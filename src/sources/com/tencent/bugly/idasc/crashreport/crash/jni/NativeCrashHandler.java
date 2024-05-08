package com.tencent.bugly.idasc.crashreport.crash.jni;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.bg;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.idasc.proguard.aa;
import com.tencent.bugly.idasc.proguard.ab;
import com.tencent.bugly.idasc.proguard.ac;
import com.tencent.bugly.idasc.proguard.ak;
import com.tencent.bugly.idasc.proguard.al;
import com.tencent.bugly.idasc.proguard.ap;
import com.tencent.bugly.idasc.proguard.as;
import com.tencent.bugly.idasc.proguard.at;
import com.tencent.bugly.idasc.proguard.bd;
import com.tencent.bugly.idasc.proguard.be;
import com.tencent.bugly.idasc.proguard.q;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NativeCrashHandler implements q {

    /* renamed from: a, reason: collision with root package name */
    public static String f39449a = null;

    /* renamed from: b, reason: collision with root package name */
    private static NativeCrashHandler f39450b = null;

    /* renamed from: c, reason: collision with root package name */
    private static int f39451c = 1;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f39452n = true;

    /* renamed from: d, reason: collision with root package name */
    private final Context f39453d;

    /* renamed from: e, reason: collision with root package name */
    private final aa f39454e;

    /* renamed from: f, reason: collision with root package name */
    private final ak f39455f;

    /* renamed from: g, reason: collision with root package name */
    private NativeExceptionHandler f39456g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f39457h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f39458i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f39459j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f39460k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f39461l = false;

    /* renamed from: m, reason: collision with root package name */
    private as f39462m;

    private NativeCrashHandler(Context context, aa aaVar, as asVar, ak akVar, boolean z10, String str) {
        this.f39453d = ap.a(context);
        if (ap.b(f39449a)) {
            try {
                if (ap.b(str)) {
                    str = context.getDir("bugly", 0).getAbsolutePath();
                }
            } catch (Throwable unused) {
                str = "/data/data/" + aa.a(context).f39473c + "/app_bugly";
            }
            f39449a = str;
        }
        this.f39462m = asVar;
        this.f39454e = aaVar;
        this.f39455f = akVar;
        this.f39457h = z10;
        this.f39456g = new bd(context, aaVar, asVar, ac.a());
    }

    private synchronized void a(boolean z10) {
        if (this.f39460k) {
            al.d("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.f39459j) {
            try {
                String regist = regist(f39449a, z10, f39451c);
                if (regist != null) {
                    al.a("[Native] Native Crash Report enable.", new Object[0]);
                    this.f39454e.f39491u = regist;
                    String concat = "-".concat(regist);
                    if (!at.f39634b && !this.f39454e.f39478h.contains(concat)) {
                        aa aaVar = this.f39454e;
                        aaVar.f39478h = aaVar.f39478h.concat("-").concat(this.f39454e.f39491u);
                    }
                    al.a("comInfo.sdkVersion %s", this.f39454e.f39478h);
                    this.f39460k = true;
                    String runningCpuAbi = getRunningCpuAbi();
                    if (!TextUtils.isEmpty(runningCpuAbi)) {
                        this.f39454e.e(runningCpuAbi);
                    }
                    return;
                }
            } catch (Throwable unused) {
                al.c("[Native] Failed to load Bugly SO file.", new Object[0]);
            }
        } else if (this.f39458i) {
            try {
                Class<Integer> cls = Integer.TYPE;
                Class[] clsArr = {String.class, String.class, cls, cls};
                Object[] objArr = new Object[4];
                objArr[0] = f39449a;
                objArr[1] = ab.d();
                objArr[2] = Integer.valueOf(z10 ? 1 : 5);
                objArr[3] = 1;
                String str = (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler2", clsArr, objArr);
                if (str == null) {
                    aa.b();
                    str = (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "registNativeExceptionHandler", new Class[]{String.class, String.class, cls}, new Object[]{f39449a, ab.d(), Integer.valueOf(aa.B())});
                }
                if (str != null) {
                    this.f39460k = true;
                    this.f39454e.f39491u = str;
                    ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.TRUE});
                    ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "setLogMode", new Class[]{cls}, new Object[]{Integer.valueOf(z10 ? 1 : 5)});
                    String runningCpuAbi2 = getRunningCpuAbi();
                    if (!TextUtils.isEmpty(runningCpuAbi2)) {
                        this.f39454e.e(runningCpuAbi2);
                    }
                    return;
                }
            } catch (Throwable unused2) {
            }
        }
        this.f39459j = false;
        this.f39458i = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i10, String str) {
        if (!this.f39459j) {
            return false;
        }
        try {
            setNativeInfo(i10, str);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            return false;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    private static boolean a(String str, boolean z10) {
        boolean z11;
        try {
            al.a("[Native] Trying to load so: %s", str);
            if (z10) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                al.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z11 = true;
                al.d(th.getMessage(), new Object[0]);
                al.d("[Native] Failed to load so: %s", str);
                return z11;
            }
        } catch (Throwable th2) {
            th = th2;
            z11 = false;
        }
    }

    private synchronized void b(boolean z10) {
        if (z10) {
            startNativeMonitor();
        } else {
            c();
        }
    }

    private synchronized void c() {
        if (!this.f39460k) {
            al.d("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                al.a("[Native] Successfully closed native crash report.", new Object[0]);
                this.f39460k = false;
                return;
            }
        } catch (Throwable unused) {
            al.c("[Native] Failed to close native crash report.", new Object[0]);
        }
        try {
            ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
            this.f39460k = false;
            al.a("[Native] Successfully closed native crash report.", new Object[0]);
        } catch (Throwable unused2) {
            al.c("[Native] Failed to close native crash report.", new Object[0]);
            this.f39459j = false;
            this.f39458i = false;
        }
    }

    private synchronized void c(boolean z10) {
        if (this.f39461l != z10) {
            al.a("user change native %b", Boolean.valueOf(z10));
            this.f39461l = z10;
        }
    }

    public static synchronized String getDumpFilePath() {
        String str;
        synchronized (NativeCrashHandler.class) {
            str = f39449a;
        }
        return str;
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = f39450b;
        }
        return nativeCrashHandler;
    }

    public static synchronized NativeCrashHandler getInstance(Context context, aa aaVar, as asVar, ac acVar, ak akVar, boolean z10, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (f39450b == null) {
                f39450b = new NativeCrashHandler(context, aaVar, asVar, akVar, z10, str);
            }
            nativeCrashHandler = f39450b;
        }
        return nativeCrashHandler;
    }

    private native String getProperties(String str);

    private native String getSoCpuAbi();

    public static boolean isShouldHandleInJava() {
        return f39452n;
    }

    public static synchronized void setDumpFilePath(String str) {
        synchronized (NativeCrashHandler.class) {
            f39449a = str;
        }
    }

    public static void setShouldHandleInJava(boolean z10) {
        f39452n = z10;
        NativeCrashHandler nativeCrashHandler = f39450b;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.a(999, String.valueOf(z10));
        }
    }

    @Override // com.tencent.bugly.idasc.proguard.q
    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.f39458i || this.f39459j) && str != null && str2 != null && str3 != null) {
            try {
                if (this.f39459j) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public native boolean appendNativeLog(String str, String str2, String str3);

    public native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.f39455f.a(new Runnable() { // from class: com.tencent.bugly.idasc.crashreport.crash.jni.NativeCrashHandler.1
            @Override // java.lang.Runnable
            public final void run() {
                int i10;
                if (!ap.a(NativeCrashHandler.this.f39453d, "native_record_lock")) {
                    al.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                    return;
                }
                if (!NativeCrashHandler.f39452n) {
                    NativeCrashHandler.this.a(999, "false");
                }
                CrashDetailBean a10 = be.a(NativeCrashHandler.this.f39453d, NativeCrashHandler.f39449a, NativeCrashHandler.this.f39456g);
                if (a10 != null) {
                    al.a("[Native] Get crash from native record.", new Object[0]);
                    if (!NativeCrashHandler.this.f39462m.a(a10, true)) {
                        NativeCrashHandler.this.f39462m.b(a10, false);
                    }
                    be.a(false, NativeCrashHandler.f39449a);
                }
                final NativeCrashHandler nativeCrashHandler = NativeCrashHandler.this;
                long b4 = ap.b() - at.f39641j;
                long b10 = ap.b() + 86400000;
                File file = new File(NativeCrashHandler.f39449a);
                if (file.exists() && file.isDirectory()) {
                    try {
                        File[] listFiles = file.listFiles();
                        if (listFiles != null && listFiles.length != 0) {
                            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.tencent.bugly.idasc.crashreport.crash.jni.NativeCrashHandler.2
                                @Override // java.util.Comparator
                                public final /* synthetic */ int compare(File file2, File file3) {
                                    return Long.compare(file3.lastModified(), file2.lastModified());
                                }
                            });
                            long j10 = 0;
                            int length = listFiles.length;
                            int i11 = 0;
                            int i12 = 0;
                            int i13 = 0;
                            while (i11 < length) {
                                File file2 = listFiles[i11];
                                long lastModified = file2.lastModified();
                                j10 += file2.length();
                                if (lastModified >= b4 && lastModified < b10 && j10 < at.f39640i) {
                                    i10 = length;
                                    i11++;
                                    length = i10;
                                }
                                i10 = length;
                                al.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                                i12++;
                                if (file2.delete()) {
                                    i13++;
                                }
                                i11++;
                                length = i10;
                            }
                            al.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i12), Integer.valueOf(i13));
                        }
                    } catch (Throwable th) {
                        al.a(th);
                    }
                }
                ap.b(NativeCrashHandler.this.f39453d, "native_record_lock");
            }
        });
    }

    public void disableCatchAnrTrace() {
        f39451c = 1;
    }

    public void dumpAnrNativeStack() {
        a(19, "1");
    }

    public void enableCatchAnrTrace() {
        f39451c |= 2;
    }

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    @Override // com.tencent.bugly.idasc.proguard.q
    public String getLogFromNative() {
        if (!this.f39458i && !this.f39459j) {
            return null;
        }
        try {
            return this.f39459j ? getNativeLog() : (String) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null);
        } catch (UnsatisfiedLinkError unused) {
            return null;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f39456g;
    }

    public native String getNativeKeyValueList();

    public native String getNativeLog();

    public String getRunningCpuAbi() {
        try {
            return getSoCpuAbi();
        } catch (Throwable unused) {
            al.d("get so cpu abi failed，please upgrade bugly so version", new Object[0]);
            return "";
        }
    }

    public String getSystemProperty(String str) {
        return (this.f39459j || this.f39458i) ? getProperties(str) : bg.b.S;
    }

    public boolean isEnableCatchAnrTrace() {
        return (f39451c & 2) == 2;
    }

    public synchronized boolean isUserOpened() {
        return this.f39461l;
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z10 = strategyBean.f39390f;
            if (z10 != this.f39460k) {
                al.d("server native changed to %b", Boolean.valueOf(z10));
            }
        }
        boolean z11 = ac.a().c().f39390f && this.f39461l;
        if (z11 != this.f39460k) {
            al.a("native changed to %b", Boolean.valueOf(z11));
            b(z11);
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f39458i || this.f39459j) && str != null && str2 != null) {
            try {
                if (this.f39459j) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) ap.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }

    public native boolean putNativeKeyValue(String str, String str2);

    public native String regist(String str, boolean z10, int i10);

    public void removeEmptyNativeRecordFiles() {
        be.c(f39449a);
    }

    public native String removeNativeKeyValue(String str);

    public void resendSigquit() {
        a(20, "");
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

    @Override // com.tencent.bugly.idasc.proguard.q
    public boolean setNativeIsAppForeground(boolean z10) {
        return a(14, z10 ? "true" : "false");
    }

    public boolean setNativeLaunchTime(long j10) {
        try {
            return a(15, String.valueOf(j10));
        } catch (NumberFormatException e2) {
            if (al.a(e2)) {
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
        ac a10 = ac.a();
        if (a10 != null) {
            isUserOpened = isUserOpened && a10.c().f39390f;
        }
        if (isUserOpened != this.f39460k) {
            al.a("native changed to %b", Boolean.valueOf(isUserOpened));
            b(isUserOpened);
        }
    }

    public synchronized void startNativeMonitor() {
        if (!this.f39459j && !this.f39458i) {
            boolean z10 = !ap.b(this.f39454e.f39490t);
            if (at.f39634b) {
                boolean a10 = a(z10 ? this.f39454e.f39490t : "Bugly_Native_idasc", z10);
                this.f39459j = a10;
                if (!a10 && !z10) {
                    this.f39458i = a("NativeRQD", false);
                }
            } else {
                String str = "Bugly_Native_idasc";
                aa aaVar = this.f39454e;
                String str2 = aaVar.f39490t;
                if (z10) {
                    str = str2;
                } else {
                    aaVar.getClass();
                }
                this.f39459j = a(str, z10);
            }
            if (this.f39459j || this.f39458i) {
                a(this.f39457h);
                setNativeAppVersion(this.f39454e.f39485o);
                setNativeAppChannel(this.f39454e.f39489s);
                setNativeAppPackage(this.f39454e.f39473c);
                setNativeUserId(this.f39454e.f());
                setNativeIsAppForeground(this.f39454e.a());
                setNativeLaunchTime(this.f39454e.f39465a);
                return;
            }
            return;
        }
        a(this.f39457h);
    }

    public native void testCrash();

    public void testNativeCrash() {
        if (this.f39459j) {
            testCrash();
        } else {
            al.d("[Native] Bugly SO file has not been load.", new Object[0]);
        }
    }

    public void testNativeCrash(boolean z10, boolean z11, boolean z12) {
        a(16, String.valueOf(z10));
        a(17, String.valueOf(z11));
        a(18, String.valueOf(z12));
        testNativeCrash();
    }

    public void unBlockSigquit(boolean z10) {
        a(21, z10 ? "true" : "false");
    }

    public native String unregist();
}
