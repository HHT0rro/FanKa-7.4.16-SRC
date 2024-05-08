package com.android.internal.graphics.cam;

import com.android.internal.graphics.ColorUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class Cam {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;
    private final float mJ;
    private final float mJstar;
    private final float mM;
    private final float mQ;
    private final float mS;

    public float getHue() {
        return this.mHue;
    }

    public float getChroma() {
        return this.mChroma;
    }

    public float getJ() {
        return this.mJ;
    }

    public float getQ() {
        return this.mQ;
    }

    public float getM() {
        return this.mM;
    }

    public float getS() {
        return this.mS;
    }

    public float getJstar() {
        return this.mJstar;
    }

    public float getAstar() {
        return this.mAstar;
    }

    public float getBstar() {
        return this.mBstar;
    }

    Cam(float hue, float chroma, float j10, float q10, float m10, float s2, float jstar, float astar, float bstar) {
        this.mHue = hue;
        this.mChroma = chroma;
        this.mJ = j10;
        this.mQ = q10;
        this.mM = m10;
        this.mS = s2;
        this.mJstar = jstar;
        this.mAstar = astar;
        this.mBstar = bstar;
    }

    public static int getInt(float hue, float chroma, float lstar) {
        return getInt(hue, chroma, lstar, Frame.DEFAULT);
    }

    public static Cam fromInt(int argb) {
        return fromIntInFrame(argb, Frame.DEFAULT);
    }

    public static Cam fromIntInFrame(int argb, Frame frame) {
        float f10;
        float[] xyz = CamUtils.xyzFromInt(argb);
        float[][] matrix = CamUtils.XYZ_TO_CAM16RGB;
        float rT = (xyz[0] * matrix[0][0]) + (xyz[1] * matrix[0][1]) + (xyz[2] * matrix[0][2]);
        float gT = (xyz[0] * matrix[1][0]) + (xyz[1] * matrix[1][1]) + (xyz[2] * matrix[1][2]);
        float bT = (xyz[0] * matrix[2][0]) + (xyz[1] * matrix[2][1]) + (xyz[2] * matrix[2][2]);
        float rD = frame.getRgbD()[0] * rT;
        float gD = frame.getRgbD()[1] * gT;
        float bD = frame.getRgbD()[2] * bT;
        float rAF = (float) Math.pow((frame.getFl() * Math.abs(rD)) / 100.0d, 0.42d);
        float gAF = (float) Math.pow((frame.getFl() * Math.abs(gD)) / 100.0d, 0.42d);
        float bAF = (float) Math.pow((frame.getFl() * Math.abs(bD)) / 100.0d, 0.42d);
        float rA = ((Math.signum(rD) * 400.0f) * rAF) / (rAF + 27.13f);
        float gA = ((Math.signum(gD) * 400.0f) * gAF) / (gAF + 27.13f);
        float bA = ((Math.signum(bD) * 400.0f) * bAF) / (27.13f + bAF);
        float a10 = ((float) (((rA * 11.0d) + (gA * (-12.0d))) + bA)) / 11.0f;
        float b4 = ((float) ((rA + gA) - (bA * 2.0d))) / 9.0f;
        float u10 = (((rA * 20.0f) + (gA * 20.0f)) + (21.0f * bA)) / 20.0f;
        float p22 = (((40.0f * rA) + (gA * 20.0f)) + bA) / 20.0f;
        float atan2 = (float) Math.atan2(b4, a10);
        float atanDegrees = (atan2 * 180.0f) / 3.1415927f;
        if (atanDegrees < 0.0f) {
            f10 = atanDegrees + 360.0f;
        } else {
            f10 = atanDegrees >= 360.0f ? atanDegrees - 360.0f : atanDegrees;
        }
        float hue = f10;
        float hueRadians = (hue * 3.1415927f) / 180.0f;
        float ac2 = frame.getNbb() * p22;
        float atan22 = ac2 / frame.getAw();
        float j10 = ((float) Math.pow(atan22, frame.getC() * frame.getZ())) * 100.0f;
        float q10 = (4.0f / frame.getC()) * ((float) Math.sqrt(j10 / 100.0f)) * (frame.getAw() + 4.0f) * frame.getFlRoot();
        float huePrime = ((double) hue) < 20.14d ? hue + 360.0f : hue;
        float eHue = ((float) (Math.cos(((huePrime * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f;
        float p12 = 3846.1538f * eHue * frame.getNc() * frame.getNcb();
        float t2 = (((float) Math.sqrt((a10 * a10) + (b4 * b4))) * p12) / (0.305f + u10);
        float alpha = ((float) Math.pow(t2, 0.9d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, frame.getN()), 0.73d));
        float c4 = ((float) Math.sqrt(j10 / 100.0d)) * alpha;
        float m10 = frame.getFlRoot() * c4;
        float s2 = ((float) Math.sqrt((frame.getC() * alpha) / (frame.getAw() + 4.0f))) * 50.0f;
        float jstar = (1.7f * j10) / ((0.007f * j10) + 1.0f);
        float mstar = ((float) Math.log((0.0228f * m10) + 1.0f)) * 43.85965f;
        float astar = ((float) Math.cos(hueRadians)) * mstar;
        float bstar = ((float) Math.sin(hueRadians)) * mstar;
        return new Cam(hue, c4, j10, q10, m10, s2, jstar, astar, bstar);
    }

    private static Cam fromJch(float j10, float c4, float h10) {
        return fromJchInFrame(j10, c4, h10, Frame.DEFAULT);
    }

    private static Cam fromJchInFrame(float j10, float c4, float h10, Frame frame) {
        float q10 = (4.0f / frame.getC()) * ((float) Math.sqrt(j10 / 100.0d)) * (frame.getAw() + 4.0f) * frame.getFlRoot();
        float m10 = c4 * frame.getFlRoot();
        float alpha = c4 / ((float) Math.sqrt(j10 / 100.0d));
        float s2 = ((float) Math.sqrt((frame.getC() * alpha) / (frame.getAw() + 4.0f))) * 50.0f;
        float hueRadians = (3.1415927f * h10) / 180.0f;
        float jstar = (1.7f * j10) / ((0.007f * j10) + 1.0f);
        float mstar = ((float) Math.log((m10 * 0.0228d) + 1.0d)) * 43.85965f;
        float astar = mstar * ((float) Math.cos(hueRadians));
        float bstar = mstar * ((float) Math.sin(hueRadians));
        return new Cam(h10, c4, j10, q10, m10, s2, jstar, astar, bstar);
    }

    public float distance(Cam other) {
        float dJ = getJstar() - other.getJstar();
        float dA = getAstar() - other.getAstar();
        float dB = getBstar() - other.getBstar();
        double dEPrime = Math.sqrt((dJ * dJ) + (dA * dA) + (dB * dB));
        double dE = Math.pow(dEPrime, 0.63d) * 1.41d;
        return (float) dE;
    }

    public int viewedInSrgb() {
        return viewed(Frame.DEFAULT);
    }

    public int viewed(Frame frame) {
        float alpha;
        if (getChroma() == ShadowDrawableWrapper.COS_45 || getJ() == ShadowDrawableWrapper.COS_45) {
            alpha = 0.0f;
        } else {
            alpha = getChroma() / ((float) Math.sqrt(getJ() / 100.0d));
        }
        float t2 = (float) Math.pow(alpha / Math.pow(1.64d - Math.pow(0.29d, frame.getN()), 0.73d), 1.1111111111111112d);
        float hRad = (getHue() * 3.1415927f) / 180.0f;
        float eHue = ((float) (Math.cos(hRad + 2.0d) + 3.8d)) * 0.25f;
        float ac2 = frame.getAw() * ((float) Math.pow(getJ() / 100.0d, (1.0d / frame.getC()) / frame.getZ()));
        float p12 = 3846.1538f * eHue * frame.getNc() * frame.getNcb();
        float p22 = ac2 / frame.getNbb();
        float hSin = (float) Math.sin(hRad);
        float hCos = (float) Math.cos(hRad);
        float gamma = (((0.305f + p22) * 23.0f) * t2) / (((23.0f * p12) + ((11.0f * t2) * hCos)) + ((108.0f * t2) * hSin));
        float a10 = gamma * hCos;
        float b4 = gamma * hSin;
        float rA = (((p22 * 460.0f) + (451.0f * a10)) + (288.0f * b4)) / 1403.0f;
        float gA = (((p22 * 460.0f) - (891.0f * a10)) - (261.0f * b4)) / 1403.0f;
        float bA = (((460.0f * p22) - (220.0f * a10)) - (6300.0f * b4)) / 1403.0f;
        float alpha2 = Math.abs(rA);
        float rCBase = (float) Math.max(ShadowDrawableWrapper.COS_45, (Math.abs(rA) * 27.13d) / (400.0d - alpha2));
        float rC = Math.signum(rA) * (100.0f / frame.getFl()) * ((float) Math.pow(rCBase, 2.380952380952381d));
        float gCBase = (float) Math.max(ShadowDrawableWrapper.COS_45, (Math.abs(gA) * 27.13d) / (400.0d - Math.abs(gA)));
        float gC = Math.signum(gA) * (100.0f / frame.getFl()) * ((float) Math.pow(gCBase, 2.380952380952381d));
        float bCBase = (float) Math.max(ShadowDrawableWrapper.COS_45, (Math.abs(bA) * 27.13d) / (400.0d - Math.abs(bA)));
        float bC = Math.signum(bA) * (100.0f / frame.getFl()) * ((float) Math.pow(bCBase, 2.380952380952381d));
        float rF = rC / frame.getRgbD()[0];
        float gF = gC / frame.getRgbD()[1];
        float bF = bC / frame.getRgbD()[2];
        float[][] matrix = CamUtils.CAM16RGB_TO_XYZ;
        float x10 = (matrix[0][0] * rF) + (matrix[0][1] * gF) + (matrix[0][2] * bF);
        float y10 = (matrix[1][0] * rF) + (matrix[1][1] * gF) + (matrix[1][2] * bF);
        float rCBase2 = (matrix[2][0] * rF) + (matrix[2][1] * gF) + (matrix[2][2] * bF);
        int argb = ColorUtils.XYZToColor(x10, y10, rCBase2);
        return argb;
    }

    public static int getInt(float hue, float chroma, float lstar, Frame frame) {
        if (frame == Frame.DEFAULT) {
            return HctSolver.solveToInt(hue, chroma, lstar);
        }
        if (chroma < 1.0d || Math.round(lstar) <= ShadowDrawableWrapper.COS_45 || Math.round(lstar) >= 100.0d) {
            return CamUtils.intFromLstar(lstar);
        }
        float hue2 = hue >= 0.0f ? Math.min(360.0f, hue) : 0.0f;
        float high = chroma;
        float mid = chroma;
        float low = 0.0f;
        boolean isFirstLoop = true;
        Cam answer = null;
        while (Math.abs(low - high) >= 0.4f) {
            Cam possibleAnswer = findCamByJ(hue2, mid, lstar);
            if (isFirstLoop) {
                if (possibleAnswer != null) {
                    return possibleAnswer.viewed(frame);
                }
                isFirstLoop = false;
                mid = low + ((high - low) / 2.0f);
            } else {
                if (possibleAnswer == null) {
                    high = mid;
                } else {
                    answer = possibleAnswer;
                    low = mid;
                }
                mid = low + ((high - low) / 2.0f);
            }
        }
        if (answer == null) {
            return CamUtils.intFromLstar(lstar);
        }
        return answer.viewed(frame);
    }

    private static Cam findCamByJ(float hue, float chroma, float lstar) {
        float low = 0.0f;
        float high = 100.0f;
        float bestdL = 1000.0f;
        float bestdE = 1000.0f;
        Cam bestCam = null;
        while (Math.abs(low - high) > 0.01f) {
            float mid = low + ((high - low) / 2.0f);
            Cam camBeforeClip = fromJch(mid, chroma, hue);
            int clipped = camBeforeClip.viewedInSrgb();
            float clippedLstar = CamUtils.lstarFromInt(clipped);
            float dL = Math.abs(lstar - clippedLstar);
            if (dL < 0.2f) {
                Cam camClipped = fromInt(clipped);
                float dE = camClipped.distance(fromJch(camClipped.getJ(), camClipped.getChroma(), hue));
                if (dE <= 1.0f) {
                    bestdL = dL;
                    bestdE = dE;
                    bestCam = camClipped;
                }
            }
            if (bestdL == 0.0f && bestdE == 0.0f) {
                break;
            }
            if (clippedLstar < lstar) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return bestCam;
    }
}
