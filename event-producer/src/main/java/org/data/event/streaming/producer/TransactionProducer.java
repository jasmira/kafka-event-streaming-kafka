package org.data.event.streaming.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.data.event.streaming.producer.generator.TransactionGenerator;
import org.data.event.streaming.producer.serialiser.TransactionSerializer;
import org.data.event.streaming.utility.entity.Transaction;
import org.data.event.streaming.utility.util.KafkaConstants;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
//@ConditionalOnProperty(prefix = "enable", name="producer", havingValue = "true")
public class TransactionProducer {

    public static void main(String[] args) {

        // create Producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.BOOTSTRAP_SERVERS);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, TransactionSerializer.class.getName());
        properties.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, "9000000");
        properties.setProperty(ProducerConfig.LINGER_MS_CONFIG, "700000");
        properties.setProperty(ProducerConfig.COMPRESSION_TYPE_CONFIG, KafkaConstants.COMPRESSION_TYPE);
        properties.setProperty(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, KafkaConstants.TRUE);
        properties.setProperty(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "5");

        // create the producer
        KafkaProducer<String, Transaction> kafkaProducer = new KafkaProducer<>(properties);

        Thread[] transactionGenerators = new Thread[4];
        for (int i = 0; i < 4; i++) {
            transactionGenerators[i] = new Thread(new TransactionGenerator(kafkaProducer, 1, 250000));
            transactionGenerators[i] = new Thread(new TransactionGenerator(kafkaProducer, 250001, 500000));
            transactionGenerators[i] = new Thread(new TransactionGenerator(kafkaProducer, 500001, 750000));
            transactionGenerators[i] = new Thread(new TransactionGenerator(kafkaProducer, 750001, 1000000));
            transactionGenerators[i].start();
        }

        try {
            for (Thread t : transactionGenerators)
                t.join();
        } catch (InterruptedException e) {
        } finally {
            kafkaProducer.close();
        }
    }
}