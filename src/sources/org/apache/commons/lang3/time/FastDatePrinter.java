package org.apache.commons.lang3.time;

import com.android.internal.accessibility.common.ShortcutConstants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.exception.ExceptionUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class FastDatePrinter implements DatePrinter, Serializable {
    public static final int FULL = 0;
    public static final int LONG = 1;
    private static final int MAX_DIGITS = 10;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    private static final ConcurrentMap<TimeZoneDisplayKey, String> cTimeZoneDisplayCache = new ConcurrentHashMap(7);
    private static final long serialVersionUID = 1;
    private final Locale mLocale;
    private transient int mMaxLengthEstimate;
    private final String mPattern;
    private transient Rule[] mRules;
    private final TimeZone mTimeZone;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class CharacterLiteral implements Rule {
        private final char mValue;

        public CharacterLiteral(char c4) {
            this.mValue = c4;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValue);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 1;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Iso8601_Rule implements Rule {
        public final int length;
        public static final Iso8601_Rule ISO8601_HOURS = new Iso8601_Rule(3);
        public static final Iso8601_Rule ISO8601_HOURS_MINUTES = new Iso8601_Rule(5);
        public static final Iso8601_Rule ISO8601_HOURS_COLON_MINUTES = new Iso8601_Rule(6);

        public Iso8601_Rule(int i10) {
            this.length = i10;
        }

        public static Iso8601_Rule getRule(int i10) {
            if (i10 == 1) {
                return ISO8601_HOURS;
            }
            if (i10 == 2) {
                return ISO8601_HOURS_MINUTES;
            }
            if (i10 == 3) {
                return ISO8601_HOURS_COLON_MINUTES;
            }
            throw new IllegalArgumentException("invalid number of X");
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i10 = calendar.get(15) + calendar.get(16);
            if (i10 == 0) {
                appendable.append("Z");
                return;
            }
            if (i10 < 0) {
                appendable.append('-');
                i10 = -i10;
            } else {
                appendable.append('+');
            }
            int i11 = i10 / 3600000;
            FastDatePrinter.appendDigits(appendable, i11);
            int i12 = this.length;
            if (i12 < 5) {
                return;
            }
            if (i12 == 6) {
                appendable.append(ShortcutConstants.SERVICES_SEPARATOR);
            }
            FastDatePrinter.appendDigits(appendable, (i10 / 60000) - (i11 * 60));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.length;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface NumberRule extends Rule {
        void appendTo(Appendable appendable, int i10) throws IOException;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class PaddedNumberField implements NumberRule {
        private final int mField;
        private final int mSize;

        public PaddedNumberField(int i10, int i11) {
            if (i11 >= 3) {
                this.mField = i10;
                this.mSize = i11;
                return;
            }
            throw new IllegalArgumentException();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mSize;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i10) throws IOException {
            FastDatePrinter.appendFullDigits(appendable, i10, this.mSize);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Rule {
        void appendTo(Appendable appendable, Calendar calendar) throws IOException;

        int estimateLength();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class StringLiteral implements Rule {
        private final String mValue;

        public StringLiteral(String str) {
            this.mValue = str;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValue);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mValue.length();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class TextField implements Rule {
        private final int mField;
        private final String[] mValues;

        public TextField(int i10, String[] strArr) {
            this.mField = i10;
            this.mValues = strArr;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendable.append(this.mValues[calendar.get(this.mField)]);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            int length = this.mValues.length;
            int i10 = 0;
            while (true) {
                length--;
                if (length < 0) {
                    return i10;
                }
                int length2 = this.mValues[length].length();
                if (length2 > i10) {
                    i10 = length2;
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class TimeZoneDisplayKey {
        private final Locale mLocale;
        private final int mStyle;
        private final TimeZone mTimeZone;

        public TimeZoneDisplayKey(TimeZone timeZone, boolean z10, int i10, Locale locale) {
            this.mTimeZone = timeZone;
            if (z10) {
                this.mStyle = Integer.MIN_VALUE | i10;
            } else {
                this.mStyle = i10;
            }
            this.mLocale = locale;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TimeZoneDisplayKey)) {
                return false;
            }
            TimeZoneDisplayKey timeZoneDisplayKey = (TimeZoneDisplayKey) obj;
            return this.mTimeZone.equals(timeZoneDisplayKey.mTimeZone) && this.mStyle == timeZoneDisplayKey.mStyle && this.mLocale.equals(timeZoneDisplayKey.mLocale);
        }

        public int hashCode() {
            return (((this.mStyle * 31) + this.mLocale.hashCode()) * 31) + this.mTimeZone.hashCode();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class TimeZoneNameRule implements Rule {
        private final String mDaylight;
        private final Locale mLocale;
        private final String mStandard;
        private final int mStyle;

        public TimeZoneNameRule(TimeZone timeZone, Locale locale, int i10) {
            this.mLocale = locale;
            this.mStyle = i10;
            this.mStandard = FastDatePrinter.getTimeZoneDisplay(timeZone, false, i10, locale);
            this.mDaylight = FastDatePrinter.getTimeZoneDisplay(timeZone, true, i10, locale);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            TimeZone timeZone = calendar.getTimeZone();
            if (calendar.get(16) == 0) {
                appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, false, this.mStyle, this.mLocale));
            } else {
                appendable.append(FastDatePrinter.getTimeZoneDisplay(timeZone, true, this.mStyle, this.mLocale));
            }
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return Math.max(this.mStandard.length(), this.mDaylight.length());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class TimeZoneNumberRule implements Rule {
        public static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
        public static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
        public final boolean mColon;

        public TimeZoneNumberRule(boolean z10) {
            this.mColon = z10;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i10 = calendar.get(15) + calendar.get(16);
            if (i10 < 0) {
                appendable.append('-');
                i10 = -i10;
            } else {
                appendable.append('+');
            }
            int i11 = i10 / 3600000;
            FastDatePrinter.appendDigits(appendable, i11);
            if (this.mColon) {
                appendable.append(ShortcutConstants.SERVICES_SEPARATOR);
            }
            FastDatePrinter.appendDigits(appendable, (i10 / 60000) - (i11 * 60));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 5;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class TwoDigitMonthField implements NumberRule {
        public static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i10) throws IOException {
            FastDatePrinter.appendDigits(appendable, i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class TwoDigitNumberField implements NumberRule {
        private final int mField;

        public TwoDigitNumberField(int i10) {
            this.mField = i10;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i10) throws IOException {
            if (i10 < 100) {
                FastDatePrinter.appendDigits(appendable, i10);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i10, 2);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class TwoDigitYearField implements NumberRule {
        public static final TwoDigitYearField INSTANCE = new TwoDigitYearField();

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(1) % 100);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i10) throws IOException {
            FastDatePrinter.appendDigits(appendable, i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class UnpaddedMonthField implements NumberRule {
        public static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(2) + 1);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 2;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i10) throws IOException {
            if (i10 < 10) {
                appendable.append((char) (i10 + 48));
            } else {
                FastDatePrinter.appendDigits(appendable, i10);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class UnpaddedNumberField implements NumberRule {
        private final int mField;

        public UnpaddedNumberField(int i10) {
            this.mField = i10;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            appendTo(appendable, calendar.get(this.mField));
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return 4;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public final void appendTo(Appendable appendable, int i10) throws IOException {
            if (i10 < 10) {
                appendable.append((char) (i10 + 48));
            } else if (i10 < 100) {
                FastDatePrinter.appendDigits(appendable, i10);
            } else {
                FastDatePrinter.appendFullDigits(appendable, i10, 1);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class WeekYear implements NumberRule {
        private final NumberRule mRule;

        public WeekYear(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            this.mRule.appendTo(appendable, calendar.getWeekYear());
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i10) throws IOException {
            this.mRule.appendTo(appendable, i10);
        }
    }

    public FastDatePrinter(String str, TimeZone timeZone, Locale locale) {
        this.mPattern = str;
        this.mTimeZone = timeZone;
        this.mLocale = locale;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendDigits(Appendable appendable, int i10) throws IOException {
        appendable.append((char) ((i10 / 10) + 48));
        appendable.append((char) ((i10 % 10) + 48));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendFullDigits(Appendable appendable, int i10, int i11) throws IOException {
        if (i10 < 10000) {
            int i12 = i10 < 1000 ? i10 < 100 ? i10 < 10 ? 1 : 2 : 3 : 4;
            for (int i13 = i11 - i12; i13 > 0; i13--) {
                appendable.append('0');
            }
            if (i12 != 1) {
                if (i12 != 2) {
                    if (i12 != 3) {
                        if (i12 != 4) {
                            return;
                        }
                        appendable.append((char) ((i10 / 1000) + 48));
                        i10 %= 1000;
                    }
                    if (i10 >= 100) {
                        appendable.append((char) ((i10 / 100) + 48));
                        i10 %= 100;
                    } else {
                        appendable.append('0');
                    }
                }
                if (i10 >= 10) {
                    appendable.append((char) ((i10 / 10) + 48));
                    i10 %= 10;
                } else {
                    appendable.append('0');
                }
            }
            appendable.append((char) (i10 + 48));
            return;
        }
        char[] cArr = new char[10];
        int i14 = 0;
        while (i10 != 0) {
            cArr[i14] = (char) ((i10 % 10) + 48);
            i10 /= 10;
            i14++;
        }
        while (i14 < i11) {
            appendable.append('0');
            i11--;
        }
        while (true) {
            i14--;
            if (i14 < 0) {
                return;
            } else {
                appendable.append(cArr[i14]);
            }
        }
    }

    private String applyRulesToString(Calendar calendar) {
        return ((StringBuilder) applyRules(calendar, (Calendar) new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    public static String getTimeZoneDisplay(TimeZone timeZone, boolean z10, int i10, Locale locale) {
        TimeZoneDisplayKey timeZoneDisplayKey = new TimeZoneDisplayKey(timeZone, z10, i10, locale);
        ConcurrentMap<TimeZoneDisplayKey, String> concurrentMap = cTimeZoneDisplayCache;
        String str = concurrentMap.get(timeZoneDisplayKey);
        if (str != null) {
            return str;
        }
        String displayName = timeZone.getDisplayName(z10, i10, locale);
        String putIfAbsent = concurrentMap.putIfAbsent(timeZoneDisplayKey, displayName);
        return putIfAbsent != null ? putIfAbsent : displayName;
    }

    private void init() {
        List<Rule> parsePattern = parsePattern();
        Rule[] ruleArr = (Rule[]) parsePattern.toArray(new Rule[parsePattern.size()]);
        this.mRules = ruleArr;
        int length = ruleArr.length;
        int i10 = 0;
        while (true) {
            length--;
            if (length >= 0) {
                i10 += this.mRules[length].estimateLength();
            } else {
                this.mMaxLengthEstimate = i10;
                return;
            }
        }
    }

    private Calendar newCalendar() {
        return Calendar.getInstance(this.mTimeZone, this.mLocale);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init();
    }

    @Deprecated
    public StringBuffer applyRules(Calendar calendar, StringBuffer stringBuffer) {
        return (StringBuffer) applyRules(calendar, (Calendar) stringBuffer);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FastDatePrinter)) {
            return false;
        }
        FastDatePrinter fastDatePrinter = (FastDatePrinter) obj;
        return this.mPattern.equals(fastDatePrinter.mPattern) && this.mTimeZone.equals(fastDatePrinter.mTimeZone) && this.mLocale.equals(fastDatePrinter.mLocale);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    @Deprecated
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unknown class: ");
        sb2.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public Locale getLocale() {
        return this.mLocale;
    }

    public int getMaxLengthEstimate() {
        return this.mMaxLengthEstimate;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String getPattern() {
        return this.mPattern;
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public int hashCode() {
        return this.mPattern.hashCode() + ((this.mTimeZone.hashCode() + (this.mLocale.hashCode() * 13)) * 13);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0053. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0056. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0059. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v17, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v12, types: [org.apache.commons.lang3.time.FastDatePrinter$StringLiteral] */
    /* JADX WARN: Type inference failed for: r9v13, types: [org.apache.commons.lang3.time.FastDatePrinter$CharacterLiteral] */
    /* JADX WARN: Type inference failed for: r9v15, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v17, types: [org.apache.commons.lang3.time.FastDatePrinter$UnpaddedMonthField] */
    /* JADX WARN: Type inference failed for: r9v18, types: [org.apache.commons.lang3.time.FastDatePrinter$TwoDigitMonthField] */
    /* JADX WARN: Type inference failed for: r9v19, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v20, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v22, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v23, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v25, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v26, types: [org.apache.commons.lang3.time.FastDatePrinter$TwelveHourField] */
    /* JADX WARN: Type inference failed for: r9v27, types: [org.apache.commons.lang3.time.FastDatePrinter$TwentyFourHourField] */
    /* JADX WARN: Type inference failed for: r9v29, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v31, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v32, types: [org.apache.commons.lang3.time.FastDatePrinter$DayInWeekField] */
    /* JADX WARN: Type inference failed for: r9v34, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v36, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v41, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v42, types: [org.apache.commons.lang3.time.FastDatePrinter$TextField] */
    /* JADX WARN: Type inference failed for: r9v45, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v46, types: [org.apache.commons.lang3.time.FastDatePrinter$NumberRule] */
    /* JADX WARN: Type inference failed for: r9v47, types: [org.apache.commons.lang3.time.FastDatePrinter$Iso8601_Rule] */
    /* JADX WARN: Type inference failed for: r9v50, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNumberRule] */
    /* JADX WARN: Type inference failed for: r9v51, types: [org.apache.commons.lang3.time.FastDatePrinter$Iso8601_Rule] */
    /* JADX WARN: Type inference failed for: r9v52, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNumberRule] */
    /* JADX WARN: Type inference failed for: r9v7, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNameRule] */
    /* JADX WARN: Type inference failed for: r9v8, types: [org.apache.commons.lang3.time.FastDatePrinter$TimeZoneNameRule] */
    public List<Rule> parsePattern() {
        int i10;
        NumberRule numberRule;
        ?? timeZoneNameRule;
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.mLocale);
        ArrayList arrayList = new ArrayList();
        String[] eras = dateFormatSymbols.getEras();
        String[] months = dateFormatSymbols.getMonths();
        String[] shortMonths = dateFormatSymbols.getShortMonths();
        String[] weekdays = dateFormatSymbols.getWeekdays();
        String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
        String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
        int length = this.mPattern.length();
        int[] iArr = new int[1];
        int i11 = 0;
        int i12 = 0;
        while (i12 < length) {
            iArr[i11] = i12;
            String parseToken = parseToken(this.mPattern, iArr);
            int i13 = iArr[i11];
            int length2 = parseToken.length();
            if (length2 == 0) {
                return arrayList;
            }
            char charAt = parseToken.charAt(i11);
            if (charAt != 'y') {
                if (charAt != 'z') {
                    switch (charAt) {
                        case '\'':
                            String substring = parseToken.substring(1);
                            if (substring.length() == 1) {
                                timeZoneNameRule = new CharacterLiteral(substring.charAt(0));
                                break;
                            } else {
                                timeZoneNameRule = new StringLiteral(substring);
                                break;
                            }
                        case 'K':
                            timeZoneNameRule = selectNumberRule(10, length2);
                            break;
                        case 'M':
                            if (length2 < 4) {
                                if (length2 != 3) {
                                    if (length2 == 2) {
                                        timeZoneNameRule = TwoDigitMonthField.INSTANCE;
                                        break;
                                    } else {
                                        timeZoneNameRule = UnpaddedMonthField.INSTANCE;
                                        break;
                                    }
                                } else {
                                    timeZoneNameRule = new TextField(2, shortMonths);
                                    break;
                                }
                            } else {
                                timeZoneNameRule = new TextField(2, months);
                                break;
                            }
                        case 'S':
                            timeZoneNameRule = selectNumberRule(14, length2);
                            break;
                        case 'a':
                            timeZoneNameRule = new TextField(9, amPmStrings);
                            break;
                        case 'd':
                            timeZoneNameRule = selectNumberRule(5, length2);
                            break;
                        case 'h':
                            timeZoneNameRule = new TwelveHourField(selectNumberRule(10, length2));
                            break;
                        case 'k':
                            timeZoneNameRule = new TwentyFourHourField(selectNumberRule(11, length2));
                            break;
                        case 'm':
                            timeZoneNameRule = selectNumberRule(12, length2);
                            break;
                        case 's':
                            timeZoneNameRule = selectNumberRule(13, length2);
                            break;
                        case 'u':
                            timeZoneNameRule = new DayInWeekField(selectNumberRule(7, length2));
                            break;
                        case 'w':
                            timeZoneNameRule = selectNumberRule(3, length2);
                            break;
                        default:
                            switch (charAt) {
                                case 'D':
                                    timeZoneNameRule = selectNumberRule(6, length2);
                                    break;
                                case 'E':
                                    numberRule = new TextField(7, length2 < 4 ? shortWeekdays : weekdays);
                                    i11 = 0;
                                    arrayList.add(numberRule);
                                    i12 = i13 + 1;
                                case 'F':
                                    timeZoneNameRule = selectNumberRule(8, length2);
                                    break;
                                case 'G':
                                    i11 = 0;
                                    numberRule = new TextField(0, eras);
                                    arrayList.add(numberRule);
                                    i12 = i13 + 1;
                                case 'H':
                                    timeZoneNameRule = selectNumberRule(11, length2);
                                    break;
                                default:
                                    switch (charAt) {
                                        case 'W':
                                            timeZoneNameRule = selectNumberRule(4, length2);
                                            break;
                                        case 'X':
                                            timeZoneNameRule = Iso8601_Rule.getRule(length2);
                                            break;
                                        case 'Y':
                                            break;
                                        case 'Z':
                                            if (length2 != 1) {
                                                if (length2 == 2) {
                                                    timeZoneNameRule = Iso8601_Rule.ISO8601_HOURS_COLON_MINUTES;
                                                    break;
                                                } else {
                                                    timeZoneNameRule = TimeZoneNumberRule.INSTANCE_COLON;
                                                    break;
                                                }
                                            } else {
                                                timeZoneNameRule = TimeZoneNumberRule.INSTANCE_NO_COLON;
                                                break;
                                            }
                                        default:
                                            throw new IllegalArgumentException("Illegal pattern component: " + parseToken);
                                    }
                            }
                            break;
                    }
                } else if (length2 >= 4) {
                    timeZoneNameRule = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 1);
                } else {
                    timeZoneNameRule = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 0);
                }
                numberRule = timeZoneNameRule;
                i11 = 0;
                arrayList.add(numberRule);
                i12 = i13 + 1;
            }
            i11 = 0;
            if (length2 == 2) {
                numberRule = TwoDigitYearField.INSTANCE;
            } else {
                if (length2 < 4) {
                    i10 = 1;
                    length2 = 4;
                } else {
                    i10 = 1;
                }
                numberRule = selectNumberRule(i10, length2);
            }
            if (charAt == 'Y') {
                numberRule = new WeekYear(numberRule);
            }
            arrayList.add(numberRule);
            i12 = i13 + 1;
        }
        return arrayList;
    }

    public String parseToken(String str, int[] iArr) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i10);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            sb2.append(charAt);
            while (true) {
                int i11 = i10 + 1;
                if (i11 >= length || str.charAt(i11) != charAt) {
                    break;
                }
                sb2.append(charAt);
                i10 = i11;
            }
        } else {
            sb2.append('\'');
            boolean z10 = false;
            while (i10 < length) {
                char charAt2 = str.charAt(i10);
                if (charAt2 != '\'') {
                    if (!z10 && ((charAt2 >= 'A' && charAt2 <= 'Z') || (charAt2 >= 'a' && charAt2 <= 'z'))) {
                        i10--;
                        break;
                    }
                    sb2.append(charAt2);
                } else {
                    int i12 = i10 + 1;
                    if (i12 >= length || str.charAt(i12) != '\'') {
                        z10 = !z10;
                    } else {
                        sb2.append(charAt2);
                        i10 = i12;
                    }
                }
                i10++;
            }
        }
        iArr[0] = i10;
        return sb2.toString();
    }

    public NumberRule selectNumberRule(int i10, int i11) {
        if (i11 == 1) {
            return new UnpaddedNumberField(i10);
        }
        if (i11 != 2) {
            return new PaddedNumberField(i10, i11);
        }
        return new TwoDigitNumberField(i10);
    }

    public String toString() {
        return "FastDatePrinter[" + this.mPattern + "," + ((Object) this.mLocale) + "," + this.mTimeZone.getID() + "]";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class DayInWeekField implements NumberRule {
        private final NumberRule mRule;

        public DayInWeekField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i10 = calendar.get(7);
            this.mRule.appendTo(appendable, i10 != 1 ? i10 - 1 : 7);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i10) throws IOException {
            this.mRule.appendTo(appendable, i10);
        }
    }

    private <B extends Appendable> B applyRules(Calendar calendar, B b4) {
        try {
            for (Rule rule : this.mRules) {
                rule.appendTo(b4, calendar);
            }
        } catch (IOException e2) {
            ExceptionUtils.rethrow(e2);
        }
        return b4;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class TwelveHourField implements NumberRule {
        private final NumberRule mRule;

        public TwelveHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i10 = calendar.get(10);
            if (i10 == 0) {
                i10 = calendar.getLeastMaximum(10) + 1;
            }
            this.mRule.appendTo(appendable, i10);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i10) throws IOException {
            this.mRule.appendTo(appendable, i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class TwentyFourHourField implements NumberRule {
        private final NumberRule mRule;

        public TwentyFourHourField(NumberRule numberRule) {
            this.mRule = numberRule;
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public void appendTo(Appendable appendable, Calendar calendar) throws IOException {
            int i10 = calendar.get(11);
            if (i10 == 0) {
                i10 = calendar.getMaximum(11) + 1;
            }
            this.mRule.appendTo(appendable, i10);
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.Rule
        public int estimateLength() {
            return this.mRule.estimateLength();
        }

        @Override // org.apache.commons.lang3.time.FastDatePrinter.NumberRule
        public void appendTo(Appendable appendable, int i10) throws IOException {
            this.mRule.appendTo(appendable, i10);
        }
    }

    public String format(Object obj) {
        if (obj instanceof Date) {
            return format((Date) obj);
        }
        if (obj instanceof Calendar) {
            return format((Calendar) obj);
        }
        if (obj instanceof Long) {
            return format(((Long) obj).longValue());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unknown class: ");
        sb2.append(obj == null ? "<null>" : obj.getClass().getName());
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(long j10) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j10);
        return applyRulesToString(newCalendar);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Date date) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return applyRulesToString(newCalendar);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public String format(Calendar calendar) {
        return ((StringBuilder) format(calendar, (Calendar) new StringBuilder(this.mMaxLengthEstimate))).toString();
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(long j10, StringBuffer stringBuffer) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j10);
        return (StringBuffer) applyRules(newCalendar, (Calendar) stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Date date, StringBuffer stringBuffer) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return (StringBuffer) applyRules(newCalendar, (Calendar) stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer) {
        return format(calendar.getTime(), stringBuffer);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(long j10, B b4) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTimeInMillis(j10);
        return (B) applyRules(newCalendar, (Calendar) b4);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Date date, B b4) {
        Calendar newCalendar = newCalendar();
        newCalendar.setTime(date);
        return (B) applyRules(newCalendar, (Calendar) b4);
    }

    @Override // org.apache.commons.lang3.time.DatePrinter
    public <B extends Appendable> B format(Calendar calendar, B b4) {
        if (!calendar.getTimeZone().equals(this.mTimeZone)) {
            calendar = (Calendar) calendar.clone();
            calendar.setTimeZone(this.mTimeZone);
        }
        return (B) applyRules(calendar, (Calendar) b4);
    }
}
