package com.alibaba.wireless.security.framework.utils;

import android.os.Process;

/* renamed from: com.alibaba.wireless.security.framework.utils.а, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class C0049 {

    /* renamed from: а, reason: contains not printable characters */
    private static String f52 = "SGTIME";

    /* renamed from: б, reason: contains not printable characters */
    private static boolean f53;

    /* renamed from: а, reason: contains not printable characters */
    public static String m1819() {
        if (f53) {
            return Thread.currentThread().getStackTrace()[3].getMethodName();
        }
        return null;
    }

    /* renamed from: а, reason: contains not printable characters */
    public static void m1820(String str) {
    }

    /* renamed from: а, reason: contains not printable characters */
    public static void m1821(String str, String str2, String str3, long j10) {
        if (f53) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            sb2.append(Process.myPid());
            sb2.append("][");
            sb2.append(Process.myTid());
            sb2.append("][");
            sb2.append(str);
            sb2.append("][JAVA][");
            sb2.append(str2);
            sb2.append("] cost = ");
            sb2.append(System.currentTimeMillis() - j10);
            sb2.append(" ms [");
            sb2.append(str3);
            sb2.append("]");
        }
    }

    /* renamed from: а, reason: contains not printable characters */
    public static void m1822(String str, Throwable th) {
    }

    /* renamed from: б, reason: contains not printable characters */
    public static long m1823() {
        if (f53) {
            return System.currentTimeMillis();
        }
        return 0L;
    }

    /* renamed from: б, reason: contains not printable characters */
    public static void m1824(String str) {
    }

    /* renamed from: в, reason: contains not printable characters */
    public static void m1825(String str) {
    }
}
