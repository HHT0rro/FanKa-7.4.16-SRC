package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.os.Build;
import com.huawei.openalliance.ad.ipc.c;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NativeCrashHandler implements com.tencent.bugly.crashreport.a {

    /* renamed from: a, reason: collision with root package name */
    private static NativeCrashHandler f39311a = null;

    /* renamed from: b, reason: collision with root package name */
    private static int f39312b = 1;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f39313m = false;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f39314n = false;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f39315p = true;

    /* renamed from: c, reason: collision with root package name */
    private final Context f39316c;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f39317d;

    /* renamed from: e, reason: collision with root package name */
    private final w f39318e;

    /* renamed from: f, reason: collision with root package name */
    private NativeExceptionHandler f39319f;

    /* renamed from: g, reason: collision with root package name */
    private String f39320g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f39321h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f39322i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f39323j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f39324k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f39325l = false;

    /* renamed from: o, reason: collision with root package name */
    private com.tencent.bugly.crashreport.crash.b f39326o;

    private NativeCrashHandler(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, w wVar, boolean z10, String str) {
        this.f39316c = z.a(context);
        try {
            if (z.a(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = "/data/data/" + com.tencent.bugly.crashreport.common.info.a.a(context).f39095c + "/app_bugly";
        }
        this.f39326o = bVar;
        this.f39320g = str;
        this.f39317d = aVar;
        this.f39318e = wVar;
        this.f39321h = z10;
        this.f39319f = new a(context, aVar, bVar, com.tencent.bugly.crashreport.common.strategy.a.a());
    }

    public static synchronized NativeCrashHandler getInstance(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2, w wVar, boolean z10, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (f39311a == null) {
                f39311a = new NativeCrashHandler(context, aVar, bVar, wVar, z10, str);
            }
            nativeCrashHandler = f39311a;
        }
        return nativeCrashHandler;
    }

    public static boolean isShouldHandleInJava() {
        return f39315p;
    }

    public static void setShouldHandleInJava(boolean z10) {
        f39315p = z10;
        NativeCrashHandler nativeCrashHandler = f39311a;
        if (nativeCrashHandler != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(z10);
            nativeCrashHandler.a(999, sb2.toString());
        }
    }

    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.f39322i || this.f39323j) && f39313m && str != null && str2 != null && str3 != null) {
            try {
                if (this.f39323j) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                f39313m = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public native boolean appendNativeLog(String str, String str2, String str3);

    public native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.f39318e.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!z.a(NativeCrashHandler.this.f39316c, "native_record_lock", 10000L)) {
                    x.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                    return;
                }
                if (!NativeCrashHandler.f39315p) {
                    NativeCrashHandler.this.a(999, "false");
                }
                CrashDetailBean a10 = b.a(NativeCrashHandler.this.f39316c, NativeCrashHandler.this.f39320g, NativeCrashHandler.this.f39319f);
                if (a10 != null) {
                    x.a("[Native] Get crash from native record.", new Object[0]);
                    if (!NativeCrashHandler.this.f39326o.a(a10)) {
                        NativeCrashHandler.this.f39326o.a(a10, c.Code, false);
                    }
                    b.a(false, NativeCrashHandler.this.f39320g);
                }
                NativeCrashHandler.this.a();
                z.b(NativeCrashHandler.this.f39316c, "native_record_lock");
            }
        });
    }

    public void dumpAnrNativeStack() {
        a(19, "1");
    }

    public void enableCatchAnrTrace() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 > 30 || i10 < 23) {
            return;
        }
        f39312b |= 2;
    }

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    public synchronized String getDumpFilePath() {
        return this.f39320g;
    }

    public String getLogFromNative() {
        if ((!this.f39322i && !this.f39323j) || !f39313m) {
            return null;
        }
        try {
            if (this.f39323j) {
                return getNativeLog();
            }
            return (String) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
        } catch (UnsatisfiedLinkError unused) {
            f39313m = false;
            return null;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f39319f;
    }

    public native String getNativeKeyValueList();

    public native String getNativeLog();

    public boolean isEnableCatchAnrTrace() {
        return (f39312b & 2) == 2;
    }

    public synchronized boolean isUserOpened() {
        return this.f39325l;
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z10 = strategyBean.f39126e;
            if (z10 != this.f39324k) {
                x.d("server native changed to %b", Boolean.valueOf(z10));
            }
        }
        boolean z11 = com.tencent.bugly.crashreport.common.strategy.a.a().c().f39126e && this.f39325l;
        if (z11 != this.f39324k) {
            x.a("native changed to %b", Boolean.valueOf(z11));
            b(z11);
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f39322i || this.f39323j) && f39313m && str != null && str2 != null) {
            try {
                if (this.f39323j) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                f39313m = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public native boolean putNativeKeyValue(String str, String str2);

    public native String regist(String str, boolean z10, int i10);

    public void removeEmptyNativeRecordFiles() {
        b.c(this.f39320g);
    }

    public native String removeNativeKeyValue(String str);

    public synchronized void setDumpFilePath(String str) {
        this.f39320g = str;
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    public native void setNativeInfo(int i10, String str);

    @Override // com.tencent.bugly.crashreport.a
    public boolean setNativeIsAppForeground(boolean z10) {
        return a(14, z10 ? "true" : "false");
    }

    public boolean setNativeLaunchTime(long j10) {
        try {
            return a(15, String.valueOf(j10));
        } catch (NumberFormatException e2) {
            if (x.a(e2)) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    public synchronized void setUserOpened(boolean z10) {
        c(z10);
        boolean isUserOpened = isUserOpened();
        com.tencent.bugly.crashreport.common.strategy.a a10 = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a10 != null) {
            isUserOpened = isUserOpened && a10.c().f39126e;
        }
        if (isUserOpened != this.f39324k) {
            x.a("native changed to %b", Boolean.valueOf(isUserOpened));
            b(isUserOpened);
        }
    }

    public synchronized void startNativeMonitor() {
        if (!this.f39323j && !this.f39322i) {
            String str = "Bugly";
            boolean z10 = !z.a(this.f39317d.f39105m);
            com.tencent.bugly.crashreport.common.info.a aVar = this.f39317d;
            String str2 = aVar.f39105m;
            if (z10) {
                str = str2;
            } else {
                aVar.getClass();
            }
            boolean a10 = a(str, z10);
            this.f39323j = a10;
            if (a10 || this.f39322i) {
                a(this.f39321h);
                if (f39313m) {
                    setNativeAppVersion(this.f39317d.f39102j);
                    setNativeAppChannel(this.f39317d.f39104l);
                    setNativeAppPackage(this.f39317d.f39095c);
                    setNativeUserId(this.f39317d.g());
                    setNativeIsAppForeground(this.f39317d.a());
                    setNativeLaunchTime(this.f39317d.f39088a);
                }
                return;
            }
            return;
        }
        a(this.f39321h);
    }

    public native void testCrash();

    public void testNativeCrash() {
        if (!this.f39323j) {
            x.d("[Native] Bugly SO file has not been load.", new Object[0]);
        } else {
            testCrash();
        }
    }

    public native String unregist();

    private synchronized void c() {
        if (!this.f39324k) {
            x.d("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                x.a("[Native] Successfully closed native crash report.", new Object[0]);
                this.f39324k = false;
                return;
            }
        } catch (Throwable unused) {
            x.c("[Native] Failed to close native crash report.", new Object[0]);
        }
        try {
            z.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
            this.f39324k = false;
            x.a("[Native] Successfully closed native crash report.", new Object[0]);
        } catch (Throwable unused2) {
            x.c("[Native] Failed to close native crash report.", new Object[0]);
            this.f39323j = false;
            this.f39322i = false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:41|(1:43)(16:69|(1:71)|45|46|(1:48)|49|(1:51)|53|(1:55)(1:67)|56|(1:58)(1:66)|59|(1:61)|62|63|64)|44|45|46|(0)|49|(0)|53|(0)(0)|56|(0)(0)|59|(0)|62|63|64) */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080 A[Catch: all -> 0x008e, TryCatch #2 {all -> 0x008e, blocks: (B:46:0x0076, B:48:0x0080, B:49:0x0082, B:51:0x008c), top: B:45:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008c A[Catch: all -> 0x008e, TRY_LEAVE, TryCatch #2 {all -> 0x008e, blocks: (B:46:0x0076, B:48:0x0080, B:49:0x0082, B:51:0x008c), top: B:45:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0092 A[Catch: all -> 0x00ed, TryCatch #1 {all -> 0x00ed, blocks: (B:39:0x0017, B:41:0x0021, B:43:0x0053, B:44:0x005d, B:53:0x008e, B:55:0x0092, B:56:0x00a1, B:58:0x00a5, B:59:0x00b4, B:61:0x00c8, B:62:0x00dc, B:66:0x00ad, B:67:0x009a, B:69:0x0065, B:71:0x006b), top: B:38:0x0017, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5 A[Catch: all -> 0x00ed, TryCatch #1 {all -> 0x00ed, blocks: (B:39:0x0017, B:41:0x0021, B:43:0x0053, B:44:0x005d, B:53:0x008e, B:55:0x0092, B:56:0x00a1, B:58:0x00a5, B:59:0x00b4, B:61:0x00c8, B:62:0x00dc, B:66:0x00ad, B:67:0x009a, B:69:0x0065, B:71:0x006b), top: B:38:0x0017, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c8 A[Catch: all -> 0x00ed, TryCatch #1 {all -> 0x00ed, blocks: (B:39:0x0017, B:41:0x0021, B:43:0x0053, B:44:0x005d, B:53:0x008e, B:55:0x0092, B:56:0x00a1, B:58:0x00a5, B:59:0x00b4, B:61:0x00c8, B:62:0x00dc, B:66:0x00ad, B:67:0x009a, B:69:0x0065, B:71:0x006b), top: B:38:0x0017, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ad A[Catch: all -> 0x00ed, TryCatch #1 {all -> 0x00ed, blocks: (B:39:0x0017, B:41:0x0021, B:43:0x0053, B:44:0x005d, B:53:0x008e, B:55:0x0092, B:56:0x00a1, B:58:0x00a5, B:59:0x00b4, B:61:0x00c8, B:62:0x00dc, B:66:0x00ad, B:67:0x009a, B:69:0x0065, B:71:0x006b), top: B:38:0x0017, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x009a A[Catch: all -> 0x00ed, TryCatch #1 {all -> 0x00ed, blocks: (B:39:0x0017, B:41:0x0021, B:43:0x0053, B:44:0x005d, B:53:0x008e, B:55:0x0092, B:56:0x00a1, B:58:0x00a5, B:59:0x00b4, B:61:0x00c8, B:62:0x00dc, B:66:0x00ad, B:67:0x009a, B:69:0x0065, B:71:0x006b), top: B:38:0x0017, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void a(boolean r13) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.a(boolean):void");
    }

    private synchronized void b(boolean z10) {
        if (z10) {
            startNativeMonitor();
        } else {
            c();
        }
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = f39311a;
        }
        return nativeCrashHandler;
    }

    public void testNativeCrash(boolean z10, boolean z11, boolean z12) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z10);
        a(16, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(z11);
        a(17, sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(z12);
        a(18, sb4.toString());
        testNativeCrash();
    }

    private synchronized void c(boolean z10) {
        if (this.f39325l != z10) {
            x.a("user change native %b", Boolean.valueOf(z10));
            this.f39325l = z10;
        }
    }

    private static boolean a(String str, boolean z10) {
        boolean z11;
        try {
            x.a("[Native] Trying to load so: %s", str);
            if (z10) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                x.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z11 = true;
                x.d(th.getMessage(), new Object[0]);
                x.d("[Native] Failed to load so: %s", str);
                return z11;
            }
        } catch (Throwable th2) {
            th = th2;
            z11 = false;
        }
    }

    public final void a() {
        long b4 = z.b() - com.tencent.bugly.crashreport.crash.c.f39243g;
        long b10 = z.b() + 86400000;
        File file = new File(this.f39320g);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i10 = 0;
                    int i11 = 0;
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (lastModified < b4 || lastModified >= b10) {
                            x.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i10++;
                            if (file2.delete()) {
                                i11++;
                            }
                        }
                    }
                    x.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i10), Integer.valueOf(i11));
                }
            } catch (Throwable th) {
                x.a(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i10, String str) {
        if (this.f39323j && f39314n) {
            try {
                setNativeInfo(i10, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                f39314n = false;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }
}
