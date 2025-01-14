package com.alibaba.security.biometrics.service.model.result;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DazzleDataConfigItem implements Serializable {
    private String color;
    private float duration;
    private float screenLight;
    private String textColor;
    private long timeInterval;

    public String getColor() {
        return this.color;
    }

    public float getDuration() {
        return this.duration;
    }

    public float getScreenLight() {
        return this.screenLight;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public long getTimeInterval() {
        return this.timeInterval;
    }

    public void setColor(String str) {
        this.color = str;
    }

    public void setDuration(float f10) {
        this.duration = f10;
    }

    public void setScreenLight(float f10) {
        this.screenLight = f10;
    }

    public void setTextColor(String str) {
        this.textColor = str;
    }

    public void setTimeInterval(long j10) {
        this.timeInterval = j10;
    }
}
