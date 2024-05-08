package java.time.chrono;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.time.temporal.ValueRange;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ChronoLocalDateTimeImpl<D extends ChronoLocalDate> implements ChronoLocalDateTime<D>, Temporal, TemporalAdjuster, Serializable {
    static final int HOURS_PER_DAY = 24;
    static final long MICROS_PER_DAY = 86400000000L;
    static final long MILLIS_PER_DAY = 86400000;
    static final int MINUTES_PER_DAY = 1440;
    static final int MINUTES_PER_HOUR = 60;
    static final long NANOS_PER_DAY = 86400000000000L;
    static final long NANOS_PER_HOUR = 3600000000000L;
    static final long NANOS_PER_MINUTE = 60000000000L;
    static final long NANOS_PER_SECOND = 1000000000;
    static final int SECONDS_PER_DAY = 86400;
    static final int SECONDS_PER_HOUR = 3600;
    static final int SECONDS_PER_MINUTE = 60;
    private static final long serialVersionUID = 4556003607393004514L;
    private final transient D date;
    private final transient LocalTime time;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <R extends ChronoLocalDate> ChronoLocalDateTimeImpl<R> of(R date, LocalTime time) {
        return new ChronoLocalDateTimeImpl<>(date, time);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <R extends ChronoLocalDate> ChronoLocalDateTimeImpl<R> ensureValid(Chronology chrono, Temporal temporal) {
        ChronoLocalDateTimeImpl<R> other = (ChronoLocalDateTimeImpl) temporal;
        if (!chrono.equals(other.getChronology())) {
            throw new ClassCastException("Chronology mismatch, required: " + chrono.getId() + ", actual: " + other.getChronology().getId());
        }
        return other;
    }

    private ChronoLocalDateTimeImpl(D date, LocalTime time) {
        Objects.requireNonNull(date, "date");
        Objects.requireNonNull(time, "time");
        this.date = date;
        this.time = time;
    }

    private ChronoLocalDateTimeImpl<D> with(Temporal newDate, LocalTime newTime) {
        D d10 = this.date;
        if (d10 == newDate && this.time == newTime) {
            return this;
        }
        return new ChronoLocalDateTimeImpl<>(ChronoLocalDateImpl.ensureValid(d10.getChronology(), newDate), newTime);
    }

    @Override // java.time.chrono.ChronoLocalDateTime
    public D toLocalDate() {
        return this.date;
    }

    @Override // java.time.chrono.ChronoLocalDateTime
    public LocalTime toLocalTime() {
        return this.time;
    }

    @Override // java.time.chrono.ChronoLocalDateTime, java.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField field) {
        if (!(field instanceof ChronoField)) {
            return field != null && field.isSupportedBy(this);
        }
        ChronoField chronoField = (ChronoField) field;
        return chronoField.isDateBased() || chronoField.isTimeBased();
    }

    @Override // java.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField field) {
        if (!(field instanceof ChronoField)) {
            return field.rangeRefinedBy(this);
        }
        ChronoField chronoField = (ChronoField) field;
        return chronoField.isTimeBased() ? this.time.range(field) : this.date.range(field);
    }

    @Override // java.time.temporal.TemporalAccessor
    public int get(TemporalField field) {
        if (!(field instanceof ChronoField)) {
            return range(field).checkValidIntValue(getLong(field), field);
        }
        ChronoField chronoField = (ChronoField) field;
        return chronoField.isTimeBased() ? this.time.get(field) : this.date.get(field);
    }

    @Override // java.time.temporal.TemporalAccessor
    public long getLong(TemporalField field) {
        if (!(field instanceof ChronoField)) {
            return field.getFrom(this);
        }
        ChronoField chronoField = (ChronoField) field;
        return chronoField.isTimeBased() ? this.time.getLong(field) : this.date.getLong(field);
    }

    @Override // java.time.chrono.ChronoLocalDateTime, java.time.temporal.Temporal
    public ChronoLocalDateTimeImpl<D> with(TemporalAdjuster adjuster) {
        if (adjuster instanceof ChronoLocalDate) {
            return with((ChronoLocalDate) adjuster, this.time);
        }
        if (adjuster instanceof LocalTime) {
            return with(this.date, (LocalTime) adjuster);
        }
        if (adjuster instanceof ChronoLocalDateTimeImpl) {
            return ensureValid(this.date.getChronology(), (ChronoLocalDateTimeImpl) adjuster);
        }
        return ensureValid(this.date.getChronology(), (ChronoLocalDateTimeImpl) adjuster.adjustInto(this));
    }

    @Override // java.time.chrono.ChronoLocalDateTime, java.time.temporal.Temporal
    public ChronoLocalDateTimeImpl<D> with(TemporalField field, long newValue) {
        if (field instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) field;
            if (chronoField.isTimeBased()) {
                return with(this.date, this.time.with(field, newValue));
            }
            return with(this.date.with(field, newValue), this.time);
        }
        return ensureValid(this.date.getChronology(), field.adjustInto(this, newValue));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.time.chrono.ChronoLocalDateTimeImpl$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoUnit;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            $SwitchMap$java$time$temporal$ChronoUnit = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    @Override // java.time.chrono.ChronoLocalDateTime, java.time.temporal.Temporal
    public ChronoLocalDateTimeImpl<D> plus(long amountToAdd, TemporalUnit unit) {
        if (unit instanceof ChronoUnit) {
            ChronoUnit chronoUnit = (ChronoUnit) unit;
            switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[chronoUnit.ordinal()]) {
                case 1:
                    return plusNanos(amountToAdd);
                case 2:
                    return plusDays(amountToAdd / MICROS_PER_DAY).plusNanos((amountToAdd % MICROS_PER_DAY) * 1000);
                case 3:
                    return plusDays(amountToAdd / 86400000).plusNanos((amountToAdd % 86400000) * 1000000);
                case 4:
                    return plusSeconds(amountToAdd);
                case 5:
                    return plusMinutes(amountToAdd);
                case 6:
                    return plusHours(amountToAdd);
                case 7:
                    return plusDays(amountToAdd / 256).plusHours((amountToAdd % 256) * 12);
                default:
                    return with(this.date.plus(amountToAdd, unit), this.time);
            }
        }
        return ensureValid(this.date.getChronology(), unit.addTo(this, amountToAdd));
    }

    private ChronoLocalDateTimeImpl<D> plusDays(long days) {
        return with(this.date.plus(days, ChronoUnit.DAYS), this.time);
    }

    private ChronoLocalDateTimeImpl<D> plusHours(long hours) {
        return plusWithOverflow(this.date, hours, 0L, 0L, 0L);
    }

    private ChronoLocalDateTimeImpl<D> plusMinutes(long minutes) {
        return plusWithOverflow(this.date, 0L, minutes, 0L, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChronoLocalDateTimeImpl<D> plusSeconds(long seconds) {
        return plusWithOverflow(this.date, 0L, 0L, seconds, 0L);
    }

    private ChronoLocalDateTimeImpl<D> plusNanos(long nanos) {
        return plusWithOverflow(this.date, 0L, 0L, 0L, nanos);
    }

    private ChronoLocalDateTimeImpl<D> plusWithOverflow(D newDate, long hours, long minutes, long seconds, long nanos) {
        if ((hours | minutes | seconds | nanos) == 0) {
            return with(newDate, this.time);
        }
        long totDays = (nanos / NANOS_PER_DAY) + (seconds / 86400) + (minutes / 1440) + (hours / 24);
        long totNanos = (nanos % NANOS_PER_DAY) + ((seconds % 86400) * NANOS_PER_SECOND) + ((minutes % 1440) * NANOS_PER_MINUTE) + ((hours % 24) * NANOS_PER_HOUR);
        long curNoD = this.time.toNanoOfDay();
        long totNanos2 = totNanos + curNoD;
        long totDays2 = totDays + Math.floorDiv(totNanos2, NANOS_PER_DAY);
        long newNoD = Math.floorMod(totNanos2, NANOS_PER_DAY);
        LocalTime newTime = newNoD == curNoD ? this.time : LocalTime.ofNanoOfDay(newNoD);
        return with(newDate.plus(totDays2, ChronoUnit.DAYS), newTime);
    }

    @Override // java.time.chrono.ChronoLocalDateTime
    /* renamed from: atZone */
    public ChronoZonedDateTime<D> atZone2(ZoneId zone) {
        return ChronoZonedDateTimeImpl.ofBest(this, zone, null);
    }

    @Override // java.time.temporal.Temporal
    public long until(Temporal endExclusive, TemporalUnit unit) {
        Objects.requireNonNull(endExclusive, "endExclusive");
        ChronoLocalDateTime<? extends ChronoLocalDate> localDateTime = getChronology().localDateTime(endExclusive);
        if (unit instanceof ChronoUnit) {
            ChronoUnit chronoUnit = (ChronoUnit) unit;
            if (unit.isTimeBased()) {
                long amount = localDateTime.getLong(ChronoField.EPOCH_DAY) - this.date.getLong(ChronoField.EPOCH_DAY);
                switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[chronoUnit.ordinal()]) {
                    case 1:
                        amount = Math.multiplyExact(amount, NANOS_PER_DAY);
                        break;
                    case 2:
                        amount = Math.multiplyExact(amount, MICROS_PER_DAY);
                        break;
                    case 3:
                        amount = Math.multiplyExact(amount, 86400000L);
                        break;
                    case 4:
                        amount = Math.multiplyExact(amount, 86400);
                        break;
                    case 5:
                        amount = Math.multiplyExact(amount, 1440);
                        break;
                    case 6:
                        amount = Math.multiplyExact(amount, 24);
                        break;
                    case 7:
                        amount = Math.multiplyExact(amount, 2);
                        break;
                }
                return Math.addExact(amount, this.time.until(localDateTime.toLocalTime(), unit));
            }
            ChronoLocalDate endDate = localDateTime.toLocalDate();
            if (localDateTime.toLocalTime().isBefore(this.time)) {
                endDate = endDate.minus(1L, (TemporalUnit) ChronoUnit.DAYS);
            }
            return this.date.until(endDate, unit);
        }
        Objects.requireNonNull(unit, "unit");
        return unit.between(this, localDateTime);
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    private void readObject(ObjectInputStream s2) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.date);
        out.writeObject(this.time);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ChronoLocalDateTime<?> readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        ChronoLocalDate date = (ChronoLocalDate) in.readObject();
        LocalTime time = (LocalTime) in.readObject();
        return date.atTime(time);
    }

    @Override // java.time.chrono.ChronoLocalDateTime
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoLocalDateTime) && compareTo((ChronoLocalDateTime<?>) obj) == 0;
    }

    @Override // java.time.chrono.ChronoLocalDateTime
    public int hashCode() {
        return toLocalDate().hashCode() ^ toLocalTime().hashCode();
    }

    @Override // java.time.chrono.ChronoLocalDateTime
    public String toString() {
        return toLocalDate().toString() + 'T' + toLocalTime().toString();
    }
}
