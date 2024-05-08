package com.baidu.mobads.sdk.internal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class bs {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9946a = "logger";

    /* renamed from: b, reason: collision with root package name */
    public static final int f9947b = 2;

    /* renamed from: c, reason: collision with root package name */
    public static final int f9948c = 3;

    /* renamed from: d, reason: collision with root package name */
    public static final int f9949d = 4;

    /* renamed from: e, reason: collision with root package name */
    public static final int f9950e = 5;

    /* renamed from: f, reason: collision with root package name */
    public static final int f9951f = 6;

    /* renamed from: g, reason: collision with root package name */
    public static final int f9952g = 7;

    /* renamed from: h, reason: collision with root package name */
    public static final int f9953h = -1;

    /* renamed from: i, reason: collision with root package name */
    private static volatile bs f9954i;

    private bs() {
    }

    public static bs a() {
        if (f9954i == null) {
            synchronized (bs.class) {
                if (f9954i == null) {
                    f9954i = new bs();
                }
            }
        }
        return f9954i;
    }

    private String e(Object[] objArr) {
        StringBuilder sb2 = new StringBuilder();
        for (Object obj : objArr) {
            sb2.append(obj);
            sb2.append(' ');
        }
        return sb2.toString();
    }

    public boolean a(String str, int i10) {
        return true;
    }

    public void b(String str) {
        if (a(5)) {
            try {
                aw.c().e(str);
            } catch (Exception unused) {
            }
        }
    }

    public void c(Object... objArr) {
        if (a(6)) {
            c(e(objArr));
        }
    }

    public void d(String str) {
        b(f9946a, str);
    }

    public void d(Object... objArr) {
        if (a(4)) {
            d(e(objArr));
        }
    }

    public void b(Object... objArr) {
        if (a(5)) {
            b(e(objArr));
        }
    }

    public void c(String str) {
        if (a(6)) {
            try {
                aw.c().f(str);
            } catch (Exception unused) {
            }
        }
    }

    public void d(String str, Throwable th) {
        if (a(4)) {
            try {
                aw.c().c(th, str);
            } catch (Exception unused) {
            }
        }
    }

    public void b(String str, Throwable th) {
        if (a(5)) {
            try {
                aw.c().d(th, str);
            } catch (Exception unused) {
            }
        }
    }

    public void c(Throwable th) {
        c("", th);
    }

    public void c(String str, Throwable th) {
        if (a(6)) {
            try {
                aw.c().e(th, str);
            } catch (Exception unused) {
            }
        }
    }

    public boolean a(int i10) {
        return a(f9946a, i10);
    }

    public void b(Throwable th) {
        b("", th);
    }

    public void a(Object... objArr) {
        if (a(3)) {
            a(e(objArr));
        }
    }

    public void b(String str, String str2) {
        if (a(4)) {
            try {
                aw.c().c(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    public void a(String str) {
        a(f9946a, str);
    }

    public void a(String str, String str2) {
        if (a(3)) {
            try {
                aw.h(str).c(str2);
            } catch (Exception unused) {
            }
        }
    }

    public void a(Throwable th) {
        a("", th);
    }

    public void a(String str, Throwable th) {
        if (a(3)) {
            try {
                aw.h(f9946a).b(th, str);
            } catch (Exception unused) {
            }
        }
    }
}
