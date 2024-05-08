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
public class AnticipateOvershootInterpolator extends BaseInterpolator implements NativeInterpolator {
    private final float mTension;

    public AnticipateOvershootInterpolator() {
        this.mTension = 3.0f;
    }

    public AnticipateOvershootInterpolator(float tension) {
        this.mTension = 1.5f * tension;
    }

    public AnticipateOvershootInterpolator(float tension, float extraTension) {
        this.mTension = tension * extraTension;
    }

    public AnticipateOvershootInterpolator(Context context, AttributeSet attrs) {
        this(context.getResources(), context.getTheme(), attrs);
    }

    public AnticipateOvershootInterpolator(Resources res, Resources.Theme theme, AttributeSet attrs) {
        TypedArray a10;
        if (theme != null) {
            a10 = theme.obtainStyledAttributes(attrs, R.styleable.AnticipateOvershootInterpolator, 0, 0);
        } else {
            a10 = res.obtainAttributes(attrs, R.styleable.AnticipateOvershootInterpolator);
        }
        this.mTension = a10.getFloat(0, 2.0f) * a10.getFloat(1, 1.5f);
        setChangingConfiguration(a10.getChangingConfigurations());
        a10.recycle();
    }

    private static float a(float t2, float s2) {
        return t2 * t2 * (((1.0f + s2) * t2) - s2);
    }

    private static float o(float t2, float s2) {
        return t2 * t2 * (((1.0f + s2) * t2) + s2);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float t2) {
        return t2 < 0.5f ? a(2.0f * t2, this.mTension) * 0.5f : (o((t2 * 2.0f) - 2.0f, this.mTension) + 2.0f) * 0.5f;
    }

    public long createNativeInterpolator() {
        return NativeInterpolatorFactory.createAnticipateOvershootInterpolator(this.mTension);
    }
}
