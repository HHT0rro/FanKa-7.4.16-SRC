package com.vivo.push.restructure.request.a;

import com.vivo.push.restructure.request.a.a.b;
import com.vivo.push.util.u;
import org.json.JSONException;

/* compiled from: CFToClientDS.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a implements com.vivo.push.restructure.request.a.a.b {

    /* renamed from: a, reason: collision with root package name */
    public static final b.a<a> f46334a = new b();

    /* renamed from: b, reason: collision with root package name */
    private String f46335b;

    /* renamed from: c, reason: collision with root package name */
    private int f46336c;

    /* renamed from: d, reason: collision with root package name */
    private int f46337d;

    /* renamed from: e, reason: collision with root package name */
    private long f46338e;

    /* renamed from: f, reason: collision with root package name */
    private int f46339f;

    /* renamed from: g, reason: collision with root package name */
    private int f46340g;

    public a(com.vivo.push.restructure.request.a.a.a aVar) {
        try {
            this.f46335b = aVar.c();
            this.f46336c = aVar.a();
            this.f46338e = aVar.b();
            this.f46339f = aVar.a();
            this.f46337d = aVar.a();
            this.f46340g = aVar.a();
        } catch (JSONException e2) {
            u.a("CFToClientDS", e2);
        }
    }

    public final int a() {
        return this.f46336c;
    }

    public final int b() {
        return this.f46339f;
    }

    public final int c() {
        return this.f46340g;
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.f46335b);
        aVar.a(this.f46336c);
        aVar.a(this.f46338e);
        aVar.a(this.f46339f);
        aVar.a(this.f46337d);
        aVar.a(this.f46340g);
    }
}
