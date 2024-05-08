package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.SplineSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class VelocityMatrix {
    private static String TAG = "VelocityMatrix";
    public float mDRotate;
    public float mDScaleX;
    public float mDScaleY;
    public float mDTranslateX;
    public float mDTranslateY;
    public float mRotate;

    public void applyTransform(float f10, float f11, int i10, int i11, float[] fArr) {
        float f12 = fArr[0];
        float f13 = fArr[1];
        float f14 = (f11 - 0.5f) * 2.0f;
        float f15 = f12 + this.mDTranslateX;
        float f16 = f13 + this.mDTranslateY;
        float f17 = f15 + (this.mDScaleX * (f10 - 0.5f) * 2.0f);
        float f18 = f16 + (this.mDScaleY * f14);
        float radians = (float) Math.toRadians(this.mRotate);
        float radians2 = (float) Math.toRadians(this.mDRotate);
        double d10 = radians;
        double d11 = i11 * f14;
        float sin = f17 + (((float) ((((-i10) * r7) * Math.sin(d10)) - (Math.cos(d10) * d11))) * radians2);
        float cos = f18 + (radians2 * ((float) (((i10 * r7) * Math.cos(d10)) - (d11 * Math.sin(d10)))));
        fArr[0] = sin;
        fArr[1] = cos;
    }

    public void clear() {
        this.mDRotate = 0.0f;
        this.mDTranslateY = 0.0f;
        this.mDTranslateX = 0.0f;
        this.mDScaleY = 0.0f;
        this.mDScaleX = 0.0f;
    }

    public void setRotationVelocity(SplineSet splineSet, float f10) {
        if (splineSet != null) {
            this.mDRotate = splineSet.getSlope(f10);
            this.mRotate = splineSet.get(f10);
        }
    }

    public void setScaleVelocity(SplineSet splineSet, SplineSet splineSet2, float f10) {
        if (splineSet != null) {
            this.mDScaleX = splineSet.getSlope(f10);
        }
        if (splineSet2 != null) {
            this.mDScaleY = splineSet2.getSlope(f10);
        }
    }

    public void setTranslationVelocity(SplineSet splineSet, SplineSet splineSet2, float f10) {
        if (splineSet != null) {
            this.mDTranslateX = splineSet.getSlope(f10);
        }
        if (splineSet2 != null) {
            this.mDTranslateY = splineSet2.getSlope(f10);
        }
    }

    public void setRotationVelocity(KeyCycleOscillator keyCycleOscillator, float f10) {
        if (keyCycleOscillator != null) {
            this.mDRotate = keyCycleOscillator.getSlope(f10);
        }
    }

    public void setScaleVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f10) {
        if (keyCycleOscillator == null && keyCycleOscillator2 == null) {
            return;
        }
        if (keyCycleOscillator == null) {
            this.mDScaleX = keyCycleOscillator.getSlope(f10);
        }
        if (keyCycleOscillator2 == null) {
            this.mDScaleY = keyCycleOscillator2.getSlope(f10);
        }
    }

    public void setTranslationVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f10) {
        if (keyCycleOscillator != null) {
            this.mDTranslateX = keyCycleOscillator.getSlope(f10);
        }
        if (keyCycleOscillator2 != null) {
            this.mDTranslateY = keyCycleOscillator2.getSlope(f10);
        }
    }
}
