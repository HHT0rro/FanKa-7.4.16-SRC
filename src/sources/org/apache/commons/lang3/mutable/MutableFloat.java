package org.apache.commons.lang3.mutable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class MutableFloat extends Number implements Comparable<MutableFloat>, Mutable<Number> {
    private static final long serialVersionUID = 5787169186L;
    private float value;

    public MutableFloat() {
    }

    public void add(float f10) {
        this.value += f10;
    }

    public float addAndGet(float f10) {
        float f11 = this.value + f10;
        this.value = f11;
        return f11;
    }

    public void decrement() {
        this.value -= 1.0f;
    }

    public float decrementAndGet() {
        float f10 = this.value - 1.0f;
        this.value = f10;
        return f10;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableFloat) && Float.floatToIntBits(((MutableFloat) obj).value) == Float.floatToIntBits(this.value);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    public float getAndAdd(float f10) {
        float f11 = this.value;
        this.value = f10 + f11;
        return f11;
    }

    public float getAndDecrement() {
        float f10 = this.value;
        this.value = f10 - 1.0f;
        return f10;
    }

    public float getAndIncrement() {
        float f10 = this.value;
        this.value = 1.0f + f10;
        return f10;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value);
    }

    public void increment() {
        this.value += 1.0f;
    }

    public float incrementAndGet() {
        float f10 = this.value + 1.0f;
        this.value = f10;
        return f10;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    public boolean isInfinite() {
        return Float.isInfinite(this.value);
    }

    public boolean isNaN() {
        return Float.isNaN(this.value);
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public void subtract(float f10) {
        this.value -= f10;
    }

    public Float toFloat() {
        return Float.valueOf(floatValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableFloat(float f10) {
        this.value = f10;
    }

    public void add(Number number) {
        this.value += number.floatValue();
    }

    public float addAndGet(Number number) {
        float floatValue = this.value + number.floatValue();
        this.value = floatValue;
        return floatValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(MutableFloat mutableFloat) {
        return Float.compare(this.value, mutableFloat.value);
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue, reason: merged with bridge method [inline-methods] */
    public Number getValue2() {
        return Float.valueOf(this.value);
    }

    public void setValue(float f10) {
        this.value = f10;
    }

    public void subtract(Number number) {
        this.value -= number.floatValue();
    }

    public float getAndAdd(Number number) {
        float f10 = this.value;
        this.value = number.floatValue() + f10;
        return f10;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        this.value = number.floatValue();
    }

    public MutableFloat(Number number) {
        this.value = number.floatValue();
    }

    public MutableFloat(String str) {
        this.value = Float.parseFloat(str);
    }
}
