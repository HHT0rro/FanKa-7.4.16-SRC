package org.joda.time.base;

import java.io.Serializable;
import je.d;
import org.joda.time.MutableInterval;
import org.joda.time.a;
import org.joda.time.c;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.e;
import org.joda.time.h;
import org.joda.time.i;
import org.joda.time.j;
import org.joda.time.l;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class BaseInterval extends d implements Serializable {
    private static final long serialVersionUID = 576586928732749278L;
    private volatile a iChronology;
    private volatile long iEndMillis;
    private volatile long iStartMillis;

    public BaseInterval(long j10, long j11, a aVar) {
        this.iChronology = c.c(aVar);
        checkInterval(j10, j11);
        this.iStartMillis = j10;
        this.iEndMillis = j11;
    }

    @Override // org.joda.time.j
    public a getChronology() {
        return this.iChronology;
    }

    @Override // org.joda.time.j
    public long getEndMillis() {
        return this.iEndMillis;
    }

    @Override // org.joda.time.j
    public long getStartMillis() {
        return this.iStartMillis;
    }

    public void setInterval(long j10, long j11, a aVar) {
        checkInterval(j10, j11);
        this.iStartMillis = j10;
        this.iEndMillis = j11;
        this.iChronology = c.c(aVar);
    }

    public BaseInterval(i iVar, i iVar2) {
        if (iVar == null && iVar2 == null) {
            long b4 = c.b();
            this.iEndMillis = b4;
            this.iStartMillis = b4;
            this.iChronology = ISOChronology.getInstance();
            return;
        }
        this.iChronology = c.g(iVar);
        this.iStartMillis = c.h(iVar);
        this.iEndMillis = c.h(iVar2);
        checkInterval(this.iStartMillis, this.iEndMillis);
    }

    public BaseInterval(i iVar, h hVar) {
        this.iChronology = c.g(iVar);
        this.iStartMillis = c.h(iVar);
        this.iEndMillis = e.e(this.iStartMillis, c.f(hVar));
        checkInterval(this.iStartMillis, this.iEndMillis);
    }

    public BaseInterval(h hVar, i iVar) {
        this.iChronology = c.g(iVar);
        this.iEndMillis = c.h(iVar);
        this.iStartMillis = e.e(this.iEndMillis, -c.f(hVar));
        checkInterval(this.iStartMillis, this.iEndMillis);
    }

    public BaseInterval(i iVar, l lVar) {
        a g3 = c.g(iVar);
        this.iChronology = g3;
        this.iStartMillis = c.h(iVar);
        if (lVar == null) {
            this.iEndMillis = this.iStartMillis;
        } else {
            this.iEndMillis = g3.add(lVar, this.iStartMillis, 1);
        }
        checkInterval(this.iStartMillis, this.iEndMillis);
    }

    public BaseInterval(l lVar, i iVar) {
        a g3 = c.g(iVar);
        this.iChronology = g3;
        this.iEndMillis = c.h(iVar);
        if (lVar == null) {
            this.iStartMillis = this.iEndMillis;
        } else {
            this.iStartMillis = g3.add(lVar, this.iEndMillis, -1);
        }
        checkInterval(this.iStartMillis, this.iEndMillis);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseInterval(Object obj, a aVar) {
        ke.i d10 = ke.d.b().d(obj);
        if (d10.c(obj, aVar)) {
            j jVar = (j) obj;
            this.iChronology = aVar == null ? jVar.getChronology() : aVar;
            this.iStartMillis = jVar.getStartMillis();
            this.iEndMillis = jVar.getEndMillis();
        } else if (this instanceof org.joda.time.e) {
            d10.j((org.joda.time.e) this, obj, aVar);
        } else {
            MutableInterval mutableInterval = new MutableInterval();
            d10.j(mutableInterval, obj, aVar);
            this.iChronology = mutableInterval.getChronology();
            this.iStartMillis = mutableInterval.getStartMillis();
            this.iEndMillis = mutableInterval.getEndMillis();
        }
        checkInterval(this.iStartMillis, this.iEndMillis);
    }
}
