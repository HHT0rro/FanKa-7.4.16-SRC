package java.text;

import android.icu.text.NumberFormat;
import com.android.icu.text.CompatibleDecimalFormatFactory;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.AttributedCharacterIterator;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import libcore.icu.DecimalFormatData;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DecimalFormat extends NumberFormat {
    static final int DOUBLE_FRACTION_DIGITS = 340;
    static final int DOUBLE_INTEGER_DIGITS = 309;
    static final int MAXIMUM_FRACTION_DIGITS = Integer.MAX_VALUE;
    static final int MAXIMUM_INTEGER_DIGITS = Integer.MAX_VALUE;
    static final int currentSerialVersion = 4;
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("positivePrefix", String.class), new ObjectStreamField("positiveSuffix", String.class), new ObjectStreamField("negativePrefix", String.class), new ObjectStreamField("negativeSuffix", String.class), new ObjectStreamField("posPrefixPattern", String.class), new ObjectStreamField("posSuffixPattern", String.class), new ObjectStreamField("negPrefixPattern", String.class), new ObjectStreamField("negSuffixPattern", String.class), new ObjectStreamField("multiplier", Integer.TYPE), new ObjectStreamField("groupingSize", Byte.TYPE), new ObjectStreamField("groupingUsed", Boolean.TYPE), new ObjectStreamField("decimalSeparatorAlwaysShown", Boolean.TYPE), new ObjectStreamField("parseBigDecimal", Boolean.TYPE), new ObjectStreamField("roundingMode", RoundingMode.class), new ObjectStreamField("symbols", DecimalFormatSymbols.class), new ObjectStreamField("useExponentialNotation", Boolean.TYPE), new ObjectStreamField("minExponentDigits", Byte.TYPE), new ObjectStreamField("maximumIntegerDigits", Integer.TYPE), new ObjectStreamField("minimumIntegerDigits", Integer.TYPE), new ObjectStreamField("maximumFractionDigits", Integer.TYPE), new ObjectStreamField("minimumFractionDigits", Integer.TYPE), new ObjectStreamField("serialVersionOnStream", Integer.TYPE)};
    static final long serialVersionUID = 864413376551465018L;
    private transient android.icu.text.DecimalFormat icuDecimalFormat;
    private int maximumFractionDigits;
    private int maximumIntegerDigits;
    private int minimumFractionDigits;
    private int minimumIntegerDigits;
    private RoundingMode roundingMode = RoundingMode.HALF_EVEN;
    private DecimalFormatSymbols symbols;

    public DecimalFormat() {
        this.symbols = null;
        Locale def = Locale.getDefault(Locale.Category.FORMAT);
        String pattern = DecimalFormatData.getInstance(def).getNumberPattern();
        this.symbols = DecimalFormatSymbols.getInstance(def);
        initPattern(pattern);
    }

    public DecimalFormat(String pattern) {
        this.symbols = null;
        this.symbols = DecimalFormatSymbols.getInstance(Locale.getDefault(Locale.Category.FORMAT));
        initPattern(pattern);
    }

    public DecimalFormat(String pattern, DecimalFormatSymbols symbols) {
        this.symbols = null;
        this.symbols = (DecimalFormatSymbols) symbols.clone();
        initPattern(pattern);
    }

    private void initPattern(String pattern) {
        this.icuDecimalFormat = CompatibleDecimalFormatFactory.create(pattern, this.symbols.getIcuDecimalFormatSymbols());
        updateFieldsFromIcu();
    }

    private void updateFieldsFromIcu() {
        if (this.icuDecimalFormat.getMaximumIntegerDigits() == 309) {
            this.icuDecimalFormat.setMaximumIntegerDigits(2000000000);
        }
        this.maximumIntegerDigits = this.icuDecimalFormat.getMaximumIntegerDigits();
        this.minimumIntegerDigits = this.icuDecimalFormat.getMinimumIntegerDigits();
        this.maximumFractionDigits = this.icuDecimalFormat.getMaximumFractionDigits();
        this.minimumFractionDigits = this.icuDecimalFormat.getMinimumFractionDigits();
    }

    private static FieldPosition getIcuFieldPosition(FieldPosition fp) {
        NumberFormat.Field attribute;
        Format.Field fieldAttribute = fp.getFieldAttribute();
        if (fieldAttribute == null) {
            return fp;
        }
        if (fieldAttribute == NumberFormat.Field.INTEGER) {
            attribute = NumberFormat.Field.INTEGER;
        } else if (fieldAttribute == NumberFormat.Field.FRACTION) {
            attribute = NumberFormat.Field.FRACTION;
        } else if (fieldAttribute == NumberFormat.Field.DECIMAL_SEPARATOR) {
            attribute = NumberFormat.Field.DECIMAL_SEPARATOR;
        } else if (fieldAttribute == NumberFormat.Field.EXPONENT_SYMBOL) {
            attribute = NumberFormat.Field.EXPONENT_SYMBOL;
        } else if (fieldAttribute == NumberFormat.Field.EXPONENT_SIGN) {
            attribute = NumberFormat.Field.EXPONENT_SIGN;
        } else if (fieldAttribute == NumberFormat.Field.EXPONENT) {
            attribute = NumberFormat.Field.EXPONENT;
        } else if (fieldAttribute == NumberFormat.Field.GROUPING_SEPARATOR) {
            attribute = NumberFormat.Field.GROUPING_SEPARATOR;
        } else if (fieldAttribute == NumberFormat.Field.CURRENCY) {
            attribute = NumberFormat.Field.CURRENCY;
        } else if (fieldAttribute == NumberFormat.Field.PERCENT) {
            attribute = NumberFormat.Field.PERCENT;
        } else if (fieldAttribute == NumberFormat.Field.PERMILLE) {
            attribute = NumberFormat.Field.PERMILLE;
        } else if (fieldAttribute == NumberFormat.Field.SIGN) {
            attribute = NumberFormat.Field.SIGN;
        } else {
            throw new IllegalArgumentException("Unexpected field position attribute type.");
        }
        FieldPosition icuFieldPosition = new FieldPosition(attribute);
        icuFieldPosition.setBeginIndex(fp.getBeginIndex());
        icuFieldPosition.setEndIndex(fp.getEndIndex());
        return icuFieldPosition;
    }

    private static NumberFormat.Field toJavaFieldAttribute(AttributedCharacterIterator.Attribute icuAttribute) {
        String name = icuAttribute.getName();
        if (name.equals(NumberFormat.Field.INTEGER.getName())) {
            return NumberFormat.Field.INTEGER;
        }
        if (name.equals(NumberFormat.Field.CURRENCY.getName())) {
            return NumberFormat.Field.CURRENCY;
        }
        if (name.equals(NumberFormat.Field.DECIMAL_SEPARATOR.getName())) {
            return NumberFormat.Field.DECIMAL_SEPARATOR;
        }
        if (name.equals(NumberFormat.Field.EXPONENT.getName())) {
            return NumberFormat.Field.EXPONENT;
        }
        if (name.equals(NumberFormat.Field.EXPONENT_SIGN.getName())) {
            return NumberFormat.Field.EXPONENT_SIGN;
        }
        if (name.equals(NumberFormat.Field.EXPONENT_SYMBOL.getName())) {
            return NumberFormat.Field.EXPONENT_SYMBOL;
        }
        if (name.equals(NumberFormat.Field.FRACTION.getName())) {
            return NumberFormat.Field.FRACTION;
        }
        if (name.equals(NumberFormat.Field.GROUPING_SEPARATOR.getName())) {
            return NumberFormat.Field.GROUPING_SEPARATOR;
        }
        if (name.equals(NumberFormat.Field.SIGN.getName())) {
            return NumberFormat.Field.SIGN;
        }
        if (name.equals(NumberFormat.Field.PERCENT.getName())) {
            return NumberFormat.Field.PERCENT;
        }
        if (name.equals(NumberFormat.Field.PERMILLE.getName())) {
            return NumberFormat.Field.PERMILLE;
        }
        throw new IllegalArgumentException("Unrecognized attribute: " + name);
    }

    @Override // java.text.NumberFormat, java.text.Format
    public final StringBuffer format(Object number, StringBuffer toAppendTo, FieldPosition pos) {
        if ((number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte) || (number instanceof AtomicInteger) || (number instanceof AtomicLong) || ((number instanceof BigInteger) && ((BigInteger) number).bitLength() < 64)) {
            return format(((Number) number).longValue(), toAppendTo, pos);
        }
        if (number instanceof BigDecimal) {
            return format((BigDecimal) number, toAppendTo, pos);
        }
        if (number instanceof BigInteger) {
            return format((BigInteger) number, toAppendTo, pos);
        }
        if (number instanceof Number) {
            return format(((Number) number).doubleValue(), toAppendTo, pos);
        }
        throw new IllegalArgumentException("Cannot format given Object as a Number");
    }

    @Override // java.text.NumberFormat
    public StringBuffer format(double number, StringBuffer result, FieldPosition fieldPosition) {
        FieldPosition icuFieldPosition = getIcuFieldPosition(fieldPosition);
        this.icuDecimalFormat.format(number, result, icuFieldPosition);
        fieldPosition.setBeginIndex(icuFieldPosition.getBeginIndex());
        fieldPosition.setEndIndex(icuFieldPosition.getEndIndex());
        return result;
    }

    @Override // java.text.NumberFormat
    public StringBuffer format(long number, StringBuffer result, FieldPosition fieldPosition) {
        FieldPosition icuFieldPosition = getIcuFieldPosition(fieldPosition);
        this.icuDecimalFormat.format(number, result, icuFieldPosition);
        fieldPosition.setBeginIndex(icuFieldPosition.getBeginIndex());
        fieldPosition.setEndIndex(icuFieldPosition.getEndIndex());
        return result;
    }

    private StringBuffer format(BigDecimal number, StringBuffer result, FieldPosition fieldPosition) {
        FieldPosition icuFieldPosition = getIcuFieldPosition(fieldPosition);
        this.icuDecimalFormat.format(number, result, icuFieldPosition);
        fieldPosition.setBeginIndex(icuFieldPosition.getBeginIndex());
        fieldPosition.setEndIndex(icuFieldPosition.getEndIndex());
        return result;
    }

    private StringBuffer format(BigInteger number, StringBuffer result, FieldPosition fieldPosition) {
        FieldPosition icuFieldPosition = getIcuFieldPosition(fieldPosition);
        this.icuDecimalFormat.format(number, result, icuFieldPosition);
        fieldPosition.setBeginIndex(icuFieldPosition.getBeginIndex());
        fieldPosition.setEndIndex(icuFieldPosition.getEndIndex());
        return result;
    }

    @Override // java.text.Format
    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        if (obj == null) {
            throw new NullPointerException("object == null");
        }
        AttributedCharacterIterator original = this.icuDecimalFormat.formatToCharacterIterator(obj);
        StringBuilder textBuilder = new StringBuilder(original.getEndIndex() - original.getBeginIndex());
        for (int i10 = original.getBeginIndex(); i10 < original.getEndIndex(); i10++) {
            textBuilder.append(original.current());
            original.next();
        }
        AttributedString result = new AttributedString(textBuilder.toString());
        for (int i11 = original.getBeginIndex(); i11 < original.getEndIndex(); i11++) {
            original.setIndex(i11);
            for (AttributedCharacterIterator.Attribute attribute : original.getAttributes().h()) {
                int start = original.getRunStart();
                int end = original.getRunLimit();
                NumberFormat.Field javaAttr = toJavaFieldAttribute(attribute);
                result.addAttribute(javaAttr, javaAttr, start, end);
            }
        }
        return result.getIterator();
    }

    @Override // java.text.NumberFormat
    public Number parse(String text, ParsePosition pos) {
        Number number;
        if (pos.index < 0 || pos.index >= text.length() || (number = this.icuDecimalFormat.parse(text, pos)) == null) {
            return null;
        }
        if (isParseBigDecimal()) {
            if (number instanceof Long) {
                return new BigDecimal(number.longValue());
            }
            if ((number instanceof Double) && !((Double) number).isInfinite() && !((Double) number).isNaN()) {
                return new BigDecimal(number.toString());
            }
            if ((number instanceof Double) && (((Double) number).isNaN() || ((Double) number).isInfinite())) {
                return number;
            }
            if (number instanceof android.icu.math.BigDecimal) {
                return ((android.icu.math.BigDecimal) number).toBigDecimal();
            }
        }
        if ((number instanceof android.icu.math.BigDecimal) || (number instanceof BigInteger)) {
            return Double.valueOf(number.doubleValue());
        }
        if (isParseIntegerOnly() && number.equals(new Double(-0.0d))) {
            return 0L;
        }
        return number;
    }

    public DecimalFormatSymbols getDecimalFormatSymbols() {
        return DecimalFormatSymbols.fromIcuInstance(this.icuDecimalFormat.getDecimalFormatSymbols());
    }

    public void setDecimalFormatSymbols(DecimalFormatSymbols newSymbols) {
        try {
            DecimalFormatSymbols decimalFormatSymbols = (DecimalFormatSymbols) newSymbols.clone();
            this.symbols = decimalFormatSymbols;
            this.icuDecimalFormat.setDecimalFormatSymbols(decimalFormatSymbols.getIcuDecimalFormatSymbols());
        } catch (Exception e2) {
        }
    }

    public String getPositivePrefix() {
        return this.icuDecimalFormat.getPositivePrefix();
    }

    public void setPositivePrefix(String newValue) {
        this.icuDecimalFormat.setPositivePrefix(newValue);
    }

    public String getNegativePrefix() {
        return this.icuDecimalFormat.getNegativePrefix();
    }

    public void setNegativePrefix(String newValue) {
        this.icuDecimalFormat.setNegativePrefix(newValue);
    }

    public String getPositiveSuffix() {
        return this.icuDecimalFormat.getPositiveSuffix();
    }

    public void setPositiveSuffix(String newValue) {
        this.icuDecimalFormat.setPositiveSuffix(newValue);
    }

    public String getNegativeSuffix() {
        return this.icuDecimalFormat.getNegativeSuffix();
    }

    public void setNegativeSuffix(String newValue) {
        this.icuDecimalFormat.setNegativeSuffix(newValue);
    }

    public int getMultiplier() {
        return this.icuDecimalFormat.getMultiplier();
    }

    public void setMultiplier(int newValue) {
        this.icuDecimalFormat.setMultiplier(newValue);
    }

    @Override // java.text.NumberFormat
    public void setGroupingUsed(boolean newValue) {
        this.icuDecimalFormat.setGroupingUsed(newValue);
    }

    @Override // java.text.NumberFormat
    public boolean isGroupingUsed() {
        return this.icuDecimalFormat.isGroupingUsed();
    }

    public int getGroupingSize() {
        return this.icuDecimalFormat.getGroupingSize();
    }

    public void setGroupingSize(int newValue) {
        if (newValue < 0 || newValue > 127) {
            throw new IllegalArgumentException("newValue is out of valid range. value: " + newValue);
        }
        this.icuDecimalFormat.setGroupingSize(newValue);
    }

    public boolean isDecimalSeparatorAlwaysShown() {
        return this.icuDecimalFormat.isDecimalSeparatorAlwaysShown();
    }

    public void setDecimalSeparatorAlwaysShown(boolean newValue) {
        this.icuDecimalFormat.setDecimalSeparatorAlwaysShown(newValue);
    }

    public boolean isParseBigDecimal() {
        return this.icuDecimalFormat.isParseBigDecimal();
    }

    public void setParseBigDecimal(boolean newValue) {
        this.icuDecimalFormat.setParseBigDecimal(newValue);
    }

    @Override // java.text.NumberFormat
    public boolean isParseIntegerOnly() {
        return this.icuDecimalFormat.isParseIntegerOnly();
    }

    @Override // java.text.NumberFormat
    public void setParseIntegerOnly(boolean value) {
        super.setParseIntegerOnly(value);
        this.icuDecimalFormat.setParseIntegerOnly(value);
    }

    @Override // java.text.NumberFormat, java.text.Format
    public Object clone() {
        try {
            DecimalFormat other = (DecimalFormat) super.clone();
            other.icuDecimalFormat = (android.icu.text.DecimalFormat) this.icuDecimalFormat.clone();
            other.symbols = (DecimalFormatSymbols) this.symbols.clone();
            return other;
        } catch (Exception e2) {
            throw new InternalError();
        }
    }

    @Override // java.text.NumberFormat
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecimalFormat)) {
            return false;
        }
        DecimalFormat other = (DecimalFormat) obj;
        if (!this.icuDecimalFormat.equals(other.icuDecimalFormat) || !compareIcuRoundingIncrement(other.icuDecimalFormat)) {
            return false;
        }
        return true;
    }

    private boolean compareIcuRoundingIncrement(android.icu.text.DecimalFormat other) {
        BigDecimal increment = this.icuDecimalFormat.getRoundingIncrement();
        return increment != null ? other.getRoundingIncrement() != null && increment.equals(other.getRoundingIncrement()) : other.getRoundingIncrement() == null;
    }

    @Override // java.text.NumberFormat
    public int hashCode() {
        return (super.hashCode() * 37) + getPositivePrefix().hashCode();
    }

    public String toPattern() {
        return this.icuDecimalFormat.toPattern();
    }

    public String toLocalizedPattern() {
        return this.icuDecimalFormat.toLocalizedPattern();
    }

    public void applyPattern(String pattern) {
        this.icuDecimalFormat.applyPattern(pattern);
        updateFieldsFromIcu();
    }

    public void applyLocalizedPattern(String pattern) {
        this.icuDecimalFormat.applyLocalizedPattern(pattern);
        updateFieldsFromIcu();
    }

    @Override // java.text.NumberFormat
    public void setMaximumIntegerDigits(int newValue) {
        int min = Math.min(Math.max(0, newValue), Integer.MAX_VALUE);
        this.maximumIntegerDigits = min;
        if (min > 309) {
            min = 309;
        }
        super.setMaximumIntegerDigits(min);
        int i10 = this.minimumIntegerDigits;
        int i11 = this.maximumIntegerDigits;
        if (i10 > i11) {
            this.minimumIntegerDigits = i11;
            super.setMinimumIntegerDigits(i11 <= 309 ? i11 : 309);
        }
        this.icuDecimalFormat.setMaximumIntegerDigits(getMaximumIntegerDigits());
    }

    @Override // java.text.NumberFormat
    public void setMinimumIntegerDigits(int newValue) {
        int min = Math.min(Math.max(0, newValue), Integer.MAX_VALUE);
        this.minimumIntegerDigits = min;
        if (min > 309) {
            min = 309;
        }
        super.setMinimumIntegerDigits(min);
        int i10 = this.minimumIntegerDigits;
        if (i10 > this.maximumIntegerDigits) {
            this.maximumIntegerDigits = i10;
            super.setMaximumIntegerDigits(i10 <= 309 ? i10 : 309);
        }
        this.icuDecimalFormat.setMinimumIntegerDigits(getMinimumIntegerDigits());
    }

    @Override // java.text.NumberFormat
    public void setMaximumFractionDigits(int newValue) {
        int min = Math.min(Math.max(0, newValue), Integer.MAX_VALUE);
        this.maximumFractionDigits = min;
        if (min > 340) {
            min = 340;
        }
        super.setMaximumFractionDigits(min);
        int i10 = this.minimumFractionDigits;
        int i11 = this.maximumFractionDigits;
        if (i10 > i11) {
            this.minimumFractionDigits = i11;
            super.setMinimumFractionDigits(i11 <= 340 ? i11 : 340);
        }
        this.icuDecimalFormat.setMaximumFractionDigits(getMaximumFractionDigits());
    }

    @Override // java.text.NumberFormat
    public void setMinimumFractionDigits(int newValue) {
        int min = Math.min(Math.max(0, newValue), Integer.MAX_VALUE);
        this.minimumFractionDigits = min;
        if (min > 340) {
            min = 340;
        }
        super.setMinimumFractionDigits(min);
        int i10 = this.minimumFractionDigits;
        if (i10 > this.maximumFractionDigits) {
            this.maximumFractionDigits = i10;
            super.setMaximumFractionDigits(i10 <= 340 ? i10 : 340);
        }
        this.icuDecimalFormat.setMinimumFractionDigits(getMinimumFractionDigits());
    }

    @Override // java.text.NumberFormat
    public int getMaximumIntegerDigits() {
        return this.maximumIntegerDigits;
    }

    @Override // java.text.NumberFormat
    public int getMinimumIntegerDigits() {
        return this.minimumIntegerDigits;
    }

    @Override // java.text.NumberFormat
    public int getMaximumFractionDigits() {
        return this.maximumFractionDigits;
    }

    @Override // java.text.NumberFormat
    public int getMinimumFractionDigits() {
        return this.minimumFractionDigits;
    }

    @Override // java.text.NumberFormat
    public Currency getCurrency() {
        return this.symbols.getCurrency();
    }

    @Override // java.text.NumberFormat
    public void setCurrency(Currency currency) {
        if (currency != this.symbols.getCurrency() || !currency.getSymbol().equals(this.symbols.getCurrencySymbol())) {
            this.symbols.setCurrency(currency);
            this.icuDecimalFormat.setDecimalFormatSymbols(this.symbols.getIcuDecimalFormatSymbols());
            this.icuDecimalFormat.setMinimumFractionDigits(this.minimumFractionDigits);
            this.icuDecimalFormat.setMaximumFractionDigits(this.maximumFractionDigits);
        }
    }

    @Override // java.text.NumberFormat
    public RoundingMode getRoundingMode() {
        return this.roundingMode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.text.DecimalFormat$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = iArr;
            try {
                iArr[RoundingMode.UP.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UNNECESSARY.ordinal()] = 8;
            } catch (NoSuchFieldError e16) {
            }
        }
    }

    private static int convertRoundingMode(RoundingMode rm) {
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[rm.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            default:
                throw new IllegalArgumentException("Invalid rounding mode specified");
        }
    }

    @Override // java.text.NumberFormat
    public void setRoundingMode(RoundingMode roundingMode) {
        if (roundingMode == null) {
            throw new NullPointerException();
        }
        this.roundingMode = roundingMode;
        this.icuDecimalFormat.setRoundingMode(convertRoundingMode(roundingMode));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void adjustForCurrencyDefaultFractionDigits() {
        int digits;
        Currency currency = this.symbols.getCurrency();
        if (currency == null) {
            try {
                currency = Currency.getInstance(this.symbols.getInternationalCurrencySymbol());
            } catch (IllegalArgumentException e2) {
            }
        }
        if (currency != null && (digits = currency.getDefaultFractionDigits()) != -1) {
            int oldMinDigits = getMinimumFractionDigits();
            if (oldMinDigits == getMaximumFractionDigits()) {
                setMinimumFractionDigits(digits);
                setMaximumFractionDigits(digits);
            } else {
                setMinimumFractionDigits(Math.min(digits, oldMinDigits));
                setMaximumFractionDigits(digits);
            }
        }
    }

    private void writeObject(ObjectOutputStream stream) throws IOException, ClassNotFoundException {
        ObjectOutputStream.PutField fields = stream.putFields();
        fields.put("positivePrefix", this.icuDecimalFormat.getPositivePrefix());
        fields.put("positiveSuffix", this.icuDecimalFormat.getPositiveSuffix());
        fields.put("negativePrefix", this.icuDecimalFormat.getNegativePrefix());
        fields.put("negativeSuffix", this.icuDecimalFormat.getNegativeSuffix());
        fields.put("posPrefixPattern", (Object) null);
        fields.put("posSuffixPattern", (Object) null);
        fields.put("negPrefixPattern", (Object) null);
        fields.put("negSuffixPattern", (Object) null);
        fields.put("multiplier", this.icuDecimalFormat.getMultiplier());
        fields.put("groupingSize", (byte) this.icuDecimalFormat.getGroupingSize());
        fields.put("groupingUsed", this.icuDecimalFormat.isGroupingUsed());
        fields.put("decimalSeparatorAlwaysShown", this.icuDecimalFormat.isDecimalSeparatorAlwaysShown());
        fields.put("parseBigDecimal", this.icuDecimalFormat.isParseBigDecimal());
        fields.put("roundingMode", this.roundingMode);
        fields.put("symbols", this.symbols);
        fields.put("useExponentialNotation", false);
        fields.put("minExponentDigits", (byte) 0);
        fields.put("maximumIntegerDigits", this.icuDecimalFormat.getMaximumIntegerDigits());
        fields.put("minimumIntegerDigits", this.icuDecimalFormat.getMinimumIntegerDigits());
        fields.put("maximumFractionDigits", this.icuDecimalFormat.getMaximumFractionDigits());
        fields.put("minimumFractionDigits", this.icuDecimalFormat.getMinimumFractionDigits());
        fields.put("serialVersionOnStream", 4);
        stream.writeFields();
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = stream.readFields();
        this.symbols = (DecimalFormatSymbols) fields.get("symbols", (Object) null);
        initPattern("#");
        String positivePrefix = (String) fields.get("positivePrefix", "");
        if (!Objects.equals(positivePrefix, this.icuDecimalFormat.getPositivePrefix())) {
            this.icuDecimalFormat.setPositivePrefix(positivePrefix);
        }
        String positiveSuffix = (String) fields.get("positiveSuffix", "");
        if (!Objects.equals(positiveSuffix, this.icuDecimalFormat.getPositiveSuffix())) {
            this.icuDecimalFormat.setPositiveSuffix(positiveSuffix);
        }
        String negativePrefix = (String) fields.get("negativePrefix", "-");
        if (!Objects.equals(negativePrefix, this.icuDecimalFormat.getNegativePrefix())) {
            this.icuDecimalFormat.setNegativePrefix(negativePrefix);
        }
        String negativeSuffix = (String) fields.get("negativeSuffix", "");
        if (!Objects.equals(negativeSuffix, this.icuDecimalFormat.getNegativeSuffix())) {
            this.icuDecimalFormat.setNegativeSuffix(negativeSuffix);
        }
        int multiplier = fields.get("multiplier", 1);
        if (multiplier != this.icuDecimalFormat.getMultiplier()) {
            this.icuDecimalFormat.setMultiplier(multiplier);
        }
        boolean groupingUsed = fields.get("groupingUsed", true);
        if (groupingUsed != this.icuDecimalFormat.isGroupingUsed()) {
            this.icuDecimalFormat.setGroupingUsed(groupingUsed);
        }
        int groupingSize = fields.get("groupingSize", (byte) 3);
        if (groupingSize != this.icuDecimalFormat.getGroupingSize()) {
            this.icuDecimalFormat.setGroupingSize(groupingSize);
        }
        boolean decimalSeparatorAlwaysShown = fields.get("decimalSeparatorAlwaysShown", false);
        if (decimalSeparatorAlwaysShown != this.icuDecimalFormat.isDecimalSeparatorAlwaysShown()) {
            this.icuDecimalFormat.setDecimalSeparatorAlwaysShown(decimalSeparatorAlwaysShown);
        }
        RoundingMode roundingMode = (RoundingMode) fields.get("roundingMode", RoundingMode.HALF_EVEN);
        if (convertRoundingMode(roundingMode) != this.icuDecimalFormat.getRoundingMode()) {
            setRoundingMode(roundingMode);
        }
        int maximumIntegerDigits = fields.get("maximumIntegerDigits", 309);
        if (maximumIntegerDigits != this.icuDecimalFormat.getMaximumIntegerDigits()) {
            this.icuDecimalFormat.setMaximumIntegerDigits(maximumIntegerDigits);
        }
        int minimumIntegerDigits = fields.get("minimumIntegerDigits", 309);
        if (minimumIntegerDigits != this.icuDecimalFormat.getMinimumIntegerDigits()) {
            this.icuDecimalFormat.setMinimumIntegerDigits(minimumIntegerDigits);
        }
        int maximumFractionDigits = fields.get("maximumFractionDigits", 340);
        if (maximumFractionDigits != this.icuDecimalFormat.getMaximumFractionDigits()) {
            this.icuDecimalFormat.setMaximumFractionDigits(maximumFractionDigits);
        }
        int minimumFractionDigits = fields.get("minimumFractionDigits", 340);
        if (minimumFractionDigits != this.icuDecimalFormat.getMinimumFractionDigits()) {
            this.icuDecimalFormat.setMinimumFractionDigits(minimumFractionDigits);
        }
        boolean parseBigDecimal = fields.get("parseBigDecimal", true);
        if (parseBigDecimal != this.icuDecimalFormat.isParseBigDecimal()) {
            this.icuDecimalFormat.setParseBigDecimal(parseBigDecimal);
        }
        updateFieldsFromIcu();
        if (fields.get("serialVersionOnStream", 0) < 3) {
            setMaximumIntegerDigits(super.getMaximumIntegerDigits());
            setMinimumIntegerDigits(super.getMinimumIntegerDigits());
            setMaximumFractionDigits(super.getMaximumFractionDigits());
            setMinimumFractionDigits(super.getMinimumFractionDigits());
        }
    }
}
