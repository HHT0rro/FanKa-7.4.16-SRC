package org.joda.time.field;

import org.joda.time.DateTimeFieldType;

/* compiled from: DecoratedDateTimeField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class c extends b {

    /* renamed from: b, reason: collision with root package name */
    public final org.joda.time.b f52530b;

    public c(org.joda.time.b bVar, DateTimeFieldType dateTimeFieldType) {
        super(dateTimeFieldType);
        if (bVar != null) {
            if (bVar.isSupported()) {
                this.f52530b = bVar;
                return;
            }
            throw new IllegalArgumentException("The field must be supported");
        }
        throw new IllegalArgumentException("The field must not be null");
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int get(long j10) {
        return this.f52530b.get(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getDurationField() {
        return this.f52530b.getDurationField();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue() {
        return this.f52530b.getMaximumValue();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue() {
        return this.f52530b.getMinimumValue();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getRangeDurationField() {
        return this.f52530b.getRangeDurationField();
    }

    public final org.joda.time.b getWrappedField() {
        return this.f52530b;
    }

    @Override // org.joda.time.b
    public boolean isLenient() {
        return this.f52530b.isLenient();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long set(long j10, int i10) {
        return this.f52530b.set(j10, i10);
    }
}
