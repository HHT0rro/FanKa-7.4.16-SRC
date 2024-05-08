package org.joda.time.field;

import org.joda.time.DurationFieldType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ScaledDurationField extends DecoratedDurationField {
    private static final long serialVersionUID = -3205227092378684157L;
    private final int iScalar;

    public ScaledDurationField(org.joda.time.d dVar, DurationFieldType durationFieldType, int i10) {
        super(dVar, durationFieldType);
        if (i10 != 0 && i10 != 1) {
            this.iScalar = i10;
            return;
        }
        throw new IllegalArgumentException("The scalar must not be 0 or 1");
    }

    @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.d
    public long add(long j10, int i10) {
        return getWrappedField().add(j10, i10 * this.iScalar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScaledDurationField)) {
            return false;
        }
        ScaledDurationField scaledDurationField = (ScaledDurationField) obj;
        return getWrappedField().equals(scaledDurationField.getWrappedField()) && getType() == scaledDurationField.getType() && this.iScalar == scaledDurationField.iScalar;
    }

    @Override // org.joda.time.field.BaseDurationField, org.joda.time.d
    public int getDifference(long j10, long j11) {
        return getWrappedField().getDifference(j10, j11) / this.iScalar;
    }

    @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.d
    public long getDifferenceAsLong(long j10, long j11) {
        return getWrappedField().getDifferenceAsLong(j10, j11) / this.iScalar;
    }

    @Override // org.joda.time.field.BaseDurationField, org.joda.time.d
    public long getMillis(int i10) {
        return getWrappedField().getMillis(i10 * this.iScalar);
    }

    public int getScalar() {
        return this.iScalar;
    }

    @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.d
    public long getUnitMillis() {
        return getWrappedField().getUnitMillis() * this.iScalar;
    }

    @Override // org.joda.time.field.BaseDurationField, org.joda.time.d
    public int getValue(long j10) {
        return getWrappedField().getValue(j10) / this.iScalar;
    }

    @Override // org.joda.time.field.BaseDurationField, org.joda.time.d
    public long getValueAsLong(long j10) {
        return getWrappedField().getValueAsLong(j10) / this.iScalar;
    }

    public int hashCode() {
        long j10 = this.iScalar;
        return ((int) (j10 ^ (j10 >>> 32))) + getType().hashCode() + getWrappedField().hashCode();
    }

    @Override // org.joda.time.field.BaseDurationField, org.joda.time.d
    public int getValue(long j10, long j11) {
        return getWrappedField().getValue(j10, j11) / this.iScalar;
    }

    @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.d
    public long getValueAsLong(long j10, long j11) {
        return getWrappedField().getValueAsLong(j10, j11) / this.iScalar;
    }

    @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.d
    public long add(long j10, long j11) {
        return getWrappedField().add(j10, e.i(j11, this.iScalar));
    }

    @Override // org.joda.time.field.BaseDurationField, org.joda.time.d
    public long getMillis(long j10) {
        return getWrappedField().getMillis(e.i(j10, this.iScalar));
    }

    @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.d
    public long getMillis(int i10, long j10) {
        return getWrappedField().getMillis(i10 * this.iScalar, j10);
    }

    @Override // org.joda.time.field.DecoratedDurationField, org.joda.time.d
    public long getMillis(long j10, long j11) {
        return getWrappedField().getMillis(e.i(j10, this.iScalar), j11);
    }
}
