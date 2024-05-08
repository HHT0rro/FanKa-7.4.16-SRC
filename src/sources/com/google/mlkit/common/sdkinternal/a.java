package com.google.mlkit.common.sdkinternal;

import androidx.annotation.RecentlyNonNull;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.mlkit:common@@17.1.1 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final ReferenceQueue<Object> f27036a = new ReferenceQueue<>();

    /* renamed from: b, reason: collision with root package name */
    public final Set<r> f27037b = Collections.synchronizedSet(new HashSet());

    /* compiled from: com.google.mlkit:common@@17.1.1 */
    /* renamed from: com.google.mlkit.common.sdkinternal.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface InterfaceC0243a {
        void a();
    }

    @RecentlyNonNull
    public static a a() {
        a aVar = new a();
        aVar.b(aVar, o.f27063b);
        final ReferenceQueue<Object> referenceQueue = aVar.f27036a;
        final Set<r> set = aVar.f27037b;
        Thread thread = new Thread(new Runnable(referenceQueue, set) { // from class: com.google.mlkit.common.sdkinternal.p

            /* renamed from: b, reason: collision with root package name */
            public final ReferenceQueue f27064b;

            /* renamed from: c, reason: collision with root package name */
            public final Set f27065c;

            {
                this.f27064b = referenceQueue;
                this.f27065c = set;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ReferenceQueue referenceQueue2 = this.f27064b;
                Set set2 = this.f27065c;
                while (!set2.isEmpty()) {
                    try {
                        ((r) referenceQueue2.remove()).a();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }, "MlKitCleaner");
        thread.setDaemon(true);
        thread.start();
        return aVar;
    }

    @RecentlyNonNull
    public InterfaceC0243a b(@RecentlyNonNull Object obj, @RecentlyNonNull Runnable runnable) {
        r rVar = new r(obj, this.f27036a, this.f27037b, runnable, null);
        this.f27037b.add(rVar);
        return rVar;
    }
}
