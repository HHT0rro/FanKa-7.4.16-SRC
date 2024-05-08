package com.google.api;

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
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
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
import u7.w;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Monitoring extends GeneratedMessageV3 implements MonitoringOrBuilder {
    public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 2;
    private static final Monitoring DEFAULT_INSTANCE = new Monitoring();
    private static final Parser<Monitoring> PARSER = new a();
    public static final int PRODUCER_DESTINATIONS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<MonitoringDestination> consumerDestinations_;
    private byte memoizedIsInitialized;
    private List<MonitoringDestination> producerDestinations_;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MonitoringOrBuilder {
        private int bitField0_;
        private RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> consumerDestinationsBuilder_;
        private List<MonitoringDestination> consumerDestinations_;
        private RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> producerDestinationsBuilder_;
        private List<MonitoringDestination> producerDestinations_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        private void ensureConsumerDestinationsIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.consumerDestinations_ = new ArrayList(this.consumerDestinations_);
                this.bitField0_ |= 2;
            }
        }

        private void ensureProducerDestinationsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.producerDestinations_ = new ArrayList(this.producerDestinations_);
                this.bitField0_ |= 1;
            }
        }

        private RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> getConsumerDestinationsFieldBuilder() {
            if (this.consumerDestinationsBuilder_ == null) {
                this.consumerDestinationsBuilder_ = new RepeatedFieldBuilderV3<>(this.consumerDestinations_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                this.consumerDestinations_ = null;
            }
            return this.consumerDestinationsBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return w.f53975a;
        }

        private RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> getProducerDestinationsFieldBuilder() {
            if (this.producerDestinationsBuilder_ == null) {
                this.producerDestinationsBuilder_ = new RepeatedFieldBuilderV3<>(this.producerDestinations_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                this.producerDestinations_ = null;
            }
            return this.producerDestinationsBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                getProducerDestinationsFieldBuilder();
                getConsumerDestinationsFieldBuilder();
            }
        }

        public Builder addAllConsumerDestinations(Iterable<? extends MonitoringDestination> iterable) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureConsumerDestinationsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.consumerDestinations_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addAllProducerDestinations(Iterable<? extends MonitoringDestination> iterable) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureProducerDestinationsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.producerDestinations_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addConsumerDestinations(MonitoringDestination monitoringDestination) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(monitoringDestination);
                ensureConsumerDestinationsIsMutable();
                this.consumerDestinations_.add(monitoringDestination);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(monitoringDestination);
            }
            return this;
        }

        public MonitoringDestination.Builder addConsumerDestinationsBuilder() {
            return getConsumerDestinationsFieldBuilder().addBuilder(MonitoringDestination.getDefaultInstance());
        }

        public Builder addProducerDestinations(MonitoringDestination monitoringDestination) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(monitoringDestination);
                ensureProducerDestinationsIsMutable();
                this.producerDestinations_.add(monitoringDestination);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(monitoringDestination);
            }
            return this;
        }

        public MonitoringDestination.Builder addProducerDestinationsBuilder() {
            return getProducerDestinationsFieldBuilder().addBuilder(MonitoringDestination.getDefaultInstance());
        }

        public Builder clearConsumerDestinations() {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.consumerDestinations_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearProducerDestinations() {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.producerDestinations_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        @Override // com.google.api.MonitoringOrBuilder
        public MonitoringDestination getConsumerDestinations(int i10) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.consumerDestinations_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public MonitoringDestination.Builder getConsumerDestinationsBuilder(int i10) {
            return getConsumerDestinationsFieldBuilder().getBuilder(i10);
        }

        public List<MonitoringDestination.Builder> getConsumerDestinationsBuilderList() {
            return getConsumerDestinationsFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.MonitoringOrBuilder
        public int getConsumerDestinationsCount() {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.consumerDestinations_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.MonitoringOrBuilder
        public List<MonitoringDestination> getConsumerDestinationsList() {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.consumerDestinations_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.MonitoringOrBuilder
        public MonitoringDestinationOrBuilder getConsumerDestinationsOrBuilder(int i10) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.consumerDestinations_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.MonitoringOrBuilder
        public List<? extends MonitoringDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.consumerDestinations_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return w.f53975a;
        }

        @Override // com.google.api.MonitoringOrBuilder
        public MonitoringDestination getProducerDestinations(int i10) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.producerDestinations_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public MonitoringDestination.Builder getProducerDestinationsBuilder(int i10) {
            return getProducerDestinationsFieldBuilder().getBuilder(i10);
        }

        public List<MonitoringDestination.Builder> getProducerDestinationsBuilderList() {
            return getProducerDestinationsFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.MonitoringOrBuilder
        public int getProducerDestinationsCount() {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.producerDestinations_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.MonitoringOrBuilder
        public List<MonitoringDestination> getProducerDestinationsList() {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.producerDestinations_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.MonitoringOrBuilder
        public MonitoringDestinationOrBuilder getProducerDestinationsOrBuilder(int i10) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.producerDestinations_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.MonitoringOrBuilder
        public List<? extends MonitoringDestinationOrBuilder> getProducerDestinationsOrBuilderList() {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.producerDestinations_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return w.f53976b.ensureFieldAccessorsInitialized(Monitoring.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder removeConsumerDestinations(int i10) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureConsumerDestinationsIsMutable();
                this.consumerDestinations_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder removeProducerDestinations(int i10) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureProducerDestinationsIsMutable();
                this.producerDestinations_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder setConsumerDestinations(int i10, MonitoringDestination monitoringDestination) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(monitoringDestination);
                ensureConsumerDestinationsIsMutable();
                this.consumerDestinations_.set(i10, monitoringDestination);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, monitoringDestination);
            }
            return this;
        }

        public Builder setProducerDestinations(int i10, MonitoringDestination monitoringDestination) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(monitoringDestination);
                ensureProducerDestinationsIsMutable();
                this.producerDestinations_.set(i10, monitoringDestination);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, monitoringDestination);
            }
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        private Builder() {
            this.producerDestinations_ = Collections.emptyList();
            this.consumerDestinations_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public MonitoringDestination.Builder addConsumerDestinationsBuilder(int i10) {
            return getConsumerDestinationsFieldBuilder().addBuilder(i10, MonitoringDestination.getDefaultInstance());
        }

        public MonitoringDestination.Builder addProducerDestinationsBuilder(int i10) {
            return getProducerDestinationsFieldBuilder().addBuilder(i10, MonitoringDestination.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Monitoring build() {
            Monitoring buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Monitoring buildPartial() {
            Monitoring monitoring = new Monitoring(this, (a) null);
            int i10 = this.bitField0_;
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((i10 & 1) != 0) {
                    this.producerDestinations_ = Collections.unmodifiableList(this.producerDestinations_);
                    this.bitField0_ &= -2;
                }
                monitoring.producerDestinations_ = this.producerDestinations_;
            } else {
                monitoring.producerDestinations_ = repeatedFieldBuilderV3.build();
            }
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV32 = this.consumerDestinationsBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                if ((this.bitField0_ & 2) != 0) {
                    this.consumerDestinations_ = Collections.unmodifiableList(this.consumerDestinations_);
                    this.bitField0_ &= -3;
                }
                monitoring.consumerDestinations_ = this.consumerDestinations_;
            } else {
                monitoring.consumerDestinations_ = repeatedFieldBuilderV32.build();
            }
            onBuilt();
            return monitoring;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Monitoring getDefaultInstanceForType() {
            return Monitoring.getDefaultInstance();
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
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.producerDestinations_ = Collections.emptyList();
                this.bitField0_ &= -2;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV32 = this.consumerDestinationsBuilder_;
            if (repeatedFieldBuilderV32 == null) {
                this.consumerDestinations_ = Collections.emptyList();
                this.bitField0_ &= -3;
            } else {
                repeatedFieldBuilderV32.clear();
            }
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.producerDestinations_ = Collections.emptyList();
            this.consumerDestinations_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Builder addConsumerDestinations(int i10, MonitoringDestination monitoringDestination) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(monitoringDestination);
                ensureConsumerDestinationsIsMutable();
                this.consumerDestinations_.add(i10, monitoringDestination);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, monitoringDestination);
            }
            return this;
        }

        public Builder addProducerDestinations(int i10, MonitoringDestination monitoringDestination) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(monitoringDestination);
                ensureProducerDestinationsIsMutable();
                this.producerDestinations_.add(i10, monitoringDestination);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, monitoringDestination);
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
            if (message instanceof Monitoring) {
                return mergeFrom((Monitoring) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setConsumerDestinations(int i10, MonitoringDestination.Builder builder) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureConsumerDestinationsIsMutable();
                this.consumerDestinations_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder setProducerDestinations(int i10, MonitoringDestination.Builder builder) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureProducerDestinationsIsMutable();
                this.producerDestinations_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder mergeFrom(Monitoring monitoring) {
            if (monitoring == Monitoring.getDefaultInstance()) {
                return this;
            }
            if (this.producerDestinationsBuilder_ == null) {
                if (!monitoring.producerDestinations_.isEmpty()) {
                    if (this.producerDestinations_.isEmpty()) {
                        this.producerDestinations_ = monitoring.producerDestinations_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureProducerDestinationsIsMutable();
                        this.producerDestinations_.addAll(monitoring.producerDestinations_);
                    }
                    onChanged();
                }
            } else if (!monitoring.producerDestinations_.isEmpty()) {
                if (this.producerDestinationsBuilder_.isEmpty()) {
                    this.producerDestinationsBuilder_.dispose();
                    this.producerDestinationsBuilder_ = null;
                    this.producerDestinations_ = monitoring.producerDestinations_;
                    this.bitField0_ &= -2;
                    this.producerDestinationsBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getProducerDestinationsFieldBuilder() : null;
                } else {
                    this.producerDestinationsBuilder_.addAllMessages(monitoring.producerDestinations_);
                }
            }
            if (this.consumerDestinationsBuilder_ == null) {
                if (!monitoring.consumerDestinations_.isEmpty()) {
                    if (this.consumerDestinations_.isEmpty()) {
                        this.consumerDestinations_ = monitoring.consumerDestinations_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureConsumerDestinationsIsMutable();
                        this.consumerDestinations_.addAll(monitoring.consumerDestinations_);
                    }
                    onChanged();
                }
            } else if (!monitoring.consumerDestinations_.isEmpty()) {
                if (this.consumerDestinationsBuilder_.isEmpty()) {
                    this.consumerDestinationsBuilder_.dispose();
                    this.consumerDestinationsBuilder_ = null;
                    this.consumerDestinations_ = monitoring.consumerDestinations_;
                    this.bitField0_ &= -3;
                    this.consumerDestinationsBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getConsumerDestinationsFieldBuilder() : null;
                } else {
                    this.consumerDestinationsBuilder_.addAllMessages(monitoring.consumerDestinations_);
                }
            }
            mergeUnknownFields(monitoring.unknownFields);
            onChanged();
            return this;
        }

        public Builder addConsumerDestinations(MonitoringDestination.Builder builder) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureConsumerDestinationsIsMutable();
                this.consumerDestinations_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addProducerDestinations(MonitoringDestination.Builder builder) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureProducerDestinationsIsMutable();
                this.producerDestinations_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addConsumerDestinations(int i10, MonitoringDestination.Builder builder) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.consumerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureConsumerDestinationsIsMutable();
                this.consumerDestinations_.add(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, builder.build());
            }
            return this;
        }

        public Builder addProducerDestinations(int i10, MonitoringDestination.Builder builder) {
            RepeatedFieldBuilderV3<MonitoringDestination, MonitoringDestination.Builder, MonitoringDestinationOrBuilder> repeatedFieldBuilderV3 = this.producerDestinationsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureProducerDestinationsIsMutable();
                this.producerDestinations_.add(i10, builder.build());
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
        public com.google.api.Monitoring.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.api.Monitoring.access$2000()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.api.Monitoring r3 = (com.google.api.Monitoring) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.api.Monitoring r4 = (com.google.api.Monitoring) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.Monitoring.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.Monitoring$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class MonitoringDestination extends GeneratedMessageV3 implements MonitoringDestinationOrBuilder {
        public static final int METRICS_FIELD_NUMBER = 2;
        public static final int MONITORED_RESOURCE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private LazyStringList metrics_;
        private volatile Object monitoredResource_;
        private static final MonitoringDestination DEFAULT_INSTANCE = new MonitoringDestination();
        private static final Parser<MonitoringDestination> PARSER = new a();

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MonitoringDestinationOrBuilder {
            private int bitField0_;
            private LazyStringList metrics_;
            private Object monitoredResource_;

            public /* synthetic */ Builder(a aVar) {
                this();
            }

            private void ensureMetricsIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.metrics_ = new LazyStringArrayList(this.metrics_);
                    this.bitField0_ |= 1;
                }
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return w.f53977c;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder addAllMetrics(Iterable<String> iterable) {
                ensureMetricsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.metrics_);
                onChanged();
                return this;
            }

            public Builder addMetrics(String str) {
                Objects.requireNonNull(str);
                ensureMetricsIsMutable();
                this.metrics_.add((LazyStringList) str);
                onChanged();
                return this;
            }

            public Builder addMetricsBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                ensureMetricsIsMutable();
                this.metrics_.add(byteString);
                onChanged();
                return this;
            }

            public Builder clearMetrics() {
                this.metrics_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearMonitoredResource() {
                this.monitoredResource_ = MonitoringDestination.getDefaultInstance().getMonitoredResource();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return w.f53977c;
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public String getMetrics(int i10) {
                return this.metrics_.get(i10);
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public ByteString getMetricsBytes(int i10) {
                return this.metrics_.getByteString(i10);
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public int getMetricsCount() {
                return this.metrics_.size();
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public String getMonitoredResource() {
                Object obj = this.monitoredResource_;
                if (!(obj instanceof String)) {
                    String stringUtf8 = ((ByteString) obj).toStringUtf8();
                    this.monitoredResource_ = stringUtf8;
                    return stringUtf8;
                }
                return (String) obj;
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public ByteString getMonitoredResourceBytes() {
                Object obj = this.monitoredResource_;
                if (obj instanceof String) {
                    ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                    this.monitoredResource_ = copyFromUtf8;
                    return copyFromUtf8;
                }
                return (ByteString) obj;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return w.f53978d.ensureFieldAccessorsInitialized(MonitoringDestination.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setMetrics(int i10, String str) {
                Objects.requireNonNull(str);
                ensureMetricsIsMutable();
                this.metrics_.set(i10, (int) str);
                onChanged();
                return this;
            }

            public Builder setMonitoredResource(String str) {
                Objects.requireNonNull(str);
                this.monitoredResource_ = str;
                onChanged();
                return this;
            }

            public Builder setMonitoredResourceBytes(ByteString byteString) {
                Objects.requireNonNull(byteString);
                AbstractMessageLite.checkByteStringIsUtf8(byteString);
                this.monitoredResource_ = byteString;
                onChanged();
                return this;
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
                this(builderParent);
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public ProtocolStringList getMetricsList() {
                return this.metrics_.getUnmodifiableView();
            }

            private Builder() {
                this.monitoredResource_ = "";
                this.metrics_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MonitoringDestination build() {
                MonitoringDestination buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MonitoringDestination buildPartial() {
                MonitoringDestination monitoringDestination = new MonitoringDestination(this, (a) null);
                monitoringDestination.monitoredResource_ = this.monitoredResource_;
                if ((this.bitField0_ & 1) != 0) {
                    this.metrics_ = this.metrics_.getUnmodifiableView();
                    this.bitField0_ &= -2;
                }
                monitoringDestination.metrics_ = this.metrics_;
                onBuilt();
                return monitoringDestination;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MonitoringDestination getDefaultInstanceForType() {
                return MonitoringDestination.getDefaultInstance();
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
                this.monitoredResource_ = "";
                this.metrics_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -2;
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.monitoredResource_ = "";
                this.metrics_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof MonitoringDestination) {
                    return mergeFrom((MonitoringDestination) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(MonitoringDestination monitoringDestination) {
                if (monitoringDestination == MonitoringDestination.getDefaultInstance()) {
                    return this;
                }
                if (!monitoringDestination.getMonitoredResource().isEmpty()) {
                    this.monitoredResource_ = monitoringDestination.monitoredResource_;
                    onChanged();
                }
                if (!monitoringDestination.metrics_.isEmpty()) {
                    if (this.metrics_.isEmpty()) {
                        this.metrics_ = monitoringDestination.metrics_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureMetricsIsMutable();
                        this.metrics_.addAll(monitoringDestination.metrics_);
                    }
                    onChanged();
                }
                mergeUnknownFields(monitoringDestination.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.google.api.Monitoring.MonitoringDestination.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.google.api.Monitoring.MonitoringDestination.access$700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.google.api.Monitoring$MonitoringDestination r3 = (com.google.api.Monitoring.MonitoringDestination) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.google.api.Monitoring$MonitoringDestination r4 = (com.google.api.Monitoring.MonitoringDestination) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.google.api.Monitoring.MonitoringDestination.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.Monitoring$MonitoringDestination$Builder");
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class a extends AbstractParser<MonitoringDestination> {
            @Override // com.google.protobuf.Parser
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public MonitoringDestination parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new MonitoringDestination(codedInputStream, extensionRegistryLite, null);
            }
        }

        public /* synthetic */ MonitoringDestination(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static MonitoringDestination getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return w.f53977c;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static MonitoringDestination parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MonitoringDestination) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static MonitoringDestination parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<MonitoringDestination> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MonitoringDestination)) {
                return super.equals(obj);
            }
            MonitoringDestination monitoringDestination = (MonitoringDestination) obj;
            return getMonitoredResource().equals(monitoringDestination.getMonitoredResource()) && getMetricsList().equals(monitoringDestination.getMetricsList()) && this.unknownFields.equals(monitoringDestination.unknownFields);
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public String getMetrics(int i10) {
            return this.metrics_.get(i10);
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public ByteString getMetricsBytes(int i10) {
            return this.metrics_.getByteString(i10);
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public int getMetricsCount() {
            return this.metrics_.size();
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public String getMonitoredResource() {
            Object obj = this.monitoredResource_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.monitoredResource_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public ByteString getMonitoredResourceBytes() {
            Object obj = this.monitoredResource_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.monitoredResource_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MonitoringDestination> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeStringSize = !GeneratedMessageV3.isStringEmpty(this.monitoredResource_) ? GeneratedMessageV3.computeStringSize(1, this.monitoredResource_) + 0 : 0;
            int i11 = 0;
            for (int i12 = 0; i12 < this.metrics_.size(); i12++) {
                i11 += GeneratedMessageV3.computeStringSizeNoTag(this.metrics_.getRaw(i12));
            }
            int size = computeStringSize + i11 + (getMetricsList().size() * 1) + this.unknownFields.getSerializedSize();
            this.memoizedSize = size;
            return size;
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
            int hashCode = ((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getMonitoredResource().hashCode();
            if (getMetricsCount() > 0) {
                hashCode = (((hashCode * 37) + 2) * 53) + getMetricsList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return w.f53978d.ensureFieldAccessorsInitialized(MonitoringDestination.class, Builder.class);
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
            return new MonitoringDestination();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!GeneratedMessageV3.isStringEmpty(this.monitoredResource_)) {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.monitoredResource_);
            }
            for (int i10 = 0; i10 < this.metrics_.size(); i10++) {
                GeneratedMessageV3.writeString(codedOutputStream, 2, this.metrics_.getRaw(i10));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public /* synthetic */ MonitoringDestination(GeneratedMessageV3.Builder builder, a aVar) {
            this(builder);
        }

        public static Builder newBuilder(MonitoringDestination monitoringDestination) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(monitoringDestination);
        }

        public static MonitoringDestination parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MonitoringDestination) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static MonitoringDestination parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public ProtocolStringList getMetricsList() {
            return this.metrics_;
        }

        private MonitoringDestination(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static MonitoringDestination parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MonitoringDestination getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            a aVar = null;
            return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
        }

        public static MonitoringDestination parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private MonitoringDestination() {
            this.memoizedIsInitialized = (byte) -1;
            this.monitoredResource_ = "";
            this.metrics_ = LazyStringArrayList.EMPTY;
        }

        public static MonitoringDestination parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static MonitoringDestination parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static MonitoringDestination parseFrom(InputStream inputStream) throws IOException {
            return (MonitoringDestination) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static MonitoringDestination parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MonitoringDestination) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        private MonitoringDestination(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    this.monitoredResource_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag != 18) {
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!(z11 & true)) {
                                        this.metrics_ = new LazyStringArrayList();
                                        z11 |= true;
                                    }
                                    this.metrics_.add((LazyStringList) readStringRequireUtf8);
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
                        this.metrics_ = this.metrics_.getUnmodifiableView();
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static MonitoringDestination parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MonitoringDestination) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static MonitoringDestination parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MonitoringDestination) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface MonitoringDestinationOrBuilder extends MessageOrBuilder {
        String getMetrics(int i10);

        ByteString getMetricsBytes(int i10);

        int getMetricsCount();

        List<String> getMetricsList();

        String getMonitoredResource();

        ByteString getMonitoredResourceBytes();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<Monitoring> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Monitoring parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Monitoring(codedInputStream, extensionRegistryLite, null);
        }
    }

    public /* synthetic */ Monitoring(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static Monitoring getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return w.f53975a;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Monitoring parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Monitoring) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Monitoring parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<Monitoring> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Monitoring)) {
            return super.equals(obj);
        }
        Monitoring monitoring = (Monitoring) obj;
        return getProducerDestinationsList().equals(monitoring.getProducerDestinationsList()) && getConsumerDestinationsList().equals(monitoring.getConsumerDestinationsList()) && this.unknownFields.equals(monitoring.unknownFields);
    }

    @Override // com.google.api.MonitoringOrBuilder
    public MonitoringDestination getConsumerDestinations(int i10) {
        return this.consumerDestinations_.get(i10);
    }

    @Override // com.google.api.MonitoringOrBuilder
    public int getConsumerDestinationsCount() {
        return this.consumerDestinations_.size();
    }

    @Override // com.google.api.MonitoringOrBuilder
    public List<MonitoringDestination> getConsumerDestinationsList() {
        return this.consumerDestinations_;
    }

    @Override // com.google.api.MonitoringOrBuilder
    public MonitoringDestinationOrBuilder getConsumerDestinationsOrBuilder(int i10) {
        return this.consumerDestinations_.get(i10);
    }

    @Override // com.google.api.MonitoringOrBuilder
    public List<? extends MonitoringDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
        return this.consumerDestinations_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Monitoring> getParserForType() {
        return PARSER;
    }

    @Override // com.google.api.MonitoringOrBuilder
    public MonitoringDestination getProducerDestinations(int i10) {
        return this.producerDestinations_.get(i10);
    }

    @Override // com.google.api.MonitoringOrBuilder
    public int getProducerDestinationsCount() {
        return this.producerDestinations_.size();
    }

    @Override // com.google.api.MonitoringOrBuilder
    public List<MonitoringDestination> getProducerDestinationsList() {
        return this.producerDestinations_;
    }

    @Override // com.google.api.MonitoringOrBuilder
    public MonitoringDestinationOrBuilder getProducerDestinationsOrBuilder(int i10) {
        return this.producerDestinations_.get(i10);
    }

    @Override // com.google.api.MonitoringOrBuilder
    public List<? extends MonitoringDestinationOrBuilder> getProducerDestinationsOrBuilderList() {
        return this.producerDestinations_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.producerDestinations_.size(); i12++) {
            i11 += CodedOutputStream.computeMessageSize(1, this.producerDestinations_.get(i12));
        }
        for (int i13 = 0; i13 < this.consumerDestinations_.size(); i13++) {
            i11 += CodedOutputStream.computeMessageSize(2, this.consumerDestinations_.get(i13));
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
        if (getProducerDestinationsCount() > 0) {
            hashCode = (((hashCode * 37) + 1) * 53) + getProducerDestinationsList().hashCode();
        }
        if (getConsumerDestinationsCount() > 0) {
            hashCode = (((hashCode * 37) + 2) * 53) + getConsumerDestinationsList().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return w.f53976b.ensureFieldAccessorsInitialized(Monitoring.class, Builder.class);
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
        return new Monitoring();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i10 = 0; i10 < this.producerDestinations_.size(); i10++) {
            codedOutputStream.writeMessage(1, this.producerDestinations_.get(i10));
        }
        for (int i11 = 0; i11 < this.consumerDestinations_.size(); i11++) {
            codedOutputStream.writeMessage(2, this.consumerDestinations_.get(i11));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ Monitoring(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(Monitoring monitoring) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(monitoring);
    }

    public static Monitoring parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Monitoring) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Monitoring parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private Monitoring(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Monitoring parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Monitoring getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static Monitoring parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private Monitoring() {
        this.memoizedIsInitialized = (byte) -1;
        this.producerDestinations_ = Collections.emptyList();
        this.consumerDestinations_ = Collections.emptyList();
    }

    public static Monitoring parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static Monitoring parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Monitoring parseFrom(InputStream inputStream) throws IOException {
        return (Monitoring) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Monitoring parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Monitoring) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Monitoring(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                if ((i10 & 1) == 0) {
                                    this.producerDestinations_ = new ArrayList();
                                    i10 |= 1;
                                }
                                this.producerDestinations_.add(codedInputStream.readMessage(MonitoringDestination.parser(), extensionRegistryLite));
                            } else if (readTag != 18) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                if ((i10 & 2) == 0) {
                                    this.consumerDestinations_ = new ArrayList();
                                    i10 |= 2;
                                }
                                this.consumerDestinations_.add(codedInputStream.readMessage(MonitoringDestination.parser(), extensionRegistryLite));
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
                    this.producerDestinations_ = Collections.unmodifiableList(this.producerDestinations_);
                }
                if ((i10 & 2) != 0) {
                    this.consumerDestinations_ = Collections.unmodifiableList(this.consumerDestinations_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    public static Monitoring parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Monitoring) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Monitoring parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Monitoring) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
