package com.android.internal.graphics.drawable;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.util.AttributeSet;
import com.android.internal.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AnimationScaleListDrawable extends DrawableContainer implements Animatable {
    private static final String TAG = "AnimationScaleListDrawable";
    private AnimationScaleListState mAnimationScaleListState;
    private boolean mMutated;

    public AnimationScaleListDrawable() {
        this(null, null);
    }

    private AnimationScaleListDrawable(AnimationScaleListState state, Resources res) {
        AnimationScaleListState newState = new AnimationScaleListState(state, this, res);
        setConstantState(newState);
        onStateChange(getState());
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] stateSet) {
        boolean changed = super.onStateChange(stateSet);
        int idx = this.mAnimationScaleListState.getCurrentDrawableIndexBasedOnScale();
        return selectDrawable(idx) || changed;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r10, XmlPullParser parser, AttributeSet attrs, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray a10 = obtainAttributes(r10, theme, attrs, R.styleable.AnimationScaleListDrawable);
        updateDensity(r10);
        a10.recycle();
        inflateChildElements(r10, parser, attrs, theme);
        onStateChange(getState());
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        if (r7 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        r8 = r12.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
    
        if (r8 != 4) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
    
        if (r8 != 2) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0047, code lost:
    
        r7 = android.graphics.drawable.Drawable.createFromXmlInner(r11, r12, r13, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0068, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r12.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0069, code lost:
    
        r0.addDrawable(r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void inflateChildElements(android.content.res.Resources r11, org.xmlpull.v1.XmlPullParser r12, android.util.AttributeSet r13, android.content.res.Resources.Theme r14) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r10 = this;
            com.android.internal.graphics.drawable.AnimationScaleListDrawable$AnimationScaleListState r0 = r10.mAnimationScaleListState
            int r1 = r12.getDepth()
            r2 = 1
            int r1 = r1 + r2
        L8:
            int r3 = r12.next()
            r4 = r3
            if (r3 == r2) goto L6d
            int r3 = r12.getDepth()
            r5 = r3
            if (r3 >= r1) goto L19
            r3 = 3
            if (r4 == r3) goto L6d
        L19:
            r3 = 2
            if (r4 == r3) goto L1d
            goto L8
        L1d:
            if (r5 > r1) goto L8
            java.lang.String r6 = r12.getName()
            java.lang.String r7 = "item"
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L2c
            goto L8
        L2c:
            int[] r6 = com.android.internal.R.styleable.AnimationScaleListDrawableItem
            android.content.res.TypedArray r6 = obtainAttributes(r11, r14, r13, r6)
            r7 = 0
            android.graphics.drawable.Drawable r7 = r6.getDrawable(r7)
            r6.recycle()
            if (r7 != 0) goto L69
        L3c:
            int r8 = r12.next()
            r4 = r8
            r9 = 4
            if (r8 != r9) goto L45
            goto L3c
        L45:
            if (r4 != r3) goto L4c
            android.graphics.drawable.Drawable r7 = android.graphics.drawable.Drawable.createFromXmlInner(r11, r12, r13, r14)
            goto L69
        L4c:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r8 = r12.getPositionDescription()
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r8 = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable"
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        L69:
            r0.addDrawable(r7)
            goto L8
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.graphics.drawable.AnimationScaleListDrawable.inflateChildElements(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mAnimationScaleListState.mutate();
            this.mMutated = true;
        }
        return this;
    }

    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Object current = getCurrent();
        if (current != null && (current instanceof Animatable)) {
            ((Animatable) current).start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Object current = getCurrent();
        if (current != null && (current instanceof Animatable)) {
            ((Animatable) current).stop();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Object current = getCurrent();
        if (current == null || !(current instanceof Animatable)) {
            return false;
        }
        boolean result = ((Animatable) current).isRunning();
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class AnimationScaleListState extends DrawableContainer.DrawableContainerState {
        int mAnimatableDrawableIndex;
        int mStaticDrawableIndex;
        int[] mThemeAttrs;

        AnimationScaleListState(AnimationScaleListState orig, AnimationScaleListDrawable owner, Resources res) {
            super(orig, owner, res);
            this.mThemeAttrs = null;
            this.mStaticDrawableIndex = -1;
            this.mAnimatableDrawableIndex = -1;
            if (orig != null) {
                this.mThemeAttrs = orig.mThemeAttrs;
                this.mStaticDrawableIndex = orig.mStaticDrawableIndex;
                this.mAnimatableDrawableIndex = orig.mAnimatableDrawableIndex;
            }
        }

        void mutate() {
            int[] iArr = this.mThemeAttrs;
            this.mThemeAttrs = iArr != null ? (int[]) iArr.clone() : null;
        }

        int addDrawable(Drawable drawable) {
            int pos = addChild(drawable);
            if (drawable instanceof Animatable) {
                this.mAnimatableDrawableIndex = pos;
            } else {
                this.mStaticDrawableIndex = pos;
            }
            return pos;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new AnimationScaleListDrawable(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources res) {
            return new AnimationScaleListDrawable(this, res);
        }

        @Override // android.graphics.drawable.DrawableContainer.DrawableContainerState, android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.mThemeAttrs != null || super.canApplyTheme();
        }

        public int getCurrentDrawableIndexBasedOnScale() {
            if (ValueAnimator.getDurationScale() == 0.0f) {
                return this.mStaticDrawableIndex;
            }
            return this.mAnimatableDrawableIndex;
        }
    }

    @Override // android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // android.graphics.drawable.DrawableContainer
    protected void setConstantState(DrawableContainer.DrawableContainerState state) {
        super.setConstantState(state);
        if (state instanceof AnimationScaleListState) {
            this.mAnimationScaleListState = (AnimationScaleListState) state;
        }
    }
}
