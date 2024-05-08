package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.field.ImpreciseDateTimeField;

/* compiled from: BasicYearDateTimeField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class g extends ImpreciseDateTimeField {

    /* renamed from: d, reason: collision with root package name */
    public final BasicChronology f52503d;

    public g(BasicChronology basicChronology) {
        super(DateTimeFieldType.year(), basicChronology.getAverageMillisPerYear());
        this.f52503d = basicChronology;
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.b, org.joda.time.b
    public long add(long j10, int i10) {
        return i10 == 0 ? j10 : set(j10, org.joda.time.field.e.d(get(j10), i10));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long addWrapField(long j10, int i10) {
        return i10 == 0 ? j10 : set(j10, org.joda.time.field.e.c(this.f52503d.getYear(j10), i10, this.f52503d.getMinYear(), this.f52503d.getMaxYear()));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int get(long j10) {
        return this.f52503d.getYear(j10);
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.b, org.joda.time.b
    public long getDifferenceAsLong(long j10, long j11) {
        if (j10 < j11) {
            return -this.f52503d.getYearDifference(j11, j10);
        }
        return this.f52503d.getYearDifference(j10, j11);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getLeapAmount(long j10) {
        return this.f52503d.isLeapYear(get(j10)) ? 1 : 0;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getLeapDurationField() {
        return this.f52503d.days();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue() {
        return this.f52503d.getMaxYear();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue() {
        return this.f52503d.getMinYear();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getRangeDurationField() {
        return null;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public boolean isLeap(long j10) {
        return this.f52503d.isLeapYear(get(j10));
    }

    @Override // org.joda.time.b
    public boolean isLenient() {
        return false;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long remainder(long j10) {
        return j10 - roundFloor(j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundCeiling(long j10) {
        int i10 = get(j10);
        return j10 != this.f52503d.getYearMillis(i10) ? this.f52503d.getYearMillis(i10 + 1) : j10;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long roundFloor(long j10) {
        return this.f52503d.getYearMillis(get(j10));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long set(long j10, int i10) {
        org.joda.time.field.e.n(this, i10, this.f52503d.getMinYear(), this.f52503d.getMaxYear());
        return this.f52503d.setYear(j10, i10);
    }

    @Override // org.joda.time.b
    public long setExtended(long j10, int i10) {
        org.joda.time.field.e.n(this, i10, this.f52503d.getMinYear() - 1, this.f52503d.getMaxYear() + 1);
        return this.f52503d.setYear(j10, i10);
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.b, org.joda.time.b
    public long add(long j10, long j11) {
        return add(j10, org.joda.time.field.e.m(j11));
    }
}
