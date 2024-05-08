package com.google.android.gms.internal.vision;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class w1 extends WeakReference<Throwable> {

    /* renamed from: a, reason: collision with root package name */
    public final int f25666a;

    public w1(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.f25666a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == w1.class) {
            if (this == obj) {
                return true;
            }
            w1 w1Var = (w1) obj;
            if (this.f25666a == w1Var.f25666a && get() == w1Var.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f25666a;
    }
}
