package com.google.android.gms.internal.vision;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class x1 {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<w1, List<Throwable>> f25672a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b, reason: collision with root package name */
    public final ReferenceQueue<Throwable> f25673b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z10) {
        Reference<? extends Throwable> poll = this.f25673b.poll();
        while (poll != null) {
            this.f25672a.remove(poll);
            poll = this.f25673b.poll();
        }
        List<Throwable> list = this.f25672a.get(new w1(th, null));
        if (!z10 || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f25672a.putIfAbsent(new w1(th, this.f25673b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
