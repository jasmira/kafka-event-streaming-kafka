/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.data.event.streaming.utility.entity;
@org.apache.avro.specific.AvroGenerated
public enum OperationType implements org.apache.avro.generic.GenericEnumSymbol<OperationType> {
  CREDIT, DEBIT  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"OperationType\",\"namespace\":\"org.data.event.streaming.utility.entity\",\"symbols\":[\"CREDIT\",\"DEBIT\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}
