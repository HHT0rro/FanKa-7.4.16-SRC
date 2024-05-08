package id;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tanx.exposer.achieve.AdMonitorType;
import com.tanx.exposer.achieve.retry.AdMonitorRetryType;
import com.tanx.exposer.framework.connectivity.tanxc_do;
import hd.a;
import hd.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import jd.a;
import kd.a;
import rc.e;
import rc.f;
import vc.d;

/* compiled from: AdMonitorRetryManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public Context f49877a;

    /* renamed from: b, reason: collision with root package name */
    public e f49878b;

    /* renamed from: c, reason: collision with root package name */
    public id.a f49879c;

    /* renamed from: d, reason: collision with root package name */
    public C0751b f49880d = new C0751b();

    /* renamed from: e, reason: collision with root package name */
    public AtomicInteger f49881e = new AtomicInteger(0);

    /* renamed from: f, reason: collision with root package name */
    public boolean f49882f = true;

    /* renamed from: g, reason: collision with root package name */
    public final tanxc_do.a f49883g = new a();

    /* renamed from: h, reason: collision with root package name */
    public int f49884h = 3;

    /* renamed from: i, reason: collision with root package name */
    public ConcurrentLinkedQueue<gd.a> f49885i = new ConcurrentLinkedQueue<>();

    /* compiled from: AdMonitorRetryManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements tanxc_do.a {
        public a() {
        }

        @Override // com.tanx.exposer.framework.connectivity.tanxc_do.a
        public void a(int i10) {
            b bVar = b.this;
            boolean z10 = i10 != -1;
            bVar.f49882f = z10;
            if (z10 && bVar.f49878b.f() != null && b.this.f49878b.f().d()) {
                b.this.a();
            }
        }
    }

    /* compiled from: AdMonitorRetryManager.java */
    /* renamed from: id.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class C0751b {
    }

    /* compiled from: AdMonitorRetryManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static final b f49887a = new b();
    }

    public synchronized void a() {
        this.f49880d.getClass();
        int i10 = 5 - this.f49881e.get();
        rc.b.a("AdRetryExposeManager", "availableRetryCount=" + i10);
        if (i10 <= 0) {
            return;
        }
        if (this.f49885i.size() <= 0) {
            return;
        }
        rc.b.a("AdRetryExposeManager", "failedRequestQueue.size=" + this.f49885i.size());
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i11 = i10 - 1;
            if (i10 <= 0) {
                break;
            }
            gd.a poll = this.f49885i.poll();
            if (poll != null) {
                arrayList.add(poll);
                e();
                this.f49879c.a(poll.f49455a);
            }
            i10 = i11;
        }
        Iterator iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            g((gd.a) iterator2.next(), true);
        }
    }

    public void b(gd.a aVar, int i10, String str, boolean z10) {
        String str2;
        if (aVar == null) {
            return;
        }
        if (z10) {
            this.f49881e.decrementAndGet();
        } else {
            aVar.f49466l = AdMonitorRetryType.NONE;
            f fVar = aVar.f49461g;
            a.C0773a.f50879a.a("TanxExposer", "EXPOSER_SUCCESS_POINT", String.valueOf(i10), str, fVar == null ? "" : fVar.toString());
        }
        String name = aVar.f49466l.name();
        AdMonitorType adMonitorType = aVar.f49459e;
        if (adMonitorType == null) {
            rc.b.a("exposeRequestFail", "wrapper is null");
        } else {
            if (adMonitorType == AdMonitorType.CLICK) {
                str2 = "tanx_click_request_fail";
            } else {
                str2 = adMonitorType == AdMonitorType.EXPOSE ? "tanx_expose_request_fail" : "tanx_interact_request_fail";
            }
            f fVar2 = aVar.f49461g;
            if (fVar2 == null) {
                rc.b.a(str2, "AdMonitorExtraParams is null");
            } else {
                Map<String, Object> f10 = rc.d.f(fVar2);
                f10.put("host", aVar.f49458d);
                f10.put("url_hash", aVar.f49460f);
                f10.put("isRetry", String.valueOf(z10));
                f10.put("retryType", name);
                f10.put("url", aVar.f49456b);
                f10.put("errorCode", String.valueOf(i10));
                f10.put("errorMsg", str);
                ld.b.b(str2, f10, false);
            }
        }
        e();
        if (d(aVar)) {
            if (this.f49885i.contains(aVar)) {
                return;
            }
            h();
            this.f49885i.add(aVar);
            id.a aVar2 = this.f49879c;
            synchronized (aVar2) {
                SQLiteDatabase writableDatabase = aVar2.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("monitor_type", aVar.f49459e.name());
                contentValues.put("monitor_url", aVar.f49456b);
                contentValues.put("monitor_original_url", aVar.f49457c);
                contentValues.put("monitor_url_host", aVar.f49458d);
                contentValues.put("monitor_url_hash", aVar.f49460f);
                f fVar3 = aVar.f49461g;
                if (fVar3 != null) {
                    contentValues.put("monitor_extra_params", fVar3.toString());
                }
                contentValues.put("retry_times", Integer.valueOf(aVar.f49463i.intValue()));
                contentValues.put("max_retry_times", Integer.valueOf(aVar.f49462h));
                contentValues.put("date", aVar.f49465k);
                contentValues.put("expire_time", Long.valueOf(aVar.f49464j));
                long insert = writableDatabase.insert("retry_monitor_info", null, contentValues);
                aVar.f49455a = insert;
                if (rc.b.f53376a) {
                    rc.b.a("RetryMonitorDbHelper", "insert: index = " + insert + ", exposeDate = " + aVar.f49465k);
                }
            }
            f(aVar, i10, str, true);
            return;
        }
        f(aVar, i10, str, false);
    }

    public void c(gd.a aVar, boolean z10) {
        String str;
        if (z10) {
            this.f49881e.decrementAndGet();
        }
        if (aVar == null) {
            return;
        }
        if (!z10) {
            aVar.f49466l = AdMonitorRetryType.NONE;
            f fVar = aVar.f49461g;
            a.C0773a.f50879a.b("TanxExposer", "EXPOSER_SUCCESS_POINT", fVar == null ? "" : fVar.toString());
        }
        String name = aVar.f49466l.name();
        AdMonitorType adMonitorType = aVar.f49459e;
        if (adMonitorType == null) {
            rc.b.a("exposeRequestSuccess", "wrapper is null");
        } else {
            if (adMonitorType == AdMonitorType.CLICK) {
                str = "tanx_click_request_success";
            } else {
                str = adMonitorType == AdMonitorType.EXPOSE ? "tanx_expose_request_success" : "tanx_interact_request_success";
            }
            f fVar2 = aVar.f49461g;
            if (fVar2 == null) {
                rc.b.a(str, "AdMonitorExtraParams is null");
            } else {
                Map<String, Object> f10 = rc.d.f(fVar2);
                f10.put("host", aVar.f49458d);
                f10.put("url_hash", aVar.f49460f);
                f10.put("isRetry", String.valueOf(z10));
                f10.put("retryType", name);
                ld.b.b(str, f10, false);
            }
        }
        jd.a c4 = e.a.f53381a.c();
        if (c4 != null && aVar.f49466l != AdMonitorRetryType.DB) {
            String str2 = aVar.f49457c;
            AdMonitorType adMonitorType2 = aVar.f49459e;
            f fVar3 = aVar.f49461g;
            if (c4.f50560a != null) {
                c4.a().post(new a.RunnableC0768a(str2, adMonitorType2, fVar3));
            }
        }
        a();
    }

    public boolean d(gd.a aVar) {
        rc.a f10 = this.f49878b.f();
        return f10 != null && f10.g() && f10.a().contains(aVar.f49459e) && aVar.f49462h > 0 && aVar.f49463i.get() < aVar.f49462h;
    }

    public final synchronized void e() {
        if (this.f49879c == null) {
            this.f49879c = new id.a(this.f49877a);
        }
    }

    public final void f(gd.a aVar, int i10, String str, boolean z10) {
        jd.a c4 = e.a.f53381a.c();
        if (c4 == null || aVar.f49466l == AdMonitorRetryType.DB) {
            return;
        }
        if (z10) {
            String str2 = aVar.f49457c;
            AdMonitorType adMonitorType = aVar.f49459e;
            f fVar = aVar.f49461g;
            if (c4.f50560a != null) {
                c4.a().post(new a.c(i10, str, str2, adMonitorType, fVar));
                return;
            }
            return;
        }
        String str3 = aVar.f49457c;
        AdMonitorType adMonitorType2 = aVar.f49459e;
        f fVar2 = aVar.f49461g;
        if (c4.f50560a != null) {
            c4.a().post(new a.b(i10, str, str3, adMonitorType2, fVar2));
        }
    }

    public final void g(gd.a aVar, boolean z10) {
        vc.c bVar;
        if (aVar == null) {
            return;
        }
        if (z10) {
            aVar.f49463i.incrementAndGet();
            this.f49881e.incrementAndGet();
        }
        vc.a h10 = this.f49878b.f().h();
        if (aVar.f49459e == AdMonitorType.EXPOSE) {
            bVar = new b.C0747b(aVar, z10);
        } else {
            bVar = new a.b(aVar, z10);
        }
        h10.a(new d.a(aVar.f49456b).f(20000).h(30000).b(3).c("User-Agent", rc.d.a()).d(), bVar);
    }

    public final void h() {
        int size = this.f49885i.size();
        this.f49880d.getClass();
        if (size < 500) {
            return;
        }
        int size2 = this.f49885i.size();
        this.f49880d.getClass();
        ArrayList arrayList = new ArrayList(size2 - 500);
        while (true) {
            int size3 = this.f49885i.size();
            this.f49880d.getClass();
            if (size3 < 500) {
                break;
            }
            gd.a poll = this.f49885i.poll();
            if (poll != null) {
                arrayList.add(poll);
                e();
                this.f49879c.a(poll.f49455a);
            }
        }
        Iterator iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            f((gd.a) iterator2.next(), -2, "retry fail,exceed max retry count", false);
        }
    }
}
