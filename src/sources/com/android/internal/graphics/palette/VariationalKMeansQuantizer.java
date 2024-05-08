package com.android.internal.graphics.palette;

import com.android.internal.graphics.ColorUtils;
import com.android.internal.graphics.palette.Palette;
import com.android.internal.ml.clustering.KMeans;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class VariationalKMeansQuantizer implements Quantizer {
    private static final boolean DEBUG = false;
    private static final String TAG = "KMeansQuantizer";
    private final int mInitializations;
    private final KMeans mKMeans;
    private final float mMinClusterSqDistance;
    private List<Palette.Swatch> mQuantizedColors;

    public VariationalKMeansQuantizer() {
        this(0.25f);
    }

    public VariationalKMeansQuantizer(float minClusterDistance) {
        this(minClusterDistance, 1);
    }

    public VariationalKMeansQuantizer(float minClusterDistance, int initializations) {
        this.mKMeans = new KMeans(new Random(0L), 30, 0.0f);
        this.mMinClusterSqDistance = minClusterDistance * minClusterDistance;
        this.mInitializations = initializations;
    }

    @Override // com.android.internal.graphics.palette.Quantizer
    public void quantize(int[] pixels, int maxColors) {
        float[] hsl;
        int i10;
        float[] hsl2 = {0.0f, 0.0f, 0.0f};
        float[][] hslPixels = (float[][]) Array.newInstance(Float.TYPE, pixels.length, 3);
        for (int i11 = 0; i11 < pixels.length; i11++) {
            ColorUtils.colorToHSL(pixels[i11], hsl2);
            hslPixels[i11][0] = hsl2[0] / 360.0f;
            hslPixels[i11][1] = hsl2[1];
            hslPixels[i11][2] = hsl2[2];
        }
        List<KMeans.Mean> optimalMeans = getOptimalKMeans(maxColors, hslPixels);
        int i12 = 0;
        while (i12 < optimalMeans.size()) {
            KMeans.Mean current = optimalMeans.get(i12);
            float[] currentCentroid = current.getCentroid();
            int j10 = i12 + 1;
            while (j10 < optimalMeans.size()) {
                KMeans.Mean compareTo = optimalMeans.get(j10);
                float[] compareToCentroid = compareTo.getCentroid();
                float sqDistance = KMeans.sqDistance(currentCentroid, compareToCentroid);
                if (sqDistance >= this.mMinClusterSqDistance) {
                    hsl = hsl2;
                    i10 = i12;
                } else {
                    optimalMeans.remove(compareTo);
                    current.getItems().addAll(compareTo.getItems());
                    int k10 = 0;
                    while (k10 < currentCentroid.length) {
                        currentCentroid[k10] = (float) (currentCentroid[k10] + ((compareToCentroid[k10] - currentCentroid[k10]) / 2.0d));
                        k10++;
                        hsl2 = hsl2;
                        i12 = i12;
                    }
                    hsl = hsl2;
                    i10 = i12;
                    j10--;
                }
                j10++;
                hsl2 = hsl;
                i12 = i10;
            }
            i12++;
        }
        this.mQuantizedColors = new ArrayList();
        float[] mHsl = new float[3];
        for (KMeans.Mean mean : optimalMeans) {
            if (mean.getItems().size() != 0) {
                float[] centroid = mean.getCentroid();
                mHsl[0] = centroid[0] * 360.0f;
                mHsl[1] = centroid[1];
                mHsl[2] = centroid[2];
                int color = ColorUtils.HSLToColor(mHsl);
                this.mQuantizedColors.add(new Palette.Swatch(color, mean.getItems().size()));
            }
        }
    }

    private List<KMeans.Mean> getOptimalKMeans(int k10, float[][] inputData) {
        List<KMeans.Mean> optimal = null;
        double optimalScore = -1.7976931348623157E308d;
        for (int runs = this.mInitializations; runs > 0; runs--) {
            List<KMeans.Mean> means = this.mKMeans.predict(k10, inputData);
            double score = KMeans.score(means);
            if (optimal == null || score > optimalScore) {
                optimalScore = score;
                optimal = means;
            }
        }
        return optimal;
    }

    @Override // com.android.internal.graphics.palette.Quantizer
    public List<Palette.Swatch> getQuantizedColors() {
        return this.mQuantizedColors;
    }
}
