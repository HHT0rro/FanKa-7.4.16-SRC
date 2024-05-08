package com.alipay.sdk.auth;

import android.content.DialogInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class f implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f4484a;

    public f(d dVar) {
        this.f4484a = dVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        String str;
        this.f4484a.f4481a.cancel();
        AuthActivity.this.f4472g = false;
        StringBuilder sb2 = new StringBuilder();
        str = AuthActivity.this.f4469d;
        sb2.append(str);
        sb2.append("?resultCode=150");
        g.a(AuthActivity.this, sb2.toString());
        AuthActivity.this.finish();
    }
}
