package org.apache.commons.lang3;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CharSetUtils {
    public static boolean containsAny(String str, String... strArr) {
        if (!StringUtils.isEmpty(str) && !deepEmpty(strArr)) {
            CharSet charSet = CharSet.getInstance(strArr);
            for (char c4 : str.toCharArray()) {
                if (charSet.contains(c4)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int count(String str, String... strArr) {
        if (StringUtils.isEmpty(str) || deepEmpty(strArr)) {
            return 0;
        }
        CharSet charSet = CharSet.getInstance(strArr);
        int i10 = 0;
        for (char c4 : str.toCharArray()) {
            if (charSet.contains(c4)) {
                i10++;
            }
        }
        return i10;
    }

    private static boolean deepEmpty(String[] strArr) {
        if (strArr == null) {
            return true;
        }
        for (String str : strArr) {
            if (StringUtils.isNotEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    public static String delete(String str, String... strArr) {
        return (StringUtils.isEmpty(str) || deepEmpty(strArr)) ? str : modify(str, strArr, false);
    }

    public static String keep(String str, String... strArr) {
        if (str == null) {
            return null;
        }
        return (str.isEmpty() || deepEmpty(strArr)) ? "" : modify(str, strArr, true);
    }

    private static String modify(String str, String[] strArr, boolean z10) {
        CharSet charSet = CharSet.getInstance(strArr);
        StringBuilder sb2 = new StringBuilder(str.length());
        for (char c4 : str.toCharArray()) {
            if (charSet.contains(c4) == z10) {
                sb2.append(c4);
            }
        }
        return sb2.toString();
    }

    public static String squeeze(String str, String... strArr) {
        if (StringUtils.isEmpty(str) || deepEmpty(strArr)) {
            return str;
        }
        CharSet charSet = CharSet.getInstance(strArr);
        StringBuilder sb2 = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        char c4 = charArray[0];
        sb2.append(c4);
        Character ch = null;
        Character ch2 = null;
        for (int i10 = 1; i10 < length; i10++) {
            char c10 = charArray[i10];
            if (c10 == c4) {
                if (ch == null || c10 != ch.charValue()) {
                    if (ch2 == null || c10 != ch2.charValue()) {
                        if (charSet.contains(c10)) {
                            ch = Character.valueOf(c10);
                        } else {
                            ch2 = Character.valueOf(c10);
                        }
                    }
                }
            }
            sb2.append(c10);
            c4 = c10;
        }
        return sb2.toString();
    }
}
