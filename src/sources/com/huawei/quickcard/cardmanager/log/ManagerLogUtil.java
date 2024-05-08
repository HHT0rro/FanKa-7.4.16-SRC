package com.huawei.quickcard.cardmanager.log;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ManagerLogUtil {

    /* renamed from: a, reason: collision with root package name */
    private static ManagerLog f33560a;

    public static void d(String str, String str2, Throwable th) {
        ManagerLog managerLog = f33560a;
        if (managerLog == null) {
            return;
        }
        managerLog.d(str, str2, th);
    }

    public static void e(String str, String str2, Throwable th) {
        ManagerLog managerLog = f33560a;
        if (managerLog == null) {
            return;
        }
        managerLog.e(str, str2, th);
    }

    public static void i(String str, String str2, Throwable th) {
        ManagerLog managerLog = f33560a;
        if (managerLog == null) {
            return;
        }
        managerLog.i(str, str2, th);
    }

    public static void setManagerLog(ManagerLog managerLog) {
        f33560a = managerLog;
    }

    public static void w(String str, String str2, Throwable th) {
        ManagerLog managerLog = f33560a;
        if (managerLog == null) {
            return;
        }
        managerLog.w(str, str2, th);
    }

    public static void d(String str, String str2) {
        ManagerLog managerLog = f33560a;
        if (managerLog == null) {
            return;
        }
        managerLog.d(str, str2);
    }

    public static void e(String str, Throwable th) {
        ManagerLog managerLog = f33560a;
        if (managerLog == null) {
            return;
        }
        managerLog.e(str, th);
    }

    public static void i(String str, String str2) {
        ManagerLog managerLog = f33560a;
        if (managerLog == null) {
            return;
        }
        managerLog.i(str, str2);
    }

    public static void w(String str, Throwable th) {
        ManagerLog managerLog = f33560a;
        if (managerLog == null) {
            return;
        }
        managerLog.w(str, th);
    }

    public static void d(String str) {
        ManagerLog managerLog = f33560a;
        if (managerLog == null) {
            return;
        }
        managerLog.d(str);
    }

    public static void e(String str, String str2) {
        ManagerLog managerLog = f33560a;
        if (managerLog == null) {
            return;
        }
        managerLog.e(str, str2);
    }

    public static void i(String str) {
        ManagerLog managerLog = f33560a;
        if (managerLog == null) {
            return;
        }
        managerLog.i(str);
    }

    public static void w(String str, String str2) {
        ManagerLog managerLog = f33560a;
        if (managerLog == null) {
            return;
        }
        managerLog.w(str, str2);
    }

    public static void e(String str) {
        ManagerLog managerLog = f33560a;
        if (managerLog == null) {
            return;
        }
        managerLog.e(str);
    }

    public static void w(String str) {
        ManagerLog managerLog = f33560a;
        if (managerLog == null) {
            return;
        }
        managerLog.w(str);
    }
}
