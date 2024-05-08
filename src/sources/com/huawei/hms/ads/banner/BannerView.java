package com.huawei.hms.ads.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.k;
import com.huawei.hms.ads.q;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.views.PPSBannerView;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BannerView extends FrameLayout implements IBannerView {
    private static final String Code = BannerView.class.getSimpleName();
    private q I;
    private PPSBannerView V;

    @GlobalApi
    public BannerView(Context context) {
        super(context);
        Code(context);
    }

    @GlobalApi
    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
        Code(attributeSet);
    }

    @GlobalApi
    public BannerView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Code(context);
        Code(attributeSet);
    }

    private void Code(Context context) {
        this.V = new PPSBannerView(context);
        addView(this.V, new FrameLayout.LayoutParams(-2, -2));
        this.I = new k(context, this.V);
    }

    private void Code(AttributeSet attributeSet) {
        String str;
        String str2;
        String str3 = Code;
        gl.Code(str3, "initDefAttr");
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BannerView);
        try {
            if (obtainStyledAttributes != null) {
                try {
                    String string = obtainStyledAttributes.getString(R.styleable.BannerView_adId);
                    if (string != null && !string.isEmpty()) {
                        this.I.Code(string);
                    }
                    String string2 = obtainStyledAttributes.getString(R.styleable.BannerView_bannerSize);
                    if (string2 != null && !string2.isEmpty()) {
                        gl.Code(str3, "AdSize:%s", string2);
                        Code(string2);
                    }
                } catch (RuntimeException e2) {
                    str = Code;
                    str2 = "initDefAttr " + e2.getClass().getSimpleName();
                    gl.I(str, str2);
                    obtainStyledAttributes.recycle();
                } catch (Throwable th) {
                    str = Code;
                    str2 = "initDefAttr " + th.getClass().getSimpleName();
                    gl.I(str, str2);
                    obtainStyledAttributes.recycle();
                }
                obtainStyledAttributes.recycle();
            }
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:36:0x008e. Please report as an issue. */
    private void Code(String str) {
        q qVar;
        BannerAdSize bannerAdSize;
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -2009976458:
                if (str.equals("BANNER_SIZE_300_250")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1952719272:
                if (str.equals("BANNER_SIZE_320_100")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1918932275:
                if (str.equals("BANNER_SIZE_ADVANCED")) {
                    c4 = 2;
                    break;
                }
                break;
            case -1838202540:
                if (str.equals("BANNER_SIZE_360_144")) {
                    c4 = 3;
                    break;
                }
                break;
            case 681762071:
                if (str.equals("BANNER_SIZE_160_600")) {
                    c4 = 4;
                    break;
                }
                break;
            case 783647454:
                if (str.equals("BANNER_SIZE_SMART")) {
                    c4 = 5;
                    break;
                }
                break;
            case 1393317908:
                if (str.equals("BANNER_SIZE_DYNAMIC")) {
                    c4 = 6;
                    break;
                }
                break;
            case 1876671828:
                if (str.equals("BANNER_SIZE_320_50")) {
                    c4 = 7;
                    break;
                }
                break;
            case 1880365919:
                if (str.equals("BANNER_SIZE_360_57")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 1909233422:
                if (str.equals("BANNER_SIZE_468_60")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 1991426884:
                if (str.equals("BANNER_SIZE_728_90")) {
                    c4 = '\n';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_300_250;
                qVar.Code(bannerAdSize);
                return;
            case 1:
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_320_100;
                qVar.Code(bannerAdSize);
                return;
            case 2:
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_ADVANCED;
                qVar.Code(bannerAdSize);
                return;
            case 3:
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_360_144;
                qVar.Code(bannerAdSize);
                return;
            case 4:
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_160_600;
                qVar.Code(bannerAdSize);
                return;
            case 5:
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_SMART;
                qVar.Code(bannerAdSize);
                return;
            case 6:
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_DYNAMIC;
                qVar.Code(bannerAdSize);
                return;
            case 7:
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_320_50;
                qVar.Code(bannerAdSize);
                return;
            case '\b':
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_360_57;
                qVar.Code(bannerAdSize);
                return;
            case '\t':
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_468_60;
                qVar.Code(bannerAdSize);
                return;
            case '\n':
                qVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_728_90;
                qVar.Code(bannerAdSize);
                return;
            default:
                return;
        }
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void destroy() {
        this.V.S();
        this.I.Code();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public String getAdId() {
        return this.I.B();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public AdListener getAdListener() {
        return this.I.C();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public BannerAdSize getBannerAdSize() {
        return this.I.Z();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public boolean isLoading() {
        return this.I.S();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void loadAd(AdParam adParam) {
        this.I.Code(adParam);
        this.I.Code(this);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void pause() {
        this.I.V();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void resume() {
        this.I.I();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setAdId(String str) {
        this.I.Code(str);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setAdListener(AdListener adListener) {
        this.I.Code(adListener);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setBannerAdSize(BannerAdSize bannerAdSize) {
        this.I.Code(bannerAdSize);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setBannerRefresh(long j10) {
        this.I.Code(j10);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setContentBundle(String str) {
        this.I.V(str);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.I.Code(rewardVerifyConfig);
    }
}
