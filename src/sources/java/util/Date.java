package java.util;

import com.android.internal.accessibility.common.ShortcutConstants;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.time.Instant;
import org.apache.commons.lang3.time.TimeZones;
import sun.util.calendar.BaseCalendar;
import sun.util.calendar.CalendarSystem;
import sun.util.calendar.CalendarUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Date implements Serializable, Cloneable, Comparable<Date> {
    private static int defaultCenturyStart = 0;
    private static BaseCalendar jcal = null;
    private static final long serialVersionUID = 7523967970034938905L;
    private transient BaseCalendar.Date cdate;
    private transient long fastTime;
    private static final BaseCalendar gcal = CalendarSystem.getGregorianCalendar();
    private static final String[] wtb = {"am", "pm", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday", "january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december", "gmt", "ut", "utc", "est", "edt", "cst", "cdt", "mst", "mdt", t.f36234s, "pdt"};
    private static final int[] ttb = {14, 1, 0, 0, 0, 0, 0, 0, 0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 10000, 10000, 10000, 10300, 10240, 10360, 10300, 10420, 10360, 10480, 10420};

    public Date() {
        this(System.currentTimeMillis());
    }

    public Date(long date) {
        this.fastTime = date;
    }

    @Deprecated
    public Date(int year, int month, int date) {
        this(year, month, date, 0, 0, 0);
    }

    @Deprecated
    public Date(int year, int month, int date, int hrs, int min) {
        this(year, month, date, hrs, min, 0);
    }

    @Deprecated
    public Date(int year, int month, int date, int hrs, int min, int sec) {
        int y10 = year + 1900;
        if (month >= 12) {
            y10 += month / 12;
            month %= 12;
        } else if (month < 0) {
            y10 += CalendarUtils.floorDivide(month, 12);
            month = CalendarUtils.mod(month, 12);
        }
        BaseCalendar cal = getCalendarSystem(y10);
        BaseCalendar.Date date2 = (BaseCalendar.Date) cal.newCalendarDate(TimeZone.getDefaultRef());
        this.cdate = date2;
        date2.setNormalizedDate(y10, month + 1, date).setTimeOfDay(hrs, min, sec, 0);
        getTimeImpl();
        this.cdate = null;
    }

    @Deprecated
    public Date(String s2) {
        this(parse(s2));
    }

    public Object clone() {
        Date d10 = null;
        try {
            d10 = (Date) super.clone();
            BaseCalendar.Date date = this.cdate;
            if (date != null) {
                d10.cdate = (BaseCalendar.Date) date.clone();
            }
        } catch (CloneNotSupportedException e2) {
        }
        return d10;
    }

    @Deprecated
    public static long UTC(int year, int month, int date, int hrs, int min, int sec) {
        int y10 = year + 1900;
        if (month >= 12) {
            y10 += month / 12;
            month %= 12;
        } else if (month < 0) {
            y10 += CalendarUtils.floorDivide(month, 12);
            month = CalendarUtils.mod(month, 12);
        }
        int m10 = month + 1;
        BaseCalendar cal = getCalendarSystem(y10);
        BaseCalendar.Date udate = (BaseCalendar.Date) cal.newCalendarDate(null);
        udate.setNormalizedDate(y10, m10, date).setTimeOfDay(hrs, min, sec, 0);
        Date d10 = new Date(0L);
        d10.normalize(udate);
        return d10.fastTime;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0080, code lost:
    
        if (r9 != Integer.MIN_VALUE) goto L88;
     */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long parse(java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 777
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.Date.parse(java.lang.String):long");
    }

    @Deprecated
    public int getYear() {
        return normalize().getYear() - 1900;
    }

    @Deprecated
    public void setYear(int year) {
        getCalendarDate().setNormalizedYear(year + 1900);
    }

    @Deprecated
    public int getMonth() {
        return normalize().getMonth() - 1;
    }

    @Deprecated
    public void setMonth(int month) {
        int y10 = 0;
        if (month >= 12) {
            y10 = month / 12;
            month %= 12;
        } else if (month < 0) {
            y10 = CalendarUtils.floorDivide(month, 12);
            month = CalendarUtils.mod(month, 12);
        }
        BaseCalendar.Date d10 = getCalendarDate();
        if (y10 != 0) {
            d10.setNormalizedYear(d10.getNormalizedYear() + y10);
        }
        d10.setMonth(month + 1);
    }

    @Deprecated
    public int getDate() {
        return normalize().getDayOfMonth();
    }

    @Deprecated
    public void setDate(int date) {
        getCalendarDate().setDayOfMonth(date);
    }

    @Deprecated
    public int getDay() {
        return normalize().getDayOfWeek() - 1;
    }

    @Deprecated
    public int getHours() {
        return normalize().getHours();
    }

    @Deprecated
    public void setHours(int hours) {
        getCalendarDate().setHours(hours);
    }

    @Deprecated
    public int getMinutes() {
        return normalize().getMinutes();
    }

    @Deprecated
    public void setMinutes(int minutes) {
        getCalendarDate().setMinutes(minutes);
    }

    @Deprecated
    public int getSeconds() {
        return normalize().getSeconds();
    }

    @Deprecated
    public void setSeconds(int seconds) {
        getCalendarDate().setSeconds(seconds);
    }

    public long getTime() {
        return getTimeImpl();
    }

    private final long getTimeImpl() {
        BaseCalendar.Date date = this.cdate;
        if (date != null && !date.isNormalized()) {
            normalize();
        }
        return this.fastTime;
    }

    public void setTime(long time) {
        this.fastTime = time;
        this.cdate = null;
    }

    public boolean before(Date when) {
        return getMillisOf(this) < getMillisOf(when);
    }

    public boolean after(Date when) {
        return getMillisOf(this) > getMillisOf(when);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Date) && getTime() == ((Date) obj).getTime();
    }

    static final long getMillisOf(Date date) {
        if (date.getClass() != Date.class) {
            return date.getTime();
        }
        BaseCalendar.Date date2 = date.cdate;
        if (date2 == null || date2.isNormalized()) {
            return date.fastTime;
        }
        BaseCalendar.Date d10 = (BaseCalendar.Date) date.cdate.clone();
        return gcal.getTime(d10);
    }

    @Override // java.lang.Comparable
    public int compareTo(Date anotherDate) {
        long thisTime = getMillisOf(this);
        long anotherTime = getMillisOf(anotherDate);
        if (thisTime < anotherTime) {
            return -1;
        }
        return thisTime == anotherTime ? 0 : 1;
    }

    public int hashCode() {
        long ht = getTime();
        return ((int) ht) ^ ((int) (ht >> 32));
    }

    public String toString() {
        BaseCalendar.Date date = normalize();
        StringBuilder sb2 = new StringBuilder(28);
        int index = date.getDayOfWeek();
        if (index == 1) {
            index = 8;
        }
        String[] strArr = wtb;
        convertToAbbr(sb2, strArr[index]).append(' ');
        convertToAbbr(sb2, strArr[(date.getMonth() - 1) + 2 + 7]).append(' ');
        CalendarUtils.sprintf0d(sb2, date.getDayOfMonth(), 2).append(' ');
        CalendarUtils.sprintf0d(sb2, date.getHours(), 2).append(ShortcutConstants.SERVICES_SEPARATOR);
        CalendarUtils.sprintf0d(sb2, date.getMinutes(), 2).append(ShortcutConstants.SERVICES_SEPARATOR);
        CalendarUtils.sprintf0d(sb2, date.getSeconds(), 2).append(' ');
        TimeZone zi = date.getZone();
        if (zi != null) {
            sb2.append(zi.getDisplayName(date.isDaylightTime(), 0, Locale.US));
        } else {
            sb2.append(TimeZones.GMT_ID);
        }
        sb2.append(' ').append(date.getYear());
        return sb2.toString();
    }

    private static final StringBuilder convertToAbbr(StringBuilder sb2, String name) {
        sb2.append(Character.toUpperCase(name.charAt(0)));
        sb2.append(name.charAt(1)).append(name.charAt(2));
        return sb2;
    }

    @Deprecated
    public String toLocaleString() {
        DateFormat formatter = DateFormat.getDateTimeInstance();
        return formatter.format(this);
    }

    @Deprecated
    public String toGMTString() {
        long t2 = getTime();
        BaseCalendar cal = getCalendarSystem(t2);
        BaseCalendar.Date date = (BaseCalendar.Date) cal.getCalendarDate(getTime(), (TimeZone) null);
        StringBuilder sb2 = new StringBuilder(32);
        CalendarUtils.sprintf0d(sb2, date.getDayOfMonth(), 1).append(' ');
        convertToAbbr(sb2, wtb[(date.getMonth() - 1) + 2 + 7]).append(' ');
        sb2.append(date.getYear()).append(' ');
        CalendarUtils.sprintf0d(sb2, date.getHours(), 2).append(ShortcutConstants.SERVICES_SEPARATOR);
        CalendarUtils.sprintf0d(sb2, date.getMinutes(), 2).append(ShortcutConstants.SERVICES_SEPARATOR);
        CalendarUtils.sprintf0d(sb2, date.getSeconds(), 2);
        sb2.append(" GMT");
        return sb2.toString();
    }

    @Deprecated
    public int getTimezoneOffset() {
        int zoneOffset;
        if (this.cdate == null) {
            GregorianCalendar cal = new GregorianCalendar(this.fastTime);
            zoneOffset = cal.get(15) + cal.get(16);
        } else {
            normalize();
            zoneOffset = this.cdate.getZoneOffset();
        }
        return (-zoneOffset) / 60000;
    }

    private final BaseCalendar.Date getCalendarDate() {
        if (this.cdate == null) {
            BaseCalendar cal = getCalendarSystem(this.fastTime);
            this.cdate = (BaseCalendar.Date) cal.getCalendarDate(this.fastTime, TimeZone.getDefaultRef());
        }
        return this.cdate;
    }

    private final BaseCalendar.Date normalize() {
        BaseCalendar.Date date = this.cdate;
        if (date == null) {
            BaseCalendar cal = getCalendarSystem(this.fastTime);
            BaseCalendar.Date date2 = (BaseCalendar.Date) cal.getCalendarDate(this.fastTime, TimeZone.getDefaultRef());
            this.cdate = date2;
            return date2;
        }
        if (!date.isNormalized()) {
            this.cdate = normalize(this.cdate);
        }
        TimeZone tz = TimeZone.getDefaultRef();
        if (tz != this.cdate.getZone()) {
            this.cdate.setZone(tz);
            CalendarSystem cal2 = getCalendarSystem(this.cdate);
            cal2.getCalendarDate(this.fastTime, this.cdate);
        }
        return this.cdate;
    }

    private final BaseCalendar.Date normalize(BaseCalendar.Date date) {
        TimeZone tz;
        BaseCalendar.Date date2;
        int y10 = date.getNormalizedYear();
        int m10 = date.getMonth();
        int d10 = date.getDayOfMonth();
        int hh = date.getHours();
        int mm = date.getMinutes();
        int ss = date.getSeconds();
        int ms = date.getMillis();
        TimeZone tz2 = date.getZone();
        if (y10 == 1582 || y10 > 280000000 || y10 < -280000000) {
            if (tz2 != null) {
                tz = tz2;
            } else {
                tz = TimeZone.getTimeZone(TimeZones.GMT_ID);
            }
            GregorianCalendar gc2 = new GregorianCalendar(tz);
            gc2.clear();
            gc2.set(14, ms);
            gc2.set(y10, m10 - 1, d10, hh, mm, ss);
            long timeInMillis = gc2.getTimeInMillis();
            this.fastTime = timeInMillis;
            return (BaseCalendar.Date) getCalendarSystem(timeInMillis).getCalendarDate(this.fastTime, tz);
        }
        BaseCalendar cal = getCalendarSystem(y10);
        if (cal == getCalendarSystem(date)) {
            date2 = date;
        } else {
            date2 = (BaseCalendar.Date) cal.newCalendarDate(tz2);
            date2.setNormalizedDate(y10, m10, d10).setTimeOfDay(hh, mm, ss, ms);
        }
        long time = cal.getTime(date2);
        this.fastTime = time;
        BaseCalendar ncal = getCalendarSystem(time);
        if (ncal != cal) {
            BaseCalendar.Date date3 = (BaseCalendar.Date) ncal.newCalendarDate(tz2);
            date3.setNormalizedDate(y10, m10, d10).setTimeOfDay(hh, mm, ss, ms);
            this.fastTime = ncal.getTime(date3);
            return date3;
        }
        return date2;
    }

    private static final BaseCalendar getCalendarSystem(int year) {
        if (year >= 1582) {
            return gcal;
        }
        return getJulianCalendar();
    }

    private static final BaseCalendar getCalendarSystem(long utc) {
        if (utc >= 0 || utc >= (-12219292800000L) - TimeZone.getDefaultRef().getOffset(utc)) {
            return gcal;
        }
        return getJulianCalendar();
    }

    private static final BaseCalendar getCalendarSystem(BaseCalendar.Date cdate) {
        if (jcal == null) {
            return gcal;
        }
        if (cdate.getEra() != null) {
            return jcal;
        }
        return gcal;
    }

    private static final synchronized BaseCalendar getJulianCalendar() {
        BaseCalendar baseCalendar;
        synchronized (Date.class) {
            if (jcal == null) {
                jcal = (BaseCalendar) CalendarSystem.forName("julian");
            }
            baseCalendar = jcal;
        }
        return baseCalendar;
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        s2.defaultWriteObject();
        s2.writeLong(getTimeImpl());
    }

    private void readObject(ObjectInputStream s2) throws IOException, ClassNotFoundException {
        s2.defaultReadObject();
        this.fastTime = s2.readLong();
    }

    public static Date from(Instant instant) {
        try {
            return new Date(instant.toEpochMilli());
        } catch (ArithmeticException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    public Instant toInstant() {
        return Instant.ofEpochMilli(getTime());
    }
}
