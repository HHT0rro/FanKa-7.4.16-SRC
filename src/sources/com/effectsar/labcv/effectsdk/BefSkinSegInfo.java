package com.effectsar.labcv.effectsdk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefSkinSegInfo {
    private int height;
    private byte[] mask;
    private int width;

    public int getHeight() {
        return this.height;
    }

    public byte[] getMask() {
        return this.mask;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return String.format("l: %d w:%d, h:%d", Integer.valueOf(this.mask.length), Integer.valueOf(this.width), Integer.valueOf(this.height));
    }
}
