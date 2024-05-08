package com.alibaba.wireless.security.open.edgecomputing;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.alibaba.wireless.security.framework.IRouterComponent;
import com.huawei.hms.push.AttributionReporter;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class ECMiscInfo {

    /* renamed from: а, reason: contains not printable characters */
    private static volatile boolean f171 = false;

    /* renamed from: б, reason: contains not printable characters */
    private static volatile boolean f172 = false;

    /* renamed from: в, reason: contains not printable characters */
    private static Context f173 = null;

    /* renamed from: г, reason: contains not printable characters */
    static Handler f174 = null;

    /* renamed from: д, reason: contains not printable characters */
    private static volatile int f175 = 0;

    /* renamed from: е, reason: contains not printable characters */
    private static volatile int f176 = 99;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
    /* renamed from: com.alibaba.wireless.security.open.edgecomputing.ECMiscInfo$а, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
    public static class RunnableC0078 implements Runnable {

        /* renamed from: а, reason: contains not printable characters */
        final /* synthetic */ int f177;

        RunnableC0078(int i10) {
            this.f177 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            IRouterComponent m1941;
            try {
                if (this.f177 == 0) {
                    int unused = ECMiscInfo.f175 = 0;
                } else if (this.f177 == 1 && ECMiscInfo.isBackgroundNew(ECMiscInfo.f173) == 1) {
                    int unused2 = ECMiscInfo.f175 = 1;
                }
                if (ECMiscInfo.f176 == ECMiscInfo.f175 || (m1941 = C0081.m1941()) == null || ((Integer) m1941.doCommand(12605, Integer.valueOf(this.f177))).intValue() != 1) {
                    return;
                }
                int unused3 = ECMiscInfo.f176 = ECMiscInfo.f175;
            } catch (Exception unused4) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
    /* renamed from: com.alibaba.wireless.security.open.edgecomputing.ECMiscInfo$б, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
    private static class C0079 implements Application.ActivityLifecycleCallbacks {
        C0079(Context context) {
            if (ECMiscInfo.f174 == null) {
                HandlerThread handlerThread = new HandlerThread("EC-ALFC");
                handlerThread.start();
                Looper looper = handlerThread.getLooper();
                if (looper != null) {
                    ECMiscInfo.f174 = new Handler(looper);
                }
            }
            ProxyUtil.init(ECMiscInfo.f174);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            activity.sendBroadcast(new Intent("com.alibaba.action.LC_ON_ACT_CREATED"));
            ECMiscInfo.m1935(activity, 0);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            activity.sendBroadcast(new Intent("com.alibaba.action.LC_ON_ACT_DESTROYED"));
            ECMiscInfo.m1935(activity, 5);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            activity.sendBroadcast(new Intent("com.alibaba.action.LC_ON_ACT_PAUSED"));
            ECMiscInfo.m1935(activity, 3);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            activity.sendBroadcast(new Intent("com.alibaba.action.LC_ON_ACT_RESUMED"));
            ECMiscInfo.m1935(activity, 2);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            activity.sendBroadcast(new Intent("com.alibaba.action.LC_ON_ACT_SAVE_INSTANCE_STATE"));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            activity.sendBroadcast(new Intent("com.alibaba.action.LC_ON_ACT_STARTED"));
            ECMiscInfo.m1935(activity, 1);
            ECMiscInfo.m1934(0, this, ECMiscInfo.f174);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            activity.sendBroadcast(new Intent("com.alibaba.action.LC_ON_ACT_STOPPED"));
            ECMiscInfo.m1935(activity, 4);
            ECMiscInfo.m1934(1, this, ECMiscInfo.f174);
        }
    }

    public static boolean getAppFirstRunState() {
        Context m1939 = C0081.m1939();
        if (m1939 != null) {
            return m1939.getSharedPreferences("edge_computing_sp", 0).getBoolean("appFirstRun", true);
        }
        return false;
    }

    public static String getLastAppVersion() {
        Context m1939 = C0081.m1939();
        if (m1939 != null) {
            return m1939.getSharedPreferences("edge_computing_sp", 0).getString("lastAppVersion", null);
        }
        return null;
    }

    public static int isBackgroundNew(Context context) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                return runningAppProcessInfo.importance == 400 ? 1 : 0;
            }
        }
        return 99;
    }

    public static void registerAppLifeCyCleCallBack() {
        Context m1939;
        f173 = C0081.m1939();
        if (Build.VERSION.SDK_INT >= 14 && (m1939 = C0081.m1939()) != null) {
            Application application = m1939 instanceof Application ? (Application) m1939 : (Application) m1939.getApplicationContext();
            if (application != null) {
                application.registerActivityLifecycleCallbacks(new C0079(m1939));
            }
        }
    }

    public static void updateAppFirstRunState() {
        if (f172) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = C0081.m1939().getSharedPreferences("edge_computing_sp", 0);
            boolean z10 = sharedPreferences.getBoolean("appRunOnce", false);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("appFirstRun", z10 ? false : true);
            edit.putBoolean("appRunOnce", true);
            edit.apply();
        } catch (Exception unused) {
        }
    }

    public static void updateAppVersion(String str) {
        if (f171) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = C0081.m1939().getSharedPreferences("edge_computing_sp", 0);
            String string = sharedPreferences.getString(AttributionReporter.APP_VERSION, null);
            if (string != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("lastAppVersion", string);
                edit.apply();
            }
            if (str != null) {
                SharedPreferences.Editor edit2 = sharedPreferences.edit();
                edit2.putString(AttributionReporter.APP_VERSION, str);
                edit2.apply();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: б, reason: contains not printable characters */
    public static void m1934(int i10, C0079 c0079, Handler handler) {
        if (handler == null) {
            HandlerThread handlerThread = new HandlerThread("EC-FB");
            handlerThread.start();
            handler = new Handler(handlerThread.getLooper());
        }
        if (handler != null) {
            handler.postDelayed(new RunnableC0078(i10), 2L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: б, reason: contains not printable characters */
    public static void m1935(Activity activity, int i10) {
        try {
            C0081.m1941().doCommand(12611, activity, Integer.valueOf(i10), activity.getClass().getCanonicalName(), f174);
        } catch (Exception unused) {
        }
    }
}
