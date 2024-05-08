package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.Event;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class y6 implements p6 {

    /* renamed from: a, reason: collision with root package name */
    public final e8.a<com.google.android.datatransport.c<byte[]>> f24720a;

    /* renamed from: b, reason: collision with root package name */
    public final e8.a<com.google.android.datatransport.c<byte[]>> f24721b;

    /* renamed from: c, reason: collision with root package name */
    public final j6 f24722c;

    public y6(Context context, j6 j6Var) {
        this.f24722c = j6Var;
        com.google.android.datatransport.runtime.d.f(context);
        final com.google.android.datatransport.d g3 = com.google.android.datatransport.runtime.d.c().g(m4.a.f51809g);
        this.f24720a = new z7.p(new e8.a(g3) { // from class: com.google.android.gms.internal.mlkit_vision_common.t6

            /* renamed from: a, reason: collision with root package name */
            public final com.google.android.datatransport.d f24644a;

            {
                this.f24644a = g3;
            }

            @Override // e8.a
            public final Object get() {
                return this.f24644a.a("FIREBASE_ML_SDK", byte[].class, com.google.android.datatransport.a.b("json"), w6.f24691a);
            }
        });
        this.f24721b = new z7.p(new e8.a(g3) { // from class: com.google.android.gms.internal.mlkit_vision_common.u6

            /* renamed from: a, reason: collision with root package name */
            public final com.google.android.datatransport.d f24665a;

            {
                this.f24665a = g3;
            }

            @Override // e8.a
            public final Object get() {
                return this.f24665a.a("FIREBASE_ML_SDK", byte[].class, com.google.android.datatransport.a.b("proto"), v6.f24677a);
            }
        });
    }

    @VisibleForTesting
    public static Event<byte[]> b(j6 j6Var, r6 r6Var) {
        int e2 = j6Var.e();
        int i10 = x6.f24705a[j6Var.d().ordinal()];
        if (i10 == 1) {
            return Event.ofUrgent(r6Var.a(e2, false));
        }
        if (i10 != 2) {
            return Event.ofData(r6Var.a(e2, false));
        }
        return Event.ofTelemetry(r6Var.a(e2, false));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.p6
    public final void a(r6 r6Var) {
        if (this.f24722c.e() == 0) {
            this.f24720a.get().a(b(this.f24722c, r6Var));
        } else {
            this.f24721b.get().a(b(this.f24722c, r6Var));
        }
    }
}
