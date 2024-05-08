package com.google.android.gms.internal.mlkit_vision_face;

import androidx.annotation.NonNull;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class n1 {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, a8.d<?>> f25084a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, a8.f<?>> f25085b;

    /* renamed from: c, reason: collision with root package name */
    public final a8.d<Object> f25086c;

    public n1(Map<Class<?>, a8.d<?>> map, Map<Class<?>, a8.f<?>> map2, a8.d<Object> dVar) {
        this.f25084a = map;
        this.f25085b = map2;
        this.f25086c = dVar;
    }

    @NonNull
    public final byte[] a(@NonNull Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new k1(byteArrayOutputStream, this.f25084a, this.f25085b, this.f25086c).i(obj);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
