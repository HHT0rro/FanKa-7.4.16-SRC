package org.joda.time.field;

import org.joda.time.DateTimeFieldType;

/* compiled from: PreciseDurationDateTimeField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class h extends b {

    /* renamed from: b, reason: collision with root package name */
    public final long f52541b;

    /* renamed from: c, reason: collision with root package name */
    public final org.joda.time.d f52542c;

    public h(DateTimeFieldType dateTimeFieldType, org.joda.time.d dVar) {
        super(dateTimeFieldType);
        if (dVar.isPrecise()) {
            long unitMillis = dVar.getUnitMillis();
            this.f52541b = unitMillis;
            if (unitMillis >= 1) {
                this.f52542c = dVar;
                return;
            }
            throw new IllegalArgumentException("The unit milliseconds must be at least 1");
        }
        throw new IllegalArgumentException("Unit duration field must be precise");
    }

    public int b(long j10, int i10) {
        return getMaximumValue(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getDurationField() {
        return this.f52542c;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue() {
        return 0;
    }

    @Override // org.joda.time.b
    public boolean isLenient() {
        return false;
    }

    public final long j() {
        return this.f52541b;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long remainder(long j10) {
        if (j10 >= 0) {
            return j10 % this.f52541b;
        }
        long j11 = this.f52541b;
        return (((j10 + 1) % j11) + j11) - 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundCeiling(long j10) {
        if (j10 > 0) {
            long j11 = j10 - 1;
            long j12 = this.f52541b;
            return (j11 - (j11 % j12)) + j12;
        }
        return j10 - (j10 % this.f52541b);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundFloor(long j10) {
        long j11;
        if (j10 >= 0) {
            j11 = j10 % this.f52541b;
        } else {
            long j12 = j10 + 1;
            j11 = this.f52541b;
            j10 = j12 - (j12 % j11);
        }
        return j10 - j11;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long set(long j10, int i10) {
        e.n(this, i10, getMinimumValue(), b(j10, i10));
        return j10 + ((i10 - get(j10)) * this.f52541b);
    }
}
