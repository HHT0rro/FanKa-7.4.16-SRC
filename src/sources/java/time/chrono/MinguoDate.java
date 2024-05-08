package java.time.chrono;

import com.alibaba.wireless.security.SecExceptionCode;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.time.temporal.ValueRange;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class MinguoDate extends ChronoLocalDateImpl<MinguoDate> implements ChronoLocalDate, Serializable {
    private static final long serialVersionUID = 1300372329181994526L;
    private final transient LocalDate isoDate;

    @Override // java.time.chrono.ChronoLocalDateImpl, java.time.chrono.ChronoLocalDate
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // java.time.chrono.ChronoLocalDateImpl, java.time.chrono.ChronoLocalDate, java.time.temporal.Temporal
    public /* bridge */ /* synthetic */ long until(Temporal temporal, TemporalUnit temporalUnit) {
        return super.until(temporal, temporalUnit);
    }

    public static MinguoDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static MinguoDate now(ZoneId zone) {
        return now(Clock.system(zone));
    }

    public static MinguoDate now(Clock clock) {
        return new MinguoDate(LocalDate.now(clock));
    }

    public static MinguoDate of(int prolepticYear, int month, int dayOfMonth) {
        return new MinguoDate(LocalDate.of(prolepticYear + SecExceptionCode.SEC_ERROR_GENERIC_AVMP_VM_SYMBOL_NOT_FOUND, month, dayOfMonth));
    }

    public static MinguoDate from(TemporalAccessor temporal) {
        return MinguoChronology.INSTANCE.date(temporal);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MinguoDate(LocalDate isoDate) {
        Objects.requireNonNull(isoDate, "isoDate");
        this.isoDate = isoDate;
    }

    @Override // java.time.chrono.ChronoLocalDate
    public MinguoChronology getChronology() {
        return MinguoChronology.INSTANCE;
    }

    @Override // java.time.chrono.ChronoLocalDate
    public MinguoEra getEra() {
        return getProlepticYear() >= 1 ? MinguoEra.ROC : MinguoEra.BEFORE_ROC;
    }

    @Override // java.time.chrono.ChronoLocalDate
    public int lengthOfMonth() {
        return this.isoDate.lengthOfMonth();
    }

    @Override // java.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField field) {
        if (field instanceof ChronoField) {
            if (isSupported(field)) {
                ChronoField f10 = (ChronoField) field;
                switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[f10.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        return this.isoDate.range(field);
                    case 4:
                        ValueRange range = ChronoField.YEAR.range();
                        long max = getProlepticYear() <= 0 ? (-range.getMinimum()) + 1 + 1911 : range.getMaximum() - 1911;
                        return ValueRange.of(1L, max);
                    default:
                        return getChronology().range(f10);
                }
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + ((Object) field));
        }
        return field.rangeRefinedBy(this);
    }

    @Override // java.time.temporal.TemporalAccessor
    public long getLong(TemporalField field) {
        if (field instanceof ChronoField) {
            switch ((ChronoField) field) {
                case YEAR_OF_ERA:
                    int prolepticYear = getProlepticYear();
                    return prolepticYear >= 1 ? prolepticYear : 1 - prolepticYear;
                case PROLEPTIC_MONTH:
                    return getProlepticMonth();
                case YEAR:
                    return getProlepticYear();
                case ERA:
                    return getProlepticYear() < 1 ? 0 : 1;
                default:
                    return this.isoDate.getLong(field);
            }
        }
        return field.getFrom(this);
    }

    private long getProlepticMonth() {
        return ((getProlepticYear() * 12) + this.isoDate.getMonthValue()) - 1;
    }

    private int getProlepticYear() {
        return this.isoDate.getYear() - 1911;
    }

    @Override // java.time.chrono.ChronoLocalDateImpl, java.time.chrono.ChronoLocalDate, java.time.temporal.Temporal
    public MinguoDate with(TemporalField field, long newValue) {
        if (!(field instanceof ChronoField)) {
            return (MinguoDate) super.with(field, newValue);
        }
        ChronoField chronoField = (ChronoField) field;
        if (getLong(chronoField) == newValue) {
            return this;
        }
        switch (chronoField) {
            case YEAR_OF_ERA:
            case YEAR:
            case ERA:
                int nvalue = getChronology().range(chronoField).checkValidIntValue(newValue, chronoField);
                switch (chronoField) {
                    case YEAR_OF_ERA:
                        return with(this.isoDate.withYear(getProlepticYear() >= 1 ? nvalue + SecExceptionCode.SEC_ERROR_GENERIC_AVMP_VM_SYMBOL_NOT_FOUND : (1 - nvalue) + SecExceptionCode.SEC_ERROR_GENERIC_AVMP_VM_SYMBOL_NOT_FOUND));
                    case YEAR:
                        return with(this.isoDate.withYear(nvalue + SecExceptionCode.SEC_ERROR_GENERIC_AVMP_VM_SYMBOL_NOT_FOUND));
                    case ERA:
                        return with(this.isoDate.withYear((1 - getProlepticYear()) + SecExceptionCode.SEC_ERROR_GENERIC_AVMP_VM_SYMBOL_NOT_FOUND));
                }
            case PROLEPTIC_MONTH:
                getChronology().range(chronoField).checkValidValue(newValue, chronoField);
                return plusMonths(newValue - getProlepticMonth());
        }
        return with(this.isoDate.with(field, newValue));
    }

    @Override // java.time.chrono.ChronoLocalDateImpl, java.time.chrono.ChronoLocalDate, java.time.temporal.Temporal
    public MinguoDate with(TemporalAdjuster adjuster) {
        return (MinguoDate) super.with(adjuster);
    }

    @Override // java.time.chrono.ChronoLocalDateImpl, java.time.chrono.ChronoLocalDate, java.time.temporal.Temporal
    public MinguoDate plus(TemporalAmount amount) {
        return (MinguoDate) super.plus(amount);
    }

    @Override // java.time.chrono.ChronoLocalDateImpl, java.time.chrono.ChronoLocalDate, java.time.temporal.Temporal
    public MinguoDate minus(TemporalAmount amount) {
        return (MinguoDate) super.minus(amount);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.time.chrono.ChronoLocalDateImpl
    public MinguoDate plusYears(long years) {
        return with(this.isoDate.plusYears(years));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.time.chrono.ChronoLocalDateImpl
    public MinguoDate plusMonths(long months) {
        return with(this.isoDate.plusMonths(months));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.time.chrono.ChronoLocalDateImpl
    public MinguoDate plusWeeks(long weeksToAdd) {
        return (MinguoDate) super.plusWeeks(weeksToAdd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.time.chrono.ChronoLocalDateImpl
    public MinguoDate plusDays(long days) {
        return with(this.isoDate.plusDays(days));
    }

    @Override // java.time.chrono.ChronoLocalDateImpl, java.time.chrono.ChronoLocalDate, java.time.temporal.Temporal
    public MinguoDate plus(long amountToAdd, TemporalUnit unit) {
        return (MinguoDate) super.plus(amountToAdd, unit);
    }

    @Override // java.time.chrono.ChronoLocalDateImpl, java.time.chrono.ChronoLocalDate, java.time.temporal.Temporal
    public MinguoDate minus(long amountToAdd, TemporalUnit unit) {
        return (MinguoDate) super.minus(amountToAdd, unit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.time.chrono.ChronoLocalDateImpl
    public MinguoDate minusYears(long yearsToSubtract) {
        return (MinguoDate) super.minusYears(yearsToSubtract);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.time.chrono.ChronoLocalDateImpl
    public MinguoDate minusMonths(long monthsToSubtract) {
        return (MinguoDate) super.minusMonths(monthsToSubtract);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.time.chrono.ChronoLocalDateImpl
    public MinguoDate minusWeeks(long weeksToSubtract) {
        return (MinguoDate) super.minusWeeks(weeksToSubtract);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.time.chrono.ChronoLocalDateImpl
    public MinguoDate minusDays(long daysToSubtract) {
        return (MinguoDate) super.minusDays(daysToSubtract);
    }

    private MinguoDate with(LocalDate newDate) {
        return newDate.equals(this.isoDate) ? this : new MinguoDate(newDate);
    }

    @Override // java.time.chrono.ChronoLocalDate
    public final ChronoLocalDateTime<MinguoDate> atTime(LocalTime localTime) {
        return super.atTime(localTime);
    }

    @Override // java.time.chrono.ChronoLocalDate
    public ChronoPeriod until(ChronoLocalDate endDate) {
        Period period = this.isoDate.until(endDate);
        return getChronology().period(period.getYears(), period.getMonths(), period.getDays());
    }

    @Override // java.time.chrono.ChronoLocalDate
    public long toEpochDay() {
        return this.isoDate.toEpochDay();
    }

    @Override // java.time.chrono.ChronoLocalDateImpl, java.time.chrono.ChronoLocalDate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MinguoDate) {
            MinguoDate otherDate = (MinguoDate) obj;
            if (this.isoDate.equals(otherDate.isoDate)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.time.chrono.ChronoLocalDateImpl, java.time.chrono.ChronoLocalDate
    public int hashCode() {
        return getChronology().getId().hashCode() ^ this.isoDate.hashCode();
    }

    private void readObject(ObjectInputStream s2) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput out) throws IOException {
        out.writeInt(get(ChronoField.YEAR));
        out.writeByte(get(ChronoField.MONTH_OF_YEAR));
        out.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MinguoDate readExternal(DataInput in) throws IOException {
        int year = in.readInt();
        int month = in.readByte();
        int dayOfMonth = in.readByte();
        return MinguoChronology.INSTANCE.date(year, month, dayOfMonth);
    }
}
