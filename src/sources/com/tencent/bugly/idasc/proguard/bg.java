package com.tencent.bugly.idasc.proguard;

import android.os.Handler;
import android.os.Looper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bg extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public bf f39750a;

    /* renamed from: g, reason: collision with root package name */
    private a f39756g;

    /* renamed from: c, reason: collision with root package name */
    private boolean f39752c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f39753d = true;

    /* renamed from: e, reason: collision with root package name */
    private boolean f39754e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f39755f = 1;

    /* renamed from: b, reason: collision with root package name */
    public boolean f39751b = true;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
    }

    private synchronized void a(bf bfVar) {
        if (this.f39753d) {
            return;
        }
        if (this.f39754e && !bfVar.a()) {
            al.c("Restart getting main stack trace.", new Object[0]);
            this.f39753d = true;
            this.f39754e = false;
        }
    }

    public final boolean a() {
        this.f39752c = true;
        if (!isAlive()) {
            return false;
        }
        try {
            interrupt();
        } catch (Exception e2) {
            al.b(e2);
        }
        al.d("MainHandlerChecker is reset to null.", new Object[0]);
        this.f39750a = null;
        return true;
    }

    public final boolean b() {
        Handler handler = new Handler(Looper.getMainLooper());
        bf bfVar = this.f39750a;
        if (bfVar != null) {
            bfVar.f39744b = 5000L;
        } else {
            this.f39750a = new bf(handler, handler.getLooper().getThread().getName());
        }
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e2) {
            al.b(e2);
            return false;
        }
    }

    public final synchronized void c() {
        this.f39753d = false;
        al.c("Record stack trace is disabled.", new Object[0]);
    }

    public final synchronized void d() {
        this.f39754e = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x006e, code lost:
    
        r2.d();
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r10 = this;
            long r0 = java.lang.System.currentTimeMillis()
        L4:
            boolean r2 = r10.f39752c
            if (r2 != 0) goto L95
            com.tencent.bugly.idasc.proguard.bf r2 = r10.f39750a     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            r3 = 0
            if (r2 != 0) goto L15
            java.lang.String r2 = "Main handler checker is null. Stop thread monitor."
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            com.tencent.bugly.idasc.proguard.al.c(r2, r3)     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            return
        L15:
            boolean r4 = r2.f39745c     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            if (r4 == 0) goto L26
            r2.f39745c = r3     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            long r4 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            r2.f39746d = r4     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            android.os.Handler r4 = r2.f39743a     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            r4.post(r2)     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
        L26:
            r10.a(r2)     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            boolean r4 = r10.f39751b     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            r5 = 1
            if (r4 == 0) goto L6c
            boolean r4 = r10.f39753d     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            if (r4 != 0) goto L33
            goto L6c
        L33:
            long r6 = r2.b()     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            r8 = 1510(0x5e6, double:7.46E-321)
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 <= 0) goto L6c
            r8 = 199990(0x30d36, double:9.8808E-319)
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 < 0) goto L45
            goto L6c
        L45:
            r8 = 5010(0x1392, double:2.4753E-320)
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 > 0) goto L56
            r10.f39755f = r5     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            java.lang.String r4 = "timeSinceMsgSent in [2s, 5s], record stack"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            com.tencent.bugly.idasc.proguard.al.c(r4, r3)     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            r3 = 1
            goto L6c
        L56:
            int r4 = r10.f39755f     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            int r4 = r4 + r5
            r10.f39755f = r4     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            int r6 = r4 + (-1)
            r4 = r4 & r6
            if (r4 != 0) goto L61
            goto L62
        L61:
            r5 = 0
        L62:
            if (r5 == 0) goto L6b
            java.lang.String r4 = "timeSinceMsgSent in (5s, 200s), should record stack:true"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            com.tencent.bugly.idasc.proguard.al.c(r4, r3)     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
        L6b:
            r3 = r5
        L6c:
            if (r3 == 0) goto L71
            r2.d()     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
        L71:
            com.tencent.bugly.idasc.proguard.bg$a r3 = r10.f39756g     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            if (r3 == 0) goto L7f
            boolean r3 = r10.f39753d     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            if (r3 == 0) goto L7f
            r2.a()     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            r2.b()     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
        L7f:
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            long r2 = r2 - r0
            r4 = 500(0x1f4, double:2.47E-321)
            long r2 = r2 % r4
            long r4 = r4 - r2
            com.tencent.bugly.idasc.proguard.ap.b(r4)     // Catch: java.lang.OutOfMemoryError -> L8d java.lang.Exception -> L8f
            goto L4
        L8d:
            r2 = move-exception
            goto L90
        L8f:
            r2 = move-exception
        L90:
            com.tencent.bugly.idasc.proguard.al.b(r2)
            goto L4
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.bg.run():void");
    }
}
