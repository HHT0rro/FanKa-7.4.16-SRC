package com.android.internal.app;

import android.util.EventLog;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class EventLogTags {
    public static final int HARMFUL_APP_WARNING_LAUNCH_ANYWAY = 53001;
    public static final int HARMFUL_APP_WARNING_UNINSTALL = 53000;

    private EventLogTags() {
    }

    public static void writeHarmfulAppWarningUninstall(String packageName) {
        EventLog.writeEvent(HARMFUL_APP_WARNING_UNINSTALL, packageName);
    }

    public static void writeHarmfulAppWarningLaunchAnyway(String packageName) {
        EventLog.writeEvent(HARMFUL_APP_WARNING_LAUNCH_ANYWAY, packageName);
    }
}
