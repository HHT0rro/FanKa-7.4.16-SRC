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
public class BounceInterpolator extends BaseInterpolator implements NativeInterpolator {
    public BounceInterpolator() {
    }

    public BounceInterpolator(Context context, AttributeSet attrs) {
    }

    private static float bounce(float t2) {
        return t2 * t2 * 8.0f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float t2) {
        float t10 = t2 * 1.1226f;
        return t10 < 0.3535f ? bounce(t10) : t10 < 0.7408f ? bounce(t10 - 0.54719f) + 0.7f : t10 < 0.9644f ? bounce(t10 - 0.8526f) + 0.9f : bounce(t10 - 1.0435f) + 0.95f;
    }

    public long createNativeInterpolator() {
        return NativeInterpolatorFactory.createBounceInterpolator();
    }
}
