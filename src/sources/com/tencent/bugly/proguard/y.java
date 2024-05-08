package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f40238a = true;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f40239b = true;

    /* renamed from: c, reason: collision with root package name */
    private static SimpleDateFormat f40240c = null;

    /* renamed from: d, reason: collision with root package name */
    private static int f40241d = 30720;

    /* renamed from: e, reason: collision with root package name */
    private static StringBuilder f40242e;

    /* renamed from: f, reason: collision with root package name */
    private static StringBuilder f40243f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f40244g;

    /* renamed from: h, reason: collision with root package name */
    private static a f40245h;

    /* renamed from: i, reason: collision with root package name */
    private static String f40246i;

    /* renamed from: j, reason: collision with root package name */
    private static String f40247j;

    /* renamed from: k, reason: collision with root package name */
    private static Context f40248k;

    /* renamed from: l, reason: collision with root package name */
    private static String f40249l;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f40250m;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f40251n;

    /* renamed from: o, reason: collision with root package name */
    private static ExecutorService f40252o;

    /* renamed from: p, reason: collision with root package name */
    private static int f40253p;

    /* renamed from: q, reason: collision with root package name */
    private static final Object f40254q = new Object();

    /* compiled from: BUGLY */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f40258a;

        /* renamed from: b, reason: collision with root package name */
        private File f40259b;

        /* renamed from: c, reason: collision with root package name */
        private String f40260c;

        /* renamed from: d, reason: collision with root package name */
        private long f40261d;

        /* renamed from: e, reason: collision with root package name */
        private long f40262e = 30720;

        public a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.f40260c = str;
            this.f40258a = a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a() {
            try {
                File file = new File(this.f40260c);
                this.f40259b = file;
                if (file.exists() && !this.f40259b.delete()) {
                    this.f40258a = false;
                    return false;
                }
                if (this.f40259b.createNewFile()) {
                    return true;
                }
                this.f40258a = false;
                return false;
            } catch (Throwable th) {
                x.a(th);
                this.f40258a = false;
                return false;
            }
        }

        public final boolean a(String str) {
            FileOutputStream fileOutputStream;
            if (!this.f40258a) {
                return false;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(this.f40259b, true);
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str.getBytes("UTF-8"));
                fileOutputStream.flush();
                fileOutputStream.close();
                this.f40261d += r10.length;
                this.f40258a = true;
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                try {
                    x.a(th);
                    this.f40258a = false;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    static {
        try {
            f40240c = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            x.b(th.getCause());
        }
    }

    public static synchronized void a(Context context) {
        synchronized (y.class) {
            if (f40250m || context == null || !f40238a) {
                return;
            }
            try {
                f40252o = Executors.newSingleThreadExecutor();
                f40243f = new StringBuilder(0);
                f40242e = new StringBuilder(0);
                f40248k = context;
                f40246i = com.tencent.bugly.crashreport.common.info.a.a(context).f39096d;
                f40247j = "";
                f40249l = f40248k.getFilesDir().getPath() + "/buglylog_" + f40246i + "_" + f40247j + ".txt";
                f40253p = Process.myPid();
            } catch (Throwable unused) {
            }
            f40250m = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(String str, String str2, String str3) {
        synchronized (y.class) {
            if (f40239b) {
                d(str, str2, str3);
            } else {
                e(str, str2, str3);
            }
        }
    }

    private static synchronized void d(String str, String str2, String str3) {
        synchronized (y.class) {
            String a10 = a(str, str2, str3, Process.myTid());
            synchronized (f40254q) {
                try {
                    f40243f.append(a10);
                    if (f40243f.length() >= f40241d) {
                        StringBuilder sb2 = f40243f;
                        f40243f = sb2.delete(0, sb2.indexOf("\u0001\r\n") + 1);
                    }
                } finally {
                }
            }
        }
    }

    private static synchronized void e(String str, String str2, String str3) {
        synchronized (y.class) {
            String a10 = a(str, str2, str3, Process.myTid());
            synchronized (f40254q) {
                try {
                    f40243f.append(a10);
                } catch (Throwable unused) {
                }
                if (f40243f.length() <= f40241d) {
                    return;
                }
                if (f40244g) {
                    return;
                }
                f40244g = true;
                a aVar = f40245h;
                if (aVar != null) {
                    if (aVar.f40259b == null || f40245h.f40259b.length() + f40243f.length() > f40245h.f40262e) {
                        f40245h.a();
                    }
                } else {
                    f40245h = new a(f40249l);
                }
                if (f40245h.a(f40243f.toString())) {
                    f40243f.setLength(0);
                    f40244g = false;
                }
            }
        }
    }

    private static byte[] b() {
        if (!f40238a) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        synchronized (f40254q) {
            a aVar = f40245h;
            if (aVar != null && aVar.f40258a && f40245h.f40259b != null && f40245h.f40259b.length() > 0) {
                sb2.append(z.a(f40245h.f40259b, 30720, true));
            }
            StringBuilder sb3 = f40243f;
            if (sb3 != null && sb3.length() > 0) {
                sb2.append(f40243f.toString());
            }
        }
        return z.a((File) null, sb2.toString(), "BuglyLog.txt");
    }

    public static void a(int i10) {
        synchronized (f40254q) {
            f40241d = i10;
            if (i10 < 0) {
                f40241d = 0;
            } else if (i10 > 30720) {
                f40241d = 30720;
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        a(str, str2, message + '\n' + z.b(th));
    }

    public static synchronized void a(final String str, final String str2, final String str3) {
        synchronized (y.class) {
            if (f40250m && f40238a) {
                try {
                    f40252o.execute(new Runnable() { // from class: com.tencent.bugly.proguard.y.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            y.c(String.this, str2, str3);
                        }
                    });
                } catch (Exception e2) {
                    x.b(e2);
                }
            }
        }
    }

    private static String a(String str, String str2, String str3, long j10) {
        String date;
        f40242e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = f40240c;
        if (simpleDateFormat != null) {
            date = simpleDateFormat.format(date2);
        } else {
            date = date2.toString();
        }
        StringBuilder sb2 = f40242e;
        sb2.append(date);
        sb2.append(" ");
        sb2.append(f40253p);
        sb2.append(" ");
        sb2.append(j10);
        sb2.append(" ");
        sb2.append(str);
        sb2.append(" ");
        sb2.append(str2);
        sb2.append(": ");
        sb2.append(str3);
        sb2.append("\u0001\r\n");
        return f40242e.toString();
    }

    public static byte[] a() {
        if (f40239b) {
            if (f40238a) {
                return z.a((File) null, f40243f.toString(), "BuglyLog.txt");
            }
            return null;
        }
        return b();
    }
}
