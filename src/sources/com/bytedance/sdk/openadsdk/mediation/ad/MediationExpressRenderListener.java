package com.bytedance.sdk.openadsdk.mediation.ad;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeAd;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface MediationExpressRenderListener extends TTNativeAd.ExpressRenderListener {
    void onAdClick();

    void onAdShow();

    void onRenderFail(View view, String str, int i10);
}
