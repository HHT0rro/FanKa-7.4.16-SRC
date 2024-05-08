package com.google.common.util.concurrent;

import com.google.common.util.concurrent.m;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* compiled from: Futures.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class i extends l {
    public static <V> V a(Future<V> future) throws ExecutionException {
        com.google.common.base.o.B(future.isDone(), "Future was expected to be done: %s", future);
        return (V) w.a(future);
    }

    public static <V> n<V> b(Throwable th) {
        com.google.common.base.o.r(th);
        return new m.a(th);
    }

    public static <V> n<V> c(V v2) {
        if (v2 == null) {
            return (n<V>) m.f26819c;
        }
        return new m(v2);
    }

    public static <I, O> n<O> d(n<I> nVar, com.google.common.base.g<? super I, ? extends O> gVar, Executor executor) {
        return b.a(nVar, gVar, executor);
    }
}
