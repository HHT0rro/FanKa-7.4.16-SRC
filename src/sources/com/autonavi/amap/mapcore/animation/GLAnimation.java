package com.autonavi.amap.mapcore.animation;

import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.amap.api.maps.model.animation.Animation;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class GLAnimation implements Cloneable {
    public static final int ABSOLUTE = 0;
    public static final int INFINITE = -1;
    public static final int RELATIVE_TO_PARENT = 2;
    public static final int RELATIVE_TO_SELF = 1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    public static final int START_ON_FIRST_FRAME = -1;
    public static final int ZORDER_BOTTOM = -1;
    public static final int ZORDER_NORMAL = 0;
    public static final int ZORDER_TOP = 1;
    private int mBackgroundColor;
    public Interpolator mInterpolator;
    public Animation.AnimationListener mListener;
    private Handler mListenerHandler;
    private Runnable mOnEnd;
    private Runnable mOnStart;
    public long mStartOffset;
    private int mZAdjustment;
    public boolean mEnded = false;
    public boolean mStarted = false;
    public boolean mCycleFlip = false;
    public boolean mInitialized = false;
    public boolean mFillBefore = true;
    public boolean mFillAfter = false;
    public boolean mFillEnabled = false;
    public long mStartTime = -1;
    public long mDuration = 500;
    public int mRepeatCount = 0;
    public int mRepeated = 0;
    public int mRepeatMode = 1;
    private float mScaleFactor = 1.0f;
    private boolean mDetachWallpaper = false;
    private boolean mMore = true;
    private boolean mOneMoreTime = true;
    public RectF mPreviousRegion = new RectF();
    public RectF mRegion = new RectF();
    public GLTransformation mPreviousTransformation = new GLTransformation();

    public GLAnimation() {
        try {
            ensureInterpolator();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void fireAnimationEnd() {
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            Handler handler = this.mListenerHandler;
            if (handler == null) {
                animationListener.onAnimationEnd();
            } else {
                handler.postAtFrontOfQueue(this.mOnEnd);
            }
        }
    }

    private void fireAnimationRepeat() {
    }

    private void fireAnimationStart() {
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            Handler handler = this.mListenerHandler;
            if (handler == null) {
                animationListener.onAnimationStart();
            } else {
                handler.postAtFrontOfQueue(this.mOnStart);
            }
        }
    }

    public void applyTransformation(float f10, GLTransformation gLTransformation) {
    }

    public void cancel() {
        if (this.mStarted && !this.mEnded) {
            fireAnimationEnd();
            this.mEnded = true;
        }
        this.mStartTime = Long.MIN_VALUE;
        this.mOneMoreTime = false;
        this.mMore = false;
    }

    public long computeDurationHint() {
        return (getStartOffset() + getDuration()) * (getRepeatCount() + 1);
    }

    public void detach() {
        if (!this.mStarted || this.mEnded) {
            return;
        }
        this.mEnded = true;
        fireAnimationEnd();
    }

    public void ensureInterpolator() {
        if (this.mInterpolator == null) {
            this.mInterpolator = new AccelerateDecelerateInterpolator();
        }
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public boolean getDetachWallpaper() {
        return this.mDetachWallpaper;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public boolean getFillAfter() {
        return this.mFillAfter;
    }

    public boolean getFillBefore() {
        return this.mFillBefore;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public float getScaleFactor() {
        return this.mScaleFactor;
    }

    public long getStartOffset() {
        return this.mStartOffset;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public boolean getTransformation(long j10, GLTransformation gLTransformation) {
        float f10;
        if (this.mStartTime == -1) {
            this.mStartTime = j10;
        }
        long startOffset = getStartOffset();
        long j11 = this.mDuration;
        if (j11 != 0) {
            f10 = ((float) (j10 - (this.mStartTime + startOffset))) / ((float) j11);
        } else {
            f10 = j10 < this.mStartTime ? 0.0f : 1.0f;
        }
        boolean z10 = f10 >= 1.0f;
        this.mMore = !z10;
        if (!this.mFillEnabled) {
            f10 = Math.max(Math.min(f10, 1.0f), 0.0f);
        }
        if ((f10 >= 0.0f || this.mFillBefore) && (f10 <= 1.0f || this.mFillAfter)) {
            if (!this.mStarted) {
                try {
                    fireAnimationStart();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                this.mStarted = true;
            }
            if (this.mFillEnabled) {
                f10 = Math.max(Math.min(f10, 1.0f), 0.0f);
            }
            if (this.mCycleFlip) {
                f10 = 1.0f - f10;
            }
            applyTransformation(this.mInterpolator.getInterpolation(f10), gLTransformation);
        }
        if (z10) {
            int i10 = this.mRepeatCount;
            int i11 = this.mRepeated;
            if (i10 == i11) {
                if (!this.mEnded) {
                    this.mEnded = true;
                    fireAnimationEnd();
                }
            } else {
                if (i10 > 0) {
                    this.mRepeated = i11 + 1;
                }
                if (this.mRepeatMode == 2) {
                    this.mCycleFlip = !this.mCycleFlip;
                }
                this.mStartTime = -1L;
                this.mMore = true;
                fireAnimationRepeat();
            }
        }
        boolean z11 = this.mMore;
        if (z11 || !this.mOneMoreTime) {
            return z11;
        }
        this.mOneMoreTime = false;
        return true;
    }

    public int getZAdjustment() {
        return this.mZAdjustment;
    }

    public boolean hasAlpha() {
        return false;
    }

    public boolean hasEnded() {
        return this.mEnded;
    }

    public boolean hasStarted() {
        return this.mStarted;
    }

    public void initialize() {
        reset();
        this.mInitialized = true;
    }

    public boolean isFillEnabled() {
        return this.mFillEnabled;
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public void reset() {
        this.mPreviousRegion.setEmpty();
        this.mPreviousTransformation.clear();
        this.mInitialized = false;
        this.mCycleFlip = false;
        this.mRepeated = 0;
        this.mMore = true;
        this.mOneMoreTime = true;
        this.mListenerHandler = null;
    }

    public void restrictDuration(long j10) {
        long j11 = this.mStartOffset;
        if (j11 > j10) {
            this.mStartOffset = j10;
            this.mDuration = 0L;
            this.mRepeatCount = 0;
            return;
        }
        long j12 = this.mDuration + j11;
        if (j12 > j10) {
            this.mDuration = j10 - j11;
            j12 = j10;
        }
        if (this.mDuration <= 0) {
            this.mDuration = 0L;
            this.mRepeatCount = 0;
            return;
        }
        int i10 = this.mRepeatCount;
        if (i10 < 0 || i10 > j10 || i10 * j12 > j10) {
            int i11 = ((int) (j10 / j12)) - 1;
            this.mRepeatCount = i11;
            if (i11 < 0) {
                this.mRepeatCount = 0;
            }
        }
    }

    public void scaleCurrentDuration(float f10) {
        this.mDuration = ((float) this.mDuration) * f10;
        this.mStartOffset = ((float) this.mStartOffset) * f10;
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    public void setBackgroundColor(int i10) {
        this.mBackgroundColor = i10;
    }

    public void setDetachWallpaper(boolean z10) {
        this.mDetachWallpaper = z10;
    }

    public void setDuration(long j10) {
        if (j10 < 0) {
            j10 = 0;
        }
        this.mDuration = j10;
    }

    public void setFillAfter(boolean z10) {
        this.mFillAfter = z10;
    }

    public void setFillBefore(boolean z10) {
        this.mFillBefore = z10;
    }

    public void setFillEnabled(boolean z10) {
        this.mFillEnabled = z10;
    }

    public void setInterpolator(Context context, int i10) {
        setInterpolator(AnimationUtils.loadInterpolator(context, i10));
    }

    public void setRepeatCount(int i10) {
        if (i10 < 0) {
            i10 = -1;
        }
        this.mRepeatCount = i10;
    }

    public void setRepeatMode(int i10) {
        this.mRepeatMode = i10;
    }

    public void setStartOffset(long j10) {
        this.mStartOffset = j10;
    }

    public void setStartTime(long j10) {
        this.mStartTime = j10;
        this.mEnded = false;
        this.mStarted = false;
        this.mCycleFlip = false;
        this.mRepeated = 0;
        this.mMore = true;
    }

    public void setZAdjustment(int i10) {
        this.mZAdjustment = i10;
    }

    public void start() {
        setStartTime(-1L);
    }

    public void startNow() {
        setStartTime(AnimationUtils.currentAnimationTimeMillis());
    }

    public boolean willChangeBounds() {
        return true;
    }

    public boolean willChangeTransformationMatrix() {
        return true;
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public GLAnimation mo2434clone() throws CloneNotSupportedException {
        GLAnimation gLAnimation = (GLAnimation) super.clone();
        gLAnimation.mPreviousRegion = new RectF();
        gLAnimation.mRegion = new RectF();
        gLAnimation.mPreviousTransformation = new GLTransformation();
        return gLAnimation;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public boolean getTransformation(long j10, GLTransformation gLTransformation, float f10) {
        this.mScaleFactor = f10;
        return getTransformation(j10, gLTransformation);
    }
}
