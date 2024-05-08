package com.google.android.gms.internal.mlkit_common;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<p, List<Throwable>> f24190a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b, reason: collision with root package name */
    public final ReferenceQueue<Throwable> f24191b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z10) {
        ReferenceQueue<Throwable> referenceQueue = this.f24191b;
        while (true) {
            Reference<? extends Throwable> poll = referenceQueue.poll();
            if (poll == null) {
                break;
            }
            this.f24190a.remove(poll);
            referenceQueue = this.f24191b;
        }
        List<Throwable> list = this.f24190a.get(new p(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f24190a.putIfAbsent(new p(th, this.f24191b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
