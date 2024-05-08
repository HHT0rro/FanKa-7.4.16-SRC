package androidx.constraintlayout.motion.utils;

import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class CurveFit {
    public static final int CONSTANT = 2;
    public static final int LINEAR = 1;
    public static final int SPLINE = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Constant extends CurveFit {
        public double mTime;
        public double[] mValue;

        public Constant(double d10, double[] dArr) {
            this.mTime = d10;
            this.mValue = dArr;
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getPos(double d10, double[] dArr) {
            double[] dArr2 = this.mValue;
            System.arraycopy((Object) dArr2, 0, (Object) dArr, 0, dArr2.length);
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double getSlope(double d10, int i10) {
            return ShadowDrawableWrapper.COS_45;
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getSlope(double d10, double[] dArr) {
            for (int i10 = 0; i10 < this.mValue.length; i10++) {
                dArr[i10] = 0.0d;
            }
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double[] getTimePoints() {
            return new double[]{this.mTime};
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public void getPos(double d10, float[] fArr) {
            int i10 = 0;
            while (true) {
                double[] dArr = this.mValue;
                if (i10 >= dArr.length) {
                    return;
                }
                fArr[i10] = (float) dArr[i10];
                i10++;
            }
        }

        @Override // androidx.constraintlayout.motion.utils.CurveFit
        public double getPos(double d10, int i10) {
            return this.mValue[i10];
        }
    }

    public static CurveFit get(int i10, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i10 = 2;
        }
        if (i10 == 0) {
            return new MonotonicCurveFit(dArr, dArr2);
        }
        if (i10 != 2) {
            return new LinearCurveFit(dArr, dArr2);
        }
        return new Constant(dArr[0], dArr2[0]);
    }

    public static CurveFit getArc(int[] iArr, double[] dArr, double[][] dArr2) {
        return new ArcCurveFit(iArr, dArr, dArr2);
    }

    public abstract double getPos(double d10, int i10);

    public abstract void getPos(double d10, double[] dArr);

    public abstract void getPos(double d10, float[] fArr);

    public abstract double getSlope(double d10, int i10);

    public abstract void getSlope(double d10, double[] dArr);

    public abstract double[] getTimePoints();
}
