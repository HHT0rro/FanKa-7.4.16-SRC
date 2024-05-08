package com.android.internal.graphics.palette;

import android.graphics.Color;
import com.android.internal.graphics.palette.Palette;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class WuQuantizer implements Quantizer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BITS = 5;
    private static final int MAX_INDEX = 32;
    private static final int SIDE_LENGTH = 33;
    private static final int TOTAL_SIZE = 35937;
    private int[] mColors;
    private Box[] mCubes;
    private Map<Integer, Integer> mInputPixelToCount;
    private double[] mMoments;
    private int[] mMomentsB;
    private int[] mMomentsG;
    private int[] mMomentsR;
    private Palette mPalette;
    private int[] mWeights;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public enum Direction {
        RED,
        GREEN,
        BLUE
    }

    @Override // com.android.internal.graphics.palette.Quantizer
    public List<Palette.Swatch> getQuantizedColors() {
        return this.mPalette.getSwatches();
    }

    @Override // com.android.internal.graphics.palette.Quantizer
    public void quantize(int[] pixels, int colorCount) {
        QuantizerMap quantizerMap = new QuantizerMap();
        quantizerMap.quantize(pixels, colorCount);
        Map<Integer, Integer> colorToCount = quantizerMap.getColorToCount();
        this.mInputPixelToCount = colorToCount;
        Set<Integer> uniqueColors = colorToCount.h();
        if (uniqueColors.size() <= colorCount) {
            this.mColors = new int[this.mInputPixelToCount.h().size()];
            int index = 0;
            Iterator<Integer> iterator2 = uniqueColors.iterator2();
            while (iterator2.hasNext()) {
                int color = iterator2.next().intValue();
                this.mColors[index] = color;
                index++;
            }
        } else {
            constructHistogram(this.mInputPixelToCount);
            createMoments();
            CreateBoxesResult createBoxesResult = createBoxes(colorCount);
            this.mColors = createResult(createBoxesResult.mResultCount);
        }
        List<Palette.Swatch> swatches = new ArrayList<>();
        for (int color2 : this.mColors) {
            swatches.add(new Palette.Swatch(color2, 0));
        }
        this.mPalette = Palette.from(swatches);
    }

    public int[] getColors() {
        return this.mColors;
    }

    public Map<Integer, Integer> inputPixelToCount() {
        return this.mInputPixelToCount;
    }

    private static int getIndex(int r10, int g3, int b4) {
        return (r10 << 10) + (r10 << 6) + (g3 << 5) + r10 + g3 + b4;
    }

    private void constructHistogram(Map<Integer, Integer> pixels) {
        WuQuantizer wuQuantizer = this;
        wuQuantizer.mWeights = new int[TOTAL_SIZE];
        wuQuantizer.mMomentsR = new int[TOTAL_SIZE];
        wuQuantizer.mMomentsG = new int[TOTAL_SIZE];
        wuQuantizer.mMomentsB = new int[TOTAL_SIZE];
        wuQuantizer.mMoments = new double[TOTAL_SIZE];
        for (Iterator<Map.Entry<Integer, Integer>> iterator2 = pixels.entrySet().iterator2(); iterator2.hasNext(); iterator2 = iterator2) {
            Map.Entry<Integer, Integer> pair = iterator2.next();
            int pixel = pair.getKey().intValue();
            int count = pair.getValue().intValue();
            int red = Color.red(pixel);
            int green = Color.green(pixel);
            int blue = Color.blue(pixel);
            int iR = (red >> 3) + 1;
            int iG = (green >> 3) + 1;
            int iB = (blue >> 3) + 1;
            int index = getIndex(iR, iG, iB);
            int[] iArr = wuQuantizer.mWeights;
            iArr[index] = iArr[index] + count;
            int[] iArr2 = wuQuantizer.mMomentsR;
            iArr2[index] = iArr2[index] + (red * count);
            int[] iArr3 = wuQuantizer.mMomentsG;
            iArr3[index] = iArr3[index] + (green * count);
            int[] iArr4 = wuQuantizer.mMomentsB;
            iArr4[index] = iArr4[index] + (blue * count);
            double[] dArr = wuQuantizer.mMoments;
            dArr[index] = dArr[index] + (count * ((red * red) + (green * green) + (blue * blue)));
            wuQuantizer = this;
        }
    }

    private void createMoments() {
        int r10 = 1;
        while (true) {
            int i10 = 33;
            if (r10 < 33) {
                int[] area = new int[33];
                int[] areaR = new int[33];
                int[] areaG = new int[33];
                int[] areaB = new int[33];
                double[] area2 = new double[33];
                int g3 = 1;
                while (g3 < i10) {
                    int line = 0;
                    int lineR = 0;
                    int lineG = 0;
                    int lineB = 0;
                    double line2 = ShadowDrawableWrapper.COS_45;
                    int b4 = 1;
                    while (b4 < i10) {
                        int index = getIndex(r10, g3, b4);
                        int line3 = line + this.mWeights[index];
                        lineR += this.mMomentsR[index];
                        lineG += this.mMomentsG[index];
                        lineB += this.mMomentsB[index];
                        line2 += this.mMoments[index];
                        area[b4] = area[b4] + line3;
                        areaR[b4] = areaR[b4] + lineR;
                        areaG[b4] = areaG[b4] + lineG;
                        areaB[b4] = areaB[b4] + lineB;
                        area2[b4] = area2[b4] + line2;
                        int previousIndex = getIndex(r10 - 1, g3, b4);
                        int[] iArr = this.mWeights;
                        iArr[index] = iArr[previousIndex] + area[b4];
                        int[] iArr2 = this.mMomentsR;
                        iArr2[index] = iArr2[previousIndex] + areaR[b4];
                        int[] iArr3 = this.mMomentsG;
                        iArr3[index] = iArr3[previousIndex] + areaG[b4];
                        int[] iArr4 = this.mMomentsB;
                        iArr4[index] = iArr4[previousIndex] + areaB[b4];
                        double[] dArr = this.mMoments;
                        dArr[index] = dArr[previousIndex] + area2[b4];
                        b4++;
                        line = line3;
                        i10 = 33;
                    }
                    g3++;
                    i10 = 33;
                }
                r10++;
            } else {
                return;
            }
        }
    }

    private CreateBoxesResult createBoxes(int maxColorCount) {
        this.mCubes = new Box[maxColorCount];
        for (int i10 = 0; i10 < maxColorCount; i10++) {
            this.mCubes[i10] = new Box();
        }
        double[] volumeVariance = new double[maxColorCount];
        Box firstBox = this.mCubes[0];
        firstBox.f9158r1 = 32;
        firstBox.f9156g1 = 32;
        firstBox.f9154b1 = 32;
        int generatedColorCount = 0;
        int next = 0;
        int i11 = 1;
        while (i11 < maxColorCount) {
            Box[] boxArr = this.mCubes;
            if (cut(boxArr[next], boxArr[i11])) {
                volumeVariance[next] = this.mCubes[next].vol > 1 ? variance(this.mCubes[next]) : 0.0d;
                volumeVariance[i11] = this.mCubes[i11].vol > 1 ? variance(this.mCubes[i11]) : 0.0d;
            } else {
                volumeVariance[next] = 0.0d;
                i11--;
            }
            next = 0;
            double temp = volumeVariance[0];
            for (int k10 = 1; k10 <= i11; k10++) {
                if (volumeVariance[k10] > temp) {
                    temp = volumeVariance[k10];
                    next = k10;
                }
            }
            generatedColorCount = i11 + 1;
            if (temp <= ShadowDrawableWrapper.COS_45) {
                break;
            }
            i11++;
        }
        return new CreateBoxesResult(maxColorCount, generatedColorCount);
    }

    private int[] createResult(int colorCount) {
        int[] colors = new int[colorCount];
        int nextAvailableIndex = 0;
        for (int i10 = 0; i10 < colorCount; i10++) {
            Box cube = this.mCubes[i10];
            int weight = volume(cube, this.mWeights);
            if (weight > 0) {
                int r10 = volume(cube, this.mMomentsR) / weight;
                int g3 = volume(cube, this.mMomentsG) / weight;
                int b4 = volume(cube, this.mMomentsB) / weight;
                int color = Color.rgb(r10, g3, b4);
                colors[nextAvailableIndex] = color;
                nextAvailableIndex++;
            }
        }
        int[] resultArray = new int[nextAvailableIndex];
        System.arraycopy((Object) colors, 0, (Object) resultArray, 0, nextAvailableIndex);
        return resultArray;
    }

    private double variance(Box cube) {
        int dr = volume(cube, this.mMomentsR);
        int dg = volume(cube, this.mMomentsG);
        int db2 = volume(cube, this.mMomentsB);
        double xx = ((((((this.mMoments[getIndex(cube.f9158r1, cube.f9156g1, cube.f9154b1)] - this.mMoments[getIndex(cube.f9158r1, cube.f9156g1, cube.f9153b0)]) - this.mMoments[getIndex(cube.f9158r1, cube.f9155g0, cube.f9154b1)]) + this.mMoments[getIndex(cube.f9158r1, cube.f9155g0, cube.f9153b0)]) - this.mMoments[getIndex(cube.f9157r0, cube.f9156g1, cube.f9154b1)]) + this.mMoments[getIndex(cube.f9157r0, cube.f9156g1, cube.f9153b0)]) + this.mMoments[getIndex(cube.f9157r0, cube.f9155g0, cube.f9154b1)]) - this.mMoments[getIndex(cube.f9157r0, cube.f9155g0, cube.f9153b0)];
        int hypotenuse = (dr * dr) + (dg * dg) + (db2 * db2);
        int volume2 = volume(cube, this.mWeights);
        double variance2 = xx - (hypotenuse / volume2);
        return variance2;
    }

    private boolean cut(Box one, Box two) {
        Direction cutDirection;
        int wholeR = volume(one, this.mMomentsR);
        int wholeG = volume(one, this.mMomentsG);
        int wholeB = volume(one, this.mMomentsB);
        int wholeW = volume(one, this.mWeights);
        MaximizeResult maxRResult = maximize(one, Direction.RED, one.f9157r0 + 1, one.f9158r1, wholeR, wholeG, wholeB, wholeW);
        MaximizeResult maxGResult = maximize(one, Direction.GREEN, one.f9155g0 + 1, one.f9156g1, wholeR, wholeG, wholeB, wholeW);
        MaximizeResult maxBResult = maximize(one, Direction.BLUE, one.f9153b0 + 1, one.f9154b1, wholeR, wholeG, wholeB, wholeW);
        double maxR = maxRResult.mMaximum;
        double maxG = maxGResult.mMaximum;
        double maxB = maxBResult.mMaximum;
        if (maxR < maxG || maxR < maxB) {
            if (maxG >= maxR && maxG >= maxB) {
                cutDirection = Direction.GREEN;
            } else {
                cutDirection = Direction.BLUE;
            }
        } else {
            if (maxRResult.mCutLocation < 0) {
                return false;
            }
            cutDirection = Direction.RED;
        }
        two.f9158r1 = one.f9158r1;
        two.f9156g1 = one.f9156g1;
        two.f9154b1 = one.f9154b1;
        switch (AnonymousClass1.$SwitchMap$com$android$internal$graphics$palette$WuQuantizer$Direction[cutDirection.ordinal()]) {
            case 1:
                one.f9158r1 = maxRResult.mCutLocation;
                two.f9157r0 = one.f9158r1;
                two.f9155g0 = one.f9155g0;
                two.f9153b0 = one.f9153b0;
                break;
            case 2:
                one.f9156g1 = maxGResult.mCutLocation;
                two.f9157r0 = one.f9157r0;
                two.f9155g0 = one.f9156g1;
                two.f9153b0 = one.f9153b0;
                break;
            case 3:
                one.f9154b1 = maxBResult.mCutLocation;
                two.f9157r0 = one.f9157r0;
                two.f9155g0 = one.f9155g0;
                two.f9153b0 = one.f9154b1;
                break;
            default:
                throw new IllegalArgumentException("unexpected direction " + ((Object) cutDirection));
        }
        one.vol = (one.f9158r1 - one.f9157r0) * (one.f9156g1 - one.f9155g0) * (one.f9154b1 - one.f9153b0);
        two.vol = (two.f9158r1 - two.f9157r0) * (two.f9156g1 - two.f9155g0) * (two.f9154b1 - two.f9153b0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* renamed from: com.android.internal.graphics.palette.WuQuantizer$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$internal$graphics$palette$WuQuantizer$Direction;

        static {
            int[] iArr = new int[Direction.values().length];
            $SwitchMap$com$android$internal$graphics$palette$WuQuantizer$Direction = iArr;
            try {
                iArr[Direction.RED.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$android$internal$graphics$palette$WuQuantizer$Direction[Direction.GREEN.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$android$internal$graphics$palette$WuQuantizer$Direction[Direction.BLUE.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    private MaximizeResult maximize(Box cube, Direction direction, int first, int last, int wholeR, int wholeG, int wholeB, int wholeW) {
        int baseR;
        WuQuantizer wuQuantizer = this;
        Box box = cube;
        Direction direction2 = direction;
        int baseR2 = bottom(box, direction2, wuQuantizer.mMomentsR);
        int baseG = bottom(box, direction2, wuQuantizer.mMomentsG);
        int baseB = bottom(box, direction2, wuQuantizer.mMomentsB);
        int baseW = bottom(box, direction2, wuQuantizer.mWeights);
        double max = ShadowDrawableWrapper.COS_45;
        int cut = -1;
        int i10 = first;
        while (i10 < last) {
            int halfR = top(box, direction2, i10, wuQuantizer.mMomentsR) + baseR2;
            int halfG = top(box, direction2, i10, wuQuantizer.mMomentsG) + baseG;
            int halfB = top(box, direction2, i10, wuQuantizer.mMomentsB) + baseB;
            int halfW = top(box, direction2, i10, wuQuantizer.mWeights) + baseW;
            if (halfW == 0) {
                baseR = baseR2;
            } else {
                double tempNumerator = (halfR * halfR) + (halfG * halfG) + (halfB * halfB);
                baseR = baseR2;
                double tempDenominator = halfW;
                double temp = tempNumerator / tempDenominator;
                int halfR2 = wholeR - halfR;
                int halfG2 = wholeG - halfG;
                int halfB2 = wholeB - halfB;
                int halfW2 = wholeW - halfW;
                if (halfW2 != 0) {
                    double tempNumerator2 = (halfR2 * halfR2) + (halfG2 * halfG2) + (halfB2 * halfB2);
                    double tempDenominator2 = halfW2;
                    double temp2 = temp + (tempNumerator2 / tempDenominator2);
                    if (temp2 > max) {
                        max = temp2;
                        cut = i10;
                    }
                }
            }
            i10++;
            wuQuantizer = this;
            box = cube;
            direction2 = direction;
            baseR2 = baseR;
        }
        return new MaximizeResult(cut, max);
    }

    private static int volume(Box cube, int[] moment) {
        return ((((((moment[getIndex(cube.f9158r1, cube.f9156g1, cube.f9154b1)] - moment[getIndex(cube.f9158r1, cube.f9156g1, cube.f9153b0)]) - moment[getIndex(cube.f9158r1, cube.f9155g0, cube.f9154b1)]) + moment[getIndex(cube.f9158r1, cube.f9155g0, cube.f9153b0)]) - moment[getIndex(cube.f9157r0, cube.f9156g1, cube.f9154b1)]) + moment[getIndex(cube.f9157r0, cube.f9156g1, cube.f9153b0)]) + moment[getIndex(cube.f9157r0, cube.f9155g0, cube.f9154b1)]) - moment[getIndex(cube.f9157r0, cube.f9155g0, cube.f9153b0)];
    }

    private static int bottom(Box cube, Direction direction, int[] moment) {
        switch (AnonymousClass1.$SwitchMap$com$android$internal$graphics$palette$WuQuantizer$Direction[direction.ordinal()]) {
            case 1:
                return (((-moment[getIndex(cube.f9157r0, cube.f9156g1, cube.f9154b1)]) + moment[getIndex(cube.f9157r0, cube.f9156g1, cube.f9153b0)]) + moment[getIndex(cube.f9157r0, cube.f9155g0, cube.f9154b1)]) - moment[getIndex(cube.f9157r0, cube.f9155g0, cube.f9153b0)];
            case 2:
                return (((-moment[getIndex(cube.f9158r1, cube.f9155g0, cube.f9154b1)]) + moment[getIndex(cube.f9158r1, cube.f9155g0, cube.f9153b0)]) + moment[getIndex(cube.f9157r0, cube.f9155g0, cube.f9154b1)]) - moment[getIndex(cube.f9157r0, cube.f9155g0, cube.f9153b0)];
            case 3:
                return (((-moment[getIndex(cube.f9158r1, cube.f9156g1, cube.f9153b0)]) + moment[getIndex(cube.f9158r1, cube.f9155g0, cube.f9153b0)]) + moment[getIndex(cube.f9157r0, cube.f9156g1, cube.f9153b0)]) - moment[getIndex(cube.f9157r0, cube.f9155g0, cube.f9153b0)];
            default:
                throw new IllegalArgumentException("unexpected direction " + ((Object) direction));
        }
    }

    private static int top(Box cube, Direction direction, int position, int[] moment) {
        switch (AnonymousClass1.$SwitchMap$com$android$internal$graphics$palette$WuQuantizer$Direction[direction.ordinal()]) {
            case 1:
                return ((moment[getIndex(position, cube.f9156g1, cube.f9154b1)] - moment[getIndex(position, cube.f9156g1, cube.f9153b0)]) - moment[getIndex(position, cube.f9155g0, cube.f9154b1)]) + moment[getIndex(position, cube.f9155g0, cube.f9153b0)];
            case 2:
                return ((moment[getIndex(cube.f9158r1, position, cube.f9154b1)] - moment[getIndex(cube.f9158r1, position, cube.f9153b0)]) - moment[getIndex(cube.f9157r0, position, cube.f9154b1)]) + moment[getIndex(cube.f9157r0, position, cube.f9153b0)];
            case 3:
                return ((moment[getIndex(cube.f9158r1, cube.f9156g1, position)] - moment[getIndex(cube.f9158r1, cube.f9155g0, position)]) - moment[getIndex(cube.f9157r0, cube.f9156g1, position)]) + moment[getIndex(cube.f9157r0, cube.f9155g0, position)];
            default:
                throw new IllegalArgumentException("unexpected direction " + ((Object) direction));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class MaximizeResult {
        final int mCutLocation;
        final double mMaximum;

        MaximizeResult(int cut, double max) {
            this.mCutLocation = cut;
            this.mMaximum = max;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class CreateBoxesResult {
        final int mRequestedCount;
        final int mResultCount;

        CreateBoxesResult(int requestedCount, int resultCount) {
            this.mRequestedCount = requestedCount;
            this.mResultCount = resultCount;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Box {

        /* renamed from: b0, reason: collision with root package name */
        public int f9153b0;

        /* renamed from: b1, reason: collision with root package name */
        public int f9154b1;

        /* renamed from: g0, reason: collision with root package name */
        public int f9155g0;

        /* renamed from: g1, reason: collision with root package name */
        public int f9156g1;

        /* renamed from: r0, reason: collision with root package name */
        public int f9157r0;

        /* renamed from: r1, reason: collision with root package name */
        public int f9158r1;
        public int vol;

        private Box() {
            this.f9157r0 = 0;
            this.f9158r1 = 0;
            this.f9155g0 = 0;
            this.f9156g1 = 0;
            this.f9153b0 = 0;
            this.f9154b1 = 0;
            this.vol = 0;
        }
    }
}
