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
public class AnticipateInterpolator extends BaseInterpolator implements NativeInterpolator {
    private final float mTension;

    public AnticipateInterpolator() {
        this.mTension = 2.0f;
    }

    public AnticipateInterpolator(float tension) {
        this.mTension = tension;
    }

    public AnticipateInterpolator(Context context, AttributeSet attrs) {
        this(context.getResources(), context.getTheme(), attrs);
    }

    public AnticipateInterpolator(Resources res, Resources.Theme theme, AttributeSet attrs) {
        TypedArray a10;
        if (theme != null) {
            a10 = theme.obtainStyledAttributes(attrs, R.styleable.AnticipateInterpolator, 0, 0);
        } else {
            a10 = res.obtainAttributes(attrs, R.styleable.AnticipateInterpolator);
        }
        this.mTension = a10.getFloat(0, 2.0f);
        setChangingConfiguration(a10.getChangingConfigurations());
        a10.recycle();
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float t2) {
        float f10 = this.mTension;
        return t2 * t2 * (((1.0f + f10) * t2) - f10);
    }

    public long createNativeInterpolator() {
        return NativeInterpolatorFactory.createAnticipateInterpolator(this.mTension);
    }
}
