package com.effectsar.labcv.effectsdk;

import com.alipay.sdk.util.i;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefVideoSRInfo {
    private int destTextureId;
    private int height;
    private int width;

    public int getDestTextureId() {
        return this.destTextureId;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setDestTextureId(int i10) {
        this.destTextureId = i10;
    }

    public void setHeight(int i10) {
        this.height = i10;
    }

    public void setWidth(int i10) {
        this.width = i10;
    }

    public String toString() {
        return "BefVideoSRInfo{width=" + this.width + ", height=" + this.height + ", destTextureID = " + this.destTextureId + i.f4738d;
    }
}
