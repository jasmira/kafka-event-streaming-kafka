package org.data.event.streaming.producer.generator;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.data.event.streaming.utility.entity.OperationType;
import org.data.event.streaming.utility.entity.Transaction;
import org.data.event.streaming.utility.util.KafkaConstants;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TransactionGenerator implements Runnable {

    private final KafkaProducer<String, Transaction> kafkaProducer;
    private int start;
    private int end;
    List<Transaction> transactionList = new ArrayList<>();

    public TransactionGenerator(KafkaProducer<String, Transaction> kafkaProducer, int start, int end){
        this.kafkaProducer = kafkaProducer;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        Long count = Long.valueOf(start);
        Format dateFormat = new SimpleDateFormat(KafkaConstants.DATE_FORMAT);

        for(int i=start; i<=end; i++) {
            Transaction transaction = new Transaction();
            transaction.setTransactionID(count);
            transaction.setAccountNumber(KafkaConstants.ACCOUNT_NUMBER);
            transaction.setCreationTime(dateFormat.format(new Date()));
            transaction.setProcessingTime("");
            transaction.setPersistenceTime("");
            transaction.setOperationType(OperationType.CREDIT);

            transactionList.add(transaction);
            count++;
        }

        for (Transaction transaction: transactionList){
            // create a producer record
            ProducerRecord<String, Transaction> producerRecord = new ProducerRecord<>(KafkaConstants.TOPIC, transaction);

            // send data - asynchronous
            kafkaProducer.send(producerRecord);
        }
    }
}