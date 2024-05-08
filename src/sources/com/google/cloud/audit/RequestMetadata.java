package com.google.cloud.audit;

import com.android.internal.logging.nano.MetricsProto;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.google.rpc.context.AttributeContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class RequestMetadata extends GeneratedMessageV3 implements RequestMetadataOrBuilder {
    public static final int CALLER_IP_FIELD_NUMBER = 1;
    public static final int CALLER_NETWORK_FIELD_NUMBER = 3;
    public static final int CALLER_SUPPLIED_USER_AGENT_FIELD_NUMBER = 2;
    public static final int DESTINATION_ATTRIBUTES_FIELD_NUMBER = 8;
    public static final int REQUEST_ATTRIBUTES_FIELD_NUMBER = 7;
    private static final long serialVersionUID = 0;
    private volatile Object callerIp_;
    private volatile Object callerNetwork_;
    private volatile Object callerSuppliedUserAgent_;
    private AttributeContext.Peer destinationAttributes_;
    private byte memoizedIsInitialized;
    private AttributeContext.Request requestAttributes_;
    private static final RequestMetadata DEFAULT_INSTANCE = new RequestMetadata();
    private static final Parser<RequestMetadata> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RequestMetadataOrBuilder {
        private Object callerIp_;
        private Object callerNetwork_;
        private Object callerSuppliedUserAgent_;
        private SingleFieldBuilderV3<AttributeContext.Peer, AttributeContext.Peer.Builder, AttributeContext.PeerOrBuilder> destinationAttributesBuilder_;
        private AttributeContext.Peer destinationAttributes_;
        private SingleFieldBuilderV3<AttributeContext.Request, AttributeContext.Request.Builder, AttributeContext.RequestOrBuilder> requestAttributesBuilder_;
        private AttributeContext.Request requestAttributes_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return w7.a.f54276g;
        }

        private SingleFieldBuilderV3<AttributeContext.Peer, AttributeContext.Peer.Builder, AttributeContext.PeerOrBuilder> getDestinationAttributesFieldBuilder() {
            if (this.destinationAttributesBuilder_ == null) {
                this.destinationAttributesBuilder_ = new SingleFieldBuilderV3<>(getDestinationAttributes(), getParentForChildren(), isClean());
                this.destinationAttributes_ = null;
            }
            return this.destinationAttributesBuilder_;
        }

        private SingleFieldBuilderV3<AttributeContext.Request, AttributeContext.Request.Builder, AttributeContext.RequestOrBuilder> getRequestAttributesFieldBuilder() {
            if (this.requestAttributesBuilder_ == null) {
                this.requestAttributesBuilder_ = new SingleFieldBuilderV3<>(getRequestAttributes(), getParentForChildren(), isClean());
                this.requestAttributes_ = null;
            }
            return this.requestAttributesBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public Builder clearCallerIp() {
            this.callerIp_ = RequestMetadata.getDefaultInstance().getCallerIp();
            onChanged();
            return this;
        }

        public Builder clearCallerNetwork() {
            this.callerNetwork_ = RequestMetadata.getDefaultInstance().getCallerNetwork();
            onChanged();
            return this;
        }

        public Builder clearCallerSuppliedUserAgent() {
            this.callerSuppliedUserAgent_ = RequestMetadata.getDefaultInstance().getCallerSuppliedUserAgent();
            onChanged();
            return this;
        }

        public Builder clearDestinationAttributes() {
            if (this.destinationAttributesBuilder_ == null) {
                this.destinationAttributes_ = null;
                onChanged();
            } else {
                this.destinationAttributes_ = null;
                this.destinationAttributesBuilder_ = null;
            }
            return this;
        }

        public Builder clearRequestAttributes() {
            if (this.requestAttributesBuilder_ == null) {
                this.requestAttributes_ = null;
                onChanged();
            } else {
                this.requestAttributes_ = null;
                this.requestAttributesBuilder_ = null;
            }
            return this;
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public String getCallerIp() {
            Object obj = this.callerIp_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.callerIp_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public ByteString getCallerIpBytes() {
            Object obj = this.callerIp_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.callerIp_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public String getCallerNetwork() {
            Object obj = this.callerNetwork_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.callerNetwork_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public ByteString getCallerNetworkBytes() {
            Object obj = this.callerNetwork_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.callerNetwork_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public String getCallerSuppliedUserAgent() {
            Object obj = this.callerSuppliedUserAgent_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.callerSuppliedUserAgent_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public ByteString getCallerSuppliedUserAgentBytes() {
            Object obj = this.callerSuppliedUserAgent_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.callerSuppliedUserAgent_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return w7.a.f54276g;
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public AttributeContext.Peer getDestinationAttributes() {
            SingleFieldBuilderV3<AttributeContext.Peer, AttributeContext.Peer.Builder, AttributeContext.PeerOrBuilder> singleFieldBuilderV3 = this.destinationAttributesBuilder_;
            if (singleFieldBuilderV3 == null) {
                AttributeContext.Peer peer = this.destinationAttributes_;
                return peer == null ? AttributeContext.Peer.getDefaultInstance() : peer;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public AttributeContext.Peer.Builder getDestinationAttributesBuilder() {
            onChanged();
            return getDestinationAttributesFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public AttributeContext.PeerOrBuilder getDestinationAttributesOrBuilder() {
            SingleFieldBuilderV3<AttributeContext.Peer, AttributeContext.Peer.Builder, AttributeContext.PeerOrBuilder> singleFieldBuilderV3 = this.destinationAttributesBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            AttributeContext.Peer peer = this.destinationAttributes_;
            return peer == null ? AttributeContext.Peer.getDefaultInstance() : peer;
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public AttributeContext.Request getRequestAttributes() {
            SingleFieldBuilderV3<AttributeContext.Request, AttributeContext.Request.Builder, AttributeContext.RequestOrBuilder> singleFieldBuilderV3 = this.requestAttributesBuilder_;
            if (singleFieldBuilderV3 == null) {
                AttributeContext.Request request = this.requestAttributes_;
                return request == null ? AttributeContext.Request.getDefaultInstance() : request;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public AttributeContext.Request.Builder getRequestAttributesBuilder() {
            onChanged();
            return getRequestAttributesFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public AttributeContext.RequestOrBuilder getRequestAttributesOrBuilder() {
            SingleFieldBuilderV3<AttributeContext.Request, AttributeContext.Request.Builder, AttributeContext.RequestOrBuilder> singleFieldBuilderV3 = this.requestAttributesBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            AttributeContext.Request request = this.requestAttributes_;
            return request == null ? AttributeContext.Request.getDefaultInstance() : request;
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public boolean hasDestinationAttributes() {
            return (this.destinationAttributesBuilder_ == null && this.destinationAttributes_ == null) ? false : true;
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public boolean hasRequestAttributes() {
            return (this.requestAttributesBuilder_ == null && this.requestAttributes_ == null) ? false : true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return w7.a.f54277h.ensureFieldAccessorsInitialized(RequestMetadata.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeDestinationAttributes(AttributeContext.Peer peer) {
            SingleFieldBuilderV3<AttributeContext.Peer, AttributeContext.Peer.Builder, AttributeContext.PeerOrBuilder> singleFieldBuilderV3 = this.destinationAttributesBuilder_;
            if (singleFieldBuilderV3 == null) {
                AttributeContext.Peer peer2 = this.destinationAttributes_;
                if (peer2 != null) {
                    this.destinationAttributes_ = AttributeContext.Peer.newBuilder(peer2).mergeFrom(peer).buildPartial();
                } else {
                    this.destinationAttributes_ = peer;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(peer);
            }
            return this;
        }

        public Builder mergeRequestAttributes(AttributeContext.Request request) {
            SingleFieldBuilderV3<AttributeContext.Request, AttributeContext.Request.Builder, AttributeContext.RequestOrBuilder> singleFieldBuilderV3 = this.requestAttributesBuilder_;
            if (singleFieldBuilderV3 == null) {
                AttributeContext.Request request2 = this.requestAttributes_;
                if (request2 != null) {
                    this.requestAttributes_ = AttributeContext.Request.newBuilder(request2).mergeFrom(request).buildPartial();
                } else {
                    this.requestAttributes_ = request;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(request);
            }
            return this;
        }

        public Builder setCallerIp(String str) {
            Objects.requireNonNull(str);
            this.callerIp_ = str;
            onChanged();
            return this;
        }

        public Builder setCallerIpBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.callerIp_ = byteString;
            onChanged();
            return this;
        }

        public Builder setCallerNetwork(String str) {
            Objects.requireNonNull(str);
            this.callerNetwork_ = str;
            onChanged();
            return this;
        }

        public Builder setCallerNetworkBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.callerNetwork_ = byteString;
            onChanged();
            return this;
        }

        public Builder setCallerSuppliedUserAgent(String str) {
            Objects.requireNonNull(str);
            this.callerSuppliedUserAgent_ = str;
            onChanged();
            return this;
        }

        public Builder setCallerSuppliedUserAgentBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.callerSuppliedUserAgent_ = byteString;
            onChanged();
            return this;
        }

        public Builder setDestinationAttributes(AttributeContext.Peer peer) {
            SingleFieldBuilderV3<AttributeContext.Peer, AttributeContext.Peer.Builder, AttributeContext.PeerOrBuilder> singleFieldBuilderV3 = this.destinationAttributesBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(peer);
                this.destinationAttributes_ = peer;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(peer);
            }
            return this;
        }

        public Builder setRequestAttributes(AttributeContext.Request request) {
            SingleFieldBuilderV3<AttributeContext.Request, AttributeContext.Request.Builder, AttributeContext.RequestOrBuilder> singleFieldBuilderV3 = this.requestAttributesBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(request);
                this.requestAttributes_ = request;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(request);
            }
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        private Builder() {
            this.callerIp_ = "";
            this.callerSuppliedUserAgent_ = "";
            this.callerNetwork_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public RequestMetadata build() {
            RequestMetadata buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public RequestMetadata buildPartial() {
            RequestMetadata requestMetadata = new RequestMetadata(this, (a) null);
            requestMetadata.callerIp_ = this.callerIp_;
            requestMetadata.callerSuppliedUserAgent_ = this.callerSuppliedUserAgent_;
            requestMetadata.callerNetwork_ = this.callerNetwork_;
            SingleFieldBuilderV3<AttributeContext.Request, AttributeContext.Request.Builder, AttributeContext.RequestOrBuilder> singleFieldBuilderV3 = this.requestAttributesBuilder_;
            if (singleFieldBuilderV3 == null) {
                requestMetadata.requestAttributes_ = this.requestAttributes_;
            } else {
                requestMetadata.requestAttributes_ = singleFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<AttributeContext.Peer, AttributeContext.Peer.Builder, AttributeContext.PeerOrBuilder> singleFieldBuilderV32 = this.destinationAttributesBuilder_;
            if (singleFieldBuilderV32 == null) {
                requestMetadata.destinationAttributes_ = this.destinationAttributes_;
            } else {
                requestMetadata.destinationAttributes_ = singleFieldBuilderV32.build();
            }
            onBuilt();
            return requestMetadata;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RequestMetadata getDefaultInstanceForType() {
            return RequestMetadata.getDefaultInstance();
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
            this.callerIp_ = "";
            this.callerSuppliedUserAgent_ = "";
            this.callerNetwork_ = "";
            if (this.requestAttributesBuilder_ == null) {
                this.requestAttributes_ = null;
            } else {
                this.requestAttributes_ = null;
                this.requestAttributesBuilder_ = null;
            }
            if (this.destinationAttributesBuilder_ == null) {
                this.destinationAttributes_ = null;
            } else {
                this.destinationAttributes_ = null;
                this.destinationAttributesBuilder_ = null;
            }
            return this;
        }

        public Builder setDestinationAttributes(AttributeContext.Peer.Builder builder) {
            SingleFieldBuilderV3<AttributeContext.Peer, AttributeContext.Peer.Builder, AttributeContext.PeerOrBuilder> singleFieldBuilderV3 = this.destinationAttributesBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.destinationAttributes_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setRequestAttributes(AttributeContext.Request.Builder builder) {
            SingleFieldBuilderV3<AttributeContext.Request, AttributeContext.Request.Builder, AttributeContext.RequestOrBuilder> singleFieldBuilderV3 = this.requestAttributesBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.requestAttributes_ = builder.build();
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
            if (message instanceof RequestMetadata) {
                return mergeFrom((RequestMetadata) message);
            }
            super.mergeFrom(message);
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.callerIp_ = "";
            this.callerSuppliedUserAgent_ = "";
            this.callerNetwork_ = "";
            maybeForceBuilderInitialization();
        }

        public Builder mergeFrom(RequestMetadata requestMetadata) {
            if (requestMetadata == RequestMetadata.getDefaultInstance()) {
                return this;
            }
            if (!requestMetadata.getCallerIp().isEmpty()) {
                this.callerIp_ = requestMetadata.callerIp_;
                onChanged();
            }
            if (!requestMetadata.getCallerSuppliedUserAgent().isEmpty()) {
                this.callerSuppliedUserAgent_ = requestMetadata.callerSuppliedUserAgent_;
                onChanged();
            }
            if (!requestMetadata.getCallerNetwork().isEmpty()) {
                this.callerNetwork_ = requestMetadata.callerNetwork_;
                onChanged();
            }
            if (requestMetadata.hasRequestAttributes()) {
                mergeRequestAttributes(requestMetadata.getRequestAttributes());
            }
            if (requestMetadata.hasDestinationAttributes()) {
                mergeDestinationAttributes(requestMetadata.getDestinationAttributes());
            }
            mergeUnknownFields(requestMetadata.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.cloud.audit.RequestMetadata.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.cloud.audit.RequestMetadata.access$1000()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.cloud.audit.RequestMetadata r3 = (com.google.cloud.audit.RequestMetadata) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.cloud.audit.RequestMetadata r4 = (com.google.cloud.audit.RequestMetadata) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.cloud.audit.RequestMetadata.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.cloud.audit.RequestMetadata$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<RequestMetadata> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RequestMetadata parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new RequestMetadata(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ RequestMetadata(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static RequestMetadata getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return w7.a.f54276g;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static RequestMetadata parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RequestMetadata) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static RequestMetadata parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<RequestMetadata> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RequestMetadata)) {
            return super.equals(obj);
        }
        RequestMetadata requestMetadata = (RequestMetadata) obj;
        if (!getCallerIp().equals(requestMetadata.getCallerIp()) || !getCallerSuppliedUserAgent().equals(requestMetadata.getCallerSuppliedUserAgent()) || !getCallerNetwork().equals(requestMetadata.getCallerNetwork()) || hasRequestAttributes() != requestMetadata.hasRequestAttributes()) {
            return false;
        }
        if ((!hasRequestAttributes() || getRequestAttributes().equals(requestMetadata.getRequestAttributes())) && hasDestinationAttributes() == requestMetadata.hasDestinationAttributes()) {
            return (!hasDestinationAttributes() || getDestinationAttributes().equals(requestMetadata.getDestinationAttributes())) && this.unknownFields.equals(requestMetadata.unknownFields);
        }
        return false;
    }

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public String getCallerIp() {
        Object obj = this.callerIp_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.callerIp_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public ByteString getCallerIpBytes() {
        Object obj = this.callerIp_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.callerIp_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public String getCallerNetwork() {
        Object obj = this.callerNetwork_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.callerNetwork_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public ByteString getCallerNetworkBytes() {
        Object obj = this.callerNetwork_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.callerNetwork_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public String getCallerSuppliedUserAgent() {
        Object obj = this.callerSuppliedUserAgent_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.callerSuppliedUserAgent_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public ByteString getCallerSuppliedUserAgentBytes() {
        Object obj = this.callerSuppliedUserAgent_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.callerSuppliedUserAgent_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public AttributeContext.Peer getDestinationAttributes() {
        AttributeContext.Peer peer = this.destinationAttributes_;
        return peer == null ? AttributeContext.Peer.getDefaultInstance() : peer;
    }

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public AttributeContext.PeerOrBuilder getDestinationAttributesOrBuilder() {
        return getDestinationAttributes();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<RequestMetadata> getParserForType() {
        return PARSER;
    }

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public AttributeContext.Request getRequestAttributes() {
        AttributeContext.Request request = this.requestAttributes_;
        return request == null ? AttributeContext.Request.getDefaultInstance() : request;
    }

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public AttributeContext.RequestOrBuilder getRequestAttributesOrBuilder() {
        return getRequestAttributes();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeStringSize = GeneratedMessageV3.isStringEmpty(this.callerIp_) ? 0 : 0 + GeneratedMessageV3.computeStringSize(1, this.callerIp_);
        if (!GeneratedMessageV3.isStringEmpty(this.callerSuppliedUserAgent_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(2, this.callerSuppliedUserAgent_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.callerNetwork_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(3, this.callerNetwork_);
        }
        if (this.requestAttributes_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(7, getRequestAttributes());
        }
        if (this.destinationAttributes_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(8, getDestinationAttributes());
        }
        int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public boolean hasDestinationAttributes() {
        return this.destinationAttributes_ != null;
    }

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public boolean hasRequestAttributes() {
        return this.requestAttributes_ != null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = ((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getCallerIp().hashCode()) * 37) + 2) * 53) + getCallerSuppliedUserAgent().hashCode()) * 37) + 3) * 53) + getCallerNetwork().hashCode();
        if (hasRequestAttributes()) {
            hashCode = (((hashCode * 37) + 7) * 53) + getRequestAttributes().hashCode();
        }
        if (hasDestinationAttributes()) {
            hashCode = (((hashCode * 37) + 8) * 53) + getDestinationAttributes().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return w7.a.f54277h.ensureFieldAccessorsInitialized(RequestMetadata.class, Builder.class);
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
        return new RequestMetadata();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!GeneratedMessageV3.isStringEmpty(this.callerIp_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.callerIp_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.callerSuppliedUserAgent_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.callerSuppliedUserAgent_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.callerNetwork_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.callerNetwork_);
        }
        if (this.requestAttributes_ != null) {
            codedOutputStream.writeMessage(7, getRequestAttributes());
        }
        if (this.destinationAttributes_ != null) {
            codedOutputStream.writeMessage(8, getDestinationAttributes());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ RequestMetadata(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(RequestMetadata requestMetadata) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(requestMetadata);
    }

    public static RequestMetadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RequestMetadata) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static RequestMetadata parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private RequestMetadata(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static RequestMetadata parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public RequestMetadata getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static RequestMetadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private RequestMetadata() {
        this.memoizedIsInitialized = (byte) -1;
        this.callerIp_ = "";
        this.callerSuppliedUserAgent_ = "";
        this.callerNetwork_ = "";
    }

    public static RequestMetadata parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static RequestMetadata parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static RequestMetadata parseFrom(InputStream inputStream) throws IOException {
        return (RequestMetadata) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static RequestMetadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RequestMetadata) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static RequestMetadata parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (RequestMetadata) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    private RequestMetadata(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.callerIp_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.callerSuppliedUserAgent_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag != 26) {
                                if (readTag == 58) {
                                    AttributeContext.Request request = this.requestAttributes_;
                                    AttributeContext.Request.Builder builder = request != null ? request.toBuilder() : null;
                                    AttributeContext.Request request2 = (AttributeContext.Request) codedInputStream.readMessage(AttributeContext.Request.parser(), extensionRegistryLite);
                                    this.requestAttributes_ = request2;
                                    if (builder != null) {
                                        builder.mergeFrom(request2);
                                        this.requestAttributes_ = builder.buildPartial();
                                    }
                                } else if (readTag != 66) {
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    AttributeContext.Peer peer = this.destinationAttributes_;
                                    AttributeContext.Peer.Builder builder2 = peer != null ? peer.toBuilder() : null;
                                    AttributeContext.Peer peer2 = (AttributeContext.Peer) codedInputStream.readMessage(AttributeContext.Peer.parser(), extensionRegistryLite);
                                    this.destinationAttributes_ = peer2;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(peer2);
                                        this.destinationAttributes_ = builder2.buildPartial();
                                    }
                                }
                            } else {
                                this.callerNetwork_ = codedInputStream.readStringRequireUtf8();
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

    public static RequestMetadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RequestMetadata) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
