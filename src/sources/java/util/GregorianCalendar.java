package java.util;

import com.android.internal.logging.nano.MetricsProto;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.Locale;
import libcore.util.ZoneInfo;
import org.apache.commons.lang3.time.TimeZones;
import sun.util.calendar.BaseCalendar;
import sun.util.calendar.CalendarDate;
import sun.util.calendar.CalendarSystem;
import sun.util.calendar.CalendarUtils;
import sun.util.calendar.Era;
import sun.util.calendar.Gregorian;
import sun.util.calendar.JulianCalendar;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class GregorianCalendar extends Calendar {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int AD = 1;
    public static final int BC = 0;
    static final int BCE = 0;
    static final int CE = 1;
    static final long DEFAULT_GREGORIAN_CUTOVER = -12219292800000L;
    private static final int EPOCH_OFFSET = 719163;
    private static final int EPOCH_YEAR = 1970;
    private static final long ONE_DAY = 86400000;
    private static final int ONE_HOUR = 3600000;
    private static final int ONE_MINUTE = 60000;
    private static final int ONE_SECOND = 1000;
    private static final long ONE_WEEK = 604800000;
    private static JulianCalendar jcal = null;
    private static Era[] jeras = null;
    static final long serialVersionUID = -8125100834729963327L;
    private transient long cachedFixedDate;
    private transient BaseCalendar calsys;
    private transient BaseCalendar.Date cdate;
    private transient BaseCalendar.Date gdate;
    private long gregorianCutover;
    private transient long gregorianCutoverDate;
    private transient int gregorianCutoverYear;
    private transient int gregorianCutoverYearJulian;
    private transient int[] originalFields;
    private transient int[] zoneOffsets;
    static final int[] MONTH_LENGTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static final int[] LEAP_MONTH_LENGTH = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static final int[] MIN_VALUES = {0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, -46800000, 0};
    static final int[] LEAST_MAX_VALUES = {1, 292269054, 11, 52, 4, 28, 365, 7, 4, 1, 11, 23, 59, 59, 999, 50400000, 1200000};
    static final int[] MAX_VALUES = {1, 292278994, 11, 53, 6, 31, 366, 7, 6, 1, 11, 23, 59, 59, 999, 50400000, 7200000};
    private static final Gregorian gcal = CalendarSystem.getGregorianCalendar();

    public GregorianCalendar() {
        this(TimeZone.getDefaultRef(), Locale.getDefault(Locale.Category.FORMAT));
        setZoneShared(true);
    }

    public GregorianCalendar(TimeZone zone) {
        this(zone, Locale.getDefault(Locale.Category.FORMAT));
    }

    public GregorianCalendar(Locale aLocale) {
        this(TimeZone.getDefaultRef(), aLocale);
        setZoneShared(true);
    }

    public GregorianCalendar(TimeZone zone, Locale aLocale) {
        super(zone, aLocale);
        this.gregorianCutover = DEFAULT_GREGORIAN_CUTOVER;
        this.gregorianCutoverDate = 577736L;
        this.gregorianCutoverYear = MetricsProto.MetricsEvent.MOBILE_DATA_DIALOG;
        this.gregorianCutoverYearJulian = MetricsProto.MetricsEvent.MOBILE_DATA_DIALOG;
        this.cachedFixedDate = Long.MIN_VALUE;
        this.gdate = gcal.newCalendarDate(zone);
        setTimeInMillis(System.currentTimeMillis());
    }

    public GregorianCalendar(int year, int month, int dayOfMonth) {
        this(year, month, dayOfMonth, 0, 0, 0, 0);
    }

    public GregorianCalendar(int year, int month, int dayOfMonth, int hourOfDay, int minute) {
        this(year, month, dayOfMonth, hourOfDay, minute, 0, 0);
    }

    public GregorianCalendar(int year, int month, int dayOfMonth, int hourOfDay, int minute, int second) {
        this(year, month, dayOfMonth, hourOfDay, minute, second, 0);
    }

    GregorianCalendar(int year, int month, int dayOfMonth, int hourOfDay, int minute, int second, int millis) {
        this.gregorianCutover = DEFAULT_GREGORIAN_CUTOVER;
        this.gregorianCutoverDate = 577736L;
        this.gregorianCutoverYear = MetricsProto.MetricsEvent.MOBILE_DATA_DIALOG;
        this.gregorianCutoverYearJulian = MetricsProto.MetricsEvent.MOBILE_DATA_DIALOG;
        this.cachedFixedDate = Long.MIN_VALUE;
        this.gdate = gcal.newCalendarDate(getZone());
        set(1, year);
        set(2, month);
        set(5, dayOfMonth);
        if (hourOfDay >= 12 && hourOfDay <= 23) {
            internalSet(9, 1);
            internalSet(10, hourOfDay - 12);
        } else {
            internalSet(10, hourOfDay);
        }
        setFieldsComputed(1536);
        set(11, hourOfDay);
        set(12, minute);
        set(13, second);
        internalSet(14, millis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GregorianCalendar(TimeZone zone, Locale locale, boolean flag) {
        super(zone, locale);
        this.gregorianCutover = DEFAULT_GREGORIAN_CUTOVER;
        this.gregorianCutoverDate = 577736L;
        this.gregorianCutoverYear = MetricsProto.MetricsEvent.MOBILE_DATA_DIALOG;
        this.gregorianCutoverYearJulian = MetricsProto.MetricsEvent.MOBILE_DATA_DIALOG;
        this.cachedFixedDate = Long.MIN_VALUE;
        this.gdate = gcal.newCalendarDate(getZone());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GregorianCalendar(long milliseconds) {
        this();
        setTimeInMillis(milliseconds);
    }

    public void setGregorianChange(Date date) {
        long cutoverTime = date.getTime();
        if (cutoverTime == this.gregorianCutover) {
            return;
        }
        complete();
        setGregorianChange(cutoverTime);
    }

    private void setGregorianChange(long cutoverTime) {
        this.gregorianCutover = cutoverTime;
        long floorDivide = CalendarUtils.floorDivide(cutoverTime, 86400000L) + 719163;
        this.gregorianCutoverDate = floorDivide;
        if (cutoverTime == Long.MAX_VALUE) {
            this.gregorianCutoverDate = floorDivide + 1;
        }
        this.gregorianCutoverYear = getGregorianCutoverDate().getYear();
        BaseCalendar julianCal = getJulianCalendarSystem();
        BaseCalendar.Date d10 = (BaseCalendar.Date) julianCal.newCalendarDate(TimeZone.NO_TIMEZONE);
        julianCal.getCalendarDateFromFixedDate(d10, this.gregorianCutoverDate - 1);
        this.gregorianCutoverYearJulian = d10.getNormalizedYear();
        if (this.time < this.gregorianCutover) {
            setUnnormalized();
        }
    }

    public final Date getGregorianChange() {
        return new Date(this.gregorianCutover);
    }

    public boolean isLeapYear(int year) {
        boolean gregorian;
        if ((year & 3) != 0) {
            return false;
        }
        int i10 = this.gregorianCutoverYear;
        if (year > i10) {
            return year % 100 != 0 || year % 400 == 0;
        }
        int i11 = this.gregorianCutoverYearJulian;
        if (year < i11) {
            return true;
        }
        if (i10 == i11) {
            BaseCalendar.Date d10 = getCalendarDate(this.gregorianCutoverDate);
            gregorian = d10.getMonth() < 3;
        } else {
            gregorian = year == i10;
        }
        return (gregorian && year % 100 == 0 && year % 400 != 0) ? false : true;
    }

    @Override // java.util.Calendar
    public String getCalendarType() {
        return "gregory";
    }

    @Override // java.util.Calendar
    public boolean equals(Object obj) {
        return (obj instanceof GregorianCalendar) && super.equals(obj) && this.gregorianCutover == ((GregorianCalendar) obj).gregorianCutover;
    }

    @Override // java.util.Calendar
    public int hashCode() {
        return super.hashCode() ^ ((int) this.gregorianCutoverDate);
    }

    @Override // java.util.Calendar
    public void add(int field, int amount) {
        int y_amount;
        if (amount == 0) {
            return;
        }
        if (field < 0 || field >= 15) {
            throw new IllegalArgumentException();
        }
        complete();
        if (field == 1) {
            int year = internalGet(1);
            if (internalGetEra() == 1) {
                int year2 = year + amount;
                if (year2 > 0) {
                    set(1, year2);
                } else {
                    set(1, 1 - year2);
                    set(0, 0);
                }
            } else {
                int year3 = year - amount;
                if (year3 > 0) {
                    set(1, year3);
                } else {
                    set(1, 1 - year3);
                    set(0, 1);
                }
            }
            pinDayOfMonth();
            return;
        }
        if (field == 2) {
            int month = internalGet(2) + amount;
            int year4 = internalGet(1);
            if (month >= 0) {
                y_amount = month / 12;
            } else {
                y_amount = ((month + 1) / 12) - 1;
            }
            if (y_amount != 0) {
                if (internalGetEra() == 1) {
                    int year5 = year4 + y_amount;
                    if (year5 > 0) {
                        set(1, year5);
                    } else {
                        set(1, 1 - year5);
                        set(0, 0);
                    }
                } else {
                    int year6 = year4 - y_amount;
                    if (year6 > 0) {
                        set(1, year6);
                    } else {
                        set(1, 1 - year6);
                        set(0, 1);
                    }
                }
            }
            if (month >= 0) {
                set(2, month % 12);
            } else {
                int month2 = month % 12;
                if (month2 < 0) {
                    month2 += 12;
                }
                set(2, month2 + 0);
            }
            pinDayOfMonth();
            return;
        }
        if (field == 0) {
            int era = internalGet(0) + amount;
            if (era < 0) {
                era = 0;
            }
            if (era > 1) {
                era = 1;
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
        long fd2 = getCurrentFixedDate();
        long timeOfDay2 = ((((((timeOfDay + internalGet(11)) * 60) + internalGet(12)) * 60) + internalGet(13)) * 1000) + internalGet(14);
        if (timeOfDay2 >= 86400000) {
            fd2++;
            timeOfDay2 -= 86400000;
        } else if (timeOfDay2 < 0) {
            fd2--;
            timeOfDay2 += 86400000;
        }
        long utcTime = (((fd2 + delta) - 719163) * 86400000) + timeOfDay2;
        long millis = adjustForZoneAndDaylightSavingsTime(0, utcTime, getZone());
        setTimeInMillis(millis);
    }

    @Override // java.util.Calendar
    public void roll(int field, boolean up) {
        roll(field, up ? 1 : -1);
    }

    @Override // java.util.Calendar
    public void roll(int field, int amount) {
        BaseCalendar cal;
        long month1;
        int monthLength;
        int dayOfMonth;
        int weekOfYear;
        int amount2 = amount;
        if (amount2 == 0) {
            return;
        }
        if (field < 0 || field >= 15) {
            throw new IllegalArgumentException();
        }
        complete();
        int min = getMinimum(field);
        int max = getMaximum(field);
        switch (field) {
            case 2:
                if (!isCutoverYear(this.cdate.getNormalizedYear())) {
                    int mon = (internalGet(2) + amount2) % 12;
                    if (mon < 0) {
                        mon += 12;
                    }
                    set(2, mon);
                    int monthLen = monthLength(mon);
                    if (internalGet(5) > monthLen) {
                        set(5, monthLen);
                        return;
                    }
                    return;
                }
                int yearLength = getActualMaximum(2) + 1;
                int mon2 = (internalGet(2) + amount2) % yearLength;
                if (mon2 < 0) {
                    mon2 += yearLength;
                }
                set(2, mon2);
                int monthLen2 = getActualMaximum(5);
                if (internalGet(5) > monthLen2) {
                    set(5, monthLen2);
                    return;
                }
                return;
            case 3:
                int y10 = this.cdate.getNormalizedYear();
                int max2 = getActualMaximum(3);
                set(7, internalGet(7));
                int woy = internalGet(3);
                int value = woy + amount2;
                if (!isCutoverYear(y10)) {
                    int weekYear = getWeekYear();
                    if (weekYear == y10) {
                        if (value > min && value < max2) {
                            set(3, value);
                            return;
                        }
                        long fd2 = getCurrentFixedDate();
                        if (this.calsys.getYearFromFixedDate(fd2 - ((woy - min) * 7)) != y10) {
                            min++;
                        }
                        if (this.calsys.getYearFromFixedDate(fd2 + ((max2 - internalGet(3)) * 7)) != y10) {
                            max2--;
                        }
                    } else if (weekYear > y10) {
                        if (amount2 < 0) {
                            amount2++;
                        }
                        woy = max2;
                    } else {
                        if (amount2 > 0) {
                            amount2 -= woy - max2;
                        }
                        woy = min;
                    }
                    set(field, getRolledValue(woy, amount2, min, max2));
                    return;
                }
                long fd3 = getCurrentFixedDate();
                int i10 = this.gregorianCutoverYear;
                if (i10 == this.gregorianCutoverYearJulian) {
                    cal = getCutoverCalendarSystem();
                } else if (y10 == i10) {
                    cal = gcal;
                } else {
                    cal = getJulianCalendarSystem();
                }
                long day1 = fd3 - ((woy - min) * 7);
                if (cal.getYearFromFixedDate(day1) != y10) {
                    min++;
                }
                long fd4 = fd3 + ((max2 - woy) * 7);
                BaseCalendar cal2 = fd4 >= this.gregorianCutoverDate ? gcal : getJulianCalendarSystem();
                if (cal2.getYearFromFixedDate(fd4) != y10) {
                    max2--;
                }
                BaseCalendar.Date d10 = getCalendarDate(((getRolledValue(woy, amount2, min, max2) - 1) * 7) + day1);
                set(2, d10.getMonth() - 1);
                set(5, d10.getDayOfMonth());
                return;
            case 4:
                boolean isCutoverYear = isCutoverYear(this.cdate.getNormalizedYear());
                int dow = internalGet(7) - getFirstDayOfWeek();
                if (dow < 0) {
                    dow += 7;
                }
                long fd5 = getCurrentFixedDate();
                if (isCutoverYear) {
                    month1 = getFixedDateMonth1(this.cdate, fd5);
                    monthLength = actualMonthLength();
                } else {
                    month1 = (fd5 - internalGet(5)) + 1;
                    monthLength = this.calsys.getMonthLength(this.cdate);
                }
                long monthDay1st = BaseCalendar.getDayOfWeekDateOnOrBefore(month1 + 6, getFirstDayOfWeek());
                if (((int) (monthDay1st - month1)) >= getMinimalDaysInFirstWeek()) {
                    monthDay1st -= 7;
                }
                long nfd = ((getRolledValue(internalGet(field), amount2, 1, getActualMaximum(field)) - 1) * 7) + monthDay1st + dow;
                if (nfd < month1) {
                    nfd = month1;
                } else if (nfd >= monthLength + month1) {
                    nfd = (monthLength + month1) - 1;
                }
                if (isCutoverYear) {
                    dayOfMonth = getCalendarDate(nfd).getDayOfMonth();
                } else {
                    dayOfMonth = ((int) (nfd - month1)) + 1;
                }
                set(5, dayOfMonth);
                return;
            case 5:
                if (!isCutoverYear(this.cdate.getNormalizedYear())) {
                    max = this.calsys.getMonthLength(this.cdate);
                    break;
                } else {
                    long fd6 = getCurrentFixedDate();
                    long month12 = getFixedDateMonth1(this.cdate, fd6);
                    set(5, getCalendarDate(getRolledValue((int) (fd6 - month12), amount2, 0, actualMonthLength() - 1) + month12).getDayOfMonth());
                    return;
                }
            case 6:
                max = getActualMaximum(field);
                if (isCutoverYear(this.cdate.getNormalizedYear())) {
                    long fd7 = getCurrentFixedDate();
                    long jan1 = (fd7 - internalGet(6)) + 1;
                    BaseCalendar.Date d11 = getCalendarDate((getRolledValue(((int) (fd7 - jan1)) + 1, amount2, min, max) + jan1) - 1);
                    set(2, d11.getMonth() - 1);
                    set(5, d11.getDayOfMonth());
                    return;
                }
                break;
            case 7:
                if (!isCutoverYear(this.cdate.getNormalizedYear()) && (weekOfYear = internalGet(3)) > 1 && weekOfYear < 52) {
                    set(3, weekOfYear);
                    max = 7;
                    break;
                } else {
                    int amount3 = amount2 % 7;
                    if (amount3 == 0) {
                        return;
                    }
                    long fd8 = getCurrentFixedDate();
                    long dowFirst = BaseCalendar.getDayOfWeekDateOnOrBefore(fd8, getFirstDayOfWeek());
                    long fd9 = fd8 + amount3;
                    if (fd9 < dowFirst) {
                        fd9 += 7;
                    } else if (fd9 >= dowFirst + 7) {
                        fd9 -= 7;
                    }
                    BaseCalendar.Date d12 = getCalendarDate(fd9);
                    set(0, d12.getNormalizedYear() <= 0 ? 0 : 1);
                    set(d12.getYear(), d12.getMonth() - 1, d12.getDayOfMonth());
                    return;
                }
                break;
            case 8:
                min = 1;
                if (!isCutoverYear(this.cdate.getNormalizedYear())) {
                    int dom = internalGet(5);
                    int monthLength2 = this.calsys.getMonthLength(this.cdate);
                    int lastDays = monthLength2 % 7;
                    max = monthLength2 / 7;
                    if ((dom - 1) % 7 < lastDays) {
                        max++;
                    }
                    set(7, internalGet(7));
                    break;
                } else {
                    long fd10 = getCurrentFixedDate();
                    long month13 = getFixedDateMonth1(this.cdate, fd10);
                    int monthLength3 = actualMonthLength();
                    int lastDays2 = monthLength3 % 7;
                    int max3 = monthLength3 / 7;
                    int x10 = ((int) (fd10 - month13)) % 7;
                    if (x10 < lastDays2) {
                        max3++;
                    }
                    long fd11 = ((getRolledValue(internalGet(field), amount2, 1, max3) - 1) * 7) + month13 + x10;
                    BaseCalendar cal3 = fd11 >= this.gregorianCutoverDate ? gcal : getJulianCalendarSystem();
                    BaseCalendar.Date d13 = (BaseCalendar.Date) cal3.newCalendarDate(TimeZone.NO_TIMEZONE);
                    cal3.getCalendarDateFromFixedDate(d13, fd11);
                    set(5, d13.getDayOfMonth());
                    return;
                }
            case 10:
            case 11:
                int rolledValue = getRolledValue(internalGet(field), amount2, min, max);
                int hourOfDay = rolledValue;
                if (field == 10 && internalGet(9) == 1) {
                    hourOfDay += 12;
                }
                CalendarDate d14 = this.calsys.getCalendarDate(this.time, getZone());
                d14.setHours(hourOfDay);
                this.time = this.calsys.getTime(d14);
                if (internalGet(11) == d14.getHours()) {
                    int hourOfDay2 = getRolledValue(rolledValue, amount2 > 0 ? 1 : -1, min, max);
                    if (field == 10 && internalGet(9) == 1) {
                        hourOfDay2 += 12;
                    }
                    d14.setHours(hourOfDay2);
                    this.time = this.calsys.getTime(d14);
                }
                int hourOfDay3 = d14.getHours();
                internalSet(11, hourOfDay3);
                internalSet(9, hourOfDay3 / 12);
                internalSet(10, hourOfDay3 % 12);
                int zoneOffset = d14.getZoneOffset();
                int saving = d14.getDaylightSaving();
                internalSet(15, zoneOffset - saving);
                internalSet(16, saving);
                return;
        }
        set(field, getRolledValue(internalGet(field), amount2, min, max));
    }

    @Override // java.util.Calendar
    public int getMinimum(int field) {
        return MIN_VALUES[field];
    }

    @Override // java.util.Calendar
    public int getMaximum(int field) {
        switch (field) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
                if (this.gregorianCutoverYear <= 200) {
                    GregorianCalendar gc2 = (GregorianCalendar) clone();
                    gc2.setLenient(true);
                    gc2.setTimeInMillis(this.gregorianCutover);
                    int v12 = gc2.getActualMaximum(field);
                    gc2.setTimeInMillis(this.gregorianCutover - 1);
                    int v2 = gc2.getActualMaximum(field);
                    return Math.max(MAX_VALUES[field], Math.max(v12, v2));
                }
                break;
        }
        return MAX_VALUES[field];
    }

    @Override // java.util.Calendar
    public int getGreatestMinimum(int field) {
        if (field == 5) {
            BaseCalendar.Date d10 = getGregorianCutoverDate();
            long mon1 = getFixedDateMonth1(d10, this.gregorianCutoverDate);
            BaseCalendar.Date d11 = getCalendarDate(mon1);
            return Math.max(MIN_VALUES[field], d11.getDayOfMonth());
        }
        return MIN_VALUES[field];
    }

    @Override // java.util.Calendar
    public int getLeastMaximum(int field) {
        switch (field) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
                GregorianCalendar gc2 = (GregorianCalendar) clone();
                gc2.setLenient(true);
                gc2.setTimeInMillis(this.gregorianCutover);
                int v12 = gc2.getActualMaximum(field);
                gc2.setTimeInMillis(this.gregorianCutover - 1);
                int v2 = gc2.getActualMaximum(field);
                return Math.min(LEAST_MAX_VALUES[field], Math.min(v12, v2));
            case 7:
            default:
                return LEAST_MAX_VALUES[field];
        }
    }

    @Override // java.util.Calendar
    public int getActualMinimum(int field) {
        if (field == 5) {
            GregorianCalendar gc2 = getNormalizedCalendar();
            int year = gc2.cdate.getNormalizedYear();
            if (year == this.gregorianCutoverYear || year == this.gregorianCutoverYearJulian) {
                BaseCalendar.Date date = gc2.cdate;
                long month1 = getFixedDateMonth1(date, gc2.calsys.getFixedDate(date));
                BaseCalendar.Date d10 = getCalendarDate(month1);
                return d10.getDayOfMonth();
            }
        }
        return getMinimum(field);
    }

    @Override // java.util.Calendar
    public int getActualMaximum(int field) {
        GregorianCalendar gc2;
        int value;
        long jan1;
        int ndays;
        int dow1;
        int i10 = 1;
        if (((1 << field) & 130689) != 0) {
            return getMaximum(field);
        }
        GregorianCalendar gc3 = getNormalizedCalendar();
        BaseCalendar.Date date = gc3.cdate;
        BaseCalendar cal = gc3.calsys;
        int normalizedYear = date.getNormalizedYear();
        switch (field) {
            case 1:
                if (gc3 != this) {
                    gc2 = gc3;
                } else {
                    gc2 = (GregorianCalendar) clone();
                }
                long current = gc2.getYearOffsetInMillis();
                if (gc2.internalGetEra() == 1) {
                    gc2.setTimeInMillis(Long.MAX_VALUE);
                    int value2 = gc2.get(1);
                    long maxEnd = gc2.getYearOffsetInMillis();
                    if (current > maxEnd) {
                        value2--;
                    }
                    return value2;
                }
                CalendarSystem mincal = gc2.getTimeInMillis() >= this.gregorianCutover ? gcal : getJulianCalendarSystem();
                CalendarDate d10 = mincal.getCalendarDate(Long.MIN_VALUE, getZone());
                long maxEnd2 = ((cal.getDayOfYear(d10) - 1) * 24) + d10.getHours();
                long maxEnd3 = (((((maxEnd2 * 60) + d10.getMinutes()) * 60) + d10.getSeconds()) * 1000) + d10.getMillis();
                int value3 = d10.getYear();
                if (value3 <= 0) {
                    value3 = 1 - value3;
                }
                if (current >= maxEnd3) {
                    return value3;
                }
                return value3 - 1;
            case 2:
                if (!gc3.isCutoverYear(normalizedYear)) {
                    return 11;
                }
                while (true) {
                    normalizedYear += i10;
                    long nextJan1 = gcal.getFixedDate(normalizedYear, i10, i10, null);
                    GregorianCalendar gc4 = gc3;
                    if (nextJan1 < this.gregorianCutoverDate) {
                        gc3 = gc4;
                        i10 = 1;
                    } else {
                        cal.getCalendarDateFromFixedDate((BaseCalendar.Date) date.clone(), nextJan1 - 1);
                        return r3.getMonth() - 1;
                    }
                }
            case 3:
                if (!gc3.isCutoverYear(normalizedYear)) {
                    CalendarDate d11 = cal.newCalendarDate(TimeZone.NO_TIMEZONE);
                    d11.setDate(date.getYear(), 1, 1);
                    int dayOfWeek = cal.getDayOfWeek(d11) - getFirstDayOfWeek();
                    if (dayOfWeek < 0) {
                        dayOfWeek += 7;
                    }
                    int magic = (getMinimalDaysInFirstWeek() + dayOfWeek) - 1;
                    if (magic != 6 && (!date.isLeapYear() || (magic != 5 && magic != 12))) {
                        return 52;
                    }
                    return 52 + 1;
                }
                if (gc3 == this) {
                    gc3 = (GregorianCalendar) gc3.clone();
                }
                int maxDayOfYear = getActualMaximum(6);
                gc3.set(6, maxDayOfYear);
                int value4 = gc3.get(3);
                if (internalGet(1) == gc3.getWeekYear()) {
                    return value4;
                }
                gc3.set(6, maxDayOfYear - 7);
                return gc3.get(3);
            case 4:
                if (!gc3.isCutoverYear(normalizedYear)) {
                    CalendarDate d12 = cal.newCalendarDate(null);
                    d12.setDate(date.getYear(), date.getMonth(), 1);
                    int dayOfWeek2 = cal.getDayOfWeek(d12);
                    int monthLength = cal.getMonthLength(d12);
                    int dayOfWeek3 = dayOfWeek2 - getFirstDayOfWeek();
                    if (dayOfWeek3 < 0) {
                        dayOfWeek3 += 7;
                    }
                    int nDaysFirstWeek = 7 - dayOfWeek3;
                    if (nDaysFirstWeek < getMinimalDaysInFirstWeek()) {
                        value = 3;
                    } else {
                        value = 3 + 1;
                    }
                    int monthLength2 = monthLength - (nDaysFirstWeek + 21);
                    if (monthLength2 > 0) {
                        int value5 = value + 1;
                        if (monthLength2 > 7) {
                            return value5 + 1;
                        }
                        return value5;
                    }
                    return value;
                }
                if (gc3 == this) {
                    gc3 = (GregorianCalendar) gc3.clone();
                }
                int y10 = gc3.internalGet(1);
                int m10 = gc3.internalGet(2);
                do {
                    int value6 = gc3.get(4);
                    gc3.add(4, 1);
                    if (gc3.get(1) == y10) {
                    }
                    return value6;
                } while (gc3.get(2) == m10);
                return value6;
            case 5:
                int value7 = cal.getMonthLength(date);
                if (gc3.isCutoverYear(normalizedYear) && date.getDayOfMonth() != value7) {
                    long fd2 = gc3.getCurrentFixedDate();
                    if (fd2 < this.gregorianCutoverDate) {
                        int monthLength3 = gc3.actualMonthLength();
                        long monthEnd = (gc3.getFixedDateMonth1(gc3.cdate, fd2) + monthLength3) - 1;
                        return gc3.getCalendarDate(monthEnd).getDayOfMonth();
                    }
                    return value7;
                }
                return value7;
            case 6:
                if (!gc3.isCutoverYear(normalizedYear)) {
                    return cal.getYearLength(date);
                }
                int i11 = this.gregorianCutoverYear;
                int i12 = this.gregorianCutoverYearJulian;
                if (i11 == i12) {
                    BaseCalendar cocal = gc3.getCutoverCalendarSystem();
                    jan1 = cocal.getFixedDate(normalizedYear, 1, 1, null);
                } else if (normalizedYear == i12) {
                    jan1 = cal.getFixedDate(normalizedYear, 1, 1, null);
                } else {
                    jan1 = this.gregorianCutoverDate;
                }
                long nextJan12 = gcal.getFixedDate(normalizedYear + 1, 1, 1, null);
                if (nextJan12 < this.gregorianCutoverDate) {
                    nextJan12 = this.gregorianCutoverDate;
                }
                return (int) (nextJan12 - jan1);
            case 7:
            default:
                throw new ArrayIndexOutOfBoundsException(field);
            case 8:
                int dow = date.getDayOfWeek();
                if (!gc3.isCutoverYear(normalizedYear)) {
                    BaseCalendar.Date d13 = (BaseCalendar.Date) date.clone();
                    ndays = cal.getMonthLength(d13);
                    d13.setDayOfMonth(1);
                    cal.normalize(d13);
                    dow1 = d13.getDayOfWeek();
                } else {
                    if (gc3 == this) {
                        gc3 = (GregorianCalendar) clone();
                    }
                    ndays = gc3.actualMonthLength();
                    gc3.set(5, gc3.getActualMinimum(5));
                    dow1 = gc3.get(7);
                }
                int x10 = dow - dow1;
                if (x10 < 0) {
                    x10 += 7;
                }
                return ((ndays - x10) + 6) / 7;
        }
    }

    private long getYearOffsetInMillis() {
        long t2 = (internalGet(6) - 1) * 24;
        return (internalGet(14) + ((((((t2 + internalGet(11)) * 60) + internalGet(12)) * 60) + internalGet(13)) * 1000)) - (internalGet(15) + internalGet(16));
    }

    @Override // java.util.Calendar
    public Object clone() {
        GregorianCalendar other = (GregorianCalendar) super.clone();
        BaseCalendar.Date date = (BaseCalendar.Date) this.gdate.clone();
        other.gdate = date;
        BaseCalendar.Date date2 = this.cdate;
        if (date2 != null) {
            if (date2 != this.gdate) {
                other.cdate = (BaseCalendar.Date) date2.clone();
            } else {
                other.cdate = date;
            }
        }
        other.originalFields = null;
        other.zoneOffsets = null;
        return other;
    }

    @Override // java.util.Calendar
    public TimeZone getTimeZone() {
        TimeZone zone = super.getTimeZone();
        this.gdate.setZone(zone);
        BaseCalendar.Date date = this.cdate;
        if (date != null && date != this.gdate) {
            date.setZone(zone);
        }
        return zone;
    }

    @Override // java.util.Calendar
    public void setTimeZone(TimeZone zone) {
        super.setTimeZone(zone);
        this.gdate.setZone(zone);
        BaseCalendar.Date date = this.cdate;
        if (date != null && date != this.gdate) {
            date.setZone(zone);
        }
    }

    @Override // java.util.Calendar
    public final boolean isWeekDateSupported() {
        return true;
    }

    @Override // java.util.Calendar
    public int getWeekYear() {
        int minDayOfYear;
        int year = get(1);
        if (internalGetEra() == 0) {
            year = 1 - year;
        }
        if (year > this.gregorianCutoverYear + 1) {
            int weekOfYear = internalGet(3);
            if (internalGet(2) == 0) {
                if (weekOfYear >= 52) {
                    return year - 1;
                }
                return year;
            }
            if (weekOfYear == 1) {
                return year + 1;
            }
            return year;
        }
        int dayOfYear = internalGet(6);
        int maxDayOfYear = getActualMaximum(6);
        int minimalDays = getMinimalDaysInFirstWeek();
        if (dayOfYear > minimalDays && dayOfYear < maxDayOfYear - 6) {
            return year;
        }
        GregorianCalendar cal = (GregorianCalendar) clone();
        cal.setLenient(true);
        cal.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
        cal.set(6, 1);
        cal.complete();
        int delta = getFirstDayOfWeek() - cal.get(7);
        if (delta != 0) {
            if (delta < 0) {
                delta += 7;
            }
            cal.add(6, delta);
        }
        int minDayOfYear2 = cal.get(6);
        if (dayOfYear >= minDayOfYear2) {
            cal.set(1, year + 1);
            cal.set(6, 1);
            cal.complete();
            int del = getFirstDayOfWeek() - cal.get(7);
            if (del != 0) {
                if (del < 0) {
                    del += 7;
                }
                cal.add(6, del);
            }
            int minDayOfYear3 = cal.get(6) - 1;
            if (minDayOfYear3 != 0) {
                minDayOfYear = minDayOfYear3;
            } else {
                minDayOfYear = 7;
            }
            if (minDayOfYear >= minimalDays) {
                int days = (maxDayOfYear - dayOfYear) + 1;
                if (days <= 7 - minDayOfYear) {
                    return year + 1;
                }
                return year;
            }
            return year;
        }
        if (minDayOfYear2 <= minimalDays) {
            return year - 1;
        }
        return year;
    }

    @Override // java.util.Calendar
    public void setWeekDate(int weekYear, int weekOfYear, int dayOfWeek) {
        if (dayOfWeek < 1 || dayOfWeek > 7) {
            throw new IllegalArgumentException("invalid dayOfWeek: " + dayOfWeek);
        }
        GregorianCalendar gc2 = (GregorianCalendar) clone();
        gc2.setLenient(true);
        int era = gc2.get(0);
        gc2.clear();
        gc2.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
        gc2.set(0, era);
        gc2.set(1, weekYear);
        gc2.set(3, 1);
        gc2.set(7, getFirstDayOfWeek());
        int days = dayOfWeek - getFirstDayOfWeek();
        if (days < 0) {
            days += 7;
        }
        int days2 = days + ((weekOfYear - 1) * 7);
        if (days2 != 0) {
            gc2.add(6, days2);
        } else {
            gc2.complete();
        }
        if (isLenient() || (gc2.getWeekYear() == weekYear && gc2.internalGet(3) == weekOfYear && gc2.internalGet(7) == dayOfWeek)) {
            set(0, gc2.internalGet(0));
            set(1, gc2.internalGet(1));
            set(2, gc2.internalGet(2));
            set(5, gc2.internalGet(5));
            internalSet(3, weekOfYear);
            complete();
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.Calendar
    public int getWeeksInWeekYear() {
        GregorianCalendar gc2 = getNormalizedCalendar();
        int weekYear = gc2.getWeekYear();
        if (weekYear == gc2.internalGet(1)) {
            return gc2.getActualMaximum(3);
        }
        if (gc2 == this) {
            gc2 = (GregorianCalendar) gc2.clone();
        }
        gc2.setWeekDate(weekYear, 2, internalGet(7));
        return gc2.getActualMaximum(3);
    }

    @Override // java.util.Calendar
    protected void computeFields() {
        int mask;
        if (isPartiallyNormalized()) {
            mask = getSetStateFields();
            int fieldMask = (~mask) & 131071;
            if (fieldMask != 0 || this.calsys == null) {
                mask |= computeFields(fieldMask, 98304 & mask);
            }
        } else {
            mask = 131071;
            computeFields(131071, 0);
        }
        setFieldsComputed(mask);
    }

    private int computeFields(int fieldMask, int tzMask) {
        int timeOfDay;
        int year;
        int relativeDayOfMonth;
        long fixedDateJan1;
        int month;
        long nextJan1;
        int i10;
        long prevJan1;
        int zoneOffset = 0;
        ZoneInfo zone = getZone();
        if (this.zoneOffsets == null) {
            this.zoneOffsets = new int[2];
        }
        if (tzMask != 98304) {
            if (zone instanceof ZoneInfo) {
                ZoneInfo zoneInfo = zone;
                zoneOffset = zoneInfo.getOffsetsByUtcTime(this.time, this.zoneOffsets);
            } else {
                zoneOffset = zone.getOffset(this.time);
                this.zoneOffsets[0] = zone.getRawOffset();
                int[] iArr = this.zoneOffsets;
                iArr[1] = zoneOffset - iArr[0];
            }
        }
        if (tzMask != 0) {
            if (isFieldSet(tzMask, 15)) {
                this.zoneOffsets[0] = internalGet(15);
            }
            if (isFieldSet(tzMask, 16)) {
                this.zoneOffsets[1] = internalGet(16);
            }
            int[] iArr2 = this.zoneOffsets;
            zoneOffset = iArr2[0] + iArr2[1];
        }
        long fixedDate = (zoneOffset / 86400000) + (this.time / 86400000);
        int timeOfDay2 = (zoneOffset % 86400000) + ((int) (this.time % 86400000));
        if (timeOfDay2 >= 86400000) {
            timeOfDay = (int) (timeOfDay2 - 86400000);
            fixedDate++;
        } else {
            while (timeOfDay2 < 0) {
                timeOfDay2 = (int) (timeOfDay2 + 86400000);
                fixedDate--;
            }
            timeOfDay = timeOfDay2;
        }
        long fixedDate2 = fixedDate + 719163;
        int era = 1;
        if (fixedDate2 < this.gregorianCutoverDate) {
            this.calsys = getJulianCalendarSystem();
            JulianCalendar.Date newCalendarDate = jcal.newCalendarDate(getZone());
            this.cdate = newCalendarDate;
            jcal.getCalendarDateFromFixedDate(newCalendarDate, fixedDate2);
            Era e2 = this.cdate.getEra();
            if (e2 == jeras[0]) {
                era = 0;
            }
            year = this.cdate.getYear();
        } else {
            if (fixedDate2 != this.cachedFixedDate) {
                gcal.getCalendarDateFromFixedDate(this.gdate, fixedDate2);
                this.cachedFixedDate = fixedDate2;
            }
            year = this.gdate.getYear();
            if (year <= 0) {
                year = 1 - year;
                era = 0;
            }
            this.calsys = gcal;
            this.cdate = this.gdate;
        }
        internalSet(0, era);
        internalSet(1, year);
        int mask = fieldMask | 3;
        int month2 = this.cdate.getMonth() - 1;
        int dayOfMonth = this.cdate.getDayOfMonth();
        if ((fieldMask & 164) != 0) {
            internalSet(2, month2);
            internalSet(5, dayOfMonth);
            internalSet(7, this.cdate.getDayOfWeek());
            mask |= 164;
        }
        if ((fieldMask & 32256) != 0) {
            if (timeOfDay == 0) {
                internalSet(11, 0);
                internalSet(9, 0);
                internalSet(10, 0);
                internalSet(12, 0);
                internalSet(13, 0);
                internalSet(14, 0);
            } else {
                int hours = timeOfDay / 3600000;
                internalSet(11, hours);
                internalSet(9, hours / 12);
                internalSet(10, hours % 12);
                int r10 = timeOfDay % 3600000;
                internalSet(12, r10 / 60000);
                int r11 = r10 % 60000;
                internalSet(13, r11 / 1000);
                internalSet(14, r11 % 1000);
            }
            mask |= 32256;
        }
        if ((fieldMask & 98304) != 0) {
            internalSet(15, this.zoneOffsets[0]);
            internalSet(16, this.zoneOffsets[1]);
            mask |= 98304;
        }
        if ((fieldMask & 344) != 0) {
            int normalizedYear = this.cdate.getNormalizedYear();
            long fixedDateJan12 = this.calsys.getFixedDate(normalizedYear, 1, 1, this.cdate);
            int dayOfYear = ((int) (fixedDate2 - fixedDateJan12)) + 1;
            long fixedDateJan13 = fixedDateJan12;
            long fixedDateMonth1 = (fixedDate2 - dayOfMonth) + 1;
            int cutoverYear = this.calsys == gcal ? this.gregorianCutoverYear : this.gregorianCutoverYearJulian;
            int relativeDayOfMonth2 = dayOfMonth - 1;
            if (normalizedYear == cutoverYear) {
                if (this.gregorianCutoverYearJulian <= this.gregorianCutoverYear) {
                    fixedDateJan13 = getFixedDateJan1(this.cdate, fixedDate2);
                    if (fixedDate2 >= this.gregorianCutoverDate) {
                        fixedDateMonth1 = getFixedDateMonth1(this.cdate, fixedDate2);
                    } else {
                        fixedDateMonth1 = fixedDateMonth1;
                    }
                } else {
                    fixedDateMonth1 = fixedDateMonth1;
                }
                int realDayOfYear = ((int) (fixedDate2 - fixedDateJan13)) + 1;
                int i11 = dayOfYear - realDayOfYear;
                dayOfYear = realDayOfYear;
                relativeDayOfMonth = (int) (fixedDate2 - fixedDateMonth1);
                fixedDateJan1 = fixedDateJan13;
            } else {
                relativeDayOfMonth = relativeDayOfMonth2;
                fixedDateJan1 = fixedDateJan13;
            }
            internalSet(6, dayOfYear);
            internalSet(8, (relativeDayOfMonth / 7) + 1);
            int weekOfYear = getWeekNumber(fixedDateJan1, fixedDate2);
            if (weekOfYear != 0) {
                month = mask;
                int cutoverYear2 = this.gregorianCutoverYear;
                if (normalizedYear <= cutoverYear2) {
                    int i12 = this.gregorianCutoverYearJulian;
                    if (normalizedYear >= i12 - 1) {
                        BaseCalendar calForJan1 = this.calsys;
                        int nextYear = normalizedYear + 1;
                        if (nextYear == i12 + 1 && nextYear < cutoverYear2) {
                            nextYear = this.gregorianCutoverYear;
                        }
                        if (nextYear == cutoverYear2) {
                            calForJan1 = getCutoverCalendarSystem();
                        }
                        int i13 = this.gregorianCutoverYear;
                        if (nextYear > i13 || (i10 = this.gregorianCutoverYearJulian) == i13 || nextYear == i10) {
                            nextJan1 = calForJan1.getFixedDate(nextYear, 1, 1, null);
                        } else {
                            nextJan1 = this.gregorianCutoverDate;
                            calForJan1 = gcal;
                        }
                        long nextJan1st = BaseCalendar.getDayOfWeekDateOnOrBefore(nextJan1 + 6, getFirstDayOfWeek());
                        int ndays = (int) (nextJan1st - nextJan1);
                        if (ndays >= getMinimalDaysInFirstWeek() && fixedDate2 >= nextJan1st - 7) {
                            weekOfYear = 1;
                        }
                    }
                }
                if (weekOfYear >= 52) {
                    long nextJan12 = 365 + fixedDateJan1;
                    if (this.cdate.isLeapYear()) {
                        nextJan12++;
                    }
                    long nextJan1st2 = BaseCalendar.getDayOfWeekDateOnOrBefore(6 + nextJan12, getFirstDayOfWeek());
                    int ndays2 = (int) (nextJan1st2 - nextJan12);
                    if (ndays2 >= getMinimalDaysInFirstWeek() && fixedDate2 >= nextJan1st2 - 7) {
                        weekOfYear = 1;
                    }
                }
            } else {
                long fixedDec31 = fixedDateJan1 - 1;
                long prevJan12 = fixedDateJan1 - 365;
                if (normalizedYear > cutoverYear + 1) {
                    if (CalendarUtils.isGregorianLeapYear(normalizedYear - 1)) {
                        month = mask;
                        prevJan1 = prevJan12 - 1;
                        weekOfYear = getWeekNumber(prevJan1, fixedDec31);
                    } else {
                        month = mask;
                        prevJan1 = prevJan12;
                        weekOfYear = getWeekNumber(prevJan1, fixedDec31);
                    }
                } else if (normalizedYear <= this.gregorianCutoverYearJulian) {
                    if (CalendarUtils.isJulianLeapYear(normalizedYear - 1)) {
                        month = mask;
                        prevJan1 = prevJan12 - 1;
                        weekOfYear = getWeekNumber(prevJan1, fixedDec31);
                    } else {
                        month = mask;
                        prevJan1 = prevJan12;
                        weekOfYear = getWeekNumber(prevJan1, fixedDec31);
                    }
                } else {
                    BaseCalendar baseCalendar = this.calsys;
                    int prevYear = getCalendarDate(fixedDec31).getNormalizedYear();
                    if (prevYear != this.gregorianCutoverYear) {
                        month = mask;
                        if (prevYear <= this.gregorianCutoverYearJulian) {
                            BaseCalendar calForJan12 = getJulianCalendarSystem();
                            prevJan1 = calForJan12.getFixedDate(prevYear, 1, 1, null);
                        }
                        prevJan1 = prevJan12;
                    } else {
                        BaseCalendar calForJan13 = getCutoverCalendarSystem();
                        if (calForJan13 == jcal) {
                            month = mask;
                            prevJan1 = calForJan13.getFixedDate(prevYear, 1, 1, null);
                        } else {
                            month = mask;
                            prevJan1 = this.gregorianCutoverDate;
                            BaseCalendar calForJan14 = gcal;
                        }
                    }
                    weekOfYear = getWeekNumber(prevJan1, fixedDec31);
                }
            }
            internalSet(3, weekOfYear);
            internalSet(4, getWeekNumber(fixedDateMonth1, fixedDate2));
            return month | 344;
        }
        return mask;
    }

    private int getWeekNumber(long fixedDay1, long fixedDate) {
        long fixedDay1st = Gregorian.getDayOfWeekDateOnOrBefore(6 + fixedDay1, getFirstDayOfWeek());
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

    /* JADX WARN: Removed duplicated region for block: B:94:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0122  */
    @Override // java.util.Calendar
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void computeTime() {
        /*
            Method dump skipped, instructions count: 509
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.GregorianCalendar.computeTime():void");
    }

    private long adjustForZoneAndDaylightSavingsTime(int tzMask, long utcTimeInMillis, TimeZone zone) {
        int zoneOffset = 0;
        int dstOffset = 0;
        if (tzMask != 98304) {
            if (this.zoneOffsets == null) {
                this.zoneOffsets = new int[2];
            }
            int gmtOffset = isFieldSet(tzMask, 15) ? internalGet(15) : zone.getRawOffset();
            long standardTimeInZone = utcTimeInMillis - gmtOffset;
            if (zone instanceof ZoneInfo) {
                ZoneInfo zoneInfo = (ZoneInfo) zone;
                zoneInfo.getOffsetsByUtcTime(standardTimeInZone, this.zoneOffsets);
            } else {
                zone.getOffsets(standardTimeInZone, this.zoneOffsets);
            }
            int[] iArr = this.zoneOffsets;
            zoneOffset = iArr[0];
            int dstOffset2 = iArr[1];
            dstOffset = adjustDstOffsetForInvalidWallClock(standardTimeInZone, zone, dstOffset2);
        }
        if (tzMask != 0) {
            if (isFieldSet(tzMask, 15)) {
                zoneOffset = internalGet(15);
            }
            if (isFieldSet(tzMask, 16)) {
                dstOffset = internalGet(16);
            }
        }
        return (utcTimeInMillis - zoneOffset) - dstOffset;
    }

    private int adjustDstOffsetForInvalidWallClock(long standardTimeInZone, TimeZone zone, int dstOffset) {
        if (dstOffset != 0 && !zone.inDaylightTime(new Date(standardTimeInZone - dstOffset))) {
            return 0;
        }
        return dstOffset;
    }

    private long getFixedDate(BaseCalendar cal, int year, int fieldMask) {
        int year2;
        int dayOfWeek;
        int dayOfWeek2;
        int dowim;
        int month = 0;
        if (!isFieldSet(fieldMask, 2)) {
            year2 = year;
        } else {
            month = internalGet(2);
            if (month > 11) {
                year2 = year + (month / 12);
                month %= 12;
            } else if (month >= 0) {
                year2 = year;
            } else {
                int[] rem = new int[1];
                int year3 = year + CalendarUtils.floorDivide(month, 12, rem);
                month = rem[0];
                year2 = year3;
            }
        }
        int i10 = month + 1;
        Gregorian gregorian = gcal;
        long fixedDate = cal.getFixedDate(year2, i10, 1, cal == gregorian ? this.gdate : null);
        if (isFieldSet(fieldMask, 2)) {
            if (isFieldSet(fieldMask, 5)) {
                if (isSet(5)) {
                    return (fixedDate + internalGet(5)) - 1;
                }
                return fixedDate;
            }
            if (isFieldSet(fieldMask, 4)) {
                long firstDayOfWeek = BaseCalendar.getDayOfWeekDateOnOrBefore(fixedDate + 6, getFirstDayOfWeek());
                if (firstDayOfWeek - fixedDate >= getMinimalDaysInFirstWeek()) {
                    firstDayOfWeek -= 7;
                }
                if (isFieldSet(fieldMask, 7)) {
                    firstDayOfWeek = BaseCalendar.getDayOfWeekDateOnOrBefore(firstDayOfWeek + 6, internalGet(7));
                }
                return firstDayOfWeek + ((internalGet(4) - 1) * 7);
            }
            int year4 = year2;
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
            if (dowim < 0) {
                int lastDate = monthLength(month, year4) + ((dowim + 1) * 7);
                return BaseCalendar.getDayOfWeekDateOnOrBefore((lastDate + fixedDate) - 1, dayOfWeek2);
            }
            return BaseCalendar.getDayOfWeekDateOnOrBefore(((dowim * 7) + fixedDate) - 1, dayOfWeek2);
        }
        int year5 = year2;
        int i11 = this.gregorianCutoverYear;
        if (year5 == i11 && cal == gregorian && fixedDate < this.gregorianCutoverDate && i11 != this.gregorianCutoverYearJulian) {
            fixedDate = this.gregorianCutoverDate;
        }
        if (isFieldSet(fieldMask, 6)) {
            return (fixedDate + internalGet(6)) - 1;
        }
        long firstDayOfWeek2 = BaseCalendar.getDayOfWeekDateOnOrBefore(fixedDate + 6, getFirstDayOfWeek());
        if (firstDayOfWeek2 - fixedDate >= getMinimalDaysInFirstWeek()) {
            firstDayOfWeek2 -= 7;
        }
        if (isFieldSet(fieldMask, 7) && (dayOfWeek = internalGet(7)) != getFirstDayOfWeek()) {
            firstDayOfWeek2 = BaseCalendar.getDayOfWeekDateOnOrBefore(6 + firstDayOfWeek2, dayOfWeek);
        }
        return firstDayOfWeek2 + ((internalGet(3) - 1) * 7);
    }

    private GregorianCalendar getNormalizedCalendar() {
        if (isFullyNormalized()) {
            return this;
        }
        GregorianCalendar gc2 = (GregorianCalendar) clone();
        gc2.setLenient(true);
        gc2.complete();
        return gc2;
    }

    private static synchronized BaseCalendar getJulianCalendarSystem() {
        JulianCalendar julianCalendar;
        synchronized (GregorianCalendar.class) {
            if (jcal == null) {
                JulianCalendar julianCalendar2 = (JulianCalendar) CalendarSystem.forName("julian");
                jcal = julianCalendar2;
                jeras = julianCalendar2.getEras();
            }
            julianCalendar = jcal;
        }
        return julianCalendar;
    }

    private BaseCalendar getCutoverCalendarSystem() {
        if (this.gregorianCutoverYearJulian < this.gregorianCutoverYear) {
            return gcal;
        }
        return getJulianCalendarSystem();
    }

    private boolean isCutoverYear(int normalizedYear) {
        int cutoverYear = this.calsys == gcal ? this.gregorianCutoverYear : this.gregorianCutoverYearJulian;
        return normalizedYear == cutoverYear;
    }

    private long getFixedDateJan1(BaseCalendar.Date date, long fixedDate) {
        if (this.gregorianCutoverYear != this.gregorianCutoverYearJulian) {
            long j10 = this.gregorianCutoverDate;
            if (fixedDate >= j10) {
                return j10;
            }
        }
        BaseCalendar juliancal = getJulianCalendarSystem();
        return juliancal.getFixedDate(date.getNormalizedYear(), 1, 1, null);
    }

    private long getFixedDateMonth1(BaseCalendar.Date date, long fixedDate) {
        BaseCalendar.Date gCutover = getGregorianCutoverDate();
        if (gCutover.getMonth() == 1 && gCutover.getDayOfMonth() == 1) {
            return (fixedDate - date.getDayOfMonth()) + 1;
        }
        if (date.getMonth() == gCutover.getMonth()) {
            BaseCalendar.Date jLastDate = getLastJulianDate();
            if (this.gregorianCutoverYear == this.gregorianCutoverYearJulian && gCutover.getMonth() == jLastDate.getMonth()) {
                long fixedDateMonth1 = jcal.getFixedDate(date.getNormalizedYear(), date.getMonth(), 1, null);
                return fixedDateMonth1;
            }
            long fixedDateMonth12 = this.gregorianCutoverDate;
            return fixedDateMonth12;
        }
        long fixedDateMonth13 = 1 + (fixedDate - date.getDayOfMonth());
        return fixedDateMonth13;
    }

    private BaseCalendar.Date getCalendarDate(long fd2) {
        BaseCalendar cal = fd2 >= this.gregorianCutoverDate ? gcal : getJulianCalendarSystem();
        BaseCalendar.Date d10 = (BaseCalendar.Date) cal.newCalendarDate(TimeZone.NO_TIMEZONE);
        cal.getCalendarDateFromFixedDate(d10, fd2);
        return d10;
    }

    private BaseCalendar.Date getGregorianCutoverDate() {
        return getCalendarDate(this.gregorianCutoverDate);
    }

    private BaseCalendar.Date getLastJulianDate() {
        return getCalendarDate(this.gregorianCutoverDate - 1);
    }

    private int monthLength(int month, int year) {
        return isLeapYear(year) ? LEAP_MONTH_LENGTH[month] : MONTH_LENGTH[month];
    }

    private int monthLength(int month) {
        int year = internalGet(1);
        if (internalGetEra() == 0) {
            year = 1 - year;
        }
        return monthLength(month, year);
    }

    private int actualMonthLength() {
        int year = this.cdate.getNormalizedYear();
        if (year != this.gregorianCutoverYear && year != this.gregorianCutoverYearJulian) {
            return this.calsys.getMonthLength(this.cdate);
        }
        BaseCalendar.Date date = (BaseCalendar.Date) this.cdate.clone();
        long fd2 = this.calsys.getFixedDate(date);
        long month1 = getFixedDateMonth1(date, fd2);
        long next1 = this.calsys.getMonthLength(date) + month1;
        if (next1 < this.gregorianCutoverDate) {
            return (int) (next1 - month1);
        }
        if (this.cdate != this.gdate) {
            date = gcal.newCalendarDate(TimeZone.NO_TIMEZONE);
        }
        gcal.getCalendarDateFromFixedDate(date, next1);
        return (int) (getFixedDateMonth1(date, next1) - month1);
    }

    private int yearLength(int year) {
        return isLeapYear(year) ? 366 : 365;
    }

    private int yearLength() {
        int year = internalGet(1);
        if (internalGetEra() == 0) {
            year = 1 - year;
        }
        return yearLength(year);
    }

    private void pinDayOfMonth() {
        int monthLen;
        int year = internalGet(1);
        if (year > this.gregorianCutoverYear || year < this.gregorianCutoverYearJulian) {
            monthLen = monthLength(internalGet(2));
        } else {
            GregorianCalendar gc2 = getNormalizedCalendar();
            monthLen = gc2.getActualMaximum(5);
        }
        int dom = internalGet(5);
        if (dom > monthLen) {
            set(5, monthLen);
        }
    }

    private long getCurrentFixedDate() {
        BaseCalendar baseCalendar = this.calsys;
        return baseCalendar == gcal ? this.cachedFixedDate : baseCalendar.getFixedDate(this.cdate);
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
        if (isSet(0)) {
            return internalGet(0);
        }
        return 1;
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        if (this.gdate == null) {
            this.gdate = gcal.newCalendarDate(getZone());
            this.cachedFixedDate = Long.MIN_VALUE;
        }
        setGregorianChange(this.gregorianCutover);
    }

    public ZonedDateTime toZonedDateTime() {
        return ZonedDateTime.ofInstant(Instant.ofEpochMilli(getTimeInMillis()), getTimeZone().toZoneId());
    }

    public static GregorianCalendar from(ZonedDateTime zdt) {
        GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone(zdt.getZone()));
        cal.setGregorianChange(new Date(Long.MIN_VALUE));
        cal.setFirstDayOfWeek(2);
        cal.setMinimalDaysInFirstWeek(4);
        try {
            cal.setTimeInMillis(Math.addExact(Math.multiplyExact(zdt.toEpochSecond(), 1000), zdt.get(ChronoField.MILLI_OF_SECOND)));
            return cal;
        } catch (ArithmeticException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
}
