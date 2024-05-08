package com.autonavi.base.amap.mapcore.message;

import android.graphics.Point;
import com.autonavi.ae.gmap.maploader.Pools;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MoveGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<MoveGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(1024);
    public static int newCount;
    public float touchDeltaX;
    public float touchDeltaY;
    public int touchX;
    public int touchY;

    public MoveGestureMapMessage(int i10, float f10, float f11) {
        super(i10);
        this.touchX = 0;
        this.touchY = 0;
        this.touchDeltaX = f10;
        this.touchDeltaY = f11;
        newCount++;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static synchronized MoveGestureMapMessage obtain(int i10, float f10, float f11, float f12, float f13) {
        MoveGestureMapMessage acquire;
        synchronized (MoveGestureMapMessage.class) {
            acquire = M_POOL.acquire();
            if (acquire == null) {
                acquire = new MoveGestureMapMessage(i10, f10, f11);
            } else {
                acquire.reset();
                acquire.setParams(i10, f10, f11);
            }
            acquire.touchX = (int) f12;
            acquire.touchY = (int) f13;
        }
        return acquire;
    }

    private void setParams(int i10, float f10, float f11) {
        setState(i10);
        this.touchDeltaX = f10;
        this.touchDeltaY = f11;
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 0;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        int i10 = (int) this.touchDeltaX;
        int i11 = (int) this.touchDeltaY;
        int i12 = this.touchX - i10;
        int i13 = this.touchY - i11;
        IPoint obtain = IPoint.obtain();
        win2geo(gLMapState, this.touchX, this.touchY, obtain);
        IPoint obtain2 = IPoint.obtain();
        win2geo(gLMapState, i12, i13, obtain2);
        IPoint obtain3 = IPoint.obtain();
        gLMapState.getMapGeoCenter(obtain3);
        gLMapState.setMapGeoCenter(((Point) obtain3).x + (((Point) obtain2).x - ((Point) obtain).x), ((Point) obtain3).y + (((Point) obtain2).y - ((Point) obtain).y));
        gLMapState.recalculate();
        obtain3.recycle();
        obtain.recycle();
        obtain2.recycle();
    }
}
