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
public class CycleInterpolator extends BaseInterpolator implements NativeInterpolator {
    private float mCycles;

    public CycleInterpolator(float cycles) {
        this.mCycles = cycles;
    }

    public CycleInterpolator(Context context, AttributeSet attrs) {
        this(context.getResources(), context.getTheme(), attrs);
    }

    public CycleInterpolator(Resources resources, Resources.Theme theme, AttributeSet attrs) {
        TypedArray a10;
        if (theme != null) {
            a10 = theme.obtainStyledAttributes(attrs, R.styleable.CycleInterpolator, 0, 0);
        } else {
            a10 = resources.obtainAttributes(attrs, R.styleable.CycleInterpolator);
        }
        this.mCycles = a10.getFloat(0, 1.0f);
        setChangingConfiguration(a10.getChangingConfigurations());
        a10.recycle();
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float input) {
        return (float) Math.sin(this.mCycles * 2.0f * 3.141592653589793d * input);
    }

    public long createNativeInterpolator() {
        return NativeInterpolatorFactory.createCycleInterpolator(this.mCycles);
    }
}
