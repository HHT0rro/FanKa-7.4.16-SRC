package org.joda.time.format;

import java.util.Locale;
import org.joda.time.MutablePeriod;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/* compiled from: PeriodFormatter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public final q f52646a;

    /* renamed from: b, reason: collision with root package name */
    public final p f52647b;

    /* renamed from: c, reason: collision with root package name */
    public final Locale f52648c;

    /* renamed from: d, reason: collision with root package name */
    public final PeriodType f52649d;

    public n(q qVar, p pVar) {
        this.f52646a = qVar;
        this.f52647b = pVar;
        this.f52648c = null;
        this.f52649d = null;
    }

    public final void a() {
        if (this.f52647b == null) {
            throw new UnsupportedOperationException("Parsing not supported");
        }
    }

    public final void b(org.joda.time.l lVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("Period must not be null");
        }
    }

    public final void c() {
        if (this.f52646a == null) {
            throw new UnsupportedOperationException("Printing not supported");
        }
    }

    public p d() {
        return this.f52647b;
    }

    public q e() {
        return this.f52646a;
    }

    public int f(org.joda.time.f fVar, String str, int i10) {
        a();
        b(fVar);
        return d().c(fVar, str, i10, this.f52648c);
    }

    public MutablePeriod g(String str) {
        a();
        MutablePeriod mutablePeriod = new MutablePeriod(0L, this.f52649d);
        int c4 = d().c(mutablePeriod, str, 0, this.f52648c);
        if (c4 < 0) {
            c4 = ~c4;
        } else if (c4 >= str.length()) {
            return mutablePeriod;
        }
        throw new IllegalArgumentException(h.h(str, c4));
    }

    public Period h(String str) {
        a();
        return g(str).toPeriod();
    }

    public String i(org.joda.time.l lVar) {
        c();
        b(lVar);
        q e2 = e();
        StringBuffer stringBuffer = new StringBuffer(e2.d(lVar, this.f52648c));
        e2.b(stringBuffer, lVar, this.f52648c);
        return stringBuffer.toString();
    }

    public n j(PeriodType periodType) {
        return periodType == this.f52649d ? this : new n(this.f52646a, this.f52647b, this.f52648c, periodType);
    }

    public n(q qVar, p pVar, Locale locale, PeriodType periodType) {
        this.f52646a = qVar;
        this.f52647b = pVar;
        this.f52648c = locale;
        this.f52649d = periodType;
    }
}
