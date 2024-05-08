package java.text;

import com.alibaba.security.realidentity.build.cg;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.cardmanager.util.CardUriUtils;
import com.wangmai.okhttp.model.Progress;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.Format;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import libcore.icu.DecimalFormatData;
import libcore.icu.ICU;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class NumberFormat extends Format {
    private static final int CURRENCYSTYLE = 1;
    public static final int FRACTION_FIELD = 1;
    private static final int INTEGERSTYLE = 3;
    public static final int INTEGER_FIELD = 0;
    private static final int NUMBERSTYLE = 0;
    private static final int PERCENTSTYLE = 2;
    static final int currentSerialVersion = 1;
    static final long serialVersionUID = -2308460125733713944L;
    private boolean groupingUsed = true;
    private byte maxIntegerDigits = 40;
    private byte minIntegerDigits = 1;
    private byte maxFractionDigits = 3;
    private byte minFractionDigits = 0;
    private boolean parseIntegerOnly = false;
    private int maximumIntegerDigits = 40;
    private int minimumIntegerDigits = 1;
    private int maximumFractionDigits = 3;
    private int minimumFractionDigits = 0;
    private int serialVersionOnStream = 1;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private enum Style {
    }

    public abstract StringBuffer format(double d10, StringBuffer stringBuffer, FieldPosition fieldPosition);

    public abstract StringBuffer format(long j10, StringBuffer stringBuffer, FieldPosition fieldPosition);

    public abstract Number parse(String str, ParsePosition parsePosition);

    @Override // java.text.Format
    public StringBuffer format(Object number, StringBuffer toAppendTo, FieldPosition pos) {
        if ((number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte) || (number instanceof AtomicInteger) || (number instanceof AtomicLong) || ((number instanceof BigInteger) && ((BigInteger) number).bitLength() < 64)) {
            return format(((Number) number).longValue(), toAppendTo, pos);
        }
        if (number instanceof Number) {
            return format(((Number) number).doubleValue(), toAppendTo, pos);
        }
        throw new IllegalArgumentException("Cannot format given Object as a Number");
    }

    @Override // java.text.Format
    public final Object parseObject(String source, ParsePosition pos) {
        return parse(source, pos);
    }

    public final String format(double number) {
        return format(number, new StringBuffer(), DontCareFieldPosition.INSTANCE).toString();
    }

    public final String format(long number) {
        return format(number, new StringBuffer(), DontCareFieldPosition.INSTANCE).toString();
    }

    public Number parse(String source) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Number result = parse(source, parsePosition);
        if (parsePosition.index == 0) {
            throw new ParseException("Unparseable number: \"" + source + "\"", parsePosition.errorIndex);
        }
        return result;
    }

    public boolean isParseIntegerOnly() {
        return this.parseIntegerOnly;
    }

    public void setParseIntegerOnly(boolean value) {
        this.parseIntegerOnly = value;
    }

    public static final NumberFormat getInstance() {
        return getInstance(Locale.getDefault(Locale.Category.FORMAT), null, 0);
    }

    public static NumberFormat getInstance(Locale inLocale) {
        return getInstance(inLocale, null, 0);
    }

    public static final NumberFormat getNumberInstance() {
        return getInstance(Locale.getDefault(Locale.Category.FORMAT), null, 0);
    }

    public static NumberFormat getNumberInstance(Locale inLocale) {
        return getInstance(inLocale, null, 0);
    }

    public static final NumberFormat getIntegerInstance() {
        return getInstance(Locale.getDefault(Locale.Category.FORMAT), null, 3);
    }

    public static NumberFormat getIntegerInstance(Locale inLocale) {
        return getInstance(inLocale, null, 3);
    }

    public static final NumberFormat getCurrencyInstance() {
        return getInstance(Locale.getDefault(Locale.Category.FORMAT), null, 1);
    }

    public static NumberFormat getCurrencyInstance(Locale inLocale) {
        return getInstance(inLocale, null, 1);
    }

    public static final NumberFormat getPercentInstance() {
        return getInstance(Locale.getDefault(Locale.Category.FORMAT), null, 2);
    }

    public static NumberFormat getPercentInstance(Locale inLocale) {
        return getInstance(inLocale, null, 2);
    }

    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableLocales();
    }

    public int hashCode() {
        return (this.maximumIntegerDigits * 37) + this.maxFractionDigits;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        NumberFormat other = (NumberFormat) obj;
        if (this.maximumIntegerDigits != other.maximumIntegerDigits || this.minimumIntegerDigits != other.minimumIntegerDigits || this.maximumFractionDigits != other.maximumFractionDigits || this.minimumFractionDigits != other.minimumFractionDigits || this.groupingUsed != other.groupingUsed || this.parseIntegerOnly != other.parseIntegerOnly) {
            return false;
        }
        return true;
    }

    @Override // java.text.Format
    public Object clone() {
        NumberFormat other = (NumberFormat) super.clone();
        return other;
    }

    public boolean isGroupingUsed() {
        return this.groupingUsed;
    }

    public void setGroupingUsed(boolean newValue) {
        this.groupingUsed = newValue;
    }

    public int getMaximumIntegerDigits() {
        return this.maximumIntegerDigits;
    }

    public void setMaximumIntegerDigits(int newValue) {
        int max = Math.max(0, newValue);
        this.maximumIntegerDigits = max;
        if (this.minimumIntegerDigits > max) {
            this.minimumIntegerDigits = max;
        }
    }

    public int getMinimumIntegerDigits() {
        return this.minimumIntegerDigits;
    }

    public void setMinimumIntegerDigits(int newValue) {
        int max = Math.max(0, newValue);
        this.minimumIntegerDigits = max;
        if (max > this.maximumIntegerDigits) {
            this.maximumIntegerDigits = max;
        }
    }

    public int getMaximumFractionDigits() {
        return this.maximumFractionDigits;
    }

    public void setMaximumFractionDigits(int newValue) {
        int max = Math.max(0, newValue);
        this.maximumFractionDigits = max;
        if (max < this.minimumFractionDigits) {
            this.minimumFractionDigits = max;
        }
    }

    public int getMinimumFractionDigits() {
        return this.minimumFractionDigits;
    }

    public void setMinimumFractionDigits(int newValue) {
        int max = Math.max(0, newValue);
        this.minimumFractionDigits = max;
        if (this.maximumFractionDigits < max) {
            this.maximumFractionDigits = max;
        }
    }

    public Currency getCurrency() {
        throw new UnsupportedOperationException();
    }

    public void setCurrency(Currency currency) {
        throw new UnsupportedOperationException();
    }

    public RoundingMode getRoundingMode() {
        throw new UnsupportedOperationException();
    }

    public void setRoundingMode(RoundingMode roundingMode) {
        throw new UnsupportedOperationException();
    }

    private static NumberFormat getInstance(Locale desiredLocale, Style formatStyle, int choice) {
        DecimalFormatData data = DecimalFormatData.getInstance(desiredLocale);
        String[] numberPatterns = {data.getNumberPattern(), data.getCurrencyPattern(), data.getPercentPattern()};
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance(desiredLocale);
        int entry = choice == 3 ? 0 : choice;
        DecimalFormat numberFormat = new DecimalFormat(numberPatterns[entry], symbols);
        if (choice == 3) {
            numberFormat.setMaximumFractionDigits(0);
            numberFormat.setDecimalSeparatorAlwaysShown(false);
            numberFormat.setParseIntegerOnly(true);
        } else if (choice == 1) {
            numberFormat.adjustForCurrencyDefaultFractionDigits();
        }
        return numberFormat;
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        int i10;
        stream.defaultReadObject();
        if (this.serialVersionOnStream < 1) {
            this.maximumIntegerDigits = this.maxIntegerDigits;
            this.minimumIntegerDigits = this.minIntegerDigits;
            this.maximumFractionDigits = this.maxFractionDigits;
            this.minimumFractionDigits = this.minFractionDigits;
        }
        int i11 = this.minimumIntegerDigits;
        if (i11 > this.maximumIntegerDigits || (i10 = this.minimumFractionDigits) > this.maximumFractionDigits || i11 < 0 || i10 < 0) {
            throw new InvalidObjectException("Digit count range invalid");
        }
        this.serialVersionOnStream = 1;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        int i10 = this.maximumIntegerDigits;
        byte b4 = Byte.MAX_VALUE;
        this.maxIntegerDigits = i10 > 127 ? Byte.MAX_VALUE : (byte) i10;
        int i11 = this.minimumIntegerDigits;
        this.minIntegerDigits = i11 > 127 ? Byte.MAX_VALUE : (byte) i11;
        int i12 = this.maximumFractionDigits;
        this.maxFractionDigits = i12 > 127 ? Byte.MAX_VALUE : (byte) i12;
        int i13 = this.minimumFractionDigits;
        if (i13 <= 127) {
            b4 = (byte) i13;
        }
        this.minFractionDigits = b4;
        stream.defaultWriteObject();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Field extends Format.Field {
        private static final long serialVersionUID = 7494728892700160890L;
        private static final Map<String, Field> instanceMap = new HashMap(11);
        public static final Field INTEGER = new Field("integer");
        public static final Field FRACTION = new Field(Progress.FRACTION);
        public static final Field EXPONENT = new Field("exponent");
        public static final Field DECIMAL_SEPARATOR = new Field("decimal separator");
        public static final Field SIGN = new Field(CardUriUtils.PARAM_SIGN);
        public static final Field GROUPING_SEPARATOR = new Field("grouping separator");
        public static final Field EXPONENT_SYMBOL = new Field("exponent symbol");
        public static final Field PERCENT = new Field(Attributes.Style.PERCENT);
        public static final Field PERMILLE = new Field("per mille");
        public static final Field CURRENCY = new Field("currency");
        public static final Field EXPONENT_SIGN = new Field("exponent sign");
        public static final Field PREFIX = new Field(cg.f3323m);
        public static final Field SUFFIX = new Field("suffix");

        protected Field(String name) {
            super(name);
            if (getClass() == Field.class) {
                instanceMap.put(name, this);
            }
        }

        @Override // java.text.AttributedCharacterIterator.Attribute
        protected Object readResolve() throws InvalidObjectException {
            if (getClass() != Field.class) {
                throw new InvalidObjectException("subclass didn't correctly implement readResolve");
            }
            Object instance = instanceMap.get(getName());
            if (instance != null) {
                return instance;
            }
            throw new InvalidObjectException("unknown attribute name");
        }
    }
}
