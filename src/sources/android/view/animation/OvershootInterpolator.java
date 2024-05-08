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
public class OvershootInterpolator extends BaseInterpolator implements NativeInterpolator {
    private final float mTension;

    public OvershootInterpolator() {
        this.mTension = 2.0f;
    }

    public OvershootInterpolator(float tension) {
        this.mTension = tension;
    }

    public OvershootInterpolator(Context context, AttributeSet attrs) {
        this(context.getResources(), context.getTheme(), attrs);
    }

    public OvershootInterpolator(Resources res, Resources.Theme theme, AttributeSet attrs) {
        TypedArray a10;
        if (theme != null) {
            a10 = theme.obtainStyledAttributes(attrs, R.styleable.OvershootInterpolator, 0, 0);
        } else {
            a10 = res.obtainAttributes(attrs, R.styleable.OvershootInterpolator);
        }
        this.mTension = a10.getFloat(0, 2.0f);
        setChangingConfiguration(a10.getChangingConfigurations());
        a10.recycle();
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float t2) {
        float t10 = t2 - 1.0f;
        float f10 = this.mTension;
        return (t10 * t10 * (((f10 + 1.0f) * t10) + f10)) + 1.0f;
    }

    public long createNativeInterpolator() {
        return NativeInterpolatorFactory.createOvershootInterpolator(this.mTension);
    }
}
