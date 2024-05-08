package android.view.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.Animation;
import com.android.internal.R;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class TranslateAnimation extends Animation {
    protected float mFromXDelta;
    private int mFromXType;
    protected float mFromXValue;
    protected float mFromYDelta;
    private int mFromYType;
    protected float mFromYValue;
    private int mParentWidth;
    protected float mToXDelta;
    private int mToXType;
    protected float mToXValue;
    protected float mToYDelta;
    private int mToYType;
    protected float mToYValue;
    private ITranslateAnimationWrapper mTranslateAnimationWrapper;
    private int mWidth;

    public TranslateAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mFromXType = 0;
        this.mToXType = 0;
        this.mFromYType = 0;
        this.mToYType = 0;
        this.mFromXValue = 0.0f;
        this.mToXValue = 0.0f;
        this.mFromYValue = 0.0f;
        this.mToYValue = 0.0f;
        this.mTranslateAnimationWrapper = new TranslateAnimationWrapper();
        TypedArray a10 = context.obtainStyledAttributes(attrs, R.styleable.TranslateAnimation);
        Animation.Description d10 = Animation.Description.parseValue(a10.peekValue(0), context);
        this.mFromXType = d10.type;
        this.mFromXValue = d10.value;
        Animation.Description d11 = Animation.Description.parseValue(a10.peekValue(1), context);
        this.mToXType = d11.type;
        this.mToXValue = d11.value;
        Animation.Description d12 = Animation.Description.parseValue(a10.peekValue(2), context);
        this.mFromYType = d12.type;
        this.mFromYValue = d12.value;
        Animation.Description d13 = Animation.Description.parseValue(a10.peekValue(3), context);
        this.mToYType = d13.type;
        this.mToYValue = d13.value;
        a10.recycle();
    }

    public TranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {
        this.mFromXType = 0;
        this.mToXType = 0;
        this.mFromYType = 0;
        this.mToYType = 0;
        this.mFromXValue = 0.0f;
        this.mToXValue = 0.0f;
        this.mFromYValue = 0.0f;
        this.mToYValue = 0.0f;
        this.mTranslateAnimationWrapper = new TranslateAnimationWrapper();
        this.mFromXValue = fromXDelta;
        this.mToXValue = toXDelta;
        this.mFromYValue = fromYDelta;
        this.mToYValue = toYDelta;
        this.mFromXType = 0;
        this.mToXType = 0;
        this.mFromYType = 0;
        this.mToYType = 0;
    }

    public TranslateAnimation(int fromXType, float fromXValue, int toXType, float toXValue, int fromYType, float fromYValue, int toYType, float toYValue) {
        this.mFromXType = 0;
        this.mToXType = 0;
        this.mFromYType = 0;
        this.mToYType = 0;
        this.mFromXValue = 0.0f;
        this.mToXValue = 0.0f;
        this.mFromYValue = 0.0f;
        this.mToYValue = 0.0f;
        this.mTranslateAnimationWrapper = new TranslateAnimationWrapper();
        this.mFromXValue = fromXValue;
        this.mToXValue = toXValue;
        this.mFromYValue = fromYValue;
        this.mToYValue = toYValue;
        this.mFromXType = fromXType;
        this.mToXType = toXType;
        this.mFromYType = fromYType;
        this.mToYType = toYType;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float interpolatedTime, Transformation t2) {
        float dx = this.mFromXDelta;
        float dy = this.mFromYDelta;
        float f10 = this.mFromXDelta;
        float f11 = this.mToXDelta;
        if (f10 != f11) {
            dx = f10 + ((f11 - f10) * interpolatedTime);
        }
        float f12 = this.mFromYDelta;
        float f13 = this.mToYDelta;
        if (f12 != f13) {
            dy = f12 + ((f13 - f12) * interpolatedTime);
        }
        t2.getMatrix().setTranslate(dx, dy);
    }

    @Override // android.view.animation.Animation
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        this.mFromXDelta = resolveSize(this.mFromXType, this.mFromXValue, width, parentWidth);
        this.mToXDelta = resolveSize(this.mToXType, this.mToXValue, width, parentWidth);
        this.mFromYDelta = resolveSize(this.mFromYType, this.mFromYValue, height, parentHeight);
        this.mToYDelta = resolveSize(this.mToYType, this.mToYValue, height, parentHeight);
        this.mWidth = width;
        this.mParentWidth = parentWidth;
    }

    public boolean isXAxisTransition() {
        return this.mFromXDelta - this.mToXDelta != 0.0f && this.mFromYDelta - this.mToYDelta == 0.0f;
    }

    public boolean isFullWidthTranslate() {
        boolean isXAxisSlideTransition = isSlideInLeft() || isSlideOutRight() || isSlideInRight() || isSlideOutLeft();
        return this.mWidth == this.mParentWidth && isXAxisSlideTransition;
    }

    private boolean isSlideInLeft() {
        boolean startsOutOfParentOnLeft = this.mFromXDelta <= ((float) (-this.mWidth));
        return startsOutOfParentOnLeft && endsXEnclosedWithinParent();
    }

    private boolean isSlideOutRight() {
        boolean endOutOfParentOnRight = this.mToXDelta >= ((float) this.mParentWidth);
        return startsXEnclosedWithinParent() && endOutOfParentOnRight;
    }

    private boolean isSlideInRight() {
        boolean startsOutOfParentOnRight = this.mFromXDelta >= ((float) this.mParentWidth);
        return startsOutOfParentOnRight && endsXEnclosedWithinParent();
    }

    private boolean isSlideOutLeft() {
        boolean endOutOfParentOnLeft = this.mToXDelta <= ((float) (-this.mWidth));
        return startsXEnclosedWithinParent() && endOutOfParentOnLeft;
    }

    private boolean endsXEnclosedWithinParent() {
        int i10 = this.mWidth;
        int i11 = this.mParentWidth;
        if (i10 <= i11) {
            float f10 = this.mToXDelta;
            if (i10 + f10 <= i11 && f10 >= 0.0f) {
                return true;
            }
        }
        return false;
    }

    private boolean startsXEnclosedWithinParent() {
        int i10 = this.mWidth;
        int i11 = this.mParentWidth;
        if (i10 <= i11) {
            float f10 = this.mFromXDelta;
            if (i10 + f10 <= i11 && f10 >= 0.0f) {
                return true;
            }
        }
        return false;
    }

    public ITranslateAnimationWrapper getWrapper() {
        return this.mTranslateAnimationWrapper;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class TranslateAnimationWrapper implements ITranslateAnimationWrapper {
        private TranslateAnimationWrapper() {
        }

        @Override // android.view.animation.ITranslateAnimationWrapper
        public float getFromXValue() {
            return TranslateAnimation.this.mFromXValue;
        }

        @Override // android.view.animation.ITranslateAnimationWrapper
        public void setFromXValue(float value) {
            TranslateAnimation.this.mFromXValue = value;
        }

        @Override // android.view.animation.ITranslateAnimationWrapper
        public float getToXValue() {
            return TranslateAnimation.this.mToXValue;
        }
    }
}
