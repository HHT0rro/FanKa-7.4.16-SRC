package org.joda.time.field;

import org.joda.time.DateTimeFieldType;

/* compiled from: RemainderDateTimeField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class i extends c {

    /* renamed from: c, reason: collision with root package name */
    public final int f52543c;

    /* renamed from: d, reason: collision with root package name */
    public final org.joda.time.d f52544d;

    /* renamed from: e, reason: collision with root package name */
    public final org.joda.time.d f52545e;

    public i(org.joda.time.b bVar, org.joda.time.d dVar, DateTimeFieldType dateTimeFieldType, int i10) {
        super(bVar, dateTimeFieldType);
        if (i10 >= 2) {
            this.f52545e = dVar;
            this.f52544d = bVar.getDurationField();
            this.f52543c = i10;
            return;
        }
        throw new IllegalArgumentException("The divisor must be at least 2");
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long addWrapField(long j10, int i10) {
        return set(j10, e.c(get(j10), i10, 0, this.f52543c - 1));
    }

    public final int b(int i10) {
        if (i10 >= 0) {
            return i10 / this.f52543c;
        }
        return ((i10 + 1) / this.f52543c) - 1;
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public int get(long j10) {
        int i10 = getWrappedField().get(j10);
        if (i10 >= 0) {
            return i10 % this.f52543c;
        }
        int i11 = this.f52543c;
        return (i11 - 1) + ((i10 + 1) % i11);
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getDurationField() {
        return this.f52544d;
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue() {
        return this.f52543c - 1;
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue() {
        return 0;
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getRangeDurationField() {
        return this.f52545e;
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
        e.n(this, i10, 0, this.f52543c - 1);
        return getWrappedField().set(j10, (b(getWrappedField().get(j10)) * this.f52543c) + i10);
    }

    public i(d dVar) {
        this(dVar, dVar.getType());
    }

    public i(d dVar, DateTimeFieldType dateTimeFieldType) {
        this(dVar, dVar.getWrappedField().getDurationField(), dateTimeFieldType);
    }

    public i(d dVar, org.joda.time.d dVar2, DateTimeFieldType dateTimeFieldType) {
        super(dVar.getWrappedField(), dateTimeFieldType);
        this.f52543c = dVar.f52531c;
        this.f52544d = dVar2;
        this.f52545e = dVar.f52532d;
    }
}
