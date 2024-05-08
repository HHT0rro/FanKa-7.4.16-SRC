package com.wangmai.common.nativepot;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WMVideoOption {
    public boolean isAutoPlay;
    public boolean isSilence;

    public boolean isAutoPlay() {
        return this.isAutoPlay;
    }

    public boolean isSilence() {
        return this.isSilence;
    }

    public WMVideoOption setAutoPlay(boolean z10) {
        this.isAutoPlay = z10;
        return this;
    }

    public WMVideoOption setSilence(boolean z10) {
        this.isSilence = z10;
        return this;
    }
}
