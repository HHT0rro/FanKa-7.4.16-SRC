package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* compiled from: VUpsManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
final class d implements IPushActionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UPSTurnCallback f46382a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VUpsManager f46383b;

    public d(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.f46383b = vUpsManager;
        this.f46382a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i10) {
        this.f46382a.onResult(new CodeResult(i10));
    }
}
