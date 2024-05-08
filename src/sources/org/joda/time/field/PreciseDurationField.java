package org.joda.time.field;

import org.joda.time.DurationFieldType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class PreciseDurationField extends BaseDurationField {
    private static final long serialVersionUID = -8346152187724495365L;
    private final long iUnitMillis;

    public PreciseDurationField(DurationFieldType durationFieldType, long j10) {
        super(durationFieldType);
        this.iUnitMillis = j10;
    }

    @Override // org.joda.time.d
    public long add(long j10, int i10) {
        return e.e(j10, i10 * this.iUnitMillis);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreciseDurationField)) {
            return false;
        }
        PreciseDurationField preciseDurationField = (PreciseDurationField) obj;
        return getType() == preciseDurationField.getType() && this.iUnitMillis == preciseDurationField.iUnitMillis;
    }

    @Override // org.joda.time.d
    public long getDifferenceAsLong(long j10, long j11) {
        return e.l(j10, j11) / this.iUnitMillis;
    }

    @Override // org.joda.time.d
    public long getMillis(int i10, long j10) {
        return i10 * this.iUnitMillis;
    }

    @Override // org.joda.time.d
    public final long getUnitMillis() {
        return this.iUnitMillis;
    }

    @Override // org.joda.time.d
    public long getValueAsLong(long j10, long j11) {
        return j10 / this.iUnitMillis;
    }

    public int hashCode() {
        long j10 = this.iUnitMillis;
        return ((int) (j10 ^ (j10 >>> 32))) + getType().hashCode();
    }

    @Override // org.joda.time.d
    public final boolean isPrecise() {
        return true;
    }

    @Override // org.joda.time.d
    public long getMillis(long j10, long j11) {
        return e.j(j10, this.iUnitMillis);
    }

    @Override // org.joda.time.d
    public long add(long j10, long j11) {
        return e.e(j10, e.j(j11, this.iUnitMillis));
    }
}
