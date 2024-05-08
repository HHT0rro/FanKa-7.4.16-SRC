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
public class DecelerateInterpolator extends BaseInterpolator implements NativeInterpolator {
    private float mFactor;

    public DecelerateInterpolator() {
        this.mFactor = 1.0f;
    }

    public DecelerateInterpolator(float factor) {
        this.mFactor = 1.0f;
        this.mFactor = factor;
    }

    public DecelerateInterpolator(Context context, AttributeSet attrs) {
        this(context.getResources(), context.getTheme(), attrs);
    }

    public DecelerateInterpolator(Resources res, Resources.Theme theme, AttributeSet attrs) {
        TypedArray a10;
        this.mFactor = 1.0f;
        if (theme != null) {
            a10 = theme.obtainStyledAttributes(attrs, R.styleable.DecelerateInterpolator, 0, 0);
        } else {
            a10 = res.obtainAttributes(attrs, R.styleable.DecelerateInterpolator);
        }
        this.mFactor = a10.getFloat(0, 1.0f);
        setChangingConfiguration(a10.getChangingConfigurations());
        a10.recycle();
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float input) {
        if (this.mFactor == 1.0f) {
            float result = 1.0f - ((1.0f - input) * (1.0f - input));
            return result;
        }
        float result2 = 1.0f - input;
        return (float) (1.0d - Math.pow(result2, r0 * 2.0f));
    }

    public long createNativeInterpolator() {
        return NativeInterpolatorFactory.createDecelerateInterpolator(this.mFactor);
    }
}
