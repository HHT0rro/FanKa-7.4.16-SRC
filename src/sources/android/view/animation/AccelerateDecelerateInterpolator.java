package android.view.animation;

import android.content.Context;
import android.graphics.animation.HasNativeInterpolator;
import android.graphics.animation.NativeInterpolator;
import android.graphics.animation.NativeInterpolatorFactory;
import android.util.AttributeSet;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@HasNativeInterpolator
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AccelerateDecelerateInterpolator extends BaseInterpolator implements NativeInterpolator {
    public AccelerateDecelerateInterpolator() {
    }

    public AccelerateDecelerateInterpolator(Context context, AttributeSet attrs) {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float input) {
        return ((float) (Math.cos((1.0f + input) * 3.141592653589793d) / 2.0d)) + 0.5f;
    }

    public long createNativeInterpolator() {
        return NativeInterpolatorFactory.createAccelerateDecelerateInterpolator();
    }
}
