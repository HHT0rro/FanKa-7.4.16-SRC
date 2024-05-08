package com.google.android.gms.internal.mlkit_vision_face;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class m1 implements b8.b<m1> {

    /* renamed from: d, reason: collision with root package name */
    public static final a8.d<Object> f25053d = l1.f25030a;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f25054e = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, a8.d<?>> f25055a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, a8.f<?>> f25056b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final a8.d<Object> f25057c = f25053d;

    @Override // b8.b
    @NonNull
    public final /* bridge */ /* synthetic */ m1 a(@NonNull Class cls, @NonNull a8.d dVar) {
        this.f25055a.put(cls, dVar);
        this.f25056b.remove(cls);
        return this;
    }

    public final n1 b() {
        return new n1(new HashMap(this.f25055a), new HashMap(this.f25056b), this.f25057c);
    }
}
