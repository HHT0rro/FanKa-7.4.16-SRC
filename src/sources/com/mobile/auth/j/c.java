package com.mobile.auth.j;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c implements b {

    /* renamed from: a, reason: collision with root package name */
    private b f37413a;

    /* renamed from: b, reason: collision with root package name */
    private com.mobile.auth.m.c f37414b;

    /* renamed from: c, reason: collision with root package name */
    private final com.mobile.auth.i.a f37415c = new com.mobile.auth.i.a();

    public void a(b bVar) {
        this.f37413a = bVar;
    }

    @Override // com.mobile.auth.j.b
    public void a(com.mobile.auth.l.c cVar, com.mobile.auth.m.c cVar2, com.cmic.sso.sdk.a aVar) {
        b(cVar, cVar2, aVar);
    }

    public void b(final com.mobile.auth.l.c cVar, final com.mobile.auth.m.c cVar2, final com.cmic.sso.sdk.a aVar) {
        if (this.f37413a != null) {
            this.f37414b = new com.mobile.auth.m.c() { // from class: com.mobile.auth.j.c.1
                @Override // com.mobile.auth.m.c
                public void a(com.mobile.auth.m.a aVar2) {
                    if (!cVar.j()) {
                        cVar2.a(aVar2);
                        return;
                    }
                    com.mobile.auth.n.c.a("RetryAndRedirectInterceptor", "retry: " + cVar.a());
                    c.this.b(cVar, cVar2, aVar);
                }

                @Override // com.mobile.auth.m.c
                public void a(com.mobile.auth.m.b bVar) {
                    com.mobile.auth.l.c b4;
                    if (bVar.d()) {
                        b4 = c.this.f37415c.a(cVar, bVar, aVar);
                    } else {
                        if (TextUtils.isEmpty(c.this.f37415c.a())) {
                            cVar2.a(bVar);
                            return;
                        }
                        b4 = c.this.f37415c.b(cVar, bVar, aVar);
                    }
                    c.this.b(b4, cVar2, aVar);
                }
            };
            if (cVar.g()) {
                this.f37413a.a(cVar, this.f37414b, aVar);
            } else {
                cVar2.a(com.mobile.auth.m.a.a(200025));
            }
        }
    }
}
