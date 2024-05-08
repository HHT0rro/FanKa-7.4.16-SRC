package org.joda.time.format;

import java.io.IOException;
import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;

/* compiled from: DateTimeFormatter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final m f52578a;

    /* renamed from: b, reason: collision with root package name */
    public final k f52579b;

    /* renamed from: c, reason: collision with root package name */
    public final Locale f52580c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f52581d;

    /* renamed from: e, reason: collision with root package name */
    public final org.joda.time.a f52582e;

    /* renamed from: f, reason: collision with root package name */
    public final DateTimeZone f52583f;

    /* renamed from: g, reason: collision with root package name */
    public final Integer f52584g;

    /* renamed from: h, reason: collision with root package name */
    public final int f52585h;

    public b(m mVar, k kVar) {
        this.f52578a = mVar;
        this.f52579b = kVar;
        this.f52580c = null;
        this.f52581d = false;
        this.f52582e = null;
        this.f52583f = null;
        this.f52584g = null;
        this.f52585h = 2000;
    }

    public Locale a() {
        return this.f52580c;
    }

    public c b() {
        return l.b(this.f52579b);
    }

    public k c() {
        return this.f52579b;
    }

    public m d() {
        return this.f52578a;
    }

    public DateTimeZone e() {
        return this.f52583f;
    }

    public DateTime f(String str) {
        k r10 = r();
        org.joda.time.a t2 = t(null);
        d dVar = new d(0L, t2, this.f52580c, this.f52584g, this.f52585h);
        int parseInto = r10.parseInto(dVar, str, 0);
        if (parseInto < 0) {
            parseInto = ~parseInto;
        } else if (parseInto >= str.length()) {
            long l10 = dVar.l(true, str);
            if (this.f52581d && dVar.p() != null) {
                t2 = t2.withZone(DateTimeZone.forOffsetMillis(dVar.p().intValue()));
            } else if (dVar.r() != null) {
                t2 = t2.withZone(dVar.r());
            }
            DateTime dateTime = new DateTime(l10, t2);
            DateTimeZone dateTimeZone = this.f52583f;
            return dateTimeZone != null ? dateTime.withZone(dateTimeZone) : dateTime;
        }
        throw new IllegalArgumentException(h.h(str, parseInto));
    }

    public LocalDate g(String str) {
        return h(str).toLocalDate();
    }

    public LocalDateTime h(String str) {
        k r10 = r();
        org.joda.time.a withUTC = t(null).withUTC();
        d dVar = new d(0L, withUTC, this.f52580c, this.f52584g, this.f52585h);
        int parseInto = r10.parseInto(dVar, str, 0);
        if (parseInto < 0) {
            parseInto = ~parseInto;
        } else if (parseInto >= str.length()) {
            long l10 = dVar.l(true, str);
            if (dVar.p() != null) {
                withUTC = withUTC.withZone(DateTimeZone.forOffsetMillis(dVar.p().intValue()));
            } else if (dVar.r() != null) {
                withUTC = withUTC.withZone(dVar.r());
            }
            return new LocalDateTime(l10, withUTC);
        }
        throw new IllegalArgumentException(h.h(str, parseInto));
    }

    public LocalTime i(String str) {
        return h(str).toLocalTime();
    }

    public long j(String str) {
        return new d(0L, t(this.f52582e), this.f52580c, this.f52584g, this.f52585h).m(r(), str);
    }

    public String k(org.joda.time.i iVar) {
        StringBuilder sb2 = new StringBuilder(s().estimatePrintedLength());
        try {
            o(sb2, iVar);
        } catch (IOException unused) {
        }
        return sb2.toString();
    }

    public String l(org.joda.time.k kVar) {
        StringBuilder sb2 = new StringBuilder(s().estimatePrintedLength());
        try {
            p(sb2, kVar);
        } catch (IOException unused) {
        }
        return sb2.toString();
    }

    public void m(Appendable appendable, long j10) throws IOException {
        n(appendable, j10, null);
    }

    public final void n(Appendable appendable, long j10, org.joda.time.a aVar) throws IOException {
        m s2 = s();
        org.joda.time.a t2 = t(aVar);
        DateTimeZone zone = t2.getZone();
        int offset = zone.getOffset(j10);
        long j11 = offset;
        long j12 = j10 + j11;
        if ((j10 ^ j12) < 0 && (j11 ^ j10) >= 0) {
            zone = DateTimeZone.UTC;
            offset = 0;
            j12 = j10;
        }
        s2.printTo(appendable, j12, t2.withUTC(), offset, zone, this.f52580c);
    }

    public void o(Appendable appendable, org.joda.time.i iVar) throws IOException {
        n(appendable, org.joda.time.c.h(iVar), org.joda.time.c.g(iVar));
    }

    public void p(Appendable appendable, org.joda.time.k kVar) throws IOException {
        m s2 = s();
        if (kVar != null) {
            s2.printTo(appendable, kVar, this.f52580c);
            return;
        }
        throw new IllegalArgumentException("The partial must not be null");
    }

    public void q(StringBuffer stringBuffer, long j10) {
        try {
            m(stringBuffer, j10);
        } catch (IOException unused) {
        }
    }

    public final k r() {
        k kVar = this.f52579b;
        if (kVar != null) {
            return kVar;
        }
        throw new UnsupportedOperationException("Parsing not supported");
    }

    public final m s() {
        m mVar = this.f52578a;
        if (mVar != null) {
            return mVar;
        }
        throw new UnsupportedOperationException("Printing not supported");
    }

    public final org.joda.time.a t(org.joda.time.a aVar) {
        org.joda.time.a c4 = org.joda.time.c.c(aVar);
        org.joda.time.a aVar2 = this.f52582e;
        if (aVar2 != null) {
            c4 = aVar2;
        }
        DateTimeZone dateTimeZone = this.f52583f;
        return dateTimeZone != null ? c4.withZone(dateTimeZone) : c4;
    }

    public b u(org.joda.time.a aVar) {
        return this.f52582e == aVar ? this : new b(this.f52578a, this.f52579b, this.f52580c, this.f52581d, aVar, this.f52583f, this.f52584g, this.f52585h);
    }

    public b v(Locale locale) {
        return (locale == a() || (locale != null && locale.equals(a()))) ? this : new b(this.f52578a, this.f52579b, locale, this.f52581d, this.f52582e, this.f52583f, this.f52584g, this.f52585h);
    }

    public b w() {
        return this.f52581d ? this : new b(this.f52578a, this.f52579b, this.f52580c, true, this.f52582e, null, this.f52584g, this.f52585h);
    }

    public b x(DateTimeZone dateTimeZone) {
        return this.f52583f == dateTimeZone ? this : new b(this.f52578a, this.f52579b, this.f52580c, false, this.f52582e, dateTimeZone, this.f52584g, this.f52585h);
    }

    public b y() {
        return x(DateTimeZone.UTC);
    }

    public b(m mVar, k kVar, Locale locale, boolean z10, org.joda.time.a aVar, DateTimeZone dateTimeZone, Integer num, int i10) {
        this.f52578a = mVar;
        this.f52579b = kVar;
        this.f52580c = locale;
        this.f52581d = z10;
        this.f52582e = aVar;
        this.f52583f = dateTimeZone;
        this.f52584g = num;
        this.f52585h = i10;
    }
}
