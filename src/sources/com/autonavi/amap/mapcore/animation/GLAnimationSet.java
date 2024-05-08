package com.autonavi.amap.mapcore.animation;

import android.view.animation.Interpolator;
import com.amap.api.maps.model.animation.Animation;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GLAnimationSet extends GLAnimation {
    private static final int PROPERTY_CHANGE_BOUNDS_MASK = 128;
    private static final int PROPERTY_DURATION_MASK = 32;
    private static final int PROPERTY_FILL_AFTER_MASK = 1;
    private static final int PROPERTY_FILL_BEFORE_MASK = 2;
    private static final int PROPERTY_MORPH_MATRIX_MASK = 64;
    private static final int PROPERTY_REPEAT_MODE_MASK = 4;
    private static final int PROPERTY_SHARE_INTERPOLATOR_MASK = 16;
    private static final int PROPERTY_START_OFFSET_MASK = 8;
    private boolean mDirty;
    private boolean mHasAlpha;
    private long mLastEnd;
    private int mFlags = 0;
    private ArrayList<GLAnimation> mAnimations = new ArrayList<>();
    private GLTransformation mTempTransformation = new GLTransformation();

    public GLAnimationSet(boolean z10) {
        setFlag(16, z10);
        init();
    }

    private void init() {
        this.mStartTime = 0L;
    }

    private void setFlag(int i10, boolean z10) {
        if (z10) {
            this.mFlags = i10 | this.mFlags;
        } else {
            this.mFlags = (~i10) & this.mFlags;
        }
    }

    public void addAnimation(Animation animation) {
        this.mAnimations.add(animation.glAnimation);
        if (((this.mFlags & 64) == 0) && animation.glAnimation.willChangeTransformationMatrix()) {
            this.mFlags |= 64;
        }
        if (((this.mFlags & 128) == 0) && animation.glAnimation.willChangeBounds()) {
            this.mFlags |= 128;
        }
        if ((this.mFlags & 32) == 32) {
            this.mLastEnd = this.mStartOffset + this.mDuration;
        } else if (this.mAnimations.size() == 1) {
            long startOffset = animation.glAnimation.getStartOffset() + animation.glAnimation.getDuration();
            this.mDuration = startOffset;
            this.mLastEnd = this.mStartOffset + startOffset;
        } else {
            long max = Math.max(this.mLastEnd, animation.glAnimation.getStartOffset() + animation.glAnimation.getDuration());
            this.mLastEnd = max;
            this.mDuration = max - this.mStartOffset;
        }
        this.mDirty = true;
    }

    public void cleanAnimation() {
        this.mAnimations.clear();
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long computeDurationHint() {
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        long j10 = 0;
        for (int i10 = size - 1; i10 >= 0; i10--) {
            long computeDurationHint = arrayList.get(i10).computeDurationHint();
            if (computeDurationHint > j10) {
                j10 = computeDurationHint;
            }
        }
        return j10;
    }

    public List<GLAnimation> getAnimations() {
        return this.mAnimations;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long getDuration() {
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        if ((this.mFlags & 32) == 32) {
            return this.mDuration;
        }
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            j10 = Math.max(j10, arrayList.get(i10).getDuration());
        }
        return j10;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public long getStartTime() {
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        long j10 = Long.MAX_VALUE;
        for (int i10 = 0; i10 < size; i10++) {
            j10 = Math.min(j10, arrayList.get(i10).getStartTime());
        }
        return j10;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean getTransformation(long j10, GLTransformation gLTransformation) {
        if (!this.mInitialized) {
            initialize();
        }
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        GLTransformation gLTransformation2 = this.mTempTransformation;
        gLTransformation.clear();
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = true;
        for (int i10 = size - 1; i10 >= 0; i10--) {
            GLAnimation gLAnimation = arrayList.get(i10);
            gLTransformation2.clear();
            z11 = gLAnimation.getTransformation(j10, gLTransformation, getScaleFactor()) || z11;
            z10 = z10 || gLAnimation.hasStarted();
            z12 = gLAnimation.hasEnded() && z12;
        }
        if (z10) {
            try {
                if (!this.mStarted) {
                    Animation.AnimationListener animationListener = this.mListener;
                    if (animationListener != null) {
                        animationListener.onAnimationStart();
                    }
                    this.mStarted = true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (z12 != this.mEnded) {
            Animation.AnimationListener animationListener2 = this.mListener;
            if (animationListener2 != null) {
                animationListener2.onAnimationEnd();
            }
            this.mEnded = z12;
        }
        return z11;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean hasAlpha() {
        if (this.mDirty) {
            int i10 = 0;
            this.mHasAlpha = false;
            this.mDirty = false;
            int size = this.mAnimations.size();
            ArrayList<GLAnimation> arrayList = this.mAnimations;
            while (true) {
                if (i10 >= size) {
                    break;
                }
                if (arrayList.get(i10).hasAlpha()) {
                    this.mHasAlpha = true;
                    break;
                }
                i10++;
            }
        }
        return this.mHasAlpha;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void initialize() {
        boolean z10;
        boolean z11;
        super.initialize();
        int i10 = this.mFlags;
        boolean z12 = (i10 & 32) == 32;
        boolean z13 = (i10 & 1) == 1;
        boolean z14 = (i10 & 2) == 2;
        boolean z15 = (i10 & 4) == 4;
        boolean z16 = (i10 & 16) == 16;
        boolean z17 = (i10 & 8) == 8;
        if (z16) {
            ensureInterpolator();
        }
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        long j10 = this.mDuration;
        boolean z18 = this.mFillAfter;
        boolean z19 = this.mFillBefore;
        int i11 = this.mRepeatMode;
        Interpolator interpolator = this.mInterpolator;
        boolean z20 = z17;
        long j11 = this.mStartOffset;
        int i12 = 0;
        while (i12 < size) {
            ArrayList<GLAnimation> arrayList2 = arrayList;
            GLAnimation gLAnimation = arrayList.get(i12);
            if (z12) {
                gLAnimation.setDuration(j10);
            }
            if (z13) {
                gLAnimation.setFillAfter(z18);
            }
            if (z14) {
                gLAnimation.setFillBefore(z19);
            }
            if (z15) {
                gLAnimation.setRepeatMode(i11);
            }
            if (z16) {
                gLAnimation.setInterpolator(interpolator);
            }
            if (z20) {
                z10 = z12;
                z11 = z13;
                gLAnimation.setStartOffset(gLAnimation.getStartOffset() + j11);
            } else {
                z10 = z12;
                z11 = z13;
            }
            gLAnimation.initialize();
            i12++;
            z12 = z10;
            arrayList = arrayList2;
            z13 = z11;
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void reset() {
        super.reset();
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void restrictDuration(long j10) {
        super.restrictDuration(j10);
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.get(i10).restrictDuration(j10);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void scaleCurrentDuration(float f10) {
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.get(i10).scaleCurrentDuration(f10);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setDuration(long j10) {
        this.mFlags |= 32;
        super.setDuration(j10);
        this.mLastEnd = this.mStartOffset + this.mDuration;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setFillAfter(boolean z10) {
        this.mFlags |= 1;
        super.setFillAfter(z10);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setFillBefore(boolean z10) {
        this.mFlags |= 2;
        super.setFillBefore(z10);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setRepeatMode(int i10) {
        this.mFlags |= 4;
        super.setRepeatMode(i10);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setStartOffset(long j10) {
        this.mFlags |= 8;
        super.setStartOffset(j10);
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void setStartTime(long j10) {
        super.setStartTime(j10);
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.get(i10).setStartTime(j10);
        }
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean willChangeBounds() {
        return (this.mFlags & 128) == 128;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public boolean willChangeTransformationMatrix() {
        return (this.mFlags & 64) == 64;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    /* renamed from: clone */
    public GLAnimationSet mo2434clone() throws CloneNotSupportedException {
        GLAnimationSet gLAnimationSet = (GLAnimationSet) super.mo2434clone();
        gLAnimationSet.mTempTransformation = new GLTransformation();
        gLAnimationSet.mAnimations = new ArrayList<>();
        int size = this.mAnimations.size();
        ArrayList<GLAnimation> arrayList = this.mAnimations;
        for (int i10 = 0; i10 < size; i10++) {
            gLAnimationSet.mAnimations.add(arrayList.get(i10).mo2434clone());
        }
        return gLAnimationSet;
    }
}
