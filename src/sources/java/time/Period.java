package java.time;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.chrono.Chronology;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Period implements ChronoPeriod, Serializable {
    private static final long serialVersionUID = -3587258372562876L;
    private final int days;
    private final int months;
    private final int years;
    public static final Period ZERO = new Period(0, 0, 0);
    private static final Pattern PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
    private static final List<TemporalUnit> SUPPORTED_UNITS = List.of(ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS);

    public static Period ofYears(int years) {
        return create(years, 0, 0);
    }

    public static Period ofMonths(int months) {
        return create(0, months, 0);
    }

    public static Period ofWeeks(int weeks) {
        return create(0, 0, Math.multiplyExact(weeks, 7));
    }

    public static Period ofDays(int days) {
        return create(0, 0, days);
    }

    public static Period of(int years, int months, int days) {
        return create(years, months, days);
    }

    public static Period from(TemporalAmount amount) {
        if (amount instanceof Period) {
            return (Period) amount;
        }
        if ((amount instanceof ChronoPeriod) && !IsoChronology.INSTANCE.equals(((ChronoPeriod) amount).getChronology())) {
            throw new DateTimeException("Period requires ISO chronology: " + ((Object) amount));
        }
        Objects.requireNonNull(amount, "amount");
        int years = 0;
        int months = 0;
        int days = 0;
        for (TemporalUnit unit : amount.getUnits()) {
            long unitAmount = amount.get(unit);
            if (unit == ChronoUnit.YEARS) {
                years = Math.toIntExact(unitAmount);
            } else if (unit == ChronoUnit.MONTHS) {
                months = Math.toIntExact(unitAmount);
            } else if (unit == ChronoUnit.DAYS) {
                days = Math.toIntExact(unitAmount);
            } else {
                throw new DateTimeException("Unit must be Years, Months or Days, but was " + ((Object) unit));
            }
        }
        return create(years, months, days);
    }

    public static Period parse(CharSequence text) {
        int i10;
        int years;
        int months;
        int weeks;
        int days;
        Objects.requireNonNull(text, "text");
        Matcher matcher = PATTERN.matcher(text);
        if (matcher.matches()) {
            int negate = charMatch(text, matcher.start(1), matcher.end(1), '-') ? -1 : 1;
            int yearStart = matcher.start(2);
            int yearEnd = matcher.end(2);
            int monthStart = matcher.start(3);
            int monthEnd = matcher.end(3);
            int weekStart = matcher.start(4);
            int weekEnd = matcher.end(4);
            int dayStart = matcher.start(5);
            int dayEnd = matcher.end(5);
            if (yearStart >= 0 || monthStart >= 0 || weekStart >= 0 || dayStart >= 0) {
                try {
                    years = parseNumber(text, yearStart, yearEnd, negate);
                    months = parseNumber(text, monthStart, monthEnd, negate);
                    weeks = parseNumber(text, weekStart, weekEnd, negate);
                    days = parseNumber(text, dayStart, dayEnd, negate);
                } catch (NumberFormatException e2) {
                    ex = e2;
                }
                try {
                    return create(years, months, Math.addExact(days, Math.multiplyExact(weeks, 7)));
                } catch (NumberFormatException e10) {
                    ex = e10;
                    throw new DateTimeParseException("Text cannot be parsed to a Period", text, 0, ex);
                }
            }
            i10 = 0;
        } else {
            i10 = 0;
        }
        throw new DateTimeParseException("Text cannot be parsed to a Period", text, i10);
    }

    private static boolean charMatch(CharSequence text, int start, int end, char c4) {
        return start >= 0 && end == start + 1 && text.charAt(start) == c4;
    }

    private static int parseNumber(CharSequence text, int start, int end, int negate) {
        if (start < 0 || end < 0) {
            return 0;
        }
        int val = Integer.parseInt(text, start, end, 10);
        try {
            return Math.multiplyExact(val, negate);
        } catch (ArithmeticException ex) {
            throw new DateTimeParseException("Text cannot be parsed to a Period", text, 0, ex);
        }
    }

    public static Period between(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        return startDateInclusive.until((ChronoLocalDate) endDateExclusive);
    }

    private static Period create(int years, int months, int days) {
        if ((years | months | days) == 0) {
            return ZERO;
        }
        return new Period(years, months, days);
    }

    private Period(int years, int months, int days) {
        this.years = years;
        this.months = months;
        this.days = days;
    }

    @Override // java.time.chrono.ChronoPeriod, java.time.temporal.TemporalAmount
    public long get(TemporalUnit unit) {
        if (unit == ChronoUnit.YEARS) {
            return getYears();
        }
        if (unit == ChronoUnit.MONTHS) {
            return getMonths();
        }
        if (unit == ChronoUnit.DAYS) {
            return getDays();
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + ((Object) unit));
    }

    @Override // java.time.chrono.ChronoPeriod, java.time.temporal.TemporalAmount
    public List<TemporalUnit> getUnits() {
        return SUPPORTED_UNITS;
    }

    @Override // java.time.chrono.ChronoPeriod
    public IsoChronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    @Override // java.time.chrono.ChronoPeriod
    public boolean isZero() {
        return this == ZERO;
    }

    @Override // java.time.chrono.ChronoPeriod
    public boolean isNegative() {
        return this.years < 0 || this.months < 0 || this.days < 0;
    }

    public int getYears() {
        return this.years;
    }

    public int getMonths() {
        return this.months;
    }

    public int getDays() {
        return this.days;
    }

    public Period withYears(int years) {
        if (years == this.years) {
            return this;
        }
        return create(years, this.months, this.days);
    }

    public Period withMonths(int months) {
        if (months == this.months) {
            return this;
        }
        return create(this.years, months, this.days);
    }

    public Period withDays(int days) {
        if (days == this.days) {
            return this;
        }
        return create(this.years, this.months, days);
    }

    @Override // java.time.chrono.ChronoPeriod
    public Period plus(TemporalAmount amountToAdd) {
        Period isoAmount = from(amountToAdd);
        return create(Math.addExact(this.years, isoAmount.years), Math.addExact(this.months, isoAmount.months), Math.addExact(this.days, isoAmount.days));
    }

    public Period plusYears(long yearsToAdd) {
        if (yearsToAdd == 0) {
            return this;
        }
        return create(Math.toIntExact(Math.addExact(this.years, yearsToAdd)), this.months, this.days);
    }

    public Period plusMonths(long monthsToAdd) {
        if (monthsToAdd == 0) {
            return this;
        }
        return create(this.years, Math.toIntExact(Math.addExact(this.months, monthsToAdd)), this.days);
    }

    public Period plusDays(long daysToAdd) {
        if (daysToAdd == 0) {
            return this;
        }
        return create(this.years, this.months, Math.toIntExact(Math.addExact(this.days, daysToAdd)));
    }

    @Override // java.time.chrono.ChronoPeriod
    public Period minus(TemporalAmount amountToSubtract) {
        Period isoAmount = from(amountToSubtract);
        return create(Math.subtractExact(this.years, isoAmount.years), Math.subtractExact(this.months, isoAmount.months), Math.subtractExact(this.days, isoAmount.days));
    }

    public Period minusYears(long yearsToSubtract) {
        return yearsToSubtract == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1L) : plusYears(-yearsToSubtract);
    }

    public Period minusMonths(long monthsToSubtract) {
        return monthsToSubtract == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1L) : plusMonths(-monthsToSubtract);
    }

    public Period minusDays(long daysToSubtract) {
        return daysToSubtract == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-daysToSubtract);
    }

    @Override // java.time.chrono.ChronoPeriod
    public Period multipliedBy(int scalar) {
        if (this == ZERO || scalar == 1) {
            return this;
        }
        return create(Math.multiplyExact(this.years, scalar), Math.multiplyExact(this.months, scalar), Math.multiplyExact(this.days, scalar));
    }

    @Override // java.time.chrono.ChronoPeriod
    public Period negated() {
        return multipliedBy(-1);
    }

    @Override // java.time.chrono.ChronoPeriod
    public Period normalized() {
        long totalMonths = toTotalMonths();
        long splitYears = totalMonths / 12;
        int splitMonths = (int) (totalMonths % 12);
        if (splitYears == this.years && splitMonths == this.months) {
            return this;
        }
        return create(Math.toIntExact(splitYears), splitMonths, this.days);
    }

    public long toTotalMonths() {
        return (this.years * 12) + this.months;
    }

    @Override // java.time.chrono.ChronoPeriod, java.time.temporal.TemporalAmount
    public Temporal addTo(Temporal temporal) {
        validateChrono(temporal);
        if (this.months == 0) {
            int i10 = this.years;
            if (i10 != 0) {
                temporal = temporal.plus(i10, ChronoUnit.YEARS);
            }
        } else {
            long totalMonths = toTotalMonths();
            if (totalMonths != 0) {
                temporal = temporal.plus(totalMonths, ChronoUnit.MONTHS);
            }
        }
        int i11 = this.days;
        if (i11 != 0) {
            return temporal.plus(i11, ChronoUnit.DAYS);
        }
        return temporal;
    }

    @Override // java.time.chrono.ChronoPeriod, java.time.temporal.TemporalAmount
    public Temporal subtractFrom(Temporal temporal) {
        validateChrono(temporal);
        if (this.months == 0) {
            int i10 = this.years;
            if (i10 != 0) {
                temporal = temporal.minus(i10, ChronoUnit.YEARS);
            }
        } else {
            long totalMonths = toTotalMonths();
            if (totalMonths != 0) {
                temporal = temporal.minus(totalMonths, ChronoUnit.MONTHS);
            }
        }
        int i11 = this.days;
        if (i11 != 0) {
            return temporal.minus(i11, ChronoUnit.DAYS);
        }
        return temporal;
    }

    private void validateChrono(TemporalAccessor temporal) {
        Objects.requireNonNull(temporal, "temporal");
        Chronology temporalChrono = (Chronology) temporal.query(TemporalQueries.chronology());
        if (temporalChrono != null && !IsoChronology.INSTANCE.equals(temporalChrono)) {
            throw new DateTimeException("Chronology mismatch, expected: ISO, actual: " + temporalChrono.getId());
        }
    }

    @Override // java.time.chrono.ChronoPeriod
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Period) {
            Period other = (Period) obj;
            if (this.years == other.years && this.months == other.months && this.days == other.days) {
                return true;
            }
        }
        return false;
    }

    @Override // java.time.chrono.ChronoPeriod
    public int hashCode() {
        return this.years + Integer.rotateLeft(this.months, 8) + Integer.rotateLeft(this.days, 16);
    }

    @Override // java.time.chrono.ChronoPeriod
    public String toString() {
        if (this == ZERO) {
            return "P0D";
        }
        StringBuilder buf = new StringBuilder();
        buf.append('P');
        int i10 = this.years;
        if (i10 != 0) {
            buf.append(i10).append('Y');
        }
        int i11 = this.months;
        if (i11 != 0) {
            buf.append(i11).append('M');
        }
        int i12 = this.days;
        if (i12 != 0) {
            buf.append(i12).append('D');
        }
        return buf.toString();
    }

    private Object writeReplace() {
        return new Ser((byte) 14, this);
    }

    private void readObject(ObjectInputStream s2) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput out) throws IOException {
        out.writeInt(this.years);
        out.writeInt(this.months);
        out.writeInt(this.days);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Period readExternal(DataInput in) throws IOException {
        int years = in.readInt();
        int months = in.readInt();
        int days = in.readInt();
        return of(years, months, days);
    }
}
