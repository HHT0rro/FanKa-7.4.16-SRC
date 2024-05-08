package com.google.api;

import com.android.internal.logging.nano.MetricsProto;
import com.google.api.AuthRequirement;
import com.google.api.OAuthRequirements;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import u7.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class AuthenticationRule extends GeneratedMessageV3 implements AuthenticationRuleOrBuilder {
    public static final int ALLOW_WITHOUT_CREDENTIAL_FIELD_NUMBER = 5;
    public static final int OAUTH_FIELD_NUMBER = 2;
    public static final int REQUIREMENTS_FIELD_NUMBER = 7;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private boolean allowWithoutCredential_;
    private byte memoizedIsInitialized;
    private OAuthRequirements oauth_;
    private List<AuthRequirement> requirements_;
    private volatile Object selector_;
    private static final AuthenticationRule DEFAULT_INSTANCE = new AuthenticationRule();
    private static final Parser<AuthenticationRule> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AuthenticationRuleOrBuilder {
        private boolean allowWithoutCredential_;
        private int bitField0_;
        private SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> oauthBuilder_;
        private OAuthRequirements oauth_;
        private RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> requirementsBuilder_;
        private List<AuthRequirement> requirements_;
        private Object selector_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        private void ensureRequirementsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.requirements_ = new ArrayList(this.requirements_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return b.f53836c;
        }

        private SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> getOauthFieldBuilder() {
            if (this.oauthBuilder_ == null) {
                this.oauthBuilder_ = new SingleFieldBuilderV3<>(getOauth(), getParentForChildren(), isClean());
                this.oauth_ = null;
            }
            return this.oauthBuilder_;
        }

        private RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> getRequirementsFieldBuilder() {
            if (this.requirementsBuilder_ == null) {
                this.requirementsBuilder_ = new RepeatedFieldBuilderV3<>(this.requirements_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.requirements_ = null;
            }
            return this.requirementsBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                getRequirementsFieldBuilder();
            }
        }

        public Builder addAllRequirements(Iterable<? extends AuthRequirement> iterable) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRequirementsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.requirements_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addRequirements(AuthRequirement authRequirement) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(authRequirement);
                ensureRequirementsIsMutable();
                this.requirements_.add(authRequirement);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(authRequirement);
            }
            return this;
        }

        public AuthRequirement.Builder addRequirementsBuilder() {
            return getRequirementsFieldBuilder().addBuilder(AuthRequirement.getDefaultInstance());
        }

        public Builder clearAllowWithoutCredential() {
            this.allowWithoutCredential_ = false;
            onChanged();
            return this;
        }

        public Builder clearOauth() {
            if (this.oauthBuilder_ == null) {
                this.oauth_ = null;
                onChanged();
            } else {
                this.oauth_ = null;
                this.oauthBuilder_ = null;
            }
            return this;
        }

        public Builder clearRequirements() {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.requirements_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearSelector() {
            this.selector_ = AuthenticationRule.getDefaultInstance().getSelector();
            onChanged();
            return this;
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public boolean getAllowWithoutCredential() {
            return this.allowWithoutCredential_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return b.f53836c;
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public OAuthRequirements getOauth() {
            SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> singleFieldBuilderV3 = this.oauthBuilder_;
            if (singleFieldBuilderV3 == null) {
                OAuthRequirements oAuthRequirements = this.oauth_;
                return oAuthRequirements == null ? OAuthRequirements.getDefaultInstance() : oAuthRequirements;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public OAuthRequirements.Builder getOauthBuilder() {
            onChanged();
            return getOauthFieldBuilder().getBuilder();
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public OAuthRequirementsOrBuilder getOauthOrBuilder() {
            SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> singleFieldBuilderV3 = this.oauthBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            OAuthRequirements oAuthRequirements = this.oauth_;
            return oAuthRequirements == null ? OAuthRequirements.getDefaultInstance() : oAuthRequirements;
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public AuthRequirement getRequirements(int i10) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.requirements_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public AuthRequirement.Builder getRequirementsBuilder(int i10) {
            return getRequirementsFieldBuilder().getBuilder(i10);
        }

        public List<AuthRequirement.Builder> getRequirementsBuilderList() {
            return getRequirementsFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public int getRequirementsCount() {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.requirements_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public List<AuthRequirement> getRequirementsList() {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.requirements_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public AuthRequirementOrBuilder getRequirementsOrBuilder(int i10) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.requirements_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public List<? extends AuthRequirementOrBuilder> getRequirementsOrBuilderList() {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.requirements_);
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public String getSelector() {
            Object obj = this.selector_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.selector_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public ByteString getSelectorBytes() {
            Object obj = this.selector_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.selector_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public boolean hasOauth() {
            return (this.oauthBuilder_ == null && this.oauth_ == null) ? false : true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return b.f53837d.ensureFieldAccessorsInitialized(AuthenticationRule.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeOauth(OAuthRequirements oAuthRequirements) {
            SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> singleFieldBuilderV3 = this.oauthBuilder_;
            if (singleFieldBuilderV3 == null) {
                OAuthRequirements oAuthRequirements2 = this.oauth_;
                if (oAuthRequirements2 != null) {
                    this.oauth_ = OAuthRequirements.newBuilder(oAuthRequirements2).mergeFrom(oAuthRequirements).buildPartial();
                } else {
                    this.oauth_ = oAuthRequirements;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(oAuthRequirements);
            }
            return this;
        }

        public Builder removeRequirements(int i10) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRequirementsIsMutable();
                this.requirements_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder setAllowWithoutCredential(boolean z10) {
            this.allowWithoutCredential_ = z10;
            onChanged();
            return this;
        }

        public Builder setOauth(OAuthRequirements oAuthRequirements) {
            SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> singleFieldBuilderV3 = this.oauthBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(oAuthRequirements);
                this.oauth_ = oAuthRequirements;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(oAuthRequirements);
            }
            return this;
        }

        public Builder setRequirements(int i10, AuthRequirement authRequirement) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(authRequirement);
                ensureRequirementsIsMutable();
                this.requirements_.set(i10, authRequirement);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, authRequirement);
            }
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
            this.selector_ = "";
            this.requirements_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public AuthRequirement.Builder addRequirementsBuilder(int i10) {
            return getRequirementsFieldBuilder().addBuilder(i10, AuthRequirement.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AuthenticationRule build() {
            AuthenticationRule buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public AuthenticationRule buildPartial() {
            AuthenticationRule authenticationRule = new AuthenticationRule(this, (a) null);
            authenticationRule.selector_ = this.selector_;
            SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> singleFieldBuilderV3 = this.oauthBuilder_;
            if (singleFieldBuilderV3 == null) {
                authenticationRule.oauth_ = this.oauth_;
            } else {
                authenticationRule.oauth_ = singleFieldBuilderV3.build();
            }
            authenticationRule.allowWithoutCredential_ = this.allowWithoutCredential_;
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 1) != 0) {
                    this.requirements_ = Collections.unmodifiableList(this.requirements_);
                    this.bitField0_ &= -2;
                }
                authenticationRule.requirements_ = this.requirements_;
            } else {
                authenticationRule.requirements_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return authenticationRule;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AuthenticationRule getDefaultInstanceForType() {
            return AuthenticationRule.getDefaultInstance();
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
            if (this.oauthBuilder_ == null) {
                this.oauth_ = null;
            } else {
                this.oauth_ = null;
                this.oauthBuilder_ = null;
            }
            this.allowWithoutCredential_ = false;
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.requirements_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder setOauth(OAuthRequirements.Builder builder) {
            SingleFieldBuilderV3<OAuthRequirements, OAuthRequirements.Builder, OAuthRequirementsOrBuilder> singleFieldBuilderV3 = this.oauthBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.oauth_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.selector_ = "";
            this.requirements_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Builder addRequirements(int i10, AuthRequirement authRequirement) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(authRequirement);
                ensureRequirementsIsMutable();
                this.requirements_.add(i10, authRequirement);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, authRequirement);
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
            if (message instanceof AuthenticationRule) {
                return mergeFrom((AuthenticationRule) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setRequirements(int i10, AuthRequirement.Builder builder) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRequirementsIsMutable();
                this.requirements_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder mergeFrom(AuthenticationRule authenticationRule) {
            if (authenticationRule == AuthenticationRule.getDefaultInstance()) {
                return this;
            }
            if (!authenticationRule.getSelector().isEmpty()) {
                this.selector_ = authenticationRule.selector_;
                onChanged();
            }
            if (authenticationRule.hasOauth()) {
                mergeOauth(authenticationRule.getOauth());
            }
            if (authenticationRule.getAllowWithoutCredential()) {
                setAllowWithoutCredential(authenticationRule.getAllowWithoutCredential());
            }
            if (this.requirementsBuilder_ == null) {
                if (!authenticationRule.requirements_.isEmpty()) {
                    if (this.requirements_.isEmpty()) {
                        this.requirements_ = authenticationRule.requirements_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRequirementsIsMutable();
                        this.requirements_.addAll(authenticationRule.requirements_);
                    }
                    onChanged();
                }
            } else if (!authenticationRule.requirements_.isEmpty()) {
                if (this.requirementsBuilder_.isEmpty()) {
                    this.requirementsBuilder_.dispose();
                    this.requirementsBuilder_ = null;
                    this.requirements_ = authenticationRule.requirements_;
                    this.bitField0_ &= -2;
                    this.requirementsBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getRequirementsFieldBuilder() : null;
                } else {
                    this.requirementsBuilder_.addAllMessages(authenticationRule.requirements_);
                }
            }
            mergeUnknownFields(authenticationRule.unknownFields);
            onChanged();
            return this;
        }

        public Builder addRequirements(AuthRequirement.Builder builder) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRequirementsIsMutable();
                this.requirements_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addRequirements(int i10, AuthRequirement.Builder builder) {
            RepeatedFieldBuilderV3<AuthRequirement, AuthRequirement.Builder, AuthRequirementOrBuilder> repeatedFieldBuilderV3 = this.requirementsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRequirementsIsMutable();
                this.requirements_.add(i10, builder.build());
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
        public com.google.api.AuthenticationRule.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.api.AuthenticationRule.access$1000()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.api.AuthenticationRule r3 = (com.google.api.AuthenticationRule) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.api.AuthenticationRule r4 = (com.google.api.AuthenticationRule) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.AuthenticationRule.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.AuthenticationRule$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<AuthenticationRule> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AuthenticationRule parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new AuthenticationRule(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ AuthenticationRule(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static AuthenticationRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return b.f53836c;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static AuthenticationRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AuthenticationRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static AuthenticationRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<AuthenticationRule> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthenticationRule)) {
            return super.equals(obj);
        }
        AuthenticationRule authenticationRule = (AuthenticationRule) obj;
        if (getSelector().equals(authenticationRule.getSelector()) && hasOauth() == authenticationRule.hasOauth()) {
            return (!hasOauth() || getOauth().equals(authenticationRule.getOauth())) && getAllowWithoutCredential() == authenticationRule.getAllowWithoutCredential() && getRequirementsList().equals(authenticationRule.getRequirementsList()) && this.unknownFields.equals(authenticationRule.unknownFields);
        }
        return false;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public boolean getAllowWithoutCredential() {
        return this.allowWithoutCredential_;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public OAuthRequirements getOauth() {
        OAuthRequirements oAuthRequirements = this.oauth_;
        return oAuthRequirements == null ? OAuthRequirements.getDefaultInstance() : oAuthRequirements;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public OAuthRequirementsOrBuilder getOauthOrBuilder() {
        return getOauth();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<AuthenticationRule> getParserForType() {
        return PARSER;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public AuthRequirement getRequirements(int i10) {
        return this.requirements_.get(i10);
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public int getRequirementsCount() {
        return this.requirements_.size();
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public List<AuthRequirement> getRequirementsList() {
        return this.requirements_;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public AuthRequirementOrBuilder getRequirementsOrBuilder(int i10) {
        return this.requirements_.get(i10);
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public List<? extends AuthRequirementOrBuilder> getRequirementsOrBuilderList() {
        return this.requirements_;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public String getSelector() {
        Object obj = this.selector_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.selector_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
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
        int computeStringSize = !GeneratedMessageV3.isStringEmpty(this.selector_) ? GeneratedMessageV3.computeStringSize(1, this.selector_) + 0 : 0;
        if (this.oauth_ != null) {
            computeStringSize += CodedOutputStream.computeMessageSize(2, getOauth());
        }
        boolean z10 = this.allowWithoutCredential_;
        if (z10) {
            computeStringSize += CodedOutputStream.computeBoolSize(5, z10);
        }
        for (int i11 = 0; i11 < this.requirements_.size(); i11++) {
            computeStringSize += CodedOutputStream.computeMessageSize(7, this.requirements_.get(i11));
        }
        int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public boolean hasOauth() {
        return this.oauth_ != null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = ((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getSelector().hashCode();
        if (hasOauth()) {
            hashCode = (((hashCode * 37) + 2) * 53) + getOauth().hashCode();
        }
        int hashBoolean = (((hashCode * 37) + 5) * 53) + Internal.hashBoolean(getAllowWithoutCredential());
        if (getRequirementsCount() > 0) {
            hashBoolean = (((hashBoolean * 37) + 7) * 53) + getRequirementsList().hashCode();
        }
        int hashCode2 = (hashBoolean * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return b.f53837d.ensureFieldAccessorsInitialized(AuthenticationRule.class, Builder.class);
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
        return new AuthenticationRule();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!GeneratedMessageV3.isStringEmpty(this.selector_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 1, this.selector_);
        }
        if (this.oauth_ != null) {
            codedOutputStream.writeMessage(2, getOauth());
        }
        boolean z10 = this.allowWithoutCredential_;
        if (z10) {
            codedOutputStream.writeBool(5, z10);
        }
        for (int i10 = 0; i10 < this.requirements_.size(); i10++) {
            codedOutputStream.writeMessage(7, this.requirements_.get(i10));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ AuthenticationRule(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(AuthenticationRule authenticationRule) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(authenticationRule);
    }

    public static AuthenticationRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthenticationRule) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static AuthenticationRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private AuthenticationRule(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static AuthenticationRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public AuthenticationRule getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static AuthenticationRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private AuthenticationRule() {
        this.memoizedIsInitialized = (byte) -1;
        this.selector_ = "";
        this.requirements_ = Collections.emptyList();
    }

    public static AuthenticationRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static AuthenticationRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static AuthenticationRule parseFrom(InputStream inputStream) throws IOException {
        return (AuthenticationRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static AuthenticationRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthenticationRule) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AuthenticationRule(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                this.selector_ = codedInputStream.readStringRequireUtf8();
                            } else if (readTag == 18) {
                                OAuthRequirements oAuthRequirements = this.oauth_;
                                OAuthRequirements.Builder builder = oAuthRequirements != null ? oAuthRequirements.toBuilder() : null;
                                OAuthRequirements oAuthRequirements2 = (OAuthRequirements) codedInputStream.readMessage(OAuthRequirements.parser(), extensionRegistryLite);
                                this.oauth_ = oAuthRequirements2;
                                if (builder != null) {
                                    builder.mergeFrom(oAuthRequirements2);
                                    this.oauth_ = builder.buildPartial();
                                }
                            } else if (readTag == 40) {
                                this.allowWithoutCredential_ = codedInputStream.readBool();
                            } else if (readTag != 58) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                if (!(z11 & true)) {
                                    this.requirements_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.requirements_.add(codedInputStream.readMessage(AuthRequirement.parser(), extensionRegistryLite));
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
                    this.requirements_ = Collections.unmodifiableList(this.requirements_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static AuthenticationRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AuthenticationRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static AuthenticationRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthenticationRule) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
