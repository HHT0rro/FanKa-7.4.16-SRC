package androidx.constraintlayout.motion.widget;

import android.view.animation.Interpolator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class MotionInterpolator implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public abstract float getInterpolation(float f10);

    public abstract float getVelocity();
}
