package ke;

import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;

/* compiled from: ReadableInstantConverter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class o extends a implements h, l {

    /* renamed from: a, reason: collision with root package name */
    public static final o f50895a = new o();

    @Override // ke.a, ke.h, ke.l
    public org.joda.time.a a(Object obj, org.joda.time.a aVar) {
        return aVar == null ? org.joda.time.c.c(((org.joda.time.i) obj).getChronology()) : aVar;
    }

    @Override // ke.a, ke.h, ke.l
    public org.joda.time.a b(Object obj, DateTimeZone dateTimeZone) {
        org.joda.time.a chronology = ((org.joda.time.i) obj).getChronology();
        if (chronology == null) {
            return ISOChronology.getInstance(dateTimeZone);
        }
        if (chronology.getZone() == dateTimeZone) {
            return chronology;
        }
        org.joda.time.a withZone = chronology.withZone(dateTimeZone);
        return withZone == null ? ISOChronology.getInstance(dateTimeZone) : withZone;
    }

    @Override // ke.c
    public Class<?> e() {
        return org.joda.time.i.class;
    }

    @Override // ke.a, ke.h
    public long k(Object obj, org.joda.time.a aVar) {
        return ((org.joda.time.i) obj).getMillis();
    }
}
