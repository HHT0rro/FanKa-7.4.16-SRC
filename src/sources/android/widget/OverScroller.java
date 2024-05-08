package android.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class OverScroller {
    private static final int DEFAULT_DURATION = 250;
    private static final int FLING_MODE = 1;
    private static final int SCROLL_MODE = 0;
    private final boolean mFlywheel;
    private Interpolator mInterpolator;
    private int mMode;
    private IOplusOverScrollerExt mOplusOverScrollerExt;
    private IOverScrollerSocExt mOverScrollerSocExt;
    private final SplineOverScroller mScrollerX;
    private final SplineOverScroller mScrollerY;
    private final OverScrollerWrapper mWrapper;

    public OverScroller(Context context) {
        this(context, null);
    }

    public OverScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public OverScroller(Context context, Interpolator interpolator, boolean flywheel) {
        this.mWrapper = new OverScrollerWrapper();
        if (interpolator == null) {
            this.mInterpolator = new Scroller.ViscousFluidInterpolator();
        } else {
            this.mInterpolator = interpolator;
        }
        this.mFlywheel = flywheel;
        SplineOverScroller splineOverScroller = new SplineOverScroller(context);
        this.mScrollerX = splineOverScroller;
        SplineOverScroller splineOverScroller2 = new SplineOverScroller(context);
        this.mScrollerY = splineOverScroller2;
        splineOverScroller.mSplineOverScrollerSocExt.setVariableRefreshRateEnable(false);
        splineOverScroller2.mSplineOverScrollerSocExt.setVariableRefreshRateEnable(true);
        IOverScrollerSocExt iOverScrollerSocExt = (IOverScrollerSocExt) ExtLoader.type(IOverScrollerSocExt.class).base(this).create();
        this.mOverScrollerSocExt = iOverScrollerSocExt;
        splineOverScroller.mOverScrollerSocExt = iOverScrollerSocExt;
        splineOverScroller2.mOverScrollerSocExt = this.mOverScrollerSocExt;
        IOverScrollerSocExt iOverScrollerSocExt2 = this.mOverScrollerSocExt;
        if (iOverScrollerSocExt2 != null) {
            iOverScrollerSocExt2.setPerfHintContext(context);
        }
        IOplusOverScrollerExt iOplusOverScrollerExt = (IOplusOverScrollerExt) ExtLoader.type(IOplusOverScrollerExt.class).base(this).create();
        this.mOplusOverScrollerExt = iOplusOverScrollerExt;
        iOplusOverScrollerExt.hookOverScroller(context, this.mInterpolator);
        this.mInterpolator = this.mOplusOverScrollerExt.getInterpolator(this.mInterpolator);
    }

    @Deprecated
    public OverScroller(Context context, Interpolator interpolator, float bounceCoefficientX, float bounceCoefficientY) {
        this(context, interpolator, true);
    }

    @Deprecated
    public OverScroller(Context context, Interpolator interpolator, float bounceCoefficientX, float bounceCoefficientY, boolean flywheel) {
        this(context, interpolator, flywheel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            this.mOplusOverScrollerExt.setInterpolator(interpolator);
        } else if (interpolator == null) {
            this.mInterpolator = new Scroller.ViscousFluidInterpolator();
        } else {
            this.mInterpolator = interpolator;
        }
    }

    public final void setFriction(float friction) {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            this.mOplusOverScrollerExt.setFriction(friction);
        } else {
            this.mScrollerX.setFriction(friction);
            this.mScrollerY.setFriction(friction);
        }
    }

    public final boolean isFinished() {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            return this.mOplusOverScrollerExt.isFinished();
        }
        return this.mScrollerX.mFinished && this.mScrollerY.mFinished;
    }

    public final void forceFinished(boolean finished) {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            this.mOplusOverScrollerExt.forceFinished(finished);
            return;
        }
        SplineOverScroller splineOverScroller = this.mScrollerX;
        this.mScrollerY.mFinished = finished;
        splineOverScroller.mFinished = finished;
        this.mOverScrollerSocExt.setFlingFlag(finished && this.mMode == 1, 1);
    }

    public final int getCurrX() {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            return this.mOplusOverScrollerExt.getCurrX();
        }
        return this.mScrollerX.mCurrentPosition;
    }

    public final int getCurrY() {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            return this.mOplusOverScrollerExt.getCurrY();
        }
        return this.mScrollerY.mCurrentPosition;
    }

    public float getCurrVelocity() {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            return this.mOplusOverScrollerExt.getCurrVelocity();
        }
        return (float) Math.hypot(this.mScrollerX.mCurrVelocity, this.mScrollerY.mCurrVelocity);
    }

    public final int getStartX() {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            return this.mOplusOverScrollerExt.getStartX();
        }
        return this.mScrollerX.mStart;
    }

    public final int getStartY() {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            return this.mOplusOverScrollerExt.getStartY();
        }
        return this.mScrollerY.mStart;
    }

    public final int getFinalX() {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            return this.mOplusOverScrollerExt.getFinalX();
        }
        return this.mScrollerX.mFinal;
    }

    public final int getFinalY() {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            return this.mOplusOverScrollerExt.getFinalY();
        }
        return this.mScrollerY.mFinal;
    }

    public final int getDuration() {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            return this.mOplusOverScrollerExt.getDuration();
        }
        return Math.max(this.mScrollerX.mDuration, this.mScrollerY.mDuration);
    }

    public void extendDuration(int extend) {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            this.mOplusOverScrollerExt.extendDuration(extend);
        } else {
            this.mScrollerX.extendDuration(extend);
            this.mScrollerY.extendDuration(extend);
        }
    }

    public void setFinalX(int newX) {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            this.mOplusOverScrollerExt.setFinalX(newX);
        } else {
            this.mScrollerX.setFinalPosition(newX);
        }
    }

    public void setFinalY(int newY) {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            this.mOplusOverScrollerExt.setFinalY(newY);
        } else {
            this.mScrollerY.setFinalPosition(newY);
        }
    }

    public boolean computeScrollOffset() {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            return this.mOplusOverScrollerExt.computeScrollOffset();
        }
        if (isFinished()) {
            this.mOverScrollerSocExt.setFlingFlag(this.mMode == 1, 1);
            return false;
        }
        switch (this.mMode) {
            case 0:
                long time = AnimationUtils.currentAnimationTimeMillis();
                long elapsedTime = time - this.mScrollerX.mStartTime;
                int duration = this.mScrollerX.mDuration;
                if (elapsedTime < duration) {
                    float q10 = this.mInterpolator.getInterpolation(((float) elapsedTime) / duration);
                    this.mScrollerX.updateScroll(q10);
                    this.mScrollerY.updateScroll(q10);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.mScrollerX.mFinished && !this.mScrollerX.update() && !this.mScrollerX.continueWhenFinished()) {
                    this.mScrollerX.finish();
                }
                if (!this.mScrollerY.mFinished && !this.mScrollerY.update() && !this.mScrollerY.continueWhenFinished()) {
                    this.mScrollerY.finish();
                }
                this.mOverScrollerSocExt.setFlingFlag(isFinished(), 1);
                break;
        }
        return true;
    }

    public void startScroll(int startX, int startY, int dx, int dy) {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            this.mOplusOverScrollerExt.startScroll(startX, startY, dx, dy);
        } else {
            startScroll(startX, startY, dx, dy, 250);
        }
    }

    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            this.mOplusOverScrollerExt.startScroll(startX, startY, dx, dy, duration);
            return;
        }
        this.mMode = 0;
        this.mScrollerX.startScroll(startX, dx, duration);
        this.mScrollerY.startScroll(startY, dy, duration);
    }

    public boolean springBack(int startX, int startY, int minX, int maxX, int minY, int maxY) {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            return this.mOplusOverScrollerExt.springBack(startX, startY, minX, maxX, minY, maxY);
        }
        this.mMode = 1;
        boolean spingbackX = this.mScrollerX.springback(startX, minX, maxX);
        boolean spingbackY = this.mScrollerY.springback(startY, minY, maxY);
        return spingbackX || spingbackY;
    }

    public void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY) {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            this.mOplusOverScrollerExt.fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY);
        } else {
            fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY, 0, 0);
        }
    }

    public void fling(int startX, int startY, int velocityX, int velocityY, int minX, int maxX, int minY, int maxY, int overX, int overY) {
        int velocityX2 = velocityX;
        int velocityY2 = velocityY;
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            this.mOplusOverScrollerExt.fling(startX, startY, velocityX, velocityY, minX, maxX, minY, maxY, overX, overY);
            return;
        }
        if (this.mFlywheel && !isFinished()) {
            float oldVelocityX = this.mScrollerX.mCurrVelocity;
            float oldVelocityY = this.mScrollerY.mCurrVelocity;
            if (Math.signum(velocityX2) == Math.signum(oldVelocityX) && Math.signum(velocityY2) == Math.signum(oldVelocityY)) {
                velocityX2 = (int) (velocityX2 + oldVelocityX);
                velocityY2 = (int) (velocityY2 + oldVelocityY);
            }
        }
        if (this.mOplusOverScrollerExt.hookCheckFlingFlag()) {
            this.mOverScrollerSocExt.setFlingFlag(false, 0);
        }
        this.mMode = 1;
        this.mScrollerX.fling(startX, velocityX2, minX, maxX, overX);
        this.mScrollerY.fling(startY, velocityY2, minY, maxY, overY);
    }

    public void notifyHorizontalEdgeReached(int startX, int finalX, int overX) {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            this.mOplusOverScrollerExt.notifyHorizontalEdgeReached(startX, finalX, overX);
        } else {
            this.mScrollerX.notifyEdgeReached(startX, finalX, overX);
        }
    }

    public void notifyVerticalEdgeReached(int startY, int finalY, int overY) {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            this.mOplusOverScrollerExt.notifyVerticalEdgeReached(startY, finalY, overY);
        } else {
            this.mScrollerY.notifyEdgeReached(startY, finalY, overY);
        }
    }

    public boolean isOverScrolled() {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            return this.mOplusOverScrollerExt.isOverScrolled();
        }
        return ((this.mScrollerX.mFinished || this.mScrollerX.mState == 0) && (this.mScrollerY.mFinished || this.mScrollerY.mState == 0)) ? false : true;
    }

    public void abortAnimation() {
        this.mOverScrollerSocExt.setFlingFlag(this.mMode == 1, 1);
        this.mOplusOverScrollerExt.hookAbortAnimation(this.mScrollerX.mSplineOverScrollerExt, this.mScrollerY.mSplineOverScrollerExt);
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            this.mOplusOverScrollerExt.abortAnimation();
        } else {
            this.mScrollerX.finish();
            this.mScrollerY.finish();
        }
    }

    public int timePassed() {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            return this.mOplusOverScrollerExt.timePassed();
        }
        long time = AnimationUtils.currentAnimationTimeMillis();
        long startTime = Math.min(this.mScrollerX.mStartTime, this.mScrollerY.mStartTime);
        return (int) (time - startTime);
    }

    public boolean isScrollingInDirection(float xvel, float yvel) {
        if (this.mOplusOverScrollerExt.getForceUsingSpring()) {
            return this.mOplusOverScrollerExt.isScrollingInDirection(xvel, yvel);
        }
        int dx = this.mScrollerX.mFinal - this.mScrollerX.mStart;
        int dy = this.mScrollerY.mFinal - this.mScrollerY.mStart;
        return !isFinished() && Math.signum(xvel) == Math.signum((float) dx) && Math.signum(yvel) == Math.signum((float) dy);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double getSplineFlingDistance(int velocity) {
        return this.mScrollerY.getSplineFlingDistance(velocity);
    }

    public IOverScrollerWrapper getWrapper() {
        return this.mWrapper;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class OverScrollerWrapper implements IOverScrollerWrapper {
        private OverScrollerWrapper() {
        }

        @Override // android.widget.IOverScrollerWrapper
        public IOplusOverScrollerExt getExtImpl() {
            return OverScroller.this.mOplusOverScrollerExt;
        }

        @Override // android.widget.IOverScrollerWrapper
        public int getMode() {
            return OverScroller.this.mMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class SplineOverScroller {
        private static final int BALLISTIC = 2;
        private static final int CUBIC = 1;
        private static final float END_TENSION = 1.0f;
        private static final float GRAVITY = 2000.0f;
        private static final float INFLEXION = 0.35f;
        private static final int NB_SAMPLES = 100;
        private static final float P1 = 0.175f;
        private static final float P2 = 0.35000002f;
        private static final int SPLINE = 0;
        private static final float START_TENSION = 0.5f;
        private Context mContext;
        private float mCurrVelocity;
        private int mCurrentPosition;
        private float mDeceleration;
        private int mDuration;
        private int mFinal;
        private int mOver;
        public IOverScrollerSocExt mOverScrollerSocExt;
        private float mPhysicalCoeff;
        private int mSplineDistance;
        private int mSplineDuration;
        private int mStart;
        private long mStartTime;
        private int mVelocity;
        private static float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] SPLINE_POSITION = new float[101];
        private static final float[] SPLINE_TIME = new float[101];
        public ISplineOverScrollerSocExt mSplineOverScrollerSocExt = (ISplineOverScrollerSocExt) ExtLoader.type(ISplineOverScrollerSocExt.class).base(this).create();
        private float mFlingFriction = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private ISplineOverScrollerWrapper mSplineOverScrollerWrapper = new SplineOverScrollerWrapper();
        private ISplineOverScrollerExt mSplineOverScrollerExt = (ISplineOverScrollerExt) ExtLoader.type(ISplineOverScrollerExt.class).base(this).create();
        private boolean mFinished = true;

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

        void setFriction(float friction) {
            this.mFlingFriction = friction;
            if (this.mSplineOverScrollerSocExt.isVariableRefreshRateEnabled()) {
                this.mSplineOverScrollerSocExt.setFlingFriction(this.mFlingFriction);
            }
        }

        SplineOverScroller(Context context) {
            this.mContext = context;
            float ppi = context.getResources().getDisplayMetrics().density * 160.0f;
            this.mPhysicalCoeff = 386.0878f * ppi * 0.84f;
            this.mSplineOverScrollerSocExt.initScrollScenario(this.mContext);
        }

        void updateScroll(float q10) {
            this.mCurrentPosition = this.mStart + Math.round((this.mFinal - r0) * q10);
        }

        private static float getDeceleration(int velocity) {
            if (velocity > 0) {
                return -2000.0f;
            }
            return GRAVITY;
        }

        private void adjustDuration(int start, int oldFinal, int newFinal) {
            int oldDistance = oldFinal - start;
            int newDistance = newFinal - start;
            float x10 = Math.abs(newDistance / oldDistance);
            int index = (int) (x10 * 100.0f);
            if (index < 100) {
                float x_inf = index / 100.0f;
                float x_sup = (index + 1) / 100.0f;
                float[] fArr = SPLINE_TIME;
                float t_inf = fArr[index];
                float t_sup = fArr[index + 1];
                float timeCoef = (((x10 - x_inf) / (x_sup - x_inf)) * (t_sup - t_inf)) + t_inf;
                this.mDuration = (int) (this.mDuration * timeCoef);
            }
        }

        void startScroll(int start, int distance, int duration) {
            this.mFinished = false;
            this.mStart = start;
            this.mCurrentPosition = start;
            this.mFinal = start + distance;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = duration;
            this.mDeceleration = 0.0f;
            this.mVelocity = 0;
            this.mSplineOverScrollerExt.markOnStartScroll();
        }

        void finish() {
            this.mSplineOverScrollerSocExt.perfHintFinish();
            this.mCurrentPosition = this.mFinal;
            this.mSplineOverScrollerExt.hookResetVeloAccuCount();
            this.mFinished = true;
            this.mSplineOverScrollerExt.onFlingFinish();
        }

        void setFinalPosition(int position) {
            this.mFinal = position;
            this.mSplineDistance = position - this.mStart;
            this.mFinished = false;
        }

        void extendDuration(int extend) {
            long time = AnimationUtils.currentAnimationTimeMillis();
            int elapsedTime = (int) (time - this.mStartTime);
            int i10 = elapsedTime + extend;
            this.mSplineDuration = i10;
            this.mDuration = i10;
            this.mFinished = false;
        }

        boolean springback(int start, int min, int max) {
            this.mFinished = true;
            this.mSplineOverScrollerExt.hookResetVeloAccuCount();
            this.mFinal = start;
            this.mStart = start;
            this.mCurrentPosition = start;
            this.mVelocity = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (start < min) {
                startSpringback(start, min, 0);
            } else if (start > max) {
                startSpringback(start, max, 0);
            }
            return true ^ this.mFinished;
        }

        private void startSpringback(int start, int end, int velocity) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = start;
            this.mCurrentPosition = start;
            this.mFinal = end;
            int delta = start - end;
            this.mDeceleration = getDeceleration(delta);
            this.mVelocity = -delta;
            this.mOver = Math.abs(delta);
            this.mDuration = (int) (Math.sqrt((delta * (-2.0d)) / this.mDeceleration) * 1000.0d);
            this.mSplineOverScrollerExt.onFlingStateUpdate(this.mState);
        }

        void fling(int start, int velocity, int min, int max, int over) {
            this.mSplineOverScrollerSocExt.perfHintStart(velocity);
            long now = System.currentTimeMillis();
            this.mSplineOverScrollerExt.hookStartFling(now, this.mCurrVelocity, velocity, this.mFinished);
            this.mOver = over;
            this.mFinished = false;
            this.mVelocity = velocity;
            this.mCurrVelocity = velocity;
            this.mSplineDuration = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = start;
            this.mCurrentPosition = start;
            this.mSplineOverScrollerExt.markOnFling();
            if (start > max || start < min) {
                startAfterEdge(start, min, max, velocity);
                return;
            }
            this.mState = 0;
            double totalDistance = ShadowDrawableWrapper.COS_45;
            if (velocity != 0) {
                int intValue = ((Integer) this.mSplineOverScrollerExt.hookEndFling(this.mContext, velocity, this.mFlingFriction).first).intValue();
                this.mSplineDuration = intValue;
                this.mDuration = intValue;
                totalDistance = ((Double) this.mSplineOverScrollerExt.hookEndFling(this.mContext, velocity, this.mFlingFriction).second).doubleValue();
            }
            int signum = (int) (Math.signum(velocity) * totalDistance);
            this.mSplineDistance = signum;
            int i10 = signum + start;
            this.mFinal = i10;
            if (i10 < min) {
                adjustDuration(this.mStart, i10, min);
                this.mFinal = min;
            }
            int i11 = this.mFinal;
            if (i11 > max) {
                adjustDuration(this.mStart, i11, max);
                this.mFinal = max;
            }
            this.mSplineOverScrollerExt.onFlingStart(this.mDuration, (int) this.mCurrVelocity, this.mCurrentPosition);
        }

        private double getSplineDeceleration(int velocity) {
            return Math.log((Math.abs(velocity) * INFLEXION) / (this.mFlingFriction * this.mPhysicalCoeff));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public double getSplineFlingDistance(int velocity) {
            double l10 = getSplineDeceleration(velocity);
            double decelMinusOne = DECELERATION_RATE - 1.0d;
            if (this.mSplineOverScrollerSocExt.isVariableRefreshRateEnabled() && this.mSplineOverScrollerSocExt.isSmoothFlingEnabled()) {
                return this.mSplineOverScrollerSocExt.getSplineFlingDistance();
            }
            return this.mFlingFriction * this.mPhysicalCoeff * Math.exp((DECELERATION_RATE / decelMinusOne) * l10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getSplineFlingDuration(int velocity) {
            double l10 = getSplineDeceleration(velocity);
            double decelMinusOne = DECELERATION_RATE - 1.0d;
            if (this.mSplineOverScrollerSocExt.isVariableRefreshRateEnabled() && this.mSplineOverScrollerSocExt.isSmoothFlingEnabled()) {
                return this.mSplineOverScrollerSocExt.getSplineDuration();
            }
            return (int) (Math.exp(l10 / decelMinusOne) * 1000.0d);
        }

        private void fitOnBounceCurve(int start, int end, int velocity) {
            float f10 = this.mDeceleration;
            float durationToApex = (-velocity) / f10;
            float velocitySquared = velocity * velocity;
            float distanceToApex = (velocitySquared / 2.0f) / Math.abs(f10);
            float distanceToEdge = Math.abs(end - start);
            float totalDuration = (float) Math.sqrt(((distanceToApex + distanceToEdge) * 2.0d) / Math.abs(this.mDeceleration));
            this.mStartTime -= (int) ((totalDuration - durationToApex) * 1000.0f);
            this.mStart = end;
            this.mCurrentPosition = end;
            this.mVelocity = (int) ((-this.mDeceleration) * totalDuration);
        }

        private void startBounceAfterEdge(int start, int end, int velocity) {
            this.mDeceleration = getDeceleration(velocity == 0 ? start - end : velocity);
            fitOnBounceCurve(start, end, velocity);
            onEdgeReached();
        }

        private void startAfterEdge(int start, int min, int max, int velocity) {
            if (start > min && start < max) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.mFinished = true;
                return;
            }
            boolean positive = start > max;
            int edge = positive ? max : min;
            int overDistance = start - edge;
            boolean keepIncreasing = overDistance * velocity >= 0;
            if (keepIncreasing) {
                startBounceAfterEdge(start, edge, velocity);
                return;
            }
            double totalDistance = getSplineFlingDistance(velocity);
            if (totalDistance > Math.abs(overDistance)) {
                fling(start, velocity, positive ? min : start, positive ? start : max, this.mOver);
            } else {
                startSpringback(start, edge, velocity);
            }
        }

        void notifyEdgeReached(int start, int end, int over) {
            if (this.mState == 0) {
                this.mOver = over;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                startAfterEdge(start, end, end, (int) this.mCurrVelocity);
            }
        }

        private void onEdgeReached() {
            int i10 = this.mVelocity;
            float velocitySquared = i10 * i10;
            float distance = velocitySquared / (Math.abs(this.mDeceleration) * 2.0f);
            float sign = Math.signum(this.mVelocity);
            int i11 = this.mOver;
            if (distance > i11) {
                this.mDeceleration = ((-sign) * velocitySquared) / (i11 * 2.0f);
                distance = i11;
            }
            this.mOver = (int) distance;
            this.mState = 2;
            int i12 = this.mStart;
            int i13 = this.mVelocity;
            this.mFinal = i12 + ((int) (i13 > 0 ? distance : -distance));
            this.mDuration = -((int) ((i13 * 1000.0f) / this.mDeceleration));
            this.mSplineOverScrollerExt.onFlingStateUpdate(2);
        }

        boolean continueWhenFinished() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration >= this.mSplineDuration) {
                        return false;
                    }
                    int i10 = this.mFinal;
                    this.mStart = i10;
                    this.mCurrentPosition = i10;
                    int i11 = (int) this.mCurrVelocity;
                    this.mVelocity = i11;
                    this.mDeceleration = getDeceleration(i11);
                    this.mStartTime += this.mDuration;
                    onEdgeReached();
                    break;
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    startSpringback(this.mFinal, this.mStart, 0);
                    break;
            }
            update();
            return true;
        }

        boolean update() {
            float t_inf;
            float d_inf;
            long time = AnimationUtils.currentAnimationTimeMillis();
            IOverScrollerSocExt iOverScrollerSocExt = this.mOverScrollerSocExt;
            long adjustedTime = iOverScrollerSocExt != null ? iOverScrollerSocExt.getAdjustedAnimationClock(time, this.mStartTime) : time;
            long j10 = this.mStartTime;
            long currentTime = this.mSplineOverScrollerExt.markOnUpdateStart(j10, adjustedTime - j10);
            if (currentTime <= 0) {
                return this.mDuration > 0;
            }
            if (currentTime > this.mDuration) {
                return false;
            }
            IOverScrollerSocExt iOverScrollerSocExt2 = this.mOverScrollerSocExt;
            if (iOverScrollerSocExt2 != null) {
                iOverScrollerSocExt2.hookScrollPerfHint(this, true);
            }
            double distance = ShadowDrawableWrapper.COS_45;
            switch (this.mState) {
                case 0:
                    if (!this.mSplineOverScrollerSocExt.isVariableRefreshRateEnabled()) {
                        int i10 = this.mSplineDuration;
                        float t2 = ((float) currentTime) / i10;
                        int index = (int) (t2 * 100.0f);
                        if (index < 100 && index >= 0) {
                            float t_inf2 = index / 100.0f;
                            float t_sup = (index + 1) / 100.0f;
                            float[] fArr = SPLINE_POSITION;
                            float d_inf2 = fArr[index];
                            float d_sup = fArr[index + 1];
                            float velocityCoef = (d_sup - d_inf2) / (t_sup - t_inf2);
                            float distanceCoef = d_inf2 + ((t2 - t_inf2) * velocityCoef);
                            t_inf = distanceCoef;
                            d_inf = velocityCoef;
                        } else {
                            t_inf = 1.0f;
                            d_inf = 0.0f;
                        }
                        int i11 = this.mSplineDistance;
                        distance = i11 * t_inf;
                        this.mCurrVelocity = ((i11 * d_inf) / i10) * 1000.0f;
                        this.mSplineOverScrollerExt.markOnUpdateSpline(i10, t2, currentTime, (int) (distance - (this.mCurrentPosition - this.mStart)));
                        break;
                    } else {
                        this.mSplineOverScrollerSocExt.perfHintUpdate(currentTime);
                        distance = this.mSplineOverScrollerSocExt.getCurrentDistance();
                        this.mCurrVelocity = this.mSplineOverScrollerSocExt.getCurrentVelocity();
                        break;
                    }
                case 1:
                    float t10 = ((float) currentTime) / this.mDuration;
                    float t22 = t10 * t10;
                    float sign = Math.signum(this.mVelocity);
                    int i12 = this.mOver;
                    distance = i12 * sign * ((3.0f * t22) - ((2.0f * t10) * t22));
                    this.mCurrVelocity = i12 * sign * 6.0f * ((-t10) + t22);
                    break;
                case 2:
                    float t11 = ((float) currentTime) / 1000.0f;
                    int i13 = this.mVelocity;
                    float f10 = this.mDeceleration;
                    this.mCurrVelocity = i13 + (f10 * t11);
                    distance = (i13 * t11) + (((f10 * t11) * t11) / 2.0f);
                    break;
            }
            this.mCurrentPosition = this.mStart + ((int) Math.round(distance));
            this.mSplineOverScrollerExt.onFlingPositionUpdate(Math.round(this.mCurrVelocity), this.mCurrentPosition);
            this.mSplineOverScrollerExt.markOnUpdateEnd();
            return true;
        }

        public ISplineOverScrollerWrapper getWrapper() {
            return this.mSplineOverScrollerWrapper;
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        private class SplineOverScrollerWrapper implements ISplineOverScrollerWrapper {
            private SplineOverScrollerWrapper() {
            }

            @Override // android.widget.ISplineOverScrollerWrapper
            public int getSplineFlingDuration(int velocity) {
                return SplineOverScroller.this.getSplineFlingDuration(velocity);
            }

            @Override // android.widget.ISplineOverScrollerWrapper
            public double getSplineFlingDistance(int velocity) {
                return SplineOverScroller.this.getSplineFlingDistance(velocity);
            }

            @Override // android.widget.ISplineOverScrollerWrapper
            public Context getContext() {
                return SplineOverScroller.this.mContext;
            }

            @Override // android.widget.ISplineOverScrollerWrapper
            public float[] getSplinePosition() {
                return SplineOverScroller.SPLINE_POSITION;
            }

            @Override // android.widget.ISplineOverScrollerWrapper
            public float getFlingFriction() {
                return SplineOverScroller.this.mFlingFriction;
            }

            @Override // android.widget.ISplineOverScrollerWrapper
            public float getPhysicalCoeff() {
                return SplineOverScroller.this.mPhysicalCoeff;
            }
        }
    }
}
