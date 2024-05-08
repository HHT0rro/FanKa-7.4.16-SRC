package org.joda.time.format;

/* compiled from: InternalParserDateTimeParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class l implements c, k {

    /* renamed from: b, reason: collision with root package name */
    public final k f52645b;

    public l(k kVar) {
        this.f52645b = kVar;
    }

    public static c b(k kVar) {
        if (kVar instanceof e) {
            return ((e) kVar).a();
        }
        if (kVar instanceof c) {
            return (c) kVar;
        }
        if (kVar == null) {
            return null;
        }
        return new l(kVar);
    }

    @Override // org.joda.time.format.c
    public int a(d dVar, String str, int i10) {
        return this.f52645b.parseInto(dVar, str, i10);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            return this.f52645b.equals(((l) obj).f52645b);
        }
        return false;
    }

    @Override // org.joda.time.format.c, org.joda.time.format.k
    public int estimateParsedLength() {
        return this.f52645b.estimateParsedLength();
    }

    @Override // org.joda.time.format.k
    public int parseInto(d dVar, CharSequence charSequence, int i10) {
        return this.f52645b.parseInto(dVar, charSequence, i10);
    }
}
