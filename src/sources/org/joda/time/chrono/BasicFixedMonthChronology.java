package org.joda.time.chrono;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
abstract class BasicFixedMonthChronology extends BasicChronology {
    public static final long MILLIS_PER_MONTH = 2592000000L;
    public static final long MILLIS_PER_YEAR = 31557600000L;
    public static final int MONTH_LENGTH = 30;
    private static final long serialVersionUID = 261387371998L;

    public BasicFixedMonthChronology(org.joda.time.a aVar, Object obj, int i10) {
        super(aVar, obj, i10);
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long getAverageMillisPerMonth() {
        return MILLIS_PER_MONTH;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long getAverageMillisPerYear() {
        return MILLIS_PER_YEAR;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long getAverageMillisPerYearDividedByTwo() {
        return 15778800000L;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public int getDayOfMonth(long j10) {
        return ((getDayOfYear(j10) - 1) % 30) + 1;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public int getDaysInMonthMax() {
        return 30;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public int getDaysInMonthMax(int i10) {
        return i10 != 13 ? 30 : 6;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public int getDaysInYearMonth(int i10, int i11) {
        if (i11 != 13) {
            return 30;
        }
        return isLeapYear(i10) ? 6 : 5;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public int getMaxMonth() {
        return 13;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public int getMonthOfYear(long j10) {
        return ((getDayOfYear(j10) - 1) / 30) + 1;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long getTotalMillisByYearMonth(int i10, int i11) {
        return (i11 - 1) * MILLIS_PER_MONTH;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long getYearDifference(long j10, long j11) {
        int year = getYear(j10);
        int year2 = getYear(j11);
        long yearMillis = j10 - getYearMillis(year);
        int i10 = year - year2;
        if (yearMillis < j11 - getYearMillis(year2)) {
            i10--;
        }
        return i10;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public boolean isLeapYear(int i10) {
        return (i10 & 3) == 3;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public long setYear(long j10, int i10) {
        int dayOfYear = getDayOfYear(j10, getYear(j10));
        int millisOfDay = getMillisOfDay(j10);
        if (dayOfYear > 365 && !isLeapYear(i10)) {
            dayOfYear--;
        }
        return getYearMonthDayMillis(i10, 1, dayOfYear) + millisOfDay;
    }

    @Override // org.joda.time.chrono.BasicChronology
    public int getMonthOfYear(long j10, int i10) {
        return ((int) ((j10 - getYearMillis(i10)) / MILLIS_PER_MONTH)) + 1;
    }
}
