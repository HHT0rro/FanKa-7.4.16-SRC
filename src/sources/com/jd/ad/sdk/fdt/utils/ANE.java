package com.jd.ad.sdk.fdt.utils;

import android.text.TextUtils;
import android.util.Log;
import com.alipay.sdk.util.i;
import com.jd.ad.sdk.jad_do.jad_jw;
import com.jd.ad.sdk.logger.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class ANE {
    public static final /* synthetic */ int jad_an = 0;

    static {
        try {
            System.loadLibrary("ane");
        } catch (Throwable th) {
            Logger.d(Log.getStackTraceString(th));
        }
    }

    private static native String a(String str);

    private static native String b(String str);

    private static native String c(String str);

    private static native String d(String str);

    public static synchronized String jad_an(String str) {
        synchronized (ANE.class) {
            if (!jad_jw.jad_an(str)) {
                return "";
            }
            String str2 = "";
            try {
                str2 = b(str);
            } catch (Throwable th) {
                Logger.d(Log.getStackTraceString(th));
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            return str2;
        }
    }

    public static synchronized String jad_bo(String str) {
        synchronized (ANE.class) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String trim = str.trim();
            if (trim.startsWith("{") && trim.endsWith(i.f4738d)) {
                return trim;
            }
            String str2 = "";
            try {
            } catch (Throwable th) {
                Logger.d(Log.getStackTraceString(th));
            }
            synchronized (ANE.class) {
                if (jad_jw.jad_an(trim)) {
                    String str3 = "";
                    try {
                        str3 = d(trim);
                    } catch (Throwable th2) {
                        Logger.d(Log.getStackTraceString(th2));
                    }
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "";
                    }
                    str2 = str3;
                } else {
                    str2 = "";
                }
                return (str2.startsWith("{") && str2.endsWith(i.f4738d)) ? str2 : "";
            }
        }
    }

    public static synchronized String jad_cp(String str) {
        synchronized (ANE.class) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String str2 = "";
            try {
                str2 = a(str);
            } catch (Throwable th) {
                Logger.d(Log.getStackTraceString(th));
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            return str2;
        }
    }

    public static synchronized String jad_dq(String str) {
        synchronized (ANE.class) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String str2 = "";
            try {
                str2 = c(str);
            } catch (Throwable th) {
                Logger.d(Log.getStackTraceString(th));
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            return str2;
        }
    }
}
