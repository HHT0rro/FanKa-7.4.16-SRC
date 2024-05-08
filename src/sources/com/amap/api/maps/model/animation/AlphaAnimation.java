package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLAlphaAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AlphaAnimation extends Animation {

    @JBindingInclude
    private float mFromAlpha;

    @JBindingInclude
    private float mToAlpha;

    public AlphaAnimation(float f10, float f11) {
        this.mFromAlpha = 0.0f;
        this.mToAlpha = 1.0f;
        this.glAnimation = new GLAlphaAnimation(f10, f11);
        this.mFromAlpha = f10;
        this.mToAlpha = f11;
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public String getAnimationType() {
        return "AlphaAnimation";
    }
}
