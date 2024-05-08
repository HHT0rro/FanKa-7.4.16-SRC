package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.turingface.sdk.mfa.ITuringIoTFeatureMap;
import com.xiaomi.push.h4;
import com.xiaomi.push.i4;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class q implements Application.ActivityLifecycleCallbacks {

    /* renamed from: b, reason: collision with root package name */
    public Set<String> f47068b = new HashSet();

    public static void a(Application application) {
        application.registerActivityLifecycleCallbacks(new q());
    }

    public static void b(Context context) {
        a((Application) context.getApplicationContext());
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
        i4 a10;
        String packageName;
        String j10;
        int i10;
        Intent intent = activity.getIntent();
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if (TextUtils.isEmpty(stringExtra) || intExtra <= 0 || this.f47068b.contains(stringExtra)) {
            return;
        }
        this.f47068b.add(stringExtra);
        if (intExtra == 3000) {
            a10 = i4.a(activity.getApplicationContext());
            packageName = activity.getPackageName();
            j10 = h4.j(intExtra);
            i10 = ITuringIoTFeatureMap.RIOT_CAMERA_SERIAL;
        } else {
            if (intExtra != 1000) {
                return;
            }
            a10 = i4.a(activity.getApplicationContext());
            packageName = activity.getPackageName();
            j10 = h4.j(intExtra);
            i10 = 1008;
        }
        a10.g(packageName, j10, stringExtra, i10, null);
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
