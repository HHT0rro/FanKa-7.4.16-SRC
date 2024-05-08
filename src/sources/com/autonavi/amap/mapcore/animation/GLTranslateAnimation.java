package com.autonavi.amap.mapcore.animation;

import com.amap.api.maps.model.LatLng;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GLTranslateAnimation extends GLAnimation {
    public double mToXDelta;
    public double mToYDelta;
    public double mFromXDelta = ShadowDrawableWrapper.COS_45;
    public double mFromYDelta = ShadowDrawableWrapper.COS_45;
    public double mCurXDelta = ShadowDrawableWrapper.COS_45;
    public double mCurYDelta = ShadowDrawableWrapper.COS_45;

    public GLTranslateAnimation(LatLng latLng) {
        this.mToXDelta = ShadowDrawableWrapper.COS_45;
        this.mToYDelta = ShadowDrawableWrapper.COS_45;
        this.mToXDelta = latLng.longitude;
        this.mToYDelta = latLng.latitude;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f10, GLTransformation gLTransformation) {
        double d10 = this.mFromXDelta;
        this.mCurXDelta = d10;
        double d11 = this.mFromYDelta;
        this.mCurYDelta = d11;
        double d12 = this.mToXDelta;
        if (d10 != d12) {
            this.mCurXDelta = d10 + ((d12 - d10) * f10);
        }
        double d13 = this.mToYDelta;
        if (d11 != d13) {
            this.mCurYDelta = d11 + ((d13 - d11) * f10);
        }
        gLTransformation.f9305x = this.mCurXDelta;
        gLTransformation.f9306y = this.mCurYDelta;
    }

    public void setFromPoint(LatLng latLng) {
        this.mFromXDelta = latLng.longitude;
        this.mFromYDelta = latLng.latitude;
    }
}
