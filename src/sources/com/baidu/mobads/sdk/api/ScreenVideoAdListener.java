package com.baidu.mobads.sdk.api;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface ScreenVideoAdListener {
    void onAdClick();

    void onAdClose(float f10);

    void onAdFailed(String str);

    void onAdLoaded();

    void onAdShow();

    void onAdSkip(float f10);

    void onVideoDownloadFailed();

    void onVideoDownloadSuccess();

    void playCompletion();
}
