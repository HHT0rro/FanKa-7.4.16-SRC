package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class MutableByte extends Number implements Comparable<MutableByte>, Mutable<Number> {
    private static final long serialVersionUID = -1585823265;
    private byte value;

    public MutableByte() {
    }

    public void add(byte b4) {
        this.value = (byte) (this.value + b4);
    }

    public byte addAndGet(byte b4) {
        byte b10 = (byte) (this.value + b4);
        this.value = b10;
        return b10;
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return this.value;
    }

    public void decrement() {
        this.value = (byte) (this.value - 1);
    }

    public byte decrementAndGet() {
        byte b4 = (byte) (this.value - 1);
        this.value = b4;
        return b4;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableByte) && this.value == ((MutableByte) obj).byteValue();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    public byte getAndAdd(byte b4) {
        byte b10 = this.value;
        this.value = (byte) (b4 + b10);
        return b10;
    }

    public byte getAndDecrement() {
        byte b4 = this.value;
        this.value = (byte) (b4 - 1);
        return b4;
    }

    public byte getAndIncrement() {
        byte b4 = this.value;
        this.value = (byte) (b4 + 1);
        return b4;
    }

    public int hashCode() {
        return this.value;
    }

    public void increment() {
        this.value = (byte) (this.value + 1);
    }

    public byte incrementAndGet() {
        byte b4 = (byte) (this.value + 1);
        this.value = b4;
        return b4;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public void subtract(byte b4) {
        this.value = (byte) (this.value - b4);
    }

    public Byte toByte() {
        return Byte.valueOf(byteValue());
    }

    public String toString() {
        return String.valueOf((int) this.value);
    }

    public MutableByte(byte b4) {
        this.value = b4;
    }

    public void add(Number number) {
        this.value = (byte) (this.value + number.byteValue());
    }

    public byte addAndGet(Number number) {
        byte byteValue = (byte) (this.value + number.byteValue());
        this.value = byteValue;
        return byteValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(MutableByte mutableByte) {
        return NumberUtils.compare(this.value, mutableByte.value);
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public Number getValue2() {
        return Byte.valueOf(this.value);
    }

    public void setValue(byte b4) {
        this.value = b4;
    }

    public void subtract(Number number) {
        this.value = (byte) (this.value - number.byteValue());
    }

    public byte getAndAdd(Number number) {
        byte b4 = this.value;
        this.value = (byte) (number.byteValue() + b4);
        return b4;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        this.value = number.byteValue();
    }

    public MutableByte(Number number) {
        this.value = number.byteValue();
    }

    public MutableByte(String str) {
        this.value = Byte.parseByte(str);
    }
}
