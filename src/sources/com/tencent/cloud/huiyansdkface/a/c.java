package com.tencent.cloud.huiyansdkface.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    private static ExecutorService f40322d = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.tencent.cloud.huiyansdkface.a.c.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "WeCameraThread");
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f40323a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f40325c;

    /* renamed from: e, reason: collision with root package name */
    private e f40326e;

    /* renamed from: f, reason: collision with root package name */
    private Context f40327f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.c.a f40328g;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.g.b f40329h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.a.a f40330i;

    /* renamed from: j, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.c f40331j;

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.a.c f40332k;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.d f40334m;

    /* renamed from: n, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.e.c f40335n;

    /* renamed from: o, reason: collision with root package name */
    private List<com.tencent.cloud.huiyansdkface.a.e.d> f40336o;

    /* renamed from: p, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.e.b f40337p;

    /* renamed from: q, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.a f40338q;

    /* renamed from: r, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.c.d f40339r;

    /* renamed from: s, reason: collision with root package name */
    private long f40340s;

    /* renamed from: b, reason: collision with root package name */
    private boolean f40324b = false;

    /* renamed from: l, reason: collision with root package name */
    private CountDownLatch f40333l = new CountDownLatch(1);

    public c(Context context, com.tencent.cloud.huiyansdkface.a.c.b bVar, com.tencent.cloud.huiyansdkface.a.g.b bVar2, com.tencent.cloud.huiyansdkface.a.a.a.a aVar, com.tencent.cloud.huiyansdkface.a.a.c cVar, com.tencent.cloud.huiyansdkface.a.a.a.c cVar2, b bVar3, com.tencent.cloud.huiyansdkface.a.e.d dVar, boolean z10) {
        this.f40327f = context;
        this.f40325c = z10;
        this.f40328g = bVar.a();
        this.f40329h = bVar2;
        this.f40330i = aVar;
        this.f40331j = cVar;
        this.f40332k = cVar2;
        e eVar = new e();
        this.f40326e = eVar;
        eVar.a(bVar3);
        ArrayList arrayList = new ArrayList();
        this.f40336o = arrayList;
        if (dVar != null) {
            arrayList.add(dVar);
        }
        a((b) new a() { // from class: com.tencent.cloud.huiyansdkface.a.c.3
            @Override // com.tencent.cloud.huiyansdkface.a.a, com.tencent.cloud.huiyansdkface.a.b
            public void a(com.tencent.cloud.huiyansdkface.a.c.a aVar2, com.tencent.cloud.huiyansdkface.a.c.d dVar2, com.tencent.cloud.huiyansdkface.a.a.a aVar3) {
                c.this.f40334m = dVar2.b();
                c.this.f40333l.countDown();
            }
        });
        this.f40329h.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f40323a) {
            com.tencent.cloud.huiyansdkface.a.d.a.a("WeCamera", "weCamera has started", new Object[0]);
            return;
        }
        com.tencent.cloud.huiyansdkface.a.d.a.a("WeCamera", "execute start camera task.", new Object[0]);
        this.f40340s = System.currentTimeMillis();
        com.tencent.cloud.huiyansdkface.a.c.d a10 = this.f40328g.a(this.f40330i);
        if (a10 == null) {
            return;
        }
        this.f40339r = a10;
        this.f40323a = true;
        this.f40338q = this.f40328g.a(this.f40331j);
        this.f40328g.a(this.f40331j.b(), com.tencent.cloud.huiyansdkface.a.f.a.a(this.f40327f));
        com.tencent.cloud.huiyansdkface.a.e.b d10 = this.f40328g.d();
        this.f40337p = d10;
        this.f40338q.a(d10);
        this.f40326e.a(this.f40328g, a10, this.f40338q);
        com.tencent.cloud.huiyansdkface.a.g.b bVar = this.f40329h;
        if (bVar != null) {
            bVar.a(this.f40332k, g());
        }
        this.f40335n = this.f40328g.e();
        if (this.f40336o.size() > 0) {
            for (int i10 = 0; i10 < this.f40336o.size(); i10++) {
                this.f40335n.a(this.f40336o.get(i10));
            }
            this.f40335n.b();
            this.f40324b = true;
        }
        if (this.f40325c) {
            com.tencent.cloud.huiyansdkface.a.g.b bVar2 = this.f40329h;
            if (bVar2 != null) {
                bVar2.a(this, (com.tencent.cloud.huiyansdkface.a.c.a.a) a10, true);
                return;
            }
            return;
        }
        com.tencent.cloud.huiyansdkface.a.g.b bVar3 = this.f40329h;
        if (bVar3 == null || bVar3.a(this, (com.tencent.cloud.huiyansdkface.a.c.a.a) a10, false)) {
            return;
        }
        com.tencent.cloud.huiyansdkface.a.d.a.b("WeCamera", "attachCameraView result=false", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        com.tencent.cloud.huiyansdkface.a.d.a.a("WeCamera", "execute stop preview callback task.", new Object[0]);
        if (a() && this.f40324b && this.f40335n != null) {
            com.tencent.cloud.huiyansdkface.a.d.a.b("WeCamera", "stop Preview Callback", new Object[0]);
            this.f40324b = false;
            this.f40335n.c();
        }
    }

    public c a(b bVar) {
        this.f40326e.a(bVar);
        return this;
    }

    public c a(Runnable runnable) {
        if (runnable != null) {
            f40322d.submit(runnable);
        }
        return this;
    }

    public void a(Object obj) {
        this.f40328g.a(obj);
        c();
        this.f40329h.a();
        com.tencent.cloud.huiyansdkface.a.d.a.a("WeCamera", "start useTime:" + (System.currentTimeMillis() - this.f40340s), new Object[0]);
    }

    public boolean a() {
        return this.f40323a;
    }

    public c b(b bVar) {
        this.f40326e.b(bVar);
        return this;
    }

    public void b() {
        if (this.f40325c) {
            h();
        } else {
            f40322d.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.a.c.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.h();
                }
            });
        }
    }

    public void c() {
        this.f40326e.a(this.f40329h, this.f40338q, this.f40337p, this.f40339r);
        this.f40328g.b();
        this.f40326e.a(this.f40328g);
    }

    public void d() {
        f();
        if (this.f40325c) {
            e();
        } else {
            f40322d.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.a.c.5
                @Override // java.lang.Runnable
                public void run() {
                    c.this.e();
                }
            });
        }
    }

    public void e() {
        if (!this.f40323a) {
            com.tencent.cloud.huiyansdkface.a.d.a.a("WeCamera", "weCamera has stopped", new Object[0]);
            return;
        }
        com.tencent.cloud.huiyansdkface.a.d.a.a("WeCamera", "execute stop camera task.", new Object[0]);
        this.f40326e.b(this.f40328g);
        this.f40328g.c();
        this.f40323a = false;
        this.f40328g.a();
        this.f40326e.a();
    }

    public void f() {
        if (this.f40325c) {
            i();
        } else {
            f40322d.submit(new Runnable() { // from class: com.tencent.cloud.huiyansdkface.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    c.this.i();
                }
            });
        }
    }

    public com.tencent.cloud.huiyansdkface.a.e.b g() {
        return this.f40328g.d();
    }
}
