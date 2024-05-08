package org.joda.time.chrono;

import com.baidu.mobads.sdk.internal.bk;
import org.joda.time.DateTimeFieldType;
import org.joda.time.field.ImpreciseDateTimeField;

/* compiled from: BasicWeekyearDateTimeField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class f extends ImpreciseDateTimeField {

    /* renamed from: d, reason: collision with root package name */
    public final BasicChronology f52502d;

    public f(BasicChronology basicChronology) {
        super(DateTimeFieldType.weekyear(), basicChronology.getAverageMillisPerYear());
        this.f52502d = basicChronology;
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.b, org.joda.time.b
    public long add(long j10, int i10) {
        return i10 == 0 ? j10 : set(j10, get(j10) + i10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long addWrapField(long j10, int i10) {
        return add(j10, i10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int get(long j10) {
        return this.f52502d.getWeekyear(j10);
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.b, org.joda.time.b
    public long getDifferenceAsLong(long j10, long j11) {
        if (j10 < j11) {
            return -getDifference(j11, j10);
        }
        int i10 = get(j10);
        int i11 = get(j11);
        long remainder = remainder(j10);
        long remainder2 = remainder(j11);
        if (remainder2 >= 31449600000L && this.f52502d.getWeeksInYear(i10) <= 52) {
            remainder2 -= bk.f9895d;
        }
        int i12 = i10 - i11;
        if (remainder < remainder2) {
            i12--;
        }
        return i12;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getLeapAmount(long j10) {
        BasicChronology basicChronology = this.f52502d;
        return basicChronology.getWeeksInYear(basicChronology.getWeekyear(j10)) - 52;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getLeapDurationField() {
        return this.f52502d.weeks();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue() {
        return this.f52502d.getMaxYear();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue() {
        return this.f52502d.getMinYear();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getRangeDurationField() {
        return null;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public boolean isLeap(long j10) {
        BasicChronology basicChronology = this.f52502d;
        return basicChronology.getWeeksInYear(basicChronology.getWeekyear(j10)) > 52;
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
    public long roundFloor(long j10) {
        long roundFloor = this.f52502d.weekOfWeekyear().roundFloor(j10);
        return this.f52502d.getWeekOfWeekyear(roundFloor) > 1 ? roundFloor - ((r0 - 1) * bk.f9895d) : roundFloor;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long set(long j10, int i10) {
        org.joda.time.field.e.n(this, Math.abs(i10), this.f52502d.getMinYear(), this.f52502d.getMaxYear());
        int i11 = get(j10);
        if (i11 == i10) {
            return j10;
        }
        int dayOfWeek = this.f52502d.getDayOfWeek(j10);
        int weeksInYear = this.f52502d.getWeeksInYear(i11);
        int weeksInYear2 = this.f52502d.getWeeksInYear(i10);
        if (weeksInYear2 < weeksInYear) {
            weeksInYear = weeksInYear2;
        }
        int weekOfWeekyear = this.f52502d.getWeekOfWeekyear(j10);
        if (weekOfWeekyear <= weeksInYear) {
            weeksInYear = weekOfWeekyear;
        }
        long year = this.f52502d.setYear(j10, i10);
        int i12 = get(year);
        if (i12 < i10) {
            year += bk.f9895d;
        } else if (i12 > i10) {
            year -= bk.f9895d;
        }
        return this.f52502d.dayOfWeek().set(year + ((weeksInYear - this.f52502d.getWeekOfWeekyear(year)) * bk.f9895d), dayOfWeek);
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.b, org.joda.time.b
    public long add(long j10, long j11) {
        return add(j10, org.joda.time.field.e.m(j11));
    }
}
