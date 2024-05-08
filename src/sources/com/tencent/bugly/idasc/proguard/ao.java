package com.tencent.bugly.idasc.proguard;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ao {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f39574a = true;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f39575b = true;

    /* renamed from: c, reason: collision with root package name */
    private static SimpleDateFormat f39576c = null;

    /* renamed from: d, reason: collision with root package name */
    private static int f39577d = 30720;

    /* renamed from: e, reason: collision with root package name */
    private static StringBuilder f39578e;

    /* renamed from: f, reason: collision with root package name */
    private static StringBuilder f39579f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f39580g;

    /* renamed from: h, reason: collision with root package name */
    private static a f39581h;

    /* renamed from: i, reason: collision with root package name */
    private static String f39582i;

    /* renamed from: j, reason: collision with root package name */
    private static String f39583j;

    /* renamed from: k, reason: collision with root package name */
    private static Context f39584k;

    /* renamed from: l, reason: collision with root package name */
    private static String f39585l;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f39586m;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f39587n;

    /* renamed from: o, reason: collision with root package name */
    private static ExecutorService f39588o;

    /* renamed from: p, reason: collision with root package name */
    private static int f39589p;

    /* renamed from: q, reason: collision with root package name */
    private static final Object f39590q = new Object();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f39597a;

        /* renamed from: b, reason: collision with root package name */
        public File f39598b;

        /* renamed from: c, reason: collision with root package name */
        public long f39599c = 30720;

        /* renamed from: d, reason: collision with root package name */
        private String f39600d;

        /* renamed from: e, reason: collision with root package name */
        private long f39601e;

        public a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.f39600d = str;
            this.f39597a = a();
        }

        public final boolean a() {
            try {
                File file = new File(this.f39600d);
                this.f39598b = file;
                if (file.exists() && !this.f39598b.delete()) {
                    this.f39597a = false;
                    return false;
                }
                if (this.f39598b.createNewFile()) {
                    return true;
                }
                this.f39597a = false;
                return false;
            } catch (Throwable th) {
                al.a(th);
                this.f39597a = false;
                return false;
            }
        }

        public final boolean a(String str) {
            FileOutputStream fileOutputStream;
            if (!this.f39597a) {
                return false;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(this.f39598b, true);
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str.getBytes("UTF-8"));
                fileOutputStream.flush();
                fileOutputStream.close();
                this.f39601e += r10.length;
                this.f39597a = true;
                try {
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
                return true;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                try {
                    al.a(th);
                    this.f39597a = false;
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
            f39576c = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable th) {
            al.b(th.getCause());
        }
    }

    private static String a(String str, String str2, String str3, long j10) {
        f39578e.setLength(0);
        if (str3.length() > 30720) {
            str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = f39576c;
        String format = simpleDateFormat != null ? simpleDateFormat.format(date) : date.toString();
        StringBuilder sb2 = f39578e;
        sb2.append(format);
        sb2.append(" ");
        sb2.append(f39589p);
        sb2.append(" ");
        sb2.append(j10);
        sb2.append(" ");
        sb2.append(str);
        sb2.append(" ");
        sb2.append(str2);
        sb2.append(": ");
        sb2.append(str3);
        sb2.append("\u0001\r\n");
        return f39578e.toString();
    }

    public static void a(int i10) {
        synchronized (f39590q) {
            f39577d = i10;
            if (i10 < 0) {
                f39577d = 0;
            } else if (i10 > 30720) {
                f39577d = 30720;
            }
        }
    }

    public static synchronized void a(Context context) {
        synchronized (ao.class) {
            if (f39586m || context == null || !f39575b) {
                return;
            }
            try {
                f39588o = Executors.newSingleThreadExecutor();
                f39579f = new StringBuilder(0);
                f39578e = new StringBuilder(0);
                f39584k = context;
                f39582i = aa.a(context).f39474d;
                f39583j = "";
                f39585l = f39584k.getFilesDir().getPath() + "/buglylog_" + f39582i + "_" + f39583j + ".txt";
                f39589p = Process.myPid();
            } catch (Throwable unused) {
            }
            f39586m = true;
        }
    }

    public static synchronized void a(final String str, final String str2, final String str3) {
        synchronized (ao.class) {
            if (f39586m && f39575b) {
                try {
                    if (f39587n) {
                        f39588o.execute(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.ao.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                ao.d(String.this, str2, str3);
                            }
                        });
                    } else {
                        f39588o.execute(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.ao.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                ao.e(String.this, str2, str3);
                            }
                        });
                    }
                } catch (Exception e2) {
                    al.b(e2);
                }
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
        a(str, str2, message + '\n' + ap.b(th));
    }

    public static byte[] a() {
        if (!f39574a) {
            return c();
        }
        if (f39575b) {
            return ap.a(f39579f.toString(), "BuglyLog.txt");
        }
        return null;
    }

    private static String b() {
        q qVar;
        try {
            aa b4 = aa.b();
            if (b4 == null || (qVar = b4.N) == null) {
                return null;
            }
            return qVar.getLogFromNative();
        } catch (Throwable th) {
            if (al.a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] c() {
        String sb2;
        String str;
        File file;
        if (!f39575b) {
            return null;
        }
        if (f39587n) {
            al.a("[LogUtil] Get user log from native.", new Object[0]);
            sb2 = b();
            if (sb2 != null) {
                al.a("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(sb2.length()));
                str = "BuglyNativeLog.txt";
                return ap.a(sb2, str);
            }
        }
        StringBuilder sb3 = new StringBuilder();
        synchronized (f39590q) {
            a aVar = f39581h;
            if (aVar != null && aVar.f39597a && (file = aVar.f39598b) != null && file.length() > 0) {
                sb3.append(ap.a(f39581h.f39598b, 30720, true));
            }
            StringBuilder sb4 = f39579f;
            if (sb4 != null && sb4.length() > 0) {
                sb3.append(f39579f.toString());
            }
        }
        sb2 = sb3.toString();
        str = "BuglyLog.txt";
        return ap.a(sb2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(String str, String str2, String str3) {
        q qVar;
        try {
            aa b4 = aa.b();
            if (b4 == null || (qVar = b4.N) == null) {
                return false;
            }
            return qVar.appendLogToNative(str, str2, str3);
        } catch (Throwable th) {
            if (al.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void e(String str, String str2, String str3) {
        synchronized (ao.class) {
            if (f39574a) {
                f(str, str2, str3);
            } else {
                g(str, str2, str3);
            }
        }
    }

    private static synchronized void f(String str, String str2, String str3) {
        synchronized (ao.class) {
            String a10 = a(str, str2, str3, Process.myTid());
            synchronized (f39590q) {
                try {
                    f39579f.append(a10);
                    if (f39579f.length() >= f39577d) {
                        StringBuilder sb2 = f39579f;
                        f39579f = sb2.delete(0, sb2.indexOf("\u0001\r\n") + 1);
                    }
                } finally {
                }
            }
        }
    }

    private static synchronized void g(String str, String str2, String str3) {
        synchronized (ao.class) {
            String a10 = a(str, str2, str3, Process.myTid());
            synchronized (f39590q) {
                try {
                    f39579f.append(a10);
                } catch (Throwable unused) {
                }
                if (f39579f.length() <= f39577d) {
                    return;
                }
                if (f39580g) {
                    return;
                }
                f39580g = true;
                a aVar = f39581h;
                if (aVar == null) {
                    f39581h = new a(f39585l);
                } else {
                    File file = aVar.f39598b;
                    if (file == null || file.length() + f39579f.length() > f39581h.f39599c) {
                        f39581h.a();
                    }
                }
                if (f39581h.a(f39579f.toString())) {
                    f39579f.setLength(0);
                    f39580g = false;
                }
            }
        }
    }
}
