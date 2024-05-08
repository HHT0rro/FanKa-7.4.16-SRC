package com.tencent.bugly.idasc;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.idasc.BuglyStrategy;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.idasc.proguard.aa;
import com.tencent.bugly.idasc.proguard.al;
import com.tencent.bugly.idasc.proguard.at;
import com.tencent.bugly.idasc.proguard.o;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CrashModule extends o {
    public static final int MODULE_ID = 1004;

    /* renamed from: c, reason: collision with root package name */
    private static int f39355c;

    /* renamed from: e, reason: collision with root package name */
    private static CrashModule f39356e = new CrashModule();

    /* renamed from: a, reason: collision with root package name */
    private long f39357a;

    /* renamed from: b, reason: collision with root package name */
    private BuglyStrategy.a f39358b;

    /* renamed from: d, reason: collision with root package name */
    private boolean f39359d = false;

    private synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        if (buglyStrategy == null) {
            return;
        }
        String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
        if (!TextUtils.isEmpty(libBuglySOFilePath)) {
            aa.a(context).f39490t = libBuglySOFilePath;
            al.a("setted libBugly.so file path :%s", libBuglySOFilePath);
        }
        if (buglyStrategy.getCrashHandleCallback() != null) {
            this.f39358b = buglyStrategy.getCrashHandleCallback();
            al.a("setted CrashHanldeCallback", new Object[0]);
        }
        if (buglyStrategy.getAppReportDelay() > 0) {
            long appReportDelay = buglyStrategy.getAppReportDelay();
            this.f39357a = appReportDelay;
            al.a("setted delay: %d", Long.valueOf(appReportDelay));
        }
    }

    public static CrashModule getInstance() {
        CrashModule crashModule = f39356e;
        crashModule.f39905id = 1004;
        return crashModule;
    }

    @Override // com.tencent.bugly.idasc.proguard.o
    public String[] getTables() {
        return new String[]{"t_cr"};
    }

    public synchronized boolean hasInitialized() {
        return this.f39359d;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0076 A[Catch: all -> 0x00df, TryCatch #0 {, blocks: (B:7:0x0003, B:10:0x0009, B:12:0x0033, B:14:0x0055, B:15:0x0064, B:17:0x0076, B:19:0x007d, B:22:0x0084, B:24:0x0094, B:27:0x009b, B:29:0x00ab, B:31:0x00b3, B:32:0x00ba, B:37:0x00a6, B:38:0x008f, B:39:0x005b, B:40:0x005d, B:41:0x0061), top: B:6:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094 A[Catch: all -> 0x00df, TryCatch #0 {, blocks: (B:7:0x0003, B:10:0x0009, B:12:0x0033, B:14:0x0055, B:15:0x0064, B:17:0x0076, B:19:0x007d, B:22:0x0084, B:24:0x0094, B:27:0x009b, B:29:0x00ab, B:31:0x00b3, B:32:0x00ba, B:37:0x00a6, B:38:0x008f, B:39:0x005b, B:40:0x005d, B:41:0x0061), top: B:6:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ab A[Catch: all -> 0x00df, TryCatch #0 {, blocks: (B:7:0x0003, B:10:0x0009, B:12:0x0033, B:14:0x0055, B:15:0x0064, B:17:0x0076, B:19:0x007d, B:22:0x0084, B:24:0x0094, B:27:0x009b, B:29:0x00ab, B:31:0x00b3, B:32:0x00ba, B:37:0x00a6, B:38:0x008f, B:39:0x005b, B:40:0x005d, B:41:0x0061), top: B:6:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b3 A[Catch: all -> 0x00df, TryCatch #0 {, blocks: (B:7:0x0003, B:10:0x0009, B:12:0x0033, B:14:0x0055, B:15:0x0064, B:17:0x0076, B:19:0x007d, B:22:0x0084, B:24:0x0094, B:27:0x009b, B:29:0x00ab, B:31:0x00b3, B:32:0x00ba, B:37:0x00a6, B:38:0x008f, B:39:0x005b, B:40:0x005d, B:41:0x0061), top: B:6:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b8  */
    @Override // com.tencent.bugly.idasc.proguard.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void init(android.content.Context r5, boolean r6, com.tencent.bugly.idasc.BuglyStrategy r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto Le2
            boolean r0 = r4.f39359d     // Catch: java.lang.Throwable -> Ldf
            if (r0 == 0) goto L9
            goto Le2
        L9:
            java.lang.String r0 = "Initializing crash module."
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Ldf
            com.tencent.bugly.idasc.proguard.al.a(r0, r2)     // Catch: java.lang.Throwable -> Ldf
            com.tencent.bugly.idasc.proguard.u r0 = com.tencent.bugly.idasc.proguard.u.a()     // Catch: java.lang.Throwable -> Ldf
            int r2 = com.tencent.bugly.idasc.CrashModule.f39355c     // Catch: java.lang.Throwable -> Ldf
            r3 = 1
            int r2 = r2 + r3
            com.tencent.bugly.idasc.CrashModule.f39355c = r2     // Catch: java.lang.Throwable -> Ldf
            r0.a(r2)     // Catch: java.lang.Throwable -> Ldf
            r4.f39359d = r3     // Catch: java.lang.Throwable -> Ldf
            com.tencent.bugly.idasc.crashreport.CrashReport.setContext(r5)     // Catch: java.lang.Throwable -> Ldf
            r4.a(r5, r7)     // Catch: java.lang.Throwable -> Ldf
            com.tencent.bugly.idasc.BuglyStrategy$a r0 = r4.f39358b     // Catch: java.lang.Throwable -> Ldf
            com.tencent.bugly.idasc.proguard.at r6 = com.tencent.bugly.idasc.proguard.at.a(r5, r6, r0)     // Catch: java.lang.Throwable -> Ldf
            com.tencent.bugly.idasc.proguard.av r0 = r6.f39652t     // Catch: java.lang.Throwable -> Ldf
            r0.a()     // Catch: java.lang.Throwable -> Ldf
            if (r7 == 0) goto L61
            int r0 = r7.getCallBackType()     // Catch: java.lang.Throwable -> Ldf
            r6.B = r0     // Catch: java.lang.Throwable -> Ldf
            boolean r0 = r7.getCloseErrorCallback()     // Catch: java.lang.Throwable -> Ldf
            r6.C = r0     // Catch: java.lang.Throwable -> Ldf
            boolean r0 = r7.isUploadSpotCrash()     // Catch: java.lang.Throwable -> Ldf
            com.tencent.bugly.idasc.proguard.at.f39646o = r0     // Catch: java.lang.Throwable -> Ldf
            com.tencent.bugly.idasc.proguard.aa r0 = com.tencent.bugly.idasc.proguard.aa.a(r5)     // Catch: java.lang.Throwable -> Ldf
            boolean r2 = r7.isEnableRecordAnrMainStack()     // Catch: java.lang.Throwable -> Ldf
            r0.S = r2     // Catch: java.lang.Throwable -> Ldf
            boolean r0 = r7.isEnableCatchAnrTrace()     // Catch: java.lang.Throwable -> Ldf
            if (r0 != 0) goto L5b
            com.tencent.bugly.idasc.crashreport.crash.jni.NativeCrashHandler r0 = r6.f39653u     // Catch: java.lang.Throwable -> Ldf
            r0.disableCatchAnrTrace()     // Catch: java.lang.Throwable -> Ldf
            goto L64
        L5b:
            com.tencent.bugly.idasc.crashreport.crash.jni.NativeCrashHandler r0 = r6.f39653u     // Catch: java.lang.Throwable -> Ldf
        L5d:
            r0.enableCatchAnrTrace()     // Catch: java.lang.Throwable -> Ldf
            goto L64
        L61:
            com.tencent.bugly.idasc.crashreport.crash.jni.NativeCrashHandler r0 = r6.f39653u     // Catch: java.lang.Throwable -> Ldf
            goto L5d
        L64:
            com.tencent.bugly.idasc.proguard.aa r0 = com.tencent.bugly.idasc.proguard.aa.b()     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r0 = r0.f39474d     // Catch: java.lang.Throwable -> Ldf
            android.content.Context r2 = r6.f39650c     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r2 = com.tencent.bugly.idasc.proguard.z.a(r2)     // Catch: java.lang.Throwable -> Ldf
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Throwable -> Ldf
            if (r0 == 0) goto L7b
            com.tencent.bugly.idasc.crashreport.crash.jni.NativeCrashHandler r0 = r6.f39653u     // Catch: java.lang.Throwable -> Ldf
            r0.removeEmptyNativeRecordFiles()     // Catch: java.lang.Throwable -> Ldf
        L7b:
            if (r7 == 0) goto L8f
            boolean r0 = r7.isEnableNativeCrashMonitor()     // Catch: java.lang.Throwable -> Ldf
            if (r0 == 0) goto L84
            goto L8f
        L84:
            java.lang.String r0 = "[crash] Closed native crash monitor!"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Ldf
            com.tencent.bugly.idasc.proguard.al.a(r0, r2)     // Catch: java.lang.Throwable -> Ldf
            r6.d()     // Catch: java.lang.Throwable -> Ldf
            goto L92
        L8f:
            r6.e()     // Catch: java.lang.Throwable -> Ldf
        L92:
            if (r7 == 0) goto La6
            boolean r0 = r7.isEnableANRCrashMonitor()     // Catch: java.lang.Throwable -> Ldf
            if (r0 == 0) goto L9b
            goto La6
        L9b:
            java.lang.String r0 = "[crash] Closed ANR monitor!"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Ldf
            com.tencent.bugly.idasc.proguard.al.a(r0, r1)     // Catch: java.lang.Throwable -> Ldf
            r6.g()     // Catch: java.lang.Throwable -> Ldf
            goto La9
        La6:
            r6.f()     // Catch: java.lang.Throwable -> Ldf
        La9:
            if (r7 == 0) goto Lb1
            boolean r0 = r7.isMerged()     // Catch: java.lang.Throwable -> Ldf
            com.tencent.bugly.idasc.proguard.at.f39636e = r0     // Catch: java.lang.Throwable -> Ldf
        Lb1:
            if (r7 == 0) goto Lb8
            long r0 = r7.getAppReportDelay()     // Catch: java.lang.Throwable -> Ldf
            goto Lba
        Lb8:
            r0 = 0
        Lba:
            r6.a(r0)     // Catch: java.lang.Throwable -> Ldf
            com.tencent.bugly.idasc.crashreport.crash.jni.NativeCrashHandler r6 = r6.f39653u     // Catch: java.lang.Throwable -> Ldf
            r6.checkUploadRecordCrash()     // Catch: java.lang.Throwable -> Ldf
            com.tencent.bugly.idasc.proguard.au.a(r5)     // Catch: java.lang.Throwable -> Ldf
            com.tencent.bugly.idasc.proguard.aq r6 = com.tencent.bugly.idasc.proguard.aq.a()     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r7 = "android.net.conn.CONNECTIVITY_CHANGE"
            r6.a(r7)     // Catch: java.lang.Throwable -> Ldf
            r6.a(r5)     // Catch: java.lang.Throwable -> Ldf
            com.tencent.bugly.idasc.proguard.u r5 = com.tencent.bugly.idasc.proguard.u.a()     // Catch: java.lang.Throwable -> Ldf
            int r6 = com.tencent.bugly.idasc.CrashModule.f39355c     // Catch: java.lang.Throwable -> Ldf
            int r6 = r6 - r3
            com.tencent.bugly.idasc.CrashModule.f39355c = r6     // Catch: java.lang.Throwable -> Ldf
            r5.a(r6)     // Catch: java.lang.Throwable -> Ldf
            monitor-exit(r4)
            return
        Ldf:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        Le2:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.CrashModule.init(android.content.Context, boolean, com.tencent.bugly.idasc.BuglyStrategy):void");
    }

    @Override // com.tencent.bugly.idasc.proguard.o
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        at a10;
        if (strategyBean == null || (a10 = at.a()) == null) {
            return;
        }
        a10.f39652t.a(strategyBean);
        a10.f39653u.onStrategyChanged(strategyBean);
        a10.f39656x.b();
    }
}
