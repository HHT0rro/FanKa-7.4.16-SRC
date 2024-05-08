package com.android.internal.dynamicanimation.animation;

import com.android.internal.dynamicanimation.animation.DynamicAnimation;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class SpringForce implements Force {
    public static final float DAMPING_RATIO_HIGH_BOUNCY = 0.2f;
    public static final float DAMPING_RATIO_LOW_BOUNCY = 0.75f;
    public static final float DAMPING_RATIO_MEDIUM_BOUNCY = 0.5f;
    public static final float DAMPING_RATIO_NO_BOUNCY = 1.0f;
    public static final float STIFFNESS_HIGH = 10000.0f;
    public static final float STIFFNESS_LOW = 200.0f;
    public static final float STIFFNESS_MEDIUM = 1500.0f;
    public static final float STIFFNESS_VERY_LOW = 50.0f;
    private static final double UNSET = Double.MAX_VALUE;
    private static final double VELOCITY_THRESHOLD_MULTIPLIER = 62.5d;
    private double mDampedFreq;
    double mDampingRatio;
    private double mFinalPosition;
    private double mGammaMinus;
    private double mGammaPlus;
    private boolean mInitialized;
    private final DynamicAnimation.MassState mMassState;
    double mNaturalFreq;
    private double mValueThreshold;
    private double mVelocityThreshold;

    public SpringForce() {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new DynamicAnimation.MassState();
    }

    public SpringForce(float finalPosition) {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new DynamicAnimation.MassState();
        this.mFinalPosition = finalPosition;
    }

    public SpringForce setStiffness(float stiffness) {
        if (stiffness <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.mNaturalFreq = Math.sqrt(stiffness);
        this.mInitialized = false;
        return this;
    }

    public float getStiffness() {
        double d10 = this.mNaturalFreq;
        return (float) (d10 * d10);
    }

    public SpringForce setDampingRatio(float dampingRatio) {
        if (dampingRatio < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.mDampingRatio = dampingRatio;
        this.mInitialized = false;
        return this;
    }

    public float getDampingRatio() {
        return (float) this.mDampingRatio;
    }

    public SpringForce setFinalPosition(float finalPosition) {
        this.mFinalPosition = finalPosition;
        return this;
    }

    public float getFinalPosition() {
        return (float) this.mFinalPosition;
    }

    @Override // com.android.internal.dynamicanimation.animation.Force
    public float getAcceleration(float lastDisplacement, float lastVelocity) {
        float lastDisplacement2 = lastDisplacement - getFinalPosition();
        double d10 = this.mNaturalFreq;
        double k10 = d10 * d10;
        double c4 = d10 * 2.0d * this.mDampingRatio;
        return (float) (((-k10) * lastDisplacement2) - (lastVelocity * c4));
    }

    @Override // com.android.internal.dynamicanimation.animation.Force
    public boolean isAtEquilibrium(float value, float velocity) {
        if (Math.abs(velocity) < this.mVelocityThreshold && Math.abs(value - getFinalPosition()) < this.mValueThreshold) {
            return true;
        }
        return false;
    }

    private void init() {
        if (this.mInitialized) {
            return;
        }
        if (this.mFinalPosition == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d10 = this.mDampingRatio;
        if (d10 > 1.0d) {
            double d11 = this.mNaturalFreq;
            this.mGammaPlus = ((-d10) * d11) + (d11 * Math.sqrt((d10 * d10) - 1.0d));
            double d12 = this.mDampingRatio;
            double d13 = this.mNaturalFreq;
            this.mGammaMinus = ((-d12) * d13) - (d13 * Math.sqrt((d12 * d12) - 1.0d));
        } else if (d10 >= ShadowDrawableWrapper.COS_45 && d10 < 1.0d) {
            this.mDampedFreq = this.mNaturalFreq * Math.sqrt(1.0d - (d10 * d10));
        }
        this.mInitialized = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DynamicAnimation.MassState updateValues(double lastDisplacement, double lastVelocity, long timeElapsed) {
        double displacement;
        double cosCoeff;
        init();
        double deltaT = timeElapsed / 1000.0d;
        double lastDisplacement2 = lastDisplacement - this.mFinalPosition;
        double displacement2 = this.mDampingRatio;
        if (displacement2 > 1.0d) {
            double d10 = this.mGammaMinus;
            double d11 = this.mGammaPlus;
            double coeffA = lastDisplacement2 - (((d10 * lastDisplacement2) - lastVelocity) / (d10 - d11));
            double coeffB = ((d10 * lastDisplacement2) - lastVelocity) / (d10 - d11);
            displacement = (Math.pow(2.718281828459045d, d10 * deltaT) * coeffA) + (Math.pow(2.718281828459045d, this.mGammaPlus * deltaT) * coeffB);
            double d12 = this.mGammaMinus;
            double pow = coeffA * d12 * Math.pow(2.718281828459045d, d12 * deltaT);
            double d13 = this.mGammaPlus;
            double currentVelocity = pow + (coeffB * d13 * Math.pow(2.718281828459045d, d13 * deltaT));
            cosCoeff = currentVelocity;
        } else if (displacement2 == 1.0d) {
            double d14 = this.mNaturalFreq;
            double coeffB2 = lastVelocity + (d14 * lastDisplacement2);
            double displacement3 = Math.pow(2.718281828459045d, (-d14) * deltaT) * (lastDisplacement2 + (coeffB2 * deltaT));
            double pow2 = (lastDisplacement2 + (coeffB2 * deltaT)) * Math.pow(2.718281828459045d, (-this.mNaturalFreq) * deltaT);
            double d15 = this.mNaturalFreq;
            double currentVelocity2 = (pow2 * (-d15)) + (Math.pow(2.718281828459045d, (-d15) * deltaT) * coeffB2);
            displacement = displacement3;
            cosCoeff = currentVelocity2;
        } else {
            double d16 = 1.0d / this.mDampedFreq;
            double d17 = this.mNaturalFreq;
            double sinCoeff = d16 * ((displacement2 * d17 * lastDisplacement2) + lastVelocity);
            double displacement4 = Math.pow(2.718281828459045d, (-displacement2) * d17 * deltaT) * ((Math.cos(this.mDampedFreq * deltaT) * lastDisplacement2) + (Math.sin(this.mDampedFreq * deltaT) * sinCoeff));
            double d18 = this.mNaturalFreq;
            double lastDisplacement3 = this.mDampingRatio;
            double d19 = (-d18) * displacement4 * lastDisplacement3;
            double pow3 = Math.pow(2.718281828459045d, (-lastDisplacement3) * d18 * deltaT);
            double d20 = this.mDampedFreq;
            double sin = (-d20) * lastDisplacement2 * Math.sin(d20 * deltaT);
            double d21 = this.mDampedFreq;
            double cos = d19 + (pow3 * (sin + (d21 * sinCoeff * Math.cos(d21 * deltaT))));
            displacement = displacement4;
            cosCoeff = cos;
        }
        this.mMassState.mValue = (float) (this.mFinalPosition + displacement);
        this.mMassState.mVelocity = (float) cosCoeff;
        return this.mMassState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValueThreshold(double threshold) {
        double abs = Math.abs(threshold);
        this.mValueThreshold = abs;
        this.mVelocityThreshold = abs * VELOCITY_THRESHOLD_MULTIPLIER;
    }
}
