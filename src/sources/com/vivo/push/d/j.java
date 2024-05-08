package com.vivo.push.d;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SyncProfileInfoImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j implements com.vivo.push.restructure.request.c<com.vivo.push.d.a.b> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IPushRequestCallback f46166a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f46167b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f46168c;

    public j(d dVar, IPushRequestCallback iPushRequestCallback, int i10) {
        this.f46168c = dVar;
        this.f46166a = iPushRequestCallback;
        this.f46167b = i10;
    }

    @Override // com.vivo.push.restructure.request.c
    public final void a(int i10) {
        if (this.f46166a != null) {
            u.b(this.f46167b + " sync err : " + i10);
            this.f46166a.onError(i10);
        }
    }

    @Override // com.vivo.push.restructure.request.c
    public final /* synthetic */ void a(com.vivo.push.d.a.b bVar) {
        if (this.f46166a != null) {
            u.b(this.f46167b + " sync success");
            this.f46166a.onSuccess(0);
        }
    }
}
