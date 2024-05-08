package ke;

/* compiled from: ReadableDurationConverter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class n extends a implements g, m {

    /* renamed from: a, reason: collision with root package name */
    public static final n f50894a = new n();

    @Override // ke.m
    public void d(org.joda.time.f fVar, Object obj, org.joda.time.a aVar) {
        int[] iArr = org.joda.time.c.c(aVar).get(fVar, ((org.joda.time.h) obj).getMillis());
        for (int i10 = 0; i10 < iArr.length; i10++) {
            fVar.setValue(i10, iArr[i10]);
        }
    }

    @Override // ke.c
    public Class<?> e() {
        return org.joda.time.h.class;
    }

    @Override // ke.g
    public long g(Object obj) {
        return ((org.joda.time.h) obj).getMillis();
    }
}
