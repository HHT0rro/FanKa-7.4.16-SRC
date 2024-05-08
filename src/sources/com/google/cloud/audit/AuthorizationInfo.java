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
import com.google.protobuf.Internal;
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
public final class AuthorizationInfo extends GeneratedMessageV3 implements AuthorizationInfoOrBuilder {
    public static final int GRANTED_FIELD_NUMBER = 3;
    public static final int PERMISSION_FIELD_NUMBER = 2;
    public static final int RESOURCE_ATTRIBUTES_FIELD_NUMBER = 5;
    public static final int RESOURCE_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private boolean granted_;
    private byte memoizedIsInitialized;
    private volatile Object permission_;
    private AttributeContext.Resource resourceAttributes_;
    private volatile Object resource_;
    private static final AuthorizationInfo DEFAULT_INSTANCE = new AuthorizationInfo();
    private static final Parser<AuthorizationInfo> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AuthorizationInfoOrBuilder {
        private boolean granted_;
        private Object permission_;
        private SingleFieldBuilderV3<AttributeContext.Resource, AttributeContext.Resource.Builder, AttributeContext.ResourceOrBuilder> resourceAttributesBuilder_;
        private AttributeContext.Resource resourceAttributes_;
        private Object resource_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return w7.a.f54274e;
        }

