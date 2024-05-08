package ke;

/* compiled from: ReadableIntervalConverter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class p extends a implements i, g, m {

    /* renamed from: a, reason: collision with root package name */
    public static final p f50896a = new p();

    @Override // ke.a, ke.i
    public boolean c(Object obj, org.joda.time.a aVar) {
        return true;
    }

    @Override // ke.m
    public void d(org.joda.time.f fVar, Object obj, org.joda.time.a aVar) {
        org.joda.time.j jVar = (org.joda.time.j) obj;
        if (aVar == null) {
            aVar = org.joda.time.c.j(jVar);
        }
        int[] iArr = aVar.get(fVar, jVar.getStartMillis(), jVar.getEndMillis());
        for (int i10 = 0; i10 < iArr.length; i10++) {
            fVar.setValue(i10, iArr[i10]);
        }
    }

    @Override // ke.c
    public Class<?> e() {
        return org.joda.time.j.class;
    }

    @Override // ke.g
    public long g(Object obj) {
        return ((org.joda.time.j) obj).toDurationMillis();
    }

    @Override // ke.i
    public void j(org.joda.time.e eVar, Object obj, org.joda.time.a aVar) {
        org.joda.time.j jVar = (org.joda.time.j) obj;
        eVar.setInterval(jVar);
        if (aVar != null) {
            eVar.setChronology(aVar);
        } else {
            eVar.setChronology(jVar.getChronology());
        }
    }
}
