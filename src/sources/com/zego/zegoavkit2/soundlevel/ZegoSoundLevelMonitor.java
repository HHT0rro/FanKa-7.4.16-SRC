package com.zego.zegoavkit2.soundlevel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoSoundLevelMonitor {
    private static ZegoSoundLevelMonitor sInstance;
    private ZegoSoundLevelJNI mJniInstance = new ZegoSoundLevelJNI();

    private ZegoSoundLevelMonitor() {
    }

    public static ZegoSoundLevelMonitor getInstance() {
        if (sInstance == null) {
            synchronized (ZegoSoundLevelMonitor.class) {
                if (sInstance == null) {
                    sInstance = new ZegoSoundLevelMonitor();
                }
            }
        }
        return sInstance;
    }

    public boolean enableVAD(boolean z10) {
        return this.mJniInstance.enableVAD(z10);
    }

    public void setCallback(IZegoSoundLevelCallback iZegoSoundLevelCallback) {
        this.mJniInstance.setCallback(iZegoSoundLevelCallback);
    }

    public boolean setCycle(int i10) {
        return this.mJniInstance.setCycle(i10);
    }

    public synchronized boolean start() {
        return this.mJniInstance.start();
    }

    public synchronized boolean stop() {
        return this.mJniInstance.stop();
    }
}
