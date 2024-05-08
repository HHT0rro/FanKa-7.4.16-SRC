package org.joda.time.field;

import java.io.Serializable;
import org.joda.time.DurationFieldType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class BaseDurationField extends org.joda.time.d implements Serializable {
    private static final long serialVersionUID = -2554245107589433218L;
    private final DurationFieldType iType;

    public BaseDurationField(DurationFieldType durationFieldType) {
        if (durationFieldType != null) {
            this.iType = durationFieldType;
            return;
        }
        throw new IllegalArgumentException("The type must not be null");
    }

    @Override // org.joda.time.d
    public int getDifference(long j10, long j11) {
        return e.m(getDifferenceAsLong(j10, j11));
    }

    @Override // org.joda.time.d
    public long getMillis(int i10) {
        return i10 * getUnitMillis();
    }

    @Override // org.joda.time.d
    public final String getName() {
        return this.iType.getName();
    }

    @Override // org.joda.time.d
    public final DurationFieldType getType() {
        return this.iType;
    }

    @Override // org.joda.time.d
    public int getValue(long j10) {
        return e.m(getValueAsLong(j10));
    }

    @Override // org.joda.time.d
    public long getValueAsLong(long j10) {
        return j10 / getUnitMillis();
    }

    @Override // org.joda.time.d
    public final boolean isSupported() {
        return true;
    }

    @Override // org.joda.time.d
    public String toString() {
        return "DurationField[" + getName() + ']';
    }

    @Override // java.lang.Comparable
    public int compareTo(org.joda.time.d dVar) {
        long unitMillis = dVar.getUnitMillis();
        long unitMillis2 = getUnitMillis();
        if (unitMillis2 == unitMillis) {
            return 0;
        }
        return unitMillis2 < unitMillis ? -1 : 1;
    }

    @Override // org.joda.time.d
    public long getMillis(long j10) {
        return e.j(j10, getUnitMillis());
    }

    @Override // org.joda.time.d
    public int getValue(long j10, long j11) {
        return e.m(getValueAsLong(j10, j11));
    }
}
