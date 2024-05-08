package com.bytedance.sdk.openadsdk.m;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
class m implements Application.ActivityLifecycleCallbacks {

    /* renamed from: m, reason: collision with root package name */
    private static volatile boolean f11226m;
    private int dk = 0;
    private InterfaceC0131m ej;

    /* renamed from: com.bytedance.sdk.openadsdk.m.m$m, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface InterfaceC0131m {
        void dk();

        void m();
    }

    public Boolean m() {
        return Boolean.valueOf(f11226m);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
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
        this.dk++;
        f11226m = false;
        InterfaceC0131m interfaceC0131m = this.ej;
        if (interfaceC0131m != null) {
            interfaceC0131m.dk();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i10 = this.dk - 1;
        this.dk = i10;
        if (i10 == 0) {
            f11226m = true;
            InterfaceC0131m interfaceC0131m = this.ej;
            if (interfaceC0131m != null) {
                interfaceC0131m.m();
            }
        }
    }

    public void m(InterfaceC0131m interfaceC0131m) {
        this.ej = interfaceC0131m;
    }
}
