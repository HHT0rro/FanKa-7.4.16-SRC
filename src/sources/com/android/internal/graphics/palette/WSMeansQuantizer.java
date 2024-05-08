package com.android.internal.graphics.palette;

import com.android.internal.graphics.palette.Palette;
import com.android.internal.graphics.palette.WSMeansQuantizer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class WSMeansQuantizer implements Quantizer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DEBUG = false;
    private static final int MAX_ITERATIONS = 10;
    private static final float MIN_MOVEMENT_DISTANCE = 3.0f;
    private static final String TAG = "QuantizerWsmeans";
    private int[] mClusterIndices;
    private int[] mClusterPopulations;
    private float[][] mClusters;
    private Map<Integer, Integer> mInputPixelToCount;
    private Palette mPalette;
    private int[] mPixels;
    private final PointProvider mPointProvider;
    private float[][] mPoints;
    private int[][] mIndexMatrix = new int[0];
    private float[][] mDistanceMatrix = new float[0];

    public WSMeansQuantizer(int[] inClusters, PointProvider pointProvider, Map<Integer, Integer> inputPixelToCount) {
        int i10 = 0;
        this.mPointProvider = pointProvider;
        this.mClusters = (float[][]) Array.newInstance(Float.TYPE, inClusters.length, 3);
        int index = 0;
        int length = inClusters.length;
        while (i10 < length) {
            int cluster = inClusters[i10];
            float[] point = pointProvider.fromInt(cluster);
            this.mClusters[index] = point;
            i10++;
            index++;
        }
        this.mInputPixelToCount = inputPixelToCount;
    }

    @Override // com.android.internal.graphics.palette.Quantizer
    public List<Palette.Swatch> getQuantizedColors() {
        return this.mPalette.getSwatches();
    }

    @Override // com.android.internal.graphics.palette.Quantizer
    public void quantize(int[] pixels, int maxColors) {
        if (this.mInputPixelToCount == null) {
            QuantizerMap mapQuantizer = new QuantizerMap();
            mapQuantizer.quantize(pixels, maxColors);
            this.mInputPixelToCount = mapQuantizer.getColorToCount();
        }
        this.mPoints = (float[][]) Array.newInstance(Float.TYPE, this.mInputPixelToCount.size(), 3);
        this.mPixels = new int[this.mInputPixelToCount.size()];
        int index = 0;
        Iterator<Integer> iterator2 = this.mInputPixelToCount.h().iterator2();
        while (iterator2.hasNext()) {
            int pixel = iterator2.next().intValue();
            this.mPixels[index] = pixel;
            this.mPoints[index] = this.mPointProvider.fromInt(pixel);
            index++;
        }
        float[][] fArr = this.mClusters;
        if (fArr.length > 0) {
            maxColors = Math.min(maxColors, fArr.length);
        }
        int maxColors2 = Math.min(maxColors, this.mPoints.length);
        initializeClusters(maxColors2);
        for (int i10 = 0; i10 < 10; i10++) {
            calculateClusterDistances(maxColors2);
            if (!reassignPoints(maxColors2)) {
                break;
            }
            recalculateClusterCenters(maxColors2);
        }
        List<Palette.Swatch> swatches = new ArrayList<>();
        for (int i11 = 0; i11 < maxColors2; i11++) {
            float[] cluster = this.mClusters[i11];
            int colorInt = this.mPointProvider.toInt(cluster);
            swatches.add(new Palette.Swatch(colorInt, this.mClusterPopulations[i11]));
        }
        this.mPalette = Palette.from(swatches);
    }

    private void initializeClusters(int maxColors) {
        float[][] fArr = this.mClusters;
        boolean hadInputClusters = fArr.length > 0;
        if (!hadInputClusters) {
            int additionalClustersNeeded = maxColors - fArr.length;
            Random random = new Random(272008L);
            List<float[]> additionalClusters = new ArrayList<>(additionalClustersNeeded);
            Set<Integer> clusterIndicesUsed = new HashSet<>();
            for (int i10 = 0; i10 < additionalClustersNeeded; i10++) {
                int index = random.nextInt(this.mPoints.length);
                while (clusterIndicesUsed.contains(Integer.valueOf(index))) {
                    int size = clusterIndicesUsed.size();
                    float[][] fArr2 = this.mPoints;
                    if (size < fArr2.length) {
                        index = random.nextInt(fArr2.length);
                    }
                }
                clusterIndicesUsed.add(Integer.valueOf(index));
                additionalClusters.add(this.mPoints[index]);
            }
            float[][] newClusters = (float[][]) additionalClusters.toArray();
            float[][] clusters = (float[][]) Arrays.copyOf(this.mClusters, maxColors);
            System.arraycopy(newClusters, 0, clusters, clusters.length, newClusters.length);
            this.mClusters = clusters;
        }
        int[] iArr = this.mPixels;
        this.mClusterIndices = new int[iArr.length];
        this.mClusterPopulations = new int[iArr.length];
        Random random2 = new Random(272008L);
        for (int i11 = 0; i11 < this.mPixels.length; i11++) {
            int clusterIndex = random2.nextInt(maxColors);
            this.mClusterIndices[i11] = clusterIndex;
            this.mClusterPopulations[i11] = this.mInputPixelToCount.get(Integer.valueOf(this.mPixels[i11])).intValue();
        }
    }

    void calculateClusterDistances(int maxColors) {
        if (this.mDistanceMatrix.length != maxColors) {
            this.mDistanceMatrix = (float[][]) Array.newInstance(Float.TYPE, maxColors, maxColors);
        }
        for (int i10 = 0; i10 <= maxColors; i10++) {
            for (int j10 = i10 + 1; j10 < maxColors; j10++) {
                PointProvider pointProvider = this.mPointProvider;
                float[][] fArr = this.mClusters;
                float distance = pointProvider.distance(fArr[i10], fArr[j10]);
                float[][] fArr2 = this.mDistanceMatrix;
                fArr2[j10][i10] = distance;
                fArr2[i10][j10] = distance;
            }
        }
        if (this.mIndexMatrix.length != maxColors) {
            this.mIndexMatrix = (int[][]) Array.newInstance(Integer.TYPE, maxColors, maxColors);
        }
        for (int i11 = 0; i11 < maxColors; i11++) {
            ArrayList<Distance> distances = new ArrayList<>(maxColors);
            for (int index = 0; index < maxColors; index++) {
                distances.add(new Distance(index, this.mDistanceMatrix[i11][index]));
            }
            distances.sort(new Comparator() { // from class: com.android.internal.graphics.palette.WSMeansQuantizer$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int compare;
                    compare = Float.compare(((WSMeansQuantizer.Distance) obj).getDistance(), ((WSMeansQuantizer.Distance) obj2).getDistance());
                    return compare;
                }
            });
            for (int j11 = 0; j11 < maxColors; j11++) {
                this.mIndexMatrix[i11][j11] = distances.get(j11).getIndex();
            }
        }
    }

    boolean reassignPoints(int maxColors) {
        boolean colorMoved = false;
        int i10 = 0;
        while (true) {
            float[][] fArr = this.mPoints;
            if (i10 < fArr.length) {
                float[] point = fArr[i10];
                int previousClusterIndex = this.mClusterIndices[i10];
                float[] previousCluster = this.mClusters[previousClusterIndex];
                float previousDistance = this.mPointProvider.distance(point, previousCluster);
                float minimumDistance = previousDistance;
                int newClusterIndex = -1;
                for (int j10 = 1; j10 < maxColors; j10++) {
                    int t2 = this.mIndexMatrix[previousClusterIndex][j10];
                    if (this.mDistanceMatrix[previousClusterIndex][t2] >= 4.0f * previousDistance) {
                        break;
                    }
                    float distance = this.mPointProvider.distance(point, this.mClusters[t2]);
                    if (distance < minimumDistance) {
                        minimumDistance = distance;
                        newClusterIndex = t2;
                    }
                }
                if (newClusterIndex != -1) {
                    float distanceChange = (float) Math.abs(Math.sqrt(minimumDistance) - Math.sqrt(previousDistance));
                    if (distanceChange > 3.0f) {
                        colorMoved = true;
                        this.mClusterIndices[i10] = newClusterIndex;
                    }
                }
                i10++;
            } else {
                return colorMoved;
            }
        }
    }

    void recalculateClusterCenters(int maxColors) {
        this.mClusterPopulations = new int[maxColors];
        float[] aSums = new float[maxColors];
        float[] bSums = new float[maxColors];
        float[] cSums = new float[maxColors];
        int i10 = 0;
        while (true) {
            float[][] fArr = this.mPoints;
            if (i10 >= fArr.length) {
                break;
            }
            int clusterIndex = this.mClusterIndices[i10];
            float[] point = fArr[i10];
            int pixel = this.mPixels[i10];
            int count = this.mInputPixelToCount.get(Integer.valueOf(pixel)).intValue();
            int[] iArr = this.mClusterPopulations;
            iArr[clusterIndex] = iArr[clusterIndex] + count;
            aSums[clusterIndex] = aSums[clusterIndex] + (point[0] * count);
            bSums[clusterIndex] = bSums[clusterIndex] + (point[1] * count);
            cSums[clusterIndex] = cSums[clusterIndex] + (point[2] * count);
            i10++;
        }
        for (int i11 = 0; i11 < maxColors; i11++) {
            int count2 = this.mClusterPopulations[i11];
            float aSum = aSums[i11];
            float bSum = bSums[i11];
            float cSum = cSums[i11];
            float[] fArr2 = this.mClusters[i11];
            fArr2[0] = aSum / count2;
            fArr2[1] = bSum / count2;
            fArr2[2] = cSum / count2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Distance {
        private final float mDistance;
        private final int mIndex;

        int getIndex() {
            return this.mIndex;
        }

        float getDistance() {
            return this.mDistance;
        }

        Distance(int index, float distance) {
            this.mIndex = index;
            this.mDistance = distance;
        }
    }
}
