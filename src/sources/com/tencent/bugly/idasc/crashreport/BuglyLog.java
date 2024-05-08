package com.tencent.bugly.idasc.crashreport;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.bugly.idasc.proguard.ao;
import com.tencent.bugly.idasc.proguard.p;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class BuglyLog {
    public static void d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z10 = p.f39908c;
        ao.a("D", str, str2);
    }

    public static void e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z10 = p.f39908c;
        ao.a(ExifInterface.LONGITUDE_EAST, str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        boolean z10 = p.f39908c;
        ao.a(ExifInterface.LONGITUDE_EAST, str, th);
    }

    public static void i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z10 = p.f39908c;
        ao.a("I", str, str2);
    }

    public static void setCache(int i10) {
        ao.a(i10);
    }

    public static void v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z10 = p.f39908c;
        ao.a(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, str, str2);
    }

    public static void w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "null";
        }
        boolean z10 = p.f39908c;
        ao.a("W", str, str2);
    }
}
