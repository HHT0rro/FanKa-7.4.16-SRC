package sun.util.calendar;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class CalendarSystem {
    private static final ConcurrentMap<String, CalendarSystem> calendars = new ConcurrentHashMap();
    private static final Map<String, Class<?>> names;

    public abstract CalendarDate getCalendarDate();

    public abstract CalendarDate getCalendarDate(long j10);

    public abstract CalendarDate getCalendarDate(long j10, TimeZone timeZone);

    public abstract CalendarDate getCalendarDate(long j10, CalendarDate calendarDate);

    public abstract Era getEra(String str);

    public abstract Era[] getEras();

    public abstract int getMonthLength(CalendarDate calendarDate);

    public abstract String getName();

    public abstract CalendarDate getNthDayOfWeek(int i10, int i11, CalendarDate calendarDate);

    public abstract long getTime(CalendarDate calendarDate);

    public abstract int getWeekLength();

    public abstract int getYearLength(CalendarDate calendarDate);

    public abstract int getYearLengthInMonths(CalendarDate calendarDate);

    public abstract CalendarDate newCalendarDate();

    public abstract CalendarDate newCalendarDate(TimeZone timeZone);

    public abstract boolean normalize(CalendarDate calendarDate);

    public abstract void setEra(CalendarDate calendarDate, String str);

    public abstract CalendarDate setTimeOfDay(CalendarDate calendarDate, int i10);

    public abstract boolean validate(CalendarDate calendarDate);

    static {
        HashMap hashMap = new HashMap();
        names = hashMap;
        hashMap.put("gregorian", Gregorian.class);
        hashMap.put("japanese", LocalGregorianCalendar.class);
        hashMap.put("julian", JulianCalendar.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class GregorianHolder {
        private static final Gregorian GREGORIAN_INSTANCE = new Gregorian();

        private GregorianHolder() {
        }
    }

    public static Gregorian getGregorianCalendar() {
        return GregorianHolder.GREGORIAN_INSTANCE;
    }

    public static CalendarSystem forName(String calendarName) {
        CalendarSystem cal;
        if ("gregorian".equals(calendarName)) {
            return GregorianHolder.GREGORIAN_INSTANCE;
        }
        ConcurrentMap<String, CalendarSystem> concurrentMap = calendars;
        CalendarSystem cal2 = concurrentMap.get(calendarName);
        if (cal2 != null) {
            return cal2;
        }
        Class<?> calendarClass = names.get(calendarName);
        if (calendarClass == null) {
            return null;
        }
        if (calendarClass.isAssignableFrom(LocalGregorianCalendar.class)) {
            cal = LocalGregorianCalendar.getLocalGregorianCalendar(calendarName);
        } else {
            try {
                cal = (CalendarSystem) calendarClass.newInstance();
            } catch (Exception e2) {
                throw new InternalError(e2);
            }
        }
        if (cal == null) {
            return null;
        }
        CalendarSystem cs = concurrentMap.putIfAbsent(calendarName, cal);
        return cs == null ? cal : cs;
    }

    public static Properties getCalendarProperties() throws IOException {
        Properties calendarProps = new Properties();
        InputStream is = ClassLoader.getSystemResourceAsStream("calendars.properties");
        try {
            calendarProps.load(is);
            if (is != null) {
                is.close();
            }
            return calendarProps;
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
