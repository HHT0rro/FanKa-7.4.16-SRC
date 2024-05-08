package hd;

import android.net.Uri;
import android.text.TextUtils;
import com.tanx.exposer.achieve.AdMonitorCommitResult;
import com.tanx.exposer.achieve.AdMonitorType;
import id.b;
import java.util.List;
import rc.d;
import rc.e;
import rc.f;
import vc.c;
import vc.d;

/* compiled from: CommonCommitter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public List<String> f49579a;

    /* renamed from: b, reason: collision with root package name */
    public AdMonitorType f49580b;

    /* renamed from: c, reason: collision with root package name */
    public f f49581c;

    /* renamed from: d, reason: collision with root package name */
    public rc.a f49582d = e.a.f53381a.f();

    /* compiled from: CommonCommitter.java */
    /* renamed from: hd.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class RunnableC0744a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f49583b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f49584c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f49585d;

        public RunnableC0744a(String str, String str2, String str3) {
            this.f49583b = str;
            this.f49584c = str2;
            this.f49585d = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            String str = this.f49583b;
            String str2 = this.f49584c;
            String str3 = this.f49585d;
            f fVar = aVar.f49581c;
            String d10 = fVar == null ? str : d.d(str, fVar.b());
            md.b.b(aVar.f49581c, aVar.f49580b, str2, str3);
            gd.a aVar2 = new gd.a(str, d10, aVar.f49580b, str2, str3, aVar.f49582d.f());
            aVar2.f49461g = aVar.f49581c;
            aVar.f49582d.h().a(new d.a(d10).f(20000).h(30000).b(3).c("User-Agent", rc.d.a()).d(), new b(aVar2, false));
        }
    }

    /* compiled from: CommonCommitter.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f49587a;

        /* renamed from: b, reason: collision with root package name */
        public gd.a f49588b;

        /* compiled from: CommonCommitter.java */
        /* renamed from: hd.a$b$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class RunnableC0745a implements Runnable {
            public RunnableC0745a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                id.b bVar = b.c.f49887a;
                b bVar2 = b.this;
                bVar.c(bVar2.f49588b, bVar2.f49587a);
            }
        }

        /* compiled from: CommonCommitter.java */
        /* renamed from: hd.a$b$b, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public class RunnableC0746b implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f49590b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f49591c;

            public RunnableC0746b(int i10, String str) {
                this.f49590b = i10;
                this.f49591c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                id.b bVar = b.c.f49887a;
                b bVar2 = b.this;
                bVar.b(bVar2.f49588b, this.f49590b, this.f49591c, bVar2.f49587a);
            }
        }

        public b(gd.a aVar, boolean z10) {
            this.f49588b = aVar;
            this.f49587a = z10;
        }

        @Override // vc.c
        public void a(int i10, String str) {
            ld.b.a(new RunnableC0746b(i10, str), 0L);
        }

        @Override // vc.c
        public void tanxc_do() {
            ld.b.a(new RunnableC0745a(), 0L);
        }
    }

    public a(AdMonitorType adMonitorType, List<String> list, f fVar) {
        this.f49580b = adMonitorType;
        this.f49579a = list;
        this.f49581c = fVar;
    }

    public AdMonitorCommitResult a() {
        for (String str : this.f49579a) {
            String c4 = rc.d.c(str);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(c4)) {
                String host = Uri.parse(str).getHost();
                if (TextUtils.isEmpty(host)) {
                    md.b.c(this.f49581c, this.f49580b, "domain_not_right");
                } else {
                    ld.b.a(new RunnableC0744a(str, host, c4), 0L);
                }
            } else {
                md.b.c(this.f49581c, this.f49580b, "url_is_empty_or_hash_error");
            }
        }
        return AdMonitorCommitResult.COMMITED;
    }
}
