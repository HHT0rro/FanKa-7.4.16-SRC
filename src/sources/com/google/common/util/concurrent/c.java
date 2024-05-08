package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: AggregateFutureState.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class c<OutputT> extends AbstractFuture.i<OutputT> {

    /* renamed from: d, reason: collision with root package name */
    public static final b f26806d;

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f26807e = Logger.getLogger(c.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public volatile Set<Throwable> f26808b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f26809c;

    /* compiled from: AggregateFutureState.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class b {
        public b() {
        }
    }

    /* compiled from: AggregateFutureState.java */
    /* renamed from: com.google.common.util.concurrent.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class C0242c extends b {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<c<?>, Set<Throwable>> f26810a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicIntegerFieldUpdater<c<?>> f26811b;

        public C0242c(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.f26810a = atomicReferenceFieldUpdater;
            this.f26811b = atomicIntegerFieldUpdater;
        }
    }

    /* compiled from: AggregateFutureState.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class d extends b {
        public d() {
            super();
        }
    }

    static {
        b bVar;
        Throwable th = null;
        byte b4 = 0;
        try {
            bVar = new C0242c(AtomicReferenceFieldUpdater.newUpdater(c.class, Set.class, "b"), AtomicIntegerFieldUpdater.newUpdater(c.class, "c"));
        } catch (Throwable th2) {
            d dVar = new d();
            th = th2;
            bVar = dVar;
        }
        f26806d = bVar;
        if (th != null) {
            f26807e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }
}
