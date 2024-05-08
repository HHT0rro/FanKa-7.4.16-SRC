package com.alipay.sdk.widget;

import android.content.DialogInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class p implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f4830a;

    public p(n nVar) {
        this.f4830a = nVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        this.f4830a.f4827a.cancel();
        this.f4830a.f4828b.f4817w = false;
        com.alipay.sdk.app.j.a(com.alipay.sdk.app.j.c());
        this.f4830a.f4828b.f4792a.finish();
    }
}
