package org.apache.commons.lang3;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CharUtils {
    public static final char CR = '\r';
    public static final char LF = '\n';
    public static final char NUL = 0;
    private static final String[] CHAR_STRING_ARRAY = new String[128];
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    static {
        char c4 = 0;
        while (true) {
            String[] strArr = CHAR_STRING_ARRAY;
            if (c4 >= strArr.length) {
                return;
            }
            strArr[c4] = String.valueOf(c4);
            c4 = (char) (c4 + 1);
        }
    }

    public static int compare(char c4, char c10) {
        return c4 - c10;
    }

    public static boolean isAscii(char c4) {
        return c4 < 128;
    }

    public static boolean isAsciiAlpha(char c4) {
        return isAsciiAlphaUpper(c4) || isAsciiAlphaLower(c4);
    }

    public static boolean isAsciiAlphaLower(char c4) {
        return c4 >= 'a' && c4 <= 'z';
    }

    public static boolean isAsciiAlphaUpper(char c4) {
        return c4 >= 'A' && c4 <= 'Z';
    }

    public static boolean isAsciiAlphanumeric(char c4) {
        return isAsciiAlpha(c4) || isAsciiNumeric(c4);
    }

    public static boolean isAsciiControl(char c4) {
        return c4 < ' ' || c4 == 127;
    }

    public static boolean isAsciiNumeric(char c4) {
        return c4 >= '0' && c4 <= '9';
    }

    public static boolean isAsciiPrintable(char c4) {
        return c4 >= ' ' && c4 < 127;
    }

    public static char toChar(Character ch) {
        Validate.isTrue(ch != null, "The Character must not be null", new Object[0]);
        return ch.charValue();
    }

    @Deprecated
    public static Character toCharacterObject(char c4) {
        return Character.valueOf(c4);
    }

    public static int toIntValue(char c4) {
        if (isAsciiNumeric(c4)) {
            return c4 - '0';
        }
        throw new IllegalArgumentException("The character " + c4 + " is not in the range '0' - '9'");
    }

    public static String toString(char c4) {
        if (c4 < 128) {
            return CHAR_STRING_ARRAY[c4];
        }
        return new String(new char[]{c4});
    }

    public static String unicodeEscaped(char c4) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\\u");
        char[] cArr = HEX_DIGITS;
        sb2.append(cArr[(c4 >> '\f') & 15]);
        sb2.append(cArr[(c4 >> '\b') & 15]);
        sb2.append(cArr[(c4 >> 4) & 15]);
        sb2.append(cArr[c4 & 15]);
        return sb2.toString();
    }

    public static Character toCharacterObject(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return Character.valueOf(str.charAt(0));
    }

    public static String unicodeEscaped(Character ch) {
        if (ch == null) {
            return null;
        }
        return unicodeEscaped(ch.charValue());
    }

    public static char toChar(Character ch, char c4) {
        return ch == null ? c4 : ch.charValue();
    }

    public static int toIntValue(char c4, int i10) {
        return !isAsciiNumeric(c4) ? i10 : c4 - '0';
    }

    public static String toString(Character ch) {
        if (ch == null) {
            return null;
        }
        return toString(ch.charValue());
    }

    public static char toChar(String str) {
        Validate.isTrue(StringUtils.isNotEmpty(str), "The String must not be empty", new Object[0]);
        return str.charAt(0);
    }

    public static int toIntValue(Character ch) {
        Validate.isTrue(ch != null, "The character must not be null", new Object[0]);
        return toIntValue(ch.charValue());
    }

    public static char toChar(String str, char c4) {
        return StringUtils.isEmpty(str) ? c4 : str.charAt(0);
    }

    public static int toIntValue(Character ch, int i10) {
        return ch == null ? i10 : toIntValue(ch.charValue(), i10);
    }
}
