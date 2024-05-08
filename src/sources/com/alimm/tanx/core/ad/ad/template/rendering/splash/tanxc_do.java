package com.alimm.tanx.core.ad.ad.template.rendering.splash;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ut.impl.TanxSplashUt;
import com.alimm.tanx.core.utils.LogUtils;

/* compiled from: BaseAdRenderer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class tanxc_do extends Handler {
    public IRenderCallback tanxc_char;
    public Context tanxc_do;
    public ITanxSplashInteractionListener tanxc_else;
    public BidInfo tanxc_for;
    public com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do tanxc_goto;
    public TanxSplashAdView tanxc_if;
    public ITanxAd tanxc_int;
    public ITanxSplashExpressAd tanxc_long;
    public boolean tanxc_new;
    public long tanxc_try;
    public boolean tanxc_byte = false;
    public boolean tanxc_case = false;
    public boolean tanxc_this = false;
    public boolean tanxc_void = false;
    public boolean tanxc_break = false;
    public boolean tanxc_catch = false;

    public tanxc_do(@NonNull IRenderCallback iRenderCallback, @NonNull Context context, @NonNull TanxSplashAdView tanxSplashAdView, @NonNull ITanxAd iTanxAd, boolean z10) {
        if (iTanxAd == null || iTanxAd.getBidInfo() == null) {
            return;
        }
        this.tanxc_char = iRenderCallback;
        this.tanxc_do = context;
        this.tanxc_if = tanxSplashAdView;
        this.tanxc_int = iTanxAd;
        BidInfo bidInfo = iTanxAd.getBidInfo();
        this.tanxc_for = bidInfo;
        this.tanxc_new = z10;
        if (bidInfo != null && bidInfo.getInteractType2Shake()) {
            this.tanxc_goto = new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_for(this, context, tanxSplashAdView, iTanxAd);
        } else {
            this.tanxc_goto = new com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if(this, context, tanxSplashAdView, iTanxAd);
        }
        LogUtils.d("BaseAdRenderer", "BaseAdRenderer:, mTemplate = " + ((Object) this.tanxc_goto) + ", rootView = " + ((Object) tanxSplashAdView));
    }

    private void tanxc_class() {
        LogUtils.d("BaseAdRenderer", "checkAdFinished: mContentShowComplete = " + this.tanxc_void + ", mCountDownFinished = " + this.tanxc_break);
        if (this.tanxc_void && this.tanxc_break) {
            this.tanxc_goto.tanxc_if();
        }
    }

    public void tanxc_break() {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do tanxc_doVar = this.tanxc_goto;
        if (tanxc_doVar != null) {
            tanxc_doVar.tanxc_this();
        }
    }

    public void tanxc_byte() {
        LogUtils.d("BaseAdRenderer", "resume: timerPause = " + this.tanxc_case);
        if (this.tanxc_case) {
            this.tanxc_goto.tanxc_int();
            this.tanxc_case = false;
        }
    }

    public void tanxc_case() {
        LogUtils.d("BaseAdRenderer", "stop: mIsStopped = " + this.tanxc_byte);
        if (this.tanxc_byte) {
            return;
        }
        this.tanxc_byte = true;
        tanxc_char();
    }

    public void tanxc_catch() {
        BidInfo bidInfo = this.tanxc_for;
        if (bidInfo != null) {
            if (TextUtils.isEmpty(bidInfo.getDeepLinkUrl()) && TextUtils.isEmpty(this.tanxc_for.getClickThroughUrl())) {
                tanxc_do(tanxc_goto(), 4);
                tanxc_do(tanxc_long(), 4);
            } else {
                tanxc_do(tanxc_goto(), 0);
                tanxc_do(tanxc_long(), 0);
            }
            if (TextUtils.isEmpty(this.tanxc_for.getAdvLogo())) {
                return;
            }
            tanxc_do(tanxc_void(), 0);
        }
    }

    public void tanxc_char() {
        LogUtils.d("BaseAdRenderer", "dispose: type = " + this.tanxc_new + ", this = " + ((Object) this));
        this.tanxc_catch = false;
        this.tanxc_goto.tanxc_new();
    }

    public void tanxc_do() {
        tanxc_if();
    }

    public void tanxc_else() {
        if (this.tanxc_this) {
            return;
        }
        this.tanxc_this = true;
        IRenderCallback iRenderCallback = this.tanxc_char;
        if (iRenderCallback != null) {
            iRenderCallback.onAdFinished(this.tanxc_new, this.tanxc_for, SystemClock.elapsedRealtime() - this.tanxc_try);
        }
    }

    public void tanxc_for() {
        LogUtils.d("BaseAdRenderer", "tanx_splash: ======= onContentShowStart ======" + System.currentTimeMillis());
        this.tanxc_catch = true;
        this.tanxc_goto.tanxc_do();
        IRenderCallback iRenderCallback = this.tanxc_char;
        if (iRenderCallback != null) {
            iRenderCallback.onAdStarted(this.tanxc_new, this.tanxc_for);
        }
        ITanxSplashExpressAd iTanxSplashExpressAd = this.tanxc_long;
        if (iTanxSplashExpressAd != null) {
            TanxSplashUt.utSplashViewCreate(iTanxSplashExpressAd, iTanxSplashExpressAd.getFromType(), true, 0);
        }
    }

    public View tanxc_goto() {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do tanxc_doVar = this.tanxc_goto;
        if (tanxc_doVar != null) {
            return tanxc_doVar.tanxc_else();
        }
        return null;
    }

    public void tanxc_if() {
        LogUtils.d("BaseAdRenderer", "doStart()");
    }

    public void tanxc_int() {
        this.tanxc_void = true;
        tanxc_class();
    }

    public View tanxc_long() {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do tanxc_doVar = this.tanxc_goto;
        if (tanxc_doVar != null) {
            return tanxc_doVar.tanxc_char();
        }
        return null;
    }

    public void tanxc_new() {
        this.tanxc_break = true;
        tanxc_class();
    }

    public View tanxc_this() {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do tanxc_doVar = this.tanxc_goto;
        if (tanxc_doVar != null) {
            return tanxc_doVar.tanxc_goto();
        }
        return null;
    }

    public void tanxc_try() {
        LogUtils.d("BaseAdRenderer", "pause: timerPause = " + this.tanxc_case);
        if (this.tanxc_case) {
            return;
        }
        this.tanxc_goto.tanxc_for();
        this.tanxc_case = true;
    }

    public View tanxc_void() {
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do tanxc_doVar = this.tanxc_goto;
        if (tanxc_doVar != null) {
            return tanxc_doVar.tanxc_long();
        }
        return null;
    }

    public void tanxc_do(int i10, String str) {
        ITanxSplashExpressAd iTanxSplashExpressAd = this.tanxc_long;
        if (iTanxSplashExpressAd != null) {
            TanxSplashUt.utSplashViewCreate(iTanxSplashExpressAd, iTanxSplashExpressAd.getFromType(), false, i10, str);
        }
        tanxc_char();
        IRenderCallback iRenderCallback = this.tanxc_char;
        if (iRenderCallback != null) {
            iRenderCallback.onAdShowError(i10);
        }
    }

    public void tanxc_do(int i10) {
        tanxc_do(i10, "");
    }

    public void tanxc_do(ITanxSplashExpressAd iTanxSplashExpressAd) {
        this.tanxc_long = iTanxSplashExpressAd;
    }

    public void tanxc_do(ITanxSplashInteractionListener iTanxSplashInteractionListener) {
        this.tanxc_else = iTanxSplashInteractionListener;
        com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do tanxc_doVar = this.tanxc_goto;
        if (tanxc_doVar == null || !(tanxc_doVar instanceof com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if)) {
            return;
        }
        ((com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if) tanxc_doVar).tanxc_do(iTanxSplashInteractionListener);
    }

    private void tanxc_do(View view, int i10) {
        if (view != null) {
            view.setVisibility(i10);
        }
    }
}
