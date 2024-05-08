package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    public LookupTableInterpolator(float[] fArr) {
        this.mValues = fArr;
        this.mStepSize = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        if (f10 >= 1.0f) {
            return 1.0f;
        }
        if (f10 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.mValues;
        int min = Math.min((int) ((fArr.length - 1) * f10), fArr.length - 2);
        float f11 = this.mStepSize;
        float f12 = (f10 - (min * f11)) / f11;
        float[] fArr2 = this.mValues;
        return fArr2[min] + (f12 * (fArr2[min + 1] - fArr2[min]));
    }
}
