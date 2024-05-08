package com.autonavi.amap.mapcore.animation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GLAlphaAnimation extends GLAnimation {
    public float mCurAlpha = 0.0f;
    public float mFromAlpha;
    public float mToAlpha;

    public GLAlphaAnimation(float f10, float f11) {
        this.mFromAlpha = f10;
        this.mToAlpha = f11;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f10, GLTransformation gLTransformation) {
        float f11 = this.mFromAlpha;
        float f12 = f11 + ((this.mToAlpha - f11) * f10);
        this.mCurAlpha = f12;
        gLTransformation.alpha = f12;
    }
}
