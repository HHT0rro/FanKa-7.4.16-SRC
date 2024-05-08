package com.tencent.cloud.huiyansdkface.a;

import android.content.Context;
import com.tencent.cloud.huiyansdkface.a.a.g;
import com.tencent.cloud.huiyansdkface.a.d.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private Context f40394a;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.g.b f40399f;

    /* renamed from: m, reason: collision with root package name */
    private g<com.tencent.cloud.huiyansdkface.a.a.a.b> f40406m;

    /* renamed from: o, reason: collision with root package name */
    private b f40408o;

    /* renamed from: q, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.f f40410q;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.c.b f40395b = com.tencent.cloud.huiyansdkface.a.c.c.a();

    /* renamed from: c, reason: collision with root package name */
    private boolean f40396c = false;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.a.c f40397d = com.tencent.cloud.huiyansdkface.a.a.a.c.CROP_CENTER;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.a.a f40398e = com.tencent.cloud.huiyansdkface.a.a.a.a.BACK;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.e.d f40400g = null;

    /* renamed from: h, reason: collision with root package name */
    private g<String> f40401h = com.tencent.cloud.huiyansdkface.a.a.b.b.a(com.tencent.cloud.huiyansdkface.a.a.b.b.d(), com.tencent.cloud.huiyansdkface.a.a.b.b.b(), com.tencent.cloud.huiyansdkface.a.a.b.b.c(), com.tencent.cloud.huiyansdkface.a.a.b.b.a());

    /* renamed from: i, reason: collision with root package name */
    private g<String> f40402i = com.tencent.cloud.huiyansdkface.a.a.b.b.a(com.tencent.cloud.huiyansdkface.a.a.b.c.c(), com.tencent.cloud.huiyansdkface.a.a.b.c.b(), com.tencent.cloud.huiyansdkface.a.a.b.c.a());

    /* renamed from: j, reason: collision with root package name */
    private g<com.tencent.cloud.huiyansdkface.a.a.a.d> f40403j = com.tencent.cloud.huiyansdkface.a.a.b.f.a();

    /* renamed from: k, reason: collision with root package name */
    private g<com.tencent.cloud.huiyansdkface.a.a.a.d> f40404k = com.tencent.cloud.huiyansdkface.a.a.b.f.a();

    /* renamed from: l, reason: collision with root package name */
    private g<com.tencent.cloud.huiyansdkface.a.a.a.d> f40405l = com.tencent.cloud.huiyansdkface.a.a.b.f.a();

    /* renamed from: n, reason: collision with root package name */
    private float f40407n = -1.0f;

    /* renamed from: p, reason: collision with root package name */
    private List<com.tencent.cloud.huiyansdkface.a.a.e> f40409p = new ArrayList();

    public d(Context context) {
        this.f40394a = context;
    }

    public c a() {
        com.tencent.cloud.huiyansdkface.a.d.a.a("WeCamera", "wecamera version:release_1.0.41.14", new Object[0]);
        com.tencent.cloud.huiyansdkface.a.a.c a10 = new com.tencent.cloud.huiyansdkface.a.a.c().a(this.f40403j).b(this.f40404k).c(this.f40405l).d(this.f40401h).e(this.f40402i).f(this.f40406m).a(this.f40409p).a(this.f40410q);
        float f10 = this.f40407n;
        if (f10 >= 0.0f && f10 <= 1.0f) {
            a10.a(f10);
        }
        return new c(this.f40394a, this.f40395b, this.f40399f, this.f40398e, a10, this.f40397d, this.f40408o, this.f40400g, this.f40396c);
    }

    public d a(com.tencent.cloud.huiyansdkface.a.a.a.a aVar) {
        if (aVar == null) {
            aVar = com.tencent.cloud.huiyansdkface.a.a.a.a.FRONT;
        }
        this.f40398e = aVar;
        return this;
    }

    public d a(com.tencent.cloud.huiyansdkface.a.a.a.c cVar) {
        if (cVar != null) {
            this.f40397d = cVar;
        }
        return this;
    }

    public d a(com.tencent.cloud.huiyansdkface.a.a.e eVar) {
        if (eVar != null && !this.f40409p.contains(eVar)) {
            this.f40409p.add(eVar);
        }
        return this;
    }

    public d a(g<String> gVar) {
        if (gVar != null) {
            this.f40402i = gVar;
        }
        return this;
    }

    public d a(com.tencent.cloud.huiyansdkface.a.b.a aVar) {
        if (aVar != null) {
            com.tencent.cloud.huiyansdkface.a.b.b.a(aVar);
        }
        return this;
    }

    public d a(com.tencent.cloud.huiyansdkface.a.c.b bVar) {
        if (bVar != null) {
            this.f40395b = bVar;
        }
        return this;
    }

    public d a(a.c cVar) {
        if (cVar != null) {
            com.tencent.cloud.huiyansdkface.a.d.a.a(cVar);
        }
        return this;
    }

    public d a(com.tencent.cloud.huiyansdkface.a.e.d dVar) {
        this.f40400g = dVar;
        return this;
    }

    public d a(com.tencent.cloud.huiyansdkface.a.g.b bVar) {
        if (bVar != null) {
            this.f40399f = bVar;
        }
        return this;
    }

    public d a(boolean z10) {
        this.f40396c = z10;
        return this;
    }

    public d b(g<com.tencent.cloud.huiyansdkface.a.a.a.d> gVar) {
        if (gVar != null) {
            this.f40403j = gVar;
        }
        return this;
    }

    public d c(g<com.tencent.cloud.huiyansdkface.a.a.a.b> gVar) {
        if (gVar != null) {
            this.f40406m = gVar;
        }
        return this;
    }
}
