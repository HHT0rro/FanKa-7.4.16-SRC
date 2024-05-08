package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class NearbyInfo {

    /* renamed from: a, reason: collision with root package name */
    private String f8586a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f8587b;

    /* renamed from: c, reason: collision with root package name */
    private long f8588c;

    /* renamed from: d, reason: collision with root package name */
    private int f8589d;

    /* renamed from: e, reason: collision with root package name */
    private int f8590e;

    public int getDistance() {
        return this.f8589d;
    }

    public int getDrivingDistance() {
        return this.f8590e;
    }

    public LatLonPoint getPoint() {
        return this.f8587b;
    }

    public long getTimeStamp() {
        return this.f8588c;
    }

    public String getUserID() {
        return this.f8586a;
    }

    public void setDistance(int i10) {
        this.f8589d = i10;
    }

    public void setDrivingDistance(int i10) {
        this.f8590e = i10;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f8587b = latLonPoint;
    }

    public void setTimeStamp(long j10) {
        this.f8588c = j10;
    }

    public void setUserID(String str) {
        this.f8586a = str;
    }
}
