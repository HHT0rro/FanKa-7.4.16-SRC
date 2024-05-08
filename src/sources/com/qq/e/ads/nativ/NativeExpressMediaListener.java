package com.qq.e.ads.nativ;

import com.qq.e.comm.util.AdError;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface NativeExpressMediaListener {
    void onVideoCached(NativeExpressADView nativeExpressADView);

    void onVideoComplete(NativeExpressADView nativeExpressADView);

    void onVideoError(NativeExpressADView nativeExpressADView, AdError adError);

    void onVideoInit(NativeExpressADView nativeExpressADView);

    void onVideoLoading(NativeExpressADView nativeExpressADView);

    void onVideoPageClose(NativeExpressADView nativeExpressADView);

    void onVideoPageOpen(NativeExpressADView nativeExpressADView);

    void onVideoPause(NativeExpressADView nativeExpressADView);

    void onVideoReady(NativeExpressADView nativeExpressADView, long j10);

    void onVideoStart(NativeExpressADView nativeExpressADView);
}
