package com.amap.api.col.s;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* compiled from: OfflineLocManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ee {

    /* renamed from: a, reason: collision with root package name */
    public static int f7884a = 1000;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f7885b = false;

    /* renamed from: c, reason: collision with root package name */
    public static int f7886c = 20;

    /* renamed from: d, reason: collision with root package name */
    public static int f7887d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static WeakReference<eb> f7888e = null;

    /* renamed from: f, reason: collision with root package name */
    private static int f7889f = 10;

    /* compiled from: OfflineLocManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a extends ey {

        /* renamed from: a, reason: collision with root package name */
        private int f7890a = 2;

        /* renamed from: b, reason: collision with root package name */
        private Context f7891b;

        /* renamed from: c, reason: collision with root package name */
        private ed f7892c;

        public a(Context context) {
            this.f7891b = context;
        }

        @Override // com.amap.api.col.s.ey
        public final void a() {
            int i10 = this.f7890a;
            if (i10 == 1) {
                try {
                    synchronized (ee.class) {
                        String l10 = Long.toString(System.currentTimeMillis());
                        eb a10 = eh.a(ee.f7888e);
                        eh.a(this.f7891b, a10, dd.f7657i, ee.f7884a, 2097152, "6");
                        if (a10.f7876e == null) {
                            a10.f7876e = new dl(new dn(new Cdo(new dn())));
                        }
                        ec.a(l10, this.f7892c.a(), a10);
                    }
                    return;
                } catch (Throwable th) {
                    df.c(th, "ofm", "aple");
                    return;
                }
            }
            if (i10 == 2) {
                try {
                    eb a11 = eh.a(ee.f7888e);
                    eh.a(this.f7891b, a11, dd.f7657i, ee.f7884a, 2097152, "6");
                    a11.f7879h = 14400000;
                    if (a11.f7878g == null) {
                        a11.f7878g = new el(new ek(this.f7891b, new ep(), new dl(new dn(new Cdo())), new String(cr.a()), bw.f(this.f7891b), ca.k(), ca.h(), ca.f(this.f7891b), ca.a(), Build.MANUFACTURER, Build.DEVICE, ca.m(), bw.c(this.f7891b), Build.MODEL, bw.d(this.f7891b), bw.b(this.f7891b), ca.e(this.f7891b), ca.a(this.f7891b), String.valueOf(Build.VERSION.SDK_INT), cn.a(this.f7891b).a()));
                    }
                    if (TextUtils.isEmpty(a11.f7880i)) {
                        a11.f7880i = "fKey";
                    }
                    Context context = this.f7891b;
                    a11.f7877f = new et(context, a11.f7879h, a11.f7880i, new er(context, ee.f7885b, ee.f7889f * 1024, ee.f7886c * 1024, "offLocKey", ee.f7887d * 1024));
                    ec.a(a11);
                } catch (Throwable th2) {
                    df.c(th2, "ofm", "uold");
                }
            }
        }
    }

    public static void a(Context context) {
        ex.a().b(new a(context));
    }
}
