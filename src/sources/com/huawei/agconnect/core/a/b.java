package com.huawei.agconnect.core.a;

import android.content.Context;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import z8.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b extends z8.c {

    /* renamed from: d, reason: collision with root package name */
    public static List<c9.a> f27208d;

    /* renamed from: e, reason: collision with root package name */
    public static final Map<String, z8.c> f27209e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public static String f27210f;

    /* renamed from: a, reason: collision with root package name */
    public final z8.d f27211a;

    /* renamed from: b, reason: collision with root package name */
    public final d f27212b;

    /* renamed from: c, reason: collision with root package name */
    public final d f27213c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a implements f.a {
        @Override // z8.f.a
        public String a(z8.d dVar) {
            String str;
            if (dVar.a().equals(z8.b.f55028c)) {
                str = "/agcgw_all/CN";
            } else if (dVar.a().equals(z8.b.f55030e)) {
                str = "/agcgw_all/RU";
            } else if (dVar.a().equals(z8.b.f55029d)) {
                str = "/agcgw_all/DE";
            } else {
                if (!dVar.a().equals(z8.b.f55031f)) {
                    return null;
                }
                str = "/agcgw_all/SG";
            }
            return dVar.getString(str);
        }
    }

    /* renamed from: com.huawei.agconnect.core.a.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class C0256b implements f.a {
        @Override // z8.f.a
        public String a(z8.d dVar) {
            String str;
            if (dVar.a().equals(z8.b.f55028c)) {
                str = "/agcgw_all/CN_back";
            } else if (dVar.a().equals(z8.b.f55030e)) {
                str = "/agcgw_all/RU_back";
            } else if (dVar.a().equals(z8.b.f55029d)) {
                str = "/agcgw_all/DE_back";
            } else {
                if (!dVar.a().equals(z8.b.f55031f)) {
                    return null;
                }
                str = "/agcgw_all/SG_back";
            }
            return dVar.getString(str);
        }
    }

    public b(z8.d dVar) {
        this.f27211a = dVar;
        this.f27212b = new d(f27208d, dVar.getContext());
        d dVar2 = new d(null, dVar.getContext());
        this.f27213c = dVar2;
        if (dVar instanceof b9.c) {
            dVar2.c(((b9.c) dVar).c(), dVar.getContext());
        }
    }

    public static z8.c f() {
        String str = f27210f;
        if (str == null) {
            str = "DEFAULT_INSTANCE";
        }
        return g(str);
    }

    public static synchronized z8.c g(String str) {
        z8.c cVar;
        synchronized (b.class) {
            cVar = f27209e.get(str);
            if (cVar == null && !"DEFAULT_INSTANCE".equals(str)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("not find instance for : ");
                sb2.append(str);
            }
        }
        return cVar;
    }

    public static z8.c h(z8.d dVar) {
        return i(dVar, false);
    }

    public static synchronized z8.c i(z8.d dVar, boolean z10) {
        z8.c cVar;
        synchronized (b.class) {
            Map<String, z8.c> map = f27209e;
            cVar = map.get(dVar.getIdentifier());
            if (cVar == null || z10) {
                cVar = new b(dVar);
                map.put(dVar.getIdentifier(), cVar);
            }
        }
        return cVar;
    }

    public static synchronized void j(Context context) {
        synchronized (b.class) {
            if (f27209e.size() > 0) {
                return;
            }
            k(context, a9.a.b(context));
        }
    }

    public static synchronized void k(Context context, z8.d dVar) {
        synchronized (b.class) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            l();
            if (f27208d == null) {
                f27208d = new c(context).b();
            }
            i(dVar, true);
            f27210f = dVar.getIdentifier();
            com.huawei.agconnect.core.a.a.a();
        }
    }

    public static void l() {
        f.b("/agcgw/url", new a());
        f.b("/agcgw/backurl", new C0256b());
    }

    @Override // z8.c
    public Context b() {
        return this.f27211a.getContext();
    }

    @Override // z8.c
    public z8.d d() {
        return this.f27211a;
    }
}
