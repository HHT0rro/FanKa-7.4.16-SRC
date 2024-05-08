package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.e0;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.l;
import kotlinx.coroutines.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractChannel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractChannel<E> extends kotlinx.coroutines.channels.b<E> implements kotlinx.coroutines.channels.e<E> {

    /* compiled from: AbstractChannel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a<E> implements ChannelIterator<E> {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public final AbstractChannel<E> f51136a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public Object f51137b = kotlinx.coroutines.channels.a.f51157d;

        public a(@NotNull AbstractChannel<E> abstractChannel) {
            this.f51136a = abstractChannel;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Nullable
        public Object a(@NotNull Continuation<? super Boolean> continuation) {
            Object obj = this.f51137b;
            f0 f0Var = kotlinx.coroutines.channels.a.f51157d;
            if (obj != f0Var) {
                return td.a.a(b(obj));
            }
            Object X = this.f51136a.X();
            this.f51137b = X;
            if (X != f0Var) {
                return td.a.a(b(X));
            }
            return c(continuation);
        }

        public final boolean b(Object obj) {
            if (!(obj instanceof kotlinx.coroutines.channels.i)) {
                return true;
            }
            kotlinx.coroutines.channels.i iVar = (kotlinx.coroutines.channels.i) obj;
            if (iVar.f51174e == null) {
                return false;
            }
            throw e0.a(iVar.W());
        }

        public final Object c(Continuation<? super Boolean> continuation) {
            kotlinx.coroutines.m b4 = kotlinx.coroutines.o.b(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
            d dVar = new d(this, b4);
            while (true) {
                if (this.f51136a.M(dVar)) {
                    this.f51136a.b0(b4, dVar);
                    break;
                }
                Object X = this.f51136a.X();
                d(X);
                if (X instanceof kotlinx.coroutines.channels.i) {
                    kotlinx.coroutines.channels.i iVar = (kotlinx.coroutines.channels.i) X;
                    if (iVar.f51174e == null) {
                        Result.Companion companion = Result.Companion;
                        b4.resumeWith(Result.m3565constructorimpl(td.a.a(false)));
                    } else {
                        Result.Companion companion2 = Result.Companion;
                        b4.resumeWith(Result.m3565constructorimpl(kotlin.e.a(iVar.W())));
                    }
                } else if (X != kotlinx.coroutines.channels.a.f51157d) {
                    Boolean a10 = td.a.a(true);
                    Function1<E, kotlin.p> function1 = this.f51136a.f51161b;
                    b4.h(a10, function1 != null ? OnUndeliveredElementKt.a(function1, X, b4.getContext()) : null);
                }
            }
            Object r10 = b4.r();
            if (r10 == sd.a.d()) {
                td.f.c(continuation);
            }
            return r10;
        }

        public final void d(@Nullable Object obj) {
            this.f51137b = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            E e2 = (E) this.f51137b;
            if (!(e2 instanceof kotlinx.coroutines.channels.i)) {
                f0 f0Var = kotlinx.coroutines.channels.a.f51157d;
                if (e2 != f0Var) {
                    this.f51137b = f0Var;
                    return e2;
                }
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            throw e0.a(((kotlinx.coroutines.channels.i) e2).W());
        }
    }

    /* compiled from: AbstractChannel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b<E> extends n<E> {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public final kotlinx.coroutines.l<Object> f51138e;

        /* renamed from: f, reason: collision with root package name */
        public final int f51139f;

        public b(@NotNull kotlinx.coroutines.l<Object> lVar, int i10) {
            this.f51138e = lVar;
            this.f51139f = i10;
        }

        @Override // kotlinx.coroutines.channels.n
        public void R(@NotNull kotlinx.coroutines.channels.i<?> iVar) {
            if (this.f51139f == 1) {
                kotlinx.coroutines.l<Object> lVar = this.f51138e;
                ChannelResult m3577boximpl = ChannelResult.m3577boximpl(ChannelResult.Companion.a(iVar.f51174e));
                Result.Companion companion = Result.Companion;
                lVar.resumeWith(Result.m3565constructorimpl(m3577boximpl));
                return;
            }
            kotlinx.coroutines.l<Object> lVar2 = this.f51138e;
            Result.Companion companion2 = Result.Companion;
            lVar2.resumeWith(Result.m3565constructorimpl(kotlin.e.a(iVar.W())));
        }

        @Nullable
        public final Object S(E e2) {
            return this.f51139f == 1 ? ChannelResult.m3577boximpl(ChannelResult.Companion.c(e2)) : e2;
        }

        @Override // kotlinx.coroutines.channels.o
        public void e(E e2) {
            this.f51138e.s(kotlinx.coroutines.n.f51447a);
        }

        @Override // kotlinx.coroutines.channels.o
        @Nullable
        public f0 i(E e2, @Nullable LockFreeLinkedListNode.c cVar) {
            if (this.f51138e.B(S(e2), cVar != null ? cVar.f51360c : null, Q(e2)) == null) {
                return null;
            }
            if (cVar != null) {
                cVar.d();
            }
            return kotlinx.coroutines.n.f51447a;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "ReceiveElement@" + j0.b(this) + "[receiveMode=" + this.f51139f + ']';
        }
    }

    /* compiled from: AbstractChannel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class c<E> extends b<E> {

        /* renamed from: g, reason: collision with root package name */
        @NotNull
        public final Function1<E, kotlin.p> f51140g;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull kotlinx.coroutines.l<Object> lVar, int i10, @NotNull Function1<? super E, kotlin.p> function1) {
            super(lVar, i10);
            this.f51140g = function1;
        }

        @Override // kotlinx.coroutines.channels.n
        @Nullable
        public Function1<Throwable, kotlin.p> Q(E e2) {
            return OnUndeliveredElementKt.a(this.f51140g, e2, this.f51138e.getContext());
        }
    }

    /* compiled from: AbstractChannel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class d<E> extends n<E> {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public final a<E> f51141e;

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        public final kotlinx.coroutines.l<Boolean> f51142f;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@NotNull a<E> aVar, @NotNull kotlinx.coroutines.l<? super Boolean> lVar) {
            this.f51141e = aVar;
            this.f51142f = lVar;
        }

        @Override // kotlinx.coroutines.channels.n
        @Nullable
        public Function1<Throwable, kotlin.p> Q(E e2) {
            Function1<E, kotlin.p> function1 = this.f51141e.f51136a.f51161b;
            if (function1 != null) {
                return OnUndeliveredElementKt.a(function1, e2, this.f51142f.getContext());
            }
            return null;
        }

        @Override // kotlinx.coroutines.channels.n
        public void R(@NotNull kotlinx.coroutines.channels.i<?> iVar) {
            Object x10;
            if (iVar.f51174e == null) {
                x10 = l.a.a(this.f51142f, Boolean.FALSE, null, 2, null);
            } else {
                x10 = this.f51142f.x(iVar.W());
            }
            if (x10 != null) {
                this.f51141e.d(iVar);
                this.f51142f.s(x10);
            }
        }

        @Override // kotlinx.coroutines.channels.o
        public void e(E e2) {
            this.f51141e.d(e2);
            this.f51142f.s(kotlinx.coroutines.n.f51447a);
        }

        @Override // kotlinx.coroutines.channels.o
        @Nullable
        public f0 i(E e2, @Nullable LockFreeLinkedListNode.c cVar) {
            if (this.f51142f.B(Boolean.TRUE, cVar != null ? cVar.f51360c : null, Q(e2)) == null) {
                return null;
            }
            if (cVar != null) {
                cVar.d();
            }
            return kotlinx.coroutines.n.f51447a;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "ReceiveHasNext@" + j0.b(this);
        }
    }

    /* compiled from: AbstractChannel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class e<R, E> extends n<E> implements t0 {

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public final AbstractChannel<E> f51143e;

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        public final kotlinx.coroutines.selects.f<R> f51144f;

        /* renamed from: g, reason: collision with root package name */
        @NotNull
        public final Function2<Object, Continuation<? super R>, Object> f51145g;

        /* renamed from: h, reason: collision with root package name */
        public final int f51146h;

        /* JADX WARN: Multi-variable type inference failed */
        public e(@NotNull AbstractChannel<E> abstractChannel, @NotNull kotlinx.coroutines.selects.f<? super R> fVar, @NotNull Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i10) {
            this.f51143e = abstractChannel;
            this.f51144f = fVar;
            this.f51145g = function2;
            this.f51146h = i10;
        }

        @Override // kotlinx.coroutines.channels.n
        @Nullable
        public Function1<Throwable, kotlin.p> Q(E e2) {
            Function1<E, kotlin.p> function1 = this.f51143e.f51161b;
            if (function1 != null) {
                return OnUndeliveredElementKt.a(function1, e2, this.f51144f.m().getContext());
            }
            return null;
        }

        @Override // kotlinx.coroutines.channels.n
        public void R(@NotNull kotlinx.coroutines.channels.i<?> iVar) {
            if (this.f51144f.l()) {
                int i10 = this.f51146h;
                if (i10 == 0) {
                    this.f51144f.n(iVar.W());
                } else {
                    if (i10 != 1) {
                        return;
                    }
                    ee.a.e(this.f51145g, ChannelResult.m3577boximpl(ChannelResult.Companion.a(iVar.f51174e)), this.f51144f.m(), null, 4, null);
                }
            }
        }

        @Override // kotlinx.coroutines.t0
        public void dispose() {
            if (K()) {
                this.f51143e.V();
            }
        }

        @Override // kotlinx.coroutines.channels.o
        public void e(E e2) {
            ee.a.d(this.f51145g, this.f51146h == 1 ? ChannelResult.m3577boximpl(ChannelResult.Companion.c(e2)) : e2, this.f51144f.m(), Q(e2));
        }

        @Override // kotlinx.coroutines.channels.o
        @Nullable
        public f0 i(E e2, @Nullable LockFreeLinkedListNode.c cVar) {
            return (f0) this.f51144f.f(cVar);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "ReceiveSelect@" + j0.b(this) + '[' + ((Object) this.f51144f) + ",receiveMode=" + this.f51146h + ']';
        }
    }

    /* compiled from: AbstractChannel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class f extends kotlinx.coroutines.e {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final n<?> f51147b;

        public f(@NotNull n<?> nVar) {
            this.f51147b = nVar;
        }

        @Override // kotlinx.coroutines.k
        public void a(@Nullable Throwable th) {
            if (this.f51147b.K()) {
                AbstractChannel.this.V();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
            a(th);
            return kotlin.p.f51048a;
        }

        @NotNull
        public String toString() {
            return "RemoveReceiveOnCancel[" + ((Object) this.f51147b) + ']';
        }
    }

    /* compiled from: AbstractChannel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class g<E> extends LockFreeLinkedListNode.d<q> {
        public g(@NotNull kotlinx.coroutines.internal.p pVar) {
            super(pVar);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.d, kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        @Nullable
        public Object e(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (lockFreeLinkedListNode instanceof kotlinx.coroutines.channels.i) {
                return lockFreeLinkedListNode;
            }
            if (lockFreeLinkedListNode instanceof q) {
                return null;
            }
            return kotlinx.coroutines.channels.a.f51157d;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        @Nullable
        public Object j(@NotNull LockFreeLinkedListNode.c cVar) {
            f0 S = ((q) cVar.f51358a).S(cVar);
            if (S == null) {
                return kotlinx.coroutines.internal.r.f51408a;
            }
            Object obj = kotlinx.coroutines.internal.c.f51374b;
            if (S == obj) {
                return obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        public void k(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            ((q) lockFreeLinkedListNode).T();
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class h extends LockFreeLinkedListNode.b {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AbstractChannel f51149d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(LockFreeLinkedListNode lockFreeLinkedListNode, AbstractChannel abstractChannel) {
            super(lockFreeLinkedListNode);
            this.f51149d = abstractChannel;
        }

        @Override // kotlinx.coroutines.internal.d
        @Nullable
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Object i(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (this.f51149d.Q()) {
                return null;
            }
            return kotlinx.coroutines.internal.q.a();
        }
    }

    /* compiled from: AbstractChannel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class i implements kotlinx.coroutines.selects.d<E> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractChannel<E> f51150a;

        public i(AbstractChannel<E> abstractChannel) {
            this.f51150a = abstractChannel;
        }

        @Override // kotlinx.coroutines.selects.d
        public <R> void a(@NotNull kotlinx.coroutines.selects.f<? super R> fVar, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
            this.f51150a.a0(fVar, 0, function2);
        }
    }

    /* compiled from: AbstractChannel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class j implements kotlinx.coroutines.selects.d<ChannelResult<? extends E>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractChannel<E> f51151a;

        public j(AbstractChannel<E> abstractChannel) {
            this.f51151a = abstractChannel;
        }

        @Override // kotlinx.coroutines.selects.d
        public <R> void a(@NotNull kotlinx.coroutines.selects.f<? super R> fVar, @NotNull Function2<? super ChannelResult<? extends E>, ? super Continuation<? super R>, ? extends Object> function2) {
            this.f51151a.a0(fVar, 1, function2);
        }
    }

    public AbstractChannel(@Nullable Function1<? super E, kotlin.p> function1) {
        super(function1);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final kotlinx.coroutines.selects.d<E> A() {
        return new i(this);
    }

    @Override // kotlinx.coroutines.channels.b
    @Nullable
    public o<E> F() {
        o<E> F = super.F();
        if (F != null && !(F instanceof kotlinx.coroutines.channels.i)) {
            V();
        }
        return F;
    }

    public final boolean K(@Nullable Throwable th) {
        boolean D = D(th);
        T(D);
        return D;
    }

    @NotNull
    public final g<E> L() {
        return new g<>(j());
    }

    public final boolean M(n<? super E> nVar) {
        boolean N = N(nVar);
        if (N) {
            W();
        }
        return N;
    }

    public boolean N(@NotNull n<? super E> nVar) {
        int O;
        LockFreeLinkedListNode G;
        if (P()) {
            LockFreeLinkedListNode j10 = j();
            do {
                G = j10.G();
                if (!(!(G instanceof q))) {
                    return false;
                }
            } while (!G.w(nVar, j10));
        } else {
            LockFreeLinkedListNode j11 = j();
            h hVar = new h(nVar, this);
            do {
                LockFreeLinkedListNode G2 = j11.G();
                if (!(!(G2 instanceof q))) {
                    return false;
                }
                O = G2.O(nVar, j11, hVar);
                if (O != 1) {
                }
            } while (O != 2);
            return false;
        }
        return true;
    }

    public final <R> boolean O(kotlinx.coroutines.selects.f<? super R> fVar, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i10) {
        e eVar = new e(this, fVar, function2, i10);
        boolean M = M(eVar);
        if (M) {
            fVar.k(eVar);
        }
        return M;
    }

    public abstract boolean P();

    public abstract boolean Q();

    public boolean R() {
        return h() != null && Q();
    }

    public final boolean S() {
        return !(j().F() instanceof q) && Q();
    }

    public void T(boolean z10) {
        kotlinx.coroutines.channels.i<?> i10 = i();
        if (i10 != null) {
            Object b4 = kotlinx.coroutines.internal.m.b(null, 1, null);
            while (true) {
                LockFreeLinkedListNode G = i10.G();
                if (G instanceof kotlinx.coroutines.internal.p) {
                    U(b4, i10);
                    return;
                } else if (!G.K()) {
                    G.H();
                } else {
                    b4 = kotlinx.coroutines.internal.m.c(b4, (q) G);
                }
            }
        } else {
            throw new IllegalStateException("Cannot happen".toString());
        }
    }

    public void U(@NotNull Object obj, @NotNull kotlinx.coroutines.channels.i<?> iVar) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            ((q) obj).R(iVar);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            } else {
                ((q) arrayList.get(size)).R(iVar);
            }
        }
    }

    public void V() {
    }

    public void W() {
    }

    @Nullable
    public Object X() {
        while (true) {
            q G = G();
            if (G == null) {
                return kotlinx.coroutines.channels.a.f51157d;
            }
            if (G.S(null) != null) {
                G.P();
                return G.Q();
            }
            G.T();
        }
    }

    @Nullable
    public Object Y(@NotNull kotlinx.coroutines.selects.f<?> fVar) {
        g<E> L = L();
        Object g3 = fVar.g(L);
        if (g3 != null) {
            return g3;
        }
        L.o().P();
        return L.o().Q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Object Z(int i10, Continuation<? super R> continuation) {
        b bVar;
        kotlinx.coroutines.m b4 = kotlinx.coroutines.o.b(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        if (this.f51161b == null) {
            bVar = new b(b4, i10);
        } else {
            bVar = new c(b4, i10, this.f51161b);
        }
        while (true) {
            if (M(bVar)) {
                b0(b4, bVar);
                break;
            }
            Object X = X();
            if (X instanceof kotlinx.coroutines.channels.i) {
                bVar.R((kotlinx.coroutines.channels.i) X);
                break;
            }
            if (X != kotlinx.coroutines.channels.a.f51157d) {
                b4.h(bVar.S(X), bVar.Q(X));
                break;
            }
        }
        Object r10 = b4.r();
        if (r10 == sd.a.d()) {
            td.f.c(continuation);
        }
        return r10;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void a(@Nullable CancellationException cancellationException) {
        if (R()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new CancellationException(j0.a(this) + " was cancelled");
        }
        K(cancellationException);
    }

    public final <R> void a0(kotlinx.coroutines.selects.f<? super R> fVar, int i10, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!fVar.j()) {
            if (S()) {
                if (O(fVar, function2, i10)) {
                    return;
                }
            } else {
                Object Y = Y(fVar);
                if (Y == kotlinx.coroutines.selects.g.d()) {
                    return;
                }
                if (Y != kotlinx.coroutines.channels.a.f51157d && Y != kotlinx.coroutines.internal.c.f51374b) {
                    c0(function2, fVar, i10, Y);
                }
            }
        }
    }

    public final void b0(kotlinx.coroutines.l<?> lVar, n<?> nVar) {
        lVar.v(new f(nVar));
    }

    public final <R> void c0(Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, kotlinx.coroutines.selects.f<? super R> fVar, int i10, Object obj) {
        boolean z10 = obj instanceof kotlinx.coroutines.channels.i;
        if (!z10) {
            if (i10 == 1) {
                ChannelResult.Companion companion = ChannelResult.Companion;
                ee.b.d(function2, ChannelResult.m3577boximpl(z10 ? companion.a(((kotlinx.coroutines.channels.i) obj).f51174e) : companion.c(obj)), fVar.m());
                return;
            } else {
                ee.b.d(function2, obj, fVar.m());
                return;
            }
        }
        if (i10 != 0) {
            if (i10 == 1 && fVar.l()) {
                ee.b.d(function2, ChannelResult.m3577boximpl(ChannelResult.Companion.a(((kotlinx.coroutines.channels.i) obj).f51174e)), fVar.m());
                return;
            }
            return;
        }
        throw e0.a(((kotlinx.coroutines.channels.i) obj).W());
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final ChannelIterator<E> iterator() {
        return new a(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final kotlinx.coroutines.selects.d<ChannelResult<E>> n() {
        return new j(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final Object o() {
        Object X = X();
        return X == kotlinx.coroutines.channels.a.f51157d ? ChannelResult.Companion.b() : X instanceof kotlinx.coroutines.channels.i ? ChannelResult.Companion.a(((kotlinx.coroutines.channels.i) X).f51174e) : ChannelResult.Companion.c(X);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object p(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = sd.a.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.e.b(r5)
            goto L5b
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.e.b(r5)
            java.lang.Object r5 = r4.X()
            kotlinx.coroutines.internal.f0 r2 = kotlinx.coroutines.channels.a.f51157d
            if (r5 == r2) goto L52
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.i
            if (r0 == 0) goto L4b
            kotlinx.coroutines.channels.ChannelResult$Companion r0 = kotlinx.coroutines.channels.ChannelResult.Companion
            kotlinx.coroutines.channels.i r5 = (kotlinx.coroutines.channels.i) r5
            java.lang.Throwable r5 = r5.f51174e
            java.lang.Object r5 = r0.a(r5)
            goto L51
        L4b:
            kotlinx.coroutines.channels.ChannelResult$Companion r0 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Object r5 = r0.c(r5)
        L51:
            return r5
        L52:
            r0.label = r3
            java.lang.Object r5 = r4.Z(r3, r0)
            if (r5 != r1) goto L5b
            return r1
        L5b:
            kotlinx.coroutines.channels.ChannelResult r5 = (kotlinx.coroutines.channels.ChannelResult) r5
            java.lang.Object r5 = r5.m3589unboximpl()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractChannel.p(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
