package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLScaleAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ScaleAnimation extends Animation {

    @JBindingInclude
    private float mFromX;

    @JBindingInclude
    private float mFromY;

    @JBindingInclude
    private float mPivotX;

    @JBindingInclude
    private float mPivotY;

    @JBindingInclude
    private float mToX;

    @JBindingInclude
    private float mToY;

    public ScaleAnimation(float f10, float f11, float f12, float f13) {
        this.glAnimation = new GLScaleAnimation(f10, f11, f12, f13);
        this.mFromX = f10;
        this.mToX = f11;
        this.mFromY = f12;
        this.mToY = f13;
        this.mPivotX = 0.0f;
        this.mPivotY = 0.0f;
        setFillMode(1);
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public String getAnimationType() {
        return "ScaleAnimation";
    }
}
