package java.text;

import com.alipay.sdk.util.i;
import com.huawei.quickcard.base.Attributes;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class MessageFormat extends Format {
    private static final int INITIAL_FORMATS = 10;
    private static final int MODIFIER_CURRENCY = 1;
    private static final int MODIFIER_DEFAULT = 0;
    private static final int MODIFIER_FULL = 4;
    private static final int MODIFIER_INTEGER = 3;
    private static final int MODIFIER_LONG = 3;
    private static final int MODIFIER_MEDIUM = 2;
    private static final int MODIFIER_PERCENT = 2;
    private static final int MODIFIER_SHORT = 1;
    private static final int SEG_INDEX = 1;
    private static final int SEG_MODIFIER = 3;
    private static final int SEG_RAW = 0;
    private static final int SEG_TYPE = 2;
    private static final int TYPE_CHOICE = 4;
    private static final int TYPE_DATE = 2;
    private static final int TYPE_NULL = 0;
    private static final int TYPE_NUMBER = 1;
    private static final int TYPE_TIME = 3;
    private static final long serialVersionUID = 6479157306784022952L;
    private int[] argumentNumbers;
    private Format[] formats;
    private Locale locale;
    private int maxOffset;
    private int[] offsets;
    private String pattern;
    private static final String[] TYPE_KEYWORDS = {"", "number", "date", "time", "choice"};
    private static final String[] NUMBER_MODIFIER_KEYWORDS = {"", "currency", Attributes.Style.PERCENT, "integer"};
    private static final String[] DATE_TIME_MODIFIER_KEYWORDS = {"", "short", "medium", "long", "full"};
    private static final int[] DATE_TIME_MODIFIERS = {2, 3, 2, 1, 0};

    public MessageFormat(String pattern) {
        this.pattern = "";
        this.formats = new Format[10];
        this.offsets = new int[10];
        this.argumentNumbers = new int[10];
        this.maxOffset = -1;
        this.locale = Locale.getDefault(Locale.Category.FORMAT);
        applyPattern(pattern);
    }

    public MessageFormat(String pattern, Locale locale) {
        this.pattern = "";
        this.formats = new Format[10];
        this.offsets = new int[10];
        this.argumentNumbers = new int[10];
        this.maxOffset = -1;
        this.locale = locale;
        applyPattern(pattern);
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public void applyPattern(String pattern) {
        StringBuilder[] segments = new StringBuilder[4];
        segments[0] = new StringBuilder();
        int part = 0;
        int formatNumber = 0;
        boolean inQuote = false;
        int braceStack = 0;
        this.maxOffset = -1;
        int i10 = 0;
        while (i10 < pattern.length()) {
            char ch = pattern.charAt(i10);
            if (part == 0) {
                if (ch == '\'') {
                    if (i10 + 1 < pattern.length() && pattern.charAt(i10 + 1) == '\'') {
                        segments[part].append(ch);
                        i10++;
                    } else {
                        inQuote = !inQuote;
                    }
                } else if (ch == '{' && !inQuote) {
                    part = 1;
                    if (segments[1] == null) {
                        segments[1] = new StringBuilder();
                    }
                } else {
                    segments[part].append(ch);
                }
            } else if (inQuote) {
                segments[part].append(ch);
                if (ch == '\'') {
                    inQuote = false;
                }
            } else {
                switch (ch) {
                    case ' ':
                        if (part != 2 || segments[2].length() > 0) {
                            segments[part].append(ch);
                            break;
                        } else {
                            continue;
                        }
                        break;
                    case '\'':
                        inQuote = true;
                        break;
                    case ',':
                        if (part < 3) {
                            part++;
                            if (segments[part] == null) {
                                segments[part] = new StringBuilder();
                                break;
                            } else {
                                continue;
                            }
                        } else {
                            segments[part].append(ch);
                            break;
                        }
                    case '{':
                        braceStack++;
                        segments[part].append(ch);
                        continue;
                    case '}':
                        if (braceStack == 0) {
                            part = 0;
                            makeFormat(i10, formatNumber, segments);
                            formatNumber++;
                            segments[1] = null;
                            segments[2] = null;
                            segments[3] = null;
                            continue;
                        } else {
                            braceStack--;
                            segments[part].append(ch);
                            break;
                        }
                }
                segments[part].append(ch);
            }
            i10++;
        }
        if (braceStack == 0 && part != 0) {
            this.maxOffset = -1;
            throw new IllegalArgumentException("Unmatched braces in the pattern.");
        }
        this.pattern = segments[0].toString();
    }

    public String toPattern() {
        int[] iArr;
        int lastOffset = 0;
        StringBuilder result = new StringBuilder();
        for (int i10 = 0; i10 <= this.maxOffset; i10++) {
            copyAndFixQuotes(this.pattern, lastOffset, this.offsets[i10], result);
            lastOffset = this.offsets[i10];
            result.append('{').append(this.argumentNumbers[i10]);
            Format fmt = this.formats[i10];
            if (fmt != null) {
                if (fmt instanceof NumberFormat) {
                    if (fmt.equals(NumberFormat.getInstance(this.locale))) {
                        result.append(",number");
                    } else if (fmt.equals(NumberFormat.getCurrencyInstance(this.locale))) {
                        result.append(",number,currency");
                    } else if (fmt.equals(NumberFormat.getPercentInstance(this.locale))) {
                        result.append(",number,percent");
                    } else if (fmt.equals(NumberFormat.getIntegerInstance(this.locale))) {
                        result.append(",number,integer");
                    } else if (fmt instanceof DecimalFormat) {
                        result.append(",number,").append(((DecimalFormat) fmt).toPattern());
                    } else if (fmt instanceof ChoiceFormat) {
                        result.append(",choice,").append(((ChoiceFormat) fmt).toPattern());
                    }
                } else if (fmt instanceof DateFormat) {
                    int index = 0;
                    while (true) {
                        iArr = DATE_TIME_MODIFIERS;
                        if (index >= iArr.length) {
                            break;
                        }
                        DateFormat df = DateFormat.getDateInstance(iArr[index], this.locale);
                        if (fmt.equals(df)) {
                            result.append(",date");
                            break;
                        }
                        DateFormat df2 = DateFormat.getTimeInstance(iArr[index], this.locale);
                        if (!fmt.equals(df2)) {
                            index++;
                        } else {
                            result.append(",time");
                            break;
                        }
                    }
                    if (index >= iArr.length) {
                        if (fmt instanceof SimpleDateFormat) {
                            result.append(",date,").append(((SimpleDateFormat) fmt).toPattern());
                        }
                    } else if (index != 0) {
                        result.append(',').append(DATE_TIME_MODIFIER_KEYWORDS[index]);
                    }
                }
            }
            result.append('}');
        }
        String str = this.pattern;
        copyAndFixQuotes(str, lastOffset, str.length(), result);
        return result.toString();
    }

    public void setFormatsByArgumentIndex(Format[] newFormats) {
        for (int i10 = 0; i10 <= this.maxOffset; i10++) {
            int j10 = this.argumentNumbers[i10];
            if (j10 < newFormats.length) {
                this.formats[i10] = newFormats[j10];
            }
        }
    }

    public void setFormats(Format[] newFormats) {
        int runsToCopy = newFormats.length;
        int i10 = this.maxOffset;
        if (runsToCopy > i10 + 1) {
            runsToCopy = i10 + 1;
        }
        for (int i11 = 0; i11 < runsToCopy; i11++) {
            this.formats[i11] = newFormats[i11];
        }
    }

    public void setFormatByArgumentIndex(int argumentIndex, Format newFormat) {
        for (int j10 = 0; j10 <= this.maxOffset; j10++) {
            if (this.argumentNumbers[j10] == argumentIndex) {
                this.formats[j10] = newFormat;
            }
        }
    }

    public void setFormat(int formatElementIndex, Format newFormat) {
        if (formatElementIndex > this.maxOffset) {
            throw new ArrayIndexOutOfBoundsException(formatElementIndex);
        }
        this.formats[formatElementIndex] = newFormat;
    }

    public Format[] getFormatsByArgumentIndex() {
        int maximumArgumentNumber = -1;
        for (int i10 = 0; i10 <= this.maxOffset; i10++) {
            int[] iArr = this.argumentNumbers;
            if (iArr[i10] > maximumArgumentNumber) {
                maximumArgumentNumber = iArr[i10];
            }
        }
        int i11 = maximumArgumentNumber + 1;
        Format[] resultArray = new Format[i11];
        for (int i12 = 0; i12 <= this.maxOffset; i12++) {
            resultArray[this.argumentNumbers[i12]] = this.formats[i12];
        }
        return resultArray;
    }

    public Format[] getFormats() {
        int i10 = this.maxOffset;
        Format[] resultArray = new Format[i10 + 1];
        System.arraycopy(this.formats, 0, resultArray, 0, i10 + 1);
        return resultArray;
    }

    public final StringBuffer format(Object[] arguments, StringBuffer result, FieldPosition pos) {
        return subformat(arguments, result, pos, null);
    }

    public static String format(String pattern, Object... arguments) {
        MessageFormat temp = new MessageFormat(pattern);
        return temp.format(arguments);
    }

    @Override // java.text.Format
    public final StringBuffer format(Object arguments, StringBuffer result, FieldPosition pos) {
        return subformat((Object[]) arguments, result, pos, null);
    }

    @Override // java.text.Format
    public AttributedCharacterIterator formatToCharacterIterator(Object arguments) {
        StringBuffer result = new StringBuffer();
        ArrayList<AttributedCharacterIterator> iterators = new ArrayList<>();
        if (arguments == null) {
            throw new NullPointerException("formatToCharacterIterator must be passed non-null object");
        }
        subformat((Object[]) arguments, result, null, iterators);
        if (iterators.size() == 0) {
            return createAttributedCharacterIterator("");
        }
        return createAttributedCharacterIterator((AttributedCharacterIterator[]) iterators.toArray(new AttributedCharacterIterator[iterators.size()]));
    }

    public Object[] parse(String source, ParsePosition pos) {
        int next;
        if (source == null) {
            Object[] empty = new Object[0];
            return empty;
        }
        int maximumArgumentNumber = -1;
        for (int i10 = 0; i10 <= this.maxOffset; i10++) {
            int[] iArr = this.argumentNumbers;
            if (iArr[i10] > maximumArgumentNumber) {
                maximumArgumentNumber = iArr[i10];
            }
        }
        int i11 = maximumArgumentNumber + 1;
        Object[] resultArray = new Object[i11];
        int patternOffset = 0;
        int sourceOffset = pos.index;
        ParsePosition tempStatus = new ParsePosition(0);
        int i12 = 0;
        while (i12 <= this.maxOffset) {
            int len = this.offsets[i12] - patternOffset;
            if (len == 0 || this.pattern.regionMatches(patternOffset, source, sourceOffset, len)) {
                int sourceOffset2 = sourceOffset + len;
                patternOffset += len;
                if (this.formats[i12] == null) {
                    int tempLength = i12 != this.maxOffset ? this.offsets[i12 + 1] : this.pattern.length();
                    if (patternOffset >= tempLength) {
                        next = source.length();
                    } else {
                        next = source.indexOf(this.pattern.substring(patternOffset, tempLength), sourceOffset2);
                    }
                    if (next < 0) {
                        pos.errorIndex = sourceOffset2;
                        return null;
                    }
                    String strValue = source.substring(sourceOffset2, next);
                    if (!strValue.equals("{" + this.argumentNumbers[i12] + i.f4738d)) {
                        resultArray[this.argumentNumbers[i12]] = source.substring(sourceOffset2, next);
                    }
                    sourceOffset = next;
                } else {
                    tempStatus.index = sourceOffset2;
                    resultArray[this.argumentNumbers[i12]] = this.formats[i12].parseObject(source, tempStatus);
                    if (tempStatus.index == sourceOffset2) {
                        pos.errorIndex = sourceOffset2;
                        return null;
                    }
                    sourceOffset = tempStatus.index;
                }
                i12++;
            } else {
                pos.errorIndex = sourceOffset;
                return null;
            }
        }
        int len2 = this.pattern.length() - patternOffset;
        if (len2 == 0 || this.pattern.regionMatches(patternOffset, source, sourceOffset, len2)) {
            pos.index = sourceOffset + len2;
            return resultArray;
        }
        pos.errorIndex = sourceOffset;
        return null;
    }

    public Object[] parse(String source) throws ParseException {
        ParsePosition pos = new ParsePosition(0);
        Object[] result = parse(source, pos);
        if (pos.index == 0) {
            throw new ParseException("MessageFormat parse error!", pos.errorIndex);
        }
        return result;
    }

    @Override // java.text.Format
    public Object parseObject(String source, ParsePosition pos) {
        return parse(source, pos);
    }

    @Override // java.text.Format
    public Object clone() {
        MessageFormat other = (MessageFormat) super.clone();
        other.formats = (Format[]) this.formats.clone();
        int i10 = 0;
        while (true) {
            Format[] formatArr = this.formats;
            if (i10 < formatArr.length) {
                Format format = formatArr[i10];
                if (format != null) {
                    other.formats[i10] = (Format) format.clone();
                }
                i10++;
            } else {
                other.offsets = (int[]) this.offsets.clone();
                other.argumentNumbers = (int[]) this.argumentNumbers.clone();
                return other;
            }
        }
    }

    public boolean equals(Object obj) {
        Locale locale;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MessageFormat other = (MessageFormat) obj;
        if (this.maxOffset == other.maxOffset && this.pattern.equals(other.pattern) && ((((locale = this.locale) != null && locale.equals(other.locale)) || (this.locale == null && other.locale == null)) && Arrays.equals(this.offsets, other.offsets) && Arrays.equals(this.argumentNumbers, other.argumentNumbers) && Arrays.equals(this.formats, other.formats))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.pattern.hashCode();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Field extends Format.Field {
        public static final Field ARGUMENT = new Field("message argument field");
        private static final long serialVersionUID = 7899943957617360810L;

        protected Field(String name) {
            super(name);
        }

        @Override // java.text.AttributedCharacterIterator.Attribute
        protected Object readResolve() throws InvalidObjectException {
            if (getClass() != Field.class) {
                throw new InvalidObjectException("subclass didn't correctly implement readResolve");
            }
            return ARGUMENT;
        }
    }

    private StringBuffer subformat(Object[] arguments, StringBuffer result, FieldPosition fp, List<AttributedCharacterIterator> characterIterators) {
        int lastOffset = 0;
        int last = result.length();
        for (int i10 = 0; i10 <= this.maxOffset; i10++) {
            result.append((CharSequence) this.pattern, lastOffset, this.offsets[i10]);
            lastOffset = this.offsets[i10];
            int argumentNumber = this.argumentNumbers[i10];
            if (arguments == null || argumentNumber >= arguments.length) {
                result.append('{').append(argumentNumber).append('}');
            } else {
                Object obj = arguments[argumentNumber];
                String arg = null;
                Format subFormatter = null;
                if (obj == null) {
                    arg = "null";
                } else {
                    Format[] formatArr = this.formats;
                    Format format = formatArr[i10];
                    if (format != null) {
                        subFormatter = formatArr[i10];
                        if (subFormatter instanceof ChoiceFormat) {
                            arg = format.format(obj);
                            if (arg.indexOf(123) >= 0) {
                                subFormatter = new MessageFormat(arg, this.locale);
                                obj = arguments;
                                arg = null;
                            }
                        }
                    } else if (obj instanceof Number) {
                        subFormatter = NumberFormat.getInstance(this.locale);
                    } else if (obj instanceof Date) {
                        subFormatter = DateFormat.getDateTimeInstance(3, 3, this.locale);
                    } else if (obj instanceof String) {
                        arg = (String) obj;
                    } else {
                        arg = obj.toString();
                        if (arg == null) {
                            arg = "null";
                        }
                    }
                }
                if (characterIterators != null) {
                    if (last != result.length()) {
                        characterIterators.add(createAttributedCharacterIterator(result.substring(last)));
                        last = result.length();
                    }
                    if (subFormatter != null) {
                        AttributedCharacterIterator subIterator = subFormatter.formatToCharacterIterator(obj);
                        append(result, subIterator);
                        if (last != result.length()) {
                            characterIterators.add(createAttributedCharacterIterator(subIterator, Field.ARGUMENT, Integer.valueOf(argumentNumber)));
                            last = result.length();
                        }
                        arg = null;
                    }
                    if (arg != null && !arg.isEmpty()) {
                        result.append(arg);
                        characterIterators.add(createAttributedCharacterIterator(arg, Field.ARGUMENT, Integer.valueOf(argumentNumber)));
                        last = result.length();
                    }
                } else {
                    if (subFormatter != null) {
                        arg = subFormatter.format(obj);
                    }
                    int last2 = result.length();
                    result.append(arg);
                    if (i10 == 0 && fp != null && Field.ARGUMENT.equals(fp.getFieldAttribute())) {
                        fp.setBeginIndex(last2);
                        fp.setEndIndex(result.length());
                    }
                    last = result.length();
                }
            }
        }
        String str = this.pattern;
        result.append((CharSequence) str, lastOffset, str.length());
        if (characterIterators != null && last != result.length()) {
            characterIterators.add(createAttributedCharacterIterator(result.substring(last)));
        }
        return result;
    }

    private void append(StringBuffer result, CharacterIterator iterator) {
        if (iterator.first() != 65535) {
            result.append(iterator.first());
            while (true) {
                char aChar = iterator.next();
                if (aChar != 65535) {
                    result.append(aChar);
                } else {
                    return;
                }
            }
        }
    }

    private void makeFormat(int position, int offsetNumber, StringBuilder[] textSegments) {
        String[] segments = new String[textSegments.length];
        for (int i10 = 0; i10 < textSegments.length; i10++) {
            StringBuilder oneseg = textSegments[i10];
            segments[i10] = oneseg != null ? oneseg.toString() : "";
        }
        try {
            int argumentNumber = Integer.parseInt(segments[1]);
            if (argumentNumber < 0) {
                throw new IllegalArgumentException("negative argument number: " + argumentNumber);
            }
            Format[] formatArr = this.formats;
            if (offsetNumber >= formatArr.length) {
                int newLength = formatArr.length * 2;
                Format[] newFormats = new Format[newLength];
                int[] newOffsets = new int[newLength];
                int[] newArgumentNumbers = new int[newLength];
                System.arraycopy(formatArr, 0, newFormats, 0, this.maxOffset + 1);
                System.arraycopy((Object) this.offsets, 0, (Object) newOffsets, 0, this.maxOffset + 1);
                System.arraycopy((Object) this.argumentNumbers, 0, (Object) newArgumentNumbers, 0, this.maxOffset + 1);
                this.formats = newFormats;
                this.offsets = newOffsets;
                this.argumentNumbers = newArgumentNumbers;
            }
            int oldMaxOffset = this.maxOffset;
            this.maxOffset = offsetNumber;
            this.offsets[offsetNumber] = segments[0].length();
            this.argumentNumbers[offsetNumber] = argumentNumber;
            Format newFormat = null;
            if (!segments[2].isEmpty()) {
                int type = findKeyword(segments[2], TYPE_KEYWORDS);
                switch (type) {
                    case 0:
                        break;
                    case 1:
                        switch (findKeyword(segments[3], NUMBER_MODIFIER_KEYWORDS)) {
                            case 0:
                                newFormat = NumberFormat.getInstance(this.locale);
                                break;
                            case 1:
                                newFormat = NumberFormat.getCurrencyInstance(this.locale);
                                break;
                            case 2:
                                newFormat = NumberFormat.getPercentInstance(this.locale);
                                break;
                            case 3:
                                newFormat = NumberFormat.getIntegerInstance(this.locale);
                                break;
                            default:
                                try {
                                    newFormat = new DecimalFormat(segments[3], DecimalFormatSymbols.getInstance(this.locale));
                                    break;
                                } catch (IllegalArgumentException e2) {
                                    this.maxOffset = oldMaxOffset;
                                    throw e2;
                                }
                        }
                    case 2:
                    case 3:
                        String str = segments[3];
                        String[] strArr = DATE_TIME_MODIFIER_KEYWORDS;
                        int mod = findKeyword(str, strArr);
                        if (mod >= 0 && mod < strArr.length) {
                            if (type == 2) {
                                newFormat = DateFormat.getDateInstance(DATE_TIME_MODIFIERS[mod], this.locale);
                                break;
                            } else {
                                newFormat = DateFormat.getTimeInstance(DATE_TIME_MODIFIERS[mod], this.locale);
                                break;
                            }
                        } else {
                            try {
                                newFormat = new SimpleDateFormat(segments[3], this.locale);
                                break;
                            } catch (IllegalArgumentException e10) {
                                this.maxOffset = oldMaxOffset;
                                throw e10;
                            }
                        }
                        break;
                    case 4:
                        try {
                            newFormat = new ChoiceFormat(segments[3]);
                            break;
                        } catch (Exception e11) {
                            this.maxOffset = oldMaxOffset;
                            throw new IllegalArgumentException("Choice Pattern incorrect: " + segments[3], e11);
                        }
                    default:
                        this.maxOffset = oldMaxOffset;
                        throw new IllegalArgumentException("unknown format type: " + segments[2]);
                }
            }
            this.formats[offsetNumber] = newFormat;
        } catch (NumberFormatException e12) {
            throw new IllegalArgumentException("can't parse argument number: " + segments[1], e12);
        }
    }

    private static final int findKeyword(String s2, String[] list) {
        for (int i10 = 0; i10 < list.length; i10++) {
            if (s2.equals(list[i10])) {
                return i10;
            }
        }
        String ls = s2.trim().toLowerCase(Locale.ROOT);
        if (ls != s2) {
            for (int i11 = 0; i11 < list.length; i11++) {
                if (ls.equals(list[i11])) {
                    return i11;
                }
            }
            return -1;
        }
        return -1;
    }

    private static final void copyAndFixQuotes(String source, int start, int end, StringBuilder target) {
        boolean quoted = false;
        for (int i10 = start; i10 < end; i10++) {
            char ch = source.charAt(i10);
            if (ch == '{') {
                if (!quoted) {
                    target.append('\'');
                    quoted = true;
                }
                target.append(ch);
            } else if (ch == '\'') {
                target.append("''");
            } else {
                if (quoted) {
                    target.append('\'');
                    quoted = false;
                }
                target.append(ch);
            }
        }
        if (quoted) {
            target.append('\'');
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int i10 = this.maxOffset;
        boolean isValid = i10 >= -1 && this.formats.length > i10 && this.offsets.length > i10 && this.argumentNumbers.length > i10;
        if (isValid) {
            int lastOffset = this.pattern.length() + 1;
            for (int i11 = this.maxOffset; i11 >= 0; i11--) {
                int[] iArr = this.offsets;
                int i12 = iArr[i11];
                if (i12 < 0 || i12 > lastOffset) {
                    isValid = false;
                    break;
                }
                lastOffset = iArr[i11];
            }
        }
        if (!isValid) {
            throw new InvalidObjectException("Could not reconstruct MessageFormat from corrupt stream.");
        }
    }
}
