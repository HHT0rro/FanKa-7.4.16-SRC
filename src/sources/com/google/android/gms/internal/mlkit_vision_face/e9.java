package com.google.android.gms.internal.mlkit_vision_face;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.Event;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e9 implements v8 {

    /* renamed from: a, reason: collision with root package name */
    public final e8.a<com.google.android.datatransport.c<byte[]>> f24842a;

    /* renamed from: b, reason: collision with root package name */
    public final e8.a<com.google.android.datatransport.c<byte[]>> f24843b;

    /* renamed from: c, reason: collision with root package name */
    public final o8 f24844c;

    public e9(Context context, o8 o8Var) {
        this.f24844c = o8Var;
        com.google.android.datatransport.runtime.d.f(context);
        final com.google.android.datatransport.d g3 = com.google.android.datatransport.runtime.d.c().g(m4.a.f51809g);
        this.f24842a = new z7.p(new e8.a(g3) { // from class: com.google.android.gms.internal.mlkit_vision_face.z8

            /* renamed from: a, reason: collision with root package name */
            public final com.google.android.datatransport.d f25368a;

            {
                this.f25368a = g3;
            }

            @Override // e8.a
            public final Object get() {
                return this.f25368a.a("FIREBASE_ML_SDK", byte[].class, com.google.android.datatransport.a.b("json"), c9.f24798a);
            }
        });
        this.f24843b = new z7.p(new e8.a(g3) { // from class: com.google.android.gms.internal.mlkit_vision_face.a9

            /* renamed from: a, reason: collision with root package name */
            public final com.google.android.datatransport.d f24758a;

            {
                this.f24758a = g3;
            }

            @Override // e8.a
            public final Object get() {
                return this.f24758a.a("FIREBASE_ML_SDK", byte[].class, com.google.android.datatransport.a.b("proto"), b9.f24778a);
            }
        });
    }

    @VisibleForTesting
    public static Event<byte[]> b(o8 o8Var, x8 x8Var) {
        int e2 = o8Var.e();
        int i10 = d9.f24817a[o8Var.d().ordinal()];
        if (i10 == 1) {
            return Event.ofUrgent(x8Var.a(e2, false));
        }
        if (i10 != 2) {
            return Event.ofData(x8Var.a(e2, false));
        }
        return Event.ofTelemetry(x8Var.a(e2, false));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.v8
    public final void a(x8 x8Var) {
        if (this.f24844c.e() == 0) {
            this.f24842a.get().a(b(this.f24844c, x8Var));
        } else {
            this.f24843b.get().a(b(this.f24844c, x8Var));
        }
    }
}
