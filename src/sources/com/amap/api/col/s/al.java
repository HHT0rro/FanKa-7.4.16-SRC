package com.amap.api.col.s;

/* compiled from: RequestCacheConfig.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class al {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f7091a;

    public static synchronized void a() {
        synchronized (al.class) {
            if (!f7091a) {
                am.a().a("regeo", new ao("/geocode/regeo"));
                am.a().a("placeAround", new ao("/place/around"));
                am.a().a("placeText", new an("/place/text"));
                am.a().a("geo", new an("/geocode/geo"));
                f7091a = true;
            }
        }
    }
}
