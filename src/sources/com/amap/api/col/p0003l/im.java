package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

/* compiled from: StatisticsManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class im {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f6479a = false;

    /* renamed from: b, reason: collision with root package name */
    public static int f6480b = 20;

    /* renamed from: c, reason: collision with root package name */
    private static int f6481c = 20;

    /* renamed from: d, reason: collision with root package name */
    private static WeakReference<ig> f6482d;

    /* renamed from: e, reason: collision with root package name */
    private static int f6483e;

    public static synchronized void a(boolean z10, int i10) {
        synchronized (im.class) {
            f6479a = z10;
            f6483e = Math.max(0, i10);
        }
    }

    public static synchronized void b(List<il> list, Context context) {
        synchronized (im.class) {
            try {
                List<il> b4 = hz.b();
                if (b4 != null && b4.size() > 0) {
                    list.addAll(b4);
                }
            } catch (Throwable unused) {
            }
            a(list, context);
        }
    }

    /* compiled from: StatisticsManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a extends je {

        /* renamed from: a, reason: collision with root package name */
        public static int f6484a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static int f6485b = 2;

        /* renamed from: c, reason: collision with root package name */
        public static int f6486c = 3;

        /* renamed from: d, reason: collision with root package name */
        private Context f6487d;

        /* renamed from: e, reason: collision with root package name */
        private il f6488e;

        /* renamed from: g, reason: collision with root package name */
        private int f6489g;

        /* renamed from: h, reason: collision with root package name */
        private List<il> f6490h;

        public a(Context context, int i10) {
            this.f6487d = context;
            this.f6489g = i10;
        }

        @Override // com.amap.api.col.p0003l.je
        public final void runTask() {
            il ilVar;
            Throwable th;
            ByteArrayOutputStream byteArrayOutputStream;
            int i10 = this.f6489g;
            if (i10 == 1) {
                try {
                    if (this.f6487d != null && this.f6488e != null) {
                        synchronized (im.class) {
                            Context context = this.f6487d;
                            if (context != null && (ilVar = this.f6488e) != null) {
                                im.a(context, ilVar.a());
                                return;
                            }
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    gy.b(th2, "stm", "as");
                    return;
                }
            }
            if (i10 != 2) {
                if (i10 == 3) {
                    try {
                        if (this.f6487d == null) {
                            return;
                        }
                        ig a10 = in.a(im.f6482d);
                        in.a(this.f6487d, a10, gw.f6169h, 1000, 307200, "2");
                        if (a10.f6456g == null) {
                            a10.f6456g = new io(new is(this.f6487d, new ip(new it(new iv()))));
                        }
                        a10.f6457h = 3600000;
                        if (TextUtils.isEmpty(a10.f6458i)) {
                            a10.f6458i = "cKey";
                        }
                        if (a10.f6455f == null) {
                            Context context2 = this.f6487d;
                            a10.f6455f = new iz(context2, a10.f6457h, a10.f6458i, new iw(a10.f6450a, new ix(context2, im.f6479a, im.f6481c * 1024, im.f6480b * 1024, "staticUpdate", im.f6483e * 1024)));
                        }
                        ih.a(a10);
                        return;
                    } catch (Throwable th3) {
                        gy.b(th3, "stm", "usd");
                        return;
                    }
                }
                return;
            }
            try {
                synchronized (im.class) {
                    if (this.f6490h != null && this.f6487d != null) {
                        ByteArrayOutputStream byteArrayOutputStream2 = null;
                        byte[] bArr = new byte[0];
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                        } catch (Throwable th4) {
                            th = th4;
                        }
                        try {
                            for (il ilVar2 : this.f6490h) {
                                if (ilVar2 != null) {
                                    byteArrayOutputStream.write(ilVar2.a());
                                }
                            }
                            bArr = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable th5) {
                                th = th5;
                                th.printStackTrace();
                                im.a(this.f6487d, bArr);
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            try {
                                gy.b(th, "stm", "aStB");
                                if (byteArrayOutputStream2 != null) {
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (Throwable th7) {
                                        th = th7;
                                        th.printStackTrace();
                                        im.a(this.f6487d, bArr);
                                    }
                                }
                                im.a(this.f6487d, bArr);
                            } finally {
                            }
                        }
                        im.a(this.f6487d, bArr);
                    }
                }
            } catch (Throwable th8) {
                gy.b(th8, "stm", "apb");
            }
        }

        public a(Context context, int i10, List<il> list) {
            this(context, i10);
            this.f6490h = list;
        }

        public a(Context context, int i10, il ilVar) {
            this(context, i10);
            this.f6488e = ilVar;
        }
    }

    public static synchronized void a(il ilVar, Context context) {
        synchronized (im.class) {
            jd.a().a(new a(context, a.f6484a, ilVar));
        }
    }

    public static synchronized void a(List<il> list, Context context) {
        synchronized (im.class) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        jd.a().a(new a(context, a.f6485b, list));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void a(Context context) {
        jd.a().a(new a(context, a.f6486c));
    }

    public static /* synthetic */ void a(Context context, byte[] bArr) throws IOException {
        ig a10 = in.a(f6482d);
        in.a(context, a10, gw.f6169h, 1000, 307200, "2");
        if (a10.f6454e == null) {
            a10.f6454e = new hm();
        }
        try {
            ih.a(Integer.toString(new Random().nextInt(100)) + Long.toString(System.nanoTime()), bArr, a10);
        } catch (Throwable th) {
            gy.b(th, "stm", "wts");
        }
    }
}
