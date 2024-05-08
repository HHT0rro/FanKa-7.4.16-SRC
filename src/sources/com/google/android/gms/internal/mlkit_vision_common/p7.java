package com.google.android.gms.internal.mlkit_vision_common;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p7 extends WeakReference<Throwable> {

    /* renamed from: a, reason: collision with root package name */
    public final int f24562a;

    public p7(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.f24562a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == p7.class) {
            if (this == obj) {
                return true;
            }
            p7 p7Var = (p7) obj;
            if (this.f24562a == p7Var.f24562a && get() == p7Var.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f24562a;
    }
}
