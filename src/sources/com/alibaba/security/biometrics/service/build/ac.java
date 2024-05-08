package com.alibaba.security.biometrics.service.build;

import android.os.Message;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.service.model.ABDetectContext;
import com.alibaba.security.biometrics.service.model.ABDetectPhase;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.common.utils.JsonUtils;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InitialState.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ac extends y {
    public ac(t tVar) {
        super(tVar);
    }

    @Override // com.alibaba.security.biometrics.service.build.y
    public final String a() {
        return "InitialState";
    }

    @Override // com.alibaba.security.biometrics.service.build.af, com.alibaba.security.biometrics.service.build.ae
    public final boolean a(Message message) {
        int i10 = message.what;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    b(message);
                    a(this.f2858b.f2852x);
                } else if (i10 == 3) {
                    b(message);
                    a(this.f2858b.f2853y);
                } else if (i10 == 4) {
                    b(message);
                    a(this.f2858b.f2854z);
                } else if (i10 == 5) {
                    b(message);
                    a(this.f2858b.A);
                } else if (i10 == 99) {
                    b(message);
                    a(this.f2858b.f2851w);
                } else if (i10 == 100 || i10 == 887) {
                    b(message);
                    a(this.f2858b.B);
                } else if (i10 == 998) {
                    a(this.f2858b.B);
                } else {
                    if (i10 != 999) {
                        return false;
                    }
                    Object obj = message.obj;
                    if (obj != null) {
                        a((ALBiometricsParams) obj);
                    }
                }
            } else if (this.f2860d.stepAdjust) {
                this.f2858b.c(2);
            } else {
                this.f2858b.b(4, ABDetectContext.getInstance().offerAction());
            }
        }
        return true;
    }

    @Override // com.alibaba.security.biometrics.service.build.y, com.alibaba.security.biometrics.service.build.af, com.alibaba.security.biometrics.service.build.ae
    public final void b() {
        super.b();
        ABDetectContext.getInstance().setCurrentPhase(ABDetectPhase.INIT);
        HashMap hashMap = new HashMap();
        hashMap.put("detectType", "action");
        hashMap.put("actionType", JsonUtils.toJSON(ABDetectContext.getInstance().getActions()));
        hashMap.put("maxRetryTimes", Integer.valueOf(this.f2860d.retryThreshold + 1));
        ALBiometricsJni.bhL(9, JsonUtils.toJSON(hashMap));
    }
}
