package com.alipay.sdk.auth;

import android.content.DialogInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class e implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f4483a;

    public e(d dVar) {
        this.f4483a = dVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        AuthActivity.this.f4472g = true;
        this.f4483a.f4481a.proceed();
        dialogInterface.dismiss();
    }
}
