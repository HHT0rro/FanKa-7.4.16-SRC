package com.autonavi.base.amap.mapcore.message;

import android.graphics.Point;
import com.autonavi.ae.gmap.maploader.Pools;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RotateGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<RotateGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(256);
    public float angleDelta;
    public int pivotX;
    public int pivotY;

    public RotateGestureMapMessage(int i10, float f10, int i11, int i12) {
        super(i10);
        this.pivotX = 0;
        this.pivotY = 0;
        this.angleDelta = 0.0f;
        setParams(i10, f10, i11, i12);
        this.angleDelta = f10;
        this.pivotX = i11;
        this.pivotY = i12;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static RotateGestureMapMessage obtain(int i10, float f10, int i11, int i12) {
        RotateGestureMapMessage acquire = M_POOL.acquire();
        if (acquire == null) {
            return new RotateGestureMapMessage(i10, f10, i11, i12);
        }
        acquire.reset();
        acquire.setParams(i10, f10, i11, i12);
        return acquire;
    }

    private void setParams(int i10, float f10, int i11, int i12) {
        setState(i10);
        this.angleDelta = f10;
        this.pivotX = i11;
        this.pivotY = i12;
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 2;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        IPoint obtain;
        float mapAngle = gLMapState.getMapAngle() + this.angleDelta;
        if (this.isGestureScaleByMapCenter) {
            gLMapState.setMapAngle(mapAngle);
            gLMapState.recalculate();
            return;
        }
        int i10 = this.pivotX;
        int i11 = this.pivotY;
        if (this.isUseAnchor) {
            i10 = this.anchorX;
            i11 = this.anchorY;
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
        gLMapState.setMapAngle(mapAngle);
        gLMapState.recalculate();
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
