package java.time.chrono;

import com.nirvana.tools.logger.upload.AbstractACMUploadManager;
import java.io.Serializable;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.time.temporal.ValueRange;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class ChronoLocalDateImpl<D extends ChronoLocalDate> implements ChronoLocalDate, Temporal, TemporalAdjuster, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    abstract D plusDays(long j10);

    abstract D plusMonths(long j10);

    abstract D plusYears(long j10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <D extends ChronoLocalDate> D ensureValid(Chronology chrono, Temporal temporal) {
        D d10 = (D) temporal;
        if (!chrono.equals(d10.getChronology())) {
            throw new ClassCastException("Chronology mismatch, expected: " + chrono.getId() + ", actual: " + d10.getChronology().getId());
        }
        return d10;
    }

    @Override // java.time.chrono.ChronoLocalDate, java.time.temporal.Temporal
    public D with(TemporalAdjuster temporalAdjuster) {
        return (D) super.with(temporalAdjuster);
    }

    @Override // java.time.chrono.ChronoLocalDate, java.time.temporal.Temporal
    public D with(TemporalField temporalField, long j10) {
        return (D) super.with(temporalField, j10);
    }

    @Override // java.time.chrono.ChronoLocalDate, java.time.temporal.Temporal
    public D plus(TemporalAmount temporalAmount) {
        return (D) super.plus(temporalAmount);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.time.chrono.ChronoLocalDateImpl$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoUnit;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            $SwitchMap$java$time$temporal$ChronoUnit = iArr;
            try {
                iArr[ChronoUnit.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.WEEKS.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MONTHS.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.YEARS.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.DECADES.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.CENTURIES.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MILLENNIA.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.ERAS.ordinal()] = 8;
            } catch (NoSuchFieldError e16) {
            }
        }
    }

    @Override // java.time.chrono.ChronoLocalDate, java.time.temporal.Temporal
    public D plus(long j10, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return plusDays(j10);
                case 2:
                    return plusDays(Math.multiplyExact(j10, 7));
                case 3:
                    return plusMonths(j10);
                case 4:
                    return plusYears(j10);
                case 5:
                    return plusYears(Math.multiplyExact(j10, 10));
                case 6:
                    return plusYears(Math.multiplyExact(j10, 100));
                case 7:
                    return plusYears(Math.multiplyExact(j10, 1000));
                case 8:
                    return with((TemporalField) ChronoField.ERA, Math.addExact(getLong(ChronoField.ERA), j10));
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + ((Object) temporalUnit));
            }
        }
        return (D) super.plus(j10, temporalUnit);
    }

    @Override // java.time.chrono.ChronoLocalDate, java.time.temporal.Temporal
    public D minus(TemporalAmount temporalAmount) {
        return (D) super.minus(temporalAmount);
    }

    @Override // java.time.chrono.ChronoLocalDate, java.time.temporal.Temporal
    public D minus(long j10, TemporalUnit temporalUnit) {
        return (D) super.minus(j10, temporalUnit);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public D plusWeeks(long weeksToAdd) {
        return plusDays(Math.multiplyExact(weeksToAdd, 7));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public D minusYears(long j10) {
        return j10 == Long.MIN_VALUE ? (D) ((ChronoLocalDateImpl) plusYears(Long.MAX_VALUE)).plusYears(1L) : plusYears(-j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public D minusMonths(long j10) {
        return j10 == Long.MIN_VALUE ? (D) ((ChronoLocalDateImpl) plusMonths(Long.MAX_VALUE)).plusMonths(1L) : plusMonths(-j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public D minusWeeks(long j10) {
        return j10 == Long.MIN_VALUE ? (D) ((ChronoLocalDateImpl) plusWeeks(Long.MAX_VALUE)).plusWeeks(1L) : plusWeeks(-j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public D minusDays(long j10) {
        return j10 == Long.MIN_VALUE ? (D) ((ChronoLocalDateImpl) plusDays(Long.MAX_VALUE)).plusDays(1L) : plusDays(-j10);
    }

    @Override // java.time.chrono.ChronoLocalDate, java.time.temporal.Temporal
    public long until(Temporal endExclusive, TemporalUnit unit) {
        Objects.requireNonNull(endExclusive, "endExclusive");
        ChronoLocalDate end = getChronology().date(endExclusive);
        if (unit instanceof ChronoUnit) {
            ChronoUnit chronoUnit = (ChronoUnit) unit;
            switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[chronoUnit.ordinal()]) {
                case 1:
                    return daysUntil(end);
                case 2:
                    return daysUntil(end) / 7;
                case 3:
                    return monthsUntil(end);
                case 4:
                    return monthsUntil(end) / 12;
                case 5:
                    return monthsUntil(end) / 120;
                case 6:
                    return monthsUntil(end) / 1200;
                case 7:
                    return monthsUntil(end) / AbstractACMUploadManager.TIME_INTERVAL;
                case 8:
                    return end.getLong(ChronoField.ERA) - getLong(ChronoField.ERA);
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + ((Object) unit));
            }
        }
        Objects.requireNonNull(unit, "unit");
        return unit.between(this, end);
    }

    private long daysUntil(ChronoLocalDate end) {
        return end.toEpochDay() - toEpochDay();
    }

    private long monthsUntil(ChronoLocalDate end) {
        ValueRange range = getChronology().range(ChronoField.MONTH_OF_YEAR);
        if (range.getMaximum() != 12) {
            throw new IllegalStateException("ChronoLocalDateImpl only supports Chronologies with 12 months per year");
        }
        long packed1 = (getLong(ChronoField.PROLEPTIC_MONTH) * 32) + get(ChronoField.DAY_OF_MONTH);
        long packed2 = (end.getLong(ChronoField.PROLEPTIC_MONTH) * 32) + end.get(ChronoField.DAY_OF_MONTH);
        return (packed2 - packed1) / 32;
    }

    @Override // java.time.chrono.ChronoLocalDate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoLocalDate) && compareTo((ChronoLocalDate) obj) == 0;
    }

    @Override // java.time.chrono.ChronoLocalDate
    public int hashCode() {
        long epDay = toEpochDay();
        return getChronology().hashCode() ^ ((int) ((epDay >>> 32) ^ epDay));
    }

    @Override // java.time.chrono.ChronoLocalDate
    public String toString() {
        long yoe = getLong(ChronoField.YEAR_OF_ERA);
        long moy = getLong(ChronoField.MONTH_OF_YEAR);
        long dom = getLong(ChronoField.DAY_OF_MONTH);
        StringBuilder buf = new StringBuilder(30);
        buf.append(getChronology().toString()).append(" ").append((Object) getEra()).append(" ").append(yoe).append(moy < 10 ? "-0" : "-").append(moy).append(dom >= 10 ? "-" : "-0").append(dom);
        return buf.toString();
    }
}
