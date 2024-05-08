package java.util;

import com.android.internal.logging.nano.MetricsProto;
import java.io.IOException;
import java.io.ObjectInputStream;
import sun.util.calendar.BaseCalendar;
import sun.util.calendar.CalendarDate;
import sun.util.calendar.CalendarSystem;
import sun.util.calendar.CalendarUtils;
import sun.util.calendar.Era;
import sun.util.calendar.Gregorian;
import sun.util.calendar.LocalGregorianCalendar;
import sun.util.locale.provider.CalendarDataUtility;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class JapaneseImperialCalendar extends Calendar {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BEFORE_MEIJI = 0;
    private static final Era BEFORE_MEIJI_ERA;
    private static final int EPOCH_OFFSET = 719163;
    public static final int HEISEI = 4;
    static final int[] LEAST_MAX_VALUES;
    static final int[] MAX_VALUES;
    public static final int MEIJI = 1;
    static final int[] MIN_VALUES;
    private static final long ONE_DAY = 86400000;
    private static final int ONE_HOUR = 3600000;
    private static final int ONE_MINUTE = 60000;
    private static final int ONE_SECOND = 1000;
    public static final int REIWA = 5;
    public static final int SHOWA = 3;
    public static final int TAISHO = 2;
    private static final int currentEra;
    private static final Era[] eras;
    private static final Gregorian gcal;
    private static final LocalGregorianCalendar jcal;
    private static final long serialVersionUID = -3364572813905467929L;
    private static final long[] sinceFixedDates;
    private transient long cachedFixedDate;
    private transient LocalGregorianCalendar.Date jdate;
    private transient int[] originalFields;
    private transient int[] zoneOffsets;

    static {
        LocalGregorianCalendar localGregorianCalendar = (LocalGregorianCalendar) CalendarSystem.forName("japanese");
        jcal = localGregorianCalendar;
        Gregorian gregorianCalendar = CalendarSystem.getGregorianCalendar();
        gcal = gregorianCalendar;
        Era era = new Era("BeforeMeiji", "BM", Long.MIN_VALUE, false);
        BEFORE_MEIJI_ERA = era;
        MIN_VALUES = new int[]{0, -292275055, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, -46800000, 0};
        LEAST_MAX_VALUES = new int[]{0, 0, 0, 0, 4, 28, 0, 7, 4, 1, 11, 23, 59, 59, 999, 50400000, 1200000};
        MAX_VALUES = new int[]{0, 292278994, 11, 53, 6, 31, 366, 7, 6, 1, 11, 23, 59, 59, 999, 50400000, 7200000};
        Era[] es = localGregorianCalendar.getEras();
        int i10 = 1;
        int length = es.length + 1;
        Era[] eraArr = new Era[length];
        eras = eraArr;
        long[] jArr = new long[length];
        sinceFixedDates = jArr;
        jArr[0] = gregorianCalendar.getFixedDate(era.getSinceDate());
        int index = 0 + 1;
        eraArr[0] = era;
        int length2 = es.length;
        int i11 = 0;
        while (i11 < length2) {
            Era e2 = es[i11];
            CalendarDate d10 = e2.getSinceDate();
            sinceFixedDates[index] = gcal.getFixedDate(d10);
            eras[index] = e2;
            i11++;
            index++;
        }
        currentEra = 5;
        int[] iArr = LEAST_MAX_VALUES;
        int[] iArr2 = MAX_VALUES;
        int length3 = eras.length - 1;
        iArr2[0] = length3;
        iArr[0] = length3;
        int year = Integer.MAX_VALUE;
        int dayOfYear = Integer.MAX_VALUE;
        CalendarDate date = gcal.newCalendarDate(TimeZone.NO_TIMEZONE);
        int i12 = 1;
        while (true) {
            Era[] eraArr2 = eras;
            if (i12 < eraArr2.length) {
                long fd2 = sinceFixedDates[i12];
                CalendarDate transitionDate = eraArr2[i12].getSinceDate();
                date.setDate(transitionDate.getYear(), i10, i10);
                Gregorian gregorian = gcal;
                long fdd = gregorian.getFixedDate(date);
                if (fd2 != fdd) {
                    dayOfYear = Math.min(((int) (fd2 - fdd)) + i10, dayOfYear);
                }
                date.setDate(transitionDate.getYear(), 12, 31);
                long fdd2 = gregorian.getFixedDate(date);
                if (fd2 != fdd2) {
                    dayOfYear = Math.min(((int) (fdd2 - fd2)) + 1, dayOfYear);
                }
                LocalGregorianCalendar.Date lgd = getCalendarDate(fd2 - 1);
                int y10 = lgd.getYear();
                if (lgd.getMonth() != 1 || lgd.getDayOfMonth() != 1) {
                    y10--;
                }
                year = Math.min(y10, year);
                i12++;
                i10 = 1;
            } else {
                int[] iArr3 = LEAST_MAX_VALUES;
                iArr3[1] = year;
                iArr3[6] = dayOfYear;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JapaneseImperialCalendar(TimeZone zone, Locale aLocale) {
        super(zone, aLocale);
        this.cachedFixedDate = Long.MIN_VALUE;
        this.jdate = jcal.newCalendarDate(zone);
        setTimeInMillis(System.currentTimeMillis());
    }

    JapaneseImperialCalendar(TimeZone zone, Locale aLocale, boolean flag) {
        super(zone, aLocale);
        this.cachedFixedDate = Long.MIN_VALUE;
        this.jdate = jcal.newCalendarDate(zone);
    }

    @Override // java.util.Calendar
    public String getCalendarType() {
        return "japanese";
    }

    @Override // java.util.Calendar
    public boolean equals(Object obj) {
        return (obj instanceof JapaneseImperialCalendar) && super.equals(obj);
    }

    @Override // java.util.Calendar
    public int hashCode() {
        return super.hashCode() ^ this.jdate.hashCode();
    }

    @Override // java.util.Calendar
    public void add(int field, int amount) {
        if (amount == 0) {
            return;
        }
        if (field < 0 || field >= 15) {
            throw new IllegalArgumentException();
        }
        complete();
        if (field == 1) {
            LocalGregorianCalendar.Date d10 = (LocalGregorianCalendar.Date) this.jdate.clone();
            d10.addYear(amount);
            pinDayOfMonth(d10);
            set(0, getEraIndex(d10));
            set(1, d10.getYear());
            set(2, d10.getMonth() - 1);
            set(5, d10.getDayOfMonth());
            return;
        }
        if (field == 2) {
            LocalGregorianCalendar.Date d11 = (LocalGregorianCalendar.Date) this.jdate.clone();
            d11.addMonth(amount);
            pinDayOfMonth(d11);
            set(0, getEraIndex(d11));
            set(1, d11.getYear());
            set(2, d11.getMonth() - 1);
            set(5, d11.getDayOfMonth());
            return;
        }
        if (field == 0) {
            int era = internalGet(0) + amount;
            if (era < 0) {
                era = 0;
            } else {
                Era[] eraArr = eras;
                if (era > eraArr.length - 1) {
                    era = eraArr.length - 1;
                }
            }
            set(0, era);
            return;
        }
        long delta = amount;
        long timeOfDay = 0;
        switch (field) {
            case 3:
            case 4:
            case 8:
                delta *= 7;
                break;
            case 9:
                delta = amount / 2;
                timeOfDay = (amount % 2) * 12;
                break;
            case 10:
            case 11:
                delta *= 3600000;
                break;
            case 12:
                delta *= 60000;
                break;
            case 13:
                delta *= 1000;
                break;
        }
        if (field >= 10) {
            setTimeInMillis(this.time + delta);
            return;
        }
        long fd2 = this.cachedFixedDate;
        long delta2 = delta;
        long timeOfDay2 = ((((((timeOfDay + internalGet(11)) * 60) + internalGet(12)) * 60) + internalGet(13)) * 1000) + internalGet(14);
        if (timeOfDay2 >= 86400000) {
            fd2++;
            timeOfDay2 -= 86400000;
        } else if (timeOfDay2 < 0) {
            fd2--;
            timeOfDay2 += 86400000;
        }
        long fd3 = fd2 + delta2;
        int zoneOffset = internalGet(15) + internalGet(16);
        setTimeInMillis((((fd3 - 719163) * 86400000) + timeOfDay2) - zoneOffset);
        int zoneOffset2 = zoneOffset - (internalGet(15) + internalGet(16));
        if (zoneOffset2 != 0) {
            setTimeInMillis(this.time + zoneOffset2);
            long fd22 = this.cachedFixedDate;
            if (fd22 != fd3) {
                setTimeInMillis(this.time - zoneOffset2);
            }
        }
    }

    @Override // java.util.Calendar
    public void roll(int field, boolean up) {
        roll(field, up ? 1 : -1);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0021. Please report as an issue. */
    @Override // java.util.Calendar
    public void roll(int field, int amount) {
        int min;
        int max;
        int min2;
        int max2;
        CalendarDate transition;
        int max3;
        int dom;
        int max4;
        int monthLength;
        long month1;
        long monthDay1st;
        int weekOfYear;
        if (amount == 0) {
            return;
        }
        if (field < 0 || field >= 15) {
            throw new IllegalArgumentException();
        }
        complete();
        int min3 = getMinimum(field);
        int max5 = getMaximum(field);
        switch (field) {
            case 0:
            case 9:
            case 12:
            case 13:
            case 14:
                min = min3;
                max = max5;
                min2 = min;
                max2 = max;
                set(field, getRolledValue(internalGet(field), amount, min2, max2));
                return;
            case 1:
                min2 = getActualMinimum(field);
                max2 = getActualMaximum(field);
                set(field, getRolledValue(internalGet(field), amount, min2, max2));
                return;
            case 2:
                int min4 = min3;
                if (!isTransitionYear(this.jdate.getNormalizedYear())) {
                    int year = this.jdate.getYear();
                    if (year != getMaximum(1)) {
                        if (year != getMinimum(1)) {
                            int mon = (internalGet(2) + amount) % 12;
                            if (mon < 0) {
                                mon += 12;
                            }
                            set(2, mon);
                            int monthLen = monthLength(mon);
                            if (internalGet(5) > monthLen) {
                                set(5, monthLen);
                            }
                            return;
                        }
                        LocalGregorianCalendar localGregorianCalendar = jcal;
                        CalendarDate jd2 = localGregorianCalendar.getCalendarDate(this.time, getZone());
                        CalendarDate d10 = localGregorianCalendar.getCalendarDate(Long.MIN_VALUE, getZone());
                        int min5 = d10.getMonth() - 1;
                        int n10 = getRolledValue(internalGet(field), amount, min5, max5);
                        if (n10 == min5) {
                            jd2.addYear(400);
                            jd2.setMonth(n10 + 1);
                            if (jd2.getDayOfMonth() < d10.getDayOfMonth()) {
                                jd2.setDayOfMonth(d10.getDayOfMonth());
                                localGregorianCalendar.normalize(jd2);
                            }
                            if (jd2.getDayOfMonth() == d10.getDayOfMonth() && jd2.getTimeOfDay() < d10.getTimeOfDay()) {
                                jd2.setMonth(n10 + 1);
                                jd2.setDayOfMonth(d10.getDayOfMonth() + 1);
                                localGregorianCalendar.normalize(jd2);
                                n10 = jd2.getMonth() - 1;
                            }
                            set(5, jd2.getDayOfMonth());
                        }
                        set(2, n10);
                        return;
                    }
                    LocalGregorianCalendar localGregorianCalendar2 = jcal;
                    CalendarDate jd3 = localGregorianCalendar2.getCalendarDate(this.time, getZone());
                    CalendarDate d11 = localGregorianCalendar2.getCalendarDate(Long.MAX_VALUE, getZone());
                    int max6 = d11.getMonth() - 1;
                    int n11 = getRolledValue(internalGet(field), amount, min4, max6);
                    if (n11 == max6) {
                        jd3.addYear(-400);
                        jd3.setMonth(n11 + 1);
                        if (jd3.getDayOfMonth() > d11.getDayOfMonth()) {
                            jd3.setDayOfMonth(d11.getDayOfMonth());
                            localGregorianCalendar2.normalize(jd3);
                        }
                        if (jd3.getDayOfMonth() == d11.getDayOfMonth() && jd3.getTimeOfDay() > d11.getTimeOfDay()) {
                            jd3.setMonth(n11 + 1);
                            jd3.setDayOfMonth(d11.getDayOfMonth() - 1);
                            localGregorianCalendar2.normalize(jd3);
                            n11 = jd3.getMonth() - 1;
                        }
                        set(5, jd3.getDayOfMonth());
                    }
                    set(2, n11);
                    return;
                }
                int eraIndex = getEraIndex(this.jdate);
                if (this.jdate.getYear() == 1) {
                    CalendarDate transition2 = eras[eraIndex].getSinceDate();
                    min4 = transition2.getMonth() - 1;
                    transition = transition2;
                    max3 = max5;
                } else {
                    Era[] eraArr = eras;
                    if (eraIndex >= eraArr.length - 1) {
                        transition = null;
                        max3 = max5;
                    } else {
                        CalendarDate transition3 = eraArr[eraIndex + 1].getSinceDate();
                        if (transition3.getYear() != this.jdate.getNormalizedYear()) {
                            transition = transition3;
                            max3 = max5;
                        } else {
                            int max7 = transition3.getMonth() - 1;
                            if (transition3.getDayOfMonth() != 1) {
                                transition = transition3;
                                max3 = max7;
                            } else {
                                int max8 = max7 - 1;
                                transition = transition3;
                                max3 = max8;
                            }
                        }
                    }
                }
                if (min4 == max3) {
                    return;
                }
                int n12 = getRolledValue(internalGet(field), amount, min4, max3);
                set(2, n12);
                if (n12 == min4) {
                    if ((transition.getMonth() != 1 || transition.getDayOfMonth() != 1) && this.jdate.getDayOfMonth() < transition.getDayOfMonth()) {
                        set(5, transition.getDayOfMonth());
                    }
                } else if (n12 == max3 && transition.getMonth() - 1 == n12 && this.jdate.getDayOfMonth() >= (dom = transition.getDayOfMonth())) {
                    set(5, dom - 1);
                }
                return;
            case 3:
                int min6 = min3;
                int y10 = this.jdate.getNormalizedYear();
                int max9 = getActualMaximum(3);
                set(7, internalGet(7));
                int woy = internalGet(3);
                int value = woy + amount;
                if (!isTransitionYear(this.jdate.getNormalizedYear())) {
                    int year2 = this.jdate.getYear();
                    if (year2 == getMaximum(1)) {
                        max9 = getActualMaximum(3);
                    } else if (year2 == getMinimum(1)) {
                        min6 = getActualMinimum(3);
                        max9 = getActualMaximum(3);
                        if (value > min6 && value < max9) {
                            set(3, value);
                            return;
                        }
                    }
                    if (value > min6 && value < max9) {
                        set(3, value);
                        return;
                    }
                    long fd2 = this.cachedFixedDate;
                    int max10 = max9;
                    long day1 = fd2 - ((woy - min6) * 7);
                    if (year2 != getMinimum(1)) {
                        if (gcal.getYearFromFixedDate(day1) == y10) {
                            max4 = max10;
                        } else {
                            min6++;
                            max4 = max10;
                        }
                    } else {
                        LocalGregorianCalendar localGregorianCalendar3 = jcal;
                        max4 = max10;
                        if (day1 < localGregorianCalendar3.getFixedDate(localGregorianCalendar3.getCalendarDate(Long.MIN_VALUE, getZone()))) {
                            min6++;
                        }
                    }
                    if (gcal.getYearFromFixedDate(fd2 + ((max4 - internalGet(3)) * 7)) == y10) {
                        min2 = min6;
                        max2 = max4;
                    } else {
                        min2 = min6;
                        max2 = max4 - 1;
                    }
                    set(field, getRolledValue(internalGet(field), amount, min2, max2));
                    return;
                }
                long fd3 = this.cachedFixedDate;
                long day12 = fd3 - ((woy - min6) * 7);
                LocalGregorianCalendar.Date d12 = getCalendarDate(day12);
                if (d12.getEra() != this.jdate.getEra() || d12.getYear() != this.jdate.getYear()) {
                    min6++;
                }
                jcal.getCalendarDateFromFixedDate(d12, fd3 + ((max9 - woy) * 7));
                if (d12.getEra() != this.jdate.getEra() || d12.getYear() != this.jdate.getYear()) {
                    max9--;
                }
                LocalGregorianCalendar.Date d13 = getCalendarDate(((getRolledValue(woy, amount, min6, max9) - 1) * 7) + day12);
                set(2, d13.getMonth() - 1);
                set(5, d13.getDayOfMonth());
                return;
            case 4:
                boolean isTransitionYear = isTransitionYear(this.jdate.getNormalizedYear());
                int dow = internalGet(7) - getFirstDayOfWeek();
                if (dow < 0) {
                    dow += 7;
                }
                long fd4 = this.cachedFixedDate;
                if (isTransitionYear) {
                    long month12 = getFixedDateMonth1(this.jdate, fd4);
                    monthLength = actualMonthLength();
                    month1 = month12;
                } else {
                    long month13 = (fd4 - internalGet(5)) + 1;
                    monthLength = jcal.getMonthLength(this.jdate);
                    month1 = month13;
                }
                long monthDay1st2 = LocalGregorianCalendar.getDayOfWeekDateOnOrBefore(6 + month1, getFirstDayOfWeek());
                if (((int) (monthDay1st2 - month1)) < getMinimalDaysInFirstWeek()) {
                    monthDay1st = monthDay1st2;
                } else {
                    monthDay1st = monthDay1st2 - 7;
                }
                long nfd = ((getRolledValue(internalGet(field), amount, 1, getActualMaximum(field)) - 1) * 7) + monthDay1st + dow;
                if (nfd < month1) {
                    nfd = month1;
                } else if (nfd >= monthLength + month1) {
                    nfd = (monthLength + month1) - 1;
                }
                set(5, ((int) (nfd - month1)) + 1);
                return;
            case 5:
                if (!isTransitionYear(this.jdate.getNormalizedYear())) {
                    max2 = jcal.getMonthLength(this.jdate);
                    min2 = min3;
                    set(field, getRolledValue(internalGet(field), amount, min2, max2));
                    return;
                } else {
                    long month14 = getFixedDateMonth1(this.jdate, this.cachedFixedDate);
                    set(5, getCalendarDate(getRolledValue((int) (this.cachedFixedDate - month14), amount, 0, actualMonthLength() - 1) + month14).getDayOfMonth());
                    return;
                }
            case 6:
                max2 = getActualMaximum(field);
                if (isTransitionYear(this.jdate.getNormalizedYear())) {
                    int value2 = getRolledValue(internalGet(6), amount, min3, max2);
                    long jan0 = this.cachedFixedDate - internalGet(6);
                    LocalGregorianCalendar.Date d14 = getCalendarDate(value2 + jan0);
                    set(2, d14.getMonth() - 1);
                    set(5, d14.getDayOfMonth());
                    return;
                }
                min2 = min3;
                set(field, getRolledValue(internalGet(field), amount, min2, max2));
                return;
            case 7:
                int normalizedYear = this.jdate.getNormalizedYear();
                if (!isTransitionYear(normalizedYear) && !isTransitionYear(normalizedYear - 1) && (weekOfYear = internalGet(3)) > 1 && weekOfYear < 52) {
                    set(3, internalGet(3));
                    max2 = 7;
                    min2 = min3;
                    set(field, getRolledValue(internalGet(field), amount, min2, max2));
                    return;
                }
                int amount2 = amount % 7;
                if (amount2 == 0) {
                    return;
                }
                long fd5 = this.cachedFixedDate;
                long dowFirst = LocalGregorianCalendar.getDayOfWeekDateOnOrBefore(fd5, getFirstDayOfWeek());
                long fd6 = fd5 + amount2;
                if (fd6 < dowFirst) {
                    fd6 += 7;
                } else if (fd6 >= dowFirst + 7) {
                    fd6 -= 7;
                }
                LocalGregorianCalendar.Date d15 = getCalendarDate(fd6);
                set(0, getEraIndex(d15));
                set(d15.getYear(), d15.getMonth() - 1, d15.getDayOfMonth());
                return;
            case 8:
                min2 = 1;
                if (!isTransitionYear(this.jdate.getNormalizedYear())) {
                    int dom2 = internalGet(5);
                    int monthLength2 = jcal.getMonthLength(this.jdate);
                    int lastDays = monthLength2 % 7;
                    max2 = monthLength2 / 7;
                    if ((dom2 - 1) % 7 < lastDays) {
                        max2++;
                    }
                    set(7, internalGet(7));
                    set(field, getRolledValue(internalGet(field), amount, min2, max2));
                    return;
                }
                long fd7 = this.cachedFixedDate;
                long month15 = getFixedDateMonth1(this.jdate, fd7);
                int monthLength3 = actualMonthLength();
                int lastDays2 = monthLength3 % 7;
                int max11 = monthLength3 / 7;
                int x10 = ((int) (fd7 - month15)) % 7;
                if (x10 < lastDays2) {
                    max11++;
                }
                set(5, getCalendarDate(((getRolledValue(internalGet(field), amount, 1, max11) - 1) * 7) + month15 + x10).getDayOfMonth());
                return;
            case 10:
            case 11:
                int min7 = max5 + 1;
                int h10 = internalGet(field);
                int nh = (h10 + amount) % min7;
                if (nh < 0) {
                    nh += min7;
                }
                this.time += (nh - h10) * 3600000;
                LocalGregorianCalendar localGregorianCalendar4 = jcal;
                CalendarDate d16 = localGregorianCalendar4.getCalendarDate(this.time, getZone());
                if (internalGet(5) != d16.getDayOfMonth()) {
                    d16.setEra(this.jdate.getEra());
                    d16.setDate(internalGet(1), internalGet(2) + 1, internalGet(5));
                    if (field == 10) {
                        d16.addHours(12);
                    }
                    this.time = localGregorianCalendar4.getTime(d16);
                }
                int hourOfDay = d16.getHours();
                internalSet(field, hourOfDay % min7);
                if (field == 10) {
                    internalSet(11, hourOfDay);
                } else {
                    internalSet(9, hourOfDay / 12);
                    internalSet(10, hourOfDay % 12);
                }
                int zoneOffset = d16.getZoneOffset();
                int saving = d16.getDaylightSaving();
                internalSet(15, zoneOffset - saving);
                internalSet(16, saving);
                return;
            default:
                min = min3;
                max = max5;
                min2 = min;
                max2 = max;
                set(field, getRolledValue(internalGet(field), amount, min2, max2));
                return;
        }
    }

    @Override // java.util.Calendar
    public String getDisplayName(int field, int style, Locale locale) {
        if (!checkDisplayNameParams(field, style, 1, 4, locale, MetricsProto.MetricsEvent.ACTION_PERMISSION_GRANT_READ_CONTACTS)) {
            return null;
        }
        int fieldValue = get(field);
        if (field == 1 && (getBaseStyle(style) != 2 || fieldValue != 1 || get(0) == 0)) {
            return null;
        }
        String name = CalendarDataUtility.retrieveFieldValueName(getCalendarType(), field, fieldValue, style, locale);
        if ((name != null && !name.isEmpty()) || field != 0) {
            return name;
        }
        Era[] eraArr = eras;
        if (fieldValue < eraArr.length) {
            Era era = eraArr[fieldValue];
            return style == 1 ? era.getAbbreviation() : era.getName();
        }
        return name;
    }

    @Override // java.util.Calendar
    public Map<String, Integer> getDisplayNames(int field, int style, Locale locale) {
        if (!checkDisplayNameParams(field, style, 0, 4, locale, MetricsProto.MetricsEvent.ACTION_PERMISSION_GRANT_READ_CONTACTS)) {
            return null;
        }
        Map<String, Integer> names = CalendarDataUtility.retrieveFieldValueNames(getCalendarType(), field, style, locale);
        if (names != null && field == 0) {
            int size = names.size();
            if (style == 0) {
                Set<Integer> values = new HashSet<>();
                for (String key : names.h()) {
                    values.add(names.get(key));
                }
                size = values.size();
            }
            if (size < eras.length) {
                int baseStyle = getBaseStyle(style);
                int i10 = 0;
                while (true) {
                    Era[] eraArr = eras;
                    if (i10 >= eraArr.length) {
                        break;
                    }
                    if (!names.values().contains(Integer.valueOf(i10))) {
                        Era era = eraArr[i10];
                        if (baseStyle == 0 || baseStyle == 1 || baseStyle == 4) {
                            names.put(era.getAbbreviation(), Integer.valueOf(i10));
                        }
                        if (baseStyle == 0 || baseStyle == 2) {
                            names.put(era.getName(), Integer.valueOf(i10));
                        }
                    }
                    i10++;
                }
            }
        }
        return names;
    }

    @Override // java.util.Calendar
    public int getMinimum(int field) {
        return MIN_VALUES[field];
    }

    @Override // java.util.Calendar
    public int getMaximum(int field) {
        switch (field) {
            case 1:
                LocalGregorianCalendar.Date d10 = jcal.getCalendarDate(Long.MAX_VALUE, getZone());
                return Math.max(LEAST_MAX_VALUES[1], d10.getYear());
            default:
                return MAX_VALUES[field];
        }
    }

    @Override // java.util.Calendar
    public int getGreatestMinimum(int field) {
        if (field == 1) {
            return 1;
        }
        return MIN_VALUES[field];
    }

    @Override // java.util.Calendar
    public int getLeastMaximum(int field) {
        switch (field) {
            case 1:
                return Math.min(LEAST_MAX_VALUES[1], getMaximum(1));
            default:
                return LEAST_MAX_VALUES[field];
        }
    }

    @Override // java.util.Calendar
    public int getActualMinimum(int field) {
        if (!isFieldSet(14, field)) {
            return getMinimum(field);
        }
        JapaneseImperialCalendar jc2 = getNormalizedCalendar();
        LocalGregorianCalendar localGregorianCalendar = jcal;
        LocalGregorianCalendar.Date jd2 = localGregorianCalendar.getCalendarDate(jc2.getTimeInMillis(), getZone());
        int eraIndex = getEraIndex(jd2);
        switch (field) {
            case 1:
                if (eraIndex > 0) {
                    long since = eras[eraIndex].getSince(getZone());
                    CalendarDate d10 = localGregorianCalendar.getCalendarDate(since, getZone());
                    jd2.setYear(d10.getYear());
                    localGregorianCalendar.normalize(jd2);
                    if (getYearOffsetInMillis(jd2) >= getYearOffsetInMillis(d10)) {
                        return 1;
                    }
                    return 1 + 1;
                }
                int value = getMinimum(field);
                CalendarDate d11 = localGregorianCalendar.getCalendarDate(Long.MIN_VALUE, getZone());
                int y10 = d11.getYear();
                if (y10 > 400) {
                    y10 -= 400;
                }
                jd2.setYear(y10);
                localGregorianCalendar.normalize(jd2);
                if (getYearOffsetInMillis(jd2) < getYearOffsetInMillis(d11)) {
                    return value + 1;
                }
                return value;
            case 2:
                if (eraIndex <= 1 || jd2.getYear() != 1) {
                    return 0;
                }
                long since2 = eras[eraIndex].getSince(getZone());
                CalendarDate d12 = localGregorianCalendar.getCalendarDate(since2, getZone());
                int value2 = d12.getMonth() - 1;
                if (jd2.getDayOfMonth() >= d12.getDayOfMonth()) {
                    return value2;
                }
                return value2 + 1;
            case 3:
                CalendarDate d13 = localGregorianCalendar.getCalendarDate(Long.MIN_VALUE, getZone());
                d13.addYear(400);
                localGregorianCalendar.normalize(d13);
                jd2.setEra(d13.getEra());
                jd2.setYear(d13.getYear());
                localGregorianCalendar.normalize(jd2);
                long jan1 = localGregorianCalendar.getFixedDate(d13);
                long fd2 = localGregorianCalendar.getFixedDate(jd2);
                int woy = getWeekNumber(jan1, fd2);
                long day1 = fd2 - ((woy - 1) * 7);
                if (day1 >= jan1 && (day1 != jan1 || jd2.getTimeOfDay() >= d13.getTimeOfDay())) {
                    return 1;
                }
                return 1 + 1;
            default:
                return 0;
        }
    }

    @Override // java.util.Calendar
    public int getActualMaximum(int field) {
        CalendarDate d10;
        int value;
        int value2;
        int value3;
        int value4;
        if (((1 << field) & 130689) != 0) {
            return getMaximum(field);
        }
        JapaneseImperialCalendar jc2 = getNormalizedCalendar();
        LocalGregorianCalendar.Date date = jc2.jdate;
        date.getNormalizedYear();
        switch (field) {
            case 1:
                LocalGregorianCalendar localGregorianCalendar = jcal;
                CalendarDate jd2 = localGregorianCalendar.getCalendarDate(jc2.getTimeInMillis(), getZone());
                int eraIndex = getEraIndex(date);
                Era[] eraArr = eras;
                if (eraIndex == eraArr.length - 1) {
                    d10 = localGregorianCalendar.getCalendarDate(Long.MAX_VALUE, getZone());
                    value = d10.getYear();
                    if (value > 400) {
                        jd2.setYear(value - 400);
                    }
                } else {
                    d10 = localGregorianCalendar.getCalendarDate(eraArr[eraIndex + 1].getSince(getZone()) - 1, getZone());
                    value = d10.getYear();
                    jd2.setYear(value);
                }
                localGregorianCalendar.normalize(jd2);
                if (getYearOffsetInMillis(jd2) <= getYearOffsetInMillis(d10)) {
                    return value;
                }
                return value - 1;
            case 2:
                if (isTransitionYear(date.getNormalizedYear())) {
                    int eraIndex2 = getEraIndex(date);
                    if (date.getYear() != 1) {
                        eraIndex2++;
                    }
                    long transition = sinceFixedDates[eraIndex2];
                    if (jc2.cachedFixedDate >= transition) {
                        return 11;
                    }
                    LocalGregorianCalendar.Date ldate = (LocalGregorianCalendar.Date) date.clone();
                    jcal.getCalendarDateFromFixedDate(ldate, transition - 1);
                    return ldate.getMonth() - 1;
                }
                LocalGregorianCalendar.Date d11 = jcal.getCalendarDate(Long.MAX_VALUE, getZone());
                if (date.getEra() == d11.getEra() && date.getYear() == d11.getYear()) {
                    return d11.getMonth() - 1;
                }
                return 11;
            case 3:
                int fieldsForFixedMax = date.getNormalizedYear();
                if (isTransitionYear(fieldsForFixedMax)) {
                    if (jc2 == this) {
                        jc2 = (JapaneseImperialCalendar) jc2.clone();
                    }
                    int max = getActualMaximum(6);
                    jc2.set(6, max);
                    int value5 = jc2.get(3);
                    if (value5 == 1 && max > 7) {
                        jc2.add(3, -1);
                        return jc2.get(3);
                    }
                    return value5;
                }
                LocalGregorianCalendar localGregorianCalendar2 = jcal;
                LocalGregorianCalendar.Date jd3 = localGregorianCalendar2.getCalendarDate(Long.MAX_VALUE, getZone());
                if (date.getEra() != jd3.getEra() || date.getYear() != jd3.getYear()) {
                    if (date.getEra() == null && date.getYear() == getMinimum(1)) {
                        CalendarDate d12 = localGregorianCalendar2.getCalendarDate(Long.MIN_VALUE, getZone());
                        d12.addYear(400);
                        localGregorianCalendar2.normalize(d12);
                        jd3.setEra(d12.getEra());
                        jd3.setDate(d12.getYear() + 1, 1, 1);
                        localGregorianCalendar2.normalize(jd3);
                        long jan1 = localGregorianCalendar2.getFixedDate(d12);
                        long nextJan1 = localGregorianCalendar2.getFixedDate(jd3);
                        long nextJan1st = LocalGregorianCalendar.getDayOfWeekDateOnOrBefore(6 + nextJan1, getFirstDayOfWeek());
                        int ndays = (int) (nextJan1st - nextJan1);
                        if (ndays >= getMinimalDaysInFirstWeek()) {
                            nextJan1st -= 7;
                        }
                        return getWeekNumber(jan1, nextJan1st);
                    }
                    Gregorian gregorian = gcal;
                    CalendarDate d13 = gregorian.newCalendarDate(TimeZone.NO_TIMEZONE);
                    d13.setDate(date.getNormalizedYear(), 1, 1);
                    int dayOfWeek = gregorian.getDayOfWeek(d13) - getFirstDayOfWeek();
                    if (dayOfWeek < 0) {
                        dayOfWeek += 7;
                    }
                    int value6 = 52;
                    int magic = (getMinimalDaysInFirstWeek() + dayOfWeek) - 1;
                    if (magic == 6 || (date.isLeapYear() && (magic == 5 || magic == 12))) {
                        value6 = 52 + 1;
                    }
                    return value6;
                }
                long fd2 = localGregorianCalendar2.getFixedDate(jd3);
                long jan12 = getFixedDateJan1(jd3, fd2);
                return getWeekNumber(jan12, fd2);
            case 4:
                LocalGregorianCalendar localGregorianCalendar3 = jcal;
                LocalGregorianCalendar.Date jd4 = localGregorianCalendar3.getCalendarDate(Long.MAX_VALUE, getZone());
                if (date.getEra() != jd4.getEra() || date.getYear() != jd4.getYear()) {
                    Gregorian gregorian2 = gcal;
                    CalendarDate d14 = gregorian2.newCalendarDate(TimeZone.NO_TIMEZONE);
                    d14.setDate(date.getNormalizedYear(), date.getMonth(), 1);
                    int dayOfWeek2 = gregorian2.getDayOfWeek(d14);
                    int monthLength = gregorian2.getMonthLength(d14);
                    int dayOfWeek3 = dayOfWeek2 - getFirstDayOfWeek();
                    if (dayOfWeek3 < 0) {
                        dayOfWeek3 += 7;
                    }
                    int nDaysFirstWeek = 7 - dayOfWeek3;
                    int value7 = 3;
                    if (nDaysFirstWeek >= getMinimalDaysInFirstWeek()) {
                        value7 = 3 + 1;
                    }
                    int monthLength2 = monthLength - (nDaysFirstWeek + 21);
                    if (monthLength2 > 0) {
                        value7++;
                        if (monthLength2 > 7) {
                            value7++;
                        }
                    }
                    value2 = value7;
                } else {
                    long fd3 = localGregorianCalendar3.getFixedDate(jd4);
                    long month1 = (fd3 - jd4.getDayOfMonth()) + 1;
                    value2 = getWeekNumber(month1, fd3);
                }
                return value2;
            case 5:
                return jcal.getMonthLength(date);
            case 6:
                if (isTransitionYear(date.getNormalizedYear())) {
                    int eraIndex3 = getEraIndex(date);
                    if (date.getYear() != 1) {
                        eraIndex3++;
                    }
                    long transition2 = sinceFixedDates[eraIndex3];
                    long fd4 = jc2.cachedFixedDate;
                    Gregorian gregorian3 = gcal;
                    CalendarDate d15 = gregorian3.newCalendarDate(TimeZone.NO_TIMEZONE);
                    d15.setDate(date.getNormalizedYear(), 1, 1);
                    if (fd4 >= transition2) {
                        d15.addYear(1);
                        value4 = (int) (gregorian3.getFixedDate(d15) - transition2);
                    } else {
                        value4 = (int) (transition2 - gregorian3.getFixedDate(d15));
                    }
                    return value4;
                }
                LocalGregorianCalendar localGregorianCalendar4 = jcal;
                LocalGregorianCalendar.Date d16 = localGregorianCalendar4.getCalendarDate(Long.MAX_VALUE, getZone());
                if (date.getEra() != d16.getEra() || date.getYear() != d16.getYear()) {
                    if (date.getYear() == getMinimum(1)) {
                        CalendarDate d17 = localGregorianCalendar4.getCalendarDate(Long.MIN_VALUE, getZone());
                        long fd1 = localGregorianCalendar4.getFixedDate(d17);
                        d17.addYear(1);
                        d17.setMonth(1).setDayOfMonth(1);
                        localGregorianCalendar4.normalize(d17);
                        long fd22 = localGregorianCalendar4.getFixedDate(d17);
                        value3 = (int) (fd22 - fd1);
                    } else {
                        value3 = localGregorianCalendar4.getYearLength(date);
                    }
                } else {
                    long fd5 = localGregorianCalendar4.getFixedDate(d16);
                    long jan13 = getFixedDateJan1(d16, fd5);
                    value3 = ((int) (fd5 - jan13)) + 1;
                }
                return value3;
            case 7:
            default:
                throw new ArrayIndexOutOfBoundsException(field);
            case 8:
                int dow = date.getDayOfWeek();
                BaseCalendar.Date d18 = (BaseCalendar.Date) date.clone();
                LocalGregorianCalendar localGregorianCalendar5 = jcal;
                int ndays2 = localGregorianCalendar5.getMonthLength(d18);
                d18.setDayOfMonth(1);
                localGregorianCalendar5.normalize(d18);
                int dow1 = d18.getDayOfWeek();
                int x10 = dow - dow1;
                if (x10 < 0) {
                    x10 += 7;
                }
                return ((ndays2 - x10) + 6) / 7;
        }
    }

    private long getYearOffsetInMillis(CalendarDate date) {
        long t2 = (jcal.getDayOfYear(date) - 1) * 86400000;
        return (date.getTimeOfDay() + t2) - date.getZoneOffset();
    }

    @Override // java.util.Calendar
    public Object clone() {
        JapaneseImperialCalendar other = (JapaneseImperialCalendar) super.clone();
        other.jdate = (LocalGregorianCalendar.Date) this.jdate.clone();
        other.originalFields = null;
        other.zoneOffsets = null;
        return other;
    }

    @Override // java.util.Calendar
    public TimeZone getTimeZone() {
        TimeZone zone = super.getTimeZone();
        this.jdate.setZone(zone);
        return zone;
    }

    @Override // java.util.Calendar
    public void setTimeZone(TimeZone zone) {
        super.setTimeZone(zone);
        this.jdate.setZone(zone);
    }

    @Override // java.util.Calendar
    protected void computeFields() {
        int mask;
        if (isPartiallyNormalized()) {
            mask = getSetStateFields();
            int fieldMask = (~mask) & 131071;
            if (fieldMask != 0 || this.cachedFixedDate == Long.MIN_VALUE) {
                mask |= computeFields(fieldMask, 98304 & mask);
            }
        } else {
            mask = 131071;
            computeFields(131071, 0);
        }
        setFieldsComputed(mask);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x022c, code lost:
    
        if (r32.jdate.getYear() != 1) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x022f, code lost:
    
        if (r10 <= 5) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0231, code lost:
    
        r9 = java.util.JapaneseImperialCalendar.eras[r10 - 1].getSinceDate();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x023f, code lost:
    
        if (r2 != r9.getYear()) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0241, code lost:
    
        r8.setMonth(r9.getMonth()).setDayOfMonth(r9.getDayOfMonth());
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0260, code lost:
    
        r2 = java.util.JapaneseImperialCalendar.jcal;
        r2.normalize(r8);
        r8 = r2.getFixedDate(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0256, code lost:
    
        r8.setMonth(1).setDayOfMonth(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x026d, code lost:
    
        r25 = r6 - 365;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0275, code lost:
    
        if (r8.isLeapYear() == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0277, code lost:
    
        r8 = r25 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x027d, code lost:
    
        r8 = r25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int computeFields(int r33, int r34) {
        /*
            Method dump skipped, instructions count: 895
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.JapaneseImperialCalendar.computeFields(int, int):int");
    }

    private int getWeekNumber(long fixedDay1, long fixedDate) {
        long fixedDay1st = LocalGregorianCalendar.getDayOfWeekDateOnOrBefore(6 + fixedDay1, getFirstDayOfWeek());
        int ndays = (int) (fixedDay1st - fixedDay1);
        if (ndays >= getMinimalDaysInFirstWeek()) {
            fixedDay1st -= 7;
        }
        int normalizedDayOfPeriod = (int) (fixedDate - fixedDay1st);
        if (normalizedDayOfPeriod >= 0) {
            return (normalizedDayOfPeriod / 7) + 1;
        }
        return CalendarUtils.floorDivide(normalizedDayOfPeriod, 7) + 1;
    }

    @Override // java.util.Calendar
    protected void computeTime() {
        int era;
        int year;
        long timeOfDay;
        char c4;
        if (!isLenient()) {
            if (this.originalFields == null) {
                this.originalFields = new int[17];
            }
            for (int field = 0; field < 17; field++) {
                int value = internalGet(field);
                if (isExternallySet(field) && (value < getMinimum(field) || value > getMaximum(field))) {
                    throw new IllegalArgumentException(getFieldName(field));
                }
                this.originalFields[field] = value;
            }
        }
        int fieldMask = selectFields();
        if (isSet(0)) {
            era = internalGet(0);
            year = isSet(1) ? internalGet(1) : 1;
        } else if (isSet(1)) {
            era = currentEra;
            year = internalGet(1);
        } else {
            era = 3;
            year = 45;
        }
        if (isFieldSet(fieldMask, 11)) {
            timeOfDay = 0 + internalGet(11);
        } else {
            timeOfDay = 0 + internalGet(10);
            if (isFieldSet(fieldMask, 9)) {
                timeOfDay += internalGet(9) * 12;
            }
        }
        long timeOfDay2 = (((((timeOfDay * 60) + internalGet(12)) * 60) + internalGet(13)) * 1000) + internalGet(14);
        long fixedDate = timeOfDay2 / 86400000;
        long timeOfDay3 = timeOfDay2 % 86400000;
        while (timeOfDay3 < 0) {
            timeOfDay3 += 86400000;
            fixedDate--;
        }
        long millis = (((fixedDate + getFixedDate(era, year, fieldMask)) - 719163) * 86400000) + timeOfDay3;
        TimeZone zone = getZone();
        if (this.zoneOffsets == null) {
            this.zoneOffsets = new int[2];
        }
        int tzMask = fieldMask & 98304;
        if (tzMask != 98304) {
            zone.getOffsets(millis - zone.getRawOffset(), this.zoneOffsets);
        }
        if (tzMask == 0) {
            c4 = 1;
        } else {
            if (isFieldSet(tzMask, 15)) {
                this.zoneOffsets[0] = internalGet(15);
            }
            if (isFieldSet(tzMask, 16)) {
                c4 = 1;
                this.zoneOffsets[1] = internalGet(16);
            } else {
                c4 = 1;
            }
        }
        int[] iArr = this.zoneOffsets;
        this.time = millis - (iArr[0] + iArr[c4]);
        int mask = computeFields(getSetStateFields() | fieldMask, tzMask);
        if (!isLenient()) {
            int field2 = 0;
            for (int i10 = 17; field2 < i10; i10 = 17) {
                if (!isExternallySet(field2) || this.originalFields[field2] == internalGet(field2)) {
                    field2++;
                } else {
                    int wrongValue = internalGet(field2);
                    System.arraycopy((Object) this.originalFields, 0, (Object) this.fields, 0, this.fields.length);
                    throw new IllegalArgumentException(getFieldName(field2) + "=" + wrongValue + ", expected " + this.originalFields[field2]);
                }
            }
        }
        setFieldsNormalized(mask);
    }

    private long getFixedDate(int era, int year, int fieldMask) {
        int dayOfWeek;
        int dayOfWeek2;
        int dowim;
        int year2 = year;
        int month = 0;
        int firstDayOfMonth = 1;
        if (isFieldSet(fieldMask, 2)) {
            month = internalGet(2);
            if (month > 11) {
                year2 += month / 12;
                month %= 12;
            } else if (month < 0) {
                int[] rem = new int[1];
                year2 += CalendarUtils.floorDivide(month, 12, rem);
                month = rem[0];
            }
        } else if (year2 == 1 && era != 0) {
            CalendarDate d10 = eras[era].getSinceDate();
            month = d10.getMonth() - 1;
            firstDayOfMonth = d10.getDayOfMonth();
        }
        if (year2 == MIN_VALUES[1]) {
            CalendarDate dx = jcal.getCalendarDate(Long.MIN_VALUE, getZone());
            int m10 = dx.getMonth() - 1;
            if (month < m10) {
                month = m10;
            }
            if (month == m10) {
                firstDayOfMonth = dx.getDayOfMonth();
            }
        }
        LocalGregorianCalendar localGregorianCalendar = jcal;
        LocalGregorianCalendar.Date date = localGregorianCalendar.newCalendarDate(TimeZone.NO_TIMEZONE);
        date.setEra(era > 0 ? eras[era] : null);
        date.setDate(year2, month + 1, firstDayOfMonth);
        localGregorianCalendar.normalize(date);
        long fixedDate = localGregorianCalendar.getFixedDate(date);
        if (isFieldSet(fieldMask, 2)) {
            if (isFieldSet(fieldMask, 5)) {
                if (isSet(5)) {
                    return (fixedDate + internalGet(5)) - firstDayOfMonth;
                }
                return fixedDate;
            }
            if (isFieldSet(fieldMask, 4)) {
                long firstDayOfWeek = LocalGregorianCalendar.getDayOfWeekDateOnOrBefore(fixedDate + 6, getFirstDayOfWeek());
                if (firstDayOfWeek - fixedDate >= getMinimalDaysInFirstWeek()) {
                    firstDayOfWeek -= 7;
                }
                if (isFieldSet(fieldMask, 7)) {
                    firstDayOfWeek = LocalGregorianCalendar.getDayOfWeekDateOnOrBefore(firstDayOfWeek + 6, internalGet(7));
                }
                return firstDayOfWeek + ((internalGet(4) - 1) * 7);
            }
            if (isFieldSet(fieldMask, 7)) {
                dayOfWeek2 = internalGet(7);
            } else {
                dayOfWeek2 = getFirstDayOfWeek();
            }
            if (isFieldSet(fieldMask, 8)) {
                dowim = internalGet(8);
            } else {
                dowim = 1;
            }
            if (dowim >= 0) {
                return LocalGregorianCalendar.getDayOfWeekDateOnOrBefore(((dowim * 7) + fixedDate) - 1, dayOfWeek2);
            }
            int lastDate = monthLength(month, year2) + ((dowim + 1) * 7);
            return LocalGregorianCalendar.getDayOfWeekDateOnOrBefore((lastDate + fixedDate) - 1, dayOfWeek2);
        }
        if (isFieldSet(fieldMask, 6)) {
            if (isTransitionYear(date.getNormalizedYear())) {
                fixedDate = getFixedDateJan1(date, fixedDate);
            }
            return (fixedDate + internalGet(6)) - 1;
        }
        long firstDayOfWeek2 = LocalGregorianCalendar.getDayOfWeekDateOnOrBefore(fixedDate + 6, getFirstDayOfWeek());
        if (firstDayOfWeek2 - fixedDate >= getMinimalDaysInFirstWeek()) {
            firstDayOfWeek2 -= 7;
        }
        if (isFieldSet(fieldMask, 7) && (dayOfWeek = internalGet(7)) != getFirstDayOfWeek()) {
            firstDayOfWeek2 = LocalGregorianCalendar.getDayOfWeekDateOnOrBefore(firstDayOfWeek2 + 6, dayOfWeek);
        }
        return firstDayOfWeek2 + ((internalGet(3) - 1) * 7);
    }

    private long getFixedDateJan1(LocalGregorianCalendar.Date date, long fixedDate) {
        date.getEra();
        if (date.getEra() != null && date.getYear() == 1) {
            for (int eraIndex = getEraIndex(date); eraIndex > 0; eraIndex--) {
                long fd2 = gcal.getFixedDate(eras[eraIndex].getSinceDate());
                if (fd2 <= fixedDate) {
                    return fd2;
                }
            }
        }
        Gregorian gregorian = gcal;
        CalendarDate d10 = gregorian.newCalendarDate(TimeZone.NO_TIMEZONE);
        d10.setDate(date.getNormalizedYear(), 1, 1);
        return gregorian.getFixedDate(d10);
    }

    private long getFixedDateMonth1(LocalGregorianCalendar.Date date, long fixedDate) {
        int eraIndex = getTransitionEraIndex(date);
        if (eraIndex != -1) {
            long transition = sinceFixedDates[eraIndex];
            if (transition <= fixedDate) {
                return transition;
            }
        }
        return (fixedDate - date.getDayOfMonth()) + 1;
    }

    private static LocalGregorianCalendar.Date getCalendarDate(long fd2) {
        LocalGregorianCalendar localGregorianCalendar = jcal;
        LocalGregorianCalendar.Date d10 = localGregorianCalendar.newCalendarDate(TimeZone.NO_TIMEZONE);
        localGregorianCalendar.getCalendarDateFromFixedDate(d10, fd2);
        return d10;
    }

    private int monthLength(int month, int gregorianYear) {
        return CalendarUtils.isGregorianLeapYear(gregorianYear) ? GregorianCalendar.LEAP_MONTH_LENGTH[month] : GregorianCalendar.MONTH_LENGTH[month];
    }

    private int monthLength(int month) {
        return this.jdate.isLeapYear() ? GregorianCalendar.LEAP_MONTH_LENGTH[month] : GregorianCalendar.MONTH_LENGTH[month];
    }

    private int actualMonthLength() {
        int length = jcal.getMonthLength(this.jdate);
        int eraIndex = getTransitionEraIndex(this.jdate);
        if (eraIndex == -1) {
            long transitionFixedDate = sinceFixedDates[eraIndex];
            CalendarDate d10 = eras[eraIndex].getSinceDate();
            if (transitionFixedDate <= this.cachedFixedDate) {
                return length - (d10.getDayOfMonth() - 1);
            }
            return d10.getDayOfMonth() - 1;
        }
        return length;
    }

    private static int getTransitionEraIndex(LocalGregorianCalendar.Date date) {
        int eraIndex = getEraIndex(date);
        Era[] eraArr = eras;
        CalendarDate transitionDate = eraArr[eraIndex].getSinceDate();
        if (transitionDate.getYear() == date.getNormalizedYear() && transitionDate.getMonth() == date.getMonth()) {
            return eraIndex;
        }
        if (eraIndex < eraArr.length - 1) {
            int eraIndex2 = eraIndex + 1;
            CalendarDate transitionDate2 = eraArr[eraIndex2].getSinceDate();
            if (transitionDate2.getYear() == date.getNormalizedYear() && transitionDate2.getMonth() == date.getMonth()) {
                return eraIndex2;
            }
            return -1;
        }
        return -1;
    }

    private boolean isTransitionYear(int normalizedYear) {
        for (int i10 = eras.length - 1; i10 > 0; i10--) {
            int transitionYear = eras[i10].getSinceDate().getYear();
            if (normalizedYear == transitionYear) {
                return true;
            }
            if (normalizedYear > transitionYear) {
                return false;
            }
        }
        return false;
    }

    private static int getEraIndex(LocalGregorianCalendar.Date date) {
        Era era = date.getEra();
        for (int i10 = eras.length - 1; i10 > 0; i10--) {
            if (eras[i10] == era) {
                return i10;
            }
        }
        return 0;
    }

    private JapaneseImperialCalendar getNormalizedCalendar() {
        if (isFullyNormalized()) {
            return this;
        }
        JapaneseImperialCalendar jc2 = (JapaneseImperialCalendar) clone();
        jc2.setLenient(true);
        jc2.complete();
        return jc2;
    }

    private void pinDayOfMonth(LocalGregorianCalendar.Date date) {
        int year = date.getYear();
        int dom = date.getDayOfMonth();
        if (year != getMinimum(1)) {
            date.setDayOfMonth(1);
            LocalGregorianCalendar localGregorianCalendar = jcal;
            localGregorianCalendar.normalize(date);
            int monthLength = localGregorianCalendar.getMonthLength(date);
            if (dom > monthLength) {
                date.setDayOfMonth(monthLength);
            } else {
                date.setDayOfMonth(dom);
            }
            localGregorianCalendar.normalize(date);
            return;
        }
        LocalGregorianCalendar localGregorianCalendar2 = jcal;
        LocalGregorianCalendar.Date d10 = localGregorianCalendar2.getCalendarDate(Long.MIN_VALUE, getZone());
        LocalGregorianCalendar.Date realDate = localGregorianCalendar2.getCalendarDate(this.time, getZone());
        long tod = realDate.getTimeOfDay();
        realDate.addYear(400);
        realDate.setMonth(date.getMonth());
        realDate.setDayOfMonth(1);
        localGregorianCalendar2.normalize(realDate);
        int monthLength2 = localGregorianCalendar2.getMonthLength(realDate);
        if (dom > monthLength2) {
            realDate.setDayOfMonth(monthLength2);
        } else if (dom < d10.getDayOfMonth()) {
            realDate.setDayOfMonth(d10.getDayOfMonth());
        } else {
            realDate.setDayOfMonth(dom);
        }
        if (realDate.getDayOfMonth() == d10.getDayOfMonth() && tod < d10.getTimeOfDay()) {
            realDate.setDayOfMonth(Math.min(dom + 1, monthLength2));
        }
        date.setDate(year, realDate.getMonth(), realDate.getDayOfMonth());
    }

    private static int getRolledValue(int value, int amount, int min, int max) {
        int range = (max - min) + 1;
        int n10 = value + (amount % range);
        if (n10 > max) {
            return n10 - range;
        }
        if (n10 < min) {
            return n10 + range;
        }
        return n10;
    }

    private int internalGetEra() {
        return isSet(0) ? internalGet(0) : currentEra;
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        if (this.jdate == null) {
            this.jdate = jcal.newCalendarDate(getZone());
            this.cachedFixedDate = Long.MIN_VALUE;
        }
    }
}
