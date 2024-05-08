package com.effectsar.labcv.effectsdk;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefChromaKeyingInfo {
    private byte color_b;
    private byte color_g;
    private byte color_r;
    private int height;
    private byte[] mask;
    private int outputTexture;
    private int width;

    public byte getColor_b() {
        return this.color_b;
    }

    public byte getColor_g() {
        return this.color_g;
    }

    public byte getColor_r() {
        return this.color_r;
    }

    public int getHeight() {
        return this.height;
    }

    public byte[] getMask() {
        return this.mask;
    }

    public int getOutputTexture() {
        return this.outputTexture;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return String.format("l: %d w:%d, h:%d", Integer.valueOf(this.mask.length), Integer.valueOf(this.width), Integer.valueOf(this.height));
    }
}
