package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.u;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements ac {

    /* renamed from: m, reason: collision with root package name */
    private static b f39208m;

    /* renamed from: c, reason: collision with root package name */
    private final Context f39211c;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f39212d;

    /* renamed from: e, reason: collision with root package name */
    private final w f39213e;

    /* renamed from: f, reason: collision with root package name */
    private String f39214f;

    /* renamed from: g, reason: collision with root package name */
    private final com.tencent.bugly.crashreport.crash.b f39215g;

    /* renamed from: h, reason: collision with root package name */
    private FileObserver f39216h;

    /* renamed from: j, reason: collision with root package name */
    private ab f39218j;

    /* renamed from: k, reason: collision with root package name */
    private int f39219k;

    /* renamed from: a, reason: collision with root package name */
    private AtomicInteger f39209a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    private long f39210b = -1;

    /* renamed from: i, reason: collision with root package name */
    private boolean f39217i = true;

    /* renamed from: l, reason: collision with root package name */
    private ActivityManager.ProcessErrorStateInfo f39220l = new ActivityManager.ProcessErrorStateInfo();

    private b(Context context, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.crashreport.common.info.a aVar2, w wVar, com.tencent.bugly.crashreport.crash.b bVar) {
        this.f39211c = z.a(context);
        this.f39214f = context.getDir("bugly", 0).getAbsolutePath();
        this.f39212d = aVar2;
        this.f39213e = wVar;
        this.f39215g = bVar;
    }

    private synchronized void c(boolean z10) {
        if (this.f39217i != z10) {
            x.a("user change anr %b", Boolean.valueOf(z10));
            this.f39217i = z10;
        }
    }

    private synchronized void d() {
        if (f()) {
            x.d("start when started!", new Object[0]);
            return;
        }
        FileObserver fileObserver = new FileObserver("/data/anr/", 8) { // from class: com.tencent.bugly.crashreport.crash.anr.b.1
            @Override // android.os.FileObserver
            public final void onEvent(int i10, String str) {
                if (str == null) {
                    return;
                }
                final String str2 = "/data/anr/" + str;
                x.d("watching file %s", str2);
                if (str2.contains("trace")) {
                    b.this.f39213e.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.anr.b.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.a(str2);
                        }
                    });
                } else {
                    x.d("not anr file %s", str2);
                }
            }
        };
        this.f39216h = fileObserver;
        try {
            fileObserver.startWatching();
            x.a("start anr monitor!", new Object[0]);
            this.f39213e.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.anr.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.b();
                }
            });
        } catch (Throwable th) {
            this.f39216h = null;
            x.d("start anr monitor failed!", new Object[0]);
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized void e() {
        if (!f()) {
            x.d("close when closed!", new Object[0]);
            return;
        }
        try {
            this.f39216h.stopWatching();
            this.f39216h = null;
            x.d("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            x.d("stop anr monitor failed!", new Object[0]);
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized boolean f() {
        return this.f39216h != null;
    }

    private synchronized boolean g() {
        return this.f39217i;
    }

    private File h() {
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(this.f39214f);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i10 = 24;
                    int length = listFiles.length;
                    int i11 = 0;
                    while (i11 < length) {
                        File file2 = listFiles[i11];
                        String name = file2.getName();
                        if (name.startsWith("jni_mannual_bugly_trace_")) {
                            try {
                                int indexOf = name.indexOf(".txt");
                                if (indexOf > 0) {
                                    long parseLong = Long.parseLong(name.substring(i10, indexOf));
                                    long j10 = (currentTimeMillis - parseLong) / 1000;
                                    x.c("current time %d trace time is %d s", Long.valueOf(currentTimeMillis), Long.valueOf(parseLong));
                                    x.c("current time minus trace time is %d s", Long.valueOf(j10));
                                    if (j10 < 30) {
                                        return file2;
                                    }
                                } else {
                                    continue;
                                }
                            } catch (Throwable unused) {
                                x.c("Trace file that has invalid format: " + name, new Object[0]);
                            }
                        }
                        i11++;
                        i10 = 24;
                    }
                }
                return null;
            } catch (Throwable th) {
                x.a(th);
                return null;
            }
        }
        return null;
    }

    private synchronized void i() {
        if (f()) {
            x.d("start when started!", new Object[0]);
            return;
        }
        if (TextUtils.isEmpty(this.f39214f)) {
            return;
        }
        ab abVar = this.f39218j;
        if (abVar == null || !abVar.isAlive()) {
            ab abVar2 = new ab();
            this.f39218j = abVar2;
            StringBuilder sb2 = new StringBuilder("Bugly-ThreadMonitor");
            int i10 = this.f39219k;
            this.f39219k = i10 + 1;
            sb2.append(i10);
            abVar2.setName(sb2.toString());
            this.f39218j.a();
            this.f39218j.a(this);
            this.f39218j.d();
            this.f39213e.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.anr.b.3
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.b();
                }
            });
        }
        FileObserver fileObserver = new FileObserver(this.f39214f, 256) { // from class: com.tencent.bugly.crashreport.crash.anr.b.4
            @Override // android.os.FileObserver
            public final void onEvent(int i11, String str) {
                if (str == null) {
                    return;
                }
                x.d("startWatchingPrivateAnrDir %s", str);
                if (b.a(b.this, str)) {
                    if (b.this.f39218j != null) {
                        b.this.f39218j.a(true);
                        return;
                    }
                    return;
                }
                x.c("trace file not caused by sigquit , ignore ", new Object[0]);
            }
        };
        this.f39216h = fileObserver;
        try {
            fileObserver.startWatching();
            x.a("startWatchingPrivateAnrDir! dumFilePath is %s", this.f39214f);
            this.f39213e.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.anr.b.5
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.b();
                }
            });
        } catch (Throwable th) {
            this.f39216h = null;
            x.d("startWatchingPrivateAnrDir failed!", new Object[0]);
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized void j() {
        if (!f()) {
            x.d("close when closed!", new Object[0]);
            return;
        }
        ab abVar = this.f39218j;
        if (abVar != null) {
            abVar.c();
            this.f39218j.b();
            this.f39218j.b(this);
            this.f39218j = null;
        }
        x.a("stopWatchingPrivateAnrDir", new Object[0]);
        try {
            this.f39216h.stopWatching();
            this.f39216h = null;
            x.d("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            x.d("stop anr monitor failed!", new Object[0]);
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public static /* synthetic */ boolean a(b bVar, String str) {
        return str.startsWith("bugly_trace_");
    }

    private synchronized void b(boolean z10) {
        if (z10) {
            i();
        } else {
            j();
        }
    }

    public static b a(Context context, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.crashreport.common.info.a aVar2, w wVar, p pVar, com.tencent.bugly.crashreport.crash.b bVar, BuglyStrategy.a aVar3) {
        if (f39208m == null) {
            f39208m = new b(context, aVar, aVar2, wVar, bVar);
        }
        return f39208m;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b() {
        /*
            r15 = this;
            java.lang.String r0 = "bugly_trace_"
            long r1 = com.tencent.bugly.proguard.z.b()
            long r3 = com.tencent.bugly.crashreport.crash.c.f39243g
            long r1 = r1 - r3
            java.io.File r3 = new java.io.File
            java.lang.String r4 = r15.f39214f
            r3.<init>(r4)
            boolean r4 = r3.exists()
            if (r4 == 0) goto La8
            boolean r4 = r3.isDirectory()
            if (r4 == 0) goto La8
            java.io.File[] r3 = r3.listFiles()     // Catch: java.lang.Throwable -> La4
            if (r3 == 0) goto La3
            int r4 = r3.length     // Catch: java.lang.Throwable -> La4
            if (r4 != 0) goto L27
            goto La3
        L27:
            java.lang.String r4 = ".txt"
            int r5 = r3.length     // Catch: java.lang.Throwable -> La4
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
        L2e:
            if (r7 >= r5) goto L90
            r10 = r3[r7]     // Catch: java.lang.Throwable -> La4
            java.lang.String r11 = r10.getName()     // Catch: java.lang.Throwable -> La4
            boolean r12 = r11.startsWith(r0)     // Catch: java.lang.Throwable -> La4
            r13 = 12
            r14 = 1
            if (r12 == 0) goto L42
        L3f:
            r9 = 12
            goto L4a
        L42:
            boolean r12 = r11.startsWith(r0)     // Catch: java.lang.Throwable -> La4
            if (r12 == 0) goto L49
            goto L3f
        L49:
            r14 = 0
        L4a:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La4
            java.lang.String r13 = "Number Trace file : "
            r12.<init>(r13)     // Catch: java.lang.Throwable -> La4
            r12.append(r11)     // Catch: java.lang.Throwable -> La4
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> La4
            java.lang.Object[] r13 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> La4
            com.tencent.bugly.proguard.x.c(r12, r13)     // Catch: java.lang.Throwable -> La4
            if (r14 == 0) goto L8d
            int r12 = r11.indexOf(r4)     // Catch: java.lang.Throwable -> L72
            if (r12 <= 0) goto L85
            java.lang.String r12 = r11.substring(r9, r12)     // Catch: java.lang.Throwable -> L72
            long r11 = java.lang.Long.parseLong(r12)     // Catch: java.lang.Throwable -> L72
            int r13 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r13 < 0) goto L85
            goto L8d
        L72:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La4
            java.lang.String r13 = "Trace file that has invalid format: "
            r12.<init>(r13)     // Catch: java.lang.Throwable -> La4
            r12.append(r11)     // Catch: java.lang.Throwable -> La4
            java.lang.String r11 = r12.toString()     // Catch: java.lang.Throwable -> La4
            java.lang.Object[] r12 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> La4
            com.tencent.bugly.proguard.x.c(r11, r12)     // Catch: java.lang.Throwable -> La4
        L85:
            boolean r10 = r10.delete()     // Catch: java.lang.Throwable -> La4
            if (r10 == 0) goto L8d
            int r8 = r8 + 1
        L8d:
            int r7 = r7 + 1
            goto L2e
        L90:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La4
            java.lang.String r1 = "Number of overdue trace files that has deleted: "
            r0.<init>(r1)     // Catch: java.lang.Throwable -> La4
            r0.append(r8)     // Catch: java.lang.Throwable -> La4
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La4
            java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> La4
            com.tencent.bugly.proguard.x.c(r0, r1)     // Catch: java.lang.Throwable -> La4
        La3:
            return
        La4:
            r0 = move-exception
            com.tencent.bugly.proguard.x.a(r0)
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.b.b():void");
    }

    public final synchronized void c() {
        x.d("customer decides whether to open or close.", new Object[0]);
    }

    private ActivityManager.ProcessErrorStateInfo a(Context context, long j10) {
        try {
            x.c("to find!", new Object[0]);
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int i10 = 0;
            while (true) {
                x.c("waiting!", new Object[0]);
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.condition == 2) {
                            x.c("found!", new Object[0]);
                            return processErrorStateInfo;
                        }
                    }
                }
                z.b(500L);
                int i11 = i10 + 1;
                if (i10 >= 40) {
                    x.c("end!", new Object[0]);
                    return null;
                }
                i10 = i11;
            }
        } catch (Exception e2) {
            x.b(e2);
            return null;
        } catch (OutOfMemoryError e10) {
            this.f39220l.pid = Process.myPid();
            this.f39220l.shortMsg = "bugly sdk waitForAnrProcessStateChanged encount error:" + e10.getMessage();
            return this.f39220l;
        }
    }

    private CrashDetailBean a(a aVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.i();
            crashDetailBean.F = this.f39212d.l();
            crashDetailBean.G = this.f39212d.k();
            crashDetailBean.H = this.f39212d.m();
            if (!com.tencent.bugly.crashreport.common.info.b.m()) {
                crashDetailBean.f39182w = z.a(this.f39211c, c.f39241e, (String) null);
            }
            crashDetailBean.f39161b = 3;
            crashDetailBean.f39164e = this.f39212d.h();
            com.tencent.bugly.crashreport.common.info.a aVar2 = this.f39212d;
            crashDetailBean.f39165f = aVar2.f39102j;
            crashDetailBean.f39166g = aVar2.r();
            crashDetailBean.f39172m = this.f39212d.g();
            crashDetailBean.f39173n = "ANR_EXCEPTION";
            crashDetailBean.f39174o = aVar.f39206f;
            crashDetailBean.f39176q = aVar.f39207g;
            HashMap hashMap = new HashMap();
            crashDetailBean.P = hashMap;
            hashMap.put("BUGLY_CR_01", aVar.f39205e);
            String str = crashDetailBean.f39176q;
            int indexOf = str != null ? str.indexOf("\n") : -1;
            crashDetailBean.f39175p = indexOf > 0 ? crashDetailBean.f39176q.substring(0, indexOf) : "GET_FAIL";
            crashDetailBean.f39177r = aVar.f39203c;
            String str2 = crashDetailBean.f39176q;
            if (str2 != null) {
                crashDetailBean.f39180u = z.a(str2.getBytes());
            }
            crashDetailBean.f39185z = aVar.f39202b;
            crashDetailBean.A = aVar.f39201a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.I = this.f39212d.t();
            crashDetailBean.f39167h = this.f39212d.q();
            crashDetailBean.f39168i = this.f39212d.C();
            crashDetailBean.f39181v = aVar.f39204d;
            com.tencent.bugly.crashreport.common.info.a aVar3 = this.f39212d;
            crashDetailBean.L = aVar3.f39106n;
            crashDetailBean.M = aVar3.f39088a;
            crashDetailBean.N = aVar3.a();
            if (!com.tencent.bugly.crashreport.common.info.b.m()) {
                this.f39215g.d(crashDetailBean);
            }
            crashDetailBean.Q = this.f39212d.A();
            crashDetailBean.R = this.f39212d.B();
            crashDetailBean.S = this.f39212d.u();
            crashDetailBean.T = this.f39212d.z();
            crashDetailBean.f39184y = y.a();
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    private static boolean a(String str, String str2, String str3) {
        Map<String, String[]> map;
        Throwable th;
        TraceFileHelper.a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo != null && (map = readTargetDumpInfo.f39200d) != null && map.size() > 0) {
            File file = new File(str2);
            try {
                if (!file.exists()) {
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                if (file.exists() && file.canWrite()) {
                    BufferedWriter bufferedWriter = null;
                    try {
                        try {
                            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, false));
                            try {
                                String[] strArr = readTargetDumpInfo.f39200d.get("main");
                                int i10 = 3;
                                if (strArr != null && strArr.length >= 3) {
                                    String str4 = strArr[0];
                                    String str5 = strArr[1];
                                    bufferedWriter2.write("\"main\" tid=" + strArr[2] + " :\n" + str4 + "\n" + str5 + "\n\n");
                                    bufferedWriter2.flush();
                                }
                                for (Map.Entry<String, String[]> entry : readTargetDumpInfo.f39200d.entrySet()) {
                                    if (!entry.getKey().equals("main")) {
                                        if (entry.getValue() != null && entry.getValue().length >= i10) {
                                            String str6 = entry.getValue()[0];
                                            String str7 = entry.getValue()[1];
                                            bufferedWriter2.write("\"" + entry.getKey() + "\" tid=" + entry.getValue()[2] + " :\n" + str6 + "\n" + str7 + "\n\n");
                                            bufferedWriter2.flush();
                                        }
                                        i10 = 3;
                                    }
                                }
                                try {
                                    bufferedWriter2.close();
                                } catch (IOException e2) {
                                    if (!x.a(e2)) {
                                        e2.printStackTrace();
                                    }
                                }
                                return true;
                            } catch (IOException e10) {
                                e = e10;
                                bufferedWriter = bufferedWriter2;
                                if (!x.a(e)) {
                                    e.printStackTrace();
                                }
                                x.e("dump trace fail %s", e.getClass().getName() + u.bD + e.getMessage());
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (IOException e11) {
                                        if (!x.a(e11)) {
                                            e11.printStackTrace();
                                        }
                                    }
                                }
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedWriter = bufferedWriter2;
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                        throw th;
                                    } catch (IOException e12) {
                                        if (!x.a(e12)) {
                                            e12.printStackTrace();
                                            throw th;
                                        }
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (IOException e13) {
                        e = e13;
                    }
                } else {
                    x.e("backup file create fail %s", str2);
                    return false;
                }
            } catch (Exception e14) {
                if (!x.a(e14)) {
                    e14.printStackTrace();
                }
                x.e("backup file create error! %s  %s", e14.getClass().getName() + u.bD + e14.getMessage(), str2);
                return false;
            }
        } else {
            x.e("not found trace dump for %s", str3);
            return false;
        }
    }

    public final boolean a() {
        return this.f39209a.get() != 0;
    }

    private boolean a(Context context, String str, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j10, Map<String, String> map) {
        a aVar = new a();
        aVar.f39203c = j10;
        aVar.f39201a = processErrorStateInfo != null ? processErrorStateInfo.processName : AppInfo.a(Process.myPid());
        aVar.f39206f = processErrorStateInfo != null ? processErrorStateInfo.shortMsg : "";
        aVar.f39205e = processErrorStateInfo != null ? processErrorStateInfo.longMsg : "";
        aVar.f39202b = map;
        Thread thread = Looper.getMainLooper().getThread();
        if (map != null) {
            Iterator<String> iterator2 = map.h().iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                String next = iterator2.next();
                if (next.startsWith(thread.getName())) {
                    aVar.f39207g = map.get(next);
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(aVar.f39207g)) {
            aVar.f39207g = "main stack is null , some error may be encountered.";
        }
        Object[] objArr = new Object[7];
        objArr[0] = Long.valueOf(aVar.f39203c);
        objArr[1] = aVar.f39204d;
        objArr[2] = aVar.f39201a;
        objArr[3] = aVar.f39207g;
        objArr[4] = aVar.f39206f;
        objArr[5] = aVar.f39205e;
        Map<String, String> map2 = aVar.f39202b;
        objArr[6] = Integer.valueOf(map2 == null ? 0 : map2.size());
        x.c("anr tm:%d\ntr:%s\nproc:%s\nmain stack:%s\nsMsg:%s\n lMsg:%s\n threads:%d", objArr);
        x.a("found visiable anr , start to upload!", new Object[0]);
        CrashDetailBean a10 = a(aVar);
        if (a10 == null) {
            x.e("pack anr fail!", new Object[0]);
            return false;
        }
        c.a().a(a10);
        if (a10.f39160a >= 0) {
            x.a("backup anr record success!", new Object[0]);
        } else {
            x.d("backup anr record fail!", new Object[0]);
        }
        if (str != null && new File(str).exists()) {
            aVar.f39204d = new File(this.f39214f, "bugly_trace_" + j10 + ".txt").getAbsolutePath();
            this.f39209a.set(3);
            if (a(str, aVar.f39204d, aVar.f39201a)) {
                x.a("backup trace success", new Object[0]);
            }
        } else {
            File h10 = h();
            x.a("traceFile is %s", h10);
            if (h10 != null) {
                a10.f39181v = h10.getAbsolutePath();
            }
        }
        com.tencent.bugly.crashreport.crash.b.a("ANR", z.a(), aVar.f39201a, "main", aVar.f39207g, a10);
        if (!this.f39215g.a(a10)) {
            this.f39215g.a(a10, com.huawei.openalliance.ad.ipc.c.Code, true);
        }
        this.f39215g.c(a10);
        return true;
    }

    public final void a(String str) {
        synchronized (this) {
            if (this.f39209a.get() != 0) {
                x.c("trace started return ", new Object[0]);
                return;
            }
            this.f39209a.set(1);
            try {
                x.c("read trace first dump for create time!", new Object[0]);
                TraceFileHelper.a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                long j10 = readFirstDumpInfo != null ? readFirstDumpInfo.f39199c : -1L;
                if (j10 == -1) {
                    x.d("trace dump fail could not get time!", new Object[0]);
                    j10 = System.currentTimeMillis();
                }
                long j11 = j10;
                if (Math.abs(j11 - this.f39210b) < 10000) {
                    x.d("should not process ANR too Fre in %d", 10000);
                } else {
                    this.f39210b = j11;
                    this.f39209a.set(1);
                    try {
                        Map<String, String> a10 = z.a(c.f39242f, false);
                        if (a10 != null && a10.size() > 0) {
                            ActivityManager.ProcessErrorStateInfo a11 = a(this.f39211c, 20000L);
                            this.f39220l = a11;
                            if (a11 == null) {
                                x.c("proc state is unvisiable!", new Object[0]);
                            } else if (a11.pid != Process.myPid()) {
                                x.c("not mind proc!", this.f39220l.processName);
                            } else {
                                x.a("found visiable anr , start to process!", new Object[0]);
                                a(this.f39211c, str, this.f39220l, j11, a10);
                            }
                        }
                        x.d("can't get all thread skip this anr", new Object[0]);
                    } catch (Throwable th) {
                        x.a(th);
                        x.e("get all thread stack fail!", new Object[0]);
                    }
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public final void a(boolean z10) {
        c(z10);
        boolean g3 = g();
        com.tencent.bugly.crashreport.common.strategy.a a10 = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a10 != null) {
            g3 = g3 && a10.c().f39126e;
        }
        if (g3 != f()) {
            x.a("anr changed to %b", Boolean.valueOf(g3));
            b(g3);
        }
    }

    @Override // com.tencent.bugly.proguard.ac
    public final boolean a(aa aaVar) {
        Map<String, String> hashMap = new HashMap<>();
        if (aaVar.e().equals(Looper.getMainLooper())) {
            try {
                hashMap = z.a(200000, false);
            } catch (Throwable th) {
                x.b(th);
                hashMap.put("main", th.getMessage());
            }
            Map<String, String> map = hashMap;
            x.c("onThreadBlock found visiable anr , start to process!", new Object[0]);
            String c4 = com.tencent.bugly.crashreport.common.info.b.c(this.f39211c);
            if (!TextUtils.isEmpty(c4) && (c4.contains("XiaoMi") || c4.contains("samsung"))) {
                this.f39220l = a(this.f39211c, 20000L);
            }
            a(this.f39211c, "", this.f39220l, System.currentTimeMillis(), map);
        } else {
            x.c("anr handler onThreadBlock only care main thread ,current thread is: %s", aaVar.d());
        }
        return true;
    }
}
