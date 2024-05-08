package com.google.mlkit.vision.common.internal;

import androidx.annotation.RecentlyNonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.h;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.f;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import java.io.Closeable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import p7.b;
import p7.i;

/* compiled from: com.google.mlkit:vision-common@@16.3.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MobileVisionBase<DetectionResultT> implements Closeable, LifecycleObserver {

    /* renamed from: f, reason: collision with root package name */
    public static final e f27084f = new e("MobileVisionBase", "");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f27085g = 0;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f27086b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public final f<DetectionResultT, m8.a> f27087c;

    /* renamed from: d, reason: collision with root package name */
    public final b f27088d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f27089e;

    public MobileVisionBase(@RecentlyNonNull f<DetectionResultT, m8.a> fVar, @RecentlyNonNull Executor executor) {
        this.f27087c = fVar;
        b bVar = new b();
        this.f27088d = bVar;
        this.f27089e = executor;
        fVar.c();
        fVar.a(executor, n8.e.f52170b, bVar.b()).b(n8.f.f52171a);
    }

    @RecentlyNonNull
    public synchronized p7.f<DetectionResultT> a(@RecentlyNonNull final m8.a aVar) {
        h.i(aVar, "InputImage can not be null");
        if (this.f27086b.get()) {
            return i.b(new MlKitException("This detector is already closed!", 14));
        }
        if (aVar.i() >= 32 && aVar.e() >= 32) {
            return this.f27087c.a(this.f27089e, new Callable(this, aVar) { // from class: n8.g

                /* renamed from: b, reason: collision with root package name */
                public final MobileVisionBase f52172b;

                /* renamed from: c, reason: collision with root package name */
                public final m8.a f52173c;

                {
                    this.f52172b = this;
                    this.f52173c = aVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f52172b.b(this.f52173c);
                }
            }, this.f27088d.b());
        }
        return i.b(new MlKitException("InputImage width and height should be at least 32!", 3));
    }

    public final /* synthetic */ Object b(m8.a aVar) throws Exception {
        return this.f27087c.h(aVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public synchronized void close() {
        if (this.f27086b.getAndSet(true)) {
            return;
        }
        this.f27088d.a();
        this.f27087c.e(this.f27089e);
    }
}
