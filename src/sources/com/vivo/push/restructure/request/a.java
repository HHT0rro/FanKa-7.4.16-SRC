package com.vivo.push.restructure.request;

import android.content.Intent;
import android.os.Bundle;
import com.vivo.push.restructure.request.a.a.b;

/* compiled from: BaseCommand.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class a<I extends com.vivo.push.restructure.request.a.a.b, O extends com.vivo.push.restructure.request.a.a.b> {

    /* renamed from: a, reason: collision with root package name */
    private int f46332a = 2020;

    /* renamed from: b, reason: collision with root package name */
    private I f46333b;

    public a(I i10) {
        this.f46333b = i10;
    }

    public final Intent a(int i10) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("client_pkgname", com.vivo.push.restructure.a.a().b().getPackageName());
        bundle.putBoolean("support_rf", true);
        com.vivo.push.restructure.request.a.c cVar = new com.vivo.push.restructure.request.a.c(this.f46332a, i10);
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        cVar.a(aVar);
        bundle.putString("cf_content", aVar.d());
        com.vivo.push.restructure.request.a.a.a aVar2 = new com.vivo.push.restructure.request.a.a.a();
        this.f46333b.a(aVar2);
        bundle.putString("content", aVar2.d());
        intent.putExtras(bundle);
        return intent;
    }

    public abstract O a(com.vivo.push.restructure.request.a.a.a aVar);
}
