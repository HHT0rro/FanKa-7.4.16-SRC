package org.joda.time.base;

import java.io.Serializable;
import je.f;
import je.g;
import ke.d;
import ke.m;
import org.joda.time.Duration;
import org.joda.time.DurationFieldType;
import org.joda.time.MutablePeriod;
import org.joda.time.PeriodType;
import org.joda.time.c;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.e;
import org.joda.time.h;
import org.joda.time.i;
import org.joda.time.k;
import org.joda.time.l;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class BasePeriod extends f implements Serializable {
    private static final l DUMMY_PERIOD = new a();
    private static final long serialVersionUID = -2110953284060001145L;
    private final PeriodType iType;
    private final int[] iValues;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a extends f {
        @Override // org.joda.time.l
        public PeriodType getPeriodType() {
            return PeriodType.time();
        }

        @Override // org.joda.time.l
        public int getValue(int i10) {
            return 0;
        }
    }

    public BasePeriod(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, PeriodType periodType) {
        this.iType = checkPeriodType(periodType);
        this.iValues = setPeriodInternal(i10, i11, i12, i13, i14, i15, i16, i17);
    }

    private void checkAndUpdate(DurationFieldType durationFieldType, int[] iArr, int i10) {
        int indexOf = indexOf(durationFieldType);
        if (indexOf != -1) {
            iArr[indexOf] = i10;
        } else {
            if (i10 == 0) {
                return;
            }
            throw new IllegalArgumentException("Period does not support field '" + durationFieldType.getName() + "'");
        }
    }

    private void setPeriodInternal(l lVar) {
        int[] iArr = new int[size()];
        int size = lVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            checkAndUpdate(lVar.getFieldType(i10), iArr, lVar.getValue(i10));
        }
        setValues(iArr);
    }

    public void addField(DurationFieldType durationFieldType, int i10) {
        addFieldInto(this.iValues, durationFieldType, i10);
    }

    public void addFieldInto(int[] iArr, DurationFieldType durationFieldType, int i10) {
        int indexOf = indexOf(durationFieldType);
        if (indexOf != -1) {
            iArr[indexOf] = e.d(iArr[indexOf], i10);
            return;
        }
        if (i10 != 0 || durationFieldType == null) {
            throw new IllegalArgumentException("Period does not support field '" + ((Object) durationFieldType) + "'");
        }
    }

    public void addPeriod(l lVar) {
        if (lVar != null) {
            setValues(addPeriodInto(getValues(), lVar));
        }
    }

    public int[] addPeriodInto(int[] iArr, l lVar) {
        int size = lVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            DurationFieldType fieldType = lVar.getFieldType(i10);
            int value = lVar.getValue(i10);
            if (value != 0) {
                int indexOf = indexOf(fieldType);
                if (indexOf != -1) {
                    iArr[indexOf] = e.d(getValue(indexOf), value);
                } else {
                    throw new IllegalArgumentException("Period does not support field '" + fieldType.getName() + "'");
                }
            }
        }
        return iArr;
    }

    public PeriodType checkPeriodType(PeriodType periodType) {
        return c.k(periodType);
    }

    @Override // org.joda.time.l
    public PeriodType getPeriodType() {
        return this.iType;
    }

    @Override // org.joda.time.l
    public int getValue(int i10) {
        return this.iValues[i10];
    }

    public void mergePeriod(l lVar) {
        if (lVar != null) {
            setValues(mergePeriodInto(getValues(), lVar));
        }
    }

    public int[] mergePeriodInto(int[] iArr, l lVar) {
        int size = lVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            checkAndUpdate(lVar.getFieldType(i10), iArr, lVar.getValue(i10));
        }
        return iArr;
    }

    public void setField(DurationFieldType durationFieldType, int i10) {
        setFieldInto(this.iValues, durationFieldType, i10);
    }

    public void setFieldInto(int[] iArr, DurationFieldType durationFieldType, int i10) {
        int indexOf = indexOf(durationFieldType);
        if (indexOf != -1) {
            iArr[indexOf] = i10;
            return;
        }
        if (i10 != 0 || durationFieldType == null) {
            throw new IllegalArgumentException("Period does not support field '" + ((Object) durationFieldType) + "'");
        }
    }

    public void setPeriod(l lVar) {
        if (lVar == null) {
            setValues(new int[size()]);
        } else {
            setPeriodInternal(lVar);
        }
    }

    public void setValue(int i10, int i11) {
        this.iValues[i10] = i11;
    }

    public void setValues(int[] iArr) {
        int[] iArr2 = this.iValues;
        System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, iArr2.length);
    }

    public Duration toDurationFrom(i iVar) {
        long h10 = c.h(iVar);
        return new Duration(h10, c.g(iVar).add(this, h10, 1));
    }

    public Duration toDurationTo(i iVar) {
        long h10 = c.h(iVar);
        return new Duration(c.g(iVar).add(this, h10, -1), h10);
    }

    public void setPeriod(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        setValues(setPeriodInternal(i10, i11, i12, i13, i14, i15, i16, i17));
    }

    public BasePeriod(long j10, long j11, PeriodType periodType, org.joda.time.a aVar) {
        PeriodType checkPeriodType = checkPeriodType(periodType);
        org.joda.time.a c4 = c.c(aVar);
        this.iType = checkPeriodType;
        this.iValues = c4.get(this, j10, j11);
    }

    private int[] setPeriodInternal(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int[] iArr = new int[size()];
        checkAndUpdate(DurationFieldType.years(), iArr, i10);
        checkAndUpdate(DurationFieldType.months(), iArr, i11);
        checkAndUpdate(DurationFieldType.weeks(), iArr, i12);
        checkAndUpdate(DurationFieldType.days(), iArr, i13);
        checkAndUpdate(DurationFieldType.hours(), iArr, i14);
        checkAndUpdate(DurationFieldType.minutes(), iArr, i15);
        checkAndUpdate(DurationFieldType.seconds(), iArr, i16);
        checkAndUpdate(DurationFieldType.millis(), iArr, i17);
        return iArr;
    }

    public BasePeriod(i iVar, i iVar2, PeriodType periodType) {
        PeriodType checkPeriodType = checkPeriodType(periodType);
        if (iVar == null && iVar2 == null) {
            this.iType = checkPeriodType;
            this.iValues = new int[size()];
            return;
        }
        long h10 = c.h(iVar);
        long h11 = c.h(iVar2);
        org.joda.time.a i10 = c.i(iVar, iVar2);
        this.iType = checkPeriodType;
        this.iValues = i10.get(this, h10, h11);
    }

    public BasePeriod(k kVar, k kVar2, PeriodType periodType) {
        if (kVar != null && kVar2 != null) {
            if ((kVar instanceof g) && (kVar2 instanceof g) && kVar.getClass() == kVar2.getClass()) {
                PeriodType checkPeriodType = checkPeriodType(periodType);
                long localMillis = ((g) kVar).getLocalMillis();
                long localMillis2 = ((g) kVar2).getLocalMillis();
                org.joda.time.a c4 = c.c(kVar.getChronology());
                this.iType = checkPeriodType;
                this.iValues = c4.get(this, localMillis, localMillis2);
                return;
            }
            if (kVar.size() == kVar2.size()) {
                int size = kVar.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (kVar.getFieldType(i10) != kVar2.getFieldType(i10)) {
                        throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
                    }
                }
                if (c.n(kVar)) {
                    this.iType = checkPeriodType(periodType);
                    org.joda.time.a withUTC = c.c(kVar.getChronology()).withUTC();
                    this.iValues = withUTC.get(this, withUTC.set(kVar, 0L), withUTC.set(kVar2, 0L));
                    return;
                }
                throw new IllegalArgumentException("ReadablePartial objects must be contiguous");
            }
            throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
        }
        throw new IllegalArgumentException("ReadablePartial objects must not be null");
    }

    public BasePeriod(i iVar, h hVar, PeriodType periodType) {
        PeriodType checkPeriodType = checkPeriodType(periodType);
        long h10 = c.h(iVar);
        long e2 = e.e(h10, c.f(hVar));
        org.joda.time.a g3 = c.g(iVar);
        this.iType = checkPeriodType;
        this.iValues = g3.get(this, h10, e2);
    }

    public BasePeriod(h hVar, i iVar, PeriodType periodType) {
        PeriodType checkPeriodType = checkPeriodType(periodType);
        long f10 = c.f(hVar);
        long h10 = c.h(iVar);
        long l10 = e.l(h10, f10);
        org.joda.time.a g3 = c.g(iVar);
        this.iType = checkPeriodType;
        this.iValues = g3.get(this, l10, h10);
    }

    public BasePeriod(long j10) {
        this.iType = PeriodType.standard();
        int[] iArr = ISOChronology.getInstanceUTC().get(DUMMY_PERIOD, j10);
        int[] iArr2 = new int[8];
        this.iValues = iArr2;
        System.arraycopy((Object) iArr, 0, (Object) iArr2, 4, 4);
    }

    public BasePeriod(long j10, PeriodType periodType, org.joda.time.a aVar) {
        PeriodType checkPeriodType = checkPeriodType(periodType);
        org.joda.time.a c4 = c.c(aVar);
        this.iType = checkPeriodType;
        this.iValues = c4.get(this, j10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BasePeriod(Object obj, PeriodType periodType, org.joda.time.a aVar) {
        m f10 = d.b().f(obj);
        PeriodType checkPeriodType = checkPeriodType(periodType == null ? f10.h(obj) : periodType);
        this.iType = checkPeriodType;
        if (this instanceof org.joda.time.f) {
            this.iValues = new int[size()];
            f10.d((org.joda.time.f) this, obj, c.c(aVar));
        } else {
            this.iValues = new MutablePeriod(obj, checkPeriodType, aVar).getValues();
        }
    }

    public BasePeriod(int[] iArr, PeriodType periodType) {
        this.iType = periodType;
        this.iValues = iArr;
    }
}
