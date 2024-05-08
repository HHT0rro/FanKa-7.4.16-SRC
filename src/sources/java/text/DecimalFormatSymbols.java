package java.text;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.quickcard.base.Attributes;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Currency;
import java.util.Locale;
import java.util.Objects;
import libcore.icu.DecimalFormatData;
import libcore.icu.ICU;
import libcore.icu.LocaleData;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DecimalFormatSymbols implements Cloneable, Serializable {
    private static final int currentSerialVersion = 5;
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("currencySymbol", String.class), new ObjectStreamField("decimalSeparator", Character.TYPE), new ObjectStreamField("digit", Character.TYPE), new ObjectStreamField("exponential", Character.TYPE), new ObjectStreamField("exponentialSeparator", String.class), new ObjectStreamField("groupingSeparator", Character.TYPE), new ObjectStreamField("infinity", String.class), new ObjectStreamField("intlCurrencySymbol", String.class), new ObjectStreamField("minusSign", Character.TYPE), new ObjectStreamField("monetarySeparator", Character.TYPE), new ObjectStreamField("NaN", String.class), new ObjectStreamField("patternSeparator", Character.TYPE), new ObjectStreamField(Attributes.Style.PERCENT, Character.TYPE), new ObjectStreamField("perMill", Character.TYPE), new ObjectStreamField("serialVersionOnStream", Integer.TYPE), new ObjectStreamField("zeroDigit", Character.TYPE), new ObjectStreamField("locale", Locale.class), new ObjectStreamField("minusSignStr", String.class), new ObjectStreamField("percentStr", String.class), new ObjectStreamField("perMillText", String.class), new ObjectStreamField("percentText", String.class), new ObjectStreamField("minusSignText", String.class), new ObjectStreamField("monetaryGroupingSeparator", Character.TYPE)};
    static final long serialVersionUID = 5772796243397350300L;
    private String NaN;
    private transient Currency currency;
    private volatile transient boolean currencyInitialized;
    private String currencySymbol;
    private char decimalSeparator;
    private char digit;
    private char exponential;
    private String exponentialSeparator;
    private char groupingSeparator;
    private volatile transient int hashCode;
    private String infinity;
    private String intlCurrencySymbol;
    private Locale locale;
    private char minusSign;
    private String minusSignText;
    private char monetaryGroupingSeparator;
    private char monetarySeparator;
    private char patternSeparator;
    private char perMill;
    private String perMillText;
    private char percent;
    private String percentText;
    private char zeroDigit;
    private int serialVersionOnStream = 5;
    private transient android.icu.text.DecimalFormatSymbols cachedIcuDFS = null;

    public DecimalFormatSymbols() {
        initialize(Locale.getDefault(Locale.Category.FORMAT));
    }

    public DecimalFormatSymbols(Locale locale) {
        initialize(locale);
    }

    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableLocales();
    }

    public static final DecimalFormatSymbols getInstance() {
        return getInstance(Locale.getDefault(Locale.Category.FORMAT));
    }

    public static final DecimalFormatSymbols getInstance(Locale locale) {
        return new DecimalFormatSymbols(locale);
    }

    public char getZeroDigit() {
        return this.zeroDigit;
    }

    public void setZeroDigit(char zeroDigit) {
        this.hashCode = 0;
        this.zeroDigit = zeroDigit;
        this.cachedIcuDFS = null;
    }

    public char getGroupingSeparator() {
        return this.groupingSeparator;
    }

    public void setGroupingSeparator(char groupingSeparator) {
        this.hashCode = 0;
        this.groupingSeparator = groupingSeparator;
        this.cachedIcuDFS = null;
    }

    public char getDecimalSeparator() {
        return this.decimalSeparator;
    }

    public void setDecimalSeparator(char decimalSeparator) {
        this.hashCode = 0;
        this.decimalSeparator = decimalSeparator;
        this.cachedIcuDFS = null;
    }

    public char getPerMill() {
        return this.perMill;
    }

    public void setPerMill(char perMill) {
        this.hashCode = 0;
        this.perMill = perMill;
        this.perMillText = Character.toString(perMill);
        this.cachedIcuDFS = null;
    }

    public char getPercent() {
        return this.percent;
    }

    public String getPercentString() {
        return getPercentText();
    }

    public void setPercent(char percent) {
        this.hashCode = 0;
        this.percent = percent;
        this.percentText = Character.toString(percent);
        this.cachedIcuDFS = null;
    }

    public char getDigit() {
        return this.digit;
    }

    public void setDigit(char digit) {
        this.hashCode = 0;
        this.digit = digit;
        this.cachedIcuDFS = null;
    }

    public char getPatternSeparator() {
        return this.patternSeparator;
    }

    public void setPatternSeparator(char patternSeparator) {
        this.hashCode = 0;
        this.patternSeparator = patternSeparator;
        this.cachedIcuDFS = null;
    }

    public String getInfinity() {
        return this.infinity;
    }

    public void setInfinity(String infinity) {
        this.hashCode = 0;
        this.infinity = infinity;
        this.cachedIcuDFS = null;
    }

    public String getNaN() {
        return this.NaN;
    }

    public void setNaN(String NaN) {
        this.hashCode = 0;
        this.NaN = NaN;
        this.cachedIcuDFS = null;
    }

    public char getMinusSign() {
        return this.minusSign;
    }

    public void setMinusSign(char minusSign) {
        this.hashCode = 0;
        this.minusSign = minusSign;
        this.minusSignText = Character.toString(minusSign);
        this.cachedIcuDFS = null;
    }

    public String getCurrencySymbol() {
        initializeCurrency(this.locale);
        return this.currencySymbol;
    }

    public void setCurrencySymbol(String currency) {
        initializeCurrency(this.locale);
        this.hashCode = 0;
        this.currencySymbol = currency;
        this.cachedIcuDFS = null;
    }

    public String getInternationalCurrencySymbol() {
        initializeCurrency(this.locale);
        return this.intlCurrencySymbol;
    }

    public void setInternationalCurrencySymbol(String currencyCode) {
        initializeCurrency(this.locale);
        this.hashCode = 0;
        this.intlCurrencySymbol = currencyCode;
        this.currency = null;
        if (currencyCode != null) {
            try {
                Currency currency = Currency.getInstance(currencyCode);
                this.currency = currency;
                this.currencySymbol = currency.getSymbol(this.locale);
            } catch (IllegalArgumentException e2) {
            }
        }
        this.cachedIcuDFS = null;
    }

    public Currency getCurrency() {
        initializeCurrency(this.locale);
        return this.currency;
    }

    public void setCurrency(Currency currency) {
        if (currency == null) {
            throw new NullPointerException();
        }
        initializeCurrency(this.locale);
        this.hashCode = 0;
        this.currency = currency;
        this.intlCurrencySymbol = currency.getCurrencyCode();
        this.currencySymbol = currency.getSymbol(this.locale);
        this.cachedIcuDFS = null;
    }

    public char getMonetaryDecimalSeparator() {
        return this.monetarySeparator;
    }

    public void setMonetaryDecimalSeparator(char sep) {
        this.hashCode = 0;
        this.monetarySeparator = sep;
        this.cachedIcuDFS = null;
    }

    public String getExponentSeparator() {
        return this.exponentialSeparator;
    }

    public void setExponentSeparator(String exp) {
        if (exp == null) {
            throw new NullPointerException();
        }
        this.hashCode = 0;
        this.exponentialSeparator = exp;
        this.cachedIcuDFS = null;
    }

    public char getMonetaryGroupingSeparator() {
        return this.monetaryGroupingSeparator;
    }

    public void setMonetaryGroupingSeparator(char monetaryGroupingSeparator) {
        this.hashCode = 0;
        this.monetaryGroupingSeparator = monetaryGroupingSeparator;
        this.cachedIcuDFS = null;
    }

    char getExponentialSymbol() {
        return this.exponential;
    }

    void setExponentialSymbol(char exp) {
        this.exponential = exp;
        this.cachedIcuDFS = null;
    }

    String getPerMillText() {
        return this.perMillText;
    }

    void setPerMillText(String perMillText) {
        Objects.requireNonNull(perMillText);
        if (perMillText.isEmpty()) {
            throw new IllegalArgumentException("Empty argument string");
        }
        this.hashCode = 0;
        this.perMillText = perMillText;
        this.perMill = findNonFormatChar(perMillText, (char) 8240);
        this.cachedIcuDFS = null;
    }

    String getPercentText() {
        return this.percentText;
    }

    void setPercentText(String percentText) {
        Objects.requireNonNull(percentText);
        if (percentText.isEmpty()) {
            throw new IllegalArgumentException("Empty argument string");
        }
        this.hashCode = 0;
        this.percentText = percentText;
        this.percent = findNonFormatChar(percentText, '%');
        this.cachedIcuDFS = null;
    }

    String getMinusSignText() {
        return this.minusSignText;
    }

    void setMinusSignText(String minusSignText) {
        Objects.requireNonNull(minusSignText);
        if (minusSignText.isEmpty()) {
            throw new IllegalArgumentException("Empty argument string");
        }
        this.hashCode = 0;
        this.minusSignText = minusSignText;
        this.minusSign = findNonFormatChar(minusSignText, '-');
        this.cachedIcuDFS = null;
    }

    public Object clone() {
        try {
            return (DecimalFormatSymbols) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2);
        }
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
        DecimalFormatSymbols other = (DecimalFormatSymbols) obj;
        if (this.zeroDigit != other.zeroDigit || this.groupingSeparator != other.groupingSeparator || this.decimalSeparator != other.decimalSeparator || this.percent != other.percent || !this.percentText.equals(other.percentText) || this.perMill != other.perMill || !this.perMillText.equals(other.perMillText) || this.digit != other.digit || this.minusSign != other.minusSign || !this.minusSignText.equals(other.minusSignText) || this.patternSeparator != other.patternSeparator || !this.infinity.equals(other.infinity) || !this.NaN.equals(other.NaN) || !getCurrencySymbol().equals(other.getCurrencySymbol()) || !this.intlCurrencySymbol.equals(other.intlCurrencySymbol) || this.currency != other.currency || this.monetarySeparator != other.monetarySeparator || this.monetaryGroupingSeparator != other.monetaryGroupingSeparator || !this.exponentialSeparator.equals(other.exponentialSeparator) || !this.locale.equals(other.locale)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Objects.hash(Character.valueOf(this.zeroDigit), Character.valueOf(this.groupingSeparator), Character.valueOf(this.decimalSeparator), Character.valueOf(this.percent), this.percentText, Character.valueOf(this.perMill), this.perMillText, Character.valueOf(this.digit), Character.valueOf(this.minusSign), this.minusSignText, Character.valueOf(this.patternSeparator), this.infinity, this.NaN, getCurrencySymbol(), this.intlCurrencySymbol, this.currency, Character.valueOf(this.monetarySeparator), Character.valueOf(this.monetaryGroupingSeparator), this.exponentialSeparator, this.locale);
        }
        return this.hashCode;
    }

    private void initialize(Locale locale) {
        char c4;
        char c10;
        this.locale = locale;
        if (locale == null) {
            throw new NullPointerException("locale");
        }
        DecimalFormatData decimalFormatData = DecimalFormatData.getInstance(LocaleData.mapInvalidAndNullLocales(locale));
        String[] values = {String.valueOf(decimalFormatData.getDecimalSeparator()), String.valueOf(decimalFormatData.getGroupingSeparator()), String.valueOf(decimalFormatData.getPatternSeparator()), decimalFormatData.getPercent(), String.valueOf(decimalFormatData.getZeroDigit()), "#", decimalFormatData.getMinusSign(), decimalFormatData.getExponentSeparator(), decimalFormatData.getPerMill(), decimalFormatData.getInfinity(), decimalFormatData.getNaN(), decimalFormatData.getMonetarySeparator(), decimalFormatData.getMonetaryGroupSeparator()};
        this.decimalSeparator = values[0].charAt(0);
        this.groupingSeparator = values[1].charAt(0);
        this.patternSeparator = values[2].charAt(0);
        char findNonFormatChar = findNonFormatChar(values[3], '%');
        this.percent = findNonFormatChar;
        this.percentText = Character.toString(findNonFormatChar);
        this.zeroDigit = values[4].charAt(0);
        this.digit = values[5].charAt(0);
        char findNonFormatChar2 = findNonFormatChar(values[6], '-');
        this.minusSign = findNonFormatChar2;
        this.minusSignText = Character.toString(findNonFormatChar2);
        this.exponential = values[7].charAt(0);
        this.exponentialSeparator = values[7];
        char findNonFormatChar3 = findNonFormatChar(values[8], (char) 8240);
        this.perMill = findNonFormatChar3;
        this.perMillText = Character.toString(findNonFormatChar3);
        this.infinity = values[9];
        this.NaN = values[10];
        if (values.length < 12 || values[11].isEmpty()) {
            c4 = this.decimalSeparator;
        } else {
            c4 = values[11].charAt(0);
        }
        this.monetarySeparator = c4;
        if (values.length < 13 || values[12].isEmpty()) {
            c10 = this.groupingSeparator;
        } else {
            c10 = values[12].charAt(0);
        }
        this.monetaryGroupingSeparator = c10;
    }

    private char findNonFormatChar(String src, char defChar) {
        return maybeStripMarkers(src, defChar);
    }

    private void initializeCurrency(Locale locale) {
        if (this.currencyInitialized) {
            return;
        }
        if (!locale.getCountry().isEmpty()) {
            try {
                this.currency = Currency.getInstance(locale);
            } catch (IllegalArgumentException e2) {
            }
        }
        Currency currency = this.currency;
        if (currency != null) {
            this.intlCurrencySymbol = currency.getCurrencyCode();
            this.currencySymbol = this.currency.getSymbol(locale);
        } else {
            this.intlCurrencySymbol = "XXX";
            try {
                this.currency = Currency.getInstance("XXX");
            } catch (IllegalArgumentException e10) {
            }
            this.currencySymbol = "¤";
        }
        this.currencyInitialized = true;
    }

    public static char maybeStripMarkers(String symbol, char fallback) {
        int length = symbol.length();
        if (length >= 1) {
            boolean sawNonMarker = false;
            char nonMarker = 0;
            for (int i10 = 0; i10 < length; i10++) {
                char c4 = symbol.charAt(i10);
                if (c4 != 8206 && c4 != 8207 && c4 != 1564) {
                    if (sawNonMarker) {
                        return fallback;
                    }
                    sawNonMarker = true;
                    nonMarker = c4;
                }
            }
            if (sawNonMarker) {
                return nonMarker;
            }
        }
        return fallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public android.icu.text.DecimalFormatSymbols getIcuDecimalFormatSymbols() {
        android.icu.text.DecimalFormatSymbols decimalFormatSymbols = this.cachedIcuDFS;
        if (decimalFormatSymbols != null) {
            return decimalFormatSymbols;
        }
        initializeCurrency(this.locale);
        android.icu.text.DecimalFormatSymbols decimalFormatSymbols2 = new android.icu.text.DecimalFormatSymbols(this.locale);
        this.cachedIcuDFS = decimalFormatSymbols2;
        decimalFormatSymbols2.setPlusSign('+');
        this.cachedIcuDFS.setZeroDigit(this.zeroDigit);
        this.cachedIcuDFS.setDigit(this.digit);
        this.cachedIcuDFS.setDecimalSeparator(this.decimalSeparator);
        this.cachedIcuDFS.setGroupingSeparator(this.groupingSeparator);
        this.cachedIcuDFS.setPatternSeparator(this.patternSeparator);
        this.cachedIcuDFS.setPercentString(this.percentText);
        this.cachedIcuDFS.setPerMillString(this.perMillText);
        this.cachedIcuDFS.setMonetaryDecimalSeparator(this.monetarySeparator);
        this.cachedIcuDFS.setMinusSignString(this.minusSignText);
        this.cachedIcuDFS.setInfinity(this.infinity);
        this.cachedIcuDFS.setNaN(this.NaN);
        this.cachedIcuDFS.setExponentSeparator(this.exponentialSeparator);
        this.cachedIcuDFS.setMonetaryGroupingSeparator(this.monetaryGroupingSeparator);
        this.cachedIcuDFS.setPatternForCurrencySpacing(2, false, "");
        this.cachedIcuDFS.setPatternForCurrencySpacing(2, true, "");
        try {
            this.cachedIcuDFS.setCurrency(android.icu.util.Currency.getInstance(getCurrency().getCurrencyCode()));
        } catch (NullPointerException e2) {
            this.currency = Currency.getInstance("XXX");
        }
        this.cachedIcuDFS.setCurrencySymbol(this.currencySymbol);
        this.cachedIcuDFS.setInternationalCurrencySymbol(this.intlCurrencySymbol);
        return this.cachedIcuDFS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static DecimalFormatSymbols fromIcuInstance(android.icu.text.DecimalFormatSymbols dfs) {
        DecimalFormatSymbols result = new DecimalFormatSymbols(dfs.getLocale());
        result.setZeroDigit(dfs.getZeroDigit());
        result.setDigit(dfs.getDigit());
        result.setDecimalSeparator(dfs.getDecimalSeparator());
        result.setGroupingSeparator(dfs.getGroupingSeparator());
        result.setPatternSeparator(dfs.getPatternSeparator());
        result.setPercent(result.findNonFormatChar(dfs.getPercentString(), '%'));
        result.setPerMill(result.findNonFormatChar(dfs.getPerMillString(), (char) 8240));
        result.setMonetaryDecimalSeparator(dfs.getMonetaryDecimalSeparator());
        result.setMinusSign(result.findNonFormatChar(dfs.getMinusSignString(), '-'));
        result.setInfinity(dfs.getInfinity());
        result.setNaN(dfs.getNaN());
        result.setExponentSeparator(dfs.getExponentSeparator());
        result.setMonetaryGroupingSeparator(dfs.getMonetaryGroupingSeparator());
        try {
            if (dfs.getCurrency() != null) {
                result.setCurrency(Currency.getInstance(dfs.getCurrency().getCurrencyCode()));
            } else {
                result.setCurrency(Currency.getInstance("XXX"));
            }
        } catch (IllegalArgumentException e2) {
            result.setCurrency(Currency.getInstance("XXX"));
        }
        result.setInternationalCurrencySymbol(dfs.getInternationalCurrencySymbol());
        result.setCurrencySymbol(dfs.getCurrencySymbol());
        return result;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields = stream.putFields();
        fields.put("currencySymbol", this.currencySymbol);
        fields.put("decimalSeparator", getDecimalSeparator());
        fields.put("digit", getDigit());
        fields.put("exponential", this.exponentialSeparator.charAt(0));
        fields.put("exponentialSeparator", this.exponentialSeparator);
        fields.put("groupingSeparator", getGroupingSeparator());
        fields.put("infinity", this.infinity);
        fields.put("intlCurrencySymbol", this.intlCurrencySymbol);
        fields.put("monetarySeparator", getMonetaryDecimalSeparator());
        fields.put("NaN", this.NaN);
        fields.put("patternSeparator", getPatternSeparator());
        fields.put("perMill", getPerMill());
        fields.put("serialVersionOnStream", this.serialVersionOnStream);
        fields.put("zeroDigit", getZeroDigit());
        fields.put("locale", this.locale);
        fields.put("minusSign", this.minusSign);
        fields.put(Attributes.Style.PERCENT, this.percent);
        fields.put("minusSignStr", String.valueOf(this.minusSign));
        fields.put("percentStr", getPercentString());
        fields.put("perMillText", getPerMillText());
        fields.put("percentText", getPercentText());
        fields.put("minusSignText", getMinusSignText());
        fields.put("monetaryGroupingSeparator", getMonetaryGroupingSeparator());
        stream.writeFields();
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = stream.readFields();
        int serialVersionOnStream = fields.get("serialVersionOnStream", 0);
        this.currencySymbol = (String) fields.get("currencySymbol", "");
        setDecimalSeparator(fields.get("decimalSeparator", '.'));
        setDigit(fields.get("digit", '#'));
        setGroupingSeparator(fields.get("groupingSeparator", ','));
        this.infinity = (String) fields.get("infinity", "");
        this.intlCurrencySymbol = (String) fields.get("intlCurrencySymbol", "");
        this.NaN = (String) fields.get("NaN", "");
        setPatternSeparator(fields.get("patternSeparator", ';'));
        String minusSignStr = (String) fields.get("minusSignStr", (Object) null);
        if (minusSignStr != null) {
            this.minusSign = minusSignStr.charAt(0);
        } else {
            setMinusSign(fields.get("minusSign", '-'));
        }
        String percentStr = (String) fields.get("percentStr", (Object) null);
        if (percentStr != null) {
            this.percent = percentStr.charAt(0);
        } else {
            setPercent(fields.get(Attributes.Style.PERCENT, '%'));
        }
        setPerMill(fields.get("perMill", (char) 8240));
        setZeroDigit(fields.get("zeroDigit", '0'));
        this.locale = (Locale) fields.get("locale", (Object) null);
        if (serialVersionOnStream == 0) {
            setMonetaryDecimalSeparator(getDecimalSeparator());
        } else {
            setMonetaryDecimalSeparator(fields.get("monetarySeparator", '.'));
        }
        if (serialVersionOnStream == 0) {
            this.exponentialSeparator = ExifInterface.LONGITUDE_EAST;
        } else if (serialVersionOnStream >= 3) {
            setExponentSeparator((String) fields.get("exponentialSeparator", ExifInterface.LONGITUDE_EAST));
        } else {
            setExponentSeparator(String.valueOf(fields.get("exponential", 'E')));
        }
        if (serialVersionOnStream < 4) {
            this.perMillText = Character.toString(this.perMill);
            this.percentText = Character.toString(this.percent);
            this.minusSignText = Character.toString(this.minusSign);
        } else {
            this.perMillText = (String) fields.get("perMillText", Character.toString(this.perMill));
            this.percentText = (String) fields.get("percentText", Character.toString(this.percent));
            this.minusSignText = (String) fields.get("minusSignText", Character.toString(this.minusSign));
            if (findNonFormatChar(this.perMillText, (char) 65535) != this.perMill || findNonFormatChar(this.percentText, (char) 65535) != this.percent || findNonFormatChar(this.minusSignText, (char) 65535) != this.minusSign) {
                throw new InvalidObjectException("'char' and 'String' representations of either percent, per mille, and/or minus sign disagree.");
            }
        }
        if (serialVersionOnStream < 5) {
            this.monetaryGroupingSeparator = this.groupingSeparator;
        } else {
            this.monetaryGroupingSeparator = fields.get("monetaryGroupingSeparator", this.groupingSeparator);
        }
        this.serialVersionOnStream = 5;
        String str = this.intlCurrencySymbol;
        if (str != null) {
            try {
                this.currency = Currency.getInstance(str);
                this.currencyInitialized = true;
            } catch (IllegalArgumentException e2) {
                this.currency = null;
            }
        }
    }
}
