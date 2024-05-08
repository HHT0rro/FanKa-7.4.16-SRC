package com.irisdt.client.chat;

import com.android.internal.logging.nano.MetricsProto;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class ChatProtos {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010ChatProtos.proto\u0012\u0016com.irisdt.client.chat\"Ü\u0001\n\tChatProto\u0012,\n\u0005event\u0018\u0001 \u0001(\u000e2\u001d.com.irisdt.client.chat.Event\u00124\n\tenum_type\u0018\u0002 \u0001(\u000e2!.com.irisdt.client.chat.Enum_type\u0012\u0012\n\ntarget_uid\u0018\u0003 \u0001(\t\u0012\u000b\n\u0003num\u0018\u0016 \u0001(\u0005\u0012\n\n\u0002id\u0018\u0017 \u0001(\t\u0012\u000f\n\u0007content\u0018\u0018 \u0001(\t\u0012\u000b\n\u0003url\u0018\u0019 \u0001(\t\u0012\f\n\u0004type\u0018\u001a \u0001(\t\u0012\u0012\n\nmessage_id\u0018\u001b \u0001(\t*§\u0002\n\u0005Event\u0012\u0011\n\rUNKNOWN_EVENT\u0010\u0000\u0012\u0017\n\u0013DELETE_VISIT_RECORD\u0010\u0001\u0012&\n\"CHAT_BOX_STROKE_LEFT_OR_LONG_PRESS\u0010\u0002\u0012\u0016\n\u0012CHAT_BOX_BTN_CLICK\u0010\u0003\u0012!\n\u001dCHAT_BOX_SECRET_VIEW_MSG_TIPS\u0010\u0004\u0012\u0014\n\u0010INSTANT_MSG_TIPS\u0010\u0005\u0012\u0016\n\u0012MARKET_NOTICE_SHOW\u0010\u0006\u0012\u0017\n\u0013MARKET_NOTICE_CLICK\u0010\u0007\u0012\u0016\n\u0012MESSAGE_TOPIC_SHOW\u0010\b\u0012\u0017\n\u0013MESSAGE_TOPIC_CLICK\u0010\t\u0012\u0017\n\u0013GROUP_MESSAGE_CLICK\u0010\n*C\n\tEnum_type\u0012\u0015\n\u0011UNKNOWN_ENUM_TYPE\u0010\u0000\u0012\n\n\u0006DELETE\u0010\u0001\u0012\b\n\u0004OPEN\u0010\u0002\u0012\t\n\u0005CLOSE\u0010\u0003B\u0007¢\u0002\u0004CHATb\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_com_irisdt_client_chat_ChatProto_descriptor;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_irisdt_client_chat_ChatProto_fieldAccessorTable;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class ChatProto extends GeneratedMessageV3 implements ChatProtoOrBuilder {
        public static final int CONTENT_FIELD_NUMBER = 24;
        public static final int ENUM_TYPE_FIELD_NUMBER = 2;
        public static final int EVENT_FIELD_NUMBER = 1;
        public static final int ID_FIELD_NUMBER = 23;
        public static final int MESSAGE_ID_FIELD_NUMBER = 27;
        public static final int NUM_FIELD_NUMBER = 22;
        public static final int TARGET_UID_FIELD_NUMBER = 3;
        public static final int TYPE_FIELD_NUMBER = 26;
        public static final int URL_FIELD_NUMBER = 25;
        private static final long serialVersionUID = 0;
        private volatile Object content_;
        private int enumType_;
        private int event_;
        private volatile Object id_;
        private byte memoizedIsInitialized;
        private volatile Object messageId_;
        private int num_;
        private volatile Object targetUid_;
        private volatile Object type_;
        private volatile Object url_;
        private static final ChatProto DEFAULT_INSTANCE = new ChatProto();
        private static final Parser<ChatProto> PARSER = new AbstractParser<ChatProto>() { // from class: com.irisdt.client.chat.ChatProtos.ChatProto.1
            @Override // com.google.protobuf.Parser
            public ChatProto parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ChatProto(codedInputStream, extensionRegistryLite);
            }
        };

        private ChatProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ChatProto getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ChatProtos.internal_static_com_irisdt_client_chat_ChatProto_descriptor;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static ChatProto parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ChatProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ChatProto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<ChatProto> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ChatProto)) {
                return super.equals(obj);
            }
            ChatProto chatProto = (ChatProto) obj;
            return this.event_ == chatProto.event_ && this.enumType_ == chatProto.enumType_ && getTargetUid().equals(chatProto.getTargetUid()) && getNum() == chatProto.getNum() && getId().equals(chatProto.getId()) && getContent().equals(chatProto.getContent()) && getUrl().equals(chatProto.getUrl()) && getType().equals(chatProto.getType()) && getMessageId().equals(chatProto.getMessageId()) && this.unknownFields.equals(chatProto.unknownFields);
        }

        @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
        public String getContent() {
            Object obj = this.content_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.content_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
        public ByteString getContentBytes() {
            Object obj = this.content_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.content_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
        public Enum_type getEnumType() {
            Enum_type valueOf = Enum_type.valueOf(this.enumType_);
            return valueOf == null ? Enum_type.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
        public int getEnumTypeValue() {
            return this.enumType_;
        }

        @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
        public Event getEvent() {
            Event valueOf = Event.valueOf(this.event_);
            return valueOf == null ? Event.UNRECOGNIZED : valueOf;
        }

        @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
        public int getEventValue() {
            return this.event_;
        }

        @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
        public String getId() {
            Object obj = this.id_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.id_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
        public ByteString getIdBytes() {
            Object obj = this.id_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.id_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
        public String getMessageId() {
            Object obj = this.messageId_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.messageId_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
        public ByteString getMessageIdBytes() {
            Object obj = this.messageId_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.messageId_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
        public int getNum() {
            return this.num_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChatProto> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeEnumSize = this.event_ != Event.UNKNOWN_EVENT.getNumber() ? 0 + CodedOutputStream.computeEnumSize(1, this.event_) : 0;
            if (this.enumType_ != Enum_type.UNKNOWN_ENUM_TYPE.getNumber()) {
                computeEnumSize += CodedOutputStream.computeEnumSize(2, this.enumType_);
            }
            if (!getTargetUidBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(3, this.targetUid_);
            }
            int i11 = this.num_;
            if (i11 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(22, i11);
            }
            if (!getIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(23, this.id_);
            }
            if (!getContentBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(24, this.content_);
            }
            if (!getUrlBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(25, this.url_);
            }
            if (!getTypeBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(26, this.type_);
            }
            if (!getMessageIdBytes().isEmpty()) {
                computeEnumSize += GeneratedMessageV3.computeStringSize(27, this.messageId_);
            }
            int serializedSize = computeEnumSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
        public String getTargetUid() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.targetUid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
        public ByteString getTargetUidBytes() {
            Object obj = this.targetUid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.targetUid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
        public String getType() {
            Object obj = this.type_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.type_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
        public ByteString getTypeBytes() {
            Object obj = this.type_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.url_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((((((((((((((((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + this.event_) * 37) + 2) * 53) + this.enumType_) * 37) + 3) * 53) + getTargetUid().hashCode()) * 37) + 22) * 53) + getNum()) * 37) + 23) * 53) + getId().hashCode()) * 37) + 24) * 53) + getContent().hashCode()) * 37) + 25) * 53) + getUrl().hashCode()) * 37) + 26) * 53) + getType().hashCode()) * 37) + 27) * 53) + getMessageId().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChatProtos.internal_static_com_irisdt_client_chat_ChatProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ChatProto.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
            return new ChatProto();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.event_ != Event.UNKNOWN_EVENT.getNumber()) {
                codedOutputStream.writeEnum(1, this.event_);
            }
            if (this.enumType_ != Enum_type.UNKNOWN_ENUM_TYPE.getNumber()) {
                codedOutputStream.writeEnum(2, this.enumType_);
            }
            if (!getTargetUidBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.targetUid_);
            }
            int i10 = this.num_;
            if (i10 != 0) {
                codedOutputStream.writeInt32(22, i10);
            }
            if (!getIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 23, this.id_);
            }
            if (!getContentBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 24, this.content_);
            }
            if (!getUrlBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 25, this.url_);
            }
            if (!getTypeBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 26, this.type_);
            }
            if (!getMessageIdBytes().isEmpty()) {
                GeneratedMessageV3.writeString(codedOutputStream, 27, this.messageId_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChatProtoOrBuilder {
            private Object content_;
            private int enumType_;
            private int event_;
            private Object id_;
            private Object messageId_;
            private int num_;
            private Object targetUid_;
            private Object type_;
            private Object url_;

            private Builder() {
                this.event_ = 0;
                this.enumType_ = 0;
                this.targetUid_ = "";
                this.id_ = "";
                this.content_ = "";
                this.url_ = "";
                this.type_ = "";
                this.messageId_ = "";
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ChatProtos.internal_static_com_irisdt_client_chat_ChatProto_descriptor;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearContent() {
                this.content_ = ChatProto.getDefaultInstance().getContent();
                onChanged();
                return this;
            }

            public Builder clearEnumType() {
                this.enumType_ = 0;
                onChanged();
                return this;
            }

            public Builder clearEvent() {
                this.event_ = 0;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = ChatProto.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public Builder clearMessageId() {
                this.messageId_ = ChatProto.getDefaultInstance().getMessageId();
                onChanged();
                return this;
            }

            public Builder clearNum() {
                this.num_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTargetUid() {
                this.targetUid_ = ChatProto.getDefaultInstance().getTargetUid();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = ChatProto.getDefaultInstance().getType();
                onChanged();
                return this;
            }

            public Builder clearUrl() {
                this.url_ = ChatProto.getDefaultInstance().getUrl();
                onChanged();
                return this;
            }

            @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
            public String getContent() {
                Object obj = this.content_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.content_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
            public ByteString getContentBytes() {
                Object obj = this.content_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.content_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChatProtos.internal_static_com_irisdt_client_chat_ChatProto_descriptor;
            }

            @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
            public Enum_type getEnumType() {
                Enum_type valueOf = Enum_type.valueOf(this.enumType_);
                return valueOf == null ? Enum_type.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
            public int getEnumTypeValue() {
                return this.enumType_;
            }

            @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
            public Event getEvent() {
                Event valueOf = Event.valueOf(this.event_);
                return valueOf == null ? Event.UNRECOGNIZED : valueOf;
            }

            @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
            public int getEventValue() {
                return this.event_;
            }

            @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
            public String getId() {
                Object obj = this.id_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.id_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
            public ByteString getIdBytes() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.id_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
            public String getMessageId() {
                Object obj = this.messageId_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.messageId_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
            public ByteString getMessageIdBytes() {
                Object obj = this.messageId_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.messageId_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
            public int getNum() {
                return this.num_;
            }

            @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
            public String getTargetUid() {
                Object obj = this.targetUid_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.targetUid_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
            public ByteString getTargetUidBytes() {
                Object obj = this.targetUid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.targetUid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
            public String getType() {
                Object obj = this.type_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.type_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
            public ByteString getTypeBytes() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.type_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
            public String getUrl() {
                Object obj = this.url_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.url_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.irisdt.client.chat.ChatProtos.ChatProtoOrBuilder
            public ByteString getUrlBytes() {
                Object obj = this.url_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.url_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChatProtos.internal_static_com_irisdt_client_chat_ChatProto_fieldAccessorTable.ensureFieldAccessorsInitialized(ChatProto.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setContent(String str) {
                Objects.requireNonNull(str);
                this.content_ = str;
                onChanged();
                return this;
            }

            public Builder setContentBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.content_ = byteString;
                onChanged();
                return this;
            }

            public Builder setEnumType(Enum_type enum_type) {
                Objects.requireNonNull(enum_type);
                this.enumType_ = enum_type.getNumber();
                onChanged();
                return this;
            }

            public Builder setEnumTypeValue(int i10) {
                this.enumType_ = i10;
                onChanged();
                return this;
            }

            public Builder setEvent(Event event) {
                Objects.requireNonNull(event);
                this.event_ = event.getNumber();
                onChanged();
                return this;
            }

            public Builder setEventValue(int i10) {
                this.event_ = i10;
                onChanged();
                return this;
            }

            public Builder setId(String str) {
                Objects.requireNonNull(str);
                this.id_ = str;
                onChanged();
                return this;
            }

            public Builder setIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.id_ = byteString;
                onChanged();
                return this;
            }

            public Builder setMessageId(String str) {
                Objects.requireNonNull(str);
                this.messageId_ = str;
                onChanged();
                return this;
            }

            public Builder setMessageIdBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.messageId_ = byteString;
                onChanged();
                return this;
            }

            public Builder setNum(int i10) {
                this.num_ = i10;
                onChanged();
                return this;
            }

            public Builder setTargetUid(String str) {
                Objects.requireNonNull(str);
                this.targetUid_ = str;
                onChanged();
                return this;
            }

            public Builder setTargetUidBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.targetUid_ = byteString;
                onChanged();
                return this;
            }

            public Builder setType(String str) {
                Objects.requireNonNull(str);
                this.type_ = str;
                onChanged();
                return this;
            }

            public Builder setTypeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.type_ = byteString;
                onChanged();
                return this;
            }

            public Builder setUrl(String str) {
                Objects.requireNonNull(str);
                this.url_ = str;
                onChanged();
                return this;
            }

            public Builder setUrlBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.url_ = byteString;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChatProto build() {
                ChatProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChatProto buildPartial() {
                ChatProto chatProto = new ChatProto(this);
                chatProto.event_ = this.event_;
                chatProto.enumType_ = this.enumType_;
                chatProto.targetUid_ = this.targetUid_;
                chatProto.num_ = this.num_;
                chatProto.id_ = this.id_;
                chatProto.content_ = this.content_;
                chatProto.url_ = this.url_;
                chatProto.type_ = this.type_;
                chatProto.messageId_ = this.messageId_;
                onBuilt();
                return chatProto;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChatProto getDefaultInstanceForType() {
                return ChatProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.setField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i10, Object obj) {
                return (Builder) super.setRepeatedField(fieldDescriptor, i10, obj);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.setUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
                return (Builder) super.clearOneof(oneofDescriptor);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.mergeUnknownFields(unknownFieldSet);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.event_ = 0;
                this.enumType_ = 0;
                this.targetUid_ = "";
                this.num_ = 0;
                this.id_ = "";
                this.content_ = "";
                this.url_ = "";
                this.type_ = "";
                this.messageId_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.m2854clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof ChatProto) {
                    return mergeFrom((ChatProto) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(ChatProto chatProto) {
                if (chatProto == ChatProto.getDefaultInstance()) {
                    return this;
                }
                if (chatProto.event_ != 0) {
                    setEventValue(chatProto.getEventValue());
                }
                if (chatProto.enumType_ != 0) {
                    setEnumTypeValue(chatProto.getEnumTypeValue());
                }
                if (!chatProto.getTargetUid().isEmpty()) {
                    this.targetUid_ = chatProto.targetUid_;
                    onChanged();
                }
                if (chatProto.getNum() != 0) {
                    setNum(chatProto.getNum());
                }
                if (!chatProto.getId().isEmpty()) {
                    this.id_ = chatProto.id_;
                    onChanged();
                }
                if (!chatProto.getContent().isEmpty()) {
                    this.content_ = chatProto.content_;
                    onChanged();
                }
                if (!chatProto.getUrl().isEmpty()) {
                    this.url_ = chatProto.url_;
                    onChanged();
                }
                if (!chatProto.getType().isEmpty()) {
                    this.type_ = chatProto.type_;
                    onChanged();
                }
                if (!chatProto.getMessageId().isEmpty()) {
                    this.messageId_ = chatProto.messageId_;
                    onChanged();
                }
                mergeUnknownFields(chatProto.unknownFields);
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.event_ = 0;
                this.enumType_ = 0;
                this.targetUid_ = "";
                this.id_ = "";
                this.content_ = "";
                this.url_ = "";
                this.type_ = "";
                this.messageId_ = "";
                maybeForceBuilderInitialization();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.irisdt.client.chat.ChatProtos.ChatProto.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.irisdt.client.chat.ChatProtos.ChatProto.t()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.irisdt.client.chat.ChatProtos$ChatProto r3 = (com.irisdt.client.chat.ChatProtos.ChatProto) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    if (r3 == 0) goto L10
                    r2.mergeFrom(r3)
                L10:
                    return r2
                L11:
                    r3 = move-exception
                    goto L21
                L13:
                    r3 = move-exception
                    com.google.protobuf.MessageLite r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L11
                    com.irisdt.client.chat.ChatProtos$ChatProto r4 = (com.irisdt.client.chat.ChatProtos.ChatProto) r4     // Catch: java.lang.Throwable -> L11
                    java.io.IOException r3 = r3.unwrapIOException()     // Catch: java.lang.Throwable -> L1f
                    throw r3     // Catch: java.lang.Throwable -> L1f
                L1f:
                    r3 = move-exception
                    r0 = r4
                L21:
                    if (r0 == 0) goto L26
                    r2.mergeFrom(r0)
                L26:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.irisdt.client.chat.ChatProtos.ChatProto.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.irisdt.client.chat.ChatProtos$ChatProto$Builder");
            }
        }

        public static Builder newBuilder(ChatProto chatProto) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(chatProto);
        }

        public static ChatProto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private ChatProto() {
            this.memoizedIsInitialized = (byte) -1;
            this.event_ = 0;
            this.enumType_ = 0;
            this.targetUid_ = "";
            this.id_ = "";
            this.content_ = "";
            this.url_ = "";
            this.type_ = "";
            this.messageId_ = "";
        }

        public static ChatProto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ChatProto) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ChatProto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChatProto getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        public static ChatProto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static ChatProto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent);
        }

        public static ChatProto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static ChatProto parseFrom(InputStream inputStream) throws IOException {
            return (ChatProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ChatProto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ChatProto) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ChatProto parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ChatProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        private ChatProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            Objects.requireNonNull(extensionRegistryLite);
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.event_ = codedInputStream.readEnum();
                                } else if (readTag == 16) {
                                    this.enumType_ = codedInputStream.readEnum();
                                } else if (readTag == 26) {
                                    this.targetUid_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 176) {
                                    this.num_ = codedInputStream.readInt32();
                                } else if (readTag == 186) {
                                    this.id_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 194) {
                                    this.content_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 202) {
                                    this.url_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 210) {
                                    this.type_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag != 218) {
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.messageId_ = codedInputStream.readStringRequireUtf8();
                                }
                            }
                            z10 = true;
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e10) {
                        throw e10.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static ChatProto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ChatProto) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface ChatProtoOrBuilder extends MessageOrBuilder {
        String getContent();

        ByteString getContentBytes();

        Enum_type getEnumType();

        int getEnumTypeValue();

        Event getEvent();

        int getEventValue();

        String getId();

        ByteString getIdBytes();

        String getMessageId();

        ByteString getMessageIdBytes();

        int getNum();

        String getTargetUid();

        ByteString getTargetUidBytes();

        String getType();

        ByteString getTypeBytes();

        String getUrl();

        ByteString getUrlBytes();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum Enum_type implements ProtocolMessageEnum {
        UNKNOWN_ENUM_TYPE(0),
        DELETE(1),
        OPEN(2),
        CLOSE(3),
        UNRECOGNIZED(-1);

        public static final int CLOSE_VALUE = 3;
        public static final int DELETE_VALUE = 1;
        public static final int OPEN_VALUE = 2;
        public static final int UNKNOWN_ENUM_TYPE_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<Enum_type> internalValueMap = new Internal.EnumLiteMap<Enum_type>() { // from class: com.irisdt.client.chat.ChatProtos.Enum_type.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Enum_type findValueByNumber(int i10) {
                return Enum_type.forNumber(i10);
            }
        };
        private static final Enum_type[] VALUES = values();

        Enum_type(int i10) {
            this.value = i10;
        }

        public static Enum_type forNumber(int i10) {
            if (i10 == 0) {
                return UNKNOWN_ENUM_TYPE;
            }
            if (i10 == 1) {
                return DELETE;
            }
            if (i10 == 2) {
                return OPEN;
            }
            if (i10 != 3) {
                return null;
            }
            return CLOSE;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return ChatProtos.getDescriptor().getEnumTypes().get(1);
        }

        public static Internal.EnumLiteMap<Enum_type> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Deprecated
        public static Enum_type valueOf(int i10) {
            return forNumber(i10);
        }

        public static Enum_type valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum Event implements ProtocolMessageEnum {
        UNKNOWN_EVENT(0),
        DELETE_VISIT_RECORD(1),
        CHAT_BOX_STROKE_LEFT_OR_LONG_PRESS(2),
        CHAT_BOX_BTN_CLICK(3),
        CHAT_BOX_SECRET_VIEW_MSG_TIPS(4),
        INSTANT_MSG_TIPS(5),
        MARKET_NOTICE_SHOW(6),
        MARKET_NOTICE_CLICK(7),
        MESSAGE_TOPIC_SHOW(8),
        MESSAGE_TOPIC_CLICK(9),
        GROUP_MESSAGE_CLICK(10),
        UNRECOGNIZED(-1);

        public static final int CHAT_BOX_BTN_CLICK_VALUE = 3;
        public static final int CHAT_BOX_SECRET_VIEW_MSG_TIPS_VALUE = 4;
        public static final int CHAT_BOX_STROKE_LEFT_OR_LONG_PRESS_VALUE = 2;
        public static final int DELETE_VISIT_RECORD_VALUE = 1;
        public static final int GROUP_MESSAGE_CLICK_VALUE = 10;
        public static final int INSTANT_MSG_TIPS_VALUE = 5;
        public static final int MARKET_NOTICE_CLICK_VALUE = 7;
        public static final int MARKET_NOTICE_SHOW_VALUE = 6;
        public static final int MESSAGE_TOPIC_CLICK_VALUE = 9;
        public static final int MESSAGE_TOPIC_SHOW_VALUE = 8;
        public static final int UNKNOWN_EVENT_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<Event> internalValueMap = new Internal.EnumLiteMap<Event>() { // from class: com.irisdt.client.chat.ChatProtos.Event.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public Event findValueByNumber(int i10) {
                return Event.forNumber(i10);
            }
        };
        private static final Event[] VALUES = values();

        Event(int i10) {
            this.value = i10;
        }

        public static Event forNumber(int i10) {
            switch (i10) {
                case 0:
                    return UNKNOWN_EVENT;
                case 1:
                    return DELETE_VISIT_RECORD;
                case 2:
                    return CHAT_BOX_STROKE_LEFT_OR_LONG_PRESS;
                case 3:
                    return CHAT_BOX_BTN_CLICK;
                case 4:
                    return CHAT_BOX_SECRET_VIEW_MSG_TIPS;
                case 5:
                    return INSTANT_MSG_TIPS;
                case 6:
                    return MARKET_NOTICE_SHOW;
                case 7:
                    return MARKET_NOTICE_CLICK;
                case 8:
                    return MESSAGE_TOPIC_SHOW;
                case 9:
                    return MESSAGE_TOPIC_CLICK;
                case 10:
                    return GROUP_MESSAGE_CLICK;
                default:
                    return null;
            }
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return ChatProtos.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<Event> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Deprecated
        public static Event valueOf(int i10) {
            return forNumber(i10);
        }

        public static Event valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    static {
        Descriptors.Descriptor descriptor2 = getDescriptor().getMessageTypes().get(0);
        internal_static_com_irisdt_client_chat_ChatProto_descriptor = descriptor2;
        internal_static_com_irisdt_client_chat_ChatProto_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(descriptor2, new String[]{com.huawei.hianalytics.core.storage.Event.TAG, "EnumType", "TargetUid", "Num", "Id", "Content", "Url", "Type", "MessageId"});
    }

    private ChatProtos() {
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
        registerAllExtensions((ExtensionRegistryLite) extensionRegistry);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
