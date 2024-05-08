package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;

/* compiled from: GJYearOfEraDateTimeField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class m extends org.joda.time.field.c {

    /* renamed from: c, reason: collision with root package name */
    public final BasicChronology f52525c;

    public m(org.joda.time.b bVar, BasicChronology basicChronology) {
        super(bVar, DateTimeFieldType.yearOfEra());
        this.f52525c = basicChronology;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long add(long j10, int i10) {
        return getWrappedField().add(j10, i10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long addWrapField(long j10, int i10) {
        return getWrappedField().addWrapField(j10, i10);
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public int get(long j10) {
        int i10 = getWrappedField().get(j10);
        return i10 <= 0 ? 1 - i10 : i10;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getDifference(long j10, long j11) {
        return getWrappedField().getDifference(j10, j11);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long getDifferenceAsLong(long j10, long j11) {
        return getWrappedField().getDifferenceAsLong(j10, j11);
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue() {
        return getWrappedField().getMaximumValue();
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue() {
        return 1;
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getRangeDurationField() {
        return this.f52525c.eras();
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

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public long set(long j10, int i10) {
        org.joda.time.field.e.n(this, i10, 1, getMaximumValue());
        if (this.f52525c.getYear(j10) <= 0) {
            i10 = 1 - i10;
        }
        return super.set(j10, i10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long add(long j10, long j11) {
        return getWrappedField().add(j10, j11);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int[] addWrapField(org.joda.time.k kVar, int i10, int[] iArr, int i11) {
        return getWrappedField().addWrapField(kVar, i10, iArr, i11);
    }
}
