package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;

/* compiled from: BasicDayOfMonthDateTimeField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a extends org.joda.time.field.h {

    /* renamed from: d, reason: collision with root package name */
    public final BasicChronology f52495d;

    public a(BasicChronology basicChronology, org.joda.time.d dVar) {
        super(DateTimeFieldType.dayOfMonth(), dVar);
        this.f52495d = basicChronology;
    }

    @Override // org.joda.time.field.h
    public int b(long j10, int i10) {
        return this.f52495d.getDaysInMonthMaxForSet(j10, i10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int get(long j10) {
        return this.f52495d.getDayOfMonth(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue() {
        return this.f52495d.getDaysInMonthMax();
    }

    @Override // org.joda.time.field.h, org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue() {
        return 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getRangeDurationField() {
        return this.f52495d.months();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public boolean isLeap(long j10) {
        return this.f52495d.isLeapDay(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue(long j10) {
        return this.f52495d.getDaysInMonthMax(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue(org.joda.time.k kVar) {
        if (kVar.isSupported(DateTimeFieldType.monthOfYear())) {
            int i10 = kVar.get(DateTimeFieldType.monthOfYear());
            if (kVar.isSupported(DateTimeFieldType.year())) {
                return this.f52495d.getDaysInYearMonth(kVar.get(DateTimeFieldType.year()), i10);
            }
            return this.f52495d.getDaysInMonthMax(i10);
        }
        return getMaximumValue();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue(org.joda.time.k kVar, int[] iArr) {
        int size = kVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (kVar.getFieldType(i10) == DateTimeFieldType.monthOfYear()) {
                int i11 = iArr[i10];
                for (int i12 = 0; i12 < size; i12++) {
                    if (kVar.getFieldType(i12) == DateTimeFieldType.year()) {
                        return this.f52495d.getDaysInYearMonth(iArr[i12], i11);
                    }
                }
                return this.f52495d.getDaysInMonthMax(i11);
            }
        }
        return getMaximumValue();
    }
}
