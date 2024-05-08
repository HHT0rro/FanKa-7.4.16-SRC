package java.time.chrono;

import com.huawei.quickcard.base.Attributes;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;
import java.util.Comparator;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface ChronoLocalDateTime<D extends ChronoLocalDate> extends Temporal, TemporalAdjuster, Comparable<ChronoLocalDateTime<?>> {
    /* renamed from: atZone */
    ChronoZonedDateTime<D> atZone2(ZoneId zoneId);

    boolean equals(Object obj);

    int hashCode();

    @Override // java.time.temporal.TemporalAccessor
    boolean isSupported(TemporalField temporalField);

    @Override // java.time.temporal.Temporal
    ChronoLocalDateTime<D> plus(long j10, TemporalUnit temporalUnit);

    D toLocalDate();

    LocalTime toLocalTime();

    String toString();

    @Override // java.time.temporal.Temporal
    ChronoLocalDateTime<D> with(TemporalField temporalField, long j10);

    static Comparator<ChronoLocalDateTime<?>> timeLineOrder() {
        return new ChronoLocalDateTime$$ExternalSyntheticLambda0();
    }

    static /* synthetic */ int lambda$timeLineOrder$b9959cb5$1(ChronoLocalDateTime dateTime1, ChronoLocalDateTime dateTime2) {
        int cmp = Long.compare(dateTime1.toLocalDate().toEpochDay(), dateTime2.toLocalDate().toEpochDay());
        if (cmp == 0) {
            return Long.compare(dateTime1.toLocalTime().toNanoOfDay(), dateTime2.toLocalTime().toNanoOfDay());
        }
        return cmp;
    }

    static ChronoLocalDateTime<?> from(TemporalAccessor temporal) {
        if (temporal instanceof ChronoLocalDateTime) {
            return (ChronoLocalDateTime) temporal;
        }
        Objects.requireNonNull(temporal, "temporal");
        Chronology chrono = (Chronology) temporal.query(TemporalQueries.chronology());
        if (chrono == null) {
            throw new DateTimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + ((Object) temporal.getClass()));
        }
        return chrono.localDateTime(temporal);
    }

    default Chronology getChronology() {
        return toLocalDate().getChronology();
    }

    @Override // java.time.temporal.Temporal
    default boolean isSupported(TemporalUnit unit) {
        return unit instanceof ChronoUnit ? unit != ChronoUnit.FOREVER : unit != null && unit.isSupportedBy(this);
    }

    @Override // java.time.temporal.Temporal
    default ChronoLocalDateTime<D> with(TemporalAdjuster adjuster) {
        return ChronoLocalDateTimeImpl.ensureValid(getChronology(), super.with(adjuster));
    }

    @Override // java.time.temporal.Temporal
    default ChronoLocalDateTime<D> plus(TemporalAmount amount) {
        return ChronoLocalDateTimeImpl.ensureValid(getChronology(), super.plus(amount));
    }

    @Override // java.time.temporal.Temporal
    default ChronoLocalDateTime<D> minus(TemporalAmount amount) {
        return ChronoLocalDateTimeImpl.ensureValid(getChronology(), super.minus(amount));
    }

    @Override // java.time.temporal.Temporal
    default ChronoLocalDateTime<D> minus(long amountToSubtract, TemporalUnit unit) {
        return ChronoLocalDateTimeImpl.ensureValid(getChronology(), super.minus(amountToSubtract, unit));
    }

    @Override // java.time.temporal.TemporalAccessor
    default <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.offset()) {
            return null;
        }
        if (temporalQuery == TemporalQueries.localTime()) {
            return (R) toLocalTime();
        }
        if (temporalQuery == TemporalQueries.chronology()) {
            return (R) getChronology();
        }
        if (temporalQuery == TemporalQueries.precision()) {
            return (R) ChronoUnit.NANOS;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // java.time.temporal.TemporalAdjuster
    default Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.EPOCH_DAY, toLocalDate().toEpochDay()).with(ChronoField.NANO_OF_DAY, toLocalTime().toNanoOfDay());
    }

    default String format(DateTimeFormatter formatter) {
        Objects.requireNonNull(formatter, "formatter");
        return formatter.format(this);
    }

    default Instant toInstant(ZoneOffset offset) {
        return Instant.ofEpochSecond(toEpochSecond(offset), toLocalTime().getNano());
    }

    default long toEpochSecond(ZoneOffset offset) {
        Objects.requireNonNull(offset, Attributes.Style.OFFSET);
        long epochDay = toLocalDate().toEpochDay();
        long secs = (86400 * epochDay) + toLocalTime().toSecondOfDay();
        return secs - offset.getTotalSeconds();
    }

    @Override // java.lang.Comparable
    default int compareTo(ChronoLocalDateTime<?> other) {
        int cmp = toLocalDate().compareTo(other.toLocalDate());
        if (cmp == 0) {
            int cmp2 = toLocalTime().compareTo(other.toLocalTime());
            if (cmp2 == 0) {
                return getChronology().compareTo(other.getChronology());
            }
            return cmp2;
        }
        return cmp;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.time.chrono.ChronoLocalDate] */
    default boolean isAfter(ChronoLocalDateTime<?> other) {
        long thisEpDay = toLocalDate().toEpochDay();
        long otherEpDay = other.toLocalDate().toEpochDay();
        return thisEpDay > otherEpDay || (thisEpDay == otherEpDay && toLocalTime().toNanoOfDay() > other.toLocalTime().toNanoOfDay());
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.time.chrono.ChronoLocalDate] */
    default boolean isBefore(ChronoLocalDateTime<?> other) {
        long thisEpDay = toLocalDate().toEpochDay();
        long otherEpDay = other.toLocalDate().toEpochDay();
        return thisEpDay < otherEpDay || (thisEpDay == otherEpDay && toLocalTime().toNanoOfDay() < other.toLocalTime().toNanoOfDay());
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.time.chrono.ChronoLocalDate] */
    default boolean isEqual(ChronoLocalDateTime<?> other) {
        return toLocalTime().toNanoOfDay() == other.toLocalTime().toNanoOfDay() && toLocalDate().toEpochDay() == other.toLocalDate().toEpochDay();
    }
}
