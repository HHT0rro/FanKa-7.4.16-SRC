package android.widget;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class Scroller {
    private static final int DEFAULT_DURATION = 250;
    private static final float END_TENSION = 1.0f;
    private static final int FLING_MODE = 1;
    private static final float INFLEXION = 0.35f;
    private static final int NB_SAMPLES = 100;
    private static final float P1 = 0.175f;
    private static final float P2 = 0.35000002f;
    private static final int SCROLL_MODE = 0;
    private static final float START_TENSION = 0.5f;
    private float mCurrVelocity;
    private int mCurrX;
    private int mCurrY;
    private float mDeceleration;
    private float mDeltaX;
    private float mDeltaY;
    private int mDistance;
    private int mDuration;
    private float mDurationReciprocal;
    private int mFinalX;
    private int mFinalY;
    private boolean mFinished;
    private float mFlingFriction;
    private boolean mFlywheel;
    private final Interpolator mInterpolator;
    private int mMaxX;
    private int mMaxY;
    private int mMinX;
    private int mMinY;
    private int mMode;
    private float mPhysicalCoeff;
    private final float mPpi;
    public IScrollerSocExt mSocExt;
    private long mStartTime;
    private int mStartX;
    private int mStartY;
    private float mVelocity;
    private static float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
    private static final float[] SPLINE_POSITION = new float[101];
    private static final float[] SPLINE_TIME = new float[101];

    static {
        float f10;
        float x10;
        float f11;
        float coef;
        float y10;
        float coef2;
        float x_min = 0.0f;
        float y_min = 0.0f;
        for (int i10 = 0; i10 < 100; i10++) {
            float alpha = i10 / 100.0f;
            float x_max = 1.0f;
            while (true) {
                f10 = 2.0f;
                x10 = ((x_max - x_min) / 2.0f) + x_min;
                f11 = 3.0f;
                coef = x10 * 3.0f * (1.0f - x10);
                float tx = ((((1.0f - x10) * 0.175f) + (x10 * P2)) * coef) + (x10 * x10 * x10);
                if (Math.abs(tx - alpha) < 1.0E-5d) {
                    break;
                } else if (tx > alpha) {
                    x_max = x10;
                } else {
                    x_min = x10;
                }
            }
            SPLINE_POSITION[i10] = ((((1.0f - x10) * 0.5f) + x10) * coef) + (x10 * x10 * x10);
            float y_max = 1.0f;
            while (true) {
                y10 = ((y_max - y_min) / f10) + y_min;
                coef2 = y10 * f11 * (1.0f - y10);
                float dy = ((((1.0f - y10) * 0.5f) + y10) * coef2) + (y10 * y10 * y10);
                if (Math.abs(dy - alpha) < 1.0E-5d) {
                    break;
                }
                if (dy > alpha) {
                    y_max = y10;
                    f10 = 2.0f;
                    f11 = 3.0f;
                } else {
                    y_min = y10;
                    f10 = 2.0f;
                    f11 = 3.0f;
                }
            }
            SPLINE_TIME[i10] = (coef2 * (((1.0f - y10) * 0.175f) + (P2 * y10))) + (y10 * y10 * y10);
        }
        float[] fArr = SPLINE_POSITION;
        SPLINE_TIME[100] = 1.0f;
        fArr[100] = 1.0f;
    }

    public Scroller(Context context) {
        this(context, null);
    }

    public Scroller(Context context, Interpolator interpolator) {
        this(context, interpolator, context.getApplicationInfo().targetSdkVersion >= 11);
    }

    public Scroller(Context context, Interpolator interpolator, boolean flywheel) {
        this.mFlingFriction = ViewConfiguration.getScrollFriction();
        IScrollerSocExt iScrollerSocExt = (IScrollerSocExt) ExtLoader.type(IScrollerSocExt.class).base(this).create();
        this.mSocExt = iScrollerSocExt;
        iScrollerSocExt.setPerfHintContext(context);
        this.mFinished = true;
        if (interpolator == null) {
            this.mInterpolator = new ViscousFluidInterpolator();
        } else {
            this.mInterpolator = interpolator;
        }
        this.mPpi = context.getResources().getDisplayMetrics().density * 160.0f;
        this.mDeceleration = computeDeceleration(ViewConfiguration.getScrollFriction());
        this.mFlywheel = flywheel;
        this.mPhysicalCoeff = computeDeceleration(0.84f);
    }

    public final void setFriction(float friction) {
        this.mDeceleration = computeDeceleration(friction);
        this.mFlingFriction = friction;
    }

    private float computeDeceleration(float friction) {
        return this.mPpi * 386.0878f * friction;
    }

    public final boolean isFinished() {
        return this.mFinished;
    }

    public final void forceFinished(boolean finished) {
        this.mFinished = finished;
    }

    public final int getDuration() {
        return this.mDuration;
    }

    public final int getCurrX() {
        return this.mCurrX;
    }

    public final int getCurrY() {
        return this.mCurrY;
    }

    public float getCurrVelocity() {
        return this.mMode == 1 ? this.mCurrVelocity : this.mVelocity - ((this.mDeceleration * timePassed()) / 2000.0f);
    }

    public final int getStartX() {
        return this.mStartX;
    }

    public final int getStartY() {
        return this.mStartY;
    }

    public final int getFinalX() {
        return this.mFinalX;
    }

    public final int getFinalY() {
        return this.mFinalY;
    }

    public boolean computeScrollOffset() {
        if (this.mFinished) {
            return false;
        }
        int timePassed = (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
        int i10 = this.mDuration;
        if (timePassed < i10) {
            switch (this.mMode) {
                case 0:
                    float x10 = this.mInterpolator.getInterpolation(timePassed * this.mDurationReciprocal);
                    this.mCurrX = this.mStartX + Math.round(this.mDeltaX * x10);
                    this.mCurrY = this.mStartY + Math.round(this.mDeltaY * x10);
                    break;
                case 1:
                    float t2 = timePassed / i10;
                    int index = (int) (t2 * 100.0f);
                    float distanceCoef = 1.0f;
                    float velocityCoef = 0.0f;
                    if (index < 100) {
                        float t_inf = index / 100.0f;
                        float t_sup = (index + 1) / 100.0f;
                        float[] fArr = SPLINE_POSITION;
                        float d_inf = fArr[index];
                        float d_sup = fArr[index + 1];
                        velocityCoef = (d_sup - d_inf) / (t_sup - t_inf);
                        distanceCoef = d_inf + ((t2 - t_inf) * velocityCoef);
                    }
                    this.mCurrVelocity = ((this.mDistance * velocityCoef) / i10) * 1000.0f;
                    int round = this.mStartX + Math.round((this.mFinalX - r1) * distanceCoef);
                    this.mCurrX = round;
                    int min = Math.min(round, this.mMaxX);
                    this.mCurrX = min;
                    this.mCurrX = Math.max(min, this.mMinX);
                    int round2 = this.mStartY + Math.round((this.mFinalY - r1) * distanceCoef);
                    this.mCurrY = round2;
                    int min2 = Math.min(round2, this.mMaxY);
                    this.mCurrY = min2;
                    int max = Math.max(min2, this.mMinY);
                    this.mCurrY = max;
                    if (this.mCurrX == this.mFinalX && max == this.mFinalY) {
                        this.mFinished = true;
                        break;
                    }
                    break;
            }
        } else {
            this.mCurrX = this.mFinalX;
            this.mCurrY = this.mFinalY;
            this.mFinished = true;
        }
        return true;
    }

    public void startScroll(int startX, int startY, int dx, int dy) {
        startScroll(startX, startY, dx, dy, 250);
    }

    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        this.mMode = 0;
        this.mFinished = false;
        this.mDuration = duration;
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mStartX = startX;
        this.mStartY = startY;
        this.mFinalX = startX + dx;
        this.mFinalY = startY + dy;
        this.mDeltaX = dx;
        this.mDeltaY = dy;
        this.mDurationReciprocal = 1.0f / this.mDuration;
        this.mSocExt.hookScrollHorizontalPerfHint(duration);
    }

    public void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY) {
        int velocityX2 = velocityX;
        int velocityY2 = velocityY;
        if (this.mFlywheel && !this.mFinished) {
            float oldVel = getCurrVelocity();
            float dx = this.mFinalX - this.mStartX;
            float dy = this.mFinalY - this.mStartY;
            float hyp = (float) Math.hypot(dx, dy);
            float ndx = dx / hyp;
            float ndy = dy / hyp;
            float oldVelocityX = ndx * oldVel;
            float oldVelocityY = ndy * oldVel;
            if (Math.signum(velocityX2) == Math.signum(oldVelocityX) && Math.signum(velocityY2) == Math.signum(oldVelocityY)) {
                velocityX2 = (int) (velocityX2 + oldVelocityX);
                velocityY2 = (int) (velocityY2 + oldVelocityY);
            }
        }
        this.mMode = 1;
        this.mFinished = false;
        float velocity = (float) Math.hypot(velocityX2, velocityY2);
        this.mVelocity = velocity;
        this.mDuration = getSplineFlingDuration(velocity);
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mStartX = startX;
        this.mStartY = startY;
        float coeffX = velocity == 0.0f ? 1.0f : velocityX2 / velocity;
        float coeffY = velocity != 0.0f ? velocityY2 / velocity : 1.0f;
        double totalDistance = getSplineFlingDistance(velocity);
        this.mDistance = (int) (Math.signum(velocity) * totalDistance);
        this.mMinX = minX;
        this.mMaxX = maxX;
        this.mMinY = minY;
        this.mMaxY = maxY;
        int round = ((int) Math.round(coeffX * totalDistance)) + startX;
        this.mFinalX = round;
        int min = Math.min(round, this.mMaxX);
        this.mFinalX = min;
        this.mFinalX = Math.max(min, this.mMinX);
        int round2 = ((int) Math.round(coeffY * totalDistance)) + startY;
        this.mFinalY = round2;
        int min2 = Math.min(round2, this.mMaxY);
        this.mFinalY = min2;
        this.mFinalY = Math.max(min2, this.mMinY);
    }

    private double getSplineDeceleration(float velocity) {
        return Math.log((Math.abs(velocity) * INFLEXION) / (this.mFlingFriction * this.mPhysicalCoeff));
    }

    private int getSplineFlingDuration(float velocity) {
        double l10 = getSplineDeceleration(velocity);
        double decelMinusOne = DECELERATION_RATE - 1.0d;
        return (int) (Math.exp(l10 / decelMinusOne) * 1000.0d);
    }

    private double getSplineFlingDistance(float velocity) {
        double l10 = getSplineDeceleration(velocity);
        float f10 = DECELERATION_RATE;
        double decelMinusOne = f10 - 1.0d;
        return this.mFlingFriction * this.mPhysicalCoeff * Math.exp((f10 / decelMinusOne) * l10);
    }

    public void abortAnimation() {
        this.mCurrX = this.mFinalX;
        this.mCurrY = this.mFinalY;
        this.mFinished = true;
    }

    public void extendDuration(int extend) {
        int passed = timePassed();
        int i10 = passed + extend;
        this.mDuration = i10;
        this.mDurationReciprocal = 1.0f / i10;
        this.mFinished = false;
    }

    public int timePassed() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
    }

    public void setFinalX(int newX) {
        this.mFinalX = newX;
        this.mDeltaX = newX - this.mStartX;
        this.mFinished = false;
    }

    public void setFinalY(int newY) {
        this.mFinalY = newY;
        this.mDeltaY = newY - this.mStartY;
        this.mFinished = false;
    }

    public boolean isScrollingInDirection(float xvel, float yvel) {
        return !this.mFinished && Math.signum(xvel) == Math.signum((float) (this.mFinalX - this.mStartX)) && Math.signum(yvel) == Math.signum((float) (this.mFinalY - this.mStartY));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class ViscousFluidInterpolator implements Interpolator {
        private static final float VISCOUS_FLUID_NORMALIZE;
        private static final float VISCOUS_FLUID_OFFSET;
        private static final float VISCOUS_FLUID_SCALE = 8.0f;

        static {
            float viscousFluid = 1.0f / viscousFluid(1.0f);
            VISCOUS_FLUID_NORMALIZE = viscousFluid;
            VISCOUS_FLUID_OFFSET = 1.0f - (viscousFluid * viscousFluid(1.0f));
        }

        private static float viscousFluid(float x10) {
            float x11 = x10 * 8.0f;
            if (x11 < 1.0f) {
                return x11 - (1.0f - ((float) Math.exp(-x11)));
            }
            return 0.36787945f + ((1.0f - 0.36787945f) * (1.0f - ((float) Math.exp(1.0f - x11))));
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float input) {
            float interpolated = VISCOUS_FLUID_NORMALIZE * viscousFluid(input);
            if (interpolated > 0.0f) {
                return VISCOUS_FLUID_OFFSET + interpolated;
            }
            return interpolated;
        }
    }
}
