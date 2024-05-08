package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class aq {
    private static String aPC = "";
    private static volatile Boolean aPD;

    private static String Mb() {
        return Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
    }

    private static String Mc() {
        try {
            Object callStaticMethod = s.callStaticMethod(Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()), "currentProcessName", new Object[0]);
            return callStaticMethod instanceof String ? (String) callStaticMethod : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static String ct(@NonNull Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return "";
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "";
    }

    public static String getProcessName(@NonNull Context context) {
        if (!TextUtils.isEmpty(aPC)) {
            return aPC;
        }
        String Mb = Mb();
        aPC = Mb;
        if (!TextUtils.isEmpty(Mb)) {
            return aPC;
        }
        String Mc = Mc();
        aPC = Mc;
        if (!TextUtils.isEmpty(Mc)) {
            return aPC;
        }
        String ct = ct(context);
        aPC = ct;
        return ct;
    }

    public static boolean isInMainProcess(Context context) {
        if (aPD == null) {
            String processName = getProcessName(context);
            aPD = Boolean.valueOf(!TextUtils.isEmpty(processName) && processName.equals(context.getPackageName()));
        }
        return aPD.booleanValue();
    }
}
