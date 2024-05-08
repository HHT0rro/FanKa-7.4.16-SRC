package com.huawei.hmf.services.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.huawei.hmf.services.ui.activity.ActivityCallback;
import com.huawei.hmf.services.ui.activity.ActivityResult;
import com.huawei.hmf.services.ui.internal.ActivityLifecycleInterceptor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Launcher {
    private static Launcher launcher = new Launcher();
    private SparseArray<ActivityCallback> mActivityCallbackMap = new SparseArray<>();

    public static Launcher getLauncher() {
        return launcher;
    }

    public FragmentModuleDelegate createFragment(Context context, UIModule uIModule) {
        ActivityLifecycleInterceptor.register(context);
        try {
            return FragmentModuleDelegate.create(uIModule.getUIModuleSpec().getType().newInstance(), uIModule.getBundle(context));
        } catch (Exception unused) {
            return null;
        }
    }

    public void onActivityResult(Activity activity, int i10, int i11, Intent intent) {
        ActivityResult createFromResultIntent = ActivityResult.createFromResultIntent(intent);
        ActivityCallback activityCallback = this.mActivityCallbackMap.get(i10);
        if (activityCallback != null) {
            removeActivityCallback(i10);
            activityCallback.onResult(activity, i11, createFromResultIntent.get());
        }
    }

    public void removeActivityCallback(int i10) {
        this.mActivityCallbackMap.remove(i10);
    }

    @Deprecated
    public void sendActivityResult(int i10, int i11, Intent intent) {
    }

    public void startActivity(Context context, UIModule uIModule) {
        startActivity(context, uIModule, (Intent) null);
    }

    public void startActivity(Context context, UIModule uIModule, Intent intent) {
        ActivityLifecycleInterceptor.register(context);
        uIModule.startActivity(context, intent);
    }

    public void startActivity(Context context, UIModule uIModule, ActivityCallback activityCallback) {
        startActivity(context, uIModule, null, activityCallback);
    }

    public void startActivity(Context context, UIModule uIModule, Intent intent, ActivityCallback activityCallback) {
        ActivityLifecycleInterceptor.register(context);
        int hashCode = uIModule.hashCode() & 65535;
        this.mActivityCallbackMap.append(hashCode, activityCallback);
        uIModule.startActivityForResult(context, intent, hashCode);
    }
}
