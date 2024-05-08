package com.google.android.gms.internal.mlkit_vision_common;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class o implements b8.b<o> {

    /* renamed from: d, reason: collision with root package name */
    public static final a8.d<Object> f24503d = n.f24473a;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f24504e = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, a8.d<?>> f24505a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, a8.f<?>> f24506b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final a8.d<Object> f24507c = f24503d;

    @Override // b8.b
    @NonNull
    public final /* bridge */ /* synthetic */ o a(@NonNull Class cls, @NonNull a8.d dVar) {
        this.f24505a.put(cls, dVar);
        this.f24506b.remove(cls);
        return this;
    }

    public final p b() {
        return new p(new HashMap(this.f24505a), new HashMap(this.f24506b), this.f24507c);
    }
}
