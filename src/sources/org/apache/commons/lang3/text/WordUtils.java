package org.apache.commons.lang3.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class WordUtils {
    public static String capitalize(String str) {
        return capitalize(str, null);
    }

    public static String capitalizeFully(String str) {
        return capitalizeFully(str, null);
    }

    public static boolean containsAllWords(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (StringUtils.isEmpty(charSequence) || ArrayUtils.isEmpty(charSequenceArr)) {
            return false;
        }
        for (CharSequence charSequence2 : charSequenceArr) {
            if (StringUtils.isBlank(charSequence2)) {
                return false;
            }
            if (!Pattern.compile(".*\\b" + ((Object) charSequence2) + "\\b.*").matcher(charSequence).matches()) {
                return false;
            }
        }
        return true;
    }

    public static String initials(String str) {
        return initials(str, null);
    }

    private static boolean isDelimiter(char c4, char[] cArr) {
        if (cArr == null) {
            return Character.isWhitespace(c4);
        }
        for (char c10 : cArr) {
            if (c4 == c10) {
                return true;
            }
        }
        return false;
    }

    public static String swapCase(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean z10 = true;
        for (int i10 = 0; i10 < charArray.length; i10++) {
            char c4 = charArray[i10];
            if (Character.isUpperCase(c4)) {
                charArray[i10] = Character.toLowerCase(c4);
            } else if (Character.isTitleCase(c4)) {
                charArray[i10] = Character.toLowerCase(c4);
            } else {
                if (!Character.isLowerCase(c4)) {
                    z10 = Character.isWhitespace(c4);
                } else if (z10) {
                    charArray[i10] = Character.toTitleCase(c4);
                } else {
                    charArray[i10] = Character.toUpperCase(c4);
                }
            }
            z10 = false;
        }
        return new String(charArray);
    }

    public static String uncapitalize(String str) {
        return uncapitalize(str, null);
    }

    public static String wrap(String str, int i10) {
        return wrap(str, i10, null, false);
    }

    public static String capitalize(String str, char... cArr) {
        int length = cArr == null ? -1 : cArr.length;
        if (StringUtils.isEmpty(str) || length == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean z10 = true;
        for (int i10 = 0; i10 < charArray.length; i10++) {
            char c4 = charArray[i10];
            if (isDelimiter(c4, cArr)) {
                z10 = true;
            } else if (z10) {
                charArray[i10] = Character.toTitleCase(c4);
                z10 = false;
            }
        }
        return new String(charArray);
    }

    public static String capitalizeFully(String str, char... cArr) {
        return (StringUtils.isEmpty(str) || (cArr == null ? -1 : cArr.length) == 0) ? str : capitalize(str.toLowerCase(), cArr);
    }

    public static String initials(String str, char... cArr) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        if (cArr != null && cArr.length == 0) {
            return "";
        }
        int length = str.length();
        char[] cArr2 = new char[(length / 2) + 1];
        int i10 = 0;
        boolean z10 = true;
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (isDelimiter(charAt, cArr)) {
                z10 = true;
            } else if (z10) {
                cArr2[i10] = charAt;
                i10++;
                z10 = false;
            }
        }
        return new String(cArr2, 0, i10);
    }

    public static String uncapitalize(String str, char... cArr) {
        int length = cArr == null ? -1 : cArr.length;
        if (StringUtils.isEmpty(str) || length == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean z10 = true;
        for (int i10 = 0; i10 < charArray.length; i10++) {
            char c4 = charArray[i10];
            if (isDelimiter(c4, cArr)) {
                z10 = true;
            } else if (z10) {
                charArray[i10] = Character.toLowerCase(c4);
                z10 = false;
            }
        }
        return new String(charArray);
    }

    public static String wrap(String str, int i10, String str2, boolean z10) {
        return wrap(str, i10, str2, z10, " ");
    }

    public static String wrap(String str, int i10, String str2, boolean z10, String str3) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = System.lineSeparator();
        }
        if (i10 < 1) {
            i10 = 1;
        }
        if (StringUtils.isBlank(str3)) {
            str3 = " ";
        }
        Pattern compile = Pattern.compile(str3);
        int length = str.length();
        int i11 = 0;
        StringBuilder sb2 = new StringBuilder(length + 32);
        while (i11 < length) {
            int i12 = -1;
            int i13 = i11 + i10;
            Matcher matcher = compile.matcher(str.substring(i11, Math.min((int) Math.min(ZipUtils.UPPER_UNIXTIME_BOUND, i13 + 1), length)));
            if (matcher.find()) {
                if (matcher.start() == 0) {
                    i11 += matcher.end();
                } else {
                    i12 = matcher.start() + i11;
                }
            }
            if (length - i11 <= i10) {
                break;
            }
            while (matcher.find()) {
                i12 = matcher.start() + i11;
            }
            if (i12 >= i11) {
                sb2.append((CharSequence) str, i11, i12);
                sb2.append(str2);
            } else if (z10) {
                sb2.append((CharSequence) str, i11, i13);
                sb2.append(str2);
                i11 = i13;
            } else {
                Matcher matcher2 = compile.matcher(str.substring(i13));
                if (matcher2.find()) {
                    i12 = matcher2.start() + i11 + i10;
                }
                if (i12 >= 0) {
                    sb2.append((CharSequence) str, i11, i12);
                    sb2.append(str2);
                } else {
                    sb2.append((CharSequence) str, i11, str.length());
                    i11 = length;
                }
            }
            i11 = i12 + 1;
        }
        sb2.append((CharSequence) str, i11, str.length());
        return sb2.toString();
    }
}
