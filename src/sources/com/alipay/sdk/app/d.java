package com.alipay.sdk.app;

import android.content.DialogInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class d implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f4403a;

    public d(c cVar) {
        this.f4403a = cVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        this.f4403a.f4402c.f4395b = true;
        this.f4403a.f4401b.proceed();
        dialogInterface.dismiss();
    }
}
