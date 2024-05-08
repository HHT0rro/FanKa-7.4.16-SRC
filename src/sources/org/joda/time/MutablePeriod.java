package org.joda.time;

import org.joda.convert.FromString;
import org.joda.time.base.BasePeriod;
import org.joda.time.format.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class MutablePeriod extends BasePeriod implements f, Cloneable {
    private static final long serialVersionUID = 3436451121567212165L;

    public MutablePeriod() {
        super(0L, (PeriodType) null, (a) null);
    }

    @FromString
    public static MutablePeriod parse(String str) {
        return parse(str, org.joda.time.format.j.a());
    }

    public void add(DurationFieldType durationFieldType, int i10) {
        super.addField(durationFieldType, i10);
    }

    public void addDays(int i10) {
        super.addField(DurationFieldType.days(), i10);
    }

    public void addHours(int i10) {
        super.addField(DurationFieldType.hours(), i10);
    }

    public void addMillis(int i10) {
        super.addField(DurationFieldType.millis(), i10);
    }

    public void addMinutes(int i10) {
        super.addField(DurationFieldType.minutes(), i10);
    }

    public void addMonths(int i10) {
        super.addField(DurationFieldType.months(), i10);
    }

    public void addSeconds(int i10) {
        super.addField(DurationFieldType.seconds(), i10);
    }

    public void addWeeks(int i10) {
        super.addField(DurationFieldType.weeks(), i10);
    }

    public void addYears(int i10) {
        super.addField(DurationFieldType.years(), i10);
    }

    @Override // org.joda.time.f
    public void clear() {
        super.setValues(new int[size()]);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError("Clone error");
        }
    }

    public MutablePeriod copy() {
        return (MutablePeriod) clone();
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

    @Override // org.joda.time.base.BasePeriod
    public void mergePeriod(l lVar) {
        super.mergePeriod(lVar);
    }

    public void set(DurationFieldType durationFieldType, int i10) {
        super.setField(durationFieldType, i10);
    }

    @Override // org.joda.time.f
    public void setDays(int i10) {
        super.setField(DurationFieldType.days(), i10);
    }

    @Override // org.joda.time.f
    public void setHours(int i10) {
        super.setField(DurationFieldType.hours(), i10);
    }

    @Override // org.joda.time.f
    public void setMillis(int i10) {
        super.setField(DurationFieldType.millis(), i10);
    }

    @Override // org.joda.time.f
    public void setMinutes(int i10) {
        super.setField(DurationFieldType.minutes(), i10);
    }

    @Override // org.joda.time.f
    public void setMonths(int i10) {
        super.setField(DurationFieldType.months(), i10);
    }

    @Override // org.joda.time.base.BasePeriod, org.joda.time.f
    public void setPeriod(l lVar) {
        super.setPeriod(lVar);
    }

    @Override // org.joda.time.f
    public void setSeconds(int i10) {
        super.setField(DurationFieldType.seconds(), i10);
    }

    @Override // org.joda.time.base.BasePeriod, org.joda.time.f
    public void setValue(int i10, int i11) {
        super.setValue(i10, i11);
    }

    @Override // org.joda.time.f
    public void setWeeks(int i10) {
        super.setField(DurationFieldType.weeks(), i10);
    }

    @Override // org.joda.time.f
    public void setYears(int i10) {
        super.setField(DurationFieldType.years(), i10);
    }

    public MutablePeriod(PeriodType periodType) {
        super(0L, periodType, (a) null);
    }

    public static MutablePeriod parse(String str, n nVar) {
        return nVar.h(str).toMutablePeriod();
    }

    public void add(l lVar) {
        super.addPeriod(lVar);
    }

    @Override // org.joda.time.base.BasePeriod
    public void setPeriod(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        super.setPeriod(i10, i11, i12, i13, i14, i15, i16, i17);
    }

    public MutablePeriod(int i10, int i11, int i12, int i13) {
        super(0, 0, 0, 0, i10, i11, i12, i13, PeriodType.standard());
    }

    public void add(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        setPeriod(org.joda.time.field.e.d(getYears(), i10), org.joda.time.field.e.d(getMonths(), i11), org.joda.time.field.e.d(getWeeks(), i12), org.joda.time.field.e.d(getDays(), i13), org.joda.time.field.e.d(getHours(), i14), org.joda.time.field.e.d(getMinutes(), i15), org.joda.time.field.e.d(getSeconds(), i16), org.joda.time.field.e.d(getMillis(), i17));
    }

    public void setPeriod(j jVar) {
        if (jVar == null) {
            setPeriod(0L);
        } else {
            setPeriod(jVar.getStartMillis(), jVar.getEndMillis(), c.c(jVar.getChronology()));
        }
    }

    public MutablePeriod(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        super(i10, i11, i12, i13, i14, i15, i16, i17, PeriodType.standard());
    }

    public MutablePeriod(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, PeriodType periodType) {
        super(i10, i11, i12, i13, i14, i15, i16, i17, periodType);
    }

    public MutablePeriod(long j10) {
        super(j10);
    }

    public void setPeriod(i iVar, i iVar2) {
        if (iVar == iVar2) {
            setPeriod(0L);
        } else {
            setPeriod(c.h(iVar), c.h(iVar2), c.i(iVar, iVar2));
        }
    }

    public MutablePeriod(long j10, PeriodType periodType) {
        super(j10, periodType, (a) null);
    }

    public MutablePeriod(long j10, a aVar) {
        super(j10, (PeriodType) null, aVar);
    }

    public MutablePeriod(long j10, PeriodType periodType, a aVar) {
        super(j10, periodType, aVar);
    }

    public MutablePeriod(long j10, long j11) {
        super(j10, j11, null, null);
    }

    public MutablePeriod(long j10, long j11, PeriodType periodType) {
        super(j10, j11, periodType, null);
    }

    public void setPeriod(long j10, long j11) {
        setPeriod(j10, j11, null);
    }

    public MutablePeriod(long j10, long j11, a aVar) {
        super(j10, j11, null, aVar);
    }

    public void add(j jVar) {
        if (jVar != null) {
            add(jVar.toPeriod(getPeriodType()));
        }
    }

    public void setPeriod(long j10, long j11, a aVar) {
        setValues(c.c(aVar).get(this, j10, j11));
    }

    public MutablePeriod(long j10, long j11, PeriodType periodType, a aVar) {
        super(j10, j11, periodType, aVar);
    }

    public void add(h hVar) {
        if (hVar != null) {
            add(new Period(hVar.getMillis(), getPeriodType()));
        }
    }

    public MutablePeriod(i iVar, i iVar2) {
        super(iVar, iVar2, (PeriodType) null);
    }

    public void add(long j10) {
        add(new Period(j10, getPeriodType()));
    }

    public void setPeriod(h hVar) {
        setPeriod(hVar, (a) null);
    }

    public MutablePeriod(i iVar, i iVar2, PeriodType periodType) {
        super(iVar, iVar2, periodType);
    }

    public void add(long j10, a aVar) {
        add(new Period(j10, getPeriodType(), aVar));
    }

    public void setPeriod(h hVar, a aVar) {
        setPeriod(c.f(hVar), aVar);
    }

    public MutablePeriod(i iVar, h hVar) {
        super(iVar, hVar, (PeriodType) null);
    }

    public MutablePeriod(i iVar, h hVar, PeriodType periodType) {
        super(iVar, hVar, periodType);
    }

    public void setPeriod(long j10) {
        setPeriod(j10, (a) null);
    }

    public MutablePeriod(h hVar, i iVar) {
        super(hVar, iVar, (PeriodType) null);
    }

    public void setPeriod(long j10, a aVar) {
        setValues(c.c(aVar).get(this, j10));
    }

    public MutablePeriod(h hVar, i iVar, PeriodType periodType) {
        super(hVar, iVar, periodType);
    }

    public MutablePeriod(Object obj) {
        super(obj, (PeriodType) null, (a) null);
    }

    public MutablePeriod(Object obj, PeriodType periodType) {
        super(obj, periodType, (a) null);
    }

    public MutablePeriod(Object obj, a aVar) {
        super(obj, (PeriodType) null, aVar);
    }

    public MutablePeriod(Object obj, PeriodType periodType, a aVar) {
        super(obj, periodType, aVar);
    }
}
