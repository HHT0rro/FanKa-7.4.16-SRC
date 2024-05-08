package com.huawei.dynamicanimation;

import e9.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class OutputData {
    public float mAcceleration;
    public float mTime;
    public float mVelocity;
    public float mX;

    public OutputData(float f10, float f11, float f12, float f13) {
        this.mTime = f10;
        this.mX = f11;
        this.mVelocity = f12;
        this.mAcceleration = f13;
    }

    public float getA() {
        return this.mAcceleration;
    }

    public float getT() {
        return this.mTime;
    }

    public float getV() {
        return this.mVelocity;
    }

    public float getX() {
        return this.mX;
    }

    public void setA(float f10) {
        this.mAcceleration = f10;
    }

    public void setT(float f10) {
        this.mTime = f10;
    }

    public void setV(float f10) {
        this.mVelocity = f10;
    }

    public void setX(float f10) {
        this.mX = f10;
    }

    public String toString() {
        StringBuilder b4 = a.b("OutputData{time=");
        b4.append(this.mTime);
        b4.append(", x=");
        b4.append(this.mX);
        b4.append(", v=");
        b4.append(this.mVelocity);
        b4.append(", a=");
        b4.append(this.mAcceleration);
        b4.append('}');
        return b4.toString();
    }
}
