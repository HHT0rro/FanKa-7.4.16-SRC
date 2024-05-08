package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AdglMapAnimFlingP20 extends AbstractAdglAnimation {
    private boolean hasCheckParams;
    private AbstractAdglAnimationParam2V moveParam = null;
    private boolean needMove;
    private float velocityScreenX;
    private float velocityScreenY;

    public AdglMapAnimFlingP20(int i10) {
        reset();
        this.duration = i10;
    }

    public void commitAnimation(Object obj) {
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        this.hasCheckParams = false;
        this.isOver = true;
        float f10 = this.velocityScreenX;
        int i10 = this.duration;
        float f11 = (f10 * i10) / 2000.0f;
        float f12 = (this.velocityScreenY * i10) / 2000.0f;
        if (Math.abs(f11) != 0.0f && Math.abs(f12) != 0.0f) {
            this.isOver = false;
            IPoint obtain = IPoint.obtain();
            gLMapState.getMapGeoCenter(obtain);
            this.moveParam.setFromValue(((Point) obtain).x, ((Point) obtain).y);
            double mapAngle = (gLMapState.getMapAngle() * 3.141592653589793d) / 180.0d;
            double mapLenWithWin = gLMapState.getMapLenWithWin(1);
            double d10 = f11;
            double d11 = f12;
            this.moveParam.setToValue(((Point) obtain).x - (((Math.cos(mapAngle) * d10) - (Math.sin(mapAngle) * d11)) * mapLenWithWin), ((Point) obtain).y - (mapLenWithWin * ((d10 * Math.sin(mapAngle)) + (d11 * Math.cos(mapAngle)))));
            this.needMove = this.moveParam.needToCaculate();
            obtain.recycle();
        }
        this.hasCheckParams = true;
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
        if (f10 < 0.0f || f10 > 1.0f || !this.needMove) {
            return;
        }
        this.moveParam.setNormalizedTime(f10);
        gLMapState.setMapGeoCenter(this.moveParam.getCurXValue(), this.moveParam.getCurYValue());
    }

    public void reset() {
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
        this.velocityScreenX = 0.0f;
        this.velocityScreenY = 0.0f;
        this.needMove = false;
        this.hasCheckParams = false;
    }

    public void setPositionAndVelocity(float f10, float f11) {
        this.moveParam = null;
        this.velocityScreenX = f10;
        this.velocityScreenY = f11;
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = new AbstractAdglAnimationParam2V();
        this.moveParam = abstractAdglAnimationParam2V;
        abstractAdglAnimationParam2V.setInterpolatorType(2, 1.2f);
        this.needMove = false;
        this.hasCheckParams = false;
    }
}
