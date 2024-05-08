package java.util;

import com.android.internal.logging.nano.MetricsProto;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.AccessControlContext;
import java.security.PermissionCollection;
import java.security.ProtectionDomain;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.time.Instant;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import libcore.icu.ICU;
import libcore.icu.LocaleData;
import libcore.util.ZoneInfo;
import sun.util.locale.provider.CalendarDataUtility;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Calendar implements Serializable, Cloneable, Comparable<Calendar> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int ALL_FIELDS = 131071;
    public static final int ALL_STYLES = 0;
    public static final int AM = 0;
    public static final int AM_PM = 9;
    static final int AM_PM_MASK = 512;
    public static final int APRIL = 3;
    public static final int AUGUST = 7;
    private static final int COMPUTED = 1;
    public static final int DATE = 5;
    static final int DATE_MASK = 32;
    public static final int DAY_OF_MONTH = 5;
    static final int DAY_OF_MONTH_MASK = 32;
    public static final int DAY_OF_WEEK = 7;
    public static final int DAY_OF_WEEK_IN_MONTH = 8;
    static final int DAY_OF_WEEK_IN_MONTH_MASK = 256;
    static final int DAY_OF_WEEK_MASK = 128;
    public static final int DAY_OF_YEAR = 6;
    static final int DAY_OF_YEAR_MASK = 64;
    public static final int DECEMBER = 11;
    public static final int DST_OFFSET = 16;
    static final int DST_OFFSET_MASK = 65536;
    public static final int ERA = 0;
    static final int ERA_MASK = 1;
    public static final int FEBRUARY = 1;
    public static final int FIELD_COUNT = 17;
    public static final int FRIDAY = 6;
    public static final int HOUR = 10;
    static final int HOUR_MASK = 1024;
    public static final int HOUR_OF_DAY = 11;
    static final int HOUR_OF_DAY_MASK = 2048;
    public static final int JANUARY = 0;
    public static final int JULY = 6;
    public static final int JUNE = 5;
    public static final int LONG = 2;
    public static final int LONG_FORMAT = 2;
    public static final int LONG_STANDALONE = 32770;
    public static final int MARCH = 2;
    public static final int MAY = 4;
    public static final int MILLISECOND = 14;
    static final int MILLISECOND_MASK = 16384;
    private static final int MINIMUM_USER_STAMP = 2;
    public static final int MINUTE = 12;
    static final int MINUTE_MASK = 4096;
    public static final int MONDAY = 2;
    public static final int MONTH = 2;
    static final int MONTH_MASK = 4;
    public static final int NARROW_FORMAT = 4;
    public static final int NARROW_STANDALONE = 32772;
    public static final int NOVEMBER = 10;
    public static final int OCTOBER = 9;
    public static final int PM = 1;
    public static final int SATURDAY = 7;
    public static final int SECOND = 13;
    static final int SECOND_MASK = 8192;
    public static final int SEPTEMBER = 8;
    public static final int SHORT = 1;
    public static final int SHORT_FORMAT = 1;
    public static final int SHORT_STANDALONE = 32769;
    static final int STANDALONE_MASK = 32768;
    public static final int SUNDAY = 1;
    public static final int THURSDAY = 5;
    public static final int TUESDAY = 3;
    public static final int UNDECIMBER = 12;
    private static final int UNSET = 0;
    public static final int WEDNESDAY = 4;
    public static final int WEEK_OF_MONTH = 4;
    static final int WEEK_OF_MONTH_MASK = 16;
    public static final int WEEK_OF_YEAR = 3;
    static final int WEEK_OF_YEAR_MASK = 8;
    public static final int YEAR = 1;
    static final int YEAR_MASK = 2;
    public static final int ZONE_OFFSET = 15;
    static final int ZONE_OFFSET_MASK = 32768;
    static final int currentSerialVersion = 1;
    static final long serialVersionUID = -1807547505821590642L;
    transient boolean areAllFieldsSet;
    protected boolean areFieldsSet;
    protected int[] fields;
    private int firstDayOfWeek;
    protected boolean[] isSet;
    protected boolean isTimeSet;
    private boolean lenient;
    private int minimalDaysInFirstWeek;
    private int nextStamp;
    private int serialVersionOnStream;
    private transient boolean sharedZone;
    private transient int[] stamp;
    protected long time;
    private TimeZone zone;
    private static final ConcurrentMap<Locale, int[]> cachedLocaleData = new ConcurrentHashMap(3);
    private static final String[] FIELD_NAME = {"ERA", "YEAR", "MONTH", "WEEK_OF_YEAR", "WEEK_OF_MONTH", "DAY_OF_MONTH", "DAY_OF_YEAR", "DAY_OF_WEEK", "DAY_OF_WEEK_IN_MONTH", "AM_PM", "HOUR", "HOUR_OF_DAY", "MINUTE", "SECOND", "MILLISECOND", "ZONE_OFFSET", "DST_OFFSET"};

    public abstract void add(int i10, int i11);

    protected abstract void computeFields();

    protected abstract void computeTime();

    public abstract int getGreatestMinimum(int i10);

    public abstract int getLeastMaximum(int i10);

    public abstract int getMaximum(int i10);

    public abstract int getMinimum(int i10);

    public abstract void roll(int i10, boolean z10);

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Builder {
        private static final int NFIELDS = 18;
        private static final int WEEK_YEAR = 17;
        private int[] fields;
        private int firstDayOfWeek;
        private long instant;
        private boolean lenient = true;
        private Locale locale;
        private int maxFieldIndex;
        private int minimalDaysInFirstWeek;
        private int nextStamp;
        private String type;
        private TimeZone zone;

        public Builder setInstant(long instant) {
            if (this.fields != null) {
                throw new IllegalStateException();
            }
            this.instant = instant;
            this.nextStamp = 1;
            return this;
        }

        public Builder setInstant(Date instant) {
            return setInstant(instant.getTime());
        }

        public Builder set(int field, int value) {
            if (field < 0 || field >= 17) {
                throw new IllegalArgumentException("field is invalid");
            }
            if (isInstantSet()) {
                throw new IllegalStateException("instant has been set");
            }
            allocateFields();
            internalSet(field, value);
            return this;
        }

        public Builder setFields(int... fieldValuePairs) {
            int len = fieldValuePairs.length;
            if (len % 2 != 0) {
                throw new IllegalArgumentException();
            }
            if (isInstantSet()) {
                throw new IllegalStateException("instant has been set");
            }
            if (this.nextStamp + (len / 2) < 0) {
                throw new IllegalStateException("stamp counter overflow");
            }
            allocateFields();
            int field = 0;
            while (field < len) {
                int i10 = field + 1;
                int field2 = fieldValuePairs[field];
                if (field2 < 0 || field2 >= 17) {
                    throw new IllegalArgumentException("field is invalid");
                }
                internalSet(field2, fieldValuePairs[i10]);
                field = i10 + 1;
            }
            return this;
        }

        public Builder setDate(int year, int month, int dayOfMonth) {
            return setFields(1, year, 2, month, 5, dayOfMonth);
        }

        public Builder setTimeOfDay(int hourOfDay, int minute, int second) {
            return setTimeOfDay(hourOfDay, minute, second, 0);
        }

        public Builder setTimeOfDay(int hourOfDay, int minute, int second, int millis) {
            return setFields(11, hourOfDay, 12, minute, 13, second, 14, millis);
        }

        public Builder setWeekDate(int weekYear, int weekOfYear, int dayOfWeek) {
            allocateFields();
            internalSet(17, weekYear);
            internalSet(3, weekOfYear);
            internalSet(7, dayOfWeek);
            return this;
        }

        public Builder setTimeZone(TimeZone zone) {
            if (zone == null) {
                throw new NullPointerException();
            }
            this.zone = zone;
            return this;
        }

        public Builder setLenient(boolean lenient) {
            this.lenient = lenient;
            return this;
        }

        public Builder setCalendarType(String type) {
            if (type.equals("gregorian")) {
                type = "gregory";
            }
            if (!Calendar.getAvailableCalendarTypes().contains(type) && !type.equals("iso8601")) {
                throw new IllegalArgumentException("unknown calendar type: " + type);
            }
            String str = this.type;
            if (str == null) {
                this.type = type;
            } else if (!str.equals(type)) {
                throw new IllegalStateException("calendar type override");
            }
            return this;
        }

        public Builder setLocale(Locale locale) {
            if (locale == null) {
                throw new NullPointerException();
            }
            this.locale = locale;
            return this;
        }

        public Builder setWeekDefinition(int firstDayOfWeek, int minimalDaysInFirstWeek) {
            if (!isValidWeekParameter(firstDayOfWeek) || !isValidWeekParameter(minimalDaysInFirstWeek)) {
                throw new IllegalArgumentException();
            }
            this.firstDayOfWeek = firstDayOfWeek;
            this.minimalDaysInFirstWeek = minimalDaysInFirstWeek;
            return this;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public Calendar build() {
            char c4;
            GregorianCalendar gcal;
            if (this.locale == null) {
                this.locale = Locale.getDefault();
            }
            if (this.zone == null) {
                this.zone = Calendar.defaultTimeZone(this.locale);
            }
            if (this.type == null) {
                this.type = this.locale.getUnicodeLocaleType("ca");
            }
            if (this.type == null) {
                this.type = "gregory";
            }
            String str = this.type;
            boolean z10 = false;
            switch (str.hashCode()) {
                case 283776265:
                    if (str.equals("gregory")) {
                        c4 = 0;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 2095190916:
                    if (str.equals("iso8601")) {
                        c4 = 1;
                        break;
                    }
                    c4 = 65535;
                    break;
                default:
                    c4 = 65535;
                    break;
            }
            switch (c4) {
                case 0:
                    gcal = new GregorianCalendar(this.zone, this.locale, true);
                    break;
                case 1:
                    gcal = new GregorianCalendar(this.zone, this.locale, true);
                    gcal.setGregorianChange(new Date(Long.MIN_VALUE));
                    setWeekDefinition(2, 4);
                    break;
                default:
                    throw new IllegalArgumentException("unknown calendar type: " + this.type);
            }
            gcal.setLenient(this.lenient);
            int i10 = this.firstDayOfWeek;
            if (i10 != 0) {
                gcal.setFirstDayOfWeek(i10);
                gcal.setMinimalDaysInFirstWeek(this.minimalDaysInFirstWeek);
            }
            if (isInstantSet()) {
                gcal.setTimeInMillis(this.instant);
                gcal.complete();
                return gcal;
            }
            if (this.fields != null) {
                if (isSet(17)) {
                    int[] iArr = this.fields;
                    if (iArr[17] > iArr[1]) {
                        z10 = true;
                    }
                }
                boolean weekDate = z10;
                if (weekDate && !gcal.isWeekDateSupported()) {
                    throw new IllegalArgumentException("week date is unsupported by " + this.type);
                }
                for (int stamp = 2; stamp < this.nextStamp; stamp++) {
                    int index = 0;
                    while (true) {
                        if (index <= this.maxFieldIndex) {
                            int[] iArr2 = this.fields;
                            if (iArr2[index] != stamp) {
                                index++;
                            } else {
                                gcal.set(index, iArr2[index + 18]);
                            }
                        }
                    }
                }
                if (weekDate) {
                    int weekOfYear = isSet(3) ? this.fields[21] : 1;
                    int dayOfWeek = isSet(7) ? this.fields[25] : gcal.getFirstDayOfWeek();
                    gcal.setWeekDate(this.fields[35], weekOfYear, dayOfWeek);
                }
                gcal.complete();
            }
            return gcal;
        }

        private void allocateFields() {
            if (this.fields == null) {
                this.fields = new int[36];
                this.nextStamp = 2;
                this.maxFieldIndex = -1;
            }
        }

        private void internalSet(int field, int value) {
            int[] iArr = this.fields;
            int i10 = this.nextStamp;
            int i11 = i10 + 1;
            this.nextStamp = i11;
            iArr[field] = i10;
            if (i11 < 0) {
                throw new IllegalStateException("stamp counter overflow");
            }
            iArr[field + 18] = value;
            if (field > this.maxFieldIndex && field < 17) {
                this.maxFieldIndex = field;
            }
        }

        private boolean isInstantSet() {
            return this.nextStamp == 1;
        }

        private boolean isSet(int index) {
            int[] iArr = this.fields;
            return iArr != null && iArr[index] > 0;
        }

        private boolean isValidWeekParameter(int value) {
            return value > 0 && value <= 7;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Calendar() {
        this(TimeZone.getDefaultRef(), Locale.getDefault(Locale.Category.FORMAT));
        this.sharedZone = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Calendar(TimeZone zone, Locale aLocale) {
        this.lenient = true;
        this.sharedZone = false;
        this.nextStamp = 2;
        this.serialVersionOnStream = 1;
        aLocale = aLocale == null ? Locale.getDefault() : aLocale;
        this.fields = new int[17];
        this.isSet = new boolean[17];
        this.stamp = new int[17];
        this.zone = zone;
        setWeekCountData(aLocale);
    }

    public static Calendar getInstance() {
        Locale aLocale = Locale.getDefault(Locale.Category.FORMAT);
        return createCalendar(defaultTimeZone(aLocale), aLocale);
    }

    public static Calendar getInstance(TimeZone zone) {
        return createCalendar(zone, Locale.getDefault(Locale.Category.FORMAT));
    }

    public static Calendar getInstance(Locale aLocale) {
        return createCalendar(defaultTimeZone(aLocale), aLocale);
    }

    public static Calendar getInstance(TimeZone zone, Locale aLocale) {
        return createCalendar(zone, aLocale);
    }

    public static Calendar getJapaneseImperialInstance(TimeZone zone, Locale aLocale) {
        return new JapaneseImperialCalendar(zone, aLocale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TimeZone defaultTimeZone(Locale l10) {
        TimeZone defaultTZ = TimeZone.getDefault();
        if (l10 == null) {
            return defaultTZ;
        }
        String shortTZID = l10.getUnicodeLocaleType("tz");
        if (shortTZID != null) {
            return (TimeZone) Optional.ofNullable(ICU.convertToTzId(shortTZID)).map(new Function() { // from class: java.util.Calendar$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return TimeZone.getTimeZone((String) obj);
                }
            }).orElse(defaultTZ);
        }
        return defaultTZ;
    }

    private static Calendar createCalendar(TimeZone zone, Locale aLocale) {
        return new GregorianCalendar(zone, aLocale);
    }

    public static synchronized Locale[] getAvailableLocales() {
        Locale[] availableLocales;
        synchronized (Calendar.class) {
            availableLocales = DateFormat.getAvailableLocales();
        }
        return availableLocales;
    }

    public final Date getTime() {
        return new Date(getTimeInMillis());
    }

    public final void setTime(Date date) {
        Objects.requireNonNull(date, "date must not be null");
        setTimeInMillis(date.getTime());
    }

    public long getTimeInMillis() {
        if (!this.isTimeSet) {
            updateTime();
        }
        return this.time;
    }

    public void setTimeInMillis(long millis) {
        if (this.time == millis && this.isTimeSet && this.areFieldsSet && this.areAllFieldsSet) {
            return;
        }
        this.time = millis;
        this.isTimeSet = true;
        this.areFieldsSet = false;
        computeFields();
        this.areFieldsSet = true;
        this.areAllFieldsSet = true;
    }

    public int get(int field) {
        complete();
        return internalGet(field);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int internalGet(int field) {
        return this.fields[field];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void internalSet(int field, int value) {
        this.fields[field] = value;
    }

    public void set(int field, int value) {
        if (this.areFieldsSet && !this.areAllFieldsSet) {
            computeFields();
        }
        internalSet(field, value);
        this.isTimeSet = false;
        this.areFieldsSet = false;
        this.isSet[field] = true;
        int[] iArr = this.stamp;
        int i10 = this.nextStamp;
        int i11 = i10 + 1;
        this.nextStamp = i11;
        iArr[field] = i10;
        if (i11 == Integer.MAX_VALUE) {
            adjustStamp();
        }
    }

    public final void set(int year, int month, int date) {
        set(1, year);
        set(2, month);
        set(5, date);
    }

    public final void set(int year, int month, int date, int hourOfDay, int minute) {
        set(1, year);
        set(2, month);
        set(5, date);
        set(11, hourOfDay);
        set(12, minute);
    }

    public final void set(int year, int month, int date, int hourOfDay, int minute, int second) {
        set(1, year);
        set(2, month);
        set(5, date);
        set(11, hourOfDay);
        set(12, minute);
        set(13, second);
    }

    public final void clear() {
        int i10 = 0;
        while (true) {
            int[] iArr = this.fields;
            if (i10 < iArr.length) {
                int[] iArr2 = this.stamp;
                iArr[i10] = 0;
                iArr2[i10] = 0;
                this.isSet[i10] = false;
                i10++;
            } else {
                this.areFieldsSet = false;
                this.areAllFieldsSet = false;
                this.isTimeSet = false;
                return;
            }
        }
    }

    public final void clear(int field) {
        this.fields[field] = 0;
        this.stamp[field] = 0;
        this.isSet[field] = false;
        this.areFieldsSet = false;
        this.areAllFieldsSet = false;
        this.isTimeSet = false;
    }

    public final boolean isSet(int field) {
        return this.stamp[field] != 0;
    }

    public String getDisplayName(int field, int style, Locale locale) {
        if (style == 0) {
            style = 1;
        }
        if (!checkDisplayNameParams(field, style, 1, 4, locale, MetricsProto.MetricsEvent.ACTION_PERMISSION_REVOKE_CAMERA)) {
            return null;
        }
        String calendarType = getCalendarType();
        int fieldValue = get(field);
        if (isStandaloneStyle(style) || isNarrowFormatStyle(style) || (field == 0 && (style & 1) == 1)) {
            String val = CalendarDataUtility.retrieveFieldValueName(calendarType, field, fieldValue, style, locale);
            if (val == null) {
                if (isNarrowFormatStyle(style)) {
                    return CalendarDataUtility.retrieveFieldValueName(calendarType, field, fieldValue, toStandaloneStyle(style), locale);
                }
                if (isStandaloneStyle(style)) {
                    return CalendarDataUtility.retrieveFieldValueName(calendarType, field, fieldValue, getBaseStyle(style), locale);
                }
                return val;
            }
            return val;
        }
        DateFormatSymbols symbols = DateFormatSymbols.getInstance(locale);
        String[] strings = getFieldStrings(field, style, symbols);
        if (strings == null || fieldValue >= strings.length) {
            return null;
        }
        return strings[fieldValue];
    }

    public Map<String, Integer> getDisplayNames(int field, int style, Locale locale) {
        if (!checkDisplayNameParams(field, style, 0, 4, locale, MetricsProto.MetricsEvent.ACTION_PERMISSION_REVOKE_CAMERA)) {
            return null;
        }
        complete();
        String calendarType = getCalendarType();
        if (style == 0 || isStandaloneStyle(style) || isNarrowFormatStyle(style) || (field == 0 && (style & 1) == 1)) {
            Map<String, Integer> map = CalendarDataUtility.retrieveFieldValueNames(calendarType, field, style, locale);
            if (map == null) {
                if (isNarrowFormatStyle(style)) {
                    return CalendarDataUtility.retrieveFieldValueNames(calendarType, field, toStandaloneStyle(style), locale);
                }
                if (style != 0) {
                    return CalendarDataUtility.retrieveFieldValueNames(calendarType, field, getBaseStyle(style), locale);
                }
                return map;
            }
            return map;
        }
        return getDisplayNamesImpl(field, style, locale);
    }

    private Map<String, Integer> getDisplayNamesImpl(int field, int style, Locale locale) {
        DateFormatSymbols symbols = DateFormatSymbols.getInstance(locale);
        String[] strings = getFieldStrings(field, style, symbols);
        if (strings != null) {
            Map<String, Integer> names = new HashMap<>();
            for (int i10 = 0; i10 < strings.length; i10++) {
                if (!strings[i10].isEmpty()) {
                    names.put(strings[i10], Integer.valueOf(i10));
                }
            }
            return names;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean checkDisplayNameParams(int field, int style, int minStyle, int maxStyle, Locale locale, int fieldMask) {
        int baseStyle = getBaseStyle(style);
        if (field < 0 || field >= this.fields.length || baseStyle < minStyle || baseStyle > maxStyle || baseStyle == 3) {
            throw new IllegalArgumentException();
        }
        if (baseStyle == 3) {
            throw new IllegalArgumentException();
        }
        if (locale == null) {
            throw new NullPointerException();
        }
        return isFieldSet(fieldMask, field);
    }

    private String[] getFieldStrings(int field, int style, DateFormatSymbols symbols) {
        int baseStyle = getBaseStyle(style);
        if (baseStyle == 4) {
            return null;
        }
        switch (field) {
            case 0:
                return symbols.getEras();
            case 2:
                return baseStyle == 2 ? symbols.getMonths() : symbols.getShortMonths();
            case 7:
                return baseStyle == 2 ? symbols.getWeekdays() : symbols.getShortWeekdays();
            case 9:
                return symbols.getAmPmStrings();
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void complete() {
        if (!this.isTimeSet) {
            updateTime();
        }
        if (!this.areFieldsSet || !this.areAllFieldsSet) {
            computeFields();
            this.areFieldsSet = true;
            this.areAllFieldsSet = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isExternallySet(int field) {
        return this.stamp[field] >= 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getSetStateFields() {
        int mask = 0;
        for (int i10 = 0; i10 < this.fields.length; i10++) {
            if (this.stamp[i10] != 0) {
                mask |= 1 << i10;
            }
        }
        return mask;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setFieldsComputed(int fieldMask) {
        if (fieldMask == ALL_FIELDS) {
            for (int i10 = 0; i10 < this.fields.length; i10++) {
                this.stamp[i10] = 1;
                this.isSet[i10] = true;
            }
            this.areAllFieldsSet = true;
            this.areFieldsSet = true;
            return;
        }
        for (int i11 = 0; i11 < this.fields.length; i11++) {
            if ((fieldMask & 1) == 1) {
                this.stamp[i11] = 1;
                this.isSet[i11] = true;
            } else if (this.areAllFieldsSet && !this.isSet[i11]) {
                this.areAllFieldsSet = false;
            }
            fieldMask >>>= 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setFieldsNormalized(int fieldMask) {
        if (fieldMask != ALL_FIELDS) {
            int i10 = 0;
            while (true) {
                int[] iArr = this.fields;
                if (i10 >= iArr.length) {
                    break;
                }
                if ((fieldMask & 1) == 0) {
                    int[] iArr2 = this.stamp;
                    iArr[i10] = 0;
                    iArr2[i10] = 0;
                    this.isSet[i10] = false;
                }
                fieldMask >>= 1;
                i10++;
            }
        }
        this.areFieldsSet = true;
        this.areAllFieldsSet = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isPartiallyNormalized() {
        return this.areFieldsSet && !this.areAllFieldsSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isFullyNormalized() {
        return this.areFieldsSet && this.areAllFieldsSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setUnnormalized() {
        this.areAllFieldsSet = false;
        this.areFieldsSet = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isFieldSet(int fieldMask, int field) {
        return ((1 << field) & fieldMask) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0063, code lost:
    
        if (r13[4] < r13[3]) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
    
        if (r13[8] >= r13[3]) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int selectFields() {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Calendar.selectFields():int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBaseStyle(int style) {
        return (-32769) & style;
    }

    public static int toStandaloneStyle(int style) {
        return 32768 | style;
    }

    private boolean isStandaloneStyle(int style) {
        return (32768 & style) != 0;
    }

    private boolean isNarrowStyle(int style) {
        return style == 4 || style == 32772;
    }

    private boolean isNarrowFormatStyle(int style) {
        return style == 4;
    }

    private static int aggregateStamp(int stamp_a, int stamp_b) {
        if (stamp_a == 0 || stamp_b == 0) {
            return 0;
        }
        return stamp_a > stamp_b ? stamp_a : stamp_b;
    }

    public static Set<String> getAvailableCalendarTypes() {
        return AvailableCalendarTypes.SET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class AvailableCalendarTypes {
        private static final Set<String> SET;

        static {
            Set<String> set = new HashSet<>(3);
            set.add("gregory");
            SET = Collections.unmodifiableSet(set);
        }

        private AvailableCalendarTypes() {
        }
    }

    public String getCalendarType() {
        return getClass().getName();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            Calendar that = (Calendar) obj;
            if (compareTo(getMillisOf(that)) == 0 && this.lenient == that.lenient && this.firstDayOfWeek == that.firstDayOfWeek && this.minimalDaysInFirstWeek == that.minimalDaysInFirstWeek) {
                TimeZone timeZone = this.zone;
                if (timeZone instanceof ZoneInfo) {
                    if (timeZone.equals(that.zone)) {
                        return true;
                    }
                } else if (timeZone.equals(that.getTimeZone())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    public int hashCode() {
        boolean z10 = this.lenient;
        int hashCode = (z10 ? 1 : 0) | (this.firstDayOfWeek << 1) | (this.minimalDaysInFirstWeek << 4) | (this.zone.hashCode() << 7);
        long millisOf = getMillisOf(this);
        return (((int) millisOf) ^ ((int) (millisOf >> 32))) ^ hashCode;
    }

    public boolean before(Object when) {
        return (when instanceof Calendar) && compareTo((Calendar) when) < 0;
    }

    public boolean after(Object when) {
        return (when instanceof Calendar) && compareTo((Calendar) when) > 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(Calendar anotherCalendar) {
        return compareTo(getMillisOf(anotherCalendar));
    }

    public void roll(int field, int amount) {
        while (amount > 0) {
            roll(field, true);
            amount--;
        }
        while (amount < 0) {
            roll(field, false);
            amount++;
        }
    }

    public void setTimeZone(TimeZone value) {
        this.zone = value;
        this.sharedZone = false;
        this.areFieldsSet = false;
        this.areAllFieldsSet = false;
    }

    public TimeZone getTimeZone() {
        if (this.sharedZone) {
            this.zone = (TimeZone) this.zone.clone();
            this.sharedZone = false;
        }
        return this.zone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimeZone getZone() {
        return this.zone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setZoneShared(boolean shared) {
        this.sharedZone = shared;
    }

    public void setLenient(boolean lenient) {
        this.lenient = lenient;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public void setFirstDayOfWeek(int value) {
        if (this.firstDayOfWeek == value) {
            return;
        }
        this.firstDayOfWeek = value;
        invalidateWeekFields();
    }

    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public void setMinimalDaysInFirstWeek(int value) {
        if (this.minimalDaysInFirstWeek == value) {
            return;
        }
        this.minimalDaysInFirstWeek = value;
        invalidateWeekFields();
    }

    public int getMinimalDaysInFirstWeek() {
        return this.minimalDaysInFirstWeek;
    }

    public boolean isWeekDateSupported() {
        return false;
    }

    public int getWeekYear() {
        throw new UnsupportedOperationException();
    }

    public void setWeekDate(int weekYear, int weekOfYear, int dayOfWeek) {
        throw new UnsupportedOperationException();
    }

    public int getWeeksInWeekYear() {
        throw new UnsupportedOperationException();
    }

    public int getActualMinimum(int field) {
        int fieldValue = getGreatestMinimum(field);
        int endValue = getMinimum(field);
        if (fieldValue == endValue) {
            return fieldValue;
        }
        Calendar work = (Calendar) clone();
        work.setLenient(true);
        int result = fieldValue;
        do {
            work.set(field, fieldValue);
            if (work.get(field) != fieldValue) {
                break;
            }
            result = fieldValue;
            fieldValue--;
        } while (fieldValue >= endValue);
        return result;
    }

    public int getActualMaximum(int field) {
        int fieldValue = getLeastMaximum(field);
        int endValue = getMaximum(field);
        if (fieldValue == endValue) {
            return fieldValue;
        }
        Calendar work = (Calendar) clone();
        work.setLenient(true);
        if (field == 3 || field == 4) {
            work.set(7, this.firstDayOfWeek);
        }
        int result = fieldValue;
        do {
            work.set(field, fieldValue);
            if (work.get(field) != fieldValue) {
                break;
            }
            result = fieldValue;
            fieldValue++;
        } while (fieldValue <= endValue);
        return result;
    }

    public Object clone() {
        try {
            Calendar other = (Calendar) super.clone();
            other.fields = new int[17];
            other.isSet = new boolean[17];
            other.stamp = new int[17];
            for (int i10 = 0; i10 < 17; i10++) {
                other.fields[i10] = this.fields[i10];
                other.stamp[i10] = this.stamp[i10];
                other.isSet[i10] = this.isSet[i10];
            }
            if (!this.sharedZone) {
                other.zone = (TimeZone) this.zone.clone();
            }
            return other;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getFieldName(int field) {
        return FIELD_NAME[field];
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder(800);
        buffer.append(getClass().getName()).append('[');
        appendValue(buffer, "time", this.isTimeSet, this.time);
        buffer.append(",areFieldsSet=").append(this.areFieldsSet);
        buffer.append(",areAllFieldsSet=").append(this.areAllFieldsSet);
        buffer.append(",lenient=").append(this.lenient);
        buffer.append(",zone=").append((Object) this.zone);
        appendValue(buffer, ",firstDayOfWeek", true, this.firstDayOfWeek);
        appendValue(buffer, ",minimalDaysInFirstWeek", true, this.minimalDaysInFirstWeek);
        for (int i10 = 0; i10 < 17; i10++) {
            buffer.append(',');
            appendValue(buffer, FIELD_NAME[i10], isSet(i10), this.fields[i10]);
        }
        buffer.append(']');
        return buffer.toString();
    }

    private static void appendValue(StringBuilder sb2, String item, boolean valid, long value) {
        sb2.append(item).append('=');
        if (valid) {
            sb2.append(value);
        } else {
            sb2.append('?');
        }
    }

    private void setWeekCountData(Locale desiredLocale) {
        Locale desiredLocale2 = LocaleData.getCompatibleLocaleForBug159514442(desiredLocale);
        ConcurrentMap<Locale, int[]> concurrentMap = cachedLocaleData;
        int[] data = concurrentMap.get(desiredLocale2);
        if (data == null) {
            LocaleData localeData = LocaleData.get(desiredLocale2);
            data = new int[]{localeData.firstDayOfWeek.intValue(), localeData.minimalDaysInFirstWeek.intValue()};
            concurrentMap.putIfAbsent(desiredLocale2, data);
        }
        this.firstDayOfWeek = data[0];
        this.minimalDaysInFirstWeek = data[1];
    }

    private void updateTime() {
        computeTime();
        this.isTimeSet = true;
    }

    private int compareTo(long t2) {
        long thisTime = getMillisOf(this);
        if (thisTime > t2) {
            return 1;
        }
        return thisTime == t2 ? 0 : -1;
    }

    private static long getMillisOf(Calendar calendar) {
        if (calendar.isTimeSet) {
            return calendar.time;
        }
        Calendar cal = (Calendar) calendar.clone();
        cal.setLenient(true);
        return cal.getTimeInMillis();
    }

    private void adjustStamp() {
        int min;
        int max = 2;
        int newStamp = 2;
        do {
            min = Integer.MAX_VALUE;
            for (int v2 : this.stamp) {
                if (v2 >= newStamp && min > v2) {
                    min = v2;
                }
                if (max < v2) {
                    max = v2;
                }
            }
            if (max != min && min == Integer.MAX_VALUE) {
                break;
            }
            int i10 = 0;
            while (true) {
                int[] iArr = this.stamp;
                if (i10 >= iArr.length) {
                    break;
                }
                if (iArr[i10] == min) {
                    iArr[i10] = newStamp;
                }
                i10++;
            }
            newStamp++;
        } while (min != max);
        this.nextStamp = newStamp;
    }

    private void invalidateWeekFields() {
        int[] iArr = this.stamp;
        if (iArr[4] != 1 && iArr[3] != 1) {
            return;
        }
        Calendar cal = (Calendar) clone();
        cal.setLenient(true);
        cal.clear(4);
        cal.clear(3);
        if (this.stamp[4] == 1) {
            int weekOfMonth = cal.get(4);
            int[] iArr2 = this.fields;
            if (iArr2[4] != weekOfMonth) {
                iArr2[4] = weekOfMonth;
            }
        }
        if (this.stamp[3] == 1) {
            int weekOfYear = cal.get(3);
            int[] iArr3 = this.fields;
            if (iArr3[3] != weekOfYear) {
                iArr3[3] = weekOfYear;
            }
        }
    }

    private synchronized void writeObject(ObjectOutputStream stream) throws IOException {
        if (!this.isTimeSet) {
            try {
                updateTime();
            } catch (IllegalArgumentException e2) {
            }
        }
        stream.defaultWriteObject();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class CalendarAccessControlContext {
        private static final AccessControlContext INSTANCE;

        static {
            RuntimePermission perm = new RuntimePermission("accessClassInPackage.sun.util.calendar");
            PermissionCollection perms = perm.newPermissionCollection();
            perms.add(perm);
            INSTANCE = new AccessControlContext(new ProtectionDomain[]{new ProtectionDomain(null, perms)});
        }

        private CalendarAccessControlContext() {
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        String id2;
        TimeZone timeZone;
        objectInputStream.defaultReadObject();
        this.stamp = new int[17];
        int i10 = this.serialVersionOnStream;
        if (i10 >= 2) {
            this.isTimeSet = true;
            if (this.fields == null) {
                this.fields = new int[17];
            }
            if (this.isSet == null) {
                this.isSet = new boolean[17];
            }
        } else if (i10 >= 0) {
            for (int i11 = 0; i11 < 17; i11++) {
                this.stamp[i11] = this.isSet[i11] ? 1 : 0;
            }
        }
        this.serialVersionOnStream = 1;
        TimeZone timeZone2 = this.zone;
        if ((timeZone2 instanceof SimpleTimeZone) && (timeZone = TimeZone.getTimeZone((id2 = timeZone2.getID()))) != null && timeZone.hasSameRules(this.zone) && timeZone.getID().equals(id2)) {
            this.zone = timeZone;
        }
    }

    public final Instant toInstant() {
        return Instant.ofEpochMilli(getTimeInMillis());
    }
}
