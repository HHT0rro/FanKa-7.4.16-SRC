package java.util;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class LongSummaryStatistics implements LongConsumer, IntConsumer {
    private long count;
    private long max;
    private long min;
    private long sum;

    public LongSummaryStatistics() {
        this.min = Long.MAX_VALUE;
        this.max = Long.MIN_VALUE;
    }

    public LongSummaryStatistics(long count, long min, long max, long sum) throws IllegalArgumentException {
        this.min = Long.MAX_VALUE;
        this.max = Long.MIN_VALUE;
        if (count < 0) {
            throw new IllegalArgumentException("Negative count value");
        }
        if (count > 0) {
            if (min > max) {
                throw new IllegalArgumentException("Minimum greater than maximum");
            }
            this.count = count;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    @Override // java.util.function.IntConsumer
    public void accept(int value) {
        accept(value);
    }

    @Override // java.util.function.LongConsumer
    public void accept(long value) {
        this.count++;
        this.sum += value;
        this.min = Math.min(this.min, value);
        this.max = Math.max(this.max, value);
    }

    public void combine(LongSummaryStatistics other) {
        this.count += other.count;
        this.sum += other.sum;
        this.min = Math.min(this.min, other.min);
        this.max = Math.max(this.max, other.max);
    }

    public final long getCount() {
        return this.count;
    }

    public final long getSum() {
        return this.sum;
    }

    public final long getMin() {
        return this.min;
    }

    public final long getMax() {
        return this.max;
    }

    public final double getAverage() {
        return getCount() > 0 ? getSum() / getCount() : ShadowDrawableWrapper.COS_45;
    }

    public String toString() {
        return String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", getClass().getSimpleName(), Long.valueOf(getCount()), Long.valueOf(getSum()), Long.valueOf(getMin()), Double.valueOf(getAverage()), Long.valueOf(getMax()));
    }
}
