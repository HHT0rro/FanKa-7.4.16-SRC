package com.huawei.dynamicanimation;

import android.os.SystemClock;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.tencent.connect.common.Constants;
import java.math.BigDecimal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class SpringModelBase extends PhysicalModelBase {
    public static final float CURRENT_TIME = -1.0f;
    public static final float DEFAULT_DAMPING = 15.0f;
    public static final float DEFAULT_ESTIMATE_DURATION = 500.0f;
    public static final float DEFAULT_MASS = 1.0f;
    public static final float DEFAULT_STIFFNESS = 800.0f;
    public static final float DEFAULT_VALUE_THRESHOLD = new BigDecimal("1").divide(new BigDecimal(Constants.DEFAULT_UIN)).floatValue();
    public static final int DIST_NUM = 16;
    public static final float EPSILON = 1.0E-6f;
    public static final int INVALID = -1;
    public static final float MAXIMUM_DAMPING = 99.0f;
    public static final float MAXIMUM_MASS = 1.0f;
    public static final float MAXIMUM_STIFFNESS = 999.0f;
    public static final float MAX_ITERATION_NUM = 999.0f;
    public static final float MINIMUM_DAMPING = 1.0f;
    public static final float MINIMUM_MASS = 1.0f;
    public static final float MINIMUM_STIFFNESS = 1.0f;
    public static final int MULTIPLE_FOUR = 4;
    public static final int MULTIPLE_TWO = 2;
    public static final double ONE_SECOND_D = 1000.0d;
    public static final float ONE_SECOND_F = 1000.0f;
    public float mDamping;
    public float mMass;
    public Solution mSolution;
    public float mStiffness;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public abstract class Solution {
        public float[] mPositionDist = new float[17];
        public float mPosition = 0.0f;
        public float mVelocity = 0.0f;
        public float mAcceleration = 0.0f;
        public float mDuration = 0.0f;

        public Solution() {
        }

        private float getIterate(float f10, float f11) {
            if (f10 <= 999.0f) {
                return f11;
            }
            return -1.0f;
        }

        private float getStartTimeForX(float f10, float f11, float f12) {
            float f13;
            float f14 = (f12 - f11) / 16.0f;
            boolean z10 = getVelocity(new BigDecimal((double) (f12 + f11)).divide(new BigDecimal("2")).floatValue()) > 0.0f;
            for (int i10 = 1; i10 < 17; i10++) {
                float[] fArr = this.mPositionDist;
                int i11 = i10 - 1;
                float f15 = fArr[i10] - fArr[i11];
                if (!z10 || fArr[i10] < f10) {
                    if (!z10 && fArr[i10] <= f10) {
                        if (f15 != 0.0f) {
                            return ((i10 - ((fArr[i10] - f10) / f15)) * f14) + f11;
                        }
                    }
                } else if (f15 != 0.0f) {
                    f13 = ((f10 - fArr[i11]) / f15) + i11;
                    return (f13 * f14) + f11;
                }
                f13 = i11;
                return (f13 * f14) + f11;
            }
            return f12;
        }

        public abstract void doEstimateDuration();

        public float doIterate(float f10, float f11) {
            float f12 = (f11 - f10) / 16.0f;
            float f13 = SpringModelBase.this.mValueThreshold;
            for (int i10 = 0; i10 < 17; i10++) {
                this.mPositionDist[i10] = getPosition((i10 * f12) + f10);
            }
            boolean z10 = true;
            int i11 = 1;
            while (true) {
                if (i11 >= 17) {
                    z10 = false;
                    break;
                }
                float[] fArr = this.mPositionDist;
                int i12 = i11 - 1;
                float f14 = fArr[i12];
                float f15 = SpringModelBase.this.mValueThreshold;
                if ((fArr[i11] - f15) * (f14 - f15) < 0.0f) {
                    f13 = f15;
                    break;
                }
                if ((fArr[i11] + f15) * (fArr[i12] + f15) < 0.0f) {
                    f13 = -f15;
                    break;
                }
                i11++;
            }
            if (!z10) {
                return f10;
            }
            float startTimeForX = getStartTimeForX(f13, f10, f11);
            while (true) {
                float f16 = startTimeForX;
                float f17 = f11;
                f11 = f16;
                if (Math.abs(getPosition(f11)) >= SpringModelBase.this.mValueThreshold || f17 - f11 < 0.0625f) {
                    break;
                }
                float f18 = (f11 - f10) / 16.0f;
                for (int i13 = 0; i13 < 17; i13++) {
                    this.mPositionDist[i13] = getPosition((i13 * f18) + f10);
                }
                startTimeForX = getStartTimeForX(f13, f10, f11);
            }
            float position = getPosition(f11);
            float velocity = getVelocity(f11);
            float f19 = 0.0f;
            while (SpringModelBase.this.almostGreaterThan(Math.abs(position), SpringModelBase.this.mValueThreshold, 0.0f)) {
                float f20 = 1.0f + f19;
                if (f19 >= 999.0f || velocity == 0.0f) {
                    f19 = f20;
                    break;
                }
                f11 -= position / velocity;
                position = getPosition(f11);
                velocity = getVelocity(f11);
                f19 = f20;
            }
            return getIterate(f19, f11);
        }

        public abstract float estimateDuration();

        public void estimateDuration(float f10, float f11) {
            int i10 = 0;
            if (f11 >= 0.0f && !Float.isInfinite(f11) && !Float.isNaN(f11)) {
                float position = getPosition(f11);
                int i11 = 0;
                while (SpringModelBase.this.almostLessThan(Math.abs(position), SpringModelBase.this.mValueThreshold, 0.0f)) {
                    i11++;
                    if (i11 > 999.0f) {
                        break;
                    }
                    f11 = (f11 + f10) / 2.0f;
                    position = getPosition(f11);
                }
                if (i11 > 999.0f) {
                    this.mDuration = f11;
                    return;
                }
                f10 = f11;
            }
            float position2 = getPosition(f10);
            float velocity = getVelocity(f10);
            while (SpringModelBase.this.almostGreaterThan(Math.abs(position2), SpringModelBase.this.mValueThreshold, 0.0f)) {
                i10++;
                if (i10 > 999.0f) {
                    break;
                }
                f10 -= position2 / velocity;
                if (f10 >= 0.0f && !Float.isNaN(f10) && !Float.isInfinite(f10)) {
                    position2 = getPosition(f10);
                    velocity = getVelocity(f10);
                } else {
                    this.mDuration = 0.0f;
                    return;
                }
            }
            if (i10 > 999.0f) {
                this.mDuration = -1.0f;
            } else {
                this.mDuration = f10;
            }
        }

        public abstract float getAcceleration(float f10);

        public abstract float getFirstExtremumX();

        public abstract float getMaxAbsX();

        public abstract float getPosition(float f10);

        public abstract float getVelocity(float f10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class Solution0 extends Solution {
        public Solution0() {
            super();
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public void doEstimateDuration() {
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float estimateDuration() {
            return 0.0f;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getAcceleration(float f10) {
            return this.mAcceleration;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getFirstExtremumX() {
            return 0.0f;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getMaxAbsX() {
            return 0.0f;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getPosition(float f10) {
            return this.mPosition;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getVelocity(float f10) {
            return this.mVelocity;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class Solution1 extends Solution {
        public float mC1;
        public float mC2;
        public float mR;

        public Solution1(float f10, float f11, float f12) {
            super();
            this.mC1 = f10;
            this.mC2 = f11;
            this.mR = f12;
            doEstimateDuration();
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public final void doEstimateDuration() {
            float f10 = this.mC2;
            if (f10 != 0.0f) {
                float f11 = this.mR;
                if (f11 == 0.0f) {
                    return;
                }
                estimateDuration(0.0f, (-(((2.0f * f10) / f11) + this.mC1)) / f10);
            }
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float estimateDuration() {
            return this.mDuration;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getAcceleration(float f10) {
            float pow = (float) Math.pow(2.718281828459045d, this.mR * f10);
            float f11 = this.mR;
            float f12 = this.mC1;
            float f13 = this.mC2;
            float f14 = (f13 * 2.0f * f11 * pow) + (((f10 * f13) + f12) * f11 * f11 * pow);
            this.mAcceleration = f14;
            return f14;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getFirstExtremumX() {
            float f10 = this.mC2;
            float f11 = 0.0f;
            if (f10 != 0.0f) {
                float f12 = this.mR;
                if (f12 != 0.0f) {
                    float f13 = (-((f10 / f12) + this.mC1)) / f10;
                    if (f13 >= 0.0f && !Float.isInfinite(f13)) {
                        f11 = f13;
                    }
                    return getPosition(f11);
                }
            }
            return 0.0f;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getMaxAbsX() {
            return Math.abs(getFirstExtremumX());
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getPosition(float f10) {
            float pow = (float) (Math.pow(2.718281828459045d, this.mR * f10) * ((this.mC2 * f10) + this.mC1));
            this.mPosition = pow;
            return pow;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getVelocity(float f10) {
            float pow = (float) Math.pow(2.718281828459045d, this.mR * f10);
            float f11 = this.mR;
            float f12 = this.mC1;
            float f13 = this.mC2;
            float f14 = (f13 * pow) + (((f10 * f13) + f12) * f11 * pow);
            this.mVelocity = f14;
            return f14;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class Solution2 extends Solution {
        public float mC1;
        public float mC2;
        public float mR1;
        public float mR2;

        public Solution2(float f10, float f11, float f12, float f13) {
            super();
            this.mC1 = f10;
            this.mC2 = f11;
            this.mR1 = f12;
            this.mR2 = f13;
            doEstimateDuration();
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public final void doEstimateDuration() {
            if (Math.abs(this.mR1 - this.mR2) < 1.0E-6f) {
                return;
            }
            float f10 = this.mC1;
            float f11 = this.mR1;
            float log = (float) Math.log(Math.abs(f10 * f11 * f11));
            float f12 = -this.mC2;
            float f13 = this.mR2;
            estimateDuration(0.0f, (log - ((float) Math.log(Math.abs((f12 * f13) * f13)))) / (this.mR2 - this.mR1));
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float estimateDuration() {
            return this.mDuration;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getAcceleration(float f10) {
            float f11 = this.mC1;
            float f12 = this.mR1;
            float pow = f11 * f12 * f12 * ((float) Math.pow(2.718281828459045d, f12 * f10));
            float f13 = this.mC2;
            float f14 = this.mR2;
            float pow2 = (f13 * f14 * f14 * ((float) Math.pow(2.718281828459045d, f14 * f10))) + pow;
            this.mAcceleration = pow2;
            return pow2;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getFirstExtremumX() {
            float f10 = 0.0f;
            if (Math.abs(this.mR1 - this.mR2) < 1.0E-6f) {
                return 0.0f;
            }
            float log = (((float) Math.log(Math.abs(this.mC1 * this.mR1))) - ((float) Math.log(Math.abs((-this.mC2) * this.mR2)))) / (this.mR2 - this.mR1);
            if (log >= 0.0f && !Float.isInfinite(log)) {
                f10 = log;
            }
            return getPosition(f10);
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getMaxAbsX() {
            return Math.abs(getFirstExtremumX());
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getPosition(float f10) {
            float pow = (this.mC2 * ((float) Math.pow(2.718281828459045d, this.mR2 * f10))) + (this.mC1 * ((float) Math.pow(2.718281828459045d, this.mR1 * f10)));
            this.mPosition = pow;
            return pow;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getVelocity(float f10) {
            float pow = (this.mC2 * this.mR2 * ((float) Math.pow(2.718281828459045d, r2 * f10))) + (this.mC1 * this.mR1 * ((float) Math.pow(2.718281828459045d, r1 * f10)));
            this.mVelocity = pow;
            return pow;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class Solution3 extends Solution {
        public float mC1;
        public float mC2;
        public float mR;
        public float mW;

        public Solution3(float f10, float f11, float f12, float f13) {
            super();
            this.mC1 = f10;
            this.mC2 = f11;
            this.mW = f12;
            this.mR = f13;
            doEstimateDuration();
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public final void doEstimateDuration() {
            float sqrt = (float) Math.sqrt((SpringModelBase.this.mDamping * SpringModelBase.this.mDamping) / (SpringModelBase.this.mStiffness * (SpringModelBase.this.mMass * 4.0f)));
            float sqrt2 = ((float) Math.sqrt(1.0f - (sqrt * sqrt))) * ((float) Math.sqrt(SpringModelBase.this.mStiffness / SpringModelBase.this.mMass));
            float f10 = (6.2831855f / sqrt2) / 2.0f;
            float atan = (float) Math.atan(this.mC2 / this.mC1);
            if (Float.isNaN(atan)) {
                this.mDuration = 0.0f;
                return;
            }
            float acos = ((((float) Math.acos(ShadowDrawableWrapper.COS_45)) + atan) % 3.1415927f) / this.mW;
            float velocity = getVelocity(acos);
            float acos2 = (((((float) Math.acos(ShadowDrawableWrapper.COS_45)) + ((float) Math.atan(sqrt2 / (sqrt * r1)))) + atan) % 3.1415927f) / sqrt2;
            int i10 = 0;
            float f11 = 0.0f;
            while (true) {
                if (!SpringModelBase.this.almostGreaterThan(Math.abs(velocity), SpringModelBase.this.mVelocityThreshold, 0.0f)) {
                    break;
                }
                int i11 = i10 + 1;
                if (i10 >= 999.0f) {
                    i10 = i11;
                    break;
                }
                acos += f10;
                velocity = getVelocity(acos);
                f11 += f10;
                acos2 += f10;
                i10 = i11;
            }
            float f12 = -1.0f;
            if (i10 >= 999.0f) {
                this.mDuration = -1.0f;
                return;
            }
            if ((f11 <= acos2 && acos2 < acos) || f11 == acos) {
                f12 = doIterate(acos2, f10 + acos2);
            } else if (f11 < acos && acos < acos2) {
                f12 = doIterate(Math.max(0.0f, acos2 - f10), acos2);
            }
            this.mDuration = f12;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float estimateDuration() {
            return this.mDuration;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getAcceleration(float f10) {
            float pow = (float) Math.pow(2.718281828459045d, this.mR * f10);
            float cos = (float) Math.cos(this.mW * f10);
            float sin = (float) Math.sin(this.mW * f10);
            float f11 = this.mR;
            float f12 = this.mC2;
            float f13 = this.mW;
            float f14 = this.mC1;
            float f15 = f14 * f13;
            float f16 = (((f12 * f13) * cos) - (f15 * sin)) * f11 * pow;
            float f17 = f16 + (((f14 * cos) + (f12 * sin)) * f11 * f11 * pow) + ((((((-f12) * f13) * f13) * sin) - ((f15 * f13) * cos)) * pow) + f16;
            this.mAcceleration = f17;
            return f17;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getFirstExtremumX() {
            if (SpringModelBase.this.mDamping == 0.0f || SpringModelBase.this.mMass == 0.0f || SpringModelBase.this.mStiffness == 0.0f || this.mC1 == 0.0f) {
                return 0.0f;
            }
            float sqrt = (float) Math.sqrt((SpringModelBase.this.mDamping * SpringModelBase.this.mDamping) / (SpringModelBase.this.mStiffness * (SpringModelBase.this.mMass * 4.0f)));
            float sqrt2 = (float) (Math.sqrt(1.0f - (sqrt * sqrt)) * ((float) Math.sqrt(SpringModelBase.this.mStiffness / SpringModelBase.this.mMass)));
            float atan = (float) Math.atan(this.mC2 / this.mC1);
            float atan2 = (float) Math.atan(sqrt2 / (sqrt * r2));
            if (sqrt2 == 0.0f) {
                return 0.0f;
            }
            return getPosition((float) ((((Math.acos(ShadowDrawableWrapper.COS_45) + atan2) + atan) % 3.141592653589793d) / sqrt2));
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getMaxAbsX() {
            float sqrt = (float) Math.sqrt((SpringModelBase.this.mDamping * SpringModelBase.this.mDamping) / (SpringModelBase.this.mStiffness * (SpringModelBase.this.mMass * 4.0f)));
            float sqrt2 = (float) (Math.sqrt(1.0f - (sqrt * sqrt)) * ((float) Math.sqrt(SpringModelBase.this.mStiffness / SpringModelBase.this.mMass)));
            float acos = (float) (((Math.acos(ShadowDrawableWrapper.COS_45) + ((float) Math.atan(sqrt2 / (sqrt * r1)))) + ((float) Math.atan(this.mC2 / this.mC1))) % 3.141592653589793d);
            float abs = Math.abs(getPosition(acos / sqrt2));
            int i10 = 0;
            do {
                float f10 = (float) (((i10 * 3.141592653589793d) / sqrt2) + acos);
                float abs2 = Math.abs(getPosition(f10));
                if (abs < abs2) {
                    abs = abs2;
                }
                if (f10 >= estimateDuration()) {
                    break;
                }
                i10++;
            } while (i10 < 999.0f);
            if (i10 >= 999.0f) {
                return -1.0f;
            }
            return abs;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getPosition(float f10) {
            float sin = ((this.mC2 * ((float) Math.sin(this.mW * f10))) + (this.mC1 * ((float) Math.cos(this.mW * f10)))) * ((float) Math.pow(2.718281828459045d, this.mR * f10));
            this.mPosition = sin;
            return sin;
        }

        @Override // com.huawei.dynamicanimation.SpringModelBase.Solution
        public float getVelocity(float f10) {
            float pow = (float) Math.pow(2.718281828459045d, this.mR * f10);
            float cos = (float) Math.cos(this.mW * f10);
            float sin = (float) Math.sin(this.mW * f10);
            float f11 = this.mC2;
            float f12 = this.mW;
            float f13 = this.mC1;
            float f14 = (((f13 * cos) + (f11 * sin)) * this.mR * pow) + ((((f11 * f12) * cos) - ((f12 * f13) * sin)) * pow);
            this.mVelocity = f14;
            return f14;
        }
    }

    public SpringModelBase(float f10, float f11, float f12) {
        this.mMass = 1.0f;
        this.mStiffness = 800.0f;
        this.mDamping = 15.0f;
        super.setValueThreshold(f12);
        this.mMass = 1.0f;
        this.mStiffness = Math.min(Math.max(1.0f, f10), 999.0f);
        this.mDamping = Math.min(Math.max(1.0f, f11), 99.0f);
        this.mSolution = null;
        this.mStartPosition = 0.0f;
        this.mEndPosition = 0.0f;
        this.mStartVelocity = 0.0f;
        this.mStartTime = 0L;
    }

    private boolean almostEqual(float f10, float f11, float f12) {
        return f10 > f11 - f12 && f10 < f11 + f12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean almostGreaterThan(float f10, float f11, float f12) {
        return f10 > f11 - f12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean almostLessThan(float f10, float f11, float f12) {
        return f10 < f11 - f12;
    }

    private boolean almostZero(float f10, float f11) {
        return almostEqual(f10, 0.0f, f11);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getAcceleration(float f10) {
        if (f10 < 0.0f) {
            f10 = (float) ((SystemClock.elapsedRealtime() - this.mStartTime) / 1000.0d);
        }
        Solution solution = this.mSolution;
        if (solution != null) {
            return solution.getAcceleration(f10);
        }
        return 0.0f;
    }

    public float getDamping() {
        return this.mDamping;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getEstimatedDuration() {
        float estimateDuration = this.mSolution.estimateDuration();
        if (Float.compare(estimateDuration, -1.0f) == 0) {
            return 500.0f;
        }
        return estimateDuration * 1000.0f;
    }

    public float getFirstExtremumX() {
        Solution solution = this.mSolution;
        if (solution != null) {
            return solution.getFirstExtremumX();
        }
        return 0.0f;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getMaxAbsX() {
        Solution solution = this.mSolution;
        if (solution != null) {
            return solution.getMaxAbsX();
        }
        return 0.0f;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getPosition(float f10) {
        if (f10 < 0.0f) {
            f10 = (float) ((SystemClock.elapsedRealtime() - this.mStartTime) / 1000.0d);
        }
        Solution solution = this.mSolution;
        if (solution != null) {
            return this.mEndPosition + solution.getPosition(f10);
        }
        return 0.0f;
    }

    public float getStiffness() {
        return this.mStiffness;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getVelocity(float f10) {
        if (f10 < 0.0f) {
            f10 = (float) ((SystemClock.elapsedRealtime() - this.mStartTime) / 1000.0d);
        }
        Solution solution = this.mSolution;
        if (solution != null) {
            return solution.getVelocity(f10);
        }
        return 0.0f;
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public boolean isAtEquilibrium(float f10) {
        if (f10 < 0.0f) {
            f10 = ((float) SystemClock.elapsedRealtime()) - (getStartTime() / 1000.0f);
        }
        return almostEqual(getPosition(f10), this.mEndPosition, this.mValueThreshold) && almostZero(getVelocity(f10), this.mValueThreshold);
    }

    public SpringModelBase reconfigure(float f10, float f11, float f12, float f13) {
        super.setValueThreshold(f13);
        this.mMass = Math.min(Math.max(1.0f, f10), 1.0f);
        this.mStiffness = Math.min(Math.max(1.0f, f11), 999.0f);
        this.mDamping = Math.min(Math.max(1.0f, f12), 99.0f);
        this.mStartPosition = getPosition(-1.0f);
        float velocity = getVelocity(-1.0f);
        this.mStartVelocity = velocity;
        this.mSolution = solve(this.mStartPosition - this.mEndPosition, velocity);
        this.mStartTime = SystemClock.elapsedRealtime();
        return this;
    }

    public SpringModelBase setDamping(float f10) {
        return reconfigure(this.mMass, this.mStiffness, f10, this.mValueThreshold);
    }

    public SpringModelBase setEndPosition(float f10, float f11, long j10) {
        float min = Math.min(99999.0f, Math.max(-99999.0f, f10));
        float min2 = Math.min(99999.0f, Math.max(-99999.0f, f11));
        if (j10 <= 0) {
            j10 = SystemClock.elapsedRealtime();
        }
        if (min == this.mEndPosition && almostZero(min2, this.mValueThreshold)) {
            return this;
        }
        float f12 = this.mEndPosition;
        if (this.mSolution != null) {
            if (almostZero(min2, this.mValueThreshold)) {
                min2 = this.mSolution.getVelocity(((float) (j10 - this.mStartTime)) / 1000.0f);
            }
            float position = this.mSolution.getPosition(((float) (j10 - this.mStartTime)) / 1000.0f);
            if (almostZero(min2, this.mValueThreshold)) {
                min2 = 0.0f;
            }
            if (almostZero(position, this.mValueThreshold)) {
                position = 0.0f;
            }
            f12 = position + this.mEndPosition;
            if (almostZero(f12 - min, this.mValueThreshold) && almostZero(min2, this.mValueThreshold)) {
                return this;
            }
        }
        this.mEndPosition = min;
        this.mStartPosition = f12;
        this.mStartVelocity = min2;
        this.mSolution = solve(f12 - min, min2);
        this.mStartTime = j10;
        return this;
    }

    public SpringModelBase setEndValue(float f10, float f11) {
        if (f10 == this.mEndPosition && almostZero(f11, this.mValueThreshold)) {
            return this;
        }
        this.mStartTime = SystemClock.elapsedRealtime();
        this.mStartPosition = 0.0f;
        this.mEndPosition = f10;
        this.mStartVelocity = f11;
        this.mSolution = solve(0.0f - f10, f11);
        return this;
    }

    public void setMass(float f10) {
        reconfigure(f10, this.mStiffness, this.mDamping, this.mValueThreshold);
    }

    public SpringModelBase setStiffness(float f10) {
        return reconfigure(this.mMass, f10, this.mDamping, this.mValueThreshold);
    }

    public SpringModelBase snap(float f10) {
        float min = Math.min(0.0f, Math.max(0.0f, f10));
        this.mStartTime = SystemClock.elapsedRealtime();
        this.mStartPosition = 0.0f;
        this.mEndPosition = min;
        this.mStartVelocity = 0.0f;
        this.mSolution = new Solution0();
        return this;
    }

    public Solution solve(float f10, float f11) {
        float f12 = this.mDamping;
        float f13 = this.mMass;
        float f14 = f12 * f12;
        float f15 = 4.0f * f13 * this.mStiffness;
        float f16 = f14 - f15;
        int compare = Float.compare(f14, f15);
        if (compare == 0) {
            float f17 = (-f12) / (f13 * 2.0f);
            return new Solution1(f10, f11 - (f17 * f10), f17);
        }
        if (compare > 0) {
            double d10 = -f12;
            double d11 = f16;
            double d12 = f13 * 2.0f;
            float sqrt = (float) ((d10 - Math.sqrt(d11)) / d12);
            float sqrt2 = (float) ((Math.sqrt(d11) + d10) / d12);
            float f18 = (f11 - (sqrt * f10)) / (sqrt2 - sqrt);
            return new Solution2(f10 - f18, f18, sqrt, sqrt2);
        }
        float f19 = f13 * 2.0f;
        float sqrt3 = (float) (Math.sqrt(f15 - f14) / f19);
        float f20 = (-f12) / f19;
        return new Solution3(f10, (f11 - (f20 * f10)) / sqrt3, sqrt3, f20);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getAcceleration() {
        return getAcceleration(-1.0f);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getPosition() {
        return getPosition(-1.0f);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public float getVelocity() {
        return getVelocity(-1.0f);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public SpringModelBase setValueThreshold(float f10) {
        return reconfigure(this.mMass, this.mStiffness, this.mDamping, f10);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public boolean isAtEquilibrium() {
        return isAtEquilibrium(-1.0f);
    }

    @Override // com.huawei.dynamicanimation.PhysicalModelBase, com.huawei.dynamicanimation.PhysicalModel
    public boolean isAtEquilibrium(float f10, float f11) {
        return Math.abs(f11) < this.mVelocityThreshold && Math.abs(f10 - this.mEndPosition) < this.mValueThreshold;
    }
}
