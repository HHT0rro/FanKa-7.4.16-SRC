package com.effectsar.labcv.effectsdk;

import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BefStudentIdOcrInfo {
    private int height;
    private int length = 0;
    private byte[] result;
    private int width;

    /* renamed from: x, reason: collision with root package name */
    private int f19183x;

    /* renamed from: y, reason: collision with root package name */
    private int f19184y;

    public int getHeight() {
        return this.height;
    }

    public int getLength() {
        return this.length;
    }

    public byte[] getResult() {
        return this.result;
    }

    public int getWidth() {
        return this.width;
    }

    public int getX() {
        return this.f19183x;
    }

    public int getY() {
        return this.f19184y;
    }

    public String toString() {
        return "BefStudentIdOcrInfo{width=" + this.width + ", height=" + this.height + ", x=" + this.f19183x + ", y=" + this.f19184y + ", length=" + this.length + ", result=" + Arrays.toString(this.result) + '}';
    }
}
