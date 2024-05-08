package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Iterator;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class s0<F, T> implements Iterator<T> {

    /* renamed from: b, reason: collision with root package name */
    public final Iterator<? extends F> f25188b;

    public s0(Iterator<? extends F> it) {
        Objects.requireNonNull(it);
        this.f25188b = it;
    }

    public abstract T a(F f10);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f25188b.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.f25188b.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f25188b.remove();
    }
}
