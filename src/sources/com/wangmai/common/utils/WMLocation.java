package com.wangmai.common.utils;

import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WMLocation {
    public float accuracy;
    public double latitude;
    public double longitude;

    public WMLocation() {
        this.latitude = ShadowDrawableWrapper.COS_45;
        this.longitude = ShadowDrawableWrapper.COS_45;
        this.accuracy = 0.0f;
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setAccuracy(float f10) {
        this.accuracy = f10;
    }

    public void setLatitude(double d10) {
        this.latitude = d10;
    }

    public void setLongitude(double d10) {
        this.longitude = d10;
    }

    public String toString() {
        return "WMLocation{latitude=" + this.latitude + ", longitude=" + this.longitude + ", accuracy=" + this.accuracy + '}';
    }

    public WMLocation(double d10, double d11) {
        this.accuracy = 0.0f;
        this.latitude = d10;
        this.longitude = d11;
    }

    public WMLocation(double d10, double d11, float f10) {
        this.latitude = d10;
        this.longitude = d11;
        this.accuracy = f10;
    }
}
