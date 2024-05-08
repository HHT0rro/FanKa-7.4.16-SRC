package android.view.animation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.android.internal.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class AnimationSet extends Animation {
    private static final int PROPERTY_CHANGE_BOUNDS_MASK = 128;
    private static final int PROPERTY_DURATION_MASK = 32;
    private static final int PROPERTY_FILL_AFTER_MASK = 1;
    private static final int PROPERTY_FILL_BEFORE_MASK = 2;
    private static final int PROPERTY_MORPH_MATRIX_MASK = 64;
    private static final int PROPERTY_REPEAT_MODE_MASK = 4;
    private static final int PROPERTY_SHARE_INTERPOLATOR_MASK = 16;
    private static final int PROPERTY_START_OFFSET_MASK = 8;
    private ArrayList<Animation> mAnimations;
    private boolean mDirty;
    private int mFlags;
    private boolean mHasAlpha;
    private long mLastEnd;
    private long[] mStoredOffsets;
    private Transformation mTempTransformation;

    public AnimationSet(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mFlags = 0;
        this.mAnimations = new ArrayList<>();
        this.mTempTransformation = new Transformation();
        TypedArray a10 = context.obtainStyledAttributes(attrs, R.styleable.AnimationSet);
        setFlag(16, a10.getBoolean(1, true));
        init();
        if (context.getApplicationInfo().targetSdkVersion >= 14) {
            if (a10.hasValue(0)) {
                this.mFlags |= 32;
            }
            if (a10.hasValue(2)) {
                this.mFlags = 2 | this.mFlags;
            }
            if (a10.hasValue(3)) {
                this.mFlags |= 1;
            }
            if (a10.hasValue(5)) {
                this.mFlags |= 4;
            }
            if (a10.hasValue(4)) {
                this.mFlags |= 8;
            }
        }
        a10.recycle();
    }

    public AnimationSet(boolean shareInterpolator) {
        this.mFlags = 0;
        this.mAnimations = new ArrayList<>();
        this.mTempTransformation = new Transformation();
        setFlag(16, shareInterpolator);
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.animation.Animation
    /* renamed from: clone */
    public AnimationSet mo547clone() throws CloneNotSupportedException {
        AnimationSet animation = (AnimationSet) super.mo547clone();
        animation.mTempTransformation = new Transformation();
        animation.mAnimations = new ArrayList<>();
        int count = this.mAnimations.size();
        ArrayList<Animation> animations = this.mAnimations;
        for (int i10 = 0; i10 < count; i10++) {
            animation.mAnimations.add(animations.get(i10).mo547clone());
        }
        return animation;
    }

    private void setFlag(int mask, boolean value) {
        if (value) {
            this.mFlags |= mask;
        } else {
            this.mFlags &= ~mask;
        }
    }

    private void init() {
        this.mStartTime = 0L;
    }

    @Override // android.view.animation.Animation
    public void setFillAfter(boolean fillAfter) {
        this.mFlags |= 1;
        super.setFillAfter(fillAfter);
    }

    @Override // android.view.animation.Animation
    public void setFillBefore(boolean fillBefore) {
        this.mFlags |= 2;
        super.setFillBefore(fillBefore);
    }

    @Override // android.view.animation.Animation
    public void setRepeatMode(int repeatMode) {
        this.mFlags |= 4;
        super.setRepeatMode(repeatMode);
    }

    @Override // android.view.animation.Animation
    public void setStartOffset(long startOffset) {
        this.mFlags |= 8;
        super.setStartOffset(startOffset);
    }

    @Override // android.view.animation.Animation
    public boolean hasAlpha() {
        if (this.mDirty) {
            this.mHasAlpha = false;
            this.mDirty = false;
            int count = this.mAnimations.size();
            ArrayList<Animation> animations = this.mAnimations;
            int i10 = 0;
            while (true) {
                if (i10 >= count) {
                    break;
                }
                if (!animations.get(i10).hasAlpha()) {
                    i10++;
                } else {
                    this.mHasAlpha = true;
                    break;
                }
            }
        }
        return this.mHasAlpha;
    }

    @Override // android.view.animation.Animation
    public void setDuration(long durationMillis) {
        this.mFlags |= 32;
        super.setDuration(durationMillis);
        this.mLastEnd = this.mStartOffset + this.mDuration;
    }

    public void addAnimation(Animation a10) {
        this.mAnimations.add(a10);
        boolean noMatrix = (this.mFlags & 64) == 0;
        if (noMatrix && a10.willChangeTransformationMatrix()) {
            this.mFlags |= 64;
        }
        boolean changeBounds = (this.mFlags & 128) == 0;
        if (changeBounds && a10.willChangeBounds()) {
            this.mFlags |= 128;
        }
        if ((this.mFlags & 32) == 32) {
            this.mLastEnd = this.mStartOffset + this.mDuration;
        } else if (this.mAnimations.size() == 1) {
            this.mDuration = a10.getStartOffset() + a10.getDuration();
            this.mLastEnd = this.mStartOffset + this.mDuration;
        } else {
            long max = Math.max(this.mLastEnd, this.mStartOffset + a10.getStartOffset() + a10.getDuration());
            this.mLastEnd = max;
            this.mDuration = max - this.mStartOffset;
        }
        this.mDirty = true;
    }

    @Override // android.view.animation.Animation
    public void setStartTime(long startTimeMillis) {
        super.setStartTime(startTimeMillis);
        int count = this.mAnimations.size();
        ArrayList<Animation> animations = this.mAnimations;
        for (int i10 = 0; i10 < count; i10++) {
            Animation a10 = animations.get(i10);
            a10.setStartTime(startTimeMillis);
        }
    }

    @Override // android.view.animation.Animation
    public long getStartTime() {
        long startTime = Long.MAX_VALUE;
        int count = this.mAnimations.size();
        ArrayList<Animation> animations = this.mAnimations;
        for (int i10 = 0; i10 < count; i10++) {
            Animation a10 = animations.get(i10);
            startTime = Math.min(startTime, a10.getStartTime());
        }
        return startTime;
    }

    @Override // android.view.animation.Animation
    public void restrictDuration(long durationMillis) {
        super.restrictDuration(durationMillis);
        ArrayList<Animation> animations = this.mAnimations;
        int count = animations.size();
        for (int i10 = 0; i10 < count; i10++) {
            animations.get(i10).restrictDuration(durationMillis);
        }
    }

    @Override // android.view.animation.Animation
    public long getDuration() {
        ArrayList<Animation> animations = this.mAnimations;
        int count = animations.size();
        long duration = 0;
        boolean durationSet = (this.mFlags & 32) == 32;
        if (durationSet) {
            long duration2 = this.mDuration;
            return duration2;
        }
        for (int i10 = 0; i10 < count; i10++) {
            duration = Math.max(duration, animations.get(i10).getDuration());
        }
        return duration;
    }

    @Override // android.view.animation.Animation
    public long computeDurationHint() {
        long duration = 0;
        int count = this.mAnimations.size();
        ArrayList<Animation> animations = this.mAnimations;
        for (int i10 = count - 1; i10 >= 0; i10--) {
            long d10 = animations.get(i10).computeDurationHint();
            if (d10 > duration) {
                duration = d10;
            }
        }
        return duration;
    }

    @Override // android.view.animation.Animation
    public void initializeInvalidateRegion(int left, int top, int right, int bottom) {
        RectF region = this.mPreviousRegion;
        region.set(left, top, right, bottom);
        region.inset(-1.0f, -1.0f);
        if (this.mFillBefore) {
            int count = this.mAnimations.size();
            ArrayList<Animation> animations = this.mAnimations;
            Transformation temp = this.mTempTransformation;
            Transformation previousTransformation = this.mPreviousTransformation;
            for (int i10 = count - 1; i10 >= 0; i10--) {
                Animation a10 = animations.get(i10);
                if (!a10.isFillEnabled() || a10.getFillBefore() || a10.getStartOffset() == 0) {
                    temp.clear();
                    Interpolator interpolator = a10.mInterpolator;
                    a10.applyTransformation(interpolator != null ? interpolator.getInterpolation(0.0f) : 0.0f, temp);
                    previousTransformation.compose(temp);
                }
            }
        }
    }

    @Override // android.view.animation.Animation
    public void getTransformationAt(float interpolatedTime, Transformation t2) {
        Transformation temp = this.mTempTransformation;
        for (int i10 = this.mAnimations.size() - 1; i10 >= 0; i10--) {
            Animation a10 = this.mAnimations.get(i10);
            temp.clear();
            a10.getTransformationAt(interpolatedTime, t2);
            t2.compose(temp);
        }
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long currentTime, Transformation t2) {
        int count = this.mAnimations.size();
        ArrayList<Animation> animations = this.mAnimations;
        Transformation temp = this.mTempTransformation;
        boolean more = false;
        boolean started = false;
        boolean ended = true;
        t2.clear();
        int i10 = count - 1;
        while (true) {
            boolean z10 = true;
            if (i10 < 0) {
                break;
            }
            Animation a10 = animations.get(i10);
            temp.clear();
            more = a10.getTransformation(currentTime, temp, getScaleFactor()) || more;
            t2.compose(temp);
            started = started || a10.hasStarted();
            if (!a10.hasEnded() || !ended) {
                z10 = false;
            }
            ended = z10;
            i10--;
        }
        if (started && !this.mStarted) {
            dispatchAnimationStart();
            this.mStarted = true;
        }
        if (ended != this.mEnded) {
            dispatchAnimationEnd();
            this.mEnded = ended;
        }
        return more;
    }

    @Override // android.view.animation.Animation
    public void scaleCurrentDuration(float scale) {
        ArrayList<Animation> animations = this.mAnimations;
        int count = animations.size();
        for (int i10 = 0; i10 < count; i10++) {
            animations.get(i10).scaleCurrentDuration(scale);
        }
    }

    @Override // android.view.animation.Animation
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        boolean durationSet;
        Interpolator interpolator;
        boolean startOffsetSet;
        Interpolator interpolator2;
        super.initialize(width, height, parentWidth, parentHeight);
        int i10 = this.mFlags;
        boolean durationSet2 = (i10 & 32) == 32;
        boolean fillAfterSet = (i10 & 1) == 1;
        boolean fillBeforeSet = (i10 & 2) == 2;
        boolean repeatModeSet = (i10 & 4) == 4;
        boolean shareInterpolator = (i10 & 16) == 16;
        boolean startOffsetSet2 = (i10 & 8) == 8;
        if (shareInterpolator) {
            ensureInterpolator();
        }
        ArrayList<Animation> children = this.mAnimations;
        int count = children.size();
        long duration = this.mDuration;
        boolean fillAfter = this.mFillAfter;
        boolean fillBefore = this.mFillBefore;
        int repeatMode = this.mRepeatMode;
        Interpolator interpolator3 = this.mInterpolator;
        Interpolator interpolator4 = interpolator3;
        long startOffset = this.mStartOffset;
        long[] storedOffsets = this.mStoredOffsets;
        if (startOffsetSet2) {
            if (storedOffsets == null || storedOffsets.length != count) {
                long[] jArr = new long[count];
                this.mStoredOffsets = jArr;
                storedOffsets = jArr;
            }
        } else if (storedOffsets != null) {
            this.mStoredOffsets = null;
            storedOffsets = null;
        }
        int i11 = 0;
        while (i11 < count) {
            Animation a10 = children.get(i11);
            if (durationSet2) {
                a10.setDuration(duration);
            }
            if (fillAfterSet) {
                a10.setFillAfter(fillAfter);
            }
            if (fillBeforeSet) {
                a10.setFillBefore(fillBefore);
            }
            if (repeatModeSet) {
                a10.setRepeatMode(repeatMode);
            }
            if (!shareInterpolator) {
                durationSet = durationSet2;
                interpolator = interpolator4;
            } else {
                durationSet = durationSet2;
                interpolator = interpolator4;
                a10.setInterpolator(interpolator);
            }
            if (!startOffsetSet2) {
                startOffsetSet = startOffsetSet2;
                interpolator2 = interpolator;
            } else {
                long offset = a10.getStartOffset();
                startOffsetSet = startOffsetSet2;
                interpolator2 = interpolator;
                a10.setStartOffset(offset + startOffset);
                storedOffsets[i11] = offset;
            }
            a10.initialize(width, height, parentWidth, parentHeight);
            i11++;
            startOffsetSet2 = startOffsetSet;
            durationSet2 = durationSet;
            children = children;
            count = count;
            interpolator4 = interpolator2;
        }
    }

    @Override // android.view.animation.Animation
    public void reset() {
        super.reset();
        restoreChildrenStartOffset();
    }

    void restoreChildrenStartOffset() {
        long[] offsets = this.mStoredOffsets;
        if (offsets == null) {
            return;
        }
        ArrayList<Animation> children = this.mAnimations;
        int count = children.size();
        for (int i10 = 0; i10 < count; i10++) {
            children.get(i10).setStartOffset(offsets[i10]);
        }
    }

    public List<Animation> getAnimations() {
        return this.mAnimations;
    }

    @Override // android.view.animation.Animation
    public boolean willChangeTransformationMatrix() {
        return (this.mFlags & 64) == 64;
    }

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return (this.mFlags & 128) == 128;
    }

    @Override // android.view.animation.Animation
    public boolean hasExtension() {
        Iterator<Animation> iterator2 = this.mAnimations.iterator2();
        while (iterator2.hasNext()) {
            Animation animation = iterator2.next();
            if (animation.hasExtension()) {
                return true;
            }
        }
        return false;
    }
}
