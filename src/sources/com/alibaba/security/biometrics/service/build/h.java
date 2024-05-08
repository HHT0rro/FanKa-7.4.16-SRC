package com.alibaba.security.biometrics.service.build;

import java.util.Timer;
import java.util.TimerTask;

/* compiled from: ABDetectTimerTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public Timer f2758a;

    /* renamed from: b, reason: collision with root package name */
    public int f2759b;

    /* renamed from: c, reason: collision with root package name */
    public a f2760c;

    /* renamed from: d, reason: collision with root package name */
    private int f2761d;

    /* renamed from: e, reason: collision with root package name */
    private int f2762e = 1000;

    /* renamed from: f, reason: collision with root package name */
    private int f2763f = 1000;

    /* compiled from: ABDetectTimerTask.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a();
    }

    public h(int i10) {
        this.f2761d = i10;
        this.f2759b = i10;
    }

    private static /* synthetic */ int a(h hVar) {
        int i10 = hVar.f2759b;
        hVar.f2759b = i10 - 1;
        return i10;
    }

    private static /* synthetic */ int c(h hVar) {
        hVar.f2759b = 0;
        return 0;
    }

    private static /* synthetic */ Timer e(h hVar) {
        hVar.f2758a = null;
        return null;
    }

    private void e() {
        this.f2760c = null;
    }

    public final boolean a() {
        return this.f2759b == 0;
    }

    public final void b() {
        this.f2759b = this.f2761d;
    }

    public final void c() {
        this.f2759b = this.f2761d;
        d();
        Timer timer = new Timer();
        this.f2758a = timer;
        timer.schedule(new TimerTask() { // from class: com.alibaba.security.biometrics.service.build.h.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public final void run() {
                h hVar = h.this;
                int i10 = hVar.f2759b - 1;
                hVar.f2759b = i10;
                if (i10 <= 0) {
                    hVar.f2759b = 0;
                    Timer timer2 = hVar.f2758a;
                    if (timer2 != null) {
                        timer2.cancel();
                        h.this.f2758a = null;
                    }
                }
            }
        }, this.f2762e, this.f2763f);
    }

    public final void d() {
        this.f2759b = this.f2761d;
        Timer timer = this.f2758a;
        if (timer != null) {
            timer.cancel();
            this.f2758a = null;
        }
    }
}
