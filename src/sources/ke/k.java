package ke;

/* compiled from: NullConverter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class k extends a implements h, l, g, m, i {

    /* renamed from: a, reason: collision with root package name */
    public static final k f50893a = new k();

    @Override // ke.m
    public void d(org.joda.time.f fVar, Object obj, org.joda.time.a aVar) {
        fVar.setPeriod(null);
    }

    @Override // ke.c
    public Class<?> e() {
        return null;
    }

    @Override // ke.g
    public long g(Object obj) {
        return 0L;
    }

    @Override // ke.i
    public void j(org.joda.time.e eVar, Object obj, org.joda.time.a aVar) {
        eVar.setChronology(aVar);
        long b4 = org.joda.time.c.b();
        eVar.setInterval(b4, b4);
    }
}
