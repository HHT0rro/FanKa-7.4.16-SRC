package com.tencent.bugly.idasc.proguard;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.text.TextUtils;
import com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.idasc.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.idasc.crashreport.crash.jni.NativeCrashHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ay {

    /* renamed from: f, reason: collision with root package name */
    public static ay f39699f;

    /* renamed from: b, reason: collision with root package name */
    public final ActivityManager f39701b;

    /* renamed from: c, reason: collision with root package name */
    public final aa f39702c;

    /* renamed from: d, reason: collision with root package name */
    public final ak f39703d;

    /* renamed from: e, reason: collision with root package name */
    public String f39704e;

    /* renamed from: g, reason: collision with root package name */
    private final Context f39705g;

    /* renamed from: h, reason: collision with root package name */
    private final ac f39706h;

    /* renamed from: i, reason: collision with root package name */
    private final as f39707i;

    /* renamed from: k, reason: collision with root package name */
    private FileObserver f39709k;

    /* renamed from: m, reason: collision with root package name */
    private bg f39711m;

    /* renamed from: n, reason: collision with root package name */
    private int f39712n;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f39700a = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    private final Object f39708j = new Object();

    /* renamed from: l, reason: collision with root package name */
    private boolean f39710l = true;

    /* renamed from: o, reason: collision with root package name */
    private long f39713o = 0;

    public ay(Context context, ac acVar, aa aaVar, ak akVar, as asVar) {
        Context a10 = ap.a(context);
        this.f39705g = a10;
        this.f39701b = (ActivityManager) a10.getSystemService("activity");
        this.f39704e = ap.b(NativeCrashHandler.getDumpFilePath()) ? context.getDir("bugly", 0).getAbsolutePath() : NativeCrashHandler.getDumpFilePath();
        this.f39702c = aaVar;
        this.f39703d = akVar;
        this.f39706h = acVar;
        this.f39707i = asVar;
    }

    private CrashDetailBean a(ax axVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.C = ab.j();
            crashDetailBean.D = ab.f();
            crashDetailBean.E = ab.l();
            crashDetailBean.F = this.f39702c.k();
            crashDetailBean.G = this.f39702c.j();
            crashDetailBean.H = this.f39702c.l();
            crashDetailBean.I = ab.b(this.f39705g);
            crashDetailBean.J = ab.g();
            crashDetailBean.K = ab.h();
            crashDetailBean.f39410b = 3;
            crashDetailBean.f39413e = this.f39702c.g();
            aa aaVar = this.f39702c;
            crashDetailBean.f39414f = aaVar.f39485o;
            crashDetailBean.f39415g = aaVar.q();
            crashDetailBean.f39421m = this.f39702c.f();
            crashDetailBean.f39422n = "ANR_EXCEPTION";
            crashDetailBean.f39423o = axVar.f39697f;
            crashDetailBean.f39425q = axVar.f39698g;
            HashMap hashMap = new HashMap();
            crashDetailBean.T = hashMap;
            hashMap.put("BUGLY_CR_01", axVar.f39696e);
            String str = crashDetailBean.f39425q;
            int indexOf = str != null ? str.indexOf("\n") : -1;
            crashDetailBean.f39424p = indexOf > 0 ? crashDetailBean.f39425q.substring(0, indexOf) : "GET_FAIL";
            crashDetailBean.f39426r = axVar.f39694c;
            String str2 = crashDetailBean.f39425q;
            if (str2 != null) {
                crashDetailBean.f39429u = ap.c(str2.getBytes());
            }
            crashDetailBean.f39434z = axVar.f39693b;
            crashDetailBean.A = axVar.f39692a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.L = this.f39702c.s();
            crashDetailBean.f39416h = this.f39702c.p();
            crashDetailBean.f39417i = this.f39702c.A();
            crashDetailBean.f39430v = axVar.f39695d;
            aa aaVar2 = this.f39702c;
            crashDetailBean.P = aaVar2.f39491u;
            crashDetailBean.Q = aaVar2.f39465a;
            crashDetailBean.R = aaVar2.a();
            crashDetailBean.U = this.f39702c.z();
            aa aaVar3 = this.f39702c;
            crashDetailBean.V = aaVar3.f39494x;
            crashDetailBean.W = aaVar3.t();
            crashDetailBean.X = this.f39702c.y();
            crashDetailBean.f39433y = ao.a();
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    public static synchronized ay a() {
        ay ayVar;
        synchronized (ay.class) {
            ayVar = f39699f;
        }
        return ayVar;
    }

    private static String a(List<ba> list, long j10) {
        if (list == null || list.isEmpty()) {
            return "main thread stack not enable";
        }
        StringBuilder sb2 = new StringBuilder(4096);
        sb2.append("\n>>>>> 以下为anr过程中主线程堆栈记录，可根据堆栈出现次数推测在该堆栈阻塞的时间，出现次数越多对anr贡献越大，越可能是造成anr的原因 >>>>>\n");
        sb2.append("\n>>>>> Thread Stack Traces Records Start >>>>>\n");
        for (int i10 = 0; i10 < list.size(); i10++) {
            ba baVar = list.get(i10);
            sb2.append("Thread name:");
            sb2.append(baVar.f39720a);
            sb2.append("\n");
            long j11 = baVar.f39721b - j10;
            String str = j11 <= 0 ? "before " : "after ";
            sb2.append("Got ");
            sb2.append(str);
            sb2.append("anr:");
            sb2.append(Math.abs(j11));
            sb2.append("ms\n");
            sb2.append(baVar.f39722c);
            sb2.append("\n");
            if (sb2.length() * 2 >= 101376) {
                break;
            }
        }
        sb2.append("\n<<<<< Thread Stack Traces Records End <<<<<\n");
        return sb2.toString();
    }

    public static /* synthetic */ void a(ay ayVar) {
        long currentTimeMillis = (at.f39641j + System.currentTimeMillis()) - ap.b();
        am.a(ayVar.f39704e, "bugly_trace_", ".txt", currentTimeMillis);
        am.a(ayVar.f39704e, "manual_bugly_trace_", ".txt", currentTimeMillis);
        am.a(ayVar.f39704e, "main_stack_record_", ".txt", currentTimeMillis);
        am.a(ayVar.f39704e, "main_stack_record_", ".txt.merged", currentTimeMillis);
    }

    private static boolean a(String str, String str2, String str3) {
        Map<String, String[]> map;
        TraceFileHelper.a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo == null || (map = readTargetDumpInfo.f39443d) == null || map.isEmpty()) {
            al.e("not found trace dump for %s", str3);
            return false;
        }
        StringBuilder sb2 = new StringBuilder(1024);
        String[] strArr = readTargetDumpInfo.f39443d.get("main");
        if (strArr != null && strArr.length >= 3) {
            sb2.append("\"main\" tid=");
            sb2.append(strArr[2]);
            sb2.append(" :\n");
            sb2.append(strArr[0]);
            sb2.append("\n");
            sb2.append(strArr[1]);
            sb2.append("\n\n");
        }
        for (Map.Entry<String, String[]> entry : readTargetDumpInfo.f39443d.entrySet()) {
            if (!entry.getKey().equals("main") && entry.getValue() != null && entry.getValue().length >= 3) {
                sb2.append("\"");
                sb2.append(entry.getKey());
                sb2.append("\" tid=");
                sb2.append(entry.getValue()[2]);
                sb2.append(" :\n");
                sb2.append(entry.getValue()[0]);
                sb2.append("\n");
                sb2.append(entry.getValue()[1]);
                sb2.append("\n\n");
            }
        }
        return am.a(str2, sb2.toString(), sb2.length() * 2);
    }

    private synchronized void c() {
        if (e()) {
            al.d("start when started!", new Object[0]);
            return;
        }
        FileObserver fileObserver = new FileObserver("/data/anr/") { // from class: com.tencent.bugly.idasc.proguard.ay.1
            @Override // android.os.FileObserver
            public final void onEvent(int i10, String str) {
                if (str == null) {
                    return;
                }
                final String concat = "/data/anr/".concat(str);
                al.d("watching file %s", concat);
                if (concat.contains("trace")) {
                    ay.this.f39703d.a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.ay.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ay ayVar = ay.this;
                            String str2 = concat;
                            if (ayVar.a(true)) {
                                try {
                                    al.c("read trace first dump for create time!", new Object[0]);
                                    TraceFileHelper.a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str2, false);
                                    long j10 = readFirstDumpInfo != null ? readFirstDumpInfo.f39442c : -1L;
                                    if (j10 == -1) {
                                        al.d("trace dump fail could not get time!", new Object[0]);
                                        j10 = System.currentTimeMillis();
                                    }
                                    if (ayVar.a(j10)) {
                                        return;
                                    }
                                    ayVar.a(j10, str2);
                                } catch (Throwable th) {
                                    if (!al.a(th)) {
                                        th.printStackTrace();
                                    }
                                    al.e("handle anr error %s", th.getClass().toString());
                                }
                            }
                        }
                    });
                } else {
                    al.d("not anr file %s", concat);
                }
            }
        };
        this.f39709k = fileObserver;
        try {
            fileObserver.startWatching();
            al.a("start anr monitor!", new Object[0]);
            this.f39703d.a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.ay.2
                @Override // java.lang.Runnable
                public final void run() {
                    ay.a(ay.this);
                }
            });
        } catch (Throwable th) {
            this.f39709k = null;
            al.d("start anr monitor failed!", new Object[0]);
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized void c(boolean z10) {
        if (z10) {
            g();
        } else {
            h();
        }
    }

    private synchronized void d() {
        if (!e()) {
            al.d("close when closed!", new Object[0]);
            return;
        }
        try {
            this.f39709k.stopWatching();
            this.f39709k = null;
            al.d("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            al.d("stop anr monitor failed!", new Object[0]);
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized void d(boolean z10) {
        if (this.f39710l != z10) {
            al.a("user change anr %b", Boolean.valueOf(z10));
            this.f39710l = z10;
        }
    }

    private synchronized boolean e() {
        return this.f39709k != null;
    }

    private synchronized boolean f() {
        return this.f39710l;
    }

    private synchronized void g() {
        if (e()) {
            al.d("start when started!", new Object[0]);
            return;
        }
        if (TextUtils.isEmpty(this.f39704e)) {
            return;
        }
        synchronized (this.f39708j) {
            bg bgVar = this.f39711m;
            if (bgVar == null || !bgVar.isAlive()) {
                bg bgVar2 = new bg();
                this.f39711m = bgVar2;
                boolean z10 = this.f39702c.S;
                bgVar2.f39751b = z10;
                al.c("set record stack trace enable:".concat(String.valueOf(z10)), new Object[0]);
                bg bgVar3 = this.f39711m;
                StringBuilder sb2 = new StringBuilder("Bugly-ThreadMonitor");
                int i10 = this.f39712n;
                this.f39712n = i10 + 1;
                sb2.append(i10);
                bgVar3.setName(sb2.toString());
                this.f39711m.b();
            }
        }
        FileObserver fileObserver = new FileObserver(this.f39704e) { // from class: com.tencent.bugly.idasc.proguard.ay.3
            @Override // android.os.FileObserver
            public final void onEvent(int i11, String str) {
                if (str == null) {
                    return;
                }
                al.d("observe file, dir:%s fileName:%s", ay.this.f39704e, str);
                if (!(str.startsWith("manual_bugly_trace_") && str.endsWith(".txt"))) {
                    al.c("not manual trace file, ignore.", new Object[0]);
                    return;
                }
                if (!ay.this.f39700a.get()) {
                    al.c("proc is not in anr, just ignore", new Object[0]);
                    return;
                }
                if (ay.this.f39702c.a()) {
                    al.c("Found foreground anr, resend sigquit immediately.", new Object[0]);
                    NativeCrashHandler.getInstance().resendSigquit();
                    long a10 = am.a(str, "manual_bugly_trace_", ".txt");
                    ay.this.a(a10, ay.this.f39704e + "/" + str);
                    al.c("Finish handling one anr.", new Object[0]);
                    return;
                }
                al.c("Found background anr, resend sigquit later.", new Object[0]);
                long a11 = am.a(str, "manual_bugly_trace_", ".txt");
                ay.this.a(a11, ay.this.f39704e + "/" + str);
                al.c("Finish handling one anr, now resend sigquit.", new Object[0]);
                NativeCrashHandler.getInstance().resendSigquit();
            }
        };
        this.f39709k = fileObserver;
        try {
            fileObserver.startWatching();
            al.a("startWatchingPrivateAnrDir! dumFilePath is %s", this.f39704e);
            this.f39703d.a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.ay.4
                @Override // java.lang.Runnable
                public final void run() {
                    ay.a(ay.this);
                }
            });
        } catch (Throwable th) {
            this.f39709k = null;
            al.d("startWatchingPrivateAnrDir failed!", new Object[0]);
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized void h() {
        if (!e()) {
            al.d("close when closed!", new Object[0]);
            return;
        }
        synchronized (this.f39708j) {
            bg bgVar = this.f39711m;
            if (bgVar != null) {
                bgVar.a();
                this.f39711m = null;
            }
        }
        al.a("stopWatchingPrivateAnrDir", new Object[0]);
        try {
            this.f39709k.stopWatching();
            this.f39709k = null;
            al.d("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            al.d("stop anr monitor failed!", new Object[0]);
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069 A[Catch: all -> 0x01f8, TryCatch #4 {all -> 0x01f8, blocks: (B:3:0x0007, B:4:0x0017, B:10:0x0029, B:12:0x0049, B:14:0x004f, B:18:0x0059, B:21:0x0069, B:23:0x007a, B:27:0x0085, B:29:0x00a2, B:30:0x00a6, B:33:0x00d6, B:35:0x00f5, B:38:0x0102, B:40:0x012b, B:41:0x0159, B:42:0x015c, B:49:0x016a, B:50:0x017b, B:51:0x018c, B:53:0x019d, B:54:0x01ac, B:57:0x01ca, B:59:0x01d0, B:60:0x01d5, B:61:0x01dc, B:72:0x01f4, B:74:0x01a5, B:78:0x0184, B:79:0x0143, B:80:0x0185, B:81:0x00d2, B:83:0x0072, B:87:0x01f7, B:63:0x01dd, B:65:0x01e1, B:66:0x01ed, B:44:0x015d, B:46:0x0161, B:47:0x0167, B:6:0x0018, B:8:0x001c, B:9:0x0028), top: B:2:0x0007, inners: #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007a A[Catch: all -> 0x01f8, TRY_LEAVE, TryCatch #4 {all -> 0x01f8, blocks: (B:3:0x0007, B:4:0x0017, B:10:0x0029, B:12:0x0049, B:14:0x004f, B:18:0x0059, B:21:0x0069, B:23:0x007a, B:27:0x0085, B:29:0x00a2, B:30:0x00a6, B:33:0x00d6, B:35:0x00f5, B:38:0x0102, B:40:0x012b, B:41:0x0159, B:42:0x015c, B:49:0x016a, B:50:0x017b, B:51:0x018c, B:53:0x019d, B:54:0x01ac, B:57:0x01ca, B:59:0x01d0, B:60:0x01d5, B:61:0x01dc, B:72:0x01f4, B:74:0x01a5, B:78:0x0184, B:79:0x0143, B:80:0x0185, B:81:0x00d2, B:83:0x0072, B:87:0x01f7, B:63:0x01dd, B:65:0x01e1, B:66:0x01ed, B:44:0x015d, B:46:0x0161, B:47:0x0167, B:6:0x0018, B:8:0x001c, B:9:0x0028), top: B:2:0x0007, inners: #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0085 A[Catch: all -> 0x01f8, TRY_ENTER, TryCatch #4 {all -> 0x01f8, blocks: (B:3:0x0007, B:4:0x0017, B:10:0x0029, B:12:0x0049, B:14:0x004f, B:18:0x0059, B:21:0x0069, B:23:0x007a, B:27:0x0085, B:29:0x00a2, B:30:0x00a6, B:33:0x00d6, B:35:0x00f5, B:38:0x0102, B:40:0x012b, B:41:0x0159, B:42:0x015c, B:49:0x016a, B:50:0x017b, B:51:0x018c, B:53:0x019d, B:54:0x01ac, B:57:0x01ca, B:59:0x01d0, B:60:0x01d5, B:61:0x01dc, B:72:0x01f4, B:74:0x01a5, B:78:0x0184, B:79:0x0143, B:80:0x0185, B:81:0x00d2, B:83:0x0072, B:87:0x01f7, B:63:0x01dd, B:65:0x01e1, B:66:0x01ed, B:44:0x015d, B:46:0x0161, B:47:0x0167, B:6:0x0018, B:8:0x001c, B:9:0x0028), top: B:2:0x0007, inners: #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x019d A[Catch: all -> 0x01f8, TryCatch #4 {all -> 0x01f8, blocks: (B:3:0x0007, B:4:0x0017, B:10:0x0029, B:12:0x0049, B:14:0x004f, B:18:0x0059, B:21:0x0069, B:23:0x007a, B:27:0x0085, B:29:0x00a2, B:30:0x00a6, B:33:0x00d6, B:35:0x00f5, B:38:0x0102, B:40:0x012b, B:41:0x0159, B:42:0x015c, B:49:0x016a, B:50:0x017b, B:51:0x018c, B:53:0x019d, B:54:0x01ac, B:57:0x01ca, B:59:0x01d0, B:60:0x01d5, B:61:0x01dc, B:72:0x01f4, B:74:0x01a5, B:78:0x0184, B:79:0x0143, B:80:0x0185, B:81:0x00d2, B:83:0x0072, B:87:0x01f7, B:63:0x01dd, B:65:0x01e1, B:66:0x01ed, B:44:0x015d, B:46:0x0161, B:47:0x0167, B:6:0x0018, B:8:0x001c, B:9:0x0028), top: B:2:0x0007, inners: #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d0 A[Catch: all -> 0x01f8, TryCatch #4 {all -> 0x01f8, blocks: (B:3:0x0007, B:4:0x0017, B:10:0x0029, B:12:0x0049, B:14:0x004f, B:18:0x0059, B:21:0x0069, B:23:0x007a, B:27:0x0085, B:29:0x00a2, B:30:0x00a6, B:33:0x00d6, B:35:0x00f5, B:38:0x0102, B:40:0x012b, B:41:0x0159, B:42:0x015c, B:49:0x016a, B:50:0x017b, B:51:0x018c, B:53:0x019d, B:54:0x01ac, B:57:0x01ca, B:59:0x01d0, B:60:0x01d5, B:61:0x01dc, B:72:0x01f4, B:74:0x01a5, B:78:0x0184, B:79:0x0143, B:80:0x0185, B:81:0x00d2, B:83:0x0072, B:87:0x01f7, B:63:0x01dd, B:65:0x01e1, B:66:0x01ed, B:44:0x015d, B:46:0x0161, B:47:0x0167, B:6:0x0018, B:8:0x001c, B:9:0x0028), top: B:2:0x0007, inners: #1, #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a5 A[Catch: all -> 0x01f8, TryCatch #4 {all -> 0x01f8, blocks: (B:3:0x0007, B:4:0x0017, B:10:0x0029, B:12:0x0049, B:14:0x004f, B:18:0x0059, B:21:0x0069, B:23:0x007a, B:27:0x0085, B:29:0x00a2, B:30:0x00a6, B:33:0x00d6, B:35:0x00f5, B:38:0x0102, B:40:0x012b, B:41:0x0159, B:42:0x015c, B:49:0x016a, B:50:0x017b, B:51:0x018c, B:53:0x019d, B:54:0x01ac, B:57:0x01ca, B:59:0x01d0, B:60:0x01d5, B:61:0x01dc, B:72:0x01f4, B:74:0x01a5, B:78:0x0184, B:79:0x0143, B:80:0x0185, B:81:0x00d2, B:83:0x0072, B:87:0x01f7, B:63:0x01dd, B:65:0x01e1, B:66:0x01ed, B:44:0x015d, B:46:0x0161, B:47:0x0167, B:6:0x0018, B:8:0x001c, B:9:0x0028), top: B:2:0x0007, inners: #1, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(long r19, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 518
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.ay.a(long, java.lang.String):void");
    }

    public final boolean a(long j10) {
        if (Math.abs(j10 - this.f39713o) < 10000) {
            al.d("should not process ANR too Fre in %dms", 10000);
            return true;
        }
        this.f39713o = j10;
        return false;
    }

    public final boolean a(boolean z10) {
        boolean compareAndSet = this.f39700a.compareAndSet(!z10, z10);
        al.c("tryChangeAnrState to %s, success:%s", Boolean.valueOf(z10), Boolean.valueOf(compareAndSet));
        return compareAndSet;
    }

    public final synchronized void b() {
        al.d("customer decides whether to open or close.", new Object[0]);
    }

    public final void b(boolean z10) {
        d(z10);
        boolean f10 = f();
        ac a10 = ac.a();
        if (a10 != null) {
            f10 = f10 && a10.c().f39390f;
        }
        if (f10 != e()) {
            al.a("anr changed to %b", Boolean.valueOf(f10));
            c(f10);
        }
    }
}
