package android.widget;

import android.animation.ValueAnimator;
import android.compat.Compatibility;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RecordingCanvas;
import android.graphics.Rect;
import android.graphics.RenderNode;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.android.internal.R;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class EdgeEffect {
    private static final double DAMPING_RATIO = 0.98d;
    private static final float EPSILON = 0.001f;
    private static final float EXP_STRETCH_INTENSITY = 0.016f;
    private static final float GLOW_ALPHA_START = 0.09f;
    private static final double LINEAR_DISTANCE_TAKE_OVER = 8.0d;
    private static final float LINEAR_STRETCH_INTENSITY = 0.016f;
    private static final float LINEAR_VELOCITY_TAKE_OVER = 200.0f;
    private static final float MAX_ALPHA = 0.15f;
    private static final float MAX_GLOW_SCALE = 2.0f;
    private static final int MAX_VELOCITY = 10000;
    private static final int MIN_VELOCITY = 100;
    private static final double NATURAL_FREQUENCY = 24.657d;
    private static final float ON_ABSORB_VELOCITY_ADJUSTMENT = 13.0f;
    private static final int PULL_DECAY_TIME = 2000;
    private static final float PULL_DISTANCE_ALPHA_GLOW_FACTOR = 0.8f;
    private static final float PULL_GLOW_BEGIN = 0.0f;
    private static final int PULL_TIME = 167;
    private static final float RADIUS_FACTOR = 0.6f;
    private static final int RECEDE_TIME = 600;
    private static final float SCROLL_DIST_AFFECTED_BY_EXP_STRETCH = 0.33f;
    private static final int STATE_ABSORB = 2;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PULL = 1;
    private static final int STATE_PULL_DECAY = 4;
    private static final int STATE_RECEDE = 3;
    private static final String TAG = "EdgeEffect";
    private static final int TYPE_GLOW = 0;
    private static final int TYPE_NONE = -1;
    private static final int TYPE_STRETCH = 1;
    public static final long USE_STRETCH_EDGE_EFFECT_BY_DEFAULT = 171228096;
    private static final double VALUE_THRESHOLD = 0.001d;
    private static final int VELOCITY_GLOW_FACTOR = 6;
    private static final double VELOCITY_THRESHOLD = 0.01d;
    private float mBaseGlowScale;
    private final Rect mBounds;
    private float mDisplacement;
    private float mDistance;
    private float mDuration;
    private int mEdgeEffectType;
    private float mGlowAlpha;
    private float mGlowAlphaFinish;
    private float mGlowAlphaStart;
    private float mGlowScaleY;
    private float mGlowScaleYFinish;
    private float mGlowScaleYStart;
    private float mHeight;
    private final Interpolator mInterpolator;
    private final Paint mPaint;
    private float mPullDistance;
    private float mRadius;
    private long mStartTime;
    private int mState;
    private float mTargetDisplacement;
    private Matrix mTmpMatrix;
    private float[] mTmpPoints;
    private float mVelocity;
    private float mWidth;
    public static final BlendMode DEFAULT_BLEND_MODE = BlendMode.SRC_ATOP;
    private static final double ANGLE = 0.5235987755982988d;
    private static final float SIN = (float) Math.sin(ANGLE);
    private static final float COS = (float) Math.cos(ANGLE);

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface EdgeEffectType {
    }

    public EdgeEffect(Context context) {
        this(context, null);
    }

    public EdgeEffect(Context context, AttributeSet attrs) {
        this.mInterpolator = new DecelerateInterpolator();
        this.mState = 0;
        this.mBounds = new Rect();
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mDisplacement = 0.5f;
        this.mTargetDisplacement = 0.5f;
        this.mEdgeEffectType = 0;
        this.mTmpMatrix = null;
        this.mTmpPoints = null;
        TypedArray a10 = context.obtainStyledAttributes(attrs, R.styleable.EdgeEffect);
        int themeColor = a10.getColor(0, -10066330);
        this.mEdgeEffectType = Compatibility.isChangeEnabled(USE_STRETCH_EDGE_EFFECT_BY_DEFAULT) ? 1 : 0;
        a10.recycle();
        paint.setAntiAlias(true);
        paint.setColor((16777215 & themeColor) | 855638016);
        paint.setStyle(Paint.Style.FILL);
        paint.setBlendMode(DEFAULT_BLEND_MODE);
    }

    private int getCurrentEdgeEffectBehavior() {
        if (!ValueAnimator.areAnimatorsEnabled()) {
            return -1;
        }
        return this.mEdgeEffectType;
    }

    public void setSize(int width, int height) {
        float f10 = SIN;
        float r10 = (width * 0.6f) / f10;
        float f11 = COS;
        float y10 = f11 * r10;
        float h10 = r10 - y10;
        float or = (height * 0.6f) / f10;
        float oy = f11 * or;
        float oh = or - oy;
        this.mRadius = r10;
        this.mBaseGlowScale = h10 > 0.0f ? Math.min(oh / h10, 1.0f) : 1.0f;
        Rect rect = this.mBounds;
        rect.set(rect.left, this.mBounds.top, width, (int) Math.min(height, h10));
        this.mWidth = width;
        this.mHeight = height;
    }

    public boolean isFinished() {
        return this.mState == 0;
    }

    public void finish() {
        this.mState = 0;
        this.mDistance = 0.0f;
        this.mVelocity = 0.0f;
    }

    public void onPull(float deltaDistance) {
        onPull(deltaDistance, 0.5f);
    }

    public void onPull(float deltaDistance, float displacement) {
        int edgeEffectBehavior = getCurrentEdgeEffectBehavior();
        if (edgeEffectBehavior == -1) {
            finish();
            return;
        }
        long now = AnimationUtils.currentAnimationTimeMillis();
        this.mTargetDisplacement = displacement;
        int i10 = this.mState;
        if (i10 == 4 && ((float) (now - this.mStartTime)) < this.mDuration && edgeEffectBehavior == 0) {
            return;
        }
        if (i10 != 1) {
            if (edgeEffectBehavior == 1) {
                this.mPullDistance = this.mDistance;
            } else {
                this.mGlowScaleY = Math.max(0.0f, this.mGlowScaleY);
            }
        }
        this.mState = 1;
        this.mStartTime = now;
        this.mDuration = 167.0f;
        float f10 = this.mPullDistance + deltaDistance;
        this.mPullDistance = f10;
        if (edgeEffectBehavior == 1) {
            this.mPullDistance = Math.min(1.0f, f10);
        }
        this.mDistance = Math.max(0.0f, this.mPullDistance);
        this.mVelocity = 0.0f;
        if (this.mPullDistance == 0.0f) {
            this.mGlowScaleYStart = 0.0f;
            this.mGlowScaleY = 0.0f;
            this.mGlowAlphaStart = 0.0f;
            this.mGlowAlpha = 0.0f;
        } else {
            float absdd = Math.abs(deltaDistance);
            float min = Math.min(MAX_ALPHA, this.mGlowAlpha + (0.8f * absdd));
            this.mGlowAlphaStart = min;
            this.mGlowAlpha = min;
            float scale = (float) (Math.max(ShadowDrawableWrapper.COS_45, (1.0d - (1.0d / Math.sqrt(Math.abs(this.mPullDistance) * this.mBounds.height()))) - 0.3d) / 0.7d);
            this.mGlowScaleYStart = scale;
            this.mGlowScaleY = scale;
        }
        float absdd2 = this.mGlowAlpha;
        this.mGlowAlphaFinish = absdd2;
        this.mGlowScaleYFinish = this.mGlowScaleY;
        if (edgeEffectBehavior == 1 && this.mDistance == 0.0f) {
            this.mState = 0;
        }
    }

    public float onPullDistance(float deltaDistance, float displacement) {
        int edgeEffectBehavior = getCurrentEdgeEffectBehavior();
        if (edgeEffectBehavior == -1) {
            return 0.0f;
        }
        float finalDistance = Math.max(0.0f, this.mDistance + deltaDistance);
        float f10 = this.mDistance;
        float delta = finalDistance - f10;
        if (delta == 0.0f && f10 == 0.0f) {
            return 0.0f;
        }
        int i10 = this.mState;
        if (i10 != 1 && i10 != 4 && edgeEffectBehavior == 0) {
            this.mPullDistance = f10;
            this.mState = 1;
        }
        onPull(delta, displacement);
        return delta;
    }

    public float getDistance() {
        return this.mDistance;
    }

    public void onRelease() {
        this.mPullDistance = 0.0f;
        int i10 = this.mState;
        if (i10 != 1 && i10 != 4) {
            return;
        }
        this.mState = 3;
        this.mGlowAlphaStart = this.mGlowAlpha;
        this.mGlowScaleYStart = this.mGlowScaleY;
        this.mGlowAlphaFinish = 0.0f;
        this.mGlowScaleYFinish = 0.0f;
        this.mVelocity = 0.0f;
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mDuration = 600.0f;
    }

    public void onAbsorb(int velocity) {
        int edgeEffectBehavior = getCurrentEdgeEffectBehavior();
        if (edgeEffectBehavior == 1) {
            this.mState = 3;
            this.mVelocity = velocity * ON_ABSORB_VELOCITY_ADJUSTMENT;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        } else {
            if (edgeEffectBehavior == 0) {
                this.mState = 2;
                this.mVelocity = 0.0f;
                int velocity2 = Math.min(Math.max(100, Math.abs(velocity)), 10000);
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                this.mDuration = (velocity2 * 0.02f) + MAX_ALPHA;
                this.mGlowAlphaStart = GLOW_ALPHA_START;
                this.mGlowScaleYStart = Math.max(this.mGlowScaleY, 0.0f);
                this.mGlowScaleYFinish = Math.min(((((velocity2 / 100) * velocity2) * 1.5E-4f) / 2.0f) + 0.025f, 1.0f);
                this.mGlowAlphaFinish = Math.max(this.mGlowAlphaStart, Math.min(velocity2 * 6 * 1.0E-5f, MAX_ALPHA));
                this.mTargetDisplacement = 0.5f;
                return;
            }
            finish();
        }
    }

    public void setColor(int color) {
        this.mPaint.setColor(color);
    }

    public void setBlendMode(BlendMode blendmode) {
        this.mPaint.setBlendMode(blendmode);
    }

    public int getColor() {
        return this.mPaint.getColor();
    }

    public BlendMode getBlendMode() {
        return this.mPaint.getBlendMode();
    }

    public boolean draw(Canvas canvas) {
        float f10;
        boolean z10;
        int edgeEffectBehavior = getCurrentEdgeEffectBehavior();
        if (edgeEffectBehavior == 0) {
            update();
            int count = canvas.save();
            float centerX = this.mBounds.centerX();
            float centerY = this.mBounds.height() - this.mRadius;
            canvas.scale(1.0f, Math.min(this.mGlowScaleY, 1.0f) * this.mBaseGlowScale, centerX, 0.0f);
            float displacement = Math.max(0.0f, Math.min(this.mDisplacement, 1.0f)) - 0.5f;
            float translateX = (this.mBounds.width() * displacement) / 2.0f;
            canvas.clipRect(this.mBounds);
            canvas.translate(translateX, 0.0f);
            this.mPaint.setAlpha((int) (this.mGlowAlpha * 255.0f));
            canvas.drawCircle(centerX, centerY, this.mRadius, this.mPaint);
            canvas.restoreToCount(count);
            f10 = 0.0f;
        } else if (edgeEffectBehavior != 1 || !(canvas instanceof RecordingCanvas)) {
            this.mState = 0;
            f10 = 0.0f;
            this.mDistance = 0.0f;
            this.mVelocity = 0.0f;
        } else {
            if (this.mState == 3) {
                updateSpring();
            }
            if (this.mDistance == 0.0f) {
                f10 = 0.0f;
            } else {
                RecordingCanvas recordingCanvas = (RecordingCanvas) canvas;
                if (this.mTmpMatrix == null) {
                    this.mTmpMatrix = new Matrix();
                    this.mTmpPoints = new float[12];
                }
                recordingCanvas.getMatrix(this.mTmpMatrix);
                float[] fArr = this.mTmpPoints;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                float f11 = this.mWidth;
                fArr[2] = f11;
                fArr[3] = 0.0f;
                fArr[4] = f11;
                float f12 = this.mHeight;
                fArr[5] = f12;
                fArr[6] = 0.0f;
                fArr[7] = f12;
                float f13 = this.mDisplacement;
                fArr[8] = f11 * f13;
                fArr[9] = 0.0f;
                fArr[10] = f11 * f13;
                fArr[11] = f12 * this.mDistance;
                this.mTmpMatrix.mapPoints(fArr);
                RenderNode renderNode = recordingCanvas.mNode;
                float left = renderNode.getLeft();
                float[] fArr2 = this.mTmpPoints;
                float left2 = left + min(fArr2[0], fArr2[2], fArr2[4], fArr2[6]);
                float top = renderNode.getTop();
                float[] fArr3 = this.mTmpPoints;
                float top2 = top + min(fArr3[1], fArr3[3], fArr3[5], fArr3[7]);
                float left3 = renderNode.getLeft();
                float[] fArr4 = this.mTmpPoints;
                float right = left3 + max(fArr4[0], fArr4[2], fArr4[4], fArr4[6]);
                float top3 = renderNode.getTop();
                float[] fArr5 = this.mTmpPoints;
                float bottom = top3 + max(fArr5[1], fArr5[3], fArr5[5], fArr5[7]);
                float[] fArr6 = this.mTmpPoints;
                float x10 = fArr6[10] - fArr6[8];
                float width = right - left2;
                float vecX = dampStretchVector(Math.max(-1.0f, Math.min(1.0f, x10 / width)));
                float[] fArr7 = this.mTmpPoints;
                float y10 = fArr7[11] - fArr7[9];
                float height = bottom - top2;
                float vecY = dampStretchVector(Math.max(-1.0f, Math.min(1.0f, y10 / height)));
                boolean hasValidVectors = Float.isFinite(vecX) && Float.isFinite(vecY);
                if (right > left2 && bottom > top2) {
                    float f14 = this.mWidth;
                    if (f14 > 0.0f) {
                        float f15 = this.mHeight;
                        if (f15 > 0.0f && hasValidVectors) {
                            renderNode.stretch(vecX, vecY, f14, f15);
                        }
                    }
                }
                f10 = 0.0f;
            }
        }
        boolean oneLastFrame = false;
        if (this.mState != 3 || this.mDistance != f10 || this.mVelocity != f10) {
            z10 = false;
        } else {
            z10 = false;
            this.mState = 0;
            oneLastFrame = true;
        }
        if (this.mState != 0 || oneLastFrame) {
            return true;
        }
        return z10;
    }

    private float min(float f12, float f22, float f32, float f42) {
        float min = Math.min(f12, f22);
        return Math.min(Math.min(min, f32), f42);
    }

    private float max(float f12, float f22, float f32, float f42) {
        float max = Math.max(f12, f22);
        return Math.max(Math.max(max, f32), f42);
    }

    public int getMaxHeight() {
        return (int) this.mHeight;
    }

    private void update() {
        long time = AnimationUtils.currentAnimationTimeMillis();
        float t2 = Math.min(((float) (time - this.mStartTime)) / this.mDuration, 1.0f);
        float interp = this.mInterpolator.getInterpolation(t2);
        float f10 = this.mGlowAlphaStart;
        float f11 = f10 + ((this.mGlowAlphaFinish - f10) * interp);
        this.mGlowAlpha = f11;
        float f12 = this.mGlowScaleYStart;
        float f13 = f12 + ((this.mGlowScaleYFinish - f12) * interp);
        this.mGlowScaleY = f13;
        if (this.mState != 1) {
            this.mDistance = calculateDistanceFromGlowValues(f13, f11);
        }
        this.mDisplacement = (this.mDisplacement + this.mTargetDisplacement) / 2.0f;
        if (t2 >= 0.999f) {
            switch (this.mState) {
                case 1:
                    this.mState = 4;
                    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                    this.mDuration = 2000.0f;
                    this.mGlowAlphaStart = this.mGlowAlpha;
                    this.mGlowScaleYStart = this.mGlowScaleY;
                    this.mGlowAlphaFinish = 0.0f;
                    this.mGlowScaleYFinish = 0.0f;
                    return;
                case 2:
                    this.mState = 3;
                    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                    this.mDuration = 600.0f;
                    this.mGlowAlphaStart = this.mGlowAlpha;
                    this.mGlowScaleYStart = this.mGlowScaleY;
                    this.mGlowAlphaFinish = 0.0f;
                    this.mGlowScaleYFinish = 0.0f;
                    return;
                case 3:
                    this.mState = 0;
                    return;
                case 4:
                    this.mState = 3;
                    return;
                default:
                    return;
            }
        }
    }

    private void updateSpring() {
        float f10;
        long time = AnimationUtils.currentAnimationTimeMillis();
        float deltaT = ((float) (time - this.mStartTime)) / 1000.0f;
        if (deltaT < 0.001f) {
            return;
        }
        this.mStartTime = time;
        if (Math.abs(this.mVelocity) <= 200.0f && Math.abs(this.mDistance * this.mHeight) < LINEAR_DISTANCE_TAKE_OVER && Math.signum(this.mVelocity) == (-Math.signum(this.mDistance))) {
            float signum = Math.signum(this.mVelocity) * 200.0f;
            this.mVelocity = signum;
            float targetDistance = this.mDistance + ((signum * deltaT) / this.mHeight);
            if (Math.signum(targetDistance) != Math.signum(this.mDistance)) {
                this.mDistance = 0.0f;
                this.mVelocity = 0.0f;
                return;
            } else {
                this.mDistance = targetDistance;
                return;
            }
        }
        double mDampedFreq = Math.sqrt(0.03960000000000008d) * NATURAL_FREQUENCY;
        float f11 = this.mDistance;
        float f12 = this.mHeight;
        double cosCoeff = f11 * f12;
        double sinCoeff = (1.0d / mDampedFreq) * ((f11 * 24.16386d * f12) + this.mVelocity);
        double distance = Math.pow(2.718281828459045d, deltaT * (-24.16386d)) * ((Math.cos(deltaT * mDampedFreq) * cosCoeff) + (Math.sin(deltaT * mDampedFreq) * sinCoeff));
        double velocity = ((-24.657d) * distance * DAMPING_RATIO) + (Math.pow(2.718281828459045d, deltaT * (-24.16386d)) * (((-mDampedFreq) * cosCoeff * Math.sin(deltaT * mDampedFreq)) + (mDampedFreq * sinCoeff * Math.cos(deltaT * mDampedFreq))));
        float f13 = ((float) distance) / this.mHeight;
        this.mDistance = f13;
        this.mVelocity = (float) velocity;
        if (f13 <= 1.0f) {
            f10 = 0.0f;
        } else {
            this.mDistance = 1.0f;
            f10 = 0.0f;
            this.mVelocity = 0.0f;
        }
        if (isAtEquilibrium()) {
            this.mDistance = f10;
            this.mVelocity = f10;
        }
    }

    private float calculateDistanceFromGlowValues(float scale, float alpha) {
        if (scale >= 1.0f) {
            return 1.0f;
        }
        if (scale > 0.0f) {
            float v2 = 1.4285715f / (this.mGlowScaleY - 1.0f);
            return (v2 * v2) / this.mBounds.height();
        }
        return alpha / 0.8f;
    }

    private boolean isAtEquilibrium() {
        double displacement = this.mDistance * this.mHeight;
        double velocity = this.mVelocity;
        return displacement < ShadowDrawableWrapper.COS_45 || (Math.abs(velocity) < VELOCITY_THRESHOLD && displacement < 0.001d);
    }

    private float dampStretchVector(float normalizedVec) {
        float sign = normalizedVec > 0.0f ? 1.0f : -1.0f;
        float overscroll = Math.abs(normalizedVec);
        float linearIntensity = 0.016f * overscroll;
        double expIntensity = (1.0d - Math.exp((-overscroll) * 8.237217334679498d)) * 0.01600000075995922d;
        return ((float) (linearIntensity + expIntensity)) * sign;
    }
}
