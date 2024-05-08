package com.zego.zegoavkit2.networkprobe;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoNetWorkProbe {
    private static ZegoNetWorkProbe sInstance;
    private ZegoNetWorkProbeJNI mJniInstance = new ZegoNetWorkProbeJNI();

    private ZegoNetWorkProbe() {
    }

    public static ZegoNetWorkProbe getInstance() {
        if (sInstance == null) {
            synchronized (ZegoNetWorkProbe.class) {
                if (sInstance == null) {
                    sInstance = new ZegoNetWorkProbe();
                }
            }
        }
        return sInstance;
    }

    public void setNetWorkProbeCallback(IZegoNetWorkProbeCallback iZegoNetWorkProbeCallback) {
        ZegoNetWorkProbeJNI.setNetWorkProbeCallback(iZegoNetWorkProbeCallback);
    }

    public void setQualityCallbackInterval(int i10) {
        ZegoNetWorkProbeJNI.setQualityCallbackInterval(i10);
    }

    public void startConnectivityTest() {
        ZegoNetWorkProbeJNI.startConnectivityTest();
    }

    public void startDownlinkSpeedTest(int i10) {
        ZegoNetWorkProbeJNI.startDownlinkSpeedTest(i10);
    }

    public void startUplinkSpeedTest(int i10) {
        ZegoNetWorkProbeJNI.startUplinkSpeedTest(i10);
    }

    public void stopConnectivityTest() {
        ZegoNetWorkProbeJNI.stopConnectivityTest();
    }

    public void stopDownlinkSpeedTest() {
        ZegoNetWorkProbeJNI.stopDownlinkSpeedTest();
    }

    public void stopUplinkSpeedTest() {
        ZegoNetWorkProbeJNI.stopUplinkSpeedTest();
    }
}
