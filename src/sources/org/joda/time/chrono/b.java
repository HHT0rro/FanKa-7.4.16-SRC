package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;

/* compiled from: BasicDayOfYearDateTimeField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b extends org.joda.time.field.h {

    /* renamed from: d, reason: collision with root package name */
    public final BasicChronology f52496d;

    public b(BasicChronology basicChronology, org.joda.time.d dVar) {
        super(DateTimeFieldType.dayOfYear(), dVar);
        this.f52496d = basicChronology;
    }

    @Override // org.joda.time.field.h
    public int b(long j10, int i10) {
        int daysInYearMax = this.f52496d.getDaysInYearMax() - 1;
        return (i10 > daysInYearMax || i10 < 1) ? getMaximumValue(j10) : daysInYearMax;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int get(long j10) {
        return this.f52496d.getDayOfYear(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue() {
        return this.f52496d.getDaysInYearMax();
    }

    @Override // org.joda.time.field.h, org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue() {
        return 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getRangeDurationField() {
        return this.f52496d.years();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public boolean isLeap(long j10) {
        return this.f52496d.isLeapDay(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue(long j10) {
        return this.f52496d.getDaysInYear(this.f52496d.getYear(j10));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue(org.joda.time.k kVar) {
        if (kVar.isSupported(DateTimeFieldType.year())) {
            return this.f52496d.getDaysInYear(kVar.get(DateTimeFieldType.year()));
        }
        return this.f52496d.getDaysInYearMax();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue(org.joda.time.k kVar, int[] iArr) {
        int size = kVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (kVar.getFieldType(i10) == DateTimeFieldType.year()) {
                return this.f52496d.getDaysInYear(iArr[i10]);
            }
        }
        return this.f52496d.getDaysInYearMax();
    }
}
