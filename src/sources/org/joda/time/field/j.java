package org.joda.time.field;

import org.joda.time.DateTimeFieldType;
import org.joda.time.k;

/* compiled from: ZeroIsMaxDateTimeField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class j extends c {
    public j(org.joda.time.b bVar, DateTimeFieldType dateTimeFieldType) {
        super(bVar, dateTimeFieldType);
        if (bVar.getMinimumValue() != 0) {
            throw new IllegalArgumentException("Wrapped field's minumum value must be zero");
        }
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
        return i10 == 0 ? getMaximumValue() : i10;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getDifference(long j10, long j11) {
        return getWrappedField().getDifference(j10, j11);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long getDifferenceAsLong(long j10, long j11) {
        return getWrappedField().getDifferenceAsLong(j10, j11);
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
        return getWrappedField().getMaximumValue() + 1;
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue() {
        return 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue(long j10) {
        return 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue(k kVar) {
        return 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue(k kVar, int[] iArr) {
        return 1;
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
        int maximumValue = getMaximumValue();
        e.n(this, i10, 1, maximumValue);
        if (i10 == maximumValue) {
            i10 = 0;
        }
        return getWrappedField().set(j10, i10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long add(long j10, long j11) {
        return getWrappedField().add(j10, j11);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int[] addWrapField(k kVar, int i10, int[] iArr, int i11) {
        return getWrappedField().addWrapField(kVar, i10, iArr, i11);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue(long j10) {
        return getWrappedField().getMaximumValue(j10) + 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue(k kVar) {
        return getWrappedField().getMaximumValue(kVar) + 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue(k kVar, int[] iArr) {
        return getWrappedField().getMaximumValue(kVar, iArr) + 1;
    }
}
