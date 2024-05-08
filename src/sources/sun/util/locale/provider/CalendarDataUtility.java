package sun.util.locale.provider;

import android.icu.text.DateFormatSymbols;
import android.icu.util.ULocale;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class CalendarDataUtility {
    private static final String BUDDHIST_CALENDAR = "buddhist";
    private static final String GREGORIAN_CALENDAR = "gregorian";
    private static final String ISLAMIC_CALENDAR = "islamic";
    private static final String JAPANESE_CALENDAR = "japanese";
    private static int[] REST_OF_STYLES = {Calendar.SHORT_STANDALONE, 2, Calendar.LONG_STANDALONE, 4, Calendar.NARROW_STANDALONE};

    private CalendarDataUtility() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int retrieveFirstDayOfWeek(Locale locale, int defaultFirstDayOfWeek) {
        String fw;
        char c4;
        if (locale.hasExtensions() && (fw = locale.getUnicodeLocaleType("fw")) != null) {
            String lowerCase = fw.toLowerCase(Locale.ROOT);
            switch (lowerCase.hashCode()) {
                case 101661:
                    if (lowerCase.equals("fri")) {
                        c4 = 4;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 108300:
                    if (lowerCase.equals("mon")) {
                        c4 = 0;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 113638:
                    if (lowerCase.equals("sat")) {
                        c4 = 5;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 114252:
                    if (lowerCase.equals("sun")) {
                        c4 = 6;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 114817:
                    if (lowerCase.equals("thu")) {
                        c4 = 3;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 115204:
                    if (lowerCase.equals("tue")) {
                        c4 = 1;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 117590:
                    if (lowerCase.equals("wed")) {
                        c4 = 2;
                        break;
                    }
                    c4 = 65535;
                    break;
                default:
                    c4 = 65535;
                    break;
            }
            switch (c4) {
                case 0:
                    return 2;
                case 1:
                    return 3;
                case 2:
                    return 4;
                case 3:
                    return 5;
                case 4:
                    return 6;
                case 5:
                    return 7;
                case 6:
                    return 1;
            }
        }
        return defaultFirstDayOfWeek;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String retrieveFieldValueName(String id2, int field, int value, int style, Locale locale) {
        char c4;
        if (field == 0) {
            String normalizeCalendarType = normalizeCalendarType(id2);
            switch (normalizeCalendarType.hashCode()) {
                case -1581060683:
                    if (normalizeCalendarType.equals(BUDDHIST_CALENDAR)) {
                        c4 = 0;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -752730191:
                    if (normalizeCalendarType.equals(JAPANESE_CALENDAR)) {
                        c4 = 2;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 2093696456:
                    if (normalizeCalendarType.equals(ISLAMIC_CALENDAR)) {
                        c4 = 1;
                        break;
                    }
                    c4 = 65535;
                    break;
                default:
                    c4 = 65535;
                    break;
            }
            switch (c4) {
                case 0:
                case 1:
                    value--;
                    break;
                case 2:
                    value += 231;
                    break;
            }
        }
        if (value < 0) {
            return null;
        }
        String[] names = getNames(id2, field, style, locale);
        if (value >= names.length) {
            return null;
        }
        return names[value];
    }

    public static String retrieveJavaTimeFieldValueName(String id2, int field, int value, int style, Locale locale) {
        return retrieveFieldValueName(id2, field, value, style, locale);
    }

    public static Map<String, Integer> retrieveFieldValueNames(String id2, int field, int style, Locale locale) {
        Map<String, Integer> names;
        if (style == 0) {
            names = retrieveFieldValueNamesImpl(id2, field, 1, locale);
            for (int st : REST_OF_STYLES) {
                names.putAll(retrieveFieldValueNamesImpl(id2, field, st, locale));
            }
        } else {
            names = retrieveFieldValueNamesImpl(id2, field, style, locale);
        }
        if (names.isEmpty()) {
            return null;
        }
        return names;
    }

    public static Map<String, Integer> retrieveJavaTimeFieldValueNames(String id2, int field, int style, Locale locale) {
        return retrieveFieldValueNames(id2, field, style, locale);
    }

    private static String normalizeCalendarType(String requestID) {
        if (requestID.equals("gregory") || requestID.equals("iso8601")) {
            return GREGORIAN_CALENDAR;
        }
        if (requestID.startsWith(ISLAMIC_CALENDAR)) {
            return ISLAMIC_CALENDAR;
        }
        return requestID;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static Map<String, Integer> retrieveFieldValueNamesImpl(String id2, int field, int style, Locale locale) {
        char c4;
        String[] names = getNames(id2, field, style, locale);
        int skipped = 0;
        int offset = 0;
        if (field == 0) {
            String normalizeCalendarType = normalizeCalendarType(id2);
            switch (normalizeCalendarType.hashCode()) {
                case -1581060683:
                    if (normalizeCalendarType.equals(BUDDHIST_CALENDAR)) {
                        c4 = 0;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -752730191:
                    if (normalizeCalendarType.equals(JAPANESE_CALENDAR)) {
                        c4 = 2;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 2093696456:
                    if (normalizeCalendarType.equals(ISLAMIC_CALENDAR)) {
                        c4 = 1;
                        break;
                    }
                    c4 = 65535;
                    break;
                default:
                    c4 = 65535;
                    break;
            }
            switch (c4) {
                case 0:
                case 1:
                    offset = 1;
                    break;
                case 2:
                    skipped = 232;
                    offset = -231;
                    break;
            }
        }
        Map<String, Integer> result = new LinkedHashMap<>();
        for (int i10 = skipped; i10 < names.length; i10++) {
            if (!names[i10].isEmpty() && result.put(names[i10], Integer.valueOf(i10 + offset)) != null) {
                return new LinkedHashMap();
            }
        }
        return result;
    }

    private static String[] getNames(String id2, int field, int style, Locale locale) {
        int context = toContext(style);
        int width = toWidth(style);
        DateFormatSymbols symbols = getDateFormatSymbols(id2, locale);
        switch (field) {
            case 0:
                switch (width) {
                    case 0:
                        return symbols.getEras();
                    case 1:
                        return symbols.getEraNames();
                    case 2:
                        return symbols.getNarrowEras();
                    default:
                        throw new UnsupportedOperationException("Unknown width: " + width);
                }
            case 2:
                return symbols.getMonths(context, width);
            case 7:
                return symbols.getWeekdays(context, width);
            case 9:
                return symbols.getAmPmStrings();
            default:
                throw new UnsupportedOperationException("Unknown field: " + field);
        }
    }

    private static DateFormatSymbols getDateFormatSymbols(String id2, Locale locale) {
        String calendarType = normalizeCalendarType(id2);
        ULocale uLocale = ULocale.forLocale(locale).setKeywordValue("calendar", calendarType);
        return new DateFormatSymbols(uLocale);
    }

    private static int toWidth(int style) {
        switch (style) {
            case 1:
            case Calendar.SHORT_STANDALONE /* 32769 */:
                return 0;
            case 2:
            case Calendar.LONG_STANDALONE /* 32770 */:
                return 1;
            case 4:
            case Calendar.NARROW_STANDALONE /* 32772 */:
                return 2;
            default:
                throw new IllegalArgumentException("Invalid style: " + style);
        }
    }

    private static int toContext(int style) {
        switch (style) {
            case 1:
            case 2:
            case 4:
                return 0;
            case Calendar.SHORT_STANDALONE /* 32769 */:
            case Calendar.LONG_STANDALONE /* 32770 */:
            case Calendar.NARROW_STANDALONE /* 32772 */:
                return 1;
            default:
                throw new IllegalArgumentException("Invalid style: " + style);
        }
    }
}
