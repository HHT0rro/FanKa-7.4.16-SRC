package com.alibaba.security.biometrics.build;

import android.app.Activity;
import android.view.KeyEvent;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;

/* compiled from: ALBiometricsComponent.java */
@m
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class p extends h {

    /* renamed from: d, reason: collision with root package name */
    public s f2318d;

    private void d() {
        ALBiometricsActivityParentView aLBiometricsActivityParentView;
        s sVar = this.f2318d;
        if (sVar == null || (aLBiometricsActivityParentView = sVar.f2334d) == null) {
            return;
        }
        aLBiometricsActivityParentView.f();
    }

    private void e() {
        s sVar = this.f2318d;
        if (sVar != null) {
            sVar.h();
        }
    }

    private void f() {
        s sVar = this.f2318d;
        if (sVar != null) {
            sVar.f2333c = 0;
        }
    }

    @Override // com.alibaba.security.biometrics.build.h, com.alibaba.security.biometrics.build.j
    public final boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        this.f2301b = aLBiometricsParams;
        s sVar = new s(activity);
        this.f2318d = sVar;
        sVar.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener);
        return false;
    }

    @Override // com.alibaba.security.biometrics.build.h, com.alibaba.security.biometrics.build.j
    public final boolean b() {
        s sVar = this.f2318d;
        if (sVar == null) {
            return false;
        }
        sVar.b();
        return false;
    }

    @Override // com.alibaba.security.biometrics.build.h, com.alibaba.security.biometrics.build.j
    public final boolean c() {
        s sVar = this.f2318d;
        if (sVar == null) {
            return false;
        }
        sVar.c();
        return false;
    }

    @Override // com.alibaba.security.biometrics.build.h, com.alibaba.security.biometrics.build.j
    public final void a(ALBiometricsActivityParentView aLBiometricsActivityParentView) {
        s sVar = this.f2318d;
        if (sVar != null) {
            sVar.a(aLBiometricsActivityParentView);
        }
    }

    @Override // com.alibaba.security.biometrics.build.h, com.alibaba.security.biometrics.build.j
    public final boolean a() {
        s sVar = this.f2318d;
        if (sVar == null) {
            return false;
        }
        sVar.a();
        return false;
    }

    @Override // com.alibaba.security.biometrics.build.h, com.alibaba.security.biometrics.build.j
    public final boolean a(int i10, KeyEvent keyEvent) {
        s sVar = this.f2318d;
        if (sVar == null) {
            return true;
        }
        sVar.a(i10, keyEvent);
        return true;
    }

    public final void a(int i10, String str, String str2) {
        s sVar = this.f2318d;
        if (sVar != null) {
            sVar.a(i10, str, str2);
        }
    }

    private void a(int i10, int[] iArr) {
        s sVar = this.f2318d;
        if (sVar == null || i10 != 1010) {
            return;
        }
        if ((iArr.length > 0 ? iArr[0] : -1) != 0) {
            s.f();
        } else {
            sVar.b(false);
        }
    }
}
