package com.huawei.hianalytics;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.LruCache;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.log.LogTag;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class h0 {
    static {
        LogTag.get(h0.class, new Class[0]);
        new LruCache(15);
    }

    public static String lmn(Context context) {
        if (context == null) {
            HiLog.e("HiAnalyticsUtils", "getProcessName context is null.");
            return "";
        }
        if (TextUtils.isEmpty(d.klm())) {
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses == null) {
                    return context.getPackageName();
                }
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == Process.myPid()) {
                        c.klm().lmn.f28751h = runningAppProcessInfo.processName;
                        return runningAppProcessInfo.processName;
                    }
                }
                return context.getPackageName();
            } catch (Exception e2) {
                StringBuilder b4 = e9.a.b("HiAnalyticsUtils getProcessName  getActivityManager e : ");
                b4.append(e2.getMessage());
                HiLog.e("HiAnalyticsUtils", b4.toString());
                return "";
            }
        }
        return d.klm();
    }
}
