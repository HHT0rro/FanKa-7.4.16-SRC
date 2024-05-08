package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AdglMapAnimGroup extends AbstractAdglAnimation {
    public static final int CAMERA_MAX_DEGREE = 80;
    public static final int CAMERA_MIN_DEGREE = 0;
    public static final int MAXMAPLEVEL = 20;
    public static final int MINMAPLEVEL = 3;
    public int endZoomDuration;
    public boolean hasCheckParams;
    public boolean hasMidZoom;
    public int midZoomDuration;
    public boolean needMove;
    public boolean needRotateCamera;
    public boolean needRotateMap;
    public boolean needZoom;
    public int startZoomDuration;
    public AbstractAdglAnimationParam1V zoomStartParam = null;
    public AbstractAdglAnimationParam1V zoomEndParam = null;
    public AbstractAdglAnimationParam2V moveParam = null;
    public AbstractAdglAnimationParam1V rotateMapParam = null;
    public AbstractAdglAnimationParam1V rotateCameraParam = null;

    public AdglMapAnimGroup(int i10) {
        reset();
        this.duration = i10;
    }

    public static boolean checkLevel(float f10) {
        return f10 >= 3.0f && f10 <= 20.0f;
    }

    private void initZoomEndParam(float f10, float f11, int i10) {
        if (this.zoomEndParam == null) {
            this.zoomEndParam = new AbstractAdglAnimationParam1V();
        }
        this.zoomEndParam.reset();
        this.zoomEndParam.setInterpolatorType(i10, 1.0f);
        this.zoomEndParam.setToValue(f11);
        this.zoomEndParam.setFromValue(f10);
    }

    private void initZoomStartParam(float f10, int i10) {
        if (this.zoomStartParam == null) {
            this.zoomStartParam = new AbstractAdglAnimationParam1V();
        }
        this.zoomStartParam.reset();
        this.zoomStartParam.setInterpolatorType(i10, 1.0f);
        this.zoomStartParam.setToValue(f10);
    }

    public void commitAnimation(Object obj) {
        this.isOver = true;
        this.hasCheckParams = false;
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        if (this.needZoom) {
            if (this.zoomStartParam == null) {
                this.hasCheckParams = true;
                return;
            }
            float mapZoomer = gLMapState.getMapZoomer();
            this.zoomStartParam.setFromValue(mapZoomer);
            if (this.hasMidZoom) {
                float toValue = this.zoomStartParam.getToValue() - mapZoomer;
                float fromValue = this.zoomEndParam.getFromValue() - this.zoomEndParam.getToValue();
                if (Math.abs(toValue) >= 1.0E-6d && Math.abs(fromValue) >= 1.0E-6d) {
                    this.zoomStartParam.needToCaculate();
                    this.zoomEndParam.needToCaculate();
                } else {
                    this.hasMidZoom = false;
                    this.zoomStartParam.setToValue(this.zoomEndParam.getToValue());
                    this.zoomStartParam.needToCaculate();
                    this.zoomEndParam = null;
                }
            }
            if (!this.hasMidZoom && Math.abs(this.zoomStartParam.getFromValue() - this.zoomStartParam.getToValue()) < 1.0E-6d) {
                this.needZoom = false;
            }
            if (this.needZoom) {
                if (this.hasMidZoom) {
                    int i10 = (this.duration - this.midZoomDuration) >> 1;
                    this.startZoomDuration = i10;
                    this.endZoomDuration = i10;
                } else {
                    this.startZoomDuration = this.duration;
                }
            }
        }
        if (this.needMove && this.moveParam != null) {
            IPoint obtain = IPoint.obtain();
            gLMapState.getMapGeoCenter(obtain);
            int i11 = ((Point) obtain).x;
            int i12 = ((Point) obtain).y;
            obtain.recycle();
            this.moveParam.setFromValue(i11, i12);
            this.needMove = this.moveParam.needToCaculate();
        }
        if (this.needRotateMap && this.rotateMapParam != null) {
            float mapAngle = gLMapState.getMapAngle();
            float toValue2 = this.rotateMapParam.getToValue();
            if (mapAngle > 180.0f && toValue2 == 0.0f) {
                toValue2 = 360.0f;
            }
            float f10 = ((int) toValue2) - ((int) mapAngle);
            if (f10 > 180.0f) {
                toValue2 -= 360.0f;
            } else if (f10 < -180.0f) {
                toValue2 += 360.0f;
            }
            this.rotateMapParam.setFromValue(mapAngle);
            this.rotateMapParam.setToValue(toValue2);
            this.needRotateMap = this.rotateMapParam.needToCaculate();
        }
        if (this.needRotateCamera && this.rotateCameraParam != null) {
            this.rotateCameraParam.setFromValue(gLMapState.getCameraDegree());
            this.needRotateCamera = this.rotateCameraParam.needToCaculate();
        }
        if (!this.needMove && !this.needZoom && !this.needRotateMap && !this.needRotateCamera) {
            this.isOver = true;
        } else {
            this.isOver = false;
        }
        this.hasCheckParams = true;
        this.startTime = SystemClock.uptimeMillis();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object obj) {
        float curValue;
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
        int i10 = this.duration;
        if (i10 == 0.0f) {
            this.isOver = true;
            return;
        }
        float f10 = ((float) uptimeMillis) / i10;
        if (f10 > 1.0f) {
            this.isOver = true;
            f10 = 1.0f;
        } else if (f10 < 0.0f) {
            this.isOver = true;
            return;
        }
        if (this.needZoom) {
            gLMapState.getMapZoomer();
            if (this.hasMidZoom) {
                long j10 = this.offsetTime;
                int i11 = this.startZoomDuration;
                if (j10 <= i11) {
                    this.zoomStartParam.setNormalizedTime(((float) j10) / i11);
                    curValue = this.zoomStartParam.getCurValue();
                } else {
                    int i12 = this.midZoomDuration;
                    if (j10 <= i11 + i12) {
                        curValue = this.zoomStartParam.getToValue();
                    } else {
                        this.zoomEndParam.setNormalizedTime(((float) ((j10 - i11) - i12)) / this.endZoomDuration);
                        curValue = this.zoomEndParam.getCurValue();
                    }
                }
                if (this.isOver) {
                    curValue = this.zoomEndParam.getToValue();
                }
            } else {
                this.zoomStartParam.setNormalizedTime(f10);
                curValue = this.zoomStartParam.getCurValue();
            }
            gLMapState.setMapZoomer(curValue);
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null && this.needMove) {
            abstractAdglAnimationParam2V.setNormalizedTime(f10);
            int fromXValue = (int) this.moveParam.getFromXValue();
            int fromYValue = (int) this.moveParam.getFromYValue();
            int toXValue = (int) this.moveParam.getToXValue();
            int toYValue = (int) this.moveParam.getToYValue();
            float curMult = this.moveParam.getCurMult();
            gLMapState.setMapGeoCenter(fromXValue + ((int) ((toXValue - fromXValue) * curMult)), fromYValue + ((int) ((toYValue - fromYValue) * curMult)));
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.rotateMapParam;
        if (abstractAdglAnimationParam1V != null && this.needRotateMap) {
            abstractAdglAnimationParam1V.setNormalizedTime(f10);
            gLMapState.setMapAngle((int) this.rotateMapParam.getCurValue());
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V2 = this.rotateCameraParam;
        if (abstractAdglAnimationParam1V2 == null || !this.needRotateCamera) {
            return;
        }
        abstractAdglAnimationParam1V2.setNormalizedTime(f10);
        gLMapState.setCameraDegree((int) this.rotateCameraParam.getCurValue());
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public boolean isValid() {
        return this.needRotateCamera || this.needRotateMap || this.needMove || this.needZoom;
    }

    public void reset() {
        this.isOver = false;
        this.hasCheckParams = false;
        this.needZoom = false;
        this.needMove = false;
        this.moveParam = null;
        this.needRotateMap = false;
        this.rotateMapParam = null;
        this.hasMidZoom = false;
        this.duration = 0;
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V = this.zoomStartParam;
        if (abstractAdglAnimationParam1V != null) {
            abstractAdglAnimationParam1V.reset();
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V2 = this.zoomEndParam;
        if (abstractAdglAnimationParam1V2 != null) {
            abstractAdglAnimationParam1V2.reset();
        }
        AbstractAdglAnimationParam1V abstractAdglAnimationParam1V3 = this.rotateCameraParam;
        if (abstractAdglAnimationParam1V3 != null) {
            abstractAdglAnimationParam1V3.reset();
        }
    }

    public void setDuration(int i10) {
        this.duration = i10;
    }

    public void setToCameraDegree(float f10, int i10) {
        this.needRotateCamera = false;
        if (f10 > 80.0f || f10 < 0.0f) {
            return;
        }
        this.needRotateCamera = true;
        if (this.rotateCameraParam == null) {
            this.rotateCameraParam = new AbstractAdglAnimationParam1V();
        }
        this.rotateCameraParam.reset();
        this.rotateCameraParam.setInterpolatorType(i10, 1.0f);
        this.rotateCameraParam.setToValue(f10);
    }

    public void setToMapAngle(float f10, int i10) {
        float f11 = f10 % 360.0f;
        this.needRotateMap = true;
        if (this.rotateMapParam == null) {
            this.rotateMapParam = new AbstractAdglAnimationParam1V();
        }
        this.rotateMapParam.reset();
        this.rotateMapParam.setInterpolatorType(i10, 1.0f);
        this.rotateMapParam.setToValue(f11);
    }

    public void setToMapCenterGeo(int i10, int i11, int i12) {
        if (i10 <= 0 || i11 <= 0) {
            return;
        }
        this.needMove = true;
        if (this.moveParam == null) {
            this.moveParam = new AbstractAdglAnimationParam2V();
        }
        this.moveParam.reset();
        this.moveParam.setInterpolatorType(i12, 1.0f);
        this.moveParam.setToValue(i10, i11);
    }

    public void setToMapLevel(float f10, int i10) {
        this.needZoom = true;
        this.midZoomDuration = 0;
        this.hasMidZoom = false;
        if (checkLevel(f10)) {
            initZoomStartParam(f10, i10);
        } else {
            this.needZoom = false;
        }
    }

    public boolean typeEqueal(AdglMapAnimGroup adglMapAnimGroup) {
        return this.needRotateCamera == adglMapAnimGroup.needRotateCamera && this.needRotateMap == adglMapAnimGroup.needRotateMap && this.needZoom == adglMapAnimGroup.needZoom && this.needMove == adglMapAnimGroup.needMove;
    }

    public void setToMapLevel(float f10, float f11, int i10) {
        this.needZoom = true;
        this.midZoomDuration = 0;
        this.hasMidZoom = false;
        if (i10 > 0 && i10 < this.duration) {
            this.midZoomDuration = i10;
        }
        if (checkLevel(f10) && checkLevel(f11)) {
            this.hasMidZoom = true;
            initZoomStartParam(f11, 0);
            initZoomEndParam(f11, f10, 0);
        } else if (checkLevel(f10)) {
            this.hasMidZoom = false;
            initZoomStartParam(f10, 0);
        } else if (checkLevel(f11)) {
            this.hasMidZoom = false;
            initZoomStartParam(f11, 0);
        } else {
            this.needZoom = false;
        }
    }
}
