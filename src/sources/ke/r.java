package ke;

import org.joda.time.PeriodType;

/* compiled from: ReadablePeriodConverter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class r extends a implements m {

    /* renamed from: a, reason: collision with root package name */
    public static final r f50898a = new r();

    @Override // ke.m
    public void d(org.joda.time.f fVar, Object obj, org.joda.time.a aVar) {
        fVar.setPeriod((org.joda.time.l) obj);
    }

    @Override // ke.c
    public Class<?> e() {
        return org.joda.time.l.class;
    }

    @Override // ke.a, ke.m
    public PeriodType h(Object obj) {
        return ((org.joda.time.l) obj).getPeriodType();
    }
}
