package com.google.android.gms.internal.mlkit_common;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p extends WeakReference<Throwable> {

    /* renamed from: a, reason: collision with root package name */
    public final int f24189a;

    public p(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.f24189a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == p.class) {
            if (this == obj) {
                return true;
            }
            p pVar = (p) obj;
            if (this.f24189a == pVar.f24189a && get() == pVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f24189a;
    }
}
