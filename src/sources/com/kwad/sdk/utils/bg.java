package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bg {
    private static final SimpleDateFormat aQb;
    private static final SimpleDateFormat aQc;
    private static final SimpleDateFormat aQd;
    private static final SimpleDateFormat aQe;
    private static final SimpleDateFormat aQf;
    private static final SimpleDateFormat aQg;
    private static final SimpleDateFormat aQh;

    static {
        Locale locale = Locale.US;
        aQb = new SimpleDateFormat("MM/dd", locale);
        aQc = new SimpleDateFormat("yyyy/MM/dd", locale);
        aQd = new SimpleDateFormat("MM月dd日", locale);
        aQe = new SimpleDateFormat("yyyy年MM月dd日", locale);
        aQf = new SimpleDateFormat("HH:mm", locale);
        aQg = new SimpleDateFormat("MM-dd", locale);
        aQh = new SimpleDateFormat("yyyy-MM-dd", locale);
    }

    public static boolean gP(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static boolean gQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(".*\\.kpg.*");
    }

    public static boolean isEquals(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2);
    }

    public static boolean isNullString(String str) {
        return TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str);
    }
}
