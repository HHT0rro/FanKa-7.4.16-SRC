package je;

import org.joda.convert.ToString;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.h;

/* compiled from: AbstractDuration.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class b implements h {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && getMillis() == ((h) obj).getMillis();
    }

    public int hashCode() {
        long millis = getMillis();
        return (int) (millis ^ (millis >>> 32));
    }

    public boolean isEqual(h hVar) {
        if (hVar == null) {
            hVar = Duration.ZERO;
        }
        return compareTo(hVar) == 0;
    }

    public boolean isLongerThan(h hVar) {
        if (hVar == null) {
            hVar = Duration.ZERO;
        }
        return compareTo(hVar) > 0;
    }

    public boolean isShorterThan(h hVar) {
        if (hVar == null) {
            hVar = Duration.ZERO;
        }
        return compareTo(hVar) < 0;
    }

    public Duration toDuration() {
        return new Duration(getMillis());
    }

    public Period toPeriod() {
        return new Period(getMillis());
    }

    @ToString
    public String toString() {
        long millis = getMillis();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PT");
        boolean z10 = millis < 0;
        org.joda.time.format.h.f(stringBuffer, millis);
        while (true) {
            int i10 = 3;
            if (stringBuffer.length() >= (z10 ? 7 : 6)) {
                break;
            }
            if (!z10) {
                i10 = 2;
            }
            stringBuffer.insert(i10, "0");
        }
        if ((millis / 1000) * 1000 == millis) {
            stringBuffer.setLength(stringBuffer.length() - 3);
        } else {
            stringBuffer.insert(stringBuffer.length() - 3, ".");
        }
        stringBuffer.append('S');
        return stringBuffer.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(h hVar) {
        long millis = getMillis();
        long millis2 = hVar.getMillis();
        if (millis < millis2) {
            return -1;
        }
        return millis > millis2 ? 1 : 0;
    }
}
