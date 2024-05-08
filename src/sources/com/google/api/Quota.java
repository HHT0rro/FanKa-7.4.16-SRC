package com.google.api;

import com.android.internal.logging.nano.MetricsProto;
import com.google.api.MetricRule;
import com.google.api.QuotaLimit;
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
import u7.x;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Quota extends GeneratedMessageV3 implements QuotaOrBuilder {
    public static final int LIMITS_FIELD_NUMBER = 3;
    public static final int METRIC_RULES_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private List<QuotaLimit> limits_;
    private byte memoizedIsInitialized;
    private List<MetricRule> metricRules_;
    private static final Quota DEFAULT_INSTANCE = new Quota();
    private static final Parser<Quota> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuotaOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> limitsBuilder_;
        private List<QuotaLimit> limits_;
        private RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> metricRulesBuilder_;
        private List<MetricRule> metricRules_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        private void ensureLimitsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.limits_ = new ArrayList(this.limits_);
                this.bitField0_ |= 1;
            }
        }

        private void ensureMetricRulesIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.metricRules_ = new ArrayList(this.metricRules_);
                this.bitField0_ |= 2;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return x.f53980a;
        }

        private RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> getLimitsFieldBuilder() {
            if (this.limitsBuilder_ == null) {
                this.limitsBuilder_ = new RepeatedFieldBuilderV3<>(this.limits_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.limits_ = null;
            }
            return this.limitsBuilder_;
        }

        private RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> getMetricRulesFieldBuilder() {
            if (this.metricRulesBuilder_ == null) {
                this.metricRulesBuilder_ = new RepeatedFieldBuilderV3<>(this.metricRules_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                this.metricRules_ = null;
            }
            return this.metricRulesBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                getLimitsFieldBuilder();
                getMetricRulesFieldBuilder();
            }
        }

        public Builder addAllLimits(Iterable<? extends QuotaLimit> iterable) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureLimitsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.limits_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addAllMetricRules(Iterable<? extends MetricRule> iterable) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMetricRulesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.metricRules_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addLimits(QuotaLimit quotaLimit) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(quotaLimit);
                ensureLimitsIsMutable();
                this.limits_.add(quotaLimit);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(quotaLimit);
            }
            return this;
        }

        public QuotaLimit.Builder addLimitsBuilder() {
            return getLimitsFieldBuilder().addBuilder(QuotaLimit.getDefaultInstance());
        }

        public Builder addMetricRules(MetricRule metricRule) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(metricRule);
                ensureMetricRulesIsMutable();
                this.metricRules_.add(metricRule);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(metricRule);
            }
            return this;
        }

        public MetricRule.Builder addMetricRulesBuilder() {
            return getMetricRulesFieldBuilder().addBuilder(MetricRule.getDefaultInstance());
        }

        public Builder clearLimits() {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.limits_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearMetricRules() {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.metricRules_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return x.f53980a;
        }

        @Override // com.google.api.QuotaOrBuilder
        public QuotaLimit getLimits(int i10) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.limits_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public QuotaLimit.Builder getLimitsBuilder(int i10) {
            return getLimitsFieldBuilder().getBuilder(i10);
        }

        public List<QuotaLimit.Builder> getLimitsBuilderList() {
            return getLimitsFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.QuotaOrBuilder
        public int getLimitsCount() {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.limits_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.QuotaOrBuilder
        public List<QuotaLimit> getLimitsList() {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.limits_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.QuotaOrBuilder
        public QuotaLimitOrBuilder getLimitsOrBuilder(int i10) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.limits_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.QuotaOrBuilder
        public List<? extends QuotaLimitOrBuilder> getLimitsOrBuilderList() {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.limits_);
        }

        @Override // com.google.api.QuotaOrBuilder
        public MetricRule getMetricRules(int i10) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.metricRules_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public MetricRule.Builder getMetricRulesBuilder(int i10) {
            return getMetricRulesFieldBuilder().getBuilder(i10);
        }

        public List<MetricRule.Builder> getMetricRulesBuilderList() {
            return getMetricRulesFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.QuotaOrBuilder
        public int getMetricRulesCount() {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.metricRules_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.QuotaOrBuilder
        public List<MetricRule> getMetricRulesList() {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.metricRules_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.QuotaOrBuilder
        public MetricRuleOrBuilder getMetricRulesOrBuilder(int i10) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.metricRules_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.QuotaOrBuilder
        public List<? extends MetricRuleOrBuilder> getMetricRulesOrBuilderList() {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.metricRules_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return x.f53981b.ensureFieldAccessorsInitialized(Quota.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder removeLimits(int i10) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureLimitsIsMutable();
                this.limits_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder removeMetricRules(int i10) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMetricRulesIsMutable();
                this.metricRules_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder setLimits(int i10, QuotaLimit quotaLimit) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(quotaLimit);
                ensureLimitsIsMutable();
                this.limits_.set(i10, quotaLimit);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, quotaLimit);
            }
            return this;
        }

        public Builder setMetricRules(int i10, MetricRule metricRule) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(metricRule);
                ensureMetricRulesIsMutable();
                this.metricRules_.set(i10, metricRule);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, metricRule);
            }
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        public QuotaLimit.Builder addLimitsBuilder(int i10) {
            return getLimitsFieldBuilder().addBuilder(i10, QuotaLimit.getDefaultInstance());
        }

        private Builder() {
            this.limits_ = Collections.emptyList();
            this.metricRules_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public MetricRule.Builder addMetricRulesBuilder(int i10) {
            return getMetricRulesFieldBuilder().addBuilder(i10, MetricRule.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Quota build() {
            Quota buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Quota buildPartial() {
            Quota quota = new Quota(this, (a) null);
            int i10 = this.bitField0_;
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i10 & 1) != 0) {
                    this.limits_ = Collections.unmodifiableList(this.limits_);
                    this.bitField0_ &= -2;
                }
                quota.limits_ = this.limits_;
            } else {
                quota.limits_ = repeatedFieldBuilderV3.build();
            }
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV32 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                if ((this.bitField0_ & 2) != 0) {
                    this.metricRules_ = Collections.unmodifiableList(this.metricRules_);
                    this.bitField0_ &= -3;
                }
                quota.metricRules_ = this.metricRules_;
            } else {
                quota.metricRules_ = repeatedFieldBuilderV32.build();
            }
            onBuilt();
            return quota;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Quota getDefaultInstanceForType() {
            return Quota.getDefaultInstance();
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
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.limits_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV32 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                this.metricRules_ = Collections.emptyList();
                this.bitField0_ &= -3;
            } else {
                repeatedFieldBuilderV32.clear();
            }
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.limits_ = Collections.emptyList();
            this.metricRules_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Builder addLimits(int i10, QuotaLimit quotaLimit) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(quotaLimit);
                ensureLimitsIsMutable();
                this.limits_.add(i10, quotaLimit);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, quotaLimit);
            }
            return this;
        }

        public Builder addMetricRules(int i10, MetricRule metricRule) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(metricRule);
                ensureMetricRulesIsMutable();
                this.metricRules_.add(i10, metricRule);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, metricRule);
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
            if (message instanceof Quota) {
                return mergeFrom((Quota) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setLimits(int i10, QuotaLimit.Builder builder) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureLimitsIsMutable();
                this.limits_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder setMetricRules(int i10, MetricRule.Builder builder) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMetricRulesIsMutable();
                this.metricRules_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder mergeFrom(Quota quota) {
            if (quota == Quota.getDefaultInstance()) {
                return this;
            }
            if (this.limitsBuilder_ == null) {
                if (!quota.limits_.isEmpty()) {
                    if (this.limits_.isEmpty()) {
                        this.limits_ = quota.limits_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureLimitsIsMutable();
                        this.limits_.addAll(quota.limits_);
                    }
                    onChanged();
                }
            } else if (!quota.limits_.isEmpty()) {
                if (this.limitsBuilder_.isEmpty()) {
                    this.limitsBuilder_.dispose();
                    this.limitsBuilder_ = null;
                    this.limits_ = quota.limits_;
                    this.bitField0_ &= -2;
                    this.limitsBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getLimitsFieldBuilder() : null;
                } else {
                    this.limitsBuilder_.addAllMessages(quota.limits_);
                }
            }
            if (this.metricRulesBuilder_ == null) {
                if (!quota.metricRules_.isEmpty()) {
                    if (this.metricRules_.isEmpty()) {
                        this.metricRules_ = quota.metricRules_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureMetricRulesIsMutable();
                        this.metricRules_.addAll(quota.metricRules_);
                    }
                    onChanged();
                }
            } else if (!quota.metricRules_.isEmpty()) {
                if (this.metricRulesBuilder_.isEmpty()) {
                    this.metricRulesBuilder_.dispose();
                    this.metricRulesBuilder_ = null;
                    this.metricRules_ = quota.metricRules_;
                    this.bitField0_ &= -3;
                    this.metricRulesBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getMetricRulesFieldBuilder() : null;
                } else {
                    this.metricRulesBuilder_.addAllMessages(quota.metricRules_);
                }
            }
            mergeUnknownFields(quota.unknownFields);
            onChanged();
            return this;
        }

        public Builder addLimits(QuotaLimit.Builder builder) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureLimitsIsMutable();
                this.limits_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addMetricRules(MetricRule.Builder builder) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMetricRulesIsMutable();
                this.metricRules_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addLimits(int i10, QuotaLimit.Builder builder) {
            RepeatedFieldBuilderV3<QuotaLimit, QuotaLimit.Builder, QuotaLimitOrBuilder> repeatedFieldBuilderV3 = this.limitsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureLimitsIsMutable();
                this.limits_.add(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, builder.build());
            }
            return this;
        }

        public Builder addMetricRules(int i10, MetricRule.Builder builder) {
            RepeatedFieldBuilderV3<MetricRule, MetricRule.Builder, MetricRuleOrBuilder> repeatedFieldBuilderV3 = this.metricRulesBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureMetricRulesIsMutable();
                this.metricRules_.add(i10, builder.build());
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
        public com.google.api.Quota.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.api.Quota.access$900()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.api.Quota r3 = (com.google.api.Quota) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.api.Quota r4 = (com.google.api.Quota) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.Quota.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.Quota$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<Quota> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Quota parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Quota(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ Quota(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static Quota getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return x.f53980a;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Quota parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Quota) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Quota parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<Quota> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Quota)) {
            return super.equals(obj);
        }
        Quota quota = (Quota) obj;
        return getLimitsList().equals(quota.getLimitsList()) && getMetricRulesList().equals(quota.getMetricRulesList()) && this.unknownFields.equals(quota.unknownFields);
    }

    @Override // com.google.api.QuotaOrBuilder
    public QuotaLimit getLimits(int i10) {
        return this.limits_.get(i10);
    }

    @Override // com.google.api.QuotaOrBuilder
    public int getLimitsCount() {
        return this.limits_.size();
    }

    @Override // com.google.api.QuotaOrBuilder
    public List<QuotaLimit> getLimitsList() {
        return this.limits_;
    }

    @Override // com.google.api.QuotaOrBuilder
    public QuotaLimitOrBuilder getLimitsOrBuilder(int i10) {
        return this.limits_.get(i10);
    }

    @Override // com.google.api.QuotaOrBuilder
    public List<? extends QuotaLimitOrBuilder> getLimitsOrBuilderList() {
        return this.limits_;
    }

    @Override // com.google.api.QuotaOrBuilder
    public MetricRule getMetricRules(int i10) {
        return this.metricRules_.get(i10);
    }

    @Override // com.google.api.QuotaOrBuilder
    public int getMetricRulesCount() {
        return this.metricRules_.size();
    }

    @Override // com.google.api.QuotaOrBuilder
    public List<MetricRule> getMetricRulesList() {
        return this.metricRules_;
    }

    @Override // com.google.api.QuotaOrBuilder
    public MetricRuleOrBuilder getMetricRulesOrBuilder(int i10) {
        return this.metricRules_.get(i10);
    }

    @Override // com.google.api.QuotaOrBuilder
    public List<? extends MetricRuleOrBuilder> getMetricRulesOrBuilderList() {
        return this.metricRules_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Quota> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.limits_.size(); i12++) {
            i11 += CodedOutputStream.computeMessageSize(3, this.limits_.get(i12));
        }
        for (int i13 = 0; i13 < this.metricRules_.size(); i13++) {
            i11 += CodedOutputStream.computeMessageSize(4, this.metricRules_.get(i13));
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
        if (getLimitsCount() > 0) {
            hashCode = (((hashCode * 37) + 3) * 53) + getLimitsList().hashCode();
        }
        if (getMetricRulesCount() > 0) {
            hashCode = (((hashCode * 37) + 4) * 53) + getMetricRulesList().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return x.f53981b.ensureFieldAccessorsInitialized(Quota.class, Builder.class);
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
        return new Quota();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i10 = 0; i10 < this.limits_.size(); i10++) {
            codedOutputStream.writeMessage(3, this.limits_.get(i10));
        }
        for (int i11 = 0; i11 < this.metricRules_.size(); i11++) {
            codedOutputStream.writeMessage(4, this.metricRules_.get(i11));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ Quota(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(Quota quota) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(quota);
    }

    public static Quota parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Quota) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Quota parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private Quota(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Quota parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Quota getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static Quota parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private Quota() {
        this.memoizedIsInitialized = (byte) -1;
        this.limits_ = Collections.emptyList();
        this.metricRules_ = Collections.emptyList();
    }

    public static Quota parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static Quota parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Quota parseFrom(InputStream inputStream) throws IOException {
        return (Quota) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Quota parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Quota) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Quota(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.limits_ = new ArrayList();
                                    i10 |= 1;
                                }
                                this.limits_.add(codedInputStream.readMessage(QuotaLimit.parser(), extensionRegistryLite));
                            } else if (readTag != 34) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                if ((i10 & 2) == 0) {
                                    this.metricRules_ = new ArrayList();
                                    i10 |= 2;
                                }
                                this.metricRules_.add(codedInputStream.readMessage(MetricRule.parser(), extensionRegistryLite));
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
                    this.limits_ = Collections.unmodifiableList(this.limits_);
                }
                if ((i10 & 2) != 0) {
                    this.metricRules_ = Collections.unmodifiableList(this.metricRules_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static Quota parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Quota) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Quota parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Quota) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
