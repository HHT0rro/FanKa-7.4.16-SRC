package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class s6 implements p6 {

    /* renamed from: b, reason: collision with root package name */
    public static final com.google.android.gms.common.internal.e f24625b = new com.google.android.gms.common.internal.e("ClearcutTransport", "");

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.clearcut.a f24626a;

    public s6(Context context) {
        this.f24626a = com.google.android.gms.clearcut.a.a(context, "FIREBASE_ML_SDK");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.p6
    public final void a(r6 r6Var) {
        com.google.android.gms.common.internal.e eVar = f24625b;
        String valueOf = String.valueOf(r6Var);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 30);
        sb2.append("Logging FirebaseMlSdkLogEvent ");
        sb2.append(valueOf);
        eVar.b("ClearcutTransport", sb2.toString());
        try {
            this.f24626a.b(r6Var.a(1, true)).a();
        } catch (SecurityException e2) {
            f24625b.d("ClearcutTransport", "Exception thrown from the logging side", e2);
        }
    }
}
