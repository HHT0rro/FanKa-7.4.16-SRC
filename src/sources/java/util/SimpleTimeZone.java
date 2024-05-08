package java.util;

import com.alibaba.wireless.security.SecExceptionCode;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import sun.util.calendar.BaseCalendar;
import sun.util.calendar.CalendarSystem;
import sun.util.calendar.CalendarUtils;
import sun.util.calendar.Gregorian;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SimpleTimeZone extends TimeZone {
    private static final int DOM_MODE = 1;
    private static final int DOW_GE_DOM_MODE = 3;
    private static final int DOW_IN_MONTH_MODE = 2;
    private static final int DOW_LE_DOM_MODE = 4;
    private static final int MAX_RULE_NUM = 6;
    public static final int STANDARD_TIME = 1;
    public static final int UTC_TIME = 2;
    public static final int WALL_TIME = 0;
    static final int currentSerialVersion = 2;
    private static final int millisPerDay = 86400000;
    private static final int millisPerHour = 3600000;
    static final long serialVersionUID = -403250971215465050L;
    private volatile transient Cache cache;
    private int dstSavings;
    private int endDay;
    private int endDayOfWeek;
    private int endMode;
    private int endMonth;
    private int endTime;
    private int endTimeMode;
    private final byte[] monthLength;
    private int rawOffset;
    private int serialVersionOnStream;
    private int startDay;
    private int startDayOfWeek;
    private int startMode;
    private int startMonth;
    private int startTime;
    private int startTimeMode;
    private int startYear;
    private boolean useDaylight;
    private static final byte[] staticMonthLength = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final byte[] staticLeapMonthLength = {31, Character.INITIAL_QUOTE_PUNCTUATION, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final Gregorian gcal = CalendarSystem.getGregorianCalendar();

    public SimpleTimeZone(int rawOffset, String ID) {
        this.useDaylight = false;
        this.monthLength = staticMonthLength;
        this.serialVersionOnStream = 2;
        this.rawOffset = rawOffset;
        setID(ID);
        this.dstSavings = 3600000;
    }

    public SimpleTimeZone(int rawOffset, String ID, int startMonth, int startDay, int startDayOfWeek, int startTime, int endMonth, int endDay, int endDayOfWeek, int endTime) {
        this(rawOffset, ID, startMonth, startDay, startDayOfWeek, startTime, 0, endMonth, endDay, endDayOfWeek, endTime, 0, 3600000);
    }

    public SimpleTimeZone(int rawOffset, String ID, int startMonth, int startDay, int startDayOfWeek, int startTime, int endMonth, int endDay, int endDayOfWeek, int endTime, int dstSavings) {
        this(rawOffset, ID, startMonth, startDay, startDayOfWeek, startTime, 0, endMonth, endDay, endDayOfWeek, endTime, 0, dstSavings);
    }

    public SimpleTimeZone(int rawOffset, String ID, int startMonth, int startDay, int startDayOfWeek, int startTime, int startTimeMode, int endMonth, int endDay, int endDayOfWeek, int endTime, int endTimeMode, int dstSavings) {
        this.useDaylight = false;
        this.monthLength = staticMonthLength;
        this.serialVersionOnStream = 2;
        setID(ID);
        this.rawOffset = rawOffset;
        this.startMonth = startMonth;
        this.startDay = startDay;
        this.startDayOfWeek = startDayOfWeek;
        this.startTime = startTime;
        this.startTimeMode = startTimeMode;
        this.endMonth = endMonth;
        this.endDay = endDay;
        this.endDayOfWeek = endDayOfWeek;
        this.endTime = endTime;
        this.endTimeMode = endTimeMode;
        this.dstSavings = dstSavings;
        decodeRules();
        if (dstSavings <= 0) {
            throw new IllegalArgumentException("Illegal daylight saving value: " + dstSavings);
        }
    }

    public void setStartYear(int year) {
        this.startYear = year;
        invalidateCache();
    }

    public void setStartRule(int startMonth, int startDay, int startDayOfWeek, int startTime) {
        this.startMonth = startMonth;
        this.startDay = startDay;
        this.startDayOfWeek = startDayOfWeek;
        this.startTime = startTime;
        this.startTimeMode = 0;
        decodeStartRule();
        invalidateCache();
    }

    public void setStartRule(int startMonth, int startDay, int startTime) {
        setStartRule(startMonth, startDay, 0, startTime);
    }

    public void setStartRule(int startMonth, int startDay, int startDayOfWeek, int startTime, boolean after) {
        if (after) {
            setStartRule(startMonth, startDay, -startDayOfWeek, startTime);
        } else {
            setStartRule(startMonth, -startDay, -startDayOfWeek, startTime);
        }
    }

    public void setEndRule(int endMonth, int endDay, int endDayOfWeek, int endTime) {
        this.endMonth = endMonth;
        this.endDay = endDay;
        this.endDayOfWeek = endDayOfWeek;
        this.endTime = endTime;
        this.endTimeMode = 0;
        decodeEndRule();
        invalidateCache();
    }

    public void setEndRule(int endMonth, int endDay, int endTime) {
        setEndRule(endMonth, endDay, 0, endTime);
    }

    public void setEndRule(int endMonth, int endDay, int endDayOfWeek, int endTime, boolean after) {
        if (after) {
            setEndRule(endMonth, endDay, -endDayOfWeek, endTime);
        } else {
            setEndRule(endMonth, -endDay, -endDayOfWeek, endTime);
        }
    }

    @Override // java.util.TimeZone
    public int getOffset(long date) {
        return getOffsets(date, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // java.util.TimeZone
    public int getOffsets(long date, int[] offsets) {
        int offset = this.rawOffset;
        if (this.useDaylight) {
            Cache cache = this.cache;
            if (cache != null && date >= cache.start && date < cache.end) {
                offset += this.dstSavings;
            } else {
                BaseCalendar cal = date >= -12219292800000L ? gcal : (BaseCalendar) CalendarSystem.forName("julian");
                BaseCalendar.Date cdate = (BaseCalendar.Date) cal.newCalendarDate(TimeZone.NO_TIMEZONE);
                cal.getCalendarDate(this.rawOffset + date, cdate);
                int year = cdate.getNormalizedYear();
                if (year >= this.startYear) {
                    cdate.setTimeOfDay(0, 0, 0, 0);
                    offset = getOffset(cal, cdate, year, date);
                }
            }
        }
        if (offsets != null) {
            int i10 = this.rawOffset;
            offsets[0] = i10;
            offsets[1] = offset - i10;
        }
        return offset;
    }

    @Override // java.util.TimeZone
    public int getOffset(int era, int year, int month, int day, int dayOfWeek, int millis) {
        int y10;
        BaseCalendar cal;
        BaseCalendar.Date cdate;
        long time;
        if (era != 1 && era != 0) {
            throw new IllegalArgumentException("Illegal era " + era);
        }
        int y11 = year;
        if (era == 0) {
            y11 = 1 - y11;
        }
        if (y11 >= 292278994) {
            y10 = (y11 % SecExceptionCode.SEC_ERROR_SENSOR) + SecExceptionCode.SEC_ERROR_SENSOR;
        } else if (y11 > -292269054) {
            y10 = y11;
        } else {
            y10 = (int) CalendarUtils.mod(y11, 28L);
        }
        int m10 = month + 1;
        BaseCalendar cal2 = gcal;
        BaseCalendar.Date cdate2 = (BaseCalendar.Date) cal2.newCalendarDate(TimeZone.NO_TIMEZONE);
        cdate2.setDate(y10, m10, day);
        long time2 = cal2.getTime(cdate2) + (millis - this.rawOffset);
        if (time2 >= -12219292800000L) {
            cal = cal2;
            cdate = cdate2;
            time = time2;
        } else {
            BaseCalendar cal3 = (BaseCalendar) CalendarSystem.forName("julian");
            BaseCalendar.Date cdate3 = (BaseCalendar.Date) cal3.newCalendarDate(TimeZone.NO_TIMEZONE);
            cdate3.setNormalizedDate(y10, m10, day);
            cal = cal3;
            cdate = cdate3;
            time = (cal3.getTime(cdate3) + millis) - this.rawOffset;
        }
        if (cdate.getNormalizedYear() == y10 && cdate.getMonth() == m10) {
            if (cdate.getDayOfMonth() == day && dayOfWeek >= 1 && dayOfWeek <= 7 && millis >= 0 && millis < 86400000) {
                if (this.useDaylight && year >= this.startYear && era == 1) {
                    return getOffset(cal, cdate, y10, time);
                }
                return this.rawOffset;
            }
        }
        throw new IllegalArgumentException();
    }

    private int getOffset(BaseCalendar cal, BaseCalendar.Date cdate, int year, long time) {
        Cache cache = this.cache;
        if (cache != null) {
            if (time >= cache.start && time < cache.end) {
                return this.rawOffset + this.dstSavings;
            }
            if (year == cache.year) {
                return this.rawOffset;
            }
        }
        long start = getStart(cal, cdate, year);
        long end = getEnd(cal, cdate, year);
        int offset = this.rawOffset;
        if (start <= end) {
            if (time >= start && time < end) {
                offset += this.dstSavings;
            }
            this.cache = new Cache(year, start, end);
        } else {
            if (time < end) {
                long start2 = getStart(cal, cdate, year - 1);
                if (time < start2) {
                    start = start2;
                } else {
                    offset += this.dstSavings;
                    start = start2;
                }
            } else if (time >= start) {
                long end2 = getEnd(cal, cdate, year + 1);
                if (time >= end2) {
                    end = end2;
                } else {
                    offset += this.dstSavings;
                    end = end2;
                }
            }
            if (start <= end) {
                this.cache = new Cache(this.startYear - 1, start, end);
            }
        }
        return offset;
    }

    private long getStart(BaseCalendar cal, BaseCalendar.Date cdate, int year) {
        int time = this.startTime;
        if (this.startTimeMode != 2) {
            time -= this.rawOffset;
        }
        return getTransition(cal, cdate, this.startMode, year, this.startMonth, this.startDay, this.startDayOfWeek, time);
    }

    private long getEnd(BaseCalendar cal, BaseCalendar.Date cdate, int year) {
        int time = this.endTime;
        int i10 = this.endTimeMode;
        if (i10 != 2) {
            time -= this.rawOffset;
        }
        if (i10 == 0) {
            time -= this.dstSavings;
        }
        return getTransition(cal, cdate, this.endMode, year, this.endMonth, this.endDay, this.endDayOfWeek, time);
    }

    private long getTransition(BaseCalendar cal, BaseCalendar.Date cdate, int mode, int year, int month, int dayOfMonth, int dayOfWeek, int timeOfDay) {
        cdate.setNormalizedYear(year);
        cdate.setMonth(month + 1);
        switch (mode) {
            case 1:
                cdate.setDayOfMonth(dayOfMonth);
                break;
            case 2:
                cdate.setDayOfMonth(1);
                if (dayOfMonth < 0) {
                    cdate.setDayOfMonth(cal.getMonthLength(cdate));
                }
                cdate = (BaseCalendar.Date) cal.getNthDayOfWeek(dayOfMonth, dayOfWeek, cdate);
                break;
            case 3:
                cdate.setDayOfMonth(dayOfMonth);
                cdate = (BaseCalendar.Date) cal.getNthDayOfWeek(1, dayOfWeek, cdate);
                break;
            case 4:
                cdate.setDayOfMonth(dayOfMonth);
                cdate = (BaseCalendar.Date) cal.getNthDayOfWeek(-1, dayOfWeek, cdate);
                break;
        }
        return cal.getTime(cdate) + timeOfDay;
    }

    @Override // java.util.TimeZone
    public int getRawOffset() {
        return this.rawOffset;
    }

    @Override // java.util.TimeZone
    public void setRawOffset(int offsetMillis) {
        this.rawOffset = offsetMillis;
    }

    public void setDSTSavings(int millisSavedDuringDST) {
        if (millisSavedDuringDST <= 0) {
            throw new IllegalArgumentException("Illegal daylight saving value: " + millisSavedDuringDST);
        }
        this.dstSavings = millisSavedDuringDST;
    }

    @Override // java.util.TimeZone
    public int getDSTSavings() {
        if (this.useDaylight) {
            return this.dstSavings;
        }
        return 0;
    }

    @Override // java.util.TimeZone
    public boolean useDaylightTime() {
        return this.useDaylight;
    }

    @Override // java.util.TimeZone
    public boolean observesDaylightTime() {
        return useDaylightTime();
    }

    @Override // java.util.TimeZone
    public boolean inDaylightTime(Date date) {
        return getOffset(date.getTime()) != this.rawOffset;
    }

    @Override // java.util.TimeZone
    public Object clone() {
        return super.clone();
    }

    public int hashCode() {
        return (((((((this.startMonth ^ this.startDay) ^ this.startDayOfWeek) ^ this.startTime) ^ this.endMonth) ^ this.endDay) ^ this.endDayOfWeek) ^ this.endTime) ^ this.rawOffset;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleTimeZone) {
            SimpleTimeZone that = (SimpleTimeZone) obj;
            if (getID().equals(that.getID()) && hasSameRules(that)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.TimeZone
    public boolean hasSameRules(TimeZone other) {
        boolean z10;
        if (this == other) {
            return true;
        }
        if (other instanceof SimpleTimeZone) {
            SimpleTimeZone that = (SimpleTimeZone) other;
            if (this.rawOffset == that.rawOffset && (z10 = this.useDaylight) == that.useDaylight) {
                if (!z10) {
                    return true;
                }
                if (this.dstSavings == that.dstSavings && this.startMode == that.startMode && this.startMonth == that.startMonth && this.startDay == that.startDay && this.startDayOfWeek == that.startDayOfWeek && this.startTime == that.startTime && this.startTimeMode == that.startTimeMode && this.endMode == that.endMode && this.endMonth == that.endMonth && this.endDay == that.endDay && this.endDayOfWeek == that.endDayOfWeek && this.endTime == that.endTime && this.endTimeMode == that.endTimeMode && this.startYear == that.startYear) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        return getClass().getName() + "[id=" + getID() + ",offset=" + this.rawOffset + ",dstSavings=" + this.dstSavings + ",useDaylight=" + this.useDaylight + ",startYear=" + this.startYear + ",startMode=" + this.startMode + ",startMonth=" + this.startMonth + ",startDay=" + this.startDay + ",startDayOfWeek=" + this.startDayOfWeek + ",startTime=" + this.startTime + ",startTimeMode=" + this.startTimeMode + ",endMode=" + this.endMode + ",endMonth=" + this.endMonth + ",endDay=" + this.endDay + ",endDayOfWeek=" + this.endDayOfWeek + ",endTime=" + this.endTime + ",endTimeMode=" + this.endTimeMode + ']';
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Cache {
        final long end;
        final long start;
        final long year;

        Cache(long year, long start, long end) {
            this.year = year;
            this.start = start;
            this.end = end;
        }
    }

    private void invalidateCache() {
        this.cache = null;
    }

    private void decodeRules() {
        decodeStartRule();
        decodeEndRule();
    }

    private void decodeStartRule() {
        int i10 = this.startDay;
        this.useDaylight = (i10 == 0 || this.endDay == 0) ? false : true;
        if (i10 != 0) {
            int i11 = this.startMonth;
            if (i11 < 0 || i11 > 11) {
                throw new IllegalArgumentException("Illegal start month " + this.startMonth);
            }
            int i12 = this.startTime;
            if (i12 < 0 || i12 > 86400000) {
                throw new IllegalArgumentException("Illegal start time " + this.startTime);
            }
            int i13 = this.startDayOfWeek;
            if (i13 == 0) {
                this.startMode = 1;
            } else {
                if (i13 > 0) {
                    this.startMode = 2;
                } else {
                    this.startDayOfWeek = -i13;
                    if (i10 > 0) {
                        this.startMode = 3;
                    } else {
                        this.startDay = -i10;
                        this.startMode = 4;
                    }
                }
                if (this.startDayOfWeek > 7) {
                    throw new IllegalArgumentException("Illegal start day of week " + this.startDayOfWeek);
                }
            }
            if (this.startMode == 2) {
                int i14 = this.startDay;
                if (i14 < -5 || i14 > 5) {
                    throw new IllegalArgumentException("Illegal start day of week in month " + this.startDay);
                }
                return;
            }
            int i15 = this.startDay;
            if (i15 < 1 || i15 > staticMonthLength[i11]) {
                throw new IllegalArgumentException("Illegal start day " + this.startDay);
            }
        }
    }

    private void decodeEndRule() {
        this.useDaylight = (this.startDay == 0 || this.endDay == 0) ? false : true;
        int i10 = this.endDay;
        if (i10 != 0) {
            int i11 = this.endMonth;
            if (i11 < 0 || i11 > 11) {
                throw new IllegalArgumentException("Illegal end month " + this.endMonth);
            }
            int i12 = this.endTime;
            if (i12 < 0 || i12 > 86400000) {
                throw new IllegalArgumentException("Illegal end time " + this.endTime);
            }
            int i13 = this.endDayOfWeek;
            if (i13 == 0) {
                this.endMode = 1;
            } else {
                if (i13 > 0) {
                    this.endMode = 2;
                } else {
                    this.endDayOfWeek = -i13;
                    if (i10 > 0) {
                        this.endMode = 3;
                    } else {
                        this.endDay = -i10;
                        this.endMode = 4;
                    }
                }
                if (this.endDayOfWeek > 7) {
                    throw new IllegalArgumentException("Illegal end day of week " + this.endDayOfWeek);
                }
            }
            if (this.endMode == 2) {
                int i14 = this.endDay;
                if (i14 < -5 || i14 > 5) {
                    throw new IllegalArgumentException("Illegal end day of week in month " + this.endDay);
                }
                return;
            }
            int i15 = this.endDay;
            if (i15 < 1 || i15 > staticMonthLength[i11]) {
                throw new IllegalArgumentException("Illegal end day " + this.endDay);
            }
        }
    }

    private void makeRulesCompatible() {
        switch (this.startMode) {
            case 1:
                this.startDay = (this.startDay / 7) + 1;
                this.startDayOfWeek = 1;
                break;
            case 3:
                int i10 = this.startDay;
                if (i10 != 1) {
                    this.startDay = (i10 / 7) + 1;
                    break;
                }
                break;
            case 4:
                int i11 = this.startDay;
                if (i11 >= 30) {
                    this.startDay = -1;
                    break;
                } else {
                    this.startDay = (i11 / 7) + 1;
                    break;
                }
        }
        switch (this.endMode) {
            case 1:
                this.endDay = (this.endDay / 7) + 1;
                this.endDayOfWeek = 1;
                break;
            case 3:
                int i12 = this.endDay;
                if (i12 != 1) {
                    this.endDay = (i12 / 7) + 1;
                    break;
                }
                break;
            case 4:
                int i13 = this.endDay;
                if (i13 >= 30) {
                    this.endDay = -1;
                    break;
                } else {
                    this.endDay = (i13 / 7) + 1;
                    break;
                }
        }
        switch (this.startTimeMode) {
            case 2:
                this.startTime += this.rawOffset;
                break;
        }
        while (true) {
            int i14 = this.startTime;
            if (i14 < 0) {
                this.startTime = i14 + 86400000;
                this.startDayOfWeek = ((this.startDayOfWeek + 5) % 7) + 1;
            } else {
                while (true) {
                    int i15 = this.startTime;
                    if (i15 >= 86400000) {
                        this.startTime = i15 - 86400000;
                        this.startDayOfWeek = (this.startDayOfWeek % 7) + 1;
                    } else {
                        switch (this.endTimeMode) {
                            case 1:
                                this.endTime += this.dstSavings;
                                break;
                            case 2:
                                this.endTime += this.rawOffset + this.dstSavings;
                                break;
                        }
                        while (true) {
                            int i16 = this.endTime;
                            if (i16 < 0) {
                                this.endTime = i16 + 86400000;
                                this.endDayOfWeek = ((this.endDayOfWeek + 5) % 7) + 1;
                            } else {
                                while (true) {
                                    int i17 = this.endTime;
                                    if (i17 >= 86400000) {
                                        this.endTime = i17 - 86400000;
                                        this.endDayOfWeek = (this.endDayOfWeek % 7) + 1;
                                    } else {
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private byte[] packRules() {
        byte[] rules = {(byte) this.startDay, (byte) this.startDayOfWeek, (byte) this.endDay, (byte) this.endDayOfWeek, (byte) this.startTimeMode, (byte) this.endTimeMode};
        return rules;
    }

    private void unpackRules(byte[] rules) {
        this.startDay = rules[0];
        this.startDayOfWeek = rules[1];
        this.endDay = rules[2];
        this.endDayOfWeek = rules[3];
        if (rules.length >= 6) {
            this.startTimeMode = rules[4];
            this.endTimeMode = rules[5];
        }
    }

    private int[] packTimes() {
        int[] times = {this.startTime, this.endTime};
        return times;
    }

    private void unpackTimes(int[] times) {
        this.startTime = times[0];
        this.endTime = times[1];
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        byte[] rules = packRules();
        int[] times = packTimes();
        makeRulesCompatible();
        stream.defaultWriteObject();
        stream.writeInt(rules.length);
        stream.write(rules);
        stream.writeObject(times);
        unpackRules(rules);
        unpackTimes(times);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        if (this.serialVersionOnStream < 1) {
            if (this.startDayOfWeek == 0) {
                this.startDayOfWeek = 1;
            }
            if (this.endDayOfWeek == 0) {
                this.endDayOfWeek = 1;
            }
            this.endMode = 2;
            this.startMode = 2;
            this.dstSavings = 3600000;
        } else {
            int length = stream.readInt();
            if (length <= 6) {
                byte[] rules = new byte[length];
                stream.readFully(rules);
                unpackRules(rules);
            } else {
                throw new InvalidObjectException("Too many rules: " + length);
            }
        }
        if (this.serialVersionOnStream >= 2) {
            int[] times = (int[]) stream.readObject();
            unpackTimes(times);
        }
        this.serialVersionOnStream = 2;
    }
}
