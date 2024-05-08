package com.alibaba.security.biometrics.service.build;

import android.os.Bundle;
import android.os.Message;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ABDetectPhase;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.result.ABActionResult;

/* compiled from: ActionDetectBeginState.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class u extends y {
    public u(t tVar) {
        super(tVar);
    }

    @Override // com.alibaba.security.biometrics.service.build.y
    public final String a() {
        return "ActionDetectBeginState";
    }

    @Override // com.alibaba.security.biometrics.service.build.af, com.alibaba.security.biometrics.service.build.ae
    public final boolean a(Message message) {
        if (message.what != 4) {
            return false;
        }
        Object obj = message.obj;
        if (obj != null) {
            ABDetectType aBDetectType = (ABDetectType) obj;
            ABDetectContext.getInstance().setCurrentPhase(ABDetectPhase.ACTION_BEGIN);
            Bundle bundle = new Bundle();
            bundle.putInt("act_type", aBDetectType.getValue());
            bundle.putInt("act_idx", ABDetectContext.getInstance().getCurrentActionIndex() + 1);
            a.a().a(b.f2669m, bundle);
            ABDetectContext.getInstance().setFrameCount(0);
            ABDetectContext.getInstance().setCurrentActionResult(new ABActionResult());
            ABDetectContext.getInstance().getCurrentActionResult().setBt(System.currentTimeMillis());
            ABDetectContext.getInstance().getCurrentActionResult().setAt(aBDetectType.getValue());
            ABDetectContext.getInstance().getResult().addActionResult(ABDetectContext.getInstance().getCurrentActionResult());
            this.f2858b.a(5, (Object) new p(aBDetectType, ABDetectContext.getInstance().getCurrentActionIndex(), ABDetectContext.getInstance().getActionCount()));
            this.f2858b.a(aBDetectType, true, true);
        }
        return true;
    }

    @Override // com.alibaba.security.biometrics.service.build.y, com.alibaba.security.biometrics.service.build.af, com.alibaba.security.biometrics.service.build.ae
    public final void b() {
        super.b();
        if (ABDetectContext.getInstance().getCurrentPhase() != ABDetectPhase.ACTION_END) {
            ABDetectContext.getInstance().getResult().getAs().clear();
        }
    }

    private void a(ABDetectType aBDetectType) {
        ABDetectContext.getInstance().setCurrentPhase(ABDetectPhase.ACTION_BEGIN);
        Bundle bundle = new Bundle();
        bundle.putInt("act_type", aBDetectType.getValue());
        bundle.putInt("act_idx", ABDetectContext.getInstance().getCurrentActionIndex() + 1);
        a.a().a(b.f2669m, bundle);
        ABDetectContext.getInstance().setFrameCount(0);
        ABDetectContext.getInstance().setCurrentActionResult(new ABActionResult());
        ABDetectContext.getInstance().getCurrentActionResult().setBt(System.currentTimeMillis());
        ABDetectContext.getInstance().getCurrentActionResult().setAt(aBDetectType.getValue());
        ABDetectContext.getInstance().getResult().addActionResult(ABDetectContext.getInstance().getCurrentActionResult());
        this.f2858b.a(5, (Object) new p(aBDetectType, ABDetectContext.getInstance().getCurrentActionIndex(), ABDetectContext.getInstance().getActionCount()));
        this.f2858b.a(aBDetectType, true, true);
    }
}
