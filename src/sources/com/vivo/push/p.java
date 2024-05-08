package com.vivo.push;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushClientManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class p implements IPushActionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f46280a;

    public p(m mVar) {
        this.f46280a = mVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i10) {
        if (i10 == 0) {
            com.vivo.push.restructure.a.a().h().b("");
        } else {
            com.vivo.push.restructure.a.a().h().c("");
        }
    }
}
