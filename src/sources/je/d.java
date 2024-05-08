package je;

import com.tencent.turingface.sdk.mfa.ITuringIoTFeatureMap;
import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;
import org.joda.time.MutableInterval;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.i;
import org.joda.time.j;

/* compiled from: AbstractInterval.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class d implements j {
    public void checkInterval(long j10, long j11) {
        if (j11 < j10) {
            throw new IllegalArgumentException("The end instant must be greater than the start instant");
        }
    }

    public boolean contains(long j10) {
        return j10 >= getStartMillis() && j10 < getEndMillis();
    }

    public boolean containsNow() {
        return contains(org.joda.time.c.b());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return getStartMillis() == jVar.getStartMillis() && getEndMillis() == jVar.getEndMillis() && org.joda.time.field.e.a(getChronology(), jVar.getChronology());
    }

    @Override // org.joda.time.j
    public DateTime getEnd() {
        return new DateTime(getEndMillis(), getChronology());
    }

    @Override // org.joda.time.j
    public DateTime getStart() {
        return new DateTime(getStartMillis(), getChronology());
    }

    public int hashCode() {
        long startMillis = getStartMillis();
        long endMillis = getEndMillis();
        return ((((ITuringIoTFeatureMap.RIOT_SIM_NUMBER + ((int) (startMillis ^ (startMillis >>> 32)))) * 31) + ((int) (endMillis ^ (endMillis >>> 32)))) * 31) + getChronology().hashCode();
    }

    public boolean isAfter(long j10) {
        return getStartMillis() > j10;
    }

    public boolean isAfterNow() {
        return isAfter(org.joda.time.c.b());
    }

    public boolean isBefore(long j10) {
        return getEndMillis() <= j10;
    }

    public boolean isBeforeNow() {
        return isBefore(org.joda.time.c.b());
    }

    public boolean isEqual(j jVar) {
        return getStartMillis() == jVar.getStartMillis() && getEndMillis() == jVar.getEndMillis();
    }

    public boolean overlaps(j jVar) {
        long startMillis = getStartMillis();
        long endMillis = getEndMillis();
        if (jVar != null) {
            return startMillis < jVar.getEndMillis() && jVar.getStartMillis() < endMillis;
        }
        long b4 = org.joda.time.c.b();
        return startMillis < b4 && b4 < endMillis;
    }

    public Duration toDuration() {
        long durationMillis = toDurationMillis();
        if (durationMillis == 0) {
            return Duration.ZERO;
        }
        return new Duration(durationMillis);
    }

    @Override // org.joda.time.j
    public long toDurationMillis() {
        return org.joda.time.field.e.l(getEndMillis(), getStartMillis());
    }

    public Interval toInterval() {
        return new Interval(getStartMillis(), getEndMillis(), getChronology());
    }

    public MutableInterval toMutableInterval() {
        return new MutableInterval(getStartMillis(), getEndMillis(), getChronology());
    }

    public Period toPeriod() {
        return new Period(getStartMillis(), getEndMillis(), getChronology());
    }

    public String toString() {
        org.joda.time.format.b u10 = i.h().u(getChronology());
        StringBuffer stringBuffer = new StringBuffer(48);
        u10.q(stringBuffer, getStartMillis());
        stringBuffer.append(IOUtils.DIR_SEPARATOR_UNIX);
        u10.q(stringBuffer, getEndMillis());
        return stringBuffer.toString();
    }

    public boolean isAfter(org.joda.time.i iVar) {
        if (iVar == null) {
            return isAfterNow();
        }
        return isAfter(iVar.getMillis());
    }

    public boolean isBefore(org.joda.time.i iVar) {
        if (iVar == null) {
            return isBeforeNow();
        }
        return isBefore(iVar.getMillis());
    }

    @Override // org.joda.time.j
    public Period toPeriod(PeriodType periodType) {
        return new Period(getStartMillis(), getEndMillis(), periodType, getChronology());
    }

    public boolean contains(org.joda.time.i iVar) {
        if (iVar == null) {
            return containsNow();
        }
        return contains(iVar.getMillis());
    }

    public boolean isAfter(j jVar) {
        long endMillis;
        if (jVar == null) {
            endMillis = org.joda.time.c.b();
        } else {
            endMillis = jVar.getEndMillis();
        }
        return getStartMillis() >= endMillis;
    }

    public boolean isBefore(j jVar) {
        if (jVar == null) {
            return isBeforeNow();
        }
        return isBefore(jVar.getStartMillis());
    }

    public boolean contains(j jVar) {
        if (jVar == null) {
            return containsNow();
        }
        long startMillis = jVar.getStartMillis();
        long endMillis = jVar.getEndMillis();
        long startMillis2 = getStartMillis();
        long endMillis2 = getEndMillis();
        return startMillis2 <= startMillis && startMillis < endMillis2 && endMillis <= endMillis2;
    }
}
