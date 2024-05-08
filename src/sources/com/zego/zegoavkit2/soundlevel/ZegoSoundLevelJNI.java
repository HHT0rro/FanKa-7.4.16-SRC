package com.zego.zegoavkit2.soundlevel;

import android.os.Handler;
import android.os.Looper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ZegoSoundLevelJNI {
    private IZegoSoundLevelCallback mCallback = null;
    private Handler mHandler = null;

    public native boolean enableVAD(boolean z10);

    public void onCaptureSoundLevelUpdate(final ZegoSoundLevelInfo zegoSoundLevelInfo) {
        Handler handler = this.mHandler;
        final IZegoSoundLevelCallback iZegoSoundLevelCallback = this.mCallback;
        if (handler == null || iZegoSoundLevelCallback == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.zego.zegoavkit2.soundlevel.ZegoSoundLevelJNI.2
            @Override // java.lang.Runnable
            public void run() {
                iZegoSoundLevelCallback.onCaptureSoundLevelUpdate(zegoSoundLevelInfo);
            }
        });
    }

    public void onSoundLevelUpdate(final ZegoSoundLevelInfo[] zegoSoundLevelInfoArr) {
        Handler handler = this.mHandler;
        final IZegoSoundLevelCallback iZegoSoundLevelCallback = this.mCallback;
        if (handler == null || iZegoSoundLevelCallback == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.zego.zegoavkit2.soundlevel.ZegoSoundLevelJNI.1
            @Override // java.lang.Runnable
            public void run() {
                iZegoSoundLevelCallback.onSoundLevelUpdate(zegoSoundLevelInfoArr);
            }
        });
    }

    public void setCallback(IZegoSoundLevelCallback iZegoSoundLevelCallback) {
        this.mCallback = iZegoSoundLevelCallback;
        if (iZegoSoundLevelCallback != null) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.getMainLooper());
            }
        } else {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.mHandler = null;
            }
        }
    }

    public native boolean setCycle(int i10);

    public native boolean start();

    public native boolean stop();
}
