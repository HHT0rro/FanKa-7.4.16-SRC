package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AdglMapAnimFling extends AbstractAdglAnimation {
    private IPoint fromCenter;
    private boolean hasCheckParams;
    private int lastMoveX;
    private int lastMoveY;
    private AbstractAdglAnimationParam2V moveParam = null;
    private boolean needMove;
    private int screenCenterX;
    private int screenCenterY;
    private float velocityX;
    private float velocityY;

    public AdglMapAnimFling(int i10, int i11, int i12) {
        this.screenCenterX = i11;
        this.screenCenterY = i12;
        this.lastMoveX = i11;
        this.lastMoveY = i12;
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
        float f10 = this.velocityX;
        int i10 = this.duration;
        int i11 = (int) ((f10 * i10) / 2000.0f);
        int i12 = (int) ((this.velocityY * i10) / 2000.0f);
        if (Math.abs(i11) != 0 && Math.abs(i12) != 0) {
            if (this.fromCenter == null) {
                this.fromCenter = IPoint.obtain();
            }
            gLMapState.getMapGeoCenter(this.fromCenter);
            this.isOver = false;
            this.moveParam.setFromValue(this.screenCenterX, this.screenCenterY);
            this.moveParam.setToValue(this.screenCenterX - i11, this.screenCenterY - i12);
            this.needMove = this.moveParam.needToCaculate();
        }
        this.hasCheckParams = true;
        this.startTime = SystemClock.uptimeMillis();
    }

    public void commitAnimationold(Object obj) {
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        this.hasCheckParams = false;
        this.isOver = true;
        float f10 = this.velocityX;
        float f11 = this.velocityY;
        float sqrt = ((float) Math.sqrt((f10 * f10) + (f11 * f11))) / 1000.0f;
        if (sqrt >= 0.1f) {
            float f12 = sqrt * 0.02f;
            if (this.fromCenter == null) {
                this.fromCenter = IPoint.obtain();
            }
            gLMapState.getMapGeoCenter(this.fromCenter);
            this.isOver = false;
            this.moveParam.setFromValue(this.screenCenterX, this.screenCenterY);
            this.moveParam.setToValue(this.screenCenterX - (this.velocityX * f12), this.screenCenterY - (this.velocityY * f12));
            this.needMove = this.moveParam.needToCaculate();
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
        int curXValue = (int) this.moveParam.getCurXValue();
        int curYValue = (int) this.moveParam.getCurYValue();
        IPoint obtain = IPoint.obtain();
        gLMapState.screenToP20Point((this.screenCenterX + curXValue) - this.lastMoveX, (this.screenCenterY + curYValue) - this.lastMoveY, obtain);
        gLMapState.setMapGeoCenter(((Point) obtain).x, ((Point) obtain).y);
        this.lastMoveX = curXValue;
        this.lastMoveY = curYValue;
        obtain.recycle();
    }

    public void reset() {
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
        this.velocityX = 0.0f;
        this.velocityY = 0.0f;
        this.needMove = false;
        this.hasCheckParams = false;
    }

    public void setPositionAndVelocity(float f10, float f11) {
        this.moveParam = null;
        this.velocityX = f10;
        this.velocityY = f11;
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = new AbstractAdglAnimationParam2V();
        this.moveParam = abstractAdglAnimationParam2V;
        abstractAdglAnimationParam2V.setInterpolatorType(2, 1.2f);
        this.needMove = false;
        this.hasCheckParams = false;
    }
}
