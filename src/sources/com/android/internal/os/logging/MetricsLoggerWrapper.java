package com.android.internal.os.logging;

import com.android.internal.util.FrameworkStatsLog;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class MetricsLoggerWrapper {
    public static void logAppOverlayEnter(int uid, String packageName, boolean changed, int type, boolean usingAlertWindow) {
        if (changed) {
            if (type != 2038) {
                FrameworkStatsLog.write(59, uid, packageName, true, 1);
            } else if (!usingAlertWindow) {
                FrameworkStatsLog.write(59, uid, packageName, false, 1);
            }
        }
    }

    public static void logAppOverlayExit(int uid, String packageName, boolean changed, int type, boolean usingAlertWindow) {
        if (changed) {
            if (type != 2038) {
                FrameworkStatsLog.write(59, uid, packageName, true, 2);
            } else if (!usingAlertWindow) {
                FrameworkStatsLog.write(59, uid, packageName, false, 2);
            }
        }
    }
}
