package com.baidu.mobads.sdk.api;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface CPUDramaListener {
    void onADExposed(CPUAdType cPUAdType);

    void onADExposureFailed(CPUAdType cPUAdType);

    void onAdClick(CPUAdType cPUAdType);

    void onContentFailed(int i10, String str);

    void onContentLoaded();

    void onVideoCollect(CPUDramaResponse cPUDramaResponse);

    void onVideoPlay(CPUDramaResponse cPUDramaResponse);
}
