package com.android.internal.app;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ActivityTrigger {
    private static final String TAG = "ActivityTrigger";

    private native void native_at_deinit();

    private native float native_at_miscActivity(int i10, String str, int i11, int i12);

    private native void native_at_pauseActivity(String str);

    private native void native_at_resumeActivity(String str);

    private native int native_at_startActivity(String str, int i10);

    private native int native_at_startApp(String str, int i10);

    private native void native_at_stopActivity(String str);

    protected void finalize() {
        native_at_deinit();
    }

    public void activityStartTrigger(ApplicationInfo appInfo, int pid) {
        String activity = appInfo.packageName + "/" + appInfo.processName + "/" + appInfo.longVersionCode + "/" + pid;
        native_at_startApp(activity, 0);
    }

    public void activityResumeTrigger(Intent intent, ActivityInfo acInfo, ApplicationInfo appInfo, boolean IsInFullScreen) {
        ComponentName cn2 = intent.getComponent();
        String activity = null;
        if (cn2 != null) {
            activity = cn2.flattenToString() + "/" + appInfo.versionCode;
        }
        native_at_resumeActivity(activity);
    }

    public void activityPauseTrigger(Intent intent, ActivityInfo acInfo, ApplicationInfo appInfo) {
        ComponentName cn2 = intent.getComponent();
        String activity = null;
        Log.d(TAG, "ActivityTrigger activityPauseTrigger ");
        if (cn2 != null && appInfo != null) {
            activity = cn2.flattenToString() + "/" + appInfo.versionCode;
        }
        native_at_pauseActivity(activity);
    }

    public void activityStopTrigger(Intent intent, ActivityInfo acInfo, ApplicationInfo appInfo) {
        ComponentName cn2 = intent.getComponent();
        String activity = null;
        Log.d(TAG, "ActivityTrigger activityStopTrigger ");
        if (cn2 != null && appInfo != null) {
            activity = cn2.flattenToString() + "/" + appInfo.versionCode;
        }
        native_at_stopActivity(activity);
    }

    public float activityMiscTrigger(int func, String activity, int flag, int type) {
        return native_at_miscActivity(func, activity, flag, type);
    }
}
