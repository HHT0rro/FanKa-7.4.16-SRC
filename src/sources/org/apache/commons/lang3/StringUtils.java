package org.apache.commons.lang3;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class StringUtils {
    public static final String CR = "\r";
    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;
    public static final String LF = "\n";
    private static final int PAD_LIMIT = 8192;
    public static final String SPACE = " ";
    private static final int STRING_BUILDER_SIZE = 256;

    public static String abbreviate(String str, int i10) {
        return abbreviate(str, "...", 0, i10);
    }

    public static String abbreviateMiddle(String str, String str2, int i10) {
        if (isEmpty(str) || isEmpty(str2) || i10 >= str.length() || i10 < str2.length() + 2) {
            return str;
        }
        int length = i10 - str2.length();
        int i11 = length / 2;
        return str.substring(0, (length % 2) + i11) + str2 + str.substring(str.length() - i11);
    }

    private static String appendIfMissing(String str, CharSequence charSequence, boolean z10, CharSequence... charSequenceArr) {
        if (str == null || isEmpty(charSequence) || endsWith(str, charSequence, z10)) {
            return str;
        }
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (endsWith(str, charSequence2, z10)) {
                    return str;
                }
            }
        }
        return str + charSequence.toString();
    }

    public static String appendIfMissingIgnoreCase(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return appendIfMissing(str, charSequence, true, charSequenceArr);
    }

    public static String capitalize(String str) {
        int length;
        int codePointAt;
        int titleCase;
        if (str == null || (length = str.length()) == 0 || codePointAt == (titleCase = Character.toTitleCase((codePointAt = str.codePointAt(0))))) {
            return str;
        }
        int[] iArr = new int[length];
        iArr[0] = titleCase;
        int charCount = Character.charCount(codePointAt);
        int i10 = 1;
        while (charCount < length) {
            int codePointAt2 = str.codePointAt(charCount);
            iArr[i10] = codePointAt2;
            charCount += Character.charCount(codePointAt2);
            i10++;
        }
        return new String(iArr, 0, i10);
    }

    public static String center(String str, int i10) {
        return center(str, i10, ' ');
    }

    public static String chomp(String str) {
        if (isEmpty(str)) {
            return str;
        }
        if (str.length() == 1) {
            char charAt = str.charAt(0);
            return (charAt == '\r' || charAt == '\n') ? "" : str;
        }
        int length = str.length() - 1;
        char charAt2 = str.charAt(length);
        if (charAt2 == '\n') {
            if (str.charAt(length - 1) == '\r') {
                length--;
            }
        } else if (charAt2 != '\r') {
            length++;
        }
        return str.substring(0, length);
    }

    public static String chop(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length < 2) {
            return "";
        }
        int i10 = length - 1;
        String substring = str.substring(0, i10);
        if (str.charAt(i10) == '\n') {
            int i11 = i10 - 1;
            if (substring.charAt(i11) == '\r') {
                return substring.substring(0, i11);
            }
        }
        return substring;
    }

    public static int compare(String str, String str2) {
        return compare(str, str2, true);
    }

    public static int compareIgnoreCase(String str, String str2) {
        return compareIgnoreCase(str, str2, true);
    }

    public static boolean contains(CharSequence charSequence, int i10) {
        return !isEmpty(charSequence) && CharSequenceUtils.indexOf(charSequence, i10, 0) >= 0;
    }

    public static boolean containsAny(CharSequence charSequence, char... cArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
            int length = charSequence.length();
            int length2 = cArr.length;
            int i10 = length - 1;
            int i11 = length2 - 1;
            for (int i12 = 0; i12 < length; i12++) {
                char charAt = charSequence.charAt(i12);
                for (int i13 = 0; i13 < length2; i13++) {
                    if (cArr[i13] == charAt) {
                        if (!Character.isHighSurrogate(charAt) || i13 == i11) {
                            return true;
                        }
                        if (i12 < i10 && cArr[i13 + 1] == charSequence.charAt(i12 + 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean containsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            int length = charSequence2.length();
            int length2 = charSequence.length() - length;
            for (int i10 = 0; i10 <= length2; i10++) {
                if (CharSequenceUtils.regionMatches(charSequence, true, i10, charSequence2, 0, length)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsNone(CharSequence charSequence, char... cArr) {
        if (charSequence != null && cArr != null) {
            int length = charSequence.length();
            int i10 = length - 1;
            int length2 = cArr.length;
            int i11 = length2 - 1;
            for (int i12 = 0; i12 < length; i12++) {
                char charAt = charSequence.charAt(i12);
                for (int i13 = 0; i13 < length2; i13++) {
                    if (cArr[i13] == charAt) {
                        if (!Character.isHighSurrogate(charAt) || i13 == i11) {
                            return false;
                        }
                        if (i12 < i10 && cArr[i13 + 1] == charSequence.charAt(i12 + 1)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean containsOnly(CharSequence charSequence, char... cArr) {
        if (cArr == null || charSequence == null) {
            return false;
        }
        if (charSequence.length() == 0) {
            return true;
        }
        return cArr.length != 0 && indexOfAnyBut(charSequence, cArr) == -1;
    }

    public static boolean containsWhitespace(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (Character.isWhitespace(charSequence.charAt(i10))) {
                return true;
            }
        }
        return false;
    }

    private static void convertRemainingAccentCharacters(StringBuilder sb2) {
        for (int i10 = 0; i10 < sb2.length(); i10++) {
            if (sb2.charAt(i10) == 321) {
                sb2.deleteCharAt(i10);
                sb2.insert(i10, 'L');
            } else if (sb2.charAt(i10) == 322) {
                sb2.deleteCharAt(i10);
                sb2.insert(i10, 'l');
            }
        }
    }

    public static int countMatches(CharSequence charSequence, CharSequence charSequence2) {
        int i10 = 0;
        if (isEmpty(charSequence) || isEmpty(charSequence2)) {
            return 0;
        }
        int i11 = 0;
        while (true) {
            int indexOf = CharSequenceUtils.indexOf(charSequence, charSequence2, i10);
            if (indexOf == -1) {
                return i11;
            }
            i11++;
            i10 = indexOf + charSequence2.length();
        }
    }

    public static <T extends CharSequence> T defaultIfBlank(T t2, T t10) {
        return isBlank(t2) ? t10 : t2;
    }

    public static <T extends CharSequence> T defaultIfEmpty(T t2, T t10) {
        return isEmpty(t2) ? t10 : t2;
    }

    public static String defaultString(String str) {
        return defaultString(str, "");
    }

    public static String defaultString(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static String deleteWhitespace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            if (!Character.isWhitespace(str.charAt(i11))) {
                cArr[i10] = str.charAt(i11);
                i10++;
            }
        }
        return i10 == length ? str : new String(cArr, 0, i10);
    }

    public static String difference(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        int indexOfDifference = indexOfDifference(str, str2);
        return indexOfDifference == -1 ? "" : str2.substring(indexOfDifference);
    }

    public static boolean endsWith(CharSequence charSequence, CharSequence charSequence2) {
        return endsWith(charSequence, charSequence2, false);
    }

    public static boolean endsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (endsWith(charSequence, charSequence2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean endsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return endsWith(charSequence, charSequence2, true);
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (charSequence.charAt(i10) != charSequence2.charAt(i10)) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (ArrayUtils.isNotEmpty(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (equals(charSequence, charSequence2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean equalsAnyIgnoreCase(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (ArrayUtils.isNotEmpty(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (equalsIgnoreCase(charSequence, charSequence2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean equalsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        return CharSequenceUtils.regionMatches(charSequence, true, 0, charSequence2, 0, charSequence.length());
    }

    @SafeVarargs
    public static <T extends CharSequence> T firstNonBlank(T... tArr) {
        if (tArr == null) {
            return null;
        }
        for (T t2 : tArr) {
            if (isNotBlank(t2)) {
                return t2;
            }
        }
        return null;
    }

    @SafeVarargs
    public static <T extends CharSequence> T firstNonEmpty(T... tArr) {
        if (tArr == null) {
            return null;
        }
        for (T t2 : tArr) {
            if (isNotEmpty(t2)) {
                return t2;
            }
        }
        return null;
    }

    public static String getCommonPrefix(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        int indexOfDifference = indexOfDifference(strArr);
        return indexOfDifference == -1 ? strArr[0] == null ? "" : strArr[0] : indexOfDifference == 0 ? "" : strArr[0].substring(0, indexOfDifference);
    }

    public static String getDigits(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(length);
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (Character.isDigit(charAt)) {
                sb2.append(charAt);
            }
        }
        return sb2.toString();
    }

    @Deprecated
    public static int getFuzzyDistance(CharSequence charSequence, CharSequence charSequence2, Locale locale) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        if (locale != null) {
            String lowerCase = charSequence.toString().toLowerCase(locale);
            String lowerCase2 = charSequence2.toString().toLowerCase(locale);
            int i10 = Integer.MIN_VALUE;
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 < lowerCase2.length(); i13++) {
                char charAt = lowerCase2.charAt(i13);
                boolean z10 = false;
                while (i12 < lowerCase.length() && !z10) {
                    if (charAt == lowerCase.charAt(i12)) {
                        i11++;
                        if (i10 + 1 == i12) {
                            i11 += 2;
                        }
                        z10 = true;
                        i10 = i12;
                    }
                    i12++;
                }
            }
            return i11;
        }
        throw new IllegalArgumentException("Locale must not be null");
    }

    @Deprecated
    public static double getJaroWinklerDistance(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            double d10 = matches(charSequence, charSequence2)[0];
            if (d10 == ShadowDrawableWrapper.COS_45) {
                return ShadowDrawableWrapper.COS_45;
            }
            double length = (((d10 / charSequence.length()) + (d10 / charSequence2.length())) + ((d10 - r0[1]) / d10)) / 3.0d;
            if (length >= 0.7d) {
                length += Math.min(0.1d, 1.0d / r0[3]) * r0[2] * (1.0d - length);
            }
            return Math.round(length * 100.0d) / 100.0d;
        }
        throw new IllegalArgumentException("Strings must not be null");
    }

    @Deprecated
    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            int length = charSequence.length();
            int length2 = charSequence2.length();
            if (length == 0) {
                return length2;
            }
            if (length2 == 0) {
                return length;
            }
            if (length > length2) {
                length2 = charSequence.length();
                length = length2;
            } else {
                charSequence2 = charSequence;
                charSequence = charSequence2;
            }
            int[] iArr = new int[length + 1];
            for (int i10 = 0; i10 <= length; i10++) {
                iArr[i10] = i10;
            }
            for (int i11 = 1; i11 <= length2; i11++) {
                int i12 = iArr[0];
                char charAt = charSequence.charAt(i11 - 1);
                iArr[0] = i11;
                int i13 = 1;
                while (i13 <= length) {
                    int i14 = iArr[i13];
                    int i15 = i13 - 1;
                    iArr[i13] = Math.min(Math.min(iArr[i15] + 1, iArr[i13] + 1), i12 + (charSequence2.charAt(i15) == charAt ? 0 : 1));
                    i13++;
                    i12 = i14;
                }
            }
            return iArr[length];
        }
        throw new IllegalArgumentException("Strings must not be null");
    }

    public static int indexOf(CharSequence charSequence, int i10) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, i10, 0);
    }

    public static int indexOfAny(CharSequence charSequence, char... cArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
            int length = charSequence.length();
            int i10 = length - 1;
            int length2 = cArr.length;
            int i11 = length2 - 1;
            for (int i12 = 0; i12 < length; i12++) {
                char charAt = charSequence.charAt(i12);
                for (int i13 = 0; i13 < length2; i13++) {
                    if (cArr[i13] == charAt && (i12 >= i10 || i13 >= i11 || !Character.isHighSurrogate(charAt) || cArr[i13 + 1] == charSequence.charAt(i12 + 1))) {
                        return i12;
                    }
                }
            }
        }
        return -1;
    }

    public static int indexOfAnyBut(CharSequence charSequence, char... cArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
            int length = charSequence.length();
            int i10 = length - 1;
            int length2 = cArr.length;
            int i11 = length2 - 1;
            for (int i12 = 0; i12 < length; i12++) {
                char charAt = charSequence.charAt(i12);
                for (int i13 = 0; i13 < length2; i13++) {
                    if (cArr[i13] != charAt || (i12 < i10 && i13 < i11 && Character.isHighSurrogate(charAt) && cArr[i13 + 1] != charSequence.charAt(i12 + 1))) {
                    }
                }
                return i12;
            }
        }
        return -1;
    }

    public static int indexOfDifference(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return -1;
        }
        int i10 = 0;
        if (charSequence != null && charSequence2 != null) {
            while (i10 < charSequence.length() && i10 < charSequence2.length() && charSequence.charAt(i10) == charSequence2.charAt(i10)) {
                i10++;
            }
            if (i10 >= charSequence2.length() && i10 >= charSequence.length()) {
                return -1;
            }
        }
        return i10;
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return indexOfIgnoreCase(charSequence, charSequence2, 0);
    }

    public static boolean isAllBlank(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty(charSequenceArr)) {
            return true;
        }
        for (CharSequence charSequence : charSequenceArr) {
            if (isNotBlank(charSequence)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllEmpty(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty(charSequenceArr)) {
            return true;
        }
        for (CharSequence charSequence : charSequenceArr) {
            if (isNotEmpty(charSequence)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllLowerCase(CharSequence charSequence) {
        if (charSequence == null || isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isLowerCase(charSequence.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllUpperCase(CharSequence charSequence) {
        if (charSequence == null || isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isUpperCase(charSequence.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlpha(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isLetter(charSequence.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphaSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isLetter(charSequence.charAt(i10)) && charSequence.charAt(i10) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumeric(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isLetterOrDigit(charSequence.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumericSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isLetterOrDigit(charSequence.charAt(i10)) && charSequence.charAt(i10) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnyBlank(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty(charSequenceArr)) {
            return false;
        }
        for (CharSequence charSequence : charSequenceArr) {
            if (isBlank(charSequence)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAnyEmpty(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty(charSequenceArr)) {
            return false;
        }
        for (CharSequence charSequence : charSequenceArr) {
            if (isEmpty(charSequence)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAsciiPrintable(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!CharUtils.isAsciiPrintable(charSequence.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBlank(CharSequence charSequence) {
        int length;
        if (charSequence != null && (length = charSequence.length()) != 0) {
            for (int i10 = 0; i10 < length; i10++) {
                if (!Character.isWhitespace(charSequence.charAt(i10))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isMixedCase(CharSequence charSequence) {
        if (isEmpty(charSequence) || charSequence.length() == 1) {
            return false;
        }
        int length = charSequence.length();
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 = 0; i10 < length; i10++) {
            if (z10 && z11) {
                return true;
            }
            if (Character.isUpperCase(charSequence.charAt(i10))) {
                z10 = true;
            } else if (Character.isLowerCase(charSequence.charAt(i10))) {
                z11 = true;
            }
        }
        return z10 && z11;
    }

    public static boolean isNoneBlank(CharSequence... charSequenceArr) {
        return !isAnyBlank(charSequenceArr);
    }

    public static boolean isNoneEmpty(CharSequence... charSequenceArr) {
        return !isAnyEmpty(charSequenceArr);
    }

    public static boolean isNotBlank(CharSequence charSequence) {
        return !isBlank(charSequence);
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    public static boolean isNumeric(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isDigit(charSequence.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumericSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isDigit(charSequence.charAt(i10)) && charSequence.charAt(i10) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isWhitespace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isWhitespace(charSequence.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    @SafeVarargs
    public static <T> String join(T... tArr) {
        return join(tArr, (String) null);
    }

    public static String joinWith(String str, Object... objArr) {
        if (objArr != null) {
            String defaultString = defaultString(str);
            StringBuilder sb2 = new StringBuilder();
            Iterator iterator2 = Arrays.asList(objArr).iterator2();
            while (iterator2.hasNext()) {
                sb2.append(Objects.toString(iterator2.next(), ""));
                if (iterator2.hasNext()) {
                    sb2.append(defaultString);
                }
            }
            return sb2.toString();
        }
        throw new IllegalArgumentException("Object varargs must not be null");
    }

    public static int lastIndexOf(CharSequence charSequence, int i10) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, i10, charSequence.length());
    }

    public static int lastIndexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        int lastIndexOf;
        int i10 = -1;
        if (charSequence != null && charSequenceArr != null) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (charSequence2 != null && (lastIndexOf = CharSequenceUtils.lastIndexOf(charSequence, charSequence2, charSequence.length())) > i10) {
                    i10 = lastIndexOf;
                }
            }
        }
        return i10;
    }

    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return lastIndexOfIgnoreCase(charSequence, charSequence2, charSequence.length());
    }

    public static int lastOrdinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i10) {
        return ordinalIndexOf(charSequence, charSequence2, i10, true);
    }

    public static String left(String str, int i10) {
        if (str == null) {
            return null;
        }
        return i10 < 0 ? "" : str.length() <= i10 ? str : str.substring(0, i10);
    }

    public static String leftPad(String str, int i10) {
        return leftPad(str, i10, ' ');
    }

    public static int length(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static String lowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    private static int[] matches(CharSequence charSequence, CharSequence charSequence2) {
        CharSequence charSequence3;
        CharSequence charSequence4;
        if (charSequence.length() > charSequence2.length()) {
            charSequence4 = charSequence;
            charSequence3 = charSequence2;
        } else {
            charSequence3 = charSequence;
            charSequence4 = charSequence2;
        }
        int max = Math.max((charSequence4.length() / 2) - 1, 0);
        int[] iArr = new int[charSequence3.length()];
        Arrays.fill(iArr, -1);
        boolean[] zArr = new boolean[charSequence4.length()];
        int i10 = 0;
        for (int i11 = 0; i11 < charSequence3.length(); i11++) {
            char charAt = charSequence3.charAt(i11);
            int max2 = Math.max(i11 - max, 0);
            int min = Math.min(i11 + max + 1, charSequence4.length());
            while (true) {
                if (max2 >= min) {
                    break;
                }
                if (!zArr[max2] && charAt == charSequence4.charAt(max2)) {
                    iArr[i11] = max2;
                    zArr[max2] = true;
                    i10++;
                    break;
                }
                max2++;
            }
        }
        char[] cArr = new char[i10];
        char[] cArr2 = new char[i10];
        int i12 = 0;
        for (int i13 = 0; i13 < charSequence3.length(); i13++) {
            if (iArr[i13] != -1) {
                cArr[i12] = charSequence3.charAt(i13);
                i12++;
            }
        }
        int i14 = 0;
        for (int i15 = 0; i15 < charSequence4.length(); i15++) {
            if (zArr[i15]) {
                cArr2[i14] = charSequence4.charAt(i15);
                i14++;
            }
        }
        int i16 = 0;
        for (int i17 = 0; i17 < i10; i17++) {
            if (cArr[i17] != cArr2[i17]) {
                i16++;
            }
        }
        int i18 = 0;
        for (int i19 = 0; i19 < charSequence3.length() && charSequence.charAt(i19) == charSequence2.charAt(i19); i19++) {
            i18++;
        }
        return new int[]{i10, i16 / 2, i18, charSequence4.length()};
    }

    public static String mid(String str, int i10, int i11) {
        if (str == null) {
            return null;
        }
        if (i11 < 0 || i10 > str.length()) {
            return "";
        }
        if (i10 < 0) {
            i10 = 0;
        }
        int i12 = i11 + i10;
        if (str.length() <= i12) {
            return str.substring(i10);
        }
        return str.substring(i10, i12);
    }

    private static StringBuilder newStringBuilder(int i10) {
        return new StringBuilder(i10 * 16);
    }

    public static String normalizeSpace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        boolean z10 = true;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = str.charAt(i12);
            if (Character.isWhitespace(charAt)) {
                if (i11 == 0 && !z10) {
                    cArr[i10] = " ".charAt(0);
                    i10++;
                }
                i11++;
            } else {
                int i13 = i10 + 1;
                if (charAt == 160) {
                    charAt = ' ';
                }
                cArr[i10] = charAt;
                i10 = i13;
                z10 = false;
                i11 = 0;
            }
        }
        if (z10) {
            return "";
        }
        return new String(cArr, 0, i10 - (i11 <= 0 ? 0 : 1)).trim();
    }

    public static int ordinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i10) {
        return ordinalIndexOf(charSequence, charSequence2, i10, false);
    }

    public static String overlay(String str, String str2, int i10, int i11) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        int length = str.length();
        if (i10 < 0) {
            i10 = 0;
        }
        if (i10 > length) {
            i10 = length;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        if (i11 <= length) {
            length = i11;
        }
        if (i10 > length) {
            int i12 = length;
            length = i10;
            i10 = i12;
        }
        return str.substring(0, i10) + str2 + str.substring(length);
    }

    private static String prependIfMissing(String str, CharSequence charSequence, boolean z10, CharSequence... charSequenceArr) {
        if (str == null || isEmpty(charSequence) || startsWith(str, charSequence, z10)) {
            return str;
        }
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (startsWith(str, charSequence2, z10)) {
                    return str;
                }
            }
        }
        return charSequence.toString() + str;
    }

    public static String prependIfMissingIgnoreCase(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return prependIfMissing(str, charSequence, true, charSequenceArr);
    }

    public static String remove(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2)) ? str : replace(str, str2, "", -1);
    }

    @Deprecated
    public static String removeAll(String str, String str2) {
        return RegExUtils.removeAll(str, str2);
    }

    public static String removeEnd(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !str.endsWith(str2)) ? str : str.substring(0, str.length() - str2.length());
    }

    public static String removeEndIgnoreCase(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !endsWithIgnoreCase(str, str2)) ? str : str.substring(0, str.length() - str2.length());
    }

    @Deprecated
    public static String removeFirst(String str, String str2) {
        return replaceFirst(str, str2, "");
    }

    public static String removeIgnoreCase(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2)) ? str : replaceIgnoreCase(str, str2, "", -1);
    }

    @Deprecated
    public static String removePattern(String str, String str2) {
        return RegExUtils.removePattern(str, str2);
    }

    public static String removeStart(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !str.startsWith(str2)) ? str : str.substring(str2.length());
    }

    public static String removeStartIgnoreCase(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !startsWithIgnoreCase(str, str2)) ? str : str.substring(str2.length());
    }

    public static String repeat(String str, int i10) {
        if (str == null) {
            return null;
        }
        if (i10 <= 0) {
            return "";
        }
        int length = str.length();
        if (i10 == 1 || length == 0) {
            return str;
        }
        if (length == 1 && i10 <= 8192) {
            return repeat(str.charAt(0), i10);
        }
        int i11 = length * i10;
        if (length == 1) {
            return repeat(str.charAt(0), i10);
        }
        if (length != 2) {
            StringBuilder sb2 = new StringBuilder(i11);
            for (int i12 = 0; i12 < i10; i12++) {
                sb2.append(str);
            }
            return sb2.toString();
        }
        char charAt = str.charAt(0);
        char charAt2 = str.charAt(1);
        char[] cArr = new char[i11];
        for (int i13 = (i10 * 2) - 2; i13 >= 0; i13 = (i13 - 1) - 1) {
            cArr[i13] = charAt;
            cArr[i13 + 1] = charAt2;
        }
        return new String(cArr);
    }

    public static String replace(String str, String str2, String str3) {
        return replace(str, str2, str3, -1);
    }

    @Deprecated
    public static String replaceAll(String str, String str2, String str3) {
        return RegExUtils.replaceAll(str, str2, str3);
    }

    public static String replaceChars(String str, char c4, char c10) {
        if (str == null) {
            return null;
        }
        return str.replace(c4, c10);
    }

    public static String replaceEach(String str, String[] strArr, String[] strArr2) {
        return replaceEach(str, strArr, strArr2, false, 0);
    }

    public static String replaceEachRepeatedly(String str, String[] strArr, String[] strArr2) {
        return replaceEach(str, strArr, strArr2, true, strArr == null ? 0 : strArr.length);
    }

    @Deprecated
    public static String replaceFirst(String str, String str2, String str3) {
        return RegExUtils.replaceFirst(str, str2, str3);
    }

    public static String replaceIgnoreCase(String str, String str2, String str3) {
        return replaceIgnoreCase(str, str2, str3, -1);
    }

    public static String replaceOnce(String str, String str2, String str3) {
        return replace(str, str2, str3, 1);
    }

    public static String replaceOnceIgnoreCase(String str, String str2, String str3) {
        return replaceIgnoreCase(str, str2, str3, 1);
    }

    @Deprecated
    public static String replacePattern(String str, String str2, String str3) {
        return RegExUtils.replacePattern(str, str2, str3);
    }

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseDelimited(String str, char c4) {
        if (str == null) {
            return null;
        }
        String[] split = split(str, c4);
        ArrayUtils.reverse(split);
        return join(split, c4);
    }

    public static String right(String str, int i10) {
        if (str == null) {
            return null;
        }
        return i10 < 0 ? "" : str.length() <= i10 ? str : str.substring(str.length() - i10);
    }

    public static String rightPad(String str, int i10) {
        return rightPad(str, i10, ' ');
    }

    public static String rotate(String str, int i10) {
        int i11;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (i10 == 0 || length == 0 || (i11 = i10 % length) == 0) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(length);
        int i12 = -i11;
        sb2.append(substring(str, i12));
        sb2.append(substring(str, 0, i12));
        return sb2.toString();
    }

    public static String[] split(String str) {
        return split(str, null, -1);
    }

    public static String[] splitByCharacterType(String str) {
        return splitByCharacterType(str, false);
    }

    public static String[] splitByCharacterTypeCamelCase(String str) {
        return splitByCharacterType(str, true);
    }

    public static String[] splitByWholeSeparator(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, true);
    }

    private static String[] splitByWholeSeparatorWorker(String str, String str2, int i10, boolean z10) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        if (str2 != null && !"".equals(str2)) {
            int length2 = str2.length();
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (i11 < length) {
                i11 = str.indexOf(str2, i12);
                if (i11 > -1) {
                    if (i11 > i12) {
                        i13++;
                        if (i13 == i10) {
                            arrayList.add(str.substring(i12));
                        } else {
                            arrayList.add(str.substring(i12, i11));
                        }
                    } else if (z10) {
                        i13++;
                        if (i13 == i10) {
                            arrayList.add(str.substring(i12));
                            i11 = length;
                        } else {
                            arrayList.add("");
                        }
                    }
                    i12 = i11 + length2;
                } else {
                    arrayList.add(str.substring(i12));
                }
                i11 = length;
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return splitWorker(str, null, i10, z10);
    }

    public static String[] splitPreserveAllTokens(String str) {
        return splitWorker(str, null, -1, true);
    }

    private static String[] splitWorker(String str, char c4, boolean z10) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        boolean z11 = false;
        boolean z12 = false;
        int i11 = 0;
        while (i10 < length) {
            if (str.charAt(i10) == c4) {
                if (z11 || z10) {
                    arrayList.add(str.substring(i11, i10));
                    z11 = false;
                    z12 = true;
                }
                i11 = i10 + 1;
                i10 = i11;
            } else {
                i10++;
                z11 = true;
                z12 = false;
            }
        }
        if (z11 || (z10 && z12)) {
            arrayList.add(str.substring(i11, i10));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean startsWith(CharSequence charSequence, CharSequence charSequence2) {
        return startsWith(charSequence, charSequence2, false);
    }

    public static boolean startsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (startsWith(charSequence, charSequence2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean startsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return startsWith(charSequence, charSequence2, true);
    }

    public static String strip(String str) {
        return strip(str, null);
    }

    public static String stripAccents(String str) {
        if (str == null) {
            return null;
        }
        Pattern compile = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        StringBuilder sb2 = new StringBuilder(Normalizer.normalize(str, Normalizer.Form.NFD));
        convertRemainingAccentCharacters(sb2);
        return compile.matcher(sb2).replaceAll("");
    }

    public static String[] stripAll(String... strArr) {
        return stripAll(strArr, null);
    }

    public static String stripEnd(String str, String str2) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        if (str2 == null) {
            while (length != 0 && Character.isWhitespace(str.charAt(length - 1))) {
                length--;
            }
        } else {
            if (str2.isEmpty()) {
                return str;
            }
            while (length != 0 && str2.indexOf(str.charAt(length - 1)) != -1) {
                length--;
            }
        }
        return str.substring(0, length);
    }

    public static String stripStart(String str, String str2) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        int i10 = 0;
        if (str2 == null) {
            while (i10 != length && Character.isWhitespace(str.charAt(i10))) {
                i10++;
            }
        } else {
            if (str2.isEmpty()) {
                return str;
            }
            while (i10 != length && str2.indexOf(str.charAt(i10)) != -1) {
                i10++;
            }
        }
        return str.substring(i10);
    }

    public static String stripToEmpty(String str) {
        return str == null ? "" : strip(str, null);
    }

    public static String stripToNull(String str) {
        if (str == null) {
            return null;
        }
        String strip = strip(str, null);
        if (strip.isEmpty()) {
            return null;
        }
        return strip;
    }

    public static String substring(String str, int i10) {
        if (str == null) {
            return null;
        }
        if (i10 < 0) {
            i10 += str.length();
        }
        if (i10 < 0) {
            i10 = 0;
        }
        return i10 > str.length() ? "" : str.substring(i10);
    }

    public static String substringAfter(String str, String str2) {
        int indexOf;
        return isEmpty(str) ? str : (str2 == null || (indexOf = str.indexOf(str2)) == -1) ? "" : str.substring(indexOf + str2.length());
    }

    public static String substringAfterLast(String str, String str2) {
        int lastIndexOf;
        return isEmpty(str) ? str : (isEmpty(str2) || (lastIndexOf = str.lastIndexOf(str2)) == -1 || lastIndexOf == str.length() - str2.length()) ? "" : str.substring(lastIndexOf + str2.length());
    }

    public static String substringBefore(String str, String str2) {
        if (isEmpty(str) || str2 == null) {
            return str;
        }
        if (str2.isEmpty()) {
            return "";
        }
        int indexOf = str.indexOf(str2);
        return indexOf == -1 ? str : str.substring(0, indexOf);
    }

    public static String substringBeforeLast(String str, String str2) {
        int lastIndexOf;
        return (isEmpty(str) || isEmpty(str2) || (lastIndexOf = str.lastIndexOf(str2)) == -1) ? str : str.substring(0, lastIndexOf);
    }

    public static String substringBetween(String str, String str2) {
        return substringBetween(str, str2, str2);
    }

    public static String[] substringsBetween(String str, String str2, String str3) {
        int indexOf;
        int i10;
        int indexOf2;
        if (str == null || isEmpty(str2) || isEmpty(str3)) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        int length2 = str3.length();
        int length3 = str2.length();
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < length - length2 && (indexOf = str.indexOf(str2, i11)) >= 0 && (indexOf2 = str.indexOf(str3, (i10 = indexOf + length3))) >= 0) {
            arrayList.add(str.substring(i10, indexOf2));
            i11 = indexOf2 + length2;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String swapCase(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int[] iArr = new int[length];
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int codePointAt = str.codePointAt(i10);
            if (Character.isUpperCase(codePointAt)) {
                codePointAt = Character.toLowerCase(codePointAt);
            } else if (Character.isTitleCase(codePointAt)) {
                codePointAt = Character.toLowerCase(codePointAt);
            } else if (Character.isLowerCase(codePointAt)) {
                codePointAt = Character.toUpperCase(codePointAt);
            }
            iArr[i11] = codePointAt;
            i10 += Character.charCount(codePointAt);
            i11++;
        }
        return new String(iArr, 0, i11);
    }

    public static int[] toCodePoints(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        if (charSequence.length() == 0) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        String charSequence2 = charSequence.toString();
        int codePointCount = charSequence2.codePointCount(0, charSequence2.length());
        int[] iArr = new int[codePointCount];
        int i10 = 0;
        for (int i11 = 0; i11 < codePointCount; i11++) {
            iArr[i11] = charSequence2.codePointAt(i10);
            i10 += Character.charCount(iArr[i11]);
        }
        return iArr;
    }

    public static String toEncodedString(byte[] bArr, Charset charset) {
        if (charset == null) {
            charset = Charset.defaultCharset();
        }
        return new String(bArr, charset);
    }

    @Deprecated
    public static String toString(byte[] bArr, String str) throws UnsupportedEncodingException {
        return str != null ? new String(bArr, str) : new String(bArr, Charset.defaultCharset());
    }

    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }

    public static String trimToNull(String str) {
        String trim = trim(str);
        if (isEmpty(trim)) {
            return null;
        }
        return trim;
    }

    public static String truncate(String str, int i10) {
        return truncate(str, 0, i10);
    }

    public static String uncapitalize(String str) {
        int length;
        int codePointAt;
        int lowerCase;
        if (str == null || (length = str.length()) == 0 || codePointAt == (lowerCase = Character.toLowerCase((codePointAt = str.codePointAt(0))))) {
            return str;
        }
        int[] iArr = new int[length];
        iArr[0] = lowerCase;
        int charCount = Character.charCount(codePointAt);
        int i10 = 1;
        while (charCount < length) {
            int codePointAt2 = str.codePointAt(charCount);
            iArr[i10] = codePointAt2;
            charCount += Character.charCount(codePointAt2);
            i10++;
        }
        return new String(iArr, 0, i10);
    }

    public static String unwrap(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2) || !startsWith(str, str2) || !endsWith(str, str2)) {
            return str;
        }
        int indexOf = str.indexOf(str2);
        int lastIndexOf = str.lastIndexOf(str2);
        return (indexOf == -1 || lastIndexOf == -1) ? str : str.substring(indexOf + str2.length(), lastIndexOf);
    }

    public static String upperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    public static String valueOf(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return String.valueOf(cArr);
    }

    public static String wrap(String str, char c4) {
        if (isEmpty(str) || c4 == 0) {
            return str;
        }
        return c4 + str + c4;
    }

    public static String wrapIfMissing(String str, char c4) {
        if (isEmpty(str) || c4 == 0) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 2);
        if (str.charAt(0) != c4) {
            sb2.append(c4);
        }
        sb2.append(str);
        if (str.charAt(str.length() - 1) != c4) {
            sb2.append(c4);
        }
        return sb2.toString();
    }

    public static String abbreviate(String str, int i10, int i11) {
        return abbreviate(str, "...", i10, i11);
    }

    public static String center(String str, int i10, char c4) {
        int length;
        int length2;
        return (str == null || i10 <= 0 || (length2 = i10 - (length = str.length())) <= 0) ? str : rightPad(leftPad(str, length + (length2 / 2), c4), i10, c4);
    }

    public static int compare(String str, String str2, boolean z10) {
        if (str == str2) {
            return 0;
        }
        if (str == null) {
            return z10 ? -1 : 1;
        }
        if (str2 == null) {
            return z10 ? 1 : -1;
        }
        return str.compareTo(str2);
    }

    public static int compareIgnoreCase(String str, String str2, boolean z10) {
        if (str == str2) {
            return 0;
        }
        if (str == null) {
            return z10 ? -1 : 1;
        }
        if (str2 == null) {
            return z10 ? 1 : -1;
        }
        return str.compareToIgnoreCase(str2);
    }

    private static boolean endsWith(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        }
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        return CharSequenceUtils.regionMatches(charSequence, z10, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length());
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i10) {
        if (charSequence != null && charSequence2 != null) {
            if (i10 < 0) {
                i10 = 0;
            }
            int length = (charSequence.length() - charSequence2.length()) + 1;
            if (i10 > length) {
                return -1;
            }
            if (charSequence2.length() == 0) {
                return i10;
            }
            while (i10 < length) {
                if (CharSequenceUtils.regionMatches(charSequence, true, i10, charSequence2, 0, charSequence2.length())) {
                    return i10;
                }
                i10++;
            }
        }
        return -1;
    }

    public static String join(Object[] objArr, char c4) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, c4, 0, objArr.length);
    }

    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i10) {
        if (charSequence != null && charSequence2 != null) {
            if (i10 > charSequence.length() - charSequence2.length()) {
                i10 = charSequence.length() - charSequence2.length();
            }
            if (i10 < 0) {
                return -1;
            }
            if (charSequence2.length() == 0) {
                return i10;
            }
            while (i10 >= 0) {
                if (CharSequenceUtils.regionMatches(charSequence, true, i10, charSequence2, 0, charSequence2.length())) {
                    return i10;
                }
                i10--;
            }
        }
        return -1;
    }

    public static String leftPad(String str, int i10, char c4) {
        if (str == null) {
            return null;
        }
        int length = i10 - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return leftPad(str, i10, String.valueOf(c4));
        }
        return repeat(c4, length).concat(str);
    }

    public static String lowerCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(locale);
    }

    private static int ordinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i10, boolean z10) {
        if (charSequence != null && charSequence2 != null && i10 > 0) {
            int i11 = 0;
            if (charSequence2.length() == 0) {
                if (z10) {
                    return charSequence.length();
                }
                return 0;
            }
            r0 = z10 ? charSequence.length() : -1;
            do {
                if (z10) {
                    r0 = CharSequenceUtils.lastIndexOf(charSequence, charSequence2, r0 - 1);
                } else {
                    r0 = CharSequenceUtils.indexOf(charSequence, charSequence2, r0 + 1);
                }
                if (r0 < 0) {
                    return r0;
                }
                i11++;
            } while (i11 < i10);
        }
        return r0;
    }

    public static String replace(String str, String str2, String str3, int i10) {
        return replace(str, str2, str3, i10, false);
    }

    public static String replaceChars(String str, String str2, String str3) {
        if (isEmpty(str) || isEmpty(str2)) {
            return str;
        }
        if (str3 == null) {
            str3 = "";
        }
        int length = str3.length();
        int length2 = str.length();
        StringBuilder sb2 = new StringBuilder(length2);
        boolean z10 = false;
        for (int i10 = 0; i10 < length2; i10++) {
            char charAt = str.charAt(i10);
            int indexOf = str2.indexOf(charAt);
            if (indexOf >= 0) {
                if (indexOf < length) {
                    sb2.append(str3.charAt(indexOf));
                }
                z10 = true;
            } else {
                sb2.append(charAt);
            }
        }
        return z10 ? sb2.toString() : str;
    }

    private static String replaceEach(String str, String[] strArr, String[] strArr2, boolean z10, int i10) {
        int length;
        if (str == null || str.isEmpty() || strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0) {
            return str;
        }
        if (i10 >= 0) {
            int length2 = strArr.length;
            int length3 = strArr2.length;
            if (length2 == length3) {
                boolean[] zArr = new boolean[length2];
                int i11 = -1;
                int i12 = -1;
                for (int i13 = 0; i13 < length2; i13++) {
                    if (!zArr[i13] && strArr[i13] != null && !strArr[i13].isEmpty() && strArr2[i13] != null) {
                        int indexOf = str.indexOf(strArr[i13]);
                        if (indexOf == -1) {
                            zArr[i13] = true;
                        } else if (i11 == -1 || indexOf < i11) {
                            i12 = i13;
                            i11 = indexOf;
                        }
                    }
                }
                if (i11 == -1) {
                    return str;
                }
                int i14 = 0;
                for (int i15 = 0; i15 < strArr.length; i15++) {
                    if (strArr[i15] != null && strArr2[i15] != null && (length = strArr2[i15].length() - strArr[i15].length()) > 0) {
                        i14 += length * 3;
                    }
                }
                StringBuilder sb2 = new StringBuilder(str.length() + Math.min(i14, str.length() / 5));
                int i16 = 0;
                while (i11 != -1) {
                    while (i16 < i11) {
                        sb2.append(str.charAt(i16));
                        i16++;
                    }
                    sb2.append(strArr2[i12]);
                    i16 = strArr[i12].length() + i11;
                    i11 = -1;
                    i12 = -1;
                    for (int i17 = 0; i17 < length2; i17++) {
                        if (!zArr[i17] && strArr[i17] != null && !strArr[i17].isEmpty() && strArr2[i17] != null) {
                            int indexOf2 = str.indexOf(strArr[i17], i16);
                            if (indexOf2 == -1) {
                                zArr[i17] = true;
                            } else if (i11 == -1 || indexOf2 < i11) {
                                i12 = i17;
                                i11 = indexOf2;
                            }
                        }
                    }
                }
                int length4 = str.length();
                while (i16 < length4) {
                    sb2.append(str.charAt(i16));
                    i16++;
                }
                String sb3 = sb2.toString();
                return !z10 ? sb3 : replaceEach(sb3, strArr, strArr2, z10, i10 - 1);
            }
            throw new IllegalArgumentException("Search and Replace array lengths don't match: " + length2 + " vs " + length3);
        }
        throw new IllegalStateException("Aborting to protect against StackOverflowError - output of one loop is the input of another");
    }

    public static String replaceIgnoreCase(String str, String str2, String str3, int i10) {
        return replace(str, str2, str3, i10, true);
    }

    public static String rightPad(String str, int i10, char c4) {
        if (str == null) {
            return null;
        }
        int length = i10 - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return rightPad(str, i10, String.valueOf(c4));
        }
        return str.concat(repeat(c4, length));
    }

    public static String[] split(String str, char c4) {
        return splitWorker(str, c4, false);
    }

    private static String[] splitByCharacterType(String str, boolean z10) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        int type = Character.getType(charArray[0]);
        for (int i11 = 1; i11 < charArray.length; i11++) {
            int type2 = Character.getType(charArray[i11]);
            if (type2 != type) {
                if (z10 && type2 == 2 && type == 1) {
                    int i12 = i11 - 1;
                    if (i12 != i10) {
                        arrayList.add(new String(charArray, i10, i12 - i10));
                        i10 = i12;
                    }
                } else {
                    arrayList.add(new String(charArray, i10, i11 - i10));
                    i10 = i11;
                }
                type = type2;
            }
        }
        arrayList.add(new String(charArray, i10, charArray.length - i10));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] splitByWholeSeparator(String str, String str2, int i10) {
        return splitByWholeSeparatorWorker(str, str2, i10, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2, int i10) {
        return splitByWholeSeparatorWorker(str, str2, i10, true);
    }

    public static String[] splitPreserveAllTokens(String str, char c4) {
        return splitWorker(str, c4, true);
    }

    private static boolean startsWith(CharSequence charSequence, CharSequence charSequence2, boolean z10) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        }
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        return CharSequenceUtils.regionMatches(charSequence, z10, 0, charSequence2, 0, charSequence2.length());
    }

    public static String strip(String str, String str2) {
        return isEmpty(str) ? str : stripEnd(stripStart(str, str2), str2);
    }

    public static String[] stripAll(String[] strArr, String str) {
        int length;
        if (strArr == null || (length = strArr.length) == 0) {
            return strArr;
        }
        String[] strArr2 = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            strArr2[i10] = strip(strArr[i10], str);
        }
        return strArr2;
    }

    public static String substringBetween(String str, String str2, String str3) {
        int indexOf;
        int indexOf2;
        if (str == null || str2 == null || str3 == null || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, str2.length() + indexOf)) == -1) {
            return null;
        }
        return str.substring(indexOf + str2.length(), indexOf2);
    }

    public static String truncate(String str, int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException("offset cannot be negative");
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("maxWith cannot be negative");
        }
        if (str == null) {
            return null;
        }
        if (i10 > str.length()) {
            return "";
        }
        if (str.length() > i11) {
            int i12 = i11 + i10;
            if (i12 > str.length()) {
                i12 = str.length();
            }
            return str.substring(i10, i12);
        }
        return str.substring(i10);
    }

    public static String upperCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(locale);
    }

    public static String abbreviate(String str, String str2, int i10) {
        return abbreviate(str, str2, 0, i10);
    }

    public static boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        return (charSequence == null || charSequence2 == null || CharSequenceUtils.indexOf(charSequence, charSequence2, 0) < 0) ? false : true;
    }

    public static int indexOf(CharSequence charSequence, int i10, int i11) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, i10, i11);
    }

    public static String join(long[] jArr, char c4) {
        if (jArr == null) {
            return null;
        }
        return join(jArr, c4, 0, jArr.length);
    }

    public static int lastIndexOf(CharSequence charSequence, int i10, int i11) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, i10, i11);
    }

    public static String remove(String str, char c4) {
        if (isEmpty(str) || str.indexOf(c4) == -1) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i10 = 0;
        for (int i11 = 0; i11 < charArray.length; i11++) {
            if (charArray[i11] != c4) {
                charArray[i10] = charArray[i11];
                i10++;
            }
        }
        return new String(charArray, 0, i10);
    }

    private static String replace(String str, String str2, String str3, int i10, boolean z10) {
        String str4;
        if (isEmpty(str) || isEmpty(str2) || str3 == null || i10 == 0) {
            return str;
        }
        if (z10) {
            str4 = str.toLowerCase();
            str2 = str2.toLowerCase();
        } else {
            str4 = str;
        }
        int i11 = 0;
        int indexOf = str4.indexOf(str2, 0);
        if (indexOf == -1) {
            return str;
        }
        int length = str2.length();
        int length2 = str3.length() - length;
        if (length2 < 0) {
            length2 = 0;
        }
        int i12 = 64;
        if (i10 < 0) {
            i12 = 16;
        } else if (i10 <= 64) {
            i12 = i10;
        }
        StringBuilder sb2 = new StringBuilder(str.length() + (length2 * i12));
        while (indexOf != -1) {
            sb2.append((CharSequence) str, i11, indexOf);
            sb2.append(str3);
            i11 = indexOf + length;
            i10--;
            if (i10 == 0) {
                break;
            }
            indexOf = str4.indexOf(str2, i11);
        }
        sb2.append((CharSequence) str, i11, str.length());
        return sb2.toString();
    }

    public static String[] split(String str, String str2) {
        return splitWorker(str, str2, -1, false);
    }

    public static String[] splitPreserveAllTokens(String str, String str2) {
        return splitWorker(str, str2, -1, true);
    }

    public static String wrap(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2)) ? str : str2.concat(str).concat(str2);
    }

    public static String abbreviate(String str, String str2, int i10, int i11) {
        if (isEmpty(str) || isEmpty(str2)) {
            return str;
        }
        int length = str2.length();
        int i12 = length + 1;
        int i13 = length + length + 1;
        if (i11 >= i12) {
            if (str.length() <= i11) {
                return str;
            }
            if (i10 > str.length()) {
                i10 = str.length();
            }
            int i14 = i11 - length;
            if (str.length() - i10 < i14) {
                i10 = str.length() - i14;
            }
            if (i10 <= i12) {
                return str.substring(0, i14) + str2;
            }
            if (i11 >= i13) {
                if ((i11 + i10) - length < str.length()) {
                    return str2 + abbreviate(str.substring(i10), str2, i14);
                }
                return str2 + str.substring(str.length() - i14);
            }
            throw new IllegalArgumentException(String.format("Minimum abbreviation width with offset is %d", Integer.valueOf(i13)));
        }
        throw new IllegalArgumentException(String.format("Minimum abbreviation width is %d", Integer.valueOf(i12)));
    }

    public static boolean containsOnly(CharSequence charSequence, String str) {
        if (charSequence == null || str == null) {
            return false;
        }
        return containsOnly(charSequence, str.toCharArray());
    }

    public static int countMatches(CharSequence charSequence, char c4) {
        if (isEmpty(charSequence)) {
            return 0;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < charSequence.length(); i11++) {
            if (c4 == charSequence.charAt(i11)) {
                i10++;
            }
        }
        return i10;
    }

    public static int indexOfDifference(CharSequence... charSequenceArr) {
        if (charSequenceArr != null && charSequenceArr.length > 1) {
            int length = charSequenceArr.length;
            int i10 = Integer.MAX_VALUE;
            boolean z10 = true;
            int i11 = 0;
            boolean z11 = false;
            for (CharSequence charSequence : charSequenceArr) {
                if (charSequence == null) {
                    i10 = 0;
                    z11 = true;
                } else {
                    i10 = Math.min(charSequence.length(), i10);
                    i11 = Math.max(charSequence.length(), i11);
                    z10 = false;
                }
            }
            if (!z10 && (i11 != 0 || z11)) {
                if (i10 == 0) {
                    return 0;
                }
                int i12 = -1;
                for (int i13 = 0; i13 < i10; i13++) {
                    char charAt = charSequenceArr[0].charAt(i13);
                    int i14 = 1;
                    while (true) {
                        if (i14 >= length) {
                            break;
                        }
                        if (charSequenceArr[i14].charAt(i13) != charAt) {
                            i12 = i13;
                            break;
                        }
                        i14++;
                    }
                    if (i12 != -1) {
                        break;
                    }
                }
                return (i12 != -1 || i10 == i11) ? i12 : i10;
            }
        }
        return -1;
    }

    public static String join(int[] iArr, char c4) {
        if (iArr == null) {
            return null;
        }
        return join(iArr, c4, 0, iArr.length);
    }

    public static String[] split(String str, String str2, int i10) {
        return splitWorker(str, str2, i10, false);
    }

    public static String[] splitPreserveAllTokens(String str, String str2, int i10) {
        return splitWorker(str, str2, i10, true);
    }

    public static String substring(String str, int i10, int i11) {
        if (str == null) {
            return null;
        }
        if (i11 < 0) {
            i11 += str.length();
        }
        if (i10 < 0) {
            i10 += str.length();
        }
        if (i11 > str.length()) {
            i11 = str.length();
        }
        if (i10 > i11) {
            return "";
        }
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        return str.substring(i10, i11);
    }

    public static String center(String str, int i10, String str2) {
        if (str == null || i10 <= 0) {
            return str;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str.length();
        int i11 = i10 - length;
        return i11 <= 0 ? str : rightPad(leftPad(str, length + (i11 / 2), str2), i10, str2);
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, charSequence2, 0);
    }

    public static String join(short[] sArr, char c4) {
        if (sArr == null) {
            return null;
        }
        return join(sArr, c4, 0, sArr.length);
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, charSequence2, charSequence.length());
    }

    public static String leftPad(String str, int i10, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i10 - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return leftPad(str, i10, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i11 = 0; i11 < length2; i11++) {
            cArr[i11] = charArray[i11 % length];
        }
        return new String(cArr).concat(str);
    }

    public static String rightPad(String str, int i10, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i10 - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return rightPad(str, i10, str2.charAt(0));
        }
        if (length2 == length) {
            return str.concat(str2);
        }
        if (length2 < length) {
            return str.concat(str2.substring(0, length2));
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i11 = 0; i11 < length2; i11++) {
            cArr[i11] = charArray[i11 % length];
        }
        return str.concat(new String(cArr));
    }

    public static String appendIfMissing(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return appendIfMissing(str, charSequence, false, charSequenceArr);
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i10) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, charSequence2, i10);
    }

    public static String join(byte[] bArr, char c4) {
        if (bArr == null) {
            return null;
        }
        return join(bArr, c4, 0, bArr.length);
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i10) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, charSequence2, i10);
    }

    public static String prependIfMissing(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return prependIfMissing(str, charSequence, false, charSequenceArr);
    }

    public static boolean containsNone(CharSequence charSequence, String str) {
        if (charSequence == null || str == null) {
            return true;
        }
        return containsNone(charSequence, str.toCharArray());
    }

    public static String join(char[] cArr, char c4) {
        if (cArr == null) {
            return null;
        }
        return join(cArr, c4, 0, cArr.length);
    }

    public static String unwrap(String str, char c4) {
        int length;
        return (isEmpty(str) || c4 == 0 || str.charAt(0) != c4 || str.charAt(str.length() - 1) != c4 || (length = str.length() - 1) == -1) ? str : str.substring(1, length);
    }

    @Deprecated
    public static String chomp(String str, String str2) {
        return removeEnd(str, str2);
    }

    public static boolean containsAny(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2 == null) {
            return false;
        }
        return containsAny(charSequence, CharSequenceUtils.toCharArray(charSequence2));
    }

    public static int indexOfAny(CharSequence charSequence, String str) {
        if (isEmpty(charSequence) || isEmpty(str)) {
            return -1;
        }
        return indexOfAny(charSequence, str.toCharArray());
    }

    public static int indexOfAnyBut(CharSequence charSequence, CharSequence charSequence2) {
        if (!isEmpty(charSequence) && !isEmpty(charSequence2)) {
            int length = charSequence.length();
            int i10 = 0;
            while (i10 < length) {
                char charAt = charSequence.charAt(i10);
                boolean z10 = CharSequenceUtils.indexOf(charSequence2, charAt, 0) >= 0;
                int i11 = i10 + 1;
                if (i11 < length && Character.isHighSurrogate(charAt)) {
                    char charAt2 = charSequence.charAt(i11);
                    if (z10 && CharSequenceUtils.indexOf(charSequence2, charAt2, 0) < 0) {
                        return i10;
                    }
                } else if (!z10) {
                    return i10;
                }
                i10 = i11;
            }
        }
        return -1;
    }

    public static String join(float[] fArr, char c4) {
        if (fArr == null) {
            return null;
        }
        return join(fArr, c4, 0, fArr.length);
    }

    private static String[] splitWorker(String str, String str2, int i10, boolean z10) {
        int i11;
        boolean z11;
        boolean z12;
        int i12;
        int i13;
        boolean z13;
        boolean z14;
        int i14;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        if (str2 == null) {
            i13 = 0;
            z13 = false;
            z14 = false;
            i14 = 0;
            int i15 = 1;
            while (i13 < length) {
                if (Character.isWhitespace(str.charAt(i13))) {
                    if (z13 || z10) {
                        int i16 = i15 + 1;
                        if (i15 == i10) {
                            i13 = length;
                            z14 = false;
                        } else {
                            z14 = true;
                        }
                        arrayList.add(str.substring(i14, i13));
                        i15 = i16;
                        z13 = false;
                    }
                    i14 = i13 + 1;
                    i13 = i14;
                } else {
                    i13++;
                    z13 = true;
                    z14 = false;
                }
            }
        } else {
            if (str2.length() == 1) {
                char charAt = str2.charAt(0);
                i11 = 0;
                z11 = false;
                z12 = false;
                i12 = 0;
                int i17 = 1;
                while (i11 < length) {
                    if (str.charAt(i11) == charAt) {
                        if (z11 || z10) {
                            int i18 = i17 + 1;
                            if (i17 == i10) {
                                i11 = length;
                                z12 = false;
                            } else {
                                z12 = true;
                            }
                            arrayList.add(str.substring(i12, i11));
                            i17 = i18;
                            z11 = false;
                        }
                        i12 = i11 + 1;
                        i11 = i12;
                    } else {
                        i11++;
                        z11 = true;
                        z12 = false;
                    }
                }
            } else {
                i11 = 0;
                z11 = false;
                z12 = false;
                i12 = 0;
                int i19 = 1;
                while (i11 < length) {
                    if (str2.indexOf(str.charAt(i11)) >= 0) {
                        if (z11 || z10) {
                            int i20 = i19 + 1;
                            if (i19 == i10) {
                                i11 = length;
                                z12 = false;
                            } else {
                                z12 = true;
                            }
                            arrayList.add(str.substring(i12, i11));
                            i19 = i20;
                            z11 = false;
                        }
                        i12 = i11 + 1;
                        i11 = i12;
                    } else {
                        i11++;
                        z11 = true;
                        z12 = false;
                    }
                }
            }
            i13 = i11;
            z13 = z11;
            z14 = z12;
            i14 = i12;
        }
        if (z13 || (z10 && z14)) {
            arrayList.add(str.substring(i14, i13));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean containsAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (contains(charSequence, charSequence2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String join(double[] dArr, char c4) {
        if (dArr == null) {
            return null;
        }
        return join(dArr, c4, 0, dArr.length);
    }

    public static String wrapIfMissing(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2)) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str.length() + str2.length() + str2.length());
        if (!str.startsWith(str2)) {
            sb2.append(str2);
        }
        sb2.append(str);
        if (!str.endsWith(str2)) {
            sb2.append(str2);
        }
        return sb2.toString();
    }

    public static int indexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        int indexOf;
        if (charSequence == null || charSequenceArr == null) {
            return -1;
        }
        int i10 = Integer.MAX_VALUE;
        for (CharSequence charSequence2 : charSequenceArr) {
            if (charSequence2 != null && (indexOf = CharSequenceUtils.indexOf(charSequence, charSequence2, 0)) != -1 && indexOf < i10) {
                i10 = indexOf;
            }
        }
        if (i10 == Integer.MAX_VALUE) {
            return -1;
        }
        return i10;
    }

    public static String join(Object[] objArr, char c4, int i10, int i11) {
        if (objArr == null) {
            return null;
        }
        int i12 = i11 - i10;
        if (i12 <= 0) {
            return "";
        }
        StringBuilder newStringBuilder = newStringBuilder(i12);
        for (int i13 = i10; i13 < i11; i13++) {
            if (i13 > i10) {
                newStringBuilder.append(c4);
            }
            if (objArr[i13] != null) {
                newStringBuilder.append(objArr[i13]);
            }
        }
        return newStringBuilder.toString();
    }

    public static String repeat(String str, String str2, int i10) {
        if (str != null && str2 != null) {
            return removeEnd(repeat(str + str2, i10), str2);
        }
        return repeat(str, i10);
    }

    @Deprecated
    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2, int i10) {
        int i11;
        int i12;
        CharSequence charSequence3;
        CharSequence charSequence4;
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        if (i10 >= 0) {
            int length = charSequence.length();
            int length2 = charSequence2.length();
            if (length == 0) {
                if (length2 <= i10) {
                    return length2;
                }
                return -1;
            }
            if (length2 == 0) {
                if (length <= i10) {
                    return length;
                }
                return -1;
            }
            if (Math.abs(length - length2) > i10) {
                return -1;
            }
            if (length > length2) {
                i12 = charSequence.length();
                i11 = length2;
                charSequence4 = charSequence;
                charSequence3 = charSequence2;
            } else {
                i11 = length;
                i12 = length2;
                charSequence3 = charSequence;
                charSequence4 = charSequence2;
            }
            int i13 = i11 + 1;
            int[] iArr = new int[i13];
            int[] iArr2 = new int[i13];
            int min = Math.min(i11, i10) + 1;
            char c4 = 0;
            for (int i14 = 0; i14 < min; i14++) {
                iArr[i14] = i14;
            }
            int i15 = Integer.MAX_VALUE;
            Arrays.fill(iArr, min, i13, Integer.MAX_VALUE);
            Arrays.fill(iArr2, Integer.MAX_VALUE);
            int i16 = 1;
            while (i16 <= i12) {
                char charAt = charSequence4.charAt(i16 - 1);
                iArr2[c4] = i16;
                int max = Math.max(1, i16 - i10);
                int min2 = i16 > i15 - i10 ? i11 : Math.min(i11, i16 + i10);
                if (max > min2) {
                    return -1;
                }
                if (max > 1) {
                    iArr2[max - 1] = i15;
                }
                while (max <= min2) {
                    int i17 = max - 1;
                    if (charSequence3.charAt(i17) == charAt) {
                        iArr2[max] = iArr[i17];
                    } else {
                        iArr2[max] = Math.min(Math.min(iArr2[i17], iArr[max]), iArr[i17]) + 1;
                    }
                    max++;
                }
                i16++;
                c4 = 0;
                i15 = Integer.MAX_VALUE;
                int[] iArr3 = iArr2;
                iArr2 = iArr;
                iArr = iArr3;
            }
            if (iArr[i11] <= i10) {
                return iArr[i11];
            }
            return -1;
        }
        throw new IllegalArgumentException("Threshold must not be negative");
    }

    public static String join(long[] jArr, char c4, int i10, int i11) {
        if (jArr == null) {
            return null;
        }
        int i12 = i11 - i10;
        if (i12 <= 0) {
            return "";
        }
        StringBuilder newStringBuilder = newStringBuilder(i12);
        for (int i13 = i10; i13 < i11; i13++) {
            if (i13 > i10) {
                newStringBuilder.append(c4);
            }
            newStringBuilder.append(jArr[i13]);
        }
        return newStringBuilder.toString();
    }

    public static String repeat(char c4, int i10) {
        if (i10 <= 0) {
            return "";
        }
        char[] cArr = new char[i10];
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            cArr[i11] = c4;
        }
        return new String(cArr);
    }

    public static String join(int[] iArr, char c4, int i10, int i11) {
        if (iArr == null) {
            return null;
        }
        int i12 = i11 - i10;
        if (i12 <= 0) {
            return "";
        }
        StringBuilder newStringBuilder = newStringBuilder(i12);
        for (int i13 = i10; i13 < i11; i13++) {
            if (i13 > i10) {
                newStringBuilder.append(c4);
            }
            newStringBuilder.append(iArr[i13]);
        }
        return newStringBuilder.toString();
    }

    public static String join(byte[] bArr, char c4, int i10, int i11) {
        if (bArr == null) {
            return null;
        }
        int i12 = i11 - i10;
        if (i12 <= 0) {
            return "";
        }
        StringBuilder newStringBuilder = newStringBuilder(i12);
        for (int i13 = i10; i13 < i11; i13++) {
            if (i13 > i10) {
                newStringBuilder.append(c4);
            }
            newStringBuilder.append((int) bArr[i13]);
        }
        return newStringBuilder.toString();
    }

    public static String join(short[] sArr, char c4, int i10, int i11) {
        if (sArr == null) {
            return null;
        }
        int i12 = i11 - i10;
        if (i12 <= 0) {
            return "";
        }
        StringBuilder newStringBuilder = newStringBuilder(i12);
        for (int i13 = i10; i13 < i11; i13++) {
            if (i13 > i10) {
                newStringBuilder.append(c4);
            }
            newStringBuilder.append((int) sArr[i13]);
        }
        return newStringBuilder.toString();
    }

    public static String join(char[] cArr, char c4, int i10, int i11) {
        if (cArr == null) {
            return null;
        }
        int i12 = i11 - i10;
        if (i12 <= 0) {
            return "";
        }
        StringBuilder newStringBuilder = newStringBuilder(i12);
        for (int i13 = i10; i13 < i11; i13++) {
            if (i13 > i10) {
                newStringBuilder.append(c4);
            }
            newStringBuilder.append(cArr[i13]);
        }
        return newStringBuilder.toString();
    }

    public static String join(double[] dArr, char c4, int i10, int i11) {
        if (dArr == null) {
            return null;
        }
        int i12 = i11 - i10;
        if (i12 <= 0) {
            return "";
        }
        StringBuilder newStringBuilder = newStringBuilder(i12);
        for (int i13 = i10; i13 < i11; i13++) {
            if (i13 > i10) {
                newStringBuilder.append(c4);
            }
            newStringBuilder.append(dArr[i13]);
        }
        return newStringBuilder.toString();
    }

    public static String join(float[] fArr, char c4, int i10, int i11) {
        if (fArr == null) {
            return null;
        }
        int i12 = i11 - i10;
        if (i12 <= 0) {
            return "";
        }
        StringBuilder newStringBuilder = newStringBuilder(i12);
        for (int i13 = i10; i13 < i11; i13++) {
            if (i13 > i10) {
                newStringBuilder.append(c4);
            }
            newStringBuilder.append(fArr[i13]);
        }
        return newStringBuilder.toString();
    }

    public static String join(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, str, 0, objArr.length);
    }

    public static String join(Object[] objArr, String str, int i10, int i11) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i12 = i11 - i10;
        if (i12 <= 0) {
            return "";
        }
        StringBuilder newStringBuilder = newStringBuilder(i12);
        for (int i13 = i10; i13 < i11; i13++) {
            if (i13 > i10) {
                newStringBuilder.append(str);
            }
            if (objArr[i13] != null) {
                newStringBuilder.append(objArr[i13]);
            }
        }
        return newStringBuilder.toString();
    }

    public static String join(Iterator<?> it, char c4) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return Objects.toString(next, "");
        }
        StringBuilder sb2 = new StringBuilder(256);
        if (next != null) {
            sb2.append(next);
        }
        while (it.hasNext()) {
            sb2.append(c4);
            Object next2 = it.next();
            if (next2 != null) {
                sb2.append(next2);
            }
        }
        return sb2.toString();
    }

    public static String join(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return Objects.toString(next, "");
        }
        StringBuilder sb2 = new StringBuilder(256);
        if (next != null) {
            sb2.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                sb2.append(str);
            }
            Object next2 = it.next();
            if (next2 != null) {
                sb2.append(next2);
            }
        }
        return sb2.toString();
    }

    public static String join(Iterable<?> iterable, char c4) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator2(), c4);
    }

    public static String join(Iterable<?> iterable, String str) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator2(), str);
    }

    public static String join(List<?> list, char c4, int i10, int i11) {
        if (list == null) {
            return null;
        }
        return i11 - i10 <= 0 ? "" : join(list.subList(i10, i11).iterator2(), c4);
    }

    public static String join(List<?> list, String str, int i10, int i11) {
        if (list == null) {
            return null;
        }
        return i11 - i10 <= 0 ? "" : join(list.subList(i10, i11).iterator2(), str);
    }
}
