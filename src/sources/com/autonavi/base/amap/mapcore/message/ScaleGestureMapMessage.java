package com.autonavi.base.amap.mapcore.message;

import android.graphics.Point;
import com.autonavi.ae.gmap.maploader.Pools;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ScaleGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<ScaleGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(256);
    public int pivotX;
    public int pivotY;
    public float scaleDelta;

    public ScaleGestureMapMessage(int i10, float f10, int i11, int i12) {
        super(i10);
        this.scaleDelta = 0.0f;
        this.pivotX = 0;
        this.pivotY = 0;
        setParams(i10, f10, i11, i12);
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static ScaleGestureMapMessage obtain(int i10, float f10, int i11, int i12) {
        ScaleGestureMapMessage acquire = M_POOL.acquire();
        if (acquire == null) {
            return new ScaleGestureMapMessage(i10, f10, i11, i12);
        }
        acquire.reset();
        acquire.setParams(i10, f10, i11, i12);
        return acquire;
    }

    private void setMapZoomer(GLMapState gLMapState) {
        gLMapState.setMapZoomer(gLMapState.getMapZoomer() + this.scaleDelta);
        gLMapState.recalculate();
    }

    private void setParams(int i10, float f10, int i11, int i12) {
        setState(i10);
        this.scaleDelta = f10;
        this.pivotX = i11;
        this.pivotY = i12;
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 1;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        IPoint obtain;
        if (this.isUseAnchor) {
            setMapZoomer(gLMapState);
            return;
        }
        int i10 = this.pivotX;
        int i11 = this.pivotY;
        if (this.isGestureScaleByMapCenter) {
            i10 = this.width >> 1;
            i11 = this.height >> 1;
        }
        IPoint iPoint = null;
        if (i10 > 0 || i11 > 0) {
            iPoint = IPoint.obtain();
            obtain = IPoint.obtain();
            win2geo(gLMapState, i10, i11, iPoint);
            gLMapState.setMapGeoCenter(((Point) iPoint).x, ((Point) iPoint).y);
        } else {
            obtain = null;
        }
        setMapZoomer(gLMapState);
        if (i10 > 0 || i11 > 0) {
            win2geo(gLMapState, i10, i11, obtain);
            if (iPoint != null) {
                gLMapState.setMapGeoCenter((((Point) iPoint).x * 2) - ((Point) obtain).x, (((Point) iPoint).y * 2) - ((Point) obtain).y);
            }
            gLMapState.recalculate();
        }
        if (iPoint != null) {
            iPoint.recycle();
        }
        if (obtain != null) {
            obtain.recycle();
        }
    }
}
