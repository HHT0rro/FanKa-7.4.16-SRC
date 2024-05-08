package android.view.animation;

import android.graphics.Matrix;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class TranslateXAnimation extends TranslateAnimation {
    float[] mTmpValues;

    public TranslateXAnimation(float fromXDelta, float toXDelta) {
        super(fromXDelta, toXDelta, 0.0f, 0.0f);
        this.mTmpValues = new float[9];
    }

    public TranslateXAnimation(int fromXType, float fromXValue, int toXType, float toXValue) {
        super(fromXType, fromXValue, toXType, toXValue, 0, 0.0f, 0, 0.0f);
        this.mTmpValues = new float[9];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.animation.TranslateAnimation, android.view.animation.Animation
    public void applyTransformation(float interpolatedTime, Transformation t2) {
        Matrix m10 = t2.getMatrix();
        m10.getValues(this.mTmpValues);
        float dx = this.mFromXDelta + ((this.mToXDelta - this.mFromXDelta) * interpolatedTime);
        t2.getMatrix().setTranslate(dx, this.mTmpValues[5]);
    }
}
