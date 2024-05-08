package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: ImmediateFuture.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class m<V> implements n<V> {

    /* renamed from: c, reason: collision with root package name */
    public static final n<?> f26819c = new m(null);

    /* renamed from: d, reason: collision with root package name */
    public static final Logger f26820d = Logger.getLogger(m.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public final V f26821b;

    /* compiled from: ImmediateFuture.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a<V> extends AbstractFuture.i<V> {
        public a(Throwable th) {
            setException(th);
        }
    }

    public m(V v2) {
        this.f26821b = v2;
    }

    @Override // com.google.common.util.concurrent.n
    public void addListener(Runnable runnable, Executor executor) {
        com.google.common.base.o.s(runnable, "Runnable was null.");
        com.google.common.base.o.s(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f26820d;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 57 + valueOf2.length());
            sb2.append("RuntimeException while executing runnable ");
            sb2.append(valueOf);
            sb2.append(" with executor ");
            sb2.append(valueOf2);
            logger.log(level, sb2.toString(), (Throwable) e2);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return this.f26821b;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    public String toString() {
        String obj = super.toString();
        String valueOf = String.valueOf(this.f26821b);
        StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 27 + valueOf.length());
        sb2.append(obj);
        sb2.append("[status=SUCCESS, result=[");
        sb2.append(valueOf);
        sb2.append("]]");
        return sb2.toString();
    }

    @Override // java.util.concurrent.Future
    public V get(long j10, TimeUnit timeUnit) throws ExecutionException {
        com.google.common.base.o.r(timeUnit);
        return get();
    }
}
