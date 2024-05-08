package com.alimm.tanx.core.ad.ad.template.rendering.splash;

import android.app.Activity;
import android.content.Context;
import com.alimm.tanx.core.ad.ad.splash.ITanxSplashAd;
import com.alimm.tanx.core.ad.ad.splash.TanxSplashAd;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.constant.TanxAdType;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.ut.AdUtConstants;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.utils.LogUtils;

/* compiled from: TanxSplashExpressAd.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_new extends tanxc_if<ITanxSplashAd> implements ITanxSplashExpressAd {
    public final Context tanxc_do;
    public TanxSplashAdView tanxc_if;
    public ITanxSplashExpressAd.OnSplashAdListener tanxc_int;
    public ITanxSplashInteractionListener tanxc_new;

    public tanxc_new(Context context, ITanxSplashAd iTanxSplashAd) {
        super(iTanxSplashAd);
        this.tanxc_do = context;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd
    public int getFromType() {
        if (tanxc_if() != null) {
            return tanxc_if().fromType;
        }
        return -1;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd
    public ITanxSplashExpressAd.OnSplashAdListener getOnSplashAdListener() {
        return this.tanxc_int;
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_if, com.alimm.tanx.core.ad.ITanxAd
    public String getScene() {
        return TanxAdType.SPLASH_STRING;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    public void refresh() {
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashExpressAd
    public void setOnSplashAdListener(ITanxSplashExpressAd.OnSplashAdListener onSplashAdListener) {
        this.tanxc_int = onSplashAdListener;
    }

    @Override // com.alimm.tanx.core.ad.listener.INewTanxExpressAd
    /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
    public TanxAdView getAdView() {
        TanxCommonUt.sendIntoMethod(getAdSlot(), getRequestId(), getBidInfo(), "TanxSplashExpressAd-getAdView", AdUtConstants.INTO_METHOD);
        if (this.tanxc_if == null) {
            TanxSplashAdView tanxSplashAdView = new TanxSplashAdView((Activity) this.tanxc_do);
            this.tanxc_if = tanxSplashAdView;
            tanxSplashAdView.setTanxSplashExpressAd(this);
            this.tanxc_if.setRenderCallback(new IRenderCallback() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.1
                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
                public void onAdClicked(boolean z10, BidInfo bidInfo, long j10, Context context, boolean z11, int i10) {
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onAdClicked();
                    }
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
                public void onAdClosed(boolean z10, BidInfo bidInfo, long j10) {
                    tanxc_new.this.tanxc_if.removeAdView();
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onAdClosed();
                    }
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
                public void onAdFinished(boolean z10, BidInfo bidInfo, long j10) {
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onAdFinish();
                    }
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
                public void onAdShowError(int i10) {
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onShowError(new TanxError("错误码:" + i10));
                    }
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
                public void onAdShowException(boolean z10, String str) {
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onShowError(new TanxError(str));
                    }
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
                public void onAdStarted(boolean z10, BidInfo bidInfo) {
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.IRenderCallback
                public void requestCloseAd(boolean z10, int i10) {
                }
            });
            this.tanxc_if.startShow(getBidInfo());
            ITanxSplashInteractionListener iTanxSplashInteractionListener = new ITanxSplashInteractionListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_new.2
                @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
                public /* synthetic */ void onAdClicked(TanxAdView tanxAdView, ITanxSplashAd iTanxSplashAd) {
                    tanxc_do();
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener
                public void onAdClose() {
                    tanxc_new.this.tanxc_if.removeAdView();
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onAdClosed();
                    }
                }

                @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener
                public void onAdShake() {
                    if (tanxc_new.this.tanxc_if != null) {
                        tanxc_new.this.tanxc_if.pauseTimer();
                    }
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onAdShake();
                    }
                    tanxc_new.this.tanxc_do(null, null, true);
                }

                @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
                public /* synthetic */ void onAdShow(ITanxSplashAd iTanxSplashAd) {
                    tanxc_if();
                }

                public void tanxc_do() {
                    tanxc_new.this.tanxc_if.pauseTimer();
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onAdClicked();
                    }
                    if (tanxc_new.this.tanxc_if == null || tanxc_new.this.tanxc_if.getClickView() == null) {
                        return;
                    }
                    tanxc_new.this.tanxc_if.notifyViewClick();
                }

                public void tanxc_if() {
                    TanxCommonUt.sendIntoMethod(tanxc_new.this.getAdSlot(), tanxc_new.this.getRequestId(), tanxc_new.this.getBidInfo(), "ITanxSplashInteractionListener-onAdShow", AdUtConstants.INTO_METHOD);
                    if (tanxc_new.this.tanxc_int != null) {
                        tanxc_new.this.tanxc_int.onAdShow();
                    }
                }
            };
            this.tanxc_new = iTanxSplashInteractionListener;
            this.tanxc_if.setITanxSplashInteractionListener(iTanxSplashInteractionListener);
            ITanxSplashAd iTanxSplashAd = (ITanxSplashAd) this.tanxc_for;
            TanxSplashAdView tanxSplashAdView2 = this.tanxc_if;
            iTanxSplashAd.bindSplashAdView(tanxSplashAdView2, tanxSplashAdView2.getClickView(), this.tanxc_if.getCloseView(), this.tanxc_new);
        }
        return this.tanxc_if;
    }

    public TanxSplashAd tanxc_if() {
        T t2 = this.tanxc_for;
        if (t2 == 0 || !(t2 instanceof TanxSplashAd)) {
            return null;
        }
        return (TanxSplashAd) t2;
    }

    public void tanxc_do(String str, String str2, boolean z10) {
        T t2 = this.tanxc_for;
        if (t2 instanceof TanxSplashAd) {
            TanxSplashAdView tanxSplashAdView = this.tanxc_if;
            if (tanxSplashAdView != null) {
                ((TanxSplashAd) t2).navigateAndUt(null, tanxSplashAdView.getContext(), z10, str, str2);
            } else {
                LogUtils.e("TanxSplashExpressAd", "摇一摇时，mAdView为空");
            }
        }
    }
}
