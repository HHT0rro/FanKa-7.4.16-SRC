package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface TTNativeExpressAd extends TTClientBidding {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface AdInteractionListener extends ExpressAdInteractionListener {
        void onAdDismiss();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface ExpressAdInteractionListener {
        void onAdClicked(View view, int i10);

        void onAdShow(View view, int i10);

        void onRenderFail(View view, String str, int i10);

        void onRenderSuccess(View view, float f10, float f11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface ExpressVideoAdListener {
        void onClickRetry();

        void onProgressUpdate(long j10, long j11);

        void onVideoAdComplete();

        void onVideoAdContinuePlay();

        void onVideoAdPaused();

        void onVideoAdStartPlay();

        void onVideoError(int i10, int i11);

        void onVideoLoad();
    }

    void destroy();

    TTAdDislike getDislikeDialog(Activity activity);

    DislikeInfo getDislikeInfo();

    View getExpressAdView();

    int getImageMode();

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    MediationNativeManager getMediationManager();

    void render();

    void setCanInterruptVideoPlay(boolean z10);

    void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    void setDownloadListener(TTAppDownloadListener tTAppDownloadListener);

    void setExpressInteractionListener(AdInteractionListener adInteractionListener);

    void setExpressInteractionListener(ExpressAdInteractionListener expressAdInteractionListener);

    void setSlideIntervalTime(int i10);

    void setVideoAdListener(ExpressVideoAdListener expressVideoAdListener);

    void showInteractionExpressAd(Activity activity);
}
