package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.j2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.x0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DispatchedContinuation.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class i<T> extends o0<T> implements td.c, Continuation<T> {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51387i = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_reusableCancellableContinuation");

    @NotNull
    private volatile /* synthetic */ Object _reusableCancellableContinuation;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final CoroutineDispatcher f51388e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Continuation<T> f51389f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public Object f51390g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Object f51391h;

    /* JADX WARN: Multi-variable type inference failed */
    public i(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Continuation<? super T> continuation) {
        super(-1);
        this.f51388e = coroutineDispatcher;
        this.f51389f = continuation;
        this.f51390g = j.a();
        this.f51391h = ThreadContextKt.b(getContext());
        this._reusableCancellableContinuation = null;
    }

    @Override // kotlinx.coroutines.o0
    public void a(@Nullable Object obj, @NotNull Throwable th) {
        if (obj instanceof kotlinx.coroutines.y) {
            ((kotlinx.coroutines.y) obj).f51567b.invoke(th);
        }
    }

    @Override // kotlinx.coroutines.o0
    @NotNull
    public Continuation<T> b() {
        return this;
    }

    @Override // kotlinx.coroutines.o0
    @Nullable
    public Object f() {
        Object obj = this.f51390g;
        this.f51390g = j.a();
        return obj;
    }

    public final void g() {
        do {
        } while (this._reusableCancellableContinuation == j.f51393b);
    }

    @Override // td.c
    @Nullable
    public td.c getCallerFrame() {
        Continuation<T> continuation = this.f51389f;
        if (continuation instanceof td.c) {
            return (td.c) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return this.f51389f.getContext();
    }

    @Override // td.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Nullable
    public final kotlinx.coroutines.m<T> i() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = j.f51393b;
                return null;
            }
            if (obj instanceof kotlinx.coroutines.m) {
                if (androidx.concurrent.futures.a.a(f51387i, this, obj, j.f51393b)) {
                    return (kotlinx.coroutines.m) obj;
                }
            } else if (obj != j.f51393b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void j(@NotNull CoroutineContext coroutineContext, T t2) {
        this.f51390g = t2;
        this.f51451d = 1;
        this.f51388e.dispatchYield(coroutineContext, this);
    }

    public final kotlinx.coroutines.m<?> k() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof kotlinx.coroutines.m) {
            return (kotlinx.coroutines.m) obj;
        }
        return null;
    }

    public final boolean l() {
        return this._reusableCancellableContinuation != null;
    }

    public final boolean m(@NotNull Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            f0 f0Var = j.f51393b;
            if (kotlin.jvm.internal.s.d(obj, f0Var)) {
                if (androidx.concurrent.futures.a.a(f51387i, this, f0Var, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (androidx.concurrent.futures.a.a(f51387i, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void n() {
        g();
        kotlinx.coroutines.m<?> k10 = k();
        if (k10 != null) {
            k10.n();
        }
    }

    @Nullable
    public final Throwable o(@NotNull kotlinx.coroutines.l<?> lVar) {
        f0 f0Var;
        do {
            Object obj = this._reusableCancellableContinuation;
            f0Var = j.f51393b;
            if (obj != f0Var) {
                if (obj instanceof Throwable) {
                    if (androidx.concurrent.futures.a.a(f51387i, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!androidx.concurrent.futures.a.a(f51387i, this, f0Var, lVar));
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        CoroutineContext context = this.f51389f.getContext();
        Object d10 = kotlinx.coroutines.a0.d(obj, null, 1, null);
        if (this.f51388e.isDispatchNeeded(context)) {
            this.f51390g = d10;
            this.f51451d = 0;
            this.f51388e.dispatch(context, this);
            return;
        }
        x0 a10 = j2.f51426a.a();
        if (a10.G()) {
            this.f51390g = d10;
            this.f51451d = 0;
            a10.B(this);
            return;
        }
        a10.D(true);
        try {
            CoroutineContext context2 = getContext();
            Object c4 = ThreadContextKt.c(context2, this.f51391h);
            try {
                this.f51389f.resumeWith(obj);
                kotlin.p pVar = kotlin.p.f51048a;
                do {
                } while (a10.I());
            } finally {
                ThreadContextKt.a(context2, c4);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    @NotNull
    public String toString() {
        return "DispatchedContinuation[" + ((Object) this.f51388e) + ", " + kotlinx.coroutines.j0.c(this.f51389f) + ']';
    }
}
