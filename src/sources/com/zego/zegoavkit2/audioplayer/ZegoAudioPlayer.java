package com.zego.zegoavkit2.audioplayer;

import android.net.Uri;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoAudioPlayer {
    public ZegoAudioPlayer() {
        ZegoAudioPlayerJNI.createAudioPlayer();
    }

    public void destroyAudioPlayer() {
        ZegoAudioPlayerJNI.destroyAudioPlayer();
    }

    public long getCurrentDuration(int i10) {
        return ZegoAudioPlayerJNI.getCurrentDuration(i10);
    }

    public long getDuration(int i10) {
        return ZegoAudioPlayerJNI.getDuration(i10);
    }

    public void pauseAll() {
        ZegoAudioPlayerJNI.pauseAll();
    }

    public void pauseEffect(int i10) {
        ZegoAudioPlayerJNI.pauseEffect(i10);
    }

    public void playEffect(String str, int i10, int i11, boolean z10) {
        ZegoAudioPlayerJNI.playEffect(str, i10, i11, z10);
    }

    public void preloadEffect(String str, int i10) {
        ZegoAudioPlayerJNI.preloadEffect(str, i10);
    }

    public void resumeAll() {
        ZegoAudioPlayerJNI.resumeAll();
    }

    public void resumeEffect(int i10) {
        ZegoAudioPlayerJNI.resumeEffect(i10);
    }

    public int seekTo(int i10, long j10) {
        return ZegoAudioPlayerJNI.seekTo(i10, j10);
    }

    public void setCallback(IZegoAudioPlayerCallback iZegoAudioPlayerCallback) {
        ZegoAudioPlayerJNI.setCallback(iZegoAudioPlayerCallback);
    }

    public void setPlaySpeed(int i10, float f10) {
        ZegoAudioPlayerJNI.setPlaySpeed(i10, f10);
    }

    public void setPlayVolume(int i10, int i11) {
        ZegoAudioPlayerJNI.setPlayVolume(i10, i11);
    }

    public void setPlayVolumeAll(int i10) {
        ZegoAudioPlayerJNI.setPlayVolumeAll(i10);
    }

    public void setPublishVolume(int i10, int i11) {
        ZegoAudioPlayerJNI.setPublishVolume(i10, i11);
    }

    public void setPublishVolumeAll(int i10) {
        ZegoAudioPlayerJNI.setPublishVolumeAll(i10);
    }

    public void setVolume(int i10, int i11) {
        ZegoAudioPlayerJNI.setVolume(i10, i11);
    }

    public void setVolumeAll(int i10) {
        ZegoAudioPlayerJNI.setVolumeAll(i10);
    }

    public void stopAll() {
        ZegoAudioPlayerJNI.stopAll();
    }

    public void stopEffect(int i10) {
        ZegoAudioPlayerJNI.stopEffect(i10);
    }

    public void unloadEffect(int i10) {
        ZegoAudioPlayerJNI.unloadEffect(i10);
    }

    public void updatePosition(int i10, float[] fArr) {
        ZegoAudioPlayerJNI.updatePosition(i10, fArr);
    }

    public void playEffect(Uri uri, int i10, int i11, boolean z10) {
        ZegoAudioPlayerJNI.playEffect(uri != null ? uri.toString() : "", i10, i11, z10);
    }

    public void preloadEffect(Uri uri, int i10) {
        ZegoAudioPlayerJNI.preloadEffect(uri != null ? uri.toString() : "", i10);
    }
}
