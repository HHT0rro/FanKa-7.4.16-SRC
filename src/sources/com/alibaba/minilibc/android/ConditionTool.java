package com.alibaba.minilibc.android;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class ConditionTool {
    public static String convertEmptyStringToNull(String str) {
        if (str == null || str.length() != 0) {
            return str;
        }
        return null;
    }

    public static boolean stringEquals(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        return (str == null || str2 == null || !str.equals(str2)) ? false : true;
    }

    public static boolean stringNotNullOrEmpty(String... strArr) {
        return !stringNullOrEmpty(strArr);
    }

    public static boolean stringNullOrEmpty(String... strArr) {
        for (String str : strArr) {
            if (str == null || "".equals(str)) {
                return true;
            }
        }
        return false;
    }
}
