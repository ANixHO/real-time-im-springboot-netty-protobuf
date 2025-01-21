// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: message.proto
// Protobuf Java Version: 4.27.3

package org.learn.realtimeim.protocol.message;

/**
 * Protobuf type {@code org.learn.realtimeim.Message}
 */
public final class Message extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:org.learn.realtimeim.Message)
    MessageOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 3,
      /* suffix= */ "",
      Message.class.getName());
  }
  // Use Message.newBuilder() to construct.
  private Message(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private Message() {
    type_ = 0;
    senderId_ = "";
    chatId_ = "";
    content_ = "";
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.learn.realtimeim.protocol.message.MessageBase.internal_static_org_learn_realtimeim_Message_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.learn.realtimeim.protocol.message.MessageBase.internal_static_org_learn_realtimeim_Message_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.learn.realtimeim.protocol.message.Message.class, org.learn.realtimeim.protocol.message.Message.Builder.class);
  }

  /**
   * Protobuf enum {@code org.learn.realtimeim.Message.ContentType}
   */
  public enum ContentType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>NORMAL = 0;</code>
     */
    NORMAL(0),
    /**
     * <code>PING_SIGNAL = 1;</code>
     */
    PING_SIGNAL(1),
    /**
     * <code>PONG_SIGNAL = 2;</code>
     */
    PONG_SIGNAL(2),
    /**
     * <code>PRIVATE_CHAT = 3;</code>
     */
    PRIVATE_CHAT(3),
    /**
     * <code>GROUP_CHAT = 4;</code>
     */
    GROUP_CHAT(4),
    UNRECOGNIZED(-1),
    ;

    static {
      com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
        com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
        /* major= */ 4,
        /* minor= */ 27,
        /* patch= */ 3,
        /* suffix= */ "",
        ContentType.class.getName());
    }
    /**
     * <code>NORMAL = 0;</code>
     */
    public static final int NORMAL_VALUE = 0;
    /**
     * <code>PING_SIGNAL = 1;</code>
     */
    public static final int PING_SIGNAL_VALUE = 1;
    /**
     * <code>PONG_SIGNAL = 2;</code>
     */
    public static final int PONG_SIGNAL_VALUE = 2;
    /**
     * <code>PRIVATE_CHAT = 3;</code>
     */
    public static final int PRIVATE_CHAT_VALUE = 3;
    /**
     * <code>GROUP_CHAT = 4;</code>
     */
    public static final int GROUP_CHAT_VALUE = 4;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static ContentType valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static ContentType forNumber(int value) {
      switch (value) {
        case 0: return NORMAL;
        case 1: return PING_SIGNAL;
        case 2: return PONG_SIGNAL;
        case 3: return PRIVATE_CHAT;
        case 4: return GROUP_CHAT;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<ContentType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        ContentType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<ContentType>() {
            public ContentType findValueByNumber(int number) {
              return ContentType.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalStateException(
            "Can't get the descriptor of an unrecognized enum value.");
      }
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return org.learn.realtimeim.protocol.message.Message.getDescriptor().getEnumTypes().get(0);
    }

    private static final ContentType[] VALUES = values();

    public static ContentType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private ContentType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:org.learn.realtimeim.Message.ContentType)
  }

  public static final int TYPE_FIELD_NUMBER = 1;
  private int type_ = 0;
  /**
   * <code>.org.learn.realtimeim.Message.ContentType type = 1;</code>
   * @return The enum numeric value on the wire for type.
   */
  @java.lang.Override public int getTypeValue() {
    return type_;
  }
  /**
   * <code>.org.learn.realtimeim.Message.ContentType type = 1;</code>
   * @return The type.
   */
  @java.lang.Override public org.learn.realtimeim.protocol.message.Message.ContentType getType() {
    org.learn.realtimeim.protocol.message.Message.ContentType result = org.learn.realtimeim.protocol.message.Message.ContentType.forNumber(type_);
    return result == null ? org.learn.realtimeim.protocol.message.Message.ContentType.UNRECOGNIZED : result;
  }

  public static final int SENDERID_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object senderId_ = "";
  /**
   * <code>string senderId = 2;</code>
   * @return The senderId.
   */
  @java.lang.Override
  public java.lang.String getSenderId() {
    java.lang.Object ref = senderId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      senderId_ = s;
      return s;
    }
  }
  /**
   * <code>string senderId = 2;</code>
   * @return The bytes for senderId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getSenderIdBytes() {
    java.lang.Object ref = senderId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      senderId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CHATID_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object chatId_ = "";
  /**
   * <code>string chatId = 3;</code>
   * @return The chatId.
   */
  @java.lang.Override
  public java.lang.String getChatId() {
    java.lang.Object ref = chatId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      chatId_ = s;
      return s;
    }
  }
  /**
   * <code>string chatId = 3;</code>
   * @return The bytes for chatId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getChatIdBytes() {
    java.lang.Object ref = chatId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      chatId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CONTENT_FIELD_NUMBER = 4;
  @SuppressWarnings("serial")
  private volatile java.lang.Object content_ = "";
  /**
   * <code>string content = 4;</code>
   * @return The content.
   */
  @java.lang.Override
  public java.lang.String getContent() {
    java.lang.Object ref = content_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      content_ = s;
      return s;
    }
  }
  /**
   * <code>string content = 4;</code>
   * @return The bytes for content.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getContentBytes() {
    java.lang.Object ref = content_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      content_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (type_ != org.learn.realtimeim.protocol.message.Message.ContentType.NORMAL.getNumber()) {
      output.writeEnum(1, type_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(senderId_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 2, senderId_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(chatId_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 3, chatId_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(content_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 4, content_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (type_ != org.learn.realtimeim.protocol.message.Message.ContentType.NORMAL.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, type_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(senderId_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(2, senderId_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(chatId_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(3, chatId_);
    }
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(content_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(4, content_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.learn.realtimeim.protocol.message.Message)) {
      return super.equals(obj);
    }
    org.learn.realtimeim.protocol.message.Message other = (org.learn.realtimeim.protocol.message.Message) obj;

    if (type_ != other.type_) return false;
    if (!getSenderId()
        .equals(other.getSenderId())) return false;
    if (!getChatId()
        .equals(other.getChatId())) return false;
    if (!getContent()
        .equals(other.getContent())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + type_;
    hash = (37 * hash) + SENDERID_FIELD_NUMBER;
    hash = (53 * hash) + getSenderId().hashCode();
    hash = (37 * hash) + CHATID_FIELD_NUMBER;
    hash = (53 * hash) + getChatId().hashCode();
    hash = (37 * hash) + CONTENT_FIELD_NUMBER;
    hash = (53 * hash) + getContent().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.learn.realtimeim.protocol.message.Message parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.learn.realtimeim.protocol.message.Message parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.learn.realtimeim.protocol.message.Message parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.learn.realtimeim.protocol.message.Message parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.learn.realtimeim.protocol.message.Message parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.learn.realtimeim.protocol.message.Message parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.learn.realtimeim.protocol.message.Message parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static org.learn.realtimeim.protocol.message.Message parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static org.learn.realtimeim.protocol.message.Message parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static org.learn.realtimeim.protocol.message.Message parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.learn.realtimeim.protocol.message.Message parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static org.learn.realtimeim.protocol.message.Message parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.learn.realtimeim.protocol.message.Message prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code org.learn.realtimeim.Message}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:org.learn.realtimeim.Message)
      org.learn.realtimeim.protocol.message.MessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.learn.realtimeim.protocol.message.MessageBase.internal_static_org_learn_realtimeim_Message_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.learn.realtimeim.protocol.message.MessageBase.internal_static_org_learn_realtimeim_Message_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.learn.realtimeim.protocol.message.Message.class, org.learn.realtimeim.protocol.message.Message.Builder.class);
    }

    // Construct using org.learn.realtimeim.protocol.message.Message.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      type_ = 0;
      senderId_ = "";
      chatId_ = "";
      content_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.learn.realtimeim.protocol.message.MessageBase.internal_static_org_learn_realtimeim_Message_descriptor;
    }

    @java.lang.Override
    public org.learn.realtimeim.protocol.message.Message getDefaultInstanceForType() {
      return org.learn.realtimeim.protocol.message.Message.getDefaultInstance();
    }

    @java.lang.Override
    public org.learn.realtimeim.protocol.message.Message build() {
      org.learn.realtimeim.protocol.message.Message result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.learn.realtimeim.protocol.message.Message buildPartial() {
      org.learn.realtimeim.protocol.message.Message result = new org.learn.realtimeim.protocol.message.Message(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(org.learn.realtimeim.protocol.message.Message result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.type_ = type_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.senderId_ = senderId_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.chatId_ = chatId_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.content_ = content_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.learn.realtimeim.protocol.message.Message) {
        return mergeFrom((org.learn.realtimeim.protocol.message.Message)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.learn.realtimeim.protocol.message.Message other) {
      if (other == org.learn.realtimeim.protocol.message.Message.getDefaultInstance()) return this;
      if (other.type_ != 0) {
        setTypeValue(other.getTypeValue());
      }
      if (!other.getSenderId().isEmpty()) {
        senderId_ = other.senderId_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (!other.getChatId().isEmpty()) {
        chatId_ = other.chatId_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      if (!other.getContent().isEmpty()) {
        content_ = other.content_;
        bitField0_ |= 0x00000008;
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              type_ = input.readEnum();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 18: {
              senderId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              chatId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 34: {
              content_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000008;
              break;
            } // case 34
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private int type_ = 0;
    /**
     * <code>.org.learn.realtimeim.Message.ContentType type = 1;</code>
     * @return The enum numeric value on the wire for type.
     */
    @java.lang.Override public int getTypeValue() {
      return type_;
    }
    /**
     * <code>.org.learn.realtimeim.Message.ContentType type = 1;</code>
     * @param value The enum numeric value on the wire for type to set.
     * @return This builder for chaining.
     */
    public Builder setTypeValue(int value) {
      type_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.org.learn.realtimeim.Message.ContentType type = 1;</code>
     * @return The type.
     */
    @java.lang.Override
    public org.learn.realtimeim.protocol.message.Message.ContentType getType() {
      org.learn.realtimeim.protocol.message.Message.ContentType result = org.learn.realtimeim.protocol.message.Message.ContentType.forNumber(type_);
      return result == null ? org.learn.realtimeim.protocol.message.Message.ContentType.UNRECOGNIZED : result;
    }
    /**
     * <code>.org.learn.realtimeim.Message.ContentType type = 1;</code>
     * @param value The type to set.
     * @return This builder for chaining.
     */
    public Builder setType(org.learn.realtimeim.protocol.message.Message.ContentType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      type_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.org.learn.realtimeim.Message.ContentType type = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearType() {
      bitField0_ = (bitField0_ & ~0x00000001);
      type_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object senderId_ = "";
    /**
     * <code>string senderId = 2;</code>
     * @return The senderId.
     */
    public java.lang.String getSenderId() {
      java.lang.Object ref = senderId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        senderId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string senderId = 2;</code>
     * @return The bytes for senderId.
     */
    public com.google.protobuf.ByteString
        getSenderIdBytes() {
      java.lang.Object ref = senderId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        senderId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string senderId = 2;</code>
     * @param value The senderId to set.
     * @return This builder for chaining.
     */
    public Builder setSenderId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      senderId_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string senderId = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearSenderId() {
      senderId_ = getDefaultInstance().getSenderId();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string senderId = 2;</code>
     * @param value The bytes for senderId to set.
     * @return This builder for chaining.
     */
    public Builder setSenderIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      senderId_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private java.lang.Object chatId_ = "";
    /**
     * <code>string chatId = 3;</code>
     * @return The chatId.
     */
    public java.lang.String getChatId() {
      java.lang.Object ref = chatId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        chatId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string chatId = 3;</code>
     * @return The bytes for chatId.
     */
    public com.google.protobuf.ByteString
        getChatIdBytes() {
      java.lang.Object ref = chatId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        chatId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string chatId = 3;</code>
     * @param value The chatId to set.
     * @return This builder for chaining.
     */
    public Builder setChatId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      chatId_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string chatId = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearChatId() {
      chatId_ = getDefaultInstance().getChatId();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string chatId = 3;</code>
     * @param value The bytes for chatId to set.
     * @return This builder for chaining.
     */
    public Builder setChatIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      chatId_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    private java.lang.Object content_ = "";
    /**
     * <code>string content = 4;</code>
     * @return The content.
     */
    public java.lang.String getContent() {
      java.lang.Object ref = content_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        content_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string content = 4;</code>
     * @return The bytes for content.
     */
    public com.google.protobuf.ByteString
        getContentBytes() {
      java.lang.Object ref = content_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        content_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string content = 4;</code>
     * @param value The content to set.
     * @return This builder for chaining.
     */
    public Builder setContent(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      content_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>string content = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearContent() {
      content_ = getDefaultInstance().getContent();
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     * <code>string content = 4;</code>
     * @param value The bytes for content to set.
     * @return This builder for chaining.
     */
    public Builder setContentBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      content_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:org.learn.realtimeim.Message)
  }

  // @@protoc_insertion_point(class_scope:org.learn.realtimeim.Message)
  private static final org.learn.realtimeim.protocol.message.Message DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.learn.realtimeim.protocol.message.Message();
  }

  public static org.learn.realtimeim.protocol.message.Message getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Message>
      PARSER = new com.google.protobuf.AbstractParser<Message>() {
    @java.lang.Override
    public Message parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<Message> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Message> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.learn.realtimeim.protocol.message.Message getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

