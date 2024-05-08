package com.google.common.util.concurrent;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AtomicDouble extends Number {
    private static final long serialVersionUID = 0;
    private transient AtomicLong value;

    public AtomicDouble(double d10) {
        this.value = new AtomicLong(Double.doubleToRawLongBits(d10));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.value = new AtomicLong();
        set(objectInputStream.readDouble());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeDouble(get());
    }

    public final double addAndGet(double d10) {
        long j10;
        double longBitsToDouble;
        do {
            j10 = this.value.get();
            longBitsToDouble = Double.longBitsToDouble(j10) + d10;
        } while (!this.value.compareAndSet(j10, Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public final boolean compareAndSet(double d10, double d11) {
        return this.value.compareAndSet(Double.doubleToRawLongBits(d10), Double.doubleToRawLongBits(d11));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    public final double get() {
        return Double.longBitsToDouble(this.value.get());
    }

    public final double getAndAdd(double d10) {
        long j10;
        double longBitsToDouble;
        do {
            j10 = this.value.get();
            longBitsToDouble = Double.longBitsToDouble(j10);
        } while (!this.value.compareAndSet(j10, Double.doubleToRawLongBits(longBitsToDouble + d10)));
        return longBitsToDouble;
    }

    public final double getAndSet(double d10) {
        return Double.longBitsToDouble(this.value.getAndSet(Double.doubleToRawLongBits(d10)));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    public final void lazySet(double d10) {
        this.value.lazySet(Double.doubleToRawLongBits(d10));
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) get();
    }

    public final void set(double d10) {
        this.value.set(Double.doubleToRawLongBits(d10));
    }

    public String toString() {
        return Double.toString(get());
    }

    public final boolean weakCompareAndSet(double d10, double d11) {
        return this.value.weakCompareAndSet(Double.doubleToRawLongBits(d10), Double.doubleToRawLongBits(d11));
    }

    public AtomicDouble() {
        this(ShadowDrawableWrapper.COS_45);
    }
}
