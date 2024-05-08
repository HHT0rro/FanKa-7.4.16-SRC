package org.joda.time.chrono;

import org.joda.time.DateTimeFieldType;
import org.joda.time.field.ImpreciseDateTimeField;

/* compiled from: BasicMonthOfYearDateTimeField.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class c extends ImpreciseDateTimeField {

    /* renamed from: d, reason: collision with root package name */
    public final BasicChronology f52497d;

    /* renamed from: e, reason: collision with root package name */
    public final int f52498e;

    /* renamed from: f, reason: collision with root package name */
    public final int f52499f;

    public c(BasicChronology basicChronology, int i10) {
        super(DateTimeFieldType.monthOfYear(), basicChronology.getAverageMillisPerMonth());
        this.f52497d = basicChronology;
        this.f52498e = basicChronology.getMaxMonth();
        this.f52499f = i10;
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.b, org.joda.time.b
    public long add(long j10, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        if (i10 == 0) {
            return j10;
        }
        long millisOfDay = this.f52497d.getMillisOfDay(j10);
        int year = this.f52497d.getYear(j10);
        int monthOfYear = this.f52497d.getMonthOfYear(j10, year);
        int i16 = monthOfYear - 1;
        int i17 = i16 + i10;
        if (monthOfYear <= 0 || i17 >= 0) {
            i11 = year;
        } else {
            if (Math.signum(this.f52498e + i10) == Math.signum(i10)) {
                i14 = year - 1;
                i15 = i10 + this.f52498e;
            } else {
                i14 = year + 1;
                i15 = i10 - this.f52498e;
            }
            int i18 = i14;
            i17 = i15 + i16;
            i11 = i18;
        }
        if (i17 >= 0) {
            int i19 = this.f52498e;
            i12 = i11 + (i17 / i19);
            i13 = (i17 % i19) + 1;
        } else {
            i12 = (i11 + (i17 / this.f52498e)) - 1;
            int abs = Math.abs(i17);
            int i20 = this.f52498e;
            int i21 = abs % i20;
            if (i21 == 0) {
                i21 = i20;
            }
            i13 = (i20 - i21) + 1;
            if (i13 == 1) {
                i12++;
            }
        }
        int dayOfMonth = this.f52497d.getDayOfMonth(j10, year, monthOfYear);
        int daysInYearMonth = this.f52497d.getDaysInYearMonth(i12, i13);
        if (dayOfMonth > daysInYearMonth) {
            dayOfMonth = daysInYearMonth;
        }
        return this.f52497d.getYearMonthDayMillis(i12, i13, dayOfMonth) + millisOfDay;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long addWrapField(long j10, int i10) {
        return set(j10, org.joda.time.field.e.c(get(j10), i10, 1, this.f52498e));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int get(long j10) {
        return this.f52497d.getMonthOfYear(j10);
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.b, org.joda.time.b
    public long getDifferenceAsLong(long j10, long j11) {
        if (j10 < j11) {
            return -getDifference(j11, j10);
        }
        int year = this.f52497d.getYear(j10);
        int monthOfYear = this.f52497d.getMonthOfYear(j10, year);
        int year2 = this.f52497d.getYear(j11);
        int monthOfYear2 = this.f52497d.getMonthOfYear(j11, year2);
        long j12 = (((year - year2) * this.f52498e) + monthOfYear) - monthOfYear2;
        int dayOfMonth = this.f52497d.getDayOfMonth(j10, year, monthOfYear);
        if (dayOfMonth == this.f52497d.getDaysInYearMonth(year, monthOfYear) && this.f52497d.getDayOfMonth(j11, year2, monthOfYear2) > dayOfMonth) {
            j11 = this.f52497d.dayOfMonth().set(j11, dayOfMonth);
        }
        return j10 - this.f52497d.getYearMonthMillis(year, monthOfYear) < j11 - this.f52497d.getYearMonthMillis(year2, monthOfYear2) ? j12 - 1 : j12;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getLeapAmount(long j10) {
        return isLeap(j10) ? 1 : 0;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getLeapDurationField() {
        return this.f52497d.days();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue() {
        return this.f52498e;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue() {
        return 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public org.joda.time.d getRangeDurationField() {
        return this.f52497d.years();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public boolean isLeap(long j10) {
        int year = this.f52497d.getYear(j10);
        return this.f52497d.isLeapYear(year) && this.f52497d.getMonthOfYear(j10, year) == this.f52499f;
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
        int year = this.f52497d.getYear(j10);
        return this.f52497d.getYearMonthMillis(year, this.f52497d.getMonthOfYear(j10, year));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long set(long j10, int i10) {
        org.joda.time.field.e.n(this, i10, 1, this.f52498e);
        int year = this.f52497d.getYear(j10);
        int dayOfMonth = this.f52497d.getDayOfMonth(j10, year);
        int daysInYearMonth = this.f52497d.getDaysInYearMonth(year, i10);
        if (dayOfMonth > daysInYearMonth) {
            dayOfMonth = daysInYearMonth;
        }
        return this.f52497d.getYearMonthDayMillis(year, i10, dayOfMonth) + this.f52497d.getMillisOfDay(j10);
    }

    @Override // org.joda.time.field.ImpreciseDateTimeField, org.joda.time.field.b, org.joda.time.b
    public long add(long j10, long j11) {
        long j12;
        long j13;
        int i10 = (int) j11;
        if (i10 == j11) {
            return add(j10, i10);
        }
        long millisOfDay = this.f52497d.getMillisOfDay(j10);
        int year = this.f52497d.getYear(j10);
        int monthOfYear = this.f52497d.getMonthOfYear(j10, year);
        long j14 = (monthOfYear - 1) + j11;
        if (j14 >= 0) {
            int i11 = this.f52498e;
            j12 = year + (j14 / i11);
            j13 = (j14 % i11) + 1;
        } else {
            j12 = (year + (j14 / this.f52498e)) - 1;
            long abs = Math.abs(j14);
            int i12 = this.f52498e;
            int i13 = (int) (abs % i12);
            if (i13 == 0) {
                i13 = i12;
            }
            j13 = (i12 - i13) + 1;
            if (j13 == 1) {
                j12++;
            }
        }
        if (j12 >= this.f52497d.getMinYear() && j12 <= this.f52497d.getMaxYear()) {
            int i14 = (int) j12;
            int i15 = (int) j13;
            int dayOfMonth = this.f52497d.getDayOfMonth(j10, year, monthOfYear);
            int daysInYearMonth = this.f52497d.getDaysInYearMonth(i14, i15);
            if (dayOfMonth > daysInYearMonth) {
                dayOfMonth = daysInYearMonth;
            }
            return this.f52497d.getYearMonthDayMillis(i14, i15, dayOfMonth) + millisOfDay;
        }
        throw new IllegalArgumentException("Magnitude of add amount is too large: " + j11);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int[] add(org.joda.time.k kVar, int i10, int[] iArr, int i11) {
        if (i11 == 0) {
            return iArr;
        }
        if (kVar.size() > 0 && kVar.getFieldType(0).equals(DateTimeFieldType.monthOfYear()) && i10 == 0) {
            return set(kVar, 0, iArr, ((((iArr[0] - 1) + (i11 % 12)) + 12) % 12) + 1);
        }
        if (org.joda.time.c.n(kVar)) {
            long j10 = 0;
            int size = kVar.size();
            for (int i12 = 0; i12 < size; i12++) {
                j10 = kVar.getFieldType(i12).getField(this.f52497d).set(j10, iArr[i12]);
            }
            return this.f52497d.get(kVar, add(j10, i11));
        }
        return super.add(kVar, i10, iArr, i11);
    }
}
