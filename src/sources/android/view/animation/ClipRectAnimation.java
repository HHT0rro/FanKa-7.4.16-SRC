package android.view.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.animation.Animation;
import com.android.internal.R;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ClipRectAnimation extends Animation {
    private int mFromBottomType;
    private float mFromBottomValue;
    private int mFromLeftType;
    private float mFromLeftValue;
    protected final Rect mFromRect;
    private int mFromRightType;
    private float mFromRightValue;
    private int mFromTopType;
    private float mFromTopValue;
    private int mToBottomType;
    private float mToBottomValue;
    private int mToLeftType;
    private float mToLeftValue;
    protected final Rect mToRect;
    private int mToRightType;
    private float mToRightValue;
    private int mToTopType;
    private float mToTopValue;

    public ClipRectAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mFromRect = new Rect();
        this.mToRect = new Rect();
        this.mFromLeftType = 0;
        this.mFromTopType = 0;
        this.mFromRightType = 0;
        this.mFromBottomType = 0;
        this.mToLeftType = 0;
        this.mToTopType = 0;
        this.mToRightType = 0;
        this.mToBottomType = 0;
        TypedArray a10 = context.obtainStyledAttributes(attrs, R.styleable.ClipRectAnimation);
        Animation.Description d10 = Animation.Description.parseValue(a10.peekValue(1), context);
        this.mFromLeftType = d10.type;
        this.mFromLeftValue = d10.value;
        Animation.Description d11 = Animation.Description.parseValue(a10.peekValue(3), context);
        this.mFromTopType = d11.type;
        this.mFromTopValue = d11.value;
        Animation.Description d12 = Animation.Description.parseValue(a10.peekValue(2), context);
        this.mFromRightType = d12.type;
        this.mFromRightValue = d12.value;
        Animation.Description d13 = Animation.Description.parseValue(a10.peekValue(0), context);
        this.mFromBottomType = d13.type;
        this.mFromBottomValue = d13.value;
        Animation.Description d14 = Animation.Description.parseValue(a10.peekValue(5), context);
        this.mToLeftType = d14.type;
        this.mToLeftValue = d14.value;
        Animation.Description d15 = Animation.Description.parseValue(a10.peekValue(7), context);
        this.mToTopType = d15.type;
        this.mToTopValue = d15.value;
        Animation.Description d16 = Animation.Description.parseValue(a10.peekValue(6), context);
        this.mToRightType = d16.type;
        this.mToRightValue = d16.value;
        Animation.Description d17 = Animation.Description.parseValue(a10.peekValue(4), context);
        this.mToBottomType = d17.type;
        this.mToBottomValue = d17.value;
        a10.recycle();
    }

    public ClipRectAnimation(Rect fromClip, Rect toClip) {
        this.mFromRect = new Rect();
        this.mToRect = new Rect();
        this.mFromLeftType = 0;
        this.mFromTopType = 0;
        this.mFromRightType = 0;
        this.mFromBottomType = 0;
        this.mToLeftType = 0;
        this.mToTopType = 0;
        this.mToRightType = 0;
        this.mToBottomType = 0;
        if (fromClip == null || toClip == null) {
            throw new RuntimeException("Expected non-null animation clip rects");
        }
        this.mFromLeftValue = fromClip.left;
        this.mFromTopValue = fromClip.top;
        this.mFromRightValue = fromClip.right;
        this.mFromBottomValue = fromClip.bottom;
        this.mToLeftValue = toClip.left;
        this.mToTopValue = toClip.top;
        this.mToRightValue = toClip.right;
        this.mToBottomValue = toClip.bottom;
    }

    public ClipRectAnimation(int fromL, int fromT, int fromR, int fromB, int toL, int toT, int toR, int toB) {
        this(new Rect(fromL, fromT, fromR, fromB), new Rect(toL, toT, toR, toB));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.animation.Animation
    public void applyTransformation(float it, Transformation tr) {
        int l10 = this.mFromRect.left + ((int) ((this.mToRect.left - this.mFromRect.left) * it));
        int t2 = this.mFromRect.top + ((int) ((this.mToRect.top - this.mFromRect.top) * it));
        int r10 = this.mFromRect.right + ((int) ((this.mToRect.right - this.mFromRect.right) * it));
        int b4 = this.mFromRect.bottom + ((int) ((this.mToRect.bottom - this.mFromRect.bottom) * it));
        tr.setClipRect(l10, t2, r10, b4);
    }

    @Override // android.view.animation.Animation
    public boolean willChangeTransformationMatrix() {
        return false;
    }

    @Override // android.view.animation.Animation
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        this.mFromRect.set((int) resolveSize(this.mFromLeftType, this.mFromLeftValue, width, parentWidth), (int) resolveSize(this.mFromTopType, this.mFromTopValue, height, parentHeight), (int) resolveSize(this.mFromRightType, this.mFromRightValue, width, parentWidth), (int) resolveSize(this.mFromBottomType, this.mFromBottomValue, height, parentHeight));
        this.mToRect.set((int) resolveSize(this.mToLeftType, this.mToLeftValue, width, parentWidth), (int) resolveSize(this.mToTopType, this.mToTopValue, height, parentHeight), (int) resolveSize(this.mToRightType, this.mToRightValue, width, parentWidth), (int) resolveSize(this.mToBottomType, this.mToBottomValue, height, parentHeight));
    }
}
