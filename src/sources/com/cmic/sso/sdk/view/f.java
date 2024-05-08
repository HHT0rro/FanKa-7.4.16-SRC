package com.cmic.sso.sdk.view;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static f f11566a;

    /* renamed from: b, reason: collision with root package name */
    private a f11567b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void a();
    }

    public static f a() {
        if (f11566a == null) {
            synchronized (f.class) {
                if (f11566a == null) {
                    f11566a = new f();
                }
            }
        }
        return f11566a;
    }

    public void a(a aVar) {
        this.f11567b = aVar;
    }

    public a b() {
        return this.f11567b;
    }

    public void c() {
        if (this.f11567b != null) {
            this.f11567b = null;
        }
    }
}
