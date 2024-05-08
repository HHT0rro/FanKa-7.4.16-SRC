package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* compiled from: VUpsManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class c implements IPushActionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UPSTurnCallback f46380a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VUpsManager f46381b;

    public c(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.f46381b = vUpsManager;
        this.f46380a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i10) {
        this.f46380a.onResult(new CodeResult(i10));
    }
}
