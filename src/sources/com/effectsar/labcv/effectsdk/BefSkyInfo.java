package com.effectsar.labcv.effectsdk;

import com.effectsar.labcv.effectsdk.SkySegment;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefSkyInfo {
    public boolean hasSky;
    private SkySegment.SkyMask skyMask;

    public boolean getHasSky() {
        return this.hasSky;
    }

    public SkySegment.SkyMask getSkyMask() {
        return this.skyMask;
    }

    public void setHasSky(boolean z10) {
        this.hasSky = z10;
    }

    public void setSkyMask(SkySegment.SkyMask skyMask) {
        this.skyMask = skyMask;
    }

    public String toString() {
        return "BefSkyInfo{hasSky=" + this.hasSky + '}';
    }
}
