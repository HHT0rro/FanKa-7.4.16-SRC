package com.huawei.hms.ads;

import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class bu {
    private NativeAd Code;
    private com.huawei.openalliance.ad.inter.data.v I;
    private VideoConfiguration V;

    public bu(NativeAd nativeAd) {
        NativeAdConfiguration ad2;
        this.Code = nativeAd;
        if (nativeAd instanceof bt) {
            bt btVar = (bt) nativeAd;
            this.I = btVar.Code().B();
            com.huawei.openalliance.ad.inter.data.g Code = btVar.Code();
            if (!(Code instanceof com.huawei.openalliance.ad.inter.data.n) || (ad2 = ((com.huawei.openalliance.ad.inter.data.n) Code).ad()) == null) {
                return;
            }
            this.V = ad2.getVideoConfiguration();
        }
    }

    public boolean Code() {
        return this.I != null;
    }

    public float I() {
        Float g3;
        com.huawei.openalliance.ad.inter.data.v vVar = this.I;
        if (vVar == null || (g3 = vVar.g()) == null) {
            return 0.0f;
        }
        return g3.floatValue();
    }

    public boolean V() {
        com.huawei.openalliance.ad.inter.data.v vVar = this.I;
        return vVar != null && "n".equals(vVar.a());
    }

    public boolean Z() {
        VideoConfiguration videoConfiguration = this.V;
        return videoConfiguration != null && videoConfiguration.isCustomizeOperateRequested();
    }
}
