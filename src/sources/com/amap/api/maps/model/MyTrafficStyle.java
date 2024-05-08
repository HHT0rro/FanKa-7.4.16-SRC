package com.amap.api.maps.model;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MyTrafficStyle {
    private int extremelySmoothColor = -15229099;
    private int smoothColor = -16735735;
    private int slowColor = -35576;
    private int congestedColor = -1441006;
    private int seriousCongestedColor = -7208950;
    private float ratio = 0.8f;
    private int trafficRoadBackgroundColor = -1;

    public int getCongestedColor() {
        return this.congestedColor;
    }

    public int getExtremelySmoothColor() {
        return this.extremelySmoothColor;
    }

    public float getRatio() {
        return this.ratio;
    }

    public int getSeriousCongestedColor() {
        return this.seriousCongestedColor;
    }

    public int getSlowColor() {
        return this.slowColor;
    }

    public int getSmoothColor() {
        return this.smoothColor;
    }

    public int getTrafficRoadBackgroundColor() {
        return this.trafficRoadBackgroundColor;
    }

    public void setCongestedColor(int i10) {
        this.congestedColor = i10;
    }

    public void setExtremelySmoothColor(int i10) {
        this.extremelySmoothColor = i10;
    }

    public void setRatio(float f10) {
        this.ratio = f10;
    }

    public void setSeriousCongestedColor(int i10) {
        this.seriousCongestedColor = i10;
    }

    public void setSlowColor(int i10) {
        this.slowColor = i10;
    }

    public void setSmoothColor(int i10) {
        this.smoothColor = i10;
    }

    public void setTrafficRoadBackgroundColor(int i10) {
        this.trafficRoadBackgroundColor = i10;
    }
}
