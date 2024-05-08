package org.joda.time.field;

import org.joda.time.DateTimeFieldType;

/* compiled from: PreciseDateTimeField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class g extends h {

    /* renamed from: d, reason: collision with root package name */
    public final int f52539d;

    /* renamed from: e, reason: collision with root package name */
    public final org.joda.time.d f52540e;

    public g(DateTimeFieldType dateTimeFieldType, org.joda.time.d dVar, org.joda.time.d dVar2) {
        super(dateTimeFieldType, dVar);
        if (dVar2.isPrecise()) {
            int unitMillis = (int) (dVar2.getUnitMillis() / j());
            this.f52539d = unitMillis;
            if (unitMillis >= 2) {
                this.f52540e = dVar2;
                return;
            }
            throw new IllegalArgumentException("The effective range must be at least 2");
        }
        throw new IllegalArgumentException("Range duration field must be precise");
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long addWrapField(long j10, int i10) {
        int i11 = get(j10);
        return j10 + ((e.c(i11, i10, getMinimumValue(), getMaximumValue()) - i11) * j());
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int get(long j10) {
        if (j10 >= 0) {
            return (int) ((j10 / j()) % this.f52539d);
        }
        return (this.f52539d - 1) + ((int) (((j10 + 1) / j()) % this.f52539d));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue() {
        return this.f52539d - 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getRangeDurationField() {
        return this.f52540e;
    }

    @Override // org.joda.time.field.h, org.joda.time.field.b, org.joda.time.b
    public long set(long j10, int i10) {
        e.n(this, i10, getMinimumValue(), getMaximumValue());
        return j10 + ((i10 - get(j10)) * this.f52541b);
    }
}
