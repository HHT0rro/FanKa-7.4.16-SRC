package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.p0003l.gz;
import com.huawei.hms.framework.common.ExceptionCode;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: AMapLogManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gf {

    /* renamed from: a, reason: collision with root package name */
    private Context f6053a;

    /* renamed from: b, reason: collision with root package name */
    private fu f6054b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6055c = true;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6056d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6057e = true;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6058f = false;

    /* renamed from: g, reason: collision with root package name */
    private List<String> f6059g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private gh f6060h = new gh((byte) 0);

    /* renamed from: i, reason: collision with root package name */
    private gh f6061i = new gh();

    /* renamed from: j, reason: collision with root package name */
    private gz.a f6062j = new gz.a() { // from class: com.amap.api.col.3l.gf.1
        @Override // com.amap.api.col.3l.gz.a
        public final void a(int i10) {
            if (i10 > 0 && gf.a(gf.this) != null) {
                ((gg) gf.this.c().f6455f).a(i10);
                gf.a(gf.this, "error", String.valueOf(((gg) gf.this.c().f6455f).b()));
                gf.a(gf.this).postDelayed(new Runnable() { // from class: com.amap.api.col.3l.gf.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        gf.this.c(false);
                    }
                }, 660000L);
            }
        }
    };

    /* renamed from: k, reason: collision with root package name */
    private gz.a f6063k = new gz.a() { // from class: com.amap.api.col.3l.gf.2
        @Override // com.amap.api.col.3l.gz.a
        public final void a(int i10) {
            if (i10 <= 0) {
                return;
            }
            ((gg) gf.this.e().f6455f).a(i10);
            gf.a(gf.this, "info", String.valueOf(((gg) gf.this.e().f6455f).b()));
            if (gf.a(gf.this) == null) {
                return;
            }
            gf.a(gf.this).postDelayed(new Runnable() { // from class: com.amap.api.col.3l.gf.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    gf.this.d(false);
                }
            }, 660000L);
        }
    };

    /* renamed from: l, reason: collision with root package name */
    private Handler f6064l = null;

    /* renamed from: m, reason: collision with root package name */
    private ig f6065m = null;

    /* renamed from: n, reason: collision with root package name */
    private ig f6066n = null;

    /* compiled from: AMapLogManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static Map<String, gf> f6071a = new HashMap();
    }

    private gf(fu fuVar) {
        this.f6054b = fuVar;
    }

    public static gf a(fu fuVar) {
        if (fuVar == null || TextUtils.isEmpty(fuVar.a())) {
            return null;
        }
        if (a.f6071a.get(fuVar.a()) == null) {
            a.f6071a.put(fuVar.a(), new gf(fuVar));
        }
        return a.f6071a.get(fuVar.a());
    }

    private ig f() {
        if (this.f6053a == null) {
            return null;
        }
        ig igVar = new ig();
        this.f6065m = igVar;
        igVar.f6450a = g();
        ig igVar2 = this.f6065m;
        igVar2.f6451b = 512000000L;
        igVar2.f6453d = 12500;
        igVar2.f6452c = "1";
        igVar2.f6457h = -1;
        igVar2.f6458i = "inlkey";
        long a10 = a("info");
        this.f6065m.f6455f = new gg(this.f6058f, new jb(this.f6053a, this.f6056d), a10, 30000000);
        ig igVar3 = this.f6065m;
        igVar3.f6456g = null;
        return igVar3;
    }

    private String g() {
        Context context = this.f6053a;
        if (context == null) {
            return null;
        }
        return a(context, "CAF9B6B99962BF5C2264824231D7A40C", this.f6054b);
    }

    private String h() {
        Context context = this.f6053a;
        if (context == null) {
            return null;
        }
        return a(context, "CB5E100E5A9A3E7F6D1FD97512215282", this.f6054b);
    }

    private boolean b() {
        return this.f6053a != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z10) {
        ig c4 = c(ge.f6048b);
        if (z10) {
            ((gg) c4.f6455f).a(z10);
        }
        Context context = this.f6053a;
        if (context == null) {
            return;
        }
        gz.a(context, c4, this.f6062j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z10) {
        ig c4 = c(ge.f6047a);
        if (z10) {
            ((gg) c4.f6455f).a(z10);
        }
        Context context = this.f6053a;
        if (context == null) {
            return;
        }
        gz.a(context, c4, this.f6063k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ig e() {
        ig igVar = this.f6065m;
        if (igVar != null) {
            return igVar;
        }
        f();
        return this.f6065m;
    }

    private gh b(int i10) {
        if (i10 == ge.f6048b) {
            return this.f6061i;
        }
        return this.f6060h;
    }

    public final void a(Context context) {
        this.f6053a = context.getApplicationContext();
    }

    private void b(boolean z10) {
        c(z10);
        d(z10);
    }

    private ig c(int i10) {
        if (i10 == ge.f6048b) {
            if (this.f6066n == null) {
                this.f6066n = c();
            }
            return this.f6066n;
        }
        if (this.f6065m == null) {
            this.f6065m = e();
        }
        return this.f6065m;
    }

    private ig d() {
        if (this.f6053a == null) {
            return null;
        }
        ig igVar = new ig();
        this.f6066n = igVar;
        igVar.f6450a = h();
        ig igVar2 = this.f6066n;
        igVar2.f6451b = 512000000L;
        igVar2.f6453d = 12500;
        igVar2.f6452c = "1";
        igVar2.f6457h = -1;
        igVar2.f6458i = "elkey";
        long a10 = a("error");
        this.f6066n.f6455f = new gg(true, new jb(this.f6053a, this.f6056d), a10, ExceptionCode.CRASH_EXCEPTION);
        ig igVar3 = this.f6066n;
        igVar3.f6456g = null;
        return igVar3;
    }

    public final void a(boolean z10, boolean z11, boolean z12, boolean z13, List<String> list) {
        this.f6055c = z10;
        this.f6056d = z11;
        this.f6057e = z12;
        this.f6058f = z13;
        this.f6059g = list;
        d();
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ig c() {
        ig igVar = this.f6066n;
        if (igVar != null) {
            return igVar;
        }
        d();
        return this.f6066n;
    }

    public final void a(boolean z10) {
        if (b()) {
            b(z10);
        }
    }

    public final void a(ge geVar) {
        if (b() && this.f6055c && ge.a(geVar)) {
            boolean z10 = true;
            if (geVar != null) {
                List<String> list = this.f6059g;
                if (list != null && list.size() != 0) {
                    for (int i10 = 0; i10 < this.f6059g.size(); i10++) {
                        if (!TextUtils.isEmpty(this.f6059g.get(i10)) && geVar.b().contains(this.f6059g.get(i10))) {
                            break;
                        }
                    }
                }
                z10 = false;
            }
            if (z10) {
                return;
            }
            if (this.f6057e || geVar.a() != ge.f6047a) {
                gh b4 = b(geVar.a());
                if (b4.a(geVar.b())) {
                    String a10 = ge.a(b4.a());
                    if (this.f6053a == null || TextUtils.isEmpty(a10) || "[]".equals(a10)) {
                        return;
                    }
                    gz.a(this.f6053a, this.f6054b, geVar.c(), c(geVar.a()), a10);
                    b(false);
                    b4.b();
                }
                b4.a(geVar);
            }
        }
    }

    public final void a() {
        if (b()) {
            a(ge.f6048b);
            a(ge.f6047a);
        }
    }

    private void a(int i10) {
        Context context;
        gh b4 = b(i10);
        String a10 = ge.a(b4.a());
        if (TextUtils.isEmpty(a10) || "[]".equals(a10) || (context = this.f6053a) == null) {
            return;
        }
        gz.a(context, this.f6054b, ge.a(i10), c(i10), a10);
        b4.b();
    }

    private long a(String str) {
        try {
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            return Long.parseLong(gi.a(this.f6054b).a(this.f6053a, "", "", format + str));
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private static String a(Context context, String str, fu fuVar) {
        String b4;
        if (context == null) {
            return null;
        }
        if (fuVar != null) {
            try {
                if (!TextUtils.isEmpty(fuVar.a())) {
                    b4 = fq.b(fuVar.a());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(context.getFilesDir().getAbsolutePath());
                    String str2 = File.separator;
                    sb2.append(str2);
                    sb2.append("EBDEC84EF205FEA2DF0719DEB822869E");
                    sb2.append(str2);
                    sb2.append(str);
                    sb2.append(str2);
                    sb2.append(b4);
                    return sb2.toString();
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        b4 = "a";
        StringBuilder sb22 = new StringBuilder();
        sb22.append(context.getFilesDir().getAbsolutePath());
        String str22 = File.separator;
        sb22.append(str22);
        sb22.append("EBDEC84EF205FEA2DF0719DEB822869E");
        sb22.append(str22);
        sb22.append(str);
        sb22.append(str22);
        sb22.append(b4);
        return sb22.toString();
    }

    public static /* synthetic */ Handler a(gf gfVar) {
        Context context = gfVar.f6053a;
        if (context == null || context == null) {
            return null;
        }
        if (gfVar.f6064l == null) {
            gfVar.f6064l = new Handler(gfVar.f6053a.getMainLooper());
        }
        return gfVar.f6064l;
    }

    public static /* synthetic */ void a(gf gfVar, String str, String str2) {
        try {
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            gi.a(gfVar.f6054b).a(gfVar.f6053a, "", "", format + str, str2);
        } catch (Throwable unused) {
        }
    }
}
