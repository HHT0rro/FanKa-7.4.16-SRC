package java.time.temporal;

import android.icu.text.DateTimePatternGenerator;
import android.icu.util.ULocale;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.IsoChronology;
import java.time.format.ResolverStyle;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class IsoFields {
    public static final TemporalField DAY_OF_QUARTER = Field.DAY_OF_QUARTER;
    public static final TemporalField QUARTER_OF_YEAR = Field.QUARTER_OF_YEAR;
    public static final TemporalField WEEK_OF_WEEK_BASED_YEAR = Field.WEEK_OF_WEEK_BASED_YEAR;
    public static final TemporalField WEEK_BASED_YEAR = Field.WEEK_BASED_YEAR;
    public static final TemporalUnit WEEK_BASED_YEARS = Unit.WEEK_BASED_YEARS;
    public static final TemporalUnit QUARTER_YEARS = Unit.QUARTER_YEARS;

    private IsoFields() {
        throw new AssertionError((Object) "Not instantiable");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class Field implements TemporalField {
        public static final Field DAY_OF_QUARTER = new AnonymousClass1("DAY_OF_QUARTER", 0);
        public static final Field QUARTER_OF_YEAR = new AnonymousClass2("QUARTER_OF_YEAR", 1);
        public static final Field WEEK_OF_WEEK_BASED_YEAR = new AnonymousClass3("WEEK_OF_WEEK_BASED_YEAR", 2);
        public static final Field WEEK_BASED_YEAR = new AnonymousClass4("WEEK_BASED_YEAR", 3);
        private static final /* synthetic */ Field[] $VALUES = $values();
        private static final int[] QUARTER_DAYS = {0, 90, 181, 273, 0, 91, 182, 274};

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* renamed from: java.time.temporal.IsoFields$Field$1, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        enum AnonymousClass1 extends Field {
            private AnonymousClass1(String str, int i10) {
                super(str, i10);
            }

            @Override // java.time.temporal.TemporalField
            public /* bridge */ /* synthetic */ TemporalAccessor resolve(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                return resolve((Map<TemporalField, Long>) map, temporalAccessor, resolverStyle);
            }

            @Override // java.time.temporal.TemporalField
            public TemporalUnit getBaseUnit() {
                return ChronoUnit.DAYS;
            }

            @Override // java.time.temporal.TemporalField
            public TemporalUnit getRangeUnit() {
                return IsoFields.QUARTER_YEARS;
            }

            @Override // java.time.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.of(1L, 90L, 92L);
            }

            @Override // java.time.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporal) {
                return temporal.isSupported(ChronoField.DAY_OF_YEAR) && temporal.isSupported(ChronoField.MONTH_OF_YEAR) && temporal.isSupported(ChronoField.YEAR) && IsoFields.isIso(temporal);
            }

            @Override // java.time.temporal.IsoFields.Field, java.time.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporal) {
                if (!isSupportedBy(temporal)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
                long qoy = temporal.getLong(QUARTER_OF_YEAR);
                if (qoy == 1) {
                    long year = temporal.getLong(ChronoField.YEAR);
                    return IsoChronology.INSTANCE.isLeapYear(year) ? ValueRange.of(1L, 91L) : ValueRange.of(1L, 90L);
                }
                if (qoy == 2) {
                    return ValueRange.of(1L, 91L);
                }
                if (qoy == 3 || qoy == 4) {
                    return ValueRange.of(1L, 92L);
                }
                return range();
            }

            @Override // java.time.temporal.TemporalField
            public long getFrom(TemporalAccessor temporal) {
                if (!isSupportedBy(temporal)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
                int doy = temporal.get(ChronoField.DAY_OF_YEAR);
                int moy = temporal.get(ChronoField.MONTH_OF_YEAR);
                long year = temporal.getLong(ChronoField.YEAR);
                return doy - Field.QUARTER_DAYS[((moy - 1) / 3) + (IsoChronology.INSTANCE.isLeapYear(year) ? 4 : 0)];
            }

            @Override // java.time.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r10, long j10) {
                long from = getFrom(r10);
                range().checkValidValue(j10, this);
                return (R) r10.with(ChronoField.DAY_OF_YEAR, r10.getLong(ChronoField.DAY_OF_YEAR) + (j10 - from));
            }

            @Override // java.time.temporal.TemporalField
            public ChronoLocalDate resolve(Map<TemporalField, Long> fieldValues, TemporalAccessor partialTemporal, ResolverStyle resolverStyle) {
                long doq;
                LocalDate date;
                Long yearLong = fieldValues.get(ChronoField.YEAR);
                Long qoyLong = fieldValues.get(QUARTER_OF_YEAR);
                if (yearLong == null || qoyLong == null) {
                    return null;
                }
                int y10 = ChronoField.YEAR.checkValidIntValue(yearLong.longValue());
                long doq2 = fieldValues.get(DAY_OF_QUARTER).longValue();
                Field.ensureIso(partialTemporal);
                if (resolverStyle == ResolverStyle.LENIENT) {
                    date = LocalDate.of(y10, 1, 1).plusMonths(Math.multiplyExact(Math.subtractExact(qoyLong.longValue(), 1L), 3));
                    doq = Math.subtractExact(doq2, 1L);
                } else {
                    int qoy = QUARTER_OF_YEAR.range().checkValidIntValue(qoyLong.longValue(), QUARTER_OF_YEAR);
                    LocalDate date2 = LocalDate.of(y10, ((qoy - 1) * 3) + 1, 1);
                    if (doq2 < 1 || doq2 > 90) {
                        if (resolverStyle == ResolverStyle.STRICT) {
                            rangeRefinedBy(date2).checkValidValue(doq2, this);
                        } else {
                            range().checkValidValue(doq2, this);
                        }
                    }
                    doq = doq2 - 1;
                    date = date2;
                }
                fieldValues.remove(this);
                fieldValues.remove(ChronoField.YEAR);
                fieldValues.remove(QUARTER_OF_YEAR);
                return date.plusDays(doq);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "DayOfQuarter";
            }
        }

        private static /* synthetic */ Field[] $values() {
            return new Field[]{DAY_OF_QUARTER, QUARTER_OF_YEAR, WEEK_OF_WEEK_BASED_YEAR, WEEK_BASED_YEAR};
        }

        private Field(String str, int i10) {
        }

        public static Field valueOf(String name) {
            return (Field) Enum.valueOf(Field.class, name);
        }

        public static Field[] values() {
            return (Field[]) $VALUES.clone();
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* renamed from: java.time.temporal.IsoFields$Field$2, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        enum AnonymousClass2 extends Field {
            private AnonymousClass2(String str, int i10) {
                super(str, i10);
            }

            @Override // java.time.temporal.TemporalField
            public TemporalUnit getBaseUnit() {
                return IsoFields.QUARTER_YEARS;
            }

            @Override // java.time.temporal.TemporalField
            public TemporalUnit getRangeUnit() {
                return ChronoUnit.YEARS;
            }

            @Override // java.time.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.of(1L, 4L);
            }

            @Override // java.time.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporal) {
                return temporal.isSupported(ChronoField.MONTH_OF_YEAR) && IsoFields.isIso(temporal);
            }

            @Override // java.time.temporal.TemporalField
            public long getFrom(TemporalAccessor temporal) {
                if (!isSupportedBy(temporal)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: QuarterOfYear");
                }
                long moy = temporal.getLong(ChronoField.MONTH_OF_YEAR);
                return (2 + moy) / 3;
            }

            @Override // java.time.temporal.IsoFields.Field, java.time.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporal) {
                if (!isSupportedBy(temporal)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: QuarterOfYear");
                }
                return super.rangeRefinedBy(temporal);
            }

            @Override // java.time.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r10, long j10) {
                long from = getFrom(r10);
                range().checkValidValue(j10, this);
                return (R) r10.with(ChronoField.MONTH_OF_YEAR, r10.getLong(ChronoField.MONTH_OF_YEAR) + ((j10 - from) * 3));
            }

            @Override // java.lang.Enum
            public String toString() {
                return "QuarterOfYear";
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* renamed from: java.time.temporal.IsoFields$Field$3, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        enum AnonymousClass3 extends Field {
            private AnonymousClass3(String str, int i10) {
                super(str, i10);
            }

            @Override // java.time.temporal.TemporalField
            public /* bridge */ /* synthetic */ TemporalAccessor resolve(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                return resolve((Map<TemporalField, Long>) map, temporalAccessor, resolverStyle);
            }

            @Override // java.time.temporal.TemporalField
            public String getDisplayName(Locale locale) {
                Objects.requireNonNull(locale, "locale");
                DateTimePatternGenerator dateTimePatternGenerator = DateTimePatternGenerator.getInstance(ULocale.forLocale(locale));
                String icuName = dateTimePatternGenerator.getAppendItemName(4);
                return (icuName == null || icuName.isEmpty()) ? toString() : icuName;
            }

            @Override // java.time.temporal.TemporalField
            public TemporalUnit getBaseUnit() {
                return ChronoUnit.WEEKS;
            }

            @Override // java.time.temporal.TemporalField
            public TemporalUnit getRangeUnit() {
                return IsoFields.WEEK_BASED_YEARS;
            }

            @Override // java.time.temporal.TemporalField
            public ValueRange range() {
                return ValueRange.of(1L, 52L, 53L);
            }

            @Override // java.time.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporal) {
                return temporal.isSupported(ChronoField.EPOCH_DAY) && IsoFields.isIso(temporal);
            }

            @Override // java.time.temporal.IsoFields.Field, java.time.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporal) {
                if (!isSupportedBy(temporal)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
                }
                return Field.getWeekRange(LocalDate.from(temporal));
            }

            @Override // java.time.temporal.TemporalField
            public long getFrom(TemporalAccessor temporal) {
                if (!isSupportedBy(temporal)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
                }
                return Field.getWeek(LocalDate.from(temporal));
            }

            @Override // java.time.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r10, long j10) {
                range().checkValidValue(j10, this);
                return (R) r10.plus(Math.subtractExact(j10, getFrom(r10)), ChronoUnit.WEEKS);
            }

            @Override // java.time.temporal.TemporalField
            public ChronoLocalDate resolve(Map<TemporalField, Long> fieldValues, TemporalAccessor partialTemporal, ResolverStyle resolverStyle) {
                LocalDate date;
                long j10;
                Long wbyLong = fieldValues.get(WEEK_BASED_YEAR);
                Long dowLong = fieldValues.get(ChronoField.DAY_OF_WEEK);
                if (wbyLong == null || dowLong == null) {
                    return null;
                }
                int wby = WEEK_BASED_YEAR.range().checkValidIntValue(wbyLong.longValue(), WEEK_BASED_YEAR);
                long wowby = fieldValues.get(WEEK_OF_WEEK_BASED_YEAR).longValue();
                Field.ensureIso(partialTemporal);
                LocalDate date2 = LocalDate.of(wby, 1, 4);
                if (resolverStyle == ResolverStyle.LENIENT) {
                    long dow = dowLong.longValue();
                    if (dow > 7) {
                        date2 = date2.plusWeeks((dow - 1) / 7);
                        dow = ((dow - 1) % 7) + 1;
                        j10 = 1;
                    } else if (dow < 1) {
                        date2 = date2.plusWeeks(Math.subtractExact(dow, 7L) / 7);
                        j10 = 1;
                        dow = ((6 + dow) % 7) + 1;
                    } else {
                        j10 = 1;
                    }
                    date = date2.plusWeeks(Math.subtractExact(wowby, j10)).with((TemporalField) ChronoField.DAY_OF_WEEK, dow);
                } else {
                    int dow2 = ChronoField.DAY_OF_WEEK.checkValidIntValue(dowLong.longValue());
                    if (wowby < 1 || wowby > 52) {
                        if (resolverStyle == ResolverStyle.STRICT) {
                            Field.getWeekRange(date2).checkValidValue(wowby, this);
                        } else {
                            range().checkValidValue(wowby, this);
                        }
                    }
                    date = date2.plusWeeks(wowby - 1).with((TemporalField) ChronoField.DAY_OF_WEEK, dow2);
                }
                fieldValues.remove(this);
                fieldValues.remove(WEEK_BASED_YEAR);
                fieldValues.remove(ChronoField.DAY_OF_WEEK);
                return date;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekOfWeekBasedYear";
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* renamed from: java.time.temporal.IsoFields$Field$4, reason: invalid class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        enum AnonymousClass4 extends Field {
            private AnonymousClass4(String str, int i10) {
                super(str, i10);
            }

            @Override // java.time.temporal.TemporalField
            public TemporalUnit getBaseUnit() {
                return IsoFields.WEEK_BASED_YEARS;
            }

            @Override // java.time.temporal.TemporalField
            public TemporalUnit getRangeUnit() {
                return ChronoUnit.FOREVER;
            }

            @Override // java.time.temporal.TemporalField
            public ValueRange range() {
                return ChronoField.YEAR.range();
            }

            @Override // java.time.temporal.TemporalField
            public boolean isSupportedBy(TemporalAccessor temporal) {
                return temporal.isSupported(ChronoField.EPOCH_DAY) && IsoFields.isIso(temporal);
            }

            @Override // java.time.temporal.TemporalField
            public long getFrom(TemporalAccessor temporal) {
                if (!isSupportedBy(temporal)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
                }
                return Field.getWeekBasedYear(LocalDate.from(temporal));
            }

            @Override // java.time.temporal.IsoFields.Field, java.time.temporal.TemporalField
            public ValueRange rangeRefinedBy(TemporalAccessor temporal) {
                if (!isSupportedBy(temporal)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
                }
                return super.rangeRefinedBy(temporal);
            }

            @Override // java.time.temporal.TemporalField
            public <R extends Temporal> R adjustInto(R r10, long j10) {
                if (!isSupportedBy(r10)) {
                    throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
                }
                int checkValidIntValue = range().checkValidIntValue(j10, WEEK_BASED_YEAR);
                LocalDate from = LocalDate.from((TemporalAccessor) r10);
                int i10 = from.get(ChronoField.DAY_OF_WEEK);
                int week = Field.getWeek(from);
                if (week == 53 && Field.getWeekRange(checkValidIntValue) == 52) {
                    week = 52;
                }
                return (R) r10.with(LocalDate.of(checkValidIntValue, 1, 4).plusDays((i10 - r4.get(ChronoField.DAY_OF_WEEK)) + ((week - 1) * 7)));
            }

            @Override // java.lang.Enum
            public String toString() {
                return "WeekBasedYear";
            }
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
        public ValueRange rangeRefinedBy(TemporalAccessor temporal) {
            return range();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void ensureIso(TemporalAccessor temporal) {
            if (!IsoFields.isIso(temporal)) {
                throw new DateTimeException("Resolve requires IsoChronology");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ValueRange getWeekRange(LocalDate date) {
            int wby = getWeekBasedYear(date);
            return ValueRange.of(1L, getWeekRange(wby));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeekRange(int wby) {
            LocalDate date = LocalDate.of(wby, 1, 1);
            if (date.getDayOfWeek() == DayOfWeek.THURSDAY) {
                return 53;
            }
            if (date.getDayOfWeek() == DayOfWeek.WEDNESDAY && date.isLeapYear()) {
                return 53;
            }
            return 52;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeek(LocalDate date) {
            int dow0 = date.getDayOfWeek().ordinal();
            boolean z10 = true;
            int doy0 = date.getDayOfYear() - 1;
            int doyThu0 = (3 - dow0) + doy0;
            int alignedWeek = doyThu0 / 7;
            int firstThuDoy0 = doyThu0 - (alignedWeek * 7);
            int firstMonDoy0 = firstThuDoy0 - 3;
            if (firstMonDoy0 < -3) {
                firstMonDoy0 += 7;
            }
            if (doy0 < firstMonDoy0) {
                return (int) getWeekRange(date.withDayOfYear(180).minusYears(1L)).getMaximum();
            }
            int week = ((doy0 - firstMonDoy0) / 7) + 1;
            if (week == 53) {
                if (firstMonDoy0 != -3 && (firstMonDoy0 != -2 || !date.isLeapYear())) {
                    z10 = false;
                }
                if (!z10) {
                    return 1;
                }
                return week;
            }
            return week;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getWeekBasedYear(LocalDate localDate) {
            int year = localDate.getYear();
            int dayOfYear = localDate.getDayOfYear();
            if (dayOfYear <= 3) {
                if (dayOfYear - localDate.getDayOfWeek().ordinal() < -2) {
                    return year - 1;
                }
                return year;
            }
            if (dayOfYear >= 363) {
                if (((dayOfYear - 363) - (localDate.isLeapYear() ? 1 : 0)) - localDate.getDayOfWeek().ordinal() >= 0) {
                    return year + 1;
                }
                return year;
            }
            return year;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private enum Unit implements TemporalUnit {
        WEEK_BASED_YEARS("WeekBasedYears", Duration.ofSeconds(31556952)),
        QUARTER_YEARS("QuarterYears", Duration.ofSeconds(7889238));

        private final Duration duration;
        private final String name;

        Unit(String name, Duration estimatedDuration) {
            this.name = name;
            this.duration = estimatedDuration;
        }

        @Override // java.time.temporal.TemporalUnit
        public Duration getDuration() {
            return this.duration;
        }

        @Override // java.time.temporal.TemporalUnit
        public boolean isDurationEstimated() {
            return true;
        }

        @Override // java.time.temporal.TemporalUnit
        public boolean isDateBased() {
            return true;
        }

        @Override // java.time.temporal.TemporalUnit
        public boolean isTimeBased() {
            return false;
        }

        @Override // java.time.temporal.TemporalUnit
        public boolean isSupportedBy(Temporal temporal) {
            return temporal.isSupported(ChronoField.EPOCH_DAY) && IsoFields.isIso(temporal);
        }

        @Override // java.time.temporal.TemporalUnit
        public <R extends Temporal> R addTo(R r10, long j10) {
            switch (AnonymousClass1.$SwitchMap$java$time$temporal$IsoFields$Unit[ordinal()]) {
                case 1:
                    return (R) r10.with(IsoFields.WEEK_BASED_YEAR, Math.addExact(r10.get(IsoFields.WEEK_BASED_YEAR), j10));
                case 2:
                    return (R) r10.plus(j10 / 4, ChronoUnit.YEARS).plus((j10 % 4) * 3, ChronoUnit.MONTHS);
                default:
                    throw new IllegalStateException("Unreachable");
            }
        }

        @Override // java.time.temporal.TemporalUnit
        public long between(Temporal temporal1Inclusive, Temporal temporal2Exclusive) {
            if (temporal1Inclusive.getClass() != temporal2Exclusive.getClass()) {
                return temporal1Inclusive.until(temporal2Exclusive, this);
            }
            switch (AnonymousClass1.$SwitchMap$java$time$temporal$IsoFields$Unit[ordinal()]) {
                case 1:
                    return Math.subtractExact(temporal2Exclusive.getLong(IsoFields.WEEK_BASED_YEAR), temporal1Inclusive.getLong(IsoFields.WEEK_BASED_YEAR));
                case 2:
                    return temporal1Inclusive.until(temporal2Exclusive, ChronoUnit.MONTHS) / 3;
                default:
                    throw new IllegalStateException("Unreachable");
            }
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.time.temporal.IsoFields$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$IsoFields$Unit;

        static {
            int[] iArr = new int[Unit.values().length];
            $SwitchMap$java$time$temporal$IsoFields$Unit = iArr;
            try {
                iArr[Unit.WEEK_BASED_YEARS.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$time$temporal$IsoFields$Unit[Unit.QUARTER_YEARS.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    static boolean isIso(TemporalAccessor temporal) {
        return Chronology.from(temporal).equals(IsoChronology.INSTANCE);
    }
}
