package com.google.android.gms.internal.mlkit_vision_face;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class y8 implements v8 {

    /* renamed from: b, reason: collision with root package name */
    public static final com.google.android.gms.common.internal.e f25341b = new com.google.android.gms.common.internal.e("ClearcutTransport", "");

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.clearcut.a f25342a;

    public y8(Context context) {
        this.f25342a = com.google.android.gms.clearcut.a.a(context, "FIREBASE_ML_SDK");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.v8
    public final void a(x8 x8Var) {
        com.google.android.gms.common.internal.e eVar = f25341b;
        String valueOf = String.valueOf(x8Var);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 30);
        sb2.append("Logging FirebaseMlSdkLogEvent ");
        sb2.append(valueOf);
        eVar.b("ClearcutTransport", sb2.toString());
        try {
            this.f25342a.b(x8Var.a(1, true)).a();
        } catch (SecurityException e2) {
            f25341b.d("ClearcutTransport", "Exception thrown from the logging side", e2);
        }
    }
}
