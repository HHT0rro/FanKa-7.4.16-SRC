package com.huawei.hmf.services.ui.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.huawei.hmf.repository.ComponentRepository;
import com.huawei.hmf.services.Module;
import com.huawei.hmf.services.interception.ActionInvocation;
import com.huawei.hmf.services.interception.Signature;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ActivityLifecycleInterceptor {
    private static ActivityLifecycleCallbacks mActivityLifecycleCallbacks;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class ActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        private ActivityLifecycleCallbacks() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            CallingInfo callingInfo;
            if (bundle != null || (callingInfo = new ActivityData(activity.getIntent()).getCallingInfo()) == null) {
                return;
            }
            String str = activity.getCallingActivity() != null ? "sendActivityResult" : "startActivity";
            Module lookup = ComponentRepository.getRepository().lookup(callingInfo.getModule());
            if (lookup == null || lookup.getInterceptor() == null) {
                return;
            }
            Signature signature = new Signature(activity.getClass());
            signature.setName(str);
            lookup.getInterceptor().after(ActionInvocation.builder().moduleName(callingInfo.getModule()).callingPackageName(callingInfo.getPackageName()).signature(signature).build());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity.isFinishing()) {
                new ActivityData(activity.getIntent()).free();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    public static synchronized void register(Context context) {
        synchronized (ActivityLifecycleInterceptor.class) {
            if (mActivityLifecycleCallbacks == null) {
                mActivityLifecycleCallbacks = new ActivityLifecycleCallbacks();
                ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks);
            }
        }
    }
}
