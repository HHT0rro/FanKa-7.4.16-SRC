package com.google.common.math;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.common.base.j;
import com.google.common.base.l;
import com.google.common.base.o;
import com.google.common.primitives.Doubles;
import com.huawei.quickcard.base.Attributes;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Stats implements Serializable {
    public static final int BYTES = 40;
    private static final long serialVersionUID = 0;
    private final long count;
    private final double max;
    private final double mean;
    private final double min;
    private final double sumOfSquaresOfDeltas;

    public Stats(long j10, double d10, double d11, double d12, double d13) {
        this.count = j10;
        this.mean = d10;
        this.sumOfSquaresOfDeltas = d11;
        this.min = d12;
        this.max = d13;
    }

    public static Stats fromByteArray(byte[] bArr) {
        o.r(bArr);
        o.i(bArr.length == 40, "Expected Stats.BYTES = %s remaining , got %s", 40, bArr.length);
        return readFrom(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
    }

    public static double meanOf(Iterable<? extends Number> iterable) {
        return meanOf(iterable.iterator2());
    }

    public static Stats of(Iterable<? extends Number> iterable) {
        g gVar = new g();
        gVar.b(iterable);
        return gVar.h();
    }

    public static Stats readFrom(ByteBuffer byteBuffer) {
        o.r(byteBuffer);
        o.i(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        return new Stats(byteBuffer.getLong(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
    }

    public long count() {
        return this.count;
    }

    public boolean equals(Object obj) {
        if (obj == null || Stats.class != obj.getClass()) {
            return false;
        }
        Stats stats = (Stats) obj;
        return this.count == stats.count && Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(stats.mean) && Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(stats.sumOfSquaresOfDeltas) && Double.doubleToLongBits(this.min) == Double.doubleToLongBits(stats.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(stats.max);
    }

    public int hashCode() {
        return l.b(Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max));
    }

    public double max() {
        o.x(this.count != 0);
        return this.max;
    }

    public double mean() {
        o.x(this.count != 0);
        return this.mean;
    }

    public double min() {
        o.x(this.count != 0);
        return this.min;
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double populationVariance() {
        o.x(this.count > 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return this.count == 1 ? ShadowDrawableWrapper.COS_45 : c.a(this.sumOfSquaresOfDeltas) / count();
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double sampleVariance() {
        o.x(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return c.a(this.sumOfSquaresOfDeltas) / (this.count - 1);
    }

    public double sum() {
        return this.mean * this.count;
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(order);
        return order.array();
    }

    public String toString() {
        if (count() > 0) {
            return j.c(this).c("count", this.count).a("mean", this.mean).a("populationStandardDeviation", populationStandardDeviation()).a(Attributes.Style.MIN, this.min).a("max", this.max).toString();
        }
        return j.c(this).c("count", this.count).toString();
    }

    public void writeTo(ByteBuffer byteBuffer) {
        o.r(byteBuffer);
        o.i(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        byteBuffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
    }

    public static double meanOf(Iterator<? extends Number> it) {
        o.d(it.hasNext());
        double doubleValue = it.next().doubleValue();
        long j10 = 1;
        while (it.hasNext()) {
            double doubleValue2 = it.next().doubleValue();
            j10++;
            doubleValue = (Doubles.f(doubleValue2) && Doubles.f(doubleValue)) ? doubleValue + ((doubleValue2 - doubleValue) / j10) : g.g(doubleValue, doubleValue2);
        }
        return doubleValue;
    }

    public static Stats of(Iterator<? extends Number> it) {
        g gVar = new g();
        gVar.c(it);
        return gVar.h();
    }

    public static Stats of(double... dArr) {
        g gVar = new g();
        gVar.d(dArr);
        return gVar.h();
    }

    public static double meanOf(double... dArr) {
        o.d(dArr.length > 0);
        double d10 = dArr[0];
        for (int i10 = 1; i10 < dArr.length; i10++) {
            double d11 = dArr[i10];
            d10 = (Doubles.f(d11) && Doubles.f(d10)) ? d10 + ((d11 - d10) / (i10 + 1)) : g.g(d10, d11);
        }
        return d10;
    }

    public static Stats of(int... iArr) {
        g gVar = new g();
        gVar.e(iArr);
        return gVar.h();
    }

    public static Stats of(long... jArr) {
        g gVar = new g();
        gVar.f(jArr);
        return gVar.h();
    }

    public static double meanOf(int... iArr) {
        o.d(iArr.length > 0);
        double d10 = iArr[0];
        for (int i10 = 1; i10 < iArr.length; i10++) {
            double d11 = iArr[i10];
            d10 = (Doubles.f(d11) && Doubles.f(d10)) ? d10 + ((d11 - d10) / (i10 + 1)) : g.g(d10, d11);
        }
        return d10;
    }

    public static double meanOf(long... jArr) {
        o.d(jArr.length > 0);
        double d10 = jArr[0];
        for (int i10 = 1; i10 < jArr.length; i10++) {
            double d11 = jArr[i10];
            d10 = (Doubles.f(d11) && Doubles.f(d10)) ? d10 + ((d11 - d10) / (i10 + 1)) : g.g(d10, d11);
        }
        return d10;
    }
}
