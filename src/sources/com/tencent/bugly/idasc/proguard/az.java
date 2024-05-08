package com.tencent.bugly.idasc.proguard;

import android.app.ActivityManager;
import android.os.Process;
import android.text.TextUtils;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class az {
    public static ActivityManager.ProcessErrorStateInfo a(ActivityManager activityManager, long j10) {
        if (activityManager == null) {
            al.c("get anr state, ActivityManager is null", new Object[0]);
            return null;
        }
        al.c("get anr state, timeout:%d", Long.valueOf(j10));
        long j11 = j10 / 500;
        int i10 = 0;
        while (true) {
            ActivityManager.ProcessErrorStateInfo a10 = a(activityManager.getProcessesInErrorState());
            if (a10 == null) {
                al.c("found proc state is null", new Object[0]);
            } else {
                int i11 = a10.condition;
                if (i11 == 2) {
                    al.c("found proc state is anr! proc:%s", a10.processName);
                    return a10;
                }
                if (i11 == 1) {
                    al.c("found proc state is crashed!", new Object[0]);
                    return null;
                }
            }
            int i12 = i10 + 1;
            if (i10 >= j11) {
                return a("Find process anr, but unable to get anr message.");
            }
            al.c("try the %s times:", Integer.valueOf(i12));
            ap.b(500L);
            i10 = i12;
        }
    }

    private static ActivityManager.ProcessErrorStateInfo a(String str) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo = new ActivityManager.ProcessErrorStateInfo();
        processErrorStateInfo.pid = Process.myPid();
        processErrorStateInfo.processName = z.a(Process.myPid());
        processErrorStateInfo.shortMsg = str;
        return processErrorStateInfo;
    }

    private static ActivityManager.ProcessErrorStateInfo a(List<ActivityManager.ProcessErrorStateInfo> list) {
        if (list == null || list.isEmpty()) {
            al.c("error state info list is null", new Object[0]);
            return null;
        }
        int myPid = Process.myPid();
        for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : list) {
            if (processErrorStateInfo.pid == myPid) {
                if (TextUtils.isEmpty(processErrorStateInfo.longMsg)) {
                    return null;
                }
                al.c("found current proc in the error state", new Object[0]);
                return processErrorStateInfo;
            }
        }
        al.c("current proc not in the error state", new Object[0]);
        return null;
    }
}
