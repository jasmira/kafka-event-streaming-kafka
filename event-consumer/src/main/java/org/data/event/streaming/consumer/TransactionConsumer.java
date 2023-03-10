package org.data.event.streaming.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.data.event.streaming.consumer.deserialiser.TransactionDeserializer;
import org.data.event.streaming.utility.entity.Transaction;
import org.data.event.streaming.utility.util.KafkaConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

@Component
//@ConditionalOnProperty(prefix = "enable", name="consumer", havingValue = "true")
public class TransactionConsumer {

    public static void main(String[] args) {
        final Logger log = LoggerFactory.getLogger(TransactionConsumer.class);

        // create Consumer properties
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.BOOTSTRAP_SERVERS);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, TransactionDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstants.GROUP_ID);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        // create consumer
        KafkaConsumer<String, Transaction> kafkaConsumer = new KafkaConsumer<>(properties);

        // subscribe consumer to our topic(s)
        kafkaConsumer.subscribe(Arrays.asList(KafkaConstants.TOPIC));

        // poll for new data
        while(true){
            ConsumerRecords<String, Transaction> records =
                    kafkaConsumer.poll(Duration.ofMillis(100));

            for (ConsumerRecord<String, Transaction> record : records){
                log.info("Key: " + record.key() + ", Value: " + record.value());
            }
        }
    }
}