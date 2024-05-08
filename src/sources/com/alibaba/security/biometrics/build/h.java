package com.alibaba.security.biometrics.build;

import android.app.Activity;
import android.view.KeyEvent;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;

/* compiled from: AbsPageComponent.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class h implements j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2300a = "AlBiometricsPageComponent";

    /* renamed from: b, reason: collision with root package name */
    public ALBiometricsParams f2301b;

    /* renamed from: c, reason: collision with root package name */
    public Activity f2302c;

    @Override // com.alibaba.security.biometrics.build.j
    public void a(ALBiometricsActivityParentView aLBiometricsActivityParentView) {
    }

    @Override // com.alibaba.security.biometrics.build.j
    public boolean a() {
        return false;
    }

    @Override // com.alibaba.security.biometrics.build.j
    public boolean a(int i10, KeyEvent keyEvent) {
        return true;
    }

    @Override // com.alibaba.security.biometrics.build.j
    public boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        this.f2301b = aLBiometricsParams;
        this.f2302c = activity;
        return false;
    }

    @Override // com.alibaba.security.biometrics.build.j
    public boolean b() {
        return false;
    }

    @Override // com.alibaba.security.biometrics.build.j
    public boolean c() {
        return false;
    }
}
