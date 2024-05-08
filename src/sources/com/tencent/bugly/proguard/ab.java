package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ab extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private boolean f40004a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f40005b = false;

    /* renamed from: c, reason: collision with root package name */
    private List<aa> f40006c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private List<ac> f40007d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<aa> f40008e = new ArrayList<>();

    private int e() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f40006c.size(); i11++) {
            try {
                i10 = Math.max(i10, this.f40006c.get(i11).c());
            } catch (Exception e2) {
                x.b(e2);
            }
        }
        return i10;
    }

    public final void a() {
        a(new Handler(Looper.getMainLooper()), 5000L);
    }

    public final void b() {
        for (int i10 = 0; i10 < this.f40006c.size(); i10++) {
            try {
                if (this.f40006c.get(i10).d().equals(Looper.getMainLooper().getThread().getName())) {
                    x.c("remove handler::%s", this.f40006c.get(i10));
                    this.f40006c.remove(i10);
                }
            } catch (Exception e2) {
                x.b(e2);
                return;
            }
        }
    }

    public final boolean c() {
        this.f40004a = true;
        if (!isAlive()) {
            return false;
        }
        try {
            interrupt();
        } catch (Exception e2) {
            x.b(e2);
        }
        return true;
    }

    public final boolean d() {
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e2) {
            x.b(e2);
            return false;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.f40004a) {
            for (int i10 = 0; i10 < this.f40006c.size(); i10++) {
                try {
                    this.f40006c.get(i10).a();
                } catch (Exception e2) {
                    x.b(e2);
                } catch (OutOfMemoryError e10) {
                    x.b(e10);
                }
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            for (long j10 = 2000; j10 > 0 && !isInterrupted(); j10 = 2000 - (SystemClock.uptimeMillis() - uptimeMillis)) {
                Thread.sleep(j10);
            }
            int e11 = e();
            if (e11 != 0 && e11 != 1) {
                this.f40008e.clear();
                for (int i11 = 0; i11 < this.f40006c.size(); i11++) {
                    aa aaVar = this.f40006c.get(i11);
                    if (aaVar.b()) {
                        this.f40008e.add(aaVar);
                        aaVar.a(Long.MAX_VALUE);
                    }
                }
                NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                if (nativeCrashHandler != null && nativeCrashHandler.isEnableCatchAnrTrace()) {
                    nativeCrashHandler.dumpAnrNativeStack();
                    x.c("jni mannual dump anr trace", new Object[0]);
                } else {
                    x.c("do not enable jni mannual dump anr trace", new Object[0]);
                }
                int i12 = 0;
                while (true) {
                    if (this.f40005b) {
                        break;
                    }
                    x.c("do not enable anr continue check", new Object[0]);
                    Thread.sleep(2000L);
                    i12++;
                    if (i12 == 15) {
                        this.f40008e.clear();
                        break;
                    }
                }
                for (int i13 = 0; i13 < this.f40008e.size(); i13++) {
                    aa aaVar2 = this.f40008e.get(i13);
                    for (int i14 = 0; i14 < this.f40007d.size(); i14++) {
                        x.e("main thread blocked,now begin to upload anr stack", new Object[0]);
                        this.f40007d.get(i14).a(aaVar2);
                        this.f40005b = false;
                    }
                }
            }
        }
    }

    private void a(Handler handler, long j10) {
        if (handler == null) {
            x.e("addThread handler should not be null", new Object[0]);
            return;
        }
        String name = handler.getLooper().getThread().getName();
        for (int i10 = 0; i10 < this.f40006c.size(); i10++) {
            try {
                if (this.f40006c.get(i10).d().equals(handler.getLooper().getThread().getName())) {
                    x.e("addThread fail ,this thread has been added in monitor queue", new Object[0]);
                    return;
                }
            } catch (Exception e2) {
                x.b(e2);
            }
        }
        this.f40006c.add(new aa(handler, name, 5000L));
    }

    public final void b(ac acVar) {
        this.f40007d.remove(acVar);
    }

    public final void a(ac acVar) {
        if (this.f40007d.contains(acVar)) {
            x.c("addThreadMonitorListeners fail ,this threadMonitorListener has been added in monitor queue", new Object[0]);
        } else {
            this.f40007d.add(acVar);
        }
    }

    public final void a(boolean z10) {
        this.f40005b = true;
    }
}
