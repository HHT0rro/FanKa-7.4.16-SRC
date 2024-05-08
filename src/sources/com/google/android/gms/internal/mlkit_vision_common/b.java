package com.google.android.gms.internal.mlkit_vision_common;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<p7, List<Throwable>> f24236a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b, reason: collision with root package name */
    public final ReferenceQueue<Throwable> f24237b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z10) {
        ReferenceQueue<Throwable> referenceQueue = this.f24237b;
        while (true) {
            Reference<? extends Throwable> poll = referenceQueue.poll();
            if (poll == null) {
                break;
            }
            this.f24236a.remove(poll);
            referenceQueue = this.f24237b;
        }
        List<Throwable> list = this.f24236a.get(new p7(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f24236a.putIfAbsent(new p7(th, this.f24237b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
