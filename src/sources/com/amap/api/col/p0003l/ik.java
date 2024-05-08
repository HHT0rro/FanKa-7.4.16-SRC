package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* compiled from: OfflineLocManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ik {

    /* renamed from: a, reason: collision with root package name */
    public static int f6465a = 1000;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f6466b = false;

    /* renamed from: c, reason: collision with root package name */
    public static int f6467c = 20;

    /* renamed from: d, reason: collision with root package name */
    public static int f6468d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static WeakReference<ig> f6469e = null;

    /* renamed from: f, reason: collision with root package name */
    private static int f6470f = 10;

    @Deprecated
    public static synchronized void a(int i10, boolean z10) {
        synchronized (ik.class) {
            f6465a = i10;
            f6466b = z10;
        }
    }

    /* compiled from: OfflineLocManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a extends je {

        /* renamed from: a, reason: collision with root package name */
        private int f6471a;

        /* renamed from: b, reason: collision with root package name */
        private Context f6472b;

        /* renamed from: c, reason: collision with root package name */
        private ij f6473c;

        public a(Context context, int i10) {
            this.f6472b = context;
            this.f6471a = i10;
        }

        @Override // com.amap.api.col.p0003l.je
        public final void runTask() {
            int i10 = this.f6471a;
            if (i10 == 1) {
                try {
                    synchronized (ik.class) {
                        String l10 = Long.toString(System.currentTimeMillis());
                        ig a10 = in.a(ik.f6469e);
                        in.a(this.f6472b, a10, gw.f6170i, ik.f6465a, 2097152, "6");
                        if (a10.f6454e == null) {
                            a10.f6454e = new ho(new hq(new hr(new hq())));
                        }
                        ih.a(l10, this.f6473c.a(), a10);
                    }
                    return;
                } catch (Throwable th) {
                    gy.b(th, "ofm", "aple");
                    return;
                }
            }
            if (i10 == 2) {
                try {
                    ig a11 = in.a(ik.f6469e);
                    in.a(this.f6472b, a11, gw.f6170i, ik.f6465a, 2097152, "6");
                    a11.f6457h = 14400000;
                    if (a11.f6456g == null) {
                        a11.f6456g = new ir(new iq(this.f6472b, new iv(), new ho(new hq(new hr())), new String(gj.a()), fj.f(this.f6472b), fm.k(), fm.h(), fm.f(this.f6472b), fm.a(), Build.MANUFACTURER, Build.DEVICE, fm.n(), fj.c(this.f6472b), Build.MODEL, fj.d(this.f6472b), fj.b(this.f6472b), fm.e(this.f6472b), fm.a(this.f6472b), String.valueOf(Build.VERSION.SDK_INT), ga.a(this.f6472b).a()));
                    }
                    if (TextUtils.isEmpty(a11.f6458i)) {
                        a11.f6458i = "fKey";
                    }
                    Context context = this.f6472b;
                    a11.f6455f = new iz(context, a11.f6457h, a11.f6458i, new ix(context, ik.f6466b, ik.f6470f * 1024, ik.f6467c * 1024, "offLocKey", ik.f6468d * 1024));
                    ih.a(a11);
                } catch (Throwable th2) {
                    gy.b(th2, "ofm", "uold");
                }
            }
        }

        public a(Context context, ij ijVar) {
            this(context, 1);
            this.f6473c = ijVar;
        }
    }

    public static synchronized void a(int i10, boolean z10, int i11, int i12) {
        synchronized (ik.class) {
            f6465a = i10;
            f6466b = z10;
            if (i11 < 10 || i11 > 100) {
                i11 = 20;
            }
            f6467c = i11;
            if (i11 / 5 > f6470f) {
                f6470f = i11 / 5;
            }
            f6468d = i12;
        }
    }

    public static synchronized void a(ij ijVar, Context context) {
        synchronized (ik.class) {
            jd.a().a(new a(context, ijVar));
        }
    }

    public static void a(Context context) {
        jd.a().a(new a(context, 2));
    }
}
