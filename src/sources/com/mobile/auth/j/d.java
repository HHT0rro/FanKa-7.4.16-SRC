package com.mobile.auth.j;

import android.content.Context;
import android.net.Network;
import com.mobile.auth.n.n;
import com.mobile.auth.n.r;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d implements b {

    /* renamed from: a, reason: collision with root package name */
    private b f37420a;

    public void a(b bVar) {
        this.f37420a = bVar;
    }

    @Override // com.mobile.auth.j.b
    public void a(final com.mobile.auth.l.c cVar, final com.mobile.auth.m.c cVar2, final com.cmic.sso.sdk.a aVar) {
        if (cVar.b()) {
            r.a((Context) null).a(new r.a() { // from class: com.mobile.auth.j.d.1

                /* renamed from: e, reason: collision with root package name */
                private final AtomicBoolean f37425e = new AtomicBoolean(false);

                @Override // com.mobile.auth.n.r.a
                public void a(final Network network) {
                    if (this.f37425e.getAndSet(true)) {
                        return;
                    }
                    n.a(new n.a(null, aVar) { // from class: com.mobile.auth.j.d.1.1
                        @Override // com.mobile.auth.n.n.a
                        public void a() {
                            if (network == null) {
                                cVar2.a(com.mobile.auth.m.a.a(102508));
                            } else {
                                com.mobile.auth.n.c.b("WifiChangeInterceptor", "onAvailable");
                                cVar.a(network);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                d.this.b(cVar, cVar2, aVar);
                            }
                        }
                    });
                }
            });
        } else {
            b(cVar, cVar2, aVar);
        }
    }

    public void b(com.mobile.auth.l.c cVar, final com.mobile.auth.m.c cVar2, com.cmic.sso.sdk.a aVar) {
        b bVar = this.f37420a;
        if (bVar != null) {
            bVar.a(cVar, new com.mobile.auth.m.c() { // from class: com.mobile.auth.j.d.2
                @Override // com.mobile.auth.m.c
                public void a(com.mobile.auth.m.a aVar2) {
                    cVar2.a(aVar2);
                }

                @Override // com.mobile.auth.m.c
                public void a(com.mobile.auth.m.b bVar2) {
                    cVar2.a(bVar2);
                }
            }, aVar);
        }
    }
}
