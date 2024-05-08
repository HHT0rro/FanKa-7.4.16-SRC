package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* compiled from: VUpsManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class a implements IPushActionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UPSRegisterCallback f46376a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VUpsManager f46377b;

    public a(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback) {
        this.f46377b = vUpsManager;
        this.f46376a = uPSRegisterCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i10) {
        this.f46376a.onResult(new TokenResult(i10, com.vivo.push.restructure.a.a().h().b()));
    }
}
