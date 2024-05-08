package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.b;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class he extends hc {
    public he(lo loVar) {
        super(loVar);
    }

    private void m() {
        com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.he.3
            @Override // java.lang.Runnable
            public void run() {
                he.this.b();
            }
        }, 2000L);
    }

    @Override // com.huawei.hms.ads.hc
    public void I(AdContentData adContentData) {
    }

    @Override // com.huawei.hms.ads.hc
    public String c() {
        return String.valueOf(1);
    }

    @Override // com.huawei.hms.ads.hg
    public void k() {
        gl.V("CacheAdMediator", "start");
        lo f10 = f();
        if (f10 == null) {
            I(-4);
            L();
            return;
        }
        AdContentData adContentData = this.C.Z() != 0 ? (AdContentData) com.huawei.openalliance.ad.utils.aw.Code(new Callable<AdContentData>() { // from class: com.huawei.hms.ads.he.1
            @Override // java.util.concurrent.Callable
            /* renamed from: Code, reason: merged with bridge method [inline-methods] */
            public AdContentData call() {
                Context context;
                AdSlotParam a10 = he.this.a();
                if (a10 == null || (context = he.this.f29267e) == null) {
                    gl.I("CacheAdMediator", "adslot is null");
                    return null;
                }
                CallResult Code = b.Code(context).Code("queryCacheSplashAd", com.huawei.openalliance.ad.utils.z.V(a10), String.class);
                he.this.f29266d = (String) Code.getData();
                return (AdContentData) com.huawei.openalliance.ad.utils.z.V((String) Code.getData(), AdContentData.class, new Class[0]);
            }
        }, null) : null;
        this.B = adContentData;
        this.S = true;
        if (adContentData == null) {
            gl.V("CacheAdMediator", "show sloganView");
            f10.Code(new mb() { // from class: com.huawei.hms.ads.he.2
                @Override // com.huawei.hms.ads.mb
                public void Code() {
                    gl.V("CacheAdMediator", "on Slogan Reach Min Show Time");
                }

                @Override // com.huawei.hms.ads.mb
                public void V() {
                    gl.V("CacheAdMediator", "on Slogan Show End");
                    com.huawei.openalliance.ad.utils.ba.Code(new Runnable() { // from class: com.huawei.hms.ads.he.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            he.this.I(498);
                            he.this.L();
                        }
                    });
                }
            });
        } else {
            if (adContentData.h() == 12) {
                if (I() == 1 && (V() instanceof com.huawei.openalliance.ad.inter.listeners.k)) {
                    com.huawei.openalliance.ad.inter.listeners.k kVar = (com.huawei.openalliance.ad.inter.listeners.k) V();
                    com.huawei.openalliance.ad.inter.data.l Code = kw.Code(adContentData);
                    if (Code != null) {
                        gl.V("CacheAdMediator", "on content find, linkedAd loaded. ");
                        this.F = System.currentTimeMillis();
                        kVar.Code(Code);
                        this.L = adContentData;
                        m();
                        B(200);
                        return;
                    }
                }
                I(1200);
                l();
                m();
                return;
            }
            if (!V(adContentData)) {
                I(com.huawei.openalliance.ad.constant.ad.f32210w);
                l();
            }
        }
        m();
    }

    @Override // com.huawei.hms.ads.hg
    public void l() {
        gl.V("CacheAdMediator", "onAdFailToDisplay");
        L();
    }
}
