package com.wangmai.appsdkdex;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import zc.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WMDexAdHelper {
    public static WeakReference<Activity> topActivity;
    public static final String TAG = b.a("XNEfyBeIfmqfs");
    public static final String EXTRA_KEY = b.a("nbq`lfz");
    public static final LinkedHashMap<String, Activity> activityMap = new LinkedHashMap<>();
    public static final LinkedHashMap<String, ViewGroup> loadViewGroupMap = new LinkedHashMap<>();
    public static Application.ActivityLifecycleCallbacks topActivityCallbacks = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            WMDexAdHelper.topActivity = new WeakReference<>(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
        }
    }

    public static Activity getActivity(String str) {
        return activityMap.get(str);
    }

    public static Application getApplication() {
        WeakReference<Activity> weakReference = topActivity;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return topActivity.get().getApplication();
    }

    public static WeakReference<Activity> getTopActivity() {
        return topActivity;
    }

    @Deprecated
    public static void setTopActivity(Activity activity) {
        WeakReference<Activity> weakReference = topActivity;
        if ((weakReference == null || weakReference.get().isFinishing()) && !activity.isFinishing()) {
            topActivity = new WeakReference<>(activity);
        }
    }

    public static void startActivty(Context context, String str, ViewGroup viewGroup, Class cls, Intent intent) {
        loadViewGroupMap.put(str, viewGroup);
        intent.putExtra(EXTRA_KEY, str);
        intent.setClass(context, cls);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }
}
