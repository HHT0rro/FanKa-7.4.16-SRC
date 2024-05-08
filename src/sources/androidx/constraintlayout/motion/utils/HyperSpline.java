package androidx.constraintlayout.motion.utils;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.lang.reflect.Array;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class HyperSpline {
    public double[][] mCtl;
    public Cubic[][] mCurve;
    public double[] mCurveLength;
    public int mDimensionality;
    public int mPoints;
    public double mTotalLength;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Cubic {
        public static final double HALF = 0.5d;
        public static final double THIRD = 0.3333333333333333d;
        public double mA;
        public double mB;
        public double mC;
        public double mD;

        public Cubic(double d10, double d11, double d12, double d13) {
            this.mA = d10;
            this.mB = d11;
            this.mC = d12;
            this.mD = d13;
        }

        public double eval(double d10) {
            return (((((this.mD * d10) + this.mC) * d10) + this.mB) * d10) + this.mA;
        }

        public double vel(double d10) {
            return (((this.mD * 0.3333333333333333d * d10) + (this.mC * 0.5d)) * d10) + this.mB;
        }
    }

    public HyperSpline(double[][] dArr) {
        setup(dArr);
    }

    public static Cubic[] calcNaturalCubic(int i10, double[] dArr) {
        double[] dArr2 = new double[i10];
        double[] dArr3 = new double[i10];
        double[] dArr4 = new double[i10];
        int i11 = i10 - 1;
        int i12 = 0;
        dArr2[0] = 0.5d;
        int i13 = 1;
        for (int i14 = 1; i14 < i11; i14++) {
            dArr2[i14] = 1.0d / (4.0d - dArr2[i14 - 1]);
        }
        int i15 = i11 - 1;
        dArr2[i11] = 1.0d / (2.0d - dArr2[i15]);
        dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
        while (i13 < i11) {
            int i16 = i13 + 1;
            int i17 = i13 - 1;
            dArr3[i13] = (((dArr[i16] - dArr[i17]) * 3.0d) - dArr3[i17]) * dArr2[i13];
            i13 = i16;
        }
        dArr3[i11] = (((dArr[i11] - dArr[i15]) * 3.0d) - dArr3[i15]) * dArr2[i11];
        dArr4[i11] = dArr3[i11];
        while (i15 >= 0) {
            dArr4[i15] = dArr3[i15] - (dArr2[i15] * dArr4[i15 + 1]);
            i15--;
        }
        Cubic[] cubicArr = new Cubic[i11];
        while (i12 < i11) {
            int i18 = i12 + 1;
            cubicArr[i12] = new Cubic((float) dArr[i12], dArr4[i12], (((dArr[i18] - dArr[i12]) * 3.0d) - (dArr4[i12] * 2.0d)) - dArr4[i18], ((dArr[i12] - dArr[i18]) * 2.0d) + dArr4[i12] + dArr4[i18]);
            i12 = i18;
        }
        return cubicArr;
    }

    public double approxLength(Cubic[] cubicArr) {
        int i10;
        int length = cubicArr.length;
        double[] dArr = new double[cubicArr.length];
        double d10 = ShadowDrawableWrapper.COS_45;
        double d11 = 0.0d;
        double d12 = 0.0d;
        while (true) {
            i10 = 0;
            if (d11 >= 1.0d) {
                break;
            }
            double d13 = 0.0d;
            while (i10 < cubicArr.length) {
                double d14 = dArr[i10];
                double eval = cubicArr[i10].eval(d11);
                dArr[i10] = eval;
                double d15 = d14 - eval;
                d13 += d15 * d15;
                i10++;
            }
            if (d11 > ShadowDrawableWrapper.COS_45) {
                d12 += Math.sqrt(d13);
            }
            d11 += 0.1d;
        }
        while (i10 < cubicArr.length) {
            double d16 = dArr[i10];
            double eval2 = cubicArr[i10].eval(1.0d);
            dArr[i10] = eval2;
            double d17 = d16 - eval2;
            d10 += d17 * d17;
            i10++;
        }
        return d12 + Math.sqrt(d10);
    }

    public void getPos(double d10, double[] dArr) {
        double d11 = d10 * this.mTotalLength;
        int i10 = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i10 >= dArr2.length - 1 || dArr2[i10] >= d11) {
                break;
            }
            d11 -= dArr2[i10];
            i10++;
        }
        for (int i11 = 0; i11 < dArr.length; i11++) {
            dArr[i11] = this.mCurve[i11][i10].eval(d11 / this.mCurveLength[i10]);
        }
    }

    public void getVelocity(double d10, double[] dArr) {
        double d11 = d10 * this.mTotalLength;
        int i10 = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i10 >= dArr2.length - 1 || dArr2[i10] >= d11) {
                break;
            }
            d11 -= dArr2[i10];
            i10++;
        }
        for (int i11 = 0; i11 < dArr.length; i11++) {
            dArr[i11] = this.mCurve[i11][i10].vel(d11 / this.mCurveLength[i10]);
        }
    }

    public void setup(double[][] dArr) {
        int i10;
        int length = dArr[0].length;
        this.mDimensionality = length;
        int length2 = dArr.length;
        this.mPoints = length2;
        this.mCtl = (double[][]) Array.newInstance((Class<?>) double.class, length, length2);
        this.mCurve = new Cubic[this.mDimensionality];
        for (int i11 = 0; i11 < this.mDimensionality; i11++) {
            for (int i12 = 0; i12 < this.mPoints; i12++) {
                this.mCtl[i11][i12] = dArr[i12][i11];
            }
        }
        int i13 = 0;
        while (true) {
            i10 = this.mDimensionality;
            if (i13 >= i10) {
                break;
            }
            Cubic[][] cubicArr = this.mCurve;
            double[][] dArr2 = this.mCtl;
            cubicArr[i13] = calcNaturalCubic(dArr2[i13].length, dArr2[i13]);
            i13++;
        }
        this.mCurveLength = new double[this.mPoints - 1];
        this.mTotalLength = ShadowDrawableWrapper.COS_45;
        Cubic[] cubicArr2 = new Cubic[i10];
        for (int i14 = 0; i14 < this.mCurveLength.length; i14++) {
            for (int i15 = 0; i15 < this.mDimensionality; i15++) {
                cubicArr2[i15] = this.mCurve[i15][i14];
            }
            double d10 = this.mTotalLength;
            double[] dArr3 = this.mCurveLength;
            double approxLength = approxLength(cubicArr2);
            dArr3[i14] = approxLength;
            this.mTotalLength = d10 + approxLength;
        }
    }

    public HyperSpline() {
    }

    public void getPos(double d10, float[] fArr) {
        double d11 = d10 * this.mTotalLength;
        int i10 = 0;
        while (true) {
            double[] dArr = this.mCurveLength;
            if (i10 >= dArr.length - 1 || dArr[i10] >= d11) {
                break;
            }
            d11 -= dArr[i10];
            i10++;
        }
        for (int i11 = 0; i11 < fArr.length; i11++) {
            fArr[i11] = (float) this.mCurve[i11][i10].eval(d11 / this.mCurveLength[i10]);
        }
    }

    public double getPos(double d10, int i10) {
        double[] dArr;
        double d11 = d10 * this.mTotalLength;
        int i11 = 0;
        while (true) {
            dArr = this.mCurveLength;
            if (i11 >= dArr.length - 1 || dArr[i11] >= d11) {
                break;
            }
            d11 -= dArr[i11];
            i11++;
        }
        return this.mCurve[i10][i11].eval(d11 / dArr[i11]);
    }
}
