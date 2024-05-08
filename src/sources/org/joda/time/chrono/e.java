package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;

/* compiled from: BasicWeekOfWeekyearDateTimeField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class e extends org.joda.time.field.h {

    /* renamed from: d, reason: collision with root package name */
    public final BasicChronology f52501d;

    public e(BasicChronology basicChronology, org.joda.time.d dVar) {
        super(DateTimeFieldType.weekOfWeekyear(), dVar);
        this.f52501d = basicChronology;
    }

    @Override // org.joda.time.field.h
    public int b(long j10, int i10) {
        if (i10 > 52) {
            return getMaximumValue(j10);
        }
        return 52;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int get(long j10) {
        return this.f52501d.getWeekOfWeekyear(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue() {
        return 53;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue(long j10) {
        return this.f52501d.getWeeksInYear(this.f52501d.getWeekyear(j10));
    }

    @Override // org.joda.time.field.h, org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue() {
        return 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getRangeDurationField() {
        return this.f52501d.weekyears();
    }

    @Override // org.joda.time.field.h, org.joda.time.field.b, org.joda.time.b
    public long remainder(long j10) {
        return super.remainder(j10 + 259200000);
    }

    @Override // org.joda.time.field.h, org.joda.time.field.b, org.joda.time.b
    public long roundCeiling(long j10) {
        return super.roundCeiling(j10 + 259200000) - 259200000;
    }

    @Override // org.joda.time.field.h, org.joda.time.field.b, org.joda.time.b
    public long roundFloor(long j10) {
        return super.roundFloor(j10 + 259200000) - 259200000;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue(org.joda.time.k kVar) {
        if (!kVar.isSupported(DateTimeFieldType.weekyear())) {
            return 53;
        }
        return this.f52501d.getWeeksInYear(kVar.get(DateTimeFieldType.weekyear()));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue(org.joda.time.k kVar, int[] iArr) {
        int size = kVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (kVar.getFieldType(i10) == DateTimeFieldType.weekyear()) {
                return this.f52501d.getWeeksInYear(iArr[i10]);
            }
        }
        return 53;
    }
}
