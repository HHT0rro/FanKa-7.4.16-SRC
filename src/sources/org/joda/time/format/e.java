package org.joda.time.format;

/* compiled from: DateTimeParserInternalParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class e implements k {

    /* renamed from: b, reason: collision with root package name */
    public final c f52608b;

    public e(c cVar) {
        this.f52608b = cVar;
    }

    public static k b(c cVar) {
        if (cVar instanceof l) {
            return (k) cVar;
        }
        if (cVar == null) {
            return null;
        }
        return new e(cVar);
    }

    public c a() {
        return this.f52608b;
    }

    @Override // org.joda.time.format.k
    public int estimateParsedLength() {
        return this.f52608b.estimateParsedLength();
    }

    @Override // org.joda.time.format.k
    public int parseInto(d dVar, CharSequence charSequence, int i10) {
        return this.f52608b.a(dVar, charSequence.toString(), i10);
    }
}
