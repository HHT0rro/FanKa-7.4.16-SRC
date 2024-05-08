package com.google.common.util.concurrent;

import com.google.common.util.concurrent.h;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TrustedListenableFutureTask<V> extends h.a<V> implements RunnableFuture<V> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class TrustedFutureInterruptibleAsyncTask extends InterruptibleTask<n<V>> {
        private final d<V> callable;
        public final /* synthetic */ TrustedListenableFutureTask this$0;

        public TrustedFutureInterruptibleAsyncTask(TrustedListenableFutureTask trustedListenableFutureTask, d<V> dVar) {
            this.callable = (d) com.google.common.base.o.r(dVar);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptiblyFailure(Throwable th) {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptiblySuccess(n<V> nVar) {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public n<V> runInterruptibly() throws Exception {
            return (n) com.google.common.base.o.t(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class TrustedFutureInterruptibleTask extends InterruptibleTask<V> {
        private final Callable<V> callable;
        public final /* synthetic */ TrustedListenableFutureTask this$0;

        public TrustedFutureInterruptibleTask(TrustedListenableFutureTask trustedListenableFutureTask, Callable<V> callable) {
            this.callable = (Callable) com.google.common.base.o.r(callable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptiblyFailure(Throwable th) {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public void afterRanInterruptiblySuccess(V v2) {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }
}
