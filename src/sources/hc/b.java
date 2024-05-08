package hc;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.xiaomi.push.g7;
import com.xiaomi.push.n;
import com.xiaomi.push.p0;
import com.xiaomi.push.q0;
import com.xiaomi.push.r0;
import com.xiaomi.push.s0;
import com.xiaomi.push.t0;
import com.xiaomi.push.w0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b {

    /* renamed from: i, reason: collision with root package name */
    public static final int f49557i;

    /* renamed from: j, reason: collision with root package name */
    public static volatile b f49558j;

    /* renamed from: a, reason: collision with root package name */
    public ExecutorService f49559a = Executors.newSingleThreadExecutor();

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, HashMap<String, gc.d>> f49560b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public HashMap<String, ArrayList<gc.d>> f49561c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public Context f49562d;

    /* renamed from: e, reason: collision with root package name */
    public gc.a f49563e;

    /* renamed from: f, reason: collision with root package name */
    public String f49564f;

    /* renamed from: g, reason: collision with root package name */
    public ic.a f49565g;

    /* renamed from: h, reason: collision with root package name */
    public ic.b f49566h;

    static {
        f49557i = g7.f() ? 30 : 10;
    }

    public b(Context context) {
        this.f49562d = context;
    }

    public static b e(Context context) {
        if (f49558j == null) {
            synchronized (b.class) {
                if (f49558j == null) {
                    f49558j = new b(context);
                }
            }
        }
        return f49558j;
    }

    public final void A() {
        if (e(this.f49562d).c().h()) {
            r0 r0Var = new r0(this.f49562d);
            int e2 = (int) e(this.f49562d).c().e();
            if (e2 < 1800) {
                e2 = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;
            }
            if (System.currentTimeMillis() - w0.b(this.f49562d).a("sp_client_report_status", "perf_last_upload_time", 0L) > e2 * 1000) {
                n.c(this.f49562d).h(new j(this, r0Var), 15);
            }
            synchronized (b.class) {
                if (!n.c(this.f49562d).k(r0Var, e2)) {
                    n.c(this.f49562d).i(100887);
                    n.c(this.f49562d).k(r0Var, e2);
                }
            }
        }
    }

    public final int a() {
        HashMap<String, ArrayList<gc.d>> hashMap = this.f49561c;
        if (hashMap == null) {
            return 0;
        }
        Iterator<String> iterator2 = hashMap.h().iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            ArrayList<gc.d> arrayList = this.f49561c.get(iterator2.next());
            i10 += arrayList != null ? arrayList.size() : 0;
        }
        return i10;
    }

    public synchronized gc.a c() {
        if (this.f49563e == null) {
            this.f49563e = gc.a.a(this.f49562d);
        }
        return this.f49563e;
    }

    public gc.b d(int i10, String str) {
        gc.b bVar = new gc.b();
        bVar.f49444k = str;
        bVar.f49443j = System.currentTimeMillis();
        bVar.f49442i = i10;
        bVar.f49441h = p0.a(6);
        bVar.f49448a = 1000;
        bVar.f49450c = 1001;
        bVar.f49449b = "E100004";
        bVar.a(this.f49562d.getPackageName());
        bVar.b(this.f49564f);
        return bVar;
    }

    public void g() {
        e(this.f49562d).z();
        e(this.f49562d).A();
    }

    public final void h(n.a aVar, int i10) {
        n.c(this.f49562d).n(aVar, i10);
    }

    public void i(gc.a aVar, ic.a aVar2, ic.b bVar) {
        this.f49563e = aVar;
        this.f49565g = aVar2;
        this.f49566h = bVar;
        aVar2.a(this.f49561c);
        this.f49566h.b(this.f49560b);
    }

    public void j(gc.b bVar) {
        if (c().g()) {
            this.f49559a.execute(new c(this, bVar));
        }
    }

    public void k(gc.c cVar) {
        if (c().h()) {
            this.f49559a.execute(new d(this, cVar));
        }
    }

    public void o(String str) {
        this.f49564f = str;
    }

    public void p(boolean z10, boolean z11, long j10, long j11) {
        gc.a aVar = this.f49563e;
        if (aVar != null) {
            if (z10 == aVar.g() && z11 == this.f49563e.h() && j10 == this.f49563e.c() && j11 == this.f49563e.e()) {
                return;
            }
            long c4 = this.f49563e.c();
            long e2 = this.f49563e.e();
            gc.a h10 = gc.a.b().i(t0.b(this.f49562d)).j(this.f49563e.f()).l(z10).k(j10).o(z11).n(j11).h(this.f49562d);
            this.f49563e = h10;
            if (!h10.g()) {
                n.c(this.f49562d).i(100886);
            } else if (c4 != h10.c()) {
                fc.c.m(this.f49562d.getPackageName() + "reset event job " + h10.c());
                z();
            }
            if (!this.f49563e.h()) {
                n.c(this.f49562d).i(100887);
                return;
            }
            if (e2 != h10.e()) {
                fc.c.m(this.f49562d.getPackageName() + "reset perf job " + h10.e());
                A();
            }
        }
    }

    public final int q() {
        HashMap<String, HashMap<String, gc.d>> hashMap = this.f49560b;
        int i10 = 0;
        if (hashMap != null) {
            Iterator<String> iterator2 = hashMap.h().iterator2();
            while (iterator2.hasNext()) {
                HashMap<String, gc.d> hashMap2 = this.f49560b.get(iterator2.next());
                if (hashMap2 != null) {
                    Iterator<String> iterator22 = hashMap2.h().iterator2();
                    while (iterator22.hasNext()) {
                        gc.d dVar = hashMap2.get(iterator22.next());
                        if (dVar instanceof gc.c) {
                            i10 = (int) (i10 + ((gc.c) dVar).f49446i);
                        }
                    }
                }
            }
        }
        return i10;
    }

    public void s() {
        if (c().g()) {
            s0 s0Var = new s0();
            s0Var.a(this.f49562d);
            s0Var.b(this.f49565g);
            this.f49559a.execute(s0Var);
        }
    }

    public final void t(gc.b bVar) {
        ic.a aVar = this.f49565g;
        if (aVar != null) {
            aVar.c(bVar);
            if (a() < 10) {
                h(new e(this), f49557i);
            } else {
                x();
                n.c(this.f49562d).i(100888);
            }
        }
    }

    public final void u(gc.c cVar) {
        ic.b bVar = this.f49566h;
        if (bVar != null) {
            bVar.c(cVar);
            if (q() < 10) {
                h(new g(this), f49557i);
            } else {
                y();
                n.c(this.f49562d).i(100889);
            }
        }
    }

    public void w() {
        if (c().h()) {
            s0 s0Var = new s0();
            s0Var.b(this.f49566h);
            s0Var.a(this.f49562d);
            this.f49559a.execute(s0Var);
        }
    }

    public final void x() {
        try {
            this.f49565g.b();
        } catch (Exception e2) {
            fc.c.n("we: " + e2.getMessage());
        }
    }

    public final void y() {
        try {
            this.f49566h.b();
        } catch (Exception e2) {
            fc.c.n("wp: " + e2.getMessage());
        }
    }

    public final void z() {
        if (e(this.f49562d).c().g()) {
            q0 q0Var = new q0(this.f49562d);
            int c4 = (int) e(this.f49562d).c().c();
            if (c4 < 1800) {
                c4 = AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;
            }
            if (System.currentTimeMillis() - w0.b(this.f49562d).a("sp_client_report_status", "event_last_upload_time", 0L) > c4 * 1000) {
                n.c(this.f49562d).h(new i(this, q0Var), 10);
            }
            synchronized (b.class) {
                if (!n.c(this.f49562d).k(q0Var, c4)) {
                    n.c(this.f49562d).i(100886);
                    n.c(this.f49562d).k(q0Var, c4);
                }
            }
        }
    }
}
