package org.joda.time.base;

import com.android.internal.logging.nano.MetricsProto;
import java.io.Serializable;
import org.joda.time.DurationFieldType;
import org.joda.time.MutablePeriod;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.a;
import org.joda.time.c;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.d;
import org.joda.time.field.e;
import org.joda.time.i;
import org.joda.time.k;
import org.joda.time.l;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class BaseSingleFieldPeriod implements l, Comparable<BaseSingleFieldPeriod>, Serializable {
    private static final long START_1972 = 63072000000L;
    private static final long serialVersionUID = 9386874258972L;
    private volatile int iPeriod;

    public BaseSingleFieldPeriod(int i10) {
        this.iPeriod = i10;
    }

    public static int between(i iVar, i iVar2, DurationFieldType durationFieldType) {
        if (iVar != null && iVar2 != null) {
            return durationFieldType.getField(c.g(iVar)).getDifference(iVar2.getMillis(), iVar.getMillis());
        }
        throw new IllegalArgumentException("ReadableInstant objects must not be null");
    }

    public static int standardPeriodIn(l lVar, long j10) {
        if (lVar == null) {
            return 0;
        }
        ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
        long j11 = 0;
        for (int i10 = 0; i10 < lVar.size(); i10++) {
            int value = lVar.getValue(i10);
            if (value != 0) {
                d field = lVar.getFieldType(i10).getField(instanceUTC);
                if (field.isPrecise()) {
                    j11 = e.e(j11, e.i(field.getUnitMillis(), value));
                } else {
                    throw new IllegalArgumentException("Cannot convert period to duration as " + field.getName() + " is not precise in the period " + ((Object) lVar));
                }
            }
        }
        return e.m(j11 / j10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return lVar.getPeriodType() == getPeriodType() && lVar.getValue(0) == getValue();
    }

    @Override // org.joda.time.l
    public int get(DurationFieldType durationFieldType) {
        if (durationFieldType == getFieldType()) {
            return getValue();
        }
        return 0;
    }

    public abstract DurationFieldType getFieldType();

    @Override // org.joda.time.l
    public DurationFieldType getFieldType(int i10) {
        if (i10 == 0) {
            return getFieldType();
        }
        throw new IndexOutOfBoundsException(String.valueOf(i10));
    }

    @Override // org.joda.time.l
    public abstract PeriodType getPeriodType();

    public int getValue() {
        return this.iPeriod;
    }

    public int hashCode() {
        return ((MetricsProto.MetricsEvent.SETTINGS_GESTURES + getValue()) * 27) + getFieldType().hashCode();
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        return durationFieldType == getFieldType();
    }

    public void setValue(int i10) {
        this.iPeriod = i10;
    }

    @Override // org.joda.time.l
    public int size() {
        return 1;
    }

    public MutablePeriod toMutablePeriod() {
        MutablePeriod mutablePeriod = new MutablePeriod();
        mutablePeriod.add(this);
        return mutablePeriod;
    }

    public Period toPeriod() {
        return Period.ZERO.withFields(this);
    }

    @Override // java.lang.Comparable
    public int compareTo(BaseSingleFieldPeriod baseSingleFieldPeriod) {
        if (baseSingleFieldPeriod.getClass() == getClass()) {
            int value = baseSingleFieldPeriod.getValue();
            int value2 = getValue();
            if (value2 > value) {
                return 1;
            }
            return value2 < value ? -1 : 0;
        }
        throw new ClassCastException(((Object) getClass()) + " cannot be compared to " + ((Object) baseSingleFieldPeriod.getClass()));
    }

    @Override // org.joda.time.l
    public int getValue(int i10) {
        if (i10 == 0) {
            return getValue();
        }
        throw new IndexOutOfBoundsException(String.valueOf(i10));
    }

    public static int between(k kVar, k kVar2, l lVar) {
        if (kVar != null && kVar2 != null) {
            if (kVar.size() == kVar2.size()) {
                int size = kVar.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (kVar.getFieldType(i10) != kVar2.getFieldType(i10)) {
                        throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
                    }
                }
                if (c.n(kVar)) {
                    a withUTC = c.c(kVar.getChronology()).withUTC();
                    return withUTC.get(lVar, withUTC.set(kVar, START_1972), withUTC.set(kVar2, START_1972))[0];
                }
                throw new IllegalArgumentException("ReadablePartial objects must be contiguous");
            }
            throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
        }
        throw new IllegalArgumentException("ReadablePartial objects must not be null");
    }
}
