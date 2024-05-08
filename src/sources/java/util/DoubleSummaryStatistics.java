package java.util;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;
import java.util.stream.DoubleStream;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class DoubleSummaryStatistics implements DoubleConsumer {
    private long count;
    private double max;
    private double min;
    private double simpleSum;
    private double sum;
    private double sumCompensation;

    public DoubleSummaryStatistics() {
        this.min = Double.POSITIVE_INFINITY;
        this.max = Double.NEGATIVE_INFINITY;
    }

    public DoubleSummaryStatistics(long count, double min, double max, double sum) throws IllegalArgumentException {
        this.min = Double.POSITIVE_INFINITY;
        this.max = Double.NEGATIVE_INFINITY;
        if (count < 0) {
            throw new IllegalArgumentException("Negative count value");
        }
        if (count > 0) {
            if (min > max) {
                throw new IllegalArgumentException("Minimum greater than maximum");
            }
            long ncount = DoubleStream.of(min, max, sum).filter(new DoublePredicate() { // from class: java.util.DoubleSummaryStatistics$$ExternalSyntheticLambda0
                @Override // java.util.function.DoublePredicate
                public final boolean test(double d10) {
                    return Double.isNaN(d10);
                }
            }).count();
            if (ncount > 0 && ncount < 3) {
                throw new IllegalArgumentException("Some, not all, of the minimum, maximum, or sum is NaN");
            }
            this.count = count;
            this.sum = sum;
            this.simpleSum = sum;
            this.sumCompensation = ShadowDrawableWrapper.COS_45;
            this.min = min;
            this.max = max;
        }
    }

    @Override // java.util.function.DoubleConsumer
    public void accept(double value) {
        this.count++;
        this.simpleSum += value;
        sumWithCompensation(value);
        this.min = Math.min(this.min, value);
        this.max = Math.max(this.max, value);
    }

    public void combine(DoubleSummaryStatistics other) {
        this.count += other.count;
        this.simpleSum += other.simpleSum;
        sumWithCompensation(other.sum);
        sumWithCompensation(other.sumCompensation);
        this.min = Math.min(this.min, other.min);
        this.max = Math.max(this.max, other.max);
    }

    private void sumWithCompensation(double value) {
        double tmp = value - this.sumCompensation;
        double d10 = this.sum;
        double velvel = d10 + tmp;
        this.sumCompensation = (velvel - d10) - tmp;
        this.sum = velvel;
    }

    public final long getCount() {
        return this.count;
    }

    public final double getSum() {
        double tmp = this.sum + this.sumCompensation;
        if (Double.isNaN(tmp) && Double.isInfinite(this.simpleSum)) {
            return this.simpleSum;
        }
        return tmp;
    }

    public final double getMin() {
        return this.min;
    }

    public final double getMax() {
        return this.max;
    }

    public final double getAverage() {
        return getCount() > 0 ? getSum() / getCount() : ShadowDrawableWrapper.COS_45;
    }

    public String toString() {
        return String.format("%s{count=%d, sum=%f, min=%f, average=%f, max=%f}", getClass().getSimpleName(), Long.valueOf(getCount()), Double.valueOf(getSum()), Double.valueOf(getMin()), Double.valueOf(getAverage()), Double.valueOf(getMax()));
    }
}
