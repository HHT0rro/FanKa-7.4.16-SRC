package org.joda.time.base;

import java.io.Serializable;
import je.b;
import ke.d;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.a;
import org.joda.time.c;
import org.joda.time.field.e;
import org.joda.time.i;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class BaseDuration extends b implements Serializable {
    private static final long serialVersionUID = 2581698638990L;
    private volatile long iMillis;

    public BaseDuration(long j10) {
        this.iMillis = j10;
    }

    @Override // org.joda.time.h
    public long getMillis() {
        return this.iMillis;
    }

    public void setMillis(long j10) {
        this.iMillis = j10;
    }

    public Interval toIntervalFrom(i iVar) {
        return new Interval(iVar, this);
    }

    public Interval toIntervalTo(i iVar) {
        return new Interval(this, iVar);
    }

    public Period toPeriod(PeriodType periodType) {
        return new Period(getMillis(), periodType);
    }

    public Period toPeriodFrom(i iVar) {
        return new Period(iVar, this);
    }

    public Period toPeriodTo(i iVar) {
        return new Period(this, iVar);
    }

    public Period toPeriod(a aVar) {
        return new Period(getMillis(), aVar);
    }

    public Period toPeriodFrom(i iVar, PeriodType periodType) {
        return new Period(iVar, this, periodType);
    }

    public Period toPeriodTo(i iVar, PeriodType periodType) {
        return new Period(this, iVar, periodType);
    }

    public BaseDuration(long j10, long j11) {
        this.iMillis = e.l(j11, j10);
    }

    public Period toPeriod(PeriodType periodType, a aVar) {
        return new Period(getMillis(), periodType, aVar);
    }

    public BaseDuration(i iVar, i iVar2) {
        if (iVar == iVar2) {
            this.iMillis = 0L;
        } else {
            this.iMillis = e.l(c.h(iVar2), c.h(iVar));
        }
    }

    public BaseDuration(Object obj) {
        this.iMillis = d.b().a(obj).g(obj);
    }
}
