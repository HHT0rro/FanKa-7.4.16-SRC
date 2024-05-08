package com.tencent.bugly.idasc.proguard;

import android.os.Handler;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f39743a;

    /* renamed from: d, reason: collision with root package name */
    public long f39746d;

    /* renamed from: e, reason: collision with root package name */
    private final String f39747e;

    /* renamed from: f, reason: collision with root package name */
    private final List<ba> f39748f = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    public long f39744b = 5000;

    /* renamed from: g, reason: collision with root package name */
    private final long f39749g = 5000;

    /* renamed from: c, reason: collision with root package name */
    public boolean f39745c = true;

    public bf(Handler handler, String str) {
        this.f39743a = handler;
        this.f39747e = str;
    }

    private Thread e() {
        return this.f39743a.getLooper().getThread();
    }

    public final boolean a() {
        return !this.f39745c && SystemClock.uptimeMillis() >= this.f39746d + this.f39744b;
    }

    public final long b() {
        return SystemClock.uptimeMillis() - this.f39746d;
    }

    public final List<ba> c() {
        ArrayList arrayList;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f39748f) {
            arrayList = new ArrayList(this.f39748f.size());
            for (int i10 = 0; i10 < this.f39748f.size(); i10++) {
                ba baVar = this.f39748f.get(i10);
                if (!baVar.f39724e && currentTimeMillis - baVar.f39721b < 200000) {
                    arrayList.add(baVar);
                    baVar.f39724e = true;
                }
            }
        }
        return arrayList;
    }

    public final void d() {
        StringBuilder sb2 = new StringBuilder(1024);
        long nanoTime = System.nanoTime();
        try {
            StackTraceElement[] stackTrace = e().getStackTrace();
            if (stackTrace.length == 0) {
                sb2.append("Thread does not have stack trace.\n");
            } else {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb2.append((Object) stackTraceElement);
                    sb2.append("\n");
                }
            }
        } catch (SecurityException e2) {
            sb2.append("getStackTrace() encountered:\n");
            sb2.append(e2.getMessage());
            sb2.append("\n");
            al.a(e2);
        }
        long nanoTime2 = System.nanoTime();
        ba baVar = new ba(sb2.toString(), System.currentTimeMillis());
        baVar.f39723d = nanoTime2 - nanoTime;
        String name = e().getName();
        if (name == null) {
            name = "";
        }
        baVar.f39720a = name;
        synchronized (this.f39748f) {
            while (this.f39748f.size() >= 32) {
                this.f39748f.remove(0);
            }
            this.f39748f.add(baVar);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f39745c = true;
        this.f39744b = this.f39749g;
    }
}
