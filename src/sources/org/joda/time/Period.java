package org.joda.time;

import com.baidu.mobads.sdk.internal.bk;
import org.joda.convert.FromString;
import org.joda.time.base.BasePeriod;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Period extends BasePeriod {
    public static final Period ZERO = new Period();
    private static final long serialVersionUID = 741052353876488155L;

    public Period() {
        super(0L, (PeriodType) null, (a) null);
    }

    private void checkYearsAndMonths(String str) {
        if (getMonths() == 0) {
            if (getYears() == 0) {
                return;
            }
            throw new UnsupportedOperationException("Cannot convert to " + str + " as this period contains years and years vary in length");
        }
        throw new UnsupportedOperationException("Cannot convert to " + str + " as this period contains months and months vary in length");
    }

    public static Period days(int i10) {
        return new Period(new int[]{0, 0, 0, i10, 0, 0, 0, 0}, PeriodType.standard());
    }

    public static Period fieldDifference(k kVar, k kVar2) {
        if (kVar != null && kVar2 != null) {
            if (kVar.size() == kVar2.size()) {
                DurationFieldType[] durationFieldTypeArr = new DurationFieldType[kVar.size()];
                int[] iArr = new int[kVar.size()];
                int size = kVar.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (kVar.getFieldType(i10) == kVar2.getFieldType(i10)) {
                        durationFieldTypeArr[i10] = kVar.getFieldType(i10).getDurationType();
                        if (i10 > 0 && durationFieldTypeArr[i10 - 1] == durationFieldTypeArr[i10]) {
                            throw new IllegalArgumentException("ReadablePartial objects must not have overlapping fields");
                        }
                        iArr[i10] = kVar2.getValue(i10) - kVar.getValue(i10);
                    } else {
                        throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
                    }
                }
                return new Period(iArr, PeriodType.forFields(durationFieldTypeArr));
            }
            throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
        }
        throw new IllegalArgumentException("ReadablePartial objects must not be null");
    }

    public static Period hours(int i10) {
        return new Period(new int[]{0, 0, 0, 0, i10, 0, 0, 0}, PeriodType.standard());
    }

    public static Period millis(int i10) {
        return new Period(new int[]{0, 0, 0, 0, 0, 0, 0, i10}, PeriodType.standard());
    }

    public static Period minutes(int i10) {
        return new Period(new int[]{0, 0, 0, 0, 0, i10, 0, 0}, PeriodType.standard());
    }

    public static Period months(int i10) {
        return new Period(new int[]{0, i10, 0, 0, 0, 0, 0, 0}, PeriodType.standard());
    }

    @FromString
    public static Period parse(String str) {
        return parse(str, org.joda.time.format.j.a());
    }

    public static Period seconds(int i10) {
        return new Period(new int[]{0, 0, 0, 0, 0, 0, i10, 0}, PeriodType.standard());
    }

    public static Period weeks(int i10) {
        return new Period(new int[]{0, 0, i10, 0, 0, 0, 0, 0}, PeriodType.standard());
    }

    public static Period years(int i10) {
        return new Period(new int[]{i10, 0, 0, 0, 0, 0, 0, 0}, PeriodType.standard());
    }

    public int getDays() {
        return getPeriodType().getIndexedField(this, PeriodType.DAY_INDEX);
    }

    public int getHours() {
        return getPeriodType().getIndexedField(this, PeriodType.HOUR_INDEX);
    }

    public int getMillis() {
        return getPeriodType().getIndexedField(this, PeriodType.MILLI_INDEX);
    }

    public int getMinutes() {
        return getPeriodType().getIndexedField(this, PeriodType.MINUTE_INDEX);
    }

    public int getMonths() {
        return getPeriodType().getIndexedField(this, PeriodType.MONTH_INDEX);
    }

    public int getSeconds() {
        return getPeriodType().getIndexedField(this, PeriodType.SECOND_INDEX);
    }

    public int getWeeks() {
        return getPeriodType().getIndexedField(this, PeriodType.WEEK_INDEX);
    }

    public int getYears() {
        return getPeriodType().getIndexedField(this, PeriodType.YEAR_INDEX);
    }

    public Period minus(l lVar) {
        if (lVar == null) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.YEAR_INDEX, values, -lVar.get(DurationFieldType.YEARS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MONTH_INDEX, values, -lVar.get(DurationFieldType.MONTHS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.WEEK_INDEX, values, -lVar.get(DurationFieldType.WEEKS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.DAY_INDEX, values, -lVar.get(DurationFieldType.DAYS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.HOUR_INDEX, values, -lVar.get(DurationFieldType.HOURS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MINUTE_INDEX, values, -lVar.get(DurationFieldType.MINUTES_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.SECOND_INDEX, values, -lVar.get(DurationFieldType.SECONDS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MILLI_INDEX, values, -lVar.get(DurationFieldType.MILLIS_TYPE));
        return new Period(values, getPeriodType());
    }

    public Period minusDays(int i10) {
        return plusDays(-i10);
    }

    public Period minusHours(int i10) {
        return plusHours(-i10);
    }

    public Period minusMillis(int i10) {
        return plusMillis(-i10);
    }

    public Period minusMinutes(int i10) {
        return plusMinutes(-i10);
    }

    public Period minusMonths(int i10) {
        return plusMonths(-i10);
    }

    public Period minusSeconds(int i10) {
        return plusSeconds(-i10);
    }

    public Period minusWeeks(int i10) {
        return plusWeeks(-i10);
    }

    public Period minusYears(int i10) {
        return plusYears(-i10);
    }

    public Period multipliedBy(int i10) {
        if (this == ZERO || i10 == 1) {
            return this;
        }
        int[] values = getValues();
        for (int i11 = 0; i11 < values.length; i11++) {
            values[i11] = org.joda.time.field.e.h(values[i11], i10);
        }
        return new Period(values, getPeriodType());
    }

    public Period negated() {
        return multipliedBy(-1);
    }

    public Period normalizedStandard() {
        return normalizedStandard(PeriodType.standard());
    }

    public Period plus(l lVar) {
        if (lVar == null) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.YEAR_INDEX, values, lVar.get(DurationFieldType.YEARS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MONTH_INDEX, values, lVar.get(DurationFieldType.MONTHS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.WEEK_INDEX, values, lVar.get(DurationFieldType.WEEKS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.DAY_INDEX, values, lVar.get(DurationFieldType.DAYS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.HOUR_INDEX, values, lVar.get(DurationFieldType.HOURS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MINUTE_INDEX, values, lVar.get(DurationFieldType.MINUTES_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.SECOND_INDEX, values, lVar.get(DurationFieldType.SECONDS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MILLI_INDEX, values, lVar.get(DurationFieldType.MILLIS_TYPE));
        return new Period(values, getPeriodType());
    }

    public Period plusDays(int i10) {
        if (i10 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.DAY_INDEX, values, i10);
        return new Period(values, getPeriodType());
    }

    public Period plusHours(int i10) {
        if (i10 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.HOUR_INDEX, values, i10);
        return new Period(values, getPeriodType());
    }

    public Period plusMillis(int i10) {
        if (i10 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.MILLI_INDEX, values, i10);
        return new Period(values, getPeriodType());
    }

    public Period plusMinutes(int i10) {
        if (i10 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.MINUTE_INDEX, values, i10);
        return new Period(values, getPeriodType());
    }

    public Period plusMonths(int i10) {
        if (i10 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.MONTH_INDEX, values, i10);
        return new Period(values, getPeriodType());
    }

    public Period plusSeconds(int i10) {
        if (i10 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.SECOND_INDEX, values, i10);
        return new Period(values, getPeriodType());
    }

    public Period plusWeeks(int i10) {
        if (i10 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.WEEK_INDEX, values, i10);
        return new Period(values, getPeriodType());
    }

    public Period plusYears(int i10) {
        if (i10 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.YEAR_INDEX, values, i10);
        return new Period(values, getPeriodType());
    }

    @Override // je.f
    public Period toPeriod() {
        return this;
    }

    public Days toStandardDays() {
        checkYearsAndMonths("Days");
        return Days.days(org.joda.time.field.e.m(org.joda.time.field.e.e(org.joda.time.field.e.e((((getMillis() + (getSeconds() * 1000)) + (getMinutes() * 60000)) + (getHours() * 3600000)) / 86400000, getDays()), getWeeks() * 7)));
    }

    public Duration toStandardDuration() {
        checkYearsAndMonths("Duration");
        return new Duration(getMillis() + (getSeconds() * 1000) + (getMinutes() * 60000) + (getHours() * 3600000) + (getDays() * 86400000) + (getWeeks() * bk.f9895d));
    }

    public Hours toStandardHours() {
        checkYearsAndMonths("Hours");
        return Hours.hours(org.joda.time.field.e.m(org.joda.time.field.e.e(org.joda.time.field.e.e(org.joda.time.field.e.e(((getMillis() + (getSeconds() * 1000)) + (getMinutes() * 60000)) / 3600000, getHours()), getDays() * 24), getWeeks() * 168)));
    }

    public Minutes toStandardMinutes() {
        checkYearsAndMonths("Minutes");
        return Minutes.minutes(org.joda.time.field.e.m(org.joda.time.field.e.e(org.joda.time.field.e.e(org.joda.time.field.e.e(org.joda.time.field.e.e((getMillis() + (getSeconds() * 1000)) / 60000, getMinutes()), getHours() * 60), getDays() * 1440), getWeeks() * 10080)));
    }

    public Seconds toStandardSeconds() {
        checkYearsAndMonths("Seconds");
        return Seconds.seconds(org.joda.time.field.e.m(org.joda.time.field.e.e(org.joda.time.field.e.e(org.joda.time.field.e.e(org.joda.time.field.e.e(org.joda.time.field.e.e(getMillis() / 1000, getSeconds()), getMinutes() * 60), getHours() * 3600), getDays() * 86400), getWeeks() * 604800)));
    }

    public Weeks toStandardWeeks() {
        checkYearsAndMonths("Weeks");
        return Weeks.weeks(org.joda.time.field.e.m(getWeeks() + (((((getMillis() + (getSeconds() * 1000)) + (getMinutes() * 60000)) + (getHours() * 3600000)) + (getDays() * 86400000)) / bk.f9895d)));
    }

    public Period withDays(int i10) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.DAY_INDEX, values, i10);
        return new Period(values, getPeriodType());
    }

    public Period withField(DurationFieldType durationFieldType, int i10) {
        if (durationFieldType != null) {
            int[] values = getValues();
            super.setFieldInto(values, durationFieldType, i10);
            return new Period(values, getPeriodType());
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public Period withFieldAdded(DurationFieldType durationFieldType, int i10) {
        if (durationFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        }
        if (i10 == 0) {
            return this;
        }
        int[] values = getValues();
        super.addFieldInto(values, durationFieldType, i10);
        return new Period(values, getPeriodType());
    }

    public Period withFields(l lVar) {
        return lVar == null ? this : new Period(super.mergePeriodInto(getValues(), lVar), getPeriodType());
    }

    public Period withHours(int i10) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.HOUR_INDEX, values, i10);
        return new Period(values, getPeriodType());
    }

    public Period withMillis(int i10) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.MILLI_INDEX, values, i10);
        return new Period(values, getPeriodType());
    }

    public Period withMinutes(int i10) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.MINUTE_INDEX, values, i10);
        return new Period(values, getPeriodType());
    }

    public Period withMonths(int i10) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.MONTH_INDEX, values, i10);
        return new Period(values, getPeriodType());
    }

    public Period withPeriodType(PeriodType periodType) {
        PeriodType k10 = c.k(periodType);
        return k10.equals(getPeriodType()) ? this : new Period(this, k10);
    }

    public Period withSeconds(int i10) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.SECOND_INDEX, values, i10);
        return new Period(values, getPeriodType());
    }

    public Period withWeeks(int i10) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.WEEK_INDEX, values, i10);
        return new Period(values, getPeriodType());
    }

    public Period withYears(int i10) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.YEAR_INDEX, values, i10);
        return new Period(values, getPeriodType());
    }

    public Period(int i10, int i11, int i12, int i13) {
        super(0, 0, 0, 0, i10, i11, i12, i13, PeriodType.standard());
    }

    public static Period parse(String str, n nVar) {
        return nVar.h(str);
    }

    public Period normalizedStandard(PeriodType periodType) {
        PeriodType k10 = c.k(periodType);
        Period period = new Period(getMillis() + (getSeconds() * 1000) + (getMinutes() * 60000) + (getHours() * 3600000) + (getDays() * 86400000) + (getWeeks() * bk.f9895d), k10, ISOChronology.getInstanceUTC());
        int years = getYears();
        int months = getMonths();
        if (years != 0 || months != 0) {
            long j10 = (years * 12) + months;
            if (k10.isSupported(DurationFieldType.YEARS_TYPE)) {
                period = period.withYears(org.joda.time.field.e.m(j10 / 12));
                j10 -= r0 * 12;
            }
            if (k10.isSupported(DurationFieldType.MONTHS_TYPE)) {
                int m10 = org.joda.time.field.e.m(j10);
                j10 -= m10;
                period = period.withMonths(m10);
            }
            if (j10 != 0) {
                throw new UnsupportedOperationException("Unable to normalize as PeriodType is missing either years or months but period has a month/year amount: " + toString());
            }
        }
        return period;
    }

    public Period(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        super(i10, i11, i12, i13, i14, i15, i16, i17, PeriodType.standard());
    }

    public Period(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, PeriodType periodType) {
        super(i10, i11, i12, i13, i14, i15, i16, i17, periodType);
    }

    public Period(long j10) {
        super(j10);
    }

    public Period(long j10, PeriodType periodType) {
        super(j10, periodType, (a) null);
    }

    public Period(long j10, a aVar) {
        super(j10, (PeriodType) null, aVar);
    }

    public Period(long j10, PeriodType periodType, a aVar) {
        super(j10, periodType, aVar);
    }

    public Period(long j10, long j11) {
        super(j10, j11, null, null);
    }

    public Period(long j10, long j11, PeriodType periodType) {
        super(j10, j11, periodType, null);
    }

    public Period(long j10, long j11, a aVar) {
        super(j10, j11, null, aVar);
    }

    public Period(long j10, long j11, PeriodType periodType, a aVar) {
        super(j10, j11, periodType, aVar);
    }

    public Period(i iVar, i iVar2) {
        super(iVar, iVar2, (PeriodType) null);
    }

    public Period(i iVar, i iVar2, PeriodType periodType) {
        super(iVar, iVar2, periodType);
    }

    public Period(k kVar, k kVar2) {
        super(kVar, kVar2, (PeriodType) null);
    }

    public Period(k kVar, k kVar2, PeriodType periodType) {
        super(kVar, kVar2, periodType);
    }

    public Period(i iVar, h hVar) {
        super(iVar, hVar, (PeriodType) null);
    }

    public Period(i iVar, h hVar, PeriodType periodType) {
        super(iVar, hVar, periodType);
    }

    public Period(h hVar, i iVar) {
        super(hVar, iVar, (PeriodType) null);
    }

    public Period(h hVar, i iVar, PeriodType periodType) {
        super(hVar, iVar, periodType);
    }

    public Period(Object obj) {
        super(obj, (PeriodType) null, (a) null);
    }

    public Period(Object obj, PeriodType periodType) {
        super(obj, periodType, (a) null);
    }

    public Period(Object obj, a aVar) {
        super(obj, (PeriodType) null, aVar);
    }

    public Period(Object obj, PeriodType periodType, a aVar) {
        super(obj, periodType, aVar);
    }

    private Period(int[] iArr, PeriodType periodType) {
        super(iArr, periodType);
    }
}
