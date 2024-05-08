package com.huawei.hms.ads;

import android.content.Context;
import android.os.CountDownTimer;
import com.huawei.hms.ads.lq;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class ju<V extends lq> extends hn<V> implements kk<V> {
    private CountDownTimer B;
    public Context V;
    private boolean Z = false;
    private boolean C = false;

    public ju(Context context, V v2) {
        this.V = context.getApplicationContext();
        Code((ju<V>) v2);
    }

    private void I(String str) {
        if (this.Z) {
            gl.V("PPSBaseViewPresenter", str);
            return;
        }
        this.Z = true;
        B();
        Code();
    }

    @Override // com.huawei.hms.ads.kk
    public void B() {
        if (this.C) {
            gl.V("PPSBaseViewPresenter", "already reset");
        }
        this.C = true;
        if (I() != 0) {
            ((lq) I()).destroyView();
        }
    }

    public void Code() {
        gl.V("PPSBaseViewPresenter", "cancelDisplayDurationCountTask");
        CountDownTimer countDownTimer = this.B;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.B = null;
        }
    }

    @Override // com.huawei.hms.ads.kk
    public void Code(int i10) {
        gl.V("PPSBaseViewPresenter", "startDisplayDurationCountTask duration: %d", Integer.valueOf(i10));
        CountDownTimer countDownTimer = this.B;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer(i10, 500L) { // from class: com.huawei.hms.ads.ju.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                ((lq) ju.this.I()).I(1);
                ju.this.V();
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j10) {
                int max = Math.max(1, (int) Math.ceil((((float) j10) * 1.0f) / 1000.0f));
                gl.Code("PPSBaseViewPresenter", "count down time: %d seconds: %d", Long.valueOf(j10), Integer.valueOf(max));
                ((lq) ju.this.I()).I(max);
            }
        };
        this.B = countDownTimer2;
        countDownTimer2.start();
    }

    @Override // com.huawei.hms.ads.kk
    public void Code(int i10, int i11, AdContentData adContentData, Long l10, com.huawei.openalliance.ad.inter.data.m mVar, int i12) {
        gl.V("PPSBaseViewPresenter", "onTouch");
        hg adMediator = ((lq) I()).getAdMediator();
        if (adMediator == null || !adMediator.Code(i10, i11, adContentData, l10, mVar, i12)) {
            return;
        }
        if (this.Z) {
            gl.V("PPSBaseViewPresenter", "onDoActionSucc hasShowFinish");
            return;
        }
        this.Z = true;
        B();
        Code();
    }

    @Override // com.huawei.hms.ads.kk
    public void Code(int i10, int i11, Long l10) {
        gl.V("PPSBaseViewPresenter", "skip ad - hasShowFinish: %s", Boolean.valueOf(this.Z));
        if (this.Z) {
            return;
        }
        this.Z = true;
        B();
        Code();
    }

    @Override // com.huawei.hms.ads.kk
    public void Code(AdContentData adContentData) {
        this.Code = adContentData;
        Code(com.huawei.openalliance.ad.utils.au.Code(Long.valueOf(com.huawei.openalliance.ad.utils.v.Code())));
        if (adContentData == null) {
            gl.I("PPSBaseViewPresenter", "loadAdMaterial contentRecord is null");
            ((lq) I()).Code(-7);
        } else {
            gl.V("PPSBaseViewPresenter", "loadAdMaterial");
            V(adContentData.d());
            com.huawei.openalliance.ad.utils.d.Code(this.V, adContentData);
        }
    }

    @Override // com.huawei.hms.ads.kk
    public void Code(AdContentData adContentData, long j10, int i10) {
        hg adMediator = ((lq) I()).getAdMediator();
        if (adMediator != null) {
            adMediator.Code(adContentData, j10, i10);
        }
    }

    @Override // com.huawei.hms.ads.kk
    public void Code(Long l10) {
        I("onWhyThisAd hasShowFinish");
    }

    @Override // com.huawei.hms.ads.kk
    public void V() {
        gl.V("PPSBaseViewPresenter", "onDisplayTimeUp hasShowFinish: %s", Boolean.valueOf(this.Z));
        if (this.Z) {
            return;
        }
        this.Z = true;
        B();
        hg adMediator = ((lq) I()).getAdMediator();
        if (adMediator != null) {
            adMediator.i();
        }
    }

    public void V(AdContentData adContentData) {
        hg adMediator = ((lq) I()).getAdMediator();
        if (adMediator != null) {
            adMediator.Z(adContentData);
        }
    }

    @Override // com.huawei.hms.ads.kk
    public void V(Long l10) {
        I("feedback hasShowFinish");
    }

    public abstract void V(String str);
}
