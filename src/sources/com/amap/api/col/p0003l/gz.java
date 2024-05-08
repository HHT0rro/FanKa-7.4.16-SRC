package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ErrorLogManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class gz {

    /* renamed from: a, reason: collision with root package name */
    private static WeakReference<ig> f6188a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f6189b = true;

    /* renamed from: c, reason: collision with root package name */
    private static WeakReference<ja> f6190c;

    /* renamed from: d, reason: collision with root package name */
    private static WeakReference<ja> f6191d;

    /* renamed from: e, reason: collision with root package name */
    private static String[] f6192e = new String[10];

    /* renamed from: f, reason: collision with root package name */
    private static int f6193f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f6194g;

    /* renamed from: h, reason: collision with root package name */
    private static int f6195h;

    /* renamed from: i, reason: collision with root package name */
    private static fu f6196i;

    /* compiled from: ErrorLogManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a(int i10);
    }

    public static void b(Context context) {
        iy iyVar = new iy(f6189b);
        f6189b = false;
        a(context, iyVar, gw.f6164c);
    }

    public static void c(Context context) {
        WeakReference<ja> weakReference = f6190c;
        if (weakReference == null || weakReference.get() == null) {
            f6190c = new WeakReference<>(new iz(context, 3600000, "hKey", new jb(context, false)));
        }
        a(context, f6190c.get(), gw.f6165d);
    }

    public static void d(Context context) {
        WeakReference<ja> weakReference = f6191d;
        if (weakReference == null || weakReference.get() == null) {
            f6191d = new WeakReference<>(new iz(context, 3600000, "gKey", new jb(context, false)));
        }
        a(context, f6191d.get(), gw.f6163b);
    }

    private static boolean a(fu fuVar) {
        return fuVar != null && fuVar.e();
    }

    private static void a(Context context, fu fuVar, int i10, String str, String str2) {
        String str3;
        String a10 = in.a();
        String a11 = in.a(context, fuVar);
        fj.a(context);
        String a12 = in.a(a11, a10, i10, str, str2);
        if (a12 == null || "".equals(a12)) {
            return;
        }
        String c4 = fq.c(str2);
        if (i10 == 1) {
            str3 = gw.f6163b;
        } else if (i10 == 2) {
            str3 = gw.f6165d;
        } else if (i10 != 0) {
            return;
        } else {
            str3 = gw.f6164c;
        }
        String str4 = str3;
        ig a13 = in.a(f6188a);
        in.a(context, a13, str4, 1000, 4096000, "1");
        if (a13.f6454e == null) {
            a13.f6454e = new hn(new ho(new hq(new hr())));
        }
        try {
            ih.a(c4, fv.a(a12.replaceAll("\n", "<br/>")), a13);
        } catch (Throwable unused) {
        }
    }

    private static String b() {
        StringBuilder sb2 = new StringBuilder();
        try {
            for (int i10 = f6193f; i10 < 10 && i10 <= 9; i10++) {
                sb2.append(f6192e[i10]);
            }
            for (int i11 = 0; i11 < f6193f; i11++) {
                sb2.append(f6192e[i11]);
            }
        } catch (Throwable th) {
            gy.b(th, "alg", "gLI");
        }
        return sb2.toString();
    }

    public static void a(Context context) {
        String a10;
        fu fuVar;
        List<fu> a11 = gw.a();
        if (a11 == null || a11.size() == 0 || (a10 = a(a11)) == null || "".equals(a10) || (fuVar = f6196i) == null) {
            return;
        }
        a(context, fuVar, 2, "ANR", a10);
    }

    public static void a(Context context, fu fuVar, String str, int i10, String str2, String str3) {
        if (str2 == null || "".equals(str2)) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("class:");
        sb2.append(str2);
        if (str3 != null) {
            sb2.append(" method:");
            sb2.append(str3);
            sb2.append("$<br/>");
        }
        sb2.append(str);
        a(context, fuVar, i10, str2, sb2.toString());
    }

    public static void a(Context context, Throwable th, int i10, String str, String str2) {
        String a10 = fv.a(th);
        fu a11 = a(a10);
        if (a(a11)) {
            String replaceAll = a10.replaceAll("\n", "<br/>");
            String th2 = th.toString();
            if (th2 == null || "".equals(th2)) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            if (str != null) {
                sb2.append("class:");
                sb2.append(str);
            }
            if (str2 != null) {
                sb2.append(" method:");
                sb2.append(str2);
                sb2.append("$<br/>");
            }
            sb2.append(replaceAll);
            a(context, a11, i10, th2, sb2.toString());
        }
    }

    public static void a(fu fuVar, Context context, String str, String str2) {
        if (!a(fuVar) || str == null || "".equals(str)) {
            return;
        }
        a(context, fuVar, 1, str, str2);
    }

    public static void a(final Context context, final fu fuVar, final String str, final ig igVar, final String str2) {
        try {
            jd.a().a(new je() { // from class: com.amap.api.col.3l.gz.1
                @Override // com.amap.api.col.p0003l.je
                public final void runTask() {
                    String a10 = gz.a(context, fuVar, str, str2);
                    ig igVar2 = igVar;
                    if (igVar2.f6454e == null) {
                        igVar2.f6454e = new hn(new ho(new hq(new hr())));
                    }
                    try {
                        ih.a(fq.c(a10), fv.a(a10), igVar);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    private static void a(final Context context, final ja jaVar, final String str) {
        jd.a().a(new je() { // from class: com.amap.api.col.3l.gz.2
            @Override // com.amap.api.col.p0003l.je
            public final void runTask() {
                try {
                    synchronized (gz.class) {
                        ig a10 = in.a(gz.f6188a);
                        in.a(context, a10, str, 1000, 4096000, "1");
                        a10.f6455f = jaVar;
                        if (a10.f6456g == null) {
                            a10.f6456g = new ir(new iq(context, new iv(), new ho(new hq(new hr())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", fj.f(context), fm.k(), fm.p(context), fj.c(context), Build.MODEL, fj.b(context), fj.d(context), Build.VERSION.RELEASE));
                        }
                        a10.f6457h = 3600000;
                        ih.a(a10);
                    }
                } catch (Throwable th) {
                    gy.b(th, "lg", "pul");
                }
            }
        });
    }

    public static void a(final Context context, final ig igVar, final a aVar) {
        try {
            jd.a().a(new je() { // from class: com.amap.api.col.3l.gz.3
                @Override // com.amap.api.col.p0003l.je
                public final void runTask() {
                    try {
                        synchronized (gz.class) {
                            ig igVar2 = ig.this;
                            if (igVar2.f6456g == null) {
                                igVar2.f6456g = new ir(new iq(context, new iv(), new ho(new hq(new hr())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", fj.f(context), fm.k(), fm.p(context), fj.c(context), Build.MODEL, fj.b(context), fj.d(context), Build.VERSION.RELEASE));
                            }
                            int a10 = ih.a(ig.this);
                            a aVar2 = aVar;
                            if (aVar2 != null) {
                                aVar2.a(a10);
                            }
                        }
                    } catch (Throwable th) {
                        gy.b(th, "lg", "pul");
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    private static fu a(String str) {
        Iterable<fu> a10 = gw.a();
        if (a10 == null) {
            a10 = new ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (fu fuVar : a10) {
                if (gw.a(fuVar.f(), str)) {
                    return fuVar;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return fv.a();
                } catch (fi e2) {
                    e2.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    fu b4 = fv.b();
                    b4.a(true);
                    return b4;
                } catch (fi e10) {
                    e10.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0101 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:101:0x00f5 -> B:28:0x00f8). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.util.List<com.amap.api.col.p0003l.fu> r11) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.gz.a(java.util.List):java.lang.String");
    }

    public static /* synthetic */ String a(Context context, fu fuVar, String str, String str2) {
        String a10 = in.a();
        String a11 = in.a(context, fuVar);
        fj.a(context);
        return in.a(a11, a10, str, str2);
    }
}
