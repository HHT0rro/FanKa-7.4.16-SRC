package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* compiled from: VUpsManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class b implements IPushActionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UPSRegisterCallback f46378a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VUpsManager f46379b;

    public b(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback) {
        this.f46379b = vUpsManager;
        this.f46378a = uPSRegisterCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i10) {
        this.f46378a.onResult(new TokenResult(i10, ""));
    }
}
