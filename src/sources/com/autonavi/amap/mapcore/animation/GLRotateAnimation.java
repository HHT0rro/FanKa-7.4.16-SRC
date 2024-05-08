package com.autonavi.amap.mapcore.animation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GLRotateAnimation extends GLAnimation {
    private float mFromDegrees;
    private float mToDegrees;

    public GLRotateAnimation(float f10, float f11, float f12, float f13, float f14) {
        this.mFromDegrees = f10;
        this.mToDegrees = f11;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f10, GLTransformation gLTransformation) {
        float f11 = this.mFromDegrees;
        gLTransformation.rotate = f11 + ((this.mToDegrees - f11) * f10);
    }
}
