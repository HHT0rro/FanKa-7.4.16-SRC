package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CancellableContinuationImpl.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class m<T> extends o0<T> implements l<T>, td.c {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f51440h = AtomicIntegerFieldUpdater.newUpdater(m.class, "_decision");

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51441i = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_state");

    @NotNull
    private volatile /* synthetic */ int _decision;

    @NotNull
    private volatile /* synthetic */ Object _state;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Continuation<T> f51442e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final CoroutineContext f51443f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public t0 f51444g;

    /* JADX WARN: Multi-variable type inference failed */
    public m(@NotNull Continuation<? super T> continuation, int i10) {
        super(i10);
        this.f51442e = continuation;
        this.f51443f = continuation.getContext();
        this._decision = 0;
        this._state = d.f51180b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void L(m mVar, Object obj, int i10, Function1 function1, int i11, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i11 & 4) != 0) {
            function1 = null;
        }
        mVar.K(obj, i10, function1);
    }

    public boolean A() {
        return !(u() instanceof a2);
    }

    @Override // kotlinx.coroutines.l
    @Nullable
    public Object B(T t2, @Nullable Object obj, @Nullable Function1<? super Throwable, kotlin.p> function1) {
        return O(t2, obj, function1);
    }

    @Override // kotlinx.coroutines.l
    public void C(@NotNull CoroutineDispatcher coroutineDispatcher, T t2) {
        Continuation<T> continuation = this.f51442e;
        kotlinx.coroutines.internal.i iVar = continuation instanceof kotlinx.coroutines.internal.i ? (kotlinx.coroutines.internal.i) continuation : null;
        L(this, t2, (iVar != null ? iVar.f51388e : null) == coroutineDispatcher ? 4 : this.f51451d, null, 4, null);
    }

    public final boolean D() {
        return p0.c(this.f51451d) && ((kotlinx.coroutines.internal.i) this.f51442e).l();
    }

    public final j E(Function1<? super Throwable, kotlin.p> function1) {
        return function1 instanceof j ? (j) function1 : new k1(function1);
    }

    public final void F(Function1<? super Throwable, kotlin.p> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + ((Object) function1) + ", already has " + obj).toString());
    }

    @NotNull
    public String G() {
        return "CancellableContinuation";
    }

    public final void H(@NotNull Throwable th) {
        if (m(th)) {
            return;
        }
        l(th);
        o();
    }

    public final void I() {
        Throwable o10;
        Continuation<T> continuation = this.f51442e;
        kotlinx.coroutines.internal.i iVar = continuation instanceof kotlinx.coroutines.internal.i ? (kotlinx.coroutines.internal.i) continuation : null;
        if (iVar == null || (o10 = iVar.o(this)) == null) {
            return;
        }
        n();
        l(o10);
    }

    public final boolean J() {
        Object obj = this._state;
        if ((obj instanceof w) && ((w) obj).f51557d != null) {
            n();
            return false;
        }
        this._decision = 0;
        this._state = d.f51180b;
        return true;
    }

    public final void K(Object obj, int i10, Function1<? super Throwable, kotlin.p> function1) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof a2) {
            } else {
                if (obj2 instanceof p) {
                    p pVar = (p) obj2;
                    if (pVar.c()) {
                        if (function1 != null) {
                            k(function1, pVar.f51562a);
                            return;
                        }
                        return;
                    }
                }
                g(obj);
                throw new KotlinNothingValueException();
            }
        } while (!androidx.concurrent.futures.a.a(f51441i, this, obj2, M((a2) obj2, obj, i10, function1, null)));
        o();
        p(i10);
    }

    public final Object M(a2 a2Var, Object obj, int i10, Function1<? super Throwable, kotlin.p> function1, Object obj2) {
        if (obj instanceof x) {
            return obj;
        }
        if (!p0.b(i10) && obj2 == null) {
            return obj;
        }
        if (function1 != null || (((a2Var instanceof j) && !(a2Var instanceof e)) || obj2 != null)) {
            return new w(obj, a2Var instanceof j ? (j) a2Var : null, function1, obj2, null, 16, null);
        }
        return obj;
    }

    public final boolean N() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f51440h.compareAndSet(this, 0, 2));
        return true;
    }

    public final kotlinx.coroutines.internal.f0 O(Object obj, Object obj2, Function1<? super Throwable, kotlin.p> function1) {
        Object obj3;
        do {
            obj3 = this._state;
            if (obj3 instanceof a2) {
            } else {
                if ((obj3 instanceof w) && obj2 != null && ((w) obj3).f51557d == obj2) {
                    return n.f51447a;
                }
                return null;
            }
        } while (!androidx.concurrent.futures.a.a(f51441i, this, obj3, M((a2) obj3, obj, this.f51451d, function1, obj2)));
        o();
        return n.f51447a;
    }

    public final boolean P() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f51440h.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // kotlinx.coroutines.o0
    public void a(@Nullable Object obj, @NotNull Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (!(obj2 instanceof a2)) {
                if (obj2 instanceof x) {
                    return;
                }
                if (obj2 instanceof w) {
                    w wVar = (w) obj2;
                    if (!wVar.c()) {
                        if (androidx.concurrent.futures.a.a(f51441i, this, obj2, w.b(wVar, null, null, null, null, th, 15, null))) {
                            wVar.d(this, th);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (androidx.concurrent.futures.a.a(f51441i, this, obj2, new w(obj2, null, null, null, th, 14, null))) {
                    return;
                }
            } else {
                throw new IllegalStateException("Not completed".toString());
            }
        }
    }

    @Override // kotlinx.coroutines.o0
    @NotNull
    public final Continuation<T> b() {
        return this.f51442e;
    }

    @Override // kotlinx.coroutines.o0
    @Nullable
    public Throwable c(@Nullable Object obj) {
        Throwable c4 = super.c(obj);
        if (c4 != null) {
            return c4;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.o0
    public <T> T d(@Nullable Object obj) {
        return obj instanceof w ? (T) ((w) obj).f51554a : obj;
    }

    @Override // kotlinx.coroutines.o0
    @Nullable
    public Object f() {
        return u();
    }

    public final Void g(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    @Override // td.c
    @Nullable
    public td.c getCallerFrame() {
        Continuation<T> continuation = this.f51442e;
        if (continuation instanceof td.c) {
            return (td.c) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return this.f51443f;
    }

    @Override // td.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.l
    public void h(T t2, @Nullable Function1<? super Throwable, kotlin.p> function1) {
        K(t2, this.f51451d, function1);
    }

    public final void i(Function1<? super Throwable, kotlin.p> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            e0.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + ((Object) this), th2));
        }
    }

    public final void j(@NotNull j jVar, @Nullable Throwable th) {
        try {
            jVar.a(th);
        } catch (Throwable th2) {
            e0.a(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + ((Object) this), th2));
        }
    }

    public final void k(@NotNull Function1<? super Throwable, kotlin.p> function1, @NotNull Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            e0.a(getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + ((Object) this), th2));
        }
    }

    public boolean l(@Nullable Throwable th) {
        Object obj;
        boolean z10;
        do {
            obj = this._state;
            if (!(obj instanceof a2)) {
                return false;
            }
            z10 = obj instanceof j;
        } while (!androidx.concurrent.futures.a.a(f51441i, this, obj, new p(this, th, z10)));
        j jVar = z10 ? (j) obj : null;
        if (jVar != null) {
            j(jVar, th);
        }
        o();
        p(this.f51451d);
        return true;
    }

    public final boolean m(Throwable th) {
        if (D()) {
            return ((kotlinx.coroutines.internal.i) this.f51442e).m(th);
        }
        return false;
    }

    public final void n() {
        t0 t0Var = this.f51444g;
        if (t0Var == null) {
            return;
        }
        t0Var.dispose();
        this.f51444g = z1.f51576b;
    }

    public final void o() {
        if (D()) {
            return;
        }
        n();
    }

    public final void p(int i10) {
        if (N()) {
            return;
        }
        p0.a(this, i10);
    }

    @NotNull
    public Throwable q(@NotNull n1 n1Var) {
        return n1Var.w();
    }

    @Nullable
    public final Object r() {
        n1 n1Var;
        boolean D = D();
        if (P()) {
            if (this.f51444g == null) {
                z();
            }
            if (D) {
                I();
            }
            return sd.a.d();
        }
        if (D) {
            I();
        }
        Object u10 = u();
        if (!(u10 instanceof x)) {
            if (p0.b(this.f51451d) && (n1Var = (n1) getContext().get(n1.C0)) != null && !n1Var.isActive()) {
                CancellationException w3 = n1Var.w();
                a(u10, w3);
                throw w3;
            }
            return d(u10);
        }
        throw ((x) u10).f51562a;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        L(this, a0.c(obj, this), this.f51451d, null, 4, null);
    }

    @Override // kotlinx.coroutines.l
    public void s(@NotNull Object obj) {
        p(this.f51451d);
    }

    @Override // kotlinx.coroutines.l
    @Nullable
    public Object t(T t2, @Nullable Object obj) {
        return O(t2, obj, null);
    }

    @NotNull
    public String toString() {
        return G() + '(' + j0.c(this.f51442e) + "){" + w() + "}@" + j0.b(this);
    }

    @Nullable
    public final Object u() {
        return this._state;
    }

    @Override // kotlinx.coroutines.l
    public void v(@NotNull Function1<? super Throwable, kotlin.p> function1) {
        j E = E(function1);
        while (true) {
            Object obj = this._state;
            if (obj instanceof d) {
                if (androidx.concurrent.futures.a.a(f51441i, this, obj, E)) {
                    return;
                }
            } else if (obj instanceof j) {
                F(function1, obj);
            } else {
                boolean z10 = obj instanceof x;
                if (z10) {
                    x xVar = (x) obj;
                    if (!xVar.b()) {
                        F(function1, obj);
                    }
                    if (obj instanceof p) {
                        if (!z10) {
                            xVar = null;
                        }
                        i(function1, xVar != null ? xVar.f51562a : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof w) {
                    w wVar = (w) obj;
                    if (wVar.f51555b != null) {
                        F(function1, obj);
                    }
                    if (E instanceof e) {
                        return;
                    }
                    if (wVar.c()) {
                        i(function1, wVar.f51558e);
                        return;
                    } else {
                        if (androidx.concurrent.futures.a.a(f51441i, this, obj, w.b(wVar, null, E, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (E instanceof e) {
                        return;
                    }
                    if (androidx.concurrent.futures.a.a(f51441i, this, obj, new w(obj, E, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    public final String w() {
        Object u10 = u();
        return u10 instanceof a2 ? "Active" : u10 instanceof p ? "Cancelled" : "Completed";
    }

    @Override // kotlinx.coroutines.l
    @Nullable
    public Object x(@NotNull Throwable th) {
        return O(new x(th, false, 2, null), null, null);
    }

    public void y() {
        t0 z10 = z();
        if (z10 != null && A()) {
            z10.dispose();
            this.f51444g = z1.f51576b;
        }
    }

    public final t0 z() {
        n1 n1Var = (n1) getContext().get(n1.C0);
        if (n1Var == null) {
            return null;
        }
        t0 d10 = n1.a.d(n1Var, true, false, new q(this), 2, null);
        this.f51444g = d10;
        return d10;
    }
}
