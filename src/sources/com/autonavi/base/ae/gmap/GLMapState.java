package com.autonavi.base.ae.gmap;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.mapcore.FPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GLMapState implements IGLMapState {
    private int engineID;
    private boolean isNewInstance;
    private long nativeEngineInstance;
    private long nativeStateInstance;

    public GLMapState(int i10, long j10) {
        this.nativeStateInstance = 0L;
        this.nativeEngineInstance = 0L;
        this.isNewInstance = false;
        if (j10 != 0) {
            this.engineID = i10;
            this.nativeEngineInstance = j10;
            this.nativeStateInstance = nativeNewInstance(i10, j10);
            this.isNewInstance = true;
        }
    }

    public static void geo2LonLat(long j10, long j11, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(j10, j11, 20);
        dPoint.f9303x = pixelsToLatLong.f9303x;
        dPoint.f9304y = pixelsToLatLong.f9304y;
        pixelsToLatLong.recycle();
    }

    public static void lonlat2Geo(double d10, double d11, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d11, d10, 20);
        ((Point) iPoint).x = latLongToPixels.x;
        ((Point) iPoint).y = latLongToPixels.y;
    }

    public static native float nativeCalMapZoomScalefactor(long j10, int i10, int i11, float f10);

    public static native float nativeCalculateMapZoomer(long j10, int i10, int i11, int i12, int i13, int i14);

    public static native float nativeGetCameraDegree(long j10);

    public static native float nativeGetGLUnitWithWin(long j10, int i10);

    public static native float nativeGetMapAngle(long j10);

    public static native void nativeGetMapCenter(long j10, Point point);

    public static native double nativeGetMapCenterXDouble(long j10);

    public static native double nativeGetMapCenterYDouble(long j10);

    public static native float nativeGetMapZoomer(long j10);

    public static native void nativeGetPixel20Bound(long j10, Rect rect, int i10, int i11);

    public static native void nativeGetProjectionMatrix(long j10, float[] fArr);

    public static native float nativeGetSkyHeight(long j10);

    public static native void nativeGetViewMatrix(long j10, float[] fArr);

    public static native long nativeNewInstance(int i10, long j10);

    public static native void nativeP20ToScreenPoint(long j10, int i10, int i11, int i12, PointF pointF);

    public static native void nativeRecalculate(long j10);

    public static native void nativeScreenToP20Point(long j10, float f10, float f11, Point point);

    public static native void nativeSetCameraDegree(long j10, float f10);

    public static native void nativeSetMapAngle(long j10, float f10);

    public static native void nativeSetMapCenter(long j10, double d10, double d11);

    private static native void nativeSetMapState(int i10, long j10, long j11);

    public static native void nativeSetMapZoomer(long j10, float f10);

    public static native void nativeStateDestroy(long j10, long j11);

    public float calMapZoomScalefactor(int i10, int i11, int i12) {
        return nativeCalMapZoomScalefactor(this.nativeStateInstance, i10, i11, i12);
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public float calculateMapZoomer(int i10, int i11, int i12, int i13, int i14) {
        long j10 = this.nativeStateInstance;
        if (j10 != 0) {
            return nativeCalculateMapZoomer(j10, i10, i11, i12, i13, i14);
        }
        return 3.0f;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public float getCameraDegree() {
        long j10 = this.nativeStateInstance;
        if (j10 != 0) {
            return nativeGetCameraDegree(j10);
        }
        return 0.0f;
    }

    public float getGLUnitWithWin(int i10) {
        long j10 = this.nativeStateInstance;
        if (j10 != 0) {
            return nativeGetGLUnitWithWin(j10, i10);
        }
        return 0.0f;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public float getMapAngle() {
        long j10 = this.nativeStateInstance;
        if (j10 != 0) {
            return nativeGetMapAngle(j10);
        }
        return 0.0f;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void getMapGeoCenter(IPoint iPoint) {
        nativeGetMapCenter(this.nativeStateInstance, iPoint);
    }

    public double getMapGeoCenterX() {
        return nativeGetMapCenterXDouble(this.nativeStateInstance);
    }

    public double getMapGeoCenterY() {
        return nativeGetMapCenterXDouble(this.nativeStateInstance);
    }

    public float getMapLenWithWin(int i10) {
        return getGLUnitWithWin(i10);
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public float getMapZoomer() {
        long j10 = this.nativeStateInstance;
        if (j10 != 0) {
            return nativeGetMapZoomer(j10);
        }
        return 0.0f;
    }

    public long getNativeInstance() {
        return this.nativeStateInstance;
    }

    public void getPixel20Bound(Rect rect, int i10, int i11) {
        long j10 = this.nativeStateInstance;
        if (j10 != 0) {
            nativeGetPixel20Bound(j10, rect, i10, i11);
        }
    }

    public void getProjectionMatrix(float[] fArr) {
        if (fArr == null || fArr.length != 16) {
            return;
        }
        nativeGetProjectionMatrix(this.nativeStateInstance, fArr);
    }

    public float getSkyHeight() {
        long j10 = this.nativeStateInstance;
        if (j10 != 0) {
            return nativeGetSkyHeight(j10);
        }
        return 0.0f;
    }

    public void getViewMatrix(float[] fArr) {
        if (fArr == null || fArr.length != 16) {
            return;
        }
        nativeGetViewMatrix(this.nativeStateInstance, fArr);
    }

    public void p20ToScreenPoint(int i10, int i11, FPoint fPoint) {
        long j10 = this.nativeStateInstance;
        if (j10 != 0) {
            nativeP20ToScreenPoint(j10, i10, i11, 0, fPoint);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void recalculate() {
        long j10 = this.nativeStateInstance;
        if (j10 != 0) {
            nativeRecalculate(j10);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void recycle() {
        long j10 = this.nativeStateInstance;
        if (j10 != 0 && this.isNewInstance) {
            nativeStateDestroy(j10, this.nativeEngineInstance);
        }
        this.nativeStateInstance = 0L;
    }

    public void reset() {
        if (this.nativeStateInstance != 0) {
            recycle();
        }
        long j10 = this.nativeEngineInstance;
        if (j10 != 0) {
            this.nativeStateInstance = nativeNewInstance(this.engineID, j10);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void screenToP20Point(int i10, int i11, Point point) {
        long j10 = this.nativeStateInstance;
        if (j10 != 0) {
            nativeScreenToP20Point(j10, i10, i11, point);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void setCameraDegree(float f10) {
        long j10 = this.nativeStateInstance;
        if (j10 != 0) {
            nativeSetCameraDegree(j10, f10);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void setMapAngle(float f10) {
        long j10 = this.nativeStateInstance;
        if (j10 != 0) {
            nativeSetMapAngle(j10, f10);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void setMapGeoCenter(double d10, double d11) {
        long j10 = this.nativeStateInstance;
        if (j10 != 0) {
            nativeSetMapCenter(j10, d10, d11);
        }
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void setMapZoomer(float f10) {
        long j10 = this.nativeStateInstance;
        if (j10 != 0) {
            nativeSetMapZoomer(j10, f10);
        }
    }

    public void setNativeMapengineState(int i10, long j10) {
        if (j10 != 0) {
            long j11 = this.nativeStateInstance;
            if (j11 == 0) {
                return;
            }
            this.nativeEngineInstance = j10;
            nativeSetMapState(i10, j10, j11);
        }
    }

    public String toString() {
        return "instance: " + this.nativeStateInstance + " center: " + getMapGeoCenter().f9303x + " , " + getMapGeoCenter().f9304y + " bearing:" + getCameraDegree() + "  tilt:" + getMapAngle() + "  zoom:" + getMapZoomer() + "  ";
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public DPoint getMapGeoCenter() {
        DPoint dPoint = new DPoint();
        dPoint.f9303x = nativeGetMapCenterXDouble(this.nativeStateInstance);
        dPoint.f9304y = nativeGetMapCenterYDouble(this.nativeStateInstance);
        return dPoint;
    }

    public GLMapState(int i10, long j10, long j11) {
        this.nativeStateInstance = 0L;
        this.nativeEngineInstance = 0L;
        this.isNewInstance = false;
        if (j10 != 0) {
            this.engineID = i10;
            this.nativeEngineInstance = j10;
            this.nativeStateInstance = j11;
            this.isNewInstance = true;
        }
    }
}
