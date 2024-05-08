package org.joda.time;

import org.joda.time.base.BaseInterval;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.n;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class Interval extends BaseInterval {
    private static final long serialVersionUID = 4922451897541386752L;

    public Interval(long j10, long j11) {
        super(j10, j11, null);
    }

    public static Interval parse(String str) {
        return new Interval(str);
    }

    public static Interval parseWithOffset(String str) {
        DateTime dateTime;
        int indexOf = str.indexOf(47);
        if (indexOf >= 0) {
            String substring = str.substring(0, indexOf);
            if (substring.length() > 0) {
                String substring2 = str.substring(indexOf + 1);
                if (substring2.length() > 0) {
                    org.joda.time.format.b w3 = org.joda.time.format.i.i().w();
                    n a10 = org.joda.time.format.j.a();
                    char charAt = substring.charAt(0);
                    Period period = null;
                    if (charAt != 'P' && charAt != 'p') {
                        dateTime = w3.f(substring);
                    } else {
                        period = a10.j(PeriodType.standard()).h(substring);
                        dateTime = null;
                    }
                    char charAt2 = substring2.charAt(0);
                    if (charAt2 != 'P' && charAt2 != 'p') {
                        DateTime f10 = w3.f(substring2);
                        if (period != null) {
                            return new Interval(period, f10);
                        }
                        return new Interval(dateTime, f10);
                    }
                    if (period == null) {
                        return new Interval(dateTime, a10.j(PeriodType.standard()).h(substring2));
                    }
                    throw new IllegalArgumentException("Interval composed of two durations: " + str);
                }
                throw new IllegalArgumentException("Format invalid: " + str);
            }
            throw new IllegalArgumentException("Format invalid: " + str);
        }
        throw new IllegalArgumentException("Format requires a '/' separator: " + str);
    }

    public boolean abuts(j jVar) {
        if (jVar != null) {
            return jVar.getEndMillis() == getStartMillis() || getEndMillis() == jVar.getStartMillis();
        }
        long b4 = c.b();
        return getStartMillis() == b4 || getEndMillis() == b4;
    }

    public Interval gap(j jVar) {
        j l10 = c.l(jVar);
        long startMillis = l10.getStartMillis();
        long endMillis = l10.getEndMillis();
        long startMillis2 = getStartMillis();
        long endMillis2 = getEndMillis();
        if (startMillis2 > endMillis) {
            return new Interval(endMillis, startMillis2, getChronology());
        }
        if (startMillis > endMillis2) {
            return new Interval(endMillis2, startMillis, getChronology());
        }
        return null;
    }

    public Interval overlap(j jVar) {
        j l10 = c.l(jVar);
        if (overlaps(l10)) {
            return new Interval(Math.max(getStartMillis(), l10.getStartMillis()), Math.min(getEndMillis(), l10.getEndMillis()), getChronology());
        }
        return null;
    }

    @Override // je.d
    public Interval toInterval() {
        return this;
    }

    public Interval withChronology(a aVar) {
        return getChronology() == aVar ? this : new Interval(getStartMillis(), getEndMillis(), aVar);
    }

    public Interval withDurationAfterStart(h hVar) {
        long f10 = c.f(hVar);
        if (f10 == toDurationMillis()) {
            return this;
        }
        a chronology = getChronology();
        long startMillis = getStartMillis();
        return new Interval(startMillis, chronology.add(startMillis, f10, 1), chronology);
    }

    public Interval withDurationBeforeEnd(h hVar) {
        long f10 = c.f(hVar);
        if (f10 == toDurationMillis()) {
            return this;
        }
        a chronology = getChronology();
        long endMillis = getEndMillis();
        return new Interval(chronology.add(endMillis, f10, -1), endMillis, chronology);
    }

    public Interval withEnd(i iVar) {
        return withEndMillis(c.h(iVar));
    }

    public Interval withEndMillis(long j10) {
        return j10 == getEndMillis() ? this : new Interval(getStartMillis(), j10, getChronology());
    }

    public Interval withPeriodAfterStart(l lVar) {
        if (lVar == null) {
            return withDurationAfterStart(null);
        }
        a chronology = getChronology();
        long startMillis = getStartMillis();
        return new Interval(startMillis, chronology.add(lVar, startMillis, 1), chronology);
    }

    public Interval withPeriodBeforeEnd(l lVar) {
        if (lVar == null) {
            return withDurationBeforeEnd(null);
        }
        a chronology = getChronology();
        long endMillis = getEndMillis();
        return new Interval(chronology.add(lVar, endMillis, -1), endMillis, chronology);
    }

    public Interval withStart(i iVar) {
        return withStartMillis(c.h(iVar));
    }

    public Interval withStartMillis(long j10) {
        return j10 == getStartMillis() ? this : new Interval(j10, getEndMillis(), getChronology());
    }

    public Interval(long j10, long j11, DateTimeZone dateTimeZone) {
        super(j10, j11, ISOChronology.getInstance(dateTimeZone));
    }

    public Interval(long j10, long j11, a aVar) {
        super(j10, j11, aVar);
    }

    public Interval(i iVar, i iVar2) {
        super(iVar, iVar2);
    }

    public Interval(i iVar, h hVar) {
        super(iVar, hVar);
    }

    public Interval(h hVar, i iVar) {
        super(hVar, iVar);
    }

    public Interval(i iVar, l lVar) {
        super(iVar, lVar);
    }

    public Interval(l lVar, i iVar) {
        super(lVar, iVar);
    }

    public Interval(Object obj) {
        super(obj, (a) null);
    }

    public Interval(Object obj, a aVar) {
        super(obj, aVar);
    }
}
