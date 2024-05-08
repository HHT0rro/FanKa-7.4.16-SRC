package com.android.internal.graphics.cam;

import android.util.MathUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class Frame {
    public static final Frame DEFAULT = make(CamUtils.WHITE_POINT_D65, (float) ((CamUtils.yFromLstar(50.0d) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    private final float mAw;
    private final float mC;
    private final float mFl;
    private final float mFlRoot;
    private final float mN;
    private final float mNbb;
    private final float mNc;
    private final float mNcb;
    private final float[] mRgbD;
    private final float mZ;

    public float getAw() {
        return this.mAw;
    }

    public float getN() {
        return this.mN;
    }

    public float getNbb() {
        return this.mNbb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getNcb() {
        return this.mNcb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getC() {
        return this.mC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getNc() {
        return this.mNc;
    }

    public float[] getRgbD() {
        return this.mRgbD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getFl() {
        return this.mFl;
    }

    public float getFlRoot() {
        return this.mFlRoot;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getZ() {
        return this.mZ;
    }

    private Frame(float n10, float aw, float nbb, float ncb, float c4, float nc2, float[] rgbD, float fl, float fLRoot, float z10) {
        this.mN = n10;
        this.mAw = aw;
        this.mNbb = nbb;
        this.mNcb = ncb;
        this.mC = c4;
        this.mNc = nc2;
        this.mRgbD = rgbD;
        this.mFl = fl;
        this.mFlRoot = fLRoot;
        this.mZ = z10;
    }

    public static Frame make(float[] whitepoint, float adaptingLuminance, float backgroundLstar, float surround, boolean discountingIlluminant) {
        float f10;
        float[][] matrix = CamUtils.XYZ_TO_CAM16RGB;
        float rW = (whitepoint[0] * matrix[0][0]) + (whitepoint[1] * matrix[0][1]) + (whitepoint[2] * matrix[0][2]);
        float gW = (whitepoint[0] * matrix[1][0]) + (whitepoint[1] * matrix[1][1]) + (whitepoint[2] * matrix[1][2]);
        float bW = (whitepoint[0] * matrix[2][0]) + (whitepoint[1] * matrix[2][1]) + (whitepoint[2] * matrix[2][2]);
        float f11 = (surround / 10.0f) + 0.8f;
        float c4 = ((double) f11) >= 0.9d ? MathUtils.lerp(0.59f, 0.69f, (f11 - 0.9f) * 10.0f) : MathUtils.lerp(0.525f, 0.59f, (f11 - 0.8f) * 10.0f);
        float d10 = discountingIlluminant ? 1.0f : (1.0f - (((float) Math.exp(((-adaptingLuminance) - 42.0f) / 92.0f)) * 0.2777778f)) * f11;
        if (d10 > 1.0d) {
            f10 = 1.0f;
        } else {
            f10 = ((double) d10) < ShadowDrawableWrapper.COS_45 ? 0.0f : d10;
        }
        float d11 = f10;
        float[] rgbD = {(((100.0f / rW) * d11) + 1.0f) - d11, (((100.0f / gW) * d11) + 1.0f) - d11, (((100.0f / bW) * d11) + 1.0f) - d11};
        float k10 = 1.0f / ((5.0f * adaptingLuminance) + 1.0f);
        float k42 = k10 * k10 * k10 * k10;
        float k4F = 1.0f - k42;
        float fl = (k42 * adaptingLuminance) + (0.1f * k4F * k4F * ((float) Math.cbrt(adaptingLuminance * 5.0d)));
        float n10 = ((float) CamUtils.yFromLstar(backgroundLstar)) / whitepoint[1];
        float z10 = ((float) Math.sqrt(n10)) + 1.48f;
        float nbb = 0.725f / ((float) Math.pow(n10, 0.2d));
        float[] rgbAFactors = {(float) Math.pow(((rgbD[0] * fl) * rW) / 100.0d, 0.42d), (float) Math.pow(((rgbD[1] * fl) * gW) / 100.0d, 0.42d), (float) Math.pow(((rgbD[2] * fl) * bW) / 100.0d, 0.42d)};
        float[] rgbA = {(rgbAFactors[0] * 400.0f) / (rgbAFactors[0] + 27.13f), (rgbAFactors[1] * 400.0f) / (rgbAFactors[1] + 27.13f), (rgbAFactors[2] * 400.0f) / (rgbAFactors[2] + 27.13f)};
        float aw = ((rgbA[0] * 2.0f) + rgbA[1] + (rgbA[2] * 0.05f)) * nbb;
        return new Frame(n10, aw, nbb, nbb, c4, f11, rgbD, fl, (float) Math.pow(fl, 0.25d), z10);
    }
}
