package com.android.internal.graphics.cam;

import android.graphics.Color;
import com.android.internal.graphics.ColorUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class CamUtils {
    static final float[][] XYZ_TO_CAM16RGB = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
    static final float[][] CAM16RGB_TO_XYZ = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
    static final float[] WHITE_POINT_D65 = {95.047f, 100.0f, 108.883f};
    static final double[][] SRGB_TO_XYZ = {new double[]{0.41233895d, 0.35762064d, 0.18051042d}, new double[]{0.2126d, 0.7152d, 0.0722d}, new double[]{0.01932141d, 0.11916382d, 0.95034478d}};
    static final double[][] XYZ_TO_SRGB = {new double[]{3.2413774792388685d, -1.5376652402851851d, -0.49885366846268053d}, new double[]{-0.9691452513005321d, 1.8758853451067872d, 0.04156585616912061d}, new double[]{0.05562093689691305d, -0.20395524564742123d, 1.0571799111220335d}};

    private CamUtils() {
    }

    public static int signum(double num) {
        if (num < ShadowDrawableWrapper.COS_45) {
            return -1;
        }
        if (num == ShadowDrawableWrapper.COS_45) {
            return 0;
        }
        return 1;
    }

    public static int argbFromLstar(double lstar) {
        double x10;
        double z10;
        double fy = (lstar + 16.0d) / 116.0d;
        boolean lExceedsEpsilonKappa = lstar > 8.0d;
        double y10 = lExceedsEpsilonKappa ? fy * fy * fy : lstar / 903.2962962962963d;
        boolean cubeExceedEpsilon = (fy * fy) * fy > 0.008856451679035631d;
        if (cubeExceedEpsilon) {
            x10 = fy * fy * fy;
        } else {
            x10 = lstar / 903.2962962962963d;
        }
        if (cubeExceedEpsilon) {
            z10 = fy * fy * fy;
        } else {
            z10 = lstar / 903.2962962962963d;
        }
        float[] whitePoint = WHITE_POINT_D65;
        return argbFromXyz(x10 * whitePoint[0], y10 * whitePoint[1], z10 * whitePoint[2]);
    }

    public static int argbFromXyz(double x10, double y10, double z10) {
        double[][] matrix = XYZ_TO_SRGB;
        double linearR = (matrix[0][0] * x10) + (matrix[0][1] * y10) + (matrix[0][2] * z10);
        double linearG = (matrix[1][0] * x10) + (matrix[1][1] * y10) + (matrix[1][2] * z10);
        double linearB = (matrix[2][0] * x10) + (matrix[2][1] * y10) + (matrix[2][2] * z10);
        int r10 = delinearized(linearR);
        int g3 = delinearized(linearG);
        int b4 = delinearized(linearB);
        return argbFromRgb(r10, g3, b4);
    }

    public static int argbFromLinrgb(double[] linrgb) {
        int r10 = delinearized(linrgb[0]);
        int g3 = delinearized(linrgb[1]);
        int b4 = delinearized(linrgb[2]);
        return argbFromRgb(r10, g3, b4);
    }

    public static int argbFromLinrgbComponents(double r10, double g3, double b4) {
        return argbFromRgb(delinearized(r10), delinearized(g3), delinearized(b4));
    }

    public static int delinearized(double rgbComponent) {
        double delinearized;
        double normalized = rgbComponent / 100.0d;
        if (normalized <= 0.0031308d) {
            delinearized = 12.92d * normalized;
        } else {
            delinearized = (Math.pow(normalized, 0.4166666666666667d) * 1.055d) - 0.055d;
        }
        return clampInt(0, 255, (int) Math.round(255.0d * delinearized));
    }

    public static int clampInt(int min, int max, int input) {
        if (input < min) {
            return min;
        }
        if (input > max) {
            return max;
        }
        return input;
    }

    public static int argbFromRgb(int red, int green, int blue) {
        return ((red & 255) << 16) | (-16777216) | ((green & 255) << 8) | (blue & 255);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int intFromLstar(float lstar) {
        float xT;
        float zT;
        if (lstar < 1.0f) {
            return -16777216;
        }
        if (lstar > 99.0f) {
            return -1;
        }
        float fy = (lstar + 16.0f) / 116.0f;
        boolean lExceedsEpsilonKappa = lstar > 8.0f;
        float yT = lExceedsEpsilonKappa ? fy * fy * fy : lstar / 903.2963f;
        boolean cubeExceedEpsilon = (fy * fy) * fy > 0.008856452f;
        if (cubeExceedEpsilon) {
            xT = fy * fy * fy;
        } else {
            xT = ((fy * 116.0f) - 16.0f) / 903.2963f;
        }
        if (cubeExceedEpsilon) {
            zT = fy * fy * fy;
        } else {
            zT = ((116.0f * fy) - 16.0f) / 903.2963f;
        }
        float[] fArr = WHITE_POINT_D65;
        return ColorUtils.XYZToColor(fArr[0] * xT, fArr[1] * yT, fArr[2] * zT);
    }

    public static float lstarFromInt(int argb) {
        return lstarFromY(yFromInt(argb));
    }

    static float lstarFromY(float y10) {
        float y11 = y10 / 100.0f;
        if (y11 <= 0.008856452f) {
            return 903.2963f * y11;
        }
        float yIntermediate = (float) Math.cbrt(y11);
        return (116.0f * yIntermediate) - 16.0f;
    }

    static float yFromInt(int argb) {
        float r10 = linearized(Color.red(argb));
        float g3 = linearized(Color.green(argb));
        float b4 = linearized(Color.blue(argb));
        double[][] matrix = SRGB_TO_XYZ;
        double y10 = (r10 * matrix[1][0]) + (g3 * matrix[1][1]) + (b4 * matrix[1][2]);
        return (float) y10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float[] xyzFromInt(int argb) {
        float r10 = linearized(Color.red(argb));
        float g3 = linearized(Color.green(argb));
        float b4 = linearized(Color.blue(argb));
        double[][] matrix = SRGB_TO_XYZ;
        double x10 = (r10 * matrix[0][0]) + (g3 * matrix[0][1]) + (b4 * matrix[0][2]);
        double y10 = (r10 * matrix[1][0]) + (g3 * matrix[1][1]) + (b4 * matrix[1][2]);
        double z10 = (r10 * matrix[2][0]) + (g3 * matrix[2][1]) + (b4 * matrix[2][2]);
        return new float[]{(float) x10, (float) y10, (float) z10};
    }

    public static double yFromLstar(double lstar) {
        if (lstar > 8.0d) {
            return Math.pow((16.0d + lstar) / 116.0d, 3.0d) * 100.0d;
        }
        return (lstar / 903.2962962962963d) * 100.0d;
    }

    static float linearized(int rgbComponent) {
        float normalized = rgbComponent / 255.0f;
        if (normalized <= 0.04045f) {
            return (normalized / 12.92f) * 100.0f;
        }
        return ((float) Math.pow((0.055f + normalized) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }
}
