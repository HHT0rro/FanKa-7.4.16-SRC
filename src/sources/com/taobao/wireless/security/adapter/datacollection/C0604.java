package com.taobao.wireless.security.adapter.datacollection;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: com.taobao.wireless.security.adapter.datacollection.г, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0604 {

    /* renamed from: а, reason: contains not printable characters */
    private static String f233;

    /* renamed from: б, reason: contains not printable characters */
    private static PackageManager f234;

    /* renamed from: а, reason: contains not printable characters */
    public static String m2905() {
        PackageInfo packageInfo;
        String str;
        try {
            if (f234 == null || f233 == null || (packageInfo = f234.getPackageInfo(f233, 0)) == null || (str = packageInfo.versionName) == null) {
                return null;
            }
            if (str.length() != 0) {
                return str;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    public static void m2906(Context context) {
        if (context == null || f234 != null) {
            return;
        }
        try {
            f233 = context.getPackageName();
        } catch (Throwable unused) {
        }
        try {
            f234 = context.getPackageManager();
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    public static boolean m2907(String str) {
        try {
            PackageManager packageManager = f234;
            if (packageManager != null) {
                return packageManager.hasSystemFeature(str);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: б, reason: contains not printable characters */
    public static String m2908() {
        return f233;
    }
}
