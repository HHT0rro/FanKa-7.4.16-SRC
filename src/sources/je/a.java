package je;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import org.joda.convert.ToString;
import org.joda.time.DateTimeFieldType;

/* compiled from: AbstractDateTime.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class a extends c implements org.joda.time.g {
    @Override // je.c, org.joda.time.i
    public int get(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            return dateTimeFieldType.getField(getChronology()).get(getMillis());
        }
        throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }

    public int getCenturyOfEra() {
        return getChronology().centuryOfEra().get(getMillis());
    }

    public int getDayOfMonth() {
        return getChronology().dayOfMonth().get(getMillis());
    }

    public int getDayOfWeek() {
        return getChronology().dayOfWeek().get(getMillis());
    }

    public int getDayOfYear() {
        return getChronology().dayOfYear().get(getMillis());
    }

    public int getEra() {
        return getChronology().era().get(getMillis());
    }

    public int getHourOfDay() {
        return getChronology().hourOfDay().get(getMillis());
    }

    public int getMillisOfDay() {
        return getChronology().millisOfDay().get(getMillis());
    }

    public int getMillisOfSecond() {
        return getChronology().millisOfSecond().get(getMillis());
    }

    public int getMinuteOfDay() {
        return getChronology().minuteOfDay().get(getMillis());
    }

    public int getMinuteOfHour() {
        return getChronology().minuteOfHour().get(getMillis());
    }

    public int getMonthOfYear() {
        return getChronology().monthOfYear().get(getMillis());
    }

    public int getSecondOfDay() {
        return getChronology().secondOfDay().get(getMillis());
    }

    public int getSecondOfMinute() {
        return getChronology().secondOfMinute().get(getMillis());
    }

    public int getWeekOfWeekyear() {
        return getChronology().weekOfWeekyear().get(getMillis());
    }

    public int getWeekyear() {
        return getChronology().weekyear().get(getMillis());
    }

    public int getYear() {
        return getChronology().year().get(getMillis());
    }

    public int getYearOfCentury() {
        return getChronology().yearOfCentury().get(getMillis());
    }

    public int getYearOfEra() {
        return getChronology().yearOfEra().get(getMillis());
    }

    public Calendar toCalendar(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        Calendar calendar = Calendar.getInstance(getZone().toTimeZone(), locale);
        calendar.setTime(toDate());
        return calendar;
    }

    public GregorianCalendar toGregorianCalendar() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(getZone().toTimeZone());
        gregorianCalendar.setTime(toDate());
        return gregorianCalendar;
    }

    @Override // je.c
    @ToString
    public String toString() {
        return super.toString();
    }

    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.b(str).k(this);
    }

    public String toString(String str, Locale locale) throws IllegalArgumentException {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.b(str).v(locale).k(this);
    }
}
