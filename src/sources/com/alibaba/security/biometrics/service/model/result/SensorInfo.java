package com.alibaba.security.biometrics.service.model.result;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SensorInfo implements Serializable {
    private float lightBrightness;
    private float proximityValue;

    public SensorInfo(float f10) {
        this.lightBrightness = f10;
    }

    public float getLightBrightness() {
        return this.lightBrightness;
    }

    public float getProximityValue() {
        return this.proximityValue;
    }

    public void setLightBrightness(float f10) {
        this.lightBrightness = f10;
    }

    public void setProximityValue(float f10) {
        this.proximityValue = f10;
    }

    public SensorInfo(float f10, float f11) {
        this.lightBrightness = f10;
        this.proximityValue = f11;
    }
}
