package java.time.format;

import android.icu.text.DateFormatSymbols;
import android.icu.util.ULocale;
import com.android.icu.text.ExtendedDateFormatSymbols;
import java.time.chrono.Chronology;
import java.time.chrono.IsoChronology;
import java.time.chrono.JapaneseChronology;
import java.time.temporal.ChronoField;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalField;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import sun.util.locale.provider.CalendarDataUtility;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DateTimeTextProvider {
    private static final ConcurrentMap<Map.Entry<TemporalField, Locale>, Object> CACHE = new ConcurrentHashMap(16, 0.75f, 2);
    private static final Comparator<Map.Entry<String, Long>> COMPARATOR = new Comparator<Map.Entry<String, Long>>() { // from class: java.time.format.DateTimeTextProvider.1
        @Override // java.util.Comparator
        public int compare(Map.Entry<String, Long> obj1, Map.Entry<String, Long> obj2) {
            return obj2.getKey().length() - obj1.getKey().length();
        }
    };
    private static final DateTimeTextProvider INSTANCE = new DateTimeTextProvider();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DateTimeTextProvider getInstance() {
        return INSTANCE;
    }

    public String getText(TemporalField field, long value, TextStyle style, Locale locale) {
        Object store = findStore(field, locale);
        if (store instanceof LocaleStore) {
            return ((LocaleStore) store).getText(value, style);
        }
        return null;
    }

    public String getText(Chronology chrono, TemporalField field, long value, TextStyle style, Locale locale) {
        int fieldIndex;
        int fieldValue;
        if (chrono == IsoChronology.INSTANCE || !(field instanceof ChronoField)) {
            return getText(field, value, style, locale);
        }
        if (field == ChronoField.ERA) {
            fieldIndex = 0;
            if (chrono != JapaneseChronology.INSTANCE) {
                fieldValue = (int) value;
            } else if (value == -999) {
                fieldValue = 0;
            } else {
                int fieldValue2 = (int) value;
                fieldValue = fieldValue2 + 2;
            }
        } else if (field == ChronoField.MONTH_OF_YEAR) {
            fieldIndex = 2;
            fieldValue = ((int) value) - 1;
        } else if (field == ChronoField.DAY_OF_WEEK) {
            fieldIndex = 7;
            fieldValue = ((int) value) + 1;
            if (fieldValue > 7) {
                fieldValue = 1;
            }
        } else if (field == ChronoField.AMPM_OF_DAY) {
            fieldIndex = 9;
            fieldValue = (int) value;
        } else {
            return null;
        }
        return CalendarDataUtility.retrieveJavaTimeFieldValueName(chrono.getCalendarType(), fieldIndex, fieldValue, style.toCalendarStyle(), locale);
    }

    public Iterator<Map.Entry<String, Long>> getTextIterator(TemporalField field, TextStyle style, Locale locale) {
        Object store = findStore(field, locale);
        if (store instanceof LocaleStore) {
            return ((LocaleStore) store).getTextIterator(style);
        }
        return null;
    }

    public Iterator<Map.Entry<String, Long>> getTextIterator(Chronology chrono, TemporalField field, TextStyle style, Locale locale) {
        int fieldIndex;
        if (chrono == IsoChronology.INSTANCE || !(field instanceof ChronoField)) {
            return getTextIterator(field, style, locale);
        }
        switch (AnonymousClass2.$SwitchMap$java$time$temporal$ChronoField[((ChronoField) field).ordinal()]) {
            case 1:
                fieldIndex = 0;
                break;
            case 2:
                fieldIndex = 2;
                break;
            case 3:
                fieldIndex = 7;
                break;
            case 4:
                fieldIndex = 9;
                break;
            default:
                return null;
        }
        int calendarStyle = style == null ? 0 : style.toCalendarStyle();
        Map<String, Integer> map = CalendarDataUtility.retrieveJavaTimeFieldValueNames(chrono.getCalendarType(), fieldIndex, calendarStyle, locale);
        if (map == null) {
            return null;
        }
        List<Map.Entry<String, Long>> list = new ArrayList<>(map.size());
        switch (fieldIndex) {
            case 0:
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    int era = entry.getValue().intValue();
                    if (chrono == JapaneseChronology.INSTANCE) {
                        era = era == 0 ? -999 : era - 2;
                    }
                    list.add(createEntry(entry.getKey(), Long.valueOf(era)));
                }
                break;
            case 2:
                for (Map.Entry<String, Integer> entry2 : map.entrySet()) {
                    list.add(createEntry(entry2.getKey(), Long.valueOf(entry2.getValue().intValue() + 1)));
                }
                break;
            case 7:
                for (Map.Entry<String, Integer> entry3 : map.entrySet()) {
                    list.add(createEntry(entry3.getKey(), Long.valueOf(toWeekDay(entry3.getValue().intValue()))));
                }
                break;
            default:
                for (Map.Entry<String, Integer> entry4 : map.entrySet()) {
                    list.add(createEntry(entry4.getKey(), Long.valueOf(entry4.getValue().intValue())));
                }
                break;
        }
        return list.iterator2();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.time.format.DateTimeTextProvider$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoField;

        static {
            int[] iArr = new int[ChronoField.values().length];
            $SwitchMap$java$time$temporal$ChronoField = iArr;
            try {
                iArr[ChronoField.ERA.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.MONTH_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.DAY_OF_WEEK.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.AMPM_OF_DAY.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    private Object findStore(TemporalField field, Locale locale) {
        Map.Entry<TemporalField, Locale> key = createEntry(field, locale);
        ConcurrentMap<Map.Entry<TemporalField, Locale>, Object> concurrentMap = CACHE;
        Object store = concurrentMap.get(key);
        if (store == null) {
            concurrentMap.putIfAbsent(key, createStore(field, locale));
            return concurrentMap.get(key);
        }
        return store;
    }

    private static int toWeekDay(int calWeekDay) {
        if (calWeekDay == 1) {
            return 7;
        }
        return calWeekDay - 1;
    }

    private Object createStore(TemporalField field, Locale locale) {
        Map<String, Integer> displayNames;
        String name;
        Map<String, Integer> displayNames2;
        Map<TextStyle, Map<Long, String>> styleMap = new HashMap<>();
        int i10 = 0;
        if (field != ChronoField.ERA) {
            int i11 = 1;
            if (field != ChronoField.MONTH_OF_YEAR) {
                if (field != ChronoField.DAY_OF_WEEK) {
                    if (field != ChronoField.AMPM_OF_DAY) {
                        if (field == IsoFields.QUARTER_OF_YEAR) {
                            ULocale uLocale = ULocale.forLocale(locale);
                            uLocale.setKeywordValue("calendar", "gregorian");
                            ExtendedDateFormatSymbols extendedDfs = ExtendedDateFormatSymbols.getInstance(uLocale);
                            DateFormatSymbols dfs = extendedDfs.getDateFormatSymbols();
                            styleMap.put(TextStyle.FULL, extractQuarters(dfs.getQuarters(0, 1)));
                            styleMap.put(TextStyle.FULL_STANDALONE, extractQuarters(dfs.getQuarters(1, 1)));
                            styleMap.put(TextStyle.SHORT, extractQuarters(dfs.getQuarters(0, 0)));
                            styleMap.put(TextStyle.SHORT_STANDALONE, extractQuarters(dfs.getQuarters(1, 0)));
                            styleMap.put(TextStyle.NARROW, extractQuarters(extendedDfs.getNarrowQuarters(0)));
                            styleMap.put(TextStyle.NARROW_STANDALONE, extractQuarters(extendedDfs.getNarrowQuarters(1)));
                            return new LocaleStore(styleMap);
                        }
                        return "";
                    }
                    TextStyle[] values = TextStyle.values();
                    int length = values.length;
                    while (i10 < length) {
                        TextStyle textStyle = values[i10];
                        if (!textStyle.isStandalone() && (displayNames = CalendarDataUtility.retrieveJavaTimeFieldValueNames("gregory", 9, textStyle.toCalendarStyle(), locale)) != null) {
                            Map<Long, String> map = new HashMap<>();
                            for (Map.Entry<String, Integer> entry : displayNames.entrySet()) {
                                map.put(Long.valueOf(entry.getValue().intValue()), entry.getKey());
                            }
                            if (!map.isEmpty()) {
                                styleMap.put(textStyle, map);
                            }
                        }
                        i10++;
                    }
                    return new LocaleStore(styleMap);
                }
                TextStyle[] values2 = TextStyle.values();
                int length2 = values2.length;
                while (i10 < length2) {
                    TextStyle textStyle2 = values2[i10];
                    Map<Long, String> map2 = new HashMap<>();
                    if (textStyle2.equals(TextStyle.NARROW) || textStyle2.equals(TextStyle.NARROW_STANDALONE)) {
                        for (int wday = 1; wday <= 7; wday++) {
                            String name2 = CalendarDataUtility.retrieveJavaTimeFieldValueName("gregory", 7, wday, textStyle2.toCalendarStyle(), locale);
                            if (name2 == null) {
                                break;
                            }
                            map2.put(Long.valueOf(toWeekDay(wday)), name2);
                        }
                    } else {
                        Map<String, Integer> displayNames3 = CalendarDataUtility.retrieveJavaTimeFieldValueNames("gregory", 7, textStyle2.toCalendarStyle(), locale);
                        if (displayNames3 != null) {
                            for (Map.Entry<String, Integer> entry2 : displayNames3.entrySet()) {
                                map2.put(Long.valueOf(toWeekDay(entry2.getValue().intValue())), entry2.getKey());
                            }
                        } else {
                            for (int wday2 = 1; wday2 <= 7; wday2++) {
                                String name3 = CalendarDataUtility.retrieveJavaTimeFieldValueName("gregory", 7, wday2, textStyle2.toCalendarStyle(), locale);
                                if (name3 == null) {
                                    break;
                                }
                                map2.put(Long.valueOf(toWeekDay(wday2)), name3);
                            }
                        }
                    }
                    if (!map2.isEmpty()) {
                        styleMap.put(textStyle2, map2);
                    }
                    i10++;
                }
                return new LocaleStore(styleMap);
            }
            TextStyle[] values3 = TextStyle.values();
            int length3 = values3.length;
            while (i10 < length3) {
                TextStyle textStyle3 = values3[i10];
                Map<Long, String> map3 = new HashMap<>();
                int i12 = 11;
                int i13 = 2;
                if (textStyle3.equals(TextStyle.NARROW) || textStyle3.equals(TextStyle.NARROW_STANDALONE)) {
                    for (int month = 0; month <= 11 && (name = CalendarDataUtility.retrieveJavaTimeFieldValueName("gregory", 2, month, textStyle3.toCalendarStyle(), locale)) != null; month++) {
                        map3.put(Long.valueOf(month + 1), name);
                    }
                } else {
                    Map<String, Integer> displayNames4 = CalendarDataUtility.retrieveJavaTimeFieldValueNames("gregory", 2, textStyle3.toCalendarStyle(), locale);
                    if (displayNames4 != null) {
                        for (Map.Entry<String, Integer> entry3 : displayNames4.entrySet()) {
                            map3.put(Long.valueOf(entry3.getValue().intValue() + i11), entry3.getKey());
                        }
                    } else {
                        int month2 = 0;
                        while (month2 <= i12) {
                            String name4 = CalendarDataUtility.retrieveJavaTimeFieldValueName("gregory", i13, month2, textStyle3.toCalendarStyle(), locale);
                            if (name4 == null) {
                                break;
                            }
                            map3.put(Long.valueOf(month2 + 1), name4);
                            month2++;
                            i12 = 11;
                            i13 = 2;
                        }
                    }
                }
                if (!map3.isEmpty()) {
                    styleMap.put(textStyle3, map3);
                }
                i10++;
                i11 = 1;
            }
            return new LocaleStore(styleMap);
        }
        for (TextStyle textStyle4 : TextStyle.values()) {
            if (!textStyle4.isStandalone() && (displayNames2 = CalendarDataUtility.retrieveJavaTimeFieldValueNames("gregory", 0, textStyle4.toCalendarStyle(), locale)) != null) {
                Map<Long, String> map4 = new HashMap<>();
                for (Map.Entry<String, Integer> entry4 : displayNames2.entrySet()) {
                    map4.put(Long.valueOf(entry4.getValue().intValue()), entry4.getKey());
                }
                if (!map4.isEmpty()) {
                    styleMap.put(textStyle4, map4);
                }
            }
        }
        return new LocaleStore(styleMap);
    }

    private static Map<Long, String> extractQuarters(String[] quarters) {
        Map<Long, String> map = new HashMap<>();
        for (int q10 = 0; q10 < quarters.length; q10++) {
            map.put(Long.valueOf(q10 + 1), quarters[q10]);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <A, B> Map.Entry<A, B> createEntry(A text, B field) {
        return new AbstractMap.SimpleImmutableEntry(text, field);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class LocaleStore {
        private final Map<TextStyle, List<Map.Entry<String, Long>>> parsable;
        private final Map<TextStyle, Map<Long, String>> valueTextMap;

        /* JADX INFO: Access modifiers changed from: package-private */
        public LocaleStore(Map<TextStyle, Map<Long, String>> valueTextMap) {
            this.valueTextMap = valueTextMap;
            Map<TextStyle, List<Map.Entry<String, Long>>> map = new HashMap<>();
            List<Map.Entry<String, Long>> allList = new ArrayList<>();
            for (Map.Entry<TextStyle, Map<Long, String>> vtmEntry : valueTextMap.entrySet()) {
                Map<String, Map.Entry<String, Long>> reverse = new HashMap<>();
                for (Map.Entry<Long, String> entry : vtmEntry.getValue().entrySet()) {
                    reverse.put(entry.getValue(), DateTimeTextProvider.createEntry(entry.getValue(), entry.getKey()));
                }
                List<Map.Entry<String, Long>> list = new ArrayList<>(reverse.values());
                Collections.sort(list, DateTimeTextProvider.COMPARATOR);
                map.put(vtmEntry.getKey(), list);
                allList.addAll(list);
                map.put(null, allList);
            }
            Collections.sort(allList, DateTimeTextProvider.COMPARATOR);
            this.parsable = map;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getText(long value, TextStyle style) {
            Map<Long, String> map = this.valueTextMap.get(style);
            if (map != null) {
                return map.get(Long.valueOf(value));
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Iterator<Map.Entry<String, Long>> getTextIterator(TextStyle style) {
            List<Map.Entry<String, Long>> list = this.parsable.get(style);
            if (list != null) {
                return list.iterator2();
            }
            return null;
        }
    }
}
