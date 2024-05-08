package com.xiaomi.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class k2 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: b, reason: collision with root package name */
    public String f47898b;

    /* renamed from: c, reason: collision with root package name */
    public String f47899c;

    /* renamed from: d, reason: collision with root package name */
    public Context f47900d;

    public k2(Context context, String str) {
        this.f47900d = context;
        this.f47898b = str;
    }

    public final void a(String str) {
        hy hyVar = new hy();
        hyVar.a(str);
        hyVar.a(System.currentTimeMillis());
        hyVar.a(hs.ActivityActiveTimeStamp);
        a3.d(this.f47900d, hyVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (TextUtils.isEmpty(this.f47898b) || TextUtils.isEmpty(localClassName)) {
            return;
        }
        this.f47899c = "";
        if (!TextUtils.isEmpty("") && !TextUtils.equals(this.f47899c, localClassName)) {
            this.f47898b = "";
            return;
        }
        a(this.f47900d.getPackageName() + "|" + localClassName + com.huawei.openalliance.ad.constant.u.bD + this.f47898b + "," + String.valueOf(System.currentTimeMillis() / 1000));
        this.f47898b = "";
        this.f47899c = "";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.f47899c)) {
            this.f47899c = activity.getLocalClassName();
        }
        this.f47898b = String.valueOf(System.currentTimeMillis() / 1000);
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
