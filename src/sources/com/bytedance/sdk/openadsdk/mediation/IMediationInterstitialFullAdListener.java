package com.bytedance.sdk.openadsdk.mediation;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IMediationInterstitialFullAdListener extends TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
    void onAdLeftApplication();

    void onAdOpened();

    void onInterstitialFullShowFail(int i10, String str);

    void onRewardVerify(Bundle bundle);

    void onVideoError();
}
