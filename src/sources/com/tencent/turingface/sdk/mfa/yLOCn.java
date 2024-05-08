package com.tencent.turingface.sdk.mfa;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class yLOCn implements Application.ActivityLifecycleCallbacks {
    public abstract void a(Activity activity);

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
