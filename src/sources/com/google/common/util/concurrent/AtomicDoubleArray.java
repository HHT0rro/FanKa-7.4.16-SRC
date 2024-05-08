package com.google.common.util.concurrent;

import com.google.common.primitives.ImmutableLongArray;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AtomicDoubleArray implements Serializable {
    private static final long serialVersionUID = 0;
    private transient AtomicLongArray longs;

    public AtomicDoubleArray(int i10) {
        this.longs = new AtomicLongArray(i10);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        ImmutableLongArray.b builder = ImmutableLongArray.builder();
        for (int i10 = 0; i10 < readInt; i10++) {
            builder.a(Double.doubleToRawLongBits(objectInputStream.readDouble()));
        }
        this.longs = new AtomicLongArray(builder.d().toArray());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        int length = length();
        objectOutputStream.writeInt(length);
        for (int i10 = 0; i10 < length; i10++) {
            objectOutputStream.writeDouble(get(i10));
        }
    }

    public double addAndGet(int i10, double d10) {
        long j10;
        double longBitsToDouble;
        do {
            j10 = this.longs.get(i10);
            longBitsToDouble = Double.longBitsToDouble(j10) + d10;
        } while (!this.longs.compareAndSet(i10, j10, Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public final boolean compareAndSet(int i10, double d10, double d11) {
        return this.longs.compareAndSet(i10, Double.doubleToRawLongBits(d10), Double.doubleToRawLongBits(d11));
    }

    public final double get(int i10) {
        return Double.longBitsToDouble(this.longs.get(i10));
    }

    public final double getAndAdd(int i10, double d10) {
        long j10;
        double longBitsToDouble;
        do {
            j10 = this.longs.get(i10);
            longBitsToDouble = Double.longBitsToDouble(j10);
        } while (!this.longs.compareAndSet(i10, j10, Double.doubleToRawLongBits(longBitsToDouble + d10)));
        return longBitsToDouble;
    }

    public final double getAndSet(int i10, double d10) {
        return Double.longBitsToDouble(this.longs.getAndSet(i10, Double.doubleToRawLongBits(d10)));
    }

    public final void lazySet(int i10, double d10) {
        this.longs.lazySet(i10, Double.doubleToRawLongBits(d10));
    }

    public final int length() {
        return this.longs.length();
    }

    public final void set(int i10, double d10) {
        this.longs.set(i10, Double.doubleToRawLongBits(d10));
    }

    public String toString() {
        int length = length() - 1;
        if (length == -1) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder((length + 1) * 19);
        sb2.append('[');
        int i10 = 0;
        while (true) {
            sb2.append(Double.longBitsToDouble(this.longs.get(i10)));
            if (i10 == length) {
                sb2.append(']');
                return sb2.toString();
            }
            sb2.append(',');
            sb2.append(' ');
            i10++;
        }
    }

    public final boolean weakCompareAndSet(int i10, double d10, double d11) {
        return this.longs.weakCompareAndSet(i10, Double.doubleToRawLongBits(d10), Double.doubleToRawLongBits(d11));
    }

    public AtomicDoubleArray(double[] dArr) {
        int length = dArr.length;
        long[] jArr = new long[length];
        for (int i10 = 0; i10 < length; i10++) {
            jArr[i10] = Double.doubleToRawLongBits(dArr[i10]);
        }
        this.longs = new AtomicLongArray(jArr);
    }
}
