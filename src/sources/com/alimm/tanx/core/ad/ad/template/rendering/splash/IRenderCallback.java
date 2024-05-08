package com.alimm.tanx.core.ad.ad.template.rendering.splash;

import android.content.Context;
import com.alimm.tanx.core.ad.bean.BidInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IRenderCallback {
    void onAdClicked(boolean z10, BidInfo bidInfo, long j10, Context context, boolean z11, int i10);

    void onAdClosed(boolean z10, BidInfo bidInfo, long j10);

    void onAdFinished(boolean z10, BidInfo bidInfo, long j10);

    void onAdShowError(int i10);

    void onAdShowException(boolean z10, String str);

    void onAdStarted(boolean z10, BidInfo bidInfo);

    void requestCloseAd(boolean z10, int i10);
}
