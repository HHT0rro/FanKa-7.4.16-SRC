package java.time;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.quickcard.base.Attributes;
import com.nirvana.tools.logger.upload.AbstractACMUploadManager;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Era;
import java.time.chrono.IsoChronology;
import java.time.chrono.IsoEra;
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
import java.time.temporal.UnsupportedTemporalTypeException;
import java.time.temporal.ValueRange;
import java.time.zone.ZoneOffsetTransition;
import java.time.zone.ZoneRules;
import java.util.Objects;
import java.util.function.LongFunction;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class LocalDate implements Temporal, TemporalAdjuster, ChronoLocalDate, Serializable {
    static final long DAYS_0000_TO_1970 = 719528;
    private static final int DAYS_PER_CYCLE = 146097;
    private static final long serialVersionUID = 2942565459149668126L;
    private final short day;
    private final short month;
    private final int year;
    public static final LocalDate MIN = of(Year.MIN_VALUE, 1, 1);
    public static final LocalDate MAX = of(Year.MAX_VALUE, 12, 31);
    public static final LocalDate EPOCH = of(1970, 1, 1);

    @Override // java.time.chrono.ChronoLocalDate
    public /* bridge */ /* synthetic */ IsoEra getEra() {
        return (IsoEra) getEra();
    }

    public static LocalDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalDate now(ZoneId zone) {
        return now(Clock.system(zone));
    }

    public static LocalDate now(Clock clock) {
        Objects.requireNonNull(clock, "clock");
        Instant now = clock.instant();
        return ofInstant(now, clock.getZone());
    }

    public static LocalDate of(int year, Month month, int dayOfMonth) {
        ChronoField.YEAR.checkValidValue(year);
        Objects.requireNonNull(month, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue(dayOfMonth);
        return create(year, month.getValue(), dayOfMonth);
    }

    public static LocalDate of(int year, int month, int dayOfMonth) {
        ChronoField.YEAR.checkValidValue(year);
        ChronoField.MONTH_OF_YEAR.checkValidValue(month);
        ChronoField.DAY_OF_MONTH.checkValidValue(dayOfMonth);
        return create(year, month, dayOfMonth);
    }

    public static LocalDate ofYearDay(int year, int dayOfYear) {
        ChronoField.YEAR.checkValidValue(year);
        ChronoField.DAY_OF_YEAR.checkValidValue(dayOfYear);
        boolean leap = IsoChronology.INSTANCE.isLeapYear(year);
        if (dayOfYear == 366 && !leap) {
            throw new DateTimeException("Invalid date 'DayOfYear 366' as '" + year + "' is not a leap year");
        }
        Month moy = Month.of(((dayOfYear - 1) / 31) + 1);
        int monthEnd = (moy.firstDayOfYear(leap) + moy.length(leap)) - 1;
        if (dayOfYear > monthEnd) {
            moy = moy.plus(1L);
        }
        int dom = (dayOfYear - moy.firstDayOfYear(leap)) + 1;
        return new LocalDate(year, moy.getValue(), dom);
    }

    public static LocalDate ofInstant(Instant instant, ZoneId zone) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zone, "zone");
        ZoneRules rules = zone.getRules();
        ZoneOffset offset = rules.getOffset(instant);
        long localSecond = instant.getEpochSecond() + offset.getTotalSeconds();
        long localEpochDay = Math.floorDiv(localSecond, RemoteMessageConst.DEFAULT_TTL);
        return ofEpochDay(localEpochDay);
    }

    public static LocalDate ofEpochDay(long epochDay) {
        ChronoField.EPOCH_DAY.checkValidValue(epochDay);
        long zeroDay = (DAYS_0000_TO_1970 + epochDay) - 60;
        long adjust = 0;
        if (zeroDay < 0) {
            long adjustCycles = ((zeroDay + 1) / 146097) - 1;
            adjust = adjustCycles * 400;
            zeroDay += (-adjustCycles) * 146097;
        }
        long yearEst = ((zeroDay * 400) + 591) / 146097;
        long doyEst = zeroDay - ((((yearEst * 365) + (yearEst / 4)) - (yearEst / 100)) + (yearEst / 400));
        if (doyEst < 0) {
            yearEst--;
            doyEst = zeroDay - ((((365 * yearEst) + (yearEst / 4)) - (yearEst / 100)) + (yearEst / 400));
        }
        int marchDoy0 = (int) doyEst;
        int marchMonth0 = ((marchDoy0 * 5) + 2) / 153;
        int month = ((marchMonth0 + 2) % 12) + 1;
        int dom = (marchDoy0 - (((marchMonth0 * 306) + 5) / 10)) + 1;
        int year = ChronoField.YEAR.checkValidIntValue(yearEst + adjust + (marchMonth0 / 10));
        return new LocalDate(year, month, dom);
    }

    public static LocalDate from(TemporalAccessor temporal) {
        Objects.requireNonNull(temporal, "temporal");
        LocalDate date = (LocalDate) temporal.query(TemporalQueries.localDate());
        if (date == null) {
            throw new DateTimeException("Unable to obtain LocalDate from TemporalAccessor: " + ((Object) temporal) + " of type " + temporal.getClass().getName());
        }
        return date;
    }

    public static LocalDate parse(CharSequence text) {
        return parse(text, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static LocalDate parse(CharSequence text, DateTimeFormatter formatter) {
        Objects.requireNonNull(formatter, "formatter");
        return (LocalDate) formatter.parse(text, new TemporalQuery() { // from class: java.time.LocalDate$$ExternalSyntheticLambda3
            @Override // java.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                return LocalDate.from(temporalAccessor);
            }
        });
    }

    private static LocalDate create(int year, int month, int dayOfMonth) {
        int i10 = 28;
        if (dayOfMonth > 28) {
            int dom = 31;
            switch (month) {
                case 2:
                    if (IsoChronology.INSTANCE.isLeapYear(year)) {
                        i10 = 29;
                    }
                    dom = i10;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    dom = 30;
                    break;
            }
            if (dayOfMonth > dom) {
                if (dayOfMonth == 29) {
                    throw new DateTimeException("Invalid date 'February 29' as '" + year + "' is not a leap year");
                }
                throw new DateTimeException("Invalid date '" + Month.of(month).name() + " " + dayOfMonth + "'");
            }
        }
        return new LocalDate(year, month, dayOfMonth);
    }

    private static LocalDate resolvePreviousValid(int year, int month, int day) {
        switch (month) {
            case 2:
                day = Math.min(day, IsoChronology.INSTANCE.isLeapYear((long) year) ? 29 : 28);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = Math.min(day, 30);
                break;
        }
        return new LocalDate(year, month, day);
    }

    private LocalDate(int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = (short) month;
        this.day = (short) dayOfMonth;
    }

    @Override // java.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField field) {
        return super.isSupported(field);
    }

    @Override // java.time.temporal.Temporal
    public boolean isSupported(TemporalUnit unit) {
        return super.isSupported(unit);
    }

    @Override // java.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField field) {
        if (field instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) field;
            if (chronoField.isDateBased()) {
                switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[chronoField.ordinal()]) {
                    case 1:
                        return ValueRange.of(1L, lengthOfMonth());
                    case 2:
                        return ValueRange.of(1L, lengthOfYear());
                    case 3:
                        return ValueRange.of(1L, (getMonth() != Month.FEBRUARY || isLeapYear()) ? 5L : 4L);
                    case 4:
                        return ValueRange.of(1L, getYear() <= 0 ? 1000000000L : 999999999L);
                    default:
                        return field.range();
                }
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + ((Object) field));
        }
        return field.rangeRefinedBy(this);
    }

    @Override // java.time.temporal.TemporalAccessor
    public int get(TemporalField field) {
        if (field instanceof ChronoField) {
            return get0(field);
        }
        return super.get(field);
    }

    @Override // java.time.temporal.TemporalAccessor
    public long getLong(TemporalField field) {
        if (field instanceof ChronoField) {
            if (field == ChronoField.EPOCH_DAY) {
                return toEpochDay();
            }
            if (field == ChronoField.PROLEPTIC_MONTH) {
                return getProlepticMonth();
            }
            return get0(field);
        }
        return field.getFrom(this);
    }

    private int get0(TemporalField field) {
        switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[((ChronoField) field).ordinal()]) {
            case 1:
                return this.day;
            case 2:
                return getDayOfYear();
            case 3:
                return ((this.day - 1) / 7) + 1;
            case 4:
                int i10 = this.year;
                return i10 >= 1 ? i10 : 1 - i10;
            case 5:
                return getDayOfWeek().getValue();
            case 6:
                return ((this.day - 1) % 7) + 1;
            case 7:
                return ((getDayOfYear() - 1) % 7) + 1;
            case 8:
                throw new UnsupportedTemporalTypeException("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((getDayOfYear() - 1) / 7) + 1;
            case 10:
                return this.month;
            case 11:
                throw new UnsupportedTemporalTypeException("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return this.year;
            case 13:
                return this.year >= 1 ? 1 : 0;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + ((Object) field));
        }
    }

    private long getProlepticMonth() {
        return ((this.year * 12) + this.month) - 1;
    }

    @Override // java.time.chrono.ChronoLocalDate
    public IsoChronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    @Override // java.time.chrono.ChronoLocalDate
    public Era getEra() {
        return getYear() >= 1 ? IsoEra.CE : IsoEra.BCE;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonthValue() {
        return this.month;
    }

    public Month getMonth() {
        return Month.of(this.month);
    }

    public int getDayOfMonth() {
        return this.day;
    }

    public int getDayOfYear() {
        return (getMonth().firstDayOfYear(isLeapYear()) + this.day) - 1;
    }

    public DayOfWeek getDayOfWeek() {
        int dow0 = Math.floorMod(toEpochDay() + 3, 7);
        return DayOfWeek.of(dow0 + 1);
    }

    @Override // java.time.chrono.ChronoLocalDate
    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear(this.year);
    }

    @Override // java.time.chrono.ChronoLocalDate
    public int lengthOfMonth() {
        switch (this.month) {
            case 2:
                return isLeapYear() ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    @Override // java.time.chrono.ChronoLocalDate
    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    @Override // java.time.temporal.Temporal
    public LocalDate with(TemporalAdjuster adjuster) {
        if (adjuster instanceof LocalDate) {
            return (LocalDate) adjuster;
        }
        return (LocalDate) adjuster.adjustInto(this);
    }

    @Override // java.time.temporal.Temporal
    public LocalDate with(TemporalField field, long newValue) {
        if (field instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) field;
            chronoField.checkValidValue(newValue);
            switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[chronoField.ordinal()]) {
                case 1:
                    return withDayOfMonth((int) newValue);
                case 2:
                    return withDayOfYear((int) newValue);
                case 3:
                    return plusWeeks(newValue - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH));
                case 4:
                    return withYear((int) (this.year >= 1 ? newValue : 1 - newValue));
                case 5:
                    return plusDays(newValue - getDayOfWeek().getValue());
                case 6:
                    return plusDays(newValue - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
                case 7:
                    return plusDays(newValue - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
                case 8:
                    return ofEpochDay(newValue);
                case 9:
                    return plusWeeks(newValue - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR));
                case 10:
                    return withMonth((int) newValue);
                case 11:
                    return plusMonths(newValue - getProlepticMonth());
                case 12:
                    return withYear((int) newValue);
                case 13:
                    return getLong(ChronoField.ERA) == newValue ? this : withYear(1 - this.year);
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported field: " + ((Object) field));
            }
        }
        return (LocalDate) field.adjustInto(this, newValue);
    }

    public LocalDate withYear(int year) {
        if (this.year == year) {
            return this;
        }
        ChronoField.YEAR.checkValidValue(year);
        return resolvePreviousValid(year, this.month, this.day);
    }

    public LocalDate withMonth(int month) {
        if (this.month == month) {
            return this;
        }
        ChronoField.MONTH_OF_YEAR.checkValidValue(month);
        return resolvePreviousValid(this.year, month, this.day);
    }

    public LocalDate withDayOfMonth(int dayOfMonth) {
        if (this.day == dayOfMonth) {
            return this;
        }
        return of(this.year, this.month, dayOfMonth);
    }

    public LocalDate withDayOfYear(int dayOfYear) {
        if (getDayOfYear() == dayOfYear) {
            return this;
        }
        return ofYearDay(this.year, dayOfYear);
    }

    @Override // java.time.temporal.Temporal
    public LocalDate plus(TemporalAmount amountToAdd) {
        if (amountToAdd instanceof Period) {
            Period periodToAdd = (Period) amountToAdd;
            return plusMonths(periodToAdd.toTotalMonths()).plusDays(periodToAdd.getDays());
        }
        Objects.requireNonNull(amountToAdd, "amountToAdd");
        return (LocalDate) amountToAdd.addTo(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.time.LocalDate$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoField;
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
            int[] iArr2 = new int[ChronoField.values().length];
            $SwitchMap$java$time$temporal$ChronoField = iArr2;
            try {
                iArr2[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.DAY_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 4;
            } catch (NoSuchFieldError e20) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.DAY_OF_WEEK.ordinal()] = 5;
            } catch (NoSuchFieldError e21) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 6;
            } catch (NoSuchFieldError e22) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 7;
            } catch (NoSuchFieldError e23) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.EPOCH_DAY.ordinal()] = 8;
            } catch (NoSuchFieldError e24) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 9;
            } catch (NoSuchFieldError e25) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.MONTH_OF_YEAR.ordinal()] = 10;
            } catch (NoSuchFieldError e26) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.PROLEPTIC_MONTH.ordinal()] = 11;
            } catch (NoSuchFieldError e27) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 12;
            } catch (NoSuchFieldError e28) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.ERA.ordinal()] = 13;
            } catch (NoSuchFieldError e29) {
            }
        }
    }

    @Override // java.time.temporal.Temporal
    public LocalDate plus(long amountToAdd, TemporalUnit unit) {
        if (unit instanceof ChronoUnit) {
            ChronoUnit chronoUnit = (ChronoUnit) unit;
            switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[chronoUnit.ordinal()]) {
                case 1:
                    return plusDays(amountToAdd);
                case 2:
                    return plusWeeks(amountToAdd);
                case 3:
                    return plusMonths(amountToAdd);
                case 4:
                    return plusYears(amountToAdd);
                case 5:
                    return plusYears(Math.multiplyExact(amountToAdd, 10));
                case 6:
                    return plusYears(Math.multiplyExact(amountToAdd, 100));
                case 7:
                    return plusYears(Math.multiplyExact(amountToAdd, 1000));
                case 8:
                    return with((TemporalField) ChronoField.ERA, Math.addExact(getLong(ChronoField.ERA), amountToAdd));
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + ((Object) unit));
            }
        }
        return (LocalDate) unit.addTo(this, amountToAdd);
    }

    public LocalDate plusYears(long yearsToAdd) {
        if (yearsToAdd == 0) {
            return this;
        }
        int newYear = ChronoField.YEAR.checkValidIntValue(this.year + yearsToAdd);
        return resolvePreviousValid(newYear, this.month, this.day);
    }

    public LocalDate plusMonths(long monthsToAdd) {
        if (monthsToAdd == 0) {
            return this;
        }
        long monthCount = (this.year * 12) + (this.month - 1);
        long calcMonths = monthCount + monthsToAdd;
        int newYear = ChronoField.YEAR.checkValidIntValue(Math.floorDiv(calcMonths, 12));
        int newMonth = Math.floorMod(calcMonths, 12) + 1;
        return resolvePreviousValid(newYear, newMonth, this.day);
    }

    public LocalDate plusWeeks(long weeksToAdd) {
        return plusDays(Math.multiplyExact(weeksToAdd, 7));
    }

    public LocalDate plusDays(long daysToAdd) {
        if (daysToAdd == 0) {
            return this;
        }
        long dom = this.day + daysToAdd;
        if (dom > 0) {
            if (dom <= 28) {
                return new LocalDate(this.year, this.month, (int) dom);
            }
            if (dom <= 59) {
                long monthLen = lengthOfMonth();
                if (dom <= monthLen) {
                    return new LocalDate(this.year, this.month, (int) dom);
                }
                short s2 = this.month;
                if (s2 < 12) {
                    return new LocalDate(this.year, s2 + 1, (int) (dom - monthLen));
                }
                ChronoField.YEAR.checkValidValue(this.year + 1);
                return new LocalDate(this.year + 1, 1, (int) (dom - monthLen));
            }
        }
        long mjDay = Math.addExact(toEpochDay(), daysToAdd);
        return ofEpochDay(mjDay);
    }

    @Override // java.time.temporal.Temporal
    public LocalDate minus(TemporalAmount amountToSubtract) {
        if (amountToSubtract instanceof Period) {
            Period periodToSubtract = (Period) amountToSubtract;
            return minusMonths(periodToSubtract.toTotalMonths()).minusDays(periodToSubtract.getDays());
        }
        Objects.requireNonNull(amountToSubtract, "amountToSubtract");
        return (LocalDate) amountToSubtract.subtractFrom(this);
    }

    @Override // java.time.temporal.Temporal
    public LocalDate minus(long amountToSubtract, TemporalUnit unit) {
        return amountToSubtract == Long.MIN_VALUE ? plus(Long.MAX_VALUE, unit).plus(1L, unit) : plus(-amountToSubtract, unit);
    }

    public LocalDate minusYears(long yearsToSubtract) {
        return yearsToSubtract == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1L) : plusYears(-yearsToSubtract);
    }

    public LocalDate minusMonths(long monthsToSubtract) {
        return monthsToSubtract == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1L) : plusMonths(-monthsToSubtract);
    }

    public LocalDate minusWeeks(long weeksToSubtract) {
        return weeksToSubtract == Long.MIN_VALUE ? plusWeeks(Long.MAX_VALUE).plusWeeks(1L) : plusWeeks(-weeksToSubtract);
    }

    public LocalDate minusDays(long daysToSubtract) {
        return daysToSubtract == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-daysToSubtract);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.time.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.localDate()) {
            return this;
        }
        return (R) super.query(temporalQuery);
    }

    @Override // java.time.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return super.adjustInto(temporal);
    }

    @Override // java.time.temporal.Temporal
    public long until(Temporal endExclusive, TemporalUnit unit) {
        LocalDate end = from((TemporalAccessor) endExclusive);
        if (unit instanceof ChronoUnit) {
            switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) unit).ordinal()]) {
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
        return unit.between(this, end);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long daysUntil(LocalDate end) {
        return end.toEpochDay() - toEpochDay();
    }

    private long monthsUntil(LocalDate end) {
        long packed1 = (getProlepticMonth() * 32) + getDayOfMonth();
        long packed2 = (end.getProlepticMonth() * 32) + end.getDayOfMonth();
        return (packed2 - packed1) / 32;
    }

    @Override // java.time.chrono.ChronoLocalDate
    public Period until(ChronoLocalDate endDateExclusive) {
        LocalDate end = from((TemporalAccessor) endDateExclusive);
        long totalMonths = end.getProlepticMonth() - getProlepticMonth();
        int days = end.day - this.day;
        if (totalMonths > 0 && days < 0) {
            totalMonths--;
            LocalDate calcDate = plusMonths(totalMonths);
            days = (int) (end.toEpochDay() - calcDate.toEpochDay());
        } else if (totalMonths < 0 && days > 0) {
            totalMonths++;
            days -= end.lengthOfMonth();
        }
        long years = totalMonths / 12;
        int months = (int) (totalMonths % 12);
        return Period.of(Math.toIntExact(years), months, days);
    }

    public Stream<LocalDate> datesUntil(LocalDate endExclusive) {
        long end = endExclusive.toEpochDay();
        long start = toEpochDay();
        if (end < start) {
            throw new IllegalArgumentException(((Object) endExclusive) + " < " + ((Object) this));
        }
        return LongStream.range(start, end).mapToObj(new LongFunction() { // from class: java.time.LocalDate$$ExternalSyntheticLambda0
            @Override // java.util.function.LongFunction
            public final Object apply(long j10) {
                return LocalDate.ofEpochDay(j10);
            }
        });
    }

    public Stream<LocalDate> datesUntil(LocalDate endExclusive, Period step) {
        long steps;
        if (step.isZero()) {
            throw new IllegalArgumentException("step is zero");
        }
        long end = endExclusive.toEpochDay();
        final long start = toEpochDay();
        long until = end - start;
        final long months = step.toTotalMonths();
        final long days = step.getDays();
        if ((months < 0 && days > 0) || (months > 0 && days < 0)) {
            throw new IllegalArgumentException("period months and days are of opposite sign");
        }
        if (until == 0) {
            return Stream.empty();
        }
        int sign = (months > 0 || days > 0) ? 1 : -1;
        if ((sign < 0) ^ (until < 0)) {
            throw new IllegalArgumentException(((Object) endExclusive) + (sign < 0 ? " > " : " < ") + ((Object) this));
        }
        if (months == 0) {
            return LongStream.rangeClosed(0L, (until - sign) / days).mapToObj(new LongFunction() { // from class: java.time.LocalDate$$ExternalSyntheticLambda1
                @Override // java.util.function.LongFunction
                public final Object apply(long j10) {
                    LocalDate ofEpochDay;
                    ofEpochDay = LocalDate.ofEpochDay((j10 * days) + start);
                    return ofEpochDay;
                }
            });
        }
        long steps2 = ((until * 1600) / ((48699 * months) + (1600 * days))) + 1;
        long addMonths = months * steps2;
        long addDays = days * steps2;
        long maxAddMonths = months > 0 ? MAX.getProlepticMonth() - getProlepticMonth() : getProlepticMonth() - MIN.getProlepticMonth();
        if (sign * addMonths <= maxAddMonths && (plusMonths(addMonths).toEpochDay() + addDays) * sign < sign * end) {
            steps = steps2;
            return LongStream.rangeClosed(0L, steps).mapToObj(new LongFunction() { // from class: java.time.LocalDate$$ExternalSyntheticLambda2
                @Override // java.util.function.LongFunction
                public final Object apply(long j10) {
                    LocalDate lambda$datesUntil$1;
                    lambda$datesUntil$1 = LocalDate.this.lambda$datesUntil$1(months, days, j10);
                    return lambda$datesUntil$1;
                }
            });
        }
        long steps3 = steps2 - 1;
        long addMonths2 = addMonths - months;
        steps = (((long) sign) * addMonths2 > maxAddMonths || (plusMonths(addMonths2).toEpochDay() + (addDays - days)) * ((long) sign) >= ((long) sign) * end) ? steps3 - 1 : steps3;
        return LongStream.rangeClosed(0L, steps).mapToObj(new LongFunction() { // from class: java.time.LocalDate$$ExternalSyntheticLambda2
            @Override // java.util.function.LongFunction
            public final Object apply(long j10) {
                LocalDate lambda$datesUntil$1;
                lambda$datesUntil$1 = LocalDate.this.lambda$datesUntil$1(months, days, j10);
                return lambda$datesUntil$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ LocalDate lambda$datesUntil$1(long months, long days, long n10) {
        return plusMonths(months * n10).plusDays(days * n10);
    }

    @Override // java.time.chrono.ChronoLocalDate
    public String format(DateTimeFormatter formatter) {
        Objects.requireNonNull(formatter, "formatter");
        return formatter.format(this);
    }

    @Override // java.time.chrono.ChronoLocalDate
    public LocalDateTime atTime(LocalTime time) {
        return LocalDateTime.of(this, time);
    }

    public LocalDateTime atTime(int hour, int minute) {
        return atTime(LocalTime.of(hour, minute));
    }

    public LocalDateTime atTime(int hour, int minute, int second) {
        return atTime(LocalTime.of(hour, minute, second));
    }

    public LocalDateTime atTime(int hour, int minute, int second, int nanoOfSecond) {
        return atTime(LocalTime.of(hour, minute, second, nanoOfSecond));
    }

    public OffsetDateTime atTime(OffsetTime time) {
        return OffsetDateTime.of(LocalDateTime.of(this, time.toLocalTime()), time.getOffset());
    }

    public LocalDateTime atStartOfDay() {
        return LocalDateTime.of(this, LocalTime.MIDNIGHT);
    }

    public ZonedDateTime atStartOfDay(ZoneId zone) {
        Objects.requireNonNull(zone, "zone");
        LocalDateTime ldt = atTime(LocalTime.MIDNIGHT);
        if (!(zone instanceof ZoneOffset)) {
            ZoneRules rules = zone.getRules();
            ZoneOffsetTransition trans = rules.getTransition(ldt);
            if (trans != null && trans.isGap()) {
                ldt = trans.getDateTimeAfter();
            }
        }
        return ZonedDateTime.of(ldt, zone);
    }

    @Override // java.time.chrono.ChronoLocalDate
    public long toEpochDay() {
        long total;
        long y10 = this.year;
        long m10 = this.month;
        long total2 = 0 + (365 * y10);
        if (y10 >= 0) {
            total = total2 + (((3 + y10) / 4) - ((99 + y10) / 100)) + ((399 + y10) / 400);
        } else {
            total = total2 - (((y10 / (-4)) - (y10 / (-100))) + (y10 / (-400)));
        }
        long total3 = total + (((367 * m10) - 362) / 12) + (this.day - 1);
        if (m10 > 2) {
            total3--;
            if (!isLeapYear()) {
                total3--;
            }
        }
        return total3 - DAYS_0000_TO_1970;
    }

    public long toEpochSecond(LocalTime time, ZoneOffset offset) {
        Objects.requireNonNull(time, "time");
        Objects.requireNonNull(offset, Attributes.Style.OFFSET);
        long secs = (toEpochDay() * 86400) + time.toSecondOfDay();
        return secs - offset.getTotalSeconds();
    }

    @Override // java.time.chrono.ChronoLocalDate, java.lang.Comparable
    public int compareTo(ChronoLocalDate other) {
        if (other instanceof LocalDate) {
            return compareTo0((LocalDate) other);
        }
        return super.compareTo(other);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int compareTo0(LocalDate otherDate) {
        int cmp = this.year - otherDate.year;
        if (cmp == 0) {
            int cmp2 = this.month - otherDate.month;
            if (cmp2 == 0) {
                return this.day - otherDate.day;
            }
            return cmp2;
        }
        return cmp;
    }

    @Override // java.time.chrono.ChronoLocalDate
    public boolean isAfter(ChronoLocalDate other) {
        if (other instanceof LocalDate) {
            return compareTo0((LocalDate) other) > 0;
        }
        return super.isAfter(other);
    }

    @Override // java.time.chrono.ChronoLocalDate
    public boolean isBefore(ChronoLocalDate other) {
        if (other instanceof LocalDate) {
            return compareTo0((LocalDate) other) < 0;
        }
        return super.isBefore(other);
    }

    @Override // java.time.chrono.ChronoLocalDate
    public boolean isEqual(ChronoLocalDate other) {
        if (other instanceof LocalDate) {
            return compareTo0((LocalDate) other) == 0;
        }
        return super.isEqual(other);
    }

    @Override // java.time.chrono.ChronoLocalDate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalDate) && compareTo0((LocalDate) obj) == 0;
    }

    @Override // java.time.chrono.ChronoLocalDate
    public int hashCode() {
        int yearValue = this.year;
        int monthValue = this.month;
        int dayValue = this.day;
        return (yearValue & (-2048)) ^ (((yearValue << 11) + (monthValue << 6)) + dayValue);
    }

    @Override // java.time.chrono.ChronoLocalDate
    public String toString() {
        int yearValue = this.year;
        int monthValue = this.month;
        int dayValue = this.day;
        int absYear = Math.abs(yearValue);
        StringBuilder buf = new StringBuilder(10);
        if (absYear < 1000) {
            if (yearValue < 0) {
                buf.append(yearValue - 10000).deleteCharAt(1);
            } else {
                buf.append(yearValue + 10000).deleteCharAt(0);
            }
        } else {
            if (yearValue > 9999) {
                buf.append('+');
            }
            buf.append(yearValue);
        }
        return buf.append(monthValue < 10 ? "-0" : "-").append(monthValue).append(dayValue >= 10 ? "-" : "-0").append(dayValue).toString();
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    private void readObject(ObjectInputStream s2) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput out) throws IOException {
        out.writeInt(this.year);
        out.writeByte(this.month);
        out.writeByte(this.day);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LocalDate readExternal(DataInput in) throws IOException {
        int year = in.readInt();
        int month = in.readByte();
        int dayOfMonth = in.readByte();
        return of(year, month, dayOfMonth);
    }
}
