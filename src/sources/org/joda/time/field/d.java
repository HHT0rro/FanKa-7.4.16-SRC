package org.joda.time.field;

import org.joda.time.DateTimeFieldType;

/* compiled from: DividedDateTimeField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class d extends c {

    /* renamed from: c, reason: collision with root package name */
    public final int f52531c;

    /* renamed from: d, reason: collision with root package name */
    public final org.joda.time.d f52532d;

    /* renamed from: e, reason: collision with root package name */
    public final org.joda.time.d f52533e;

    /* renamed from: f, reason: collision with root package name */
    public final int f52534f;

    /* renamed from: g, reason: collision with root package name */
    public final int f52535g;

    public d(org.joda.time.b bVar, DateTimeFieldType dateTimeFieldType, int i10) {
        this(bVar, bVar.getRangeDurationField(), dateTimeFieldType, i10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long add(long j10, int i10) {
        return getWrappedField().add(j10, i10 * this.f52531c);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long addWrapField(long j10, int i10) {
        return set(j10, e.c(get(j10), i10, this.f52534f, this.f52535g));
    }

    public final int b(int i10) {
        if (i10 >= 0) {
            return i10 % this.f52531c;
        }
        int i11 = this.f52531c;
        return (i11 - 1) + ((i10 + 1) % i11);
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public int get(long j10) {
        int i10 = getWrappedField().get(j10);
        if (i10 >= 0) {
            return i10 / this.f52531c;
        }
        return ((i10 + 1) / this.f52531c) - 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getDifference(long j10, long j11) {
        return getWrappedField().getDifference(j10, j11) / this.f52531c;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long getDifferenceAsLong(long j10, long j11) {
        return getWrappedField().getDifferenceAsLong(j10, j11) / this.f52531c;
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getDurationField() {
        return this.f52532d;
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue() {
        return this.f52535g;
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue() {
        return this.f52534f;
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getRangeDurationField() {
        org.joda.time.d dVar = this.f52533e;
        return dVar != null ? dVar : super.getRangeDurationField();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long remainder(long j10) {
        return set(j10, get(getWrappedField().remainder(j10)));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundFloor(long j10) {
        org.joda.time.b wrappedField = getWrappedField();
        return wrappedField.roundFloor(wrappedField.set(j10, get(j10) * this.f52531c));
    }

    @Override // org.joda.time.field.c, org.joda.time.field.b, org.joda.time.b
    public long set(long j10, int i10) {
        e.n(this, i10, this.f52534f, this.f52535g);
        return getWrappedField().set(j10, (i10 * this.f52531c) + b(getWrappedField().get(j10)));
    }

    public d(org.joda.time.b bVar, org.joda.time.d dVar, DateTimeFieldType dateTimeFieldType, int i10) {
        super(bVar, dateTimeFieldType);
        if (i10 >= 2) {
            org.joda.time.d durationField = bVar.getDurationField();
            if (durationField == null) {
                this.f52532d = null;
            } else {
                this.f52532d = new ScaledDurationField(durationField, dateTimeFieldType.getDurationType(), i10);
            }
            this.f52533e = dVar;
            this.f52531c = i10;
            int minimumValue = bVar.getMinimumValue();
            int i11 = minimumValue >= 0 ? minimumValue / i10 : ((minimumValue + 1) / i10) - 1;
            int maximumValue = bVar.getMaximumValue();
            int i12 = maximumValue >= 0 ? maximumValue / i10 : ((maximumValue + 1) / i10) - 1;
            this.f52534f = i11;
            this.f52535g = i12;
            return;
        }
        throw new IllegalArgumentException("The divisor must be at least 2");
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long add(long j10, long j11) {
        return getWrappedField().add(j10, j11 * this.f52531c);
    }
}
