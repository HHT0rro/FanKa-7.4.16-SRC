package org.joda.time.field;

import java.io.Serializable;
import org.joda.time.DurationFieldType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MillisDurationField extends org.joda.time.d implements Serializable {
    public static final org.joda.time.d INSTANCE = new MillisDurationField();
    private static final long serialVersionUID = 2656707858124633367L;

    private MillisDurationField() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.joda.time.d
    public long add(long j10, int i10) {
        return e.e(j10, i10);
    }

    public boolean equals(Object obj) {
        return (obj instanceof MillisDurationField) && getUnitMillis() == ((MillisDurationField) obj).getUnitMillis();
    }

    @Override // org.joda.time.d
    public int getDifference(long j10, long j11) {
        return e.m(e.l(j10, j11));
    }

    @Override // org.joda.time.d
    public long getDifferenceAsLong(long j10, long j11) {
        return e.l(j10, j11);
    }

    @Override // org.joda.time.d
    public long getMillis(int i10) {
        return i10;
    }

    @Override // org.joda.time.d
    public long getMillis(int i10, long j10) {
        return i10;
    }

    @Override // org.joda.time.d
    public long getMillis(long j10) {
        return j10;
    }

    @Override // org.joda.time.d
    public long getMillis(long j10, long j11) {
        return j10;
    }

    @Override // org.joda.time.d
    public String getName() {
        return "millis";
    }

    @Override // org.joda.time.d
    public DurationFieldType getType() {
        return DurationFieldType.millis();
    }

    @Override // org.joda.time.d
    public final long getUnitMillis() {
        return 1L;
    }

    @Override // org.joda.time.d
    public int getValue(long j10) {
        return e.m(j10);
    }

    @Override // org.joda.time.d
    public long getValueAsLong(long j10) {
        return j10;
    }

    @Override // org.joda.time.d
    public long getValueAsLong(long j10, long j11) {
        return j10;
    }

    public int hashCode() {
        return (int) getUnitMillis();
    }

    @Override // org.joda.time.d
    public final boolean isPrecise() {
        return true;
    }

    @Override // org.joda.time.d
    public boolean isSupported() {
        return true;
    }

    @Override // org.joda.time.d
    public String toString() {
        return "DurationField[millis]";
    }

    @Override // org.joda.time.d
    public long add(long j10, long j11) {
        return e.e(j10, j11);
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
    public int getValue(long j10, long j11) {
        return e.m(j10);
    }
}
