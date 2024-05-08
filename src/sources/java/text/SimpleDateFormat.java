package java.text;

import android.icu.text.TimeZoneNames;
import android.icu.util.ULocale;
import com.android.icu.text.ExtendedTimeZoneNames;
import com.android.internal.accessibility.common.ShortcutConstants;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.Format;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import libcore.icu.SimpleDateFormatData;
import sun.util.calendar.CalendarUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class SimpleDateFormat extends DateFormat {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String GMT = "GMT";
    private static final int MILLIS_PER_MINUTE = 60000;
    private static final int TAG_QUOTE_ASCII_CHAR = 100;
    private static final int TAG_QUOTE_CHARS = 101;
    static final int currentSerialVersion = 1;
    static final long serialVersionUID = 4774881970558875024L;
    private transient char[] compiledPattern;
    private Date defaultCenturyStart;
    private transient int defaultCenturyStartYear;
    private DateFormatSymbols formatData;
    private transient boolean hasFollowingMinusSign;
    private Locale locale;
    private transient char minusSign;
    private transient NumberFormat originalNumberFormat;
    private transient String originalNumberPattern;
    private String pattern;
    private int serialVersionOnStream;
    private transient ExtendedTimeZoneNames timeZoneNames;
    transient boolean useDateFormatSymbols;
    private transient char zeroDigit;
    private static final ConcurrentMap<Locale, NumberFormat> cachedNumberFormatData = new ConcurrentHashMap(3);
    private static final int[] PATTERN_INDEX_TO_CALENDAR_FIELD = {0, 1, 2, 5, 11, 11, 12, 13, 14, 7, 6, 8, 3, 4, 9, 10, 10, 15, 15, 17, 1000, 15, 2, 7, 9, 9};
    private static final int[] PATTERN_INDEX_TO_DATE_FORMAT_FIELD = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 17, 1, 9, 17, 2, 9, 14, 14};
    private static final DateFormat.Field[] PATTERN_INDEX_TO_DATE_FORMAT_FIELD_ID = {DateFormat.Field.ERA, DateFormat.Field.YEAR, DateFormat.Field.MONTH, DateFormat.Field.DAY_OF_MONTH, DateFormat.Field.HOUR_OF_DAY1, DateFormat.Field.HOUR_OF_DAY0, DateFormat.Field.MINUTE, DateFormat.Field.SECOND, DateFormat.Field.MILLISECOND, DateFormat.Field.DAY_OF_WEEK, DateFormat.Field.DAY_OF_YEAR, DateFormat.Field.DAY_OF_WEEK_IN_MONTH, DateFormat.Field.WEEK_OF_YEAR, DateFormat.Field.WEEK_OF_MONTH, DateFormat.Field.AM_PM, DateFormat.Field.HOUR1, DateFormat.Field.HOUR0, DateFormat.Field.TIME_ZONE, DateFormat.Field.TIME_ZONE, DateFormat.Field.YEAR, DateFormat.Field.DAY_OF_WEEK, DateFormat.Field.TIME_ZONE, DateFormat.Field.MONTH, DateFormat.Field.DAY_OF_WEEK, DateFormat.Field.AM_PM, DateFormat.Field.AM_PM};
    private static final int[] REST_OF_STYLES = {Calendar.SHORT_STANDALONE, 2, Calendar.LONG_STANDALONE};

    public SimpleDateFormat() {
        this(3, 3, Locale.getDefault(Locale.Category.FORMAT));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleDateFormat(int timeStyle, int dateStyle, Locale locale) {
        this(getDateTimeFormat(timeStyle, dateStyle, locale), locale);
    }

    private static String getDateTimeFormat(int timeStyle, int dateStyle, Locale locale) {
        SimpleDateFormatData data = SimpleDateFormatData.getInstance(locale);
        if (timeStyle >= 0 && dateStyle >= 0) {
            Object[] dateTimeArgs = {data.getDateFormat(dateStyle), data.getTimeFormat(timeStyle)};
            return MessageFormat.format("{0} {1}", dateTimeArgs);
        }
        if (timeStyle >= 0) {
            return data.getTimeFormat(timeStyle);
        }
        if (dateStyle >= 0) {
            return data.getDateFormat(dateStyle);
        }
        throw new IllegalArgumentException("No date or time style specified");
    }

    public SimpleDateFormat(String pattern) {
        this(pattern, Locale.getDefault(Locale.Category.FORMAT));
    }

    public SimpleDateFormat(String pattern, Locale locale) {
        this.serialVersionOnStream = 1;
        this.minusSign = '-';
        this.hasFollowingMinusSign = false;
        if (pattern == null || locale == null) {
            throw new NullPointerException();
        }
        initializeCalendar(locale);
        this.pattern = pattern;
        this.formatData = DateFormatSymbols.getInstanceRef(locale);
        this.locale = locale;
        initialize(locale);
    }

    public SimpleDateFormat(String pattern, DateFormatSymbols formatSymbols) {
        this.serialVersionOnStream = 1;
        this.minusSign = '-';
        this.hasFollowingMinusSign = false;
        if (pattern == null || formatSymbols == null) {
            throw new NullPointerException();
        }
        this.pattern = pattern;
        this.formatData = (DateFormatSymbols) formatSymbols.clone();
        Locale locale = Locale.getDefault(Locale.Category.FORMAT);
        this.locale = locale;
        initializeCalendar(locale);
        initialize(this.locale);
        this.useDateFormatSymbols = true;
    }

    private void initialize(Locale loc) {
        this.compiledPattern = compile(this.pattern);
        ConcurrentMap<Locale, NumberFormat> concurrentMap = cachedNumberFormatData;
        this.numberFormat = concurrentMap.get(loc);
        if (this.numberFormat == null) {
            this.numberFormat = NumberFormat.getIntegerInstance(loc);
            this.numberFormat.setGroupingUsed(false);
            concurrentMap.putIfAbsent(loc, this.numberFormat);
        }
        this.numberFormat = (NumberFormat) this.numberFormat.clone();
        initializeDefaultCentury();
    }

    private void initializeCalendar(Locale loc) {
        if (this.calendar == null) {
            this.calendar = Calendar.getInstance(loc);
        }
    }

    private char[] compile(String pattern) {
        char c4;
        int length = pattern.length();
        boolean inQuote = false;
        StringBuilder compiledCode = new StringBuilder(length * 2);
        StringBuilder tmpBuffer = null;
        int count = 0;
        int lastTag = -1;
        int i10 = 0;
        while (i10 < length) {
            char c10 = pattern.charAt(i10);
            if (c10 == '\'') {
                if (i10 + 1 < length && (c4 = pattern.charAt(i10 + 1)) == '\'') {
                    i10++;
                    if (count != 0) {
                        encode(lastTag, count, compiledCode);
                        lastTag = -1;
                        count = 0;
                    }
                    if (inQuote) {
                        tmpBuffer.append(c4);
                    } else {
                        compiledCode.append((char) (c4 | 25600));
                    }
                } else if (!inQuote) {
                    if (count != 0) {
                        encode(lastTag, count, compiledCode);
                        lastTag = -1;
                        count = 0;
                    }
                    if (tmpBuffer == null) {
                        tmpBuffer = new StringBuilder(length);
                    } else {
                        tmpBuffer.setLength(0);
                    }
                    inQuote = true;
                } else {
                    int len = tmpBuffer.length();
                    if (len == 1) {
                        char ch = tmpBuffer.charAt(0);
                        if (ch < 128) {
                            compiledCode.append((char) (ch | 25600));
                        } else {
                            compiledCode.append((char) 25857);
                            compiledCode.append(ch);
                        }
                    } else {
                        encode(101, len, compiledCode);
                        compiledCode.append((CharSequence) tmpBuffer);
                    }
                    inQuote = false;
                }
            } else if (inQuote) {
                tmpBuffer.append(c10);
            } else if ((c10 < 'a' || c10 > 'z') && (c10 < 'A' || c10 > 'Z')) {
                if (count != 0) {
                    encode(lastTag, count, compiledCode);
                    lastTag = -1;
                    count = 0;
                }
                if (c10 < 128) {
                    compiledCode.append((char) (c10 | 25600));
                } else {
                    int j10 = i10 + 1;
                    while (j10 < length) {
                        char d10 = pattern.charAt(j10);
                        if (d10 == '\'' || ((d10 >= 'a' && d10 <= 'z') || (d10 >= 'A' && d10 <= 'Z'))) {
                            break;
                        }
                        j10++;
                    }
                    encode(101, j10 - i10, compiledCode);
                    while (i10 < j10) {
                        compiledCode.append(pattern.charAt(i10));
                        i10++;
                    }
                    i10--;
                }
            } else {
                int tag = "GyMdkHmsSEDFwWahKzZYuXLcbB".indexOf(c10);
                if (tag == -1) {
                    throw new IllegalArgumentException("Illegal pattern character '" + c10 + "'");
                }
                if (lastTag == -1 || lastTag == tag) {
                    lastTag = tag;
                    count++;
                } else {
                    encode(lastTag, count, compiledCode);
                    lastTag = tag;
                    count = 1;
                }
            }
            i10++;
        }
        if (inQuote) {
            throw new IllegalArgumentException("Unterminated quote");
        }
        if (count != 0) {
            encode(lastTag, count, compiledCode);
        }
        int len2 = compiledCode.length();
        char[] r10 = new char[len2];
        compiledCode.getChars(0, len2, r10, 0);
        return r10;
    }

    private static void encode(int tag, int length, StringBuilder buffer) {
        if (tag == 21 && length >= 4) {
            throw new IllegalArgumentException("invalid ISO 8601 format: length=" + length);
        }
        if (length >= 255) {
            buffer.append((char) (255 | (tag << 8)));
            buffer.append((char) (length >>> 16));
            buffer.append((char) (65535 & length));
            return;
        }
        buffer.append((char) ((tag << 8) | length));
    }

    private void initializeDefaultCentury() {
        this.calendar.setTimeInMillis(System.currentTimeMillis());
        this.calendar.add(1, -80);
        parseAmbiguousDatesAsAfter(this.calendar.getTime());
    }

    private void parseAmbiguousDatesAsAfter(Date startDate) {
        this.defaultCenturyStart = startDate;
        this.calendar.setTime(startDate);
        this.defaultCenturyStartYear = this.calendar.get(1);
    }

    public void set2DigitYearStart(Date startDate) {
        parseAmbiguousDatesAsAfter(new Date(startDate.getTime()));
    }

    public Date get2DigitYearStart() {
        return (Date) this.defaultCenturyStart.clone();
    }

    @Override // java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition pos) {
        pos.endIndex = 0;
        pos.beginIndex = 0;
        return format(date, toAppendTo, pos.getFieldDelegate());
    }

    private StringBuffer format(Date date, StringBuffer toAppendTo, Format.FieldDelegate delegate) {
        int i10;
        int count;
        this.calendar.setTime(date);
        boolean useDateFormatSymbols = useDateFormatSymbols();
        int i11 = 0;
        while (true) {
            char[] cArr = this.compiledPattern;
            if (i11 < cArr.length) {
                char c4 = cArr[i11];
                int tag = c4 >>> '\b';
                int i12 = i11 + 1;
                int count2 = c4 & 255;
                if (count2 != 255) {
                    i10 = i12;
                    count = count2;
                } else {
                    int i13 = i12 + 1;
                    count = (cArr[i12] << 16) | cArr[i13];
                    i10 = i13 + 1;
                }
                switch (tag) {
                    case 100:
                        toAppendTo.append((char) count);
                        break;
                    case 101:
                        toAppendTo.append(cArr, i10, count);
                        i11 = i10 + count;
                        continue;
                    default:
                        subFormat(tag, count, delegate, toAppendTo, useDateFormatSymbols);
                        break;
                }
                i11 = i10;
            } else {
                return toAppendTo;
            }
        }
    }

    @Override // java.text.Format
    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        StringBuffer sb2 = new StringBuffer();
        CharacterIteratorFieldDelegate delegate = new CharacterIteratorFieldDelegate();
        if (obj instanceof Date) {
            format((Date) obj, sb2, delegate);
        } else if (obj instanceof Number) {
            format(new Date(((Number) obj).longValue()), sb2, delegate);
        } else {
            if (obj == null) {
                throw new NullPointerException("formatToCharacterIterator must be passed non-null object");
            }
            throw new IllegalArgumentException("Cannot format given Object as a Date");
        }
        return delegate.getIterator(sb2.toString());
    }

    private void subFormat(int patternCharIndex, int count, Format.FieldDelegate delegate, StringBuffer buffer, boolean useDateFormatSymbols) {
        int patternCharIndex2;
        int value;
        int field;
        String current;
        int beginOffset;
        String current2;
        int beginOffset2;
        TimeZoneNames.NameType nameType;
        String zoneString;
        int beginOffset3 = buffer.length();
        int[] iArr = PATTERN_INDEX_TO_CALENDAR_FIELD;
        int field2 = iArr[patternCharIndex];
        if (field2 == 17) {
            if (this.calendar.isWeekDateSupported()) {
                patternCharIndex2 = patternCharIndex;
                value = this.calendar.getWeekYear();
                field = field2;
            } else {
                int field3 = iArr[1];
                value = this.calendar.get(field3);
                field = field3;
                patternCharIndex2 = 1;
            }
        } else if (field2 == 1000) {
            patternCharIndex2 = patternCharIndex;
            value = CalendarBuilder.toISODayOfWeek(this.calendar.get(7));
            field = field2;
        } else {
            patternCharIndex2 = patternCharIndex;
            value = this.calendar.get(field2);
            field = field2;
        }
        int style = count >= 4 ? 2 : 1;
        if (!useDateFormatSymbols && field != 1000) {
            String current3 = this.calendar.getDisplayName(field, style, this.locale);
            current = current3;
        } else {
            current = null;
        }
        switch (patternCharIndex2) {
            case 0:
                beginOffset = beginOffset3;
                int beginOffset4 = value;
                if (useDateFormatSymbols) {
                    String[] eras = this.formatData.getEras();
                    if (beginOffset4 < eras.length) {
                        current = eras[beginOffset4];
                    }
                }
                if (current != null) {
                    current2 = current;
                    break;
                } else {
                    current2 = "";
                    break;
                }
            case 1:
            case 19:
                beginOffset = beginOffset3;
                beginOffset2 = value;
                if (this.calendar instanceof GregorianCalendar) {
                    if (count != 2) {
                        zeroPaddingNumber(beginOffset2, count, Integer.MAX_VALUE, buffer);
                    } else {
                        zeroPaddingNumber(beginOffset2, 2, 2, buffer);
                    }
                } else if (current == null) {
                    zeroPaddingNumber(beginOffset2, style == 2 ? 1 : count, Integer.MAX_VALUE, buffer);
                }
                current2 = current;
                break;
            case 2:
                beginOffset = beginOffset3;
                String current4 = formatMonth(count, value, Integer.MAX_VALUE, buffer, useDateFormatSymbols, false, field, style);
                current2 = current4;
                break;
            case 3:
            case 5:
            case 6:
            case 7:
            case 10:
            case 11:
            case 12:
            case 13:
            case 16:
            case 20:
            default:
                beginOffset = beginOffset3;
                beginOffset2 = value;
                if (current == null) {
                    zeroPaddingNumber(beginOffset2, count, Integer.MAX_VALUE, buffer);
                }
                current2 = current;
                break;
            case 4:
                beginOffset = beginOffset3;
                beginOffset2 = value;
                if (current == null) {
                    if (beginOffset2 == 0) {
                        zeroPaddingNumber(this.calendar.getMaximum(11) + 1, count, Integer.MAX_VALUE, buffer);
                    } else {
                        zeroPaddingNumber(beginOffset2, count, Integer.MAX_VALUE, buffer);
                    }
                }
                current2 = current;
                break;
            case 8:
                beginOffset = beginOffset3;
                beginOffset2 = value;
                if (current != null) {
                    current2 = current;
                    break;
                } else {
                    int value2 = (int) ((beginOffset2 / 1000.0d) * Math.pow(10.0d, count));
                    zeroPaddingNumber(value2, count, count, buffer);
                    current2 = current;
                    break;
                }
            case 9:
                beginOffset = beginOffset3;
                beginOffset2 = value;
                if (current != null) {
                    current2 = current;
                    break;
                } else {
                    String current5 = formatWeekday(count, beginOffset2, useDateFormatSymbols, false);
                    current2 = current5;
                    break;
                }
            case 14:
                beginOffset = beginOffset3;
                beginOffset2 = value;
                if (!useDateFormatSymbols) {
                    current2 = current;
                    break;
                } else {
                    String[] ampm = this.formatData.getAmPmStrings();
                    String current6 = ampm[beginOffset2];
                    current2 = current6;
                    break;
                }
            case 15:
                beginOffset = beginOffset3;
                beginOffset2 = value;
                if (current == null) {
                    if (beginOffset2 == 0) {
                        zeroPaddingNumber(this.calendar.getLeastMaximum(10) + 1, count, Integer.MAX_VALUE, buffer);
                    } else {
                        zeroPaddingNumber(beginOffset2, count, Integer.MAX_VALUE, buffer);
                    }
                }
                current2 = current;
                break;
            case 17:
                beginOffset = beginOffset3;
                beginOffset2 = value;
                if (current == null) {
                    TimeZone tz = this.calendar.getTimeZone();
                    boolean daylight = this.calendar.get(16) != 0;
                    if (this.formatData.isZoneStringsSet) {
                        int tzstyle = count >= 4 ? 1 : 0;
                        zoneString = libcore.icu.TimeZoneNames.getDisplayName(this.formatData.getZoneStringsWrapper(), tz.getID(), daylight, tzstyle);
                    } else {
                        if (count < 4) {
                            if (daylight) {
                                nameType = TimeZoneNames.NameType.SHORT_DAYLIGHT;
                            } else {
                                nameType = TimeZoneNames.NameType.SHORT_STANDARD;
                            }
                        } else if (daylight) {
                            nameType = TimeZoneNames.NameType.LONG_DAYLIGHT;
                        } else {
                            nameType = TimeZoneNames.NameType.LONG_STANDARD;
                        }
                        String canonicalID = android.icu.util.TimeZone.getCanonicalID(tz.getID());
                        zoneString = getTimeZoneNames().getDisplayName(canonicalID, nameType, this.calendar.getTimeInMillis());
                    }
                    if (zoneString != null) {
                        buffer.append(zoneString);
                    } else {
                        int offsetMillis = this.calendar.get(15) + this.calendar.get(16);
                        buffer.append(TimeZone.createGmtOffsetString(true, true, offsetMillis));
                    }
                }
                current2 = current;
                break;
            case 18:
                beginOffset = beginOffset3;
                int value3 = this.calendar.get(15) + this.calendar.get(16);
                boolean includeSeparator = count >= 4;
                boolean includeGmt = count == 4;
                buffer.append(TimeZone.createGmtOffsetString(includeGmt, includeSeparator, value3));
                current2 = current;
                break;
            case 21:
                beginOffset = beginOffset3;
                int value4 = this.calendar.get(15) + this.calendar.get(16);
                if (value4 == 0) {
                    buffer.append('Z');
                    current2 = current;
                    break;
                } else {
                    int value5 = value4 / 60000;
                    if (value5 >= 0) {
                        buffer.append('+');
                    } else {
                        buffer.append('-');
                        value5 = -value5;
                    }
                    CalendarUtils.sprintf0d(buffer, value5 / 60, 2);
                    if (count != 1) {
                        if (count == 3) {
                            buffer.append(ShortcutConstants.SERVICES_SEPARATOR);
                        }
                        CalendarUtils.sprintf0d(buffer, value5 % 60, 2);
                    }
                    current2 = current;
                    break;
                }
            case 22:
                beginOffset = beginOffset3;
                String current7 = formatMonth(count, value, Integer.MAX_VALUE, buffer, useDateFormatSymbols, true, field, style);
                current2 = current7;
                break;
            case 23:
                if (current != null) {
                    beginOffset = beginOffset3;
                    beginOffset2 = value;
                    current2 = current;
                    break;
                } else {
                    String current8 = formatWeekday(count, value, useDateFormatSymbols, true);
                    beginOffset = beginOffset3;
                    current2 = current8;
                    break;
                }
            case 24:
            case 25:
                beginOffset = beginOffset3;
                current2 = "";
                break;
        }
        if (current2 != null) {
            buffer.append(current2);
        }
        int fieldID = PATTERN_INDEX_TO_DATE_FORMAT_FIELD[patternCharIndex2];
        DateFormat.Field f10 = PATTERN_INDEX_TO_DATE_FORMAT_FIELD_ID[patternCharIndex2];
        delegate.formatted(fieldID, f10, f10, beginOffset, buffer.length(), buffer);
    }

    private String formatWeekday(int count, int value, boolean useDateFormatSymbols, boolean standalone) {
        String[] weekdays;
        if (useDateFormatSymbols) {
            if (count == 4) {
                DateFormatSymbols dateFormatSymbols = this.formatData;
                weekdays = standalone ? dateFormatSymbols.getStandAloneWeekdays() : dateFormatSymbols.getWeekdays();
            } else if (count == 5) {
                DateFormatSymbols dateFormatSymbols2 = this.formatData;
                weekdays = standalone ? dateFormatSymbols2.getTinyStandAloneWeekdays() : dateFormatSymbols2.getTinyWeekdays();
            } else {
                DateFormatSymbols dateFormatSymbols3 = this.formatData;
                weekdays = standalone ? dateFormatSymbols3.getShortStandAloneWeekdays() : dateFormatSymbols3.getShortWeekdays();
            }
            return weekdays[value];
        }
        return null;
    }

    private String formatMonth(int count, int value, int maxIntCount, StringBuffer buffer, boolean useDateFormatSymbols, boolean standalone, int field, int style) {
        String[] months;
        String current = null;
        if (useDateFormatSymbols) {
            if (count == 4) {
                DateFormatSymbols dateFormatSymbols = this.formatData;
                months = standalone ? dateFormatSymbols.getStandAloneMonths() : dateFormatSymbols.getMonths();
            } else if (count == 5) {
                DateFormatSymbols dateFormatSymbols2 = this.formatData;
                months = standalone ? dateFormatSymbols2.getTinyStandAloneMonths() : dateFormatSymbols2.getTinyMonths();
            } else if (count == 3) {
                DateFormatSymbols dateFormatSymbols3 = this.formatData;
                months = standalone ? dateFormatSymbols3.getShortStandAloneMonths() : dateFormatSymbols3.getShortMonths();
            } else {
                months = null;
            }
            if (months != null) {
                current = months[value];
            }
        } else if (count < 3) {
            current = null;
        } else {
            if (standalone) {
                style = Calendar.toStandaloneStyle(style);
            }
            current = this.calendar.getDisplayName(field, style, this.locale);
        }
        if (current == null) {
            zeroPaddingNumber(value + 1, count, maxIntCount, buffer);
        }
        return current;
    }

    private void zeroPaddingNumber(int value, int minDigits, int maxDigits, StringBuffer buffer) {
        try {
            if (this.zeroDigit == 0) {
                this.zeroDigit = ((DecimalFormat) this.numberFormat).getDecimalFormatSymbols().getZeroDigit();
            }
            if (value >= 0) {
                if (value < 100 && minDigits >= 1 && minDigits <= 2) {
                    if (value < 10) {
                        if (minDigits == 2) {
                            buffer.append(this.zeroDigit);
                        }
                        buffer.append((char) (this.zeroDigit + value));
                        return;
                    } else {
                        buffer.append((char) (this.zeroDigit + (value / 10)));
                        buffer.append((char) (this.zeroDigit + (value % 10)));
                        return;
                    }
                }
                if (value >= 1000 && value < 10000) {
                    if (minDigits == 4) {
                        buffer.append((char) (this.zeroDigit + (value / 1000)));
                        int value2 = value % 1000;
                        buffer.append((char) (this.zeroDigit + (value2 / 100)));
                        int value3 = value2 % 100;
                        buffer.append((char) (this.zeroDigit + (value3 / 10)));
                        buffer.append((char) (this.zeroDigit + (value3 % 10)));
                        return;
                    }
                    if (minDigits == 2 && maxDigits == 2) {
                        zeroPaddingNumber(value % 100, 2, 2, buffer);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
        }
        this.numberFormat.setMinimumIntegerDigits(minDigits);
        this.numberFormat.setMaximumIntegerDigits(maxDigits);
        this.numberFormat.format(value, buffer, DontCareFieldPosition.INSTANCE);
    }

    @Override // java.text.DateFormat
    public Date parse(String text, ParsePosition pos) {
        TimeZone tz = getTimeZone();
        try {
            return parseInternal(text, pos);
        } finally {
            setTimeZone(tz);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0093, code lost:
    
        r26.index = r0;
        r26.errorIndex = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0097, code lost:
    
        return null;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0045. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v17, types: [char] */
    /* JADX WARN: Type inference failed for: r24v0, types: [java.text.SimpleDateFormat] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Date parseInternal(java.lang.String r25, java.text.ParsePosition r26) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.text.SimpleDateFormat.parseInternal(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private boolean shouldObeyCount(int tag, int count) {
        switch (tag) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 15:
            case 16:
            case 19:
            case 20:
                return true;
            case 2:
            case 22:
                return count <= 2;
            case 9:
            case 14:
            case 17:
            case 18:
            case 21:
            default:
                return false;
        }
    }

    private int matchString(String text, int start, int field, String[] data, CalendarBuilder calb) {
        int count = data.length;
        int i10 = field == 7 ? 1 : 0;
        int bestMatchLength = 0;
        int bestMatch = -1;
        for (int i11 = i10; i11 < count; i11++) {
            int length = data[i11].length();
            if (length > bestMatchLength && text.regionMatches(true, start, data[i11], 0, length)) {
                bestMatch = i11;
                bestMatchLength = length;
            }
            if (data[i11].charAt(length - 1) == '.' && length - 1 > bestMatchLength && text.regionMatches(true, start, data[i11], 0, length - 1)) {
                int bestMatch2 = i11;
                bestMatch = bestMatch2;
                bestMatchLength = length - 1;
            }
        }
        if (bestMatch < 0) {
            return -start;
        }
        calb.set(field, bestMatch);
        return start + bestMatchLength;
    }

    private int matchString(String text, int start, int field, Map<String, Integer> data, CalendarBuilder calb) {
        if (data != null) {
            if ((data instanceof NavigableMap) && ((NavigableMap) data).comparator() == null) {
                for (String name : ((NavigableMap) data).descendingKeySet()) {
                    if (text.regionMatches(true, start, name, 0, name.length())) {
                        calb.set(field, data.get(name).intValue());
                        return name.length() + start;
                    }
                }
                return -start;
            }
            String bestMatch = null;
            for (String name2 : data.h()) {
                int length = name2.length();
                if (bestMatch == null || length > bestMatch.length()) {
                    if (text.regionMatches(true, start, name2, 0, length)) {
                        bestMatch = name2;
                    }
                }
            }
            if (bestMatch != null) {
                calb.set(field, data.get(bestMatch).intValue());
                return bestMatch.length() + start;
            }
        }
        return -start;
    }

    private int matchZoneString(String text, int start, String[] zoneNames) {
        for (int i10 = 1; i10 <= 4; i10++) {
            String zoneName = zoneNames[i10];
            if (text.regionMatches(true, start, zoneName, 0, zoneName.length())) {
                return i10;
            }
        }
        return -1;
    }

    private int subParseZoneString(String text, int start, CalendarBuilder calb) {
        if (this.formatData.isZoneStringsSet) {
            return subParseZoneStringFromSymbols(text, start, calb);
        }
        return subParseZoneStringFromICU(text, start, calb);
    }

    private ExtendedTimeZoneNames getExtendedTimeZoneNames() {
        if (this.timeZoneNames == null) {
            this.timeZoneNames = ExtendedTimeZoneNames.getInstance(ULocale.forLocale(this.locale));
        }
        return this.timeZoneNames;
    }

    private TimeZoneNames getTimeZoneNames() {
        return getExtendedTimeZoneNames().getTimeZoneNames();
    }

    private int subParseZoneStringFromICU(String text, int start, CalendarBuilder calb) {
        String currentTimeZoneID = android.icu.util.TimeZone.getCanonicalID(getTimeZone().getID());
        ExtendedTimeZoneNames.Match matchedName = getExtendedTimeZoneNames().matchName(text, start, currentTimeZoneID);
        if (matchedName == null) {
            return -start;
        }
        String tzId = matchedName.getTzId();
        TimeZone newTimeZone = TimeZone.getTimeZone(tzId);
        if (!currentTimeZoneID.equals(tzId)) {
            setTimeZone(newTimeZone);
        }
        boolean isDst = matchedName.isDst();
        int dstAmount = isDst ? newTimeZone.getDSTSavings() : 0;
        if (!isDst || dstAmount != 0) {
            calb.clear(15).set(16, dstAmount);
        }
        return matchedName.getMatchLength() + start;
    }

    private int subParseZoneStringFromSymbols(String text, int start, CalendarBuilder calb) {
        int zoneIndex;
        boolean useSameName = false;
        TimeZone currentTimeZone = getTimeZone();
        int zoneIndex2 = this.formatData.getZoneIndex(currentTimeZone.getID());
        TimeZone tz = null;
        String[][] zoneStrings = this.formatData.getZoneStringsWrapper();
        String[] zoneNames = null;
        int nameIndex = 0;
        if (zoneIndex2 != -1) {
            zoneNames = zoneStrings[zoneIndex2];
            int matchZoneString = matchZoneString(text, start, zoneNames);
            nameIndex = matchZoneString;
            if (matchZoneString > 0) {
                if (nameIndex <= 2) {
                    useSameName = zoneNames[nameIndex].equalsIgnoreCase(zoneNames[nameIndex + 2]);
                }
                tz = TimeZone.getTimeZone(zoneNames[0]);
            }
        }
        if (tz == null && (zoneIndex = this.formatData.getZoneIndex(TimeZone.getDefault().getID())) != -1) {
            zoneNames = zoneStrings[zoneIndex];
            int matchZoneString2 = matchZoneString(text, start, zoneNames);
            nameIndex = matchZoneString2;
            if (matchZoneString2 > 0) {
                if (nameIndex <= 2) {
                    useSameName = zoneNames[nameIndex].equalsIgnoreCase(zoneNames[nameIndex + 2]);
                }
                tz = TimeZone.getTimeZone(zoneNames[0]);
            }
        }
        if (tz == null) {
            int len = zoneStrings.length;
            int i10 = 0;
            while (true) {
                if (i10 >= len) {
                    break;
                }
                zoneNames = zoneStrings[i10];
                int matchZoneString3 = matchZoneString(text, start, zoneNames);
                nameIndex = matchZoneString3;
                if (matchZoneString3 <= 0) {
                    i10++;
                } else {
                    if (nameIndex <= 2) {
                        useSameName = zoneNames[nameIndex].equalsIgnoreCase(zoneNames[nameIndex + 2]);
                    }
                    tz = TimeZone.getTimeZone(zoneNames[0]);
                }
            }
        }
        if (tz != null) {
            if (!tz.equals(currentTimeZone)) {
                setTimeZone(tz);
            }
            int dstAmount = nameIndex >= 3 ? tz.getDSTSavings() : 0;
            if (!useSameName && (nameIndex < 3 || dstAmount != 0)) {
                calb.clear(15).set(16, dstAmount);
            }
            return zoneNames[nameIndex].length() + start;
        }
        return -start;
    }

    private int subParseNumericZone(String text, int start, int sign, int count, boolean colon, CalendarBuilder calb) {
        int index = start + 1;
        try {
            char c4 = text.charAt(start);
            if (isDigit(c4)) {
                int hours = c4 - 48;
                int index2 = index + 1;
                try {
                    char c10 = text.charAt(index);
                    if (isDigit(c10)) {
                        hours = (hours * 10) + (c10 - 48);
                        index = index2;
                    } else {
                        index = index2 - 1;
                    }
                    if (hours <= 23) {
                        int minutes = 0;
                        if (count != 1) {
                            int index3 = index + 1;
                            try {
                                char c11 = text.charAt(index);
                                if (c11 == ':') {
                                    index = index3 + 1;
                                    c11 = text.charAt(index3);
                                } else if (!colon) {
                                    index = index3;
                                } else {
                                    index = index3;
                                }
                                if (isDigit(c11)) {
                                    int minutes2 = c11 - 48;
                                    index3 = index + 1;
                                    char c12 = text.charAt(index);
                                    if (isDigit(c12) && (minutes = (minutes2 * 10) + (c12 - 48)) <= 59) {
                                        index = index3;
                                    } else {
                                        index = index3;
                                    }
                                }
                            } catch (IndexOutOfBoundsException e2) {
                                index = index3;
                            }
                        }
                        calb.set(15, 60000 * (minutes + (hours * 60)) * sign).set(16, 0);
                        return index;
                    }
                } catch (IndexOutOfBoundsException e10) {
                    index = index2;
                }
            }
        } catch (IndexOutOfBoundsException e11) {
        }
        return 1 - index;
    }

    private boolean isDigit(char c4) {
        return c4 >= '0' && c4 <= '9';
    }

    /* JADX WARN: Code restructure failed: missing block: B:246:0x008c, code lost:
    
        if ((r25.calendar instanceof java.util.GregorianCalendar) == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0529, code lost:
    
        if (r9.charAt(r6.index - 1) == r25.minusSign) goto L250;
     */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int subParse(java.lang.String r26, int r27, int r28, int r29, boolean r30, boolean[] r31, java.text.ParsePosition r32, boolean r33, java.text.CalendarBuilder r34) {
        /*
            Method dump skipped, instructions count: 1432
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.text.SimpleDateFormat.subParse(java.lang.String, int, int, int, boolean, boolean[], java.text.ParsePosition, boolean, java.text.CalendarBuilder):int");
    }

    private int parseMonth(String text, int count, int value, int start, int field, ParsePosition pos, boolean useDateFormatSymbols, boolean standalone, CalendarBuilder out) {
        int index;
        if (count <= 2) {
            out.set(2, value - 1);
            return pos.index;
        }
        if (useDateFormatSymbols) {
            DateFormatSymbols dateFormatSymbols = this.formatData;
            int index2 = matchString(text, start, 2, standalone ? dateFormatSymbols.getStandAloneMonths() : dateFormatSymbols.getMonths(), out);
            if (index2 > 0) {
                return index2;
            }
            DateFormatSymbols dateFormatSymbols2 = this.formatData;
            int matchString = matchString(text, start, 2, standalone ? dateFormatSymbols2.getShortStandAloneMonths() : dateFormatSymbols2.getShortMonths(), out);
            index = matchString;
            if (matchString > 0) {
                return index;
            }
        } else {
            Map<String, Integer> map = getDisplayNamesMap(field, this.locale);
            int matchString2 = matchString(text, start, field, map, out);
            index = matchString2;
            if (matchString2 > 0) {
                return index;
            }
        }
        return index;
    }

    private int parseWeekday(String text, int start, int field, boolean useDateFormatSymbols, boolean standalone, CalendarBuilder out) {
        if (useDateFormatSymbols) {
            DateFormatSymbols dateFormatSymbols = this.formatData;
            int index = matchString(text, start, 7, standalone ? dateFormatSymbols.getStandAloneWeekdays() : dateFormatSymbols.getWeekdays(), out);
            if (index > 0) {
                return index;
            }
            DateFormatSymbols dateFormatSymbols2 = this.formatData;
            int index2 = matchString(text, start, 7, standalone ? dateFormatSymbols2.getShortStandAloneWeekdays() : dateFormatSymbols2.getShortWeekdays(), out);
            return index2 > 0 ? index2 : index2;
        }
        int[] styles = {2, 1};
        int index3 = -1;
        for (int style : styles) {
            Map<String, Integer> map = this.calendar.getDisplayNames(field, style, this.locale);
            int matchString = matchString(text, start, field, map, out);
            index3 = matchString;
            if (matchString > 0) {
                return index3;
            }
        }
        return index3;
    }

    private boolean useDateFormatSymbols() {
        return this.useDateFormatSymbols || "java.util.GregorianCalendar".equals(this.calendar.getClass().getName()) || this.locale == null;
    }

    private String translatePattern(String pattern, String from, String to) {
        StringBuilder result = new StringBuilder();
        boolean inQuote = false;
        for (int i10 = 0; i10 < pattern.length(); i10++) {
            char c4 = pattern.charAt(i10);
            if (inQuote) {
                if (c4 == '\'') {
                    inQuote = false;
                }
            } else if (c4 == '\'') {
                inQuote = true;
            } else if ((c4 >= 'a' && c4 <= 'z') || (c4 >= 'A' && c4 <= 'Z')) {
                int ci = from.indexOf(c4);
                if (ci >= 0) {
                    if (ci < to.length()) {
                        c4 = to.charAt(ci);
                    }
                } else {
                    throw new IllegalArgumentException("Illegal pattern  character '" + c4 + "'");
                }
            }
            result.append(c4);
        }
        if (inQuote) {
            throw new IllegalArgumentException("Unfinished quote in pattern");
        }
        return result.toString();
    }

    public String toPattern() {
        return this.pattern;
    }

    public String toLocalizedPattern() {
        return translatePattern(this.pattern, "GyMdkHmsSEDFwWahKzZYuXLcbB", this.formatData.getLocalPatternChars());
    }

    public void applyPattern(String pattern) {
        applyPatternImpl(pattern);
    }

    private void applyPatternImpl(String pattern) {
        this.compiledPattern = compile(pattern);
        this.pattern = pattern;
    }

    public void applyLocalizedPattern(String pattern) {
        String p10 = translatePattern(pattern, this.formatData.getLocalPatternChars(), "GyMdkHmsSEDFwWahKzZYuXLcbB");
        this.compiledPattern = compile(p10);
        this.pattern = p10;
    }

    public DateFormatSymbols getDateFormatSymbols() {
        return (DateFormatSymbols) this.formatData.clone();
    }

    public void setDateFormatSymbols(DateFormatSymbols newFormatSymbols) {
        this.formatData = (DateFormatSymbols) newFormatSymbols.clone();
        this.useDateFormatSymbols = true;
    }

    @Override // java.text.DateFormat, java.text.Format
    public Object clone() {
        SimpleDateFormat other = (SimpleDateFormat) super.clone();
        other.formatData = (DateFormatSymbols) this.formatData.clone();
        return other;
    }

    @Override // java.text.DateFormat
    public int hashCode() {
        return this.pattern.hashCode();
    }

    @Override // java.text.DateFormat
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        SimpleDateFormat that = (SimpleDateFormat) obj;
        return this.pattern.equals(that.pattern) && this.formatData.equals(that.formatData);
    }

    private Map<String, Integer> getDisplayNamesMap(int field, Locale locale) {
        Map<String, Integer> map = this.calendar.getDisplayNames(field, 1, locale);
        for (int style : REST_OF_STYLES) {
            Map<String, Integer> m10 = this.calendar.getDisplayNames(field, style, locale);
            if (m10 != null) {
                map.putAll(m10);
            }
        }
        return map;
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        String id2;
        TimeZone zi;
        stream.defaultReadObject();
        try {
            this.compiledPattern = compile(this.pattern);
            if (this.serialVersionOnStream < 1) {
                initializeDefaultCentury();
            } else {
                parseAmbiguousDatesAsAfter(this.defaultCenturyStart);
            }
            this.serialVersionOnStream = 1;
            TimeZone tz = getTimeZone();
            if ((tz instanceof SimpleTimeZone) && (zi = TimeZone.getTimeZone((id2 = tz.getID()))) != null && zi.hasSameRules(tz) && zi.getID().equals(id2)) {
                setTimeZone(zi);
            }
        } catch (Exception e2) {
            throw new InvalidObjectException("invalid pattern");
        }
    }

    private void checkNegativeNumberExpression() {
        int minusIndex;
        if ((this.numberFormat instanceof DecimalFormat) && !this.numberFormat.equals(this.originalNumberFormat)) {
            String numberPattern = ((DecimalFormat) this.numberFormat).toPattern();
            if (!numberPattern.equals(this.originalNumberPattern)) {
                this.hasFollowingMinusSign = false;
                int separatorIndex = numberPattern.indexOf(59);
                if (separatorIndex > -1 && (minusIndex = numberPattern.indexOf(45, separatorIndex)) > numberPattern.lastIndexOf(48) && minusIndex > numberPattern.lastIndexOf(35)) {
                    this.hasFollowingMinusSign = true;
                    this.minusSign = ((DecimalFormat) this.numberFormat).getDecimalFormatSymbols().getMinusSign();
                }
                this.originalNumberPattern = numberPattern;
            }
            this.originalNumberFormat = this.numberFormat;
        }
    }
}
