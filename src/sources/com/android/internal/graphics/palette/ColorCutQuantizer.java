package com.android.internal.graphics.palette;

import android.graphics.Color;
import android.util.TimingLogger;
import com.android.internal.graphics.palette.Palette;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class ColorCutQuantizer implements Quantizer {
    static final int COMPONENT_BLUE = -1;
    static final int COMPONENT_GREEN = -2;
    static final int COMPONENT_RED = -3;
    private static final String LOG_TAG = "ColorCutQuantizer";
    private static final boolean LOG_TIMINGS = false;
    private static final int QUANTIZE_WORD_MASK = 31;
    private static final int QUANTIZE_WORD_WIDTH = 5;
    private static final Comparator<Vbox> VBOX_COMPARATOR_VOLUME = new Comparator<Vbox>() { // from class: com.android.internal.graphics.palette.ColorCutQuantizer.1
        @Override // java.util.Comparator
        public int compare(Vbox lhs, Vbox rhs) {
            return rhs.getVolume() - lhs.getVolume();
        }
    };
    int[] mColors;
    int[] mHistogram;
    List<Palette.Swatch> mQuantizedColors;
    private final float[] mTempHsl = new float[3];
    TimingLogger mTimingLogger;

    @Override // com.android.internal.graphics.palette.Quantizer
    public void quantize(int[] pixels, int maxColors) {
        this.mTimingLogger = null;
        int[] hist = new int[32768];
        this.mHistogram = hist;
        for (int i10 = 0; i10 < pixels.length; i10++) {
            int quantizedColor = quantizeFromRgb888(pixels[i10]);
            pixels[i10] = quantizedColor;
            hist[quantizedColor] = hist[quantizedColor] + 1;
        }
        int distinctColorCount = 0;
        for (int i11 : hist) {
            if (i11 > 0) {
                distinctColorCount++;
            }
        }
        int[] colors = new int[distinctColorCount];
        this.mColors = colors;
        int distinctColorIndex = 0;
        for (int color = 0; color < hist.length; color++) {
            if (hist[color] > 0) {
                colors[distinctColorIndex] = color;
                distinctColorIndex++;
            }
        }
        if (distinctColorCount <= maxColors) {
            this.mQuantizedColors = new ArrayList();
            for (int color2 : colors) {
                this.mQuantizedColors.add(new Palette.Swatch(approximateToRgb888(color2), hist[color2]));
            }
            return;
        }
        this.mQuantizedColors = quantizePixels(maxColors);
    }

    @Override // com.android.internal.graphics.palette.Quantizer
    public List<Palette.Swatch> getQuantizedColors() {
        return this.mQuantizedColors;
    }

    private List<Palette.Swatch> quantizePixels(int maxColors) {
        PriorityQueue<Vbox> pq = new PriorityQueue<>(maxColors, VBOX_COMPARATOR_VOLUME);
        pq.offer(new Vbox(0, this.mColors.length - 1));
        splitBoxes(pq, maxColors);
        return generateAverageColors(pq);
    }

    private void splitBoxes(PriorityQueue<Vbox> queue, int maxSize) {
        Vbox vbox;
        while (queue.size() < maxSize && (vbox = queue.poll()) != null && vbox.canSplit()) {
            queue.offer(vbox.splitBox());
            queue.offer(vbox);
        }
    }

    private List<Palette.Swatch> generateAverageColors(Collection<Vbox> vboxes) {
        ArrayList<Palette.Swatch> colors = new ArrayList<>(vboxes.size());
        for (Vbox vbox : vboxes) {
            Palette.Swatch swatch = vbox.getAverageColor();
            colors.add(swatch);
        }
        return colors;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class Vbox {
        private final int mLowerIndex;
        private int mMaxBlue;
        private int mMaxGreen;
        private int mMaxRed;
        private int mMinBlue;
        private int mMinGreen;
        private int mMinRed;
        private int mPopulation;
        private int mUpperIndex;

        Vbox(int lowerIndex, int upperIndex) {
            this.mLowerIndex = lowerIndex;
            this.mUpperIndex = upperIndex;
            fitBox();
        }

        final int getVolume() {
            return ((this.mMaxRed - this.mMinRed) + 1) * ((this.mMaxGreen - this.mMinGreen) + 1) * ((this.mMaxBlue - this.mMinBlue) + 1);
        }

        final boolean canSplit() {
            return getColorCount() > 1;
        }

        final int getColorCount() {
            return (this.mUpperIndex + 1) - this.mLowerIndex;
        }

        final void fitBox() {
            int[] colors = ColorCutQuantizer.this.mColors;
            int[] hist = ColorCutQuantizer.this.mHistogram;
            int minRed = Integer.MAX_VALUE;
            int minBlue = Integer.MAX_VALUE;
            int minGreen = Integer.MAX_VALUE;
            int maxRed = Integer.MIN_VALUE;
            int maxBlue = Integer.MIN_VALUE;
            int maxGreen = Integer.MIN_VALUE;
            int count = 0;
            for (int i10 = this.mLowerIndex; i10 <= this.mUpperIndex; i10++) {
                int color = colors[i10];
                count += hist[color];
                int r10 = ColorCutQuantizer.quantizedRed(color);
                int g3 = ColorCutQuantizer.quantizedGreen(color);
                int b4 = ColorCutQuantizer.quantizedBlue(color);
                if (r10 > maxRed) {
                    maxRed = r10;
                }
                if (r10 < minRed) {
                    minRed = r10;
                }
                if (g3 > maxGreen) {
                    maxGreen = g3;
                }
                if (g3 < minGreen) {
                    minGreen = g3;
                }
                if (b4 > maxBlue) {
                    maxBlue = b4;
                }
                if (b4 < minBlue) {
                    minBlue = b4;
                }
            }
            this.mMinRed = minRed;
            this.mMaxRed = maxRed;
            this.mMinGreen = minGreen;
            this.mMaxGreen = maxGreen;
            this.mMinBlue = minBlue;
            this.mMaxBlue = maxBlue;
            this.mPopulation = count;
        }

        final Vbox splitBox() {
            if (!canSplit()) {
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
            int splitPoint = findSplitPoint();
            Vbox newBox = new Vbox(splitPoint + 1, this.mUpperIndex);
            this.mUpperIndex = splitPoint;
            fitBox();
            return newBox;
        }

        final int getLongestColorDimension() {
            int redLength = this.mMaxRed - this.mMinRed;
            int greenLength = this.mMaxGreen - this.mMinGreen;
            int blueLength = this.mMaxBlue - this.mMinBlue;
            if (redLength >= greenLength && redLength >= blueLength) {
                return -3;
            }
            if (greenLength >= redLength && greenLength >= blueLength) {
                return -2;
            }
            return -1;
        }

        final int findSplitPoint() {
            int longestDimension = getLongestColorDimension();
            int[] colors = ColorCutQuantizer.this.mColors;
            int[] hist = ColorCutQuantizer.this.mHistogram;
            ColorCutQuantizer.modifySignificantOctet(colors, longestDimension, this.mLowerIndex, this.mUpperIndex);
            Arrays.sort(colors, this.mLowerIndex, this.mUpperIndex + 1);
            ColorCutQuantizer.modifySignificantOctet(colors, longestDimension, this.mLowerIndex, this.mUpperIndex);
            int midPoint = this.mPopulation / 2;
            int i10 = this.mLowerIndex;
            int count = 0;
            while (true) {
                int i11 = this.mUpperIndex;
                if (i10 <= i11) {
                    count += hist[colors[i10]];
                    if (count < midPoint) {
                        i10++;
                    } else {
                        return Math.min(i11 - 1, i10);
                    }
                } else {
                    int i12 = this.mLowerIndex;
                    return i12;
                }
            }
        }

        final Palette.Swatch getAverageColor() {
            int[] colors = ColorCutQuantizer.this.mColors;
            int[] hist = ColorCutQuantizer.this.mHistogram;
            int redSum = 0;
            int greenSum = 0;
            int blueSum = 0;
            int totalPopulation = 0;
            for (int i10 = this.mLowerIndex; i10 <= this.mUpperIndex; i10++) {
                int color = colors[i10];
                int colorPopulation = hist[color];
                totalPopulation += colorPopulation;
                redSum += ColorCutQuantizer.quantizedRed(color) * colorPopulation;
                greenSum += ColorCutQuantizer.quantizedGreen(color) * colorPopulation;
                blueSum += ColorCutQuantizer.quantizedBlue(color) * colorPopulation;
            }
            int redMean = Math.round(redSum / totalPopulation);
            int greenMean = Math.round(greenSum / totalPopulation);
            int blueMean = Math.round(blueSum / totalPopulation);
            return new Palette.Swatch(ColorCutQuantizer.approximateToRgb888(redMean, greenMean, blueMean), totalPopulation);
        }
    }

    static void modifySignificantOctet(int[] a10, int dimension, int lower, int upper) {
        switch (dimension) {
            case -3:
            default:
                return;
            case -2:
                for (int i10 = lower; i10 <= upper; i10++) {
                    int color = a10[i10];
                    a10[i10] = (quantizedGreen(color) << 10) | (quantizedRed(color) << 5) | quantizedBlue(color);
                }
                return;
            case -1:
                for (int i11 = lower; i11 <= upper; i11++) {
                    int color2 = a10[i11];
                    a10[i11] = (quantizedBlue(color2) << 10) | (quantizedGreen(color2) << 5) | quantizedRed(color2);
                }
                return;
        }
    }

    private static int quantizeFromRgb888(int color) {
        int r10 = modifyWordWidth(Color.red(color), 8, 5);
        int g3 = modifyWordWidth(Color.green(color), 8, 5);
        int b4 = modifyWordWidth(Color.blue(color), 8, 5);
        return (r10 << 10) | (g3 << 5) | b4;
    }

    static int approximateToRgb888(int r10, int g3, int b4) {
        return Color.rgb(modifyWordWidth(r10, 5, 8), modifyWordWidth(g3, 5, 8), modifyWordWidth(b4, 5, 8));
    }

    private static int approximateToRgb888(int color) {
        return approximateToRgb888(quantizedRed(color), quantizedGreen(color), quantizedBlue(color));
    }

    static int quantizedRed(int color) {
        return (color >> 10) & 31;
    }

    static int quantizedGreen(int color) {
        return (color >> 5) & 31;
    }

    static int quantizedBlue(int color) {
        return color & 31;
    }

    private static int modifyWordWidth(int value, int currentWidth, int targetWidth) {
        int newValue;
        if (targetWidth > currentWidth) {
            newValue = value << (targetWidth - currentWidth);
        } else {
            int newValue2 = currentWidth - targetWidth;
            newValue = value >> newValue2;
        }
        return newValue & ((1 << targetWidth) - 1);
    }
}
