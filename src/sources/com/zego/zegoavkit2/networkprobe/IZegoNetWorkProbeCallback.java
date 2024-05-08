package com.zego.zegoavkit2.networkprobe;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface IZegoNetWorkProbeCallback {
    void onConnectResult(int i10, ZegoNetConnectInfo zegoNetConnectInfo, int i11);

    void onTestStop(int i10, int i11);

    void onUpdateSpeed(ZegoNetQualityInfo zegoNetQualityInfo, int i10);
}
