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
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.Struct;
import com.google.protobuf.StructOrBuilder;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ServiceAccountDelegationInfo extends GeneratedMessageV3 implements ServiceAccountDelegationInfoOrBuilder {
    public static final int FIRST_PARTY_PRINCIPAL_FIELD_NUMBER = 1;
    public static final int PRINCIPAL_SUBJECT_FIELD_NUMBER = 3;
    public static final int THIRD_PARTY_PRINCIPAL_FIELD_NUMBER = 2;
    private static final long serialVersionUID = 0;
    private int authorityCase_;
    private Object authority_;
    private byte memoizedIsInitialized;
    private volatile Object principalSubject_;
    private static final ServiceAccountDelegationInfo DEFAULT_INSTANCE = new ServiceAccountDelegationInfo();
    private static final Parser<ServiceAccountDelegationInfo> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum AuthorityCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
        FIRST_PARTY_PRINCIPAL(1),
        THIRD_PARTY_PRINCIPAL(2),
        AUTHORITY_NOT_SET(0);

        private final int value;

        AuthorityCase(int i10) {
            this.value = i10;
        }

        public static AuthorityCase forNumber(int i10) {
            if (i10 == 0) {
                return AUTHORITY_NOT_SET;
            }
            if (i10 == 1) {
                return FIRST_PARTY_PRINCIPAL;
            }
            if (i10 != 2) {
                return null;
            }
            return THIRD_PARTY_PRINCIPAL;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static AuthorityCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ServiceAccountDelegationInfoOrBuilder {
        private int authorityCase_;
        private Object authority_;
        private SingleFieldBuilderV3<FirstPartyPrincipal, FirstPartyPrincipal.Builder, FirstPartyPrincipalOrBuilder> firstPartyPrincipalBuilder_;
        private Object principalSubject_;
        private SingleFieldBuilderV3<ThirdPartyPrincipal, ThirdPartyPrincipal.Builder, ThirdPartyPrincipalOrBuilder> thirdPartyPrincipalBuilder_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return w7.a.f54280k;
        }

        private SingleFieldBuilderV3<FirstPartyPrincipal, FirstPartyPrincipal.Builder, FirstPartyPrincipalOrBuilder> getFirstPartyPrincipalFieldBuilder() {
            if (this.firstPartyPrincipalBuilder_ == null) {
                if (this.authorityCase_ != 1) {
                    this.authority_ = FirstPartyPrincipal.getDefaultInstance();
                }
                this.firstPartyPrincipalBuilder_ = new SingleFieldBuilderV3<>((FirstPartyPrincipal) this.authority_, getParentForChildren(), isClean());
                this.authority_ = null;
            }
            this.authorityCase_ = 1;
            onChanged();
            return this.firstPartyPrincipalBuilder_;
        }

        private SingleFieldBuilderV3<ThirdPartyPrincipal, ThirdPartyPrincipal.Builder, ThirdPartyPrincipalOrBuilder> getThirdPartyPrincipalFieldBuilder() {
            if (this.thirdPartyPrincipalBuilder_ == null) {
                if (this.authorityCase_ != 2) {
                    this.authority_ = ThirdPartyPrincipal.getDefaultInstance();
                }
                this.thirdPartyPrincipalBuilder_ = new SingleFieldBuilderV3<>((ThirdPartyPrincipal) this.authority_, getParentForChildren(), isClean());
                this.authority_ = null;
            }
            this.authorityCase_ = 2;
            onChanged();
            return this.thirdPartyPrincipalBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public Builder clearAuthority() {
            this.authorityCase_ = 0;
            this.authority_ = null;
            onChanged();
            return this;
        }

        public Builder clearFirstPartyPrincipal() {
            SingleFieldBuilderV3<FirstPartyPrincipal, FirstPartyPrincipal.Builder, FirstPartyPrincipalOrBuilder> singleFieldBuilderV3 = this.firstPartyPrincipalBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.authorityCase_ == 1) {
                    this.authorityCase_ = 0;
                    this.authority_ = null;
                    onChanged();
                }
            } else {
                if (this.authorityCase_ == 1) {
                    this.authorityCase_ = 0;
                    this.authority_ = null;
                }
                singleFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearPrincipalSubject() {
            this.principalSubject_ = ServiceAccountDelegationInfo.getDefaultInstance().getPrincipalSubject();
            onChanged();
            return this;
        }

        public Builder clearThirdPartyPrincipal() {
            SingleFieldBuilderV3<ThirdPartyPrincipal, ThirdPartyPrincipal.Builder, ThirdPartyPrincipalOrBuilder> singleFieldBuilderV3 = this.thirdPartyPrincipalBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.authorityCase_ == 2) {
                    this.authorityCase_ = 0;
                    this.authority_ = null;
                    onChanged();
                }
            } else {
                if (this.authorityCase_ == 2) {
                    this.authorityCase_ = 0;
                    this.authority_ = null;
                }
                singleFieldBuilderV3.clear();
            }
            return this;
        }

        @Override // com.google.cloud.audit.ServiceAccountDelegationInfoOrBuilder
        public AuthorityCase getAuthorityCase() {
            return AuthorityCase.forNumber(this.authorityCase_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return w7.a.f54280k;
        }

        @Override // com.google.cloud.audit.ServiceAccountDelegationInfoOrBuilder
        public FirstPartyPrincipal getFirstPartyPrincipal() {
            SingleFieldBuilderV3<FirstPartyPrincipal, FirstPartyPrincipal.Builder, FirstPartyPrincipalOrBuilder> singleFieldBuilderV3 = this.firstPartyPrincipalBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.authorityCase_ == 1) {
                    return (FirstPartyPrincipal) this.authority_;
                }
                return FirstPartyPrincipal.getDefaultInstance();
            }
            if (this.authorityCase_ == 1) {
                return singleFieldBuilderV3.getMessage();
            }
            return FirstPartyPrincipal.getDefaultInstance();
        }

        public FirstPartyPrincipal.Builder getFirstPartyPrincipalBuilder() {
            return getFirstPartyPrincipalFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.ServiceAccountDelegationInfoOrBuilder
        public FirstPartyPrincipalOrBuilder getFirstPartyPrincipalOrBuilder() {
            SingleFieldBuilderV3<FirstPartyPrincipal, FirstPartyPrincipal.Builder, FirstPartyPrincipalOrBuilder> singleFieldBuilderV3;
            int i10 = this.authorityCase_;
            if (i10 == 1 && (singleFieldBuilderV3 = this.firstPartyPrincipalBuilder_) != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            if (i10 == 1) {
                return (FirstPartyPrincipal) this.authority_;
            }
            return FirstPartyPrincipal.getDefaultInstance();
        }

        @Override // com.google.cloud.audit.ServiceAccountDelegationInfoOrBuilder
        public String getPrincipalSubject() {
            Object obj = this.principalSubject_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.principalSubject_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.cloud.audit.ServiceAccountDelegationInfoOrBuilder
        public ByteString getPrincipalSubjectBytes() {
            Object obj = this.principalSubject_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.principalSubject_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.cloud.audit.ServiceAccountDelegationInfoOrBuilder
        public ThirdPartyPrincipal getThirdPartyPrincipal() {
            SingleFieldBuilderV3<ThirdPartyPrincipal, ThirdPartyPrincipal.Builder, ThirdPartyPrincipalOrBuilder> singleFieldBuilderV3 = this.thirdPartyPrincipalBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.authorityCase_ == 2) {
                    return (ThirdPartyPrincipal) this.authority_;
                }
                return ThirdPartyPrincipal.getDefaultInstance();
            }
            if (this.authorityCase_ == 2) {
                return singleFieldBuilderV3.getMessage();
            }
            return ThirdPartyPrincipal.getDefaultInstance();
        }

        public ThirdPartyPrincipal.Builder getThirdPartyPrincipalBuilder() {
            return getThirdPartyPrincipalFieldBuilder().getBuilder();
        }

        @Override // com.google.cloud.audit.ServiceAccountDelegationInfoOrBuilder
        public ThirdPartyPrincipalOrBuilder getThirdPartyPrincipalOrBuilder() {
            SingleFieldBuilderV3<ThirdPartyPrincipal, ThirdPartyPrincipal.Builder, ThirdPartyPrincipalOrBuilder> singleFieldBuilderV3;
            int i10 = this.authorityCase_;
            if (i10 == 2 && (singleFieldBuilderV3 = this.thirdPartyPrincipalBuilder_) != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            if (i10 == 2) {
                return (ThirdPartyPrincipal) this.authority_;
            }
            return ThirdPartyPrincipal.getDefaultInstance();
        }

        @Override // com.google.cloud.audit.ServiceAccountDelegationInfoOrBuilder
        public boolean hasFirstPartyPrincipal() {
            return this.authorityCase_ == 1;
        }

        @Override // com.google.cloud.audit.ServiceAccountDelegationInfoOrBuilder
        public boolean hasThirdPartyPrincipal() {
            return this.authorityCase_ == 2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return w7.a.f54281l.ensureFieldAccessorsInitialized(ServiceAccountDelegationInfo.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFirstPartyPrincipal(FirstPartyPrincipal firstPartyPrincipal) {
            SingleFieldBuilderV3<FirstPartyPrincipal, FirstPartyPrincipal.Builder, FirstPartyPrincipalOrBuilder> singleFieldBuilderV3 = this.firstPartyPrincipalBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.authorityCase_ == 1 && this.authority_ != FirstPartyPrincipal.getDefaultInstance()) {
                    this.authority_ = FirstPartyPrincipal.newBuilder((FirstPartyPrincipal) this.authority_).mergeFrom(firstPartyPrincipal).buildPartial();
                } else {
                    this.authority_ = firstPartyPrincipal;
                }
                onChanged();
            } else if (this.authorityCase_ == 1) {
                singleFieldBuilderV3.mergeFrom(firstPartyPrincipal);
            } else {
                singleFieldBuilderV3.setMessage(firstPartyPrincipal);
            }
            this.authorityCase_ = 1;
            return this;
        }

        public Builder mergeThirdPartyPrincipal(ThirdPartyPrincipal thirdPartyPrincipal) {
            SingleFieldBuilderV3<ThirdPartyPrincipal, ThirdPartyPrincipal.Builder, ThirdPartyPrincipalOrBuilder> singleFieldBuilderV3 = this.thirdPartyPrincipalBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.authorityCase_ == 2 && this.authority_ != ThirdPartyPrincipal.getDefaultInstance()) {
                    this.authority_ = ThirdPartyPrincipal.newBuilder((ThirdPartyPrincipal) this.authority_).mergeFrom(thirdPartyPrincipal).buildPartial();
                } else {
                    this.authority_ = thirdPartyPrincipal;
                }
                onChanged();
            } else if (this.authorityCase_ == 2) {
                singleFieldBuilderV3.mergeFrom(thirdPartyPrincipal);
            } else {
                singleFieldBuilderV3.setMessage(thirdPartyPrincipal);
            }
            this.authorityCase_ = 2;
            return this;
        }

        public Builder setFirstPartyPrincipal(FirstPartyPrincipal firstPartyPrincipal) {
            SingleFieldBuilderV3<FirstPartyPrincipal, FirstPartyPrincipal.Builder, FirstPartyPrincipalOrBuilder> singleFieldBuilderV3 = this.firstPartyPrincipalBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(firstPartyPrincipal);
                this.authority_ = firstPartyPrincipal;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(firstPartyPrincipal);
            }
            this.authorityCase_ = 1;
            return this;
        }

        public Builder setPrincipalSubject(String str) {
            Objects.requireNonNull(str);
            this.principalSubject_ = str;
            onChanged();
            return this;
        }

        public Builder setPrincipalSubjectBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.principalSubject_ = byteString;
            onChanged();
            return this;
        }

        public Builder setThirdPartyPrincipal(ThirdPartyPrincipal thirdPartyPrincipal) {
            SingleFieldBuilderV3<ThirdPartyPrincipal, ThirdPartyPrincipal.Builder, ThirdPartyPrincipalOrBuilder> singleFieldBuilderV3 = this.thirdPartyPrincipalBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(thirdPartyPrincipal);
                this.authority_ = thirdPartyPrincipal;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(thirdPartyPrincipal);
            }
            this.authorityCase_ = 2;
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        private Builder() {
            this.authorityCase_ = 0;
            this.principalSubject_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ServiceAccountDelegationInfo build() {
            ServiceAccountDelegationInfo buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ServiceAccountDelegationInfo buildPartial() {
            ServiceAccountDelegationInfo serviceAccountDelegationInfo = new ServiceAccountDelegationInfo(this, (a) null);
            serviceAccountDelegationInfo.principalSubject_ = this.principalSubject_;
            if (this.authorityCase_ == 1) {
                SingleFieldBuilderV3<FirstPartyPrincipal, FirstPartyPrincipal.Builder, FirstPartyPrincipalOrBuilder> singleFieldBuilderV3 = this.firstPartyPrincipalBuilder_;
                if (singleFieldBuilderV3 == null) {
                    serviceAccountDelegationInfo.authority_ = this.authority_;
                } else {
                    serviceAccountDelegationInfo.authority_ = singleFieldBuilderV3.build();
                }
            }
            if (this.authorityCase_ == 2) {
                SingleFieldBuilderV3<ThirdPartyPrincipal, ThirdPartyPrincipal.Builder, ThirdPartyPrincipalOrBuilder> singleFieldBuilderV32 = this.thirdPartyPrincipalBuilder_;
                if (singleFieldBuilderV32 == null) {
                    serviceAccountDelegationInfo.authority_ = this.authority_;
                } else {
                    serviceAccountDelegationInfo.authority_ = singleFieldBuilderV32.build();
                }
            }
            serviceAccountDelegationInfo.authorityCase_ = this.authorityCase_;
            onBuilt();
            return serviceAccountDelegationInfo;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ServiceAccountDelegationInfo getDefaultInstanceForType() {
            return ServiceAccountDelegationInfo.getDefaultInstance();
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
            this.principalSubject_ = "";
            this.authorityCase_ = 0;
            this.authority_ = null;
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.authorityCase_ = 0;
            this.principalSubject_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2458clone() {
            return (Builder) super.mo2458clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ServiceAccountDelegationInfo) {
                return mergeFrom((ServiceAccountDelegationInfo) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setFirstPartyPrincipal(FirstPartyPrincipal.Builder builder) {
            SingleFieldBuilderV3<FirstPartyPrincipal, FirstPartyPrincipal.Builder, FirstPartyPrincipalOrBuilder> singleFieldBuilderV3 = this.firstPartyPrincipalBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.authority_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.authorityCase_ = 1;
            return this;
        }

        public Builder setThirdPartyPrincipal(ThirdPartyPrincipal.Builder builder) {
            SingleFieldBuilderV3<ThirdPartyPrincipal, ThirdPartyPrincipal.Builder, ThirdPartyPrincipalOrBuilder> singleFieldBuilderV3 = this.thirdPartyPrincipalBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.authority_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.authorityCase_ = 2;
            return this;
        }

        public Builder mergeFrom(ServiceAccountDelegationInfo serviceAccountDelegationInfo) {
            if (serviceAccountDelegationInfo == ServiceAccountDelegationInfo.getDefaultInstance()) {
                return this;
            }
            if (!serviceAccountDelegationInfo.getPrincipalSubject().isEmpty()) {
                this.principalSubject_ = serviceAccountDelegationInfo.principalSubject_;
                onChanged();
            }
            int i10 = b.f25934a[serviceAccountDelegationInfo.getAuthorityCase().ordinal()];
            if (i10 == 1) {
                mergeFirstPartyPrincipal(serviceAccountDelegationInfo.getFirstPartyPrincipal());
            } else if (i10 == 2) {
                mergeThirdPartyPrincipal(serviceAccountDelegationInfo.getThirdPartyPrincipal());
            }
            mergeUnknownFields(serviceAccountDelegationInfo.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.cloud.audit.ServiceAccountDelegationInfo.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.cloud.audit.ServiceAccountDelegationInfo.access$2600()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.cloud.audit.ServiceAccountDelegationInfo r3 = (com.google.cloud.audit.ServiceAccountDelegationInfo) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.cloud.audit.ServiceAccountDelegationInfo r4 = (com.google.cloud.audit.ServiceAccountDelegationInfo) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.cloud.audit.ServiceAccountDelegationInfo.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.cloud.audit.ServiceAccountDelegationInfo$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class FirstPartyPrincipal extends GeneratedMessageV3 implements FirstPartyPrincipalOrBuilder {
        private static final FirstPartyPrincipal DEFAULT_INSTANCE = new FirstPartyPrincipal();
        private static final Parser<FirstPartyPrincipal> PARSER = new a();
        public static final int PRINCIPAL_EMAIL_FIELD_NUMBER = 1;
        public static final int SERVICE_METADATA_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private volatile Object principalEmail_;
        private Struct serviceMetadata_;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FirstPartyPrincipalOrBuilder {
            private Object principalEmail_;
            private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> serviceMetadataBuilder_;
            private Struct serviceMetadata_;

            public /* synthetic */ Builder(a aVar) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return w7.a.f54282m;
            }

            private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getServiceMetadataFieldBuilder() {
                if (this.serviceMetadataBuilder_ == null) {
                    this.serviceMetadataBuilder_ = new SingleFieldBuilderV3<>(getServiceMetadata(), getParentForChildren(), isClean());
                    this.serviceMetadata_ = null;
                }
                return this.serviceMetadataBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearPrincipalEmail() {
                this.principalEmail_ = FirstPartyPrincipal.getDefaultInstance().getPrincipalEmail();
                onChanged();
                return this;
            }

            public Builder clearServiceMetadata() {
                if (this.serviceMetadataBuilder_ == null) {
                    this.serviceMetadata_ = null;
                    onChanged();
                } else {
                    this.serviceMetadata_ = null;
                    this.serviceMetadataBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return w7.a.f54282m;
            }

            @Override // com.google.cloud.audit.ServiceAccountDelegationInfo.FirstPartyPrincipalOrBuilder
            public String getPrincipalEmail() {
                Object obj = this.principalEmail_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.principalEmail_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.cloud.audit.ServiceAccountDelegationInfo.FirstPartyPrincipalOrBuilder
            public ByteString getPrincipalEmailBytes() {
                Object obj = this.principalEmail_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.principalEmail_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.cloud.audit.ServiceAccountDelegationInfo.FirstPartyPrincipalOrBuilder
            public Struct getServiceMetadata() {
                SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.serviceMetadataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Struct struct = this.serviceMetadata_;
                    return struct == null ? Struct.getDefaultInstance() : struct;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Struct.Builder getServiceMetadataBuilder() {
                onChanged();
                return getServiceMetadataFieldBuilder().getBuilder();
            }

            @Override // com.google.cloud.audit.ServiceAccountDelegationInfo.FirstPartyPrincipalOrBuilder
            public StructOrBuilder getServiceMetadataOrBuilder() {
                SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.serviceMetadataBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Struct struct = this.serviceMetadata_;
                return struct == null ? Struct.getDefaultInstance() : struct;
            }

            @Override // com.google.cloud.audit.ServiceAccountDelegationInfo.FirstPartyPrincipalOrBuilder
            public boolean hasServiceMetadata() {
                return (this.serviceMetadataBuilder_ == null && this.serviceMetadata_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return w7.a.f54283n.ensureFieldAccessorsInitialized(FirstPartyPrincipal.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeServiceMetadata(Struct struct) {
                SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.serviceMetadataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Struct struct2 = this.serviceMetadata_;
                    if (struct2 != null) {
                        this.serviceMetadata_ = Struct.newBuilder(struct2).mergeFrom(struct).buildPartial();
                    } else {
                        this.serviceMetadata_ = struct;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(struct);
                }
                return this;
            }

            public Builder setPrincipalEmail(String str) {
                Objects.requireNonNull(str);
                this.principalEmail_ = str;
                onChanged();
                return this;
            }

            public Builder setPrincipalEmailBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.principalEmail_ = byteString;
                onChanged();
                return this;
            }

            public Builder setServiceMetadata(Struct struct) {
                SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.serviceMetadataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Objects.requireNonNull(struct);
                    this.serviceMetadata_ = struct;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(struct);
                }
                return this;
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
                this(builderParent);
            }

            private Builder() {
                this.principalEmail_ = "";
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FirstPartyPrincipal build() {
                FirstPartyPrincipal buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FirstPartyPrincipal buildPartial() {
                FirstPartyPrincipal firstPartyPrincipal = new FirstPartyPrincipal(this, (a) null);
                firstPartyPrincipal.principalEmail_ = this.principalEmail_;
                SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.serviceMetadataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    firstPartyPrincipal.serviceMetadata_ = this.serviceMetadata_;
                } else {
                    firstPartyPrincipal.serviceMetadata_ = singleFieldBuilderV3.build();
                }
                onBuilt();
                return firstPartyPrincipal;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FirstPartyPrincipal getDefaultInstanceForType() {
                return FirstPartyPrincipal.getDefaultInstance();
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
                this.principalEmail_ = "";
                if (this.serviceMetadataBuilder_ == null) {
                    this.serviceMetadata_ = null;
                } else {
                    this.serviceMetadata_ = null;
                    this.serviceMetadataBuilder_ = null;
                }
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.principalEmail_ = "";
                maybeForceBuilderInitialization();
            }

            public Builder setServiceMetadata(Struct.Builder builder) {
                SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.serviceMetadataBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.serviceMetadata_ = builder.build();
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
                if (message instanceof FirstPartyPrincipal) {
                    return mergeFrom((FirstPartyPrincipal) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(FirstPartyPrincipal firstPartyPrincipal) {
                if (firstPartyPrincipal == FirstPartyPrincipal.getDefaultInstance()) {
                    return this;
                }
                if (!firstPartyPrincipal.getPrincipalEmail().isEmpty()) {
                    this.principalEmail_ = firstPartyPrincipal.principalEmail_;
                    onChanged();
                }
                if (firstPartyPrincipal.hasServiceMetadata()) {
                    mergeServiceMetadata(firstPartyPrincipal.getServiceMetadata());
                }
                mergeUnknownFields(firstPartyPrincipal.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.google.cloud.audit.ServiceAccountDelegationInfo.FirstPartyPrincipal.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.google.cloud.audit.ServiceAccountDelegationInfo.FirstPartyPrincipal.access$700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.google.cloud.audit.ServiceAccountDelegationInfo$FirstPartyPrincipal r3 = (com.google.cloud.audit.ServiceAccountDelegationInfo.FirstPartyPrincipal) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.google.cloud.audit.ServiceAccountDelegationInfo$FirstPartyPrincipal r4 = (com.google.cloud.audit.ServiceAccountDelegationInfo.FirstPartyPrincipal) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.google.cloud.audit.ServiceAccountDelegationInfo.FirstPartyPrincipal.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.cloud.audit.ServiceAccountDelegationInfo$FirstPartyPrincipal$Builder");
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class a extends AbstractParser<FirstPartyPrincipal> {
            @Override // com.google.protobuf.Parser
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public FirstPartyPrincipal parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new FirstPartyPrincipal(codedInputStream, extensionRegistryLite, null);
            }
        }

        public /* synthetic */ FirstPartyPrincipal(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static FirstPartyPrincipal getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return w7.a.f54282m;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static FirstPartyPrincipal parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FirstPartyPrincipal) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static FirstPartyPrincipal parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<FirstPartyPrincipal> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FirstPartyPrincipal)) {
                return super.equals(obj);
            }
            FirstPartyPrincipal firstPartyPrincipal = (FirstPartyPrincipal) obj;
            if (getPrincipalEmail().equals(firstPartyPrincipal.getPrincipalEmail()) && hasServiceMetadata() == firstPartyPrincipal.hasServiceMetadata()) {
                return (!hasServiceMetadata() || getServiceMetadata().equals(firstPartyPrincipal.getServiceMetadata())) && this.unknownFields.equals(firstPartyPrincipal.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FirstPartyPrincipal> getParserForType() {
            return PARSER;
        }

        @Override // com.google.cloud.audit.ServiceAccountDelegationInfo.FirstPartyPrincipalOrBuilder
        public String getPrincipalEmail() {
            Object obj = this.principalEmail_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.principalEmail_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.cloud.audit.ServiceAccountDelegationInfo.FirstPartyPrincipalOrBuilder
        public ByteString getPrincipalEmailBytes() {
            Object obj = this.principalEmail_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.principalEmail_ = copyFromUtf8;
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
            int computeStringSize = GeneratedMessageV3.isStringEmpty(this.principalEmail_) ? 0 : 0 + GeneratedMessageV3.computeStringSize(1, this.principalEmail_);
            if (this.serviceMetadata_ != null) {
                computeStringSize += CodedOutputStream.computeMessageSize(2, getServiceMetadata());
            }
            int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.cloud.audit.ServiceAccountDelegationInfo.FirstPartyPrincipalOrBuilder
        public Struct getServiceMetadata() {
            Struct struct = this.serviceMetadata_;
            return struct == null ? Struct.getDefaultInstance() : struct;
        }

        @Override // com.google.cloud.audit.ServiceAccountDelegationInfo.FirstPartyPrincipalOrBuilder
        public StructOrBuilder getServiceMetadataOrBuilder() {
            return getServiceMetadata();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.cloud.audit.ServiceAccountDelegationInfo.FirstPartyPrincipalOrBuilder
        public boolean hasServiceMetadata() {
            return this.serviceMetadata_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getPrincipalEmail().hashCode();
            if (hasServiceMetadata()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getServiceMetadata().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return w7.a.f54283n.ensureFieldAccessorsInitialized(FirstPartyPrincipal.class, Builder.class);
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
            return new FirstPartyPrincipal();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!GeneratedMessageV3.isStringEmpty(this.principalEmail_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.principalEmail_);
            }
            if (this.serviceMetadata_ != null) {
                codedOutputStream.writeMessage(2, getServiceMetadata());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public /* synthetic */ FirstPartyPrincipal(GeneratedMessageV3.Builder builder, a aVar) {
            this(builder);
        }

        public static Builder newBuilder(FirstPartyPrincipal firstPartyPrincipal) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(firstPartyPrincipal);
        }

        public static FirstPartyPrincipal parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FirstPartyPrincipal) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static FirstPartyPrincipal parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private FirstPartyPrincipal(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static FirstPartyPrincipal parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FirstPartyPrincipal getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            a aVar = null;
            return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
        }

        public static FirstPartyPrincipal parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private FirstPartyPrincipal() {
            this.memoizedIsInitialized = (byte) -1;
            this.principalEmail_ = "";
        }

        public static FirstPartyPrincipal parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static FirstPartyPrincipal parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static FirstPartyPrincipal parseFrom(InputStream inputStream) throws IOException {
            return (FirstPartyPrincipal) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        private FirstPartyPrincipal(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            Objects.requireNonNull(extensionRegistryLite);
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 10) {
                                this.principalEmail_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag != 18) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                Struct struct = this.serviceMetadata_;
                                Struct.Builder builder = struct != null ? struct.toBuilder() : null;
                                Struct struct2 = (Struct) codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                                this.serviceMetadata_ = struct2;
                                if (builder != null) {
                                    builder.mergeFrom(struct2);
                                    this.serviceMetadata_ = builder.buildPartial();
                                }
                            }
                        }
                        z10 = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (UninitializedMessageException e10) {
                        throw e10.asInvalidProtocolBufferException().setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                    }
                } finally {
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static FirstPartyPrincipal parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FirstPartyPrincipal) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static FirstPartyPrincipal parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FirstPartyPrincipal) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static FirstPartyPrincipal parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FirstPartyPrincipal) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface FirstPartyPrincipalOrBuilder extends MessageOrBuilder {
        String getPrincipalEmail();

        ByteString getPrincipalEmailBytes();

        Struct getServiceMetadata();

        StructOrBuilder getServiceMetadataOrBuilder();

        boolean hasServiceMetadata();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class ThirdPartyPrincipal extends GeneratedMessageV3 implements ThirdPartyPrincipalOrBuilder {
        private static final ThirdPartyPrincipal DEFAULT_INSTANCE = new ThirdPartyPrincipal();
        private static final Parser<ThirdPartyPrincipal> PARSER = new a();
        public static final int THIRD_PARTY_CLAIMS_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private Struct thirdPartyClaims_;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ThirdPartyPrincipalOrBuilder {
            private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> thirdPartyClaimsBuilder_;
            private Struct thirdPartyClaims_;

            public /* synthetic */ Builder(a aVar) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return w7.a.f54284o;
            }

            private SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> getThirdPartyClaimsFieldBuilder() {
                if (this.thirdPartyClaimsBuilder_ == null) {
                    this.thirdPartyClaimsBuilder_ = new SingleFieldBuilderV3<>(getThirdPartyClaims(), getParentForChildren(), isClean());
                    this.thirdPartyClaims_ = null;
                }
                return this.thirdPartyClaimsBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearThirdPartyClaims() {
                if (this.thirdPartyClaimsBuilder_ == null) {
                    this.thirdPartyClaims_ = null;
                    onChanged();
                } else {
                    this.thirdPartyClaims_ = null;
                    this.thirdPartyClaimsBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return w7.a.f54284o;
            }

            @Override // com.google.cloud.audit.ServiceAccountDelegationInfo.ThirdPartyPrincipalOrBuilder
            public Struct getThirdPartyClaims() {
                SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.thirdPartyClaimsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Struct struct = this.thirdPartyClaims_;
                    return struct == null ? Struct.getDefaultInstance() : struct;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Struct.Builder getThirdPartyClaimsBuilder() {
                onChanged();
                return getThirdPartyClaimsFieldBuilder().getBuilder();
            }

            @Override // com.google.cloud.audit.ServiceAccountDelegationInfo.ThirdPartyPrincipalOrBuilder
            public StructOrBuilder getThirdPartyClaimsOrBuilder() {
                SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.thirdPartyClaimsBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Struct struct = this.thirdPartyClaims_;
                return struct == null ? Struct.getDefaultInstance() : struct;
            }

            @Override // com.google.cloud.audit.ServiceAccountDelegationInfo.ThirdPartyPrincipalOrBuilder
            public boolean hasThirdPartyClaims() {
                return (this.thirdPartyClaimsBuilder_ == null && this.thirdPartyClaims_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return w7.a.f54285p.ensureFieldAccessorsInitialized(ThirdPartyPrincipal.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeThirdPartyClaims(Struct struct) {
                SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.thirdPartyClaimsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Struct struct2 = this.thirdPartyClaims_;
                    if (struct2 != null) {
                        this.thirdPartyClaims_ = Struct.newBuilder(struct2).mergeFrom(struct).buildPartial();
                    } else {
                        this.thirdPartyClaims_ = struct;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(struct);
                }
                return this;
            }

            public Builder setThirdPartyClaims(Struct struct) {
                SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.thirdPartyClaimsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Objects.requireNonNull(struct);
                    this.thirdPartyClaims_ = struct;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(struct);
                }
                return this;
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
                this(builderParent);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ThirdPartyPrincipal build() {
                ThirdPartyPrincipal buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ThirdPartyPrincipal buildPartial() {
                ThirdPartyPrincipal thirdPartyPrincipal = new ThirdPartyPrincipal(this, (a) null);
                SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.thirdPartyClaimsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    thirdPartyPrincipal.thirdPartyClaims_ = this.thirdPartyClaims_;
                } else {
                    thirdPartyPrincipal.thirdPartyClaims_ = singleFieldBuilderV3.build();
                }
                onBuilt();
                return thirdPartyPrincipal;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ThirdPartyPrincipal getDefaultInstanceForType() {
                return ThirdPartyPrincipal.getDefaultInstance();
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
                if (this.thirdPartyClaimsBuilder_ == null) {
                    this.thirdPartyClaims_ = null;
                } else {
                    this.thirdPartyClaims_ = null;
                    this.thirdPartyClaimsBuilder_ = null;
                }
                return this;
            }

            public Builder setThirdPartyClaims(Struct.Builder builder) {
                SingleFieldBuilderV3<Struct, Struct.Builder, StructOrBuilder> singleFieldBuilderV3 = this.thirdPartyClaimsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.thirdPartyClaims_ = builder.build();
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
                if (message instanceof ThirdPartyPrincipal) {
                    return mergeFrom((ThirdPartyPrincipal) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(ThirdPartyPrincipal thirdPartyPrincipal) {
                if (thirdPartyPrincipal == ThirdPartyPrincipal.getDefaultInstance()) {
                    return this;
                }
                if (thirdPartyPrincipal.hasThirdPartyClaims()) {
                    mergeThirdPartyClaims(thirdPartyPrincipal.getThirdPartyClaims());
                }
                mergeUnknownFields(thirdPartyPrincipal.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.google.cloud.audit.ServiceAccountDelegationInfo.ThirdPartyPrincipal.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.google.cloud.audit.ServiceAccountDelegationInfo.ThirdPartyPrincipal.access$1600()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.google.cloud.audit.ServiceAccountDelegationInfo$ThirdPartyPrincipal r3 = (com.google.cloud.audit.ServiceAccountDelegationInfo.ThirdPartyPrincipal) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.google.cloud.audit.ServiceAccountDelegationInfo$ThirdPartyPrincipal r4 = (com.google.cloud.audit.ServiceAccountDelegationInfo.ThirdPartyPrincipal) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.google.cloud.audit.ServiceAccountDelegationInfo.ThirdPartyPrincipal.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.cloud.audit.ServiceAccountDelegationInfo$ThirdPartyPrincipal$Builder");
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class a extends AbstractParser<ThirdPartyPrincipal> {
            @Override // com.google.protobuf.Parser
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ThirdPartyPrincipal parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ThirdPartyPrincipal(codedInputStream, extensionRegistryLite, null);
            }
        }

        public /* synthetic */ ThirdPartyPrincipal(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static ThirdPartyPrincipal getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return w7.a.f54284o;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static ThirdPartyPrincipal parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ThirdPartyPrincipal) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static ThirdPartyPrincipal parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<ThirdPartyPrincipal> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ThirdPartyPrincipal)) {
                return super.equals(obj);
            }
            ThirdPartyPrincipal thirdPartyPrincipal = (ThirdPartyPrincipal) obj;
            if (hasThirdPartyClaims() != thirdPartyPrincipal.hasThirdPartyClaims()) {
                return false;
            }
            return (!hasThirdPartyClaims() || getThirdPartyClaims().equals(thirdPartyPrincipal.getThirdPartyClaims())) && this.unknownFields.equals(thirdPartyPrincipal.unknownFields);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ThirdPartyPrincipal> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeMessageSize = (this.thirdPartyClaims_ != null ? 0 + CodedOutputStream.computeMessageSize(1, getThirdPartyClaims()) : 0) + this.unknownFields.getSerializedSize();
            this.memoizedSize = computeMessageSize;
            return computeMessageSize;
        }

        @Override // com.google.cloud.audit.ServiceAccountDelegationInfo.ThirdPartyPrincipalOrBuilder
        public Struct getThirdPartyClaims() {
            Struct struct = this.thirdPartyClaims_;
            return struct == null ? Struct.getDefaultInstance() : struct;
        }

        @Override // com.google.cloud.audit.ServiceAccountDelegationInfo.ThirdPartyPrincipalOrBuilder
        public StructOrBuilder getThirdPartyClaimsOrBuilder() {
            return getThirdPartyClaims();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.cloud.audit.ServiceAccountDelegationInfo.ThirdPartyPrincipalOrBuilder
        public boolean hasThirdPartyClaims() {
            return this.thirdPartyClaims_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode();
            if (hasThirdPartyClaims()) {
                hashCode = (((hashCode * 37) + 1) * 53) + getThirdPartyClaims().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return w7.a.f54285p.ensureFieldAccessorsInitialized(ThirdPartyPrincipal.class, Builder.class);
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
            return new ThirdPartyPrincipal();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.thirdPartyClaims_ != null) {
                codedOutputStream.writeMessage(1, getThirdPartyClaims());
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public /* synthetic */ ThirdPartyPrincipal(GeneratedMessageV3.Builder builder, a aVar) {
            this(builder);
        }

        public static Builder newBuilder(ThirdPartyPrincipal thirdPartyPrincipal) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(thirdPartyPrincipal);
        }

        public static ThirdPartyPrincipal parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ThirdPartyPrincipal) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ThirdPartyPrincipal parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private ThirdPartyPrincipal(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ThirdPartyPrincipal parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ThirdPartyPrincipal getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            a aVar = null;
            return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
        }

        public static ThirdPartyPrincipal parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private ThirdPartyPrincipal() {
            this.memoizedIsInitialized = (byte) -1;
        }

        public static ThirdPartyPrincipal parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static ThirdPartyPrincipal parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        private ThirdPartyPrincipal(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                if (readTag != 10) {
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    Struct struct = this.thirdPartyClaims_;
                                    Struct.Builder builder = struct != null ? struct.toBuilder() : null;
                                    Struct struct2 = (Struct) codedInputStream.readMessage(Struct.parser(), extensionRegistryLite);
                                    this.thirdPartyClaims_ = struct2;
                                    if (builder != null) {
                                        builder.mergeFrom(struct2);
                                        this.thirdPartyClaims_ = builder.buildPartial();
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

        public static ThirdPartyPrincipal parseFrom(InputStream inputStream) throws IOException {
            return (ThirdPartyPrincipal) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static ThirdPartyPrincipal parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ThirdPartyPrincipal) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static ThirdPartyPrincipal parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ThirdPartyPrincipal) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static ThirdPartyPrincipal parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ThirdPartyPrincipal) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ThirdPartyPrincipalOrBuilder extends MessageOrBuilder {
        Struct getThirdPartyClaims();

        StructOrBuilder getThirdPartyClaimsOrBuilder();

        boolean hasThirdPartyClaims();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<ServiceAccountDelegationInfo> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ServiceAccountDelegationInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ServiceAccountDelegationInfo(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25934a;

        static {
            int[] iArr = new int[AuthorityCase.values().length];
            f25934a = iArr;
            try {
                iArr[AuthorityCase.FIRST_PARTY_PRINCIPAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25934a[AuthorityCase.THIRD_PARTY_PRINCIPAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25934a[AuthorityCase.AUTHORITY_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public /* synthetic */ ServiceAccountDelegationInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static ServiceAccountDelegationInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return w7.a.f54280k;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static ServiceAccountDelegationInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ServiceAccountDelegationInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ServiceAccountDelegationInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<ServiceAccountDelegationInfo> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ServiceAccountDelegationInfo)) {
            return super.equals(obj);
        }
        ServiceAccountDelegationInfo serviceAccountDelegationInfo = (ServiceAccountDelegationInfo) obj;
        if (!getPrincipalSubject().equals(serviceAccountDelegationInfo.getPrincipalSubject()) || !getAuthorityCase().equals(serviceAccountDelegationInfo.getAuthorityCase())) {
            return false;
        }
        int i10 = this.authorityCase_;
        if (i10 != 1) {
            if (i10 == 2 && !getThirdPartyPrincipal().equals(serviceAccountDelegationInfo.getThirdPartyPrincipal())) {
                return false;
            }
        } else if (!getFirstPartyPrincipal().equals(serviceAccountDelegationInfo.getFirstPartyPrincipal())) {
            return false;
        }
        return this.unknownFields.equals(serviceAccountDelegationInfo.unknownFields);
    }

    @Override // com.google.cloud.audit.ServiceAccountDelegationInfoOrBuilder
    public AuthorityCase getAuthorityCase() {
        return AuthorityCase.forNumber(this.authorityCase_);
    }

    @Override // com.google.cloud.audit.ServiceAccountDelegationInfoOrBuilder
    public FirstPartyPrincipal getFirstPartyPrincipal() {
        if (this.authorityCase_ == 1) {
            return (FirstPartyPrincipal) this.authority_;
        }
        return FirstPartyPrincipal.getDefaultInstance();
    }

    @Override // com.google.cloud.audit.ServiceAccountDelegationInfoOrBuilder
    public FirstPartyPrincipalOrBuilder getFirstPartyPrincipalOrBuilder() {
        if (this.authorityCase_ == 1) {
            return (FirstPartyPrincipal) this.authority_;
        }
        return FirstPartyPrincipal.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ServiceAccountDelegationInfo> getParserForType() {
        return PARSER;
    }

    @Override // com.google.cloud.audit.ServiceAccountDelegationInfoOrBuilder
    public String getPrincipalSubject() {
        Object obj = this.principalSubject_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.principalSubject_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.cloud.audit.ServiceAccountDelegationInfoOrBuilder
    public ByteString getPrincipalSubjectBytes() {
        Object obj = this.principalSubject_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.principalSubject_ = copyFromUtf8;
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
        int computeMessageSize = this.authorityCase_ == 1 ? 0 + CodedOutputStream.computeMessageSize(1, (FirstPartyPrincipal) this.authority_) : 0;
        if (this.authorityCase_ == 2) {
            computeMessageSize += CodedOutputStream.computeMessageSize(2, (ThirdPartyPrincipal) this.authority_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.principalSubject_)) {
            computeMessageSize += GeneratedMessageV3.computeStringSize(3, this.principalSubject_);
        }
        int serializedSize = computeMessageSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.cloud.audit.ServiceAccountDelegationInfoOrBuilder
    public ThirdPartyPrincipal getThirdPartyPrincipal() {
        if (this.authorityCase_ == 2) {
            return (ThirdPartyPrincipal) this.authority_;
        }
        return ThirdPartyPrincipal.getDefaultInstance();
    }

    @Override // com.google.cloud.audit.ServiceAccountDelegationInfoOrBuilder
    public ThirdPartyPrincipalOrBuilder getThirdPartyPrincipalOrBuilder() {
        if (this.authorityCase_ == 2) {
            return (ThirdPartyPrincipal) this.authority_;
        }
        return ThirdPartyPrincipal.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.cloud.audit.ServiceAccountDelegationInfoOrBuilder
    public boolean hasFirstPartyPrincipal() {
        return this.authorityCase_ == 1;
    }

    @Override // com.google.cloud.audit.ServiceAccountDelegationInfoOrBuilder
    public boolean hasThirdPartyPrincipal() {
        return this.authorityCase_ == 2;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10;
        int hashCode;
        int i11 = this.memoizedHashCode;
        if (i11 != 0) {
            return i11;
        }
        int hashCode2 = ((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 3) * 53) + getPrincipalSubject().hashCode();
        int i12 = this.authorityCase_;
        if (i12 == 1) {
            i10 = ((hashCode2 * 37) + 1) * 53;
            hashCode = getFirstPartyPrincipal().hashCode();
        } else {
            if (i12 == 2) {
                i10 = ((hashCode2 * 37) + 2) * 53;
                hashCode = getThirdPartyPrincipal().hashCode();
            }
            int hashCode3 = (hashCode2 * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode3;
            return hashCode3;
        }
        hashCode2 = i10 + hashCode;
        int hashCode32 = (hashCode2 * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode32;
        return hashCode32;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return w7.a.f54281l.ensureFieldAccessorsInitialized(ServiceAccountDelegationInfo.class, Builder.class);
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
        return new ServiceAccountDelegationInfo();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.authorityCase_ == 1) {
            codedOutputStream.writeMessage(1, (FirstPartyPrincipal) this.authority_);
        }
        if (this.authorityCase_ == 2) {
            codedOutputStream.writeMessage(2, (ThirdPartyPrincipal) this.authority_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.principalSubject_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.principalSubject_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ ServiceAccountDelegationInfo(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(ServiceAccountDelegationInfo serviceAccountDelegationInfo) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(serviceAccountDelegationInfo);
    }

    public static ServiceAccountDelegationInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ServiceAccountDelegationInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ServiceAccountDelegationInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private ServiceAccountDelegationInfo(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.authorityCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ServiceAccountDelegationInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ServiceAccountDelegationInfo getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static ServiceAccountDelegationInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static ServiceAccountDelegationInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    private ServiceAccountDelegationInfo() {
        this.authorityCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
        this.principalSubject_ = "";
    }

    public static ServiceAccountDelegationInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static ServiceAccountDelegationInfo parseFrom(InputStream inputStream) throws IOException {
        return (ServiceAccountDelegationInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ServiceAccountDelegationInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ServiceAccountDelegationInfo) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ServiceAccountDelegationInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ServiceAccountDelegationInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    private ServiceAccountDelegationInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        Objects.requireNonNull(extensionRegistryLite);
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            FirstPartyPrincipal.Builder builder = this.authorityCase_ == 1 ? ((FirstPartyPrincipal) this.authority_).toBuilder() : null;
                            MessageLite readMessage = codedInputStream.readMessage(FirstPartyPrincipal.parser(), extensionRegistryLite);
                            this.authority_ = readMessage;
                            if (builder != null) {
                                builder.mergeFrom((FirstPartyPrincipal) readMessage);
                                this.authority_ = builder.buildPartial();
                            }
                            this.authorityCase_ = 1;
                        } else if (readTag == 18) {
                            ThirdPartyPrincipal.Builder builder2 = this.authorityCase_ == 2 ? ((ThirdPartyPrincipal) this.authority_).toBuilder() : null;
                            MessageLite readMessage2 = codedInputStream.readMessage(ThirdPartyPrincipal.parser(), extensionRegistryLite);
                            this.authority_ = readMessage2;
                            if (builder2 != null) {
                                builder2.mergeFrom((ThirdPartyPrincipal) readMessage2);
                                this.authority_ = builder2.buildPartial();
                            }
                            this.authorityCase_ = 2;
                        } else if (readTag != 26) {
                            if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            this.principalSubject_ = codedInputStream.readStringRequireUtf8();
                        }
                    }
                    z10 = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (UninitializedMessageException e10) {
                    throw e10.asInvalidProtocolBufferException().setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new InvalidProtocolBufferException(e11).setUnfinishedMessage(this);
                }
            } finally {
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static ServiceAccountDelegationInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ServiceAccountDelegationInfo) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
