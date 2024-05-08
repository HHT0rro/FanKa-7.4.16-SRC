package androidx.constraintlayout.motion.utils;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    public double[] mArea;
    public int mType;
    public float[] mPeriod = new float[0];
    public double[] mPosition = new double[0];
    public double PI2 = 6.283185307179586d;
    private boolean mNormalized = false;

    public void addPoint(double d10, float f10) {
        int length = this.mPeriod.length + 1;
        int binarySearch = Arrays.binarySearch(this.mPosition, d10);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy((Object) dArr, binarySearch, (Object) dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.mPosition[binarySearch] = d10;
        this.mPeriod[binarySearch] = f10;
        this.mNormalized = false;
    }

    public double getDP(double d10) {
        if (d10 <= ShadowDrawableWrapper.COS_45) {
            d10 = 1.0E-5d;
        } else if (d10 >= 1.0d) {
            d10 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d10);
        if (binarySearch > 0 || binarySearch == 0) {
            return ShadowDrawableWrapper.COS_45;
        }
        int i10 = (-binarySearch) - 1;
        float[] fArr = this.mPeriod;
        int i11 = i10 - 1;
        double d11 = fArr[i10] - fArr[i11];
        double[] dArr = this.mPosition;
        double d12 = d11 / (dArr[i10] - dArr[i11]);
        return (fArr[i11] - (d12 * dArr[i11])) + (d10 * d12);
    }

    public double getP(double d10) {
        if (d10 < ShadowDrawableWrapper.COS_45) {
            d10 = 0.0d;
        } else if (d10 > 1.0d) {
            d10 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d10);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return ShadowDrawableWrapper.COS_45;
        }
        int i10 = (-binarySearch) - 1;
        float[] fArr = this.mPeriod;
        int i11 = i10 - 1;
        double d11 = fArr[i10] - fArr[i11];
        double[] dArr = this.mPosition;
        double d12 = d11 / (dArr[i10] - dArr[i11]);
        return this.mArea[i11] + ((fArr[i11] - (dArr[i11] * d12)) * (d10 - dArr[i11])) + ((d12 * ((d10 * d10) - (dArr[i11] * dArr[i11]))) / 2.0d);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    public double getSlope(double d10) {
        double dp;
        double signum;
        double dp2;
        double dp3;
        double sin;
        switch (this.mType) {
            case 1:
                return ShadowDrawableWrapper.COS_45;
            case 2:
                dp = getDP(d10) * 4.0d;
                signum = Math.signum((((getP(d10) * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                return dp * signum;
            case 3:
                dp2 = getDP(d10);
                return dp2 * 2.0d;
            case 4:
                dp2 = -getDP(d10);
                return dp2 * 2.0d;
            case 5:
                dp3 = (-this.PI2) * getDP(d10);
                sin = Math.sin(this.PI2 * getP(d10));
                return dp3 * sin;
            case 6:
                dp = getDP(d10) * 4.0d;
                signum = (((getP(d10) * 4.0d) + 2.0d) % 4.0d) - 2.0d;
                return dp * signum;
            default:
                dp3 = this.PI2 * getDP(d10);
                sin = Math.cos(this.PI2 * getP(d10));
                return dp3 * sin;
        }
    }

    public double getValue(double d10) {
        double abs;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (getP(d10) % 1.0d));
            case 2:
                abs = Math.abs((((getP(d10) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((getP(d10) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((getP(d10) * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.PI2 * getP(d10));
            case 6:
                double abs2 = 1.0d - Math.abs(((getP(d10) * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            default:
                return Math.sin(this.PI2 * getP(d10));
        }
        return 1.0d - abs;
    }

    public void normalize() {
        double d10 = 0.0d;
        int i10 = 0;
        while (true) {
            if (i10 >= this.mPeriod.length) {
                break;
            }
            d10 += r7[i10];
            i10++;
        }
        double d11 = 0.0d;
        int i11 = 1;
        while (true) {
            float[] fArr = this.mPeriod;
            if (i11 >= fArr.length) {
                break;
            }
            int i12 = i11 - 1;
            float f10 = (fArr[i12] + fArr[i11]) / 2.0f;
            double[] dArr = this.mPosition;
            d11 += (dArr[i11] - dArr[i12]) * f10;
            i11++;
        }
        int i13 = 0;
        while (true) {
            float[] fArr2 = this.mPeriod;
            if (i13 >= fArr2.length) {
                break;
            }
            fArr2[i13] = (float) (fArr2[i13] * (d10 / d11));
            i13++;
        }
        this.mArea[0] = 0.0d;
        int i14 = 1;
        while (true) {
            float[] fArr3 = this.mPeriod;
            if (i14 < fArr3.length) {
                int i15 = i14 - 1;
                float f11 = (fArr3[i15] + fArr3[i14]) / 2.0f;
                double[] dArr2 = this.mPosition;
                double d12 = dArr2[i14] - dArr2[i15];
                double[] dArr3 = this.mArea;
                dArr3[i14] = dArr3[i15] + (d12 * f11);
                i14++;
            } else {
                this.mNormalized = true;
                return;
            }
        }
    }

    public void setType(int i10) {
        this.mType = i10;
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