        private SingleFieldBuilderV3<AttributeContext.Resource, AttributeContext.Resource.Builder, AttributeContext.ResourceOrBuilder> getResourceAttributesFieldBuilder() {
            if (this.resourceAttributesBuilder_ == null) {
                this.resourceAttributesBuilder_ = new SingleFieldBuilderV3<>(getResourceAttributes(), getParentForChildren(), isClean());
                this.resourceAttributes_ = null;
            }
            return this.resourceAttributesBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public Builder clearGranted() {
            this.granted_ = false;
            onChanged();
            return this;
        }

        public Builder clearPermission() {
            this.permission_ = AuthorizationInfo.getDefaultInstance().getPermission();
            onChanged();
            return this;
        }

        public Builder clearResource() {
            this.resource_ = AuthorizationInfo.getDefaultInstance().getResource();
            onChanged();
            return this;
        }

        public Builder clearResourceAttributes() {
            if (this.resourceAttributesBuilder_ == null) {
                this.resourceAttributes_ = null;
                onChanged();
            } else {
                this.resourceAttributes_ = null;
                this.resourceAttributesBuilder_ = null;
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return w7.a.f54274e;
        }

        @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
        public boolean getGranted() {
            return this.granted_;
        }

        @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
        public String getPermission() {
            Object obj = this.permission_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.permission_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
        public ByteString getPermissionBytes() {
            Object obj = this.permission_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.permission_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
        public String getResource() {
            Object obj = this.resource_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.resource_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
        public AttributeContext.Resource getResourceAttributes() {
            SingleFieldBuilderV3<AttributeContext.Resource, AttributeContext.Resource.Builder, AttributeContext.ResourceOrBuilder> singleFieldBuilderV3 = this.resourceAttributesBuilder_;
            if (singleFieldBuilderV3 == null) {
                AttributeContext.Resource resource = this.resourceAttributes_;
                return resource == null ? AttributeContext.Resource.getDefaultInstance() : resource;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public AttributeContext.Resource.Builder getResourceAttributesBuilder() {
            onChanged();
            return getResourceAttributesFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
        public AttributeContext.ResourceOrBuilder getResourceAttributesOrBuilder() {
            SingleFieldBuilderV3<AttributeContext.Resource, AttributeContext.Resource.Builder, AttributeContext.ResourceOrBuilder> singleFieldBuilderV3 = this.resourceAttributesBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            AttributeContext.Resource resource = this.resourceAttributes_;
            return resource == null ? AttributeContext.Resource.getDefaultInstance() : resource;
        }

        @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
        public ByteString getResourceBytes() {
            Object obj = this.resource_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.resource_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
        public boolean hasResourceAttributes() {
            return (this.resourceAttributesBuilder_ == null && this.resourceAttributes_ == null) ? false : true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return w7.a.f54275f.ensureFieldAccessorsInitialized(AuthorizationInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeResourceAttributes(AttributeContext.Resource resource) {
            SingleFieldBuilderV3<AttributeContext.Resource, AttributeContext.Resource.Builder, AttributeContext.ResourceOrBuilder> singleFieldBuilderV3 = this.resourceAttributesBuilder_;
            if (singleFieldBuilderV3 == null) {
                AttributeContext.Resource resource2 = this.resourceAttributes_;
                if (resource2 != null) {
                    this.resourceAttributes_ = AttributeContext.Resource.newBuilder(resource2).mergeFrom(resource).buildPartial();
                } else {
                    this.resourceAttributes_ = resource;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(resource);
            }
            return this;
        }

        public Builder setGranted(boolean z10) {
            this.granted_ = z10;
            onChanged();
            return this;
        }

        public Builder setPermission(String str) {
            Objects.requireNonNull(str);
            this.permission_ = str;
            onChanged();
            return this;
        }

        public Builder setPermissionBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.permission_ = byteString;
            onChanged();
            return this;
        }

        public Builder setResource(String str) {
            Objects.requireNonNull(str);
            this.resource_ = str;
            onChanged();
            return this;
        }

        public Builder setResourceAttributes(AttributeContext.Resource resource) {
            SingleFieldBuilderV3<AttributeContext.Resource, AttributeContext.Resource.Builder, AttributeContext.ResourceOrBuilder> singleFieldBuilderV3 = this.resourceAttributesBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(resource);
                this.resourceAttributes_ = resource;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(resource);
            }
            return this;
        }

        public Builder setResourceBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.resource_ = byteString;
            onChanged();
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        private Builder() {
            this.resource_ = "";
            this.permission_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AuthorizationInfo build() {
            AuthorizationInfo buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AuthorizationInfo buildPartial() {
            AuthorizationInfo authorizationInfo = new AuthorizationInfo(this, (a) null);
            authorizationInfo.resource_ = this.resource_;
            authorizationInfo.permission_ = this.permission_;
            authorizationInfo.granted_ = this.granted_;
            SingleFieldBuilderV3<AttributeContext.Resource, AttributeContext.Resource.Builder, AttributeContext.ResourceOrBuilder> singleFieldBuilderV3 = this.resourceAttributesBuilder_;
            if (singleFieldBuilderV3 == null) {
                authorizationInfo.resourceAttributes_ = this.resourceAttributes_;
            } else {
                authorizationInfo.resourceAttributes_ = singleFieldBuilderV3.build();
            }
            onBuilt();
            return authorizationInfo;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AuthorizationInfo getDefaultInstanceForType() {
            return AuthorizationInfo.getDefaultInstance();
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
            this.resource_ = "";
            this.permission_ = "";
            this.granted_ = false;
            if (this.resourceAttributesBuilder_ == null) {
                this.resourceAttributes_ = null;
            } else {
                this.resourceAttributes_ = null;
                this.resourceAttributesBuilder_ = null;
            }
            return this;
        }

        public Builder setResourceAttributes(AttributeContext.Resource.Builder builder) {
            SingleFieldBuilderV3<AttributeContext.Resource, AttributeContext.Resource.Builder, AttributeContext.ResourceOrBuilder> singleFieldBuilderV3 = this.resourceAttributesBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.resourceAttributes_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.resource_ = "";
            this.permission_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2458clone() {
            return (Builder) super.mo2458clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof AuthorizationInfo) {
                return mergeFrom((AuthorizationInfo) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(AuthorizationInfo authorizationInfo) {
            if (authorizationInfo == AuthorizationInfo.getDefaultInstance()) {
                return this;
            }
            if (!authorizationInfo.getResource().isEmpty()) {
                this.resource_ = authorizationInfo.resource_;
                onChanged();
            }
            if (!authorizationInfo.getPermission().isEmpty()) {
                this.permission_ = authorizationInfo.permission_;
                onChanged();
            }
            if (authorizationInfo.getGranted()) {
                setGranted(authorizationInfo.getGranted());
            }
            if (authorizationInfo.hasResourceAttributes()) {
                mergeResourceAttributes(authorizationInfo.getResourceAttributes());
            }
            mergeUnknownFields(authorizationInfo.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.cloud.audit.AuthorizationInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.cloud.audit.AuthorizationInfo.access$900()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.cloud.audit.AuthorizationInfo r3 = (com.google.cloud.audit.AuthorizationInfo) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.cloud.audit.AuthorizationInfo r4 = (com.google.cloud.audit.AuthorizationInfo) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.cloud.audit.AuthorizationInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.cloud.audit.AuthorizationInfo$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<AuthorizationInfo> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AuthorizationInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new AuthorizationInfo(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ AuthorizationInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static AuthorizationInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return w7.a.f54274e;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static AuthorizationInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AuthorizationInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static AuthorizationInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<AuthorizationInfo> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthorizationInfo)) {
            return super.equals(obj);
        }
        AuthorizationInfo authorizationInfo = (AuthorizationInfo) obj;
        if (getResource().equals(authorizationInfo.getResource()) && getPermission().equals(authorizationInfo.getPermission()) && getGranted() == authorizationInfo.getGranted() && hasResourceAttributes() == authorizationInfo.hasResourceAttributes()) {
            return (!hasResourceAttributes() || getResourceAttributes().equals(authorizationInfo.getResourceAttributes())) && this.unknownFields.equals(authorizationInfo.unknownFields);
        }
        return false;
    }

    @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
    public boolean getGranted() {
        return this.granted_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<AuthorizationInfo> getParserForType() {
        return PARSER;
    }

    @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
    public String getPermission() {
        Object obj = this.permission_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.permission_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
    public ByteString getPermissionBytes() {
        Object obj = this.permission_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.permission_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
    public String getResource() {
        Object obj = this.resource_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.resource_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
    public AttributeContext.Resource getResourceAttributes() {
        AttributeContext.Resource resource = this.resourceAttributes_;
        return resource == null ? AttributeContext.Resource.getDefaultInstance() : resource;
    }

    @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
    public AttributeContext.ResourceOrBuilder getResourceAttributesOrBuilder() {
        return getResourceAttributes();
    }

    @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
    public ByteString getResourceBytes() {
        Object obj = this.resource_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.resource_ = copyFromUtf8;
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
        int computeStringSize = GeneratedMessageV3.isStringEmpty(this.resource_) ? 0 : 0 + GeneratedMessageV3.computeStringSize(1, this.resource_);
        if (!GeneratedMessageV3.isStringEmpty(this.permission_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(2, this.permission_);
        }
        boolean z10 = this.granted_;
        if (z10) {
            computeStringSize += CodedOutputStream.computeBoolSize(3, z10);
        }
        if (this.resourceAttributes_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(5, getResourceAttributes());
        }
        int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
    public boolean hasResourceAttributes() {
        return this.resourceAttributes_ != null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = ((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getResource().hashCode()) * 37) + 2) * 53) + getPermission().hashCode()) * 37) + 3) * 53) + Internal.hashBoolean(getGranted());
        if (hasResourceAttributes()) {
            hashCode = (((hashCode * 37) + 5) * 53) + getResourceAttributes().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return w7.a.f54275f.ensureFieldAccessorsInitialized(AuthorizationInfo.class, Builder.class);
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
        return new AuthorizationInfo();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!GeneratedMessageV3.isStringEmpty(this.resource_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.resource_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.permission_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.permission_);
        }
        boolean z10 = this.granted_;
        if (z10) {
            codedOutputStream.writeBool(3, z10);
        }
        if (this.resourceAttributes_ != null) {
            codedOutputStream.writeMessage(5, getResourceAttributes());
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ AuthorizationInfo(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(AuthorizationInfo authorizationInfo) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(authorizationInfo);
    }

    public static AuthorizationInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthorizationInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AuthorizationInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private AuthorizationInfo(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static AuthorizationInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public AuthorizationInfo getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static AuthorizationInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private AuthorizationInfo() {
        this.memoizedIsInitialized = (byte) -1;
        this.resource_ = "";
        this.permission_ = "";
    }

    public static AuthorizationInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static AuthorizationInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static AuthorizationInfo parseFrom(InputStream inputStream) throws IOException {
        return (AuthorizationInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static AuthorizationInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthorizationInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    private AuthorizationInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.resource_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.permission_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 24) {
                                this.granted_ = codedInputStream.readBool();
                            } else if (readTag != 42) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                AttributeContext.Resource resource = this.resourceAttributes_;
                                AttributeContext.Resource.Builder builder = resource != null ? resource.toBuilder() : null;
                                AttributeContext.Resource resource2 = (AttributeContext.Resource) codedInputStream.readMessage(AttributeContext.Resource.parser(), extensionRegistryLite);
                                this.resourceAttributes_ = resource2;
                                if (builder != null) {
                                    builder.mergeFrom(resource2);
                                    this.resourceAttributes_ = builder.buildPartial();
                                }
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

    public static AuthorizationInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AuthorizationInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static AuthorizationInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthorizationInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
