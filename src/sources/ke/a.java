package ke;

import org.joda.time.DateTimeZone;
import org.joda.time.PeriodType;
import org.joda.time.chrono.ISOChronology;

/* compiled from: AbstractConverter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class a implements c {
    public org.joda.time.a a(Object obj, org.joda.time.a aVar) {
        return org.joda.time.c.c(aVar);
    }

    public org.joda.time.a b(Object obj, DateTimeZone dateTimeZone) {
        return ISOChronology.getInstance(dateTimeZone);
    }

    public boolean c(Object obj, org.joda.time.a aVar) {
        return false;
    }

    public int[] f(org.joda.time.k kVar, Object obj, org.joda.time.a aVar, org.joda.time.format.b bVar) {
        return i(kVar, obj, aVar);
    }

    public PeriodType h(Object obj) {
        return PeriodType.standard();
    }

    public int[] i(org.joda.time.k kVar, Object obj, org.joda.time.a aVar) {
        return aVar.get(kVar, k(obj, aVar));
    }

    public long k(Object obj, org.joda.time.a aVar) {
        return org.joda.time.c.b();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Converter[");
        sb2.append(e() == null ? "null" : e().getName());
        sb2.append("]");
        return sb2.toString();
    }
}
