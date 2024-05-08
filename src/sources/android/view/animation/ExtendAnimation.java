package android.view.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Insets;
import android.util.AttributeSet;
import android.view.animation.Animation;
import com.android.internal.R;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ExtendAnimation extends Animation {
    private int mFromBottomType;
    private float mFromBottomValue;
    protected Insets mFromInsets;
    private int mFromLeftType;
    private float mFromLeftValue;
    private int mFromRightType;
    private float mFromRightValue;
    private int mFromTopType;
    private float mFromTopValue;
    private int mToBottomType;
    private float mToBottomValue;
    protected Insets mToInsets;
    private int mToLeftType;
    private float mToLeftValue;
    private int mToRightType;
    private float mToRightValue;
    private int mToTopType;
    private float mToTopValue;

    public ExtendAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mFromInsets = Insets.NONE;
        this.mToInsets = Insets.NONE;
        this.mFromLeftType = 0;
        this.mFromTopType = 0;
        this.mFromRightType = 0;
        this.mFromBottomType = 0;
        this.mToLeftType = 0;
        this.mToTopType = 0;
        this.mToRightType = 0;
        this.mToBottomType = 0;
        TypedArray a10 = context.obtainStyledAttributes(attrs, R.styleable.ExtendAnimation);
        Animation.Description d10 = Animation.Description.parseValue(a10.peekValue(0), context);
        this.mFromLeftType = d10.type;
        this.mFromLeftValue = d10.value;
        Animation.Description d11 = Animation.Description.parseValue(a10.peekValue(1), context);
        this.mFromTopType = d11.type;
        this.mFromTopValue = d11.value;
        Animation.Description d12 = Animation.Description.parseValue(a10.peekValue(2), context);
        this.mFromRightType = d12.type;
        this.mFromRightValue = d12.value;
        Animation.Description d13 = Animation.Description.parseValue(a10.peekValue(3), context);
        this.mFromBottomType = d13.type;
        this.mFromBottomValue = d13.value;
        Animation.Description d14 = Animation.Description.parseValue(a10.peekValue(4), context);
        this.mToLeftType = d14.type;
        this.mToLeftValue = d14.value;
        Animation.Description d15 = Animation.Description.parseValue(a10.peekValue(5), context);
        this.mToTopType = d15.type;
        this.mToTopValue = d15.value;
        Animation.Description d16 = Animation.Description.parseValue(a10.peekValue(6), context);
        this.mToRightType = d16.type;
        this.mToRightValue = d16.value;
        Animation.Description d17 = Animation.Description.parseValue(a10.peekValue(7), context);
        this.mToBottomType = d17.type;
        this.mToBottomValue = d17.value;
        a10.recycle();
    }

    public ExtendAnimation(Insets fromInsets, Insets toInsets) {
        this.mFromInsets = Insets.NONE;
        this.mToInsets = Insets.NONE;
        this.mFromLeftType = 0;
        this.mFromTopType = 0;
        this.mFromRightType = 0;
        this.mFromBottomType = 0;
        this.mToLeftType = 0;
        this.mToTopType = 0;
        this.mToRightType = 0;
        this.mToBottomType = 0;
        if (fromInsets == null || toInsets == null) {
            throw new RuntimeException("Expected non-null animation outsets");
        }
        this.mFromLeftValue = -fromInsets.left;
        this.mFromTopValue = -fromInsets.top;
        this.mFromRightValue = -fromInsets.right;
        this.mFromBottomValue = -fromInsets.bottom;
        this.mToLeftValue = -toInsets.left;
        this.mToTopValue = -toInsets.top;
        this.mToRightValue = -toInsets.right;
        this.mToBottomValue = -toInsets.bottom;
    }

    public ExtendAnimation(int fromL, int fromT, int fromR, int fromB, int toL, int toT, int toR, int toB) {
        this(Insets.of(-fromL, -fromT, -fromR, -fromB), Insets.of(-toL, -toT, -toR, -toB));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.animation.Animation
    public void applyTransformation(float it, Transformation tr) {
        int l10 = this.mFromInsets.left + ((int) ((this.mToInsets.left - this.mFromInsets.left) * it));
        int t2 = this.mFromInsets.top + ((int) ((this.mToInsets.top - this.mFromInsets.top) * it));
        int r10 = this.mFromInsets.right + ((int) ((this.mToInsets.right - this.mFromInsets.right) * it));
        int b4 = this.mFromInsets.bottom + ((int) ((this.mToInsets.bottom - this.mFromInsets.bottom) * it));
        tr.setInsets(l10, t2, r10, b4);
    }

    @Override // android.view.animation.Animation
    public boolean willChangeTransformationMatrix() {
        return false;
    }

    @Override // android.view.animation.Animation
    public boolean hasExtension() {
        return this.mFromInsets.left < 0 || this.mFromInsets.top < 0 || this.mFromInsets.right < 0 || this.mFromInsets.bottom < 0;
    }

    @Override // android.view.animation.Animation
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        this.mFromInsets = Insets.min(Insets.of(-((int) resolveSize(this.mFromLeftType, this.mFromLeftValue, width, parentWidth)), -((int) resolveSize(this.mFromTopType, this.mFromTopValue, height, parentHeight)), -((int) resolveSize(this.mFromRightType, this.mFromRightValue, width, parentWidth)), -((int) resolveSize(this.mFromBottomType, this.mFromBottomValue, height, parentHeight))), Insets.NONE);
        this.mToInsets = Insets.min(Insets.of(-((int) resolveSize(this.mToLeftType, this.mToLeftValue, width, parentWidth)), -((int) resolveSize(this.mToTopType, this.mToTopValue, height, parentHeight)), -((int) resolveSize(this.mToRightType, this.mToRightValue, width, parentWidth)), -((int) resolveSize(this.mToBottomType, this.mToBottomValue, height, parentHeight))), Insets.NONE);
    }
}
