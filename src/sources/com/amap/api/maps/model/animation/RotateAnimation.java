package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLRotateAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RotateAnimation extends Animation {

    @JBindingInclude
    private float mFromDegrees;

    @JBindingInclude
    private float mToDegrees;

    public RotateAnimation(float f10, float f11, float f12, float f13, float f14) {
        this.mFromDegrees = 0.0f;
        this.mToDegrees = 1.0f;
        this.glAnimation = new GLRotateAnimation(f10, f11, f12, f13, f14);
        this.mFromDegrees = f10;
        this.mToDegrees = f11;
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public String getAnimationType() {
        return "RotateAnimation";
    }

    public RotateAnimation(float f10, float f11) {
        this.mFromDegrees = 0.0f;
        this.mToDegrees = 1.0f;
        this.glAnimation = new GLRotateAnimation(f10, f11, 0.0f, 0.0f, 0.0f);
        this.mFromDegrees = f10;
        this.mToDegrees = f11;
    }
}
