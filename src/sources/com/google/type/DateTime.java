package com.google.type;

import com.android.internal.logging.nano.MetricsProto;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Duration;
import com.google.protobuf.DurationOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UninitializedMessageException;
import com.google.protobuf.UnknownFieldSet;
import com.google.type.TimeZone;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;
import s8.d;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class DateTime extends GeneratedMessageV3 implements DateTimeOrBuilder {
    public static final int DAY_FIELD_NUMBER = 3;
    public static final int HOURS_FIELD_NUMBER = 4;
    public static final int MINUTES_FIELD_NUMBER = 5;
    public static final int MONTH_FIELD_NUMBER = 2;
    public static final int NANOS_FIELD_NUMBER = 7;
    public static final int SECONDS_FIELD_NUMBER = 6;
    public static final int TIME_ZONE_FIELD_NUMBER = 9;
    public static final int UTC_OFFSET_FIELD_NUMBER = 8;
    public static final int YEAR_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private int day_;
    private int hours_;
    private byte memoizedIsInitialized;
    private int minutes_;
    private int month_;
    private int nanos_;
    private int seconds_;
    private int timeOffsetCase_;
    private Object timeOffset_;
    private int year_;
    private static final DateTime DEFAULT_INSTANCE = new DateTime();
    private static final Parser<DateTime> PARSER = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DateTimeOrBuilder {
        private int day_;
        private int hours_;
        private int minutes_;
        private int month_;
        private int nanos_;
        private int seconds_;
        private int timeOffsetCase_;
        private Object timeOffset_;
        private SingleFieldBuilderV3<TimeZone, TimeZone.Builder, TimeZoneOrBuilder> timeZoneBuilder_;
        private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> utcOffsetBuilder_;
        private int year_;

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, a aVar) {
            this(builderParent);
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return d.f53636a;
        }

        private SingleFieldBuilderV3<TimeZone, TimeZone.Builder, TimeZoneOrBuilder> getTimeZoneFieldBuilder() {
            if (this.timeZoneBuilder_ == null) {
                if (this.timeOffsetCase_ != 9) {
                    this.timeOffset_ = TimeZone.getDefaultInstance();
                }
                this.timeZoneBuilder_ = new SingleFieldBuilderV3<>((TimeZone) this.timeOffset_, getParentForChildren(), isClean());
                this.timeOffset_ = null;
            }
            this.timeOffsetCase_ = 9;
            onChanged();
            return this.timeZoneBuilder_;
        }

        private SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> getUtcOffsetFieldBuilder() {
            if (this.utcOffsetBuilder_ == null) {
                if (this.timeOffsetCase_ != 8) {
                    this.timeOffset_ = Duration.getDefaultInstance();
                }
                this.utcOffsetBuilder_ = new SingleFieldBuilderV3<>((Duration) this.timeOffset_, getParentForChildren(), isClean());
                this.timeOffset_ = null;
            }
            this.timeOffsetCase_ = 8;
            onChanged();
            return this.utcOffsetBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public Builder clearDay() {
            this.day_ = 0;
            onChanged();
            return this;
        }

        public Builder clearHours() {
            this.hours_ = 0;
            onChanged();
            return this;
        }

        public Builder clearMinutes() {
            this.minutes_ = 0;
            onChanged();
            return this;
        }

        public Builder clearMonth() {
            this.month_ = 0;
            onChanged();
            return this;
        }

        public Builder clearNanos() {
            this.nanos_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSeconds() {
            this.seconds_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTimeOffset() {
            this.timeOffsetCase_ = 0;
            this.timeOffset_ = null;
            onChanged();
            return this;
        }

        public Builder clearTimeZone() {
            SingleFieldBuilderV3<TimeZone, TimeZone.Builder, TimeZoneOrBuilder> singleFieldBuilderV3 = this.timeZoneBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.timeOffsetCase_ == 9) {
                    this.timeOffsetCase_ = 0;
                    this.timeOffset_ = null;
                    onChanged();
                }
            } else {
                if (this.timeOffsetCase_ == 9) {
                    this.timeOffsetCase_ = 0;
                    this.timeOffset_ = null;
                }
                singleFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearUtcOffset() {
            SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.utcOffsetBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.timeOffsetCase_ == 8) {
                    this.timeOffsetCase_ = 0;
                    this.timeOffset_ = null;
                    onChanged();
                }
            } else {
                if (this.timeOffsetCase_ == 8) {
                    this.timeOffsetCase_ = 0;
                    this.timeOffset_ = null;
                }
                singleFieldBuilderV3.clear();
            }
            return this;
        }

        public Builder clearYear() {
            this.year_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getDay() {
            return this.day_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return d.f53636a;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getHours() {
            return this.hours_;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getMinutes() {
            return this.minutes_;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getMonth() {
            return this.month_;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getNanos() {
            return this.nanos_;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getSeconds() {
            return this.seconds_;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public TimeOffsetCase getTimeOffsetCase() {
            return TimeOffsetCase.forNumber(this.timeOffsetCase_);
        }

        @Override // com.google.type.DateTimeOrBuilder
        public TimeZone getTimeZone() {
            SingleFieldBuilderV3<TimeZone, TimeZone.Builder, TimeZoneOrBuilder> singleFieldBuilderV3 = this.timeZoneBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.timeOffsetCase_ == 9) {
                    return (TimeZone) this.timeOffset_;
                }
                return TimeZone.getDefaultInstance();
            }
            if (this.timeOffsetCase_ == 9) {
                return singleFieldBuilderV3.getMessage();
            }
            return TimeZone.getDefaultInstance();
        }

        public TimeZone.Builder getTimeZoneBuilder() {
            return getTimeZoneFieldBuilder().getBuilder();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public TimeZoneOrBuilder getTimeZoneOrBuilder() {
            SingleFieldBuilderV3<TimeZone, TimeZone.Builder, TimeZoneOrBuilder> singleFieldBuilderV3;
            int i10 = this.timeOffsetCase_;
            if (i10 == 9 && (singleFieldBuilderV3 = this.timeZoneBuilder_) != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            if (i10 == 9) {
                return (TimeZone) this.timeOffset_;
            }
            return TimeZone.getDefaultInstance();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public Duration getUtcOffset() {
            SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.utcOffsetBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.timeOffsetCase_ == 8) {
                    return (Duration) this.timeOffset_;
                }
                return Duration.getDefaultInstance();
            }
            if (this.timeOffsetCase_ == 8) {
                return singleFieldBuilderV3.getMessage();
            }
            return Duration.getDefaultInstance();
        }

        public Duration.Builder getUtcOffsetBuilder() {
            return getUtcOffsetFieldBuilder().getBuilder();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public DurationOrBuilder getUtcOffsetOrBuilder() {
            SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3;
            int i10 = this.timeOffsetCase_;
            if (i10 == 8 && (singleFieldBuilderV3 = this.utcOffsetBuilder_) != null) {
                return singleFieldBuilderV3.getMessageOrBuilder();
            }
            if (i10 == 8) {
                return (Duration) this.timeOffset_;
            }
            return Duration.getDefaultInstance();
        }

        @Override // com.google.type.DateTimeOrBuilder
        public int getYear() {
            return this.year_;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public boolean hasTimeZone() {
            return this.timeOffsetCase_ == 9;
        }

        @Override // com.google.type.DateTimeOrBuilder
        public boolean hasUtcOffset() {
            return this.timeOffsetCase_ == 8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return d.f53637b.ensureFieldAccessorsInitialized(DateTime.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeTimeZone(TimeZone timeZone) {
            SingleFieldBuilderV3<TimeZone, TimeZone.Builder, TimeZoneOrBuilder> singleFieldBuilderV3 = this.timeZoneBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.timeOffsetCase_ == 9 && this.timeOffset_ != TimeZone.getDefaultInstance()) {
                    this.timeOffset_ = TimeZone.newBuilder((TimeZone) this.timeOffset_).mergeFrom(timeZone).buildPartial();
                } else {
                    this.timeOffset_ = timeZone;
                }
                onChanged();
            } else if (this.timeOffsetCase_ == 9) {
                singleFieldBuilderV3.mergeFrom(timeZone);
            } else {
                singleFieldBuilderV3.setMessage(timeZone);
            }
            this.timeOffsetCase_ = 9;
            return this;
        }

        public Builder mergeUtcOffset(Duration duration) {
            SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.utcOffsetBuilder_;
            if (singleFieldBuilderV3 == null) {
                if (this.timeOffsetCase_ == 8 && this.timeOffset_ != Duration.getDefaultInstance()) {
                    this.timeOffset_ = Duration.newBuilder((Duration) this.timeOffset_).mergeFrom(duration).buildPartial();
                } else {
                    this.timeOffset_ = duration;
                }
                onChanged();
            } else if (this.timeOffsetCase_ == 8) {
                singleFieldBuilderV3.mergeFrom(duration);
            } else {
                singleFieldBuilderV3.setMessage(duration);
            }
            this.timeOffsetCase_ = 8;
            return this;
        }

        public Builder setDay(int i10) {
            this.day_ = i10;
            onChanged();
            return this;
        }

        public Builder setHours(int i10) {
            this.hours_ = i10;
            onChanged();
            return this;
        }

        public Builder setMinutes(int i10) {
            this.minutes_ = i10;
            onChanged();
            return this;
        }

        public Builder setMonth(int i10) {
            this.month_ = i10;
            onChanged();
            return this;
        }

        public Builder setNanos(int i10) {
            this.nanos_ = i10;
            onChanged();
            return this;
        }

        public Builder setSeconds(int i10) {
            this.seconds_ = i10;
            onChanged();
            return this;
        }

        public Builder setTimeZone(TimeZone timeZone) {
            SingleFieldBuilderV3<TimeZone, TimeZone.Builder, TimeZoneOrBuilder> singleFieldBuilderV3 = this.timeZoneBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(timeZone);
                this.timeOffset_ = timeZone;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(timeZone);
            }
            this.timeOffsetCase_ = 9;
            return this;
        }

        public Builder setUtcOffset(Duration duration) {
            SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.utcOffsetBuilder_;
            if (singleFieldBuilderV3 == null) {
                Objects.requireNonNull(duration);
                this.timeOffset_ = duration;
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(duration);
            }
            this.timeOffsetCase_ = 8;
            return this;
        }

        public Builder setYear(int i10) {
            this.year_ = i10;
            onChanged();
            return this;
        }

        public /* synthetic */ Builder(a aVar) {
            this();
        }

        private Builder() {
            this.timeOffsetCase_ = 0;
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public DateTime build() {
            DateTime buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessage.Builder.newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public DateTime buildPartial() {
            DateTime dateTime = new DateTime(this, (a) null);
            dateTime.year_ = this.year_;
            dateTime.month_ = this.month_;
            dateTime.day_ = this.day_;
            dateTime.hours_ = this.hours_;
            dateTime.minutes_ = this.minutes_;
            dateTime.seconds_ = this.seconds_;
            dateTime.nanos_ = this.nanos_;
            if (this.timeOffsetCase_ == 8) {
                SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.utcOffsetBuilder_;
                if (singleFieldBuilderV3 == null) {
                    dateTime.timeOffset_ = this.timeOffset_;
                } else {
                    dateTime.timeOffset_ = singleFieldBuilderV3.build();
                }
            }
            if (this.timeOffsetCase_ == 9) {
                SingleFieldBuilderV3<TimeZone, TimeZone.Builder, TimeZoneOrBuilder> singleFieldBuilderV32 = this.timeZoneBuilder_;
                if (singleFieldBuilderV32 == null) {
                    dateTime.timeOffset_ = this.timeOffset_;
                } else {
                    dateTime.timeOffset_ = singleFieldBuilderV32.build();
                }
            }
            dateTime.timeOffsetCase_ = this.timeOffsetCase_;
            onBuilt();
            return dateTime;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DateTime getDefaultInstanceForType() {
            return DateTime.getDefaultInstance();
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
            this.year_ = 0;
            this.month_ = 0;
            this.day_ = 0;
            this.hours_ = 0;
            this.minutes_ = 0;
            this.seconds_ = 0;
            this.nanos_ = 0;
            this.timeOffsetCase_ = 0;
            this.timeOffset_ = null;
            return this;
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.timeOffsetCase_ = 0;
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2458clone() {
            return (Builder) super.mo2458clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof DateTime) {
                return mergeFrom((DateTime) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder setTimeZone(TimeZone.Builder builder) {
            SingleFieldBuilderV3<TimeZone, TimeZone.Builder, TimeZoneOrBuilder> singleFieldBuilderV3 = this.timeZoneBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.timeOffset_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.timeOffsetCase_ = 9;
            return this;
        }

        public Builder setUtcOffset(Duration.Builder builder) {
            SingleFieldBuilderV3<Duration, Duration.Builder, DurationOrBuilder> singleFieldBuilderV3 = this.utcOffsetBuilder_;
            if (singleFieldBuilderV3 == null) {
                this.timeOffset_ = builder.build();
                onChanged();
            } else {
                singleFieldBuilderV3.setMessage(builder.build());
            }
            this.timeOffsetCase_ = 8;
            return this;
        }

        public Builder mergeFrom(DateTime dateTime) {
            if (dateTime == DateTime.getDefaultInstance()) {
                return this;
            }
            if (dateTime.getYear() != 0) {
                setYear(dateTime.getYear());
            }
            if (dateTime.getMonth() != 0) {
                setMonth(dateTime.getMonth());
            }
            if (dateTime.getDay() != 0) {
                setDay(dateTime.getDay());
            }
            if (dateTime.getHours() != 0) {
                setHours(dateTime.getHours());
            }
            if (dateTime.getMinutes() != 0) {
                setMinutes(dateTime.getMinutes());
            }
            if (dateTime.getSeconds() != 0) {
                setSeconds(dateTime.getSeconds());
            }
            if (dateTime.getNanos() != 0) {
                setNanos(dateTime.getNanos());
            }
            int i10 = b.f27110a[dateTime.getTimeOffsetCase().ordinal()];
            if (i10 == 1) {
                mergeUtcOffset(dateTime.getUtcOffset());
            } else if (i10 == 2) {
                mergeTimeZone(dateTime.getTimeZone());
            }
            mergeUnknownFields(dateTime.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.type.DateTime.Builder mergeFrom(com.google.protobuf.CodedInputStream r3, com.google.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
            /*
                r2 = this;
                r0 = 0
                com.google.protobuf.Parser r1 = com.google.type.DateTime.access$1400()     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                java.lang.Object r3 = r1.parsePartialFrom(r3, r4)     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
                com.google.type.DateTime r3 = (com.google.type.DateTime) r3     // Catch: java.lang.Throwable -> L11 com.google.protobuf.InvalidProtocolBufferException -> L13
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
                com.google.type.DateTime r4 = (com.google.type.DateTime) r4     // Catch: java.lang.Throwable -> L11
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.type.DateTime.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.type.DateTime$Builder");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum TimeOffsetCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
        UTC_OFFSET(8),
        TIME_ZONE(9),
        TIMEOFFSET_NOT_SET(0);

        private final int value;

        TimeOffsetCase(int i10) {
            this.value = i10;
        }

        public static TimeOffsetCase forNumber(int i10) {
            if (i10 == 0) {
                return TIMEOFFSET_NOT_SET;
            }
            if (i10 == 8) {
                return UTC_OFFSET;
            }
            if (i10 != 9) {
                return null;
            }
            return TIME_ZONE;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static TimeOffsetCase valueOf(int i10) {
            return forNumber(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a extends AbstractParser<DateTime> {
        @Override // com.google.protobuf.Parser
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateTime parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new DateTime(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27110a;

        static {
            int[] iArr = new int[TimeOffsetCase.values().length];
            f27110a = iArr;
            try {
                iArr[TimeOffsetCase.UTC_OFFSET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27110a[TimeOffsetCase.TIME_ZONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27110a[TimeOffsetCase.TIMEOFFSET_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public /* synthetic */ DateTime(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, a aVar) throws InvalidProtocolBufferException {
        this(codedInputStream, extensionRegistryLite);
    }

    public static DateTime getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return d.f53636a;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static DateTime parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (DateTime) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static DateTime parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Parser<DateTime> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DateTime)) {
            return super.equals(obj);
        }
        DateTime dateTime = (DateTime) obj;
        if (getYear() != dateTime.getYear() || getMonth() != dateTime.getMonth() || getDay() != dateTime.getDay() || getHours() != dateTime.getHours() || getMinutes() != dateTime.getMinutes() || getSeconds() != dateTime.getSeconds() || getNanos() != dateTime.getNanos() || !getTimeOffsetCase().equals(dateTime.getTimeOffsetCase())) {
            return false;
        }
        int i10 = this.timeOffsetCase_;
        if (i10 != 8) {
            if (i10 == 9 && !getTimeZone().equals(dateTime.getTimeZone())) {
                return false;
            }
        } else if (!getUtcOffset().equals(dateTime.getUtcOffset())) {
            return false;
        }
        return this.unknownFields.equals(dateTime.unknownFields);
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getDay() {
        return this.day_;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getHours() {
        return this.hours_;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getMinutes() {
        return this.minutes_;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getMonth() {
        return this.month_;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getNanos() {
        return this.nanos_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<DateTime> getParserForType() {
        return PARSER;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getSeconds() {
        return this.seconds_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i10 = this.memoizedSize;
        if (i10 != -1) {
            return i10;
        }
        int i11 = this.year_;
        int computeInt32Size = i11 != 0 ? 0 + CodedOutputStream.computeInt32Size(1, i11) : 0;
        int i12 = this.month_;
        if (i12 != 0) {
            computeInt32Size += CodedOutputStream.computeInt32Size(2, i12);
        }
        int i13 = this.day_;
        if (i13 != 0) {
            computeInt32Size += CodedOutputStream.computeInt32Size(3, i13);
        }
        int i14 = this.hours_;
        if (i14 != 0) {
            computeInt32Size += CodedOutputStream.computeInt32Size(4, i14);
        }
        int i15 = this.minutes_;
        if (i15 != 0) {
            computeInt32Size += CodedOutputStream.computeInt32Size(5, i15);
        }
        int i16 = this.seconds_;
        if (i16 != 0) {
            computeInt32Size += CodedOutputStream.computeInt32Size(6, i16);
        }
        int i17 = this.nanos_;
        if (i17 != 0) {
            computeInt32Size += CodedOutputStream.computeInt32Size(7, i17);
        }
        if (this.timeOffsetCase_ == 8) {
            computeInt32Size += CodedOutputStream.computeMessageSize(8, (Duration) this.timeOffset_);
        }
        if (this.timeOffsetCase_ == 9) {
            computeInt32Size += CodedOutputStream.computeMessageSize(9, (TimeZone) this.timeOffset_);
        }
        int serializedSize = computeInt32Size + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public TimeOffsetCase getTimeOffsetCase() {
        return TimeOffsetCase.forNumber(this.timeOffsetCase_);
    }

    @Override // com.google.type.DateTimeOrBuilder
    public TimeZone getTimeZone() {
        if (this.timeOffsetCase_ == 9) {
            return (TimeZone) this.timeOffset_;
        }
        return TimeZone.getDefaultInstance();
    }

    @Override // com.google.type.DateTimeOrBuilder
    public TimeZoneOrBuilder getTimeZoneOrBuilder() {
        if (this.timeOffsetCase_ == 9) {
            return (TimeZone) this.timeOffset_;
        }
        return TimeZone.getDefaultInstance();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public Duration getUtcOffset() {
        if (this.timeOffsetCase_ == 8) {
            return (Duration) this.timeOffset_;
        }
        return Duration.getDefaultInstance();
    }

    @Override // com.google.type.DateTimeOrBuilder
    public DurationOrBuilder getUtcOffsetOrBuilder() {
        if (this.timeOffsetCase_ == 8) {
            return (Duration) this.timeOffset_;
        }
        return Duration.getDefaultInstance();
    }

    @Override // com.google.type.DateTimeOrBuilder
    public int getYear() {
        return this.year_;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public boolean hasTimeZone() {
        return this.timeOffsetCase_ == 9;
    }

    @Override // com.google.type.DateTimeOrBuilder
    public boolean hasUtcOffset() {
        return this.timeOffsetCase_ == 8;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int i10;
        int hashCode;
        int i11 = this.memoizedHashCode;
        if (i11 != 0) {
            return i11;
        }
        int hashCode2 = ((((((((((((((((((((((((((((MetricsProto.MetricsEvent.APP_SPECIAL_PERMISSION_PREMIUM_SMS_DENY + getDescriptor().hashCode()) * 37) + 1) * 53) + getYear()) * 37) + 2) * 53) + getMonth()) * 37) + 3) * 53) + getDay()) * 37) + 4) * 53) + getHours()) * 37) + 5) * 53) + getMinutes()) * 37) + 6) * 53) + getSeconds()) * 37) + 7) * 53) + getNanos();
        int i12 = this.timeOffsetCase_;
        if (i12 == 8) {
            i10 = ((hashCode2 * 37) + 8) * 53;
            hashCode = getUtcOffset().hashCode();
        } else {
            if (i12 == 9) {
                i10 = ((hashCode2 * 37) + 9) * 53;
                hashCode = getTimeZone().hashCode();
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
        return d.f53637b.ensureFieldAccessorsInitialized(DateTime.class, Builder.class);
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
        return new DateTime();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i10 = this.year_;
        if (i10 != 0) {
            codedOutputStream.writeInt32(1, i10);
        }
        int i11 = this.month_;
        if (i11 != 0) {
            codedOutputStream.writeInt32(2, i11);
        }
        int i12 = this.day_;
        if (i12 != 0) {
            codedOutputStream.writeInt32(3, i12);
        }
        int i13 = this.hours_;
        if (i13 != 0) {
            codedOutputStream.writeInt32(4, i13);
        }
        int i14 = this.minutes_;
        if (i14 != 0) {
            codedOutputStream.writeInt32(5, i14);
        }
        int i15 = this.seconds_;
        if (i15 != 0) {
            codedOutputStream.writeInt32(6, i15);
        }
        int i16 = this.nanos_;
        if (i16 != 0) {
            codedOutputStream.writeInt32(7, i16);
        }
        if (this.timeOffsetCase_ == 8) {
            codedOutputStream.writeMessage(8, (Duration) this.timeOffset_);
        }
        if (this.timeOffsetCase_ == 9) {
            codedOutputStream.writeMessage(9, (TimeZone) this.timeOffset_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }

    public /* synthetic */ DateTime(GeneratedMessageV3.Builder builder, a aVar) {
        this(builder);
    }

    public static Builder newBuilder(DateTime dateTime) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(dateTime);
    }

    public static DateTime parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DateTime) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static DateTime parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    private DateTime(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.timeOffsetCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static DateTime parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public DateTime getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        a aVar = null;
        return this == DEFAULT_INSTANCE ? new Builder(aVar) : new Builder(aVar).mergeFrom(this);
    }

    public static DateTime parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static DateTime parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    private DateTime() {
        this.timeOffsetCase_ = 0;
        this.memoizedIsInitialized = (byte) -1;
    }

    public static DateTime parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static DateTime parseFrom(InputStream inputStream) throws IOException {
        return (DateTime) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static DateTime parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DateTime) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    private DateTime(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                            if (readTag == 8) {
                                this.year_ = codedInputStream.readInt32();
                            } else if (readTag == 16) {
                                this.month_ = codedInputStream.readInt32();
                            } else if (readTag == 24) {
                                this.day_ = codedInputStream.readInt32();
                            } else if (readTag == 32) {
                                this.hours_ = codedInputStream.readInt32();
                            } else if (readTag == 40) {
                                this.minutes_ = codedInputStream.readInt32();
                            } else if (readTag == 48) {
                                this.seconds_ = codedInputStream.readInt32();
                            } else if (readTag != 56) {
                                if (readTag == 66) {
                                    Duration.Builder builder = this.timeOffsetCase_ == 8 ? ((Duration) this.timeOffset_).toBuilder() : null;
                                    MessageLite readMessage = codedInputStream.readMessage(Duration.parser(), extensionRegistryLite);
                                    this.timeOffset_ = readMessage;
                                    if (builder != null) {
                                        builder.mergeFrom((Duration) readMessage);
                                        this.timeOffset_ = builder.buildPartial();
                                    }
                                    this.timeOffsetCase_ = 8;
                                } else if (readTag != 74) {
                                    if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    TimeZone.Builder builder2 = this.timeOffsetCase_ == 9 ? ((TimeZone) this.timeOffset_).toBuilder() : null;
                                    MessageLite readMessage2 = codedInputStream.readMessage(TimeZone.parser(), extensionRegistryLite);
                                    this.timeOffset_ = readMessage2;
                                    if (builder2 != null) {
                                        builder2.mergeFrom((TimeZone) readMessage2);
                                        this.timeOffset_ = builder2.buildPartial();
                                    }
                                    this.timeOffsetCase_ = 9;
                                }
                            } else {
                                this.nanos_ = codedInputStream.readInt32();
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

    public static DateTime parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (DateTime) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static DateTime parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DateTime) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }
}
