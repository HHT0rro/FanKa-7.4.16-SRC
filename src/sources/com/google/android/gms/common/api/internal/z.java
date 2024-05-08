package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.g;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class z implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ConnectionResult f23497b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g.c f23498c;

    public z(g.c cVar, ConnectionResult connectionResult) {
        this.f23498c = cVar;
        this.f23497b = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar;
        a.f fVar;
        a.f fVar2;
        a.f fVar3;
        a.f fVar4;
        Map map = g.this.f23440j;
        bVar = this.f23498c.f23460b;
        g.a aVar = (g.a) map.get(bVar);
        if (aVar == null) {
            return;
        }
        if (this.f23497b.isSuccess()) {
            g.c.f(this.f23498c, true);
            fVar = this.f23498c.f23459a;
            if (fVar.c()) {
                this.f23498c.e();
                return;
            }
            try {
                fVar3 = this.f23498c.f23459a;
                fVar4 = this.f23498c.f23459a;
                fVar3.f(null, fVar4.e());
                return;
            } catch (SecurityException unused) {
                fVar2 = this.f23498c.f23459a;
                fVar2.a("Failed to get service from broker.");
                aVar.onConnectionFailed(new ConnectionResult(10));
                return;
            }
        }
        aVar.onConnectionFailed(this.f23497b);
    }
}
