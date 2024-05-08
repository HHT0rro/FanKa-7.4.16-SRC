package com.amap.api.services.help;

import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class InputtipsQuery implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private String f8573a;

    /* renamed from: b, reason: collision with root package name */
    private String f8574b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f8575c = false;

    /* renamed from: d, reason: collision with root package name */
    private String f8576d = null;

    /* renamed from: e, reason: collision with root package name */
    private LatLonPoint f8577e;

    public InputtipsQuery(String str, String str2) {
        this.f8573a = str;
        this.f8574b = str2;
    }

    public String getCity() {
        return this.f8574b;
    }

    public boolean getCityLimit() {
        return this.f8575c;
    }

    public String getKeyword() {
        return this.f8573a;
    }

    public LatLonPoint getLocation() {
        return this.f8577e;
    }

    public String getType() {
        return this.f8576d;
    }

    public void setCityLimit(boolean z10) {
        this.f8575c = z10;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.f8577e = latLonPoint;
    }

    public void setType(String str) {
        this.f8576d = str;
    }
}
