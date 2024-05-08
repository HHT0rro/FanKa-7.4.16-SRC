package com.android.internal.graphics;

import android.graphics.Color;
import com.android.internal.graphics.cam.Cam;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface ContrastCalculator {
        double calculateContrast(int i10, int i11, int i12);
    }

    private ColorUtils() {
    }

    public static int compositeColors(int foreground, int background) {
        int bgAlpha = Color.alpha(background);
        int fgAlpha = Color.alpha(foreground);
        int a10 = compositeAlpha(fgAlpha, bgAlpha);
        int r10 = compositeComponent(Color.red(foreground), fgAlpha, Color.red(background), bgAlpha, a10);
        int g3 = compositeComponent(Color.green(foreground), fgAlpha, Color.green(background), bgAlpha, a10);
        int b4 = compositeComponent(Color.blue(foreground), fgAlpha, Color.blue(background), bgAlpha, a10);
        return Color.argb(a10, r10, g3, b4);
    }

    public static int compositeAlpha(int foregroundAlpha, int backgroundAlpha) {
        return 255 - (((255 - backgroundAlpha) * (255 - foregroundAlpha)) / 255);
    }

    private static int compositeComponent(int fgC, int fgA, int bgC, int bgA, int a10) {
        if (a10 == 0) {
            return 0;
        }
        return (((fgC * 255) * fgA) + ((bgC * bgA) * (255 - fgA))) / (a10 * 255);
    }

    public static double calculateLuminance(int color) {
        double[] result = getTempDouble3Array();
        colorToXYZ(color, result);
        return result[1] / XYZ_WHITE_REFERENCE_Y;
    }

    public static double calculateContrast(int foreground, int background) {
        if (Color.alpha(background) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(background));
        }
        if (Color.alpha(foreground) < 255) {
            foreground = compositeColors(foreground, background);
        }
        double luminance1 = calculateLuminance(foreground) + 0.05d;
        double luminance2 = calculateLuminance(background) + 0.05d;
        return Math.max(luminance1, luminance2) / Math.min(luminance1, luminance2);
    }

    public static int calculateMinimumBackgroundAlpha(int foreground, int background, float minContrastRatio) {
        int background2 = setAlphaComponent(background, 255);
        final int leastContrastyColor = setAlphaComponent(foreground, 255);
        return binaryAlphaSearch(foreground, background2, minContrastRatio, new ContrastCalculator() { // from class: com.android.internal.graphics.ColorUtils$$ExternalSyntheticLambda0
            @Override // com.android.internal.graphics.ColorUtils.ContrastCalculator
            public final double calculateContrast(int i10, int i11, int i12) {
                return ColorUtils.lambda$calculateMinimumBackgroundAlpha$0(leastContrastyColor, i10, i11, i12);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ double lambda$calculateMinimumBackgroundAlpha$0(int leastContrastyColor, int fg, int bg, int alpha) {
        int testBackground = blendARGB(leastContrastyColor, bg, alpha / 255.0f);
        return calculateContrast(fg, setAlphaComponent(testBackground, 255));
    }

    public static int calculateMinimumAlpha(int foreground, int background, float minContrastRatio) {
        if (Color.alpha(background) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(background));
        }
        ContrastCalculator contrastCalculator = new ContrastCalculator() { // from class: com.android.internal.graphics.ColorUtils$$ExternalSyntheticLambda1
            @Override // com.android.internal.graphics.ColorUtils.ContrastCalculator
            public final double calculateContrast(int i10, int i11, int i12) {
                return ColorUtils.lambda$calculateMinimumAlpha$1(i10, i11, i12);
            }
        };
        double testRatio = contrastCalculator.calculateContrast(foreground, background, 255);
        if (testRatio < minContrastRatio) {
            return -1;
        }
        return binaryAlphaSearch(setAlphaComponent(foreground, 255), background, minContrastRatio, contrastCalculator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ double lambda$calculateMinimumAlpha$1(int fg, int bg, int alpha) {
        int testForeground = setAlphaComponent(fg, alpha);
        return calculateContrast(testForeground, bg);
    }

    private static int binaryAlphaSearch(int foreground, int background, float minContrastRatio, ContrastCalculator calculator) {
        int minAlpha = 0;
        int maxAlpha = 255;
        for (int numIterations = 0; numIterations <= 10 && maxAlpha - minAlpha > 1; numIterations++) {
            int testAlpha = (minAlpha + maxAlpha) / 2;
            double testRatio = calculator.calculateContrast(foreground, background, testAlpha);
            if (testRatio < minContrastRatio) {
                minAlpha = testAlpha;
            } else {
                maxAlpha = testAlpha;
            }
        }
        return maxAlpha;
    }

    public static void RGBToHSL(int r10, int g3, int b4, float[] outHsl) {
        float h10;
        float s2;
        float rf = r10 / 255.0f;
        float gf = g3 / 255.0f;
        float bf = b4 / 255.0f;
        float max = Math.max(rf, Math.max(gf, bf));
        float min = Math.min(rf, Math.min(gf, bf));
        float deltaMaxMin = max - min;
        float l10 = (max + min) / 2.0f;
        if (max == min) {
            s2 = 0.0f;
            h10 = 0.0f;
        } else {
            if (max == rf) {
                h10 = ((gf - bf) / deltaMaxMin) % 6.0f;
            } else if (max == gf) {
                h10 = ((bf - rf) / deltaMaxMin) + 2.0f;
            } else {
                float h11 = rf - gf;
                h10 = (h11 / deltaMaxMin) + 4.0f;
            }
            s2 = deltaMaxMin / (1.0f - Math.abs((2.0f * l10) - 1.0f));
        }
        float h12 = (60.0f * h10) % 360.0f;
        if (h12 < 0.0f) {
            h12 += 360.0f;
        }
        outHsl[0] = constrain(h12, 0.0f, 360.0f);
        outHsl[1] = constrain(s2, 0.0f, 1.0f);
        outHsl[2] = constrain(l10, 0.0f, 1.0f);
    }

    public static void colorToHSL(int color, float[] outHsl) {
        RGBToHSL(Color.red(color), Color.green(color), Color.blue(color), outHsl);
    }

    public static int HSLToColor(float[] hsl) {
        float h10 = hsl[0];
        float s2 = hsl[1];
        float l10 = hsl[2];
        float c4 = (1.0f - Math.abs((l10 * 2.0f) - 1.0f)) * s2;
        float m10 = l10 - (0.5f * c4);
        float x10 = (1.0f - Math.abs(((h10 / 60.0f) % 2.0f) - 1.0f)) * c4;
        int hueSegment = ((int) h10) / 60;
        int r10 = 0;
        int g3 = 0;
        int b4 = 0;
        switch (hueSegment) {
            case 0:
                r10 = Math.round((c4 + m10) * 255.0f);
                g3 = Math.round((x10 + m10) * 255.0f);
                b4 = Math.round(255.0f * m10);
                break;
            case 1:
                r10 = Math.round((x10 + m10) * 255.0f);
                g3 = Math.round((c4 + m10) * 255.0f);
                b4 = Math.round(255.0f * m10);
                break;
            case 2:
                r10 = Math.round(m10 * 255.0f);
                g3 = Math.round((c4 + m10) * 255.0f);
                b4 = Math.round((x10 + m10) * 255.0f);
                break;
            case 3:
                r10 = Math.round(m10 * 255.0f);
                g3 = Math.round((x10 + m10) * 255.0f);
                b4 = Math.round((c4 + m10) * 255.0f);
                break;
            case 4:
                r10 = Math.round((x10 + m10) * 255.0f);
                g3 = Math.round(m10 * 255.0f);
                b4 = Math.round((c4 + m10) * 255.0f);
                break;
            case 5:
            case 6:
                r10 = Math.round((c4 + m10) * 255.0f);
                g3 = Math.round(m10 * 255.0f);
                b4 = Math.round((x10 + m10) * 255.0f);
                break;
        }
        return Color.rgb(constrain(r10, 0, 255), constrain(g3, 0, 255), constrain(b4, 0, 255));
    }

    public static Cam colorToCAM(int color) {
        return Cam.fromInt(color);
    }

    public static int CAMToColor(float hue, float chroma, float lstar) {
        return Cam.getInt(hue, chroma, lstar);
    }

    public static int setAlphaComponent(int color, int alpha) {
        if (alpha < 0 || alpha > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (16777215 & color) | (alpha << 24);
    }

    public static void colorToLAB(int color, double[] outLab) {
        RGBToLAB(Color.red(color), Color.green(color), Color.blue(color), outLab);
    }

    public static void RGBToLAB(int r10, int g3, int b4, double[] outLab) {
        RGBToXYZ(r10, g3, b4, outLab);
        XYZToLAB(outLab[0], outLab[1], outLab[2], outLab);
    }

    public static void colorToXYZ(int color, double[] outXyz) {
        RGBToXYZ(Color.red(color), Color.green(color), Color.blue(color), outXyz);
    }

    public static void RGBToXYZ(int r10, int g3, int b4, double[] outXyz) {
        if (outXyz.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double sr = r10 / 255.0d;
        double sr2 = sr < 0.04045d ? sr / 12.92d : Math.pow((sr + 0.055d) / 1.055d, 2.4d);
        double sg = g3 / 255.0d;
        double sg2 = sg < 0.04045d ? sg / 12.92d : Math.pow((sg + 0.055d) / 1.055d, 2.4d);
        double sb2 = b4 / 255.0d;
        double sb3 = sb2 < 0.04045d ? sb2 / 12.92d : Math.pow((0.055d + sb2) / 1.055d, 2.4d);
        outXyz[0] = ((0.4124d * sr2) + (0.3576d * sg2) + (0.1805d * sb3)) * XYZ_WHITE_REFERENCE_Y;
        outXyz[1] = ((0.2126d * sr2) + (0.7152d * sg2) + (0.0722d * sb3)) * XYZ_WHITE_REFERENCE_Y;
        outXyz[2] = ((0.0193d * sr2) + (0.1192d * sg2) + (0.9505d * sb3)) * XYZ_WHITE_REFERENCE_Y;
    }

    public static void XYZToLAB(double x10, double y10, double z10, double[] outLab) {
        if (outLab.length != 3) {
            throw new IllegalArgumentException("outLab must have a length of 3.");
        }
        double x11 = pivotXyzComponent(x10 / XYZ_WHITE_REFERENCE_X);
        double y11 = pivotXyzComponent(y10 / XYZ_WHITE_REFERENCE_Y);
        double z11 = pivotXyzComponent(z10 / XYZ_WHITE_REFERENCE_Z);
        outLab[0] = Math.max(ShadowDrawableWrapper.COS_45, (116.0d * y11) - 16.0d);
        outLab[1] = (x11 - y11) * 500.0d;
        outLab[2] = (y11 - z11) * 200.0d;
    }

    public static void LABToXYZ(double l10, double a10, double b4, double[] outXyz) {
        double fy = (l10 + 16.0d) / 116.0d;
        double fx = (a10 / 500.0d) + fy;
        double fz = fy - (b4 / 200.0d);
        double tmp = Math.pow(fx, 3.0d);
        double xr = tmp > XYZ_EPSILON ? tmp : ((fx * 116.0d) - 16.0d) / XYZ_KAPPA;
        double yr = l10 > 7.9996247999999985d ? Math.pow(fy, 3.0d) : l10 / XYZ_KAPPA;
        double tmp2 = Math.pow(fz, 3.0d);
        double zr = tmp2 > XYZ_EPSILON ? tmp2 : ((116.0d * fz) - 16.0d) / XYZ_KAPPA;
        outXyz[0] = XYZ_WHITE_REFERENCE_X * xr;
        outXyz[1] = XYZ_WHITE_REFERENCE_Y * yr;
        outXyz[2] = XYZ_WHITE_REFERENCE_Z * zr;
    }

    public static int XYZToColor(double x10, double y10, double z10) {
        double r10 = (((3.2406d * x10) + ((-1.5372d) * y10)) + ((-0.4986d) * z10)) / XYZ_WHITE_REFERENCE_Y;
        double g3 = ((((-0.9689d) * x10) + (1.8758d * y10)) + (0.0415d * z10)) / XYZ_WHITE_REFERENCE_Y;
        double b4 = (((0.0557d * x10) + ((-0.204d) * y10)) + (1.057d * z10)) / XYZ_WHITE_REFERENCE_Y;
        return Color.rgb(constrain((int) Math.round((r10 > 0.0031308d ? (Math.pow(r10, 0.4166666666666667d) * 1.055d) - 0.055d : r10 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((g3 > 0.0031308d ? (Math.pow(g3, 0.4166666666666667d) * 1.055d) - 0.055d : g3 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round(255.0d * (b4 > 0.0031308d ? (Math.pow(b4, 0.4166666666666667d) * 1.055d) - 0.055d : b4 * 12.92d)), 0, 255));
    }

    public static int LABToColor(double l10, double a10, double b4) {
        double[] result = getTempDouble3Array();
        LABToXYZ(l10, a10, b4, result);
        return XYZToColor(result[0], result[1], result[2]);
    }

    public static double distanceEuclidean(double[] labX, double[] labY) {
        return Math.sqrt(Math.pow(labX[0] - labY[0], 2.0d) + Math.pow(labX[1] - labY[1], 2.0d) + Math.pow(labX[2] - labY[2], 2.0d));
    }

    private static float constrain(float amount, float low, float high) {
        return amount < low ? low : amount > high ? high : amount;
    }

    private static int constrain(int amount, int low, int high) {
        return amount < low ? low : amount > high ? high : amount;
    }

    private static double pivotXyzComponent(double component) {
        if (component > XYZ_EPSILON) {
            return Math.pow(component, 0.3333333333333333d);
        }
        return ((XYZ_KAPPA * component) + 16.0d) / 116.0d;
    }

    public static int blendARGB(int color1, int color2, float ratio) {
        float inverseRatio = 1.0f - ratio;
        float a10 = (Color.alpha(color1) * inverseRatio) + (Color.alpha(color2) * ratio);
        float r10 = (Color.red(color1) * inverseRatio) + (Color.red(color2) * ratio);
        float g3 = (Color.green(color1) * inverseRatio) + (Color.green(color2) * ratio);
        float b4 = (Color.blue(color1) * inverseRatio) + (Color.blue(color2) * ratio);
        return Color.argb((int) a10, (int) r10, (int) g3, (int) b4);
    }

    public static void blendHSL(float[] hsl1, float[] hsl2, float ratio, float[] outResult) {
        if (outResult.length != 3) {
            throw new IllegalArgumentException("result must have a length of 3.");
        }
        float inverseRatio = 1.0f - ratio;
        outResult[0] = circularInterpolate(hsl1[0], hsl2[0], ratio);
        outResult[1] = (hsl1[1] * inverseRatio) + (hsl2[1] * ratio);
        outResult[2] = (hsl1[2] * inverseRatio) + (hsl2[2] * ratio);
    }

    public static void blendLAB(double[] lab1, double[] lab2, double ratio, double[] outResult) {
        if (outResult.length != 3) {
            throw new IllegalArgumentException("outResult must have a length of 3.");
        }
        double inverseRatio = 1.0d - ratio;
        outResult[0] = (lab1[0] * inverseRatio) + (lab2[0] * ratio);
        outResult[1] = (lab1[1] * inverseRatio) + (lab2[1] * ratio);
        outResult[2] = (lab1[2] * inverseRatio) + (lab2[2] * ratio);
    }

    static float circularInterpolate(float a10, float b4, float f10) {
        if (Math.abs(b4 - a10) > 180.0f) {
            if (b4 > a10) {
                a10 += 360.0f;
            } else {
                b4 += 360.0f;
            }
        }
        return (((b4 - a10) * f10) + a10) % 360.0f;
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal<double[]> threadLocal = TEMP_ARRAY;
        double[] result = threadLocal.get();
        if (result == null) {
            double[] result2 = new double[3];
            threadLocal.set(result2);
            return result2;
        }
        return result;
    }
}
