package sun.util.calendar;

import java.util.TimeZone;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class BaseCalendar extends AbstractCalendar {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int APRIL = 4;
    public static final int AUGUST = 8;
    private static final int BASE_YEAR = 1970;
    public static final int DECEMBER = 12;
    public static final int FEBRUARY = 2;
    public static final int FRIDAY = 6;
    public static final int JANUARY = 1;
    public static final int JULY = 7;
    public static final int JUNE = 6;
    public static final int MARCH = 3;
    public static final int MAY = 5;
    public static final int MONDAY = 2;
    public static final int NOVEMBER = 11;
    public static final int OCTOBER = 10;
    public static final int SATURDAY = 7;
    public static final int SEPTEMBER = 9;
    public static final int SUNDAY = 1;
    public static final int THURSDAY = 5;
    public static final int TUESDAY = 3;
    public static final int WEDNESDAY = 4;
    private static final int[] FIXED_DATES = {719163, 719528, 719893, 720259, 720624, 720989, 721354, 721720, 722085, 722450, 722815, 723181, 723546, 723911, 724276, 724642, 725007, 725372, 725737, 726103, 726468, 726833, 727198, 727564, 727929, 728294, 728659, 729025, 729390, 729755, 730120, 730486, 730851, 731216, 731581, 731947, 732312, 732677, 733042, 733408, 733773, 734138, 734503, 734869, 735234, 735599, 735964, 736330, 736695, 737060, 737425, 737791, 738156, 738521, 738886, 739252, 739617, 739982, 740347, 740713, 741078, 741443, 741808, 742174, 742539, 742904, 743269, 743635, 744000, 744365};
    static final int[] DAYS_IN_MONTH = {31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static final int[] ACCUMULATED_DAYS_IN_MONTH = {-30, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
    static final int[] ACCUMULATED_DAYS_IN_MONTH_LEAP = {-30, 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class Date extends CalendarDate {
        long cachedFixedDateJan1;
        long cachedFixedDateNextJan1;
        int cachedYear;

        public abstract int getNormalizedYear();

        public abstract void setNormalizedYear(int i10);

        /* JADX INFO: Access modifiers changed from: protected */
        public Date() {
            this.cachedYear = 2004;
            this.cachedFixedDateJan1 = 731581L;
            this.cachedFixedDateNextJan1 = 731581 + 366;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Date(TimeZone zone) {
            super(zone);
            this.cachedYear = 2004;
            this.cachedFixedDateJan1 = 731581L;
            this.cachedFixedDateNextJan1 = 731581 + 366;
        }

        public Date setNormalizedDate(int normalizedYear, int month, int dayOfMonth) {
            setNormalizedYear(normalizedYear);
            setMonth(month).setDayOfMonth(dayOfMonth);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final boolean hit(int year) {
            return year == this.cachedYear;
        }

        protected final boolean hit(long fixedDate) {
            return fixedDate >= this.cachedFixedDateJan1 && fixedDate < this.cachedFixedDateNextJan1;
        }

        protected int getCachedYear() {
            return this.cachedYear;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public long getCachedJan1() {
            return this.cachedFixedDateJan1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void setCache(int year, long jan1, int len) {
            this.cachedYear = year;
            this.cachedFixedDateJan1 = jan1;
            this.cachedFixedDateNextJan1 = len + jan1;
        }
    }

    @Override // sun.util.calendar.CalendarSystem
    public boolean validate(CalendarDate date) {
        int d10;
        Date bdate = (Date) date;
        if (bdate.isNormalized()) {
            return true;
        }
        int month = bdate.getMonth();
        if (month < 1 || month > 12 || (d10 = bdate.getDayOfMonth()) <= 0 || d10 > getMonthLength(bdate.getNormalizedYear(), month)) {
            return false;
        }
        int dow = bdate.getDayOfWeek();
        if ((dow != Integer.MIN_VALUE && dow != getDayOfWeek(bdate)) || !validateTime(date)) {
            return false;
        }
        bdate.setNormalized(true);
        return true;
    }

    @Override // sun.util.calendar.CalendarSystem
    public boolean normalize(CalendarDate date) {
        if (date.isNormalized()) {
            return true;
        }
        Date bdate = (Date) date;
        TimeZone zi = bdate.getZone();
        if (zi != null) {
            getTime(date);
            return true;
        }
        int days = normalizeTime(bdate);
        normalizeMonth(bdate);
        long d10 = bdate.getDayOfMonth() + days;
        int m10 = bdate.getMonth();
        int y10 = bdate.getNormalizedYear();
        int ml = getMonthLength(y10, m10);
        if (d10 > 0 && d10 <= ml) {
            bdate.setDayOfWeek(getDayOfWeek(bdate));
        } else if (d10 <= 0 && d10 > -28) {
            int m11 = m10 - 1;
            bdate.setDayOfMonth((int) (d10 + getMonthLength(y10, m11)));
            if (m11 == 0) {
                m11 = 12;
                bdate.setNormalizedYear(y10 - 1);
            }
            bdate.setMonth(m11);
        } else if (d10 > ml && d10 < ml + 28) {
            int m12 = m10 + 1;
            bdate.setDayOfMonth((int) (d10 - ml));
            if (m12 > 12) {
                bdate.setNormalizedYear(y10 + 1);
                m12 = 1;
            }
            bdate.setMonth(m12);
        } else {
            long fixedDate = (getFixedDate(y10, m10, 1, bdate) + d10) - 1;
            getCalendarDateFromFixedDate(bdate, fixedDate);
        }
        date.setLeapYear(isLeapYear(bdate.getNormalizedYear()));
        date.setZoneOffset(0);
        date.setDaylightSaving(0);
        bdate.setNormalized(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void normalizeMonth(CalendarDate date) {
        Date bdate = (Date) date;
        int year = bdate.getNormalizedYear();
        long month = bdate.getMonth();
        if (month > 0) {
            if (month > 12) {
                bdate.setNormalizedYear(year + ((int) ((month - 1) / 12)));
                bdate.setMonth((int) (((month - 1) % 12) + 1));
                return;
            }
            return;
        }
        long xm = 1 - month;
        int year2 = year - ((int) ((xm / 12) + 1));
        long month2 = 13 - (xm % 12);
        if (month2 == 13) {
            year2++;
            month2 = 1;
        }
        bdate.setNormalizedYear(year2);
        bdate.setMonth((int) month2);
    }

    @Override // sun.util.calendar.CalendarSystem
    public int getYearLength(CalendarDate date) {
        return isLeapYear(((Date) date).getNormalizedYear()) ? 366 : 365;
    }

    @Override // sun.util.calendar.CalendarSystem
    public int getYearLengthInMonths(CalendarDate date) {
        return 12;
    }

    @Override // sun.util.calendar.CalendarSystem
    public int getMonthLength(CalendarDate date) {
        Date gdate = (Date) date;
        int month = gdate.getMonth();
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Illegal month value: " + month);
        }
        return getMonthLength(gdate.getNormalizedYear(), month);
    }

    private int getMonthLength(int year, int month) {
        int days = DAYS_IN_MONTH[month];
        if (month == 2 && isLeapYear(year)) {
            return days + 1;
        }
        return days;
    }

    public long getDayOfYear(CalendarDate date) {
        return getDayOfYear(((Date) date).getNormalizedYear(), date.getMonth(), date.getDayOfMonth());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long getDayOfYear(int year, int month, int dayOfMonth) {
        return dayOfMonth + (isLeapYear(year) ? ACCUMULATED_DAYS_IN_MONTH_LEAP[month] : ACCUMULATED_DAYS_IN_MONTH[month]);
    }

    @Override // sun.util.calendar.AbstractCalendar
    public long getFixedDate(CalendarDate date) {
        if (!date.isNormalized()) {
            normalizeMonth(date);
        }
        return getFixedDate(((Date) date).getNormalizedYear(), date.getMonth(), date.getDayOfMonth(), (Date) date);
    }

    public long getFixedDate(int year, int month, int dayOfMonth, Date cache) {
        long days;
        boolean isJan1 = month == 1 && dayOfMonth == 1;
        if (cache != null && cache.hit(year)) {
            if (!isJan1) {
                return (cache.getCachedJan1() + getDayOfYear(year, month, dayOfMonth)) - 1;
            }
            return cache.getCachedJan1();
        }
        int n10 = year - 1970;
        if (n10 >= 0) {
            int[] iArr = FIXED_DATES;
            if (n10 < iArr.length) {
                long jan1 = iArr[n10];
                if (cache != null) {
                    cache.setCache(year, jan1, isLeapYear(year) ? 366 : 365);
                }
                return isJan1 ? jan1 : (getDayOfYear(year, month, dayOfMonth) + jan1) - 1;
            }
        }
        long prevyear = year - 1;
        long days2 = dayOfMonth;
        if (prevyear >= 0) {
            days = days2 + (((365 * prevyear) + (prevyear / 4)) - (prevyear / 100)) + (prevyear / 400) + (((month * 367) - 362) / 12);
        } else {
            days = days2 + (((365 * prevyear) + CalendarUtils.floorDivide(prevyear, 4L)) - CalendarUtils.floorDivide(prevyear, 100L)) + CalendarUtils.floorDivide(prevyear, 400L) + CalendarUtils.floorDivide((month * 367) - 362, 12);
        }
        if (month > 2) {
            days -= isLeapYear(year) ? 1L : 2L;
        }
        if (cache != null && isJan1) {
            cache.setCache(year, days, isLeapYear(year) ? 366 : 365);
        }
        return days;
    }

    @Override // sun.util.calendar.AbstractCalendar
    public void getCalendarDateFromFixedDate(CalendarDate date, long fixedDate) {
        int year;
        long jan1;
        boolean isLeap;
        int month;
        Date gdate = (Date) date;
        if (gdate.hit(fixedDate)) {
            year = gdate.getCachedYear();
            jan1 = gdate.getCachedJan1();
            isLeap = isLeapYear(year);
        } else {
            year = getGregorianYearFromFixedDate(fixedDate);
            jan1 = getFixedDate(year, 1, 1, null);
            isLeap = isLeapYear(year);
            gdate.setCache(year, jan1, isLeap ? 366 : 365);
        }
        int priorDays = (int) (fixedDate - jan1);
        long mar1 = 31 + jan1 + 28;
        if (isLeap) {
            mar1++;
        }
        if (fixedDate >= mar1) {
            priorDays += isLeap ? 1 : 2;
        }
        int month2 = (priorDays * 12) + 373;
        if (month2 > 0) {
            month = month2 / 367;
        } else {
            month = CalendarUtils.floorDivide(month2, 367);
        }
        long month1 = ACCUMULATED_DAYS_IN_MONTH[month] + jan1;
        if (isLeap && month >= 3) {
            month1++;
        }
        int dayOfMonth = ((int) (fixedDate - month1)) + 1;
        int dayOfWeek = getDayOfWeekFromFixedDate(fixedDate);
        gdate.setNormalizedYear(year);
        gdate.setMonth(month);
        gdate.setDayOfMonth(dayOfMonth);
        gdate.setDayOfWeek(dayOfWeek);
        gdate.setLeapYear(isLeap);
        gdate.setNormalized(true);
    }

    public int getDayOfWeek(CalendarDate date) {
        long fixedDate = getFixedDate(date);
        return getDayOfWeekFromFixedDate(fixedDate);
    }

    public static final int getDayOfWeekFromFixedDate(long fixedDate) {
        if (fixedDate >= 0) {
            return ((int) (fixedDate % 7)) + 1;
        }
        return ((int) CalendarUtils.mod(fixedDate, 7L)) + 1;
    }

    public int getYearFromFixedDate(long fixedDate) {
        return getGregorianYearFromFixedDate(fixedDate);
    }

    final int getGregorianYearFromFixedDate(long fixedDate) {
        int n400;
        int n100;
        int d32;
        int n12;
        if (fixedDate > 0) {
            long d02 = fixedDate - 1;
            n400 = (int) (d02 / 146097);
            int d12 = (int) (d02 % 146097);
            n100 = d12 / 36524;
            int d22 = d12 % 36524;
            d32 = d22 / 1461;
            int d33 = d22 % 1461;
            n12 = d33 / 365;
            int i10 = (d33 % 365) + 1;
        } else {
            long d03 = fixedDate - 1;
            n400 = (int) CalendarUtils.floorDivide(d03, 146097L);
            int d13 = (int) CalendarUtils.mod(d03, 146097L);
            n100 = CalendarUtils.floorDivide(d13, 36524);
            int d23 = CalendarUtils.mod(d13, 36524);
            int n42 = CalendarUtils.floorDivide(d23, 1461);
            int d34 = CalendarUtils.mod(d23, 1461);
            int n13 = CalendarUtils.floorDivide(d34, 365);
            int mod = CalendarUtils.mod(d34, 365) + 1;
            d32 = n42;
            n12 = n13;
        }
        int year = (n400 * 400) + (n100 * 100) + (d32 * 4) + n12;
        if (n100 != 4 && n12 != 4) {
            return year + 1;
        }
        return year;
    }

    @Override // sun.util.calendar.AbstractCalendar
    protected boolean isLeapYear(CalendarDate date) {
        return isLeapYear(((Date) date).getNormalizedYear());
    }

    boolean isLeapYear(int normalizedYear) {
        return CalendarUtils.isGregorianLeapYear(normalizedYear);
    }
}
