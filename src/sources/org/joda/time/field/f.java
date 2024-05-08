package org.joda.time.field;

import org.joda.time.DateTimeFieldType;

/* compiled from: OffsetDateTimeField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class f extends c {

    /* renamed from: c, reason: collision with root package name */
    public final int f52536c;

    /* renamed from: d, reason: collision with root package name */
    public final int f52537d;

    /* renamed from: e, reason: collision with root package name */
    public final int f52538e;

    public f(org.joda.time.b bVar, int i10) {
        this(bVar, bVar == null ? null : bVar.getType(), i10, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long add(long j10, int i10) {
        long add = super.add(j10, i10);
        e.n(this, get(add), this.f52537d, this.f52538e);
        return add;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long addWrapField(long j10, int i10) {
        return set(j10, e.c(get(j10), i10, this.f52537d, this.f52538e));
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public int get(long j10) {
        return super.get(j10) + this.f52536c;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getLeapAmount(long j10) {
        return getWrappedField().getLeapAmount(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getLeapDurationField() {
        return getWrappedField().getLeapDurationField();
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue() {
        return this.f52538e;
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue() {
        return this.f52537d;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public boolean isLeap(long j10) {
        return getWrappedField().isLeap(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long remainder(long j10) {
        return getWrappedField().remainder(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundCeiling(long j10) {
        return getWrappedField().roundCeiling(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundFloor(long j10) {
        return getWrappedField().roundFloor(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundHalfCeiling(long j10) {
        return getWrappedField().roundHalfCeiling(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundHalfEven(long j10) {
        return getWrappedField().roundHalfEven(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundHalfFloor(long j10) {
        return getWrappedField().roundHalfFloor(j10);
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public long set(long j10, int i10) {
        e.n(this, i10, this.f52537d, this.f52538e);
        return super.set(j10, i10 - this.f52536c);
    }

    public f(org.joda.time.b bVar, DateTimeFieldType dateTimeFieldType, int i10) {
        this(bVar, dateTimeFieldType, i10, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public f(org.joda.time.b bVar, DateTimeFieldType dateTimeFieldType, int i10, int i11, int i12) {
        super(bVar, dateTimeFieldType);
        if (i10 != 0) {
            this.f52536c = i10;
            if (i11 < bVar.getMinimumValue() + i10) {
                this.f52537d = bVar.getMinimumValue() + i10;
            } else {
                this.f52537d = i11;
            }
            if (i12 > bVar.getMaximumValue() + i10) {
                this.f52538e = bVar.getMaximumValue() + i10;
                return;
            } else {
                this.f52538e = i12;
                return;
            }
        }
        throw new IllegalArgumentException("The offset cannot be zero");
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long add(long j10, long j11) {
        long add = super.add(j10, j11);
        e.n(this, get(add), this.f52537d, this.f52538e);
        return add;
    }
}
