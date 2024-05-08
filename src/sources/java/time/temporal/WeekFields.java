package java.time.temporal;

import android.icu.text.DateTimePatternGenerator;
import android.icu.util.Calendar;
import android.icu.util.ULocale;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.format.ResolverStyle;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import sun.util.locale.provider.CalendarDataUtility;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class WeekFields implements Serializable {
    private static final ConcurrentMap<String, WeekFields> CACHE = new ConcurrentHashMap(4, 0.75f, 2);
    public static final WeekFields ISO = of(DayOfWeek.MONDAY, 4);
    public static final WeekFields SUNDAY_START = of(DayOfWeek.SUNDAY, 1);
    public static final TemporalUnit WEEK_BASED_YEARS = IsoFields.WEEK_BASED_YEARS;
    private static final long serialVersionUID = -1177360819670808121L;
    private final DayOfWeek firstDayOfWeek;
    private final int minimalDays;
    private final transient TemporalField dayOfWeek = ComputedDayOfField.ofDayOfWeekField(this);
    private final transient TemporalField weekOfMonth = ComputedDayOfField.ofWeekOfMonthField(this);
    private final transient TemporalField weekOfYear = ComputedDayOfField.ofWeekOfYearField(this);
    private final transient TemporalField weekOfWeekBasedYear = ComputedDayOfField.ofWeekOfWeekBasedYearField(this);
    private final transient TemporalField weekBasedYear = ComputedDayOfField.ofWeekBasedYearField(this);

    public static WeekFields of(Locale locale) {
        Objects.requireNonNull(locale, "locale");
        Calendar calendar = Calendar.getInstance(locale);
        Calendar.WeekData weekData = calendar.getWeekData();
        int calDow = CalendarDataUtility.retrieveFirstDayOfWeek(locale, weekData.firstDayOfWeek);
        DayOfWeek dow = DayOfWeek.SUNDAY.plus(calDow - 1);
        int minDays = weekData.minimalDaysInFirstWeek;
        return of(dow, minDays);
    }

    public static WeekFields of(DayOfWeek firstDayOfWeek, int minimalDaysInFirstWeek) {
        String key = firstDayOfWeek.toString() + minimalDaysInFirstWeek;
        ConcurrentMap<String, WeekFields> concurrentMap = CACHE;
        WeekFields rules = concurrentMap.get(key);
        if (rules == null) {
            concurrentMap.putIfAbsent(key, new WeekFields(firstDayOfWeek, minimalDaysInFirstWeek));
            return concurrentMap.get(key);
        }
        return rules;
    }

    private WeekFields(DayOfWeek firstDayOfWeek, int minimalDaysInFirstWeek) {
        Objects.requireNonNull(firstDayOfWeek, "firstDayOfWeek");
        if (minimalDaysInFirstWeek < 1 || minimalDaysInFirstWeek > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.firstDayOfWeek = firstDayOfWeek;
        this.minimalDays = minimalDaysInFirstWeek;
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException, InvalidObjectException {
        s2.defaultReadObject();
        if (this.firstDayOfWeek == null) {
            throw new InvalidObjectException("firstDayOfWeek is null");
        }
        int i10 = this.minimalDays;
        if (i10 < 1 || i10 > 7) {
            throw new InvalidObjectException("Minimal number of days is invalid");
        }
    }

    private Object readResolve() throws InvalidObjectException {
        try {
            return of(this.firstDayOfWeek, this.minimalDays);
        } catch (IllegalArgumentException iae) {
            throw new InvalidObjectException("Invalid serialized WeekFields: " + iae.getMessage());
        }
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public int getMinimalDaysInFirstWeek() {
        return this.minimalDays;
    }

    public TemporalField dayOfWeek() {
        return this.dayOfWeek;
    }

    public TemporalField weekOfMonth() {
        return this.weekOfMonth;
    }

    public TemporalField weekOfYear() {
        return this.weekOfYear;
    }

    public TemporalField weekOfWeekBasedYear() {
        return this.weekOfWeekBasedYear;
    }

    public TemporalField weekBasedYear() {
        return this.weekBasedYear;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        return (object instanceof WeekFields) && hashCode() == object.hashCode();
    }

    public int hashCode() {
        return (this.firstDayOfWeek.ordinal() * 7) + this.minimalDays;
    }

    public String toString() {
        return "WeekFields[" + ((Object) this.firstDayOfWeek) + ',' + this.minimalDays + ']';
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class ComputedDayOfField implements TemporalField {
        private final TemporalUnit baseUnit;
        private final String name;
        private final ValueRange range;
        private final TemporalUnit rangeUnit;
        private final WeekFields weekDef;
        private static final ValueRange DAY_OF_WEEK_RANGE = ValueRange.of(1, 7);
        private static final ValueRange WEEK_OF_MONTH_RANGE = ValueRange.of(0, 1, 4, 6);
        private static final ValueRange WEEK_OF_YEAR_RANGE = ValueRange.of(0, 1, 52, 54);
        private static final ValueRange WEEK_OF_WEEK_BASED_YEAR_RANGE = ValueRange.of(1, 52, 53);

        @Override // java.time.temporal.TemporalField
        public /* bridge */ /* synthetic */ TemporalAccessor resolve(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            return resolve((Map<TemporalField, Long>) map, temporalAccessor, resolverStyle);
        }

        static ComputedDayOfField ofDayOfWeekField(WeekFields weekDef) {
            return new ComputedDayOfField("DayOfWeek", weekDef, ChronoUnit.DAYS, ChronoUnit.WEEKS, DAY_OF_WEEK_RANGE);
        }

        static ComputedDayOfField ofWeekOfMonthField(WeekFields weekDef) {
            return new ComputedDayOfField("WeekOfMonth", weekDef, ChronoUnit.WEEKS, ChronoUnit.MONTHS, WEEK_OF_MONTH_RANGE);
        }

        static ComputedDayOfField ofWeekOfYearField(WeekFields weekDef) {
            return new ComputedDayOfField("WeekOfYear", weekDef, ChronoUnit.WEEKS, ChronoUnit.YEARS, WEEK_OF_YEAR_RANGE);
        }

        static ComputedDayOfField ofWeekOfWeekBasedYearField(WeekFields weekDef) {
            return new ComputedDayOfField("WeekOfWeekBasedYear", weekDef, ChronoUnit.WEEKS, IsoFields.WEEK_BASED_YEARS, WEEK_OF_WEEK_BASED_YEAR_RANGE);
        }

        static ComputedDayOfField ofWeekBasedYearField(WeekFields weekDef) {
            return new ComputedDayOfField("WeekBasedYear", weekDef, IsoFields.WEEK_BASED_YEARS, ChronoUnit.FOREVER, ChronoField.YEAR.range());
        }

        private ChronoLocalDate ofWeekBasedYear(Chronology chrono, int yowby, int wowby, int dow) {
            ChronoLocalDate date = chrono.date(yowby, 1, 1);
            int ldow = localizedDayOfWeek(date);
            int offset = startOfWeekOffset(1, ldow);
            int yearLen = date.lengthOfYear();
            int newYearWeek = computeWeek(offset, this.weekDef.getMinimalDaysInFirstWeek() + yearLen);
            int days = (-offset) + (dow - 1) + ((Math.min(wowby, newYearWeek - 1) - 1) * 7);
            return date.plus(days, (TemporalUnit) ChronoUnit.DAYS);
        }

        private ComputedDayOfField(String name, WeekFields weekDef, TemporalUnit baseUnit, TemporalUnit rangeUnit, ValueRange range) {
            this.name = name;
            this.weekDef = weekDef;
            this.baseUnit = baseUnit;
            this.rangeUnit = rangeUnit;
            this.range = range;
        }

        @Override // java.time.temporal.TemporalField
        public long getFrom(TemporalAccessor temporal) {
            if (this.rangeUnit == ChronoUnit.WEEKS) {
                return localizedDayOfWeek(temporal);
            }
            if (this.rangeUnit == ChronoUnit.MONTHS) {
                return localizedWeekOfMonth(temporal);
            }
            if (this.rangeUnit == ChronoUnit.YEARS) {
                return localizedWeekOfYear(temporal);
            }
            if (this.rangeUnit == WeekFields.WEEK_BASED_YEARS) {
                return localizedWeekOfWeekBasedYear(temporal);
            }
            if (this.rangeUnit == ChronoUnit.FOREVER) {
                return localizedWeekBasedYear(temporal);
            }
            throw new IllegalStateException("unreachable, rangeUnit: " + ((Object) this.rangeUnit) + ", this: " + ((Object) this));
        }

        private int localizedDayOfWeek(TemporalAccessor temporal) {
            int sow = this.weekDef.getFirstDayOfWeek().getValue();
            int isoDow = temporal.get(ChronoField.DAY_OF_WEEK);
            return Math.floorMod(isoDow - sow, 7) + 1;
        }

        private int localizedDayOfWeek(int isoDow) {
            int sow = this.weekDef.getFirstDayOfWeek().getValue();
            return Math.floorMod(isoDow - sow, 7) + 1;
        }

        private long localizedWeekOfMonth(TemporalAccessor temporal) {
            int dow = localizedDayOfWeek(temporal);
            int dom = temporal.get(ChronoField.DAY_OF_MONTH);
            int offset = startOfWeekOffset(dom, dow);
            return computeWeek(offset, dom);
        }

        private long localizedWeekOfYear(TemporalAccessor temporal) {
            int dow = localizedDayOfWeek(temporal);
            int doy = temporal.get(ChronoField.DAY_OF_YEAR);
            int offset = startOfWeekOffset(doy, dow);
            return computeWeek(offset, doy);
        }

        private int localizedWeekBasedYear(TemporalAccessor temporal) {
            int dow = localizedDayOfWeek(temporal);
            int year = temporal.get(ChronoField.YEAR);
            int doy = temporal.get(ChronoField.DAY_OF_YEAR);
            int offset = startOfWeekOffset(doy, dow);
            int week = computeWeek(offset, doy);
            if (week == 0) {
                return year - 1;
            }
            ValueRange dayRange = temporal.range(ChronoField.DAY_OF_YEAR);
            int yearLen = (int) dayRange.getMaximum();
            int newYearWeek = computeWeek(offset, this.weekDef.getMinimalDaysInFirstWeek() + yearLen);
            if (week >= newYearWeek) {
                return year + 1;
            }
            return year;
        }

        private int localizedWeekOfWeekBasedYear(TemporalAccessor temporal) {
            int dow = localizedDayOfWeek(temporal);
            int doy = temporal.get(ChronoField.DAY_OF_YEAR);
            int offset = startOfWeekOffset(doy, dow);
            int week = computeWeek(offset, doy);
            if (week == 0) {
                ChronoLocalDate date = Chronology.from(temporal).date(temporal);
                return localizedWeekOfWeekBasedYear(date.minus(doy, (TemporalUnit) ChronoUnit.DAYS));
            }
            if (week > 50) {
                ValueRange dayRange = temporal.range(ChronoField.DAY_OF_YEAR);
                int yearLen = (int) dayRange.getMaximum();
                int newYearWeek = computeWeek(offset, this.weekDef.getMinimalDaysInFirstWeek() + yearLen);
                if (week >= newYearWeek) {
                    return (week - newYearWeek) + 1;
                }
                return week;
            }
            return week;
        }

        private int startOfWeekOffset(int day, int dow) {
            int weekStart = Math.floorMod(day - dow, 7);
            int offset = -weekStart;
            if (weekStart + 1 > this.weekDef.getMinimalDaysInFirstWeek()) {
                int offset2 = 7 - weekStart;
                return offset2;
            }
            return offset;
        }

        private int computeWeek(int offset, int day) {
            return ((offset + 7) + (day - 1)) / 7;
        }

        @Override // java.time.temporal.TemporalField
        public <R extends Temporal> R adjustInto(R r10, long j10) {
            if (this.range.checkValidIntValue(j10, this) == r10.get(this)) {
                return r10;
            }
            if (this.rangeUnit == ChronoUnit.FOREVER) {
                return ofWeekBasedYear(Chronology.from(r10), (int) j10, r10.get(this.weekDef.weekOfWeekBasedYear), r10.get(this.weekDef.dayOfWeek));
            }
            return (R) r10.plus(r0 - r1, this.baseUnit);
        }

        @Override // java.time.temporal.TemporalField
        public ChronoLocalDate resolve(Map<TemporalField, Long> fieldValues, TemporalAccessor partialTemporal, ResolverStyle resolverStyle) {
            Chronology chrono;
            int dow;
            long value = fieldValues.get(this).longValue();
            int newValue = Math.toIntExact(value);
            if (this.rangeUnit == ChronoUnit.WEEKS) {
                int checkedValue = this.range.checkValidIntValue(value, this);
                int startDow = this.weekDef.getFirstDayOfWeek().getValue();
                long isoDow = Math.floorMod((startDow - 1) + (checkedValue - 1), 7) + 1;
                fieldValues.remove(this);
                fieldValues.put(ChronoField.DAY_OF_WEEK, Long.valueOf(isoDow));
                return null;
            }
            if (!fieldValues.containsKey(ChronoField.DAY_OF_WEEK)) {
                return null;
            }
            int isoDow2 = ChronoField.DAY_OF_WEEK.checkValidIntValue(fieldValues.get(ChronoField.DAY_OF_WEEK).longValue());
            int dow2 = localizedDayOfWeek(isoDow2);
            Chronology chrono2 = Chronology.from(partialTemporal);
            if (fieldValues.containsKey(ChronoField.YEAR)) {
                int year = ChronoField.YEAR.checkValidIntValue(fieldValues.get(ChronoField.YEAR).longValue());
                if (this.rangeUnit != ChronoUnit.MONTHS || !fieldValues.containsKey(ChronoField.MONTH_OF_YEAR)) {
                    chrono = chrono2;
                    dow = dow2;
                    if (this.rangeUnit == ChronoUnit.YEARS) {
                        return resolveWoY(fieldValues, chrono, year, newValue, dow, resolverStyle);
                    }
                } else {
                    long month = fieldValues.get(ChronoField.MONTH_OF_YEAR).longValue();
                    return resolveWoM(fieldValues, chrono2, year, month, newValue, dow2, resolverStyle);
                }
            } else {
                chrono = chrono2;
                dow = dow2;
                if (this.rangeUnit == WeekFields.WEEK_BASED_YEARS || this.rangeUnit == ChronoUnit.FOREVER) {
                    if (fieldValues.containsKey(this.weekDef.weekBasedYear) && fieldValues.containsKey(this.weekDef.weekOfWeekBasedYear)) {
                        return resolveWBY(fieldValues, chrono, dow, resolverStyle);
                    }
                    return null;
                }
            }
            return null;
        }

        private ChronoLocalDate resolveWoM(Map<TemporalField, Long> fieldValues, Chronology chrono, int year, long month, long wom, int localDow, ResolverStyle resolverStyle) {
            ChronoLocalDate date;
            if (resolverStyle == ResolverStyle.LENIENT) {
                ChronoLocalDate date2 = chrono.date(year, 1, 1).plus(Math.subtractExact(month, 1L), (TemporalUnit) ChronoUnit.MONTHS);
                long weeks = Math.subtractExact(wom, localizedWeekOfMonth(date2));
                int days = localDow - localizedDayOfWeek(date2);
                long multiplyExact = Math.multiplyExact(weeks, 7);
                long weeks2 = days;
                date = date2.plus(Math.addExact(multiplyExact, weeks2), (TemporalUnit) ChronoUnit.DAYS);
            } else {
                int monthValid = ChronoField.MONTH_OF_YEAR.checkValidIntValue(month);
                ChronoLocalDate date3 = chrono.date(year, monthValid, 1);
                int womInt = this.range.checkValidIntValue(wom, this);
                int weeks3 = (int) (womInt - localizedWeekOfMonth(date3));
                int days2 = localDow - localizedDayOfWeek(date3);
                ChronoLocalDate date4 = date3.plus((weeks3 * 7) + days2, (TemporalUnit) ChronoUnit.DAYS);
                if (resolverStyle == ResolverStyle.STRICT && date4.getLong(ChronoField.MONTH_OF_YEAR) != month) {
                    throw new DateTimeException("Strict mode rejected resolved date as it is in a different month");
                }
                date = date4;
            }
            fieldValues.remove(this);
            fieldValues.remove(ChronoField.YEAR);
            fieldValues.remove(ChronoField.MONTH_OF_YEAR);
            fieldValues.remove(ChronoField.DAY_OF_WEEK);
            return date;
        }

        private ChronoLocalDate resolveWoY(Map<TemporalField, Long> fieldValues, Chronology chrono, int year, long woy, int localDow, ResolverStyle resolverStyle) {
            ChronoLocalDate date;
            ChronoLocalDate date2 = chrono.date(year, 1, 1);
            if (resolverStyle == ResolverStyle.LENIENT) {
                long weeks = Math.subtractExact(woy, localizedWeekOfYear(date2));
                int days = localDow - localizedDayOfWeek(date2);
                date = date2.plus(Math.addExact(Math.multiplyExact(weeks, 7), days), (TemporalUnit) ChronoUnit.DAYS);
            } else {
                int womInt = this.range.checkValidIntValue(woy, this);
                int weeks2 = (int) (womInt - localizedWeekOfYear(date2));
                int days2 = localDow - localizedDayOfWeek(date2);
                date = date2.plus((weeks2 * 7) + days2, (TemporalUnit) ChronoUnit.DAYS);
                if (resolverStyle == ResolverStyle.STRICT && date.getLong(ChronoField.YEAR) != year) {
                    throw new DateTimeException("Strict mode rejected resolved date as it is in a different year");
                }
            }
            fieldValues.remove(this);
            fieldValues.remove(ChronoField.YEAR);
            fieldValues.remove(ChronoField.DAY_OF_WEEK);
            return date;
        }

        private ChronoLocalDate resolveWBY(Map<TemporalField, Long> fieldValues, Chronology chrono, int localDow, ResolverStyle resolverStyle) {
            ChronoLocalDate date;
            int yowby = this.weekDef.weekBasedYear.range().checkValidIntValue(fieldValues.get(this.weekDef.weekBasedYear).longValue(), this.weekDef.weekBasedYear);
            if (resolverStyle == ResolverStyle.LENIENT) {
                ChronoLocalDate date2 = ofWeekBasedYear(chrono, yowby, 1, localDow);
                long wowby = fieldValues.get(this.weekDef.weekOfWeekBasedYear).longValue();
                long weeks = Math.subtractExact(wowby, 1L);
                date = date2.plus(weeks, (TemporalUnit) ChronoUnit.WEEKS);
            } else {
                int wowby2 = this.weekDef.weekOfWeekBasedYear.range().checkValidIntValue(fieldValues.get(this.weekDef.weekOfWeekBasedYear).longValue(), this.weekDef.weekOfWeekBasedYear);
                ChronoLocalDate date3 = ofWeekBasedYear(chrono, yowby, wowby2, localDow);
                if (resolverStyle == ResolverStyle.STRICT && localizedWeekBasedYear(date3) != yowby) {
                    throw new DateTimeException("Strict mode rejected resolved date as it is in a different week-based-year");
                }
                date = date3;
            }
            fieldValues.remove(this);
            fieldValues.remove(this.weekDef.weekBasedYear);
            fieldValues.remove(this.weekDef.weekOfWeekBasedYear);
            fieldValues.remove(ChronoField.DAY_OF_WEEK);
            return date;
        }

        @Override // java.time.temporal.TemporalField
        public String getDisplayName(Locale locale) {
            Objects.requireNonNull(locale, "locale");
            if (this.rangeUnit == ChronoUnit.YEARS) {
                DateTimePatternGenerator dateTimePatternGenerator = DateTimePatternGenerator.getInstance(ULocale.forLocale(locale));
                String icuName = dateTimePatternGenerator.getAppendItemName(4);
                return (icuName == null || icuName.isEmpty()) ? this.name : icuName;
            }
            return this.name;
        }

        @Override // java.time.temporal.TemporalField
        public TemporalUnit getBaseUnit() {
            return this.baseUnit;
        }

        @Override // java.time.temporal.TemporalField
        public TemporalUnit getRangeUnit() {
            return this.rangeUnit;
        }

        @Override // java.time.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // java.time.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        @Override // java.time.temporal.TemporalField
        public ValueRange range() {
            return this.range;
        }

        @Override // java.time.temporal.TemporalField
        public boolean isSupportedBy(TemporalAccessor temporal) {
            if (temporal.isSupported(ChronoField.DAY_OF_WEEK)) {
                if (this.rangeUnit == ChronoUnit.WEEKS) {
                    return true;
                }
                if (this.rangeUnit == ChronoUnit.MONTHS) {
                    return temporal.isSupported(ChronoField.DAY_OF_MONTH);
                }
                if (this.rangeUnit == ChronoUnit.YEARS) {
                    return temporal.isSupported(ChronoField.DAY_OF_YEAR);
                }
                if (this.rangeUnit == WeekFields.WEEK_BASED_YEARS) {
                    return temporal.isSupported(ChronoField.DAY_OF_YEAR);
                }
                if (this.rangeUnit == ChronoUnit.FOREVER) {
                    return temporal.isSupported(ChronoField.YEAR);
                }
                return false;
            }
            return false;
        }

        @Override // java.time.temporal.TemporalField
        public ValueRange rangeRefinedBy(TemporalAccessor temporal) {
            if (this.rangeUnit == ChronoUnit.WEEKS) {
                return this.range;
            }
            if (this.rangeUnit == ChronoUnit.MONTHS) {
                return rangeByWeek(temporal, ChronoField.DAY_OF_MONTH);
            }
            if (this.rangeUnit == ChronoUnit.YEARS) {
                return rangeByWeek(temporal, ChronoField.DAY_OF_YEAR);
            }
            if (this.rangeUnit == WeekFields.WEEK_BASED_YEARS) {
                return rangeWeekOfWeekBasedYear(temporal);
            }
            if (this.rangeUnit == ChronoUnit.FOREVER) {
                return ChronoField.YEAR.range();
            }
            throw new IllegalStateException("unreachable, rangeUnit: " + ((Object) this.rangeUnit) + ", this: " + ((Object) this));
        }

        private ValueRange rangeByWeek(TemporalAccessor temporal, TemporalField field) {
            int dow = localizedDayOfWeek(temporal);
            int offset = startOfWeekOffset(temporal.get(field), dow);
            ValueRange fieldRange = temporal.range(field);
            return ValueRange.of(computeWeek(offset, (int) fieldRange.getMinimum()), computeWeek(offset, (int) fieldRange.getMaximum()));
        }

        private ValueRange rangeWeekOfWeekBasedYear(TemporalAccessor temporal) {
            if (!temporal.isSupported(ChronoField.DAY_OF_YEAR)) {
                return WEEK_OF_YEAR_RANGE;
            }
            int dow = localizedDayOfWeek(temporal);
            int doy = temporal.get(ChronoField.DAY_OF_YEAR);
            int offset = startOfWeekOffset(doy, dow);
            int week = computeWeek(offset, doy);
            if (week == 0) {
                ChronoLocalDate date = Chronology.from(temporal).date(temporal);
                return rangeWeekOfWeekBasedYear(date.minus(doy + 7, (TemporalUnit) ChronoUnit.DAYS));
            }
            ValueRange dayRange = temporal.range(ChronoField.DAY_OF_YEAR);
            int yearLen = (int) dayRange.getMaximum();
            int newYearWeek = computeWeek(offset, this.weekDef.getMinimalDaysInFirstWeek() + yearLen);
            if (week >= newYearWeek) {
                ChronoLocalDate date2 = Chronology.from(temporal).date(temporal);
                return rangeWeekOfWeekBasedYear(date2.plus((yearLen - doy) + 1 + 7, (TemporalUnit) ChronoUnit.DAYS));
            }
            return ValueRange.of(1L, newYearWeek - 1);
        }

        @Override // java.time.temporal.TemporalField
        public String toString() {
            return this.name + "[" + this.weekDef.toString() + "]";
        }
    }
}
