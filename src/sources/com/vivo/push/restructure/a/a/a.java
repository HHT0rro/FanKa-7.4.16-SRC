package com.vivo.push.restructure.a.a;

import com.vivo.push.util.u;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AbstractMessageNodeMonitor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
abstract class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public T f46294a;

    /* renamed from: b, reason: collision with root package name */
    private String f46295b;

    /* renamed from: e, reason: collision with root package name */
    private i f46298e;

    /* renamed from: g, reason: collision with root package name */
    private a f46300g;

    /* renamed from: c, reason: collision with root package name */
    private long f46296c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f46297d = -1;

    /* renamed from: f, reason: collision with root package name */
    private boolean f46299f = false;

    public a(String str, T t2, i iVar) {
        this.f46295b = str;
        this.f46294a = t2;
        this.f46298e = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f46297d = a((a<T>) this.f46294a);
        this.f46296c = System.currentTimeMillis() - currentTimeMillis;
        int i10 = this.f46297d;
        if (i10 != 0) {
            i iVar = this.f46298e;
            if (iVar != null) {
                iVar.a(this, this.f46294a, i10);
                return;
            }
            return;
        }
        a aVar = this.f46300g;
        if (aVar != null) {
            aVar.a();
            return;
        }
        i iVar2 = this.f46298e;
        if (iVar2 != null) {
            iVar2.a((i) this.f46294a);
        }
    }

    public abstract int a(T t2);

    public final void a(a aVar) {
        if (this != aVar) {
            this.f46300g = aVar;
        }
    }

    public final JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        for (a<T> aVar = this; aVar != null; aVar = aVar.f46300g) {
            try {
                jSONArray.put(aVar.b());
            } catch (Exception e2) {
                u.a("AbstractMessageNodeMoni", e2);
            }
        }
        return jSONArray;
    }

    public final void a(long j10) {
        this.f46296c = j10;
    }

    public synchronized String b() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f46295b);
            jSONObject.put("code", this.f46297d);
            jSONObject.put("cost", this.f46296c);
        } catch (Exception e2) {
            u.a("AbstractMessageNodeMoni", e2);
        }
        return jSONObject.toString();
    }

    public final void a() {
        if (this.f46299f) {
            com.vivo.push.util.g.a().execute(new b(this));
        } else {
            d();
        }
    }
}
