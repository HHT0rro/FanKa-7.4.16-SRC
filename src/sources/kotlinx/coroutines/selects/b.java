package kotlinx.coroutines.selects;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.p;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.n;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.o1;
import kotlinx.coroutines.t0;
import kotlinx.coroutines.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Select.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b<R> extends p implements kotlinx.coroutines.selects.a<R>, f<R>, Continuation<R>, td.c {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51486f = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_state");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51487g = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_result");

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Continuation<R> f51488e;

    @NotNull
    public volatile /* synthetic */ Object _state = g.e();

    @NotNull
    private volatile /* synthetic */ Object _result = g.c();

    @NotNull
    private volatile /* synthetic */ Object _parentHandle = null;

    /* compiled from: Select.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a extends kotlinx.coroutines.internal.d<Object> {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final b<?> f51489b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public final kotlinx.coroutines.internal.b f51490c;

        /* renamed from: d, reason: collision with root package name */
        public final long f51491d = g.b().a();

        public a(@NotNull b<?> bVar, @NotNull kotlinx.coroutines.internal.b bVar2) {
            this.f51489b = bVar;
            this.f51490c = bVar2;
            bVar2.d(this);
        }

        @Override // kotlinx.coroutines.internal.d
        public void d(@Nullable Object obj, @Nullable Object obj2) {
            j(obj2);
            this.f51490c.a(this, obj2);
        }

        @Override // kotlinx.coroutines.internal.d
        public long g() {
            return this.f51491d;
        }

        @Override // kotlinx.coroutines.internal.d
        @Nullable
        public Object i(@Nullable Object obj) {
            Object k10;
            if (obj == null && (k10 = k()) != null) {
                return k10;
            }
            try {
                return this.f51490c.c(this);
            } catch (Throwable th) {
                if (obj == null) {
                    l();
                }
                throw th;
            }
        }

        public final void j(Object obj) {
            boolean z10 = obj == null;
            if (androidx.concurrent.futures.a.a(b.f51486f, this.f51489b, this, z10 ? null : g.e()) && z10) {
                this.f51489b.S();
            }
        }

        public final Object k() {
            b<?> bVar = this.f51489b;
            while (true) {
                Object obj = bVar._state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof y) {
                    ((y) obj).c(this.f51489b);
                } else if (obj == g.e()) {
                    if (androidx.concurrent.futures.a.a(b.f51486f, this.f51489b, g.e(), this)) {
                        return null;
                    }
                } else {
                    return g.d();
                }
            }
        }

        public final void l() {
            androidx.concurrent.futures.a.a(b.f51486f, this.f51489b, this, g.e());
        }

        @Override // kotlinx.coroutines.internal.y
        @NotNull
        public String toString() {
            return "AtomicSelectOp(sequence=" + g() + ')';
        }
    }

    /* compiled from: Select.kt */
    @kotlin.d
    /* renamed from: kotlinx.coroutines.selects.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class C0782b extends LockFreeLinkedListNode {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public final t0 f51492e;

        public C0782b(@NotNull t0 t0Var) {
            this.f51492e = t0Var;
        }
    }

    /* compiled from: Select.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class c extends y {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public final LockFreeLinkedListNode.c f51493a;

        public c(@NotNull LockFreeLinkedListNode.c cVar) {
            this.f51493a = cVar;
        }

        @Override // kotlinx.coroutines.internal.y
        @NotNull
        public kotlinx.coroutines.internal.d<?> a() {
            return this.f51493a.a();
        }

        @Override // kotlinx.coroutines.internal.y
        @Nullable
        public Object c(@Nullable Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
            b bVar = (b) obj;
            this.f51493a.d();
            Object e2 = this.f51493a.a().e(null);
            androidx.concurrent.futures.a.a(b.f51486f, bVar, this, e2 == null ? this.f51493a.f51360c : g.e());
            return e2;
        }
    }

    /* compiled from: Select.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class d extends o1 {
        public d() {
        }

        @Override // kotlinx.coroutines.z
        public void P(@Nullable Throwable th) {
            if (b.this.l()) {
                b.this.n(Q().w());
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
            P(th);
            return kotlin.p.f51048a;
        }
    }

    /* compiled from: Runnable.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class e implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1 f51496c;

        public e(Function1 function1) {
            this.f51496c = function1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.l()) {
                ee.a.c(this.f51496c, b.this.m());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull Continuation<? super R> continuation) {
        this.f51488e = continuation;
    }

    public final void S() {
        t0 T = T();
        if (T != null) {
            T.dispose();
        }
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) E(); !s.d(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.F()) {
            if (lockFreeLinkedListNode instanceof C0782b) {
                ((C0782b) lockFreeLinkedListNode).f51492e.dispose();
            }
        }
    }

    public final t0 T() {
        return (t0) this._parentHandle;
    }

    @Nullable
    public final Object U() {
        if (!j()) {
            W();
        }
        Object obj = this._result;
        if (obj == g.c()) {
            if (androidx.concurrent.futures.a.a(f51487g, this, g.c(), sd.a.d())) {
                return sd.a.d();
            }
            obj = this._result;
        }
        if (obj != g.a()) {
            if (obj instanceof x) {
                throw ((x) obj).f51562a;
            }
            return obj;
        }
        throw new IllegalStateException("Already resumed");
    }

    public final void V(@NotNull Throwable th) {
        if (l()) {
            Result.Companion companion = Result.Companion;
            resumeWith(Result.m3565constructorimpl(kotlin.e.a(th)));
        } else {
            if (th instanceof CancellationException) {
                return;
            }
            Object U = U();
            if ((U instanceof x) && ((x) U).f51562a == th) {
                return;
            }
            e0.a(getContext(), th);
        }
    }

    public final void W() {
        n1 n1Var = (n1) getContext().get(n1.C0);
        if (n1Var == null) {
            return;
        }
        t0 d10 = n1.a.d(n1Var, true, false, new d(), 2, null);
        X(d10);
        if (j()) {
            d10.dispose();
        }
    }

    public final void X(t0 t0Var) {
        this._parentHandle = t0Var;
    }

    @Override // kotlinx.coroutines.selects.a
    public void d(long j10, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        if (j10 <= 0) {
            if (l()) {
                ee.b.c(function1, m());
            }
        } else {
            k(DelayKt.c(getContext()).l(j10, new e(function1), getContext()));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0030, code lost:
    
        S();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0035, code lost:
    
        return kotlinx.coroutines.n.f51447a;
     */
    @Override // kotlinx.coroutines.selects.f
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object f(@org.jetbrains.annotations.Nullable kotlinx.coroutines.internal.LockFreeLinkedListNode.c r4) {
        /*
            r3 = this;
        L0:
            java.lang.Object r0 = r3._state
            java.lang.Object r1 = kotlinx.coroutines.selects.g.e()
            r2 = 0
            if (r0 != r1) goto L36
            if (r4 != 0) goto L18
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.selects.b.f51486f
            java.lang.Object r1 = kotlinx.coroutines.selects.g.e()
            boolean r0 = androidx.concurrent.futures.a.a(r0, r3, r1, r2)
            if (r0 != 0) goto L30
            goto L0
        L18:
            kotlinx.coroutines.selects.b$c r0 = new kotlinx.coroutines.selects.b$c
            r0.<init>(r4)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.selects.b.f51486f
            java.lang.Object r2 = kotlinx.coroutines.selects.g.e()
            boolean r1 = androidx.concurrent.futures.a.a(r1, r3, r2, r0)
            if (r1 == 0) goto L0
            java.lang.Object r4 = r0.c(r3)
            if (r4 == 0) goto L30
            return r4
        L30:
            r3.S()
            kotlinx.coroutines.internal.f0 r4 = kotlinx.coroutines.n.f51447a
            return r4
        L36:
            boolean r1 = r0 instanceof kotlinx.coroutines.internal.y
            if (r1 == 0) goto L6a
            if (r4 == 0) goto L64
            kotlinx.coroutines.internal.d r1 = r4.a()
            boolean r2 = r1 instanceof kotlinx.coroutines.selects.b.a
            if (r2 == 0) goto L58
            r2 = r1
            kotlinx.coroutines.selects.b$a r2 = (kotlinx.coroutines.selects.b.a) r2
            kotlinx.coroutines.selects.b<?> r2 = r2.f51489b
            if (r2 == r3) goto L4c
            goto L58
        L4c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot use matching select clauses on the same object"
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            throw r4
        L58:
            r2 = r0
            kotlinx.coroutines.internal.y r2 = (kotlinx.coroutines.internal.y) r2
            boolean r1 = r1.b(r2)
            if (r1 == 0) goto L64
            java.lang.Object r4 = kotlinx.coroutines.internal.c.f51374b
            return r4
        L64:
            kotlinx.coroutines.internal.y r0 = (kotlinx.coroutines.internal.y) r0
            r0.c(r3)
            goto L0
        L6a:
            if (r4 != 0) goto L6d
            return r2
        L6d:
            kotlinx.coroutines.internal.LockFreeLinkedListNode$a r4 = r4.f51360c
            if (r0 != r4) goto L74
            kotlinx.coroutines.internal.f0 r4 = kotlinx.coroutines.n.f51447a
            return r4
        L74:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.b.f(kotlinx.coroutines.internal.LockFreeLinkedListNode$c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.selects.f
    @Nullable
    public Object g(@NotNull kotlinx.coroutines.internal.b bVar) {
        return new a(this, bVar).c(null);
    }

    @Override // td.c
    @Nullable
    public td.c getCallerFrame() {
        Continuation<R> continuation = this.f51488e;
        if (continuation instanceof td.c) {
            return (td.c) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return this.f51488e.getContext();
    }

    @Override // td.c
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.selects.f
    public boolean j() {
        while (true) {
            Object obj = this._state;
            if (obj == g.e()) {
                return false;
            }
            if (!(obj instanceof y)) {
                return true;
            }
            ((y) obj).c(this);
        }
    }

    @Override // kotlinx.coroutines.selects.f
    public void k(@NotNull t0 t0Var) {
        C0782b c0782b = new C0782b(t0Var);
        if (!j()) {
            u(c0782b);
            if (!j()) {
                return;
            }
        }
        t0Var.dispose();
    }

    @Override // kotlinx.coroutines.selects.f
    public boolean l() {
        Object f10 = f(null);
        if (f10 == n.f51447a) {
            return true;
        }
        if (f10 == null) {
            return false;
        }
        throw new IllegalStateException(("Unexpected trySelectIdempotent result " + f10).toString());
    }

    @Override // kotlinx.coroutines.selects.f
    @NotNull
    public Continuation<R> m() {
        return this;
    }

    @Override // kotlinx.coroutines.selects.f
    public void n(@NotNull Throwable th) {
        while (true) {
            Object obj = this._result;
            if (obj == g.c()) {
                if (androidx.concurrent.futures.a.a(f51487g, this, g.c(), new x(th, false, 2, null))) {
                    return;
                }
            } else {
                if (obj != sd.a.d()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (androidx.concurrent.futures.a.a(f51487g, this, sd.a.d(), g.a())) {
                    Continuation c4 = IntrinsicsKt__IntrinsicsJvmKt.c(this.f51488e);
                    Result.Companion companion = Result.Companion;
                    c4.resumeWith(Result.m3565constructorimpl(kotlin.e.a(th)));
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.a
    public <Q> void o(@NotNull kotlinx.coroutines.selects.d<? extends Q> dVar, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        dVar.a(this, function2);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        while (true) {
            Object obj2 = this._result;
            if (obj2 == g.c()) {
                if (androidx.concurrent.futures.a.a(f51487g, this, g.c(), a0.d(obj, null, 1, null))) {
                    return;
                }
            } else {
                if (obj2 != sd.a.d()) {
                    throw new IllegalStateException("Already resumed");
                }
                if (androidx.concurrent.futures.a.a(f51487g, this, sd.a.d(), g.a())) {
                    if (Result.m3571isFailureimpl(obj)) {
                        Continuation<R> continuation = this.f51488e;
                        Throwable m3568exceptionOrNullimpl = Result.m3568exceptionOrNullimpl(obj);
                        s.f(m3568exceptionOrNullimpl);
                        Result.Companion companion = Result.Companion;
                        continuation.resumeWith(Result.m3565constructorimpl(kotlin.e.a(m3568exceptionOrNullimpl)));
                        return;
                    }
                    this.f51488e.resumeWith(obj);
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    @NotNull
    public String toString() {
        return "SelectInstance(state=" + this._state + ", result=" + this._result + ')';
    }
}
