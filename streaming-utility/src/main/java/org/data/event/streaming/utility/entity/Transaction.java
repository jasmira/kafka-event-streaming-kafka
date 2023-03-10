/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.data.event.streaming.utility.entity;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Transaction extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 595341386949711921L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Transaction\",\"namespace\":\"org.data.event.streaming.utility.entity\",\"fields\":[{\"name\":\"transactionID\",\"type\":\"long\"},{\"name\":\"accountNumber\",\"type\":\"string\"},{\"name\":\"creationTime\",\"type\":\"string\"},{\"name\":\"processingTime\",\"type\":[\"string\",\"null\"]},{\"name\":\"persistenceTime\",\"type\":[\"string\",\"null\"]},{\"name\":\"amount\",\"type\":\"long\"},{\"name\":\"operationType\",\"type\":{\"type\":\"enum\",\"name\":\"OperationType\",\"symbols\":[\"CREDIT\",\"DEBIT\"]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Transaction> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Transaction> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Transaction> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Transaction> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Transaction> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Transaction to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Transaction from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Transaction instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Transaction fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private long transactionID;
  private java.lang.CharSequence accountNumber;
  private java.lang.CharSequence creationTime;
  private java.lang.CharSequence processingTime;
  private java.lang.CharSequence persistenceTime;
  private long amount;
  private org.data.event.streaming.utility.entity.OperationType operationType;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Transaction() {}

  /**
   * All-args constructor.
   * @param transactionID The new value for transactionID
   * @param accountNumber The new value for accountNumber
   * @param creationTime The new value for creationTime
   * @param processingTime The new value for processingTime
   * @param persistenceTime The new value for persistenceTime
   * @param amount The new value for amount
   * @param operationType The new value for operationType
   */
  public Transaction(java.lang.Long transactionID, java.lang.CharSequence accountNumber, java.lang.CharSequence creationTime, java.lang.CharSequence processingTime, java.lang.CharSequence persistenceTime, java.lang.Long amount, org.data.event.streaming.utility.entity.OperationType operationType) {
    this.transactionID = transactionID;
    this.accountNumber = accountNumber;
    this.creationTime = creationTime;
    this.processingTime = processingTime;
    this.persistenceTime = persistenceTime;
    this.amount = amount;
    this.operationType = operationType;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return transactionID;
    case 1: return accountNumber;
    case 2: return creationTime;
    case 3: return processingTime;
    case 4: return persistenceTime;
    case 5: return amount;
    case 6: return operationType;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: transactionID = (java.lang.Long)value$; break;
    case 1: accountNumber = (java.lang.CharSequence)value$; break;
    case 2: creationTime = (java.lang.CharSequence)value$; break;
    case 3: processingTime = (java.lang.CharSequence)value$; break;
    case 4: persistenceTime = (java.lang.CharSequence)value$; break;
    case 5: amount = (java.lang.Long)value$; break;
    case 6: operationType = (org.data.event.streaming.utility.entity.OperationType)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'transactionID' field.
   * @return The value of the 'transactionID' field.
   */
  public long getTransactionID() {
    return transactionID;
  }


  /**
   * Sets the value of the 'transactionID' field.
   * @param value the value to set.
   */
  public void setTransactionID(long value) {
    this.transactionID = value;
  }

  /**
   * Gets the value of the 'accountNumber' field.
   * @return The value of the 'accountNumber' field.
   */
  public java.lang.CharSequence getAccountNumber() {
    return accountNumber;
  }


  /**
   * Sets the value of the 'accountNumber' field.
   * @param value the value to set.
   */
  public void setAccountNumber(java.lang.CharSequence value) {
    this.accountNumber = value;
  }

  /**
   * Gets the value of the 'creationTime' field.
   * @return The value of the 'creationTime' field.
   */
  public java.lang.CharSequence getCreationTime() {
    return creationTime;
  }


  /**
   * Sets the value of the 'creationTime' field.
   * @param value the value to set.
   */
  public void setCreationTime(java.lang.CharSequence value) {
    this.creationTime = value;
  }

  /**
   * Gets the value of the 'processingTime' field.
   * @return The value of the 'processingTime' field.
   */
  public java.lang.CharSequence getProcessingTime() {
    return processingTime;
  }


  /**
   * Sets the value of the 'processingTime' field.
   * @param value the value to set.
   */
  public void setProcessingTime(java.lang.CharSequence value) {
    this.processingTime = value;
  }

  /**
   * Gets the value of the 'persistenceTime' field.
   * @return The value of the 'persistenceTime' field.
   */
  public java.lang.CharSequence getPersistenceTime() {
    return persistenceTime;
  }


  /**
   * Sets the value of the 'persistenceTime' field.
   * @param value the value to set.
   */
  public void setPersistenceTime(java.lang.CharSequence value) {
    this.persistenceTime = value;
  }

  /**
   * Gets the value of the 'amount' field.
   * @return The value of the 'amount' field.
   */
  public long getAmount() {
    return amount;
  }


  /**
   * Sets the value of the 'amount' field.
   * @param value the value to set.
   */
  public void setAmount(long value) {
    this.amount = value;
  }

  /**
   * Gets the value of the 'operationType' field.
   * @return The value of the 'operationType' field.
   */
  public org.data.event.streaming.utility.entity.OperationType getOperationType() {
    return operationType;
  }


  /**
   * Sets the value of the 'operationType' field.
   * @param value the value to set.
   */
  public void setOperationType(org.data.event.streaming.utility.entity.OperationType value) {
    this.operationType = value;
  }

  /**
   * Creates a new Transaction RecordBuilder.
   * @return A new Transaction RecordBuilder
   */
  public static org.data.event.streaming.utility.entity.Transaction.Builder newBuilder() {
    return new org.data.event.streaming.utility.entity.Transaction.Builder();
  }

  /**
   * Creates a new Transaction RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Transaction RecordBuilder
   */
  public static org.data.event.streaming.utility.entity.Transaction.Builder newBuilder(org.data.event.streaming.utility.entity.Transaction.Builder other) {
    if (other == null) {
      return new org.data.event.streaming.utility.entity.Transaction.Builder();
    } else {
      return new org.data.event.streaming.utility.entity.Transaction.Builder(other);
    }
  }

  /**
   * Creates a new Transaction RecordBuilder by copying an existing Transaction instance.
   * @param other The existing instance to copy.
   * @return A new Transaction RecordBuilder
   */
  public static org.data.event.streaming.utility.entity.Transaction.Builder newBuilder(org.data.event.streaming.utility.entity.Transaction other) {
    if (other == null) {
      return new org.data.event.streaming.utility.entity.Transaction.Builder();
    } else {
      return new org.data.event.streaming.utility.entity.Transaction.Builder(other);
    }
  }

  /**
   * RecordBuilder for Transaction instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Transaction>
    implements org.apache.avro.data.RecordBuilder<Transaction> {

    private long transactionID;
    private java.lang.CharSequence accountNumber;
    private java.lang.CharSequence creationTime;
    private java.lang.CharSequence processingTime;
    private java.lang.CharSequence persistenceTime;
    private long amount;
    private org.data.event.streaming.utility.entity.OperationType operationType;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.data.event.streaming.utility.entity.Transaction.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.transactionID)) {
        this.transactionID = data().deepCopy(fields()[0].schema(), other.transactionID);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.accountNumber)) {
        this.accountNumber = data().deepCopy(fields()[1].schema(), other.accountNumber);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.creationTime)) {
        this.creationTime = data().deepCopy(fields()[2].schema(), other.creationTime);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.processingTime)) {
        this.processingTime = data().deepCopy(fields()[3].schema(), other.processingTime);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.persistenceTime)) {
        this.persistenceTime = data().deepCopy(fields()[4].schema(), other.persistenceTime);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.amount)) {
        this.amount = data().deepCopy(fields()[5].schema(), other.amount);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.operationType)) {
        this.operationType = data().deepCopy(fields()[6].schema(), other.operationType);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
    }

    /**
     * Creates a Builder by copying an existing Transaction instance
     * @param other The existing instance to copy.
     */
    private Builder(org.data.event.streaming.utility.entity.Transaction other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.transactionID)) {
        this.transactionID = data().deepCopy(fields()[0].schema(), other.transactionID);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.accountNumber)) {
        this.accountNumber = data().deepCopy(fields()[1].schema(), other.accountNumber);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.creationTime)) {
        this.creationTime = data().deepCopy(fields()[2].schema(), other.creationTime);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.processingTime)) {
        this.processingTime = data().deepCopy(fields()[3].schema(), other.processingTime);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.persistenceTime)) {
        this.persistenceTime = data().deepCopy(fields()[4].schema(), other.persistenceTime);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.amount)) {
        this.amount = data().deepCopy(fields()[5].schema(), other.amount);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.operationType)) {
        this.operationType = data().deepCopy(fields()[6].schema(), other.operationType);
        fieldSetFlags()[6] = true;
      }
    }

    /**
      * Gets the value of the 'transactionID' field.
      * @return The value.
      */
    public long getTransactionID() {
      return transactionID;
    }


    /**
      * Sets the value of the 'transactionID' field.
      * @param value The value of 'transactionID'.
      * @return This builder.
      */
    public org.data.event.streaming.utility.entity.Transaction.Builder setTransactionID(long value) {
      validate(fields()[0], value);
      this.transactionID = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'transactionID' field has been set.
      * @return True if the 'transactionID' field has been set, false otherwise.
      */
    public boolean hasTransactionID() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'transactionID' field.
      * @return This builder.
      */
    public org.data.event.streaming.utility.entity.Transaction.Builder clearTransactionID() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'accountNumber' field.
      * @return The value.
      */
    public java.lang.CharSequence getAccountNumber() {
      return accountNumber;
    }


    /**
      * Sets the value of the 'accountNumber' field.
      * @param value The value of 'accountNumber'.
      * @return This builder.
      */
    public org.data.event.streaming.utility.entity.Transaction.Builder setAccountNumber(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.accountNumber = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'accountNumber' field has been set.
      * @return True if the 'accountNumber' field has been set, false otherwise.
      */
    public boolean hasAccountNumber() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'accountNumber' field.
      * @return This builder.
      */
    public org.data.event.streaming.utility.entity.Transaction.Builder clearAccountNumber() {
      accountNumber = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'creationTime' field.
      * @return The value.
      */
    public java.lang.CharSequence getCreationTime() {
      return creationTime;
    }


    /**
      * Sets the value of the 'creationTime' field.
      * @param value The value of 'creationTime'.
      * @return This builder.
      */
    public org.data.event.streaming.utility.entity.Transaction.Builder setCreationTime(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.creationTime = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'creationTime' field has been set.
      * @return True if the 'creationTime' field has been set, false otherwise.
      */
    public boolean hasCreationTime() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'creationTime' field.
      * @return This builder.
      */
    public org.data.event.streaming.utility.entity.Transaction.Builder clearCreationTime() {
      creationTime = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'processingTime' field.
      * @return The value.
      */
    public java.lang.CharSequence getProcessingTime() {
      return processingTime;
    }


    /**
      * Sets the value of the 'processingTime' field.
      * @param value The value of 'processingTime'.
      * @return This builder.
      */
    public org.data.event.streaming.utility.entity.Transaction.Builder setProcessingTime(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.processingTime = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'processingTime' field has been set.
      * @return True if the 'processingTime' field has been set, false otherwise.
      */
    public boolean hasProcessingTime() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'processingTime' field.
      * @return This builder.
      */
    public org.data.event.streaming.utility.entity.Transaction.Builder clearProcessingTime() {
      processingTime = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'persistenceTime' field.
      * @return The value.
      */
    public java.lang.CharSequence getPersistenceTime() {
      return persistenceTime;
    }


    /**
      * Sets the value of the 'persistenceTime' field.
      * @param value The value of 'persistenceTime'.
      * @return This builder.
      */
    public org.data.event.streaming.utility.entity.Transaction.Builder setPersistenceTime(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.persistenceTime = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'persistenceTime' field has been set.
      * @return True if the 'persistenceTime' field has been set, false otherwise.
      */
    public boolean hasPersistenceTime() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'persistenceTime' field.
      * @return This builder.
      */
    public org.data.event.streaming.utility.entity.Transaction.Builder clearPersistenceTime() {
      persistenceTime = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'amount' field.
      * @return The value.
      */
    public long getAmount() {
      return amount;
    }


    /**
      * Sets the value of the 'amount' field.
      * @param value The value of 'amount'.
      * @return This builder.
      */
    public org.data.event.streaming.utility.entity.Transaction.Builder setAmount(long value) {
      validate(fields()[5], value);
      this.amount = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'amount' field has been set.
      * @return True if the 'amount' field has been set, false otherwise.
      */
    public boolean hasAmount() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'amount' field.
      * @return This builder.
      */
    public org.data.event.streaming.utility.entity.Transaction.Builder clearAmount() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'operationType' field.
      * @return The value.
      */
    public org.data.event.streaming.utility.entity.OperationType getOperationType() {
      return operationType;
    }


    /**
      * Sets the value of the 'operationType' field.
      * @param value The value of 'operationType'.
      * @return This builder.
      */
    public org.data.event.streaming.utility.entity.Transaction.Builder setOperationType(org.data.event.streaming.utility.entity.OperationType value) {
      validate(fields()[6], value);
      this.operationType = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'operationType' field has been set.
      * @return True if the 'operationType' field has been set, false otherwise.
      */
    public boolean hasOperationType() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'operationType' field.
      * @return This builder.
      */
    public org.data.event.streaming.utility.entity.Transaction.Builder clearOperationType() {
      operationType = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Transaction build() {
      try {
        Transaction record = new Transaction();
        record.transactionID = fieldSetFlags()[0] ? this.transactionID : (java.lang.Long) defaultValue(fields()[0]);
        record.accountNumber = fieldSetFlags()[1] ? this.accountNumber : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.creationTime = fieldSetFlags()[2] ? this.creationTime : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.processingTime = fieldSetFlags()[3] ? this.processingTime : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.persistenceTime = fieldSetFlags()[4] ? this.persistenceTime : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.amount = fieldSetFlags()[5] ? this.amount : (java.lang.Long) defaultValue(fields()[5]);
        record.operationType = fieldSetFlags()[6] ? this.operationType : (org.data.event.streaming.utility.entity.OperationType) defaultValue(fields()[6]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Transaction>
    WRITER$ = (org.apache.avro.io.DatumWriter<Transaction>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Transaction>
    READER$ = (org.apache.avro.io.DatumReader<Transaction>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeLong(this.transactionID);

    out.writeString(this.accountNumber);

    out.writeString(this.creationTime);

    if (this.processingTime == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      out.writeString(this.processingTime);
    }

    if (this.persistenceTime == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      out.writeString(this.persistenceTime);
    }

    out.writeLong(this.amount);

    out.writeEnum(this.operationType.ordinal());

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.transactionID = in.readLong();

      this.accountNumber = in.readString(this.accountNumber instanceof Utf8 ? (Utf8)this.accountNumber : null);

      this.creationTime = in.readString(this.creationTime instanceof Utf8 ? (Utf8)this.creationTime : null);

      if (in.readIndex() != 0) {
        in.readNull();
        this.processingTime = null;
      } else {
        this.processingTime = in.readString(this.processingTime instanceof Utf8 ? (Utf8)this.processingTime : null);
      }

      if (in.readIndex() != 0) {
        in.readNull();
        this.persistenceTime = null;
      } else {
        this.persistenceTime = in.readString(this.persistenceTime instanceof Utf8 ? (Utf8)this.persistenceTime : null);
      }

      this.amount = in.readLong();

      this.operationType = org.data.event.streaming.utility.entity.OperationType.values()[in.readEnum()];

    } else {
      for (int i = 0; i < 7; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.transactionID = in.readLong();
          break;

        case 1:
          this.accountNumber = in.readString(this.accountNumber instanceof Utf8 ? (Utf8)this.accountNumber : null);
          break;

        case 2:
          this.creationTime = in.readString(this.creationTime instanceof Utf8 ? (Utf8)this.creationTime : null);
          break;

        case 3:
          if (in.readIndex() != 0) {
            in.readNull();
            this.processingTime = null;
          } else {
            this.processingTime = in.readString(this.processingTime instanceof Utf8 ? (Utf8)this.processingTime : null);
          }
          break;

        case 4:
          if (in.readIndex() != 0) {
            in.readNull();
            this.persistenceTime = null;
          } else {
            this.persistenceTime = in.readString(this.persistenceTime instanceof Utf8 ? (Utf8)this.persistenceTime : null);
          }
          break;

        case 5:
          this.amount = in.readLong();
          break;

        case 6:
          this.operationType = org.data.event.streaming.utility.entity.OperationType.values()[in.readEnum()];
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










