package androidx.constraintlayout.motion.utils;

import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private double[] mT;
    private double mTotalLength;
    private double[][] mY;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        this.mTotalLength = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mT = dArr;
        this.mY = dArr2;
        if (length2 > 2) {
            double d10 = 0.0d;
            double d11 = 0.0d;
            int i10 = 0;
            while (i10 < dArr.length) {
                double d12 = dArr2[i10][0];
                double d13 = dArr2[i10][0];
                if (i10 > 0) {
                    Math.hypot(d12 - d10, d13 - d11);
                }
                i10++;
                d10 = d12;
                d11 = d13;
            }
            this.mTotalLength = ShadowDrawableWrapper.COS_45;
        }
    }

    private double getLength2D(double d10) {
        if (Double.isNaN(this.mTotalLength)) {
            return ShadowDrawableWrapper.COS_45;
        }
        double[] dArr = this.mT;
        int length = dArr.length;
        if (d10 <= dArr[0]) {
            return ShadowDrawableWrapper.COS_45;
        }
        int i10 = length - 1;
        if (d10 >= dArr[i10]) {
            return this.mTotalLength;
        }
        double d11 = 0.0d;
        double d12 = 0.0d;
        double d13 = 0.0d;
        int i11 = 0;
        while (i11 < i10) {
            double[][] dArr2 = this.mY;
            double d14 = dArr2[i11][0];
            double d15 = dArr2[i11][1];
            if (i11 > 0) {
                d11 += Math.hypot(d14 - d12, d15 - d13);
            }
            double[] dArr3 = this.mT;
            if (d10 == dArr3[i11]) {
                return d11;
            }
            int i12 = i11 + 1;
            if (d10 < dArr3[i12]) {
                double d16 = (d10 - dArr3[i11]) / (dArr3[i12] - dArr3[i11]);
                double[][] dArr4 = this.mY;
                double d17 = 1.0d - d16;
                return d11 + Math.hypot(d15 - ((dArr4[i11][1] * d17) + (dArr4[i12][1] * d16)), d14 - ((dArr4[i11][0] * d17) + (dArr4[i12][0] * d16)));
            }
            i11 = i12;
            d12 = d14;
            d13 = d15;
        }
        return ShadowDrawableWrapper.COS_45;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d10, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int i10 = 0;
        int length2 = this.mY[0].length;
        if (d10 <= dArr2[0]) {
            for (int i11 = 0; i11 < length2; i11++) {
                dArr[i11] = this.mY[0][i11];
            }
            return;
        }
        int i12 = length - 1;
        if (d10 >= dArr2[i12]) {
            while (i10 < length2) {
                dArr[i10] = this.mY[i12][i10];
                i10++;
            }
            return;
        }
        int i13 = 0;
        while (i13 < i12) {
            if (d10 == this.mT[i13]) {
                for (int i14 = 0; i14 < length2; i14++) {
                    dArr[i14] = this.mY[i13][i14];
                }
            }
            double[] dArr3 = this.mT;
            int i15 = i13 + 1;
            if (d10 < dArr3[i15]) {
                double d11 = (d10 - dArr3[i13]) / (dArr3[i15] - dArr3[i13]);
                while (i10 < length2) {
                    double[][] dArr4 = this.mY;
                    dArr[i10] = (dArr4[i13][i10] * (1.0d - d11)) + (dArr4[i15][i10] * d11);
                    i10++;
                }
                return;
            }
            i13 = i15;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double d10, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int length2 = this.mY[0].length;
        if (d10 <= dArr2[0]) {
            d10 = dArr2[0];
        } else {
            int i10 = length - 1;
            if (d10 >= dArr2[i10]) {
                d10 = dArr2[i10];
            }
        }
        int i11 = 0;
        while (i11 < length - 1) {
            double[] dArr3 = this.mT;
            int i12 = i11 + 1;
            if (d10 <= dArr3[i12]) {
                double d11 = dArr3[i12] - dArr3[i11];
                double d12 = dArr3[i11];
                for (int i13 = 0; i13 < length2; i13++) {
                    double[][] dArr4 = this.mY;
                    dArr[i13] = (dArr4[i12][i13] - dArr4[i11][i13]) / d11;
                }
                return;
            }
            i11 = i12;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double d10, int i10) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i11 = 0;
        if (d10 < dArr[0]) {
            d10 = dArr[0];
        } else {
            int i12 = length - 1;
            if (d10 >= dArr[i12]) {
                d10 = dArr[i12];
            }
        }
        while (i11 < length - 1) {
            double[] dArr2 = this.mT;
            int i13 = i11 + 1;
            if (d10 <= dArr2[i13]) {
                double d11 = dArr2[i13] - dArr2[i11];
                double d12 = dArr2[i11];
                double[][] dArr3 = this.mY;
                return (dArr3[i13][i10] - dArr3[i11][i10]) / d11;
            }
            i11 = i13;
        }
        return ShadowDrawableWrapper.COS_45;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double d10, float[] fArr) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i10 = 0;
        int length2 = this.mY[0].length;
        if (d10 <= dArr[0]) {
            for (int i11 = 0; i11 < length2; i11++) {
                fArr[i11] = (float) this.mY[0][i11];
            }
            return;
        }
        int i12 = length - 1;
        if (d10 >= dArr[i12]) {
            while (i10 < length2) {
                fArr[i10] = (float) this.mY[i12][i10];
                i10++;
            }
            return;
        }
        int i13 = 0;
        while (i13 < i12) {
            if (d10 == this.mT[i13]) {
                for (int i14 = 0; i14 < length2; i14++) {
                    fArr[i14] = (float) this.mY[i13][i14];
                }
            }
            double[] dArr2 = this.mT;
            int i15 = i13 + 1;
            if (d10 < dArr2[i15]) {
                double d11 = (d10 - dArr2[i13]) / (dArr2[i15] - dArr2[i13]);
                while (i10 < length2) {
                    double[][] dArr3 = this.mY;
                    fArr[i10] = (float) ((dArr3[i13][i10] * (1.0d - d11)) + (dArr3[i15][i10] * d11));
                    i10++;
                }
                return;
            }
            i13 = i15;
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double d10, int i10) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i11 = 0;
        if (d10 <= dArr[0]) {
            return this.mY[0][i10];
        }
        int i12 = length - 1;
        if (d10 >= dArr[i12]) {
            return this.mY[i12][i10];
        }
        while (i11 < i12) {
            double[] dArr2 = this.mT;
            if (d10 == dArr2[i11]) {
                return this.mY[i11][i10];
            }
            int i13 = i11 + 1;
            if (d10 < dArr2[i13]) {
                double d11 = (d10 - dArr2[i11]) / (dArr2[i13] - dArr2[i11]);
                double[][] dArr3 = this.mY;
                return (dArr3[i11][i10] * (1.0d - d11)) + (dArr3[i13][i10] * d11);
            }
            i11 = i13;
        }
        return ShadowDrawableWrapper.COS_45;
    }
}
