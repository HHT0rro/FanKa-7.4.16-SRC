package com.autonavi.amap.mapcore;

import android.graphics.Point;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MapProjection {
    public static void geo2LonLat(int i10, int i11, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(i10, i11, 20);
        dPoint.f9303x = pixelsToLatLong.f9303x;
        dPoint.f9304y = pixelsToLatLong.f9304y;
        pixelsToLatLong.recycle();
    }

    public static void lonlat2Geo(double d10, double d11, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d11, d10, 20);
        ((Point) iPoint).x = latLongToPixels.x;
        ((Point) iPoint).y = latLongToPixels.y;
    }
}
