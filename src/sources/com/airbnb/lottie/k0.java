package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* compiled from: LottieTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class k0<T> {

    /* renamed from: e, reason: collision with root package name */
    public static Executor f1945e = Executors.newCachedThreadPool();

    /* renamed from: a, reason: collision with root package name */
    public final Set<f0<T>> f1946a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<f0<Throwable>> f1947b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f1948c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public volatile LottieResult<T> f1949d;

    /* compiled from: LottieTask.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a extends FutureTask<LottieResult<T>> {
        public a(Callable<LottieResult<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                k0.this.k(get());
            } catch (InterruptedException | ExecutionException e2) {
                k0.this.k(new LottieResult(e2));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public k0(Callable<LottieResult<T>> callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        LottieResult<T> lottieResult = this.f1949d;
        if (lottieResult == null) {
            return;
        }
        if (lottieResult.getValue() != null) {
            h(lottieResult.getValue());
        } else {
            f(lottieResult.getException());
        }
    }

    public synchronized k0<T> c(f0<Throwable> f0Var) {
        LottieResult<T> lottieResult = this.f1949d;
        if (lottieResult != null && lottieResult.getException() != null) {
            f0Var.onResult(lottieResult.getException());
        }
        this.f1947b.add(f0Var);
        return this;
    }

    public synchronized k0<T> d(f0<T> f0Var) {
        LottieResult<T> lottieResult = this.f1949d;
        if (lottieResult != null && lottieResult.getValue() != null) {
            f0Var.onResult(lottieResult.getValue());
        }
        this.f1946a.add(f0Var);
        return this;
    }

    public final synchronized void f(Throwable th) {
        ArrayList arrayList = new ArrayList(this.f1947b);
        if (arrayList.isEmpty()) {
            n.d.d("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            ((f0) iterator2.next()).onResult(th);
        }
    }

    public final void g() {
        this.f1948c.post(new Runnable() { // from class: com.airbnb.lottie.j0
            @Override // java.lang.Runnable
            public final void run() {
                k0.this.e();
            }
        });
    }

    public final synchronized void h(T t2) {
        Iterator<E> iterator2 = new ArrayList(this.f1946a).iterator2();
        while (iterator2.hasNext()) {
            ((f0) iterator2.next()).onResult(t2);
        }
    }

    public synchronized k0<T> i(f0<Throwable> f0Var) {
        this.f1947b.remove(f0Var);
        return this;
    }

    public synchronized k0<T> j(f0<T> f0Var) {
        this.f1946a.remove(f0Var);
        return this;
    }

    public final void k(@Nullable LottieResult<T> lottieResult) {
        if (this.f1949d == null) {
            this.f1949d = lottieResult;
            g();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public k0(Callable<LottieResult<T>> callable, boolean z10) {
        this.f1946a = new LinkedHashSet(1);
        this.f1947b = new LinkedHashSet(1);
        this.f1948c = new Handler(Looper.getMainLooper());
        this.f1949d = null;
        if (z10) {
            try {
                k(callable.call());
                return;
            } catch (Throwable th) {
                k(new LottieResult<>(th));
                return;
            }
        }
        f1945e.execute(new a(callable));
    }
}
