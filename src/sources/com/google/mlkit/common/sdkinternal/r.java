package com.google.mlkit.common.sdkinternal;

import com.google.mlkit.common.sdkinternal.a;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Set;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class r extends PhantomReference<Object> implements a.InterfaceC0243a {

    /* renamed from: b, reason: collision with root package name */
    public final Set<r> f27066b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f27067c;

    public /* synthetic */ r(Object obj, ReferenceQueue referenceQueue, Set set, Runnable runnable, q qVar) {
        super(obj, referenceQueue);
        this.f27066b = set;
        this.f27067c = runnable;
    }

    @Override // com.google.mlkit.common.sdkinternal.a.InterfaceC0243a
    public final void a() {
        if (this.f27066b.remove(this)) {
            clear();
            this.f27067c.run();
        }
    }
}
