package org.apache.commons.lang3.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.Validate;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class DateUtils {
    public static final long MILLIS_PER_DAY = 86400000;
    public static final long MILLIS_PER_HOUR = 3600000;
    public static final long MILLIS_PER_MINUTE = 60000;
    public static final long MILLIS_PER_SECOND = 1000;
    public static final int RANGE_MONTH_MONDAY = 6;
    public static final int RANGE_MONTH_SUNDAY = 5;
    public static final int RANGE_WEEK_CENTER = 4;
    public static final int RANGE_WEEK_MONDAY = 2;
    public static final int RANGE_WEEK_RELATIVE = 3;
    public static final int RANGE_WEEK_SUNDAY = 1;
    public static final int SEMI_MONTH = 1001;
    private static final int[][] fields = {new int[]{14}, new int[]{13}, new int[]{12}, new int[]{11, 10}, new int[]{5, 5, 9}, new int[]{2, 1001}, new int[]{1}, new int[]{0}};

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class DateIterator implements Iterator<Calendar> {
        private final Calendar endFinal;
        private final Calendar spot;

        public DateIterator(Calendar calendar, Calendar calendar2) {
            this.endFinal = calendar2;
            this.spot = calendar;
            calendar.add(5, -1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.spot.before(this.endFinal);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public Calendar next() {
            if (!this.spot.equals(this.endFinal)) {
                this.spot.add(5, 1);
                return (Calendar) this.spot.clone();
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum ModifyType {
        TRUNCATE,
        ROUND,
        CEILING
    }

    private static Date add(Date date, int i10, int i11) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(i10, i11);
        return calendar.getTime();
    }

    public static Date addDays(Date date, int i10) {
        return add(date, 5, i10);
    }

    public static Date addHours(Date date, int i10) {
        return add(date, 11, i10);
    }

    public static Date addMilliseconds(Date date, int i10) {
        return add(date, 14, i10);
    }

    public static Date addMinutes(Date date, int i10) {
        return add(date, 12, i10);
    }

    public static Date addMonths(Date date, int i10) {
        return add(date, 2, i10);
    }

    public static Date addSeconds(Date date, int i10) {
        return add(date, 13, i10);
    }

    public static Date addWeeks(Date date, int i10) {
        return add(date, 3, i10);
    }

    public static Date addYears(Date date, int i10) {
        return add(date, 1, i10);
    }

    public static Date ceiling(Date date, int i10) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        modify(calendar, i10, ModifyType.CEILING);
        return calendar.getTime();
    }

    private static long getFragment(Date date, int i10, TimeUnit timeUnit) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getFragment(calendar, i10, timeUnit);
    }

    public static long getFragmentInDays(Date date, int i10) {
        return getFragment(date, i10, TimeUnit.DAYS);
    }

    public static long getFragmentInHours(Date date, int i10) {
        return getFragment(date, i10, TimeUnit.HOURS);
    }

    public static long getFragmentInMilliseconds(Date date, int i10) {
        return getFragment(date, i10, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInMinutes(Date date, int i10) {
        return getFragment(date, i10, TimeUnit.MINUTES);
    }

    public static long getFragmentInSeconds(Date date, int i10) {
        return getFragment(date, i10, TimeUnit.SECONDS);
    }

    public static boolean isSameDay(Date date, Date date2) {
        if (date != null && date2 != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date2);
            return isSameDay(calendar, calendar2);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameInstant(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return date.getTime() == date2.getTime();
    }

    public static boolean isSameLocalTime(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return calendar.get(14) == calendar2.get(14) && calendar.get(13) == calendar2.get(13) && calendar.get(12) == calendar2.get(12) && calendar.get(11) == calendar2.get(11) && calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1) && calendar.get(0) == calendar2.get(0) && calendar.getClass() == calendar2.getClass();
    }

    public static Iterator<Calendar> iterator(Date date, int i10) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return iterator(calendar, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void modify(java.util.Calendar r16, int r17, org.apache.commons.lang3.time.DateUtils.ModifyType r18) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DateUtils.modify(java.util.Calendar, int, org.apache.commons.lang3.time.DateUtils$ModifyType):void");
    }

    public static Date parseDate(String str, String... strArr) throws ParseException {
        return parseDate(str, null, strArr);
    }

    public static Date parseDateStrictly(String str, String... strArr) throws ParseException {
        return parseDateStrictly(str, null, strArr);
    }

    private static Date parseDateWithLeniency(String str, Locale locale, String[] strArr, boolean z10) throws ParseException {
        if (str != null && strArr != null) {
            TimeZone timeZone = TimeZone.getDefault();
            if (locale == null) {
                locale = Locale.getDefault();
            }
            ParsePosition parsePosition = new ParsePosition(0);
            Calendar calendar = Calendar.getInstance(timeZone, locale);
            calendar.setLenient(z10);
            for (String str2 : strArr) {
                FastDateParser fastDateParser = new FastDateParser(str2, timeZone, locale);
                calendar.clear();
                try {
                    if (fastDateParser.parse(str, parsePosition, calendar) && parsePosition.getIndex() == str.length()) {
                        return calendar.getTime();
                    }
                } catch (IllegalArgumentException unused) {
                }
                parsePosition.setIndex(0);
            }
            throw new ParseException("Unable to parse the date: " + str, -1);
        }
        throw new IllegalArgumentException("Date and Patterns must not be null");
    }

    public static Date round(Date date, int i10) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        modify(calendar, i10, ModifyType.ROUND);
        return calendar.getTime();
    }

    private static Date set(Date date, int i10, int i11) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.setTime(date);
        calendar.set(i10, i11);
        return calendar.getTime();
    }

    public static Date setDays(Date date, int i10) {
        return set(date, 5, i10);
    }

    public static Date setHours(Date date, int i10) {
        return set(date, 11, i10);
    }

    public static Date setMilliseconds(Date date, int i10) {
        return set(date, 14, i10);
    }

    public static Date setMinutes(Date date, int i10) {
        return set(date, 12, i10);
    }

    public static Date setMonths(Date date, int i10) {
        return set(date, 2, i10);
    }

    public static Date setSeconds(Date date, int i10) {
        return set(date, 13, i10);
    }

    public static Date setYears(Date date, int i10) {
        return set(date, 1, i10);
    }

    public static Calendar toCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date truncate(Date date, int i10) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        modify(calendar, i10, ModifyType.TRUNCATE);
        return calendar.getTime();
    }

    public static int truncatedCompareTo(Calendar calendar, Calendar calendar2, int i10) {
        return truncate(calendar, i10).compareTo(truncate(calendar2, i10));
    }

    public static boolean truncatedEquals(Calendar calendar, Calendar calendar2, int i10) {
        return truncatedCompareTo(calendar, calendar2, i10) == 0;
    }

    private static void validateDateNotNull(Date date) {
        Validate.isTrue(date != null, "The date must not be null", new Object[0]);
    }

    public static long getFragmentInDays(Calendar calendar, int i10) {
        return getFragment(calendar, i10, TimeUnit.DAYS);
    }

    public static long getFragmentInHours(Calendar calendar, int i10) {
        return getFragment(calendar, i10, TimeUnit.HOURS);
    }

    public static long getFragmentInMilliseconds(Calendar calendar, int i10) {
        return getFragment(calendar, i10, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInMinutes(Calendar calendar, int i10) {
        return getFragment(calendar, i10, TimeUnit.MINUTES);
    }

    public static long getFragmentInSeconds(Calendar calendar, int i10) {
        return getFragment(calendar, i10, TimeUnit.SECONDS);
    }

    public static Date parseDate(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, locale, strArr, true);
    }

    public static Date parseDateStrictly(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, locale, strArr, false);
    }

    public static boolean truncatedEquals(Date date, Date date2, int i10) {
        return truncatedCompareTo(date, date2, i10) == 0;
    }

    public static boolean isSameInstant(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return calendar.getTime().getTime() == calendar2.getTime().getTime();
    }

    public static Calendar toCalendar(Date date, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(date);
        return calendar;
    }

    public static int truncatedCompareTo(Date date, Date date2, int i10) {
        return truncate(date, i10).compareTo(truncate(date2, i10));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0032. Please report as an issue. */
    private static long getFragment(Calendar calendar, int i10, TimeUnit timeUnit) {
        long convert;
        if (calendar != null) {
            long j10 = 0;
            TimeUnit timeUnit2 = TimeUnit.DAYS;
            int i11 = timeUnit == timeUnit2 ? 0 : 1;
            if (i10 == 1) {
                convert = timeUnit.convert(calendar.get(6) - i11, timeUnit2);
            } else {
                if (i10 == 2) {
                    convert = timeUnit.convert(calendar.get(5) - i11, timeUnit2);
                }
                if (i10 != 1 || i10 == 2 || i10 == 5 || i10 == 6) {
                    j10 += timeUnit.convert(calendar.get(11), TimeUnit.HOURS);
                } else {
                    switch (i10) {
                        case 11:
                            break;
                        case 12:
                            j10 += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
                        case 13:
                            return j10 + timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS);
                        case 14:
                            return j10;
                        default:
                            throw new IllegalArgumentException("The fragment " + i10 + " is not supported");
                    }
                }
                j10 += timeUnit.convert(calendar.get(12), TimeUnit.MINUTES);
                j10 += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
                return j10 + timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS);
            }
            j10 = 0 + convert;
            if (i10 != 1) {
            }
            j10 += timeUnit.convert(calendar.get(11), TimeUnit.HOURS);
            j10 += timeUnit.convert(calendar.get(12), TimeUnit.MINUTES);
            j10 += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
            return j10 + timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0007. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007e A[LOOP:0: B:20:0x0078->B:22:0x007e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088 A[LOOP:1: B:24:0x0082->B:26:0x0088, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Iterator<java.util.Calendar> iterator(java.util.Calendar r8, int r9) {
        /*
            if (r8 == 0) goto L92
            r0 = -1
            r1 = 2
            r2 = 5
            r3 = 1
            r4 = 7
            switch(r9) {
                case 1: goto L41;
                case 2: goto L41;
                case 3: goto L41;
                case 4: goto L41;
                case 5: goto L26;
                case 6: goto L26;
                default: goto La;
            }
        La:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "The range style "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = " is not valid."
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r8.<init>(r9)
            throw r8
        L26:
            java.util.Calendar r8 = truncate(r8, r1)
            java.lang.Object r5 = r8.clone()
            java.util.Calendar r5 = (java.util.Calendar) r5
            r5.add(r1, r3)
            r5.add(r2, r0)
            r6 = 6
            if (r9 != r6) goto L3c
            r6 = r5
            r5 = r8
            goto L67
        L3c:
            r6 = r5
            r1 = 1
            r5 = r8
            r8 = 7
            goto L68
        L41:
            java.util.Calendar r5 = truncate(r8, r2)
            java.util.Calendar r6 = truncate(r8, r2)
            if (r9 == r1) goto L67
            r1 = 3
            if (r9 == r1) goto L60
            r7 = 4
            if (r9 == r7) goto L54
            r8 = 7
            r1 = 1
            goto L68
        L54:
            int r9 = r8.get(r4)
            int r9 = r9 - r1
            int r8 = r8.get(r4)
            int r8 = r8 + r1
            r1 = r9
            goto L68
        L60:
            int r1 = r8.get(r4)
            int r8 = r1 + (-1)
            goto L68
        L67:
            r8 = 1
        L68:
            if (r1 >= r3) goto L6c
            int r1 = r1 + 7
        L6c:
            if (r1 <= r4) goto L70
            int r1 = r1 + (-7)
        L70:
            if (r8 >= r3) goto L74
            int r8 = r8 + 7
        L74:
            if (r8 <= r4) goto L78
            int r8 = r8 + (-7)
        L78:
            int r9 = r5.get(r4)
            if (r9 == r1) goto L82
            r5.add(r2, r0)
            goto L78
        L82:
            int r9 = r6.get(r4)
            if (r9 == r8) goto L8c
            r6.add(r2, r3)
            goto L82
        L8c:
            org.apache.commons.lang3.time.DateUtils$DateIterator r8 = new org.apache.commons.lang3.time.DateUtils$DateIterator
            r8.<init>(r5, r6)
            return r8
        L92:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "The date must not be null"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DateUtils.iterator(java.util.Calendar, int):java.util.Iterator");
    }

    public static Calendar ceiling(Calendar calendar, int i10) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i10, ModifyType.CEILING);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar round(Calendar calendar, int i10) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i10, ModifyType.ROUND);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar truncate(Calendar calendar, int i10) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i10, ModifyType.TRUNCATE);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public static Date ceiling(Object obj, int i10) {
        if (obj != null) {
            if (obj instanceof Date) {
                return ceiling((Date) obj, i10);
            }
            if (obj instanceof Calendar) {
                return ceiling((Calendar) obj, i10).getTime();
            }
            throw new ClassCastException("Could not find ceiling of for type: " + ((Object) obj.getClass()));
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date round(Object obj, int i10) {
        if (obj != null) {
            if (obj instanceof Date) {
                return round((Date) obj, i10);
            }
            if (obj instanceof Calendar) {
                return round((Calendar) obj, i10).getTime();
            }
            throw new ClassCastException("Could not round " + obj);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date truncate(Object obj, int i10) {
        if (obj != null) {
            if (obj instanceof Date) {
                return truncate((Date) obj, i10);
            }
            if (obj instanceof Calendar) {
                return truncate((Calendar) obj, i10).getTime();
            }
            throw new ClassCastException("Could not truncate " + obj);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Iterator<?> iterator(Object obj, int i10) {
        if (obj != null) {
            if (obj instanceof Date) {
                return iterator((Date) obj, i10);
            }
            if (obj instanceof Calendar) {
                return iterator((Calendar) obj, i10);
            }
            throw new ClassCastException("Could not iterate based on " + obj);
        }
        throw new IllegalArgumentException("The date must not be null");
    }
}
