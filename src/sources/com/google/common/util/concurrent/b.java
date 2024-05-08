package com.google.common.util.concurrent;

import com.google.common.util.concurrent.h;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* compiled from: AbstractTransformFuture.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class b<I, O, F, T> extends h.a<O> implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public n<? extends I> f26804b;

    /* renamed from: c, reason: collision with root package name */
    public F f26805c;

    /* compiled from: AbstractTransformFuture.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a<I, O> extends b<I, O, com.google.common.base.g<? super I, ? extends O>, O> {
        public a(n<? extends I> nVar, com.google.common.base.g<? super I, ? extends O> gVar) {
            super(nVar, gVar);
        }

        @Override // com.google.common.util.concurrent.b
        public void c(O o10) {
            set(o10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public O b(com.google.common.base.g<? super I, ? extends O> gVar, I i10) {
            return gVar.apply(i10);
        }
    }

    public b(n<? extends I> nVar, F f10) {
        this.f26804b = (n) com.google.common.base.o.r(nVar);
        this.f26805c = (F) com.google.common.base.o.r(f10);
    }

    public static <I, O> n<O> a(n<I> nVar, com.google.common.base.g<? super I, ? extends O> gVar, Executor executor) {
        com.google.common.base.o.r(gVar);
        a aVar = new a(nVar, gVar);
        nVar.addListener(aVar, p.b(executor, aVar));
        return aVar;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.f26804b);
        this.f26804b = null;
        this.f26805c = null;
    }

    public abstract T b(F f10, I i10) throws Exception;

    public abstract void c(T t2);

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        String str;
        n<? extends I> nVar = this.f26804b;
        F f10 = this.f26805c;
        String pendingToString = super.pendingToString();
        if (nVar != null) {
            String valueOf = String.valueOf(nVar);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 16);
            sb2.append("inputFuture=[");
            sb2.append(valueOf);
            sb2.append("], ");
            str = sb2.toString();
        } else {
            str = "";
        }
        if (f10 == null) {
            if (pendingToString == null) {
                return null;
            }
            String valueOf2 = String.valueOf(str);
            return pendingToString.length() != 0 ? valueOf2.concat(pendingToString) : new String(valueOf2);
        }
        String valueOf3 = String.valueOf(f10);
        StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 11 + valueOf3.length());
        sb3.append(str);
        sb3.append("function=[");
        sb3.append(valueOf3);
        sb3.append("]");
        return sb3.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        n<? extends I> nVar = this.f26804b;
        F f10 = this.f26805c;
        if ((isCancelled() | (nVar == null)) || (f10 == null)) {
            return;
        }
        this.f26804b = null;
        if (nVar.isCancelled()) {
            setFuture(nVar);
            return;
        }
        try {
            try {
                Object b4 = b(f10, i.a(nVar));
                this.f26805c = null;
                c(b4);
            } catch (Throwable th) {
                try {
                    setException(th);
                } finally {
                    this.f26805c = null;
                }
            }
        } catch (Error e2) {
            setException(e2);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e10) {
            setException(e10);
        } catch (ExecutionException e11) {
            setException(e11.getCause());
        }
    }
}
