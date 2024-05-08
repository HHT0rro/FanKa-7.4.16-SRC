package com.alibaba.security.biometrics.service.build;

import android.os.Message;
import com.alibaba.security.biometrics.service.ALBiometricsService;
import com.alibaba.security.biometrics.service.build.ag;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseState.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class y extends af implements ad {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2857a = "StateMachine";

    /* renamed from: b, reason: collision with root package name */
    public t f2858b;

    /* renamed from: c, reason: collision with root package name */
    public ALBiometricsService f2859c;

    /* renamed from: d, reason: collision with root package name */
    public ALBiometricsParams f2860d;

    /* renamed from: e, reason: collision with root package name */
    public j f2861e;

    /* renamed from: f, reason: collision with root package name */
    public s f2862f;

    public y(t tVar) {
        this.f2858b = tVar;
        ALBiometricsService aLBiometricsService = tVar.f2843o;
        this.f2859c = aLBiometricsService;
        this.f2860d = aLBiometricsService.getParams();
        t tVar2 = this.f2858b;
        this.f2861e = tVar2.f2847s;
        this.f2862f = tVar2.f2848t;
    }

    public abstract String a();

    public final void a(ALBiometricsParams aLBiometricsParams) {
        if (aLBiometricsParams != null) {
            this.f2860d = aLBiometricsParams;
        }
    }

    public final void b(Message message) {
        ag.c.a(this.f2858b.g_, message);
    }

    @Override // com.alibaba.security.biometrics.service.build.af, com.alibaba.security.biometrics.service.build.ae
    public final void c() {
    }

    public final void a(ae aeVar) {
        t tVar = this.f2858b;
        if (aeVar != null) {
            tVar.g_.a(aeVar);
        }
    }

    @Override // com.alibaba.security.biometrics.service.build.af, com.alibaba.security.biometrics.service.build.ae
    public void b() {
        super.b();
    }
}
