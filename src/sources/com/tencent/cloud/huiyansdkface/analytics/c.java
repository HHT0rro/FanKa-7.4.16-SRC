package com.tencent.cloud.huiyansdkface.analytics;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f40464a = "c";

    /* renamed from: b, reason: collision with root package name */
    private static String f40465b = "";

    /* renamed from: c, reason: collision with root package name */
    private static DisplayMetrics f40466c;

    public static String a() {
        try {
            return TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a(Context context) {
        return context.getPackageName();
    }

    public static boolean a(Object... objArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 3; i11++) {
            Object obj = objArr[i11];
            if (obj != null) {
                i10 += obj.toString().length();
            }
        }
        return i10 > 61440;
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(f40465b)) {
            return f40465b;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f40465b = str;
            if (str == null) {
                return "";
            }
        } catch (Throwable th) {
            th.printStackTrace();
            WBSLogger.e(f40464a, th.getMessage(), new Object[0]);
        }
        return f40465b;
    }

    public static DisplayMetrics c(Context context) {
        if (f40466c == null) {
            f40466c = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(f40466c);
        }
        return f40466c;
    }

    public static String d(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        return locale.getLanguage() + "_" + locale.getCountry();
    }
}
