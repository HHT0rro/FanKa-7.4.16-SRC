package com.zego.zegoavkit2.peertopeerlatencyprobe;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ZegoPeerToPeerLatencyProbeJNI {
    private static volatile IZegoPeerToPeerLatencyProbeCallback sCallback;

    public static native void enablePeerToPeerLatencyProbe(boolean z10, int i10);

    public static void onPeerToPeerLatencyProbeResult(String str, int i10) {
        IZegoPeerToPeerLatencyProbeCallback iZegoPeerToPeerLatencyProbeCallback = sCallback;
        if (iZegoPeerToPeerLatencyProbeCallback != null) {
            iZegoPeerToPeerLatencyProbeCallback.onPeerToPeerLatencyProbeResult(str, i10);
        }
    }

    public static void setCallback(IZegoPeerToPeerLatencyProbeCallback iZegoPeerToPeerLatencyProbeCallback) {
        sCallback = iZegoPeerToPeerLatencyProbeCallback;
        if (iZegoPeerToPeerLatencyProbeCallback != null) {
            setPeerToPeerLatencyProbeCallback(true);
        } else {
            setPeerToPeerLatencyProbeCallback(false);
        }
    }

    private static native void setPeerToPeerLatencyProbeCallback(boolean z10);

    public static native void setPeerToPeerLatencyProbeInterval(int i10, int i11);
}
