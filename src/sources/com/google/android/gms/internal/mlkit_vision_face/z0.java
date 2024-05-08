package com.google.android.gms.internal.mlkit_vision_face;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@16.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class z0 {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<y0, List<Throwable>> f25346a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b, reason: collision with root package name */
    public final ReferenceQueue<Throwable> f25347b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z10) {
        ReferenceQueue<Throwable> referenceQueue = this.f25347b;
        while (true) {
            Reference<? extends Throwable> poll = referenceQueue.poll();
            if (poll == null) {
                break;
            }
            this.f25346a.remove(poll);
            referenceQueue = this.f25347b;
        }
        List<Throwable> list = this.f25346a.get(new y0(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f25346a.putIfAbsent(new y0(th, this.f25347b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
