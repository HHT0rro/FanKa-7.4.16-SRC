package java.time.format;

import android.icu.text.LocaleDisplayNames;
import android.icu.text.TimeZoneNames;
import android.icu.util.ULocale;
import com.android.icu.util.ExtendedCalendar;
import com.android.internal.accessibility.common.ShortcutConstants;
import com.google.android.material.badge.BadgeDrawable;
import com.huawei.openalliance.ad.constant.u;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.ParsePosition;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeTextProvider;
import java.time.temporal.ChronoField;
import java.time.temporal.IsoFields;
import java.time.temporal.JulianFields;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.ValueRange;
import java.time.temporal.WeekFields;
import java.time.zone.ZoneRulesProvider;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.zip.ZipUtils;
import libcore.icu.ICU;
import okhttp3.internal.connection.RealConnection;
import org.apache.commons.lang3.time.TimeZones;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class DateTimeFormatterBuilder {
    private static final Map<Character, TemporalField> FIELD_MAP;
    private static final TemporalQuery<ZoneId> QUERY_REGION_ONLY = new TemporalQuery() { // from class: java.time.format.DateTimeFormatterBuilder$$ExternalSyntheticLambda0
        @Override // java.time.temporal.TemporalQuery
        public final Object queryFrom(TemporalAccessor temporalAccessor) {
            return DateTimeFormatterBuilder.lambda$static$0(temporalAccessor);
        }
    };
    private DateTimeFormatterBuilder active;
    private final boolean optional;
    private char padNextChar;
    private int padNextWidth;
    private final DateTimeFormatterBuilder parent;
    private final List<DateTimePrinterParser> printerParsers;
    private int valueParserIndex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface DateTimePrinterParser {
        boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb2);

        int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i10);
    }

    static {
        HashMap hashMap = new HashMap();
        FIELD_MAP = hashMap;
        hashMap.put('G', ChronoField.ERA);
        hashMap.put('y', ChronoField.YEAR_OF_ERA);
        hashMap.put('u', ChronoField.YEAR);
        hashMap.put('Q', IsoFields.QUARTER_OF_YEAR);
        hashMap.put('q', IsoFields.QUARTER_OF_YEAR);
        hashMap.put('M', ChronoField.MONTH_OF_YEAR);
        hashMap.put('L', ChronoField.MONTH_OF_YEAR);
        hashMap.put('D', ChronoField.DAY_OF_YEAR);
        hashMap.put('d', ChronoField.DAY_OF_MONTH);
        hashMap.put('F', ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        hashMap.put('E', ChronoField.DAY_OF_WEEK);
        hashMap.put('c', ChronoField.DAY_OF_WEEK);
        hashMap.put('e', ChronoField.DAY_OF_WEEK);
        hashMap.put('a', ChronoField.AMPM_OF_DAY);
        hashMap.put('H', ChronoField.HOUR_OF_DAY);
        hashMap.put('k', ChronoField.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', ChronoField.HOUR_OF_AMPM);
        hashMap.put('h', ChronoField.CLOCK_HOUR_OF_AMPM);
        hashMap.put('m', ChronoField.MINUTE_OF_HOUR);
        hashMap.put('s', ChronoField.SECOND_OF_MINUTE);
        hashMap.put('S', ChronoField.NANO_OF_SECOND);
        hashMap.put('A', ChronoField.MILLI_OF_DAY);
        hashMap.put('n', ChronoField.NANO_OF_SECOND);
        hashMap.put('N', ChronoField.NANO_OF_DAY);
        hashMap.put('g', JulianFields.MODIFIED_JULIAN_DAY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ZoneId lambda$static$0(TemporalAccessor temporal) {
        ZoneId zone = (ZoneId) temporal.query(TemporalQueries.zoneId());
        if (zone instanceof ZoneOffset) {
            return null;
        }
        return zone;
    }

    public static String getLocalizedDateTimePattern(FormatStyle dateStyle, FormatStyle timeStyle, Chronology chrono, Locale locale) {
        Objects.requireNonNull(locale, "locale");
        Objects.requireNonNull(chrono, "chrono");
        if (dateStyle == null && timeStyle == null) {
            throw new IllegalArgumentException("Either dateStyle or timeStyle must be non-null");
        }
        String calType = chrono instanceof IsoChronology ? "gregorian" : chrono.getCalendarType();
        ExtendedCalendar extendedCalendar = ICU.getExtendedCalendar(locale, calType);
        String pattern = extendedCalendar.getDateTimePattern(convertStyle(dateStyle), convertStyle(timeStyle));
        return ICU.transformIcuDateTimePattern_forJavaTime(pattern);
    }

    private static int convertStyle(FormatStyle style) {
        if (style == null) {
            return -1;
        }
        return style.ordinal();
    }

    public DateTimeFormatterBuilder() {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = null;
        this.optional = false;
    }

    private DateTimeFormatterBuilder(DateTimeFormatterBuilder parent, boolean optional) {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = parent;
        this.optional = optional;
    }

    public DateTimeFormatterBuilder parseCaseSensitive() {
        appendInternal(SettingsParser.SENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder parseCaseInsensitive() {
        appendInternal(SettingsParser.INSENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder parseStrict() {
        appendInternal(SettingsParser.STRICT);
        return this;
    }

    public DateTimeFormatterBuilder parseLenient() {
        appendInternal(SettingsParser.LENIENT);
        return this;
    }

    public DateTimeFormatterBuilder parseDefaulting(TemporalField field, long value) {
        Objects.requireNonNull(field, "field");
        appendInternal(new DefaultValueParser(field, value));
        return this;
    }

    public DateTimeFormatterBuilder appendValue(TemporalField field) {
        Objects.requireNonNull(field, "field");
        appendValue(new NumberPrinterParser(field, 1, 19, SignStyle.NORMAL));
        return this;
    }

    public DateTimeFormatterBuilder appendValue(TemporalField field, int width) {
        Objects.requireNonNull(field, "field");
        if (width < 1 || width > 19) {
            throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + width);
        }
        NumberPrinterParser pp = new NumberPrinterParser(field, width, width, SignStyle.NOT_NEGATIVE);
        appendValue(pp);
        return this;
    }

    public DateTimeFormatterBuilder appendValue(TemporalField field, int minWidth, int maxWidth, SignStyle signStyle) {
        if (minWidth == maxWidth && signStyle == SignStyle.NOT_NEGATIVE) {
            return appendValue(field, maxWidth);
        }
        Objects.requireNonNull(field, "field");
        Objects.requireNonNull(signStyle, "signStyle");
        if (minWidth < 1 || minWidth > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + minWidth);
        }
        if (maxWidth < 1 || maxWidth > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + maxWidth);
        }
        if (maxWidth < minWidth) {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + maxWidth + " < " + minWidth);
        }
        NumberPrinterParser pp = new NumberPrinterParser(field, minWidth, maxWidth, signStyle);
        appendValue(pp);
        return this;
    }

    public DateTimeFormatterBuilder appendValueReduced(TemporalField field, int width, int maxWidth, int baseValue) {
        Objects.requireNonNull(field, "field");
        ReducedPrinterParser pp = new ReducedPrinterParser(field, width, maxWidth, baseValue, null);
        appendValue(pp);
        return this;
    }

    public DateTimeFormatterBuilder appendValueReduced(TemporalField field, int width, int maxWidth, ChronoLocalDate baseDate) {
        Objects.requireNonNull(field, "field");
        Objects.requireNonNull(baseDate, "baseDate");
        ReducedPrinterParser pp = new ReducedPrinterParser(field, width, maxWidth, 0, baseDate);
        appendValue(pp);
        return this;
    }

    private DateTimeFormatterBuilder appendValue(NumberPrinterParser pp) {
        NumberPrinterParser basePP;
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        if (dateTimeFormatterBuilder.valueParserIndex >= 0) {
            int activeValueParser = dateTimeFormatterBuilder.valueParserIndex;
            NumberPrinterParser basePP2 = (NumberPrinterParser) dateTimeFormatterBuilder.printerParsers.get(activeValueParser);
            if (pp.minWidth == pp.maxWidth && pp.signStyle == SignStyle.NOT_NEGATIVE) {
                basePP = basePP2.withSubsequentWidth(pp.maxWidth);
                appendInternal(pp.withFixedWidth());
                this.active.valueParserIndex = activeValueParser;
            } else {
                basePP = basePP2.withFixedWidth();
                this.active.valueParserIndex = appendInternal(pp);
            }
            this.active.printerParsers.set(activeValueParser, basePP);
        } else {
            dateTimeFormatterBuilder.valueParserIndex = appendInternal(pp);
        }
        return this;
    }

    public DateTimeFormatterBuilder appendFraction(TemporalField field, int minWidth, int maxWidth, boolean decimalPoint) {
        if (minWidth == maxWidth && !decimalPoint) {
            appendValue(new FractionPrinterParser(field, minWidth, maxWidth, decimalPoint));
        } else {
            appendInternal(new FractionPrinterParser(field, minWidth, maxWidth, decimalPoint));
        }
        return this;
    }

    public DateTimeFormatterBuilder appendText(TemporalField field) {
        return appendText(field, TextStyle.FULL);
    }

    public DateTimeFormatterBuilder appendText(TemporalField field, TextStyle textStyle) {
        Objects.requireNonNull(field, "field");
        Objects.requireNonNull(textStyle, "textStyle");
        appendInternal(new TextPrinterParser(field, textStyle, DateTimeTextProvider.getInstance()));
        return this;
    }

    public DateTimeFormatterBuilder appendText(TemporalField field, Map<Long, String> textLookup) {
        Objects.requireNonNull(field, "field");
        Objects.requireNonNull(textLookup, "textLookup");
        Map<Long, String> copy = new LinkedHashMap<>(textLookup);
        Map<TextStyle, Map<Long, String>> map = Collections.singletonMap(TextStyle.FULL, copy);
        final DateTimeTextProvider.LocaleStore store = new DateTimeTextProvider.LocaleStore(map);
        DateTimeTextProvider provider = new DateTimeTextProvider() { // from class: java.time.format.DateTimeFormatterBuilder.1
            @Override // java.time.format.DateTimeTextProvider
            public String getText(Chronology chrono, TemporalField field2, long value, TextStyle style, Locale locale) {
                return store.getText(value, style);
            }

            @Override // java.time.format.DateTimeTextProvider
            public String getText(TemporalField field2, long value, TextStyle style, Locale locale) {
                return store.getText(value, style);
            }

            @Override // java.time.format.DateTimeTextProvider
            public Iterator<Map.Entry<String, Long>> getTextIterator(Chronology chrono, TemporalField field2, TextStyle style, Locale locale) {
                return store.getTextIterator(style);
            }

            @Override // java.time.format.DateTimeTextProvider
            public Iterator<Map.Entry<String, Long>> getTextIterator(TemporalField field2, TextStyle style, Locale locale) {
                return store.getTextIterator(style);
            }
        };
        appendInternal(new TextPrinterParser(field, TextStyle.FULL, provider));
        return this;
    }

    public DateTimeFormatterBuilder appendInstant() {
        appendInternal(new InstantPrinterParser(-2));
        return this;
    }

    public DateTimeFormatterBuilder appendInstant(int fractionalDigits) {
        if (fractionalDigits < -1 || fractionalDigits > 9) {
            throw new IllegalArgumentException("The fractional digits must be from -1 to 9 inclusive but was " + fractionalDigits);
        }
        appendInternal(new InstantPrinterParser(fractionalDigits));
        return this;
    }

    public DateTimeFormatterBuilder appendOffsetId() {
        appendInternal(OffsetIdPrinterParser.INSTANCE_ID_Z);
        return this;
    }

    public DateTimeFormatterBuilder appendOffset(String pattern, String noOffsetText) {
        appendInternal(new OffsetIdPrinterParser(pattern, noOffsetText));
        return this;
    }

    public DateTimeFormatterBuilder appendLocalizedOffset(TextStyle style) {
        Objects.requireNonNull(style, "style");
        if (style != TextStyle.FULL && style != TextStyle.SHORT) {
            throw new IllegalArgumentException("Style must be either full or short");
        }
        appendInternal(new LocalizedOffsetIdPrinterParser(style));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneId() {
        appendInternal(new ZoneIdPrinterParser(TemporalQueries.zoneId(), "ZoneId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneRegionId() {
        appendInternal(new ZoneIdPrinterParser(QUERY_REGION_ONLY, "ZoneRegionId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneOrOffsetId() {
        appendInternal(new ZoneIdPrinterParser(TemporalQueries.zone(), "ZoneOrOffsetId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneText(TextStyle textStyle) {
        appendInternal(new ZoneTextPrinterParser(textStyle, null, false));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneText(TextStyle textStyle, Set<ZoneId> preferredZones) {
        Objects.requireNonNull(preferredZones, "preferredZones");
        appendInternal(new ZoneTextPrinterParser(textStyle, preferredZones, false));
        return this;
    }

    public DateTimeFormatterBuilder appendGenericZoneText(TextStyle textStyle) {
        appendInternal(new ZoneTextPrinterParser(textStyle, null, true));
        return this;
    }

    public DateTimeFormatterBuilder appendGenericZoneText(TextStyle textStyle, Set<ZoneId> preferredZones) {
        appendInternal(new ZoneTextPrinterParser(textStyle, preferredZones, true));
        return this;
    }

    public DateTimeFormatterBuilder appendChronologyId() {
        appendInternal(new ChronoPrinterParser(null));
        return this;
    }

    public DateTimeFormatterBuilder appendChronologyText(TextStyle textStyle) {
        Objects.requireNonNull(textStyle, "textStyle");
        appendInternal(new ChronoPrinterParser(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder appendLocalized(FormatStyle dateStyle, FormatStyle timeStyle) {
        if (dateStyle == null && timeStyle == null) {
            throw new IllegalArgumentException("Either the date or time style must be non-null");
        }
        appendInternal(new LocalizedPrinterParser(dateStyle, timeStyle));
        return this;
    }

    public DateTimeFormatterBuilder appendLiteral(char literal) {
        appendInternal(new CharLiteralPrinterParser(literal));
        return this;
    }

    public DateTimeFormatterBuilder appendLiteral(String literal) {
        Objects.requireNonNull(literal, "literal");
        if (!literal.isEmpty()) {
            if (literal.length() == 1) {
                appendInternal(new CharLiteralPrinterParser(literal.charAt(0)));
            } else {
                appendInternal(new StringLiteralPrinterParser(literal));
            }
        }
        return this;
    }

    public DateTimeFormatterBuilder append(DateTimeFormatter formatter) {
        Objects.requireNonNull(formatter, "formatter");
        appendInternal(formatter.toPrinterParser(false));
        return this;
    }

    public DateTimeFormatterBuilder appendOptional(DateTimeFormatter formatter) {
        Objects.requireNonNull(formatter, "formatter");
        appendInternal(formatter.toPrinterParser(true));
        return this;
    }

    public DateTimeFormatterBuilder appendPattern(String pattern) {
        Objects.requireNonNull(pattern, "pattern");
        parsePattern(pattern);
        return this;
    }

    private void parsePattern(String pattern) {
        int start = 0;
        while (start < pattern.length()) {
            char cur = pattern.charAt(start);
            if ((cur >= 'A' && cur <= 'Z') || (cur >= 'a' && cur <= 'z')) {
                int pos = start + 1;
                while (pos < pattern.length() && pattern.charAt(pos) == cur) {
                    pos++;
                }
                int count = pos - start;
                if (cur == 'p') {
                    int pad = 0;
                    if (pos < pattern.length() && (((cur = pattern.charAt(pos)) >= 'A' && cur <= 'Z') || (cur >= 'a' && cur <= 'z'))) {
                        pad = count;
                        int pos2 = pos + 1;
                        int start2 = pos;
                        while (pos2 < pattern.length() && pattern.charAt(pos2) == cur) {
                            pos2++;
                        }
                        pos = pos2;
                        count = pos2 - start2;
                    }
                    if (pad == 0) {
                        throw new IllegalArgumentException("Pad letter 'p' must be followed by valid pad pattern: " + pattern);
                    }
                    padNext(pad);
                }
                TemporalField field = FIELD_MAP.get(Character.valueOf(cur));
                if (field != null) {
                    parseField(cur, count, field);
                } else if (cur == 'z') {
                    if (count > 4) {
                        throw new IllegalArgumentException("Too many pattern letters: " + cur);
                    }
                    if (count == 4) {
                        appendZoneText(TextStyle.FULL);
                    } else {
                        appendZoneText(TextStyle.SHORT);
                    }
                } else if (cur == 'V') {
                    if (count != 2) {
                        throw new IllegalArgumentException("Pattern letter count must be 2: " + cur);
                    }
                    appendZoneId();
                } else if (cur != 'v') {
                    String str = "+0000";
                    if (cur == 'Z') {
                        if (count < 4) {
                            appendOffset("+HHMM", "+0000");
                        } else if (count == 4) {
                            appendLocalizedOffset(TextStyle.FULL);
                        } else if (count == 5) {
                            appendOffset("+HH:MM:ss", "Z");
                        } else {
                            throw new IllegalArgumentException("Too many pattern letters: " + cur);
                        }
                    } else if (cur == 'O') {
                        if (count == 1) {
                            appendLocalizedOffset(TextStyle.SHORT);
                        } else if (count == 4) {
                            appendLocalizedOffset(TextStyle.FULL);
                        } else {
                            throw new IllegalArgumentException("Pattern letter count must be 1 or 4: " + cur);
                        }
                    } else {
                        if (cur == 'X') {
                            if (count <= 5) {
                                appendOffset(OffsetIdPrinterParser.PATTERNS[(count != 1 ? 1 : 0) + count], "Z");
                            } else {
                                throw new IllegalArgumentException("Too many pattern letters: " + cur);
                            }
                        } else if (cur == 'x') {
                            if (count > 5) {
                                throw new IllegalArgumentException("Too many pattern letters: " + cur);
                            }
                            if (count == 1) {
                                str = "+00";
                            } else if (count % 2 != 0) {
                                str = "+00:00";
                            }
                            String zero = str;
                            appendOffset(OffsetIdPrinterParser.PATTERNS[(count != 1 ? 1 : 0) + count], zero);
                        } else if (cur == 'W') {
                            if (count > 1) {
                                throw new IllegalArgumentException("Too many pattern letters: " + cur);
                            }
                            appendValue(new WeekBasedFieldPrinterParser(cur, count, count, count));
                        } else if (cur == 'w') {
                            if (count > 2) {
                                throw new IllegalArgumentException("Too many pattern letters: " + cur);
                            }
                            appendValue(new WeekBasedFieldPrinterParser(cur, count, count, 2));
                        } else if (cur == 'Y') {
                            if (count == 2) {
                                appendValue(new WeekBasedFieldPrinterParser(cur, count, count, 2));
                            } else {
                                appendValue(new WeekBasedFieldPrinterParser(cur, count, count, 19));
                            }
                        } else {
                            throw new IllegalArgumentException("Unknown pattern letter: " + cur);
                        }
                    }
                } else if (count == 1) {
                    appendGenericZoneText(TextStyle.SHORT);
                } else if (count == 4) {
                    appendGenericZoneText(TextStyle.FULL);
                } else {
                    throw new IllegalArgumentException("Wrong number of pattern letters: " + cur);
                }
                start = pos - 1;
            } else if (cur == '\'') {
                int pos3 = start + 1;
                while (pos3 < pattern.length()) {
                    if (pattern.charAt(pos3) == '\'') {
                        if (pos3 + 1 >= pattern.length() || pattern.charAt(pos3 + 1) != '\'') {
                            break;
                        } else {
                            pos3++;
                        }
                    }
                    pos3++;
                }
                if (pos3 >= pattern.length()) {
                    throw new IllegalArgumentException("Pattern ends with an incomplete string literal: " + pattern);
                }
                String str2 = pattern.substring(start + 1, pos3);
                if (!str2.isEmpty()) {
                    appendLiteral(str2.replace("''", "'"));
                } else {
                    appendLiteral('\'');
                }
                start = pos3;
            } else if (cur == '[') {
                optionalStart();
            } else if (cur == ']') {
                if (this.active.parent == null) {
                    throw new IllegalArgumentException("Pattern invalid as it contains ] without previous [");
                }
                optionalEnd();
            } else {
                if (cur == '{' || cur == '}' || cur == '#') {
                    throw new IllegalArgumentException("Pattern includes reserved character: '" + cur + "'");
                }
                appendLiteral(cur);
            }
            start++;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parseField(char r6, int r7, java.time.temporal.TemporalField r8) {
        /*
            Method dump skipped, instructions count: 504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.time.format.DateTimeFormatterBuilder.parseField(char, int, java.time.temporal.TemporalField):void");
    }

    public DateTimeFormatterBuilder padNext(int padWidth) {
        return padNext(padWidth, ' ');
    }

    public DateTimeFormatterBuilder padNext(int padWidth, char padChar) {
        if (padWidth < 1) {
            throw new IllegalArgumentException("The pad width must be at least one but was " + padWidth);
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        dateTimeFormatterBuilder.padNextWidth = padWidth;
        dateTimeFormatterBuilder.padNextChar = padChar;
        dateTimeFormatterBuilder.valueParserIndex = -1;
        return this;
    }

    public DateTimeFormatterBuilder optionalStart() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        dateTimeFormatterBuilder.valueParserIndex = -1;
        this.active = new DateTimeFormatterBuilder(dateTimeFormatterBuilder, true);
        return this;
    }

    public DateTimeFormatterBuilder optionalEnd() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        if (dateTimeFormatterBuilder.parent == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (dateTimeFormatterBuilder.printerParsers.size() > 0) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
            CompositePrinterParser cpp = new CompositePrinterParser(dateTimeFormatterBuilder2.printerParsers, dateTimeFormatterBuilder2.optional);
            this.active = this.active.parent;
            appendInternal(cpp);
        } else {
            this.active = this.active.parent;
        }
        return this;
    }

    private int appendInternal(DateTimePrinterParser pp) {
        Objects.requireNonNull(pp, "pp");
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        int i10 = dateTimeFormatterBuilder.padNextWidth;
        if (i10 > 0) {
            pp = new PadPrinterParserDecorator(pp, i10, dateTimeFormatterBuilder.padNextChar);
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
            dateTimeFormatterBuilder2.padNextWidth = 0;
            dateTimeFormatterBuilder2.padNextChar = (char) 0;
        }
        this.active.printerParsers.add(pp);
        this.active.valueParserIndex = -1;
        return r0.printerParsers.size() - 1;
    }

    public DateTimeFormatter toFormatter() {
        return toFormatter(Locale.getDefault(Locale.Category.FORMAT));
    }

    public DateTimeFormatter toFormatter(Locale locale) {
        return toFormatter(locale, ResolverStyle.SMART, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DateTimeFormatter toFormatter(ResolverStyle resolverStyle, Chronology chrono) {
        return toFormatter(Locale.getDefault(Locale.Category.FORMAT), resolverStyle, chrono);
    }

    private DateTimeFormatter toFormatter(Locale locale, ResolverStyle resolverStyle, Chronology chrono) {
        Objects.requireNonNull(locale, "locale");
        while (this.active.parent != null) {
            optionalEnd();
        }
        CompositePrinterParser pp = new CompositePrinterParser(this.printerParsers, false);
        return new DateTimeFormatter(pp, locale, DecimalStyle.STANDARD, resolverStyle, null, chrono, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class CompositePrinterParser implements DateTimePrinterParser {
        private final boolean optional;
        private final DateTimePrinterParser[] printerParsers;

        CompositePrinterParser(List<DateTimePrinterParser> printerParsers, boolean optional) {
            this((DateTimePrinterParser[]) printerParsers.toArray(new DateTimePrinterParser[0]), optional);
        }

        CompositePrinterParser(DateTimePrinterParser[] printerParsers, boolean optional) {
            this.printerParsers = printerParsers;
            this.optional = optional;
        }

        public CompositePrinterParser withOptional(boolean optional) {
            if (optional == this.optional) {
                return this;
            }
            return new CompositePrinterParser(this.printerParsers, optional);
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext context, StringBuilder buf) {
            int length = buf.length();
            if (this.optional) {
                context.startOptional();
            }
            try {
                for (DateTimePrinterParser pp : this.printerParsers) {
                    if (!pp.format(context, buf)) {
                        buf.setLength(length);
                        return true;
                    }
                }
                if (this.optional) {
                    context.endOptional();
                }
                return true;
            } finally {
                if (this.optional) {
                    context.endOptional();
                }
            }
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext context, CharSequence text, int position) {
            if (this.optional) {
                context.startOptional();
                int pos = position;
                for (DateTimePrinterParser pp : this.printerParsers) {
                    pos = pp.parse(context, text, pos);
                    if (pos < 0) {
                        context.endOptional(false);
                        return position;
                    }
                }
                context.endOptional(true);
                return pos;
            }
            for (DateTimePrinterParser pp2 : this.printerParsers) {
                position = pp2.parse(context, text, position);
                if (position < 0) {
                    break;
                }
            }
            return position;
        }

        public String toString() {
            StringBuilder buf = new StringBuilder();
            if (this.printerParsers != null) {
                buf.append(this.optional ? "[" : "(");
                for (DateTimePrinterParser pp : this.printerParsers) {
                    buf.append((Object) pp);
                }
                buf.append(this.optional ? "]" : ")");
            }
            return buf.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class PadPrinterParserDecorator implements DateTimePrinterParser {
        private final char padChar;
        private final int padWidth;
        private final DateTimePrinterParser printerParser;

        PadPrinterParserDecorator(DateTimePrinterParser printerParser, int padWidth, char padChar) {
            this.printerParser = printerParser;
            this.padWidth = padWidth;
            this.padChar = padChar;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext context, StringBuilder buf) {
            int preLen = buf.length();
            if (!this.printerParser.format(context, buf)) {
                return false;
            }
            int len = buf.length() - preLen;
            if (len > this.padWidth) {
                throw new DateTimeException("Cannot print as output of " + len + " characters exceeds pad width of " + this.padWidth);
            }
            for (int i10 = 0; i10 < this.padWidth - len; i10++) {
                buf.insert(preLen, this.padChar);
            }
            return true;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext context, CharSequence text, int position) {
            boolean strict = context.isStrict();
            if (position > text.length()) {
                throw new IndexOutOfBoundsException();
            }
            if (position == text.length()) {
                return ~position;
            }
            int endPos = this.padWidth + position;
            if (endPos > text.length()) {
                if (strict) {
                    return ~position;
                }
                endPos = text.length();
            }
            int pos = position;
            while (pos < endPos && context.charEquals(text.charAt(pos), this.padChar)) {
                pos++;
            }
            int resultPos = this.printerParser.parse(context, text.subSequence(0, endPos), pos);
            if (resultPos != endPos && strict) {
                return ~(position + pos);
            }
            return resultPos;
        }

        public String toString() {
            return "Pad(" + ((Object) this.printerParser) + "," + this.padWidth + (this.padChar == ' ' ? ")" : ",'" + this.padChar + "')");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public enum SettingsParser implements DateTimePrinterParser {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext context, StringBuilder buf) {
            return true;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0019, code lost:
        
            return r6;
         */
        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int parse(java.time.format.DateTimeParseContext r4, java.lang.CharSequence r5, int r6) {
            /*
                r3 = this;
                int r0 = r3.ordinal()
                r1 = 0
                r2 = 1
                switch(r0) {
                    case 0: goto L16;
                    case 1: goto L12;
                    case 2: goto Le;
                    case 3: goto La;
                    default: goto L9;
                }
            L9:
                goto L19
            La:
                r4.setStrict(r1)
                goto L19
            Le:
                r4.setStrict(r2)
                goto L19
            L12:
                r4.setCaseSensitive(r1)
                goto L19
            L16:
                r4.setCaseSensitive(r2)
            L19:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: java.time.format.DateTimeFormatterBuilder.SettingsParser.parse(java.time.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }

        @Override // java.lang.Enum
        public String toString() {
            switch (this) {
                case SENSITIVE:
                    return "ParseCaseSensitive(true)";
                case INSENSITIVE:
                    return "ParseCaseSensitive(false)";
                case STRICT:
                    return "ParseStrict(true)";
                case LENIENT:
                    return "ParseStrict(false)";
                default:
                    throw new IllegalStateException("Unreachable");
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static class DefaultValueParser implements DateTimePrinterParser {
        private final TemporalField field;
        private final long value;

        DefaultValueParser(TemporalField field, long value) {
            this.field = field;
            this.value = value;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext context, StringBuilder buf) {
            return true;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext context, CharSequence text, int position) {
            if (context.getParsed(this.field) == null) {
                context.setParsedField(this.field, this.value, position, position);
            }
            return position;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class CharLiteralPrinterParser implements DateTimePrinterParser {
        private final char literal;

        CharLiteralPrinterParser(char literal) {
            this.literal = literal;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext context, StringBuilder buf) {
            buf.append(this.literal);
            return true;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext context, CharSequence text, int position) {
            int length = text.length();
            if (position == length) {
                return ~position;
            }
            char ch = text.charAt(position);
            if (ch != this.literal && (context.isCaseSensitive() || (Character.toUpperCase(ch) != Character.toUpperCase(this.literal) && Character.toLowerCase(ch) != Character.toLowerCase(this.literal)))) {
                return ~position;
            }
            return position + 1;
        }

        public String toString() {
            if (this.literal == '\'') {
                return "''";
            }
            return "'" + this.literal + "'";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class StringLiteralPrinterParser implements DateTimePrinterParser {
        private final String literal;

        StringLiteralPrinterParser(String literal) {
            this.literal = literal;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext context, StringBuilder buf) {
            buf.append(this.literal);
            return true;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext context, CharSequence text, int position) {
            int length = text.length();
            if (position > length || position < 0) {
                throw new IndexOutOfBoundsException();
            }
            String str = this.literal;
            if (!context.subSequenceEquals(text, position, str, 0, str.length())) {
                return ~position;
            }
            return this.literal.length() + position;
        }

        public String toString() {
            String converted = this.literal.replace("'", "''");
            return "'" + converted + "'";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class NumberPrinterParser implements DateTimePrinterParser {
        static final long[] EXCEED_POINTS = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, RealConnection.IDLE_CONNECTION_HEALTHY_NS};
        final TemporalField field;
        final int maxWidth;
        final int minWidth;
        private final SignStyle signStyle;
        final int subsequentWidth;

        NumberPrinterParser(TemporalField field, int minWidth, int maxWidth, SignStyle signStyle) {
            this.field = field;
            this.minWidth = minWidth;
            this.maxWidth = maxWidth;
            this.signStyle = signStyle;
            this.subsequentWidth = 0;
        }

        protected NumberPrinterParser(TemporalField field, int minWidth, int maxWidth, SignStyle signStyle, int subsequentWidth) {
            this.field = field;
            this.minWidth = minWidth;
            this.maxWidth = maxWidth;
            this.signStyle = signStyle;
            this.subsequentWidth = subsequentWidth;
        }

        NumberPrinterParser withFixedWidth() {
            if (this.subsequentWidth == -1) {
                return this;
            }
            return new NumberPrinterParser(this.field, this.minWidth, this.maxWidth, this.signStyle, -1);
        }

        NumberPrinterParser withSubsequentWidth(int subsequentWidth) {
            return new NumberPrinterParser(this.field, this.minWidth, this.maxWidth, this.signStyle, this.subsequentWidth + subsequentWidth);
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext context, StringBuilder buf) {
            Long valueLong = context.getValue(this.field);
            if (valueLong == null) {
                return false;
            }
            long value = getValue(context, valueLong.longValue());
            DecimalStyle decimalStyle = context.getDecimalStyle();
            String str = value == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(value));
            if (str.length() > this.maxWidth) {
                throw new DateTimeException("Field " + ((Object) this.field) + " cannot be printed as the value " + value + " exceeds the maximum print width of " + this.maxWidth);
            }
            String str2 = decimalStyle.convertNumberToI18N(str);
            if (value >= 0) {
                switch (AnonymousClass2.$SwitchMap$java$time$format$SignStyle[this.signStyle.ordinal()]) {
                    case 1:
                        int i10 = this.minWidth;
                        if (i10 < 19 && value >= EXCEED_POINTS[i10]) {
                            buf.append(decimalStyle.getPositiveSign());
                            break;
                        }
                        break;
                    case 2:
                        buf.append(decimalStyle.getPositiveSign());
                        break;
                }
            } else {
                switch (AnonymousClass2.$SwitchMap$java$time$format$SignStyle[this.signStyle.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        buf.append(decimalStyle.getNegativeSign());
                        break;
                    case 4:
                        throw new DateTimeException("Field " + ((Object) this.field) + " cannot be printed as the value " + value + " cannot be negative according to the SignStyle");
                }
            }
            for (int i11 = 0; i11 < this.minWidth - str2.length(); i11++) {
                buf.append(decimalStyle.getZeroDigit());
            }
            buf.append(str2);
            return true;
        }

        long getValue(DateTimePrintContext context, long value) {
            return value;
        }

        boolean isFixedWidth(DateTimeParseContext context) {
            int i10 = this.subsequentWidth;
            return i10 == -1 || (i10 > 0 && this.minWidth == this.maxWidth && this.signStyle == SignStyle.NOT_NEGATIVE);
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext context, CharSequence text, int position) {
            int position2;
            boolean negative;
            boolean positive;
            int pos;
            long total;
            BigInteger totalBig;
            long total2;
            int length;
            char sign;
            char sign2;
            int length2 = text.length();
            if (position == length2) {
                return ~position;
            }
            char sign3 = text.charAt(position);
            if (sign3 == context.getDecimalStyle().getPositiveSign()) {
                if (!this.signStyle.parse(true, context.isStrict(), this.minWidth == this.maxWidth)) {
                    return ~position;
                }
                position2 = position + 1;
                negative = false;
                positive = true;
            } else if (sign3 == context.getDecimalStyle().getNegativeSign()) {
                if (!this.signStyle.parse(false, context.isStrict(), this.minWidth == this.maxWidth)) {
                    return ~position;
                }
                position2 = position + 1;
                negative = true;
                positive = false;
            } else {
                if (this.signStyle == SignStyle.ALWAYS && context.isStrict()) {
                    return ~position;
                }
                position2 = position;
                negative = false;
                positive = false;
            }
            int effMinWidth = (context.isStrict() || isFixedWidth(context)) ? this.minWidth : 1;
            int minEndPos = position2 + effMinWidth;
            if (minEndPos <= length2) {
                int effMaxWidth = ((context.isStrict() || isFixedWidth(context)) ? this.maxWidth : 9) + Math.max(this.subsequentWidth, 0);
                long total3 = 0;
                BigInteger totalBig2 = null;
                int pos2 = position2;
                int pass = 0;
                int effMaxWidth2 = effMaxWidth;
                while (pass < 2) {
                    int digit = Math.min(pos2 + effMaxWidth2, length2);
                    while (true) {
                        if (pos2 >= digit) {
                            total2 = total3;
                            length = length2;
                            sign = sign3;
                            break;
                        }
                        int pos3 = pos2 + 1;
                        length = length2;
                        char ch = text.charAt(pos2);
                        int maxEndPos = digit;
                        int digit2 = context.getDecimalStyle().convertToDigit(ch);
                        if (digit2 < 0) {
                            int pos4 = pos3 - 1;
                            if (pos4 < minEndPos) {
                                return ~position2;
                            }
                            total2 = total3;
                            sign = sign3;
                            pos2 = pos4;
                        } else {
                            if (pos3 - position2 > 18) {
                                if (totalBig2 == null) {
                                    totalBig2 = BigInteger.valueOf(total3);
                                }
                                sign2 = sign3;
                                totalBig2 = totalBig2.multiply(BigInteger.TEN).add(BigInteger.valueOf(digit2));
                            } else {
                                sign2 = sign3;
                                long j10 = 10 * total3;
                                long total4 = digit2;
                                total3 = total4 + j10;
                            }
                            digit = maxEndPos;
                            pos2 = pos3;
                            length2 = length;
                            sign3 = sign2;
                        }
                    }
                    int maxEndPos2 = this.subsequentWidth;
                    if (maxEndPos2 > 0 && pass == 0) {
                        effMaxWidth2 = Math.max(effMinWidth, (pos2 - position2) - maxEndPos2);
                        pos2 = position2;
                        totalBig2 = null;
                        pass++;
                        total3 = 0;
                        length2 = length;
                        sign3 = sign;
                    } else {
                        pos = pos2;
                        total3 = total2;
                        break;
                    }
                }
                pos = pos2;
                if (negative) {
                    if (totalBig2 != null) {
                        if (totalBig2.equals(BigInteger.ZERO) && context.isStrict()) {
                            return ~(position2 - 1);
                        }
                        total = total3;
                        totalBig = totalBig2.negate();
                    } else {
                        if (total3 == 0 && context.isStrict()) {
                            return ~(position2 - 1);
                        }
                        total = -total3;
                        totalBig = totalBig2;
                    }
                } else {
                    if (this.signStyle == SignStyle.EXCEEDS_PAD && context.isStrict()) {
                        int parseLen = pos - position2;
                        if (positive) {
                            if (parseLen <= this.minWidth) {
                                return ~(position2 - 1);
                            }
                        } else if (parseLen > this.minWidth) {
                            return ~position2;
                        }
                    }
                    total = total3;
                    totalBig = totalBig2;
                }
                if (totalBig != null) {
                    if (totalBig.bitLength() > 63) {
                        totalBig = totalBig.divide(BigInteger.TEN);
                        pos--;
                    }
                    return setValue(context, totalBig.longValue(), position2, pos);
                }
                return setValue(context, total, position2, pos);
            }
            return ~position2;
        }

        int setValue(DateTimeParseContext context, long value, int errorPos, int successPos) {
            return context.setParsedField(this.field, value, errorPos, successPos);
        }

        public String toString() {
            if (this.minWidth == 1 && this.maxWidth == 19 && this.signStyle == SignStyle.NORMAL) {
                return "Value(" + ((Object) this.field) + ")";
            }
            if (this.minWidth == this.maxWidth && this.signStyle == SignStyle.NOT_NEGATIVE) {
                return "Value(" + ((Object) this.field) + "," + this.minWidth + ")";
            }
            return "Value(" + ((Object) this.field) + "," + this.minWidth + "," + this.maxWidth + "," + ((Object) this.signStyle) + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.time.format.DateTimeFormatterBuilder$2, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$java$time$format$SignStyle;

        static {
            int[] iArr = new int[SignStyle.values().length];
            $SwitchMap$java$time$format$SignStyle = iArr;
            try {
                iArr[SignStyle.EXCEEDS_PAD.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$time$format$SignStyle[SignStyle.ALWAYS.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$time$format$SignStyle[SignStyle.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$java$time$format$SignStyle[SignStyle.NOT_NEGATIVE.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class ReducedPrinterParser extends NumberPrinterParser {
        static final LocalDate BASE_DATE = LocalDate.of(2000, 1, 1);
        private final ChronoLocalDate baseDate;
        private final int baseValue;

        ReducedPrinterParser(TemporalField field, int minWidth, int maxWidth, int baseValue, ChronoLocalDate baseDate) {
            this(field, minWidth, maxWidth, baseValue, baseDate, 0);
            if (minWidth < 1 || minWidth > 10) {
                throw new IllegalArgumentException("The minWidth must be from 1 to 10 inclusive but was " + minWidth);
            }
            if (maxWidth < 1 || maxWidth > 10) {
                throw new IllegalArgumentException("The maxWidth must be from 1 to 10 inclusive but was " + minWidth);
            }
            if (maxWidth < minWidth) {
                throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + maxWidth + " < " + minWidth);
            }
            if (baseDate == null) {
                if (!field.range().isValidValue(baseValue)) {
                    throw new IllegalArgumentException("The base value must be within the range of the field");
                }
                if (baseValue + EXCEED_POINTS[maxWidth] > ZipUtils.UPPER_UNIXTIME_BOUND) {
                    throw new DateTimeException("Unable to add printer-parser as the range exceeds the capacity of an int");
                }
            }
        }

        private ReducedPrinterParser(TemporalField field, int minWidth, int maxWidth, int baseValue, ChronoLocalDate baseDate, int subsequentWidth) {
            super(field, minWidth, maxWidth, SignStyle.NOT_NEGATIVE, subsequentWidth);
            this.baseValue = baseValue;
            this.baseDate = baseDate;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        long getValue(DateTimePrintContext context, long value) {
            long absValue = Math.abs(value);
            int baseValue = this.baseValue;
            if (this.baseDate != null) {
                Chronology chrono = Chronology.from(context.getTemporal());
                baseValue = chrono.date(this.baseDate).get(this.field);
            }
            if (value >= baseValue && value < baseValue + EXCEED_POINTS[this.minWidth]) {
                return absValue % EXCEED_POINTS[this.minWidth];
            }
            return absValue % EXCEED_POINTS[this.maxWidth];
        }

        @Override // java.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        int setValue(final DateTimeParseContext context, final long value, final int errorPos, final int successPos) {
            long range;
            long value2;
            int baseValue = this.baseValue;
            if (this.baseDate != null) {
                Chronology chrono = context.getEffectiveChronology();
                int baseValue2 = chrono.date(this.baseDate).get(this.field);
                context.addChronoChangedListener(new Consumer() { // from class: java.time.format.DateTimeFormatterBuilder$ReducedPrinterParser$$ExternalSyntheticLambda0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        DateTimeFormatterBuilder.ReducedPrinterParser.this.lambda$setValue$0(context, value, errorPos, successPos, (Chronology) obj);
                    }
                });
                baseValue = baseValue2;
            }
            int parseLen = successPos - errorPos;
            if (parseLen == this.minWidth && value >= 0) {
                long range2 = EXCEED_POINTS[this.minWidth];
                long lastPart = baseValue % range2;
                long basePart = baseValue - lastPart;
                if (baseValue > 0) {
                    value2 = basePart + value;
                } else {
                    value2 = basePart - value;
                }
                if (value2 >= baseValue) {
                    range = value2;
                } else {
                    range = value2 + range2;
                }
            } else {
                range = value;
            }
            return context.setParsedField(this.field, range, errorPos, successPos);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setValue$0(DateTimeParseContext context, long initialValue, int errorPos, int successPos, Chronology _unused) {
            setValue(context, initialValue, errorPos, successPos);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // java.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        public ReducedPrinterParser withFixedWidth() {
            if (this.subsequentWidth == -1) {
                return this;
            }
            return new ReducedPrinterParser(this.field, this.minWidth, this.maxWidth, this.baseValue, this.baseDate, -1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // java.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        public ReducedPrinterParser withSubsequentWidth(int subsequentWidth) {
            return new ReducedPrinterParser(this.field, this.minWidth, this.maxWidth, this.baseValue, this.baseDate, this.subsequentWidth + subsequentWidth);
        }

        @Override // java.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        boolean isFixedWidth(DateTimeParseContext context) {
            if (!context.isStrict()) {
                return false;
            }
            return super.isFixedWidth(context);
        }

        @Override // java.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        public String toString() {
            return "ReducedValue(" + ((Object) this.field) + "," + this.minWidth + "," + this.maxWidth + "," + Objects.requireNonNullElse(this.baseDate, Integer.valueOf(this.baseValue)) + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class FractionPrinterParser extends NumberPrinterParser {
        private final boolean decimalPoint;

        FractionPrinterParser(TemporalField field, int minWidth, int maxWidth, boolean decimalPoint) {
            this(field, minWidth, maxWidth, decimalPoint, 0);
            Objects.requireNonNull(field, "field");
            if (!field.range().isFixed()) {
                throw new IllegalArgumentException("Field must have a fixed set of values: " + ((Object) field));
            }
            if (minWidth < 0 || minWidth > 9) {
                throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + minWidth);
            }
            if (maxWidth < 1 || maxWidth > 9) {
                throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + maxWidth);
            }
            if (maxWidth < minWidth) {
                throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + maxWidth + " < " + minWidth);
            }
        }

        FractionPrinterParser(TemporalField field, int minWidth, int maxWidth, boolean decimalPoint, int subsequentWidth) {
            super(field, minWidth, maxWidth, SignStyle.NOT_NEGATIVE, subsequentWidth);
            this.decimalPoint = decimalPoint;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // java.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        public FractionPrinterParser withFixedWidth() {
            if (this.subsequentWidth == -1) {
                return this;
            }
            return new FractionPrinterParser(this.field, this.minWidth, this.maxWidth, this.decimalPoint, -1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // java.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        public FractionPrinterParser withSubsequentWidth(int subsequentWidth) {
            return new FractionPrinterParser(this.field, this.minWidth, this.maxWidth, this.decimalPoint, this.subsequentWidth + subsequentWidth);
        }

        @Override // java.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        boolean isFixedWidth(DateTimeParseContext context) {
            if (context.isStrict() && this.minWidth == this.maxWidth && !this.decimalPoint) {
                return true;
            }
            return false;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.NumberPrinterParser, java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext context, StringBuilder buf) {
            Long value = context.getValue(this.field);
            if (value == null) {
                return false;
            }
            DecimalStyle decimalStyle = context.getDecimalStyle();
            BigDecimal fraction = convertToFraction(value.longValue());
            if (fraction.scale() == 0) {
                if (this.minWidth > 0) {
                    if (this.decimalPoint) {
                        buf.append(decimalStyle.getDecimalSeparator());
                    }
                    for (int i10 = 0; i10 < this.minWidth; i10++) {
                        buf.append(decimalStyle.getZeroDigit());
                    }
                    return true;
                }
                return true;
            }
            int outputScale = Math.min(Math.max(fraction.scale(), this.minWidth), this.maxWidth);
            String str = fraction.setScale(outputScale, RoundingMode.FLOOR).toPlainString().substring(2);
            String str2 = decimalStyle.convertNumberToI18N(str);
            if (this.decimalPoint) {
                buf.append(decimalStyle.getDecimalSeparator());
            }
            buf.append(str2);
            return true;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.NumberPrinterParser, java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext context, CharSequence text, int position) {
            int pos;
            int position2 = position;
            int effectiveMin = (context.isStrict() || isFixedWidth(context)) ? this.minWidth : 0;
            int effectiveMax = (context.isStrict() || isFixedWidth(context)) ? this.maxWidth : 9;
            int length = text.length();
            if (position2 == length) {
                return effectiveMin > 0 ? ~position2 : position2;
            }
            if (this.decimalPoint) {
                if (text.charAt(position) != context.getDecimalStyle().getDecimalSeparator()) {
                    return effectiveMin > 0 ? ~position2 : position2;
                }
                position2++;
            }
            int minEndPos = position2 + effectiveMin;
            if (minEndPos > length) {
                return ~position2;
            }
            int maxEndPos = Math.min(position2 + effectiveMax, length);
            int pos2 = position2;
            int total = 0;
            while (true) {
                if (pos2 >= maxEndPos) {
                    pos = pos2;
                    break;
                }
                int pos3 = pos2 + 1;
                char ch = text.charAt(pos2);
                int digit = context.getDecimalStyle().convertToDigit(ch);
                if (digit < 0) {
                    if (pos3 <= minEndPos) {
                        return ~position2;
                    }
                    pos = pos3 - 1;
                } else {
                    total = (total * 10) + digit;
                    pos2 = pos3;
                }
            }
            BigDecimal fraction = new BigDecimal(total).movePointLeft(pos - position2);
            long value = convertFromFraction(fraction);
            return context.setParsedField(this.field, value, position2, pos);
        }

        private BigDecimal convertToFraction(long value) {
            ValueRange range = this.field.range();
            range.checkValidValue(value, this.field);
            BigDecimal minBD = BigDecimal.valueOf(range.getMinimum());
            BigDecimal rangeBD = BigDecimal.valueOf(range.getMaximum()).subtract(minBD).add(BigDecimal.ONE);
            BigDecimal valueBD = BigDecimal.valueOf(value).subtract(minBD);
            BigDecimal fraction = valueBD.divide(rangeBD, 9, RoundingMode.FLOOR);
            return fraction.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : fraction.stripTrailingZeros();
        }

        private long convertFromFraction(BigDecimal fraction) {
            ValueRange range = this.field.range();
            BigDecimal minBD = BigDecimal.valueOf(range.getMinimum());
            BigDecimal rangeBD = BigDecimal.valueOf(range.getMaximum()).subtract(minBD).add(BigDecimal.ONE);
            BigDecimal valueBD = fraction.multiply(rangeBD).setScale(0, RoundingMode.FLOOR).add(minBD);
            return valueBD.longValueExact();
        }

        @Override // java.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        public String toString() {
            String decimal = this.decimalPoint ? ",DecimalPoint" : "";
            return "Fraction(" + ((Object) this.field) + "," + this.minWidth + "," + this.maxWidth + decimal + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class TextPrinterParser implements DateTimePrinterParser {
        private final TemporalField field;
        private volatile NumberPrinterParser numberPrinterParser;
        private final DateTimeTextProvider provider;
        private final TextStyle textStyle;

        TextPrinterParser(TemporalField field, TextStyle textStyle, DateTimeTextProvider provider) {
            this.field = field;
            this.textStyle = textStyle;
            this.provider = provider;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext context, StringBuilder buf) {
            String text;
            Long value = context.getValue(this.field);
            if (value == null) {
                return false;
            }
            Chronology chrono = (Chronology) context.getTemporal().query(TemporalQueries.chronology());
            if (chrono == null || chrono == IsoChronology.INSTANCE) {
                text = this.provider.getText(this.field, value.longValue(), this.textStyle, context.getLocale());
            } else {
                text = this.provider.getText(chrono, this.field, value.longValue(), this.textStyle, context.getLocale());
            }
            if (text == null) {
                return numberPrinterParser().format(context, buf);
            }
            buf.append(text);
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
        
            if (r11 != null) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0043, code lost:
        
            if (r11.hasNext() == false) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
        
            r12 = r11.next();
            r13 = r12.getKey();
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0063, code lost:
        
            if (r17.subSequenceEquals(r13, 0, r18, r19, r13.length()) == false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x007f, code lost:
        
            return r17.setParsedField(r16.field, r12.getValue().longValue(), r19, r19 + r13.length());
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0085, code lost:
        
            if (r16.field != java.time.temporal.ChronoField.ERA) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x008b, code lost:
        
            if (r17.isStrict() != false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x008d, code lost:
        
            r12 = r10.eras();
            r13 = r12.iterator2();
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0099, code lost:
        
            if (r13.hasNext() == false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x009b, code lost:
        
            r14 = r13.next();
            r15 = r14.toString();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00b6, code lost:
        
            if (r17.subSequenceEquals(r15, 0, r18, r19, r15.length()) == false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00cd, code lost:
        
            return r17.setParsedField(r16.field, r14.getValue(), r19, r19 + r15.length());
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00d3, code lost:
        
            if (r17.isStrict() == false) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00d6, code lost:
        
            return ~r19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00e3, code lost:
        
            return numberPrinterParser().parse(r17, r18, r19);
         */
        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int parse(java.time.format.DateTimeParseContext r17, java.lang.CharSequence r18, int r19) {
            /*
                r16 = this;
                r0 = r16
                r7 = r19
                int r8 = r18.length()
                if (r7 < 0) goto Le4
                if (r7 > r8) goto Le4
                boolean r1 = r17.isStrict()
                if (r1 == 0) goto L15
                java.time.format.TextStyle r1 = r0.textStyle
                goto L16
            L15:
                r1 = 0
            L16:
                r9 = r1
                java.time.chrono.Chronology r10 = r17.getEffectiveChronology()
                if (r10 == 0) goto L30
                java.time.chrono.IsoChronology r1 = java.time.chrono.IsoChronology.INSTANCE
                if (r10 != r1) goto L22
                goto L30
            L22:
                java.time.format.DateTimeTextProvider r1 = r0.provider
                java.time.temporal.TemporalField r2 = r0.field
                java.util.Locale r3 = r17.getLocale()
                java.util.Iterator r1 = r1.getTextIterator(r10, r2, r9, r3)
                r11 = r1
                goto L3d
            L30:
                java.time.format.DateTimeTextProvider r1 = r0.provider
                java.time.temporal.TemporalField r2 = r0.field
                java.util.Locale r3 = r17.getLocale()
                java.util.Iterator r1 = r1.getTextIterator(r2, r9, r3)
                r11 = r1
            L3d:
                if (r11 == 0) goto Ld7
            L3f:
                boolean r1 = r11.hasNext()
                if (r1 == 0) goto L81
                java.lang.Object r1 = r11.next()
                r12 = r1
                java.util.Map$Entry r12 = (java.util.Map.Entry) r12
                java.lang.Object r1 = r12.getKey()
                r13 = r1
                java.lang.String r13 = (java.lang.String) r13
                r3 = 0
                int r6 = r13.length()
                r1 = r17
                r2 = r13
                r4 = r18
                r5 = r19
                boolean r1 = r1.subSequenceEquals(r2, r3, r4, r5, r6)
                if (r1 == 0) goto L80
                java.time.temporal.TemporalField r2 = r0.field
                java.lang.Object r1 = r12.getValue()
                java.lang.Long r1 = (java.lang.Long) r1
                long r3 = r1.longValue()
                int r1 = r13.length()
                int r6 = r7 + r1
                r1 = r17
                r5 = r19
                int r1 = r1.setParsedField(r2, r3, r5, r6)
                return r1
            L80:
                goto L3f
            L81:
                java.time.temporal.TemporalField r1 = r0.field
                java.time.temporal.ChronoField r2 = java.time.temporal.ChronoField.ERA
                if (r1 != r2) goto Lcf
                boolean r1 = r17.isStrict()
                if (r1 != 0) goto Lcf
                java.util.List r12 = r10.eras()
                java.util.Iterator r13 = r12.iterator2()
            L95:
                boolean r1 = r13.hasNext()
                if (r1 == 0) goto Lcf
                java.lang.Object r1 = r13.next()
                r14 = r1
                java.time.chrono.Era r14 = (java.time.chrono.Era) r14
                java.lang.String r15 = r14.toString()
                r3 = 0
                int r6 = r15.length()
                r1 = r17
                r2 = r15
                r4 = r18
                r5 = r19
                boolean r1 = r1.subSequenceEquals(r2, r3, r4, r5, r6)
                if (r1 == 0) goto Lce
                java.time.temporal.TemporalField r2 = r0.field
                int r1 = r14.getValue()
                long r3 = (long) r1
                int r1 = r15.length()
                int r6 = r7 + r1
                r1 = r17
                r5 = r19
                int r1 = r1.setParsedField(r2, r3, r5, r6)
                return r1
            Lce:
                goto L95
            Lcf:
                boolean r1 = r17.isStrict()
                if (r1 == 0) goto Ld7
                int r1 = ~r7
                return r1
            Ld7:
                java.time.format.DateTimeFormatterBuilder$NumberPrinterParser r1 = r16.numberPrinterParser()
                r2 = r17
                r3 = r18
                int r1 = r1.parse(r2, r3, r7)
                return r1
            Le4:
                r2 = r17
                r3 = r18
                java.lang.IndexOutOfBoundsException r1 = new java.lang.IndexOutOfBoundsException
                r1.<init>()
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: java.time.format.DateTimeFormatterBuilder.TextPrinterParser.parse(java.time.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }

        private NumberPrinterParser numberPrinterParser() {
            if (this.numberPrinterParser == null) {
                this.numberPrinterParser = new NumberPrinterParser(this.field, 1, 19, SignStyle.NORMAL);
            }
            return this.numberPrinterParser;
        }

        public String toString() {
            if (this.textStyle == TextStyle.FULL) {
                return "Text(" + ((Object) this.field) + ")";
            }
            return "Text(" + ((Object) this.field) + "," + ((Object) this.textStyle) + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class InstantPrinterParser implements DateTimePrinterParser {
        private static final long SECONDS_0000_TO_1970 = 62167219200L;
        private static final long SECONDS_PER_10000_YEARS = 315569520000L;
        private final int fractionalDigits;

        InstantPrinterParser(int fractionalDigits) {
            this.fractionalDigits = fractionalDigits;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext context, StringBuilder buf) {
            Long inSecs = context.getValue(ChronoField.INSTANT_SECONDS);
            Long inNanos = null;
            if (context.getTemporal().isSupported(ChronoField.NANO_OF_SECOND)) {
                inNanos = Long.valueOf(context.getTemporal().getLong(ChronoField.NANO_OF_SECOND));
            }
            if (inSecs == null) {
                return false;
            }
            long inSec = inSecs.longValue();
            int inNano = ChronoField.NANO_OF_SECOND.checkValidIntValue(inNanos != null ? inNanos.longValue() : 0L);
            if (inSec >= -62167219200L) {
                long zeroSecs = (inSec - SECONDS_PER_10000_YEARS) + SECONDS_0000_TO_1970;
                long hi = Math.floorDiv(zeroSecs, SECONDS_PER_10000_YEARS) + 1;
                LocalDateTime ldt = LocalDateTime.ofEpochSecond(Math.floorMod(zeroSecs, SECONDS_PER_10000_YEARS) - SECONDS_0000_TO_1970, 0, ZoneOffset.UTC);
                if (hi > 0) {
                    buf.append('+').append(hi);
                }
                buf.append((Object) ldt);
                if (ldt.getSecond() == 0) {
                    buf.append(":00");
                }
            } else {
                long zeroSecs2 = inSec + SECONDS_0000_TO_1970;
                long hi2 = zeroSecs2 / SECONDS_PER_10000_YEARS;
                long lo = zeroSecs2 % SECONDS_PER_10000_YEARS;
                LocalDateTime ldt2 = LocalDateTime.ofEpochSecond(lo - SECONDS_0000_TO_1970, 0, ZoneOffset.UTC);
                int pos = buf.length();
                buf.append((Object) ldt2);
                if (ldt2.getSecond() == 0) {
                    buf.append(":00");
                }
                if (hi2 < 0) {
                    if (ldt2.getYear() == -10000) {
                        buf.replace(pos, pos + 2, Long.toString(hi2 - 1));
                    } else if (lo == 0) {
                        buf.insert(pos, hi2);
                    } else {
                        buf.insert(pos + 1, Math.abs(hi2));
                    }
                }
            }
            int i10 = this.fractionalDigits;
            if ((i10 < 0 && inNano > 0) || i10 > 0) {
                buf.append('.');
                int div = 100000000;
                int i11 = 0;
                while (true) {
                    int i12 = this.fractionalDigits;
                    if ((i12 != -1 || inNano <= 0) && ((i12 != -2 || (inNano <= 0 && i11 % 3 == 0)) && i11 >= i12)) {
                        break;
                    }
                    int digit = inNano / div;
                    buf.append((char) (digit + 48));
                    inNano -= digit * div;
                    div /= 10;
                    i11++;
                }
            }
            buf.append('Z');
            return true;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext context, CharSequence text, int position) {
            int hour;
            int sec;
            int sec2;
            int i10 = this.fractionalDigits;
            int minDigits = i10 < 0 ? 0 : i10;
            if (i10 < 0) {
                i10 = 9;
            }
            int maxDigits = i10;
            CompositePrinterParser parser = new DateTimeFormatterBuilder().append(DateTimeFormatter.ISO_LOCAL_DATE).appendLiteral('T').appendValue(ChronoField.HOUR_OF_DAY, 2).appendLiteral(ShortcutConstants.SERVICES_SEPARATOR).appendValue(ChronoField.MINUTE_OF_HOUR, 2).appendLiteral(ShortcutConstants.SERVICES_SEPARATOR).appendValue(ChronoField.SECOND_OF_MINUTE, 2).appendFraction(ChronoField.NANO_OF_SECOND, minDigits, maxDigits, true).appendOffsetId().toFormatter().toPrinterParser(false);
            DateTimeParseContext newContext = context.copy();
            int pos = parser.parse(newContext, text, position);
            if (pos < 0) {
                return pos;
            }
            long yearParsed = newContext.getParsed(ChronoField.YEAR).longValue();
            int month = newContext.getParsed(ChronoField.MONTH_OF_YEAR).intValue();
            int day = newContext.getParsed(ChronoField.DAY_OF_MONTH).intValue();
            int hour2 = newContext.getParsed(ChronoField.HOUR_OF_DAY).intValue();
            int min = newContext.getParsed(ChronoField.MINUTE_OF_HOUR).intValue();
            Long secVal = newContext.getParsed(ChronoField.SECOND_OF_MINUTE);
            Long nanoVal = newContext.getParsed(ChronoField.NANO_OF_SECOND);
            int sec3 = secVal != null ? secVal.intValue() : 0;
            int nano = nanoVal != null ? nanoVal.intValue() : 0;
            int offset = newContext.getParsed(ChronoField.OFFSET_SECONDS).intValue();
            if (hour2 == 24 && min == 0 && sec3 == 0 && nano == 0) {
                hour = 0;
                sec = sec3;
                sec2 = 1;
            } else if (hour2 == 23 && min == 59 && sec3 == 60) {
                context.setParsedLeapSecond();
                hour = hour2;
                sec = 59;
                sec2 = 0;
            } else {
                hour = hour2;
                sec = sec3;
                sec2 = 0;
            }
            int year = ((int) yearParsed) % 10000;
            try {
                try {
                    LocalDateTime ldt = LocalDateTime.of(year, month, day, hour, min, sec, 0).plusDays(sec2);
                    long instantSecs = ldt.toEpochSecond(ZoneOffset.ofTotalSeconds(offset));
                    int nano2 = nano;
                    try {
                        try {
                            int successPos = context.setParsedField(ChronoField.INSTANT_SECONDS, instantSecs + Math.multiplyExact(yearParsed / 10000, SECONDS_PER_10000_YEARS), position, pos);
                            return context.setParsedField(ChronoField.NANO_OF_SECOND, nano2, position, successPos);
                        } catch (RuntimeException e2) {
                            return ~position;
                        }
                    } catch (RuntimeException e10) {
                    }
                } catch (RuntimeException e11) {
                }
            } catch (RuntimeException e12) {
            }
        }

        public String toString() {
            return "Instant()";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class OffsetIdPrinterParser implements DateTimePrinterParser {
        private final String noOffsetText;
        private final int style;
        private final int type;
        static final String[] PATTERNS = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS", "+HHmmss", "+HH:mm:ss", "+H", "+Hmm", "+H:mm", "+HMM", "+H:MM", "+HMMss", "+H:MM:ss", "+HMMSS", "+H:MM:SS", "+Hmmss", "+H:mm:ss"};
        static final OffsetIdPrinterParser INSTANCE_ID_Z = new OffsetIdPrinterParser("+HH:MM:ss", "Z");
        static final OffsetIdPrinterParser INSTANCE_ID_ZERO = new OffsetIdPrinterParser("+HH:MM:ss", "0");

        OffsetIdPrinterParser(String pattern, String noOffsetText) {
            Objects.requireNonNull(pattern, "pattern");
            Objects.requireNonNull(noOffsetText, "noOffsetText");
            int checkPattern = checkPattern(pattern);
            this.type = checkPattern;
            this.style = checkPattern % 11;
            this.noOffsetText = noOffsetText;
        }

        private int checkPattern(String pattern) {
            int i10 = 0;
            while (true) {
                String[] strArr = PATTERNS;
                if (i10 < strArr.length) {
                    if (!strArr[i10].equals(pattern)) {
                        i10++;
                    } else {
                        return i10;
                    }
                } else {
                    throw new IllegalArgumentException("Invalid zone offset pattern: " + pattern);
                }
            }
        }

        private boolean isPaddedHour() {
            return this.type < 11;
        }

        private boolean isColon() {
            int i10 = this.style;
            return i10 > 0 && i10 % 2 == 0;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext context, StringBuilder buf) {
            Long offsetSecs = context.getValue(ChronoField.OFFSET_SECONDS);
            if (offsetSecs == null) {
                return false;
            }
            int totalSecs = Math.toIntExact(offsetSecs.longValue());
            if (totalSecs == 0) {
                buf.append(this.noOffsetText);
            } else {
                int absHours = Math.abs((totalSecs / SdkConfigData.DEFAULT_REQUEST_INTERVAL) % 100);
                int absMinutes = Math.abs((totalSecs / 60) % 60);
                int absSeconds = Math.abs(totalSecs % 60);
                int bufPos = buf.length();
                int output = absHours;
                buf.append(totalSecs < 0 ? "-" : BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                if (isPaddedHour() || absHours >= 10) {
                    formatZeroPad(false, absHours, buf);
                } else {
                    buf.append((char) (absHours + 48));
                }
                int i10 = this.style;
                if ((i10 >= 3 && i10 <= 8) || ((i10 >= 9 && absSeconds > 0) || (i10 >= 1 && absMinutes > 0))) {
                    formatZeroPad(isColon(), absMinutes, buf);
                    output += absMinutes;
                    int i11 = this.style;
                    if (i11 == 7 || i11 == 8 || (i11 >= 5 && absSeconds > 0)) {
                        formatZeroPad(isColon(), absSeconds, buf);
                        output += absSeconds;
                    }
                }
                if (output == 0) {
                    buf.setLength(bufPos);
                    buf.append(this.noOffsetText);
                }
            }
            return true;
        }

        private void formatZeroPad(boolean colon, int value, StringBuilder buf) {
            buf.append(colon ? u.bD : "").append((char) ((value / 10) + 48)).append((char) ((value % 10) + 48));
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext context, CharSequence text, int position) {
            boolean isColon;
            int parseType;
            int length = text.length();
            int noOffsetLen = this.noOffsetText.length();
            if (noOffsetLen == 0) {
                if (position == length) {
                    return context.setParsedField(ChronoField.OFFSET_SECONDS, 0L, position, position);
                }
            } else {
                if (position == length) {
                    return ~position;
                }
                if (context.subSequenceEquals(text, position, this.noOffsetText, 0, noOffsetLen)) {
                    return context.setParsedField(ChronoField.OFFSET_SECONDS, 0L, position, position + noOffsetLen);
                }
            }
            char sign = text.charAt(position);
            if (sign == '+' || sign == '-') {
                int negative = sign == '-' ? -1 : 1;
                boolean isColon2 = isColon();
                boolean paddedHour = isPaddedHour();
                int[] array = new int[4];
                array[0] = position + 1;
                int parseType2 = this.type;
                if (context.isStrict()) {
                    isColon = isColon2;
                    parseType = parseType2;
                } else if (paddedHour) {
                    if (isColon2 || (parseType2 == 0 && length > position + 3 && text.charAt(position + 3) == ':')) {
                        isColon = true;
                        parseType = 10;
                    } else {
                        isColon = isColon2;
                        parseType = 9;
                    }
                } else if (isColon2 || (parseType2 == 11 && length > position + 3 && (text.charAt(position + 2) == ':' || text.charAt(position + 3) == ':'))) {
                    isColon = true;
                    parseType = 21;
                } else {
                    isColon = isColon2;
                    parseType = 20;
                }
                switch (parseType) {
                    case 0:
                    case 11:
                        parseHour(text, paddedHour, array);
                        break;
                    case 1:
                    case 2:
                    case 13:
                        parseHour(text, paddedHour, array);
                        parseMinute(text, isColon, false, array);
                        break;
                    case 3:
                    case 4:
                    case 15:
                        parseHour(text, paddedHour, array);
                        parseMinute(text, isColon, true, array);
                        break;
                    case 5:
                    case 6:
                    case 17:
                        parseHour(text, paddedHour, array);
                        parseMinute(text, isColon, true, array);
                        parseSecond(text, isColon, false, array);
                        break;
                    case 7:
                    case 8:
                    case 19:
                        parseHour(text, paddedHour, array);
                        parseMinute(text, isColon, true, array);
                        parseSecond(text, isColon, true, array);
                        break;
                    case 9:
                    case 10:
                    case 21:
                        parseHour(text, paddedHour, array);
                        parseOptionalMinuteSecond(text, isColon, array);
                        break;
                    case 12:
                        parseVariableWidthDigits(text, 1, 4, array);
                        break;
                    case 14:
                        parseVariableWidthDigits(text, 3, 4, array);
                        break;
                    case 16:
                        parseVariableWidthDigits(text, 3, 6, array);
                        break;
                    case 18:
                        parseVariableWidthDigits(text, 5, 6, array);
                        break;
                    case 20:
                        parseVariableWidthDigits(text, 1, 6, array);
                        break;
                }
                if (array[0] > 0) {
                    if (array[1] <= 23 && array[2] <= 59 && array[3] <= 59) {
                        long offsetSecs = negative * ((array[1] * 3600) + (array[2] * 60) + array[3]);
                        return context.setParsedField(ChronoField.OFFSET_SECONDS, offsetSecs, position, array[0]);
                    }
                    throw new DateTimeException("Value out of range: Hour[0-23], Minute[0-59], Second[0-59]");
                }
            }
            if (noOffsetLen == 0) {
                return context.setParsedField(ChronoField.OFFSET_SECONDS, 0L, position, position);
            }
            return ~position;
        }

        private void parseHour(CharSequence parseText, boolean paddedHour, int[] array) {
            if (paddedHour) {
                if (!parseDigits(parseText, false, 1, array)) {
                    array[0] = ~array[0];
                    return;
                }
                return;
            }
            parseVariableWidthDigits(parseText, 1, 2, array);
        }

        private void parseMinute(CharSequence parseText, boolean isColon, boolean mandatory, int[] array) {
            if (!parseDigits(parseText, isColon, 2, array) && mandatory) {
                array[0] = ~array[0];
            }
        }

        private void parseSecond(CharSequence parseText, boolean isColon, boolean mandatory, int[] array) {
            if (!parseDigits(parseText, isColon, 3, array) && mandatory) {
                array[0] = ~array[0];
            }
        }

        private void parseOptionalMinuteSecond(CharSequence parseText, boolean isColon, int[] array) {
            if (parseDigits(parseText, isColon, 2, array)) {
                parseDigits(parseText, isColon, 3, array);
            }
        }

        private boolean parseDigits(CharSequence parseText, boolean isColon, int arrayIndex, int[] array) {
            int value;
            int pos = array[0];
            if (pos < 0) {
                return true;
            }
            if (isColon && arrayIndex != 1) {
                if (pos + 1 > parseText.length() || parseText.charAt(pos) != ':') {
                    return false;
                }
                pos++;
            }
            if (pos + 2 > parseText.length()) {
                return false;
            }
            int pos2 = pos + 1;
            char ch1 = parseText.charAt(pos);
            int pos3 = pos2 + 1;
            char ch2 = parseText.charAt(pos2);
            if (ch1 < '0' || ch1 > '9' || ch2 < '0' || ch2 > '9' || (value = ((ch1 - '0') * 10) + (ch2 - '0')) < 0 || value > 59) {
                return false;
            }
            array[arrayIndex] = value;
            array[0] = pos3;
            return true;
        }

        private void parseVariableWidthDigits(CharSequence parseText, int minDigits, int maxDigits, int[] array) {
            int pos = array[0];
            int available = 0;
            char[] chars = new char[maxDigits];
            int i10 = 0;
            while (i10 < maxDigits && pos + 1 <= parseText.length()) {
                int pos2 = pos + 1;
                char ch = parseText.charAt(pos);
                if (ch < '0' || ch > '9') {
                    pos = pos2 - 1;
                    break;
                }
                chars[i10] = ch;
                available++;
                i10++;
                pos = pos2;
            }
            if (available < minDigits) {
                array[0] = ~array[0];
                return;
            }
            switch (available) {
                case 1:
                    array[1] = chars[0] - '0';
                    break;
                case 2:
                    array[1] = ((chars[0] - '0') * 10) + (chars[1] - '0');
                    break;
                case 3:
                    array[1] = chars[0] - '0';
                    array[2] = ((chars[1] - '0') * 10) + (chars[2] - '0');
                    break;
                case 4:
                    array[1] = ((chars[0] - '0') * 10) + (chars[1] - '0');
                    array[2] = ((chars[2] - '0') * 10) + (chars[3] - '0');
                    break;
                case 5:
                    array[1] = chars[0] - '0';
                    array[2] = ((chars[1] - '0') * 10) + (chars[2] - '0');
                    array[3] = ((chars[3] - '0') * 10) + (chars[4] - '0');
                    break;
                case 6:
                    array[1] = ((chars[0] - '0') * 10) + (chars[1] - '0');
                    array[2] = ((chars[2] - '0') * 10) + (chars[3] - '0');
                    array[3] = ((chars[4] - '0') * 10) + (chars[5] - '0');
                    break;
            }
            array[0] = pos;
        }

        public String toString() {
            String converted = this.noOffsetText.replace("'", "''");
            return "Offset(" + PATTERNS[this.type] + ",'" + converted + "')";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class LocalizedOffsetIdPrinterParser implements DateTimePrinterParser {
        private final TextStyle style;

        LocalizedOffsetIdPrinterParser(TextStyle style) {
            this.style = style;
        }

        private static StringBuilder appendHMS(StringBuilder buf, int t2) {
            return buf.append((char) ((t2 / 10) + 48)).append((char) ((t2 % 10) + 48));
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext context, StringBuilder buf) {
            Long offsetSecs = context.getValue(ChronoField.OFFSET_SECONDS);
            if (offsetSecs == null) {
                return false;
            }
            String gmtText = ICU.getGMTZeroFormatString(context.getLocale());
            if (gmtText == null) {
                gmtText = TimeZones.GMT_ID;
            }
            buf.append(gmtText);
            int totalSecs = Math.toIntExact(offsetSecs.longValue());
            if (totalSecs != 0) {
                int absHours = Math.abs((totalSecs / SdkConfigData.DEFAULT_REQUEST_INTERVAL) % 100);
                int absMinutes = Math.abs((totalSecs / 60) % 60);
                int absSeconds = Math.abs(totalSecs % 60);
                buf.append(totalSecs < 0 ? "-" : BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
                if (this.style == TextStyle.FULL) {
                    appendHMS(buf, absHours);
                    buf.append(ShortcutConstants.SERVICES_SEPARATOR);
                    appendHMS(buf, absMinutes);
                    if (absSeconds != 0) {
                        buf.append(ShortcutConstants.SERVICES_SEPARATOR);
                        appendHMS(buf, absSeconds);
                        return true;
                    }
                    return true;
                }
                if (absHours >= 10) {
                    buf.append((char) ((absHours / 10) + 48));
                }
                buf.append((char) ((absHours % 10) + 48));
                if (absMinutes != 0 || absSeconds != 0) {
                    buf.append(ShortcutConstants.SERVICES_SEPARATOR);
                    appendHMS(buf, absMinutes);
                    if (absSeconds != 0) {
                        buf.append(ShortcutConstants.SERVICES_SEPARATOR);
                        appendHMS(buf, absSeconds);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }

        int getDigit(CharSequence text, int position) {
            char c4 = text.charAt(position);
            if (c4 < '0' || c4 > '9') {
                return -1;
            }
            return c4 - '0';
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext context, CharSequence text, int position) {
            String gmtText;
            int negative;
            int m12;
            int pos;
            int pos2;
            int h10;
            int end = text.length();
            String gmtText2 = ICU.getGMTZeroFormatString(context.getLocale());
            if (gmtText2 != null) {
                gmtText = gmtText2;
            } else {
                gmtText = TimeZones.GMT_ID;
            }
            if (!context.subSequenceEquals(text, position, gmtText, 0, gmtText.length())) {
                return ~position;
            }
            int pos3 = position + gmtText.length();
            if (pos3 == end) {
                return context.setParsedField(ChronoField.OFFSET_SECONDS, 0L, position, pos3);
            }
            char sign = text.charAt(pos3);
            if (sign == '+') {
                negative = 1;
            } else if (sign == '-') {
                negative = -1;
            } else {
                return context.setParsedField(ChronoField.OFFSET_SECONDS, 0L, position, pos3);
            }
            int pos4 = pos3 + 1;
            int m10 = 0;
            int s2 = 0;
            if (this.style == TextStyle.FULL) {
                int pos5 = pos4 + 1;
                int h12 = getDigit(text, pos4);
                int pos6 = pos5 + 1;
                int h22 = getDigit(text, pos5);
                if (h12 >= 0 && h22 >= 0) {
                    int pos7 = pos6 + 1;
                    if (text.charAt(pos6) == 58) {
                        int h11 = (h12 * 10) + h22;
                        int h13 = pos7 + 1;
                        int m13 = getDigit(text, pos7);
                        int pos8 = h13 + 1;
                        int m22 = getDigit(text, h13);
                        if (m13 >= 0 && m22 >= 0) {
                            int m11 = (m13 * 10) + m22;
                            if (pos8 + 2 < end && text.charAt(pos8) == ':') {
                                int s12 = getDigit(text, pos8 + 1);
                                int s22 = getDigit(text, pos8 + 2);
                                if (s12 >= 0 && s22 >= 0) {
                                    s2 = (s12 * 10) + s22;
                                    pos8 += 3;
                                }
                            }
                            m12 = s2;
                            pos = pos8;
                            pos2 = h11;
                            h10 = m11;
                        }
                        return ~position;
                    }
                }
                return ~position;
            }
            int pos9 = pos4 + 1;
            int h14 = getDigit(text, pos4);
            if (h14 < 0) {
                return ~position;
            }
            if (pos9 >= end) {
                m12 = 0;
                pos = pos9;
                pos2 = h14;
                h10 = 0;
            } else {
                int h23 = getDigit(text, pos9);
                if (h23 >= 0) {
                    pos9++;
                    h14 = (h14 * 10) + h23;
                }
                if (pos9 + 2 < end && text.charAt(pos9) == ':' && pos9 + 2 < end && text.charAt(pos9) == ':') {
                    int m14 = getDigit(text, pos9 + 1);
                    int m23 = getDigit(text, pos9 + 2);
                    if (m14 >= 0 && m23 >= 0) {
                        m10 = (m14 * 10) + m23;
                        pos9 += 3;
                        if (pos9 + 2 < end && text.charAt(pos9) == ':') {
                            int s13 = getDigit(text, pos9 + 1);
                            int s23 = getDigit(text, pos9 + 2);
                            if (s13 >= 0 && s23 >= 0) {
                                m12 = (s13 * 10) + s23;
                                pos = pos9 + 3;
                                pos2 = h14;
                                h10 = m10;
                            }
                        }
                    }
                }
                m12 = 0;
                pos = pos9;
                pos2 = h14;
                h10 = m10;
            }
            long offsetSecs = negative * ((pos2 * 3600) + (h10 * 60) + m12);
            return context.setParsedField(ChronoField.OFFSET_SECONDS, offsetSecs, position, pos);
        }

        public String toString() {
            return "LocalizedOffset(" + ((Object) this.style) + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class ZoneTextPrinterParser extends ZoneIdPrinterParser {
        private static final int DST = 1;
        private static final int GENERIC = 2;
        private static final int STD = 0;
        private final Map<Locale, Map.Entry<Integer, SoftReference<PrefixTree>>> cachedTree;
        private final Map<Locale, Map.Entry<Integer, SoftReference<PrefixTree>>> cachedTreeCI;
        private final boolean isGeneric;
        private Set<String> preferredZones;
        private final TextStyle textStyle;
        private static final TimeZoneNames.NameType[] TYPES = {TimeZoneNames.NameType.LONG_STANDARD, TimeZoneNames.NameType.SHORT_STANDARD, TimeZoneNames.NameType.LONG_DAYLIGHT, TimeZoneNames.NameType.SHORT_DAYLIGHT, TimeZoneNames.NameType.LONG_GENERIC, TimeZoneNames.NameType.SHORT_GENERIC};
        private static final TimeZoneNames.NameType[] FULL_TYPES = {TimeZoneNames.NameType.LONG_STANDARD, TimeZoneNames.NameType.LONG_DAYLIGHT, TimeZoneNames.NameType.LONG_GENERIC};
        private static final TimeZoneNames.NameType[] SHORT_TYPES = {TimeZoneNames.NameType.SHORT_STANDARD, TimeZoneNames.NameType.SHORT_DAYLIGHT, TimeZoneNames.NameType.SHORT_GENERIC};
        private static final Map<String, SoftReference<Map<Locale, String[]>>> cache = new ConcurrentHashMap();

        ZoneTextPrinterParser(TextStyle textStyle, Set<ZoneId> preferredZones, boolean isGeneric) {
            super(TemporalQueries.zone(), "ZoneText(" + ((Object) textStyle) + ")");
            this.cachedTree = new HashMap();
            this.cachedTreeCI = new HashMap();
            this.textStyle = (TextStyle) Objects.requireNonNull(textStyle, "textStyle");
            this.isGeneric = isGeneric;
            if (preferredZones != null && preferredZones.size() != 0) {
                this.preferredZones = new HashSet();
                for (ZoneId id2 : preferredZones) {
                    this.preferredZones.add(id2.getId());
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
        
            if (r9 == null) goto L12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.lang.String getDisplayName(java.lang.String r21, int r22, java.util.Locale r23) {
            /*
                Method dump skipped, instructions count: 248
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: java.time.format.DateTimeFormatterBuilder.ZoneTextPrinterParser.getDisplayName(java.lang.String, int, java.util.Locale):java.lang.String");
        }

        @Override // java.time.format.DateTimeFormatterBuilder.ZoneIdPrinterParser, java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb2) {
            ZoneId zoneId = (ZoneId) dateTimePrintContext.getValue(TemporalQueries.zoneId());
            if (zoneId == null) {
                return false;
            }
            String id2 = zoneId.getId();
            if (!(zoneId instanceof ZoneOffset)) {
                TemporalAccessor temporal = dateTimePrintContext.getTemporal();
                int i10 = 2;
                if (!this.isGeneric) {
                    if (temporal.isSupported(ChronoField.INSTANT_SECONDS)) {
                        i10 = zoneId.getRules().isDaylightSavings(Instant.from(temporal)) ? 1 : 0;
                    } else if (temporal.isSupported(ChronoField.EPOCH_DAY) && temporal.isSupported(ChronoField.NANO_OF_DAY)) {
                        LocalDateTime atTime = LocalDate.ofEpochDay(temporal.getLong(ChronoField.EPOCH_DAY)).atTime(LocalTime.ofNanoOfDay(temporal.getLong(ChronoField.NANO_OF_DAY)));
                        if (zoneId.getRules().getTransition(atTime) == null) {
                            i10 = zoneId.getRules().isDaylightSavings(atTime.atZone2(zoneId).toInstant()) ? 1 : 0;
                        }
                    }
                }
                String displayName = getDisplayName(id2, i10, dateTimePrintContext.getLocale());
                if (displayName != null) {
                    id2 = displayName;
                }
            }
            sb2.append(id2);
            return true;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.ZoneIdPrinterParser
        protected PrefixTree getTree(DateTimeParseContext context) {
            PrefixTree tree;
            String[] names;
            String[] names2;
            ZoneTextPrinterParser zoneTextPrinterParser = this;
            if (zoneTextPrinterParser.textStyle == TextStyle.NARROW) {
                return super.getTree(context);
            }
            Locale locale = context.getLocale();
            boolean isCaseSensitive = context.isCaseSensitive();
            Set<String> regionIds = new HashSet<>(ZoneRulesProvider.getAvailableZoneIds());
            new HashSet(64);
            int regionIdsSize = regionIds.size();
            Map<Locale, Map.Entry<Integer, SoftReference<PrefixTree>>> cached = isCaseSensitive ? zoneTextPrinterParser.cachedTree : zoneTextPrinterParser.cachedTreeCI;
            Map.Entry<Integer, SoftReference<PrefixTree>> entry = cached.get(locale);
            if (entry != null && entry.getKey().intValue() == regionIdsSize) {
                PrefixTree prefixTree = entry.getValue().get();
                tree = prefixTree;
                if (prefixTree != null) {
                    return tree;
                }
            }
            tree = PrefixTree.newTree(context);
            TimeZoneNames timeZoneNames = TimeZoneNames.getInstance(locale);
            long now = System.currentTimeMillis();
            TimeZoneNames.NameType[] types = zoneTextPrinterParser.textStyle == TextStyle.FULL ? FULL_TYPES : SHORT_TYPES;
            String[] names3 = new String[types.length];
            for (String zid : regionIds) {
                tree.add(zid, zid);
                String zid2 = ZoneName.toZid(zid, locale);
                boolean isCaseSensitive2 = isCaseSensitive;
                String[] names4 = names3;
                TimeZoneNames.NameType[] types2 = types;
                libcore.icu.TimeZoneNames.getDisplayNames(timeZoneNames, zid2, types, now, names4, 0);
                int i10 = 0;
                while (true) {
                    names2 = names4;
                    if (i10 < names2.length) {
                        if (names2[i10] != null) {
                            tree.add(names2[i10], zid2);
                        }
                        i10++;
                        names4 = names2;
                    }
                }
                names3 = names2;
                isCaseSensitive = isCaseSensitive2;
                types = types2;
            }
            TimeZoneNames.NameType[] types3 = types;
            String[] names5 = names3;
            if (zoneTextPrinterParser.preferredZones != null) {
                for (String zid3 : regionIds) {
                    if (zoneTextPrinterParser.preferredZones.contains(zid3)) {
                        String canonicalId = ZoneName.toZid(zid3, locale);
                        String[] names6 = names5;
                        libcore.icu.TimeZoneNames.getDisplayNames(timeZoneNames, canonicalId, types3, now, names5, 0);
                        int i11 = 0;
                        while (true) {
                            names = names6;
                            if (i11 >= names.length) {
                                break;
                            }
                            if (names[i11] != null) {
                                tree.add(names[i11], zid3);
                            }
                            i11++;
                            names6 = names;
                        }
                        zoneTextPrinterParser = this;
                        names5 = names;
                    }
                }
            }
            cached.put(locale, new AbstractMap.SimpleImmutableEntry(Integer.valueOf(regionIdsSize), new SoftReference(tree)));
            return tree;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ZoneIdPrinterParser implements DateTimePrinterParser {
        private static volatile Map.Entry<Integer, PrefixTree> cachedPrefixTree;
        private static volatile Map.Entry<Integer, PrefixTree> cachedPrefixTreeCI;
        private final String description;
        private final TemporalQuery<ZoneId> query;

        ZoneIdPrinterParser(TemporalQuery<ZoneId> query, String description) {
            this.query = query;
            this.description = description;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext context, StringBuilder buf) {
            ZoneId zone = (ZoneId) context.getValue(this.query);
            if (zone == null) {
                return false;
            }
            buf.append(zone.getId());
            return true;
        }

        protected PrefixTree getTree(DateTimeParseContext context) {
            Set<String> regionIds = ZoneRulesProvider.getAvailableZoneIds();
            int regionIdsSize = regionIds.size();
            Map.Entry<Integer, PrefixTree> cached = context.isCaseSensitive() ? cachedPrefixTree : cachedPrefixTreeCI;
            if (cached == null || cached.getKey().intValue() != regionIdsSize) {
                synchronized (this) {
                    cached = context.isCaseSensitive() ? cachedPrefixTree : cachedPrefixTreeCI;
                    if (cached == null || cached.getKey().intValue() != regionIdsSize) {
                        cached = new AbstractMap.SimpleImmutableEntry(Integer.valueOf(regionIdsSize), PrefixTree.newTree(regionIds, context));
                        if (context.isCaseSensitive()) {
                            cachedPrefixTree = cached;
                        } else {
                            cachedPrefixTreeCI = cached;
                        }
                    }
                }
            }
            return cached.getValue();
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext context, CharSequence text, int position) {
            int length = text.length();
            if (position > length) {
                throw new IndexOutOfBoundsException();
            }
            if (position == length) {
                return ~position;
            }
            char nextChar = text.charAt(position);
            if (nextChar == '+' || nextChar == '-') {
                return parseOffsetBased(context, text, position, position, OffsetIdPrinterParser.INSTANCE_ID_Z);
            }
            if (length >= position + 2) {
                char nextNextChar = text.charAt(position + 1);
                if (context.charEquals(nextChar, 'U') && context.charEquals(nextNextChar, 'T')) {
                    if (length >= position + 3 && context.charEquals(text.charAt(position + 2), 'C')) {
                        if (!(this instanceof ZoneTextPrinterParser)) {
                            return parseOffsetBased(context, text, position, position + 3, OffsetIdPrinterParser.INSTANCE_ID_ZERO);
                        }
                    } else {
                        return parseOffsetBased(context, text, position, position + 2, OffsetIdPrinterParser.INSTANCE_ID_ZERO);
                    }
                } else if (context.charEquals(nextChar, 'G') && length >= position + 3 && context.charEquals(nextNextChar, 'M') && context.charEquals(text.charAt(position + 2), 'T')) {
                    if (length >= position + 4 && context.charEquals(text.charAt(position + 3), '0')) {
                        context.setParsed(ZoneId.of("GMT0"));
                        return position + 4;
                    }
                    return parseOffsetBased(context, text, position, position + 3, OffsetIdPrinterParser.INSTANCE_ID_ZERO);
                }
            }
            PrefixTree tree = getTree(context);
            ParsePosition ppos = new ParsePosition(position);
            String parsedZoneId = tree.match(text, ppos);
            if (parsedZoneId == null) {
                if (context.charEquals(nextChar, 'Z')) {
                    context.setParsed(ZoneOffset.UTC);
                    return position + 1;
                }
                return ~position;
            }
            context.setParsed(ZoneId.of(parsedZoneId));
            return ppos.getIndex();
        }

        private int parseOffsetBased(DateTimeParseContext context, CharSequence text, int prefixPos, int position, OffsetIdPrinterParser parser) {
            String prefix = text.subSequence(prefixPos, position).toString().toUpperCase();
            if (position >= text.length()) {
                context.setParsed(ZoneId.of(prefix));
                return position;
            }
            if (text.charAt(position) == '0' && prefix.equals(TimeZones.GMT_ID)) {
                context.setParsed(ZoneId.of("GMT0"));
                return position + 1;
            }
            if (text.charAt(position) == '0' || context.charEquals(text.charAt(position), 'Z')) {
                context.setParsed(ZoneId.of(prefix));
                return position;
            }
            DateTimeParseContext newContext = context.copy();
            int endPos = parser.parse(newContext, text, position);
            try {
                if (endPos < 0) {
                    if (parser == OffsetIdPrinterParser.INSTANCE_ID_Z) {
                        return ~prefixPos;
                    }
                    context.setParsed(ZoneId.of(prefix));
                    return position;
                }
                int offset = (int) newContext.getParsed(ChronoField.OFFSET_SECONDS).longValue();
                ZoneOffset zoneOffset = ZoneOffset.ofTotalSeconds(offset);
                context.setParsed(ZoneId.ofOffset(prefix, zoneOffset));
                return endPos;
            } catch (DateTimeException e2) {
                return ~prefixPos;
            }
        }

        public String toString() {
            return this.description;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class PrefixTree {

        /* renamed from: c0, reason: collision with root package name */
        protected char f50421c0;
        protected PrefixTree child;
        protected String key;
        protected PrefixTree sibling;
        protected String value;

        private PrefixTree(String k10, String v2, PrefixTree child) {
            this.key = k10;
            this.value = v2;
            this.child = child;
            if (k10.isEmpty()) {
                this.f50421c0 = (char) 65535;
            } else {
                this.f50421c0 = this.key.charAt(0);
            }
        }

        public static PrefixTree newTree(DateTimeParseContext dateTimeParseContext) {
            String str = "";
            String str2 = null;
            byte b4 = 0;
            byte b10 = 0;
            if (dateTimeParseContext.isCaseSensitive()) {
                return new PrefixTree("", null, null);
            }
            return new CI(str, str2, b10 == true ? 1 : 0);
        }

        public static PrefixTree newTree(Set<String> keys, DateTimeParseContext context) {
            PrefixTree tree = newTree(context);
            for (String k10 : keys) {
                tree.add0(k10, k10);
            }
            return tree;
        }

        public PrefixTree copyTree() {
            PrefixTree copy = new PrefixTree(this.key, this.value, null);
            PrefixTree prefixTree = this.child;
            if (prefixTree != null) {
                copy.child = prefixTree.copyTree();
            }
            PrefixTree prefixTree2 = this.sibling;
            if (prefixTree2 != null) {
                copy.sibling = prefixTree2.copyTree();
            }
            return copy;
        }

        public boolean add(String k10, String v2) {
            return add0(k10, v2);
        }

        private boolean add0(String k10, String v2) {
            String k11 = toKey(k10);
            int prefixLen = prefixLength(k11);
            if (prefixLen == this.key.length()) {
                if (prefixLen < k11.length()) {
                    String subKey = k11.substring(prefixLen);
                    for (PrefixTree c4 = this.child; c4 != null; c4 = c4.sibling) {
                        if (isEqual(c4.f50421c0, subKey.charAt(0))) {
                            return c4.add0(subKey, v2);
                        }
                    }
                    PrefixTree c10 = newNode(subKey, v2, null);
                    c10.sibling = this.child;
                    this.child = c10;
                    return true;
                }
                this.value = v2;
                return true;
            }
            PrefixTree n12 = newNode(this.key.substring(prefixLen), this.value, this.child);
            this.key = k11.substring(0, prefixLen);
            this.child = n12;
            if (prefixLen < k11.length()) {
                PrefixTree n22 = newNode(k11.substring(prefixLen), v2, null);
                this.child.sibling = n22;
                this.value = null;
            } else {
                this.value = v2;
            }
            return true;
        }

        public String match(CharSequence text, int off, int end) {
            int off2;
            if (!prefixOf(text, off, end)) {
                return null;
            }
            if (this.child != null && (off2 = this.key.length() + off) != end) {
                PrefixTree c4 = this.child;
                while (!isEqual(c4.f50421c0, text.charAt(off2))) {
                    c4 = c4.sibling;
                    if (c4 == null) {
                    }
                }
                String found = c4.match(text, off2, end);
                if (found != null) {
                    return found;
                }
                return this.value;
            }
            return this.value;
        }

        public String match(CharSequence text, ParsePosition pos) {
            int off = pos.getIndex();
            int end = text.length();
            if (!prefixOf(text, off, end)) {
                return null;
            }
            int off2 = off + this.key.length();
            if (this.child != null && off2 != end) {
                PrefixTree c4 = this.child;
                while (true) {
                    if (isEqual(c4.f50421c0, text.charAt(off2))) {
                        pos.setIndex(off2);
                        String found = c4.match(text, pos);
                        if (found != null) {
                            return found;
                        }
                    } else {
                        c4 = c4.sibling;
                        if (c4 == null) {
                            break;
                        }
                    }
                }
            }
            pos.setIndex(off2);
            return this.value;
        }

        protected String toKey(String k10) {
            return k10;
        }

        protected PrefixTree newNode(String k10, String v2, PrefixTree child) {
            return new PrefixTree(k10, v2, child);
        }

        protected boolean isEqual(char c12, char c22) {
            return c12 == c22;
        }

        protected boolean prefixOf(CharSequence text, int off, int end) {
            if (text instanceof String) {
                return ((String) text).startsWith(this.key, off);
            }
            int len = this.key.length();
            if (len > end - off) {
                return false;
            }
            int off2 = 0;
            while (true) {
                int len2 = len - 1;
                if (len > 0) {
                    int off0 = off2 + 1;
                    char charAt = this.key.charAt(off2);
                    int off3 = off + 1;
                    if (!isEqual(charAt, text.charAt(off))) {
                        return false;
                    }
                    off = off3;
                    len = len2;
                    off2 = off0;
                } else {
                    return true;
                }
            }
        }

        private int prefixLength(String k10) {
            int off = 0;
            while (off < k10.length() && off < this.key.length()) {
                if (!isEqual(k10.charAt(off), this.key.charAt(off))) {
                    return off;
                }
                off++;
            }
            return off;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static class CI extends PrefixTree {
            private CI(String k10, String v2, PrefixTree child) {
                super(k10, v2, child);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.time.format.DateTimeFormatterBuilder.PrefixTree
            public CI newNode(String k10, String v2, PrefixTree child) {
                return new CI(k10, v2, child);
            }

            @Override // java.time.format.DateTimeFormatterBuilder.PrefixTree
            protected boolean isEqual(char c12, char c22) {
                return DateTimeParseContext.charEqualsIgnoreCase(c12, c22);
            }

            @Override // java.time.format.DateTimeFormatterBuilder.PrefixTree
            protected boolean prefixOf(CharSequence text, int off, int end) {
                int len = this.key.length();
                if (len > end - off) {
                    return false;
                }
                int off2 = 0;
                while (true) {
                    int len2 = len - 1;
                    if (len > 0) {
                        int off0 = off2 + 1;
                        char charAt = this.key.charAt(off2);
                        int off3 = off + 1;
                        if (!isEqual(charAt, text.charAt(off))) {
                            return false;
                        }
                        off = off3;
                        len = len2;
                        off2 = off0;
                    } else {
                        return true;
                    }
                }
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static class LENIENT extends CI {
            private LENIENT(String k10, String v2, PrefixTree child) {
                super(k10, v2, child);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.time.format.DateTimeFormatterBuilder.PrefixTree.CI, java.time.format.DateTimeFormatterBuilder.PrefixTree
            public CI newNode(String k10, String v2, PrefixTree child) {
                return new LENIENT(k10, v2, child);
            }

            private boolean isLenientChar(char c4) {
                return c4 == ' ' || c4 == '_' || c4 == '/';
            }

            @Override // java.time.format.DateTimeFormatterBuilder.PrefixTree
            protected String toKey(String k10) {
                int i10 = 0;
                while (i10 < k10.length()) {
                    if (!isLenientChar(k10.charAt(i10))) {
                        i10++;
                    } else {
                        StringBuilder sb2 = new StringBuilder(k10.length());
                        sb2.append((CharSequence) k10, 0, i10);
                        while (true) {
                            i10++;
                            if (i10 < k10.length()) {
                                if (!isLenientChar(k10.charAt(i10))) {
                                    sb2.append(k10.charAt(i10));
                                }
                            } else {
                                return sb2.toString();
                            }
                        }
                    }
                }
                return k10;
            }

            @Override // java.time.format.DateTimeFormatterBuilder.PrefixTree
            public String match(CharSequence text, ParsePosition pos) {
                int off = pos.getIndex();
                int end = text.length();
                int len = this.key.length();
                int koff = 0;
                while (koff < len && off < end) {
                    if (isLenientChar(text.charAt(off))) {
                        off++;
                    } else {
                        int koff2 = koff + 1;
                        int off2 = off + 1;
                        if (!isEqual(this.key.charAt(koff), text.charAt(off))) {
                            return null;
                        }
                        off = off2;
                        koff = koff2;
                    }
                }
                if (koff != len) {
                    return null;
                }
                if (this.child != null && off != end) {
                    int off0 = off;
                    while (off0 < end && isLenientChar(text.charAt(off0))) {
                        off0++;
                    }
                    if (off0 < end) {
                        PrefixTree c4 = this.child;
                        while (true) {
                            if (isEqual(c4.f50421c0, text.charAt(off0))) {
                                pos.setIndex(off0);
                                String found = c4.match(text, pos);
                                if (found != null) {
                                    return found;
                                }
                            } else {
                                c4 = c4.sibling;
                                if (c4 == null) {
                                    break;
                                }
                            }
                        }
                    }
                }
                pos.setIndex(off);
                return this.value;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class ChronoPrinterParser implements DateTimePrinterParser {
        private final TextStyle textStyle;

        ChronoPrinterParser(TextStyle textStyle) {
            this.textStyle = textStyle;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext context, StringBuilder buf) {
            Chronology chrono = (Chronology) context.getValue(TemporalQueries.chronology());
            if (chrono == null) {
                return false;
            }
            if (this.textStyle == null) {
                buf.append(chrono.getId());
                return true;
            }
            buf.append(getChronologyName(chrono, context.getLocale()));
            return true;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext context, CharSequence text, int position) {
            String name;
            if (position < 0 || position > text.length()) {
                throw new IndexOutOfBoundsException();
            }
            Set<Chronology> chronos = Chronology.getAvailableChronologies();
            Chronology bestMatch = null;
            int matchLen = -1;
            for (Chronology chrono : chronos) {
                if (this.textStyle == null) {
                    name = chrono.getId();
                } else {
                    name = getChronologyName(chrono, context.getLocale());
                }
                int nameLen = name.length();
                if (nameLen > matchLen && context.subSequenceEquals(text, position, name, 0, nameLen)) {
                    bestMatch = chrono;
                    matchLen = nameLen;
                }
            }
            if (bestMatch == null) {
                return ~position;
            }
            context.setParsed(bestMatch);
            return position + matchLen;
        }

        private String getChronologyName(final Chronology chrono, Locale locale) {
            LocaleDisplayNames displayNames = LocaleDisplayNames.getInstance(ULocale.forLocale(locale));
            String name = displayNames.keyValueDisplayName("calendar", chrono.getCalendarType());
            return (String) Objects.requireNonNullElseGet(name, new Supplier() { // from class: java.time.format.DateTimeFormatterBuilder$ChronoPrinterParser$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    String id2;
                    id2 = Chronology.this.getId();
                    return id2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class LocalizedPrinterParser implements DateTimePrinterParser {
        private static final ConcurrentMap<String, DateTimeFormatter> FORMATTER_CACHE = new ConcurrentHashMap(16, 0.75f, 2);
        private final FormatStyle dateStyle;
        private final FormatStyle timeStyle;

        LocalizedPrinterParser(FormatStyle dateStyle, FormatStyle timeStyle) {
            this.dateStyle = dateStyle;
            this.timeStyle = timeStyle;
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext context, StringBuilder buf) {
            Chronology chrono = Chronology.from(context.getTemporal());
            return formatter(context.getLocale(), chrono).toPrinterParser(false).format(context, buf);
        }

        @Override // java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext context, CharSequence text, int position) {
            Chronology chrono = context.getEffectiveChronology();
            return formatter(context.getLocale(), chrono).toPrinterParser(false).parse(context, text, position);
        }

        private DateTimeFormatter formatter(Locale locale, Chronology chrono) {
            String key = chrono.getId() + '|' + locale.toString() + '|' + ((Object) this.dateStyle) + ((Object) this.timeStyle);
            ConcurrentMap<String, DateTimeFormatter> concurrentMap = FORMATTER_CACHE;
            DateTimeFormatter formatter = concurrentMap.get(key);
            if (formatter == null) {
                String pattern = DateTimeFormatterBuilder.getLocalizedDateTimePattern(this.dateStyle, this.timeStyle, chrono, locale);
                DateTimeFormatter formatter2 = new DateTimeFormatterBuilder().appendPattern(pattern).toFormatter(locale);
                DateTimeFormatter old = concurrentMap.putIfAbsent(key, formatter2);
                if (old != null) {
                    return old;
                }
                return formatter2;
            }
            return formatter;
        }

        public String toString() {
            StringBuilder append = new StringBuilder().append("Localized(");
            Object obj = this.dateStyle;
            if (obj == null) {
                obj = "";
            }
            StringBuilder append2 = append.append(obj).append(",");
            FormatStyle formatStyle = this.timeStyle;
            return append2.append(formatStyle != null ? formatStyle : "").append(")").toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class WeekBasedFieldPrinterParser extends NumberPrinterParser {
        private char chr;
        private int count;

        WeekBasedFieldPrinterParser(char chr, int count, int minWidth, int maxWidth) {
            this(chr, count, minWidth, maxWidth, 0);
        }

        WeekBasedFieldPrinterParser(char chr, int count, int minWidth, int maxWidth, int subsequentWidth) {
            super(null, minWidth, maxWidth, SignStyle.NOT_NEGATIVE, subsequentWidth);
            this.chr = chr;
            this.count = count;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // java.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        public WeekBasedFieldPrinterParser withFixedWidth() {
            if (this.subsequentWidth == -1) {
                return this;
            }
            return new WeekBasedFieldPrinterParser(this.chr, this.count, this.minWidth, this.maxWidth, -1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // java.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        public WeekBasedFieldPrinterParser withSubsequentWidth(int subsequentWidth) {
            return new WeekBasedFieldPrinterParser(this.chr, this.count, this.minWidth, this.maxWidth, this.subsequentWidth + subsequentWidth);
        }

        @Override // java.time.format.DateTimeFormatterBuilder.NumberPrinterParser, java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext context, StringBuilder buf) {
            return printerParser(context.getLocale()).format(context, buf);
        }

        @Override // java.time.format.DateTimeFormatterBuilder.NumberPrinterParser, java.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext context, CharSequence text, int position) {
            return printerParser(context.getLocale()).parse(context, text, position);
        }

        private DateTimePrinterParser printerParser(Locale locale) {
            TemporalField field;
            WeekFields weekDef = WeekFields.of(locale);
            switch (this.chr) {
                case 'W':
                    field = weekDef.weekOfMonth();
                    break;
                case 'Y':
                    TemporalField field2 = weekDef.weekBasedYear();
                    if (this.count == 2) {
                        return new ReducedPrinterParser(field2, 2, 2, 0, ReducedPrinterParser.BASE_DATE, this.subsequentWidth);
                    }
                    int i10 = this.count;
                    return new NumberPrinterParser(field2, i10, 19, i10 < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD, this.subsequentWidth);
                case 'c':
                case 'e':
                    field = weekDef.dayOfWeek();
                    break;
                case 'w':
                    field = weekDef.weekOfWeekBasedYear();
                    break;
                default:
                    throw new IllegalStateException("unreachable");
            }
            return new NumberPrinterParser(field, this.minWidth, this.maxWidth, SignStyle.NOT_NEGATIVE, this.subsequentWidth);
        }

        @Override // java.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        public String toString() {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Localized(");
            char c4 = this.chr;
            if (c4 == 'Y') {
                int i10 = this.count;
                if (i10 == 1) {
                    sb2.append("WeekBasedYear");
                } else if (i10 == 2) {
                    sb2.append("ReducedValue(WeekBasedYear,2,2,2000-01-01)");
                } else {
                    sb2.append("WeekBasedYear,").append(this.count).append(",").append(19).append(",").append((Object) (this.count < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD));
                }
            } else {
                switch (c4) {
                    case 'W':
                        sb2.append("WeekOfMonth");
                        break;
                    case 'c':
                    case 'e':
                        sb2.append("DayOfWeek");
                        break;
                    case 'w':
                        sb2.append("WeekOfWeekBasedYear");
                        break;
                }
                sb2.append(",");
                sb2.append(this.count);
            }
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class DayPeriod {
        private static final Map<Locale, Map<DayPeriod, Long>> DAYPERIOD_CACHE = new ConcurrentHashMap();
        private static final Comparator<DayPeriod> DPCOMPARATOR = new Comparator() { // from class: java.time.format.DateTimeFormatterBuilder$DayPeriod$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return DateTimeFormatterBuilder.DayPeriod.lambda$static$0((DateTimeFormatterBuilder.DayPeriod) obj, (DateTimeFormatterBuilder.DayPeriod) obj2);
            }
        };
        private static final Pattern RULE = Pattern.compile("(?<type>[a-z12]+):(?<from>\\d{2}):00(-(?<to>\\d{2}))*");
        private final long from;
        private final long index;
        private final long to;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ int lambda$static$0(DayPeriod dp1, DayPeriod dp2) {
            return (int) (dp1.duration() - dp2.duration());
        }

        private DayPeriod(long from, long to, long index) {
            this.from = from;
            this.to = to;
            this.index = index;
        }

        long getIndex() {
            return this.index;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long mid() {
            return (this.from + (duration() / 2)) % 1440;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean includes(long mod) {
            long j10 = this.from;
            if (j10 == 0 && this.to == 0 && mod == 1440) {
                return true;
            }
            if (j10 == mod && this.to == mod) {
                return true;
            }
            if (j10 <= mod && mod < this.to) {
                return true;
            }
            long j11 = this.to;
            return j10 > j11 && (j10 <= mod || j11 > mod);
        }

        private long duration() {
            long j10 = this.from;
            long j11 = this.to;
            return j10 > j11 ? (1440 - j10) + j11 : j11 - j10;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        static long mapToIndex(String type) {
            char c4;
            switch (type.hashCode()) {
                case -1640863024:
                    if (type.equals("midnight")) {
                        c4 = 2;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1045618919:
                    if (type.equals("night1")) {
                        c4 = '\n';
                        break;
                    }
                    c4 = 65535;
                    break;
                case -1045618918:
                    if (type.equals("night2")) {
                        c4 = 11;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -209993491:
                    if (type.equals("morning1")) {
                        c4 = 4;
                        break;
                    }
                    c4 = 65535;
                    break;
                case -209993490:
                    if (type.equals("morning2")) {
                        c4 = 5;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 3116:
                    if (type.equals("am")) {
                        c4 = 0;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 3581:
                    if (type.equals("pm")) {
                        c4 = 1;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 3387232:
                    if (type.equals("noon")) {
                        c4 = 3;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 277805225:
                    if (type.equals("evening1")) {
                        c4 = '\b';
                        break;
                    }
                    c4 = 65535;
                    break;
                case 277805226:
                    if (type.equals("evening2")) {
                        c4 = '\t';
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1556119669:
                    if (type.equals("afternoon1")) {
                        c4 = 6;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1556119670:
                    if (type.equals("afternoon2")) {
                        c4 = 7;
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
                    return 0L;
                case 1:
                    return 1L;
                case 2:
                    return 2L;
                case 3:
                    return 3L;
                case 4:
                    return 4L;
                case 5:
                    return 5L;
                case 6:
                    return 6L;
                case 7:
                    return 7L;
                case '\b':
                    return 8L;
                case '\t':
                    return 9L;
                case '\n':
                    return 10L;
                case 11:
                    return 11L;
                default:
                    throw new InternalError("invalid day period type");
            }
        }

        public boolean equals(Object o10) {
            if (this == o10) {
                return true;
            }
            if (o10 == null || getClass() != o10.getClass()) {
                return false;
            }
            DayPeriod dayPeriod = (DayPeriod) o10;
            if (this.from == dayPeriod.from && this.to == dayPeriod.to && this.index == dayPeriod.index) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.from), Long.valueOf(this.to), Long.valueOf(this.index));
        }

        public String toString() {
            StringBuilder append = new StringBuilder().append("DayPeriod(%02d:%02d".formatted(Long.valueOf(this.from / 60), Long.valueOf(this.from % 60)));
            long j10 = this.from;
            long j11 = this.to;
            return append.append(j10 == j11 ? ")" : "-%02d:%02d)".formatted(Long.valueOf(j11 / 60), Long.valueOf(this.to % 60))).toString();
        }
    }
}
