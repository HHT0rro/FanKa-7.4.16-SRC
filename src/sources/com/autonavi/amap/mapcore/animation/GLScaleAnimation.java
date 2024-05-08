package com.autonavi.amap.mapcore.animation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GLScaleAnimation extends GLAnimation {
    private float mFromX;
    private float mFromY;
    private float mPivotX = 0.0f;
    private float mPivotY = 0.0f;
    private float mToX;
    private float mToY;

    public GLScaleAnimation(float f10, float f11, float f12, float f13) {
        this.mFromX = f10;
        this.mToX = f11;
        this.mFromY = f12;
        this.mToY = f13;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f10, GLTransformation gLTransformation) {
        float f11 = this.mFromX;
        float f12 = (f11 == 1.0f && this.mToX == 1.0f) ? 1.0f : f11 + ((this.mToX - f11) * f10);
        float f13 = this.mFromY;
        float f14 = (f13 == 1.0f && this.mToY == 1.0f) ? 1.0f : ((this.mToY - f13) * f10) + f13;
        gLTransformation.scaleX = f12;
        gLTransformation.scaleY = f14;
    }
}
