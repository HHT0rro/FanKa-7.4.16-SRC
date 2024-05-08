package com.google.common.primitives;

import com.google.common.base.o;
import java.math.BigInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class UnsignedLong extends Number implements Comparable<UnsignedLong> {
    private static final long UNSIGNED_MASK = Long.MAX_VALUE;
    private final long value;
    public static final UnsignedLong ZERO = new UnsignedLong(0);
    public static final UnsignedLong ONE = new UnsignedLong(1);
    public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1);

    private UnsignedLong(long j10) {
        this.value = j10;
    }

    public static UnsignedLong fromLongBits(long j10) {
        return new UnsignedLong(j10);
    }

    public static UnsignedLong valueOf(long j10) {
        o.j(j10 >= 0, "value (%s) is outside the range for an unsigned long value", j10);
        return fromLongBits(j10);
    }

    public BigInteger bigIntegerValue() {
        BigInteger valueOf = BigInteger.valueOf(this.value & Long.MAX_VALUE);
        return this.value < 0 ? valueOf.setBit(63) : valueOf;
    }

    public UnsignedLong dividedBy(UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.b(this.value, ((UnsignedLong) o.r(unsignedLong)).value));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        long j10 = this.value;
        if (j10 >= 0) {
            return j10;
        }
        return ((j10 & 1) | (j10 >>> 1)) * 2.0d;
    }

    public boolean equals(Object obj) {
        return (obj instanceof UnsignedLong) && this.value == ((UnsignedLong) obj).value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        long j10 = this.value;
        if (j10 >= 0) {
            return (float) j10;
        }
        return ((float) ((j10 & 1) | (j10 >>> 1))) * 2.0f;
    }

    public int hashCode() {
        return Longs.e(this.value);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public UnsignedLong minus(UnsignedLong unsignedLong) {
        return fromLongBits(this.value - ((UnsignedLong) o.r(unsignedLong)).value);
    }

    public UnsignedLong mod(UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.e(this.value, ((UnsignedLong) o.r(unsignedLong)).value));
    }

    public UnsignedLong plus(UnsignedLong unsignedLong) {
        return fromLongBits(this.value + ((UnsignedLong) o.r(unsignedLong)).value);
    }

    public UnsignedLong times(UnsignedLong unsignedLong) {
        return fromLongBits(this.value * ((UnsignedLong) o.r(unsignedLong)).value);
    }

    public String toString() {
        return UnsignedLongs.f(this.value);
    }

    @Override // java.lang.Comparable
    public int compareTo(UnsignedLong unsignedLong) {
        o.r(unsignedLong);
        return UnsignedLongs.a(this.value, unsignedLong.value);
    }

    public String toString(int i10) {
        return UnsignedLongs.g(this.value, i10);
    }

    public static UnsignedLong valueOf(BigInteger bigInteger) {
        o.r(bigInteger);
        o.m(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", bigInteger);
        return fromLongBits(bigInteger.longValue());
    }

    public static UnsignedLong valueOf(String str) {
        return valueOf(str, 10);
    }

    public static UnsignedLong valueOf(String str, int i10) {
        return fromLongBits(UnsignedLongs.d(str, i10));
    }
}
