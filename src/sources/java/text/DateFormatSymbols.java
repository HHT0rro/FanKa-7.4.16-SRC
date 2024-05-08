package java.text;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import libcore.icu.ICU;
import libcore.icu.LocaleData;
import libcore.icu.TimeZoneNames;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DateFormatSymbols implements Serializable, Cloneable {
    static final int PATTERN_AM_PM = 14;
    static final int PATTERN_DAY_OF_MONTH = 3;
    static final int PATTERN_DAY_OF_WEEK = 9;
    static final int PATTERN_DAY_OF_WEEK_IN_MONTH = 11;
    static final int PATTERN_DAY_OF_YEAR = 10;
    static final int PATTERN_DAY_PERIOD = 24;
    static final int PATTERN_ERA = 0;
    static final int PATTERN_FLEXIBLE_DAY_PERIOD = 25;
    static final int PATTERN_HOUR0 = 16;
    static final int PATTERN_HOUR1 = 15;
    static final int PATTERN_HOUR_OF_DAY0 = 5;
    static final int PATTERN_HOUR_OF_DAY1 = 4;
    static final int PATTERN_ISO_DAY_OF_WEEK = 20;
    static final int PATTERN_ISO_ZONE = 21;
    static final int PATTERN_MILLISECOND = 8;
    static final int PATTERN_MINUTE = 6;
    static final int PATTERN_MONTH = 2;
    static final int PATTERN_MONTH_STANDALONE = 22;
    static final int PATTERN_SECOND = 7;
    static final int PATTERN_STANDALONE_DAY_OF_WEEK = 23;
    static final int PATTERN_WEEK_OF_MONTH = 13;
    static final int PATTERN_WEEK_OF_YEAR = 12;
    static final int PATTERN_WEEK_YEAR = 19;
    static final int PATTERN_YEAR = 1;
    static final int PATTERN_ZONE_NAME = 17;
    static final int PATTERN_ZONE_VALUE = 18;
    private static final ConcurrentMap<Locale, SoftReference<DateFormatSymbols>> cachedInstances = new ConcurrentHashMap(3);
    static final int currentSerialVersion = 1;
    static final int millisPerHour = 3600000;
    static final String patternChars = "GyMdkHmsSEDFwWahKzZYuXLcbB";
    static final long serialVersionUID = -5987973545549424702L;
    volatile transient int cachedHashCode;
    private transient int lastZoneIndex;
    private String[] shortStandAloneMonths;
    private String[] shortStandAloneWeekdays;
    private String[] standAloneMonths;
    private String[] standAloneWeekdays;
    private String[] tinyMonths;
    private String[] tinyStandAloneMonths;
    private String[] tinyStandAloneWeekdays;
    private String[] tinyWeekdays;
    String[] eras = null;
    String[] months = null;
    String[] shortMonths = null;
    String[] weekdays = null;
    String[] shortWeekdays = null;
    String[] ampms = null;
    String[][] zoneStrings = null;
    transient boolean isZoneStringsSet = false;
    String localPatternChars = null;
    Locale locale = null;
    private int serialVersionOnStream = 1;

    public DateFormatSymbols() {
        initializeData(Locale.getDefault(Locale.Category.FORMAT));
    }

    public DateFormatSymbols(Locale locale) {
        initializeData(locale);
    }

    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableLocales();
    }

    public static final DateFormatSymbols getInstance() {
        return getInstance(Locale.getDefault(Locale.Category.FORMAT));
    }

    public static final DateFormatSymbols getInstance(Locale locale) {
        return (DateFormatSymbols) getCachedInstance(locale).clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final DateFormatSymbols getInstanceRef(Locale locale) {
        return getCachedInstance(locale);
    }

    private static DateFormatSymbols getCachedInstance(Locale locale) {
        DateFormatSymbols dfs;
        Locale cacheKey = LocaleData.getCompatibleLocaleForBug159514442(locale);
        ConcurrentMap<Locale, SoftReference<DateFormatSymbols>> concurrentMap = cachedInstances;
        SoftReference<DateFormatSymbols> ref = concurrentMap.get(cacheKey);
        if (ref != null && (dfs = ref.get()) != null) {
            return dfs;
        }
        DateFormatSymbols dfs2 = new DateFormatSymbols(locale);
        SoftReference<DateFormatSymbols> ref2 = new SoftReference<>(dfs2);
        SoftReference<DateFormatSymbols> x10 = concurrentMap.putIfAbsent(cacheKey, ref2);
        if (x10 == null) {
            return dfs2;
        }
        DateFormatSymbols y10 = x10.get();
        if (y10 != null) {
            return y10;
        }
        concurrentMap.put(cacheKey, ref2);
        return dfs2;
    }

    public String[] getEras() {
        String[] strArr = this.eras;
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public void setEras(String[] newEras) {
        this.eras = (String[]) Arrays.copyOf(newEras, newEras.length);
        this.cachedHashCode = 0;
    }

    public String[] getMonths() {
        String[] strArr = this.months;
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public void setMonths(String[] newMonths) {
        this.months = (String[]) Arrays.copyOf(newMonths, newMonths.length);
        this.cachedHashCode = 0;
    }

    public String[] getShortMonths() {
        String[] strArr = this.shortMonths;
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public void setShortMonths(String[] newShortMonths) {
        this.shortMonths = (String[]) Arrays.copyOf(newShortMonths, newShortMonths.length);
        this.cachedHashCode = 0;
    }

    public String[] getWeekdays() {
        String[] strArr = this.weekdays;
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public void setWeekdays(String[] newWeekdays) {
        this.weekdays = (String[]) Arrays.copyOf(newWeekdays, newWeekdays.length);
        this.cachedHashCode = 0;
    }

    public String[] getShortWeekdays() {
        String[] strArr = this.shortWeekdays;
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public void setShortWeekdays(String[] newShortWeekdays) {
        this.shortWeekdays = (String[]) Arrays.copyOf(newShortWeekdays, newShortWeekdays.length);
        this.cachedHashCode = 0;
    }

    public String[] getAmPmStrings() {
        String[] strArr = this.ampms;
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public void setAmPmStrings(String[] newAmpms) {
        this.ampms = (String[]) Arrays.copyOf(newAmpms, newAmpms.length);
        this.cachedHashCode = 0;
    }

    public String[][] getZoneStrings() {
        return getZoneStringsImpl(true);
    }

    public void setZoneStrings(String[][] newZoneStrings) {
        String[][] aCopy = new String[newZoneStrings.length];
        for (int i10 = 0; i10 < newZoneStrings.length; i10++) {
            int len = newZoneStrings[i10].length;
            if (len < 5) {
                throw new IllegalArgumentException();
            }
            aCopy[i10] = (String[]) Arrays.copyOf(newZoneStrings[i10], len);
        }
        this.zoneStrings = aCopy;
        this.isZoneStringsSet = true;
    }

    public String getLocalPatternChars() {
        return this.localPatternChars;
    }

    public void setLocalPatternChars(String newLocalPatternChars) {
        this.localPatternChars = newLocalPatternChars.toString();
        this.cachedHashCode = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] getTinyMonths() {
        return this.tinyMonths;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] getStandAloneMonths() {
        return this.standAloneMonths;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] getShortStandAloneMonths() {
        return this.shortStandAloneMonths;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] getTinyStandAloneMonths() {
        return this.tinyStandAloneMonths;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] getTinyWeekdays() {
        return this.tinyWeekdays;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] getStandAloneWeekdays() {
        return this.standAloneWeekdays;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] getShortStandAloneWeekdays() {
        return this.shortStandAloneWeekdays;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] getTinyStandAloneWeekdays() {
        return this.tinyStandAloneWeekdays;
    }

    public Object clone() {
        try {
            DateFormatSymbols other = (DateFormatSymbols) super.clone();
            copyMembers(this, other);
            return other;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2);
        }
    }

    public int hashCode() {
        int hashCode = this.cachedHashCode;
        if (hashCode == 0 && (hashCode = (((((((((((((5 * 11) + Arrays.hashCode(this.eras)) * 11) + Arrays.hashCode(this.months)) * 11) + Arrays.hashCode(this.shortMonths)) * 11) + Arrays.hashCode(this.weekdays)) * 11) + Arrays.hashCode(this.shortWeekdays)) * 11) + Arrays.hashCode(this.ampms)) * 11) + Objects.hashCode(this.localPatternChars)) != 0) {
            this.cachedHashCode = hashCode;
        }
        return hashCode;
    }

    public boolean equals(Object obj) {
        String str;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DateFormatSymbols that = (DateFormatSymbols) obj;
        if (!Arrays.equals(this.eras, that.eras) || !Arrays.equals(this.months, that.months) || !Arrays.equals(this.shortMonths, that.shortMonths) || !Arrays.equals(this.tinyMonths, that.tinyMonths) || !Arrays.equals(this.weekdays, that.weekdays) || !Arrays.equals(this.shortWeekdays, that.shortWeekdays) || !Arrays.equals(this.tinyWeekdays, that.tinyWeekdays) || !Arrays.equals(this.standAloneMonths, that.standAloneMonths) || !Arrays.equals(this.shortStandAloneMonths, that.shortStandAloneMonths) || !Arrays.equals(this.tinyStandAloneMonths, that.tinyStandAloneMonths) || !Arrays.equals(this.standAloneWeekdays, that.standAloneWeekdays) || !Arrays.equals(this.shortStandAloneWeekdays, that.shortStandAloneWeekdays) || !Arrays.equals(this.tinyStandAloneWeekdays, that.tinyStandAloneWeekdays) || !Arrays.equals(this.ampms, that.ampms) || (((str = this.localPatternChars) == null || !str.equals(that.localPatternChars)) && (this.localPatternChars != null || that.localPatternChars != null))) {
            return false;
        }
        if (!this.isZoneStringsSet && !that.isZoneStringsSet && Objects.equals(this.locale, that.locale)) {
            return true;
        }
        return Arrays.deepEquals(getZoneStringsWrapper(), that.getZoneStringsWrapper());
    }

    private void initializeData(Locale locale) {
        DateFormatSymbols dfs;
        Locale cacheKey = LocaleData.getCompatibleLocaleForBug159514442(locale);
        SoftReference<DateFormatSymbols> ref = cachedInstances.get(cacheKey);
        if (ref != null && (dfs = ref.get()) != null) {
            copyMembers(dfs, this);
            return;
        }
        Locale locale2 = LocaleData.mapInvalidAndNullLocales(locale);
        LocaleData localeData = LocaleData.get(locale2);
        this.locale = locale2;
        this.eras = localeData.eras;
        this.months = localeData.longMonthNames;
        this.shortMonths = localeData.shortMonthNames;
        this.ampms = localeData.amPm;
        this.localPatternChars = patternChars;
        this.weekdays = localeData.longWeekdayNames;
        this.shortWeekdays = localeData.shortWeekdayNames;
        initializeSupplementaryData(localeData);
    }

    private void initializeSupplementaryData(LocaleData localeData) {
        this.tinyMonths = localeData.tinyMonthNames;
        this.tinyWeekdays = localeData.tinyWeekdayNames;
        this.standAloneMonths = localeData.longStandAloneMonthNames;
        this.shortStandAloneMonths = localeData.shortStandAloneMonthNames;
        this.tinyStandAloneMonths = localeData.tinyStandAloneMonthNames;
        this.standAloneWeekdays = localeData.longStandAloneWeekdayNames;
        this.shortStandAloneWeekdays = localeData.shortStandAloneWeekdayNames;
        this.tinyStandAloneWeekdays = localeData.tinyStandAloneWeekdayNames;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getZoneIndex(String ID) {
        String[][] zoneStrings = getZoneStringsWrapper();
        int i10 = this.lastZoneIndex;
        if (i10 < zoneStrings.length && ID.equals(zoneStrings[i10][0])) {
            return this.lastZoneIndex;
        }
        for (int index = 0; index < zoneStrings.length; index++) {
            if (ID.equals(zoneStrings[index][0])) {
                this.lastZoneIndex = index;
                return index;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String[][] getZoneStringsWrapper() {
        if (isSubclassObject()) {
            return getZoneStrings();
        }
        return getZoneStringsImpl(false);
    }

    private synchronized String[][] internalZoneStrings() {
        if (this.zoneStrings == null) {
            this.zoneStrings = TimeZoneNames.getZoneStrings(this.locale);
        }
        return this.zoneStrings;
    }

    private String[][] getZoneStringsImpl(boolean needsCopy) {
        String[][] zoneStrings = internalZoneStrings();
        if (!needsCopy) {
            return zoneStrings;
        }
        int len = zoneStrings.length;
        String[][] aCopy = new String[len];
        for (int i10 = 0; i10 < len; i10++) {
            aCopy[i10] = (String[]) Arrays.copyOf(zoneStrings[i10], zoneStrings[i10].length);
        }
        return aCopy;
    }

    private boolean isSubclassObject() {
        return !getClass().getName().equals("java.text.DateFormatSymbols");
    }

    private void copyMembers(DateFormatSymbols src, DateFormatSymbols dst) {
        dst.locale = src.locale;
        String[] strArr = src.eras;
        dst.eras = (String[]) Arrays.copyOf(strArr, strArr.length);
        String[] strArr2 = src.months;
        dst.months = (String[]) Arrays.copyOf(strArr2, strArr2.length);
        String[] strArr3 = src.shortMonths;
        dst.shortMonths = (String[]) Arrays.copyOf(strArr3, strArr3.length);
        String[] strArr4 = src.weekdays;
        dst.weekdays = (String[]) Arrays.copyOf(strArr4, strArr4.length);
        String[] strArr5 = src.shortWeekdays;
        dst.shortWeekdays = (String[]) Arrays.copyOf(strArr5, strArr5.length);
        String[] strArr6 = src.ampms;
        dst.ampms = (String[]) Arrays.copyOf(strArr6, strArr6.length);
        if (src.zoneStrings != null) {
            dst.zoneStrings = src.getZoneStringsImpl(true);
        } else {
            dst.zoneStrings = null;
        }
        dst.localPatternChars = src.localPatternChars;
        dst.cachedHashCode = 0;
        dst.tinyMonths = src.tinyMonths;
        dst.tinyWeekdays = src.tinyWeekdays;
        dst.standAloneMonths = src.standAloneMonths;
        dst.shortStandAloneMonths = src.shortStandAloneMonths;
        dst.tinyStandAloneMonths = src.tinyStandAloneMonths;
        dst.standAloneWeekdays = src.standAloneWeekdays;
        dst.shortStandAloneWeekdays = src.shortStandAloneWeekdays;
        dst.tinyStandAloneWeekdays = src.tinyStandAloneWeekdays;
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        if (this.serialVersionOnStream < 1) {
            LocaleData localeData = LocaleData.get(this.locale);
            initializeSupplementaryData(localeData);
        }
        this.serialVersionOnStream = 1;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        internalZoneStrings();
        stream.defaultWriteObject();
    }
}
