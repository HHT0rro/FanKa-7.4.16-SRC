package com.vivo.push;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BasePushClient.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IPushActionListener f46135a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f46136b;

    public c(a aVar, IPushActionListener iPushActionListener) {
        this.f46136b = aVar;
        this.f46135a = iPushActionListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int a10 = com.vivo.push.restructure.a.a().h().a();
        IPushActionListener iPushActionListener = this.f46135a;
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(a10);
        }
    }
}
