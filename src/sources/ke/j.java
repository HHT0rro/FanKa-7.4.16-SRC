package ke;

/* compiled from: LongConverter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class j extends a implements h, l, g {

    /* renamed from: a, reason: collision with root package name */
    public static final j f50892a = new j();

    @Override // ke.c
    public Class<?> e() {
        return Long.class;
    }

    @Override // ke.g
    public long g(Object obj) {
        return ((Long) obj).longValue();
    }

    @Override // ke.a, ke.h
    public long k(Object obj, org.joda.time.a aVar) {
        return ((Long) obj).longValue();
    }
}
