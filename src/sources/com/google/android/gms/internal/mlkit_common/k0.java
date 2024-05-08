package com.google.android.gms.internal.mlkit_common;

import android.content.Context;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k0 implements d0 {

    /* renamed from: a, reason: collision with root package name */
    public final e8.a<com.google.android.datatransport.c<byte[]>> f24184a;

    /* renamed from: b, reason: collision with root package name */
    public final e8.a<com.google.android.datatransport.c<byte[]>> f24185b;

    /* renamed from: c, reason: collision with root package name */
    public final z f24186c;

    public k0(Context context, z zVar) {
        this.f24186c = zVar;
        com.google.android.datatransport.runtime.d.f(context);
        final com.google.android.datatransport.d g3 = com.google.android.datatransport.runtime.d.c().g(m4.a.f51809g);
        this.f24184a = new z7.p(new e8.a(g3) { // from class: com.google.android.gms.internal.mlkit_common.g0

            /* renamed from: a, reason: collision with root package name */
            public final com.google.android.datatransport.d f24177a;

            {
                this.f24177a = g3;
            }

            @Override // e8.a
            public final Object get() {
                return this.f24177a.a("FIREBASE_ML_SDK", byte[].class, com.google.android.datatransport.a.b("json"), j0.f24183a);
            }
        });
        this.f24185b = new z7.p(new e8.a(g3) { // from class: com.google.android.gms.internal.mlkit_common.h0

            /* renamed from: a, reason: collision with root package name */
            public final com.google.android.datatransport.d f24178a;

            {
                this.f24178a = g3;
            }

            @Override // e8.a
            public final Object get() {
                return this.f24178a.a("FIREBASE_ML_SDK", byte[].class, com.google.android.datatransport.a.b("proto"), i0.f24180a);
            }
        });
    }
}
