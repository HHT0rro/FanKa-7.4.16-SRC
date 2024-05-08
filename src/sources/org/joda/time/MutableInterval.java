package org.joda.time;

import org.joda.time.base.BaseInterval;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class MutableInterval extends BaseInterval implements e, Cloneable {
    private static final long serialVersionUID = -5982824024992428470L;

    public MutableInterval() {
        super(0L, 0L, null);
    }

    public static MutableInterval parse(String str) {
        return new MutableInterval(str);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError("Clone error");
        }
    }

    public MutableInterval copy() {
        return (MutableInterval) clone();
    }

    @Override // org.joda.time.e
    public void setChronology(a aVar) {
        super.setInterval(getStartMillis(), getEndMillis(), aVar);
    }

    public void setDurationAfterStart(long j10) {
        setEndMillis(org.joda.time.field.e.e(getStartMillis(), j10));
    }

    public void setDurationBeforeEnd(long j10) {
        setStartMillis(org.joda.time.field.e.e(getEndMillis(), -j10));
    }

    public void setEnd(i iVar) {
        super.setInterval(getStartMillis(), c.h(iVar), getChronology());
    }

    public void setEndMillis(long j10) {
        super.setInterval(getStartMillis(), j10, getChronology());
    }

    @Override // org.joda.time.e
    public void setInterval(long j10, long j11) {
        super.setInterval(j10, j11, getChronology());
    }

    public void setPeriodAfterStart(l lVar) {
        if (lVar == null) {
            setEndMillis(getStartMillis());
        } else {
            setEndMillis(getChronology().add(lVar, getStartMillis(), 1));
        }
    }

    public void setPeriodBeforeEnd(l lVar) {
        if (lVar == null) {
            setStartMillis(getEndMillis());
        } else {
            setStartMillis(getChronology().add(lVar, getEndMillis(), -1));
        }
    }

    public void setStart(i iVar) {
        super.setInterval(c.h(iVar), getEndMillis(), getChronology());
    }

    public void setStartMillis(long j10) {
        super.setInterval(j10, getEndMillis(), getChronology());
    }

    public MutableInterval(long j10, long j11) {
        super(j10, j11, null);
    }

    public void setDurationAfterStart(h hVar) {
        setEndMillis(org.joda.time.field.e.e(getStartMillis(), c.f(hVar)));
    }

    public void setDurationBeforeEnd(h hVar) {
        setStartMillis(org.joda.time.field.e.e(getEndMillis(), -c.f(hVar)));
    }

    @Override // org.joda.time.e
    public void setInterval(j jVar) {
        if (jVar != null) {
            super.setInterval(jVar.getStartMillis(), jVar.getEndMillis(), jVar.getChronology());
            return;
        }
        throw new IllegalArgumentException("Interval must not be null");
    }

    public MutableInterval(long j10, long j11, a aVar) {
        super(j10, j11, aVar);
    }

    public MutableInterval(i iVar, i iVar2) {
        super(iVar, iVar2);
    }

    public MutableInterval(i iVar, h hVar) {
        super(iVar, hVar);
    }

    public MutableInterval(h hVar, i iVar) {
        super(hVar, iVar);
    }

    public MutableInterval(i iVar, l lVar) {
        super(iVar, lVar);
    }

    public void setInterval(i iVar, i iVar2) {
        if (iVar == null && iVar2 == null) {
            long b4 = c.b();
            setInterval(b4, b4);
        } else {
            super.setInterval(c.h(iVar), c.h(iVar2), c.g(iVar));
        }
    }

    public MutableInterval(l lVar, i iVar) {
        super(lVar, iVar);
    }

    public MutableInterval(Object obj) {
        super(obj, (a) null);
    }

    public MutableInterval(Object obj, a aVar) {
        super(obj, aVar);
    }
}
