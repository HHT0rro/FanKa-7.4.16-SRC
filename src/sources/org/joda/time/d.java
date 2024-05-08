package org.joda.time;

/* compiled from: DurationField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class d implements Comparable<d> {
    public abstract long add(long j10, int i10);

    public abstract long add(long j10, long j11);

    public abstract int getDifference(long j10, long j11);

    public abstract long getDifferenceAsLong(long j10, long j11);

    public abstract long getMillis(int i10);

    public abstract long getMillis(int i10, long j10);

    public abstract long getMillis(long j10);

    public abstract long getMillis(long j10, long j11);

    public abstract String getName();

    public abstract DurationFieldType getType();

    public abstract long getUnitMillis();

    public abstract int getValue(long j10);

    public abstract int getValue(long j10, long j11);

    public abstract long getValueAsLong(long j10);

    public abstract long getValueAsLong(long j10, long j11);

    public abstract boolean isPrecise();

    public abstract boolean isSupported();

    public long subtract(long j10, int i10) {
        if (i10 == Integer.MIN_VALUE) {
            return subtract(j10, i10);
        }
        return add(j10, -i10);
    }

    public abstract String toString();

    public long subtract(long j10, long j11) {
        if (j11 != Long.MIN_VALUE) {
            return add(j10, -j11);
        }
        throw new ArithmeticException("Long.MIN_VALUE cannot be negated");
    }
}
