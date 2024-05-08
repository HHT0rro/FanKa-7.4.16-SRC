package com.amap.api.col.p0003l;

import android.graphics.Point;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

/* compiled from: CameraUpdateFactoryDelegate.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class al {
    public static AbstractCameraUpdateMessage a() {
        ak akVar = new ak();
        akVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        akVar.amount = 1.0f;
        return akVar;
    }

    public static AbstractCameraUpdateMessage b() {
        ak akVar = new ak();
        akVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        akVar.amount = -1.0f;
        return akVar;
    }

    public static AbstractCameraUpdateMessage c(float f10) {
        ai aiVar = new ai();
        aiVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        aiVar.tilt = f10;
        return aiVar;
    }

    public static AbstractCameraUpdateMessage d(float f10) {
        ai aiVar = new ai();
        aiVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        aiVar.bearing = f10;
        return aiVar;
    }

    public static AbstractCameraUpdateMessage a(float f10, float f11) {
        aj ajVar = new aj();
        ajVar.nowType = AbstractCameraUpdateMessage.Type.scrollBy;
        ajVar.xPixel = f10;
        ajVar.yPixel = f11;
        return ajVar;
    }

    public static AbstractCameraUpdateMessage b(float f10) {
        return a(f10, (Point) null);
    }

    public static AbstractCameraUpdateMessage c() {
        return new ai();
    }

    public static AbstractCameraUpdateMessage b(float f10, Point point) {
        ai aiVar = new ai();
        aiVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        aiVar.geoPoint = new DPoint(point.x, point.y);
        aiVar.bearing = f10;
        return aiVar;
    }

    public static AbstractCameraUpdateMessage a(float f10) {
        ai aiVar = new ai();
        aiVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        aiVar.zoom = f10;
        return aiVar;
    }

    public static AbstractCameraUpdateMessage a(float f10, Point point) {
        ak akVar = new ak();
        akVar.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        akVar.amount = f10;
        akVar.focus = point;
        return akVar;
    }

    public static AbstractCameraUpdateMessage a(CameraPosition cameraPosition) {
        LatLng latLng;
        ai aiVar = new ai();
        aiVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        if (cameraPosition != null && (latLng = cameraPosition.target) != null) {
            DPoint latLongToPixelsDouble = VirtualEarthProjection.latLongToPixelsDouble(latLng.latitude, latLng.longitude, 20);
            aiVar.geoPoint = new DPoint(latLongToPixelsDouble.f9303x, latLongToPixelsDouble.f9304y);
            aiVar.zoom = cameraPosition.zoom;
            aiVar.bearing = cameraPosition.bearing;
            aiVar.tilt = cameraPosition.tilt;
            aiVar.cameraPosition = cameraPosition;
        }
        return aiVar;
    }

    public static AbstractCameraUpdateMessage a(Point point) {
        ai aiVar = new ai();
        aiVar.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        aiVar.geoPoint = new DPoint(point.x, point.y);
        return aiVar;
    }

    public static AbstractCameraUpdateMessage a(LatLng latLng) {
        return a(CameraPosition.builder().target(latLng).zoom(Float.NaN).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static AbstractCameraUpdateMessage a(LatLng latLng, float f10) {
        return a(CameraPosition.builder().target(latLng).zoom(f10).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static AbstractCameraUpdateMessage a(LatLngBounds latLngBounds, int i10) {
        ah ahVar = new ah();
        ahVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        ahVar.bounds = latLngBounds;
        ahVar.paddingLeft = i10;
        ahVar.paddingRight = i10;
        ahVar.paddingTop = i10;
        ahVar.paddingBottom = i10;
        return ahVar;
    }

    public static AbstractCameraUpdateMessage a(LatLngBounds latLngBounds, int i10, int i11, int i12) {
        ah ahVar = new ah();
        ahVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBoundsWithSize;
        ahVar.bounds = latLngBounds;
        ahVar.paddingLeft = i12;
        ahVar.paddingRight = i12;
        ahVar.paddingTop = i12;
        ahVar.paddingBottom = i12;
        ahVar.width = i10;
        ahVar.height = i11;
        return ahVar;
    }

    public static AbstractCameraUpdateMessage a(LatLngBounds latLngBounds, int i10, int i11, int i12, int i13) {
        ah ahVar = new ah();
        ahVar.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        ahVar.bounds = latLngBounds;
        ahVar.paddingLeft = i10;
        ahVar.paddingRight = i11;
        ahVar.paddingTop = i12;
        ahVar.paddingBottom = i13;
        return ahVar;
    }
}
