package com.amap.api.services.nearby;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class UploadInfo {

    /* renamed from: a, reason: collision with root package name */
    private int f8602a = 1;

    /* renamed from: b, reason: collision with root package name */
    private String f8603b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f8604c;

    public int getCoordType() {
        return this.f8602a;
    }

    public LatLonPoint getPoint() {
        return this.f8604c;
    }

    public String getUserID() {
        return this.f8603b;
    }

    public void setCoordType(int i10) {
        if (i10 != 0 && i10 != 1) {
            this.f8602a = 1;
        } else {
            this.f8602a = i10;
        }
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f8604c = latLonPoint;
    }

    public void setUserID(String str) {
        this.f8603b = str;
    }
}
