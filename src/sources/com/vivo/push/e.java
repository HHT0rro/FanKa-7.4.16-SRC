package com.vivo.push;

import com.vivo.push.restructure.request.a.a.c;
import org.json.JSONException;

/* compiled from: ClientSdkQueryParemeterDS.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e implements com.vivo.push.restructure.request.a.a.c {

    /* renamed from: a, reason: collision with root package name */
    public static c.a<e> f46169a = new f();

    /* renamed from: b, reason: collision with root package name */
    private int f46170b;

    /* renamed from: c, reason: collision with root package name */
    private String f46171c;

    /* renamed from: d, reason: collision with root package name */
    private String f46172d;

    /* renamed from: e, reason: collision with root package name */
    private String f46173e;

    /* renamed from: f, reason: collision with root package name */
    private String f46174f;

    public e(int i10, String str, String str2, String str3, String str4) {
        this.f46170b = i10;
        this.f46171c = str;
        this.f46172d = str2;
        this.f46173e = str3;
        this.f46174f = str4;
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        aVar.a(this.f46170b);
        aVar.a(this.f46171c);
        aVar.a(this.f46172d);
        aVar.a(this.f46173e);
        aVar.a(this.f46174f);
        return aVar.d();
    }

    public e(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.f46170b = aVar.a();
        this.f46171c = aVar.c();
        this.f46172d = aVar.c();
        this.f46173e = aVar.c();
        this.f46174f = aVar.c();
    }
}
