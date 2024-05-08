package com.alibaba.security.biometrics.build;

import android.app.Activity;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;

/* compiled from: EnvironmentComponent.java */
@m(a = 8)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class i extends h {

    /* renamed from: d, reason: collision with root package name */
    public ai f2303d;

    @Override // com.alibaba.security.biometrics.build.h, com.alibaba.security.biometrics.build.j
    public final boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        super.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener);
        this.f2303d = new aj(activity);
        return false;
    }

    @Override // com.alibaba.security.biometrics.build.h, com.alibaba.security.biometrics.build.j
    public final boolean a() {
        if (this.f2303d.a(this.f2301b.supportX86)) {
            return false;
        }
        ((p) l.a(p.class)).a(this.f2303d.a(), "EnvironmentComponent", null);
        return true;
    }
}
