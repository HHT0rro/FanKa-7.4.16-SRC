package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AdglMapAnimPivotZoom extends AbstractAdglAnimation {
    private int beginCenterGeoX;
    private int beginCenterGeoY;
    private boolean hasCheckParams;
    private float mapLevelTo;
    private int pivotGeoX;
    private int pivotGeoY;
    private float winPivotX;
    private float winPivotY;
    private boolean zoomCenter;
    public AbstractAdglAnimationParam1V zoomParam = null;

    public AdglMapAnimPivotZoom(int i10) {
        reset();
        this.duration = i10;
    }

    public void commitAnimation(Object obj) {
        this.isOver = true;
        this.hasCheckParams = false;
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        float mapZoomer = gLMapState.getMapZoomer();
        if (Math.abs(this.mapLevelTo - mapZoomer) < 1.0E-6d) {
            this.isOver = true;
            this.hasCheckParams = true;
            return;
        }
        this.zoomParam.setFromValue(mapZoomer);
        this.zoomParam.setToValue(this.mapLevelTo);
        if (!this.zoomCenter) {
            IPoint obtain = IPoint.obtain();
            gLMapState.getMapGeoCenter(obtain);
            this.beginCenterGeoX = ((Point) obtain).x;
            this.beginCenterGeoY = ((Point) obtain).y;
            IPoint obtain2 = IPoint.obtain();
            gLMapState.screenToP20Point((int) this.winPivotX, (int) this.winPivotY, obtain2);
            this.pivotGeoX = ((Point) obtain2).x;
            this.pivotGeoY = ((Point) obtain2).y;
            obtain.recycle();
            obtain2.recycle();
        }
        this.hasCheckParams = true;
        this.isOver = false;
        this.startTime = SystemClock.uptimeMillis();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object obj) {
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        if (!this.hasCheckParams) {
            commitAnimation(obj);
        }
        if (this.isOver) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.startTime;
        this.offsetTime = uptimeMillis;
        float f10 = ((float) uptimeMillis) / this.duration;
        if (f10 > 1.0f) {
            this.isOver = true;
            f10 = 1.0f;
        }
        if (f10 < 0.0f || f10 > 1.0f) {
            return;
        }
        this.zoomParam.setNormalizedTime(f10);
        float curValue = this.zoomParam.getCurValue();
        if (curValue > 20.0f) {
            this.isOver = true;
            curValue = 20.0f;
        }
        if (curValue < 3.0f) {
            this.isOver = true;
            curValue = 3.0f;
        }
        if (!this.zoomCenter) {
            float pow = (float) Math.pow(2.0d, curValue - this.zoomParam.getFromValue());
            int i10 = this.pivotGeoX;
            int i11 = this.beginCenterGeoX;
            int i12 = (int) ((i10 - i11) * (1.0f - (1.0f / pow)));
            int i13 = this.pivotGeoY;
            int i14 = this.beginCenterGeoY;
            gLMapState.setMapGeoCenter(i11 + i12, i14 + ((int) ((i13 - i14) * r2)));
        }
        gLMapState.setMapZoomer(curValue);
    }

    public void reset() {
        this.isOver = false;
        this.hasCheckParams = false;
        this.zoomCenter = true;
        this.mapLevelTo = 0.0f;
        this.beginCenterGeoX = 0;
        this.beginCenterGeoY = 0;
        this.pivotGeoX = 0;
        this.pivotGeoY = 0;
        this.winPivotX = 0.0f;
        this.winPivotY = 0.0f;
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.zoomParam;
        if (abstractAdglAnimationParam1V != null) {
            abstractAdglAnimationParam1V.reset();
        }
    }

    public void setToMapZoomAndPivot(float f10, int i10, Point point) {
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = new AbstractAdglAnimationParam1V();
        this.zoomParam = abstractAdglAnimationParam1V;
        abstractAdglAnimationParam1V.setInterpolatorType(i10, 1.0f);
        if (f10 > 20.0f) {
            f10 = 20.0f;
        }
        if (f10 < 3.0f) {
            f10 = 3.0f;
        }
        this.mapLevelTo = f10;
        if (point != null) {
            this.winPivotX = point.x;
            this.winPivotY = point.y;
            this.zoomCenter = false;
        }
    }
}
