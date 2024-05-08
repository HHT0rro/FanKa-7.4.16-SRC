package com.amap.api.maps.model;

import com.amap.api.col.p0003l.dx;
import com.autonavi.amap.mapcore.DPoint;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class WeightedLatLng {
    public static final double DEFAULT_INTENSITY = 1.0d;
    public final double intensity;
    public final LatLng latLng;
    private DPoint mPoint;

    public WeightedLatLng(LatLng latLng, double d10) {
        if (latLng != null) {
            this.latLng = latLng;
            this.mPoint = dx.a(latLng);
            if (d10 >= ShadowDrawableWrapper.COS_45) {
                this.intensity = d10;
                return;
            } else {
                this.intensity = 1.0d;
                return;
            }
        }
        throw new IllegalArgumentException("latLng can not null");
    }

    public DPoint getPoint() {
        return this.mPoint;
    }

    public WeightedLatLng(LatLng latLng) {
        this(latLng, 1.0d);
    }
}
