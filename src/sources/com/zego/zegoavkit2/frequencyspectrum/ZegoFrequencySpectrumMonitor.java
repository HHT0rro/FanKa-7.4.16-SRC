package com.zego.zegoavkit2.frequencyspectrum;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoFrequencySpectrumMonitor {
    private static ZegoFrequencySpectrumMonitor sInstance;
    private ZegoFrequencySpectrumJNI mJniInstance = new ZegoFrequencySpectrumJNI();

    private ZegoFrequencySpectrumMonitor() {
    }

    public static ZegoFrequencySpectrumMonitor getInstance() {
        if (sInstance == null) {
            synchronized (ZegoFrequencySpectrumMonitor.class) {
                if (sInstance == null) {
                    sInstance = new ZegoFrequencySpectrumMonitor();
                }
            }
        }
        return sInstance;
    }

    public void setCallback(IZegoFrequencySpectrumCallback iZegoFrequencySpectrumCallback) {
        this.mJniInstance.setCallback(iZegoFrequencySpectrumCallback);
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
