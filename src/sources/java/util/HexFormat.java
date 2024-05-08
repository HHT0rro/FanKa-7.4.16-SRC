package java.util;

import com.alibaba.security.realidentity.build.cg;
import com.huawei.quickcard.base.Attributes;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class HexFormat {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final HexFormat HEX_FORMAT;
    private static final byte[] LOWERCASE_DIGITS;
    private final String delimiter;
    private final byte[] digits;
    private final String prefix;
    private final String suffix;
    private static final byte[] UPPERCASE_DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
    private static final byte[] DIGITS = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final byte[] EMPTY_BYTES = new byte[0];

    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
        LOWERCASE_DIGITS = bArr;
        HEX_FORMAT = new HexFormat("", "", "", bArr);
    }

    private HexFormat(String delimiter, String prefix, String suffix, byte[] digits) {
        this.delimiter = (String) Objects.requireNonNull(delimiter, cg.f3324n);
        this.prefix = (String) Objects.requireNonNull(prefix, cg.f3323m);
        this.suffix = (String) Objects.requireNonNull(suffix, "suffix");
        this.digits = digits;
    }

    public static HexFormat of() {
        return HEX_FORMAT;
    }

    public static HexFormat ofDelimiter(String delimiter) {
        return new HexFormat(delimiter, "", "", LOWERCASE_DIGITS);
    }

    public HexFormat withDelimiter(String delimiter) {
        return new HexFormat(delimiter, this.prefix, this.suffix, this.digits);
    }

    public HexFormat withPrefix(String prefix) {
        return new HexFormat(this.delimiter, prefix, this.suffix, this.digits);
    }

    public HexFormat withSuffix(String suffix) {
        return new HexFormat(this.delimiter, this.prefix, suffix, this.digits);
    }

    public HexFormat withUpperCase() {
        return new HexFormat(this.delimiter, this.prefix, this.suffix, UPPERCASE_DIGITS);
    }

    public HexFormat withLowerCase() {
        return new HexFormat(this.delimiter, this.prefix, this.suffix, LOWERCASE_DIGITS);
    }

    public String delimiter() {
        return this.delimiter;
    }

    public String prefix() {
        return this.prefix;
    }

    public String suffix() {
        return this.suffix;
    }

    public boolean isUpperCase() {
        return Arrays.equals(this.digits, UPPERCASE_DIGITS);
    }

    public String formatHex(byte[] bytes) {
        return formatHex(bytes, 0, bytes.length);
    }

    public String formatHex(byte[] bytes, int fromIndex, int toIndex) {
        Objects.requireNonNull(bytes, "bytes");
        Objects.checkFromToIndex(fromIndex, toIndex, bytes.length);
        if (toIndex - fromIndex == 0) {
            return "";
        }
        String s2 = formatOptDelimiter(bytes, fromIndex, toIndex);
        if (s2 == null) {
            long stride = this.prefix.length() + 2 + this.suffix.length() + this.delimiter.length();
            int capacity = checkMaxArraySize(((toIndex - fromIndex) * stride) - this.delimiter.length());
            StringBuilder sb2 = new StringBuilder(capacity);
            formatHex(sb2, bytes, fromIndex, toIndex);
            return sb2.toString();
        }
        return s2;
    }

    public <A extends Appendable> A formatHex(A a10, byte[] bArr) {
        return (A) formatHex(a10, bArr, 0, bArr.length);
    }

    public <A extends Appendable> A formatHex(A out, byte[] bytes, int fromIndex, int toIndex) {
        Objects.requireNonNull(out, "out");
        Objects.requireNonNull(bytes, "bytes");
        Objects.checkFromToIndex(fromIndex, toIndex, bytes.length);
        int length = toIndex - fromIndex;
        if (length > 0) {
            try {
                String between = this.suffix + this.delimiter + this.prefix;
                out.append(this.prefix);
                toHexDigits((HexFormat) out, bytes[fromIndex]);
                if (between.isEmpty()) {
                    for (int i10 = 1; i10 < length; i10++) {
                        toHexDigits((HexFormat) out, bytes[fromIndex + i10]);
                    }
                } else {
                    for (int i11 = 1; i11 < length; i11++) {
                        out.append(between);
                        toHexDigits((HexFormat) out, bytes[fromIndex + i11]);
                    }
                }
                out.append(this.suffix);
            } catch (IOException ioe) {
                throw new UncheckedIOException(ioe.getMessage(), ioe);
            }
        }
        return out;
    }

    private String formatOptDelimiter(byte[] bytes, int fromIndex, int toIndex) {
        byte[] rep;
        if (!this.prefix.isEmpty() || !this.suffix.isEmpty()) {
            return null;
        }
        int length = toIndex - fromIndex;
        if (this.delimiter.isEmpty()) {
            rep = new byte[checkMaxArraySize(length * 2)];
            for (int i10 = 0; i10 < length; i10++) {
                rep[i10 * 2] = (byte) toHighHexDigit(bytes[fromIndex + i10]);
                rep[(i10 * 2) + 1] = (byte) toLowHexDigit(bytes[fromIndex + i10]);
            }
        } else {
            if (this.delimiter.length() != 1 || this.delimiter.charAt(0) >= 256) {
                return null;
            }
            char sep = this.delimiter.charAt(0);
            byte[] rep2 = new byte[checkMaxArraySize((length * 3) - 1)];
            rep2[0] = (byte) toHighHexDigit(bytes[fromIndex]);
            rep2[1] = (byte) toLowHexDigit(bytes[fromIndex]);
            for (int i11 = 1; i11 < length; i11++) {
                rep2[(i11 * 3) - 1] = (byte) sep;
                rep2[i11 * 3] = (byte) toHighHexDigit(bytes[fromIndex + i11]);
                rep2[(i11 * 3) + 1] = (byte) toLowHexDigit(bytes[fromIndex + i11]);
            }
            rep = rep2;
        }
        return StringFactory.newStringFromBytes(rep, StandardCharsets.ISO_8859_1);
    }

    private static int checkMaxArraySize(long length) {
        if (length > ZipUtils.UPPER_UNIXTIME_BOUND) {
            throw new OutOfMemoryError("String size " + length + " exceeds maximum 2147483647");
        }
        return (int) length;
    }

    public byte[] parseHex(CharSequence string) {
        return parseHex(string, 0, string.length());
    }

    public byte[] parseHex(CharSequence string, int fromIndex, int toIndex) {
        Objects.requireNonNull(string, Attributes.TextOverflow.STRING);
        Objects.checkFromToIndex(fromIndex, toIndex, string.length());
        if (fromIndex != 0 || toIndex != string.length()) {
            string = string.subSequence(fromIndex, toIndex);
        }
        if (string.length() == 0) {
            return EMPTY_BYTES;
        }
        if (this.delimiter.isEmpty() && this.prefix.isEmpty() && this.suffix.isEmpty()) {
            return parseNoDelimiter(string);
        }
        long valueChars = this.prefix.length() + 2 + this.suffix.length();
        long stride = this.delimiter.length() + valueChars;
        if ((string.length() - valueChars) % stride != 0) {
            throw new IllegalArgumentException("extra or missing delimiters or values consisting of prefix, two hexadecimal digits, and suffix");
        }
        checkLiteral(string, 0, this.prefix);
        checkLiteral(string, string.length() - this.suffix.length(), this.suffix);
        String between = this.suffix + this.delimiter + this.prefix;
        int len = (int) (((string.length() - valueChars) / stride) + 1);
        byte[] bytes = new byte[len];
        int i10 = 0;
        int offset = this.prefix.length();
        while (i10 < len - 1) {
            bytes[i10] = (byte) fromHexDigits(string, offset);
            checkLiteral(string, offset + 2, between);
            i10++;
            offset += between.length() + 2;
        }
        bytes[i10] = (byte) fromHexDigits(string, offset);
        return bytes;
    }

    public byte[] parseHex(char[] chars, int fromIndex, int toIndex) {
        Objects.requireNonNull(chars, "chars");
        Objects.checkFromToIndex(fromIndex, toIndex, chars.length);
        CharBuffer cb2 = CharBuffer.wrap(chars, fromIndex, toIndex - fromIndex);
        return parseHex(cb2);
    }

    private static void checkLiteral(CharSequence string, int index, String literal) {
        if (!literal.isEmpty()) {
            if (literal.length() == 1 && literal.charAt(0) == string.charAt(index)) {
                return;
            }
            for (int i10 = 0; i10 < literal.length(); i10++) {
                if (string.charAt(index + i10) != literal.charAt(i10)) {
                    throw new IllegalArgumentException(escapeNL("found: \"" + ((Object) string.subSequence(index, literal.length() + index)) + "\", expected: \"" + literal + "\", index: " + index + " ch: " + ((int) string.charAt(index + i10))));
                }
            }
        }
    }

    private static String escapeNL(String string) {
        return string.replace("\n", "\\n").replace(StringUtils.CR, "\\r");
    }

    public char toLowHexDigit(int value) {
        return (char) this.digits[value & 15];
    }

    public char toHighHexDigit(int value) {
        return (char) this.digits[(value >> 4) & 15];
    }

    public <A extends Appendable> A toHexDigits(A out, byte value) {
        Objects.requireNonNull(out, "out");
        try {
            out.append(toHighHexDigit(value));
            out.append(toLowHexDigit(value));
            return out;
        } catch (IOException ioe) {
            throw new UncheckedIOException(ioe.getMessage(), ioe);
        }
    }

    public String toHexDigits(byte value) {
        byte[] rep = {(byte) toHighHexDigit(value), (byte) toLowHexDigit(value)};
        return StringFactory.newStringFromBytes(rep, StandardCharsets.ISO_8859_1);
    }

    public String toHexDigits(char value) {
        return toHexDigits((short) value);
    }

    public String toHexDigits(short value) {
        byte[] rep = {(byte) toHighHexDigit((byte) (value >> 8)), (byte) toLowHexDigit((byte) (value >> 8)), (byte) toHighHexDigit((byte) value), (byte) toLowHexDigit((byte) value)};
        return StringFactory.newStringFromBytes(rep, StandardCharsets.ISO_8859_1);
    }

    public String toHexDigits(int value) {
        byte[] rep = {(byte) toHighHexDigit((byte) (value >> 24)), (byte) toLowHexDigit((byte) (value >> 24)), (byte) toHighHexDigit((byte) (value >> 16)), (byte) toLowHexDigit((byte) (value >> 16)), (byte) toHighHexDigit((byte) (value >> 8)), (byte) toLowHexDigit((byte) (value >> 8)), (byte) toHighHexDigit((byte) value), (byte) toLowHexDigit((byte) value)};
        return StringFactory.newStringFromBytes(rep, StandardCharsets.ISO_8859_1);
    }

    public String toHexDigits(long value) {
        byte[] rep = {(byte) toHighHexDigit((byte) (value >>> 56)), (byte) toLowHexDigit((byte) (value >>> 56)), (byte) toHighHexDigit((byte) (value >>> 48)), (byte) toLowHexDigit((byte) (value >>> 48)), (byte) toHighHexDigit((byte) (value >>> 40)), (byte) toLowHexDigit((byte) (value >>> 40)), (byte) toHighHexDigit((byte) (value >>> 32)), (byte) toLowHexDigit((byte) (value >>> 32)), (byte) toHighHexDigit((byte) (value >>> 24)), (byte) toLowHexDigit((byte) (value >>> 24)), (byte) toHighHexDigit((byte) (value >>> 16)), (byte) toLowHexDigit((byte) (value >>> 16)), (byte) toHighHexDigit((byte) (value >>> 8)), (byte) toLowHexDigit((byte) (value >>> 8)), (byte) toHighHexDigit((byte) value), (byte) toLowHexDigit((byte) value)};
        return StringFactory.newStringFromBytes(rep, StandardCharsets.ISO_8859_1);
    }

    public String toHexDigits(long value, int digits) {
        if (digits < 0 || digits > 16) {
            throw new IllegalArgumentException("number of digits: " + digits);
        }
        if (digits == 0) {
            return "";
        }
        byte[] rep = new byte[digits];
        for (int i10 = rep.length - 1; i10 >= 0; i10--) {
            rep[i10] = (byte) toLowHexDigit((byte) value);
            value >>>= 4;
        }
        return StringFactory.newStringFromBytes(rep, StandardCharsets.ISO_8859_1);
    }

    private static byte[] parseNoDelimiter(CharSequence string) {
        if ((string.length() & 1) != 0) {
            throw new IllegalArgumentException("string length not even: " + string.length());
        }
        byte[] bytes = new byte[string.length() / 2];
        for (int i10 = 0; i10 < bytes.length; i10++) {
            bytes[i10] = (byte) fromHexDigits(string, i10 * 2);
        }
        return bytes;
    }

    private static int checkDigitCount(int fromIndex, int toIndex, int limit) {
        int length = toIndex - fromIndex;
        if (length > limit) {
            throw new IllegalArgumentException("string length greater than " + limit + ": " + length);
        }
        return length;
    }

    public static boolean isHexDigit(int ch) {
        return (ch >>> 8) == 0 && DIGITS[ch] >= 0;
    }

    public static int fromHexDigit(int ch) {
        int value;
        if ((ch >>> 8) != 0 || (value = DIGITS[ch]) < 0) {
            throw new NumberFormatException("not a hexadecimal digit: \"" + ((char) ch) + "\" = " + ch);
        }
        return value;
    }

    private static int fromHexDigits(CharSequence string, int index) {
        int high = fromHexDigit(string.charAt(index));
        int low = fromHexDigit(string.charAt(index + 1));
        return (high << 4) | low;
    }

    public static int fromHexDigits(CharSequence string) {
        return fromHexDigits(string, 0, string.length());
    }

    public static int fromHexDigits(CharSequence string, int fromIndex, int toIndex) {
        Objects.requireNonNull(string, Attributes.TextOverflow.STRING);
        Objects.checkFromToIndex(fromIndex, toIndex, string.length());
        int length = checkDigitCount(fromIndex, toIndex, 8);
        int value = 0;
        for (int i10 = 0; i10 < length; i10++) {
            value = (value << 4) + fromHexDigit(string.charAt(fromIndex + i10));
        }
        return value;
    }

    public static long fromHexDigitsToLong(CharSequence string) {
        return fromHexDigitsToLong(string, 0, string.length());
    }

    public static long fromHexDigitsToLong(CharSequence string, int fromIndex, int toIndex) {
        Objects.requireNonNull(string, Attributes.TextOverflow.STRING);
        Objects.checkFromToIndex(fromIndex, toIndex, string.length());
        int length = checkDigitCount(fromIndex, toIndex, 16);
        long value = 0;
        for (int i10 = 0; i10 < length; i10++) {
            value = (value << 4) + fromHexDigit(string.charAt(fromIndex + i10));
        }
        return value;
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        HexFormat otherHex = (HexFormat) o10;
        if (Arrays.equals(this.digits, otherHex.digits) && this.delimiter.equals(otherHex.delimiter) && this.prefix.equals(otherHex.prefix) && this.suffix.equals(otherHex.suffix)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = Objects.hash(this.delimiter, this.prefix, this.suffix);
        return (result * 31) + Boolean.hashCode(Arrays.equals(this.digits, UPPERCASE_DIGITS));
    }

    public String toString() {
        return escapeNL("uppercase: " + Arrays.equals(this.digits, UPPERCASE_DIGITS) + ", delimiter: \"" + this.delimiter + "\", prefix: \"" + this.prefix + "\", suffix: \"" + this.suffix + "\"");
    }
}
