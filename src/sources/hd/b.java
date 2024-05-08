package hd;

import android.net.Uri;
import android.text.TextUtils;
import com.tanx.exposer.achieve.AdMonitorCommitResult;
import com.tanx.exposer.achieve.AdMonitorType;
import hd.a;
import id.b;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import rc.d;
import rc.f;
import vc.d;

/* compiled from: ExposeCommitter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b extends hd.a {

    /* renamed from: e, reason: collision with root package name */
    public static Queue<String> f49593e = new ConcurrentLinkedQueue();

    /* renamed from: f, reason: collision with root package name */
    public static Map<String, gd.a> f49594f = new ConcurrentHashMap();

    /* compiled from: ExposeCommitter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f49595b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f49596c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f49597d;

        public a(String str, String str2, String str3) {
            this.f49595b = str;
            this.f49596c = str2;
            this.f49597d = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            String str = this.f49595b;
            String str2 = this.f49596c;
            String str3 = this.f49597d;
            bVar.getClass();
            if (b.f49593e.contains(str3)) {
                f fVar = bVar.f49581c;
                if (fVar == null) {
                    rc.b.a("tanx_expose_request_duplicated", "AdMonitorExtraParams is null");
                    return;
                } else {
                    ld.b.b("tanx_expose_request_duplicated", d.f(fVar), true);
                    return;
                }
            }
            gd.a aVar = b.f49594f.get(str3);
            if (aVar != null) {
                id.b bVar2 = b.c.f49887a;
                bVar2.getClass();
                if (bVar2.f49885i.contains(aVar) && bVar2.f49885i.remove(aVar)) {
                    bVar2.g(aVar, false);
                }
                f fVar2 = bVar.f49581c;
                if (fVar2 != null) {
                    rc.b.d("tanx_expose_request_pending", fVar2.toString());
                    return;
                }
                return;
            }
            md.b.b(bVar.f49581c, bVar.f49580b, str2, str3);
            f fVar3 = bVar.f49581c;
            String d10 = fVar3 == null ? str : d.d(str, fVar3.b());
            gd.a aVar2 = new gd.a(str, d10, bVar.f49580b, str2, str3, bVar.f49582d.f());
            aVar2.f49461g = bVar.f49581c;
            bVar.f49582d.h().a(new d.a(d10).f(20000).h(30000).b(3).c("User-Agent", rc.d.a()).d(), new C0747b(aVar2, false));
            b.f49594f.put(str3, aVar2);
        }
    }

    /* compiled from: ExposeCommitter.java */
    /* renamed from: hd.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class C0747b extends a.b {

        /* compiled from: ExposeCommitter.java */
        /* renamed from: hd.b$b$a */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                id.b bVar = b.c.f49887a;
                C0747b c0747b = C0747b.this;
                bVar.c(c0747b.f49588b, c0747b.f49587a);
                b.f49594f.remove(C0747b.this.f49588b.f49460f);
                if (b.f49593e.size() >= 1000) {
                    b.f49593e.poll();
                }
                b.f49593e.offer(C0747b.this.f49588b.f49460f);
            }
        }

        /* compiled from: ExposeCommitter.java */
        /* renamed from: hd.b$b$b, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class RunnableC0748b implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f49600b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f49601c;

            public RunnableC0748b(int i10, String str) {
                this.f49600b = i10;
                this.f49601c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                id.b bVar = b.c.f49887a;
                C0747b c0747b = C0747b.this;
                bVar.b(c0747b.f49588b, this.f49600b, this.f49601c, c0747b.f49587a);
                if (bVar.d(C0747b.this.f49588b)) {
                    return;
                }
                b.f49594f.remove(C0747b.this.f49588b.f49460f);
            }
        }

        public C0747b(gd.a aVar, boolean z10) {
            super(aVar, z10);
        }

        @Override // hd.a.b, vc.c
        public void a(int i10, String str) {
            ld.b.a(new RunnableC0748b(i10, str), 0L);
        }

        @Override // hd.a.b, vc.c
        public void tanxc_do() {
            ld.b.a(new a(), 0L);
        }
    }

    public b(AdMonitorType adMonitorType, List<String> list, f fVar) {
        super(adMonitorType, list, fVar);
    }

    @Override // hd.a
    public AdMonitorCommitResult a() {
        for (String str : this.f49579a) {
            String c4 = rc.d.c(str);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(c4)) {
                String host = Uri.parse(str).getHost();
                if (TextUtils.isEmpty(host)) {
                    md.b.c(this.f49581c, this.f49580b, "domain_not_right");
                } else if (f49593e.contains(c4)) {
                    f fVar = this.f49581c;
                    if (fVar == null) {
                        rc.b.a("tanx_expose_request_duplicated", "AdMonitorExtraParams is null");
                    } else {
                        ld.b.b("tanx_expose_request_duplicated", rc.d.f(fVar), true);
                    }
                } else {
                    ld.b.a(new a(str, host, c4), 0L);
                }
            } else {
                md.b.c(this.f49581c, this.f49580b, "url_is_empty_or_hash_error");
            }
        }
        return AdMonitorCommitResult.COMMITED;
    }
}
