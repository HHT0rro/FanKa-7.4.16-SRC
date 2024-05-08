package com.vivo.push;

import com.vivo.push.listener.IPushQueryActionListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BasePushClient.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IPushQueryActionListener f46078a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f46079b;

    public b(a aVar, IPushQueryActionListener iPushQueryActionListener) {
        this.f46079b = aVar;
        this.f46078a = iPushQueryActionListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String b4 = com.vivo.push.restructure.a.a().h().b();
        IPushQueryActionListener iPushQueryActionListener = this.f46078a;
        if (iPushQueryActionListener != null) {
            iPushQueryActionListener.onSuccess(b4);
        }
    }
}
