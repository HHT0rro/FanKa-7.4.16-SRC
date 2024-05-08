package com.google.api;

import com.android.internal.logging.nano.MetricsProto;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import u7.j;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Distribution extends GeneratedMessageV3 implements DistributionOrBuilder {
    public static final int BUCKET_COUNTS_FIELD_NUMBER = 7;
    public static final int BUCKET_OPTIONS_FIELD_NUMBER = 6;
    public static final int COUNT_FIELD_NUMBER = 1;
    public static final int EXEMPLARS_FIELD_NUMBER = 10;
    public static final int MEAN_FIELD_NUMBER = 2;
    public static final int RANGE_FIELD_NUMBER = 4;
    public static final int SUM_OF_SQUARED_DEVIATION_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0;
    private int bucketCountsMemoizedSerializedSize;
    private Internal.LongList bucketCounts_;
    private BucketOptions bucketOptions_;
    private long count_;
    private List<Exemplar> exemplars_;
    private double mean_;
    private byte memoizedIsInitialized;
    private Range range_;
    private double sumOfSquaredDeviation_;
    private static final Distribution DEFAULT_INSTANCE = new Distribution();
    private static final Parser<Distribution> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class BucketOptions extends GeneratedMessageV3 implements BucketOptionsOrBuilder {
        public static final int EXPLICIT_BUCKETS_FIELD_NUMBER = 3;
        public static final int EXPONENTIAL_BUCKETS_FIELD_NUMBER = 2;
        public static final int LINEAR_BUCKETS_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int optionsCase_;
        private Object options_;
        private static final BucketOptions DEFAULT_INSTANCE = new BucketOptions();
        private static final Parser<BucketOptions> PARSER = new a();

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BucketOptionsOrBuilder {
            private SingleFieldBuilderV3<Explicit, Explicit.Builder, ExplicitOrBuilder> explicitBucketsBuilder_;
            private SingleFieldBuilderV3<Exponential, Exponential.Builder, ExponentialOrBuilder> exponentialBucketsBuilder_;
            private SingleFieldBuilderV3<Linear, Linear.Builder, LinearOrBuilder> linearBucketsBuilder_;
            private int optionsCase_;
            private Object options_;

            public /* synthetic */ Builder(a aVar) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return j.f53909e;
            }

            private SingleFieldBuilderV3<Explicit, Explicit.Builder, ExplicitOrBuilder> getExplicitBucketsFieldBuilder() {
                if (this.explicitBucketsBuilder_ == null) {
                    if (this.optionsCase_ != 3) {
                        this.options_ = Explicit.getDefaultInstance();
                    }
                    this.explicitBucketsBuilder_ = new SingleFieldBuilderV3<>((Explicit) this.options_, getParentForChildren(), isClean());
                    this.options_ = null;
                }
                this.optionsCase_ = 3;
                onChanged();
                return this.explicitBucketsBuilder_;
            }

            private SingleFieldBuilderV3<Exponential, Exponential.Builder, ExponentialOrBuilder> getExponentialBucketsFieldBuilder() {
                if (this.exponentialBucketsBuilder_ == null) {
                    if (this.optionsCase_ != 2) {
                        this.options_ = Exponential.getDefaultInstance();
                    }
                    this.exponentialBucketsBuilder_ = new SingleFieldBuilderV3<>((Exponential) this.options_, getParentForChildren(), isClean());
                    this.options_ = null;
                }
                this.optionsCase_ = 2;
                onChanged();
                return this.exponentialBucketsBuilder_;
            }

            private SingleFieldBuilderV3<Linear, Linear.Builder, LinearOrBuilder> getLinearBucketsFieldBuilder() {
                if (this.linearBucketsBuilder_ == null) {
                    if (this.optionsCase_ != 1) {
                        this.options_ = Linear.getDefaultInstance();
                    }
                    this.linearBucketsBuilder_ = new SingleFieldBuilderV3<>((Linear) this.options_, getParentForChildren(), isClean());
                    this.options_ = null;
                }
                this.optionsCase_ = 1;
                onChanged();
                return this.linearBucketsBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearExplicitBuckets() {
                SingleFieldBuilderV3<Explicit, Explicit.Builder, ExplicitOrBuilder> singleFieldBuilderV3 = this.explicitBucketsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.optionsCase_ == 3) {
                        this.optionsCase_ = 0;
                        this.options_ = null;
                        onChanged();
                    }
                } else {
                    if (this.optionsCase_ == 3) {
                        this.optionsCase_ = 0;
                        this.options_ = null;
                    }
                    singleFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder clearExponentialBuckets() {
                SingleFieldBuilderV3<Exponential, Exponential.Builder, ExponentialOrBuilder> singleFieldBuilderV3 = this.exponentialBucketsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.optionsCase_ == 2) {
                        this.optionsCase_ = 0;
                        this.options_ = null;
                        onChanged();
                    }
                } else {
                    if (this.optionsCase_ == 2) {
                        this.optionsCase_ = 0;
                        this.options_ = null;
                    }
                    singleFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder clearLinearBuckets() {
                SingleFieldBuilderV3<Linear, Linear.Builder, LinearOrBuilder> singleFieldBuilderV3 = this.linearBucketsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.optionsCase_ == 1) {
                        this.optionsCase_ = 0;
                        this.options_ = null;
                        onChanged();
                    }
                } else {
                    if (this.optionsCase_ == 1) {
                        this.optionsCase_ = 0;
                        this.options_ = null;
                    }
                    singleFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder clearOptions() {
                this.optionsCase_ = 0;
                this.options_ = null;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return j.f53909e;
            }

            @Override // com.google.api.Distribution.BucketOptionsOrBuilder
            public Explicit getExplicitBuckets() {
                SingleFieldBuilderV3<Explicit, Explicit.Builder, ExplicitOrBuilder> singleFieldBuilderV3 = this.explicitBucketsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.optionsCase_ == 3) {
                        return (Explicit) this.options_;
                    }
                    return Explicit.getDefaultInstance();
                }
                if (this.optionsCase_ == 3) {
                    return singleFieldBuilderV3.getMessage();
                }
                return Explicit.getDefaultInstance();
            }

            public Explicit.Builder getExplicitBucketsBuilder() {
                return getExplicitBucketsFieldBuilder().getBuilder();
            }

            @Override // com.google.api.Distribution.BucketOptionsOrBuilder
            public ExplicitOrBuilder getExplicitBucketsOrBuilder() {
                SingleFieldBuilderV3<Explicit, Explicit.Builder, ExplicitOrBuilder> singleFieldBuilderV3;
                int i10 = this.optionsCase_;
                if (i10 == 3 && (singleFieldBuilderV3 = this.explicitBucketsBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (i10 == 3) {
                    return (Explicit) this.options_;
                }
                return Explicit.getDefaultInstance();
            }

            @Override // com.google.api.Distribution.BucketOptionsOrBuilder
            public Exponential getExponentialBuckets() {
                SingleFieldBuilderV3<Exponential, Exponential.Builder, ExponentialOrBuilder> singleFieldBuilderV3 = this.exponentialBucketsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.optionsCase_ == 2) {
                        return (Exponential) this.options_;
                    }
                    return Exponential.getDefaultInstance();
                }
                if (this.optionsCase_ == 2) {
                    return singleFieldBuilderV3.getMessage();
                }
                return Exponential.getDefaultInstance();
            }

            public Exponential.Builder getExponentialBucketsBuilder() {
                return getExponentialBucketsFieldBuilder().getBuilder();
            }

            @Override // com.google.api.Distribution.BucketOptionsOrBuilder
            public ExponentialOrBuilder getExponentialBucketsOrBuilder() {
                SingleFieldBuilderV3<Exponential, Exponential.Builder, ExponentialOrBuilder> singleFieldBuilderV3;
                int i10 = this.optionsCase_;
                if (i10 == 2 && (singleFieldBuilderV3 = this.exponentialBucketsBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (i10 == 2) {
                    return (Exponential) this.options_;
                }
                return Exponential.getDefaultInstance();
            }

            @Override // com.google.api.Distribution.BucketOptionsOrBuilder
            public Linear getLinearBuckets() {
                SingleFieldBuilderV3<Linear, Linear.Builder, LinearOrBuilder> singleFieldBuilderV3 = this.linearBucketsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.optionsCase_ == 1) {
                        return (Linear) this.options_;
                    }
                    return Linear.getDefaultInstance();
                }
                if (this.optionsCase_ == 1) {
                    return singleFieldBuilderV3.getMessage();
                }
                return Linear.getDefaultInstance();
            }

            public Linear.Builder getLinearBucketsBuilder() {
                return getLinearBucketsFieldBuilder().getBuilder();
            }

            @Override // com.google.api.Distribution.BucketOptionsOrBuilder
            public LinearOrBuilder getLinearBucketsOrBuilder() {
                SingleFieldBuilderV3<Linear, Linear.Builder, LinearOrBuilder> singleFieldBuilderV3;
                int i10 = this.optionsCase_;
                if (i10 == 1 && (singleFieldBuilderV3 = this.linearBucketsBuilder_) != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                if (i10 == 1) {
                    return (Linear) this.options_;
                }
                return Linear.getDefaultInstance();
            }

            @Override // com.google.api.Distribution.BucketOptionsOrBuilder
            public OptionsCase getOptionsCase() {
                return OptionsCase.forNumber(this.optionsCase_);
            }

            @Override // com.google.api.Distribution.BucketOptionsOrBuilder
            public boolean hasExplicitBuckets() {
                return this.optionsCase_ == 3;
            }

            @Override // com.google.api.Distribution.BucketOptionsOrBuilder
            public boolean hasExponentialBuckets() {
                return this.optionsCase_ == 2;
            }

            @Override // com.google.api.Distribution.BucketOptionsOrBuilder
            public boolean hasLinearBuckets() {
                return this.optionsCase_ == 1;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return j.f53910f.ensureFieldAccessorsInitialized(BucketOptions.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeExplicitBuckets(Explicit explicit) {
                SingleFieldBuilderV3<Explicit, Explicit.Builder, ExplicitOrBuilder> singleFieldBuilderV3 = this.explicitBucketsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.optionsCase_ == 3 && this.options_ != Explicit.getDefaultInstance()) {
                        this.options_ = Explicit.newBuilder((Explicit) this.options_).mergeFrom(explicit).buildPartial();
                    } else {
                        this.options_ = explicit;
                    }
                    onChanged();
                } else if (this.optionsCase_ == 3) {
                    singleFieldBuilderV3.mergeFrom(explicit);
                } else {
                    singleFieldBuilderV3.setMessage(explicit);
                }
                this.optionsCase_ = 3;
                return this;
            }

            public Builder mergeExponentialBuckets(Exponential exponential) {
                SingleFieldBuilderV3<Exponential, Exponential.Builder, ExponentialOrBuilder> singleFieldBuilderV3 = this.exponentialBucketsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.optionsCase_ == 2 && this.options_ != Exponential.getDefaultInstance()) {
                        this.options_ = Exponential.newBuilder((Exponential) this.options_).mergeFrom(exponential).buildPartial();
                    } else {
                        this.options_ = exponential;
                    }
                    onChanged();
                } else if (this.optionsCase_ == 2) {
                    singleFieldBuilderV3.mergeFrom(exponential);
                } else {
                    singleFieldBuilderV3.setMessage(exponential);
                }
                this.optionsCase_ = 2;
                return this;
            }

            public Builder mergeLinearBuckets(Linear linear) {
                SingleFieldBuilderV3<Linear, Linear.Builder, LinearOrBuilder> singleFieldBuilderV3 = this.linearBucketsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    if (this.optionsCase_ == 1 && this.options_ != Linear.getDefaultInstance()) {
                        this.options_ = Linear.newBuilder((Linear) this.options_).mergeFrom(linear).buildPartial();
                    } else {
                        this.options_ = linear;
                    }
                    onChanged();
                } else if (this.optionsCase_ == 1) {
                    singleFieldBuilderV3.mergeFrom(linear);
                } else {
                    singleFieldBuilderV3.setMessage(linear);
                }
                this.optionsCase_ = 1;
                return this;
            }

            public Builder setExplicitBuckets(Explicit explicit) {
                SingleFieldBuilderV3<Explicit, Explicit.Builder, ExplicitOrBuilder> singleFieldBuilderV3 = this.explicitBucketsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Objects.requireNonNull(explicit);
                    this.options_ = explicit;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(explicit);
                }
                this.optionsCase_ = 3;
                return this;
            }

            public Builder setExponentialBuckets(Exponential exponential) {
                SingleFieldBuilderV3<Exponential, Exponential.Builder, ExponentialOrBuilder> singleFieldBuilderV3 = this.exponentialBucketsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Objects.requireNonNull(exponential);
                    this.options_ = exponential;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(exponential);
                }
                this.optionsCase_ = 2;
                return this;
            }

            public Builder setLinearBuckets(Linear linear) {
                SingleFieldBuilderV3<Linear, Linear.Builder, LinearOrBuilder> singleFieldBuilderV3 = this.linearBucketsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Objects.requireNonNull(linear);
                    this.options_ = linear;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(linear);
                }
                this.optionsCase_ = 1;
                return this;
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
                this(builderParent);
            }

            private Builder() {
                this.optionsCase_ = 0;
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BucketOptions build() {
                BucketOptions buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BucketOptions buildPartial() {
                BucketOptions bucketOptions = new BucketOptions(this, (a) null);
                if (this.optionsCase_ == 1) {
                    SingleFieldBuilderV3<Linear, Linear.Builder, LinearOrBuilder> singleFieldBuilderV3 = this.linearBucketsBuilder_;
                    if (singleFieldBuilderV3 == null) {
                        bucketOptions.options_ = this.options_;
                    } else {
                        bucketOptions.options_ = singleFieldBuilderV3.build();
                    }
                }
                if (this.optionsCase_ == 2) {
                    SingleFieldBuilderV3<Exponential, Exponential.Builder, ExponentialOrBuilder> singleFieldBuilderV32 = this.exponentialBucketsBuilder_;
                    if (singleFieldBuilderV32 == null) {
                        bucketOptions.options_ = this.options_;
                    } else {
                        bucketOptions.options_ = singleFieldBuilderV32.build();
                    }
                }
                if (this.optionsCase_ == 3) {
                    SingleFieldBuilderV3<Explicit, Explicit.Builder, ExplicitOrBuilder> singleFieldBuilderV33 = this.explicitBucketsBuilder_;
                    if (singleFieldBuilderV33 == null) {
                        bucketOptions.options_ = this.options_;
                    } else {
                        bucketOptions.options_ = singleFieldBuilderV33.build();
                    }
                }
                bucketOptions.optionsCase_ = this.optionsCase_;
                onBuilt();
                return bucketOptions;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BucketOptions getDefaultInstanceForType() {
                return BucketOptions.getDefaultInstance();
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
                this.optionsCase_ = 0;
                this.options_ = null;
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.optionsCase_ = 0;
                maybeForceBuilderInitialization();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof BucketOptions) {
                    return mergeFrom((BucketOptions) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder setExplicitBuckets(Explicit.Builder builder) {
                SingleFieldBuilderV3<Explicit, Explicit.Builder, ExplicitOrBuilder> singleFieldBuilderV3 = this.explicitBucketsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.options_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.optionsCase_ = 3;
                return this;
            }

            public Builder setExponentialBuckets(Exponential.Builder builder) {
                SingleFieldBuilderV3<Exponential, Exponential.Builder, ExponentialOrBuilder> singleFieldBuilderV3 = this.exponentialBucketsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.options_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.optionsCase_ = 2;
                return this;
            }

            public Builder setLinearBuckets(Linear.Builder builder) {
                SingleFieldBuilderV3<Linear, Linear.Builder, LinearOrBuilder> singleFieldBuilderV3 = this.linearBucketsBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.options_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                this.optionsCase_ = 1;
                return this;
            }

            public Builder mergeFrom(BucketOptions bucketOptions) {
                if (bucketOptions == BucketOptions.getDefaultInstance()) {
                    return this;
                }
                int i10 = b.f25926a[bucketOptions.getOptionsCase().ordinal()];
                if (i10 == 1) {
                    mergeLinearBuckets(bucketOptions.getLinearBuckets());
                } else if (i10 == 2) {
                    mergeExponentialBuckets(bucketOptions.getExponentialBuckets());
                } else if (i10 == 3) {
                    mergeExplicitBuckets(bucketOptions.getExplicitBuckets());
                }
                mergeUnknownFields(bucketOptions.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.google.api.Distribution.BucketOptions.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.google.api.Distribution.BucketOptions.access$4800()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.google.api.Distribution$BucketOptions r3 = (com.google.api.Distribution.BucketOptions) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.google.api.Distribution$BucketOptions r4 = (com.google.api.Distribution.BucketOptions) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.google.api.Distribution.BucketOptions.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.Distribution$BucketOptions$Builder");
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class Explicit extends GeneratedMessageV3 implements ExplicitOrBuilder {
            public static final int BOUNDS_FIELD_NUMBER = 1;
            private static final Explicit DEFAULT_INSTANCE = new Explicit();
            private static final Parser<Explicit> PARSER = new a();
            private static final long serialVersionUID = 0;
            private int boundsMemoizedSerializedSize;
            private Internal.DoubleList bounds_;
            private byte memoizedIsInitialized;

            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ExplicitOrBuilder {
                private int bitField0_;
                private Internal.DoubleList bounds_;

                public /* synthetic */ Builder(a aVar) {
                    this();
                }

                private void ensureBoundsIsMutable() {
                    if ((this.bitField0_ & 1) == 0) {
                        this.bounds_ = GeneratedMessageV3.mutableCopy(this.bounds_);
                        this.bitField0_ |= 1;
                    }
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return j.f53915k;
                }

                private void maybeForceBuilderInitialization() {
                    boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
                }

                public Builder addAllBounds(Iterable<? extends Double> iterable) {
                    ensureBoundsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.bounds_);
                    onChanged();
                    return this;
                }

                public Builder addBounds(double d10) {
                    ensureBoundsIsMutable();
                    this.bounds_.addDouble(d10);
                    onChanged();
                    return this;
                }

                public Builder clearBounds() {
                    this.bounds_ = Explicit.access$3900();
                    this.bitField0_ &= -2;
                    onChanged();
                    return this;
                }

                @Override // com.google.api.Distribution.BucketOptions.ExplicitOrBuilder
                public double getBounds(int i10) {
                    return this.bounds_.getDouble(i10);
                }

                @Override // com.google.api.Distribution.BucketOptions.ExplicitOrBuilder
                public int getBoundsCount() {
                    return this.bounds_.size();
                }

                @Override // com.google.api.Distribution.BucketOptions.ExplicitOrBuilder
                public List<Double> getBoundsList() {
                    return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.bounds_) : this.bounds_;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return j.f53915k;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return j.f53916l.ensureFieldAccessorsInitialized(Explicit.class, Builder.class);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public Builder setBounds(int i10, double d10) {
                    ensureBoundsIsMutable();
                    this.bounds_.setDouble(i10, d10);
                    onChanged();
                    return this;
                }

                public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
                    this(builderParent);
                }

                private Builder() {
                    this.bounds_ = Explicit.access$3700();
                    maybeForceBuilderInitialization();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
                public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.addRepeatedField(fieldDescriptor, obj);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Explicit build() {
                    Explicit buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Explicit buildPartial() {
                    Explicit explicit = new Explicit(this, (a) null);
                    if ((this.bitField0_ & 1) != 0) {
                        this.bounds_.makeImmutable();
                        this.bitField0_ &= -2;
                    }
                    explicit.bounds_ = this.bounds_;
                    onBuilt();
                    return explicit;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
                public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                    return (Builder) super.clearField(fieldDescriptor);
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public Explicit getDefaultInstanceForType() {
                    return Explicit.getDefaultInstance();
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
                    this.bounds_ = Explicit.access$3200();
                    this.bitField0_ &= -2;
                    return this;
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.bounds_ = Explicit.access$3700();
                    maybeForceBuilderInitialization();
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public Builder mo2458clone() {
                    return (Builder) super.mo2458clone();
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(Message message) {
                    if (message instanceof Explicit) {
                        return mergeFrom((Explicit) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder mergeFrom(Explicit explicit) {
                    if (explicit == Explicit.getDefaultInstance()) {
                        return this;
                    }
                    if (!explicit.bounds_.isEmpty()) {
                        if (this.bounds_.isEmpty()) {
                            this.bounds_ = explicit.bounds_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureBoundsIsMutable();
                            this.bounds_.addAll(explicit.bounds_);
                        }
                        onChanged();
                    }
                    mergeUnknownFields(explicit.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public com.google.api.Distribution.BucketOptions.Explicit.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        com.google.protobuf.Parser r1 = com.google.api.Distribution.BucketOptions.Explicit.access$3600()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                        java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                        com.google.api.Distribution$BucketOptions$Explicit r3 = (com.google.api.Distribution.BucketOptions.Explicit) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                        com.google.api.Distribution$BucketOptions$Explicit r4 = (com.google.api.Distribution.BucketOptions.Explicit) r4     // Catch: java.lang.Throwable -> L11
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
                    throw new UnsupportedOperationException("Method not decompiled: com.google.api.Distribution.BucketOptions.Explicit.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.Distribution$BucketOptions$Explicit$Builder");
                }
            }

            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
            public static class a extends AbstractParser<Explicit> {
                @Override // com.google.protobuf.Parser
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Explicit parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Explicit(codedInputStream, extensionRegistryLite, null);
                }
            }

            public /* synthetic */ Explicit(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
                this(codedInputStream, extensionRegistryLite);
            }

            public static /* synthetic */ Internal.DoubleList access$3200() {
                return GeneratedMessageV3.emptyDoubleList();
            }

            public static /* synthetic */ Internal.DoubleList access$3700() {
                return GeneratedMessageV3.emptyDoubleList();
            }

            public static /* synthetic */ Internal.DoubleList access$3900() {
                return GeneratedMessageV3.emptyDoubleList();
            }

            public static Explicit getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return j.f53915k;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Explicit parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Explicit) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static Explicit parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static Parser<Explicit> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Explicit)) {
                    return super.equals(obj);
                }
                Explicit explicit = (Explicit) obj;
                return getBoundsList().equals(explicit.getBoundsList()) && this.unknownFields.equals(explicit.unknownFields);
            }

            @Override // com.google.api.Distribution.BucketOptions.ExplicitOrBuilder
            public double getBounds(int i10) {
                return this.bounds_.getDouble(i10);
            }

            @Override // com.google.api.Distribution.BucketOptions.ExplicitOrBuilder
            public int getBoundsCount() {
                return this.bounds_.size();
            }

            @Override // com.google.api.Distribution.BucketOptions.ExplicitOrBuilder
            public List<Double> getBoundsList() {
                return this.bounds_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<Explicit> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i10 = this.memoizedSize;
                if (i10 != -1) {
                    return i10;
                }
                int size = getBoundsList().size() * 8;
                int i11 = size + 0;
                if (!getBoundsList().isEmpty()) {
                    i11 = i11 + 1 + CodedOutputStream.computeInt32SizeNoTag(size);
                }
                this.boundsMemoizedSerializedSize = size;
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
                if (getBoundsCount() > 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + getBoundsList().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return j.f53916l.ensureFieldAccessorsInitialized(Explicit.class, Builder.class);
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
                return new Explicit();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if (getBoundsList().size() > 0) {
                    codedOutputStream.writeUInt32NoTag(10);
                    codedOutputStream.writeUInt32NoTag(this.boundsMemoizedSerializedSize);
                }
                for (int i10 = 0; i10 < this.bounds_.size(); i10++) {
                    codedOutputStream.writeDoubleNoTag(this.bounds_.getDouble(i10));
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            public /* synthetic */ Explicit(GeneratedMessageV3.Builder builder, a aVar) {
                this(builder);
            }

            public static Builder newBuilder(Explicit explicit) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(explicit);
            }

            public static Explicit parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Explicit) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static Explicit parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            private Explicit(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.boundsMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
            }

            public static Explicit parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Explicit getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder toBuilder() {
                a aVar = null;
                return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
            }

            public static Explicit parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Explicit parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
                return new Builder(builderParent, null);
            }

            private Explicit() {
                this.boundsMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.bounds_ = GeneratedMessageV3.emptyDoubleList();
            }

            public static Explicit parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            public static Explicit parseFrom(InputStream inputStream) throws IOException {
                return (Explicit) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static Explicit parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Explicit) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static Explicit parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Explicit) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            private Explicit(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    if (readTag == 9) {
                                        if (!(z11 & true)) {
                                            this.bounds_ = GeneratedMessageV3.newDoubleList();
                                            z11 |= true;
                                        }
                                        this.bounds_.addDouble(codedInputStream.readDouble());
                                    } else if (readTag != 10) {
                                        if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                        }
                                    } else {
                                        int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                        if (!(z11 & true) && codedInputStream.getBytesUntilLimit() > 0) {
                                            this.bounds_ = GeneratedMessageV3.newDoubleList();
                                            z11 |= true;
                                        }
                                        while (codedInputStream.getBytesUntilLimit() > 0) {
                                            this.bounds_.addDouble(codedInputStream.readDouble());
                                        }
                                        codedInputStream.popLimit(pushLimit);
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
                        if (z11 & true) {
                            this.bounds_.makeImmutable();
                        }
                        this.unknownFields = newBuilder.build();
                        makeExtensionsImmutable();
                    }
                }
            }

            public static Explicit parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Explicit) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public interface ExplicitOrBuilder extends MessageOrBuilder {
            double getBounds(int i10);

            int getBoundsCount();

            List<Double> getBoundsList();
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class Exponential extends GeneratedMessageV3 implements ExponentialOrBuilder {
            public static final int GROWTH_FACTOR_FIELD_NUMBER = 2;
            public static final int NUM_FINITE_BUCKETS_FIELD_NUMBER = 1;
            public static final int SCALE_FIELD_NUMBER = 3;
            private static final long serialVersionUID = 0;
            private double growthFactor_;
            private byte memoizedIsInitialized;
            private int numFiniteBuckets_;
            private double scale_;
            private static final Exponential DEFAULT_INSTANCE = new Exponential();
            private static final Parser<Exponential> PARSER = new a();

            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ExponentialOrBuilder {
                private double growthFactor_;
                private int numFiniteBuckets_;
                private double scale_;

                public /* synthetic */ Builder(a aVar) {
                    this();
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return j.f53913i;
                }

                private void maybeForceBuilderInitialization() {
                    boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
                }

                public Builder clearGrowthFactor() {
                    this.growthFactor_ = ShadowDrawableWrapper.COS_45;
                    onChanged();
                    return this;
                }

                public Builder clearNumFiniteBuckets() {
                    this.numFiniteBuckets_ = 0;
                    onChanged();
                    return this;
                }

                public Builder clearScale() {
                    this.scale_ = ShadowDrawableWrapper.COS_45;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return j.f53913i;
                }

                @Override // com.google.api.Distribution.BucketOptions.ExponentialOrBuilder
                public double getGrowthFactor() {
                    return this.growthFactor_;
                }

                @Override // com.google.api.Distribution.BucketOptions.ExponentialOrBuilder
                public int getNumFiniteBuckets() {
                    return this.numFiniteBuckets_;
                }

                @Override // com.google.api.Distribution.BucketOptions.ExponentialOrBuilder
                public double getScale() {
                    return this.scale_;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return j.f53914j.ensureFieldAccessorsInitialized(Exponential.class, Builder.class);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public Builder setGrowthFactor(double d10) {
                    this.growthFactor_ = d10;
                    onChanged();
                    return this;
                }

                public Builder setNumFiniteBuckets(int i10) {
                    this.numFiniteBuckets_ = i10;
                    onChanged();
                    return this;
                }

                public Builder setScale(double d10) {
                    this.scale_ = d10;
                    onChanged();
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
                public Exponential build() {
                    Exponential buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Exponential buildPartial() {
                    Exponential exponential = new Exponential(this, (a) null);
                    exponential.numFiniteBuckets_ = this.numFiniteBuckets_;
                    exponential.growthFactor_ = this.growthFactor_;
                    exponential.scale_ = this.scale_;
                    onBuilt();
                    return exponential;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
                public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                    return (Builder) super.clearField(fieldDescriptor);
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public Exponential getDefaultInstanceForType() {
                    return Exponential.getDefaultInstance();
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
                    this.numFiniteBuckets_ = 0;
                    this.growthFactor_ = ShadowDrawableWrapper.COS_45;
                    this.scale_ = ShadowDrawableWrapper.COS_45;
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public Builder mo2458clone() {
                    return (Builder) super.mo2458clone();
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(Message message) {
                    if (message instanceof Exponential) {
                        return mergeFrom((Exponential) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder mergeFrom(Exponential exponential) {
                    if (exponential == Exponential.getDefaultInstance()) {
                        return this;
                    }
                    if (exponential.getNumFiniteBuckets() != 0) {
                        setNumFiniteBuckets(exponential.getNumFiniteBuckets());
                    }
                    if (exponential.getGrowthFactor() != ShadowDrawableWrapper.COS_45) {
                        setGrowthFactor(exponential.getGrowthFactor());
                    }
                    if (exponential.getScale() != ShadowDrawableWrapper.COS_45) {
                        setScale(exponential.getScale());
                    }
                    mergeUnknownFields(exponential.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public com.google.api.Distribution.BucketOptions.Exponential.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        com.google.protobuf.Parser r1 = com.google.api.Distribution.BucketOptions.Exponential.access$2700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                        java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                        com.google.api.Distribution$BucketOptions$Exponential r3 = (com.google.api.Distribution.BucketOptions.Exponential) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                        com.google.api.Distribution$BucketOptions$Exponential r4 = (com.google.api.Distribution.BucketOptions.Exponential) r4     // Catch: java.lang.Throwable -> L11
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
                    throw new UnsupportedOperationException("Method not decompiled: com.google.api.Distribution.BucketOptions.Exponential.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.Distribution$BucketOptions$Exponential$Builder");
                }
            }

            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
            public static class a extends AbstractParser<Exponential> {
                @Override // com.google.protobuf.Parser
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Exponential parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Exponential(codedInputStream, extensionRegistryLite, null);
                }
            }

            public /* synthetic */ Exponential(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
                this(codedInputStream, extensionRegistryLite);
            }

            public static Exponential getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return j.f53913i;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Exponential parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Exponential) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static Exponential parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static Parser<Exponential> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Exponential)) {
                    return super.equals(obj);
                }
                Exponential exponential = (Exponential) obj;
                return getNumFiniteBuckets() == exponential.getNumFiniteBuckets() && Double.doubleToLongBits(getGrowthFactor()) == Double.doubleToLongBits(exponential.getGrowthFactor()) && Double.doubleToLongBits(getScale()) == Double.doubleToLongBits(exponential.getScale()) && this.unknownFields.equals(exponential.unknownFields);
            }

            @Override // com.google.api.Distribution.BucketOptions.ExponentialOrBuilder
            public double getGrowthFactor() {
                return this.growthFactor_;
            }

            @Override // com.google.api.Distribution.BucketOptions.ExponentialOrBuilder
            public int getNumFiniteBuckets() {
                return this.numFiniteBuckets_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<Exponential> getParserForType() {
                return PARSER;
            }

            @Override // com.google.api.Distribution.BucketOptions.ExponentialOrBuilder
            public double getScale() {
                return this.scale_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i10 = this.memoizedSize;
                if (i10 != -1) {
                    return i10;
                }
                int i11 = this.numFiniteBuckets_;
                int computeInt32Size = i11 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i11) : 0;
                if (Double.doubleToRawLongBits(this.growthFactor_) != 0) {
                    computeInt32Size += CodedOutputStream.computeDoubleSize(2, this.growthFactor_);
                }
                if (Double.doubleToRawLongBits(this.scale_) != 0) {
                    computeInt32Size += CodedOutputStream.computeDoubleSize(3, this.scale_);
                }
                int serializedSize = computeInt32Size + this.unknownFields.getSerializedSize();
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
                int hashCode = ((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getNumFiniteBuckets()) * 37) + 2) * 53) + Internal.hashLong(Double.doubleToLongBits(getGrowthFactor()))) * 37) + 3) * 53) + Internal.hashLong(Double.doubleToLongBits(getScale()))) * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode;
                return hashCode;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return j.f53914j.ensureFieldAccessorsInitialized(Exponential.class, Builder.class);
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
                return new Exponential();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i10 = this.numFiniteBuckets_;
                if (i10 != 0) {
                    codedOutputStream.writeInt32(1, i10);
                }
                if (Double.doubleToRawLongBits(this.growthFactor_) != 0) {
                    codedOutputStream.writeDouble(2, this.growthFactor_);
                }
                if (Double.doubleToRawLongBits(this.scale_) != 0) {
                    codedOutputStream.writeDouble(3, this.scale_);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            public /* synthetic */ Exponential(GeneratedMessageV3.Builder builder, a aVar) {
                this(builder);
            }

            public static Builder newBuilder(Exponential exponential) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(exponential);
            }

            public static Exponential parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Exponential) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static Exponential parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            private Exponential(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
            }

            public static Exponential parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Exponential getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder toBuilder() {
                a aVar = null;
                return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
            }

            public static Exponential parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            private Exponential() {
                this.memoizedIsInitialized = (byte) -1;
            }

            public static Exponential parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
                return new Builder(builderParent, null);
            }

            public static Exponential parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            private Exponential(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this();
                Objects.requireNonNull(extensionRegistryLite);
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.numFiniteBuckets_ = codedInputStream.readInt32();
                                } else if (readTag == 17) {
                                    this.growthFactor_ = codedInputStream.readDouble();
                                } else if (readTag != 25) {
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.scale_ = codedInputStream.readDouble();
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

            public static Exponential parseFrom(InputStream inputStream) throws IOException {
                return (Exponential) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static Exponential parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Exponential) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static Exponential parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Exponential) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static Exponential parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Exponential) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public interface ExponentialOrBuilder extends MessageOrBuilder {
            double getGrowthFactor();

            int getNumFiniteBuckets();

            double getScale();
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class Linear extends GeneratedMessageV3 implements LinearOrBuilder {
            public static final int NUM_FINITE_BUCKETS_FIELD_NUMBER = 1;
            public static final int OFFSET_FIELD_NUMBER = 3;
            public static final int WIDTH_FIELD_NUMBER = 2;
            private static final long serialVersionUID = 0;
            private byte memoizedIsInitialized;
            private int numFiniteBuckets_;
            private double offset_;
            private double width_;
            private static final Linear DEFAULT_INSTANCE = new Linear();
            private static final Parser<Linear> PARSER = new a();

            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LinearOrBuilder {
                private int numFiniteBuckets_;
                private double offset_;
                private double width_;

                public /* synthetic */ Builder(a aVar) {
                    this();
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return j.f53911g;
                }

                private void maybeForceBuilderInitialization() {
                    boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
                }

                public Builder clearNumFiniteBuckets() {
                    this.numFiniteBuckets_ = 0;
                    onChanged();
                    return this;
                }

                public Builder clearOffset() {
                    this.offset_ = ShadowDrawableWrapper.COS_45;
                    onChanged();
                    return this;
                }

                public Builder clearWidth() {
                    this.width_ = ShadowDrawableWrapper.COS_45;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return j.f53911g;
                }

                @Override // com.google.api.Distribution.BucketOptions.LinearOrBuilder
                public int getNumFiniteBuckets() {
                    return this.numFiniteBuckets_;
                }

                @Override // com.google.api.Distribution.BucketOptions.LinearOrBuilder
                public double getOffset() {
                    return this.offset_;
                }

                @Override // com.google.api.Distribution.BucketOptions.LinearOrBuilder
                public double getWidth() {
                    return this.width_;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return j.f53912h.ensureFieldAccessorsInitialized(Linear.class, Builder.class);
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                public Builder setNumFiniteBuckets(int i10) {
                    this.numFiniteBuckets_ = i10;
                    onChanged();
                    return this;
                }

                public Builder setOffset(double d10) {
                    this.offset_ = d10;
                    onChanged();
                    return this;
                }

                public Builder setWidth(double d10) {
                    this.width_ = d10;
                    onChanged();
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
                public Linear build() {
                    Linear buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Linear buildPartial() {
                    Linear linear = new Linear(this, (a) null);
                    linear.numFiniteBuckets_ = this.numFiniteBuckets_;
                    linear.width_ = this.width_;
                    linear.offset_ = this.offset_;
                    onBuilt();
                    return linear;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
                public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                    return (Builder) super.clearField(fieldDescriptor);
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public Linear getDefaultInstanceForType() {
                    return Linear.getDefaultInstance();
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
                    this.numFiniteBuckets_ = 0;
                    this.width_ = ShadowDrawableWrapper.COS_45;
                    this.offset_ = ShadowDrawableWrapper.COS_45;
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public Builder mo2458clone() {
                    return (Builder) super.mo2458clone();
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(Message message) {
                    if (message instanceof Linear) {
                        return mergeFrom((Linear) message);
                    }
                    super.mergeFrom(message);
                    return this;
                }

                public Builder mergeFrom(Linear linear) {
                    if (linear == Linear.getDefaultInstance()) {
                        return this;
                    }
                    if (linear.getNumFiniteBuckets() != 0) {
                        setNumFiniteBuckets(linear.getNumFiniteBuckets());
                    }
                    if (linear.getWidth() != ShadowDrawableWrapper.COS_45) {
                        setWidth(linear.getWidth());
                    }
                    if (linear.getOffset() != ShadowDrawableWrapper.COS_45) {
                        setOffset(linear.getOffset());
                    }
                    mergeUnknownFields(linear.unknownFields);
                    onChanged();
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public com.google.api.Distribution.BucketOptions.Linear.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        com.google.protobuf.Parser r1 = com.google.api.Distribution.BucketOptions.Linear.access$1700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                        java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                        com.google.api.Distribution$BucketOptions$Linear r3 = (com.google.api.Distribution.BucketOptions.Linear) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                        com.google.api.Distribution$BucketOptions$Linear r4 = (com.google.api.Distribution.BucketOptions.Linear) r4     // Catch: java.lang.Throwable -> L11
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
                    throw new UnsupportedOperationException("Method not decompiled: com.google.api.Distribution.BucketOptions.Linear.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.Distribution$BucketOptions$Linear$Builder");
                }
            }

            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
            public static class a extends AbstractParser<Linear> {
                @Override // com.google.protobuf.Parser
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Linear parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Linear(codedInputStream, extensionRegistryLite, null);
                }
            }

            public /* synthetic */ Linear(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
                this(codedInputStream, extensionRegistryLite);
            }

            public static Linear getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return j.f53911g;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Linear parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Linear) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
            }

            public static Linear parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer);
            }

            public static Parser<Linear> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Linear)) {
                    return super.equals(obj);
                }
                Linear linear = (Linear) obj;
                return getNumFiniteBuckets() == linear.getNumFiniteBuckets() && Double.doubleToLongBits(getWidth()) == Double.doubleToLongBits(linear.getWidth()) && Double.doubleToLongBits(getOffset()) == Double.doubleToLongBits(linear.getOffset()) && this.unknownFields.equals(linear.unknownFields);
            }

            @Override // com.google.api.Distribution.BucketOptions.LinearOrBuilder
            public int getNumFiniteBuckets() {
                return this.numFiniteBuckets_;
            }

            @Override // com.google.api.Distribution.BucketOptions.LinearOrBuilder
            public double getOffset() {
                return this.offset_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<Linear> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i10 = this.memoizedSize;
                if (i10 != -1) {
                    return i10;
                }
                int i11 = this.numFiniteBuckets_;
                int computeInt32Size = i11 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i11) : 0;
                if (Double.doubleToRawLongBits(this.width_) != 0) {
                    computeInt32Size += CodedOutputStream.computeDoubleSize(2, this.width_);
                }
                if (Double.doubleToRawLongBits(this.offset_) != 0) {
                    computeInt32Size += CodedOutputStream.computeDoubleSize(3, this.offset_);
                }
                int serializedSize = computeInt32Size + this.unknownFields.getSerializedSize();
                this.memoizedSize = serializedSize;
                return serializedSize;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            @Override // com.google.api.Distribution.BucketOptions.LinearOrBuilder
            public double getWidth() {
                return this.width_;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                int i10 = this.memoizedHashCode;
                if (i10 != 0) {
                    return i10;
                }
                int hashCode = ((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getNumFiniteBuckets()) * 37) + 2) * 53) + Internal.hashLong(Double.doubleToLongBits(getWidth()))) * 37) + 3) * 53) + Internal.hashLong(Double.doubleToLongBits(getOffset()))) * 29) + this.unknownFields.hashCode();
                this.memoizedHashCode = hashCode;
                return hashCode;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return j.f53912h.ensureFieldAccessorsInitialized(Linear.class, Builder.class);
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
                return new Linear();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                int i10 = this.numFiniteBuckets_;
                if (i10 != 0) {
                    codedOutputStream.writeInt32(1, i10);
                }
                if (Double.doubleToRawLongBits(this.width_) != 0) {
                    codedOutputStream.writeDouble(2, this.width_);
                }
                if (Double.doubleToRawLongBits(this.offset_) != 0) {
                    codedOutputStream.writeDouble(3, this.offset_);
                }
                this.unknownFields.writeTo(codedOutputStream);
            }

            public /* synthetic */ Linear(GeneratedMessageV3.Builder builder, a aVar) {
                this(builder);
            }

            public static Builder newBuilder(Linear linear) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(linear);
            }

            public static Linear parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Linear) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static Linear parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
            }

            private Linear(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
            }

            public static Linear parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Linear getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder toBuilder() {
                a aVar = null;
                return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
            }

            public static Linear parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            private Linear() {
                this.memoizedIsInitialized = (byte) -1;
            }

            public static Linear parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr);
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
                return new Builder(builderParent, null);
            }

            public static Linear parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(bArr, extensionRegistryLite);
            }

            private Linear(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this();
                Objects.requireNonNull(extensionRegistryLite);
                UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
                boolean z10 = false;
                while (!z10) {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.numFiniteBuckets_ = codedInputStream.readInt32();
                                } else if (readTag == 17) {
                                    this.width_ = codedInputStream.readDouble();
                                } else if (readTag != 25) {
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.offset_ = codedInputStream.readDouble();
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

            public static Linear parseFrom(InputStream inputStream) throws IOException {
                return (Linear) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
            }

            public static Linear parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Linear) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
            }

            public static Linear parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Linear) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
            }

            public static Linear parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Linear) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public interface LinearOrBuilder extends MessageOrBuilder {
            int getNumFiniteBuckets();

            double getOffset();

            double getWidth();
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public enum OptionsCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            LINEAR_BUCKETS(1),
            EXPONENTIAL_BUCKETS(2),
            EXPLICIT_BUCKETS(3),
            OPTIONS_NOT_SET(0);

            private final int value;

            OptionsCase(int i10) {
                this.value = i10;
            }

            public static OptionsCase forNumber(int i10) {
                if (i10 == 0) {
                    return OPTIONS_NOT_SET;
                }
                if (i10 == 1) {
                    return LINEAR_BUCKETS;
                }
                if (i10 == 2) {
                    return EXPONENTIAL_BUCKETS;
                }
                if (i10 != 3) {
                    return null;
                }
                return EXPLICIT_BUCKETS;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static OptionsCase valueOf(int i10) {
                return forNumber(i10);
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class a extends AbstractParser<BucketOptions> {
            @Override // com.google.protobuf.Parser
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public BucketOptions parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new BucketOptions(codedInputStream, extensionRegistryLite, null);
            }
        }

        public /* synthetic */ BucketOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static BucketOptions getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return j.f53909e;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static BucketOptions parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (BucketOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static BucketOptions parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<BucketOptions> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BucketOptions)) {
                return super.equals(obj);
            }
            BucketOptions bucketOptions = (BucketOptions) obj;
            if (!getOptionsCase().equals(bucketOptions.getOptionsCase())) {
                return false;
            }
            int i10 = this.optionsCase_;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3 && !getExplicitBuckets().equals(bucketOptions.getExplicitBuckets())) {
                        return false;
                    }
                } else if (!getExponentialBuckets().equals(bucketOptions.getExponentialBuckets())) {
                    return false;
                }
            } else if (!getLinearBuckets().equals(bucketOptions.getLinearBuckets())) {
                return false;
            }
            return this.unknownFields.equals(bucketOptions.unknownFields);
        }

        @Override // com.google.api.Distribution.BucketOptionsOrBuilder
        public Explicit getExplicitBuckets() {
            if (this.optionsCase_ == 3) {
                return (Explicit) this.options_;
            }
            return Explicit.getDefaultInstance();
        }

        @Override // com.google.api.Distribution.BucketOptionsOrBuilder
        public ExplicitOrBuilder getExplicitBucketsOrBuilder() {
            if (this.optionsCase_ == 3) {
                return (Explicit) this.options_;
            }
            return Explicit.getDefaultInstance();
        }

        @Override // com.google.api.Distribution.BucketOptionsOrBuilder
        public Exponential getExponentialBuckets() {
            if (this.optionsCase_ == 2) {
                return (Exponential) this.options_;
            }
            return Exponential.getDefaultInstance();
        }

        @Override // com.google.api.Distribution.BucketOptionsOrBuilder
        public ExponentialOrBuilder getExponentialBucketsOrBuilder() {
            if (this.optionsCase_ == 2) {
                return (Exponential) this.options_;
            }
            return Exponential.getDefaultInstance();
        }

        @Override // com.google.api.Distribution.BucketOptionsOrBuilder
        public Linear getLinearBuckets() {
            if (this.optionsCase_ == 1) {
                return (Linear) this.options_;
            }
            return Linear.getDefaultInstance();
        }

        @Override // com.google.api.Distribution.BucketOptionsOrBuilder
        public LinearOrBuilder getLinearBucketsOrBuilder() {
            if (this.optionsCase_ == 1) {
                return (Linear) this.options_;
            }
            return Linear.getDefaultInstance();
        }

        @Override // com.google.api.Distribution.BucketOptionsOrBuilder
        public OptionsCase getOptionsCase() {
            return OptionsCase.forNumber(this.optionsCase_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BucketOptions> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeMessageSize = this.optionsCase_ == 1 ? 0 + CodedOutputStream.computeMessageSize(1, (Linear) this.options_) : 0;
            if (this.optionsCase_ == 2) {
                computeMessageSize += CodedOutputStream.computeMessageSize(2, (Exponential) this.options_);
            }
            if (this.optionsCase_ == 3) {
                computeMessageSize += CodedOutputStream.computeMessageSize(3, (Explicit) this.options_);
            }
            int serializedSize = computeMessageSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.api.Distribution.BucketOptionsOrBuilder
        public boolean hasExplicitBuckets() {
            return this.optionsCase_ == 3;
        }

        @Override // com.google.api.Distribution.BucketOptionsOrBuilder
        public boolean hasExponentialBuckets() {
            return this.optionsCase_ == 2;
        }

        @Override // com.google.api.Distribution.BucketOptionsOrBuilder
        public boolean hasLinearBuckets() {
            return this.optionsCase_ == 1;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10;
            int hashCode;
            int i11 = this.memoizedHashCode;
            if (i11 != 0) {
                return i11;
            }
            int hashCode2 = MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode();
            int i12 = this.optionsCase_;
            if (i12 == 1) {
                i10 = ((hashCode2 * 37) + 1) * 53;
                hashCode = getLinearBuckets().hashCode();
            } else if (i12 == 2) {
                i10 = ((hashCode2 * 37) + 2) * 53;
                hashCode = getExponentialBuckets().hashCode();
            } else {
                if (i12 == 3) {
                    i10 = ((hashCode2 * 37) + 3) * 53;
                    hashCode = getExplicitBuckets().hashCode();
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
            return j.f53910f.ensureFieldAccessorsInitialized(BucketOptions.class, Builder.class);
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
            return new BucketOptions();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.optionsCase_ == 1) {
                codedOutputStream.writeMessage(1, (Linear) this.options_);
            }
            if (this.optionsCase_ == 2) {
                codedOutputStream.writeMessage(2, (Exponential) this.options_);
            }
            if (this.optionsCase_ == 3) {
                codedOutputStream.writeMessage(3, (Explicit) this.options_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public /* synthetic */ BucketOptions(GeneratedMessageV3.Builder builder, a aVar) {
            this(builder);
        }

        public static Builder newBuilder(BucketOptions bucketOptions) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(bucketOptions);
        }

        public static BucketOptions parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BucketOptions) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static BucketOptions parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private BucketOptions(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.optionsCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static BucketOptions parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BucketOptions getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            a aVar = null;
            return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
        }

        public static BucketOptions parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static BucketOptions parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        private BucketOptions() {
            this.optionsCase_ = 0;
            this.memoizedIsInitialized = (byte) -1;
        }

        public static BucketOptions parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static BucketOptions parseFrom(InputStream inputStream) throws IOException {
            return (BucketOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static BucketOptions parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BucketOptions) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        private BucketOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                    Linear.Builder builder = this.optionsCase_ == 1 ? ((Linear) this.options_).toBuilder() : null;
                                    MessageLite readMessage = codedInputStream.readMessage(Linear.parser(), extensionRegistryLite);
                                    this.options_ = readMessage;
                                    if (builder != null) {
                                        builder.mergeFrom((Linear) readMessage);
                                        this.options_ = builder.buildPartial();
                                    }
                                    this.optionsCase_ = 1;
                                } else if (readTag == 18) {
                                    Exponential.Builder builder2 = this.optionsCase_ == 2 ? ((Exponential) this.options_).toBuilder() : null;
                                    MessageLite readMessage2 = codedInputStream.readMessage(Exponential.parser(), extensionRegistryLite);
                                    this.options_ = readMessage2;
                                    if (builder2 != null) {
                                        builder2.mergeFrom((Exponential) readMessage2);
                                        this.options_ = builder2.buildPartial();
                                    }
                                    this.optionsCase_ = 2;
                                } else if (readTag != 26) {
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    Explicit.Builder builder3 = this.optionsCase_ == 3 ? ((Explicit) this.options_).toBuilder() : null;
                                    MessageLite readMessage3 = codedInputStream.readMessage(Explicit.parser(), extensionRegistryLite);
                                    this.options_ = readMessage3;
                                    if (builder3 != null) {
                                        builder3.mergeFrom((Explicit) readMessage3);
                                        this.options_ = builder3.buildPartial();
                                    }
                                    this.optionsCase_ = 3;
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

        public static BucketOptions parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (BucketOptions) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static BucketOptions parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (BucketOptions) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface BucketOptionsOrBuilder extends MessageOrBuilder {
        BucketOptions.Explicit getExplicitBuckets();

        BucketOptions.ExplicitOrBuilder getExplicitBucketsOrBuilder();

        BucketOptions.Exponential getExponentialBuckets();

        BucketOptions.ExponentialOrBuilder getExponentialBucketsOrBuilder();

        BucketOptions.Linear getLinearBuckets();

        BucketOptions.LinearOrBuilder getLinearBucketsOrBuilder();

        BucketOptions.OptionsCase getOptionsCase();

        boolean hasExplicitBuckets();

        boolean hasExponentialBuckets();

        boolean hasLinearBuckets();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DistributionOrBuilder {
        private int bitField0_;
        private Internal.LongList bucketCounts_;
        private SingleFieldBuilderV3<BucketOptions, BucketOptions.Builder, BucketOptionsOrBuilder> bucketOptionsBuilder_;
        private BucketOptions bucketOptions_;
        private long count_;
        private RepeatedFieldBuilderV3<Exemplar, Exemplar.Builder, ExemplarOrBuilder> exemplarsBuilder_;
        private List<Exemplar> exemplars_;
        private double mean_;
        private SingleFieldBuilderV3<Range, Range.Builder, RangeOrBuilder> rangeBuilder_;
        private Range range_;
        private double sumOfSquaredDeviation_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        private void ensureBucketCountsIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.bucketCounts_ = GeneratedMessageV3.mutableCopy(this.bucketCounts_);
                this.bitField0_ |= 1;
            }
        }

        private void ensureExemplarsIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.exemplars_ = new ArrayList(this.exemplars_);
                this.bitField0_ |= 2;
            }
        }

        private SingleFieldBuilderV3<BucketOptions, BucketOptions.Builder, BucketOptionsOrBuilder> getBucketOptionsFieldBuilder() {
            if (this.bucketOptionsBuilder_ == null) {
                this.bucketOptionsBuilder_ = new SingleFieldBuilderV3<>(getBucketOptions(), getParentForChildren(), isClean());
                this.bucketOptions_ = null;
            }
            return this.bucketOptionsBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return j.f53905a;
        }

        private RepeatedFieldBuilderV3<Exemplar, Exemplar.Builder, ExemplarOrBuilder> getExemplarsFieldBuilder() {
            if (this.exemplarsBuilder_ == null) {
                this.exemplarsBuilder_ = new RepeatedFieldBuilderV3<>(this.exemplars_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                this.exemplars_ = null;
            }
            return this.exemplarsBuilder_;
        }

        private SingleFieldBuilderV3<Range, Range.Builder, RangeOrBuilder> getRangeFieldBuilder() {
            if (this.rangeBuilder_ == null) {
                this.rangeBuilder_ = new SingleFieldBuilderV3<>(getRange(), getParentForChildren(), isClean());
                this.range_ = null;
            }
            return this.rangeBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                getExemplarsFieldBuilder();
            }
        }

        public Builder addAllBucketCounts(Iterable<? extends Long> iterable) {
            ensureBucketCountsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.bucketCounts_);
            onChanged();
            return this;
        }

        public Builder addAllExemplars(Iterable<? extends Exemplar> iterable) {
            RepeatedFieldBuilderV3<Exemplar, Exemplar.Builder, ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureExemplarsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.exemplars_);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addAllMessages(iterable);
            }
            return this;
        }

        public Builder addBucketCounts(long j10) {
            ensureBucketCountsIsMutable();
            this.bucketCounts_.addLong(j10);
            onChanged();
            return this;
        }

        public Builder addExemplars(Exemplar exemplar) {
            RepeatedFieldBuilderV3<Exemplar, Exemplar.Builder, ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(exemplar);
                ensureExemplarsIsMutable();
                this.exemplars_.add(exemplar);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(exemplar);
            }
            return this;
        }

        public Exemplar.Builder addExemplarsBuilder() {
            return getExemplarsFieldBuilder().addBuilder(Exemplar.getDefaultInstance());
        }

        public Builder clearBucketCounts() {
            this.bucketCounts_ = Distribution.access$7800();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearBucketOptions() {
            if (this.bucketOptionsBuilder_ == null) {
                this.bucketOptions_ = null;
                onChanged();
            } else {
                this.bucketOptions_ = null;
                this.bucketOptionsBuilder_ = null;
            }
            return this;
        }

        public Builder clearCount() {
            this.count_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearExemplars() {
            RepeatedFieldBuilderV3<Exemplar, Exemplar.Builder, ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.exemplars_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearMean() {
            this.mean_ = ShadowDrawableWrapper.COS_45;
            onChanged();
            return this;
        }

        public Builder clearRange() {
            if (this.rangeBuilder_ == null) {
                this.range_ = null;
                onChanged();
            } else {
                this.range_ = null;
                this.rangeBuilder_ = null;
            }
            return this;
        }

        public Builder clearSumOfSquaredDeviation() {
            this.sumOfSquaredDeviation_ = ShadowDrawableWrapper.COS_45;
            onChanged();
            return this;
        }

        @Override // com.google.api.DistributionOrBuilder
        public long getBucketCounts(int i10) {
            return this.bucketCounts_.getLong(i10);
        }

        @Override // com.google.api.DistributionOrBuilder
        public int getBucketCountsCount() {
            return this.bucketCounts_.size();
        }

        @Override // com.google.api.DistributionOrBuilder
        public List<Long> getBucketCountsList() {
            return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.bucketCounts_) : this.bucketCounts_;
        }

        @Override // com.google.api.DistributionOrBuilder
        public BucketOptions getBucketOptions() {
            SingleFieldBuilderV3<BucketOptions, BucketOptions.Builder, BucketOptionsOrBuilder> singleFieldBuilderV3 = this.bucketOptionsBuilder_;
            if (singleFieldBuilderV3 == null) {
                BucketOptions bucketOptions = this.bucketOptions_;
                return bucketOptions == null ? BucketOptions.getDefaultInstance() : bucketOptions;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public BucketOptions.Builder getBucketOptionsBuilder() {
            onChanged();
            return getBucketOptionsFieldBuilder().getBuilder();
        }

        @Override // com.google.api.DistributionOrBuilder
        public BucketOptionsOrBuilder getBucketOptionsOrBuilder() {
            SingleFieldBuilderV3<BucketOptions, BucketOptions.Builder, BucketOptionsOrBuilder> singleFieldBuilderV3 = this.bucketOptionsBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            BucketOptions bucketOptions = this.bucketOptions_;
            return bucketOptions == null ? BucketOptions.getDefaultInstance() : bucketOptions;
        }

        @Override // com.google.api.DistributionOrBuilder
        public long getCount() {
            return this.count_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return j.f53905a;
        }

        @Override // com.google.api.DistributionOrBuilder
        public Exemplar getExemplars(int i10) {
            RepeatedFieldBuilderV3<Exemplar, Exemplar.Builder, ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.exemplars_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessage(i10);
        }

        public Exemplar.Builder getExemplarsBuilder(int i10) {
            return getExemplarsFieldBuilder().getBuilder(i10);
        }

        public List<Exemplar.Builder> getExemplarsBuilderList() {
            return getExemplarsFieldBuilder().getBuilderList();
        }

        @Override // com.google.api.DistributionOrBuilder
        public int getExemplarsCount() {
            RepeatedFieldBuilderV3<Exemplar, Exemplar.Builder, ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.exemplars_.size();
            }
            return repeatedFieldBuilderV3.getCount();
        }

        @Override // com.google.api.DistributionOrBuilder
        public List<Exemplar> getExemplarsList() {
            RepeatedFieldBuilderV3<Exemplar, Exemplar.Builder, ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return Collections.unmodifiableList(this.exemplars_);
            }
            return repeatedFieldBuilderV3.getMessageList();
        }

        @Override // com.google.api.DistributionOrBuilder
        public ExemplarOrBuilder getExemplarsOrBuilder(int i10) {
            RepeatedFieldBuilderV3<Exemplar, Exemplar.Builder, ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                return this.exemplars_.get(i10);
            }
            return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
        }

        @Override // com.google.api.DistributionOrBuilder
        public List<? extends ExemplarOrBuilder> getExemplarsOrBuilderList() {
            RepeatedFieldBuilderV3<Exemplar, Exemplar.Builder, ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
            if (repeatedFieldBuilderV3 != null) {
                return repeatedFieldBuilderV3.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.exemplars_);
        }

        @Override // com.google.api.DistributionOrBuilder
        public double getMean() {
            return this.mean_;
        }

        @Override // com.google.api.DistributionOrBuilder
        public Range getRange() {
            SingleFieldBuilderV3<Range, Range.Builder, RangeOrBuilder> singleFieldBuilderV3 = this.rangeBuilder_;
            if (singleFieldBuilderV3 == null) {
                Range range = this.range_;
                return range == null ? Range.getDefaultInstance() : range;
            }
            return singleFieldBuilderV3.getMessage();
        }

        public Range.Builder getRangeBuilder() {
            onChanged();
            return getRangeFieldBuilder().getBuilder();
        }

        @Override // com.google.api.DistributionOrBuilder
        public RangeOrBuilder getRangeOrBuilder() {
            SingleFieldBuilderV3<Range, Range.Builder, RangeOrBuilder> singleFieldBuilderV3 = this.rangeBuilder_;
            if (singleFieldBuilderV3 != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            Range range = this.range_;
            return range == null ? Range.getDefaultInstance() : range;
        }

        @Override // com.google.api.DistributionOrBuilder
        public double getSumOfSquaredDeviation() {
            return this.sumOfSquaredDeviation_;
        }

        @Override // com.google.api.DistributionOrBuilder
        public boolean hasBucketOptions() {
            return (this.bucketOptionsBuilder_ == null && this.bucketOptions_ == null) ? false : true;
        }

        @Override // com.google.api.DistributionOrBuilder
        public boolean hasRange() {
            return (this.rangeBuilder_ == null && this.range_ == null) ? false : true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return j.f53906b.ensureFieldAccessorsInitialized(Distribution.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeBucketOptions(BucketOptions bucketOptions) {
            SingleFieldBuilderV3<BucketOptions, BucketOptions.Builder, BucketOptionsOrBuilder> singleFieldBuilderV3 = this.bucketOptionsBuilder_;
            if (singleFieldBuilderV3 == null) {
                BucketOptions bucketOptions2 = this.bucketOptions_;
                if (bucketOptions2 != null) {
                    this.bucketOptions_ = BucketOptions.newBuilder(bucketOptions2).mergeFrom(bucketOptions).buildPartial();
                } else {
                    this.bucketOptions_ = bucketOptions;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(bucketOptions);
            }
            return this;
        }

        public Builder mergeRange(Range range) {
            SingleFieldBuilderV3<Range, Range.Builder, RangeOrBuilder> singleFieldBuilderV3 = this.rangeBuilder_;
            if (singleFieldBuilderV3 == null) {
                Range range2 = this.range_;
                if (range2 != null) {
                    this.range_ = Range.newBuilder(range2).mergeFrom(range).buildPartial();
                } else {
                    this.range_ = range;
                }
                onChanged();
            } else {
                singleFieldBuilderV3.mergeFrom(range);
            }
            return this;
        }

        public Builder removeExemplars(int i10) {
            RepeatedFieldBuilderV3<Exemplar, Exemplar.Builder, ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureExemplarsIsMutable();
                this.exemplars_.remove(i10);
                onChanged();
            } else {
                repeatedFieldBuilderV3.remove(i10);
            }
            return this;
        }

        public Builder setBucketCounts(int i10, long j10) {
            ensureBucketCountsIsMutable();
            this.bucketCounts_.setLong(i10, j10);
            onChanged();
            return this;
        }

        public Builder setBucketOptions(BucketOptions bucketOptions) {
            SingleFieldBuilderV3<BucketOptions, BucketOptions.Builder, BucketOptionsOrBuilder> singleFieldBuilderV3 = this.bucketOptionsBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(bucketOptions);
                this.bucketOptions_ = bucketOptions;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(bucketOptions);
            }
            return this;
        }

        public Builder setCount(long j10) {
            this.count_ = j10;
            onChanged();
            return this;
        }

        public Builder setExemplars(int i10, Exemplar exemplar) {
            RepeatedFieldBuilderV3<Exemplar, Exemplar.Builder, ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(exemplar);
                ensureExemplarsIsMutable();
                this.exemplars_.set(i10, exemplar);
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, exemplar);
            }
            return this;
        }

        public Builder setMean(double d10) {
            this.mean_ = d10;
            onChanged();
            return this;
        }

        public Builder setRange(Range range) {
            SingleFieldBuilderV3<Range, Range.Builder, RangeOrBuilder> singleFieldBuilderV3 = this.rangeBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(range);
                this.range_ = range;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(range);
            }
            return this;
        }

        public Builder setSumOfSquaredDeviation(double d10) {
            this.sumOfSquaredDeviation_ = d10;
            onChanged();
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        private Builder() {
            this.bucketCounts_ = Distribution.access$7600();
            this.exemplars_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Exemplar.Builder addExemplarsBuilder(int i10) {
            return getExemplarsFieldBuilder().addBuilder(i10, Exemplar.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Distribution build() {
            Distribution buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Distribution buildPartial() {
            Distribution distribution = new Distribution(this, (a) null);
            distribution.count_ = this.count_;
            distribution.mean_ = this.mean_;
            distribution.sumOfSquaredDeviation_ = this.sumOfSquaredDeviation_;
            SingleFieldBuilderV3<Range, Range.Builder, RangeOrBuilder> singleFieldBuilderV3 = this.rangeBuilder_;
            if (singleFieldBuilderV3 == null) {
                distribution.range_ = this.range_;
            } else {
                distribution.range_ = singleFieldBuilderV3.build();
            }
            SingleFieldBuilderV3<BucketOptions, BucketOptions.Builder, BucketOptionsOrBuilder> singleFieldBuilderV32 = this.bucketOptionsBuilder_;
            if (singleFieldBuilderV32 == null) {
                distribution.bucketOptions_ = this.bucketOptions_;
            } else {
                distribution.bucketOptions_ = singleFieldBuilderV32.build();
            }
            if ((this.bitField0_ & 1) != 0) {
                this.bucketCounts_.makeImmutable();
                this.bitField0_ &= -2;
            }
            distribution.bucketCounts_ = this.bucketCounts_;
            RepeatedFieldBuilderV3<Exemplar, Exemplar.Builder, ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                if ((this.bitField0_ & 2) != 0) {
                    this.exemplars_ = Collections.unmodifiableList(this.exemplars_);
                    this.bitField0_ &= -3;
                }
                distribution.exemplars_ = this.exemplars_;
            } else {
                distribution.exemplars_ = repeatedFieldBuilderV3.build();
            }
            onBuilt();
            return distribution;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Distribution getDefaultInstanceForType() {
            return Distribution.getDefaultInstance();
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
            this.count_ = 0L;
            this.mean_ = ShadowDrawableWrapper.COS_45;
            this.sumOfSquaredDeviation_ = ShadowDrawableWrapper.COS_45;
            if (this.rangeBuilder_ == null) {
                this.range_ = null;
            } else {
                this.range_ = null;
                this.rangeBuilder_ = null;
            }
            if (this.bucketOptionsBuilder_ == null) {
                this.bucketOptions_ = null;
            } else {
                this.bucketOptions_ = null;
                this.bucketOptionsBuilder_ = null;
            }
            this.bucketCounts_ = Distribution.access$6400();
            this.bitField0_ &= -2;
            RepeatedFieldBuilderV3<Exemplar, Exemplar.Builder, ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                this.exemplars_ = Collections.emptyList();
                this.bitField0_ &= -3;
            } else {
                repeatedFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder setBucketOptions(BucketOptions.Builder builder) {
            SingleFieldBuilderV3<BucketOptions, BucketOptions.Builder, BucketOptionsOrBuilder> singleFieldBuilderV3 = this.bucketOptionsBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.bucketOptions_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        public Builder setRange(Range.Builder builder) {
            SingleFieldBuilderV3<Range, Range.Builder, RangeOrBuilder> singleFieldBuilderV3 = this.rangeBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.range_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.bucketCounts_ = Distribution.access$7600();
            this.exemplars_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        public Builder addExemplars(int i10, Exemplar exemplar) {
            RepeatedFieldBuilderV3<Exemplar, Exemplar.Builder, ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                Objects.requireNonNull(exemplar);
                ensureExemplarsIsMutable();
                this.exemplars_.add(i10, exemplar);
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(i10, exemplar);
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
            if (message instanceof Distribution) {
                return mergeFrom((Distribution) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setExemplars(int i10, Exemplar.Builder builder) {
            RepeatedFieldBuilderV3<Exemplar, Exemplar.Builder, ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureExemplarsIsMutable();
                this.exemplars_.set(i10, builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.setMessage(i10, builder.build());
            }
            return this;
        }

        public Builder mergeFrom(Distribution distribution) {
            if (distribution == Distribution.getDefaultInstance()) {
                return this;
            }
            if (distribution.getCount() != 0) {
                setCount(distribution.getCount());
            }
            if (distribution.getMean() != ShadowDrawableWrapper.COS_45) {
                setMean(distribution.getMean());
            }
            if (distribution.getSumOfSquaredDeviation() != ShadowDrawableWrapper.COS_45) {
                setSumOfSquaredDeviation(distribution.getSumOfSquaredDeviation());
            }
            if (distribution.hasRange()) {
                mergeRange(distribution.getRange());
            }
            if (distribution.hasBucketOptions()) {
                mergeBucketOptions(distribution.getBucketOptions());
            }
            if (!distribution.bucketCounts_.isEmpty()) {
                if (this.bucketCounts_.isEmpty()) {
                    this.bucketCounts_ = distribution.bucketCounts_;
                    this.bitField0_ &= -2;
                } else {
                    ensureBucketCountsIsMutable();
                    this.bucketCounts_.addAll(distribution.bucketCounts_);
                }
                onChanged();
            }
            if (this.exemplarsBuilder_ == null) {
                if (!distribution.exemplars_.isEmpty()) {
                    if (this.exemplars_.isEmpty()) {
                        this.exemplars_ = distribution.exemplars_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureExemplarsIsMutable();
                        this.exemplars_.addAll(distribution.exemplars_);
                    }
                    onChanged();
                }
            } else if (!distribution.exemplars_.isEmpty()) {
                if (this.exemplarsBuilder_.isEmpty()) {
                    this.exemplarsBuilder_.dispose();
                    this.exemplarsBuilder_ = null;
                    this.exemplars_ = distribution.exemplars_;
                    this.bitField0_ &= -3;
                    this.exemplarsBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getExemplarsFieldBuilder() : null;
                } else {
                    this.exemplarsBuilder_.addAllMessages(distribution.exemplars_);
                }
            }
            mergeUnknownFields(distribution.unknownFields);
            onChanged();
            return this;
        }

        public Builder addExemplars(Exemplar.Builder builder) {
            RepeatedFieldBuilderV3<Exemplar, Exemplar.Builder, ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureExemplarsIsMutable();
                this.exemplars_.add(builder.build());
                onChanged();
            } else {
                repeatedFieldBuilderV3.addMessage(builder.build());
            }
            return this;
        }

        public Builder addExemplars(int i10, Exemplar.Builder builder) {
            RepeatedFieldBuilderV3<Exemplar, Exemplar.Builder, ExemplarOrBuilder> repeatedFieldBuilderV3 = this.exemplarsBuilder_;
            if (repeatedFieldBuilderV3 == null) {
                ensureExemplarsIsMutable();
                this.exemplars_.add(i10, builder.build());
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
        public com.google.api.Distribution.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.api.Distribution.access$7500()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.api.Distribution r3 = (com.google.api.Distribution) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.api.Distribution r4 = (com.google.api.Distribution) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.Distribution.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.Distribution$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Exemplar extends GeneratedMessageV3 implements ExemplarOrBuilder {
        public static final int ATTACHMENTS_FIELD_NUMBER = 3;
        private static final Exemplar DEFAULT_INSTANCE = new Exemplar();
        private static final Parser<Exemplar> PARSER = new a();
        public static final int TIMESTAMP_FIELD_NUMBER = 2;
        public static final int VALUE_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private List<Any> attachments_;
        private byte memoizedIsInitialized;
        private Timestamp timestamp_;
        private double value_;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ExemplarOrBuilder {
            private RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> attachmentsBuilder_;
            private List<Any> attachments_;
            private int bitField0_;
            private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> timestampBuilder_;
            private Timestamp timestamp_;
            private double value_;

            public /* synthetic */ Builder(a aVar) {
                this();
            }

            private void ensureAttachmentsIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.attachments_ = new ArrayList(this.attachments_);
                    this.bitField0_ |= 1;
                }
            }

            private RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> getAttachmentsFieldBuilder() {
                if (this.attachmentsBuilder_ == null) {
                    this.attachmentsBuilder_ = new RepeatedFieldBuilderV3<>(this.attachments_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.attachments_ = null;
                }
                return this.attachmentsBuilder_;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return j.f53917m;
            }

            private SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> getTimestampFieldBuilder() {
                if (this.timestampBuilder_ == null) {
                    this.timestampBuilder_ = new SingleFieldBuilderV3<>(getTimestamp(), getParentForChildren(), isClean());
                    this.timestamp_ = null;
                }
                return this.timestampBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessageV3.alwaysUseFieldBuilders) {
                    getAttachmentsFieldBuilder();
                }
            }

            public Builder addAllAttachments(Iterable<? extends Any> iterable) {
                RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAttachmentsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.attachments_);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addAllMessages(iterable);
                }
                return this;
            }

            public Builder addAttachments(Any any) {
                RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    Objects.requireNonNull(any);
                    ensureAttachmentsIsMutable();
                    this.attachments_.add(any);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(any);
                }
                return this;
            }

            public Any.Builder addAttachmentsBuilder() {
                return getAttachmentsFieldBuilder().addBuilder(Any.getDefaultInstance());
            }

            public Builder clearAttachments() {
                RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.attachments_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            public Builder clearTimestamp() {
                if (this.timestampBuilder_ == null) {
                    this.timestamp_ = null;
                    onChanged();
                } else {
                    this.timestamp_ = null;
                    this.timestampBuilder_ = null;
                }
                return this;
            }

            public Builder clearValue() {
                this.value_ = ShadowDrawableWrapper.COS_45;
                onChanged();
                return this;
            }

            @Override // com.google.api.Distribution.ExemplarOrBuilder
            public Any getAttachments(int i10) {
                RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.attachments_.get(i10);
                }
                return repeatedFieldBuilderV3.getMessage(i10);
            }

            public Any.Builder getAttachmentsBuilder(int i10) {
                return getAttachmentsFieldBuilder().getBuilder(i10);
            }

            public List<Any.Builder> getAttachmentsBuilderList() {
                return getAttachmentsFieldBuilder().getBuilderList();
            }

            @Override // com.google.api.Distribution.ExemplarOrBuilder
            public int getAttachmentsCount() {
                RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.attachments_.size();
                }
                return repeatedFieldBuilderV3.getCount();
            }

            @Override // com.google.api.Distribution.ExemplarOrBuilder
            public List<Any> getAttachmentsList() {
                RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return Collections.unmodifiableList(this.attachments_);
                }
                return repeatedFieldBuilderV3.getMessageList();
            }

            @Override // com.google.api.Distribution.ExemplarOrBuilder
            public AnyOrBuilder getAttachmentsOrBuilder(int i10) {
                RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    return this.attachments_.get(i10);
                }
                return repeatedFieldBuilderV3.getMessageOrBuilder(i10);
            }

            @Override // com.google.api.Distribution.ExemplarOrBuilder
            public List<? extends AnyOrBuilder> getAttachmentsOrBuilderList() {
                RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
                if (repeatedFieldBuilderV3 != null) {
                    return repeatedFieldBuilderV3.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.attachments_);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return j.f53917m;
            }

            @Override // com.google.api.Distribution.ExemplarOrBuilder
            public Timestamp getTimestamp() {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Timestamp timestamp = this.timestamp_;
                    return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
                }
                return singleFieldBuilderV3.getMessage();
            }

            public Timestamp.Builder getTimestampBuilder() {
                onChanged();
                return getTimestampFieldBuilder().getBuilder();
            }

            @Override // com.google.api.Distribution.ExemplarOrBuilder
            public TimestampOrBuilder getTimestampOrBuilder() {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 != null) {
                    return singleFieldBuilderV3.getMessageOrBuilder();
                }
                Timestamp timestamp = this.timestamp_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }

            @Override // com.google.api.Distribution.ExemplarOrBuilder
            public double getValue() {
                return this.value_;
            }

            @Override // com.google.api.Distribution.ExemplarOrBuilder
            public boolean hasTimestamp() {
                return (this.timestampBuilder_ == null && this.timestamp_ == null) ? false : true;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return j.f53918n.ensureFieldAccessorsInitialized(Exemplar.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder mergeTimestamp(Timestamp timestamp) {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Timestamp timestamp2 = this.timestamp_;
                    if (timestamp2 != null) {
                        this.timestamp_ = Timestamp.newBuilder(timestamp2).mergeFrom(timestamp).buildPartial();
                    } else {
                        this.timestamp_ = timestamp;
                    }
                    onChanged();
                } else {
                    singleFieldBuilderV3.mergeFrom(timestamp);
                }
                return this;
            }

            public Builder removeAttachments(int i10) {
                RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAttachmentsIsMutable();
                    this.attachments_.remove(i10);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.remove(i10);
                }
                return this;
            }

            public Builder setAttachments(int i10, Any any) {
                RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    Objects.requireNonNull(any);
                    ensureAttachmentsIsMutable();
                    this.attachments_.set(i10, any);
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i10, any);
                }
                return this;
            }

            public Builder setTimestamp(Timestamp timestamp) {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    Objects.requireNonNull(timestamp);
                    this.timestamp_ = timestamp;
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(timestamp);
                }
                return this;
            }

            public Builder setValue(double d10) {
                this.value_ = d10;
                onChanged();
                return this;
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
                this(builderParent);
            }

            private Builder() {
                this.attachments_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Any.Builder addAttachmentsBuilder(int i10) {
                return getAttachmentsFieldBuilder().addBuilder(i10, Any.getDefaultInstance());
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.addRepeatedField(fieldDescriptor, obj);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Exemplar build() {
                Exemplar buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Exemplar buildPartial() {
                Exemplar exemplar = new Exemplar(this, (a) null);
                exemplar.value_ = this.value_;
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    exemplar.timestamp_ = this.timestamp_;
                } else {
                    exemplar.timestamp_ = singleFieldBuilderV3.build();
                }
                RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.attachments_ = Collections.unmodifiableList(this.attachments_);
                        this.bitField0_ &= -2;
                    }
                    exemplar.attachments_ = this.attachments_;
                } else {
                    exemplar.attachments_ = repeatedFieldBuilderV3.build();
                }
                onBuilt();
                return exemplar;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Exemplar getDefaultInstanceForType() {
                return Exemplar.getDefaultInstance();
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
                this.value_ = ShadowDrawableWrapper.COS_45;
                if (this.timestampBuilder_ == null) {
                    this.timestamp_ = null;
                } else {
                    this.timestamp_ = null;
                    this.timestampBuilder_ = null;
                }
                RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    this.attachments_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    repeatedFieldBuilderV3.clear();
                }
                return this;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.attachments_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder setTimestamp(Timestamp.Builder builder) {
                SingleFieldBuilderV3<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilderV3 = this.timestampBuilder_;
                if (singleFieldBuilderV3 == null) {
                    this.timestamp_ = builder.build();
                    onChanged();
                } else {
                    singleFieldBuilderV3.setMessage(builder.build());
                }
                return this;
            }

            public Builder addAttachments(int i10, Any any) {
                RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    Objects.requireNonNull(any);
                    ensureAttachmentsIsMutable();
                    this.attachments_.add(i10, any);
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
                if (message instanceof Exemplar) {
                    return mergeFrom((Exemplar) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder setAttachments(int i10, Any.Builder builder) {
                RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAttachmentsIsMutable();
                    this.attachments_.set(i10, builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.setMessage(i10, builder.build());
                }
                return this;
            }

            public Builder mergeFrom(Exemplar exemplar) {
                if (exemplar == Exemplar.getDefaultInstance()) {
                    return this;
                }
                if (exemplar.getValue() != ShadowDrawableWrapper.COS_45) {
                    setValue(exemplar.getValue());
                }
                if (exemplar.hasTimestamp()) {
                    mergeTimestamp(exemplar.getTimestamp());
                }
                if (this.attachmentsBuilder_ == null) {
                    if (!exemplar.attachments_.isEmpty()) {
                        if (this.attachments_.isEmpty()) {
                            this.attachments_ = exemplar.attachments_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureAttachmentsIsMutable();
                            this.attachments_.addAll(exemplar.attachments_);
                        }
                        onChanged();
                    }
                } else if (!exemplar.attachments_.isEmpty()) {
                    if (this.attachmentsBuilder_.isEmpty()) {
                        this.attachmentsBuilder_.dispose();
                        this.attachmentsBuilder_ = null;
                        this.attachments_ = exemplar.attachments_;
                        this.bitField0_ &= -2;
                        this.attachmentsBuilder_ = GeneratedMessageV3.alwaysUseFieldBuilders ? getAttachmentsFieldBuilder() : null;
                    } else {
                        this.attachmentsBuilder_.addAllMessages(exemplar.attachments_);
                    }
                }
                mergeUnknownFields(exemplar.unknownFields);
                onChanged();
                return this;
            }

            public Builder addAttachments(Any.Builder builder) {
                RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAttachmentsIsMutable();
                    this.attachments_.add(builder.build());
                    onChanged();
                } else {
                    repeatedFieldBuilderV3.addMessage(builder.build());
                }
                return this;
            }

            public Builder addAttachments(int i10, Any.Builder builder) {
                RepeatedFieldBuilderV3<Any, Any.Builder, AnyOrBuilder> repeatedFieldBuilderV3 = this.attachmentsBuilder_;
                if (repeatedFieldBuilderV3 == null) {
                    ensureAttachmentsIsMutable();
                    this.attachments_.add(i10, builder.build());
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
            public com.google.api.Distribution.Exemplar.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.google.api.Distribution.Exemplar.access$5900()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.google.api.Distribution$Exemplar r3 = (com.google.api.Distribution.Exemplar) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.google.api.Distribution$Exemplar r4 = (com.google.api.Distribution.Exemplar) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.google.api.Distribution.Exemplar.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.Distribution$Exemplar$Builder");
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class a extends AbstractParser<Exemplar> {
            @Override // com.google.protobuf.Parser
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Exemplar parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Exemplar(codedInputStream, extensionRegistryLite, null);
            }
        }

        public /* synthetic */ Exemplar(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static Exemplar getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return j.f53917m;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Exemplar parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Exemplar) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Exemplar parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<Exemplar> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Exemplar)) {
                return super.equals(obj);
            }
            Exemplar exemplar = (Exemplar) obj;
            if (Double.doubleToLongBits(getValue()) == Double.doubleToLongBits(exemplar.getValue()) && hasTimestamp() == exemplar.hasTimestamp()) {
                return (!hasTimestamp() || getTimestamp().equals(exemplar.getTimestamp())) && getAttachmentsList().equals(exemplar.getAttachmentsList()) && this.unknownFields.equals(exemplar.unknownFields);
            }
            return false;
        }

        @Override // com.google.api.Distribution.ExemplarOrBuilder
        public Any getAttachments(int i10) {
            return this.attachments_.get(i10);
        }

        @Override // com.google.api.Distribution.ExemplarOrBuilder
        public int getAttachmentsCount() {
            return this.attachments_.size();
        }

        @Override // com.google.api.Distribution.ExemplarOrBuilder
        public List<Any> getAttachmentsList() {
            return this.attachments_;
        }

        @Override // com.google.api.Distribution.ExemplarOrBuilder
        public AnyOrBuilder getAttachmentsOrBuilder(int i10) {
            return this.attachments_.get(i10);
        }

        @Override // com.google.api.Distribution.ExemplarOrBuilder
        public List<? extends AnyOrBuilder> getAttachmentsOrBuilderList() {
            return this.attachments_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Exemplar> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeDoubleSize = Double.doubleToRawLongBits(this.value_) != 0 ? CodedOutputStream.computeDoubleSize(1, this.value_) + 0 : 0;
            if (this.timestamp_ != null) {
                computeDoubleSize += CodedOutputStream.computeMessageSize(2, getTimestamp());
            }
            for (int i11 = 0; i11 < this.attachments_.size(); i11++) {
                computeDoubleSize += CodedOutputStream.computeMessageSize(3, this.attachments_.get(i11));
            }
            int serializedSize = computeDoubleSize + this.unknownFields.getSerializedSize();
            this.memoizedSize = serializedSize;
            return serializedSize;
        }

        @Override // com.google.api.Distribution.ExemplarOrBuilder
        public Timestamp getTimestamp() {
            Timestamp timestamp = this.timestamp_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        @Override // com.google.api.Distribution.ExemplarOrBuilder
        public TimestampOrBuilder getTimestampOrBuilder() {
            return getTimestamp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.api.Distribution.ExemplarOrBuilder
        public double getValue() {
            return this.value_;
        }

        @Override // com.google.api.Distribution.ExemplarOrBuilder
        public boolean hasTimestamp() {
            return this.timestamp_ != null;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int i10 = this.memoizedHashCode;
            if (i10 != 0) {
                return i10;
            }
            int hashCode = ((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(Double.doubleToLongBits(getValue()));
            if (hasTimestamp()) {
                hashCode = (((hashCode * 37) + 2) * 53) + getTimestamp().hashCode();
            }
            if (getAttachmentsCount() > 0) {
                hashCode = (((hashCode * 37) + 3) * 53) + getAttachmentsList().hashCode();
            }
            int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode2;
            return hashCode2;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return j.f53918n.ensureFieldAccessorsInitialized(Exemplar.class, Builder.class);
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
            return new Exemplar();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (Double.doubleToRawLongBits(this.value_) != 0) {
                codedOutputStream.writeDouble(1, this.value_);
            }
            if (this.timestamp_ != null) {
                codedOutputStream.writeMessage(2, getTimestamp());
            }
            for (int i10 = 0; i10 < this.attachments_.size(); i10++) {
                codedOutputStream.writeMessage(3, this.attachments_.get(i10));
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public /* synthetic */ Exemplar(GeneratedMessageV3.Builder builder, a aVar) {
            this(builder);
        }

        public static Builder newBuilder(Exemplar exemplar) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(exemplar);
        }

        public static Exemplar parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Exemplar) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Exemplar parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private Exemplar(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Exemplar parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Exemplar getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            a aVar = null;
            return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
        }

        public static Exemplar parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private Exemplar() {
            this.memoizedIsInitialized = (byte) -1;
            this.attachments_ = Collections.emptyList();
        }

        public static Exemplar parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static Exemplar parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static Exemplar parseFrom(InputStream inputStream) throws IOException {
            return (Exemplar) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Exemplar(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            Objects.requireNonNull(extensionRegistryLite);
            UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
            boolean z10 = false;
            boolean z11 = false;
            while (!z10) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 9) {
                                this.value_ = codedInputStream.readDouble();
                            } else if (readTag == 18) {
                                Timestamp timestamp = this.timestamp_;
                                Timestamp.Builder builder = timestamp != null ? timestamp.toBuilder() : null;
                                Timestamp timestamp2 = (Timestamp) codedInputStream.readMessage(Timestamp.parser(), extensionRegistryLite);
                                this.timestamp_ = timestamp2;
                                if (builder != null) {
                                    builder.mergeFrom(timestamp2);
                                    this.timestamp_ = builder.buildPartial();
                                }
                            } else if (readTag != 26) {
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                if (!(z11 & true)) {
                                    this.attachments_ = new ArrayList();
                                    z11 |= true;
                                }
                                this.attachments_.add(codedInputStream.readMessage(Any.parser(), extensionRegistryLite));
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
                    if (z11 & true) {
                        this.attachments_ = Collections.unmodifiableList(this.attachments_);
                    }
                    this.unknownFields = newBuilder.build();
                    makeExtensionsImmutable();
                }
            }
        }

        public static Exemplar parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Exemplar) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Exemplar parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Exemplar) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Exemplar parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Exemplar) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ExemplarOrBuilder extends MessageOrBuilder {
        Any getAttachments(int i10);

        int getAttachmentsCount();

        List<Any> getAttachmentsList();

        AnyOrBuilder getAttachmentsOrBuilder(int i10);

        List<? extends AnyOrBuilder> getAttachmentsOrBuilderList();

        Timestamp getTimestamp();

        TimestampOrBuilder getTimestampOrBuilder();

        double getValue();

        boolean hasTimestamp();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Range extends GeneratedMessageV3 implements RangeOrBuilder {
        public static final int MAX_FIELD_NUMBER = 2;
        public static final int MIN_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private double max_;
        private byte memoizedIsInitialized;
        private double min_;
        private static final Range DEFAULT_INSTANCE = new Range();
        private static final Parser<Range> PARSER = new a();

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RangeOrBuilder {
            private double max_;
            private double min_;

            public /* synthetic */ Builder(a aVar) {
                this();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return j.f53907c;
            }

            private void maybeForceBuilderInitialization() {
                boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
            }

            public Builder clearMax() {
                this.max_ = ShadowDrawableWrapper.COS_45;
                onChanged();
                return this;
            }

            public Builder clearMin() {
                this.min_ = ShadowDrawableWrapper.COS_45;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return j.f53907c;
            }

            @Override // com.google.api.Distribution.RangeOrBuilder
            public double getMax() {
                return this.max_;
            }

            @Override // com.google.api.Distribution.RangeOrBuilder
            public double getMin() {
                return this.min_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return j.f53908d.ensureFieldAccessorsInitialized(Range.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public Builder setMax(double d10) {
                this.max_ = d10;
                onChanged();
                return this;
            }

            public Builder setMin(double d10) {
                this.min_ = d10;
                onChanged();
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
            public Range build() {
                Range buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Range buildPartial() {
                Range range = new Range(this, (a) null);
                range.min_ = this.min_;
                range.max_ = this.max_;
                onBuilt();
                return range;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
                return (Builder) super.clearField(fieldDescriptor);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Range getDefaultInstanceForType() {
                return Range.getDefaultInstance();
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
                this.min_ = ShadowDrawableWrapper.COS_45;
                this.max_ = ShadowDrawableWrapper.COS_45;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo2458clone() {
                return (Builder) super.mo2458clone();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message message) {
                if (message instanceof Range) {
                    return mergeFrom((Range) message);
                }
                super.mergeFrom(message);
                return this;
            }

            public Builder mergeFrom(Range range) {
                if (range == Range.getDefaultInstance()) {
                    return this;
                }
                if (range.getMin() != ShadowDrawableWrapper.COS_45) {
                    setMin(range.getMin());
                }
                if (range.getMax() != ShadowDrawableWrapper.COS_45) {
                    setMax(range.getMax());
                }
                mergeUnknownFields(range.unknownFields);
                onChanged();
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.google.api.Distribution.Range.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.google.protobuf.Parser r1 = com.google.api.Distribution.Range.access$700()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                    com.google.api.Distribution$Range r3 = (com.google.api.Distribution.Range) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                    com.google.api.Distribution$Range r4 = (com.google.api.Distribution.Range) r4     // Catch: java.lang.Throwable -> L11
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
                throw new UnsupportedOperationException("Method not decompiled: com.google.api.Distribution.Range.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.Distribution$Range$Builder");
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class a extends AbstractParser<Range> {
            @Override // com.google.protobuf.Parser
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Range parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new Range(codedInputStream, extensionRegistryLite, null);
            }
        }

        public /* synthetic */ Range(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        public static Range getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return j.f53907c;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Range parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Range) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
        }

        public static Range parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer);
        }

        public static Parser<Range> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Range)) {
                return super.equals(obj);
            }
            Range range = (Range) obj;
            return Double.doubleToLongBits(getMin()) == Double.doubleToLongBits(range.getMin()) && Double.doubleToLongBits(getMax()) == Double.doubleToLongBits(range.getMax()) && this.unknownFields.equals(range.unknownFields);
        }

        @Override // com.google.api.Distribution.RangeOrBuilder
        public double getMax() {
            return this.max_;
        }

        @Override // com.google.api.Distribution.RangeOrBuilder
        public double getMin() {
            return this.min_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Range> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i10 = this.memoizedSize;
            if (i10 != -1) {
                return i10;
            }
            int computeDoubleSize = Double.doubleToRawLongBits(this.min_) != 0 ? 0 + CodedOutputStream.computeDoubleSize(1, this.min_) : 0;
            if (Double.doubleToRawLongBits(this.max_) != 0) {
                computeDoubleSize += CodedOutputStream.computeDoubleSize(2, this.max_);
            }
            int serializedSize = computeDoubleSize + this.unknownFields.getSerializedSize();
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
            int hashCode = ((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(Double.doubleToLongBits(getMin()))) * 37) + 2) * 53) + Internal.hashLong(Double.doubleToLongBits(getMax()))) * 29) + this.unknownFields.hashCode();
            this.memoizedHashCode = hashCode;
            return hashCode;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return j.f53908d.ensureFieldAccessorsInitialized(Range.class, Builder.class);
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
            return new Range();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (Double.doubleToRawLongBits(this.min_) != 0) {
                codedOutputStream.writeDouble(1, this.min_);
            }
            if (Double.doubleToRawLongBits(this.max_) != 0) {
                codedOutputStream.writeDouble(2, this.max_);
            }
            this.unknownFields.writeTo(codedOutputStream);
        }

        public /* synthetic */ Range(GeneratedMessageV3.Builder builder, a aVar) {
            this(builder);
        }

        public static Builder newBuilder(Range range) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(range);
        }

        public static Range parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Range) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Range parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
        }

        private Range(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Range parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Range getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            a aVar = null;
            return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
        }

        public static Range parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        private Range() {
            this.memoizedIsInitialized = (byte) -1;
        }

        public static Range parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, null);
        }

        public static Range parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        private Range(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                                if (readTag == 9) {
                                    this.min_ = codedInputStream.readDouble();
                                } else if (readTag != 17) {
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.max_ = codedInputStream.readDouble();
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

        public static Range parseFrom(InputStream inputStream) throws IOException {
            return (Range) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
        }

        public static Range parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Range) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
        }

        public static Range parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Range) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
        }

        public static Range parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Range) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface RangeOrBuilder extends MessageOrBuilder {
        double getMax();

        double getMin();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<Distribution> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Distribution parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new Distribution(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25926a;

        static {
            int[] iArr = new int[BucketOptions.OptionsCase.values().length];
            f25926a = iArr;
            try {
                iArr[BucketOptions.OptionsCase.LINEAR_BUCKETS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25926a[BucketOptions.OptionsCase.EXPONENTIAL_BUCKETS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25926a[BucketOptions.OptionsCase.EXPLICIT_BUCKETS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25926a[BucketOptions.OptionsCase.OPTIONS_NOT_SET.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public /* synthetic */ Distribution(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static /* synthetic */ Internal.LongList access$6400() {
        return GeneratedMessageV3.emptyLongList();
    }

    public static /* synthetic */ Internal.LongList access$7600() {
        return GeneratedMessageV3.emptyLongList();
    }

    public static /* synthetic */ Internal.LongList access$7800() {
        return GeneratedMessageV3.emptyLongList();
    }

    public static Distribution getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return j.f53905a;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Distribution parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Distribution) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Distribution parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<Distribution> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Distribution)) {
            return super.equals(obj);
        }
        Distribution distribution = (Distribution) obj;
        if (getCount() != distribution.getCount() || Double.doubleToLongBits(getMean()) != Double.doubleToLongBits(distribution.getMean()) || Double.doubleToLongBits(getSumOfSquaredDeviation()) != Double.doubleToLongBits(distribution.getSumOfSquaredDeviation()) || hasRange() != distribution.hasRange()) {
            return false;
        }
        if ((!hasRange() || getRange().equals(distribution.getRange())) && hasBucketOptions() == distribution.hasBucketOptions()) {
            return (!hasBucketOptions() || getBucketOptions().equals(distribution.getBucketOptions())) && getBucketCountsList().equals(distribution.getBucketCountsList()) && getExemplarsList().equals(distribution.getExemplarsList()) && this.unknownFields.equals(distribution.unknownFields);
        }
        return false;
    }

    @Override // com.google.api.DistributionOrBuilder
    public long getBucketCounts(int i10) {
        return this.bucketCounts_.getLong(i10);
    }

    @Override // com.google.api.DistributionOrBuilder
    public int getBucketCountsCount() {
        return this.bucketCounts_.size();
    }

    @Override // com.google.api.DistributionOrBuilder
    public List<Long> getBucketCountsList() {
        return this.bucketCounts_;
    }

    @Override // com.google.api.DistributionOrBuilder
    public BucketOptions getBucketOptions() {
        BucketOptions bucketOptions = this.bucketOptions_;
        return bucketOptions == null ? BucketOptions.getDefaultInstance() : bucketOptions;
    }

    @Override // com.google.api.DistributionOrBuilder
    public BucketOptionsOrBuilder getBucketOptionsOrBuilder() {
        return getBucketOptions();
    }

    @Override // com.google.api.DistributionOrBuilder
    public long getCount() {
        return this.count_;
    }

    @Override // com.google.api.DistributionOrBuilder
    public Exemplar getExemplars(int i10) {
        return this.exemplars_.get(i10);
    }

    @Override // com.google.api.DistributionOrBuilder
    public int getExemplarsCount() {
        return this.exemplars_.size();
    }

    @Override // com.google.api.DistributionOrBuilder
    public List<Exemplar> getExemplarsList() {
        return this.exemplars_;
    }

    @Override // com.google.api.DistributionOrBuilder
    public ExemplarOrBuilder getExemplarsOrBuilder(int i10) {
        return this.exemplars_.get(i10);
    }

    @Override // com.google.api.DistributionOrBuilder
    public List<? extends ExemplarOrBuilder> getExemplarsOrBuilderList() {
        return this.exemplars_;
    }

    @Override // com.google.api.DistributionOrBuilder
    public double getMean() {
        return this.mean_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Distribution> getParserForType() {
        return PARSER;
    }

    @Override // com.google.api.DistributionOrBuilder
    public Range getRange() {
        Range range = this.range_;
        return range == null ? Range.getDefaultInstance() : range;
    }

    @Override // com.google.api.DistributionOrBuilder
    public RangeOrBuilder getRangeOrBuilder() {
        return getRange();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        long j10 = this.count_;
        int computeInt64Size = j10 != 0 ? CodedOutputStream.computeInt64Size(1, j10) + 0 : 0;
        if (Double.doubleToRawLongBits(this.mean_) != 0) {
            computeInt64Size += CodedOutputStream.computeDoubleSize(2, this.mean_);
        }
        if (Double.doubleToRawLongBits(this.sumOfSquaredDeviation_) != 0) {
            computeInt64Size += CodedOutputStream.computeDoubleSize(3, this.sumOfSquaredDeviation_);
        }
        if (this.range_ != null) {
            computeInt64Size += CodedOutputStream.computeMessageSize(4, getRange());
        }
        if (this.bucketOptions_ != null) {
            computeInt64Size += CodedOutputStream.computeMessageSize(6, getBucketOptions());
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.bucketCounts_.size(); i12++) {
            i11 += CodedOutputStream.computeInt64SizeNoTag(this.bucketCounts_.getLong(i12));
        }
        int i13 = computeInt64Size + i11;
        if (!getBucketCountsList().isEmpty()) {
            i13 = i13 + 1 + CodedOutputStream.computeInt32SizeNoTag(i11);
        }
        this.bucketCountsMemoizedSerializedSize = i11;
        for (int i14 = 0; i14 < this.exemplars_.size(); i14++) {
            i13 += CodedOutputStream.computeMessageSize(10, this.exemplars_.get(i14));
        }
        int serializedSize = i13 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.api.DistributionOrBuilder
    public double getSumOfSquaredDeviation() {
        return this.sumOfSquaredDeviation_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.api.DistributionOrBuilder
    public boolean hasBucketOptions() {
        return this.bucketOptions_ != null;
    }

    @Override // com.google.api.DistributionOrBuilder
    public boolean hasRange() {
        return this.range_ != null;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = ((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + Internal.hashLong(getCount())) * 37) + 2) * 53) + Internal.hashLong(Double.doubleToLongBits(getMean()))) * 37) + 3) * 53) + Internal.hashLong(Double.doubleToLongBits(getSumOfSquaredDeviation()));
        if (hasRange()) {
            hashCode = (((hashCode * 37) + 4) * 53) + getRange().hashCode();
        }
        if (hasBucketOptions()) {
            hashCode = (((hashCode * 37) + 6) * 53) + getBucketOptions().hashCode();
        }
        if (getBucketCountsCount() > 0) {
            hashCode = (((hashCode * 37) + 7) * 53) + getBucketCountsList().hashCode();
        }
        if (getExemplarsCount() > 0) {
            hashCode = (((hashCode * 37) + 10) * 53) + getExemplarsList().hashCode();
        }
        int hashCode2 = (hashCode * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return j.f53906b.ensureFieldAccessorsInitialized(Distribution.class, Builder.class);
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
        return new Distribution();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        long j10 = this.count_;
        if (j10 != 0) {
            codedOutputStream.writeInt64(1, j10);
        }
        if (Double.doubleToRawLongBits(this.mean_) != 0) {
            codedOutputStream.writeDouble(2, this.mean_);
        }
        if (Double.doubleToRawLongBits(this.sumOfSquaredDeviation_) != 0) {
            codedOutputStream.writeDouble(3, this.sumOfSquaredDeviation_);
        }
        if (this.range_ != null) {
            codedOutputStream.writeMessage(4, getRange());
        }
        if (this.bucketOptions_ != null) {
            codedOutputStream.writeMessage(6, getBucketOptions());
        }
        if (getBucketCountsList().size() > 0) {
            codedOutputStream.writeUInt32NoTag(58);
            codedOutputStream.writeUInt32NoTag(this.bucketCountsMemoizedSerializedSize);
        }
        for (int i10 = 0; i10 < this.bucketCounts_.size(); i10++) {
            codedOutputStream.writeInt64NoTag(this.bucketCounts_.getLong(i10));
        }
        for (int i11 = 0; i11 < this.exemplars_.size(); i11++) {
            codedOutputStream.writeMessage(10, this.exemplars_.get(i11));
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ Distribution(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(Distribution distribution) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(distribution);
    }

    public static Distribution parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Distribution) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Distribution parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private Distribution(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.bucketCountsMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static Distribution parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Distribution getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static Distribution parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Distribution parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    private Distribution() {
        this.bucketCountsMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.bucketCounts_ = GeneratedMessageV3.emptyLongList();
        this.exemplars_ = Collections.emptyList();
    }

    public static Distribution parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Distribution parseFrom(InputStream inputStream) throws IOException {
        return (Distribution) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Distribution parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Distribution) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Distribution parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Distribution) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Distribution parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Distribution) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Distribution(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 8) {
                                this.count_ = codedInputStream.readInt64();
                            } else if (readTag == 17) {
                                this.mean_ = codedInputStream.readDouble();
                            } else if (readTag != 25) {
                                if (readTag == 34) {
                                    Range range = this.range_;
                                    Range.Builder builder = range != null ? range.toBuilder() : null;
                                    Range range2 = (Range) codedInputStream.readMessage(Range.parser(), extensionRegistryLite);
                                    this.range_ = range2;
                                    if (builder != null) {
                                        builder.mergeFrom(range2);
                                        this.range_ = builder.buildPartial();
                                    }
                                } else if (readTag == 50) {
                                    BucketOptions bucketOptions = this.bucketOptions_;
                                    BucketOptions.Builder builder2 = bucketOptions != null ? bucketOptions.toBuilder() : null;
                                    BucketOptions bucketOptions2 = (BucketOptions) codedInputStream.readMessage(BucketOptions.parser(), extensionRegistryLite);
                                    this.bucketOptions_ = bucketOptions2;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(bucketOptions2);
                                        this.bucketOptions_ = builder2.buildPartial();
                                    }
                                } else if (readTag == 56) {
                                    if ((i10 & 1) == 0) {
                                        this.bucketCounts_ = GeneratedMessageV3.newLongList();
                                        i10 |= 1;
                                    }
                                    this.bucketCounts_.addLong(codedInputStream.readInt64());
                                } else if (readTag == 58) {
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if ((i10 & 1) == 0 && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.bucketCounts_ = GeneratedMessageV3.newLongList();
                                        i10 |= 1;
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.bucketCounts_.addLong(codedInputStream.readInt64());
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                } else if (readTag != 82) {
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    if ((i10 & 2) == 0) {
                                        this.exemplars_ = new ArrayList();
                                        i10 |= 2;
                                    }
                                    this.exemplars_.add(codedInputStream.readMessage(Exemplar.parser(), extensionRegistryLite));
                                }
                            } else {
                                this.sumOfSquaredDeviation_ = codedInputStream.readDouble();
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
                    this.bucketCounts_.makeImmutable();
                }
                if ((i10 & 2) != 0) {
                    this.exemplars_ = Collections.unmodifiableList(this.exemplars_);
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }
}
