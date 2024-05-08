package sun.util.calendar;

import java.util.TimeZone;
import libcore.util.ZoneInfo;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractCalendar extends CalendarSystem {
    static final int DAY_IN_MILLIS = 86400000;
    static final int EPOCH_OFFSET = 719163;
    static final int HOUR_IN_MILLIS = 3600000;
    static final int MINUTE_IN_MILLIS = 60000;
    static final int SECOND_IN_MILLIS = 1000;
    private Era[] eras;

    protected abstract void getCalendarDateFromFixedDate(CalendarDate calendarDate, long j10);

    protected abstract long getFixedDate(CalendarDate calendarDate);

    protected abstract boolean isLeapYear(CalendarDate calendarDate);

    @Override // sun.util.calendar.CalendarSystem
    public Era getEra(String eraName) {
        Era[] eraArr = this.eras;
        if (eraArr != null) {
            for (Era era : eraArr) {
                if (era.getName().equals(eraName)) {
                    return era;
                }
            }
            return null;
        }
        return null;
    }

    @Override // sun.util.calendar.CalendarSystem
    public Era[] getEras() {
        Era[] eraArr = this.eras;
        if (eraArr == null) {
            return null;
        }
        Era[] e2 = new Era[eraArr.length];
        System.arraycopy(eraArr, 0, e2, 0, eraArr.length);
        return e2;
    }

    @Override // sun.util.calendar.CalendarSystem
    public void setEra(CalendarDate date, String eraName) {
        if (this.eras == null) {
            return;
        }
        int i10 = 0;
        while (true) {
            Era[] eraArr = this.eras;
            if (i10 < eraArr.length) {
                Era e2 = eraArr[i10];
                if (e2 == null || !e2.getName().equals(eraName)) {
                    i10++;
                } else {
                    date.setEra(e2);
                    return;
                }
            } else {
                throw new IllegalArgumentException("unknown era name: " + eraName);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setEras(Era[] eras) {
        this.eras = eras;
    }

    @Override // sun.util.calendar.CalendarSystem
    public CalendarDate getCalendarDate() {
        return getCalendarDate(System.currentTimeMillis(), newCalendarDate());
    }

    @Override // sun.util.calendar.CalendarSystem
    public CalendarDate getCalendarDate(long millis) {
        return getCalendarDate(millis, newCalendarDate());
    }

    @Override // sun.util.calendar.CalendarSystem
    public CalendarDate getCalendarDate(long millis, TimeZone zone) {
        CalendarDate date = newCalendarDate(zone);
        return getCalendarDate(millis, date);
    }

    @Override // sun.util.calendar.CalendarSystem
    public CalendarDate getCalendarDate(long millis, CalendarDate date) {
        int ms = 0;
        int zoneOffset = 0;
        int saving = 0;
        long days = 0;
        ZoneInfo zone = date.getZone();
        if (zone != null) {
            int[] offsets = new int[2];
            if (zone instanceof ZoneInfo) {
                zoneOffset = zone.getOffsetsByUtcTime(millis, offsets);
            } else {
                zoneOffset = zone.getOffset(millis);
                offsets[0] = zone.getRawOffset();
                offsets[1] = zoneOffset - offsets[0];
            }
            days = zoneOffset / 86400000;
            ms = zoneOffset % 86400000;
            saving = offsets[1];
        }
        date.setZoneOffset(zoneOffset);
        date.setDaylightSaving(saving);
        long days2 = days + (millis / 86400000);
        int ms2 = ms + ((int) (millis % 86400000));
        if (ms2 >= 86400000) {
            ms2 -= 86400000;
            days2++;
        } else {
            while (ms2 < 0) {
                ms2 += 86400000;
                days2--;
            }
        }
        getCalendarDateFromFixedDate(date, days2 + 719163);
        setTimeOfDay(date, ms2);
        date.setLeapYear(isLeapYear(date));
        date.setNormalized(true);
        return date;
    }

    @Override // sun.util.calendar.CalendarSystem
    public long getTime(CalendarDate date) {
        long gd2 = getFixedDate(date);
        long ms = ((gd2 - 719163) * 86400000) + getTimeOfDay(date);
        int zoneOffset = 0;
        TimeZone zi = date.getZone();
        if (zi != null) {
            if (date.isNormalized()) {
                return ms - date.getZoneOffset();
            }
            int[] iArr = new int[2];
            if (date.isStandardTime()) {
                zoneOffset = zi.getOffset(ms - zi.getRawOffset());
            } else {
                zoneOffset = zi.getOffset(ms - zi.getRawOffset());
            }
        }
        long ms2 = ms - zoneOffset;
        getCalendarDate(ms2, date);
        return ms2;
    }

    protected long getTimeOfDay(CalendarDate date) {
        long fraction = date.getTimeOfDay();
        if (fraction != Long.MIN_VALUE) {
            return fraction;
        }
        long fraction2 = getTimeOfDayValue(date);
        date.setTimeOfDay(fraction2);
        return fraction2;
    }

    public long getTimeOfDayValue(CalendarDate date) {
        long fraction = date.getHours();
        return (((((fraction * 60) + date.getMinutes()) * 60) + date.getSeconds()) * 1000) + date.getMillis();
    }

    @Override // sun.util.calendar.CalendarSystem
    public CalendarDate setTimeOfDay(CalendarDate cdate, int fraction) {
        if (fraction < 0) {
            throw new IllegalArgumentException();
        }
        boolean normalizedState = cdate.isNormalized();
        int hours = fraction / 3600000;
        int time = fraction % 3600000;
        int minutes = time / 60000;
        int time2 = time % 60000;
        int seconds = time2 / 1000;
        cdate.setHours(hours);
        cdate.setMinutes(minutes);
        cdate.setSeconds(seconds);
        cdate.setMillis(time2 % 1000);
        cdate.setTimeOfDay(fraction);
        if (hours < 24 && normalizedState) {
            cdate.setNormalized(normalizedState);
        }
        return cdate;
    }

    @Override // sun.util.calendar.CalendarSystem
    public int getWeekLength() {
        return 7;
    }

    @Override // sun.util.calendar.CalendarSystem
    public CalendarDate getNthDayOfWeek(int nth, int dayOfWeek, CalendarDate date) {
        long nfd;
        CalendarDate ndate = (CalendarDate) date.clone();
        normalize(ndate);
        long fd2 = getFixedDate(ndate);
        if (nth > 0) {
            nfd = (nth * 7) + getDayOfWeekDateBefore(fd2, dayOfWeek);
        } else {
            nfd = (nth * 7) + getDayOfWeekDateAfter(fd2, dayOfWeek);
        }
        getCalendarDateFromFixedDate(ndate, nfd);
        return ndate;
    }

    static long getDayOfWeekDateBefore(long fixedDate, int dayOfWeek) {
        return getDayOfWeekDateOnOrBefore(fixedDate - 1, dayOfWeek);
    }

    static long getDayOfWeekDateAfter(long fixedDate, int dayOfWeek) {
        return getDayOfWeekDateOnOrBefore(7 + fixedDate, dayOfWeek);
    }

    public static long getDayOfWeekDateOnOrBefore(long fixedDate, int dayOfWeek) {
        long fd2 = fixedDate - (dayOfWeek - 1);
        if (fd2 >= 0) {
            return fixedDate - (fd2 % 7);
        }
        return fixedDate - CalendarUtils.mod(fd2, 7L);
    }

    public boolean validateTime(CalendarDate date) {
        int t2;
        int t10;
        int t11;
        int t12 = date.getHours();
        if (t12 < 0 || t12 >= 24 || (t2 = date.getMinutes()) < 0 || t2 >= 60 || (t10 = date.getSeconds()) < 0 || t10 >= 60 || (t11 = date.getMillis()) < 0 || t11 >= 1000) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int normalizeTime(CalendarDate date) {
        long fraction = getTimeOfDay(date);
        long days = 0;
        if (fraction >= 86400000) {
            days = fraction / 86400000;
            fraction %= 86400000;
        } else if (fraction < 0) {
            days = CalendarUtils.floorDivide(fraction, 86400000L);
            if (days != 0) {
                fraction -= 86400000 * days;
            }
        }
        if (days != 0) {
            date.setTimeOfDay(fraction);
        }
        date.setMillis((int) (fraction % 1000));
        long fraction2 = fraction / 1000;
        date.setSeconds((int) (fraction2 % 60));
        long fraction3 = fraction2 / 60;
        date.setMinutes((int) (fraction3 % 60));
        date.setHours((int) (fraction3 / 60));
        return (int) days;
    }
}
