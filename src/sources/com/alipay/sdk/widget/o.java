package com.alipay.sdk.widget;

import android.content.DialogInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class o implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f4829a;

    public o(n nVar) {
        this.f4829a = nVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        this.f4829a.f4828b.f4817w = true;
        this.f4829a.f4827a.proceed();
        dialogInterface.dismiss();
    }
}
