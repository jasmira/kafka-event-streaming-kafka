package org.data.event.streaming.consumer.deserialiser;

import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.data.event.streaming.utility.entity.Transaction;

import java.util.Arrays;
import java.util.Map;

public class TransactionDeserializer<T extends SpecificRecordBase> implements Deserializer<T> {
    protected Class<T> targetType;

    public TransactionDeserializer() {

    }

    public TransactionDeserializer(Class<T> targetType) {
        this.targetType = targetType;
    }

    @Override
    public void close() {
        // No-op
    }

    @Override
    public void configure(Map<String, ?> arg0, boolean arg1) {
        // No-op
    }

    @SuppressWarnings("unchecked")
    @Override
    public T deserialize(String topic, byte[] data) {
        try {
            T result = null;

            if (data != null) {
                SpecificDatumReader<Transaction> datumReader =
                        new SpecificDatumReader<>(Transaction.getClassSchema());
                Decoder decoder = DecoderFactory.get().binaryDecoder(data, null);

                result = (T) datumReader.read(null, decoder);
            }
            return result;
        } catch (Exception ex) {
            throw new SerializationException(
                    "Can't deserialize data '" + Arrays.toString(data) + "' from topic '" + topic + "'", ex);
        }
    }
}