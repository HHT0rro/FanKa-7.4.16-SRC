package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.alimm.tanx.core.web.cache.utils.TimeUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: OSSLogToFileUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ce {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3300a = "OSSLog";

    /* renamed from: c, reason: collision with root package name */
    private static Context f3302c;

    /* renamed from: d, reason: collision with root package name */
    private static ce f3303d;

    /* renamed from: e, reason: collision with root package name */
    private static File f3304e;

    /* renamed from: h, reason: collision with root package name */
    private boolean f3307h = true;

    /* renamed from: b, reason: collision with root package name */
    private static ca f3301b = ca.a();

    /* renamed from: f, reason: collision with root package name */
    private static SimpleDateFormat f3305f = new SimpleDateFormat(TimeUtils.STARD_FROMAT);

    /* renamed from: g, reason: collision with root package name */
    private static long f3306g = 5242880;

    /* compiled from: OSSLogToFileUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Object f3308a;

        public a(Object obj) {
            this.f3308a = obj;
        }

        private PrintWriter a(PrintWriter printWriter) {
            printWriter.println("crash_time：" + ce.f3305f.format(new Date()));
            ((Throwable) this.f3308a).printStackTrace(printWriter);
            return printWriter;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ce.f3304e != null) {
                ce.a();
                if (ce.a(ce.f3304e) > ce.f3306g) {
                    ce.a();
                    ce.b();
                }
                try {
                    PrintWriter printWriter = new PrintWriter((Writer) new FileWriter(ce.f3304e, true), true);
                    if (this.f3308a instanceof Throwable) {
                        printWriter.println("crash_time：" + ce.f3305f.format(new Date()));
                        ((Throwable) this.f3308a).printStackTrace(printWriter);
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        ce.a();
                        sb2.append(ce.g());
                        sb2.append(" - ");
                        sb2.append(this.f3308a.toString());
                        printWriter.println(sb2.toString());
                    }
                    printWriter.println("------>end of log");
                    printWriter.println();
                    printWriter.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private ce() {
    }

    public static void a(Context context, bt btVar) {
        File file;
        cd.c("init ...");
        if (btVar != null) {
            f3306g = btVar.f3208d;
        }
        if (f3302c != null && f3303d != null && (file = f3304e) != null && file.exists()) {
            cd.c("LogToFileUtils has been init ...");
            return;
        }
        f3302c = context.getApplicationContext();
        f3303d = a();
        f3301b.a(new Runnable() { // from class: com.alibaba.security.realidentity.build.ce.1
            @Override // java.lang.Runnable
            public final void run() {
                ce unused = ce.f3303d;
                File unused2 = ce.f3304e = ce.d();
                if (ce.f3304e != null) {
                    cd.a("LogFilePath is: " + ce.f3304e.getPath(), false);
                    if (ce.f3306g < ce.a(ce.f3304e)) {
                        cd.a("init reset log file", false);
                        ce unused3 = ce.f3303d;
                        ce.b();
                    }
                }
            }
        });
    }

    public static /* synthetic */ File d() {
        return m();
    }

    public static /* synthetic */ String g() {
        return "[" + f3305f.format(new Date()) + "]";
    }

    private static void i() {
        f3302c = null;
        f3303d = null;
        f3304e = null;
    }

    private static long j() {
        return a(f3304e);
    }

    private static long k() {
        StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
        long availableBlocks = (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024;
        cd.c("内部存储空间:" + String.valueOf(availableBlocks) + "kb");
        return availableBlocks;
    }

    private static void l() {
        if (f3304e == null) {
            return;
        }
        File file = new File(f3304e.getParent() + "/logs.csv");
        if (file.exists()) {
            cd.c("delete Log File ... ");
            file.delete();
        }
    }

    private static File m() {
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getPath());
            long availableBlocks = (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024;
            cd.c("内部存储空间:" + String.valueOf(availableBlocks) + "kb");
            boolean z10 = availableBlocks > f3306g / 1024;
            File file = new File(f3302c.getFilesDir().getPath() + File.separator + f3300a);
            if (!z10) {
                return null;
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file.getPath() + "/logs.csv");
            if (!file2.exists()) {
                c(file2);
            }
            return file2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void b() {
        cd.c("Reset Log File ... ");
        File file = f3304e;
        if (file == null) {
            return;
        }
        if (!file.getParentFile().exists()) {
            cd.c("Reset Log make File dir ... ");
            f3304e.getParentFile().mkdir();
        }
        File file2 = new File(f3304e.getParent() + "/logs.csv");
        if (file2.exists()) {
            file2.delete();
        }
        c(file2);
    }

    private static void c(File file) {
        try {
            file.createNewFile();
        } catch (Exception e2) {
            cd.e("Create log file failure !!! " + e2.toString());
        }
    }

    public static ce a() {
        if (f3303d == null) {
            synchronized (ce.class) {
                if (f3303d == null) {
                    f3303d = new ce();
                }
            }
        }
        return f3303d;
    }

    public static long a(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return file.length();
    }

    private void a(boolean z10) {
        this.f3307h = z10;
    }

    private static String a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr != null) {
            return null;
        }
        return "[" + f3305f.format(new Date()) + "]";
    }

    public final synchronized void a(Object obj) {
        File file;
        if (cd.a()) {
            if (f3302c != null && f3303d != null && (file = f3304e) != null) {
                if (!file.exists()) {
                    b();
                }
                f3301b.a(new a(obj));
            }
        }
    }
}
