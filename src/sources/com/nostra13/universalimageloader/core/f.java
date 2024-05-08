package com.nostra13.universalimageloader.core;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: ImageLoaderEngine.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final e f37855a;

    /* renamed from: b, reason: collision with root package name */
    public Executor f37856b;

    /* renamed from: c, reason: collision with root package name */
    public Executor f37857c;

    /* renamed from: e, reason: collision with root package name */
    public final Map<Integer, String> f37859e = Collections.synchronizedMap(new HashMap());

    /* renamed from: f, reason: collision with root package name */
    public final Map<String, ReentrantLock> f37860f = new WeakHashMap();

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f37861g = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f37862h = new AtomicBoolean(false);

    /* renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f37863i = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    public final Object f37864j = new Object();

    /* renamed from: d, reason: collision with root package name */
    public Executor f37858d = com.nostra13.universalimageloader.core.a.i();

    /* compiled from: ImageLoaderEngine.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LoadAndDisplayImageTask f37865b;

        public a(LoadAndDisplayImageTask loadAndDisplayImageTask) {
            this.f37865b = loadAndDisplayImageTask;
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = f.this.f37855a.f37821o.get(this.f37865b.m());
            boolean z10 = file != null && file.exists();
            f.this.k();
            if (z10) {
                f.this.f37857c.execute(this.f37865b);
            } else {
                f.this.f37856b.execute(this.f37865b);
            }
        }
    }

    public f(e eVar) {
        this.f37855a = eVar;
        this.f37856b = eVar.f37813g;
        this.f37857c = eVar.f37814h;
    }

    public void d(mb.a aVar) {
        this.f37859e.remove(Integer.valueOf(aVar.getId()));
    }

    public final Executor e() {
        e eVar = this.f37855a;
        return com.nostra13.universalimageloader.core.a.c(eVar.f37817k, eVar.f37818l, eVar.f37819m);
    }

    public void f(Runnable runnable) {
        this.f37858d.execute(runnable);
    }

    public String g(mb.a aVar) {
        return this.f37859e.get(Integer.valueOf(aVar.getId()));
    }

    public ReentrantLock h(String str) {
        ReentrantLock reentrantLock = this.f37860f.get(str);
        if (reentrantLock != null) {
            return reentrantLock;
        }
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.f37860f.put(str, reentrantLock2);
        return reentrantLock2;
    }

    public AtomicBoolean i() {
        return this.f37861g;
    }

    public Object j() {
        return this.f37864j;
    }

    public final void k() {
        if (!this.f37855a.f37815i && ((ExecutorService) this.f37856b).isShutdown()) {
            this.f37856b = e();
        }
        if (this.f37855a.f37816j || !((ExecutorService) this.f37857c).isShutdown()) {
            return;
        }
        this.f37857c = e();
    }

    public boolean l() {
        return this.f37862h.get();
    }

    public boolean m() {
        return this.f37863i.get();
    }

    public void n(mb.a aVar, String str) {
        this.f37859e.put(Integer.valueOf(aVar.getId()), str);
    }

    public void o(LoadAndDisplayImageTask loadAndDisplayImageTask) {
        this.f37858d.execute(new a(loadAndDisplayImageTask));
    }

    public void p(h hVar) {
        k();
        this.f37857c.execute(hVar);
    }
}
