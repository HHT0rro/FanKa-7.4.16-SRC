package com.vivo.push.restructure.a.a;

import android.os.SystemClock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IPCNode.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g extends a<com.vivo.push.restructure.a.a> {

    /* renamed from: b, reason: collision with root package name */
    private long f46308b;

    public g(com.vivo.push.restructure.a.a aVar, i iVar) {
        super("IPCNode", aVar, iVar);
        this.f46308b = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long d10 = aVar.d();
        if (d10 <= 0 || elapsedRealtime <= d10) {
            return;
        }
        this.f46308b = elapsedRealtime - d10;
    }

    @Override // com.vivo.push.restructure.a.a.a
    public final /* bridge */ /* synthetic */ int a(com.vivo.push.restructure.a.a aVar) {
        return 0;
    }

    @Override // com.vivo.push.restructure.a.a.a
    public final synchronized String b() {
        a(this.f46308b);
        return super.b();
    }
}
