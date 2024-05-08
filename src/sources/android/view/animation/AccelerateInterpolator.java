package android.view.animation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.animation.HasNativeInterpolator;
import android.graphics.animation.NativeInterpolator;
import android.graphics.animation.NativeInterpolatorFactory;
import android.util.AttributeSet;
import com.android.internal.R;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@HasNativeInterpolator
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AccelerateInterpolator extends BaseInterpolator implements NativeInterpolator {
    private final double mDoubleFactor;
    private final float mFactor;

    public AccelerateInterpolator() {
        this.mFactor = 1.0f;
        this.mDoubleFactor = 2.0d;
    }

    public AccelerateInterpolator(float factor) {
        this.mFactor = factor;
        this.mDoubleFactor = 2.0f * factor;
    }

    public AccelerateInterpolator(Context context, AttributeSet attrs) {
        this(context.getResources(), context.getTheme(), attrs);
    }

    public AccelerateInterpolator(Resources res, Resources.Theme theme, AttributeSet attrs) {
        TypedArray a10;
        if (theme != null) {
            a10 = theme.obtainStyledAttributes(attrs, R.styleable.AccelerateInterpolator, 0, 0);
        } else {
            a10 = res.obtainAttributes(attrs, R.styleable.AccelerateInterpolator);
        }
        this.mFactor = a10.getFloat(0, 1.0f);
        this.mDoubleFactor = r0 * 2.0f;
        setChangingConfiguration(a10.getChangingConfigurations());
        a10.recycle();
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float input) {
        if (this.mFactor == 1.0f) {
            return input * input;
        }
        return (float) Math.pow(input, this.mDoubleFactor);
    }

    public long createNativeInterpolator() {
        return NativeInterpolatorFactory.createAccelerateInterpolator(this.mFactor);
    }
}
