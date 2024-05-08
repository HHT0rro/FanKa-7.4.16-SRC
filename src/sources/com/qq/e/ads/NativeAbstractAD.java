package com.qq.e.ads;

import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.pi.ADI;
import com.qq.e.comm.util.AdError;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class NativeAbstractAD<T extends ADI> extends AbstractAD<T> {

    /* renamed from: f, reason: collision with root package name */
    private DownAPPConfirmPolicy f38104f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(T t2) {
        DownAPPConfirmPolicy downAPPConfirmPolicy = this.f38104f;
        if (downAPPConfirmPolicy != null) {
            setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.f38104f = downAPPConfirmPolicy;
        T t2 = this.f38089a;
        if (t2 == 0 || downAPPConfirmPolicy == null) {
            return;
        }
        ((ADI) t2).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }
}
