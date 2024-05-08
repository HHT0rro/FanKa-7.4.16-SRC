package com.alimm.tanx.core.ut.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class LifeCycleManager {
    public static final String TAG = "LifeCycleManager";
    public static volatile LifeCycleManager instance;
    public ActivityLifeCycle activityLifeCycle;
    public volatile ConcurrentHashMap<String, Integer> activityVisibleMap = new ConcurrentHashMap<>(1000);
    public boolean nowBackground = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class ActivityLifeCycle implements Application.ActivityLifecycleCallbacks {
        public ActivityLifeCycle() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            LogUtils.d(LifeCycleManager.TAG, "onActivityCreated ，activity->" + activity.getClass().getName() + " activitySize->" + LifeCycleManager.this.activityVisibleMap.size());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            LogUtils.d(LifeCycleManager.TAG, "onActivityPaused，activity.");
            try {
                LogUtils.d(LifeCycleManager.TAG, "onActivityPaused，activity->" + activity.getClass().getName() + " activitySize->" + LifeCycleManager.this.activityVisibleMap.size());
                String name = activity.getClass().getName();
                if (LifeCycleManager.this.activityVisibleMap != null && LifeCycleManager.this.activityVisibleMap.get(name) != null) {
                    int intValue = ((Integer) LifeCycleManager.this.activityVisibleMap.get(name)).intValue();
                    if (intValue > 1) {
                        LifeCycleManager.this.activityVisibleMap.put(name, Integer.valueOf(intValue - 1));
                    } else {
                        LifeCycleManager.this.activityVisibleMap.remove(name);
                    }
                }
            } catch (Exception e2) {
                LogUtils.e(LifeCycleManager.TAG, e2);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            try {
                String name = activity.getClass().getName();
                if (LifeCycleManager.this.activityVisibleMap.get(activity.getClass().getName()) == null) {
                    LifeCycleManager.this.activityVisibleMap.put(name, 1);
                } else {
                    LifeCycleManager.this.activityVisibleMap.put(activity.getClass().getName(), Integer.valueOf(((Integer) LifeCycleManager.this.activityVisibleMap.get(activity.getClass().getName())).intValue() + 1));
                }
                LogUtils.d(LifeCycleManager.TAG, "onActivityResumed ，activity->" + activity.getClass().getName() + " activitySize->" + LifeCycleManager.this.activityVisibleMap.size());
                LifeCycleManager.this.appVisibleExecute();
            } catch (Exception e2) {
                LogUtils.e(LifeCycleManager.TAG, e2);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            LogUtils.d(LifeCycleManager.TAG, "onActivityStarted :，activity->" + activity.getClass().getName() + " activitySize->" + LifeCycleManager.this.activityVisibleMap.size());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            LogUtils.d(LifeCycleManager.TAG, "onActivityStoppedactivity->" + activity.getClass().getName() + " activitySize->" + LifeCycleManager.this.activityVisibleMap.size());
            LifeCycleManager.this.appBackgroundExecute();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appBackgroundExecute() {
        if (isBackground()) {
            UserReportManager.getInstance().destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appVisibleExecute() {
        if (!this.nowBackground || isBackground()) {
            return;
        }
        UserReportManager.getInstance().init();
    }

    public static LifeCycleManager getInstance() {
        if (instance == null) {
            synchronized (CacheUserReportManager.class) {
                if (instance == null) {
                    instance = new LifeCycleManager();
                }
            }
        }
        return instance;
    }

    public void init() {
        this.activityLifeCycle = new ActivityLifeCycle();
        TanxCoreSdk.getApplication().registerActivityLifecycleCallbacks(this.activityLifeCycle);
    }

    public boolean isBackground() {
        this.nowBackground = this.activityVisibleMap.size() <= 0;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("UserReport :当前前后台状态：->");
        sb2.append(this.nowBackground ? "后台" : "前台");
        LogUtils.d(TAG, sb2.toString());
        LogUtils.d(TAG, "UserReport :activityVisibleMap：->" + this.activityVisibleMap.toString());
        return this.nowBackground;
    }
}
