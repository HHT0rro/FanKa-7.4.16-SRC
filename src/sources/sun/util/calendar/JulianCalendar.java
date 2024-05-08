package sun.util.calendar;

import java.util.TimeZone;
import sun.util.calendar.BaseCalendar;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class JulianCalendar extends BaseCalendar {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BCE = 0;
    private static final int CE = 1;
    private static final int JULIAN_EPOCH = -1;
    private static final Era[] eras = {new Era("BeforeCommonEra", "B.C.E.", Long.MIN_VALUE, false), new Era("CommonEra", "C.E.", -62135709175808L, true)};

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Date extends BaseCalendar.Date {
        protected Date() {
            setCache(1, -1L, 365);
        }

        protected Date(TimeZone zone) {
            super(zone);
            setCache(1, -1L, 365);
        }

        @Override // sun.util.calendar.CalendarDate
        public Date setEra(Era era) {
            if (era == null) {
                throw new NullPointerException();
            }
            if (era != JulianCalendar.eras[0] || era != JulianCalendar.eras[1]) {
                throw new IllegalArgumentException("unknown era: " + ((Object) era));
            }
            super.setEra(era);
            return this;
        }

        protected void setKnownEra(Era era) {
            super.setEra(era);
        }

        @Override // sun.util.calendar.BaseCalendar.Date
        public int getNormalizedYear() {
            if (getEra() == JulianCalendar.eras[0]) {
                return 1 - getYear();
            }
            return getYear();
        }

        @Override // sun.util.calendar.BaseCalendar.Date
        public void setNormalizedYear(int year) {
            if (year <= 0) {
                setYear(1 - year);
                setKnownEra(JulianCalendar.eras[0]);
            } else {
                setYear(year);
                setKnownEra(JulianCalendar.eras[1]);
            }
        }

        @Override // sun.util.calendar.CalendarDate
        public String toString() {
            String n10;
            String time = super.toString();
            String time2 = time.substring(time.indexOf(84));
            StringBuffer sb2 = new StringBuffer();
            Era era = getEra();
            if (era != null && (n10 = era.getAbbreviation()) != null) {
                sb2.append(n10).append(' ');
            }
            sb2.append(getYear()).append('-');
            CalendarUtils.sprintf0d(sb2, getMonth(), 2).append('-');
            CalendarUtils.sprintf0d(sb2, getDayOfMonth(), 2);
            sb2.append(time2);
            return sb2.toString();
        }
    }

    JulianCalendar() {
        setEras(eras);
    }

    @Override // sun.util.calendar.CalendarSystem
    public String getName() {
        return "julian";
    }

    @Override // sun.util.calendar.AbstractCalendar, sun.util.calendar.CalendarSystem
    public Date getCalendarDate() {
        return getCalendarDate(System.currentTimeMillis(), (CalendarDate) newCalendarDate());
    }

    @Override // sun.util.calendar.AbstractCalendar, sun.util.calendar.CalendarSystem
    public Date getCalendarDate(long millis) {
        return getCalendarDate(millis, (CalendarDate) newCalendarDate());
    }

    @Override // sun.util.calendar.AbstractCalendar, sun.util.calendar.CalendarSystem
    public Date getCalendarDate(long millis, CalendarDate date) {
        return (Date) super.getCalendarDate(millis, date);
    }

    @Override // sun.util.calendar.AbstractCalendar, sun.util.calendar.CalendarSystem
    public Date getCalendarDate(long millis, TimeZone zone) {
        return getCalendarDate(millis, (CalendarDate) newCalendarDate(zone));
    }

    @Override // sun.util.calendar.CalendarSystem
    public Date newCalendarDate() {
        return new Date();
    }

    @Override // sun.util.calendar.CalendarSystem
    public Date newCalendarDate(TimeZone zone) {
        return new Date(zone);
    }

    @Override // sun.util.calendar.BaseCalendar
    public long getFixedDate(int jyear, int month, int dayOfMonth, BaseCalendar.Date cache) {
        long days;
        boolean isJan1 = month == 1 && dayOfMonth == 1;
        if (cache != null && cache.hit(jyear)) {
            if (!isJan1) {
                return (cache.getCachedJan1() + getDayOfYear(jyear, month, dayOfMonth)) - 1;
            }
            return cache.getCachedJan1();
        }
        long y10 = jyear;
        long days2 = (((y10 - 1) * 365) - 2) + dayOfMonth;
        if (y10 > 0) {
            days = days2 + ((y10 - 1) / 4);
        } else {
            days = days2 + CalendarUtils.floorDivide(y10 - 1, 4L);
        }
        long days3 = month > 0 ? days + (((month * 367) - 362) / 12) : days + CalendarUtils.floorDivide((month * 367) - 362, 12L);
        if (month > 2) {
            days3 -= CalendarUtils.isJulianLeapYear(jyear) ? 1L : 2L;
        }
        if (cache != null && isJan1) {
            cache.setCache(jyear, days3, CalendarUtils.isJulianLeapYear(jyear) ? 366 : 365);
        }
        return days3;
    }

    @Override // sun.util.calendar.BaseCalendar, sun.util.calendar.AbstractCalendar
    public void getCalendarDateFromFixedDate(CalendarDate date, long fixedDate) {
        int year;
        int month;
        Date jdate = (Date) date;
        long fd2 = ((fixedDate - (-1)) * 4) + 1464;
        if (fd2 >= 0) {
            year = (int) (fd2 / 1461);
        } else {
            year = (int) CalendarUtils.floorDivide(fd2, 1461L);
        }
        int priorDays = (int) (fixedDate - getFixedDate(year, 1, 1, jdate));
        boolean isLeap = CalendarUtils.isJulianLeapYear(year);
        if (fixedDate >= getFixedDate(year, 3, 1, jdate)) {
            priorDays += isLeap ? 1 : 2;
        }
        int month2 = (priorDays * 12) + 373;
        if (month2 > 0) {
            month = month2 / 367;
        } else {
            month = CalendarUtils.floorDivide(month2, 367);
        }
        int dayOfMonth = ((int) (fixedDate - getFixedDate(year, month, 1, jdate))) + 1;
        int dayOfWeek = getDayOfWeekFromFixedDate(fixedDate);
        jdate.setNormalizedYear(year);
        jdate.setMonth(month);
        jdate.setDayOfMonth(dayOfMonth);
        jdate.setDayOfWeek(dayOfWeek);
        jdate.setLeapYear(isLeap);
        jdate.setNormalized(true);
    }

    @Override // sun.util.calendar.BaseCalendar
    public int getYearFromFixedDate(long fixedDate) {
        int year = (int) CalendarUtils.floorDivide(((fixedDate - (-1)) * 4) + 1464, 1461L);
        return year;
    }

    @Override // sun.util.calendar.BaseCalendar
    public int getDayOfWeek(CalendarDate date) {
        long fixedDate = getFixedDate(date);
        return getDayOfWeekFromFixedDate(fixedDate);
    }

    @Override // sun.util.calendar.BaseCalendar
    boolean isLeapYear(int jyear) {
        return CalendarUtils.isJulianLeapYear(jyear);
    }
}
