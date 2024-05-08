package com.zego.zegoavkit2.audioplayer;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class ZegoAudioPlayerJNI {
    private static Lock mCallbackLock = new ReentrantLock();
    private static volatile IZegoAudioPlayerCallback mCallback = null;

    public static native void createAudioPlayer();

    public static native void destroyAudioPlayer();

    public static native long getCurrentDuration(int i10);

    public static native long getDuration(int i10);

    public static void onPlayEffect(final int i10, final int i11) {
        mCallbackLock.lock();
        if (mCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.audioplayer.ZegoAudioPlayerJNI.1
                @Override // java.lang.Runnable
                public void run() {
                    ZegoAudioPlayerJNI.mCallbackLock.lock();
                    if (ZegoAudioPlayerJNI.mCallback != null) {
                        ZegoAudioPlayerJNI.mCallback.onPlayEffect(i10, i11);
                    }
                    ZegoAudioPlayerJNI.mCallbackLock.unlock();
                }
            });
        }
        mCallbackLock.unlock();
    }

    public static void onPlayEnd(final int i10) {
        mCallbackLock.lock();
        if (mCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.audioplayer.ZegoAudioPlayerJNI.3
                @Override // java.lang.Runnable
                public void run() {
                    ZegoAudioPlayerJNI.mCallbackLock.lock();
                    if (ZegoAudioPlayerJNI.mCallback != null) {
                        ZegoAudioPlayerJNI.mCallback.onPlayEnd(i10);
                    }
                    ZegoAudioPlayerJNI.mCallbackLock.unlock();
                }
            });
        }
        mCallbackLock.unlock();
    }

    public static void onPreloadComplete(final int i10) {
        mCallbackLock.lock();
        if (mCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.audioplayer.ZegoAudioPlayerJNI.4
                @Override // java.lang.Runnable
                public void run() {
                    ZegoAudioPlayerJNI.mCallbackLock.lock();
                    if (ZegoAudioPlayerJNI.mCallback != null) {
                        ZegoAudioPlayerJNI.mCallback.onPreloadComplete(i10);
                    }
                    ZegoAudioPlayerJNI.mCallbackLock.unlock();
                }
            });
        }
        mCallbackLock.unlock();
    }

    public static void onPreloadEffect(final int i10, final int i11) {
        mCallbackLock.lock();
        if (mCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.audioplayer.ZegoAudioPlayerJNI.2
                @Override // java.lang.Runnable
                public void run() {
                    ZegoAudioPlayerJNI.mCallbackLock.lock();
                    if (ZegoAudioPlayerJNI.mCallback != null) {
                        ZegoAudioPlayerJNI.mCallback.onPreloadEffect(i10, i11);
                    }
                    ZegoAudioPlayerJNI.mCallbackLock.unlock();
                }
            });
        }
        mCallbackLock.unlock();
    }

    public static native void pauseAll();

    public static native void pauseEffect(int i10);

    public static native void playEffect(String str, int i10, int i11, boolean z10);

    public static native void preloadEffect(String str, int i10);

    public static native void resumeAll();

    public static native void resumeEffect(int i10);

    public static native int seekTo(int i10, long j10);

    public static void setCallback(IZegoAudioPlayerCallback iZegoAudioPlayerCallback) {
        mCallbackLock.lock();
        mCallback = iZegoAudioPlayerCallback;
        mCallbackLock.unlock();
    }

    public static native void setPlaySpeed(int i10, float f10);

    public static native void setPlayVolume(int i10, int i11);

    public static native void setPlayVolumeAll(int i10);

    public static native void setPublishVolume(int i10, int i11);

    public static native void setPublishVolumeAll(int i10);

    public static native void setVolume(int i10, int i11);

    public static native void setVolumeAll(int i10);

    public static native void stopAll();

    public static native void stopEffect(int i10);

    public static native void unloadEffect(int i10);

    public static native void updatePosition(int i10, float[] fArr);
}
