package com.zego.zegoavkit2.mediaside;

import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ZegoMediaSideInfoJNI {
    private static volatile IZegoMediaSideCallback sCallback;

    public static void onMediaSideCallback(String str, ByteBuffer byteBuffer, int i10) {
        IZegoMediaSideCallback iZegoMediaSideCallback = sCallback;
        if (iZegoMediaSideCallback != null) {
            iZegoMediaSideCallback.onRecvMediaSideInfo(str, byteBuffer, i10);
        }
    }

    public static native void sendMediaSideInfo(ByteBuffer byteBuffer, int i10, boolean z10, int i11);

    public static void setCallback(IZegoMediaSideCallback iZegoMediaSideCallback) {
        sCallback = iZegoMediaSideCallback;
        if (iZegoMediaSideCallback != null) {
            setMediaSideCallback(true);
        } else {
            setMediaSideCallback(false);
        }
    }

    private static native void setMediaSideCallback(boolean z10);

    public static native void setMediaSideFlags(boolean z10, boolean z11, int i10, int i11, int i12);
}
