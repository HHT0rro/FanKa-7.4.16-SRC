package com.vivo.push.d;

import com.vivo.push.restructure.request.a.a.c;
import org.json.JSONException;

/* compiled from: ProfileInfoDS.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements com.vivo.push.restructure.request.a.a.c {

    /* renamed from: a, reason: collision with root package name */
    public static c.a<b> f46153a = new c();

    /* renamed from: b, reason: collision with root package name */
    private String f46154b;

    public b(String str) {
        this.f46154b = str;
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        aVar.a(this.f46154b);
        return aVar.d();
    }

    public final String b() {
        return this.f46154b;
    }

    public b(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.f46154b = aVar.c();
    }
}
