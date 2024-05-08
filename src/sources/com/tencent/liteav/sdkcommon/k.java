package com.tencent.liteav.sdkcommon;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private final g f43193a;

    private k(g gVar) {
        this.f43193a = gVar;
    }

    public static View.OnClickListener a(g gVar) {
        return new k(gVar);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f43193a.a(false);
    }
}
