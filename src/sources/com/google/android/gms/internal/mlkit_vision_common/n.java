package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.encoders.EncodingException;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class n implements a8.d {

    /* renamed from: a, reason: collision with root package name */
    public static final a8.d f24473a = new n();

    @Override // a8.b
    public final void a(Object obj, a8.e eVar) {
        int i10 = o.f24504e;
        String valueOf = String.valueOf(obj.getClass().getCanonicalName());
        throw new EncodingException(valueOf.length() != 0 ? "Couldn't find encoder for type ".concat(valueOf) : new String("Couldn't find encoder for type "));
    }
}
