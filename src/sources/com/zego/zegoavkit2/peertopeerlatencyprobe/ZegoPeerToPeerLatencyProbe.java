package com.zego.zegoavkit2.peertopeerlatencyprobe;

import android.os.Handler;
import android.os.Looper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoPeerToPeerLatencyProbe {
    private static volatile ZegoPeerToPeerLatencyProbe sInstance;
    private volatile IZegoPeerToPeerLatencyProbeCallback mZegoPeerToPeerLatencyProbeCallback;

    public static ZegoPeerToPeerLatencyProbe getInstance() {
        if (sInstance == null) {
            synchronized (ZegoPeerToPeerLatencyProbe.class) {
                if (sInstance == null) {
                    sInstance = new ZegoPeerToPeerLatencyProbe();
                }
            }
        }
        return sInstance;
    }

    public void enablePeerToPeerLatencyProbe(boolean z10, int i10) {
        ZegoPeerToPeerLatencyProbeJNI.enablePeerToPeerLatencyProbe(z10, i10);
    }

    public void setPeerToPeerLatencyProbeInterval(int i10, int i11) {
        ZegoPeerToPeerLatencyProbeJNI.setPeerToPeerLatencyProbeInterval(i10, i11);
    }

    public void setZegoPeerToPeerLatencyProbeCallback(IZegoPeerToPeerLatencyProbeCallback iZegoPeerToPeerLatencyProbeCallback) {
        this.mZegoPeerToPeerLatencyProbeCallback = iZegoPeerToPeerLatencyProbeCallback;
        if (iZegoPeerToPeerLatencyProbeCallback != null) {
            ZegoPeerToPeerLatencyProbeJNI.setCallback(new IZegoPeerToPeerLatencyProbeCallback() { // from class: com.zego.zegoavkit2.peertopeerlatencyprobe.ZegoPeerToPeerLatencyProbe.1
                @Override // com.zego.zegoavkit2.peertopeerlatencyprobe.IZegoPeerToPeerLatencyProbeCallback
                public void onPeerToPeerLatencyProbeResult(final String str, final int i10) {
                    final IZegoPeerToPeerLatencyProbeCallback iZegoPeerToPeerLatencyProbeCallback2 = ZegoPeerToPeerLatencyProbe.this.mZegoPeerToPeerLatencyProbeCallback;
                    if (iZegoPeerToPeerLatencyProbeCallback2 != null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.peertopeerlatencyprobe.ZegoPeerToPeerLatencyProbe.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                iZegoPeerToPeerLatencyProbeCallback2.onPeerToPeerLatencyProbeResult(str, i10);
                            }
                        });
                    }
                }
            });
        } else {
            ZegoPeerToPeerLatencyProbeJNI.setCallback(null);
        }
    }
}
