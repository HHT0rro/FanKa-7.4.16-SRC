package ke;

import java.util.Date;

/* compiled from: DateConverter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class f extends a implements h, l {

    /* renamed from: a, reason: collision with root package name */
    public static final f f50891a = new f();

    @Override // ke.c
    public Class<?> e() {
        return Date.class;
    }

    @Override // ke.a, ke.h
    public long k(Object obj, org.joda.time.a aVar) {
        return ((Date) obj).getTime();
    }
}
