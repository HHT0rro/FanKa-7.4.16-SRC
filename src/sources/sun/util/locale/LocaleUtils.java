package sun.util.locale;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class LocaleUtils {
    private LocaleUtils() {
    }

    public static boolean caseIgnoreMatch(String s12, String s2) {
        if (s12 == s2) {
            return true;
        }
        int len = s12.length();
        if (len != s2.length()) {
            return false;
        }
        for (int i10 = 0; i10 < len; i10++) {
            char c12 = s12.charAt(i10);
            char c22 = s2.charAt(i10);
            if (c12 != c22 && toLower(c12) != toLower(c22)) {
                return false;
            }
        }
        return true;
    }

    static int caseIgnoreCompare(String s12, String s2) {
        if (s12 == s2) {
            return 0;
        }
        return toLowerString(s12).compareTo(toLowerString(s2));
    }

    static char toUpper(char c4) {
        return isLower(c4) ? (char) (c4 - ' ') : c4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static char toLower(char c4) {
        return isUpper(c4) ? (char) (c4 + ' ') : c4;
    }

    public static String toLowerString(String s2) {
        int len = s2.length();
        int idx = 0;
        while (idx < len && !isUpper(s2.charAt(idx))) {
            idx++;
        }
        if (idx == len) {
            return s2;
        }
        char[] buf = new char[len];
        int i10 = 0;
        while (i10 < len) {
            char c4 = s2.charAt(i10);
            buf[i10] = i10 < idx ? c4 : toLower(c4);
            i10++;
        }
        return new String(buf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toUpperString(String s2) {
        int len = s2.length();
        int idx = 0;
        while (idx < len && !isLower(s2.charAt(idx))) {
            idx++;
        }
        if (idx == len) {
            return s2;
        }
        char[] buf = new char[len];
        int i10 = 0;
        while (i10 < len) {
            char c4 = s2.charAt(i10);
            buf[i10] = i10 < idx ? c4 : toUpper(c4);
            i10++;
        }
        return new String(buf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toTitleString(String s2) {
        int len = s2.length();
        if (len == 0) {
            return s2;
        }
        int idx = 0;
        if (!isLower(s2.charAt(0))) {
            idx = 1;
            while (idx < len && !isUpper(s2.charAt(idx))) {
                idx++;
            }
        }
        if (idx == len) {
            return s2;
        }
        char[] buf = new char[len];
        for (int i10 = 0; i10 < len; i10++) {
            char c4 = s2.charAt(i10);
            if (i10 == 0 && idx == 0) {
                buf[i10] = toUpper(c4);
            } else if (i10 < idx) {
                buf[i10] = c4;
            } else {
                buf[i10] = toLower(c4);
            }
        }
        return new String(buf);
    }

    private static boolean isUpper(char c4) {
        return c4 >= 'A' && c4 <= 'Z';
    }

    private static boolean isLower(char c4) {
        return c4 >= 'a' && c4 <= 'z';
    }

    static boolean isAlpha(char c4) {
        return (c4 >= 'A' && c4 <= 'Z') || (c4 >= 'a' && c4 <= 'z');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAlphaString(String s2) {
        int len = s2.length();
        for (int i10 = 0; i10 < len; i10++) {
            if (!isAlpha(s2.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isNumeric(char c4) {
        return c4 >= '0' && c4 <= '9';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isNumericString(String s2) {
        int len = s2.length();
        for (int i10 = 0; i10 < len; i10++) {
            if (!isNumeric(s2.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAlphaNumeric(char c4) {
        return isAlpha(c4) || isNumeric(c4);
    }

    public static boolean isAlphaNumericString(String s2) {
        int len = s2.length();
        for (int i10 = 0; i10 < len; i10++) {
            if (!isAlphaNumeric(s2.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isEmpty(Set<?> set) {
        return set == null || set.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }
}
