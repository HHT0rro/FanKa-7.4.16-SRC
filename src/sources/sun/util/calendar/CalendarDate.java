package sun.util.calendar;

import com.android.internal.accessibility.common.ShortcutConstants;
import java.util.Locale;
import java.util.TimeZone;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class CalendarDate implements Cloneable {
    public static final int FIELD_UNDEFINED = Integer.MIN_VALUE;
    public static final long TIME_UNDEFINED = Long.MIN_VALUE;
    private int dayOfMonth;
    private int dayOfWeek;
    private int daylightSaving;
    private Era era;
    private boolean forceStandardTime;
    private long fraction;
    private int hours;
    private boolean leapYear;
    private Locale locale;
    private int millis;
    private int minutes;
    private int month;
    private boolean normalized;
    private int seconds;
    private int year;
    private int zoneOffset;
    private TimeZone zoneinfo;

    /* JADX INFO: Access modifiers changed from: protected */
    public CalendarDate() {
        this(TimeZone.getDefault());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CalendarDate(TimeZone zone) {
        this.dayOfWeek = Integer.MIN_VALUE;
        this.zoneinfo = zone;
    }

    public Era getEra() {
        return this.era;
    }

    public CalendarDate setEra(Era era) {
        if (this.era == era) {
            return this;
        }
        this.era = era;
        this.normalized = false;
        return this;
    }

    public int getYear() {
        return this.year;
    }

    public CalendarDate setYear(int year) {
        if (this.year != year) {
            this.year = year;
            this.normalized = false;
        }
        return this;
    }

    public CalendarDate addYear(int n10) {
        if (n10 != 0) {
            this.year += n10;
            this.normalized = false;
        }
        return this;
    }

    public boolean isLeapYear() {
        return this.leapYear;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLeapYear(boolean leapYear) {
        this.leapYear = leapYear;
    }

    public int getMonth() {
        return this.month;
    }

    public CalendarDate setMonth(int month) {
        if (this.month != month) {
            this.month = month;
            this.normalized = false;
        }
        return this;
    }

    public CalendarDate addMonth(int n10) {
        if (n10 != 0) {
            this.month += n10;
            this.normalized = false;
        }
        return this;
    }

    public int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public CalendarDate setDayOfMonth(int date) {
        if (this.dayOfMonth != date) {
            this.dayOfMonth = date;
            this.normalized = false;
        }
        return this;
    }

    public CalendarDate addDayOfMonth(int n10) {
        if (n10 != 0) {
            this.dayOfMonth += n10;
            this.normalized = false;
        }
        return this;
    }

    public int getDayOfWeek() {
        if (!isNormalized()) {
            this.dayOfWeek = Integer.MIN_VALUE;
        }
        return this.dayOfWeek;
    }

    public int getHours() {
        return this.hours;
    }

    public CalendarDate setHours(int hours) {
        if (this.hours != hours) {
            this.hours = hours;
            this.normalized = false;
        }
        return this;
    }

    public CalendarDate addHours(int n10) {
        if (n10 != 0) {
            this.hours += n10;
            this.normalized = false;
        }
        return this;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public CalendarDate setMinutes(int minutes) {
        if (this.minutes != minutes) {
            this.minutes = minutes;
            this.normalized = false;
        }
        return this;
    }

    public CalendarDate addMinutes(int n10) {
        if (n10 != 0) {
            this.minutes += n10;
            this.normalized = false;
        }
        return this;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public CalendarDate setSeconds(int seconds) {
        if (this.seconds != seconds) {
            this.seconds = seconds;
            this.normalized = false;
        }
        return this;
    }

    public CalendarDate addSeconds(int n10) {
        if (n10 != 0) {
            this.seconds += n10;
            this.normalized = false;
        }
        return this;
    }

    public int getMillis() {
        return this.millis;
    }

    public CalendarDate setMillis(int millis) {
        if (this.millis != millis) {
            this.millis = millis;
            this.normalized = false;
        }
        return this;
    }

    public CalendarDate addMillis(int n10) {
        if (n10 != 0) {
            this.millis += n10;
            this.normalized = false;
        }
        return this;
    }

    public long getTimeOfDay() {
        if (!isNormalized()) {
            this.fraction = Long.MIN_VALUE;
            return Long.MIN_VALUE;
        }
        return this.fraction;
    }

    public CalendarDate setDate(int year, int month, int dayOfMonth) {
        setYear(year);
        setMonth(month);
        setDayOfMonth(dayOfMonth);
        return this;
    }

    public CalendarDate addDate(int year, int month, int dayOfMonth) {
        addYear(year);
        addMonth(month);
        addDayOfMonth(dayOfMonth);
        return this;
    }

    public CalendarDate setTimeOfDay(int hours, int minutes, int seconds, int millis) {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
        setMillis(millis);
        return this;
    }

    public CalendarDate addTimeOfDay(int hours, int minutes, int seconds, int millis) {
        addHours(hours);
        addMinutes(minutes);
        addSeconds(seconds);
        addMillis(millis);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTimeOfDay(long fraction) {
        this.fraction = fraction;
    }

    public boolean isNormalized() {
        return this.normalized;
    }

    public boolean isStandardTime() {
        return this.forceStandardTime;
    }

    public void setStandardTime(boolean standardTime) {
        this.forceStandardTime = standardTime;
    }

    public boolean isDaylightTime() {
        return (isStandardTime() || this.daylightSaving == 0) ? false : true;
    }

    protected void setLocale(Locale loc) {
        this.locale = loc;
    }

    public TimeZone getZone() {
        return this.zoneinfo;
    }

    public CalendarDate setZone(TimeZone zoneinfo) {
        this.zoneinfo = zoneinfo;
        return this;
    }

    public boolean isSameDate(CalendarDate date) {
        return getDayOfWeek() == date.getDayOfWeek() && getMonth() == date.getMonth() && getYear() == date.getYear() && getEra() == date.getEra();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CalendarDate)) {
            return false;
        }
        CalendarDate that = (CalendarDate) obj;
        if (isNormalized() != that.isNormalized()) {
            return false;
        }
        TimeZone timeZone = this.zoneinfo;
        boolean hasZone = timeZone != null;
        TimeZone timeZone2 = that.zoneinfo;
        boolean thatHasZone = timeZone2 != null;
        if (hasZone != thatHasZone) {
            return false;
        }
        return (!hasZone || timeZone.equals(timeZone2)) && getEra() == that.getEra() && this.year == that.year && this.month == that.month && this.dayOfMonth == that.dayOfMonth && this.hours == that.hours && this.minutes == that.minutes && this.seconds == that.seconds && this.millis == that.millis && this.zoneOffset == that.zoneOffset;
    }

    public int hashCode() {
        long j10 = (((((((this.hours + ((((((this.year - 1970) * 12) + (this.month - 1)) * 30) + this.dayOfMonth) * 24)) * 60) + this.minutes) * 60) + this.seconds) * 1000) + this.millis) - this.zoneOffset;
        boolean isNormalized = isNormalized();
        int i10 = 0;
        Era era = getEra();
        if (era != null) {
            i10 = era.hashCode();
        }
        TimeZone timeZone = this.zoneinfo;
        return (((((int) j10) * ((int) (j10 >> 32))) ^ i10) ^ (isNormalized ? 1 : 0)) ^ (timeZone != null ? timeZone.hashCode() : 0);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2);
        }
    }

    public String toString() {
        int offset;
        char sign;
        StringBuilder sb2 = new StringBuilder();
        CalendarUtils.sprintf0d(sb2, this.year, 4).append('-');
        CalendarUtils.sprintf0d(sb2, this.month, 2).append('-');
        CalendarUtils.sprintf0d(sb2, this.dayOfMonth, 2).append('T');
        CalendarUtils.sprintf0d(sb2, this.hours, 2).append(ShortcutConstants.SERVICES_SEPARATOR);
        CalendarUtils.sprintf0d(sb2, this.minutes, 2).append(ShortcutConstants.SERVICES_SEPARATOR);
        CalendarUtils.sprintf0d(sb2, this.seconds, 2).append('.');
        CalendarUtils.sprintf0d(sb2, this.millis, 3);
        int offset2 = this.zoneOffset;
        if (offset2 == 0) {
            sb2.append('Z');
        } else if (offset2 != Integer.MIN_VALUE) {
            if (offset2 > 0) {
                offset = this.zoneOffset;
                sign = '+';
            } else {
                offset = -offset2;
                sign = '-';
            }
            int offset3 = offset / 60000;
            sb2.append(sign);
            CalendarUtils.sprintf0d(sb2, offset3 / 60, 2);
            CalendarUtils.sprintf0d(sb2, offset3 % 60, 2);
        } else {
            sb2.append(" local time");
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNormalized(boolean normalized) {
        this.normalized = normalized;
    }

    public int getZoneOffset() {
        return this.zoneOffset;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setZoneOffset(int offset) {
        this.zoneOffset = offset;
    }

    public int getDaylightSaving() {
        return this.daylightSaving;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setDaylightSaving(int daylightSaving) {
        this.daylightSaving = daylightSaving;
    }
}
