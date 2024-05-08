package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class MutableLong extends Number implements Comparable<MutableLong>, Mutable<Number> {
    private static final long serialVersionUID = 62986528375L;
    private long value;

    public MutableLong() {
    }

    public void add(long j10) {
        this.value += j10;
    }

    public long addAndGet(long j10) {
        long j11 = this.value + j10;
        this.value = j11;
        return j11;
    }

    public void decrement() {
        this.value--;
    }

    public long decrementAndGet() {
        long j10 = this.value - 1;
        this.value = j10;
        return j10;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableLong) && this.value == ((MutableLong) obj).longValue();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) this.value;
    }

    public long getAndAdd(long j10) {
        long j11 = this.value;
        this.value = j10 + j11;
        return j11;
    }

    public long getAndDecrement() {
        long j10 = this.value;
        this.value = j10 - 1;
        return j10;
    }

    public long getAndIncrement() {
        long j10 = this.value;
        this.value = 1 + j10;
        return j10;
    }

    public int hashCode() {
        long j10 = this.value;
        return (int) (j10 ^ (j10 >>> 32));
    }

    public void increment() {
        this.value++;
    }

    public long incrementAndGet() {
        long j10 = this.value + 1;
        this.value = j10;
        return j10;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public void subtract(long j10) {
        this.value -= j10;
    }

    public Long toLong() {
        return Long.valueOf(longValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableLong(long j10) {
        this.value = j10;
    }

    public void add(Number number) {
        this.value += number.longValue();
    }

    public long addAndGet(Number number) {
        long longValue = this.value + number.longValue();
        this.value = longValue;
        return longValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(MutableLong mutableLong) {
        return NumberUtils.compare(this.value, mutableLong.value);
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public Number getValue2() {
        return Long.valueOf(this.value);
    }

    public void setValue(long j10) {
        this.value = j10;
    }

    public void subtract(Number number) {
        this.value -= number.longValue();
    }

    public long getAndAdd(Number number) {
        long j10 = this.value;
        this.value = number.longValue() + j10;
        return j10;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        this.value = number.longValue();
    }

    public MutableLong(Number number) {
        this.value = number.longValue();
    }

    public MutableLong(String str) {
        this.value = Long.parseLong(str);
    }
}
