package com.android.internal.colorextraction.types;

import android.app.WallpaperColors;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.util.MathUtils;
import android.util.Range;
import com.android.internal.colorextraction.ColorExtractor;
import com.android.internal.graphics.ColorUtils;
import com.huawei.quickcard.base.Attributes;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class Tonal implements ExtractionType {
    private static final boolean DEBUG = true;
    private static final float FIT_WEIGHT_H = 1.0f;
    private static final float FIT_WEIGHT_L = 10.0f;
    private static final float FIT_WEIGHT_S = 1.0f;
    public static final int MAIN_COLOR_DARK = -14671580;
    public static final int MAIN_COLOR_LIGHT = -2433824;
    public static final int MAIN_COLOR_REGULAR = -16777216;
    private static final String TAG = "Tonal";
    private final Context mContext;
    private final TonalPalette mGreyPalette;
    private float[] mTmpHSL = new float[3];
    private final ArrayList<TonalPalette> mTonalPalettes;

    public Tonal(Context context) {
        ConfigParser parser = new ConfigParser(context);
        ArrayList<TonalPalette> tonalPalettes = parser.getTonalPalettes();
        this.mTonalPalettes = tonalPalettes;
        this.mContext = context;
        this.mGreyPalette = tonalPalettes.get(0);
        tonalPalettes.remove(0);
    }

    @Override // com.android.internal.colorextraction.types.ExtractionType
    public void extractInto(WallpaperColors inWallpaperColors, ColorExtractor.GradientColors outColorsNormal, ColorExtractor.GradientColors outColorsDark, ColorExtractor.GradientColors outColorsExtraDark) {
        boolean success = runTonalExtraction(inWallpaperColors, outColorsNormal, outColorsDark, outColorsExtraDark);
        if (!success) {
            applyFallback(inWallpaperColors, outColorsNormal, outColorsDark, outColorsExtraDark);
        }
    }

    private boolean runTonalExtraction(WallpaperColors inWallpaperColors, ColorExtractor.GradientColors outColorsNormal, ColorExtractor.GradientColors outColorsDark, ColorExtractor.GradientColors outColorsExtraDark) {
        int primaryIndex;
        int primaryIndex2;
        if (inWallpaperColors == null) {
            return false;
        }
        List<Color> mainColors = inWallpaperColors.getMainColors();
        int mainColorsSize = mainColors.size();
        int hints = inWallpaperColors.getColorHints();
        boolean supportsDarkText = (hints & 1) != 0;
        if (mainColorsSize == 0) {
            return false;
        }
        Color bestColor = mainColors.get(0);
        int colorValue = bestColor.toArgb();
        ColorUtils.RGBToHSL(Color.red(colorValue), Color.green(colorValue), Color.blue(colorValue), hsl);
        float[] hsl = {hsl[0] / 360.0f};
        TonalPalette palette = findTonalPalette(hsl[0], hsl[1]);
        if (palette == null) {
            Log.w(TAG, "Could not find a tonal palette!");
            return false;
        }
        int fitIndex = bestFit(palette, hsl[0], hsl[1], hsl[2]);
        if (fitIndex == -1) {
            Log.w(TAG, "Could not find best fit!");
            return false;
        }
        float[] h10 = fit(palette.f9150h, hsl[0], fitIndex, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY);
        float[] s2 = fit(palette.f9152s, hsl[1], fitIndex, 0.0f, 1.0f);
        float[] l10 = fit(palette.f9151l, hsl[2], fitIndex, 0.0f, 1.0f);
        int[] colorPalette = getColorPalette(h10, s2, l10);
        StringBuilder builder = new StringBuilder("Tonal Palette - index: " + fitIndex + ". Main color: " + Integer.toHexString(getColorInt(fitIndex, h10, s2, l10)) + "\nColors: ");
        for (int i10 = 0; i10 < h10.length; i10++) {
            builder.append(Integer.toHexString(getColorInt(i10, h10, s2, l10)));
            if (i10 < h10.length - 1) {
                builder.append(", ");
            }
        }
        Log.d(TAG, builder.toString());
        int mainColor = getColorInt(fitIndex, h10, s2, l10);
        ColorUtils.colorToHSL(mainColor, this.mTmpHSL);
        float[] fArr = this.mTmpHSL;
        float mainLuminosity = fArr[2];
        ColorUtils.colorToHSL(MAIN_COLOR_LIGHT, fArr);
        float[] fArr2 = this.mTmpHSL;
        float lightLuminosity = fArr2[2];
        if (mainLuminosity > lightLuminosity) {
            return false;
        }
        ColorUtils.colorToHSL(MAIN_COLOR_DARK, fArr2);
        float darkLuminosity = this.mTmpHSL[2];
        if (mainLuminosity < darkLuminosity) {
            return false;
        }
        outColorsNormal.setMainColor(mainColor);
        outColorsNormal.setSecondaryColor(mainColor);
        outColorsNormal.setColorPalette(colorPalette);
        if (supportsDarkText) {
            primaryIndex = h10.length - 1;
        } else if (fitIndex < 2) {
            primaryIndex = 0;
        } else {
            primaryIndex = Math.min(fitIndex, 3);
        }
        int mainColor2 = getColorInt(primaryIndex, h10, s2, l10);
        outColorsDark.setMainColor(mainColor2);
        outColorsDark.setSecondaryColor(mainColor2);
        outColorsDark.setColorPalette(colorPalette);
        if (supportsDarkText) {
            primaryIndex2 = h10.length - 1;
        } else if (fitIndex < 2) {
            primaryIndex2 = 0;
        } else {
            primaryIndex2 = 2;
        }
        int mainColor3 = getColorInt(primaryIndex2, h10, s2, l10);
        outColorsExtraDark.setMainColor(mainColor3);
        outColorsExtraDark.setSecondaryColor(mainColor3);
        outColorsExtraDark.setColorPalette(colorPalette);
        outColorsNormal.setSupportsDarkText(supportsDarkText);
        outColorsDark.setSupportsDarkText(supportsDarkText);
        outColorsExtraDark.setSupportsDarkText(supportsDarkText);
        Log.d(TAG, "Gradients: \n\tNormal " + ((Object) outColorsNormal) + "\n\tDark " + ((Object) outColorsDark) + "\n\tExtra dark: " + ((Object) outColorsExtraDark));
        return true;
    }

    private void applyFallback(WallpaperColors inWallpaperColors, ColorExtractor.GradientColors outColorsNormal, ColorExtractor.GradientColors outColorsDark, ColorExtractor.GradientColors outColorsExtraDark) {
        applyFallback(inWallpaperColors, outColorsNormal);
        applyFallback(inWallpaperColors, outColorsDark);
        applyFallback(inWallpaperColors, outColorsExtraDark);
    }

    public void applyFallback(WallpaperColors inWallpaperColors, ColorExtractor.GradientColors outGradientColors) {
        int color;
        boolean light = (inWallpaperColors == null || (inWallpaperColors.getColorHints() & 1) == 0) ? false : true;
        boolean dark = (inWallpaperColors == null || (inWallpaperColors.getColorHints() & 2) == 0) ? false : true;
        boolean inNightMode = (this.mContext.getResources().getConfiguration().uiMode & 48) == 32;
        if (light) {
            color = MAIN_COLOR_LIGHT;
        } else if (dark || inNightMode) {
            color = MAIN_COLOR_DARK;
        } else {
            color = -16777216;
        }
        float[] hsl = new float[3];
        ColorUtils.colorToHSL(color, hsl);
        outGradientColors.setMainColor(color);
        outGradientColors.setSecondaryColor(color);
        outGradientColors.setSupportsDarkText(light);
        outGradientColors.setColorPalette(getColorPalette(findTonalPalette(hsl[0], hsl[1])));
    }

    private int getColorInt(int fitIndex, float[] h10, float[] s2, float[] l10) {
        this.mTmpHSL[0] = fract(h10[fitIndex]) * 360.0f;
        float[] fArr = this.mTmpHSL;
        fArr[1] = s2[fitIndex];
        fArr[2] = l10[fitIndex];
        return ColorUtils.HSLToColor(fArr);
    }

    private int[] getColorPalette(float[] h10, float[] s2, float[] l10) {
        int[] colorPalette = new int[h10.length];
        for (int i10 = 0; i10 < colorPalette.length; i10++) {
            colorPalette[i10] = getColorInt(i10, h10, s2, l10);
        }
        return colorPalette;
    }

    private int[] getColorPalette(TonalPalette palette) {
        return getColorPalette(palette.f9150h, palette.f9152s, palette.f9151l);
    }

    private static float[] fit(float[] data, float v2, int index, float min, float max) {
        float[] fitData = new float[data.length];
        float delta = v2 - data[index];
        for (int i10 = 0; i10 < data.length; i10++) {
            fitData[i10] = MathUtils.constrain(data[i10] + delta, min, max);
        }
        return fitData;
    }

    private static int bestFit(TonalPalette palette, float h10, float s2, float l10) {
        int minErrorIndex = -1;
        float minError = Float.POSITIVE_INFINITY;
        for (int i10 = 0; i10 < palette.f9150h.length; i10++) {
            float error = (Math.abs(h10 - palette.f9150h[i10]) * 1.0f) + (Math.abs(s2 - palette.f9152s[i10]) * 1.0f) + (Math.abs(l10 - palette.f9151l[i10]) * FIT_WEIGHT_L);
            if (error < minError) {
                minError = error;
                minErrorIndex = i10;
            }
        }
        return minErrorIndex;
    }

    private TonalPalette findTonalPalette(float h10, float s2) {
        if (s2 < 0.05f) {
            return this.mGreyPalette;
        }
        TonalPalette best = null;
        float error = Float.POSITIVE_INFINITY;
        int tonalPalettesCount = this.mTonalPalettes.size();
        for (int i10 = 0; i10 < tonalPalettesCount; i10++) {
            TonalPalette candidate = this.mTonalPalettes.get(i10);
            if (h10 >= candidate.minHue && h10 <= candidate.maxHue) {
                return candidate;
            }
            if (candidate.maxHue > 1.0f && h10 >= 0.0f && h10 <= fract(candidate.maxHue)) {
                return candidate;
            }
            if (candidate.minHue >= 0.0f || h10 < fract(candidate.minHue) || h10 > 1.0f) {
                if (h10 <= candidate.minHue && candidate.minHue - h10 < error) {
                    best = candidate;
                    error = candidate.minHue - h10;
                } else {
                    float error2 = candidate.maxHue;
                    if (h10 >= error2 && h10 - candidate.maxHue < error) {
                        best = candidate;
                        error = h10 - candidate.maxHue;
                    } else if (candidate.maxHue > 1.0f && h10 >= fract(candidate.maxHue) && h10 - fract(candidate.maxHue) < error) {
                        best = candidate;
                        error = h10 - fract(candidate.maxHue);
                    } else if (candidate.minHue < 0.0f && h10 <= fract(candidate.minHue) && fract(candidate.minHue) - h10 < error) {
                        best = candidate;
                        error = fract(candidate.minHue) - h10;
                    }
                }
            } else {
                return candidate;
            }
        }
        return best;
    }

    private static float fract(float v2) {
        return v2 - ((float) Math.floor(v2));
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class TonalPalette {

        /* renamed from: h, reason: collision with root package name */
        public final float[] f9150h;

        /* renamed from: l, reason: collision with root package name */
        public final float[] f9151l;
        public final float maxHue;
        public final float minHue;

        /* renamed from: s, reason: collision with root package name */
        public final float[] f9152s;

        TonalPalette(float[] h10, float[] s2, float[] l10) {
            if (h10.length != s2.length || s2.length != l10.length) {
                throw new IllegalArgumentException("All arrays should have the same size. h: " + Arrays.toString(h10) + " s: " + Arrays.toString(s2) + " l: " + Arrays.toString(l10));
            }
            this.f9150h = h10;
            this.f9152s = s2;
            this.f9151l = l10;
            float minHue = Float.POSITIVE_INFINITY;
            float maxHue = Float.NEGATIVE_INFINITY;
            for (float v2 : h10) {
                minHue = Math.min(v2, minHue);
                maxHue = Math.max(v2, maxHue);
            }
            this.minHue = minHue;
            this.maxHue = maxHue;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class ColorRange {
        private Range<Float> mHue;
        private Range<Float> mLightness;
        private Range<Float> mSaturation;

        public ColorRange(Range<Float> hue, Range<Float> saturation, Range<Float> lightness) {
            this.mHue = hue;
            this.mSaturation = saturation;
            this.mLightness = lightness;
        }

        public boolean containsColor(float h10, float s2, float l10) {
            return this.mHue.contains((Range<Float>) Float.valueOf(h10)) && this.mSaturation.contains((Range<Float>) Float.valueOf(s2)) && this.mLightness.contains((Range<Float>) Float.valueOf(l10));
        }

        public float[] getCenter() {
            return new float[]{this.mHue.getLower().floatValue() + ((this.mHue.getUpper().floatValue() - this.mHue.getLower().floatValue()) / 2.0f), this.mSaturation.getLower().floatValue() + ((this.mSaturation.getUpper().floatValue() - this.mSaturation.getLower().floatValue()) / 2.0f), this.mLightness.getLower().floatValue() + ((this.mLightness.getUpper().floatValue() - this.mLightness.getLower().floatValue()) / 2.0f)};
        }

        public String toString() {
            return String.format("H: %s, S: %s, L %s", this.mHue, this.mSaturation, this.mLightness);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class ConfigParser {
        private final ArrayList<TonalPalette> mTonalPalettes = new ArrayList<>();

        public ConfigParser(Context context) {
            try {
                XmlPullParser parser = context.getResources().getXml(18284549);
                for (int eventType = parser.getEventType(); eventType != 1; eventType = parser.next()) {
                    if (eventType != 0 && eventType != 3) {
                        if (eventType == 2) {
                            String tagName = parser.getName();
                            if (tagName.equals("palettes")) {
                                parsePalettes(parser);
                            }
                        } else {
                            throw new XmlPullParserException("Invalid XML event " + eventType + " - " + parser.getName(), parser, null);
                        }
                    }
                }
            } catch (IOException | XmlPullParserException e2) {
                throw new RuntimeException(e2);
            }
        }

        public ArrayList<TonalPalette> getTonalPalettes() {
            return this.mTonalPalettes;
        }

        private ColorRange readRange(XmlPullParser parser) throws XmlPullParserException, IOException {
            parser.require(2, null, Attributes.Style.RANGE);
            float[] h10 = readFloatArray(parser.getAttributeValue(null, "h"));
            float[] s2 = readFloatArray(parser.getAttributeValue(null, t.f36222g));
            float[] l10 = readFloatArray(parser.getAttributeValue(null, "l"));
            if (h10 == null || s2 == null || l10 == null) {
                throw new XmlPullParserException("Incomplete range tag.", parser, null);
            }
            return new ColorRange(new Range(Float.valueOf(h10[0]), Float.valueOf(h10[1])), new Range(Float.valueOf(s2[0]), Float.valueOf(s2[1])), new Range(Float.valueOf(l10[0]), Float.valueOf(l10[1])));
        }

        private void parsePalettes(XmlPullParser parser) throws XmlPullParserException, IOException {
            parser.require(2, null, "palettes");
            while (parser.next() != 3) {
                if (parser.getEventType() == 2) {
                    String name = parser.getName();
                    if (name.equals("palette")) {
                        this.mTonalPalettes.add(readPalette(parser));
                        parser.next();
                    } else {
                        throw new XmlPullParserException("Invalid tag: " + name);
                    }
                }
            }
        }

        private TonalPalette readPalette(XmlPullParser parser) throws XmlPullParserException, IOException {
            parser.require(2, null, "palette");
            float[] h10 = readFloatArray(parser.getAttributeValue(null, "h"));
            float[] s2 = readFloatArray(parser.getAttributeValue(null, t.f36222g));
            float[] l10 = readFloatArray(parser.getAttributeValue(null, "l"));
            if (h10 == null || s2 == null || l10 == null) {
                throw new XmlPullParserException("Incomplete range tag.", parser, null);
            }
            return new TonalPalette(h10, s2, l10);
        }

        private float[] readFloatArray(String attributeValue) throws IOException, XmlPullParserException {
            String[] tokens = attributeValue.replaceAll(" ", "").replaceAll("\n", "").split(",");
            float[] numbers = new float[tokens.length];
            for (int i10 = 0; i10 < tokens.length; i10++) {
                numbers[i10] = Float.parseFloat(tokens[i10]);
            }
            return numbers;
        }
    }
}
