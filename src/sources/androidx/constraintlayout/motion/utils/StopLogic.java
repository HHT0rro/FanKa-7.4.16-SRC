package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.widget.MotionInterpolator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class StopLogic extends MotionInterpolator {
    private boolean mBackwards = false;
    private float mLastPosition;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private String mType;

    private float calcY(float f10) {
        float f11 = this.mStage1Duration;
        if (f10 <= f11) {
            float f12 = this.mStage1Velocity;
            return (f12 * f10) + ((((this.mStage2Velocity - f12) * f10) * f10) / (f11 * 2.0f));
        }
        int i10 = this.mNumberOfStages;
        if (i10 == 1) {
            return this.mStage1EndPosition;
        }
        float f13 = f10 - f11;
        float f14 = this.mStage2Duration;
        if (f13 < f14) {
            float f15 = this.mStage1EndPosition;
            float f16 = this.mStage2Velocity;
            return f15 + (f16 * f13) + ((((this.mStage3Velocity - f16) * f13) * f13) / (f14 * 2.0f));
        }
        if (i10 == 2) {
            return this.mStage2EndPosition;
        }
        float f17 = f13 - f14;
        float f18 = this.mStage3Duration;
        if (f17 < f18) {
            float f19 = this.mStage2EndPosition;
            float f20 = this.mStage3Velocity;
            return (f19 + (f20 * f17)) - (((f20 * f17) * f17) / (f18 * 2.0f));
        }
        return this.mStage3EndPosition;
    }

    private void setup(float f10, float f11, float f12, float f13, float f14) {
        if (f10 == 0.0f) {
            f10 = 1.0E-4f;
        }
        this.mStage1Velocity = f10;
        float f15 = f10 / f12;
        float f16 = (f15 * f10) / 2.0f;
        if (f10 < 0.0f) {
            float sqrt = (float) Math.sqrt((f11 - ((((-f10) / f12) * f10) / 2.0f)) * f12);
            if (sqrt < f13) {
                this.mType = "backward accelerate, decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f10;
                this.mStage2Velocity = sqrt;
                this.mStage3Velocity = 0.0f;
                float f17 = (sqrt - f10) / f12;
                this.mStage1Duration = f17;
                this.mStage2Duration = sqrt / f12;
                this.mStage1EndPosition = ((f10 + sqrt) * f17) / 2.0f;
                this.mStage2EndPosition = f11;
                this.mStage3EndPosition = f11;
                return;
            }
            this.mType = "backward accelerate cruse decelerate";
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f10;
            this.mStage2Velocity = f13;
            this.mStage3Velocity = f13;
            float f18 = (f13 - f10) / f12;
            this.mStage1Duration = f18;
            float f19 = f13 / f12;
            this.mStage3Duration = f19;
            float f20 = ((f10 + f13) * f18) / 2.0f;
            float f21 = (f19 * f13) / 2.0f;
            this.mStage2Duration = ((f11 - f20) - f21) / f13;
            this.mStage1EndPosition = f20;
            this.mStage2EndPosition = f11 - f21;
            this.mStage3EndPosition = f11;
            return;
        }
        if (f16 >= f11) {
            this.mType = "hard stop";
            this.mNumberOfStages = 1;
            this.mStage1Velocity = f10;
            this.mStage2Velocity = 0.0f;
            this.mStage1EndPosition = f11;
            this.mStage1Duration = (2.0f * f11) / f10;
            return;
        }
        float f22 = f11 - f16;
        float f23 = f22 / f10;
        if (f23 + f15 < f14) {
            this.mType = "cruse decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f10;
            this.mStage2Velocity = f10;
            this.mStage3Velocity = 0.0f;
            this.mStage1EndPosition = f22;
            this.mStage2EndPosition = f11;
            this.mStage1Duration = f23;
            this.mStage2Duration = f15;
            return;
        }
        float sqrt2 = (float) Math.sqrt((f12 * f11) + ((f10 * f10) / 2.0f));
        float f24 = (sqrt2 - f10) / f12;
        this.mStage1Duration = f24;
        float f25 = sqrt2 / f12;
        this.mStage2Duration = f25;
        if (sqrt2 < f13) {
            this.mType = "accelerate decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f10;
            this.mStage2Velocity = sqrt2;
            this.mStage3Velocity = 0.0f;
            this.mStage1Duration = f24;
            this.mStage2Duration = f25;
            this.mStage1EndPosition = ((f10 + sqrt2) * f24) / 2.0f;
            this.mStage2EndPosition = f11;
            return;
        }
        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = f10;
        this.mStage2Velocity = f13;
        this.mStage3Velocity = f13;
        float f26 = (f13 - f10) / f12;
        this.mStage1Duration = f26;
        float f27 = f13 / f12;
        this.mStage3Duration = f27;
        float f28 = ((f10 + f13) * f26) / 2.0f;
        float f29 = (f27 * f13) / 2.0f;
        this.mStage2Duration = ((f11 - f28) - f29) / f13;
        this.mStage1EndPosition = f28;
        this.mStage2EndPosition = f11 - f29;
        this.mStage3EndPosition = f11;
    }

    public void config(float f10, float f11, float f12, float f13, float f14, float f15) {
        this.mStartPosition = f10;
        boolean z10 = f10 > f11;
        this.mBackwards = z10;
        if (z10) {
            setup(-f12, f10 - f11, f14, f15, f13);
        } else {
            setup(f12, f11 - f10, f14, f15, f13);
        }
    }

    public void debug(String str, String str2, float f10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(" ===== ");
        sb2.append(this.mType);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str2);
        sb3.append(this.mBackwards ? "backwards" : "forward ");
        sb3.append(" time = ");
        sb3.append(f10);
        sb3.append("  stages ");
        sb3.append(this.mNumberOfStages);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(str2);
        sb4.append(" dur ");
        sb4.append(this.mStage1Duration);
        sb4.append(" vel ");
        sb4.append(this.mStage1Velocity);
        sb4.append(" pos ");
        sb4.append(this.mStage1EndPosition);
        if (this.mNumberOfStages > 1) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str2);
            sb5.append(" dur ");
            sb5.append(this.mStage2Duration);
            sb5.append(" vel ");
            sb5.append(this.mStage2Velocity);
            sb5.append(" pos ");
            sb5.append(this.mStage2EndPosition);
        }
        if (this.mNumberOfStages > 2) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str2);
            sb6.append(" dur ");
            sb6.append(this.mStage3Duration);
            sb6.append(" vel ");
            sb6.append(this.mStage3Velocity);
            sb6.append(" pos ");
            sb6.append(this.mStage3EndPosition);
        }
        float f11 = this.mStage1Duration;
        if (f10 <= f11) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str2);
            sb7.append("stage 0");
            return;
        }
        int i10 = this.mNumberOfStages;
        if (i10 == 1) {
            StringBuilder sb8 = new StringBuilder();
            sb8.append(str2);
            sb8.append("end stage 0");
            return;
        }
        float f12 = f10 - f11;
        float f13 = this.mStage2Duration;
        if (f12 < f13) {
            StringBuilder sb9 = new StringBuilder();
            sb9.append(str2);
            sb9.append(" stage 1");
        } else if (i10 == 2) {
            StringBuilder sb10 = new StringBuilder();
            sb10.append(str2);
            sb10.append("end stage 1");
        } else if (f12 - f13 < this.mStage3Duration) {
            StringBuilder sb11 = new StringBuilder();
            sb11.append(str2);
            sb11.append(" stage 2");
        } else {
            StringBuilder sb12 = new StringBuilder();
            sb12.append(str2);
            sb12.append(" end stage 2");
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        float calcY = calcY(f10);
        this.mLastPosition = f10;
        return this.mBackwards ? this.mStartPosition - calcY : this.mStartPosition + calcY;
    }

    public float getVelocity(float f10) {
        float f11 = this.mStage1Duration;
        if (f10 <= f11) {
            float f12 = this.mStage1Velocity;
            return f12 + (((this.mStage2Velocity - f12) * f10) / f11);
        }
        int i10 = this.mNumberOfStages;
        if (i10 == 1) {
            return 0.0f;
        }
        float f13 = f10 - f11;
        float f14 = this.mStage2Duration;
        if (f13 < f14) {
            float f15 = this.mStage2Velocity;
            return f15 + (((this.mStage3Velocity - f15) * f13) / f14);
        }
        if (i10 == 2) {
            return this.mStage2EndPosition;
        }
        float f16 = f13 - f14;
        float f17 = this.mStage3Duration;
        if (f16 < f17) {
            float f18 = this.mStage3Velocity;
            return f18 - ((f16 * f18) / f17);
        }
        return this.mStage3EndPosition;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public float getVelocity() {
        return this.mBackwards ? -getVelocity(this.mLastPosition) : getVelocity(this.mLastPosition);
    }
}
