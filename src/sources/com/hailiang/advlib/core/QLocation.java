package com.hailiang.advlib.core;

import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class QLocation implements IQLocation {
    public double lat;
    public double lot;
    public int type;

    public QLocation() {
        this.lat = ShadowDrawableWrapper.COS_45;
        this.lot = ShadowDrawableWrapper.COS_45;
        this.type = 0;
    }

    @Override // com.hailiang.advlib.core.IQLocation
    public double getLatitude() {
        return this.lat;
    }

    @Override // com.hailiang.advlib.core.IQLocation
    public double getLongitude() {
        return this.lot;
    }

    @Override // com.hailiang.advlib.core.IQLocation
    public int getType() {
        return this.type;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public QLocation(double d10, double d11, int i10) {
        this.lat = d10;
        this.lot = d11;
        this.type = i10;
    }
}
