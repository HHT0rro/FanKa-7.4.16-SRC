package com.huawei.hms.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kp;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.g;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ac;
import com.huawei.openalliance.ad.views.PPSSplashView;
import java.util.List;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SplashView extends PPSSplashView {
    private SplashAdDisplayListener D;
    private SplashAdLoadListener F;

    @GlobalApi
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static abstract class SplashAdLoadListener {
        @GlobalApi
        public void onAdDismissed() {
        }

        @GlobalApi
        public void onAdFailedToLoad(int i10) {
        }

        @GlobalApi
        public void onAdLoaded() {
        }
    }

    @GlobalApi
    public SplashView(Context context) {
        super(context);
    }

    @GlobalApi
    public SplashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @GlobalApi
    public SplashView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    private void Z() {
        Integer F;
        if (isLoading()) {
            SplashAdLoadListener splashAdLoadListener = this.F;
            if (splashAdLoadListener != null) {
                splashAdLoadListener.onAdFailedToLoad(4);
                return;
            }
            return;
        }
        kp splashPresenter = getSplashPresenter();
        if (splashPresenter.V()) {
            AdSlotParam adSlotParam = getAdSlotParam();
            if (!splashPresenter.B() || adSlotParam == null || (F = adSlotParam.F()) == null || F.intValue() != 0) {
                if (adSlotParam != null) {
                    ac.Code(getContext().getApplicationContext(), adSlotParam.B());
                }
                getSplashPresenter().Code();
            } else {
                List<String> Code = adSlotParam.Code();
                splashPresenter.Code(aa.Code(Code) ? null : Code.get(0), 1);
                splashPresenter.C();
            }
        }
    }

    private void setAdLoadListener(SplashAdLoadListener splashAdLoadListener) {
        this.F = splashAdLoadListener;
        getSplashPresenter().Code(splashAdLoadListener);
        if (getAdMediator() != null) {
            getAdMediator().Code(splashAdLoadListener);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.lo
    public void Code(int i10) {
        super.Code(i10);
        getAdMediator().Code(this.F);
        getAdMediator().Code(this.D);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.lz
    @GlobalApi
    public void destroyView() {
        super.destroyView();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public boolean isLoaded() {
        return super.isLoaded();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public boolean isLoading() {
        return super.isLoading();
    }

    @GlobalApi
    public void load(String str, int i10, AdParam adParam, SplashAdLoadListener splashAdLoadListener) {
        this.C = System.currentTimeMillis();
        gl.V("SplashView", g.Code);
        setAdLoadListener(splashAdLoadListener);
        AdSlotParam.a aVar = new AdSlotParam.a();
        SplashAd.Code(getContext(), str, i10, adParam, aVar);
        super.setAdSlotParam(aVar.S());
        Z();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.lz
    @GlobalApi
    public void pauseView() {
        super.pauseView();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.lz
    @GlobalApi
    public void resumeView() {
        super.resumeView();
    }

    @GlobalApi
    public void setAdDisplayListener(SplashAdDisplayListener splashAdDisplayListener) {
        this.D = splashAdDisplayListener;
        if (getAdMediator() != null) {
            getAdMediator().Code(this.D);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setAudioFocusType(int i10) {
        super.setAudioFocusType(i10);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setLogo(View view) {
        super.setLogo(view);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setLogo(View view, int i10) {
        super.setLogo(view, i10);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setLogoBitmap(Bitmap bitmap) {
        super.setLogoBitmap(bitmap);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setLogoResId(int i10) {
        super.setLogoResId(i10);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setMediaNameResId(int i10) {
        super.setMediaNameResId(i10);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setMediaNameString(String str) {
        super.setMediaNameString(str);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        super.setRewardVerifyConfig(rewardVerifyConfig);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setSloganResId(int i10) {
        super.setSloganResId(i10);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setSloganView(View view) {
        super.setSloganView(view);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setWideSloganResId(int i10) {
        super.setWideSloganResId(i10);
    }
}
