package com.zego.zegoavkit2.audioobserver;

import android.os.Handler;
import android.os.Looper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ZegoAudioObserverJNI {
    private static volatile IZegoAudioObserverCallback mAudioObserverCallback;

    private static native void enableAudioObserverCallback(boolean z10);

    public static void onAudioObserverError(final int i10) {
        final IZegoAudioObserverCallback iZegoAudioObserverCallback = mAudioObserverCallback;
        if (iZegoAudioObserverCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.audioobserver.ZegoAudioObserverJNI.1
                @Override // java.lang.Runnable
                public void run() {
                    IZegoAudioObserverCallback iZegoAudioObserverCallback2 = IZegoAudioObserverCallback.this;
                    if (iZegoAudioObserverCallback2 != null) {
                        iZegoAudioObserverCallback2.onAudioObserverError(i10);
                    }
                }
            });
        }
    }

    public static void onCapturedAudioData(byte[] bArr, int i10, int i11, int i12) {
        IZegoAudioObserverCallback iZegoAudioObserverCallback = mAudioObserverCallback;
        if (iZegoAudioObserverCallback != null) {
            iZegoAudioObserverCallback.onCapturedAudioData(bArr, i10, i11, i12);
        }
    }

    public static void onMixAudioData(byte[] bArr, int i10, int i11, int i12) {
        IZegoAudioObserverCallback iZegoAudioObserverCallback = mAudioObserverCallback;
        if (iZegoAudioObserverCallback != null) {
            iZegoAudioObserverCallback.onMixAudioData(bArr, i10, i11, i12);
        }
    }

    public static void onPlaybackAudioData(byte[] bArr, int i10, int i11, int i12) {
        IZegoAudioObserverCallback iZegoAudioObserverCallback = mAudioObserverCallback;
        if (iZegoAudioObserverCallback != null) {
            iZegoAudioObserverCallback.onPlaybackAudioData(bArr, i10, i11, i12);
        }
    }

    public static void setAudioObserverCallback(IZegoAudioObserverCallback iZegoAudioObserverCallback) {
        mAudioObserverCallback = iZegoAudioObserverCallback;
        enableAudioObserverCallback(iZegoAudioObserverCallback != null);
    }

    public static native boolean startAudioObserver(int i10, int i11, int i12);

    public static native void stopAudioObserver();
}
