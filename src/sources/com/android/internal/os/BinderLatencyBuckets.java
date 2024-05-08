package com.android.internal.os;

import android.util.Slog;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class BinderLatencyBuckets {
    private static final String TAG = "BinderLatencyBuckets";
    private final int[] mBuckets;

    public BinderLatencyBuckets(int bucketCount, int firstBucketSize, float scaleFactor) {
        int[] buffer = new int[bucketCount - 1];
        buffer[0] = firstBucketSize;
        double lastTarget = firstBucketSize;
        for (int i10 = 1; i10 < bucketCount - 1; i10++) {
            double nextTarget = scaleFactor * lastTarget;
            if (nextTarget > 2.147483647E9d) {
                Slog.w(TAG, "Attempted to create a bucket larger than maxint");
                this.mBuckets = Arrays.copyOfRange(buffer, 0, i10);
                return;
            } else {
                if (((int) nextTarget) > buffer[i10 - 1]) {
                    buffer[i10] = (int) nextTarget;
                } else {
                    buffer[i10] = buffer[i10 - 1] + 1;
                }
                lastTarget = nextTarget;
            }
        }
        this.mBuckets = buffer;
    }

    public int sampleToBucket(int sample) {
        int[] iArr = this.mBuckets;
        if (sample >= iArr[iArr.length - 1]) {
            return iArr.length;
        }
        int searchResult = Arrays.binarySearch(iArr, sample);
        int i10 = searchResult + 1;
        return searchResult < 0 ? -i10 : i10;
    }

    public int[] getBuckets() {
        return this.mBuckets;
    }
}
