package com.vivo.push;

import com.vivo.push.restructure.request.a.a.c;
import org.json.JSONException;

/* compiled from: ClientSdkQueryResultDS.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g implements com.vivo.push.restructure.request.a.a.c {

    /* renamed from: a, reason: collision with root package name */
    public static c.a<g> f46225a = new h();

    /* renamed from: b, reason: collision with root package name */
    private int f46226b;

    /* renamed from: c, reason: collision with root package name */
    private String f46227c;

    public g(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.f46226b = aVar.a();
        this.f46227c = aVar.c();
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        aVar.a(this.f46226b);
        aVar.a(this.f46227c);
        return aVar.d();
    }

    public final String b() {
        return this.f46227c;
    }
}
