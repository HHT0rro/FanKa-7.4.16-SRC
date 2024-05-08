package com.google.api;

import com.android.internal.logging.nano.MetricsProto;
import com.google.android.material.shadow.ShadowDrawableWrapper;
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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;
import u7.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class BackendRule extends GeneratedMessageV3 implements BackendRuleOrBuilder {
    public static final int ADDRESS_FIELD_NUMBER = 2;
    public static final int DEADLINE_FIELD_NUMBER = 3;
    public static final int DISABLE_AUTH_FIELD_NUMBER = 8;
    public static final int JWT_AUDIENCE_FIELD_NUMBER = 7;
    public static final int MIN_DEADLINE_FIELD_NUMBER = 4;
    public static final int OPERATION_DEADLINE_FIELD_NUMBER = 5;
    public static final int PATH_TRANSLATION_FIELD_NUMBER = 6;
    public static final int PROTOCOL_FIELD_NUMBER = 9;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private volatile Object address_;
    private int authenticationCase_;
    private Object authentication_;
    private double deadline_;
    private byte memoizedIsInitialized;
    private double minDeadline_;
    private double operationDeadline_;
    private int pathTranslation_;
    private volatile Object protocol_;
    private volatile Object selector_;
    private static final BackendRule DEFAULT_INSTANCE = new BackendRule();
    private static final Parser<BackendRule> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum AuthenticationCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
        JWT_AUDIENCE(7),
        DISABLE_AUTH(8),
        AUTHENTICATION_NOT_SET(0);

        private final int value;

        AuthenticationCase(int i10) {
            this.value = i10;
        }

        public static AuthenticationCase forNumber(int i10) {
            if (i10 == 0) {
                return AUTHENTICATION_NOT_SET;
            }
            if (i10 == 7) {
                return JWT_AUDIENCE;
            }
            if (i10 != 8) {
                return null;
            }
            return DISABLE_AUTH;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static AuthenticationCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BackendRuleOrBuilder {
        private Object address_;
        private int authenticationCase_;
        private Object authentication_;
        private double deadline_;
        private double minDeadline_;
        private double operationDeadline_;
        private int pathTranslation_;
        private Object protocol_;
        private Object selector_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return c.f53852c;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public Builder clearAddress() {
            this.address_ = BackendRule.getDefaultInstance().getAddress();
            onChanged();
            return this;
        }

        public Builder clearAuthentication() {
            this.authenticationCase_ = 0;
            this.authentication_ = null;
            onChanged();
            return this;
        }

        public Builder clearDeadline() {
            this.deadline_ = ShadowDrawableWrapper.COS_45;
            onChanged();
            return this;
        }

        public Builder clearDisableAuth() {
            if (this.authenticationCase_ == 8) {
                this.authenticationCase_ = 0;
                this.authentication_ = null;
                onChanged();
            }
            return this;
        }

        public Builder clearJwtAudience() {
            if (this.authenticationCase_ == 7) {
                this.authenticationCase_ = 0;
                this.authentication_ = null;
                onChanged();
            }
            return this;
        }

        public Builder clearMinDeadline() {
            this.minDeadline_ = ShadowDrawableWrapper.COS_45;
            onChanged();
            return this;
        }

        public Builder clearOperationDeadline() {
            this.operationDeadline_ = ShadowDrawableWrapper.COS_45;
            onChanged();
            return this;
        }

        public Builder clearPathTranslation() {
            this.pathTranslation_ = 0;
            onChanged();
            return this;
        }

        public Builder clearProtocol() {
            this.protocol_ = BackendRule.getDefaultInstance().getProtocol();
            onChanged();
            return this;
        }

        public Builder clearSelector() {
            this.selector_ = BackendRule.getDefaultInstance().getSelector();
            onChanged();
            return this;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public String getAddress() {
            Object obj = this.address_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.address_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public ByteString getAddressBytes() {
            Object obj = this.address_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.address_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public AuthenticationCase getAuthenticationCase() {
            return AuthenticationCase.forNumber(this.authenticationCase_);
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public double getDeadline() {
            return this.deadline_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return c.f53852c;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public boolean getDisableAuth() {
            if (this.authenticationCase_ == 8) {
                return ((Boolean) this.authentication_).booleanValue();
            }
            return false;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public String getJwtAudience() {
            String str = this.authenticationCase_ == 7 ? this.authentication_ : "";
            if (!(str instanceof String)) {
                String stringUtf8 = ((ByteString) str).toStringUtf8();
                if (this.authenticationCase_ == 7) {
                    this.authentication_ = stringUtf8;
                }
                return stringUtf8;
            }
            return (String) str;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public ByteString getJwtAudienceBytes() {
            String str = this.authenticationCase_ == 7 ? this.authentication_ : "";
            if (str instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
                if (this.authenticationCase_ == 7) {
                    this.authentication_ = copyFromUtf8;
                }
                return copyFromUtf8;
            }
            return (ByteString) str;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public double getMinDeadline() {
            return this.minDeadline_;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public double getOperationDeadline() {
            return this.operationDeadline_;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public PathTranslation getPathTranslation() {
            PathTranslation valueOf = PathTranslation.valueOf(this.pathTranslation_);
            return valueOf == null ? PathTranslation.UNRECOGNIZED : valueOf;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public int getPathTranslationValue() {
            return this.pathTranslation_;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public String getProtocol() {
            Object obj = this.protocol_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.protocol_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public ByteString getProtocolBytes() {
            Object obj = this.protocol_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.protocol_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public String getSelector() {
            Object obj = this.selector_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.selector_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public ByteString getSelectorBytes() {
            Object obj = this.selector_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.selector_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public boolean hasDisableAuth() {
            return this.authenticationCase_ == 8;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public boolean hasJwtAudience() {
            return this.authenticationCase_ == 7;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return c.f53853d.ensureFieldAccessorsInitialized(BackendRule.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder setAddress(String str) {
            Objects.requireNonNull(str);
            this.address_ = str;
            onChanged();
            return this;
        }

        public Builder setAddressBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.address_ = byteString;
            onChanged();
            return this;
        }

        public Builder setDeadline(double d10) {
            this.deadline_ = d10;
            onChanged();
            return this;
        }

        public Builder setDisableAuth(boolean z10) {
            this.authenticationCase_ = 8;
            this.authentication_ = Boolean.valueOf(z10);
            onChanged();
            return this;
        }

        public Builder setJwtAudience(String str) {
            Objects.requireNonNull(str);
            this.authenticationCase_ = 7;
            this.authentication_ = str;
            onChanged();
            return this;
        }

        public Builder setJwtAudienceBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.authenticationCase_ = 7;
            this.authentication_ = byteString;
            onChanged();
            return this;
        }

        public Builder setMinDeadline(double d10) {
            this.minDeadline_ = d10;
            onChanged();
            return this;
        }

        public Builder setOperationDeadline(double d10) {
            this.operationDeadline_ = d10;
            onChanged();
            return this;
        }

        public Builder setPathTranslation(PathTranslation pathTranslation) {
            Objects.requireNonNull(pathTranslation);
            this.pathTranslation_ = pathTranslation.getNumber();
            onChanged();
            return this;
        }

        public Builder setPathTranslationValue(int i10) {
            this.pathTranslation_ = i10;
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

        public Builder setSelector(String str) {
            Objects.requireNonNull(str);
            this.selector_ = str;
            onChanged();
            return this;
        }

        public Builder setSelectorBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.selector_ = byteString;
            onChanged();
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        private Builder() {
            this.authenticationCase_ = 0;
            this.selector_ = "";
            this.address_ = "";
            this.pathTranslation_ = 0;
            this.protocol_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BackendRule build() {
            BackendRule buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BackendRule buildPartial() {
            BackendRule backendRule = new BackendRule(this, (a) null);
            backendRule.selector_ = this.selector_;
            backendRule.address_ = this.address_;
            backendRule.deadline_ = this.deadline_;
            backendRule.minDeadline_ = this.minDeadline_;
            backendRule.operationDeadline_ = this.operationDeadline_;
            backendRule.pathTranslation_ = this.pathTranslation_;
            if (this.authenticationCase_ == 7) {
                backendRule.authentication_ = this.authentication_;
            }
            if (this.authenticationCase_ == 8) {
                backendRule.authentication_ = this.authentication_;
            }
            backendRule.protocol_ = this.protocol_;
            backendRule.authenticationCase_ = this.authenticationCase_;
            onBuilt();
            return backendRule;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BackendRule getDefaultInstanceForType() {
            return BackendRule.getDefaultInstance();
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
            this.selector_ = "";
            this.address_ = "";
            this.deadline_ = ShadowDrawableWrapper.COS_45;
            this.minDeadline_ = ShadowDrawableWrapper.COS_45;
            this.operationDeadline_ = ShadowDrawableWrapper.COS_45;
            this.pathTranslation_ = 0;
            this.protocol_ = "";
            this.authenticationCase_ = 0;
            this.authentication_ = null;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2458clone() {
            return (Builder) super.mo2458clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof BackendRule) {
                return mergeFrom((BackendRule) message);
            }
            super.mergeFrom(message);
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.authenticationCase_ = 0;
            this.selector_ = "";
            this.address_ = "";
            this.pathTranslation_ = 0;
            this.protocol_ = "";
            maybeForceBuilderInitialization();
        }

        public Builder mergeFrom(BackendRule backendRule) {
            if (backendRule == BackendRule.getDefaultInstance()) {
                return this;
            }
            if (!backendRule.getSelector().isEmpty()) {
                this.selector_ = backendRule.selector_;
                onChanged();
            }
            if (!backendRule.getAddress().isEmpty()) {
                this.address_ = backendRule.address_;
                onChanged();
            }
            if (backendRule.getDeadline() != ShadowDrawableWrapper.COS_45) {
                setDeadline(backendRule.getDeadline());
            }
            if (backendRule.getMinDeadline() != ShadowDrawableWrapper.COS_45) {
                setMinDeadline(backendRule.getMinDeadline());
            }
            if (backendRule.getOperationDeadline() != ShadowDrawableWrapper.COS_45) {
                setOperationDeadline(backendRule.getOperationDeadline());
            }
            if (backendRule.pathTranslation_ != 0) {
                setPathTranslationValue(backendRule.getPathTranslationValue());
            }
            if (!backendRule.getProtocol().isEmpty()) {
                this.protocol_ = backendRule.protocol_;
                onChanged();
            }
            int i10 = b.f25925a[backendRule.getAuthenticationCase().ordinal()];
            if (i10 == 1) {
                this.authenticationCase_ = 7;
                this.authentication_ = backendRule.authentication_;
                onChanged();
            } else if (i10 == 2) {
                setDisableAuth(backendRule.getDisableAuth());
            }
            mergeUnknownFields(backendRule.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.api.BackendRule.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.api.BackendRule.access$1400()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.api.BackendRule r3 = (com.google.api.BackendRule) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.api.BackendRule r4 = (com.google.api.BackendRule) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.BackendRule.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.BackendRule$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum PathTranslation implements ProtocolMessageEnum {
        PATH_TRANSLATION_UNSPECIFIED(0),
        CONSTANT_ADDRESS(1),
        APPEND_PATH_TO_ADDRESS(2),
        UNRECOGNIZED(-1);

        public static final int APPEND_PATH_TO_ADDRESS_VALUE = 2;
        public static final int CONSTANT_ADDRESS_VALUE = 1;
        public static final int PATH_TRANSLATION_UNSPECIFIED_VALUE = 0;
        private final int value;
        private static final Internal.EnumLiteMap<PathTranslation> internalValueMap = new a();
        private static final PathTranslation[] VALUES = values();

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class a implements Internal.EnumLiteMap<PathTranslation> {
            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public PathTranslation findValueByNumber(int i10) {
                return PathTranslation.forNumber(i10);
            }
        }

        PathTranslation(int i10) {
            this.value = i10;
        }

        public static PathTranslation forNumber(int i10) {
            if (i10 == 0) {
                return PATH_TRANSLATION_UNSPECIFIED;
            }
            if (i10 == 1) {
                return CONSTANT_ADDRESS;
            }
            if (i10 != 2) {
                return null;
            }
            return APPEND_PATH_TO_ADDRESS;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return BackendRule.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<PathTranslation> internalGetValueMap() {
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
        public static PathTranslation valueOf(int i10) {
            return forNumber(i10);
        }

        public static PathTranslation valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                if (enumValueDescriptor.getIndex() == -1) {
                    return UNRECOGNIZED;
                }
                return VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<BackendRule> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackendRule parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new BackendRule(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25925a;

        static {
            int[] iArr = new int[AuthenticationCase.values().length];
            f25925a = iArr;
            try {
                iArr[AuthenticationCase.JWT_AUDIENCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25925a[AuthenticationCase.DISABLE_AUTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25925a[AuthenticationCase.AUTHENTICATION_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public /* synthetic */ BackendRule(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static BackendRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return c.f53852c;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static BackendRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (BackendRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static BackendRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<BackendRule> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendRule)) {
            return super.equals(obj);
        }
        BackendRule backendRule = (BackendRule) obj;
        if (!getSelector().equals(backendRule.getSelector()) || !getAddress().equals(backendRule.getAddress()) || Double.doubleToLongBits(getDeadline()) != Double.doubleToLongBits(backendRule.getDeadline()) || Double.doubleToLongBits(getMinDeadline()) != Double.doubleToLongBits(backendRule.getMinDeadline()) || Double.doubleToLongBits(getOperationDeadline()) != Double.doubleToLongBits(backendRule.getOperationDeadline()) || this.pathTranslation_ != backendRule.pathTranslation_ || !getProtocol().equals(backendRule.getProtocol()) || !getAuthenticationCase().equals(backendRule.getAuthenticationCase())) {
            return false;
        }
        int i10 = this.authenticationCase_;
        if (i10 != 7) {
            if (i10 == 8 && getDisableAuth() != backendRule.getDisableAuth()) {
                return false;
            }
        } else if (!getJwtAudience().equals(backendRule.getJwtAudience())) {
            return false;
        }
        return this.unknownFields.equals(backendRule.unknownFields);
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public String getAddress() {
        Object obj = this.address_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.address_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public ByteString getAddressBytes() {
        Object obj = this.address_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.address_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public AuthenticationCase getAuthenticationCase() {
        return AuthenticationCase.forNumber(this.authenticationCase_);
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public double getDeadline() {
        return this.deadline_;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public boolean getDisableAuth() {
        if (this.authenticationCase_ == 8) {
            return ((Boolean) this.authentication_).booleanValue();
        }
        return false;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public String getJwtAudience() {
        String str = this.authenticationCase_ == 7 ? this.authentication_ : "";
        if (str instanceof String) {
            return (String) str;
        }
        String stringUtf8 = ((ByteString) str).toStringUtf8();
        if (this.authenticationCase_ == 7) {
            this.authentication_ = stringUtf8;
        }
        return stringUtf8;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public ByteString getJwtAudienceBytes() {
        String str = this.authenticationCase_ == 7 ? this.authentication_ : "";
        if (str instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) str);
            if (this.authenticationCase_ == 7) {
                this.authentication_ = copyFromUtf8;
            }
            return copyFromUtf8;
        }
        return (ByteString) str;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public double getMinDeadline() {
        return this.minDeadline_;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public double getOperationDeadline() {
        return this.operationDeadline_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<BackendRule> getParserForType() {
        return PARSER;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public PathTranslation getPathTranslation() {
        PathTranslation valueOf = PathTranslation.valueOf(this.pathTranslation_);
        return valueOf == null ? PathTranslation.UNRECOGNIZED : valueOf;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public int getPathTranslationValue() {
        return this.pathTranslation_;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public String getProtocol() {
        Object obj = this.protocol_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.protocol_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public ByteString getProtocolBytes() {
        Object obj = this.protocol_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.protocol_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public String getSelector() {
        Object obj = this.selector_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.selector_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public ByteString getSelectorBytes() {
        Object obj = this.selector_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.selector_ = copyFromUtf8;
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
        int computeStringSize = GeneratedMessageV3.isStringEmpty(this.selector_) ? 0 : 0 + GeneratedMessageV3.computeStringSize(1, this.selector_);
        if (!GeneratedMessageV3.isStringEmpty(this.address_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(2, this.address_);
        }
        if (Double.doubleToRawLongBits(this.deadline_) != 0) {
            computeStringSize += CodedOutputStream.computeDoubleSize(3, this.deadline_);
        }
        if (Double.doubleToRawLongBits(this.minDeadline_) != 0) {
            computeStringSize += CodedOutputStream.computeDoubleSize(4, this.minDeadline_);
        }
        if (Double.doubleToRawLongBits(this.operationDeadline_) != 0) {
            computeStringSize += CodedOutputStream.computeDoubleSize(5, this.operationDeadline_);
        }
        if (this.pathTranslation_ != PathTranslation.PATH_TRANSLATION_UNSPECIFIED.getNumber()) {
            computeStringSize += CodedOutputStream.computeEnumSize(6, this.pathTranslation_);
        }
        if (this.authenticationCase_ == 7) {
            computeStringSize += GeneratedMessageV3.computeStringSize(7, this.authentication_);
        }
        if (this.authenticationCase_ == 8) {
            computeStringSize += CodedOutputStream.computeBoolSize(8, ((Boolean) this.authentication_).booleanValue());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.protocol_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(9, this.protocol_);
        }
        int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public boolean hasDisableAuth() {
        return this.authenticationCase_ == 8;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public boolean hasJwtAudience() {
        return this.authenticationCase_ == 7;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10;
        int hashCode;
        int i11 = this.memoizedHashCode;
        if (i11 != 0) {
            return i11;
        }
        int hashCode2 = ((((((((((((((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getSelector().hashCode()) * 37) + 2) * 53) + getAddress().hashCode()) * 37) + 3) * 53) + Internal.hashLong(Double.doubleToLongBits(getDeadline()))) * 37) + 4) * 53) + Internal.hashLong(Double.doubleToLongBits(getMinDeadline()))) * 37) + 5) * 53) + Internal.hashLong(Double.doubleToLongBits(getOperationDeadline()))) * 37) + 6) * 53) + this.pathTranslation_) * 37) + 9) * 53) + getProtocol().hashCode();
        int i12 = this.authenticationCase_;
        if (i12 == 7) {
            i10 = ((hashCode2 * 37) + 7) * 53;
            hashCode = getJwtAudience().hashCode();
        } else {
            if (i12 == 8) {
                i10 = ((hashCode2 * 37) + 8) * 53;
                hashCode = Internal.hashBoolean(getDisableAuth());
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
        return c.f53853d.ensureFieldAccessorsInitialized(BackendRule.class, Builder.class);
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
        return new BackendRule();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!GeneratedMessageV3.isStringEmpty(this.selector_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.selector_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.address_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.address_);
        }
        if (Double.doubleToRawLongBits(this.deadline_) != 0) {
            codedOutputStream.writeDouble(3, this.deadline_);
        }
        if (Double.doubleToRawLongBits(this.minDeadline_) != 0) {
            codedOutputStream.writeDouble(4, this.minDeadline_);
        }
        if (Double.doubleToRawLongBits(this.operationDeadline_) != 0) {
            codedOutputStream.writeDouble(5, this.operationDeadline_);
        }
        if (this.pathTranslation_ != PathTranslation.PATH_TRANSLATION_UNSPECIFIED.getNumber()) {
            codedOutputStream.writeEnum(6, this.pathTranslation_);
        }
        if (this.authenticationCase_ == 7) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.authentication_);
        }
        if (this.authenticationCase_ == 8) {
            codedOutputStream.writeBool(8, ((Boolean) this.authentication_).booleanValue());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.protocol_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 9, this.protocol_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ BackendRule(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(BackendRule backendRule) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(backendRule);
    }

    public static BackendRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BackendRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BackendRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private BackendRule(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.authenticationCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static BackendRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public BackendRule getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static BackendRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static BackendRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    private BackendRule() {
        this.authenticationCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
        this.selector_ = "";
        this.address_ = "";
        this.pathTranslation_ = 0;
        this.protocol_ = "";
    }

    public static BackendRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static BackendRule parseFrom(InputStream inputStream) throws IOException {
        return (BackendRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static BackendRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BackendRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static BackendRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (BackendRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static BackendRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BackendRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    private BackendRule(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.selector_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                this.address_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 25) {
                                this.deadline_ = codedInputStream.readDouble();
                            } else if (readTag == 33) {
                                this.minDeadline_ = codedInputStream.readDouble();
                            } else if (readTag == 41) {
                                this.operationDeadline_ = codedInputStream.readDouble();
                            } else if (readTag == 48) {
                                this.pathTranslation_ = codedInputStream.readEnum();
                            } else if (readTag == 58) {
                                String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                this.authenticationCase_ = 7;
                                this.authentication_ = readStringRequireUtf8;
                            } else if (readTag == 64) {
                                this.authentication_ = Boolean.valueOf(codedInputStream.readBool());
                                this.authenticationCase_ = 8;
                            } else if (readTag != 74) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.protocol_ = codedInputStream.readStringRequireUtf8();
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
