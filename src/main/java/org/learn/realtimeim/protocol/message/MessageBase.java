// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: message.proto
// Protobuf Java Version: 4.27.3

package org.learn.realtimeim.protocol.message;

public final class MessageBase {
  private MessageBase() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 3,
      /* suffix= */ "",
      MessageBase.class.getName());
  }
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_org_learn_realtimeim_Message_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_org_learn_realtimeim_Message_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rmessage.proto\022\024org.learn.realtimeim\"O\n" +
      "\007Message\022\021\n\tmessageId\030\001 \001(\t\022\020\n\010senderId\030" +
      "\002 \001(\t\022\016\n\006chatId\030\003 \001(\t\022\017\n\007content\030\004 \001(\tB6" +
      "\n%org.learn.realtimeim.protocol.messageB" +
      "\013MessageBaseP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_org_learn_realtimeim_Message_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_org_learn_realtimeim_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_org_learn_realtimeim_Message_descriptor,
        new java.lang.String[] { "MessageId", "SenderId", "ChatId", "Content", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
