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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Objects;
import u7.x;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class QuotaLimit extends GeneratedMessageV3 implements QuotaLimitOrBuilder {
    public static final int DEFAULT_LIMIT_FIELD_NUMBER = 3;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 12;
    public static final int DURATION_FIELD_NUMBER = 5;
    public static final int FREE_TIER_FIELD_NUMBER = 7;
    public static final int MAX_LIMIT_FIELD_NUMBER = 4;
    public static final int METRIC_FIELD_NUMBER = 8;
    public static final int NAME_FIELD_NUMBER = 6;
    public static final int UNIT_FIELD_NUMBER = 9;
    public static final int VALUES_FIELD_NUMBER = 10;
    private static final long serialVersionUID = 0;
    private long defaultLimit_;
    private volatile Object description_;
    private volatile Object displayName_;
    private volatile Object duration_;
    private long freeTier_;
    private long maxLimit_;
    private byte memoizedIsInitialized;
    private volatile Object metric_;
    private volatile Object name_;
    private volatile Object unit_;
    private MapField<String, Long> values_;
    private static final QuotaLimit DEFAULT_INSTANCE = new QuotaLimit();
    private static final Parser<QuotaLimit> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements QuotaLimitOrBuilder {
        private int bitField0_;
        private long defaultLimit_;
        private Object description_;
        private Object displayName_;
        private Object duration_;
        private long freeTier_;
        private long maxLimit_;
        private Object metric_;
        private Object name_;
        private Object unit_;
        private MapField<String, Long> values_;

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return x.f53986g;
        }

        private MapField<String, Long> internalGetMutableValues() {
            onChanged();
            if (this.values_ == null) {
                this.values_ = MapField.newMapField(b.f25933a);
            }
            if (!this.values_.isMutable()) {
                this.values_ = this.values_.copy();
            }
            return this.values_;
        }

        private MapField<String, Long> internalGetValues() {
            MapField<String, Long> mapField = this.values_;
            return mapField == null ? MapField.emptyMapField(b.f25933a) : mapField;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public Builder clearDefaultLimit() {
            this.defaultLimit_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearDescription() {
            this.description_ = QuotaLimit.getDefaultInstance().getDescription();
            onChanged();
            return this;
        }

        public Builder clearDisplayName() {
            this.displayName_ = QuotaLimit.getDefaultInstance().getDisplayName();
            onChanged();
            return this;
        }

        public Builder clearDuration() {
            this.duration_ = QuotaLimit.getDefaultInstance().getDuration();
            onChanged();
            return this;
        }

        public Builder clearFreeTier() {
            this.freeTier_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearMaxLimit() {
            this.maxLimit_ = 0L;
            onChanged();
            return this;
        }

        public Builder clearMetric() {
            this.metric_ = QuotaLimit.getDefaultInstance().getMetric();
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = QuotaLimit.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        public Builder clearUnit() {
            this.unit_ = QuotaLimit.getDefaultInstance().getUnit();
            onChanged();
            return this;
        }

        public Builder clearValues() {
            internalGetMutableValues().getMutableMap().clear();
            return this;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public boolean containsValues(String str) {
            Objects.requireNonNull(str, "map key");
            return internalGetValues().getMap().containsKey(str);
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public long getDefaultLimit() {
            return this.defaultLimit_;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public String getDescription() {
            Object obj = this.description_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.description_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public ByteString getDescriptionBytes() {
            Object obj = this.description_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.description_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return x.f53986g;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public String getDisplayName() {
            Object obj = this.displayName_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.displayName_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public ByteString getDisplayNameBytes() {
            Object obj = this.displayName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.displayName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public String getDuration() {
            Object obj = this.duration_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.duration_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public ByteString getDurationBytes() {
            Object obj = this.duration_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.duration_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public long getFreeTier() {
            return this.freeTier_;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public long getMaxLimit() {
            return this.maxLimit_;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public String getMetric() {
            Object obj = this.metric_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.metric_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public ByteString getMetricBytes() {
            Object obj = this.metric_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.metric_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Deprecated
        public Map<String, Long> getMutableValues() {
            return internalGetMutableValues().getMutableMap();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public String getUnit() {
            Object obj = this.unit_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.unit_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public ByteString getUnitBytes() {
            Object obj = this.unit_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.unit_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        @Deprecated
        public Map<String, Long> getValues() {
            return getValuesMap();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public int getValuesCount() {
            return internalGetValues().getMap().size();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public Map<String, Long> getValuesMap() {
            return internalGetValues().getMap();
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public long getValuesOrDefault(String str, long j10) {
            Objects.requireNonNull(str, "map key");
            Map<String, Long> map = internalGetValues().getMap();
            return map.containsKey(str) ? map.get(str).longValue() : j10;
        }

        @Override // com.google.api.QuotaLimitOrBuilder
        public long getValuesOrThrow(String str) {
            Objects.requireNonNull(str, "map key");
            Map<String, Long> map = internalGetValues().getMap();
            if (map.containsKey(str)) {
                return map.get(str).longValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return x.f53987h.ensureFieldAccessorsInitialized(QuotaLimit.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public MapField internalGetMapField(int i10) {
            if (i10 == 10) {
                return internalGetValues();
            }
            throw new RuntimeException("Invalid map field number: " + i10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public MapField internalGetMutableMapField(int i10) {
            if (i10 == 10) {
                return internalGetMutableValues();
            }
            throw new RuntimeException("Invalid map field number: " + i10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder putAllValues(Map<String, Long> map) {
            internalGetMutableValues().getMutableMap().putAll(map);
            return this;
        }

        public Builder putValues(String str, long j10) {
            Objects.requireNonNull(str, "map key");
            internalGetMutableValues().getMutableMap().put(str, Long.valueOf(j10));
            return this;
        }

        public Builder removeValues(String str) {
            Objects.requireNonNull(str, "map key");
            internalGetMutableValues().getMutableMap().remove(str);
            return this;
        }

        public Builder setDefaultLimit(long j10) {
            this.defaultLimit_ = j10;
            onChanged();
            return this;
        }

        public Builder setDescription(String str) {
            Objects.requireNonNull(str);
            this.description_ = str;
            onChanged();
            return this;
        }

        public Builder setDescriptionBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.description_ = byteString;
            onChanged();
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

        public Builder setDuration(String str) {
            Objects.requireNonNull(str);
            this.duration_ = str;
            onChanged();
            return this;
        }

        public Builder setDurationBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.duration_ = byteString;
            onChanged();
            return this;
        }

        public Builder setFreeTier(long j10) {
            this.freeTier_ = j10;
            onChanged();
            return this;
        }

        public Builder setMaxLimit(long j10) {
            this.maxLimit_ = j10;
            onChanged();
            return this;
        }

        public Builder setMetric(String str) {
            Objects.requireNonNull(str);
            this.metric_ = str;
            onChanged();
            return this;
        }

        public Builder setMetricBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.metric_ = byteString;
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

        public Builder setUnit(String str) {
            Objects.requireNonNull(str);
            this.unit_ = str;
            onChanged();
            return this;
        }

        public Builder setUnitBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.unit_ = byteString;
            onChanged();
            return this;
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        private Builder() {
            this.name_ = "";
            this.description_ = "";
            this.duration_ = "";
            this.metric_ = "";
            this.unit_ = "";
            this.displayName_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public QuotaLimit build() {
            QuotaLimit buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public QuotaLimit buildPartial() {
            QuotaLimit quotaLimit = new QuotaLimit(this, (a) null);
            quotaLimit.name_ = this.name_;
            quotaLimit.description_ = this.description_;
            quotaLimit.defaultLimit_ = this.defaultLimit_;
            quotaLimit.maxLimit_ = this.maxLimit_;
            quotaLimit.freeTier_ = this.freeTier_;
            quotaLimit.duration_ = this.duration_;
            quotaLimit.metric_ = this.metric_;
            quotaLimit.unit_ = this.unit_;
            quotaLimit.values_ = internalGetValues();
            quotaLimit.values_.makeImmutable();
            quotaLimit.displayName_ = this.displayName_;
            onBuilt();
            return quotaLimit;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public QuotaLimit getDefaultInstanceForType() {
            return QuotaLimit.getDefaultInstance();
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
            this.name_ = "";
            this.description_ = "";
            this.defaultLimit_ = 0L;
            this.maxLimit_ = 0L;
            this.freeTier_ = 0L;
            this.duration_ = "";
            this.metric_ = "";
            this.unit_ = "";
            internalGetMutableValues().clear();
            this.displayName_ = "";
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2458clone() {
            return (Builder) super.mo2458clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof QuotaLimit) {
                return mergeFrom((QuotaLimit) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(QuotaLimit quotaLimit) {
            if (quotaLimit == QuotaLimit.getDefaultInstance()) {
                return this;
            }
            if (!quotaLimit.getName().isEmpty()) {
                this.name_ = quotaLimit.name_;
                onChanged();
            }
            if (!quotaLimit.getDescription().isEmpty()) {
                this.description_ = quotaLimit.description_;
                onChanged();
            }
            if (quotaLimit.getDefaultLimit() != 0) {
                setDefaultLimit(quotaLimit.getDefaultLimit());
            }
            if (quotaLimit.getMaxLimit() != 0) {
                setMaxLimit(quotaLimit.getMaxLimit());
            }
            if (quotaLimit.getFreeTier() != 0) {
                setFreeTier(quotaLimit.getFreeTier());
            }
            if (!quotaLimit.getDuration().isEmpty()) {
                this.duration_ = quotaLimit.duration_;
                onChanged();
            }
            if (!quotaLimit.getMetric().isEmpty()) {
                this.metric_ = quotaLimit.metric_;
                onChanged();
            }
            if (!quotaLimit.getUnit().isEmpty()) {
                this.unit_ = quotaLimit.unit_;
                onChanged();
            }
            internalGetMutableValues().mergeFrom(quotaLimit.internalGetValues());
            if (!quotaLimit.getDisplayName().isEmpty()) {
                this.displayName_ = quotaLimit.displayName_;
                onChanged();
            }
            mergeUnknownFields(quotaLimit.unknownFields);
            onChanged();
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.name_ = "";
            this.description_ = "";
            this.duration_ = "";
            this.metric_ = "";
            this.unit_ = "";
            this.displayName_ = "";
            maybeForceBuilderInitialization();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.api.QuotaLimit.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.api.QuotaLimit.access$1600()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.api.QuotaLimit r3 = (com.google.api.QuotaLimit) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.api.QuotaLimit r4 = (com.google.api.QuotaLimit) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.api.QuotaLimit.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.api.QuotaLimit$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<QuotaLimit> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QuotaLimit parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new QuotaLimit(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final MapEntry<String, Long> f25933a = MapEntry.newDefaultInstance(x.f53988i, WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT64, 0L);
    }

    public /* synthetic */ QuotaLimit(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static QuotaLimit getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return x.f53986g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MapField<String, Long> internalGetValues() {
        MapField<String, Long> mapField = this.values_;
        return mapField == null ? MapField.emptyMapField(b.f25933a) : mapField;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static QuotaLimit parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (QuotaLimit) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static QuotaLimit parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<QuotaLimit> parser() {
        return PARSER;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public boolean containsValues(String str) {
        Objects.requireNonNull(str, "map key");
        return internalGetValues().getMap().containsKey(str);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QuotaLimit)) {
            return super.equals(obj);
        }
        QuotaLimit quotaLimit = (QuotaLimit) obj;
        return getName().equals(quotaLimit.getName()) && getDescription().equals(quotaLimit.getDescription()) && getDefaultLimit() == quotaLimit.getDefaultLimit() && getMaxLimit() == quotaLimit.getMaxLimit() && getFreeTier() == quotaLimit.getFreeTier() && getDuration().equals(quotaLimit.getDuration()) && getMetric().equals(quotaLimit.getMetric()) && getUnit().equals(quotaLimit.getUnit()) && internalGetValues().equals(quotaLimit.internalGetValues()) && getDisplayName().equals(quotaLimit.getDisplayName()) && this.unknownFields.equals(quotaLimit.unknownFields);
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public long getDefaultLimit() {
        return this.defaultLimit_;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public String getDescription() {
        Object obj = this.description_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.description_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public ByteString getDescriptionBytes() {
        Object obj = this.description_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.description_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public String getDisplayName() {
        Object obj = this.displayName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.displayName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public ByteString getDisplayNameBytes() {
        Object obj = this.displayName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.displayName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public String getDuration() {
        Object obj = this.duration_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.duration_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public ByteString getDurationBytes() {
        Object obj = this.duration_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.duration_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public long getFreeTier() {
        return this.freeTier_;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public long getMaxLimit() {
        return this.maxLimit_;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public String getMetric() {
        Object obj = this.metric_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.metric_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public ByteString getMetricBytes() {
        Object obj = this.metric_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.metric_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
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
    public Parser<QuotaLimit> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int computeStringSize = GeneratedMessageV3.isStringEmpty(this.description_) ? 0 : 0 + GeneratedMessageV3.computeStringSize(2, this.description_);
        long j10 = this.defaultLimit_;
        if (j10 != 0) {
            computeStringSize += CodedOutputStream.computeInt64Size(3, j10);
        }
        long j11 = this.maxLimit_;
        if (j11 != 0) {
            computeStringSize += CodedOutputStream.computeInt64Size(4, j11);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.duration_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(5, this.duration_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(6, this.name_);
        }
        long j12 = this.freeTier_;
        if (j12 != 0) {
            computeStringSize += CodedOutputStream.computeInt64Size(7, j12);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.metric_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(8, this.metric_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.unit_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(9, this.unit_);
        }
        for (Map.Entry<String, Long> entry : internalGetValues().getMap().entrySet()) {
            computeStringSize += CodedOutputStream.computeMessageSize(10, b.f25933a.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
        }
        if (!GeneratedMessageV3.isStringEmpty(this.displayName_)) {
            computeStringSize += GeneratedMessageV3.computeStringSize(12, this.displayName_);
        }
        int serializedSize = computeStringSize + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public String getUnit() {
        Object obj = this.unit_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.unit_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public ByteString getUnitBytes() {
        Object obj = this.unit_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.unit_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    @Deprecated
    public Map<String, Long> getValues() {
        return getValuesMap();
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public int getValuesCount() {
        return internalGetValues().getMap().size();
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public Map<String, Long> getValuesMap() {
        return internalGetValues().getMap();
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public long getValuesOrDefault(String str, long j10) {
        Objects.requireNonNull(str, "map key");
        Map<String, Long> map = internalGetValues().getMap();
        return map.containsKey(str) ? map.get(str).longValue() : j10;
    }

    @Override // com.google.api.QuotaLimitOrBuilder
    public long getValuesOrThrow(String str) {
        Objects.requireNonNull(str, "map key");
        Map<String, Long> map = internalGetValues().getMap();
        if (map.containsKey(str)) {
            return map.get(str).longValue();
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = ((((((((((((((((((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 6) * 53) + getName().hashCode()) * 37) + 2) * 53) + getDescription().hashCode()) * 37) + 3) * 53) + Internal.hashLong(getDefaultLimit())) * 37) + 4) * 53) + Internal.hashLong(getMaxLimit())) * 37) + 7) * 53) + Internal.hashLong(getFreeTier())) * 37) + 5) * 53) + getDuration().hashCode()) * 37) + 8) * 53) + getMetric().hashCode()) * 37) + 9) * 53) + getUnit().hashCode();
        if (!internalGetValues().getMap().isEmpty()) {
            hashCode = (((hashCode * 37) + 10) * 53) + internalGetValues().hashCode();
        }
        int hashCode2 = (((((hashCode * 37) + 12) * 53) + getDisplayName().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return x.f53987h.ensureFieldAccessorsInitialized(QuotaLimit.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public MapField internalGetMapField(int i10) {
        if (i10 == 10) {
            return internalGetValues();
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
        return new QuotaLimit();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (!GeneratedMessageV3.isStringEmpty(this.description_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.description_);
        }
        long j10 = this.defaultLimit_;
        if (j10 != 0) {
            codedOutputStream.writeInt64(3, j10);
        }
        long j11 = this.maxLimit_;
        if (j11 != 0) {
            codedOutputStream.writeInt64(4, j11);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.duration_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.duration_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.name_);
        }
        long j12 = this.freeTier_;
        if (j12 != 0) {
            codedOutputStream.writeInt64(7, j12);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.metric_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.metric_);
        }
        if (!GeneratedMessageV3.isStringEmpty(this.unit_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 9, this.unit_);
        }
        GeneratedMessageV3.serializeStringMapTo(codedOutputStream, internalGetValues(), b.f25933a, 10);
        if (!GeneratedMessageV3.isStringEmpty(this.displayName_)) {
            GeneratedMessageV3.writeString(codedOutputStream, 12, this.displayName_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ QuotaLimit(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(QuotaLimit quotaLimit) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(quotaLimit);
    }

    public static QuotaLimit parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (QuotaLimit) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static QuotaLimit parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private QuotaLimit(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static QuotaLimit parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public QuotaLimit getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static QuotaLimit parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    private QuotaLimit() {
        this.memoizedIsInitialized = (byte) -1;
        this.name_ = "";
        this.description_ = "";
        this.duration_ = "";
        this.metric_ = "";
        this.unit_ = "";
        this.displayName_ = "";
    }

    public static QuotaLimit parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static QuotaLimit parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static QuotaLimit parseFrom(InputStream inputStream) throws IOException {
        return (QuotaLimit) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static QuotaLimit parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (QuotaLimit) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static QuotaLimit parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (QuotaLimit) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static QuotaLimit parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (QuotaLimit) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0013. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    private QuotaLimit(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            case 18:
                                this.description_ = codedInputStream.readStringRequireUtf8();
                            case 24:
                                this.defaultLimit_ = codedInputStream.readInt64();
                            case 32:
                                this.maxLimit_ = codedInputStream.readInt64();
                            case 42:
                                this.duration_ = codedInputStream.readStringRequireUtf8();
                            case 50:
                                this.name_ = codedInputStream.readStringRequireUtf8();
                            case 56:
                                this.freeTier_ = codedInputStream.readInt64();
                            case 66:
                                this.metric_ = codedInputStream.readStringRequireUtf8();
                            case 74:
                                this.unit_ = codedInputStream.readStringRequireUtf8();
                            case 82:
                                if (!(z11 & true)) {
                                    this.values_ = MapField.newMapField(b.f25933a);
                                    z11 |= true;
                                }
                                MapEntry mapEntry = (MapEntry) codedInputStream.readMessage(b.f25933a.getParserForType(), extensionRegistryLite);
                                this.values_.getMutableMap().put(mapEntry.getKey(), mapEntry.getValue());
                            case 98:
                                this.displayName_ = codedInputStream.readStringRequireUtf8();
                            default:
                                if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    z10 = true;
                                }
                        }
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
