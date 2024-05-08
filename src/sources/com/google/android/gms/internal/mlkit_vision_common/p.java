package com.google.android.gms.internal.mlkit_vision_common;

import androidx.annotation.NonNull;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, a8.d<?>> f24543a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, a8.f<?>> f24544b;

    /* renamed from: c, reason: collision with root package name */
    public final a8.d<Object> f24545c;

    public p(Map<Class<?>, a8.d<?>> map, Map<Class<?>, a8.f<?>> map2, a8.d<Object> dVar) {
        this.f24543a = map;
        this.f24544b = map2;
        this.f24545c = dVar;
    }

    @NonNull
    public final byte[] a(@NonNull Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new m(byteArrayOutputStream, this.f24543a, this.f24544b, this.f24545c).i(obj);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
