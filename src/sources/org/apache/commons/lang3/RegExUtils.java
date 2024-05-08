package org.apache.commons.lang3;

import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class RegExUtils {
    public static String removeAll(String str, Pattern pattern) {
        return replaceAll(str, pattern, "");
    }

    public static String removeFirst(String str, Pattern pattern) {
        return replaceFirst(str, pattern, "");
    }

    public static String removePattern(String str, String str2) {
        return replacePattern(str, str2, "");
    }

    public static String replaceAll(String str, Pattern pattern, String str2) {
        return (str == null || pattern == null || str2 == null) ? str : pattern.matcher(str).replaceAll(str2);
    }

    public static String replaceFirst(String str, Pattern pattern, String str2) {
        return (str == null || pattern == null || str2 == null) ? str : pattern.matcher(str).replaceFirst(str2);
    }

    public static String replacePattern(String str, String str2, String str3) {
        return (str == null || str2 == null || str3 == null) ? str : Pattern.compile(str2, 32).matcher(str).replaceAll(str3);
    }

    public static String removeAll(String str, String str2) {
        return replaceAll(str, str2, "");
    }

    public static String removeFirst(String str, String str2) {
        return replaceFirst(str, str2, "");
    }

    public static String replaceAll(String str, String str2, String str3) {
        return (str == null || str2 == null || str3 == null) ? str : str.replaceAll(str2, str3);
    }

    public static String replaceFirst(String str, String str2, String str3) {
        return (str == null || str2 == null || str3 == null) ? str : str.replaceFirst(str2, str3);
    }
}
