package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.encoders.EncodingException;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class l1 implements a8.d {

    /* renamed from: a, reason: collision with root package name */
    public static final a8.d f25030a = new l1();

    @Override // a8.b
    public final void a(Object obj, a8.e eVar) {
        int i10 = m1.f25054e;
        String valueOf = String.valueOf(obj.getClass().getCanonicalName());
        throw new EncodingException(valueOf.length() != 0 ? "Couldn't find encoder for type ".concat(valueOf) : new String("Couldn't find encoder for type "));
    }
}
