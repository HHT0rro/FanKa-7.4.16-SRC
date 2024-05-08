package com.alibaba.security.biometrics.build;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.utils.LocalBroadcastManagerUtils;

/* compiled from: ScreenOffComponent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class n extends h {

    /* renamed from: d, reason: collision with root package name */
    private final BroadcastReceiver f2316d = new BroadcastReceiver() { // from class: com.alibaba.security.biometrics.build.n.1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            s sVar;
            if (!"android.intent.action.SCREEN_OFF".equals(intent.getAction()) || (sVar = ((p) l.a(p.class)).f2318d) == null) {
                return;
            }
            sVar.h();
        }
    };

    @Override // com.alibaba.security.biometrics.build.h, com.alibaba.security.biometrics.build.j
    public final boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        LocalBroadcastManagerUtils.getInstance(activity).registerReceiver(this.f2316d, new IntentFilter("android.intent.action.SCREEN_OFF"));
        return super.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener);
    }

    @Override // com.alibaba.security.biometrics.build.h, com.alibaba.security.biometrics.build.j
    public final boolean c() {
        LocalBroadcastManagerUtils.getInstance(this.f2302c).unregisterReceiver(this.f2316d);
        return super.c();
    }
}
