package com.amap.api.maps;

import android.graphics.Point;
import com.amap.api.col.p0003l.al;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CameraUpdateFactory {
    private static final String CLASSNAME = "CameraUpdateFactory";

    public static CameraUpdate changeBearing(float f10) {
        return new CameraUpdate(al.d(f10 % 360.0f));
    }

    public static CameraUpdate changeBearingGeoCenter(float f10, IPoint iPoint) {
        if (iPoint == null) {
            return new CameraUpdate(al.c());
        }
        return new CameraUpdate(al.b(f10 % 360.0f, new Point(((Point) iPoint).x, ((Point) iPoint).y)));
    }

    public static CameraUpdate changeLatLng(LatLng latLng) {
        if (latLng == null) {
            return new CameraUpdate(al.c());
        }
        return new CameraUpdate(al.a(VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20)));
    }

    public static CameraUpdate changeTilt(float f10) {
        return new CameraUpdate(al.c(f10));
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            return new CameraUpdate(al.c());
        }
        return new CameraUpdate(al.a(cameraPosition));
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        if (latLng == null) {
            return new CameraUpdate(al.c());
        }
        return new CameraUpdate(al.a(latLng));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i10) {
        if (latLngBounds == null) {
            return new CameraUpdate(al.c());
        }
        return new CameraUpdate(al.a(latLngBounds, i10));
    }

    public static CameraUpdate newLatLngBoundsRect(LatLngBounds latLngBounds, int i10, int i11, int i12, int i13) {
        if (latLngBounds == null) {
            return new CameraUpdate(al.c());
        }
        return new CameraUpdate(al.a(latLngBounds, i10, i11, i12, i13));
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f10) {
        if (latLng == null) {
            return new CameraUpdate(al.c());
        }
        return new CameraUpdate(al.a(latLng, f10));
    }

    public static CameraUpdate scrollBy(float f10, float f11) {
        return new CameraUpdate(al.a(f10, f11));
    }

    public static CameraUpdate zoomBy(float f10) {
        return new CameraUpdate(al.b(f10));
    }

    public static CameraUpdate zoomIn() {
        return new CameraUpdate(al.a());
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(al.b());
    }

    public static CameraUpdate zoomTo(float f10) {
        return new CameraUpdate(al.a(f10));
    }

    public static CameraUpdate zoomBy(float f10, Point point) {
        return new CameraUpdate(al.a(f10, point));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i10, int i11, int i12) {
        if (latLngBounds == null) {
            return new CameraUpdate(al.c());
        }
        return new CameraUpdate(al.a(latLngBounds, i10, i11, i12));
    }
}
