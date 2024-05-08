package com.google.api;

import com.android.internal.logging.nano.MetricsProto;
import com.google.api.AuthProvider;
import com.google.api.AuthenticationRule;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
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
public final class Authentication extends GeneratedMessageV3 implements AuthenticationOrBuilder {
    private static final Authentication DEFAULT_INSTANCE = new Authentication();
    private static final Parser<Authentication> PARSER = new a();
    public static final int PROVIDERS_FIELD_NUMBER = 4;
    public static final int RULES_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private List<AuthProvider> providers_;
    private List<AuthenticationRule> rules_;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AuthenticationOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> providersBuilder_;
        private List<AuthProvider> providers_;
        private RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> rulesBuilder_;
        private List<AuthenticationRule> rules_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        private void ensureProvidersIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.providers_ = new ArrayList(this.providers_);
                this.bitField0_ |= 2;
            }
        }

        private void ensureRulesIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.rules_ = new ArrayList(this.rules_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return b.f53834a;
        }

        private RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> getProvidersFieldBuilder() {
            if (this.providersBuilder_ == null) {
                this.providersBuilder_ = new RepeatedFieldBuilderV3<>(this.providers_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                this.providers_ = null;
            }
            return this.providersBuilder_;
        }

        private RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> getRulesFieldBuilder() {
            if (this.rulesBuilder_ == null) {
                this.rulesBuilder_ = new RepeatedFieldBuilderV3<>(this.rules_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.rules_ = null;
            }
            return this.rulesBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                getRulesFieldBuilder();
                getProvidersFieldBuilder();
            }
        }

        public Builder addAllProviders(Iterable<? extends AuthProvider> iterable) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureProvidersIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.providers_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addAllRules(Iterable<? extends AuthenticationRule> iterable) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRulesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.rules_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addProviders(AuthProvider authProvider) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(authProvider);
                ensureProvidersIsMutable();
                this.providers_.add(authProvider);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(authProvider);
            }
            return this;
        }

        public AuthProvider.Builder addProvidersBuilder() {
            return getProvidersFieldBuilder().addBuilder(AuthProvider.getDefaultInstance());
        }

        public Builder addRules(AuthenticationRule authenticationRule) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(authenticationRule);
                ensureRulesIsMutable();
                this.rules_.add(authenticationRule);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(authenticationRule);
            }
            return this;
        }

        public AuthenticationRule.Builder addRulesBuilder() {
            return getRulesFieldBuilder().addBuilder(AuthenticationRule.getDefaultInstance());
        }

        public Builder clearProviders() {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.providers_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearRules() {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.rules_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return b.f53834a;
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public AuthProvider getProviders(int i10) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.providers_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public AuthProvider.Builder getProvidersBuilder(int i10) {
            return getProvidersFieldBuilder().getBuilder(i10);
        }

        public List<AuthProvider.Builder> getProvidersBuilderList() {
            return getProvidersFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public int getProvidersCount() {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.providers_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public List<AuthProvider> getProvidersList() {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.providers_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public AuthProviderOrBuilder getProvidersOrBuilder(int i10) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.providers_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public List<? extends AuthProviderOrBuilder> getProvidersOrBuilderList() {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.providers_);
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public AuthenticationRule getRules(int i10) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.rules_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public AuthenticationRule.Builder getRulesBuilder(int i10) {
            return getRulesFieldBuilder().getBuilder(i10);
        }

        public List<AuthenticationRule.Builder> getRulesBuilderList() {
            return getRulesFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public int getRulesCount() {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.rules_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public List<AuthenticationRule> getRulesList() {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.rules_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public AuthenticationRuleOrBuilder getRulesOrBuilder(int i10) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.rules_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.AuthenticationOrBuilder
        public List<? extends AuthenticationRuleOrBuilder> getRulesOrBuilderList() {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.rules_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return b.f53835b.ensureFieldAccessorsInitialized(Authentication.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder removeProviders(int i10) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureProvidersIsMutable();
                this.providers_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder removeRules(int i10) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRulesIsMutable();
                this.rules_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder setProviders(int i10, AuthProvider authProvider) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(authProvider);
                ensureProvidersIsMutable();
                this.providers_.set(i10, authProvider);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, authProvider);
            }
            return this;
        }

        public Builder setRules(int i10, AuthenticationRule authenticationRule) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(authenticationRule);
                ensureRulesIsMutable();
                this.rules_.set(i10, authenticationRule);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, authenticationRule);
            }
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        private Builder() {
            this.rules_ = Collections.emptyList();
            this.providers_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public AuthProvider.Builder addProvidersBuilder(int i10) {
            return getProvidersFieldBuilder().addBuilder(i10, AuthProvider.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public AuthenticationRule.Builder addRulesBuilder(int i10) {
            return getRulesFieldBuilder().addBuilder(i10, AuthenticationRule.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Authentication build() {
            Authentication buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Authentication buildPartial() {
            Authentication authentication = new Authentication(this, (a) null);
            int i10 = this.bitField0_;
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i10 & 1) != 0) {
                    this.rules_ = Collections.unmodifiableList(this.rules_);
                    this.bitField0_ &= -2;
                }
                authentication.rules_ = this.rules_;
            } else {
                authentication.rules_ = repeatedFieldBuilderV3.build();
            }
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV32 = this.providersBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                if ((this.bitField0_ & 2) != 0) {
                    this.providers_ = Collections.unmodifiableList(this.providers_);
                    this.bitField0_ &= -3;
                }
                authentication.providers_ = this.providers_;
            } else {
                authentication.providers_ = repeatedFieldBuilderV32.build();
            }
            onBuilt();
            return authentication;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Authentication getDefaultInstanceForType() {
            return Authentication.getDefaultInstance();
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
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.rules_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV32 = this.providersBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                this.providers_ = Collections.emptyList();
                this.bitField0_ &= -3;
            } else {
                repeatedFieldBuilderV32.clear();
            }
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.rules_ = Collections.emptyList();
            this.providers_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Builder addProviders(int i10, AuthProvider authProvider) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(authProvider);
                ensureProvidersIsMutable();
                this.providers_.add(i10, authProvider);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, authProvider);
            }
            return this;
        }

        public Builder addRules(int i10, AuthenticationRule authenticationRule) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(authenticationRule);
                ensureRulesIsMutable();
                this.rules_.add(i10, authenticationRule);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, authenticationRule);
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
            if (message instanceof Authentication) {
                return mergeFrom((Authentication) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setProviders(int i10, AuthProvider.Builder builder) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureProvidersIsMutable();
                this.providers_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder setRules(int i10, AuthenticationRule.Builder builder) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRulesIsMutable();
                this.rules_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder mergeFrom(Authentication authentication) {
            if (authentication == Authentication.getDefaultInstance()) {
                return this;
            }
            if (this.rulesBuilder_ == null) {
                if (!authentication.rules_.isEmpty()) {
                    if (this.rules_.isEmpty()) {
                        this.rules_ = authentication.rules_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureRulesIsMutable();
                        this.rules_.addAll(authentication.rules_);
                    }
                    onChanged();
                }
            } else if (!authentication.rules_.isEmpty()) {
                if (this.rulesBuilder_.isEmpty()) {
                    this.rulesBuilder_.dispose();
                    this.rulesBuilder_ = null;
                    this.rules_ = authentication.rules_;
                    this.bitField0_ &= -2;
                    this.rulesBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getRulesFieldBuilder() : null;
                } else {
                    this.rulesBuilder_.addAllMessages(authentication.rules_);
                }
            }
            if (this.providersBuilder_ == null) {
                if (!authentication.providers_.isEmpty()) {
                    if (this.providers_.isEmpty()) {
                        this.providers_ = authentication.providers_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureProvidersIsMutable();
                        this.providers_.addAll(authentication.providers_);
                    }
                    onChanged();
                }
            } else if (!authentication.providers_.isEmpty()) {
                if (this.providersBuilder_.isEmpty()) {
                    this.providersBuilder_.dispose();
                    this.providersBuilder_ = null;
                    this.providers_ = authentication.providers_;
                    this.bitField0_ &= -3;
                    this.providersBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getProvidersFieldBuilder() : null;
                } else {
                    this.providersBuilder_.addAllMessages(authentication.providers_);
                }
            }
            mergeUnknownFields(authentication.unknownFields);
            onChanged();
            return this;
        }

        public Builder addProviders(AuthProvider.Builder builder) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureProvidersIsMutable();
                this.providers_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addRules(AuthenticationRule.Builder builder) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRulesIsMutable();
                this.rules_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addProviders(int i10, AuthProvider.Builder builder) {
            RepeatedFieldBuilderV3<AuthProvider, AuthProvider.Builder, AuthProviderOrBuilder> repeatedFieldBuilderV3 = this.providersBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureProvidersIsMutable();
                this.providers_.add(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, builder.build());
            }
            return this;
        }

        public Builder addRules(int i10, AuthenticationRule.Builder builder) {
            RepeatedFieldBuilderV3<AuthenticationRule, AuthenticationRule.Builder, AuthenticationRuleOrBuilder> repeatedFieldBuilderV3 = this.rulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureRulesIsMutable();
                this.rules_.add(i10, builder.build());
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
        public com.google.api.Authentication.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.api.Authentication.access$900()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.api.Authentication r3 = (com.google.api.Authentication) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.api.Authentication r4 = (com.google.api.Authentication) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.Authentication.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.Authentication$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<Authentication> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Authentication parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Authentication(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ Authentication(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static Authentication getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return b.f53834a;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Authentication parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Authentication) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Authentication parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<Authentication> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Authentication)) {
            return super.equals(obj);
        }
        Authentication authentication = (Authentication) obj;
        return getRulesList().equals(authentication.getRulesList()) && getProvidersList().equals(authentication.getProvidersList()) && this.unknownFields.equals(authentication.unknownFields);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Authentication> getParserForType() {
        return PARSER;
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public AuthProvider getProviders(int i10) {
        return this.providers_.get(i10);
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public int getProvidersCount() {
        return this.providers_.size();
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public List<AuthProvider> getProvidersList() {
        return this.providers_;
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public AuthProviderOrBuilder getProvidersOrBuilder(int i10) {
        return this.providers_.get(i10);
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public List<? extends AuthProviderOrBuilder> getProvidersOrBuilderList() {
        return this.providers_;
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public AuthenticationRule getRules(int i10) {
        return this.rules_.get(i10);
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public int getRulesCount() {
        return this.rules_.size();
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public List<AuthenticationRule> getRulesList() {
        return this.rules_;
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public AuthenticationRuleOrBuilder getRulesOrBuilder(int i10) {
        return this.rules_.get(i10);
    }

    @Override // com.google.api.AuthenticationOrBuilder
    public List<? extends AuthenticationRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.rules_.size(); i12++) {
            i11 += CodedOutputStream.computeMessageSize(3, this.rules_.get(i12));
        }
        for (int i13 = 0; i13 < this.providers_.size(); i13++) {
            i11 += CodedOutputStream.computeMessageSize(4, this.providers_.get(i13));
        }
        int serializedSize = i11 + this.unknownFields.getSerializedSize();
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
        int hashCode = MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode();
        if (getRulesCount() > 0) {
            hashCode = (((hashCode * 37) + 3) * 53) + getRulesList().hashCode();
        }
        if (getProvidersCount() > 0) {
            hashCode = (((hashCode * 37) + 4) * 53) + getProvidersList().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return b.f53835b.ensureFieldAccessorsInitialized(Authentication.class, Builder.class);
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
        return new Authentication();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i10 = 0; i10 < this.rules_.size(); i10++) {
            codedOutputStream.writeMessage(3, this.rules_.get(i10));
        }
        for (int i11 = 0; i11 < this.providers_.size(); i11++) {
            codedOutputStream.writeMessage(4, this.providers_.get(i11));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ Authentication(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(Authentication authentication) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(authentication);
    }

    public static Authentication parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Authentication) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Authentication parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private Authentication(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Authentication parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Authentication getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static Authentication parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private Authentication() {
        this.memoizedIsInitialized = (byte) -1;
        this.rules_ = Collections.emptyList();
        this.providers_ = Collections.emptyList();
    }

    public static Authentication parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static Authentication parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Authentication parseFrom(InputStream inputStream) throws IOException {
        return (Authentication) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Authentication parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Authentication) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Authentication(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 26) {
                                if ((i10 & 1) == 0) {
                                    this.rules_ = new ArrayList();
                                    i10 |= 1;
                                }
                                this.rules_.add(codedInputStream.readMessage(AuthenticationRule.parser(), extensionRegistryLite));
                            } else if (readTag != 34) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                if ((i10 & 2) == 0) {
                                    this.providers_ = new ArrayList();
                                    i10 |= 2;
                                }
                                this.providers_.add(codedInputStream.readMessage(AuthProvider.parser(), extensionRegistryLite));
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
                    this.rules_ = Collections.unmodifiableList(this.rules_);
                }
                if ((i10 & 2) != 0) {
                    this.providers_ = Collections.unmodifiableList(this.providers_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static Authentication parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Authentication) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Authentication parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Authentication) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
