package java.time.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.time.temporal.ValueRange;
import java.util.List;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ChronoPeriodImpl implements ChronoPeriod, Serializable {
    private static final List<TemporalUnit> SUPPORTED_UNITS = List.of(ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS);
    private static final long serialVersionUID = 57387258289L;
    private final Chronology chrono;
    final int days;
    final int months;
    final int years;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChronoPeriodImpl(Chronology chrono, int years, int months, int days) {
        Objects.requireNonNull(chrono, "chrono");
        this.chrono = chrono;
        this.years = years;
        this.months = months;
        this.days = days;
    }

    @Override // java.time.chrono.ChronoPeriod, java.time.temporal.TemporalAmount
    public long get(TemporalUnit unit) {
        if (unit == ChronoUnit.YEARS) {
            return this.years;
        }
        if (unit == ChronoUnit.MONTHS) {
            return this.months;
        }
        if (unit == ChronoUnit.DAYS) {
            return this.days;
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + ((Object) unit));
    }

    @Override // java.time.chrono.ChronoPeriod, java.time.temporal.TemporalAmount
    public List<TemporalUnit> getUnits() {
        return SUPPORTED_UNITS;
    }

    @Override // java.time.chrono.ChronoPeriod
    public Chronology getChronology() {
        return this.chrono;
    }

    @Override // java.time.chrono.ChronoPeriod
    public boolean isZero() {
        return this.years == 0 && this.months == 0 && this.days == 0;
    }

    @Override // java.time.chrono.ChronoPeriod
    public boolean isNegative() {
        return this.years < 0 || this.months < 0 || this.days < 0;
    }

    @Override // java.time.chrono.ChronoPeriod
    public ChronoPeriod plus(TemporalAmount amountToAdd) {
        ChronoPeriodImpl amount = validateAmount(amountToAdd);
        return new ChronoPeriodImpl(this.chrono, Math.addExact(this.years, amount.years), Math.addExact(this.months, amount.months), Math.addExact(this.days, amount.days));
    }

    @Override // java.time.chrono.ChronoPeriod
    public ChronoPeriod minus(TemporalAmount amountToSubtract) {
        ChronoPeriodImpl amount = validateAmount(amountToSubtract);
        return new ChronoPeriodImpl(this.chrono, Math.subtractExact(this.years, amount.years), Math.subtractExact(this.months, amount.months), Math.subtractExact(this.days, amount.days));
    }

    private ChronoPeriodImpl validateAmount(TemporalAmount amount) {
        Objects.requireNonNull(amount, "amount");
        if (!(amount instanceof ChronoPeriodImpl)) {
            throw new DateTimeException("Unable to obtain ChronoPeriod from TemporalAmount: " + ((Object) amount.getClass()));
        }
        ChronoPeriodImpl period = (ChronoPeriodImpl) amount;
        if (!this.chrono.equals(period.getChronology())) {
            throw new ClassCastException("Chronology mismatch, expected: " + this.chrono.getId() + ", actual: " + period.getChronology().getId());
        }
        return period;
    }

    @Override // java.time.chrono.ChronoPeriod
    public ChronoPeriod multipliedBy(int scalar) {
        if (isZero() || scalar == 1) {
            return this;
        }
        return new ChronoPeriodImpl(this.chrono, Math.multiplyExact(this.years, scalar), Math.multiplyExact(this.months, scalar), Math.multiplyExact(this.days, scalar));
    }

    @Override // java.time.chrono.ChronoPeriod
    public ChronoPeriod normalized() {
        long monthRange = monthRange();
        if (monthRange > 0) {
            int i10 = this.years;
            int i11 = this.months;
            long totalMonths = (i10 * monthRange) + i11;
            long splitYears = totalMonths / monthRange;
            int splitMonths = (int) (totalMonths % monthRange);
            if (splitYears == i10 && splitMonths == i11) {
                return this;
            }
            return new ChronoPeriodImpl(this.chrono, Math.toIntExact(splitYears), splitMonths, this.days);
        }
        return this;
    }

    private long monthRange() {
        ValueRange startRange = this.chrono.range(ChronoField.MONTH_OF_YEAR);
        if (startRange.isFixed() && startRange.isIntValue()) {
            return (startRange.getMaximum() - startRange.getMinimum()) + 1;
        }
        return -1L;
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
            long monthRange = monthRange();
            if (monthRange > 0) {
                temporal = temporal.plus((this.years * monthRange) + this.months, ChronoUnit.MONTHS);
            } else {
                int i11 = this.years;
                if (i11 != 0) {
                    temporal = temporal.plus(i11, ChronoUnit.YEARS);
                }
                temporal = temporal.plus(this.months, ChronoUnit.MONTHS);
            }
        }
        int i12 = this.days;
        if (i12 != 0) {
            return temporal.plus(i12, ChronoUnit.DAYS);
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
            long monthRange = monthRange();
            if (monthRange > 0) {
                temporal = temporal.minus((this.years * monthRange) + this.months, ChronoUnit.MONTHS);
            } else {
                int i11 = this.years;
                if (i11 != 0) {
                    temporal = temporal.minus(i11, ChronoUnit.YEARS);
                }
                temporal = temporal.minus(this.months, ChronoUnit.MONTHS);
            }
        }
        int i12 = this.days;
        if (i12 != 0) {
            return temporal.minus(i12, ChronoUnit.DAYS);
        }
        return temporal;
    }

    private void validateChrono(TemporalAccessor temporal) {
        Objects.requireNonNull(temporal, "temporal");
        Chronology temporalChrono = (Chronology) temporal.query(TemporalQueries.chronology());
        if (temporalChrono != null && !this.chrono.equals(temporalChrono)) {
            throw new DateTimeException("Chronology mismatch, expected: " + this.chrono.getId() + ", actual: " + temporalChrono.getId());
        }
    }

    @Override // java.time.chrono.ChronoPeriod
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChronoPeriodImpl) {
            ChronoPeriodImpl other = (ChronoPeriodImpl) obj;
            if (this.years == other.years && this.months == other.months && this.days == other.days && this.chrono.equals(other.chrono)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.time.chrono.ChronoPeriod
    public int hashCode() {
        return ((this.years + Integer.rotateLeft(this.months, 8)) + Integer.rotateLeft(this.days, 16)) ^ this.chrono.hashCode();
    }

    @Override // java.time.chrono.ChronoPeriod
    public String toString() {
        if (isZero()) {
            return getChronology().toString() + " P0D";
        }
        StringBuilder buf = new StringBuilder();
        buf.append(getChronology().toString()).append(' ').append('P');
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

    protected Object writeReplace() {
        return new Ser((byte) 9, this);
    }

    private void readObject(ObjectInputStream s2) throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput out) throws IOException {
        out.writeUTF(this.chrono.getId());
        out.writeInt(this.years);
        out.writeInt(this.months);
        out.writeInt(this.days);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ChronoPeriodImpl readExternal(DataInput in) throws IOException {
        Chronology chrono = Chronology.of(in.readUTF());
        int years = in.readInt();
        int months = in.readInt();
        int days = in.readInt();
        return new ChronoPeriodImpl(chrono, years, months, days);
    }
}
