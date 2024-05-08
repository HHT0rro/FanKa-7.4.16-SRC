package com.zego.zegoavkit2.networkprobe;

import android.os.Handler;
import android.os.Looper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ZegoNetWorkProbeJNI {
    private static volatile IZegoNetWorkProbeCallback mNetWorkProbeCallback;

    private static native void enableNetWorkProbeCallback(boolean z10);

    public static void onConnectResult(final int i10, final ZegoNetConnectInfo zegoNetConnectInfo, final int i11) {
        final IZegoNetWorkProbeCallback iZegoNetWorkProbeCallback = mNetWorkProbeCallback;
        if (iZegoNetWorkProbeCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.networkprobe.ZegoNetWorkProbeJNI.1
                @Override // java.lang.Runnable
                public void run() {
                    IZegoNetWorkProbeCallback iZegoNetWorkProbeCallback2 = IZegoNetWorkProbeCallback.this;
                    if (iZegoNetWorkProbeCallback2 != null) {
                        iZegoNetWorkProbeCallback2.onConnectResult(i10, zegoNetConnectInfo, i11);
                    }
                }
            });
        }
    }

    public static void onTestStop(final int i10, final int i11) {
        final IZegoNetWorkProbeCallback iZegoNetWorkProbeCallback = mNetWorkProbeCallback;
        if (iZegoNetWorkProbeCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.networkprobe.ZegoNetWorkProbeJNI.3
                @Override // java.lang.Runnable
                public void run() {
                    IZegoNetWorkProbeCallback iZegoNetWorkProbeCallback2 = IZegoNetWorkProbeCallback.this;
                    if (iZegoNetWorkProbeCallback2 != null) {
                        iZegoNetWorkProbeCallback2.onTestStop(i10, i11);
                    }
                }
            });
        }
    }

    public static void onUpdateSpeed(final ZegoNetQualityInfo zegoNetQualityInfo, final int i10) {
        final IZegoNetWorkProbeCallback iZegoNetWorkProbeCallback = mNetWorkProbeCallback;
        if (iZegoNetWorkProbeCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.networkprobe.ZegoNetWorkProbeJNI.2
                @Override // java.lang.Runnable
                public void run() {
                    IZegoNetWorkProbeCallback iZegoNetWorkProbeCallback2 = IZegoNetWorkProbeCallback.this;
                    if (iZegoNetWorkProbeCallback2 != null) {
                        iZegoNetWorkProbeCallback2.onUpdateSpeed(zegoNetQualityInfo, i10);
                    }
                }
            });
        }
    }

    public static void setNetWorkProbeCallback(IZegoNetWorkProbeCallback iZegoNetWorkProbeCallback) {
        mNetWorkProbeCallback = iZegoNetWorkProbeCallback;
        enableNetWorkProbeCallback(iZegoNetWorkProbeCallback != null);
    }

    public static native void setQualityCallbackInterval(int i10);

    public static native void startConnectivityTest();

    public static native void startDownlinkSpeedTest(int i10);

    public static native void startUplinkSpeedTest(int i10);

    public static native void stopConnectivityTest();

    public static native void stopDownlinkSpeedTest();

    public static native void stopUplinkSpeedTest();
}
