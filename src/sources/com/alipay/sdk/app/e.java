package com.alipay.sdk.app;

import android.content.DialogInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class e implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f4404a;

    public e(c cVar) {
        this.f4404a = cVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        this.f4404a.f4401b.cancel();
        this.f4404a.f4402c.f4395b = false;
        j.a(j.c());
        this.f4404a.f4400a.finish();
    }
}
