package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JobSupport.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class u1 implements n1, t, b2, kotlinx.coroutines.selects.c {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51538b = AtomicReferenceFieldUpdater.newUpdater(u1.class, Object.class, "_state");

    @NotNull
    private volatile /* synthetic */ Object _parentHandle;

    @NotNull
    private volatile /* synthetic */ Object _state;

    /* compiled from: JobSupport.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a extends t1 {

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        public final u1 f51539f;

        /* renamed from: g, reason: collision with root package name */
        @NotNull
        public final b f51540g;

        /* renamed from: h, reason: collision with root package name */
        @NotNull
        public final s f51541h;

        /* renamed from: i, reason: collision with root package name */
        @Nullable
        public final Object f51542i;

        public a(@NotNull u1 u1Var, @NotNull b bVar, @NotNull s sVar, @Nullable Object obj) {
            this.f51539f = u1Var;
            this.f51540g = bVar;
            this.f51541h = sVar;
            this.f51542i = obj;
        }

        @Override // kotlinx.coroutines.z
        public void P(@Nullable Throwable th) {
            this.f51539f.T(this.f51540g, this.f51541h, this.f51542i);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
            P(th);
            return kotlin.p.f51048a;
        }
    }

    /* compiled from: JobSupport.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class b implements h1 {

        @NotNull
        private volatile /* synthetic */ Object _exceptionsHolder = null;

        @NotNull
        private volatile /* synthetic */ int _isCompleting;

        @NotNull
        private volatile /* synthetic */ Object _rootCause;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final y1 f51543b;

        public b(@NotNull y1 y1Var, boolean z10, @Nullable Throwable th) {
            this.f51543b = y1Var;
            this._isCompleting = z10 ? 1 : 0;
            this._rootCause = th;
        }

        public final void a(@NotNull Throwable th) {
            Throwable e2 = e();
            if (e2 == null) {
                l(th);
                return;
            }
            if (th == e2) {
                return;
            }
            Object d10 = d();
            if (d10 == null) {
                k(th);
                return;
            }
            if (d10 instanceof Throwable) {
                if (th == d10) {
                    return;
                }
                ArrayList<Throwable> b4 = b();
                b4.add(d10);
                b4.add(th);
                k(b4);
                return;
            }
            if (d10 instanceof ArrayList) {
                ((ArrayList) d10).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + d10).toString());
        }

        public final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        @Override // kotlinx.coroutines.h1
        @NotNull
        public y1 c() {
            return this.f51543b;
        }

        public final Object d() {
            return this._exceptionsHolder;
        }

        @Nullable
        public final Throwable e() {
            return (Throwable) this._rootCause;
        }

        public final boolean f() {
            return e() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        public final boolean g() {
            return this._isCompleting;
        }

        public final boolean h() {
            return d() == v1.e();
        }

        @NotNull
        public final List<Throwable> i(@Nullable Throwable th) {
            ArrayList<Throwable> arrayList;
            Object d10 = d();
            if (d10 == null) {
                arrayList = b();
            } else if (d10 instanceof Throwable) {
                ArrayList<Throwable> b4 = b();
                b4.add(d10);
                arrayList = b4;
            } else {
                if (!(d10 instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + d10).toString());
                }
                arrayList = (ArrayList) d10;
            }
            Throwable e2 = e();
            if (e2 != null) {
                arrayList.add(0, e2);
            }
            if (th != null && !kotlin.jvm.internal.s.d(th, e2)) {
                arrayList.add(th);
            }
            k(v1.e());
            return arrayList;
        }

        @Override // kotlinx.coroutines.h1
        public boolean isActive() {
            return e() == null;
        }

        public final void j(boolean z10) {
            this._isCompleting = z10 ? 1 : 0;
        }

        public final void k(Object obj) {
            this._exceptionsHolder = obj;
        }

        public final void l(@Nullable Throwable th) {
            this._rootCause = th;
        }

        @NotNull
        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + ((Object) e()) + ", exceptions=" + d() + ", list=" + ((Object) c()) + ']';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class c extends LockFreeLinkedListNode.b {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ u1 f51544d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f51545e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(LockFreeLinkedListNode lockFreeLinkedListNode, u1 u1Var, Object obj) {
            super(lockFreeLinkedListNode);
            this.f51544d = u1Var;
            this.f51545e = obj;
        }

        @Override // kotlinx.coroutines.internal.d
        @Nullable
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Object i(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (this.f51544d.d0() == this.f51545e) {
                return null;
            }
            return kotlinx.coroutines.internal.q.a();
        }
    }

    public u1(boolean z10) {
        this._state = z10 ? v1.c() : v1.d();
        this._parentHandle = null;
    }

    public static /* synthetic */ CancellationException B0(u1 u1Var, Throwable th, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        return u1Var.A0(th, str);
    }

    @NotNull
    public final CancellationException A0(@NotNull Throwable th, @Nullable String str) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = Q();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    @NotNull
    public final String C0() {
        return n0() + '{' + z0(d0()) + '}';
    }

    public final boolean D0(h1 h1Var, Object obj) {
        if (!androidx.concurrent.futures.a.a(f51538b, this, h1Var, v1.g(obj))) {
            return false;
        }
        r0(null);
        s0(obj);
        S(h1Var, obj);
        return true;
    }

    public final boolean E0(h1 h1Var, Throwable th) {
        y1 b02 = b0(h1Var);
        if (b02 == null) {
            return false;
        }
        if (!androidx.concurrent.futures.a.a(f51538b, this, h1Var, new b(b02, false, th))) {
            return false;
        }
        p0(b02, th);
        return true;
    }

    public final Object F0(Object obj, Object obj2) {
        if (!(obj instanceof h1)) {
            return v1.a();
        }
        if ((!(obj instanceof w0) && !(obj instanceof t1)) || (obj instanceof s) || (obj2 instanceof x)) {
            return G0((h1) obj, obj2);
        }
        return D0((h1) obj, obj2) ? obj2 : v1.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Throwable, T] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final Object G0(h1 h1Var, Object obj) {
        y1 b02 = b0(h1Var);
        if (b02 == null) {
            return v1.b();
        }
        b bVar = h1Var instanceof b ? (b) h1Var : null;
        if (bVar == null) {
            bVar = new b(b02, false, null);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        synchronized (bVar) {
            if (bVar.g()) {
                return v1.a();
            }
            bVar.j(true);
            if (bVar != h1Var && !androidx.concurrent.futures.a.a(f51538b, this, h1Var, bVar)) {
                return v1.b();
            }
            boolean f10 = bVar.f();
            x xVar = obj instanceof x ? (x) obj : null;
            if (xVar != null) {
                bVar.a(xVar.f51562a);
            }
            ?? e2 = Boolean.valueOf(f10 ? false : true).booleanValue() ? bVar.e() : 0;
            ref$ObjectRef.element = e2;
            kotlin.p pVar = kotlin.p.f51048a;
            if (e2 != 0) {
                p0(b02, e2);
            }
            s W = W(h1Var);
            if (W != null && H0(bVar, W, obj)) {
                return v1.f51548b;
            }
            return V(bVar, obj);
        }
    }

    public final boolean H0(b bVar, s sVar, Object obj) {
        while (n1.a.d(sVar.f51463f, false, false, new a(this, bVar, sVar, obj), 1, null) == z1.f51576b) {
            sVar = o0(sVar);
            if (sVar == null) {
                return false;
            }
        }
        return true;
    }

    public final boolean I(Object obj, y1 y1Var, t1 t1Var) {
        int O;
        c cVar = new c(t1Var, this, obj);
        do {
            O = y1Var.G().O(t1Var, y1Var, cVar);
            if (O == 1) {
                return true;
            }
        } while (O != 2);
        return false;
    }

    public final void J(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th2 : list) {
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                kotlin.a.a(th, th2);
            }
        }
    }

    public void K(@Nullable Object obj) {
    }

    public final boolean L(@Nullable Throwable th) {
        return M(th);
    }

    public final boolean M(@Nullable Object obj) {
        Object a10 = v1.a();
        if (a0() && (a10 = O(obj)) == v1.f51548b) {
            return true;
        }
        if (a10 == v1.a()) {
            a10 = k0(obj);
        }
        if (a10 == v1.a() || a10 == v1.f51548b) {
            return true;
        }
        if (a10 == v1.f()) {
            return false;
        }
        K(a10);
        return true;
    }

    public void N(@NotNull Throwable th) {
        M(th);
    }

    public final Object O(Object obj) {
        Object F0;
        do {
            Object d02 = d0();
            if ((d02 instanceof h1) && (!(d02 instanceof b) || !((b) d02).g())) {
                F0 = F0(d02, new x(U(obj), false, 2, null));
            } else {
                return v1.a();
            }
        } while (F0 == v1.b());
        return F0;
    }

    public final boolean P(Throwable th) {
        if (h0()) {
            return true;
        }
        boolean z10 = th instanceof CancellationException;
        r c02 = c0();
        return (c02 == null || c02 == z1.f51576b) ? z10 : c02.b(th) || z10;
    }

    @NotNull
    public String Q() {
        return "Job was cancelled";
    }

    public boolean R(@NotNull Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return M(th) && Z();
    }

    public final void S(h1 h1Var, Object obj) {
        r c02 = c0();
        if (c02 != null) {
            c02.dispose();
            x0(z1.f51576b);
        }
        x xVar = obj instanceof x ? (x) obj : null;
        Throwable th = xVar != null ? xVar.f51562a : null;
        if (h1Var instanceof t1) {
            try {
                ((t1) h1Var).P(th);
                return;
            } catch (Throwable th2) {
                f0(new CompletionHandlerException("Exception in completion handler " + ((Object) h1Var) + " for " + ((Object) this), th2));
                return;
            }
        }
        y1 c4 = h1Var.c();
        if (c4 != null) {
            q0(c4, th);
        }
    }

    public final void T(b bVar, s sVar, Object obj) {
        s o02 = o0(sVar);
        if (o02 == null || !H0(bVar, o02, obj)) {
            K(V(bVar, obj));
        }
    }

    public final Throwable U(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new JobCancellationException(Q(), null, this) : th;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((b2) obj).z();
    }

    public final Object V(b bVar, Object obj) {
        boolean f10;
        Throwable Y;
        DefaultConstructorMarker defaultConstructorMarker = null;
        x xVar = obj instanceof x ? (x) obj : null;
        Throwable th = xVar != null ? xVar.f51562a : null;
        synchronized (bVar) {
            f10 = bVar.f();
            List<Throwable> i10 = bVar.i(th);
            Y = Y(bVar, i10);
            if (Y != null) {
                J(Y, i10);
            }
        }
        if (Y != null && Y != th) {
            obj = new x(Y, r3, 2, defaultConstructorMarker);
        }
        if (Y != null) {
            if (P(Y) || e0(Y)) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                ((x) obj).b();
            }
        }
        if (!f10) {
            r0(Y);
        }
        s0(obj);
        androidx.concurrent.futures.a.a(f51538b, this, bVar, v1.g(obj));
        S(bVar, obj);
        return obj;
    }

    public final s W(h1 h1Var) {
        s sVar = h1Var instanceof s ? (s) h1Var : null;
        if (sVar != null) {
            return sVar;
        }
        y1 c4 = h1Var.c();
        if (c4 != null) {
            return o0(c4);
        }
        return null;
    }

    public final Throwable X(Object obj) {
        x xVar = obj instanceof x ? (x) obj : null;
        if (xVar != null) {
            return xVar.f51562a;
        }
        return null;
    }

    public final Throwable Y(b bVar, List<? extends Throwable> list) {
        Throwable th;
        Throwable th2 = null;
        if (list.isEmpty()) {
            if (bVar.f()) {
                return new JobCancellationException(Q(), null, this);
            }
            return null;
        }
        Iterator<? extends Throwable> iterator2 = list.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                th = null;
                break;
            }
            th = iterator2.next();
            if (!(th instanceof CancellationException)) {
                break;
            }
        }
        Throwable th3 = th;
        if (th3 != null) {
            return th3;
        }
        Throwable th4 = list.get(0);
        if (th4 instanceof TimeoutCancellationException) {
            Iterator<? extends Throwable> iterator22 = list.iterator2();
            while (true) {
                if (!iterator22.hasNext()) {
                    break;
                }
                Throwable next = iterator22.next();
                Throwable th5 = next;
                if (th5 != th4 && (th5 instanceof TimeoutCancellationException)) {
                    th2 = next;
                    break;
                }
            }
            Throwable th6 = th2;
            if (th6 != null) {
                return th6;
            }
        }
        return th4;
    }

    public boolean Z() {
        return true;
    }

    @Override // kotlinx.coroutines.n1, kotlinx.coroutines.channels.ReceiveChannel
    public void a(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(Q(), null, this);
        }
        N(cancellationException);
    }

    public boolean a0() {
        return false;
    }

    public final y1 b0(h1 h1Var) {
        y1 c4 = h1Var.c();
        if (c4 != null) {
            return c4;
        }
        if (h1Var instanceof w0) {
            return new y1();
        }
        if (h1Var instanceof t1) {
            v0((t1) h1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + ((Object) h1Var)).toString());
    }

    @Nullable
    public final r c0() {
        return (r) this._parentHandle;
    }

    @Override // kotlinx.coroutines.t
    public final void d(@NotNull b2 b2Var) {
        M(b2Var);
    }

    @Nullable
    public final Object d0() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof kotlinx.coroutines.internal.y)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.y) obj).c(this);
        }
    }

    @Override // kotlinx.coroutines.n1
    @NotNull
    public final t0 e(@NotNull Function1<? super Throwable, kotlin.p> function1) {
        return u(false, true, function1);
    }

    public boolean e0(@NotNull Throwable th) {
        return false;
    }

    public void f0(@NotNull Throwable th) {
        throw th;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r10, @NotNull Function2<? super R, ? super CoroutineContext.a, ? extends R> function2) {
        return (R) n1.a.b(this, r10, function2);
    }

    public final void g0(@Nullable n1 n1Var) {
        if (n1Var == null) {
            x0(z1.f51576b);
            return;
        }
        n1Var.start();
        r r10 = n1Var.r(this);
        x0(r10);
        if (isCompleted()) {
            r10.dispose();
            x0(z1.f51576b);
        }
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.a> E get(@NotNull CoroutineContext.b<E> bVar) {
        return (E) n1.a.c(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    @NotNull
    public final CoroutineContext.b<?> getKey() {
        return n1.C0;
    }

    public boolean h0() {
        return false;
    }

    public final boolean i0() {
        Object d02;
        do {
            d02 = d0();
            if (!(d02 instanceof h1)) {
                return false;
            }
        } while (y0(d02) < 0);
        return true;
    }

    @Override // kotlinx.coroutines.n1
    public boolean isActive() {
        Object d02 = d0();
        return (d02 instanceof h1) && ((h1) d02).isActive();
    }

    @Override // kotlinx.coroutines.n1
    public final boolean isCancelled() {
        Object d02 = d0();
        return (d02 instanceof x) || ((d02 instanceof b) && ((b) d02).f());
    }

    @Override // kotlinx.coroutines.n1
    public final boolean isCompleted() {
        return !(d0() instanceof h1);
    }

    public final Object j0(Continuation<? super kotlin.p> continuation) {
        m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        mVar.y();
        o.a(mVar, e(new d2(mVar)));
        Object r10 = mVar.r();
        if (r10 == sd.a.d()) {
            td.f.c(continuation);
        }
        return r10 == sd.a.d() ? r10 : kotlin.p.f51048a;
    }

    public final Object k0(Object obj) {
        byte b4 = 0;
        Throwable th = null;
        while (true) {
            Object d02 = d0();
            if (d02 instanceof b) {
                synchronized (d02) {
                    if (((b) d02).h()) {
                        return v1.f();
                    }
                    boolean f10 = ((b) d02).f();
                    if (obj != null || !f10) {
                        if (th == null) {
                            th = U(obj);
                        }
                        ((b) d02).a(th);
                    }
                    Throwable e2 = f10 ^ true ? ((b) d02).e() : null;
                    if (e2 != null) {
                        p0(((b) d02).c(), e2);
                    }
                    return v1.a();
                }
            }
            if (d02 instanceof h1) {
                if (th == null) {
                    th = U(obj);
                }
                h1 h1Var = (h1) d02;
                if (h1Var.isActive()) {
                    if (E0(h1Var, th)) {
                        return v1.a();
                    }
                } else {
                    Object F0 = F0(d02, new x(th, false, 2, b4 == true ? 1 : 0));
                    if (F0 != v1.a()) {
                        if (F0 != v1.b()) {
                            return F0;
                        }
                    } else {
                        throw new IllegalStateException(("Cannot happen in " + d02).toString());
                    }
                }
            } else {
                return v1.f();
            }
        }
    }

    @Nullable
    public final Object l0(@Nullable Object obj) {
        Object F0;
        do {
            F0 = F0(d0(), obj);
            if (F0 == v1.a()) {
                throw new IllegalStateException("Job " + ((Object) this) + " is already complete or completing, but is being completed with " + obj, X(obj));
            }
        } while (F0 == v1.b());
        return F0;
    }

    public final t1 m0(Function1<? super Throwable, kotlin.p> function1, boolean z10) {
        t1 t1Var;
        if (z10) {
            t1Var = function1 instanceof o1 ? (o1) function1 : null;
            if (t1Var == null) {
                t1Var = new l1(function1);
            }
        } else {
            t1Var = function1 instanceof t1 ? (t1) function1 : null;
            if (t1Var == null) {
                t1Var = new m1(function1);
            }
        }
        t1Var.R(this);
        return t1Var;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.b<?> bVar) {
        return n1.a.e(this, bVar);
    }

    @NotNull
    public String n0() {
        return j0.a(this);
    }

    public final s o0(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.J()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.G();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.F();
            if (!lockFreeLinkedListNode.J()) {
                if (lockFreeLinkedListNode instanceof s) {
                    return (s) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof y1) {
                    return null;
                }
            }
        }
    }

    public final void p0(y1 y1Var, Throwable th) {
        r0(th);
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) y1Var.E(); !kotlin.jvm.internal.s.d(lockFreeLinkedListNode, y1Var); lockFreeLinkedListNode = lockFreeLinkedListNode.F()) {
            if (lockFreeLinkedListNode instanceof o1) {
                t1 t1Var = (t1) lockFreeLinkedListNode;
                try {
                    t1Var.P(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.a.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + ((Object) t1Var) + " for " + ((Object) this), th2);
                        kotlin.p pVar = kotlin.p.f51048a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            f0(completionHandlerException);
        }
        P(th);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return n1.a.f(this, coroutineContext);
    }

    public final void q0(y1 y1Var, Throwable th) {
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) y1Var.E(); !kotlin.jvm.internal.s.d(lockFreeLinkedListNode, y1Var); lockFreeLinkedListNode = lockFreeLinkedListNode.F()) {
            if (lockFreeLinkedListNode instanceof t1) {
                t1 t1Var = (t1) lockFreeLinkedListNode;
                try {
                    t1Var.P(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.a.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + ((Object) t1Var) + " for " + ((Object) this), th2);
                        kotlin.p pVar = kotlin.p.f51048a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            f0(completionHandlerException);
        }
    }

    @Override // kotlinx.coroutines.n1
    @NotNull
    public final r r(@NotNull t tVar) {
        return (r) n1.a.d(this, true, false, new s(tVar), 2, null);
    }

    public void r0(@Nullable Throwable th) {
    }

    public void s0(@Nullable Object obj) {
    }

    @Override // kotlinx.coroutines.n1
    public final boolean start() {
        int y02;
        do {
            y02 = y0(d0());
            if (y02 == 0) {
                return false;
            }
        } while (y02 != 1);
        return true;
    }

    public void t0() {
    }

    @NotNull
    public String toString() {
        return C0() + '@' + j0.b(this);
    }

    @Override // kotlinx.coroutines.n1
    @NotNull
    public final t0 u(boolean z10, boolean z11, @NotNull Function1<? super Throwable, kotlin.p> function1) {
        t1 m02 = m0(function1, z10);
        while (true) {
            Object d02 = d0();
            if (d02 instanceof w0) {
                w0 w0Var = (w0) d02;
                if (w0Var.isActive()) {
                    if (androidx.concurrent.futures.a.a(f51538b, this, d02, m02)) {
                        return m02;
                    }
                } else {
                    u0(w0Var);
                }
            } else {
                if (d02 instanceof h1) {
                    y1 c4 = ((h1) d02).c();
                    if (c4 == null) {
                        Objects.requireNonNull(d02, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        v0((t1) d02);
                    } else {
                        t0 t0Var = z1.f51576b;
                        if (z10 && (d02 instanceof b)) {
                            synchronized (d02) {
                                r3 = ((b) d02).e();
                                if (r3 == null || ((function1 instanceof s) && !((b) d02).g())) {
                                    if (I(d02, c4, m02)) {
                                        if (r3 == null) {
                                            return m02;
                                        }
                                        t0Var = m02;
                                    }
                                }
                                kotlin.p pVar = kotlin.p.f51048a;
                            }
                        }
                        if (r3 != null) {
                            if (z11) {
                                function1.invoke(r3);
                            }
                            return t0Var;
                        }
                        if (I(d02, c4, m02)) {
                            return m02;
                        }
                    }
                } else {
                    if (z11) {
                        x xVar = d02 instanceof x ? (x) d02 : null;
                        function1.invoke(xVar != null ? xVar.f51562a : null);
                    }
                    return z1.f51576b;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.g1] */
    public final void u0(w0 w0Var) {
        y1 y1Var = new y1();
        if (!w0Var.isActive()) {
            y1Var = new g1(y1Var);
        }
        androidx.concurrent.futures.a.a(f51538b, this, w0Var, y1Var);
    }

    public final void v0(t1 t1Var) {
        t1Var.y(new y1());
        androidx.concurrent.futures.a.a(f51538b, this, t1Var, t1Var.F());
    }

    @Override // kotlinx.coroutines.n1
    @NotNull
    public final CancellationException w() {
        Object d02 = d0();
        if (d02 instanceof b) {
            Throwable e2 = ((b) d02).e();
            if (e2 != null) {
                CancellationException A0 = A0(e2, j0.a(this) + " is cancelling");
                if (A0 != null) {
                    return A0;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + ((Object) this)).toString());
        }
        if (!(d02 instanceof h1)) {
            if (d02 instanceof x) {
                return B0(this, ((x) d02).f51562a, null, 1, null);
            }
            return new JobCancellationException(j0.a(this) + " has completed normally", null, this);
        }
        throw new IllegalStateException(("Job is still new or active: " + ((Object) this)).toString());
    }

    public final void w0(@NotNull t1 t1Var) {
        Object d02;
        do {
            d02 = d0();
            if (!(d02 instanceof t1)) {
                if (!(d02 instanceof h1) || ((h1) d02).c() == null) {
                    return;
                }
                t1Var.K();
                return;
            }
            if (d02 != t1Var) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(f51538b, this, d02, v1.c()));
    }

    public final void x0(@Nullable r rVar) {
        this._parentHandle = rVar;
    }

    @Override // kotlinx.coroutines.n1
    @Nullable
    public final Object y(@NotNull Continuation<? super kotlin.p> continuation) {
        if (!i0()) {
            q1.g(continuation.getContext());
            return kotlin.p.f51048a;
        }
        Object j02 = j0(continuation);
        return j02 == sd.a.d() ? j02 : kotlin.p.f51048a;
    }

    public final int y0(Object obj) {
        if (obj instanceof w0) {
            if (((w0) obj).isActive()) {
                return 0;
            }
            if (!androidx.concurrent.futures.a.a(f51538b, this, obj, v1.c())) {
                return -1;
            }
            t0();
            return 1;
        }
        if (!(obj instanceof g1)) {
            return 0;
        }
        if (!androidx.concurrent.futures.a.a(f51538b, this, obj, ((g1) obj).c())) {
            return -1;
        }
        t0();
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // kotlinx.coroutines.b2
    @NotNull
    public CancellationException z() {
        CancellationException cancellationException;
        Object d02 = d0();
        if (d02 instanceof b) {
            cancellationException = ((b) d02).e();
        } else if (d02 instanceof x) {
            cancellationException = ((x) d02).f51562a;
        } else {
            if (d02 instanceof h1) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + d02).toString());
            }
            cancellationException = null;
        }
        CancellationException cancellationException2 = cancellationException instanceof CancellationException ? cancellationException : null;
        if (cancellationException2 != null) {
            return cancellationException2;
        }
        return new JobCancellationException("Parent job is " + z0(d02), cancellationException, this);
    }

    public final String z0(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof h1 ? ((h1) obj).isActive() ? "Active" : "New" : obj instanceof x ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        return bVar.f() ? "Cancelling" : bVar.g() ? "Completing" : "Active";
    }
}
