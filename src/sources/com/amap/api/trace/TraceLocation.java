package com.amap.api.trace;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TraceLocation {

    /* renamed from: a, reason: collision with root package name */
    private double f9131a;

    /* renamed from: b, reason: collision with root package name */
    private double f9132b;

    /* renamed from: c, reason: collision with root package name */
    private float f9133c;

    /* renamed from: d, reason: collision with root package name */
    private float f9134d;

    /* renamed from: e, reason: collision with root package name */
    private long f9135e;

    public TraceLocation(double d10, double d11, float f10, float f11, long j10) {
        this.f9131a = a(d10);
        this.f9132b = a(d11);
        this.f9133c = (int) ((f10 * 3600.0f) / 1000.0f);
        this.f9134d = (int) f11;
        this.f9135e = j10;
    }

    private static double a(double d10) {
        return Math.round(d10 * 1000000.0d) / 1000000.0d;
    }

    public TraceLocation copy() {
        TraceLocation traceLocation = new TraceLocation();
        traceLocation.f9134d = this.f9134d;
        traceLocation.f9131a = this.f9131a;
        traceLocation.f9132b = this.f9132b;
        traceLocation.f9133c = this.f9133c;
        traceLocation.f9135e = this.f9135e;
        return traceLocation;
    }

    public float getBearing() {
        return this.f9134d;
    }

    public double getLatitude() {
        return this.f9131a;
    }

    public double getLongitude() {
        return this.f9132b;
    }

    public float getSpeed() {
        return this.f9133c;
    }

    public long getTime() {
        return this.f9135e;
    }

    public void setBearing(float f10) {
        this.f9134d = (int) f10;
    }

    public void setLatitude(double d10) {
        this.f9131a = a(d10);
    }

    public void setLongitude(double d10) {
        this.f9132b = a(d10);
    }

    public void setSpeed(float f10) {
        this.f9133c = (int) ((f10 * 3600.0f) / 1000.0f);
    }

    public void setTime(long j10) {
        this.f9135e = j10;
    }

    public String toString() {
        return this.f9131a + ",longtitude " + this.f9132b + ",speed " + this.f9133c + ",bearing " + this.f9134d + ",time " + this.f9135e;
    }

    public TraceLocation() {
    }
}
