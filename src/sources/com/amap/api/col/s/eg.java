package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Random;

/* compiled from: StatisticsManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class eg {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f7898a = false;

    /* renamed from: b, reason: collision with root package name */
    public static int f7899b = 20;

    /* renamed from: c, reason: collision with root package name */
    private static int f7900c = 20;

    /* renamed from: d, reason: collision with root package name */
    private static WeakReference<eb> f7901d;

    /* renamed from: e, reason: collision with root package name */
    private static int f7902e;

    public static synchronized void a(ef efVar, Context context) {
        synchronized (eg.class) {
            ex.a().b(new a(context, a.f7903a, efVar));
        }
    }

    /* compiled from: StatisticsManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a extends ey {

        /* renamed from: a, reason: collision with root package name */
        public static int f7903a = 1;

        /* renamed from: b, reason: collision with root package name */
        public static int f7904b = 2;

        /* renamed from: c, reason: collision with root package name */
        public static int f7905c = 3;

        /* renamed from: d, reason: collision with root package name */
        private Context f7906d;

        /* renamed from: f, reason: collision with root package name */
        private ef f7907f;

        /* renamed from: g, reason: collision with root package name */
        private int f7908g;

        /* renamed from: h, reason: collision with root package name */
        private List<ef> f7909h;

        public a(Context context, int i10) {
            this.f7906d = context;
            this.f7908g = i10;
        }

        @Override // com.amap.api.col.s.ey
        public final void a() {
            ef efVar;
            Throwable th;
            ByteArrayOutputStream byteArrayOutputStream;
            int i10 = this.f7908g;
            if (i10 == 1) {
                try {
                    if (this.f7906d != null && this.f7907f != null) {
                        synchronized (eg.class) {
                            Context context = this.f7906d;
                            if (context != null && (efVar = this.f7907f) != null) {
                                eg.a(context, efVar.a());
                                return;
                            }
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    df.c(th2, "stm", "as");
                    return;
                }
            }
            if (i10 != 2) {
                if (i10 == 3) {
                    try {
                        if (this.f7906d == null) {
                            return;
                        }
                        eb a10 = eh.a(eg.f7901d);
                        eh.a(this.f7906d, a10, dd.f7656h, 1000, 307200, "2");
                        if (a10.f7878g == null) {
                            a10.f7878g = new ei(new em(this.f7906d, new ej(new en(new ep()))));
                        }
                        a10.f7879h = 3600000;
                        if (TextUtils.isEmpty(a10.f7880i)) {
                            a10.f7880i = "cKey";
                        }
                        if (a10.f7877f == null) {
                            Context context2 = this.f7906d;
                            a10.f7877f = new et(context2, a10.f7879h, a10.f7880i, new eq(a10.f7872a, new er(context2, eg.f7898a, eg.f7900c * 1024, eg.f7899b * 1024, "staticUpdate", eg.f7902e * 1024)));
                        }
                        ec.a(a10);
                        return;
                    } catch (Throwable th3) {
                        df.c(th3, "stm", "usd");
                        return;
                    }
                }
                return;
            }
            try {
                synchronized (eg.class) {
                    if (this.f7909h != null && this.f7906d != null) {
                        ByteArrayOutputStream byteArrayOutputStream2 = null;
                        byte[] bArr = new byte[0];
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                        } catch (Throwable th4) {
                            th = th4;
                        }
                        try {
                            for (ef efVar2 : this.f7909h) {
                                if (efVar2 != null) {
                                    byteArrayOutputStream.write(efVar2.a());
                                }
                            }
                            bArr = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable th5) {
                                th = th5;
                                th.printStackTrace();
                                eg.a(this.f7906d, bArr);
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            try {
                                df.c(th, "stm", "aStB");
                                if (byteArrayOutputStream2 != null) {
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (Throwable th7) {
                                        th = th7;
                                        th.printStackTrace();
                                        eg.a(this.f7906d, bArr);
                                    }
                                }
                                eg.a(this.f7906d, bArr);
                            } finally {
                            }
                        }
                        eg.a(this.f7906d, bArr);
                    }
                }
            } catch (Throwable th8) {
                df.c(th8, "stm", "apb");
            }
        }

        public a(Context context, int i10, List<ef> list) {
            this(context, i10);
            this.f7909h = list;
        }

        public a(Context context, int i10, ef efVar) {
            this(context, i10);
            this.f7907f = efVar;
        }
    }

    public static synchronized void a(List<ef> list, Context context) {
        synchronized (eg.class) {
            if (list != null) {
                try {
                    if (list.size() != 0) {
                        ex.a().b(new a(context, a.f7904b, list));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void a(Context context) {
        ex.a().b(new a(context, a.f7905c));
    }

    public static /* synthetic */ void a(Context context, byte[] bArr) throws IOException {
        eb a10 = eh.a(f7901d);
        eh.a(context, a10, dd.f7656h, 1000, 307200, "2");
        if (a10.f7876e == null) {
            a10.f7876e = new dj();
        }
        try {
            ec.a(Integer.toString(new Random().nextInt(100)) + Long.toString(System.nanoTime()), bArr, a10);
        } catch (Throwable th) {
            df.c(th, "stm", "wts");
        }
    }
}
