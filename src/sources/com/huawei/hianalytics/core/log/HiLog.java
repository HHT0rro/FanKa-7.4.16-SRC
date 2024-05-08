package com.huawei.hianalytics.core.log;

import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HiLog {

    /* renamed from: a, reason: collision with root package name */
    public static LogAdapter f28739a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f28740b = false;

    /* renamed from: c, reason: collision with root package name */
    public static int f28741c = 3;

    /* renamed from: d, reason: collision with root package name */
    public static String f28742d = "";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface ErrorCode {
        public static final String CE001 = "CE-001";
        public static final String IE001 = "IE-001";
        public static final String IE002 = "IE-002";
        public static final String IE003 = "IE-003";
        public static final String IE004 = "IE-004";
        public static final String IE005 = "IE-005";
        public static final String IE006 = "IE-006";
        public static final String NE001 = "NE-001";
        public static final String NE002 = "NE-002";
        public static final String NE003 = "NE-003";
        public static final String NE004 = "NE-004";
        public static final String NE005 = "NE-005";
        public static final String NE006 = "NE-006";
        public static final String PE001 = "PE-001";
        public static final String PE002 = "PE-002";
        public static final String PE003 = "PE-003";
        public static final String PE004 = "PE-004";
        public static final String PE005 = "PE-005";
        public static final String PE006 = "PE-006";
        public static final String SE001 = "SE-001";
        public static final String SE002 = "SE-002";
        public static final String SE003 = "SE-003";
    }

    public static boolean a() {
        LogAdapter logAdapter = f28739a;
        if (logAdapter != null) {
            return logAdapter.isLoggable(3);
        }
        return false;
    }

    public static boolean b() {
        LogAdapter logAdapter = f28739a;
        if (logAdapter != null) {
            return logAdapter.isLoggable(4);
        }
        return false;
    }

    public static boolean c() {
        LogAdapter logAdapter = f28739a;
        if (logAdapter != null) {
            return logAdapter.isLoggable(5);
        }
        return false;
    }

    public static void d(String str, String str2) {
        if (!a() || str == null || str2 == null) {
            return;
        }
        f28739a.println(3, str, str2);
    }

    public static void e(String str, String str2) {
        if (a(str, str2)) {
            f28739a.println(6, str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (!b() || str == null || str2 == null) {
            return;
        }
        f28739a.println(4, str, str2);
    }

    public static void init(int i10, String str) {
        f28740b = true;
        f28741c = i10;
        f28742d = str;
        LogAdapter logAdapter = f28739a;
        if (logAdapter != null) {
            logAdapter.init(i10, str);
        }
    }

    public static void setLogAdapter(LogAdapter logAdapter) {
        if (f28739a == null) {
            f28739a = logAdapter;
        }
        if (f28740b) {
            init(f28741c, f28742d);
        }
    }

    public static void si(String str, String str2) {
        if (a(str, str2)) {
            f28739a.println(4, str, str2);
        }
    }

    public static void sw(String str, String str2) {
        if (a(str, str2)) {
            f28739a.println(5, str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (!c() || str == null || str2 == null) {
            return;
        }
        f28739a.println(5, str, str2);
    }

    public static boolean a(String str, String str2) {
        return (f28739a == null || str == null || str2 == null) ? false : true;
    }

    public static void d(String str, String str2, String str3) {
        if (a()) {
            f28739a.println(3, str, str2, str3);
        }
    }

    public static void e(String str, String str2, String str3) {
        if (a(str, str3)) {
            f28739a.println(6, str, str2, str3);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (!b() || str == null || str2 == null) {
            return;
        }
        f28739a.println(4, str, String.format(Locale.ROOT, str2, objArr));
    }

    public static void si(String str, String str2, Object... objArr) {
        if (a(str, str2)) {
            si(str, String.format(str2, objArr));
        }
    }

    public static void sw(String str, String str2, Object... objArr) {
        if (a(str, str2)) {
            sw(str, String.format(str2, objArr));
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (!c() || str2 == null) {
            return;
        }
        w(str, String.format(str2, objArr));
    }

    public static void e(String str, String str2, Object... objArr) {
        if (a(str, str2)) {
            e(str, String.format(str2, objArr));
        }
    }

    public static void i(String str, String str2, String str3) {
        if (b()) {
            f28739a.println(4, str, str2, str3);
        }
    }

    public static void w(String str, String str2, String str3) {
        if (c()) {
            f28739a.println(5, str, str2, str3);
        }
    }
}
