package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.openalliance.ad.inter.HiAd;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class h implements o, com.huawei.openalliance.ad.inter.listeners.i {
    private static final Integer Z = 2;
    public NativeAdConfiguration Code;
    private NativeAd.NativeAdLoadedListener D;
    private String F;
    private AdListener L;
    private Context S;
    public com.huawei.openalliance.ad.inter.m V;

    /* renamed from: a, reason: collision with root package name */
    private boolean f29260a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f29261b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f29262c;

    public h(Context context, String str) {
        this.S = context.getApplicationContext();
        this.F = str;
        this.f29261b = com.huawei.openalliance.ad.utils.l.I(context);
    }

    private void Code(int i10) {
        AdListener adListener = this.L;
        if (adListener != null) {
            adListener.onAdFailed(i10);
        }
    }

    private com.huawei.openalliance.ad.inter.i V() {
        if (this.V == null) {
            this.V = new com.huawei.openalliance.ad.inter.m(this.S, new String[]{this.F}, 3);
        }
        return this.V;
    }

    private void V(AdParam adParam) {
        com.huawei.openalliance.ad.inter.m mVar;
        if (adParam == null || (mVar = this.V) == null) {
            return;
        }
        mVar.Code(dy.Code(adParam.V()));
        this.V.Code(true);
        this.V.Code(adParam.Code());
        this.V.Code(adParam.getKeywords());
        this.V.Code(adParam.getGender());
        this.V.V(adParam.getTargetingContentUrl());
        this.V.I(adParam.I());
        this.V.Code(adParam.B());
        this.V.Z(adParam.C());
        this.V.Z(adParam.S());
        HiAd.getInstance(this.S).setCountryCode(adParam.Z());
    }

    private void V(NativeAdConfiguration nativeAdConfiguration) {
        if (nativeAdConfiguration != null) {
            com.huawei.openalliance.ad.inter.m mVar = this.V;
            if (mVar instanceof com.huawei.openalliance.ad.inter.m) {
                mVar.Code(nativeAdConfiguration);
                Integer V = nativeAdConfiguration.V();
                if (V != null) {
                    if (V.intValue() == -1) {
                        this.V.Code((Integer) 0);
                    } else {
                        this.V.Code(Integer.valueOf(V.intValue() + Z.intValue()));
                    }
                }
                AdSize adSize = nativeAdConfiguration.getAdSize();
                if (adSize != null) {
                    if (AdSize.AD_SIZE_SMART.equals(adSize)) {
                        this.V.Code((Integer) 1);
                    } else {
                        this.V.Code((Integer) 0);
                    }
                    this.V.V(Integer.valueOf(adSize.getWidthPx(this.S)));
                    this.V.I(Integer.valueOf(adSize.getHeightPx(this.S)));
                }
                int adType = nativeAdConfiguration.getAdType();
                if (-1 != adType) {
                    this.V.I(adType);
                }
            }
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.i
    public void Code(int i10, boolean z10) {
        Code(dx.Code(i10));
        if (z10) {
            this.f29260a = false;
        }
    }

    @Override // com.huawei.hms.ads.o
    public void Code(AdListener adListener) {
        this.L = adListener;
    }

    @Override // com.huawei.hms.ads.o
    public void Code(AdParam adParam) {
        Code(adParam, 1);
    }

    @Override // com.huawei.hms.ads.o
    public void Code(AdParam adParam, int i10) {
        if (TextUtils.isEmpty(this.F)) {
            Code(1);
            gl.V("AdLoadMediator", " ad uint id is invalid.");
            return;
        }
        j.Code().Code(this.S);
        V();
        V(adParam);
        V(this.Code);
        com.huawei.openalliance.ad.inter.m mVar = this.V;
        if (mVar != null) {
            this.f29260a = true;
            mVar.V(i10);
            this.V.Code(this);
            this.V.I(this.f29262c);
            this.V.Code(this.f29261b, false);
        }
    }

    @Override // com.huawei.hms.ads.o
    public void Code(NativeAd.NativeAdLoadedListener nativeAdLoadedListener) {
        this.D = nativeAdLoadedListener;
    }

    @Override // com.huawei.hms.ads.o
    public void Code(NativeAdConfiguration nativeAdConfiguration) {
        this.Code = nativeAdConfiguration;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.i
    public void Code(Map<String, List<com.huawei.openalliance.ad.inter.data.g>> map, boolean z10) {
        if (z10) {
            this.f29260a = false;
        }
        if (map == null || map.size() <= 0) {
            gl.V("AdLoadMediator", " ads map is empty.");
            Code(3);
            return;
        }
        List<com.huawei.openalliance.ad.inter.data.g> list = map.get(this.F);
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.huawei.openalliance.ad.inter.data.g gVar : list) {
            if (this.D != null && gVar != null) {
                bt btVar = new bt(this.S, gVar);
                NativeAdConfiguration nativeAdConfiguration = this.Code;
                if (nativeAdConfiguration != null) {
                    btVar.Code(nativeAdConfiguration.Code());
                }
                btVar.Code(this.L);
                this.D.onNativeAdLoaded(btVar);
            }
        }
        AdListener adListener = this.L;
        if (adListener != null) {
            adListener.onAdLoaded();
        }
    }

    @Override // com.huawei.hms.ads.o
    public void Code(boolean z10) {
        this.f29262c = z10;
    }

    @Override // com.huawei.hms.ads.o
    public boolean Code() {
        return this.f29260a;
    }
}
