package com.zego.zegoavkit2.networktrace;

import android.os.Handler;
import android.os.Looper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ZegoNetworktraceJNI {
    private static volatile IZegoNetworkTraceCallback mNetworkTraceCallback;

    private static native void enableNetworkTraceCallback(boolean z10);

    public static void onNetworkTrace(final long j10, final ZegoHttpTraceResult zegoHttpTraceResult, final ZegoTcpTraceResult zegoTcpTraceResult, final ZegoUdpTraceResult zegoUdpTraceResult, final ZegoTracerouteResult zegoTracerouteResult) {
        final IZegoNetworkTraceCallback iZegoNetworkTraceCallback = mNetworkTraceCallback;
        if (iZegoNetworkTraceCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.networktrace.ZegoNetworktraceJNI.1
                @Override // java.lang.Runnable
                public void run() {
                    IZegoNetworkTraceCallback iZegoNetworkTraceCallback2 = IZegoNetworkTraceCallback.this;
                    if (iZegoNetworkTraceCallback2 != null) {
                        iZegoNetworkTraceCallback2.onNetworkTrace(j10, zegoHttpTraceResult, zegoTcpTraceResult, zegoUdpTraceResult, zegoTracerouteResult);
                    }
                }
            });
        }
    }

    public static void setNetworkTraceCallback(IZegoNetworkTraceCallback iZegoNetworkTraceCallback) {
        mNetworkTraceCallback = iZegoNetworkTraceCallback;
        enableNetworkTraceCallback(iZegoNetworkTraceCallback != null);
    }

    public static native void startNetworkTrace(ZegoNetworkTraceConfig zegoNetworkTraceConfig);

    public static native void stopNetworkTrace();
}
