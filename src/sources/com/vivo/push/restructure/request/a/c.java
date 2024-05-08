package com.vivo.push.restructure.request.a;

import com.vivo.push.restructure.request.a.a.b;
import org.json.JSONException;

/* compiled from: CFToCoreDS.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c implements com.vivo.push.restructure.request.a.a.b {

    /* renamed from: a, reason: collision with root package name */
    public static final b.a<c> f46344a = new d();

    /* renamed from: b, reason: collision with root package name */
    private String f46345b;

    /* renamed from: c, reason: collision with root package name */
    private int f46346c;

    /* renamed from: d, reason: collision with root package name */
    private long f46347d;

    /* renamed from: e, reason: collision with root package name */
    private int f46348e;

    public c(int i10, int i11) {
        this.f46345b = com.vivo.push.restructure.a.a().b().getPackageName();
        this.f46346c = i10;
        this.f46347d = 341L;
        this.f46348e = i11;
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.f46345b);
        aVar.a(this.f46346c);
        aVar.a(this.f46347d);
        aVar.a(this.f46348e);
    }

    public c(com.vivo.push.restructure.request.a.a.a aVar) {
        try {
            this.f46345b = aVar.c();
            this.f46346c = aVar.a();
            this.f46347d = aVar.b();
            this.f46348e = aVar.a();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
