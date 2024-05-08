package com.inno.innosdk.utils;

import android.text.TextUtils;

/* compiled from: ServiceAddress.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f35635a = false;

    /* renamed from: b, reason: collision with root package name */
    public static String f35636b = "https://usr-api.1sapp.com";

    /* renamed from: c, reason: collision with root package name */
    public static String f35637c = f35636b + "/report/v1";

    /* renamed from: d, reason: collision with root package name */
    public static String f35638d = "https://qfc.innotechx.com";

    /* renamed from: e, reason: collision with root package name */
    public static String f35639e = "https://fy.1sapp.com";

    /* renamed from: f, reason: collision with root package name */
    public static String f35640f = "http://fy.1sapp.com";

    public static String a() {
        if (com.inno.innosdk.a.c.p() != null && !TextUtils.isEmpty(com.inno.innosdk.a.c.p().getRurl())) {
            return com.inno.innosdk.a.c.p().getRurl() + "/report/v1";
        }
        if (f35635a) {
            f35637c = "http://qfc.innotechx.com/report/v1";
        } else {
            f35637c = f35638d + "/report/v1";
        }
        return f35637c;
    }

    public static String b() {
        if (com.inno.innosdk.a.c.p() != null && !TextUtils.isEmpty(com.inno.innosdk.a.c.p().getTurl())) {
            return com.inno.innosdk.a.c.p().getTurl() + "/report/v1";
        }
        String str = f35639e + "/report/v1";
        f35637c = str;
        return str;
    }

    public static String c() {
        if (com.inno.innosdk.a.c.p() != null && !TextUtils.isEmpty(com.inno.innosdk.a.c.p().getTurl())) {
            return com.inno.innosdk.a.c.p().getTurl() + "/report/v1";
        }
        if (f35635a) {
            f35637c = "http://usr-api.1sapp.com/107635";
        } else {
            f35637c = f35636b + "/107635";
        }
        return f35637c;
    }

    public static boolean d() {
        if (!f35636b.startsWith("https://")) {
            return false;
        }
        f35636b = "http://usr-api.1sapp.com";
        f35638d = "http://qfc.innotechx.com";
        f35639e = "http://fy.1sapp.com";
        f35640f = "http://qfc.innotechx.com";
        return true;
    }
}
