package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.huawei.hms.ads.banner.BannerView;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.b;
import com.huawei.openalliance.ad.inter.listeners.c;
import com.huawei.openalliance.ad.views.PPSBannerView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class k implements q, c, com.huawei.openalliance.ad.inter.listeners.m {
    private static final String Code = "k";
    private Context B;
    private BannerAdSize I;
    private AdListener V;
    private PPSBannerView Z;

    public k(Context context, PPSBannerView pPSBannerView) {
        this.B = context;
        this.Z = pPSBannerView;
    }

    private void I(BannerAdSize bannerAdSize) {
        int widthPx = bannerAdSize.getWidthPx(this.B);
        int heightPx = bannerAdSize.getHeightPx(this.B);
        int V = bannerAdSize.V(this.B);
        int Code2 = bannerAdSize.Code(this.B);
        gl.Code(Code, "set advanced size width: %s height: %s reqW %s reqH %s", Integer.valueOf(widthPx), Integer.valueOf(heightPx), Integer.valueOf(V), Integer.valueOf(Code2));
        if (widthPx <= 0 || heightPx <= 0 || V <= 0 || Code2 <= 0) {
            this.Z.setBannerSize(b.B);
        } else {
            this.Z.setBannerSize(new b(widthPx, heightPx, V, Code2));
        }
    }

    private void V(int i10) {
        AdListener adListener = this.V;
        if (adListener != null) {
            adListener.onAdFailed(i10);
        }
    }

    private void V(AdParam adParam) {
        PPSBannerView pPSBannerView;
        if (adParam == null || (pPSBannerView = this.Z) == null) {
            return;
        }
        pPSBannerView.setRequestOptions(adParam.V());
        this.Z.setLocation(adParam.Code());
        this.Z.setContentBundle(adParam.C());
        HiAd.getInstance(this.B).setCountryCode(adParam.Z());
        this.Z.setTargetingInfo(new com.huawei.openalliance.ad.inter.data.t(adParam.getKeywords(), adParam.getGender(), adParam.getTargetingContentUrl(), adParam.I()));
    }

    private void V(BannerAdSize bannerAdSize) {
        this.Z.setBannerSize(new b(bannerAdSize.getWidthPx(this.B), bannerAdSize.getHeightPx(this.B)));
    }

    @Override // com.huawei.hms.ads.q
    public String B() {
        return this.Z.getAdId();
    }

    @Override // com.huawei.hms.ads.q
    public AdListener C() {
        return this.V;
    }

    @Override // com.huawei.hms.ads.q
    public void Code() {
        this.Z.V();
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.c
    public void Code(int i10) {
        V(dx.Code(i10));
    }

    @Override // com.huawei.hms.ads.q
    public void Code(long j10) {
        this.Z.setBannerRefresh(j10);
    }

    @Override // com.huawei.hms.ads.q
    public void Code(AdListener adListener) {
        this.V = adListener;
        this.Z.setAdListener(this);
        this.Z.setOnBannerAdStatusTrackingListener(this);
    }

    @Override // com.huawei.hms.ads.q
    public void Code(AdParam adParam) {
        String str = Code;
        gl.V(str, "load banner ");
        if (BannerAdSize.BANNER_SIZE_INVALID.equals(this.I)) {
            gl.Code(str, "invalid ad size");
            V(1);
        } else if (TextUtils.isEmpty(this.Z.getAdId())) {
            V(1);
            gl.V(str, " ad id is empty.");
        } else {
            j.Code().Code(this.B);
            V(adParam);
            this.Z.Code();
        }
    }

    @Override // com.huawei.hms.ads.q
    public void Code(BannerAdSize bannerAdSize) {
        PPSBannerView pPSBannerView;
        Integer num;
        if (bannerAdSize == null) {
            gl.I(Code, "invalid para.");
            return;
        }
        gl.V(Code, "setBannerAdSize width: %s  height: %s", Integer.valueOf(bannerAdSize.getWidth()), Integer.valueOf(bannerAdSize.getHeight()));
        this.I = bannerAdSize;
        if (BannerAdSize.BANNER_SIZE_DYNAMIC.equals(bannerAdSize) || BannerAdSize.BANNER_SIZE_SMART.equals(bannerAdSize)) {
            V(BannerAdSize.BANNER_SIZE_SMART);
            pPSBannerView = this.Z;
            num = com.huawei.openalliance.ad.constant.u.aJ;
        } else {
            BannerAdSize bannerAdSize2 = BannerAdSize.BANNER_SIZE_INVALID;
            if (bannerAdSize2.equals(bannerAdSize)) {
                this.I = bannerAdSize2;
                return;
            } else {
                I(bannerAdSize);
                pPSBannerView = this.Z;
                num = com.huawei.openalliance.ad.constant.u.aK;
            }
        }
        pPSBannerView.setIsSmart(num);
    }

    @Override // com.huawei.hms.ads.q
    public void Code(BannerView bannerView) {
        ViewGroup.LayoutParams layoutParams;
        if (bannerView == null || !AdSize.AD_SIZE_SMART.equals(this.I) || (layoutParams = bannerView.getLayoutParams()) == null) {
            return;
        }
        String str = Code;
        gl.Code(str, "layoutParams width: %s height: ", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        if (layoutParams.width >= 0 || layoutParams.height >= 0) {
            gl.I(str, "Smart banner is not suitable for fixed AdView.");
            this.Z.setAdContainerSizeMatched(false);
        }
    }

    @Override // com.huawei.hms.ads.q
    public void Code(RewardVerifyConfig rewardVerifyConfig) {
        this.Z.setRewardVerifyConfig(rewardVerifyConfig);
    }

    @Override // com.huawei.hms.ads.q
    public void Code(String str) {
        this.Z.setAdId(str);
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.m
    public void D() {
        AdListener adListener = this.V;
        if (adListener != null) {
            adListener.onAdClicked();
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.c
    public void F() {
        AdListener adListener = this.V;
        if (adListener != null) {
            adListener.onAdLoaded();
        }
    }

    @Override // com.huawei.hms.ads.q
    public void I() {
        this.Z.Z();
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.m
    public void L() {
        AdListener adListener = this.V;
        if (adListener != null) {
            adListener.onAdOpened();
        }
    }

    @Override // com.huawei.hms.ads.q
    public boolean S() {
        return this.Z.C();
    }

    @Override // com.huawei.hms.ads.q
    public void V() {
        this.Z.I();
    }

    @Override // com.huawei.hms.ads.q
    public void V(String str) {
        this.Z.setContentBundle(str);
    }

    @Override // com.huawei.hms.ads.q
    public BannerAdSize Z() {
        return this.I;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.m
    public void a() {
        AdListener adListener = this.V;
        if (adListener != null) {
            adListener.onAdLeave();
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.c, com.huawei.openalliance.ad.inter.listeners.m
    public void b() {
        AdListener adListener = this.V;
        if (adListener != null) {
            adListener.onAdClosed();
        }
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.m
    public void c() {
        AdListener adListener = this.V;
        if (adListener != null) {
            adListener.onAdImpression();
        }
    }
}
