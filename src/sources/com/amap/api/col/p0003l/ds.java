package com.amap.api.col.p0003l;

import com.amap.api.maps.model.LatLng;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* compiled from: SegmentsIntersect.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ds {
    private static double a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d10 = latLng.latitude;
        double d11 = d10 - latLng3.latitude;
        double d12 = latLng.longitude;
        return ((d12 - latLng3.longitude) * (d10 - latLng2.latitude)) - ((d12 - latLng2.longitude) * d11);
    }

    private static boolean b(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d10 = latLng.longitude;
        double d11 = latLng2.longitude;
        double d12 = d10 - d11 > ShadowDrawableWrapper.COS_45 ? d10 : d11;
        if (d10 - d11 >= ShadowDrawableWrapper.COS_45) {
            d10 = d11;
        }
        double d13 = latLng.latitude;
        double d14 = latLng2.latitude;
        double d15 = d13 - d14 > ShadowDrawableWrapper.COS_45 ? d13 : d14;
        if (d13 - d14 >= ShadowDrawableWrapper.COS_45) {
            d13 = d14;
        }
        double d16 = latLng3.longitude;
        if (d10 > d16 || d16 > d12) {
            return false;
        }
        double d17 = latLng3.latitude;
        return d13 <= d17 && d17 <= d15;
    }

    public static boolean a(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4) {
        double a10 = a(latLng3, latLng4, latLng);
        double a11 = a(latLng3, latLng4, latLng2);
        double a12 = a(latLng, latLng2, latLng3);
        double a13 = a(latLng, latLng2, latLng4);
        if (((a10 > ShadowDrawableWrapper.COS_45 && a11 < ShadowDrawableWrapper.COS_45) || (a10 < ShadowDrawableWrapper.COS_45 && a11 > ShadowDrawableWrapper.COS_45)) && ((a12 > ShadowDrawableWrapper.COS_45 && a13 < ShadowDrawableWrapper.COS_45) || (a12 < ShadowDrawableWrapper.COS_45 && a13 > ShadowDrawableWrapper.COS_45))) {
            return true;
        }
        if (a10 == ShadowDrawableWrapper.COS_45 && b(latLng3, latLng4, latLng)) {
            return true;
        }
        if (a11 == ShadowDrawableWrapper.COS_45 && b(latLng3, latLng4, latLng2)) {
            return true;
        }
        if (a12 == ShadowDrawableWrapper.COS_45 && b(latLng, latLng2, latLng3)) {
            return true;
        }
        return a13 == ShadowDrawableWrapper.COS_45 && b(latLng, latLng2, latLng4);
    }
}
