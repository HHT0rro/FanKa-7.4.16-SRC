package com.alibaba.security.biometrics.service.build;

import android.os.Bundle;
import android.os.Message;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ABDetectPhase;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;

/* compiled from: AdjustBeginState.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class w extends y {
    public w(t tVar) {
        super(tVar);
    }

    private void e() {
        ABDetectContext.getInstance().setCurrentPhase(ABDetectPhase.ADJUST_BEGIN);
        Bundle bundle = new Bundle();
        bundle.putInt("aju_c", ABDetectContext.getInstance().getRetryTimes() + 1);
        a.a().a(b.f2667k, bundle);
        this.f2858b.a(ABDetectType.KEEP_STILL, false, false);
        this.f2858b.a(3);
    }

    @Override // com.alibaba.security.biometrics.service.build.y
    public final String a() {
        return "AdjustBeginState";
    }

    @Override // com.alibaba.security.biometrics.service.build.af, com.alibaba.security.biometrics.service.build.ae
    public final boolean a(Message message) {
        if (message.what != 2) {
            return false;
        }
        ABDetectContext.getInstance().setCurrentPhase(ABDetectPhase.ADJUST_BEGIN);
        Bundle bundle = new Bundle();
        bundle.putInt("aju_c", ABDetectContext.getInstance().getRetryTimes() + 1);
        a.a().a(b.f2667k, bundle);
        this.f2858b.a(ABDetectType.KEEP_STILL, false, false);
        this.f2858b.a(3);
        return true;
    }

    @Override // com.alibaba.security.biometrics.service.build.y, com.alibaba.security.biometrics.service.build.af, com.alibaba.security.biometrics.service.build.ae
    public final void b() {
        super.b();
    }
}
