package com.amap.api.col.p0003l;

/* compiled from: ThreadUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class dv {

    /* renamed from: b, reason: collision with root package name */
    private static volatile dv f5389b;

    /* renamed from: a, reason: collision with root package name */
    private jd f5390a;

    private dv() {
        this.f5390a = null;
        this.f5390a = dw.a("AMapThreadUtil");
    }

    public static dv a() {
        if (f5389b == null) {
            synchronized (dv.class) {
                if (f5389b == null) {
                    f5389b = new dv();
                }
            }
        }
        return f5389b;
    }

    public static void b() {
        if (f5389b != null) {
            try {
                if (f5389b.f5390a != null) {
                    f5389b.f5390a.e();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            f5389b.f5390a = null;
            f5389b = null;
        }
    }

    public static void b(je jeVar) {
        if (jeVar != null) {
            try {
                jeVar.cancelTask();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(je jeVar) {
        try {
            this.f5390a.a(jeVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
