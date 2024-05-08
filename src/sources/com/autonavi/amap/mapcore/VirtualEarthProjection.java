package com.autonavi.amap.mapcore;

import android.graphics.Point;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class VirtualEarthProjection {
    public static final double EARTH_CIRCUMFERENCE_IN_METERS = 4.007501668557849E7d;
    public static final int EARTH_RADIUS_IN_METERS = 6378137;
    private static final int KMA_MAX_MAP_SIZE = 268435456;
    private static final double K_EARTH_CIRCLE = 4.0075016E7d;
    private static final double K_EARTH_CIRCLE_2 = 2.0037508E7d;
    public static final int MAXZOOMLEVEL = 20;
    public static final double MAX_LATITUDE = 85.0511287798d;
    public static final double MAX_LONGITUDE = 360.0d;
    public static final double MIN_LATITUDE = -85.0511287798d;
    public static final double MIN_LONGITUDE = -360.0d;
    public static final int PIXELS_PER_TILE = 256;
    public static final int TILE_SPLIT_LEVEL = 0;

    public static double clip(double d10, double d11, double d12) {
        return Math.min(Math.max(d10, d11), d12);
    }

    private static double degToRad(double d10) {
        return d10 * 0.017453292519943295d;
    }

    public static Point latLongToPixels(int i10, int i11, int i12) {
        return latLongToPixels(i11 / 3600000.0d, i10 / 3600000.0d, i12);
    }

    public static DPoint latLongToPixelsDouble(double d10, double d11, int i10) {
        DPoint dPoint = new DPoint();
        double clip = clip(d10, -85.0511287798d, 85.0511287798d);
        double degToRad = degToRad(clip(d11, -360.0d, 360.0d)) * 6378137.0d;
        double sin = Math.sin(degToRad(clip));
        double log = (Math.log((sin + 1.0d) / (1.0d - sin)) * 6378137.0d) / 2.0d;
        double d12 = (degToRad + K_EARTH_CIRCLE_2) / 0.14929106831550598d;
        double d13 = (K_EARTH_CIRCLE_2 - log) / 0.14929106831550598d;
        dPoint.f9303x = d12;
        dPoint.f9304y = d13;
        return dPoint;
    }

    public static DPoint pixelsToLatLong(long j10, long j11, int i10) {
        DPoint obtain = DPoint.obtain();
        double d10 = (j10 * 0.14929106831550598d) - K_EARTH_CIRCLE_2;
        double d11 = K_EARTH_CIRCLE_2 - (j11 * 0.14929106831550598d);
        obtain.f9303x = radToDeg(d10 / 6378137.0d);
        double exp = Math.exp((d11 / 6378137.0d) * 2.0d);
        obtain.f9304y = radToDeg(Math.asin((exp - 1.0d) / (exp + 1.0d)));
        return obtain;
    }

    private static double radToDeg(double d10) {
        return d10 * 57.29577951308232d;
    }

    public static void latLongToPixels(double d10, double d11, int i10, Point point) {
        double clip = clip(d10, -85.0511287798d, 85.0511287798d);
        double degToRad = degToRad(clip(d11, -360.0d, 360.0d)) * 6378137.0d;
        double sin = Math.sin(degToRad(clip));
        double log = (Math.log((sin + 1.0d) / (1.0d - sin)) * 6378137.0d) / 2.0d;
        double d12 = (degToRad + K_EARTH_CIRCLE_2) / 0.14929106831550598d;
        double d13 = (K_EARTH_CIRCLE_2 - log) / 0.14929106831550598d;
        point.x = (int) d12;
        point.y = (int) d13;
    }

    public static DPoint pixelsToLatLong(double d10, double d11, int i10) {
        DPoint obtain = DPoint.obtain();
        double d12 = (d10 * 0.14929106831550598d) - K_EARTH_CIRCLE_2;
        double d13 = K_EARTH_CIRCLE_2 - (d11 * 0.14929106831550598d);
        obtain.f9303x = radToDeg(d12 / 6378137.0d);
        double exp = Math.exp((d13 / 6378137.0d) * 2.0d);
        obtain.f9304y = radToDeg(Math.asin((exp - 1.0d) / (exp + 1.0d)));
        return obtain;
    }

    public static Point latLongToPixels(double d10, double d11, int i10) {
        Point point = new Point();
        latLongToPixels(d10, d11, i10, point);
        return point;
    }
}
