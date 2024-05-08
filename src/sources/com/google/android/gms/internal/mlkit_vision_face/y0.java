package com.google.android.gms.internal.mlkit_vision_face;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class y0 extends WeakReference<Throwable> {

    /* renamed from: a, reason: collision with root package name */
    public final int f25317a;

    public y0(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.f25317a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == y0.class) {
            if (this == obj) {
                return true;
            }
            y0 y0Var = (y0) obj;
            if (this.f25317a == y0Var.f25317a && get() == y0Var.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f25317a;
    }
}
