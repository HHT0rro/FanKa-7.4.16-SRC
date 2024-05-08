package com.android.internal.ml.clustering;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class KMeans {
    private static final boolean DEBUG = false;
    private static final String TAG = "KMeans";
    private final int mMaxIterations;
    private final Random mRandomState;
    private float mSqConvergenceEpsilon;

    public KMeans() {
        this(new Random());
    }

    public KMeans(Random random) {
        this(random, 30, 0.005f);
    }

    public KMeans(Random random, int maxIterations, float convergenceEpsilon) {
        this.mRandomState = random;
        this.mMaxIterations = maxIterations;
        this.mSqConvergenceEpsilon = convergenceEpsilon * convergenceEpsilon;
    }

    public List<Mean> predict(int k10, float[][] inputData) {
        checkDataSetSanity(inputData);
        int dimension = inputData[0].length;
        ArrayList<Mean> means = new ArrayList<>();
        for (int i10 = 0; i10 < k10; i10++) {
            Mean m10 = new Mean(dimension);
            for (int j10 = 0; j10 < dimension; j10++) {
                m10.mCentroid[j10] = this.mRandomState.nextFloat();
            }
            means.add(m10);
        }
        for (int i11 = 0; i11 < this.mMaxIterations; i11++) {
            boolean converged = step(means, inputData);
            if (converged) {
                break;
            }
        }
        return means;
    }

    public static double score(List<Mean> means) {
        double score = ShadowDrawableWrapper.COS_45;
        int meansSize = means.size();
        for (int i10 = 0; i10 < meansSize; i10++) {
            Mean mean = means.get(i10);
            for (int j10 = 0; j10 < meansSize; j10++) {
                Mean compareTo = means.get(j10);
                if (mean != compareTo) {
                    double distance = Math.sqrt(sqDistance(mean.mCentroid, compareTo.mCentroid));
                    score += distance;
                }
            }
        }
        return score;
    }

    public void checkDataSetSanity(float[][] inputData) {
        if (inputData == null) {
            throw new IllegalArgumentException("Data set is null.");
        }
        if (inputData.length == 0) {
            throw new IllegalArgumentException("Data set is empty.");
        }
        if (inputData[0] == null) {
            throw new IllegalArgumentException("Bad data set format.");
        }
        int dimension = inputData[0].length;
        int length = inputData.length;
        for (int i10 = 1; i10 < length; i10++) {
            if (inputData[i10] == null || inputData[i10].length != dimension) {
                throw new IllegalArgumentException("Bad data set format.");
            }
        }
    }

    private boolean step(ArrayList<Mean> means, float[][] inputData) {
        for (int i10 = means.size() - 1; i10 >= 0; i10--) {
            means.get(i10).mClosestItems.clear();
        }
        int i11 = inputData.length;
        for (int i12 = i11 - 1; i12 >= 0; i12--) {
            float[] current = inputData[i12];
            Mean nearest = nearestMean(current, means);
            nearest.mClosestItems.add(current);
        }
        boolean converged = true;
        for (int i13 = means.size() - 1; i13 >= 0; i13--) {
            Mean mean = means.get(i13);
            if (mean.mClosestItems.size() != 0) {
                float[] oldCentroid = mean.mCentroid;
                mean.mCentroid = new float[oldCentroid.length];
                for (int j10 = 0; j10 < mean.mClosestItems.size(); j10++) {
                    for (int p10 = 0; p10 < mean.mCentroid.length; p10++) {
                        float[] fArr = mean.mCentroid;
                        fArr[p10] = fArr[p10] + mean.mClosestItems.get(j10)[p10];
                    }
                }
                for (int j11 = 0; j11 < mean.mCentroid.length; j11++) {
                    float[] fArr2 = mean.mCentroid;
                    fArr2[j11] = fArr2[j11] / mean.mClosestItems.size();
                }
                if (sqDistance(oldCentroid, mean.mCentroid) > this.mSqConvergenceEpsilon) {
                    converged = false;
                }
            }
        }
        return converged;
    }

    public static Mean nearestMean(float[] point, List<Mean> means) {
        Mean nearest = null;
        float nearestDistance = Float.MAX_VALUE;
        int meanCount = means.size();
        for (int i10 = 0; i10 < meanCount; i10++) {
            Mean next = means.get(i10);
            float nextDistance = sqDistance(point, next.mCentroid);
            if (nextDistance < nearestDistance) {
                nearest = next;
                nearestDistance = nextDistance;
            }
        }
        return nearest;
    }

    public static float sqDistance(float[] a10, float[] b4) {
        float dist = 0.0f;
        int length = a10.length;
        for (int i10 = 0; i10 < length; i10++) {
            dist += (a10[i10] - b4[i10]) * (a10[i10] - b4[i10]);
        }
        return dist;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Mean {
        float[] mCentroid;
        final ArrayList<float[]> mClosestItems = new ArrayList<>();

        public Mean(int dimension) {
            this.mCentroid = new float[dimension];
        }

        public Mean(float... centroid) {
            this.mCentroid = centroid;
        }

        public float[] getCentroid() {
            return this.mCentroid;
        }

        public List<float[]> getItems() {
            return this.mClosestItems;
        }

        public String toString() {
            return "Mean(centroid: " + Arrays.toString(this.mCentroid) + ", size: " + this.mClosestItems.size() + ")";
        }
    }
}
