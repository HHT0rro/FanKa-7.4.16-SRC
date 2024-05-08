package com.google.rpc.context;

import com.android.internal.logging.nano.MetricsProto;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Duration;
import com.google.protobuf.DurationOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.Struct;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class AttributeContext extends GeneratedMessageV3 implements AttributeContextOrBuilder {
    public static final int API_FIELD_NUMBER = 6;
    public static final int DESTINATION_FIELD_NUMBER = 2;
    public static final int EXTENSIONS_FIELD_NUMBER = 8;
    public static final int ORIGIN_FIELD_NUMBER = 7;
    public static final int REQUEST_FIELD_NUMBER = 3;
    public static final int RESOURCE_FIELD_NUMBER = 5;
    public static final int RESPONSE_FIELD_NUMBER = 4;
    public static final int SOURCE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private Api api_;
    private Peer destination_;
    private List<Any> extensions_;
    private byte memoizedIsInitialized;
    private Peer origin_;
    private Request request_;
    private Resource resource_;
    private Response response_;
    private Peer source_;
    private static final AttributeContext DEFAULT_INSTANCE = new AttributeContext();
    private static final Parser<AttributeContext> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Api extends GeneratedMessageV3 implements ApiOrBuilder {
        public static final int OPERATION_FIELD_NUMBER = 2;
        public static final int PROTOCOL_FIELD_NUMBER = 3;
        public static final int SERVICE_FIELD_NUMBER = 1;
        public static final int VERSION_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private volatile Object operation_;
        private volatile Object protocol_;
        private volatile Object service_;
        private volatile Object version_;
        private static final Api DEFAULT_INSTANCE = new Api();
        private static final Parser<Api> PARSER = new a();

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ApiOrBuilder {
            private Object operation_;
            private Object protocol_;
            private Object service_;
            private Object version_;

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
                this(builderParent);
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return r8.a.f53307g;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearOperation() {
                this.operation_ = Api.getDefaultInstance().getOperation();
                onChanged();
                return this;
            }

            public Builder clearProtocol() {
                this.protocol_ = Api.getDefaultInstance().getProtocol();
                onChanged();
                return this;
            }

            public Builder clearService() {
                this.service_ = Api.getDefaultInstance().getService();
                onChanged();
                return this;
            }

            public Builder clearVersion() {
                this.version_ = Api.getDefaultInstance().getVersion();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return r8.a.f53307g;
            }

            @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
            public String getOperation() {
                Object obj = this.operation_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.operation_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
            public ByteString getOperationBytes() {
                Object obj = this.operation_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.operation_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
            public String getProtocol() {
                Object obj = this.protocol_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.protocol_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
            public ByteString getProtocolBytes() {
                Object obj = this.protocol_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.protocol_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
            public String getService() {
                Object obj = this.service_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.service_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
            public ByteString getServiceBytes() {
                Object obj = this.service_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.service_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
            public String getVersion() {
                Object obj = this.version_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.version_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
            public ByteString getVersionBytes() {
                Object obj = this.version_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.version_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return r8.a.f53308h.ensureFieldAccessorsInitialized(Api.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setOperation(String str) {
                Objects.requireNonNull(str);
                this.operation_ = str;
                onChanged();
                return this;
            }

            public Builder setOperationBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.operation_ = byteString;
                onChanged();
                return this;
            }

            public Builder setProtocol(String str) {
                Objects.requireNonNull(str);
                this.protocol_ = str;
                onChanged();
                return this;
            }

            public Builder setProtocolBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.protocol_ = byteString;
                onChanged();
                return this;
            }

            public Builder setService(String str) {
                Objects.requireNonNull(str);
                this.service_ = str;
                onChanged();
                return this;
            }

            public Builder setServiceBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.service_ = byteString;
                onChanged();
                return this;
            }

            public Builder setVersion(String str) {
                Objects.requireNonNull(str);
                this.version_ = str;
                onChanged();
                return this;
            }

            public Builder setVersionBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.version_ = byteString;
                onChanged();
                return this;
            }

            public /* synthetic */ Builder(a aVar) {
                this();
            }

            private Builder() {
                this.service_ = "";
                this.operation_ = "";
                this.protocol_ = "";
                this.version_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Api build() {
                Api buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Api buildPartial() {
                Api api = new Api(this, (a) null);
                api.service_ = this.service_;
                api.operation_ = this.operation_;
                api.protocol_ = this.protocol_;
                api.version_ = this.version_;
                onBuilt();
                return api;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Api getDefaultInstanceForType() {
                return Api.getDefaultInstance();
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
                this.service_ = "";
                this.operation_ = "";
                this.protocol_ = "";
                this.version_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Api) {
                    return mergeFrom((Api) message);
                }
                super.mergeFrom(message);
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.service_ = "";
                this.operation_ = "";
                this.protocol_ = "";
                this.version_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder mergeFrom(Api api) {
                if (api == Api.getDefaultInstance()) {
                    return this;
                }
                if (!api.getService().isEmpty()) {
                    this.service_ = api.service_;
                    onChanged();
                }
                if (!api.getOperation().isEmpty()) {
                    this.operation_ = api.operation_;
                    onChanged();
                }
                if (!api.getProtocol().isEmpty()) {
                    this.protocol_ = api.protocol_;
                    onChanged();
                }
                if (!api.getVersion().isEmpty()) {
                    this.version_ = api.version_;
                    onChanged();
                }
                mergeUnknownFields(api.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.google.rpc.context.AttributeContext.Api.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.google.rpc.context.AttributeContext.Api.access$2500()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.google.rpc.context.AttributeContext$Api r3 = (com.google.rpc.context.AttributeContext.Api) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.google.rpc.context.AttributeContext$Api r4 = (com.google.rpc.context.AttributeContext.Api) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.google.rpc.context.AttributeContext.Api.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.rpc.context.AttributeContext$Api$Builder");
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class a extends AbstractParser<Api> {
            @Override // com.google.protobuf.Parser
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Api parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Api(codedInputStream, extensionRegistryLite, null);
            }
        }

        public /* synthetic */ Api(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static Api getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return r8.a.f53307g;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Api parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Api) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Api parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<Api> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Api)) {
                return super.equals(obj);
            }
            Api api = (Api) obj;
            return getService().equals(api.getService()) && getOperation().equals(api.getOperation()) && getProtocol().equals(api.getProtocol()) && getVersion().equals(api.getVersion()) && this.unknownFields.equals(api.unknownFields);
        }

        @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
        public String getOperation() {
            Object obj = this.operation_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.operation_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
        public ByteString getOperationBytes() {
            Object obj = this.operation_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.operation_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Api> getParserForType() {
            return PARSER;
        }

        @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
        public String getProtocol() {
            Object obj = this.protocol_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.protocol_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
        public ByteString getProtocolBytes() {
            Object obj = this.protocol_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.protocol_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeStringSize = GeneratedMessageV3.isStringEmpty(this.service_) ? 0 : 0 + GeneratedMessageV3.computeStringSize(1, this.service_);
            if (!GeneratedMessageV3.isStringEmpty(this.operation_)) {
                computeStringSize += GeneratedMessageV3.computeStringSize(2, this.operation_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.protocol_)) {
                computeStringSize += GeneratedMessageV3.computeStringSize(3, this.protocol_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.version_)) {
                computeStringSize += GeneratedMessageV3.computeStringSize(4, this.version_);
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
        public String getService() {
            Object obj = this.service_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.service_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
        public ByteString getServiceBytes() {
            Object obj = this.service_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.service_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
        public String getVersion() {
            Object obj = this.version_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.version_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
        public ByteString getVersionBytes() {
            Object obj = this.version_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.version_ = copyFromUtf8;
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
            int hashCode = ((((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getService().hashCode()) * 37) + 2) * 53) + getOperation().hashCode()) * 37) + 3) * 53) + getProtocol().hashCode()) * 37) + 4) * 53) + getVersion().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return r8.a.f53308h.ensureFieldAccessorsInitialized(Api.class, Builder.class);
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
            return new Api();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!GeneratedMessageV3.isStringEmpty(this.service_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.service_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.operation_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.operation_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.protocol_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.protocol_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.version_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.version_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public /* synthetic */ Api(GeneratedMessageV3.Builder builder, a aVar) {
            this(builder);
        }

        public static Builder newBuilder(Api api) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(api);
        }

        public static Api parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Api) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Api parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private Api(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Api parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Api getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            a aVar = null;
            return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
        }

        public static Api parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private Api() {
            this.memoizedIsInitialized = (byte) -1;
            this.service_ = "";
            this.operation_ = "";
            this.protocol_ = "";
            this.version_ = "";
        }

        public static Api parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static Api parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Api parseFrom(InputStream inputStream) throws IOException {
            return (Api) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Api parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Api) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Api parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Api) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Api parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Api) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        private Api(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                if (readTag == 10) {
                                    this.service_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    this.operation_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 26) {
                                    this.protocol_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag != 34) {
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.version_ = codedInputStream.readStringRequireUtf8();
                                }
                            }
                            z10 = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        } catch (UninitializedMessageException e10) {
                            throw e10.asInvalidProtocolBufferException().setUnfinishedMessage(this);
                        }
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ApiOrBuilder extends MessageOrBuilder {
        String getOperation();

        ByteString getOperationBytes();

        String getProtocol();

        ByteString getProtocolBytes();

        String getService();

        ByteString getServiceBytes();

        String getVersion();

        ByteString getVersionBytes();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Auth extends GeneratedMessageV3 implements AuthOrBuilder {
        public static final int ACCESS_LEVELS_FIELD_NUMBER = 5;
        public static final int AUDIENCES_FIELD_NUMBER = 2;
        public static final int CLAIMS_FIELD_NUMBER = 4;
        private static final Auth DEFAULT_INSTANCE = new Auth();
        private static final Parser<Auth> PARSER = new a();
        public static final int PRESENTER_FIELD_NUMBER = 3;
        public static final int PRINCIPAL_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private LazyStringList accessLevels_;
        private LazyStringList audiences_;
        private Struct claims_;
        private byte memoizedIsInitialized;
        private volatile Object presenter_;
        private volatile Object principal_;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AuthOrBuilder {
            private LazyStringList accessLevels_;
            private LazyStringList audiences_;
            private int bitField0_;
            private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> claimsBuilder_;
            private Struct claims_;
            private Object presenter_;
            private Object principal_;

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
                this(builderParent);
            }

            private void ensureAccessLevelsIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.accessLevels_ = new LazyStringArrayList(this.accessLevels_);
                    this.bitField0_ |= 2;
                }
            }

            private void ensureAudiencesIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.audiences_ = new LazyStringArrayList(this.audiences_);
                    this.bitField0_ |= 1;
                }
            }

            private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getClaimsFieldBuilder() {
                if (this.claimsBuilder_ == null) {
                    this.claimsBuilder_ = new SingleFieldBuilderV3<>(getClaims(), getParentForChildren(), isClean());
                    this.claims_ = null;
                }
                return this.claimsBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return r8.a.f53309i;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder addAccessLevels(String str) {
                Objects.requireNonNull(str);
                ensureAccessLevelsIsMutable();
                this.accessLevels_.add((LazyStringList) str);
                onChanged();
                return this;
            }

            public Builder addAccessLevelsBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                ensureAccessLevelsIsMutable();
                this.accessLevels_.add(byteString);
                onChanged();
                return this;
            }

            public Builder addAllAccessLevels(Iterable<String> iterable) {
                ensureAccessLevelsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.accessLevels_);
                onChanged();
                return this;
            }

            public Builder addAllAudiences(Iterable<String> iterable) {
                ensureAudiencesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.audiences_);
                onChanged();
                return this;
            }

            public Builder addAudiences(String str) {
                Objects.requireNonNull(str);
                ensureAudiencesIsMutable();
                this.audiences_.add((LazyStringList) str);
                onChanged();
                return this;
            }

            public Builder addAudiencesBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                ensureAudiencesIsMutable();
                this.audiences_.add(byteString);
                onChanged();
                return this;
            }

            public Builder clearAccessLevels() {
                this.accessLevels_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            public Builder clearAudiences() {
                this.audiences_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearClaims() {
                if (this.claimsBuilder_ == null) {
                    this.claims_ = null;
                    onChanged();
                } else {
                    this.claims_ = null;
                    this.claimsBuilder_ = null;
                }
                return this;
            }

            public Builder clearPresenter() {
                this.presenter_ = Auth.getDefaultInstance().getPresenter();
                onChanged();
                return this;
            }

            public Builder clearPrincipal() {
                this.principal_ = Auth.getDefaultInstance().getPrincipal();
                onChanged();
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public String getAccessLevels(int i10) {
                return this.accessLevels_.get(i10);
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public ByteString getAccessLevelsBytes(int i10) {
                return this.accessLevels_.getByteString(i10);
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public int getAccessLevelsCount() {
                return this.accessLevels_.size();
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public String getAudiences(int i10) {
                return this.audiences_.get(i10);
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public ByteString getAudiencesBytes(int i10) {
                return this.audiences_.getByteString(i10);
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public int getAudiencesCount() {
                return this.audiences_.size();
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public Struct getClaims() {
                SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.claimsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Struct struct = this.claims_;
                    return struct == null ? Struct.getDefaultInstance() : struct;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Struct.Builder getClaimsBuilder() {
                onChanged();
                return getClaimsFieldBuilder().getBuilder();
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public StructOrBuilder getClaimsOrBuilder() {
                SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.claimsBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Struct struct = this.claims_;
                return struct == null ? Struct.getDefaultInstance() : struct;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return r8.a.f53309i;
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public String getPresenter() {
                Object obj = this.presenter_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.presenter_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public ByteString getPresenterBytes() {
                Object obj = this.presenter_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.presenter_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public String getPrincipal() {
                Object obj = this.principal_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.principal_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public ByteString getPrincipalBytes() {
                Object obj = this.principal_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.principal_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public boolean hasClaims() {
                return (this.claimsBuilder_ == null && this.claims_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return r8.a.f53310j.ensureFieldAccessorsInitialized(Auth.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeClaims(Struct struct) {
                SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.claimsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Struct struct2 = this.claims_;
                    if (struct2 != null) {
                        this.claims_ = Struct.newBuilder(struct2).mergeFrom(struct).buildPartial();
                    } else {
                        this.claims_ = struct;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(struct);
                }
                return this;
            }

            public Builder setAccessLevels(int i10, String str) {
                Objects.requireNonNull(str);
                ensureAccessLevelsIsMutable();
                this.accessLevels_.set(i10, (int) str);
                onChanged();
                return this;
            }

            public Builder setAudiences(int i10, String str) {
                Objects.requireNonNull(str);
                ensureAudiencesIsMutable();
                this.audiences_.set(i10, (int) str);
                onChanged();
                return this;
            }

            public Builder setClaims(Struct struct) {
                SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.claimsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Objects.requireNonNull(struct);
                    this.claims_ = struct;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(struct);
                }
                return this;
            }

            public Builder setPresenter(String str) {
                Objects.requireNonNull(str);
                this.presenter_ = str;
                onChanged();
                return this;
            }

            public Builder setPresenterBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.presenter_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPrincipal(String str) {
                Objects.requireNonNull(str);
                this.principal_ = str;
                onChanged();
                return this;
            }

            public Builder setPrincipalBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.principal_ = byteString;
                onChanged();
                return this;
            }

            public /* synthetic */ Builder(a aVar) {
                this();
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public ProtocolStringList getAccessLevelsList() {
                return this.accessLevels_.getUnmodifiableView();
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public ProtocolStringList getAudiencesList() {
                return this.audiences_.getUnmodifiableView();
            }

            private Builder() {
                this.principal_ = "";
                LazyStringList lazyStringList = LazyStringArrayList.EMPTY;
                this.audiences_ = lazyStringList;
                this.presenter_ = "";
                this.accessLevels_ = lazyStringList;
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Auth build() {
                Auth buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Auth buildPartial() {
                Auth auth = new Auth(this, (a) null);
                auth.principal_ = this.principal_;
                if ((this.bitField0_ & 1) != 0) {
                    this.audiences_ = this.audiences_.getUnmodifiableView();
                    this.bitField0_ &= -2;
                }
                auth.audiences_ = this.audiences_;
                auth.presenter_ = this.presenter_;
                SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.claimsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    auth.claims_ = this.claims_;
                } else {
                    auth.claims_ = singleFieldBuilderV3.build();
                }
                if ((this.bitField0_ & 2) != 0) {
                    this.accessLevels_ = this.accessLevels_.getUnmodifiableView();
                    this.bitField0_ &= -3;
                }
                auth.accessLevels_ = this.accessLevels_;
                onBuilt();
                return auth;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Auth getDefaultInstanceForType() {
                return Auth.getDefaultInstance();
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
                this.principal_ = "";
                LazyStringList lazyStringList = LazyStringArrayList.EMPTY;
                this.audiences_ = lazyStringList;
                int i10 = this.bitField0_ & (-2);
                this.bitField0_ = i10;
                this.presenter_ = "";
                if (this.claimsBuilder_ == null) {
                    this.claims_ = null;
                } else {
                    this.claims_ = null;
                    this.claimsBuilder_ = null;
                }
                this.accessLevels_ = lazyStringList;
                this.bitField0_ = i10 & (-3);
                return this;
            }

            public Builder setClaims(Struct.Builder builder) {
                SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.claimsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.claims_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Auth) {
                    return mergeFrom((Auth) message);
                }
                super.mergeFrom(message);
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.principal_ = "";
                LazyStringList lazyStringList = LazyStringArrayList.EMPTY;
                this.audiences_ = lazyStringList;
                this.presenter_ = "";
                this.accessLevels_ = lazyStringList;
                maybeForceBuilderInitialization();
            }

            public Builder mergeFrom(Auth auth) {
                if (auth == Auth.getDefaultInstance()) {
                    return this;
                }
                if (!auth.getPrincipal().isEmpty()) {
                    this.principal_ = auth.principal_;
                    onChanged();
                }
                if (!auth.audiences_.isEmpty()) {
                    if (this.audiences_.isEmpty()) {
                        this.audiences_ = auth.audiences_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureAudiencesIsMutable();
                        this.audiences_.addAll(auth.audiences_);
                    }
                    onChanged();
                }
                if (!auth.getPresenter().isEmpty()) {
                    this.presenter_ = auth.presenter_;
                    onChanged();
                }
                if (auth.hasClaims()) {
                    mergeClaims(auth.getClaims());
                }
                if (!auth.accessLevels_.isEmpty()) {
                    if (this.accessLevels_.isEmpty()) {
                        this.accessLevels_ = auth.accessLevels_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureAccessLevelsIsMutable();
                        this.accessLevels_.addAll(auth.accessLevels_);
                    }
                    onChanged();
                }
                mergeUnknownFields(auth.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.google.rpc.context.AttributeContext.Auth.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.google.rpc.context.AttributeContext.Auth.access$4100()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.google.rpc.context.AttributeContext$Auth r3 = (com.google.rpc.context.AttributeContext.Auth) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.google.rpc.context.AttributeContext$Auth r4 = (com.google.rpc.context.AttributeContext.Auth) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.google.rpc.context.AttributeContext.Auth.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.rpc.context.AttributeContext$Auth$Builder");
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class a extends AbstractParser<Auth> {
            @Override // com.google.protobuf.Parser
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Auth parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Auth(codedInputStream, extensionRegistryLite, null);
            }
        }

        public /* synthetic */ Auth(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static Auth getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return r8.a.f53309i;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Auth parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Auth) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Auth parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<Auth> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Auth)) {
                return super.equals(obj);
            }
            Auth auth = (Auth) obj;
            if (getPrincipal().equals(auth.getPrincipal()) && getAudiencesList().equals(auth.getAudiencesList()) && getPresenter().equals(auth.getPresenter()) && hasClaims() == auth.hasClaims()) {
                return (!hasClaims() || getClaims().equals(auth.getClaims())) && getAccessLevelsList().equals(auth.getAccessLevelsList()) && this.unknownFields.equals(auth.unknownFields);
            }
            return false;
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public String getAccessLevels(int i10) {
            return this.accessLevels_.get(i10);
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public ByteString getAccessLevelsBytes(int i10) {
            return this.accessLevels_.getByteString(i10);
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public int getAccessLevelsCount() {
            return this.accessLevels_.size();
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public String getAudiences(int i10) {
            return this.audiences_.get(i10);
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public ByteString getAudiencesBytes(int i10) {
            return this.audiences_.getByteString(i10);
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public int getAudiencesCount() {
            return this.audiences_.size();
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public Struct getClaims() {
            Struct struct = this.claims_;
            return struct == null ? Struct.getDefaultInstance() : struct;
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public StructOrBuilder getClaimsOrBuilder() {
            return getClaims();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Auth> getParserForType() {
            return PARSER;
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public String getPresenter() {
            Object obj = this.presenter_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.presenter_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public ByteString getPresenterBytes() {
            Object obj = this.presenter_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.presenter_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public String getPrincipal() {
            Object obj = this.principal_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.principal_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public ByteString getPrincipalBytes() {
            Object obj = this.principal_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.principal_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeStringSize = !GeneratedMessageV3.isStringEmpty(this.principal_) ? GeneratedMessageV3.computeStringSize(1, this.principal_) + 0 : 0;
            int i11 = 0;
            for (int i12 = 0; i12 < this.audiences_.size(); i12++) {
                i11 += GeneratedMessageV3.computeStringSizeNoTag(this.audiences_.getRaw(i12));
            }
            int size = computeStringSize + i11 + (getAudiencesList().size() * 1);
            if (!GeneratedMessageV3.isStringEmpty(this.presenter_)) {
                size += GeneratedMessageV3.computeStringSize(3, this.presenter_);
            }
            if (this.claims_ != null) {
                size += CodedOutputStream.computeMessageSize(4, getClaims());
            }
            int i13 = 0;
            for (int i14 = 0; i14 < this.accessLevels_.size(); i14++) {
                i13 += GeneratedMessageV3.computeStringSizeNoTag(this.accessLevels_.getRaw(i14));
            }
            int size2 = size + i13 + (getAccessLevelsList().size() * 1) + this.unknownFields.getSerializedSize();
            this.memoizedSize = size2;
            return size2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public boolean hasClaims() {
            return this.claims_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getPrincipal().hashCode();
            if (getAudiencesCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getAudiencesList().hashCode();
            }
            int hashCode2 = (((hashCode * 37) + 3) * 53) + getPresenter().hashCode();
            if (hasClaims()) {
                hashCode2 = (((hashCode2 * 37) + 4) * 53) + getClaims().hashCode();
            }
            if (getAccessLevelsCount() > 0) {
                hashCode2 = (((hashCode2 * 37) + 5) * 53) + getAccessLevelsList().hashCode();
            }
            int hashCode3 = (hashCode2 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode3;
            return hashCode3;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return r8.a.f53310j.ensureFieldAccessorsInitialized(Auth.class, Builder.class);
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
            return new Auth();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!GeneratedMessageV3.isStringEmpty(this.principal_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.principal_);
            }
            for (int i10 = 0; i10 < this.audiences_.size(); i10++) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.audiences_.getRaw(i10));
            }
            if (!GeneratedMessageV3.isStringEmpty(this.presenter_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.presenter_);
            }
            if (this.claims_ != null) {
                codedOutputStream.writeMessage(4, getClaims());
            }
            for (int i11 = 0; i11 < this.accessLevels_.size(); i11++) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.accessLevels_.getRaw(i11));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public /* synthetic */ Auth(GeneratedMessageV3.Builder builder, a aVar) {
            this(builder);
        }

        public static Builder newBuilder(Auth auth) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(auth);
        }

        public static Auth parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Auth) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Auth parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public ProtocolStringList getAccessLevelsList() {
            return this.accessLevels_;
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public ProtocolStringList getAudiencesList() {
            return this.audiences_;
        }

        private Auth(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Auth parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Auth getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            a aVar = null;
            return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
        }

        public static Auth parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private Auth() {
            this.memoizedIsInitialized = (byte) -1;
            this.principal_ = "";
            LazyStringList lazyStringList = LazyStringArrayList.EMPTY;
            this.audiences_ = lazyStringList;
            this.presenter_ = "";
            this.accessLevels_ = lazyStringList;
        }

        public static Auth parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static Auth parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Auth parseFrom(InputStream inputStream) throws IOException {
            return (Auth) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Auth parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Auth) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Auth parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Auth) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Auth parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Auth) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        private Auth(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            Objects.requireNonNull(extensionRegistryLite);
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z10 = false;
            int i10 = 0;
            while (!z10) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.principal_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if ((i10 & 1) == 0) {
                                        this.audiences_ = new LazyStringArrayList();
                                        i10 |= 1;
                                    }
                                    this.audiences_.add((LazyStringList) readStringRequireUtf8);
                                } else if (readTag == 26) {
                                    this.presenter_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 34) {
                                    Struct struct = this.claims_;
                                    Struct.Builder builder = struct != null ? struct.toBuilder() : null;
                                    Struct struct2 = (Struct) codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                                    this.claims_ = struct2;
                                    if (builder != null) {
                                        builder.mergeFrom(struct2);
                                        this.claims_ = builder.buildPartial();
                                    }
                                } else if (readTag != 42) {
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                                    if ((i10 & 2) == 0) {
                                        this.accessLevels_ = new LazyStringArrayList();
                                        i10 |= 2;
                                    }
                                    this.accessLevels_.add((LazyStringList) readStringRequireUtf82);
                                }
                            }
                            z10 = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        } catch (UninitializedMessageException e10) {
                            throw e10.asInvalidProtocolBufferException().setUnfinishedMessage(this);
                        }
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    if ((i10 & 1) != 0) {
                        this.audiences_ = this.audiences_.getUnmodifiableView();
                    }
                    if ((i10 & 2) != 0) {
                        this.accessLevels_ = this.accessLevels_.getUnmodifiableView();
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface AuthOrBuilder extends MessageOrBuilder {
        String getAccessLevels(int i10);

        ByteString getAccessLevelsBytes(int i10);

        int getAccessLevelsCount();

        List<String> getAccessLevelsList();

        String getAudiences(int i10);

        ByteString getAudiencesBytes(int i10);

        int getAudiencesCount();

        List<String> getAudiencesList();

        Struct getClaims();

        StructOrBuilder getClaimsOrBuilder();

        String getPresenter();

        ByteString getPresenterBytes();

        String getPrincipal();

        ByteString getPrincipalBytes();

        boolean hasClaims();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AttributeContextOrBuilder {
        private SingleFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> apiBuilder_;
        private Api api_;
        private int bitField0_;
        private SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> destinationBuilder_;
        private Peer destination_;
        private RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> extensionsBuilder_;
        private List<Any> extensions_;
        private SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> originBuilder_;
        private Peer origin_;
        private SingleFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> requestBuilder_;
        private Request request_;
        private SingleFieldBuilderV3<Resource, Resource.Builder, ResourceOrBuilder> resourceBuilder_;
        private Resource resource_;
        private SingleFieldBuilderV3<Response, Response.Builder, ResponseOrBuilder> responseBuilder_;
        private Response response_;
        private SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> sourceBuilder_;
        private Peer source_;

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        private void ensureExtensionsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.extensions_ = new ArrayList(this.extensions_);
                this.bitField0_ |= 1;
            }
        }

        private SingleFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> getApiFieldBuilder() {
            if (this.apiBuilder_ == null) {
                this.apiBuilder_ = new SingleFieldBuilderV3<>(getApi(), getParentForChildren(), isClean());
                this.api_ = null;
            }
            return this.apiBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return r8.a.f53301a;
        }

        private SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> getDestinationFieldBuilder() {
            if (this.destinationBuilder_ == null) {
                this.destinationBuilder_ = new SingleFieldBuilderV3<>(getDestination(), getParentForChildren(), isClean());
                this.destination_ = null;
            }
            return this.destinationBuilder_;
        }

        private RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getExtensionsFieldBuilder() {
            if (this.extensionsBuilder_ == null) {
                this.extensionsBuilder_ = new RepeatedFieldBuilderV3<>(this.extensions_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.extensions_ = null;
            }
            return this.extensionsBuilder_;
        }

        private SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> getOriginFieldBuilder() {
            if (this.originBuilder_ == null) {
                this.originBuilder_ = new SingleFieldBuilderV3<>(getOrigin(), getParentForChildren(), isClean());
                this.origin_ = null;
            }
            return this.originBuilder_;
        }

        private SingleFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> getRequestFieldBuilder() {
            if (this.requestBuilder_ == null) {
                this.requestBuilder_ = new SingleFieldBuilderV3<>(getRequest(), getParentForChildren(), isClean());
                this.request_ = null;
            }
            return this.requestBuilder_;
        }

        private SingleFieldBuilderV3<Resource, Resource.Builder, ResourceOrBuilder> getResourceFieldBuilder() {
            if (this.resourceBuilder_ == null) {
                this.resourceBuilder_ = new SingleFieldBuilderV3<>(getResource(), getParentForChildren(), isClean());
                this.resource_ = null;
            }
            return this.resourceBuilder_;
        }

        private SingleFieldBuilderV3<Response, Response.Builder, ResponseOrBuilder> getResponseFieldBuilder() {
            if (this.responseBuilder_ == null) {
                this.responseBuilder_ = new SingleFieldBuilderV3<>(getResponse(), getParentForChildren(), isClean());
                this.response_ = null;
            }
            return this.responseBuilder_;
        }

        private SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> getSourceFieldBuilder() {
            if (this.sourceBuilder_ == null) {
                this.sourceBuilder_ = new SingleFieldBuilderV3<>(getSource(), getParentForChildren(), isClean());
                this.source_ = null;
            }
            return this.sourceBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                getExtensionsFieldBuilder();
            }
        }

        public Builder addAllExtensions(Iterable<? extends Any> iterable) {
            RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureExtensionsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.extensions_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addExtensions(Any any) {
            RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(any);
                ensureExtensionsIsMutable();
                this.extensions_.add(any);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(any);
            }
            return this;
        }

        public Any.Builder addExtensionsBuilder() {
            return getExtensionsFieldBuilder().addBuilder(Any.getDefaultInstance());
        }

        public Builder clearApi() {
            if (this.apiBuilder_ == null) {
                this.api_ = null;
                onChanged();
            } else {
                this.api_ = null;
                this.apiBuilder_ = null;
            }
            return this;
        }

        public Builder clearDestination() {
            if (this.destinationBuilder_ == null) {
                this.destination_ = null;
                onChanged();
            } else {
                this.destination_ = null;
                this.destinationBuilder_ = null;
            }
            return this;
        }

        public Builder clearExtensions() {
            RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.extensions_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearOrigin() {
            if (this.originBuilder_ == null) {
                this.origin_ = null;
                onChanged();
            } else {
                this.origin_ = null;
                this.originBuilder_ = null;
            }
            return this;
        }

        public Builder clearRequest() {
            if (this.requestBuilder_ == null) {
                this.request_ = null;
                onChanged();
            } else {
                this.request_ = null;
                this.requestBuilder_ = null;
            }
            return this;
        }

        public Builder clearResource() {
            if (this.resourceBuilder_ == null) {
                this.resource_ = null;
                onChanged();
            } else {
                this.resource_ = null;
                this.resourceBuilder_ = null;
            }
            return this;
        }

        public Builder clearResponse() {
            if (this.responseBuilder_ == null) {
                this.response_ = null;
                onChanged();
            } else {
                this.response_ = null;
                this.responseBuilder_ = null;
            }
            return this;
        }

        public Builder clearSource() {
            if (this.sourceBuilder_ == null) {
                this.source_ = null;
                onChanged();
            } else {
                this.source_ = null;
                this.sourceBuilder_ = null;
            }
            return this;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public Api getApi() {
            SingleFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> singleFieldBuilderV3 = this.apiBuilder_;
            if (singleFieldBuilderV3 == null) {
                Api api = this.api_;
                return api == null ? Api.getDefaultInstance() : api;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Api.Builder getApiBuilder() {
            onChanged();
            return getApiFieldBuilder().getBuilder();
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public ApiOrBuilder getApiOrBuilder() {
            SingleFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> singleFieldBuilderV3 = this.apiBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Api api = this.api_;
            return api == null ? Api.getDefaultInstance() : api;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return r8.a.f53301a;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public Peer getDestination() {
            SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> singleFieldBuilderV3 = this.destinationBuilder_;
            if (singleFieldBuilderV3 == null) {
                Peer peer = this.destination_;
                return peer == null ? Peer.getDefaultInstance() : peer;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Peer.Builder getDestinationBuilder() {
            onChanged();
            return getDestinationFieldBuilder().getBuilder();
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public PeerOrBuilder getDestinationOrBuilder() {
            SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> singleFieldBuilderV3 = this.destinationBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Peer peer = this.destination_;
            return peer == null ? Peer.getDefaultInstance() : peer;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public Any getExtensions(int i10) {
            RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.extensions_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public Any.Builder getExtensionsBuilder(int i10) {
            return getExtensionsFieldBuilder().getBuilder(i10);
        }

        public List<Any.Builder> getExtensionsBuilderList() {
            return getExtensionsFieldBuilder().getBuilderList();
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public int getExtensionsCount() {
            RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.extensions_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public List<Any> getExtensionsList() {
            RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.extensions_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public AnyOrBuilder getExtensionsOrBuilder(int i10) {
            RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.extensions_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public List<? extends AnyOrBuilder> getExtensionsOrBuilderList() {
            RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.extensions_);
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public Peer getOrigin() {
            SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> singleFieldBuilderV3 = this.originBuilder_;
            if (singleFieldBuilderV3 == null) {
                Peer peer = this.origin_;
                return peer == null ? Peer.getDefaultInstance() : peer;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Peer.Builder getOriginBuilder() {
            onChanged();
            return getOriginFieldBuilder().getBuilder();
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public PeerOrBuilder getOriginOrBuilder() {
            SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> singleFieldBuilderV3 = this.originBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Peer peer = this.origin_;
            return peer == null ? Peer.getDefaultInstance() : peer;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public Request getRequest() {
            SingleFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
            if (singleFieldBuilderV3 == null) {
                Request request = this.request_;
                return request == null ? Request.getDefaultInstance() : request;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Request.Builder getRequestBuilder() {
            onChanged();
            return getRequestFieldBuilder().getBuilder();
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public RequestOrBuilder getRequestOrBuilder() {
            SingleFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Request request = this.request_;
            return request == null ? Request.getDefaultInstance() : request;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public Resource getResource() {
            SingleFieldBuilderV3<Resource, Resource.Builder, ResourceOrBuilder> singleFieldBuilderV3 = this.resourceBuilder_;
            if (singleFieldBuilderV3 == null) {
                Resource resource = this.resource_;
                return resource == null ? Resource.getDefaultInstance() : resource;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Resource.Builder getResourceBuilder() {
            onChanged();
            return getResourceFieldBuilder().getBuilder();
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public ResourceOrBuilder getResourceOrBuilder() {
            SingleFieldBuilderV3<Resource, Resource.Builder, ResourceOrBuilder> singleFieldBuilderV3 = this.resourceBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Resource resource = this.resource_;
            return resource == null ? Resource.getDefaultInstance() : resource;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public Response getResponse() {
            SingleFieldBuilderV3<Response, Response.Builder, ResponseOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 == null) {
                Response response = this.response_;
                return response == null ? Response.getDefaultInstance() : response;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Response.Builder getResponseBuilder() {
            onChanged();
            return getResponseFieldBuilder().getBuilder();
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public ResponseOrBuilder getResponseOrBuilder() {
            SingleFieldBuilderV3<Response, Response.Builder, ResponseOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Response response = this.response_;
            return response == null ? Response.getDefaultInstance() : response;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public Peer getSource() {
            SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> singleFieldBuilderV3 = this.sourceBuilder_;
            if (singleFieldBuilderV3 == null) {
                Peer peer = this.source_;
                return peer == null ? Peer.getDefaultInstance() : peer;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Peer.Builder getSourceBuilder() {
            onChanged();
            return getSourceFieldBuilder().getBuilder();
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public PeerOrBuilder getSourceOrBuilder() {
            SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> singleFieldBuilderV3 = this.sourceBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Peer peer = this.source_;
            return peer == null ? Peer.getDefaultInstance() : peer;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public boolean hasApi() {
            return (this.apiBuilder_ == null && this.api_ == null) ? false : true;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public boolean hasDestination() {
            return (this.destinationBuilder_ == null && this.destination_ == null) ? false : true;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public boolean hasOrigin() {
            return (this.originBuilder_ == null && this.origin_ == null) ? false : true;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public boolean hasRequest() {
            return (this.requestBuilder_ == null && this.request_ == null) ? false : true;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public boolean hasResource() {
            return (this.resourceBuilder_ == null && this.resource_ == null) ? false : true;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public boolean hasResponse() {
            return (this.responseBuilder_ == null && this.response_ == null) ? false : true;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public boolean hasSource() {
            return (this.sourceBuilder_ == null && this.source_ == null) ? false : true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return r8.a.f53302b.ensureFieldAccessorsInitialized(AttributeContext.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeApi(Api api) {
            SingleFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> singleFieldBuilderV3 = this.apiBuilder_;
            if (singleFieldBuilderV3 == null) {
                Api api2 = this.api_;
                if (api2 != null) {
                    this.api_ = Api.newBuilder(api2).mergeFrom(api).buildPartial();
                } else {
                    this.api_ = api;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(api);
            }
            return this;
        }

        public Builder mergeDestination(Peer peer) {
            SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> singleFieldBuilderV3 = this.destinationBuilder_;
            if (singleFieldBuilderV3 == null) {
                Peer peer2 = this.destination_;
                if (peer2 != null) {
                    this.destination_ = Peer.newBuilder(peer2).mergeFrom(peer).buildPartial();
                } else {
                    this.destination_ = peer;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(peer);
            }
            return this;
        }

        public Builder mergeOrigin(Peer peer) {
            SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> singleFieldBuilderV3 = this.originBuilder_;
            if (singleFieldBuilderV3 == null) {
                Peer peer2 = this.origin_;
                if (peer2 != null) {
                    this.origin_ = Peer.newBuilder(peer2).mergeFrom(peer).buildPartial();
                } else {
                    this.origin_ = peer;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(peer);
            }
            return this;
        }

        public Builder mergeRequest(Request request) {
            SingleFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
            if (singleFieldBuilderV3 == null) {
                Request request2 = this.request_;
                if (request2 != null) {
                    this.request_ = Request.newBuilder(request2).mergeFrom(request).buildPartial();
                } else {
                    this.request_ = request;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(request);
            }
            return this;
        }

        public Builder mergeResource(Resource resource) {
            SingleFieldBuilderV3<Resource, Resource.Builder, ResourceOrBuilder> singleFieldBuilderV3 = this.resourceBuilder_;
            if (singleFieldBuilderV3 == null) {
                Resource resource2 = this.resource_;
                if (resource2 != null) {
                    this.resource_ = Resource.newBuilder(resource2).mergeFrom(resource).buildPartial();
                } else {
                    this.resource_ = resource;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(resource);
            }
            return this;
        }

        public Builder mergeResponse(Response response) {
            SingleFieldBuilderV3<Response, Response.Builder, ResponseOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 == null) {
                Response response2 = this.response_;
                if (response2 != null) {
                    this.response_ = Response.newBuilder(response2).mergeFrom(response).buildPartial();
                } else {
                    this.response_ = response;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(response);
            }
            return this;
        }

        public Builder mergeSource(Peer peer) {
            SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> singleFieldBuilderV3 = this.sourceBuilder_;
            if (singleFieldBuilderV3 == null) {
                Peer peer2 = this.source_;
                if (peer2 != null) {
                    this.source_ = Peer.newBuilder(peer2).mergeFrom(peer).buildPartial();
                } else {
                    this.source_ = peer;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(peer);
            }
            return this;
        }

        public Builder removeExtensions(int i10) {
            RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureExtensionsIsMutable();
                this.extensions_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder setApi(Api api) {
            SingleFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> singleFieldBuilderV3 = this.apiBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(api);
                this.api_ = api;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(api);
            }
            return this;
        }

        public Builder setDestination(Peer peer) {
            SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> singleFieldBuilderV3 = this.destinationBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(peer);
                this.destination_ = peer;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(peer);
            }
            return this;
        }

        public Builder setExtensions(int i10, Any any) {
            RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(any);
                ensureExtensionsIsMutable();
                this.extensions_.set(i10, any);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, any);
            }
            return this;
        }

        public Builder setOrigin(Peer peer) {
            SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> singleFieldBuilderV3 = this.originBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(peer);
                this.origin_ = peer;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(peer);
            }
            return this;
        }

        public Builder setRequest(Request request) {
            SingleFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(request);
                this.request_ = request;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(request);
            }
            return this;
        }

        public Builder setResource(Resource resource) {
            SingleFieldBuilderV3<Resource, Resource.Builder, ResourceOrBuilder> singleFieldBuilderV3 = this.resourceBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(resource);
                this.resource_ = resource;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(resource);
            }
            return this;
        }

        public Builder setResponse(Response response) {
            SingleFieldBuilderV3<Response, Response.Builder, ResponseOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(response);
                this.response_ = response;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(response);
            }
            return this;
        }

        public Builder setSource(Peer peer) {
            SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> singleFieldBuilderV3 = this.sourceBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(peer);
                this.source_ = peer;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(peer);
            }
            return this;
        }

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        public Any.Builder addExtensionsBuilder(int i10) {
            return getExtensionsFieldBuilder().addBuilder(i10, Any.getDefaultInstance());
        }

        private Builder() {
            this.extensions_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AttributeContext build() {
            AttributeContext buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AttributeContext buildPartial() {
            AttributeContext attributeContext = new AttributeContext(this, (a) null);
            SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> singleFieldBuilderV3 = this.originBuilder_;
            if (singleFieldBuilderV3 == null) {
                attributeContext.origin_ = this.origin_;
            } else {
                attributeContext.origin_ = singleFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> singleFieldBuilderV32 = this.sourceBuilder_;
            if (singleFieldBuilderV32 == null) {
                attributeContext.source_ = this.source_;
            } else {
                attributeContext.source_ = singleFieldBuilderV32.build();
            }
            SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> singleFieldBuilderV33 = this.destinationBuilder_;
            if (singleFieldBuilderV33 == null) {
                attributeContext.destination_ = this.destination_;
            } else {
                attributeContext.destination_ = singleFieldBuilderV33.build();
            }
            SingleFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> singleFieldBuilderV34 = this.requestBuilder_;
            if (singleFieldBuilderV34 == null) {
                attributeContext.request_ = this.request_;
            } else {
                attributeContext.request_ = singleFieldBuilderV34.build();
            }
            SingleFieldBuilderV3<Response, Response.Builder, ResponseOrBuilder> singleFieldBuilderV35 = this.responseBuilder_;
            if (singleFieldBuilderV35 == null) {
                attributeContext.response_ = this.response_;
            } else {
                attributeContext.response_ = singleFieldBuilderV35.build();
            }
            SingleFieldBuilderV3<Resource, Resource.Builder, ResourceOrBuilder> singleFieldBuilderV36 = this.resourceBuilder_;
            if (singleFieldBuilderV36 == null) {
                attributeContext.resource_ = this.resource_;
            } else {
                attributeContext.resource_ = singleFieldBuilderV36.build();
            }
            SingleFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> singleFieldBuilderV37 = this.apiBuilder_;
            if (singleFieldBuilderV37 == null) {
                attributeContext.api_ = this.api_;
            } else {
                attributeContext.api_ = singleFieldBuilderV37.build();
            }
            RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.extensions_ = Collections.unmodifiableList(this.extensions_);
                    this.bitField0_ &= -2;
                }
                attributeContext.extensions_ = this.extensions_;
            } else {
                attributeContext.extensions_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return attributeContext;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AttributeContext getDefaultInstanceForType() {
            return AttributeContext.getDefaultInstance();
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
            if (this.originBuilder_ == null) {
                this.origin_ = null;
            } else {
                this.origin_ = null;
                this.originBuilder_ = null;
            }
            if (this.sourceBuilder_ == null) {
                this.source_ = null;
            } else {
                this.source_ = null;
                this.sourceBuilder_ = null;
            }
            if (this.destinationBuilder_ == null) {
                this.destination_ = null;
            } else {
                this.destination_ = null;
                this.destinationBuilder_ = null;
            }
            if (this.requestBuilder_ == null) {
                this.request_ = null;
            } else {
                this.request_ = null;
                this.requestBuilder_ = null;
            }
            if (this.responseBuilder_ == null) {
                this.response_ = null;
            } else {
                this.response_ = null;
                this.responseBuilder_ = null;
            }
            if (this.resourceBuilder_ == null) {
                this.resource_ = null;
            } else {
                this.resource_ = null;
                this.resourceBuilder_ = null;
            }
            if (this.apiBuilder_ == null) {
                this.api_ = null;
            } else {
                this.api_ = null;
                this.apiBuilder_ = null;
            }
            RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.extensions_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.extensions_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Builder setApi(Api.Builder builder) {
            SingleFieldBuilderV3<Api, Api.Builder, ApiOrBuilder> singleFieldBuilderV3 = this.apiBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.api_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setDestination(Peer.Builder builder) {
            SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> singleFieldBuilderV3 = this.destinationBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.destination_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setOrigin(Peer.Builder builder) {
            SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> singleFieldBuilderV3 = this.originBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.origin_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setRequest(Request.Builder builder) {
            SingleFieldBuilderV3<Request, Request.Builder, RequestOrBuilder> singleFieldBuilderV3 = this.requestBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.request_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setResource(Resource.Builder builder) {
            SingleFieldBuilderV3<Resource, Resource.Builder, ResourceOrBuilder> singleFieldBuilderV3 = this.resourceBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.resource_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setResponse(Response.Builder builder) {
            SingleFieldBuilderV3<Response, Response.Builder, ResponseOrBuilder> singleFieldBuilderV3 = this.responseBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.response_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setSource(Peer.Builder builder) {
            SingleFieldBuilderV3<Peer, Peer.Builder, PeerOrBuilder> singleFieldBuilderV3 = this.sourceBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.source_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder addExtensions(int i10, Any any) {
            RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(any);
                ensureExtensionsIsMutable();
                this.extensions_.add(i10, any);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, any);
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2458clone() {
            return (Builder) super.mo2458clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof AttributeContext) {
                return mergeFrom((AttributeContext) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setExtensions(int i10, Any.Builder builder) {
            RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureExtensionsIsMutable();
                this.extensions_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder mergeFrom(AttributeContext attributeContext) {
            if (attributeContext == AttributeContext.getDefaultInstance()) {
                return this;
            }
            if (attributeContext.hasOrigin()) {
                mergeOrigin(attributeContext.getOrigin());
            }
            if (attributeContext.hasSource()) {
                mergeSource(attributeContext.getSource());
            }
            if (attributeContext.hasDestination()) {
                mergeDestination(attributeContext.getDestination());
            }
            if (attributeContext.hasRequest()) {
                mergeRequest(attributeContext.getRequest());
            }
            if (attributeContext.hasResponse()) {
                mergeResponse(attributeContext.getResponse());
            }
            if (attributeContext.hasResource()) {
                mergeResource(attributeContext.getResource());
            }
            if (attributeContext.hasApi()) {
                mergeApi(attributeContext.getApi());
            }
            if (this.extensionsBuilder_ == null) {
                if (!attributeContext.extensions_.isEmpty()) {
                    if (this.extensions_.isEmpty()) {
                        this.extensions_ = attributeContext.extensions_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureExtensionsIsMutable();
                        this.extensions_.addAll(attributeContext.extensions_);
                    }
                    onChanged();
                }
            } else if (!attributeContext.extensions_.isEmpty()) {
                if (this.extensionsBuilder_.isEmpty()) {
                    this.extensionsBuilder_.dispose();
                    this.extensionsBuilder_ = null;
                    this.extensions_ = attributeContext.extensions_;
                    this.bitField0_ &= -2;
                    this.extensionsBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getExtensionsFieldBuilder() : null;
                } else {
                    this.extensionsBuilder_.addAllMessages(attributeContext.extensions_);
                }
            }
            mergeUnknownFields(attributeContext.unknownFields);
            onChanged();
            return this;
        }

        public Builder addExtensions(Any.Builder builder) {
            RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureExtensionsIsMutable();
                this.extensions_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addExtensions(int i10, Any.Builder builder) {
            RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.extensionsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureExtensionsIsMutable();
                this.extensions_.add(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, builder.build());
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.rpc.context.AttributeContext.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.rpc.context.AttributeContext.access$13000()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.rpc.context.AttributeContext r3 = (com.google.rpc.context.AttributeContext) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.rpc.context.AttributeContext r4 = (com.google.rpc.context.AttributeContext) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.rpc.context.AttributeContext.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.rpc.context.AttributeContext$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Peer extends GeneratedMessageV3 implements PeerOrBuilder {
        public static final int IP_FIELD_NUMBER = 1;
        public static final int LABELS_FIELD_NUMBER = 6;
        public static final int PORT_FIELD_NUMBER = 2;
        public static final int PRINCIPAL_FIELD_NUMBER = 7;
        public static final int REGION_CODE_FIELD_NUMBER = 8;
        private static final long serialVersionUID = 0;
        private volatile Object ip_;
        private MapField<String, String> labels_;
        private byte memoizedIsInitialized;
        private long port_;
        private volatile Object principal_;
        private volatile Object regionCode_;
        private static final Peer DEFAULT_INSTANCE = new Peer();
        private static final Parser<Peer> PARSER = new a();

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PeerOrBuilder {
            private int bitField0_;
            private Object ip_;
            private MapField<String, String> labels_;
            private long port_;
            private Object principal_;
            private Object regionCode_;

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
                this(builderParent);
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return r8.a.f53303c;
            }

            private MapField<String, String> internalGetLabels() {
                MapField<String, String> mapField = this.labels_;
                return mapField == null ? MapField.emptyMapField(b.f27105a) : mapField;
            }

            private MapField<String, String> internalGetMutableLabels() {
                onChanged();
                if (this.labels_ == null) {
                    this.labels_ = MapField.newMapField(b.f27105a);
                }
                if (!this.labels_.isMutable()) {
                    this.labels_ = this.labels_.copy();
                }
                return this.labels_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearIp() {
                this.ip_ = Peer.getDefaultInstance().getIp();
                onChanged();
                return this;
            }

            public Builder clearLabels() {
                internalGetMutableLabels().getMutableMap().clear();
                return this;
            }

            public Builder clearPort() {
                this.port_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearPrincipal() {
                this.principal_ = Peer.getDefaultInstance().getPrincipal();
                onChanged();
                return this;
            }

            public Builder clearRegionCode() {
                this.regionCode_ = Peer.getDefaultInstance().getRegionCode();
                onChanged();
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public boolean containsLabels(String str) {
                Objects.requireNonNull(str, "map key");
                return internalGetLabels().getMap().containsKey(str);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return r8.a.f53303c;
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public String getIp() {
                Object obj = this.ip_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.ip_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public ByteString getIpBytes() {
                Object obj = this.ip_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.ip_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            @Deprecated
            public Map<String, String> getLabels() {
                return getLabelsMap();
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public int getLabelsCount() {
                return internalGetLabels().getMap().size();
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public Map<String, String> getLabelsMap() {
                return internalGetLabels().getMap();
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public String getLabelsOrDefault(String str, String str2) {
                Objects.requireNonNull(str, "map key");
                Map<String, String> map = internalGetLabels().getMap();
                return map.containsKey(str) ? map.get(str) : str2;
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public String getLabelsOrThrow(String str) {
                Objects.requireNonNull(str, "map key");
                Map<String, String> map = internalGetLabels().getMap();
                if (map.containsKey(str)) {
                    return map.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Deprecated
            public Map<String, String> getMutableLabels() {
                return internalGetMutableLabels().getMutableMap();
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public long getPort() {
                return this.port_;
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public String getPrincipal() {
                Object obj = this.principal_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.principal_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public ByteString getPrincipalBytes() {
                Object obj = this.principal_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.principal_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public String getRegionCode() {
                Object obj = this.regionCode_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.regionCode_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public ByteString getRegionCodeBytes() {
                Object obj = this.regionCode_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.regionCode_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return r8.a.f53304d.ensureFieldAccessorsInitialized(Peer.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public MapField internalGetMapField(int i10) {
                if (i10 == 6) {
                    return internalGetLabels();
                }
                throw new RuntimeException("Invalid map field number: " + i10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public MapField internalGetMutableMapField(int i10) {
                if (i10 == 6) {
                    return internalGetMutableLabels();
                }
                throw new RuntimeException("Invalid map field number: " + i10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder putAllLabels(Map<String, String> map) {
                internalGetMutableLabels().getMutableMap().putAll(map);
                return this;
            }

            public Builder putLabels(String str, String str2) {
                Objects.requireNonNull(str, "map key");
                Objects.requireNonNull(str2, "map value");
                internalGetMutableLabels().getMutableMap().put(str, str2);
                return this;
            }

            public Builder removeLabels(String str) {
                Objects.requireNonNull(str, "map key");
                internalGetMutableLabels().getMutableMap().remove(str);
                return this;
            }

            public Builder setIp(String str) {
                Objects.requireNonNull(str);
                this.ip_ = str;
                onChanged();
                return this;
            }

            public Builder setIpBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.ip_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPort(long j10) {
                this.port_ = j10;
                onChanged();
                return this;
            }

            public Builder setPrincipal(String str) {
                Objects.requireNonNull(str);
                this.principal_ = str;
                onChanged();
                return this;
            }

            public Builder setPrincipalBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.principal_ = byteString;
                onChanged();
                return this;
            }

            public Builder setRegionCode(String str) {
                Objects.requireNonNull(str);
                this.regionCode_ = str;
                onChanged();
                return this;
            }

            public Builder setRegionCodeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.regionCode_ = byteString;
                onChanged();
                return this;
            }

            public /* synthetic */ Builder(a aVar) {
                this();
            }

            private Builder() {
                this.ip_ = "";
                this.principal_ = "";
                this.regionCode_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Peer build() {
                Peer buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Peer buildPartial() {
                Peer peer = new Peer(this, (a) null);
                peer.ip_ = this.ip_;
                peer.port_ = this.port_;
                peer.labels_ = internalGetLabels();
                peer.labels_.makeImmutable();
                peer.principal_ = this.principal_;
                peer.regionCode_ = this.regionCode_;
                onBuilt();
                return peer;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Peer getDefaultInstanceForType() {
                return Peer.getDefaultInstance();
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
                this.ip_ = "";
                this.port_ = 0L;
                internalGetMutableLabels().clear();
                this.principal_ = "";
                this.regionCode_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Peer) {
                    return mergeFrom((Peer) message);
                }
                super.mergeFrom(message);
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.ip_ = "";
                this.principal_ = "";
                this.regionCode_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder mergeFrom(Peer peer) {
                if (peer == Peer.getDefaultInstance()) {
                    return this;
                }
                if (!peer.getIp().isEmpty()) {
                    this.ip_ = peer.ip_;
                    onChanged();
                }
                if (peer.getPort() != 0) {
                    setPort(peer.getPort());
                }
                internalGetMutableLabels().mergeFrom(peer.internalGetLabels());
                if (!peer.getPrincipal().isEmpty()) {
                    this.principal_ = peer.principal_;
                    onChanged();
                }
                if (!peer.getRegionCode().isEmpty()) {
                    this.regionCode_ = peer.regionCode_;
                    onChanged();
                }
                mergeUnknownFields(peer.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.google.rpc.context.AttributeContext.Peer.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.google.rpc.context.AttributeContext.Peer.access$1100()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.google.rpc.context.AttributeContext$Peer r3 = (com.google.rpc.context.AttributeContext.Peer) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.google.rpc.context.AttributeContext$Peer r4 = (com.google.rpc.context.AttributeContext.Peer) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.google.rpc.context.AttributeContext.Peer.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.rpc.context.AttributeContext$Peer$Builder");
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class a extends AbstractParser<Peer> {
            @Override // com.google.protobuf.Parser
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Peer parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Peer(codedInputStream, extensionRegistryLite, null);
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class b {

            /* renamed from: a, reason: collision with root package name */
            public static final MapEntry<String, String> f27105a;

            static {
                Descriptors.Descriptor descriptor = r8.a.f53305e;
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                f27105a = MapEntry.newDefaultInstance(descriptor, fieldType, "", fieldType, "");
            }
        }

        public /* synthetic */ Peer(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static Peer getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return r8.a.f53303c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MapField<String, String> internalGetLabels() {
            MapField<String, String> mapField = this.labels_;
            return mapField == null ? MapField.emptyMapField(b.f27105a) : mapField;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Peer parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Peer) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Peer parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<Peer> parser() {
            return PARSER;
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public boolean containsLabels(String str) {
            Objects.requireNonNull(str, "map key");
            return internalGetLabels().getMap().containsKey(str);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Peer)) {
                return super.equals(obj);
            }
            Peer peer = (Peer) obj;
            return getIp().equals(peer.getIp()) && getPort() == peer.getPort() && internalGetLabels().equals(peer.internalGetLabels()) && getPrincipal().equals(peer.getPrincipal()) && getRegionCode().equals(peer.getRegionCode()) && this.unknownFields.equals(peer.unknownFields);
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public String getIp() {
            Object obj = this.ip_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.ip_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public ByteString getIpBytes() {
            Object obj = this.ip_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.ip_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        @Deprecated
        public Map<String, String> getLabels() {
            return getLabelsMap();
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public int getLabelsCount() {
            return internalGetLabels().getMap().size();
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public Map<String, String> getLabelsMap() {
            return internalGetLabels().getMap();
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public String getLabelsOrDefault(String str, String str2) {
            Objects.requireNonNull(str, "map key");
            Map<String, String> map = internalGetLabels().getMap();
            return map.containsKey(str) ? map.get(str) : str2;
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public String getLabelsOrThrow(String str) {
            Objects.requireNonNull(str, "map key");
            Map<String, String> map = internalGetLabels().getMap();
            if (map.containsKey(str)) {
                return map.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Peer> getParserForType() {
            return PARSER;
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public long getPort() {
            return this.port_;
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public String getPrincipal() {
            Object obj = this.principal_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.principal_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public ByteString getPrincipalBytes() {
            Object obj = this.principal_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.principal_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public String getRegionCode() {
            Object obj = this.regionCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.regionCode_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public ByteString getRegionCodeBytes() {
            Object obj = this.regionCode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.regionCode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeStringSize = GeneratedMessageV3.isStringEmpty(this.ip_) ? 0 : 0 + GeneratedMessageV3.computeStringSize(1, this.ip_);
            long j10 = this.port_;
            if (j10 != 0) {
                computeStringSize += CodedOutputStream.computeInt64Size(2, j10);
            }
            for (Map.Entry<String, String> entry : internalGetLabels().getMap().entrySet()) {
                computeStringSize += CodedOutputStream.computeMessageSize(6, b.f27105a.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (!GeneratedMessageV3.isStringEmpty(this.principal_)) {
                computeStringSize += GeneratedMessageV3.computeStringSize(7, this.principal_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.regionCode_)) {
                computeStringSize += GeneratedMessageV3.computeStringSize(8, this.regionCode_);
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getIp().hashCode()) * 37) + 2) * 53) + Internal.hashLong(getPort());
            if (!internalGetLabels().getMap().isEmpty()) {
                hashCode = (((hashCode * 37) + 6) * 53) + internalGetLabels().hashCode();
            }
            int hashCode2 = (((((((((hashCode * 37) + 7) * 53) + getPrincipal().hashCode()) * 37) + 8) * 53) + getRegionCode().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return r8.a.f53304d.ensureFieldAccessorsInitialized(Peer.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public MapField internalGetMapField(int i10) {
            if (i10 == 6) {
                return internalGetLabels();
            }
            throw new RuntimeException("Invalid map field number: " + i10);
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
            return new Peer();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!GeneratedMessageV3.isStringEmpty(this.ip_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.ip_);
            }
            long j10 = this.port_;
            if (j10 != 0) {
                codedOutputStream.writeInt64(2, j10);
            }
            GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetLabels(), b.f27105a, 6);
            if (!GeneratedMessageV3.isStringEmpty(this.principal_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.principal_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.regionCode_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 8, this.regionCode_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public /* synthetic */ Peer(GeneratedMessageV3.Builder builder, a aVar) {
            this(builder);
        }

        public static Builder newBuilder(Peer peer) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(peer);
        }

        public static Peer parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Peer) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Peer parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private Peer(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Peer parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Peer getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            a aVar = null;
            return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
        }

        public static Peer parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private Peer() {
            this.memoizedIsInitialized = (byte) -1;
            this.ip_ = "";
            this.principal_ = "";
            this.regionCode_ = "";
        }

        public static Peer parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static Peer parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Peer parseFrom(InputStream inputStream) throws IOException {
            return (Peer) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Peer parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Peer) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Peer parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Peer) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Peer(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            Objects.requireNonNull(extensionRegistryLite);
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z10 = false;
            boolean z11 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.ip_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 16) {
                                    this.port_ = codedInputStream.readInt64();
                                } else if (readTag == 50) {
                                    if (!(z11 & true)) {
                                        this.labels_ = MapField.newMapField(b.f27105a);
                                        z11 |= true;
                                    }
                                    MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(b.f27105a.getParserForType(), extensionRegistryLite);
                                    this.labels_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
                                } else if (readTag == 58) {
                                    this.principal_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag != 66) {
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.regionCode_ = codedInputStream.readStringRequireUtf8();
                                }
                            }
                            z10 = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.setUnfinishedMessage(this);
                        } catch (UninitializedMessageException e10) {
                            throw e10.asInvalidProtocolBufferException().setUnfinishedMessage(this);
                        }
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static Peer parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Peer) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface PeerOrBuilder extends MessageOrBuilder {
        boolean containsLabels(String str);

        String getIp();

        ByteString getIpBytes();

        @Deprecated
        Map<String, String> getLabels();

        int getLabelsCount();

        Map<String, String> getLabelsMap();

        String getLabelsOrDefault(String str, String str2);

        String getLabelsOrThrow(String str);

        long getPort();

        String getPrincipal();

        ByteString getPrincipalBytes();

        String getRegionCode();

        ByteString getRegionCodeBytes();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Request extends GeneratedMessageV3 implements RequestOrBuilder {
        public static final int AUTH_FIELD_NUMBER = 13;
        public static final int HEADERS_FIELD_NUMBER = 3;
        public static final int HOST_FIELD_NUMBER = 5;
        public static final int ID_FIELD_NUMBER = 1;
        public static final int METHOD_FIELD_NUMBER = 2;
        public static final int PATH_FIELD_NUMBER = 4;
        public static final int PROTOCOL_FIELD_NUMBER = 11;
        public static final int QUERY_FIELD_NUMBER = 7;
        public static final int REASON_FIELD_NUMBER = 12;
        public static final int SCHEME_FIELD_NUMBER = 6;
        public static final int SIZE_FIELD_NUMBER = 10;
        public static final int TIME_FIELD_NUMBER = 9;
        private static final long serialVersionUID = 0;
        private Auth auth_;
        private MapField<String, String> headers_;
        private volatile Object host_;
        private volatile Object id_;
        private byte memoizedIsInitialized;
        private volatile Object method_;
        private volatile Object path_;
        private volatile Object protocol_;
        private volatile Object query_;
        private volatile Object reason_;
        private volatile Object scheme_;
        private long size_;
        private Timestamp time_;
        private static final Request DEFAULT_INSTANCE = new Request();
        private static final Parser<Request> PARSER = new a();

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestOrBuilder {
            private SingleFieldBuilderV3<Auth, Auth.Builder, AuthOrBuilder> authBuilder_;
            private Auth auth_;
            private int bitField0_;
            private MapField<String, String> headers_;
            private Object host_;
            private Object id_;
            private Object method_;
            private Object path_;
            private Object protocol_;
            private Object query_;
            private Object reason_;
            private Object scheme_;
            private long size_;
            private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> timeBuilder_;
            private Timestamp time_;

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
                this(builderParent);
            }

            private SingleFieldBuilderV3<Auth, Auth.Builder, AuthOrBuilder> getAuthFieldBuilder() {
                if (this.authBuilder_ == null) {
                    this.authBuilder_ = new SingleFieldBuilderV3<>(getAuth(), getParentForChildren(), isClean());
                    this.auth_ = null;
                }
                return this.authBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return r8.a.f53311k;
            }

            private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> getTimeFieldBuilder() {
                if (this.timeBuilder_ == null) {
                    this.timeBuilder_ = new SingleFieldBuilderV3<>(getTime(), getParentForChildren(), isClean());
                    this.time_ = null;
                }
                return this.timeBuilder_;
            }

            private MapField<String, String> internalGetHeaders() {
                MapField<String, String> mapField = this.headers_;
                return mapField == null ? MapField.emptyMapField(b.f27106a) : mapField;
            }

            private MapField<String, String> internalGetMutableHeaders() {
                onChanged();
                if (this.headers_ == null) {
                    this.headers_ = MapField.newMapField(b.f27106a);
                }
                if (!this.headers_.isMutable()) {
                    this.headers_ = this.headers_.copy();
                }
                return this.headers_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearAuth() {
                if (this.authBuilder_ == null) {
                    this.auth_ = null;
                    onChanged();
                } else {
                    this.auth_ = null;
                    this.authBuilder_ = null;
                }
                return this;
            }

            public Builder clearHeaders() {
                internalGetMutableHeaders().getMutableMap().clear();
                return this;
            }

            public Builder clearHost() {
                this.host_ = Request.getDefaultInstance().getHost();
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = Request.getDefaultInstance().getId();
                onChanged();
                return this;
            }

            public Builder clearMethod() {
                this.method_ = Request.getDefaultInstance().getMethod();
                onChanged();
                return this;
            }

            public Builder clearPath() {
                this.path_ = Request.getDefaultInstance().getPath();
                onChanged();
                return this;
            }

            public Builder clearProtocol() {
                this.protocol_ = Request.getDefaultInstance().getProtocol();
                onChanged();
                return this;
            }

            public Builder clearQuery() {
                this.query_ = Request.getDefaultInstance().getQuery();
                onChanged();
                return this;
            }

            public Builder clearReason() {
                this.reason_ = Request.getDefaultInstance().getReason();
                onChanged();
                return this;
            }

            public Builder clearScheme() {
                this.scheme_ = Request.getDefaultInstance().getScheme();
                onChanged();
                return this;
            }

            public Builder clearSize() {
                this.size_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearTime() {
                if (this.timeBuilder_ == null) {
                    this.time_ = null;
                    onChanged();
                } else {
                    this.time_ = null;
                    this.timeBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public boolean containsHeaders(String str) {
                Objects.requireNonNull(str, "map key");
                return internalGetHeaders().getMap().containsKey(str);
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public Auth getAuth() {
                SingleFieldBuilderV3<Auth, Auth.Builder, AuthOrBuilder> singleFieldBuilderV3 = this.authBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Auth auth = this.auth_;
                    return auth == null ? Auth.getDefaultInstance() : auth;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Auth.Builder getAuthBuilder() {
                onChanged();
                return getAuthFieldBuilder().getBuilder();
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public AuthOrBuilder getAuthOrBuilder() {
                SingleFieldBuilderV3<Auth, Auth.Builder, AuthOrBuilder> singleFieldBuilderV3 = this.authBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Auth auth = this.auth_;
                return auth == null ? Auth.getDefaultInstance() : auth;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return r8.a.f53311k;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            @Deprecated
            public Map<String, String> getHeaders() {
                return getHeadersMap();
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public int getHeadersCount() {
                return internalGetHeaders().getMap().size();
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public Map<String, String> getHeadersMap() {
                return internalGetHeaders().getMap();
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public String getHeadersOrDefault(String str, String str2) {
                Objects.requireNonNull(str, "map key");
                Map<String, String> map = internalGetHeaders().getMap();
                return map.containsKey(str) ? map.get(str) : str2;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public String getHeadersOrThrow(String str) {
                Objects.requireNonNull(str, "map key");
                Map<String, String> map = internalGetHeaders().getMap();
                if (map.containsKey(str)) {
                    return map.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public String getHost() {
                Object obj = this.host_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.host_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public ByteString getHostBytes() {
                Object obj = this.host_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.host_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public String getId() {
                Object obj = this.id_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.id_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public ByteString getIdBytes() {
                Object obj = this.id_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.id_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public String getMethod() {
                Object obj = this.method_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.method_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public ByteString getMethodBytes() {
                Object obj = this.method_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.method_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Deprecated
            public Map<String, String> getMutableHeaders() {
                return internalGetMutableHeaders().getMutableMap();
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public String getPath() {
                Object obj = this.path_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.path_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public ByteString getPathBytes() {
                Object obj = this.path_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.path_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public String getProtocol() {
                Object obj = this.protocol_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.protocol_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public ByteString getProtocolBytes() {
                Object obj = this.protocol_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.protocol_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public String getQuery() {
                Object obj = this.query_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.query_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public ByteString getQueryBytes() {
                Object obj = this.query_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.query_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public String getReason() {
                Object obj = this.reason_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.reason_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public ByteString getReasonBytes() {
                Object obj = this.reason_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.reason_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public String getScheme() {
                Object obj = this.scheme_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.scheme_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public ByteString getSchemeBytes() {
                Object obj = this.scheme_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.scheme_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public long getSize() {
                return this.size_;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public Timestamp getTime() {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Timestamp timestamp = this.time_;
                    return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Timestamp.Builder getTimeBuilder() {
                onChanged();
                return getTimeFieldBuilder().getBuilder();
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public TimestampOrBuilder getTimeOrBuilder() {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timeBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Timestamp timestamp = this.time_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public boolean hasAuth() {
                return (this.authBuilder_ == null && this.auth_ == null) ? false : true;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public boolean hasTime() {
                return (this.timeBuilder_ == null && this.time_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return r8.a.f53312l.ensureFieldAccessorsInitialized(Request.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public MapField internalGetMapField(int i10) {
                if (i10 == 3) {
                    return internalGetHeaders();
                }
                throw new RuntimeException("Invalid map field number: " + i10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public MapField internalGetMutableMapField(int i10) {
                if (i10 == 3) {
                    return internalGetMutableHeaders();
                }
                throw new RuntimeException("Invalid map field number: " + i10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeAuth(Auth auth) {
                SingleFieldBuilderV3<Auth, Auth.Builder, AuthOrBuilder> singleFieldBuilderV3 = this.authBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Auth auth2 = this.auth_;
                    if (auth2 != null) {
                        this.auth_ = Auth.newBuilder(auth2).mergeFrom(auth).buildPartial();
                    } else {
                        this.auth_ = auth;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(auth);
                }
                return this;
            }

            public Builder mergeTime(Timestamp timestamp) {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Timestamp timestamp2 = this.time_;
                    if (timestamp2 != null) {
                        this.time_ = Timestamp.newBuilder(timestamp2).mergeFrom(timestamp).buildPartial();
                    } else {
                        this.time_ = timestamp;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(timestamp);
                }
                return this;
            }

            public Builder putAllHeaders(Map<String, String> map) {
                internalGetMutableHeaders().getMutableMap().putAll(map);
                return this;
            }

            public Builder putHeaders(String str, String str2) {
                Objects.requireNonNull(str, "map key");
                Objects.requireNonNull(str2, "map value");
                internalGetMutableHeaders().getMutableMap().put(str, str2);
                return this;
            }

            public Builder removeHeaders(String str) {
                Objects.requireNonNull(str, "map key");
                internalGetMutableHeaders().getMutableMap().remove(str);
                return this;
            }

            public Builder setAuth(Auth auth) {
                SingleFieldBuilderV3<Auth, Auth.Builder, AuthOrBuilder> singleFieldBuilderV3 = this.authBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Objects.requireNonNull(auth);
                    this.auth_ = auth;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(auth);
                }
                return this;
            }

            public Builder setHost(String str) {
                Objects.requireNonNull(str);
                this.host_ = str;
                onChanged();
                return this;
            }

            public Builder setHostBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.host_ = byteString;
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

            public Builder setMethod(String str) {
                Objects.requireNonNull(str);
                this.method_ = str;
                onChanged();
                return this;
            }

            public Builder setMethodBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.method_ = byteString;
                onChanged();
                return this;
            }

            public Builder setPath(String str) {
                Objects.requireNonNull(str);
                this.path_ = str;
                onChanged();
                return this;
            }

            public Builder setPathBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.path_ = byteString;
                onChanged();
                return this;
            }

            public Builder setProtocol(String str) {
                Objects.requireNonNull(str);
                this.protocol_ = str;
                onChanged();
                return this;
            }

            public Builder setProtocolBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.protocol_ = byteString;
                onChanged();
                return this;
            }

            public Builder setQuery(String str) {
                Objects.requireNonNull(str);
                this.query_ = str;
                onChanged();
                return this;
            }

            public Builder setQueryBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.query_ = byteString;
                onChanged();
                return this;
            }

            public Builder setReason(String str) {
                Objects.requireNonNull(str);
                this.reason_ = str;
                onChanged();
                return this;
            }

            public Builder setReasonBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.reason_ = byteString;
                onChanged();
                return this;
            }

            public Builder setScheme(String str) {
                Objects.requireNonNull(str);
                this.scheme_ = str;
                onChanged();
                return this;
            }

            public Builder setSchemeBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.scheme_ = byteString;
                onChanged();
                return this;
            }

            public Builder setSize(long j10) {
                this.size_ = j10;
                onChanged();
                return this;
            }

            public Builder setTime(Timestamp timestamp) {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Objects.requireNonNull(timestamp);
                    this.time_ = timestamp;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(timestamp);
                }
                return this;
            }

            public /* synthetic */ Builder(a aVar) {
                this();
            }

            private Builder() {
                this.id_ = "";
                this.method_ = "";
                this.path_ = "";
                this.host_ = "";
                this.scheme_ = "";
                this.query_ = "";
                this.protocol_ = "";
                this.reason_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Request build() {
                Request buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Request buildPartial() {
                Request request = new Request(this, (a) null);
                request.id_ = this.id_;
                request.method_ = this.method_;
                request.headers_ = internalGetHeaders();
                request.headers_.makeImmutable();
                request.path_ = this.path_;
                request.host_ = this.host_;
                request.scheme_ = this.scheme_;
                request.query_ = this.query_;
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    request.time_ = this.time_;
                } else {
                    request.time_ = singleFieldBuilderV3.build();
                }
                request.size_ = this.size_;
                request.protocol_ = this.protocol_;
                request.reason_ = this.reason_;
                SingleFieldBuilderV3<Auth, Auth.Builder, AuthOrBuilder> singleFieldBuilderV32 = this.authBuilder_;
                if (singleFieldBuilderV32 == null) {
                    request.auth_ = this.auth_;
                } else {
                    request.auth_ = singleFieldBuilderV32.build();
                }
                onBuilt();
                return request;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Request getDefaultInstanceForType() {
                return Request.getDefaultInstance();
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
                this.id_ = "";
                this.method_ = "";
                internalGetMutableHeaders().clear();
                this.path_ = "";
                this.host_ = "";
                this.scheme_ = "";
                this.query_ = "";
                if (this.timeBuilder_ == null) {
                    this.time_ = null;
                } else {
                    this.time_ = null;
                    this.timeBuilder_ = null;
                }
                this.size_ = 0L;
                this.protocol_ = "";
                this.reason_ = "";
                if (this.authBuilder_ == null) {
                    this.auth_ = null;
                } else {
                    this.auth_ = null;
                    this.authBuilder_ = null;
                }
                return this;
            }

            public Builder setAuth(Auth.Builder builder) {
                SingleFieldBuilderV3<Auth, Auth.Builder, AuthOrBuilder> singleFieldBuilderV3 = this.authBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.auth_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder setTime(Timestamp.Builder builder) {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.time_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Request) {
                    return mergeFrom((Request) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Request request) {
                if (request == Request.getDefaultInstance()) {
                    return this;
                }
                if (!request.getId().isEmpty()) {
                    this.id_ = request.id_;
                    onChanged();
                }
                if (!request.getMethod().isEmpty()) {
                    this.method_ = request.method_;
                    onChanged();
                }
                internalGetMutableHeaders().mergeFrom(request.internalGetHeaders());
                if (!request.getPath().isEmpty()) {
                    this.path_ = request.path_;
                    onChanged();
                }
                if (!request.getHost().isEmpty()) {
                    this.host_ = request.host_;
                    onChanged();
                }
                if (!request.getScheme().isEmpty()) {
                    this.scheme_ = request.scheme_;
                    onChanged();
                }
                if (!request.getQuery().isEmpty()) {
                    this.query_ = request.query_;
                    onChanged();
                }
                if (request.hasTime()) {
                    mergeTime(request.getTime());
                }
                if (request.getSize() != 0) {
                    setSize(request.getSize());
                }
                if (!request.getProtocol().isEmpty()) {
                    this.protocol_ = request.protocol_;
                    onChanged();
                }
                if (!request.getReason().isEmpty()) {
                    this.reason_ = request.reason_;
                    onChanged();
                }
                if (request.hasAuth()) {
                    mergeAuth(request.getAuth());
                }
                mergeUnknownFields(request.unknownFields);
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.id_ = "";
                this.method_ = "";
                this.path_ = "";
                this.host_ = "";
                this.scheme_ = "";
                this.query_ = "";
                this.protocol_ = "";
                this.reason_ = "";
                maybeForceBuilderInitialization();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.google.rpc.context.AttributeContext.Request.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.google.rpc.context.AttributeContext.Request.access$6500()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.google.rpc.context.AttributeContext$Request r3 = (com.google.rpc.context.AttributeContext.Request) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.google.rpc.context.AttributeContext$Request r4 = (com.google.rpc.context.AttributeContext.Request) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.google.rpc.context.AttributeContext.Request.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.rpc.context.AttributeContext$Request$Builder");
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class a extends AbstractParser<Request> {
            @Override // com.google.protobuf.Parser
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Request parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Request(codedInputStream, extensionRegistryLite, null);
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class b {

            /* renamed from: a, reason: collision with root package name */
            public static final MapEntry<String, String> f27106a;

            static {
                Descriptors.Descriptor descriptor = r8.a.f53313m;
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                f27106a = MapEntry.newDefaultInstance(descriptor, fieldType, "", fieldType, "");
            }
        }

        public /* synthetic */ Request(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static Request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return r8.a.f53311k;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MapField<String, String> internalGetHeaders() {
            MapField<String, String> mapField = this.headers_;
            return mapField == null ? MapField.emptyMapField(b.f27106a) : mapField;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Request parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Request parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<Request> parser() {
            return PARSER;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public boolean containsHeaders(String str) {
            Objects.requireNonNull(str, "map key");
            return internalGetHeaders().getMap().containsKey(str);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Request)) {
                return super.equals(obj);
            }
            Request request = (Request) obj;
            if (!getId().equals(request.getId()) || !getMethod().equals(request.getMethod()) || !internalGetHeaders().equals(request.internalGetHeaders()) || !getPath().equals(request.getPath()) || !getHost().equals(request.getHost()) || !getScheme().equals(request.getScheme()) || !getQuery().equals(request.getQuery()) || hasTime() != request.hasTime()) {
                return false;
            }
            if ((!hasTime() || getTime().equals(request.getTime())) && getSize() == request.getSize() && getProtocol().equals(request.getProtocol()) && getReason().equals(request.getReason()) && hasAuth() == request.hasAuth()) {
                return (!hasAuth() || getAuth().equals(request.getAuth())) && this.unknownFields.equals(request.unknownFields);
            }
            return false;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public Auth getAuth() {
            Auth auth = this.auth_;
            return auth == null ? Auth.getDefaultInstance() : auth;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public AuthOrBuilder getAuthOrBuilder() {
            return getAuth();
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        @Deprecated
        public Map<String, String> getHeaders() {
            return getHeadersMap();
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public int getHeadersCount() {
            return internalGetHeaders().getMap().size();
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public Map<String, String> getHeadersMap() {
            return internalGetHeaders().getMap();
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public String getHeadersOrDefault(String str, String str2) {
            Objects.requireNonNull(str, "map key");
            Map<String, String> map = internalGetHeaders().getMap();
            return map.containsKey(str) ? map.get(str) : str2;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public String getHeadersOrThrow(String str) {
            Objects.requireNonNull(str, "map key");
            Map<String, String> map = internalGetHeaders().getMap();
            if (map.containsKey(str)) {
                return map.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public String getHost() {
            Object obj = this.host_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.host_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public ByteString getHostBytes() {
            Object obj = this.host_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.host_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public String getId() {
            Object obj = this.id_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.id_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public ByteString getIdBytes() {
            Object obj = this.id_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.id_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public String getMethod() {
            Object obj = this.method_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.method_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public ByteString getMethodBytes() {
            Object obj = this.method_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.method_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Request> getParserForType() {
            return PARSER;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public String getPath() {
            Object obj = this.path_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.path_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public ByteString getPathBytes() {
            Object obj = this.path_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.path_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public String getProtocol() {
            Object obj = this.protocol_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.protocol_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public ByteString getProtocolBytes() {
            Object obj = this.protocol_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.protocol_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public String getQuery() {
            Object obj = this.query_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.query_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public ByteString getQueryBytes() {
            Object obj = this.query_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.query_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public String getReason() {
            Object obj = this.reason_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.reason_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public ByteString getReasonBytes() {
            Object obj = this.reason_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.reason_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public String getScheme() {
            Object obj = this.scheme_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.scheme_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public ByteString getSchemeBytes() {
            Object obj = this.scheme_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.scheme_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeStringSize = GeneratedMessageV3.isStringEmpty(this.id_) ? 0 : 0 + GeneratedMessageV3.computeStringSize(1, this.id_);
            if (!GeneratedMessageV3.isStringEmpty(this.method_)) {
                computeStringSize += GeneratedMessageV3.computeStringSize(2, this.method_);
            }
            for (Map.Entry<String, String> entry : internalGetHeaders().getMap().entrySet()) {
                computeStringSize += CodedOutputStream.computeMessageSize(3, b.f27106a.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (!GeneratedMessageV3.isStringEmpty(this.path_)) {
                computeStringSize += GeneratedMessageV3.computeStringSize(4, this.path_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.host_)) {
                computeStringSize += GeneratedMessageV3.computeStringSize(5, this.host_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.scheme_)) {
                computeStringSize += GeneratedMessageV3.computeStringSize(6, this.scheme_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.query_)) {
                computeStringSize += GeneratedMessageV3.computeStringSize(7, this.query_);
            }
            if (this.time_ != null) {
                computeStringSize += CodedOutputStream.computeMessageSize(9, getTime());
            }
            long j10 = this.size_;
            if (j10 != 0) {
                computeStringSize += CodedOutputStream.computeInt64Size(10, j10);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.protocol_)) {
                computeStringSize += GeneratedMessageV3.computeStringSize(11, this.protocol_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.reason_)) {
                computeStringSize += GeneratedMessageV3.computeStringSize(12, this.reason_);
            }
            if (this.auth_ != null) {
                computeStringSize += CodedOutputStream.computeMessageSize(13, getAuth());
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public long getSize() {
            return this.size_;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public Timestamp getTime() {
            Timestamp timestamp = this.time_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public TimestampOrBuilder getTimeOrBuilder() {
            return getTime();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public boolean hasAuth() {
            return this.auth_ != null;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public boolean hasTime() {
            return this.time_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getId().hashCode()) * 37) + 2) * 53) + getMethod().hashCode();
            if (!internalGetHeaders().getMap().isEmpty()) {
                hashCode = (((hashCode * 37) + 3) * 53) + internalGetHeaders().hashCode();
            }
            int hashCode2 = (((((((((((((((hashCode * 37) + 4) * 53) + getPath().hashCode()) * 37) + 5) * 53) + getHost().hashCode()) * 37) + 6) * 53) + getScheme().hashCode()) * 37) + 7) * 53) + getQuery().hashCode();
            if (hasTime()) {
                hashCode2 = (((hashCode2 * 37) + 9) * 53) + getTime().hashCode();
            }
            int hashLong = (((((((((((hashCode2 * 37) + 10) * 53) + Internal.hashLong(getSize())) * 37) + 11) * 53) + getProtocol().hashCode()) * 37) + 12) * 53) + getReason().hashCode();
            if (hasAuth()) {
                hashLong = (((hashLong * 37) + 13) * 53) + getAuth().hashCode();
            }
            int hashCode3 = (hashLong * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode3;
            return hashCode3;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return r8.a.f53312l.ensureFieldAccessorsInitialized(Request.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public MapField internalGetMapField(int i10) {
            if (i10 == 3) {
                return internalGetHeaders();
            }
            throw new RuntimeException("Invalid map field number: " + i10);
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
            return new Request();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!GeneratedMessageV3.isStringEmpty(this.id_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.id_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.method_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.method_);
            }
            GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetHeaders(), b.f27106a, 3);
            if (!GeneratedMessageV3.isStringEmpty(this.path_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 4, this.path_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.host_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.host_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.scheme_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 6, this.scheme_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.query_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.query_);
            }
            if (this.time_ != null) {
                codedOutputStream.writeMessage(9, getTime());
            }
            long j10 = this.size_;
            if (j10 != 0) {
                codedOutputStream.writeInt64(10, j10);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.protocol_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 11, this.protocol_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.reason_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 12, this.reason_);
            }
            if (this.auth_ != null) {
                codedOutputStream.writeMessage(13, getAuth());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public /* synthetic */ Request(GeneratedMessageV3.Builder builder, a aVar) {
            this(builder);
        }

        public static Builder newBuilder(Request request) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(request);
        }

        public static Request parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Request parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private Request(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Request parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Request getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            a aVar = null;
            return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
        }

        public static Request parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private Request() {
            this.memoizedIsInitialized = (byte) -1;
            this.id_ = "";
            this.method_ = "";
            this.path_ = "";
            this.host_ = "";
            this.scheme_ = "";
            this.query_ = "";
            this.protocol_ = "";
            this.reason_ = "";
        }

        public static Request parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static Request parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Request parseFrom(InputStream inputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Request parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Request parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Request parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0014. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        private Request(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            Objects.requireNonNull(extensionRegistryLite);
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z10 = false;
            boolean z11 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z10 = true;
                                case 10:
                                    this.id_ = codedInputStream.readStringRequireUtf8();
                                case 18:
                                    this.method_ = codedInputStream.readStringRequireUtf8();
                                case 26:
                                    if (!(z11 & true)) {
                                        this.headers_ = MapField.newMapField(b.f27106a);
                                        z11 |= true;
                                    }
                                    MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(b.f27106a.getParserForType(), extensionRegistryLite);
                                    this.headers_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
                                case 34:
                                    this.path_ = codedInputStream.readStringRequireUtf8();
                                case 42:
                                    this.host_ = codedInputStream.readStringRequireUtf8();
                                case 50:
                                    this.scheme_ = codedInputStream.readStringRequireUtf8();
                                case 58:
                                    this.query_ = codedInputStream.readStringRequireUtf8();
                                case 74:
                                    Timestamp timestamp = this.time_;
                                    Timestamp.Builder builder = timestamp != null ? timestamp.toBuilder() : null;
                                    Timestamp timestamp2 = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                    this.time_ = timestamp2;
                                    if (builder != null) {
                                        builder.mergeFrom(timestamp2);
                                        this.time_ = builder.buildPartial();
                                    }
                                case 80:
                                    this.size_ = codedInputStream.readInt64();
                                case 90:
                                    this.protocol_ = codedInputStream.readStringRequireUtf8();
                                case 98:
                                    this.reason_ = codedInputStream.readStringRequireUtf8();
                                case 106:
                                    Auth auth = this.auth_;
                                    Auth.Builder builder2 = auth != null ? auth.toBuilder() : null;
                                    Auth auth2 = (Auth) codedInputStream.readMessage(Auth.parser(), extensionRegistryLite);
                                    this.auth_ = auth2;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(auth2);
                                        this.auth_ = builder2.buildPartial();
                                    }
                                default:
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                        z10 = true;
                                    }
                            }
                        } catch (UninitializedMessageException e2) {
                            throw e2.asInvalidProtocolBufferException().setUnfinishedMessage(this);
                        } catch (IOException e10) {
                            throw new InvalidProtocolBufferException(e10).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e11) {
                        throw e11.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface RequestOrBuilder extends MessageOrBuilder {
        boolean containsHeaders(String str);

        Auth getAuth();

        AuthOrBuilder getAuthOrBuilder();

        @Deprecated
        Map<String, String> getHeaders();

        int getHeadersCount();

        Map<String, String> getHeadersMap();

        String getHeadersOrDefault(String str, String str2);

        String getHeadersOrThrow(String str);

        String getHost();

        ByteString getHostBytes();

        String getId();

        ByteString getIdBytes();

        String getMethod();

        ByteString getMethodBytes();

        String getPath();

        ByteString getPathBytes();

        String getProtocol();

        ByteString getProtocolBytes();

        String getQuery();

        ByteString getQueryBytes();

        String getReason();

        ByteString getReasonBytes();

        String getScheme();

        ByteString getSchemeBytes();

        long getSize();

        Timestamp getTime();

        TimestampOrBuilder getTimeOrBuilder();

        boolean hasAuth();

        boolean hasTime();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Resource extends GeneratedMessageV3 implements ResourceOrBuilder {
        public static final int ANNOTATIONS_FIELD_NUMBER = 6;
        public static final int CREATE_TIME_FIELD_NUMBER = 8;
        public static final int DELETE_TIME_FIELD_NUMBER = 10;
        public static final int DISPLAY_NAME_FIELD_NUMBER = 7;
        public static final int ETAG_FIELD_NUMBER = 11;
        public static final int LABELS_FIELD_NUMBER = 4;
        public static final int LOCATION_FIELD_NUMBER = 12;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int SERVICE_FIELD_NUMBER = 1;
        public static final int TYPE_FIELD_NUMBER = 3;
        public static final int UID_FIELD_NUMBER = 5;
        public static final int UPDATE_TIME_FIELD_NUMBER = 9;
        private static final long serialVersionUID = 0;
        private MapField<String, String> annotations_;
        private Timestamp createTime_;
        private Timestamp deleteTime_;
        private volatile Object displayName_;
        private volatile Object etag_;
        private MapField<String, String> labels_;
        private volatile Object location_;
        private byte memoizedIsInitialized;
        private volatile Object name_;
        private volatile Object service_;
        private volatile Object type_;
        private volatile Object uid_;
        private Timestamp updateTime_;
        private static final Resource DEFAULT_INSTANCE = new Resource();
        private static final Parser<Resource> PARSER = new a();

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResourceOrBuilder {
            private MapField<String, String> annotations_;
            private int bitField0_;
            private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> createTimeBuilder_;
            private Timestamp createTime_;
            private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> deleteTimeBuilder_;
            private Timestamp deleteTime_;
            private Object displayName_;
            private Object etag_;
            private MapField<String, String> labels_;
            private Object location_;
            private Object name_;
            private Object service_;
            private Object type_;
            private Object uid_;
            private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> updateTimeBuilder_;
            private Timestamp updateTime_;

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
                this(builderParent);
            }

            private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> getCreateTimeFieldBuilder() {
                if (this.createTimeBuilder_ == null) {
                    this.createTimeBuilder_ = new SingleFieldBuilderV3<>(getCreateTime(), getParentForChildren(), isClean());
                    this.createTime_ = null;
                }
                return this.createTimeBuilder_;
            }

            private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> getDeleteTimeFieldBuilder() {
                if (this.deleteTimeBuilder_ == null) {
                    this.deleteTimeBuilder_ = new SingleFieldBuilderV3<>(getDeleteTime(), getParentForChildren(), isClean());
                    this.deleteTime_ = null;
                }
                return this.deleteTimeBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return r8.a.f53319s;
            }

            private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> getUpdateTimeFieldBuilder() {
                if (this.updateTimeBuilder_ == null) {
                    this.updateTimeBuilder_ = new SingleFieldBuilderV3<>(getUpdateTime(), getParentForChildren(), isClean());
                    this.updateTime_ = null;
                }
                return this.updateTimeBuilder_;
            }

            private MapField<String, String> internalGetAnnotations() {
                MapField<String, String> mapField = this.annotations_;
                return mapField == null ? MapField.emptyMapField(b.f27107a) : mapField;
            }

            private MapField<String, String> internalGetLabels() {
                MapField<String, String> mapField = this.labels_;
                return mapField == null ? MapField.emptyMapField(c.f27108a) : mapField;
            }

            private MapField<String, String> internalGetMutableAnnotations() {
                onChanged();
                if (this.annotations_ == null) {
                    this.annotations_ = MapField.newMapField(b.f27107a);
                }
                if (!this.annotations_.isMutable()) {
                    this.annotations_ = this.annotations_.copy();
                }
                return this.annotations_;
            }

            private MapField<String, String> internalGetMutableLabels() {
                onChanged();
                if (this.labels_ == null) {
                    this.labels_ = MapField.newMapField(c.f27108a);
                }
                if (!this.labels_.isMutable()) {
                    this.labels_ = this.labels_.copy();
                }
                return this.labels_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearAnnotations() {
                internalGetMutableAnnotations().getMutableMap().clear();
                return this;
            }

            public Builder clearCreateTime() {
                if (this.createTimeBuilder_ == null) {
                    this.createTime_ = null;
                    onChanged();
                } else {
                    this.createTime_ = null;
                    this.createTimeBuilder_ = null;
                }
                return this;
            }

            public Builder clearDeleteTime() {
                if (this.deleteTimeBuilder_ == null) {
                    this.deleteTime_ = null;
                    onChanged();
                } else {
                    this.deleteTime_ = null;
                    this.deleteTimeBuilder_ = null;
                }
                return this;
            }

            public Builder clearDisplayName() {
                this.displayName_ = Resource.getDefaultInstance().getDisplayName();
                onChanged();
                return this;
            }

            public Builder clearEtag() {
                this.etag_ = Resource.getDefaultInstance().getEtag();
                onChanged();
                return this;
            }

            public Builder clearLabels() {
                internalGetMutableLabels().getMutableMap().clear();
                return this;
            }

            public Builder clearLocation() {
                this.location_ = Resource.getDefaultInstance().getLocation();
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = Resource.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder clearService() {
                this.service_ = Resource.getDefaultInstance().getService();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = Resource.getDefaultInstance().getType();
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = Resource.getDefaultInstance().getUid();
                onChanged();
                return this;
            }

            public Builder clearUpdateTime() {
                if (this.updateTimeBuilder_ == null) {
                    this.updateTime_ = null;
                    onChanged();
                } else {
                    this.updateTime_ = null;
                    this.updateTimeBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public boolean containsAnnotations(String str) {
                Objects.requireNonNull(str, "map key");
                return internalGetAnnotations().getMap().containsKey(str);
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public boolean containsLabels(String str) {
                Objects.requireNonNull(str, "map key");
                return internalGetLabels().getMap().containsKey(str);
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            @Deprecated
            public Map<String, String> getAnnotations() {
                return getAnnotationsMap();
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public int getAnnotationsCount() {
                return internalGetAnnotations().getMap().size();
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public Map<String, String> getAnnotationsMap() {
                return internalGetAnnotations().getMap();
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public String getAnnotationsOrDefault(String str, String str2) {
                Objects.requireNonNull(str, "map key");
                Map<String, String> map = internalGetAnnotations().getMap();
                return map.containsKey(str) ? map.get(str) : str2;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public String getAnnotationsOrThrow(String str) {
                Objects.requireNonNull(str, "map key");
                Map<String, String> map = internalGetAnnotations().getMap();
                if (map.containsKey(str)) {
                    return map.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public Timestamp getCreateTime() {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.createTimeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Timestamp timestamp = this.createTime_;
                    return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Timestamp.Builder getCreateTimeBuilder() {
                onChanged();
                return getCreateTimeFieldBuilder().getBuilder();
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public TimestampOrBuilder getCreateTimeOrBuilder() {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.createTimeBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Timestamp timestamp = this.createTime_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public Timestamp getDeleteTime() {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.deleteTimeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Timestamp timestamp = this.deleteTime_;
                    return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Timestamp.Builder getDeleteTimeBuilder() {
                onChanged();
                return getDeleteTimeFieldBuilder().getBuilder();
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public TimestampOrBuilder getDeleteTimeOrBuilder() {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.deleteTimeBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Timestamp timestamp = this.deleteTime_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return r8.a.f53319s;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public String getDisplayName() {
                Object obj = this.displayName_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.displayName_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public ByteString getDisplayNameBytes() {
                Object obj = this.displayName_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.displayName_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public String getEtag() {
                Object obj = this.etag_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.etag_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public ByteString getEtagBytes() {
                Object obj = this.etag_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.etag_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            @Deprecated
            public Map<String, String> getLabels() {
                return getLabelsMap();
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public int getLabelsCount() {
                return internalGetLabels().getMap().size();
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public Map<String, String> getLabelsMap() {
                return internalGetLabels().getMap();
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public String getLabelsOrDefault(String str, String str2) {
                Objects.requireNonNull(str, "map key");
                Map<String, String> map = internalGetLabels().getMap();
                return map.containsKey(str) ? map.get(str) : str2;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public String getLabelsOrThrow(String str) {
                Objects.requireNonNull(str, "map key");
                Map<String, String> map = internalGetLabels().getMap();
                if (map.containsKey(str)) {
                    return map.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public String getLocation() {
                Object obj = this.location_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.location_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public ByteString getLocationBytes() {
                Object obj = this.location_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.location_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Deprecated
            public Map<String, String> getMutableAnnotations() {
                return internalGetMutableAnnotations().getMutableMap();
            }

            @Deprecated
            public Map<String, String> getMutableLabels() {
                return internalGetMutableLabels().getMutableMap();
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public String getName() {
                Object obj = this.name_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.name_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public ByteString getNameBytes() {
                Object obj = this.name_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.name_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public String getService() {
                Object obj = this.service_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.service_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public ByteString getServiceBytes() {
                Object obj = this.service_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.service_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public String getType() {
                Object obj = this.type_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.type_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public ByteString getTypeBytes() {
                Object obj = this.type_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.type_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public String getUid() {
                Object obj = this.uid_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.uid_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public ByteString getUidBytes() {
                Object obj = this.uid_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.uid_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public Timestamp getUpdateTime() {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.updateTimeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Timestamp timestamp = this.updateTime_;
                    return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Timestamp.Builder getUpdateTimeBuilder() {
                onChanged();
                return getUpdateTimeFieldBuilder().getBuilder();
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public TimestampOrBuilder getUpdateTimeOrBuilder() {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.updateTimeBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Timestamp timestamp = this.updateTime_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public boolean hasCreateTime() {
                return (this.createTimeBuilder_ == null && this.createTime_ == null) ? false : true;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public boolean hasDeleteTime() {
                return (this.deleteTimeBuilder_ == null && this.deleteTime_ == null) ? false : true;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public boolean hasUpdateTime() {
                return (this.updateTimeBuilder_ == null && this.updateTime_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return r8.a.f53320t.ensureFieldAccessorsInitialized(Resource.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public MapField internalGetMapField(int i10) {
                if (i10 == 4) {
                    return internalGetLabels();
                }
                if (i10 == 6) {
                    return internalGetAnnotations();
                }
                throw new RuntimeException("Invalid map field number: " + i10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public MapField internalGetMutableMapField(int i10) {
                if (i10 == 4) {
                    return internalGetMutableLabels();
                }
                if (i10 == 6) {
                    return internalGetMutableAnnotations();
                }
                throw new RuntimeException("Invalid map field number: " + i10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeCreateTime(Timestamp timestamp) {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.createTimeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Timestamp timestamp2 = this.createTime_;
                    if (timestamp2 != null) {
                        this.createTime_ = Timestamp.newBuilder(timestamp2).mergeFrom(timestamp).buildPartial();
                    } else {
                        this.createTime_ = timestamp;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(timestamp);
                }
                return this;
            }

            public Builder mergeDeleteTime(Timestamp timestamp) {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.deleteTimeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Timestamp timestamp2 = this.deleteTime_;
                    if (timestamp2 != null) {
                        this.deleteTime_ = Timestamp.newBuilder(timestamp2).mergeFrom(timestamp).buildPartial();
                    } else {
                        this.deleteTime_ = timestamp;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(timestamp);
                }
                return this;
            }

            public Builder mergeUpdateTime(Timestamp timestamp) {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.updateTimeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Timestamp timestamp2 = this.updateTime_;
                    if (timestamp2 != null) {
                        this.updateTime_ = Timestamp.newBuilder(timestamp2).mergeFrom(timestamp).buildPartial();
                    } else {
                        this.updateTime_ = timestamp;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(timestamp);
                }
                return this;
            }

            public Builder putAllAnnotations(Map<String, String> map) {
                internalGetMutableAnnotations().getMutableMap().putAll(map);
                return this;
            }

            public Builder putAllLabels(Map<String, String> map) {
                internalGetMutableLabels().getMutableMap().putAll(map);
                return this;
            }

            public Builder putAnnotations(String str, String str2) {
                Objects.requireNonNull(str, "map key");
                Objects.requireNonNull(str2, "map value");
                internalGetMutableAnnotations().getMutableMap().put(str, str2);
                return this;
            }

            public Builder putLabels(String str, String str2) {
                Objects.requireNonNull(str, "map key");
                Objects.requireNonNull(str2, "map value");
                internalGetMutableLabels().getMutableMap().put(str, str2);
                return this;
            }

            public Builder removeAnnotations(String str) {
                Objects.requireNonNull(str, "map key");
                internalGetMutableAnnotations().getMutableMap().remove(str);
                return this;
            }

            public Builder removeLabels(String str) {
                Objects.requireNonNull(str, "map key");
                internalGetMutableLabels().getMutableMap().remove(str);
                return this;
            }

            public Builder setCreateTime(Timestamp timestamp) {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.createTimeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Objects.requireNonNull(timestamp);
                    this.createTime_ = timestamp;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(timestamp);
                }
                return this;
            }

            public Builder setDeleteTime(Timestamp timestamp) {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.deleteTimeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Objects.requireNonNull(timestamp);
                    this.deleteTime_ = timestamp;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(timestamp);
                }
                return this;
            }

            public Builder setDisplayName(String str) {
                Objects.requireNonNull(str);
                this.displayName_ = str;
                onChanged();
                return this;
            }

            public Builder setDisplayNameBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.displayName_ = byteString;
                onChanged();
                return this;
            }

            public Builder setEtag(String str) {
                Objects.requireNonNull(str);
                this.etag_ = str;
                onChanged();
                return this;
            }

            public Builder setEtagBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.etag_ = byteString;
                onChanged();
                return this;
            }

            public Builder setLocation(String str) {
                Objects.requireNonNull(str);
                this.location_ = str;
                onChanged();
                return this;
            }

            public Builder setLocationBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.location_ = byteString;
                onChanged();
                return this;
            }

            public Builder setName(String str) {
                Objects.requireNonNull(str);
                this.name_ = str;
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }

            public Builder setService(String str) {
                Objects.requireNonNull(str);
                this.service_ = str;
                onChanged();
                return this;
            }

            public Builder setServiceBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.service_ = byteString;
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

            public Builder setUid(String str) {
                Objects.requireNonNull(str);
                this.uid_ = str;
                onChanged();
                return this;
            }

            public Builder setUidBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.uid_ = byteString;
                onChanged();
                return this;
            }

            public Builder setUpdateTime(Timestamp timestamp) {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.updateTimeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Objects.requireNonNull(timestamp);
                    this.updateTime_ = timestamp;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(timestamp);
                }
                return this;
            }

            public /* synthetic */ Builder(a aVar) {
                this();
            }

            private Builder() {
                this.service_ = "";
                this.name_ = "";
                this.type_ = "";
                this.uid_ = "";
                this.displayName_ = "";
                this.etag_ = "";
                this.location_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Resource build() {
                Resource buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Resource buildPartial() {
                Resource resource = new Resource(this, (a) null);
                resource.service_ = this.service_;
                resource.name_ = this.name_;
                resource.type_ = this.type_;
                resource.labels_ = internalGetLabels();
                resource.labels_.makeImmutable();
                resource.uid_ = this.uid_;
                resource.annotations_ = internalGetAnnotations();
                resource.annotations_.makeImmutable();
                resource.displayName_ = this.displayName_;
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.createTimeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    resource.createTime_ = this.createTime_;
                } else {
                    resource.createTime_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV32 = this.updateTimeBuilder_;
                if (singleFieldBuilderV32 == null) {
                    resource.updateTime_ = this.updateTime_;
                } else {
                    resource.updateTime_ = singleFieldBuilderV32.build();
                }
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV33 = this.deleteTimeBuilder_;
                if (singleFieldBuilderV33 == null) {
                    resource.deleteTime_ = this.deleteTime_;
                } else {
                    resource.deleteTime_ = singleFieldBuilderV33.build();
                }
                resource.etag_ = this.etag_;
                resource.location_ = this.location_;
                onBuilt();
                return resource;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Resource getDefaultInstanceForType() {
                return Resource.getDefaultInstance();
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
                this.service_ = "";
                this.name_ = "";
                this.type_ = "";
                internalGetMutableLabels().clear();
                this.uid_ = "";
                internalGetMutableAnnotations().clear();
                this.displayName_ = "";
                if (this.createTimeBuilder_ == null) {
                    this.createTime_ = null;
                } else {
                    this.createTime_ = null;
                    this.createTimeBuilder_ = null;
                }
                if (this.updateTimeBuilder_ == null) {
                    this.updateTime_ = null;
                } else {
                    this.updateTime_ = null;
                    this.updateTimeBuilder_ = null;
                }
                if (this.deleteTimeBuilder_ == null) {
                    this.deleteTime_ = null;
                } else {
                    this.deleteTime_ = null;
                    this.deleteTimeBuilder_ = null;
                }
                this.etag_ = "";
                this.location_ = "";
                return this;
            }

            public Builder setCreateTime(Timestamp.Builder builder) {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.createTimeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.createTime_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder setDeleteTime(Timestamp.Builder builder) {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.deleteTimeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.deleteTime_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder setUpdateTime(Timestamp.Builder builder) {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.updateTimeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.updateTime_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Resource) {
                    return mergeFrom((Resource) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Resource resource) {
                if (resource == Resource.getDefaultInstance()) {
                    return this;
                }
                if (!resource.getService().isEmpty()) {
                    this.service_ = resource.service_;
                    onChanged();
                }
                if (!resource.getName().isEmpty()) {
                    this.name_ = resource.name_;
                    onChanged();
                }
                if (!resource.getType().isEmpty()) {
                    this.type_ = resource.type_;
                    onChanged();
                }
                internalGetMutableLabels().mergeFrom(resource.internalGetLabels());
                if (!resource.getUid().isEmpty()) {
                    this.uid_ = resource.uid_;
                    onChanged();
                }
                internalGetMutableAnnotations().mergeFrom(resource.internalGetAnnotations());
                if (!resource.getDisplayName().isEmpty()) {
                    this.displayName_ = resource.displayName_;
                    onChanged();
                }
                if (resource.hasCreateTime()) {
                    mergeCreateTime(resource.getCreateTime());
                }
                if (resource.hasUpdateTime()) {
                    mergeUpdateTime(resource.getUpdateTime());
                }
                if (resource.hasDeleteTime()) {
                    mergeDeleteTime(resource.getDeleteTime());
                }
                if (!resource.getEtag().isEmpty()) {
                    this.etag_ = resource.etag_;
                    onChanged();
                }
                if (!resource.getLocation().isEmpty()) {
                    this.location_ = resource.location_;
                    onChanged();
                }
                mergeUnknownFields(resource.unknownFields);
                onChanged();
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.service_ = "";
                this.name_ = "";
                this.type_ = "";
                this.uid_ = "";
                this.displayName_ = "";
                this.etag_ = "";
                this.location_ = "";
                maybeForceBuilderInitialization();
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.google.rpc.context.AttributeContext.Resource.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.google.rpc.context.AttributeContext.Resource.access$10700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.google.rpc.context.AttributeContext$Resource r3 = (com.google.rpc.context.AttributeContext.Resource) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.google.rpc.context.AttributeContext$Resource r4 = (com.google.rpc.context.AttributeContext.Resource) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.google.rpc.context.AttributeContext.Resource.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.rpc.context.AttributeContext$Resource$Builder");
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class a extends AbstractParser<Resource> {
            @Override // com.google.protobuf.Parser
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Resource parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Resource(codedInputStream, extensionRegistryLite, null);
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class b {

            /* renamed from: a, reason: collision with root package name */
            public static final MapEntry<String, String> f27107a;

            static {
                Descriptors.Descriptor descriptor = r8.a.f53323w;
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                f27107a = MapEntry.newDefaultInstance(descriptor, fieldType, "", fieldType, "");
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class c {

            /* renamed from: a, reason: collision with root package name */
            public static final MapEntry<String, String> f27108a;

            static {
                Descriptors.Descriptor descriptor = r8.a.f53321u;
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                f27108a = MapEntry.newDefaultInstance(descriptor, fieldType, "", fieldType, "");
            }
        }

        public /* synthetic */ Resource(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static Resource getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return r8.a.f53319s;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MapField<String, String> internalGetAnnotations() {
            MapField<String, String> mapField = this.annotations_;
            return mapField == null ? MapField.emptyMapField(b.f27107a) : mapField;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MapField<String, String> internalGetLabels() {
            MapField<String, String> mapField = this.labels_;
            return mapField == null ? MapField.emptyMapField(c.f27108a) : mapField;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Resource parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Resource) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Resource parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<Resource> parser() {
            return PARSER;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public boolean containsAnnotations(String str) {
            Objects.requireNonNull(str, "map key");
            return internalGetAnnotations().getMap().containsKey(str);
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public boolean containsLabels(String str) {
            Objects.requireNonNull(str, "map key");
            return internalGetLabels().getMap().containsKey(str);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Resource)) {
                return super.equals(obj);
            }
            Resource resource = (Resource) obj;
            if (!getService().equals(resource.getService()) || !getName().equals(resource.getName()) || !getType().equals(resource.getType()) || !internalGetLabels().equals(resource.internalGetLabels()) || !getUid().equals(resource.getUid()) || !internalGetAnnotations().equals(resource.internalGetAnnotations()) || !getDisplayName().equals(resource.getDisplayName()) || hasCreateTime() != resource.hasCreateTime()) {
                return false;
            }
            if ((hasCreateTime() && !getCreateTime().equals(resource.getCreateTime())) || hasUpdateTime() != resource.hasUpdateTime()) {
                return false;
            }
            if ((!hasUpdateTime() || getUpdateTime().equals(resource.getUpdateTime())) && hasDeleteTime() == resource.hasDeleteTime()) {
                return (!hasDeleteTime() || getDeleteTime().equals(resource.getDeleteTime())) && getEtag().equals(resource.getEtag()) && getLocation().equals(resource.getLocation()) && this.unknownFields.equals(resource.unknownFields);
            }
            return false;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        @Deprecated
        public Map<String, String> getAnnotations() {
            return getAnnotationsMap();
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public int getAnnotationsCount() {
            return internalGetAnnotations().getMap().size();
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public Map<String, String> getAnnotationsMap() {
            return internalGetAnnotations().getMap();
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public String getAnnotationsOrDefault(String str, String str2) {
            Objects.requireNonNull(str, "map key");
            Map<String, String> map = internalGetAnnotations().getMap();
            return map.containsKey(str) ? map.get(str) : str2;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public String getAnnotationsOrThrow(String str) {
            Objects.requireNonNull(str, "map key");
            Map<String, String> map = internalGetAnnotations().getMap();
            if (map.containsKey(str)) {
                return map.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public Timestamp getCreateTime() {
            Timestamp timestamp = this.createTime_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public TimestampOrBuilder getCreateTimeOrBuilder() {
            return getCreateTime();
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public Timestamp getDeleteTime() {
            Timestamp timestamp = this.deleteTime_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public TimestampOrBuilder getDeleteTimeOrBuilder() {
            return getDeleteTime();
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public String getDisplayName() {
            Object obj = this.displayName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.displayName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public ByteString getDisplayNameBytes() {
            Object obj = this.displayName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.displayName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public String getEtag() {
            Object obj = this.etag_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.etag_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public ByteString getEtagBytes() {
            Object obj = this.etag_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.etag_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        @Deprecated
        public Map<String, String> getLabels() {
            return getLabelsMap();
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public int getLabelsCount() {
            return internalGetLabels().getMap().size();
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public Map<String, String> getLabelsMap() {
            return internalGetLabels().getMap();
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public String getLabelsOrDefault(String str, String str2) {
            Objects.requireNonNull(str, "map key");
            Map<String, String> map = internalGetLabels().getMap();
            return map.containsKey(str) ? map.get(str) : str2;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public String getLabelsOrThrow(String str) {
            Objects.requireNonNull(str, "map key");
            Map<String, String> map = internalGetLabels().getMap();
            if (map.containsKey(str)) {
                return map.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public String getLocation() {
            Object obj = this.location_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.location_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public ByteString getLocationBytes() {
            Object obj = this.location_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.location_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Resource> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeStringSize = GeneratedMessageV3.isStringEmpty(this.service_) ? 0 : 0 + GeneratedMessageV3.computeStringSize(1, this.service_);
            if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
                computeStringSize += GeneratedMessageV3.computeStringSize(2, this.name_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.type_)) {
                computeStringSize += GeneratedMessageV3.computeStringSize(3, this.type_);
            }
            for (Map.Entry<String, String> entry : internalGetLabels().getMap().entrySet()) {
                computeStringSize += CodedOutputStream.computeMessageSize(4, c.f27108a.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (!GeneratedMessageV3.isStringEmpty(this.uid_)) {
                computeStringSize += GeneratedMessageV3.computeStringSize(5, this.uid_);
            }
            for (Map.Entry<String, String> entry2 : internalGetAnnotations().getMap().entrySet()) {
                computeStringSize += CodedOutputStream.computeMessageSize(6, b.f27107a.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            if (!GeneratedMessageV3.isStringEmpty(this.displayName_)) {
                computeStringSize += GeneratedMessageV3.computeStringSize(7, this.displayName_);
            }
            if (this.createTime_ != null) {
                computeStringSize += CodedOutputStream.computeMessageSize(8, getCreateTime());
            }
            if (this.updateTime_ != null) {
                computeStringSize += CodedOutputStream.computeMessageSize(9, getUpdateTime());
            }
            if (this.deleteTime_ != null) {
                computeStringSize += CodedOutputStream.computeMessageSize(10, getDeleteTime());
            }
            if (!GeneratedMessageV3.isStringEmpty(this.etag_)) {
                computeStringSize += GeneratedMessageV3.computeStringSize(11, this.etag_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.location_)) {
                computeStringSize += GeneratedMessageV3.computeStringSize(12, this.location_);
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public String getService() {
            Object obj = this.service_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.service_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public ByteString getServiceBytes() {
            Object obj = this.service_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.service_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public String getType() {
            Object obj = this.type_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.type_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public ByteString getTypeBytes() {
            Object obj = this.type_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.type_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public String getUid() {
            Object obj = this.uid_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.uid_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public ByteString getUidBytes() {
            Object obj = this.uid_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.uid_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public Timestamp getUpdateTime() {
            Timestamp timestamp = this.updateTime_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public TimestampOrBuilder getUpdateTimeOrBuilder() {
            return getUpdateTime();
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public boolean hasCreateTime() {
            return this.createTime_ != null;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public boolean hasDeleteTime() {
            return this.deleteTime_ != null;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public boolean hasUpdateTime() {
            return this.updateTime_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getService().hashCode()) * 37) + 2) * 53) + getName().hashCode()) * 37) + 3) * 53) + getType().hashCode();
            if (!internalGetLabels().getMap().isEmpty()) {
                hashCode = (((hashCode * 37) + 4) * 53) + internalGetLabels().hashCode();
            }
            int hashCode2 = (((hashCode * 37) + 5) * 53) + getUid().hashCode();
            if (!internalGetAnnotations().getMap().isEmpty()) {
                hashCode2 = (((hashCode2 * 37) + 6) * 53) + internalGetAnnotations().hashCode();
            }
            int hashCode3 = (((hashCode2 * 37) + 7) * 53) + getDisplayName().hashCode();
            if (hasCreateTime()) {
                hashCode3 = (((hashCode3 * 37) + 8) * 53) + getCreateTime().hashCode();
            }
            if (hasUpdateTime()) {
                hashCode3 = (((hashCode3 * 37) + 9) * 53) + getUpdateTime().hashCode();
            }
            if (hasDeleteTime()) {
                hashCode3 = (((hashCode3 * 37) + 10) * 53) + getDeleteTime().hashCode();
            }
            int hashCode4 = (((((((((hashCode3 * 37) + 11) * 53) + getEtag().hashCode()) * 37) + 12) * 53) + getLocation().hashCode()) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode4;
            return hashCode4;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return r8.a.f53320t.ensureFieldAccessorsInitialized(Resource.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public MapField internalGetMapField(int i10) {
            if (i10 == 4) {
                return internalGetLabels();
            }
            if (i10 == 6) {
                return internalGetAnnotations();
            }
            throw new RuntimeException("Invalid map field number: " + i10);
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
            return new Resource();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!GeneratedMessageV3.isStringEmpty(this.service_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.service_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.name_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.type_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 3, this.type_);
            }
            GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetLabels(), c.f27108a, 4);
            if (!GeneratedMessageV3.isStringEmpty(this.uid_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 5, this.uid_);
            }
            GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetAnnotations(), b.f27107a, 6);
            if (!GeneratedMessageV3.isStringEmpty(this.displayName_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 7, this.displayName_);
            }
            if (this.createTime_ != null) {
                codedOutputStream.writeMessage(8, getCreateTime());
            }
            if (this.updateTime_ != null) {
                codedOutputStream.writeMessage(9, getUpdateTime());
            }
            if (this.deleteTime_ != null) {
                codedOutputStream.writeMessage(10, getDeleteTime());
            }
            if (!GeneratedMessageV3.isStringEmpty(this.etag_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 11, this.etag_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.location_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 12, this.location_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public /* synthetic */ Resource(GeneratedMessageV3.Builder builder, a aVar) {
            this(builder);
        }

        public static Builder newBuilder(Resource resource) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(resource);
        }

        public static Resource parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Resource) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Resource parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private Resource(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Resource parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Resource getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            a aVar = null;
            return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
        }

        public static Resource parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private Resource() {
            this.memoizedIsInitialized = (byte) -1;
            this.service_ = "";
            this.name_ = "";
            this.type_ = "";
            this.uid_ = "";
            this.displayName_ = "";
            this.etag_ = "";
            this.location_ = "";
        }

        public static Resource parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static Resource parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Resource parseFrom(InputStream inputStream) throws IOException {
            return (Resource) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Resource parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Resource) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Resource parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Resource) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Resource parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Resource) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0014. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        private Resource(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            Timestamp.Builder builder;
            Objects.requireNonNull(extensionRegistryLite);
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z10 = false;
            int i10 = 0;
            while (!z10) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z10 = true;
                                case 10:
                                    this.service_ = codedInputStream.readStringRequireUtf8();
                                case 18:
                                    this.name_ = codedInputStream.readStringRequireUtf8();
                                case 26:
                                    this.type_ = codedInputStream.readStringRequireUtf8();
                                case 34:
                                    if ((i10 & 1) == 0) {
                                        this.labels_ = MapField.newMapField(c.f27108a);
                                        i10 |= 1;
                                    }
                                    MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(c.f27108a.getParserForType(), extensionRegistryLite);
                                    this.labels_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
                                case 42:
                                    this.uid_ = codedInputStream.readStringRequireUtf8();
                                case 50:
                                    if ((i10 & 2) == 0) {
                                        this.annotations_ = MapField.newMapField(b.f27107a);
                                        i10 |= 2;
                                    }
                                    MapEntry mapEntry2 = (MapEntry) codedInputStream.readMessage(b.f27107a.getParserForType(), extensionRegistryLite);
                                    this.annotations_.getMutableMap().put(mapEntry2.getKey(), mapEntry2.getValue());
                                case 58:
                                    this.displayName_ = codedInputStream.readStringRequireUtf8();
                                case 66:
                                    Timestamp timestamp = this.createTime_;
                                    builder = timestamp != null ? timestamp.toBuilder() : null;
                                    Timestamp timestamp2 = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                    this.createTime_ = timestamp2;
                                    if (builder != null) {
                                        builder.mergeFrom(timestamp2);
                                        this.createTime_ = builder.buildPartial();
                                    }
                                case 74:
                                    Timestamp timestamp3 = this.updateTime_;
                                    builder = timestamp3 != null ? timestamp3.toBuilder() : null;
                                    Timestamp timestamp4 = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                    this.updateTime_ = timestamp4;
                                    if (builder != null) {
                                        builder.mergeFrom(timestamp4);
                                        this.updateTime_ = builder.buildPartial();
                                    }
                                case 82:
                                    Timestamp timestamp5 = this.deleteTime_;
                                    builder = timestamp5 != null ? timestamp5.toBuilder() : null;
                                    Timestamp timestamp6 = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                    this.deleteTime_ = timestamp6;
                                    if (builder != null) {
                                        builder.mergeFrom(timestamp6);
                                        this.deleteTime_ = builder.buildPartial();
                                    }
                                case 90:
                                    this.etag_ = codedInputStream.readStringRequireUtf8();
                                case 98:
                                    this.location_ = codedInputStream.readStringRequireUtf8();
                                default:
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                        z10 = true;
                                    }
                            }
                        } catch (UninitializedMessageException e2) {
                            throw e2.asInvalidProtocolBufferException().setUnfinishedMessage(this);
                        } catch (IOException e10) {
                            throw new InvalidProtocolBufferException(e10).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e11) {
                        throw e11.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ResourceOrBuilder extends MessageOrBuilder {
        boolean containsAnnotations(String str);

        boolean containsLabels(String str);

        @Deprecated
        Map<String, String> getAnnotations();

        int getAnnotationsCount();

        Map<String, String> getAnnotationsMap();

        String getAnnotationsOrDefault(String str, String str2);

        String getAnnotationsOrThrow(String str);

        Timestamp getCreateTime();

        TimestampOrBuilder getCreateTimeOrBuilder();

        Timestamp getDeleteTime();

        TimestampOrBuilder getDeleteTimeOrBuilder();

        String getDisplayName();

        ByteString getDisplayNameBytes();

        String getEtag();

        ByteString getEtagBytes();

        @Deprecated
        Map<String, String> getLabels();

        int getLabelsCount();

        Map<String, String> getLabelsMap();

        String getLabelsOrDefault(String str, String str2);

        String getLabelsOrThrow(String str);

        String getLocation();

        ByteString getLocationBytes();

        String getName();

        ByteString getNameBytes();

        String getService();

        ByteString getServiceBytes();

        String getType();

        ByteString getTypeBytes();

        String getUid();

        ByteString getUidBytes();

        Timestamp getUpdateTime();

        TimestampOrBuilder getUpdateTimeOrBuilder();

        boolean hasCreateTime();

        boolean hasDeleteTime();

        boolean hasUpdateTime();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Response extends GeneratedMessageV3 implements ResponseOrBuilder {
        public static final int BACKEND_LATENCY_FIELD_NUMBER = 5;
        public static final int CODE_FIELD_NUMBER = 1;
        public static final int HEADERS_FIELD_NUMBER = 3;
        public static final int SIZE_FIELD_NUMBER = 2;
        public static final int TIME_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private Duration backendLatency_;
        private long code_;
        private MapField<String, String> headers_;
        private byte memoizedIsInitialized;
        private long size_;
        private Timestamp time_;
        private static final Response DEFAULT_INSTANCE = new Response();
        private static final Parser<Response> PARSER = new a();

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResponseOrBuilder {
            private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> backendLatencyBuilder_;
            private Duration backendLatency_;
            private int bitField0_;
            private long code_;
            private MapField<String, String> headers_;
            private long size_;
            private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> timeBuilder_;
            private Timestamp time_;

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
                this(builderParent);
            }

            private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> getBackendLatencyFieldBuilder() {
                if (this.backendLatencyBuilder_ == null) {
                    this.backendLatencyBuilder_ = new SingleFieldBuilderV3<>(getBackendLatency(), getParentForChildren(), isClean());
                    this.backendLatency_ = null;
                }
                return this.backendLatencyBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return r8.a.f53315o;
            }

            private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> getTimeFieldBuilder() {
                if (this.timeBuilder_ == null) {
                    this.timeBuilder_ = new SingleFieldBuilderV3<>(getTime(), getParentForChildren(), isClean());
                    this.time_ = null;
                }
                return this.timeBuilder_;
            }

            private MapField<String, String> internalGetHeaders() {
                MapField<String, String> mapField = this.headers_;
                return mapField == null ? MapField.emptyMapField(b.f27109a) : mapField;
            }

            private MapField<String, String> internalGetMutableHeaders() {
                onChanged();
                if (this.headers_ == null) {
                    this.headers_ = MapField.newMapField(b.f27109a);
                }
                if (!this.headers_.isMutable()) {
                    this.headers_ = this.headers_.copy();
                }
                return this.headers_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearBackendLatency() {
                if (this.backendLatencyBuilder_ == null) {
                    this.backendLatency_ = null;
                    onChanged();
                } else {
                    this.backendLatency_ = null;
                    this.backendLatencyBuilder_ = null;
                }
                return this;
            }

            public Builder clearCode() {
                this.code_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearHeaders() {
                internalGetMutableHeaders().getMutableMap().clear();
                return this;
            }

            public Builder clearSize() {
                this.size_ = 0L;
                onChanged();
                return this;
            }

            public Builder clearTime() {
                if (this.timeBuilder_ == null) {
                    this.time_ = null;
                    onChanged();
                } else {
                    this.time_ = null;
                    this.timeBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public boolean containsHeaders(String str) {
                Objects.requireNonNull(str, "map key");
                return internalGetHeaders().getMap().containsKey(str);
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public Duration getBackendLatency() {
                SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.backendLatencyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Duration duration = this.backendLatency_;
                    return duration == null ? Duration.getDefaultInstance() : duration;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Duration.Builder getBackendLatencyBuilder() {
                onChanged();
                return getBackendLatencyFieldBuilder().getBuilder();
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public DurationOrBuilder getBackendLatencyOrBuilder() {
                SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.backendLatencyBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Duration duration = this.backendLatency_;
                return duration == null ? Duration.getDefaultInstance() : duration;
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public long getCode() {
                return this.code_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return r8.a.f53315o;
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            @Deprecated
            public Map<String, String> getHeaders() {
                return getHeadersMap();
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public int getHeadersCount() {
                return internalGetHeaders().getMap().size();
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public Map<String, String> getHeadersMap() {
                return internalGetHeaders().getMap();
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public String getHeadersOrDefault(String str, String str2) {
                Objects.requireNonNull(str, "map key");
                Map<String, String> map = internalGetHeaders().getMap();
                return map.containsKey(str) ? map.get(str) : str2;
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public String getHeadersOrThrow(String str) {
                Objects.requireNonNull(str, "map key");
                Map<String, String> map = internalGetHeaders().getMap();
                if (map.containsKey(str)) {
                    return map.get(str);
                }
                throw new IllegalArgumentException();
            }

            @Deprecated
            public Map<String, String> getMutableHeaders() {
                return internalGetMutableHeaders().getMutableMap();
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public long getSize() {
                return this.size_;
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public Timestamp getTime() {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Timestamp timestamp = this.time_;
                    return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Timestamp.Builder getTimeBuilder() {
                onChanged();
                return getTimeFieldBuilder().getBuilder();
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public TimestampOrBuilder getTimeOrBuilder() {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timeBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Timestamp timestamp = this.time_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public boolean hasBackendLatency() {
                return (this.backendLatencyBuilder_ == null && this.backendLatency_ == null) ? false : true;
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public boolean hasTime() {
                return (this.timeBuilder_ == null && this.time_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return r8.a.f53316p.ensureFieldAccessorsInitialized(Response.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public MapField internalGetMapField(int i10) {
                if (i10 == 3) {
                    return internalGetHeaders();
                }
                throw new RuntimeException("Invalid map field number: " + i10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public MapField internalGetMutableMapField(int i10) {
                if (i10 == 3) {
                    return internalGetMutableHeaders();
                }
                throw new RuntimeException("Invalid map field number: " + i10);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeBackendLatency(Duration duration) {
                SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.backendLatencyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Duration duration2 = this.backendLatency_;
                    if (duration2 != null) {
                        this.backendLatency_ = Duration.newBuilder(duration2).mergeFrom(duration).buildPartial();
                    } else {
                        this.backendLatency_ = duration;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(duration);
                }
                return this;
            }

            public Builder mergeTime(Timestamp timestamp) {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Timestamp timestamp2 = this.time_;
                    if (timestamp2 != null) {
                        this.time_ = Timestamp.newBuilder(timestamp2).mergeFrom(timestamp).buildPartial();
                    } else {
                        this.time_ = timestamp;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(timestamp);
                }
                return this;
            }

            public Builder putAllHeaders(Map<String, String> map) {
                internalGetMutableHeaders().getMutableMap().putAll(map);
                return this;
            }

            public Builder putHeaders(String str, String str2) {
                Objects.requireNonNull(str, "map key");
                Objects.requireNonNull(str2, "map value");
                internalGetMutableHeaders().getMutableMap().put(str, str2);
                return this;
            }

            public Builder removeHeaders(String str) {
                Objects.requireNonNull(str, "map key");
                internalGetMutableHeaders().getMutableMap().remove(str);
                return this;
            }

            public Builder setBackendLatency(Duration duration) {
                SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.backendLatencyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Objects.requireNonNull(duration);
                    this.backendLatency_ = duration;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(duration);
                }
                return this;
            }

            public Builder setCode(long j10) {
                this.code_ = j10;
                onChanged();
                return this;
            }

            public Builder setSize(long j10) {
                this.size_ = j10;
                onChanged();
                return this;
            }

            public Builder setTime(Timestamp timestamp) {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Objects.requireNonNull(timestamp);
                    this.time_ = timestamp;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(timestamp);
                }
                return this;
            }

            public /* synthetic */ Builder(a aVar) {
                this();
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Response build() {
                Response buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Response buildPartial() {
                Response response = new Response(this, (a) null);
                response.code_ = this.code_;
                response.size_ = this.size_;
                response.headers_ = internalGetHeaders();
                response.headers_.makeImmutable();
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    response.time_ = this.time_;
                } else {
                    response.time_ = singleFieldBuilderV3.build();
                }
                SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV32 = this.backendLatencyBuilder_;
                if (singleFieldBuilderV32 == null) {
                    response.backendLatency_ = this.backendLatency_;
                } else {
                    response.backendLatency_ = singleFieldBuilderV32.build();
                }
                onBuilt();
                return response;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Response getDefaultInstanceForType() {
                return Response.getDefaultInstance();
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

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.code_ = 0L;
                this.size_ = 0L;
                internalGetMutableHeaders().clear();
                if (this.timeBuilder_ == null) {
                    this.time_ = null;
                } else {
                    this.time_ = null;
                    this.timeBuilder_ = null;
                }
                if (this.backendLatencyBuilder_ == null) {
                    this.backendLatency_ = null;
                } else {
                    this.backendLatency_ = null;
                    this.backendLatencyBuilder_ = null;
                }
                return this;
            }

            public Builder setBackendLatency(Duration.Builder builder) {
                SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.backendLatencyBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.backendLatency_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder setTime(Timestamp.Builder builder) {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timeBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.time_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Response) {
                    return mergeFrom((Response) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Response response) {
                if (response == Response.getDefaultInstance()) {
                    return this;
                }
                if (response.getCode() != 0) {
                    setCode(response.getCode());
                }
                if (response.getSize() != 0) {
                    setSize(response.getSize());
                }
                internalGetMutableHeaders().mergeFrom(response.internalGetHeaders());
                if (response.hasTime()) {
                    mergeTime(response.getTime());
                }
                if (response.hasBackendLatency()) {
                    mergeBackendLatency(response.getBackendLatency());
                }
                mergeUnknownFields(response.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.google.rpc.context.AttributeContext.Response.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.google.rpc.context.AttributeContext.Response.access$8600()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.google.rpc.context.AttributeContext$Response r3 = (com.google.rpc.context.AttributeContext.Response) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.google.rpc.context.AttributeContext$Response r4 = (com.google.rpc.context.AttributeContext.Response) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.google.rpc.context.AttributeContext.Response.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.rpc.context.AttributeContext$Response$Builder");
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class a extends AbstractParser<Response> {
            @Override // com.google.protobuf.Parser
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Response parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Response(codedInputStream, extensionRegistryLite, null);
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class b {

            /* renamed from: a, reason: collision with root package name */
            public static final MapEntry<String, String> f27109a;

            static {
                Descriptors.Descriptor descriptor = r8.a.f53317q;
                WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
                f27109a = MapEntry.newDefaultInstance(descriptor, fieldType, "", fieldType, "");
            }
        }

        public /* synthetic */ Response(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static Response getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return r8.a.f53315o;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MapField<String, String> internalGetHeaders() {
            MapField<String, String> mapField = this.headers_;
            return mapField == null ? MapField.emptyMapField(b.f27109a) : mapField;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Response parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Response parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<Response> parser() {
            return PARSER;
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public boolean containsHeaders(String str) {
            Objects.requireNonNull(str, "map key");
            return internalGetHeaders().getMap().containsKey(str);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Response)) {
                return super.equals(obj);
            }
            Response response = (Response) obj;
            if (getCode() != response.getCode() || getSize() != response.getSize() || !internalGetHeaders().equals(response.internalGetHeaders()) || hasTime() != response.hasTime()) {
                return false;
            }
            if ((!hasTime() || getTime().equals(response.getTime())) && hasBackendLatency() == response.hasBackendLatency()) {
                return (!hasBackendLatency() || getBackendLatency().equals(response.getBackendLatency())) && this.unknownFields.equals(response.unknownFields);
            }
            return false;
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public Duration getBackendLatency() {
            Duration duration = this.backendLatency_;
            return duration == null ? Duration.getDefaultInstance() : duration;
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public DurationOrBuilder getBackendLatencyOrBuilder() {
            return getBackendLatency();
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public long getCode() {
            return this.code_;
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        @Deprecated
        public Map<String, String> getHeaders() {
            return getHeadersMap();
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public int getHeadersCount() {
            return internalGetHeaders().getMap().size();
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public Map<String, String> getHeadersMap() {
            return internalGetHeaders().getMap();
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public String getHeadersOrDefault(String str, String str2) {
            Objects.requireNonNull(str, "map key");
            Map<String, String> map = internalGetHeaders().getMap();
            return map.containsKey(str) ? map.get(str) : str2;
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public String getHeadersOrThrow(String str) {
            Objects.requireNonNull(str, "map key");
            Map<String, String> map = internalGetHeaders().getMap();
            if (map.containsKey(str)) {
                return map.get(str);
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Response> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            long j10 = this.code_;
            int computeInt64Size = j10 != 0 ? 0 + CodedOutputStream.computeInt64Size(1, j10) : 0;
            long j11 = this.size_;
            if (j11 != 0) {
                computeInt64Size += CodedOutputStream.computeInt64Size(2, j11);
            }
            for (Map.Entry<String, String> entry : internalGetHeaders().getMap().entrySet()) {
                computeInt64Size += CodedOutputStream.computeMessageSize(3, b.f27109a.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.time_ != null) {
                computeInt64Size += CodedOutputStream.computeMessageSize(4, getTime());
            }
            if (this.backendLatency_ != null) {
                computeInt64Size += CodedOutputStream.computeMessageSize(5, getBackendLatency());
            }
            int serializedSize = computeInt64Size + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public long getSize() {
            return this.size_;
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public Timestamp getTime() {
            Timestamp timestamp = this.time_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public TimestampOrBuilder getTimeOrBuilder() {
            return getTime();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public boolean hasBackendLatency() {
            return this.backendLatency_ != null;
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public boolean hasTime() {
            return this.time_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getCode())) * 37) + 2) * 53) + Internal.hashLong(getSize());
            if (!internalGetHeaders().getMap().isEmpty()) {
                hashCode = (((hashCode * 37) + 3) * 53) + internalGetHeaders().hashCode();
            }
            if (hasTime()) {
                hashCode = (((hashCode * 37) + 4) * 53) + getTime().hashCode();
            }
            if (hasBackendLatency()) {
                hashCode = (((hashCode * 37) + 5) * 53) + getBackendLatency().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return r8.a.f53316p.ensureFieldAccessorsInitialized(Response.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public MapField internalGetMapField(int i10) {
            if (i10 == 3) {
                return internalGetHeaders();
            }
            throw new RuntimeException("Invalid map field number: " + i10);
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
            return new Response();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            long j10 = this.code_;
            if (j10 != 0) {
                codedOutputStream.writeInt64(1, j10);
            }
            long j11 = this.size_;
            if (j11 != 0) {
                codedOutputStream.writeInt64(2, j11);
            }
            GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetHeaders(), b.f27109a, 3);
            if (this.time_ != null) {
                codedOutputStream.writeMessage(4, getTime());
            }
            if (this.backendLatency_ != null) {
                codedOutputStream.writeMessage(5, getBackendLatency());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public /* synthetic */ Response(GeneratedMessageV3.Builder builder, a aVar) {
            this(builder);
        }

        public static Builder newBuilder(Response response) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(response);
        }

        public static Response parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Response parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private Response(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Response parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Response getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            a aVar = null;
            return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
        }

        public static Response parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private Response() {
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Response parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static Response parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Response(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            Objects.requireNonNull(extensionRegistryLite);
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z10 = false;
            boolean z11 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.code_ = codedInputStream.readInt64();
                                } else if (readTag == 16) {
                                    this.size_ = codedInputStream.readInt64();
                                } else if (readTag != 26) {
                                    if (readTag == 34) {
                                        Timestamp timestamp = this.time_;
                                        Timestamp.Builder builder = timestamp != null ? timestamp.toBuilder() : null;
                                        Timestamp timestamp2 = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                        this.time_ = timestamp2;
                                        if (builder != null) {
                                            builder.mergeFrom(timestamp2);
                                            this.time_ = builder.buildPartial();
                                        }
                                    } else if (readTag != 42) {
                                        if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                        }
                                    } else {
                                        Duration duration = this.backendLatency_;
                                        Duration.Builder builder2 = duration != null ? duration.toBuilder() : null;
                                        Duration duration2 = (Duration) codedInputStream.readMessage(Duration.parser(), extensionRegistryLite);
                                        this.backendLatency_ = duration2;
                                        if (builder2 != null) {
                                            builder2.mergeFrom(duration2);
                                            this.backendLatency_ = builder2.buildPartial();
                                        }
                                    }
                                } else {
                                    if (!(z11 & true)) {
                                        this.headers_ = MapField.newMapField(b.f27109a);
                                        z11 |= true;
                                    }
                                    MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(b.f27109a.getParserForType(), extensionRegistryLite);
                                    this.headers_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
                                }
                            }
                            z10 = true;
                        } catch (UninitializedMessageException e2) {
                            throw e2.asInvalidProtocolBufferException().setUnfinishedMessage(this);
                        } catch (IOException e10) {
                            throw new InvalidProtocolBufferException(e10).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e11) {
                        throw e11.setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static Response parseFrom(InputStream inputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Response parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Response parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Response parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ResponseOrBuilder extends MessageOrBuilder {
        boolean containsHeaders(String str);

        Duration getBackendLatency();

        DurationOrBuilder getBackendLatencyOrBuilder();

        long getCode();

        @Deprecated
        Map<String, String> getHeaders();

        int getHeadersCount();

        Map<String, String> getHeadersMap();

        String getHeadersOrDefault(String str, String str2);

        String getHeadersOrThrow(String str);

        long getSize();

        Timestamp getTime();

        TimestampOrBuilder getTimeOrBuilder();

        boolean hasBackendLatency();

        boolean hasTime();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<AttributeContext> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AttributeContext parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new AttributeContext(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ AttributeContext(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static AttributeContext getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return r8.a.f53301a;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static AttributeContext parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AttributeContext) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static AttributeContext parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<AttributeContext> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeContext)) {
            return super.equals(obj);
        }
        AttributeContext attributeContext = (AttributeContext) obj;
        if (hasOrigin() != attributeContext.hasOrigin()) {
            return false;
        }
        if ((hasOrigin() && !getOrigin().equals(attributeContext.getOrigin())) || hasSource() != attributeContext.hasSource()) {
            return false;
        }
        if ((hasSource() && !getSource().equals(attributeContext.getSource())) || hasDestination() != attributeContext.hasDestination()) {
            return false;
        }
        if ((hasDestination() && !getDestination().equals(attributeContext.getDestination())) || hasRequest() != attributeContext.hasRequest()) {
            return false;
        }
        if ((hasRequest() && !getRequest().equals(attributeContext.getRequest())) || hasResponse() != attributeContext.hasResponse()) {
            return false;
        }
        if ((hasResponse() && !getResponse().equals(attributeContext.getResponse())) || hasResource() != attributeContext.hasResource()) {
            return false;
        }
        if ((!hasResource() || getResource().equals(attributeContext.getResource())) && hasApi() == attributeContext.hasApi()) {
            return (!hasApi() || getApi().equals(attributeContext.getApi())) && getExtensionsList().equals(attributeContext.getExtensionsList()) && this.unknownFields.equals(attributeContext.unknownFields);
        }
        return false;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public Api getApi() {
        Api api = this.api_;
        return api == null ? Api.getDefaultInstance() : api;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public ApiOrBuilder getApiOrBuilder() {
        return getApi();
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public Peer getDestination() {
        Peer peer = this.destination_;
        return peer == null ? Peer.getDefaultInstance() : peer;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public PeerOrBuilder getDestinationOrBuilder() {
        return getDestination();
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public Any getExtensions(int i10) {
        return this.extensions_.get(i10);
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public int getExtensionsCount() {
        return this.extensions_.size();
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public List<Any> getExtensionsList() {
        return this.extensions_;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public AnyOrBuilder getExtensionsOrBuilder(int i10) {
        return this.extensions_.get(i10);
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public List<? extends AnyOrBuilder> getExtensionsOrBuilderList() {
        return this.extensions_;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public Peer getOrigin() {
        Peer peer = this.origin_;
        return peer == null ? Peer.getDefaultInstance() : peer;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public PeerOrBuilder getOriginOrBuilder() {
        return getOrigin();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<AttributeContext> getParserForType() {
        return PARSER;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public Request getRequest() {
        Request request = this.request_;
        return request == null ? Request.getDefaultInstance() : request;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public RequestOrBuilder getRequestOrBuilder() {
        return getRequest();
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public Resource getResource() {
        Resource resource = this.resource_;
        return resource == null ? Resource.getDefaultInstance() : resource;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public ResourceOrBuilder getResourceOrBuilder() {
        return getResource();
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public Response getResponse() {
        Response response = this.response_;
        return response == null ? Response.getDefaultInstance() : response;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public ResponseOrBuilder getResponseOrBuilder() {
        return getResponse();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeMessageSize = this.source_ != null ? CodedOutputStream.computeMessageSize(1, getSource()) + 0 : 0;
        if (this.destination_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(2, getDestination());
        }
        if (this.request_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(3, getRequest());
        }
        if (this.response_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(4, getResponse());
        }
        if (this.resource_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(5, getResource());
        }
        if (this.api_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(6, getApi());
        }
        if (this.origin_ != null) {
            computeMessageSize += CodedOutputStream.computeMessageSize(7, getOrigin());
        }
        for (int i11 = 0; i11 < this.extensions_.size(); i11++) {
            computeMessageSize += CodedOutputStream.computeMessageSize(8, this.extensions_.get(i11));
        }
        int serializedSize = computeMessageSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public Peer getSource() {
        Peer peer = this.source_;
        return peer == null ? Peer.getDefaultInstance() : peer;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public PeerOrBuilder getSourceOrBuilder() {
        return getSource();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public boolean hasApi() {
        return this.api_ != null;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public boolean hasDestination() {
        return this.destination_ != null;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public boolean hasOrigin() {
        return this.origin_ != null;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public boolean hasRequest() {
        return this.request_ != null;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public boolean hasResource() {
        return this.resource_ != null;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public boolean hasResponse() {
        return this.response_ != null;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public boolean hasSource() {
        return this.source_ != null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode();
        if (hasOrigin()) {
            hashCode = (((hashCode * 37) + 7) * 53) + getOrigin().hashCode();
        }
        if (hasSource()) {
            hashCode = (((hashCode * 37) + 1) * 53) + getSource().hashCode();
        }
        if (hasDestination()) {
            hashCode = (((hashCode * 37) + 2) * 53) + getDestination().hashCode();
        }
        if (hasRequest()) {
            hashCode = (((hashCode * 37) + 3) * 53) + getRequest().hashCode();
        }
        if (hasResponse()) {
            hashCode = (((hashCode * 37) + 4) * 53) + getResponse().hashCode();
        }
        if (hasResource()) {
            hashCode = (((hashCode * 37) + 5) * 53) + getResource().hashCode();
        }
        if (hasApi()) {
            hashCode = (((hashCode * 37) + 6) * 53) + getApi().hashCode();
        }
        if (getExtensionsCount() > 0) {
            hashCode = (((hashCode * 37) + 8) * 53) + getExtensionsList().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return r8.a.f53302b.ensureFieldAccessorsInitialized(AttributeContext.class, Builder.class);
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
        return new AttributeContext();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.source_ != null) {
            codedOutputStream.writeMessage(1, getSource());
        }
        if (this.destination_ != null) {
            codedOutputStream.writeMessage(2, getDestination());
        }
        if (this.request_ != null) {
            codedOutputStream.writeMessage(3, getRequest());
        }
        if (this.response_ != null) {
            codedOutputStream.writeMessage(4, getResponse());
        }
        if (this.resource_ != null) {
            codedOutputStream.writeMessage(5, getResource());
        }
        if (this.api_ != null) {
            codedOutputStream.writeMessage(6, getApi());
        }
        if (this.origin_ != null) {
            codedOutputStream.writeMessage(7, getOrigin());
        }
        for (int i10 = 0; i10 < this.extensions_.size(); i10++) {
            codedOutputStream.writeMessage(8, this.extensions_.get(i10));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ AttributeContext(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(AttributeContext attributeContext) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(attributeContext);
    }

    public static AttributeContext parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AttributeContext) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AttributeContext parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private AttributeContext(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static AttributeContext parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public AttributeContext getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static AttributeContext parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private AttributeContext() {
        this.memoizedIsInitialized = (byte) -1;
        this.extensions_ = Collections.emptyList();
    }

    public static AttributeContext parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static AttributeContext parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static AttributeContext parseFrom(InputStream inputStream) throws IOException {
        return (AttributeContext) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AttributeContext(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        Objects.requireNonNull(extensionRegistryLite);
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                Peer peer = this.source_;
                                Peer.Builder builder = peer != null ? peer.toBuilder() : null;
                                Peer peer2 = (Peer) codedInputStream.readMessage(Peer.parser(), extensionRegistryLite);
                                this.source_ = peer2;
                                if (builder != null) {
                                    builder.mergeFrom(peer2);
                                    this.source_ = builder.buildPartial();
                                }
                            } else if (readTag == 18) {
                                Peer peer3 = this.destination_;
                                Peer.Builder builder2 = peer3 != null ? peer3.toBuilder() : null;
                                Peer peer4 = (Peer) codedInputStream.readMessage(Peer.parser(), extensionRegistryLite);
                                this.destination_ = peer4;
                                if (builder2 != null) {
                                    builder2.mergeFrom(peer4);
                                    this.destination_ = builder2.buildPartial();
                                }
                            } else if (readTag == 26) {
                                Request request = this.request_;
                                Request.Builder builder3 = request != null ? request.toBuilder() : null;
                                Request request2 = (Request) codedInputStream.readMessage(Request.parser(), extensionRegistryLite);
                                this.request_ = request2;
                                if (builder3 != null) {
                                    builder3.mergeFrom(request2);
                                    this.request_ = builder3.buildPartial();
                                }
                            } else if (readTag == 34) {
                                Response response = this.response_;
                                Response.Builder builder4 = response != null ? response.toBuilder() : null;
                                Response response2 = (Response) codedInputStream.readMessage(Response.parser(), extensionRegistryLite);
                                this.response_ = response2;
                                if (builder4 != null) {
                                    builder4.mergeFrom(response2);
                                    this.response_ = builder4.buildPartial();
                                }
                            } else if (readTag == 42) {
                                Resource resource = this.resource_;
                                Resource.Builder builder5 = resource != null ? resource.toBuilder() : null;
                                Resource resource2 = (Resource) codedInputStream.readMessage(Resource.parser(), extensionRegistryLite);
                                this.resource_ = resource2;
                                if (builder5 != null) {
                                    builder5.mergeFrom(resource2);
                                    this.resource_ = builder5.buildPartial();
                                }
                            } else if (readTag == 50) {
                                Api api = this.api_;
                                Api.Builder builder6 = api != null ? api.toBuilder() : null;
                                Api api2 = (Api) codedInputStream.readMessage(Api.parser(), extensionRegistryLite);
                                this.api_ = api2;
                                if (builder6 != null) {
                                    builder6.mergeFrom(api2);
                                    this.api_ = builder6.buildPartial();
                                }
                            } else if (readTag == 58) {
                                Peer peer5 = this.origin_;
                                Peer.Builder builder7 = peer5 != null ? peer5.toBuilder() : null;
                                Peer peer6 = (Peer) codedInputStream.readMessage(Peer.parser(), extensionRegistryLite);
                                this.origin_ = peer6;
                                if (builder7 != null) {
                                    builder7.mergeFrom(peer6);
                                    this.origin_ = builder7.buildPartial();
                                }
                            } else if (readTag != 66) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                if (!(z11 & true)) {
                                    this.extensions_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.extensions_.add(codedInputStream.readMessage(Any.parser(), extensionRegistryLite));
                            }
                        }
                        z10 = true;
                    } catch (UninitializedMessageException e2) {
                        throw e2.asInvalidProtocolBufferException().setUnfinishedMessage(this);
                    } catch (IOException e10) {
                        throw new InvalidProtocolBufferException(e10).setUnfinishedMessage(this);
                    }
                } catch (InvalidProtocolBufferException e11) {
                    throw e11.setUnfinishedMessage(this);
                }
            } finally {
                if (z11 & true) {
                    this.extensions_ = Collections.unmodifiableList(this.extensions_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static AttributeContext parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AttributeContext) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AttributeContext parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AttributeContext) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static AttributeContext parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AttributeContext) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
