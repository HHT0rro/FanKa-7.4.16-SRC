package com.tencent.liteav.base.util;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f42916a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f42917b = false;

    /* renamed from: c, reason: collision with root package name */
    private static String f42918c = "";

    public static boolean a() {
        boolean z10;
        synchronized (f42916a) {
            if (!f42917b) {
                "load library txsoundtouch ".concat(String.valueOf(b("txsoundtouch")));
                "load library txffmpeg ".concat(String.valueOf(b("txffmpeg")));
                f42917b = b("liteavsdk");
                new StringBuilder("load library liteavsdk ").append(f42917b);
            }
            z10 = f42917b;
        }
        return z10;
    }

    private static boolean b(String str) {
        try {
            if (!TextUtils.isEmpty(f42918c) ? a(f42918c, str) : false) {
                return true;
            }
            StringBuilder sb2 = new StringBuilder("load library ");
            sb2.append(str);
            sb2.append(" from system path ");
            System.loadLibrary(str);
            return true;
        } catch (Error e2) {
            new StringBuilder("load library : ").append(e2.toString());
            return false;
        } catch (Exception e10) {
            new StringBuilder("load library : ").append(e10.toString());
            return false;
        }
    }

    private static boolean a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            StringBuilder sb2 = new StringBuilder("load library ");
            sb2.append(str2);
            sb2.append(" from path ");
            sb2.append(str);
            System.load(str + "/lib" + str2 + ".so");
            return true;
        } catch (Error e2) {
            new StringBuilder("load library : ").append(e2.toString());
            return false;
        } catch (Exception e10) {
            new StringBuilder("load library : ").append(e10.toString());
            return false;
        }
    }

    public static void a(String str) {
        "setLibraryPath ".concat(String.valueOf(str));
        f42918c = str;
    }
}
