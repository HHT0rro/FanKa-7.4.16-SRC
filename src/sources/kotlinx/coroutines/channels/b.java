package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.z;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.j0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractChannel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class b<E> implements r<E> {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51160d = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "onCloseHandler");

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final Function1<E, kotlin.p> f51161b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final kotlinx.coroutines.internal.p f51162c = new kotlinx.coroutines.internal.p();

    @NotNull
    private volatile /* synthetic */ Object onCloseHandler = null;

    /* compiled from: AbstractChannel.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a<E> extends q {

        /* renamed from: e, reason: collision with root package name */
        public final E f51163e;

        public a(E e2) {
            this.f51163e = e2;
        }

        @Override // kotlinx.coroutines.channels.q
        public void P() {
        }

        @Override // kotlinx.coroutines.channels.q
        @Nullable
        public Object Q() {
            return this.f51163e;
        }

        @Override // kotlinx.coroutines.channels.q
        public void R(@NotNull i<?> iVar) {
        }

        @Override // kotlinx.coroutines.channels.q
        @Nullable
        public f0 S(@Nullable LockFreeLinkedListNode.c cVar) {
            f0 f0Var = kotlinx.coroutines.n.f51447a;
            if (cVar != null) {
                cVar.d();
            }
            return f0Var;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "SendBuffered@" + j0.b(this) + '(' + ((Object) this.f51163e) + ')';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @kotlin.d
    /* renamed from: kotlinx.coroutines.channels.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class C0778b extends LockFreeLinkedListNode.b {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f51164d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0778b(LockFreeLinkedListNode lockFreeLinkedListNode, b bVar) {
            super(lockFreeLinkedListNode);
            this.f51164d = bVar;
        }

        @Override // kotlinx.coroutines.internal.d
        @Nullable
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Object i(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (this.f51164d.w()) {
                return null;
            }
            return kotlinx.coroutines.internal.q.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@Nullable Function1<? super E, kotlin.p> function1) {
        this.f51161b = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final o<?> B(E e2) {
        LockFreeLinkedListNode G;
        kotlinx.coroutines.internal.p pVar = this.f51162c;
        a aVar = new a(e2);
        do {
            G = pVar.G();
            if (G instanceof o) {
                return (o) G;
            }
        } while (!G.w(aVar, pVar));
        return null;
    }

    public final Object C(E e2, Continuation<? super kotlin.p> continuation) {
        q tVar;
        kotlinx.coroutines.m b4 = kotlinx.coroutines.o.b(IntrinsicsKt__IntrinsicsJvmKt.c(continuation));
        while (true) {
            if (x()) {
                if (this.f51161b == null) {
                    tVar = new s(e2, b4);
                } else {
                    tVar = new t(e2, b4, this.f51161b);
                }
                Object f10 = f(tVar);
                if (f10 == null) {
                    kotlinx.coroutines.o.c(b4, tVar);
                    break;
                }
                if (f10 instanceof i) {
                    t(b4, e2, (i) f10);
                    break;
                }
                if (f10 != kotlinx.coroutines.channels.a.f51158e && !(f10 instanceof n)) {
                    throw new IllegalStateException(("enqueueSend returned " + f10).toString());
                }
            }
            Object y10 = y(e2);
            if (y10 == kotlinx.coroutines.channels.a.f51155b) {
                Result.Companion companion = Result.Companion;
                b4.resumeWith(Result.m3565constructorimpl(kotlin.p.f51048a));
                break;
            }
            if (y10 != kotlinx.coroutines.channels.a.f51156c) {
                if (y10 instanceof i) {
                    t(b4, e2, (i) y10);
                } else {
                    throw new IllegalStateException(("offerInternal returned " + y10).toString());
                }
            }
        }
        Object r10 = b4.r();
        if (r10 == sd.a.d()) {
            td.f.c(continuation);
        }
        return r10 == sd.a.d() ? r10 : kotlin.p.f51048a;
    }

    @Override // kotlinx.coroutines.channels.r
    public boolean D(@Nullable Throwable th) {
        boolean z10;
        i<?> iVar = new i<>(th);
        LockFreeLinkedListNode lockFreeLinkedListNode = this.f51162c;
        while (true) {
            LockFreeLinkedListNode G = lockFreeLinkedListNode.G();
            z10 = true;
            if (!(!(G instanceof i))) {
                z10 = false;
                break;
            }
            if (G.w(iVar, lockFreeLinkedListNode)) {
                break;
            }
        }
        if (!z10) {
            iVar = (i) this.f51162c.G();
        }
        r(iVar);
        if (z10) {
            u(th);
        }
        return z10;
    }

    @Override // kotlinx.coroutines.channels.r
    @Nullable
    public final Object E(E e2, @NotNull Continuation<? super kotlin.p> continuation) {
        Object C;
        return (y(e2) != kotlinx.coroutines.channels.a.f51155b && (C = C(e2, continuation)) == sd.a.d()) ? C : kotlin.p.f51048a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    @Nullable
    public o<E> F() {
        ?? r12;
        LockFreeLinkedListNode M;
        kotlinx.coroutines.internal.p pVar = this.f51162c;
        while (true) {
            r12 = (LockFreeLinkedListNode) pVar.E();
            if (r12 != pVar && (r12 instanceof o)) {
                if (((((o) r12) instanceof i) && !r12.J()) || (M = r12.M()) == null) {
                    break;
                }
                M.I();
            }
        }
        r12 = 0;
        return (o) r12;
    }

    @Nullable
    public final q G() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListNode M;
        kotlinx.coroutines.internal.p pVar = this.f51162c;
        while (true) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) pVar.E();
            if (lockFreeLinkedListNode != pVar && (lockFreeLinkedListNode instanceof q)) {
                if (((((q) lockFreeLinkedListNode) instanceof i) && !lockFreeLinkedListNode.J()) || (M = lockFreeLinkedListNode.M()) == null) {
                    break;
                }
                M.I();
            }
        }
        lockFreeLinkedListNode = null;
        return (q) lockFreeLinkedListNode;
    }

    public final int e() {
        kotlinx.coroutines.internal.p pVar = this.f51162c;
        int i10 = 0;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) pVar.E(); !kotlin.jvm.internal.s.d(lockFreeLinkedListNode, pVar); lockFreeLinkedListNode = lockFreeLinkedListNode.F()) {
            if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                i10++;
            }
        }
        return i10;
    }

    @Nullable
    public Object f(@NotNull q qVar) {
        boolean z10;
        LockFreeLinkedListNode G;
        if (v()) {
            LockFreeLinkedListNode lockFreeLinkedListNode = this.f51162c;
            do {
                G = lockFreeLinkedListNode.G();
                if (G instanceof o) {
                    return G;
                }
            } while (!G.w(qVar, lockFreeLinkedListNode));
            return null;
        }
        LockFreeLinkedListNode lockFreeLinkedListNode2 = this.f51162c;
        C0778b c0778b = new C0778b(qVar, this);
        while (true) {
            LockFreeLinkedListNode G2 = lockFreeLinkedListNode2.G();
            if (!(G2 instanceof o)) {
                int O = G2.O(qVar, lockFreeLinkedListNode2, c0778b);
                z10 = true;
                if (O != 1) {
                    if (O == 2) {
                        z10 = false;
                        break;
                    }
                } else {
                    break;
                }
            } else {
                return G2;
            }
        }
        if (z10) {
            return null;
        }
        return kotlinx.coroutines.channels.a.f51158e;
    }

    @NotNull
    public String g() {
        return "";
    }

    @Nullable
    public final i<?> h() {
        LockFreeLinkedListNode F = this.f51162c.F();
        i<?> iVar = F instanceof i ? (i) F : null;
        if (iVar == null) {
            return null;
        }
        r(iVar);
        return iVar;
    }

    @Nullable
    public final i<?> i() {
        LockFreeLinkedListNode G = this.f51162c.G();
        i<?> iVar = G instanceof i ? (i) G : null;
        if (iVar == null) {
            return null;
        }
        r(iVar);
        return iVar;
    }

    @NotNull
    public final kotlinx.coroutines.internal.p j() {
        return this.f51162c;
    }

    @Override // kotlinx.coroutines.channels.r
    public void k(@NotNull Function1<? super Throwable, kotlin.p> function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51160d;
        if (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj == kotlinx.coroutines.channels.a.f51159f) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        i<?> i10 = i();
        if (i10 == null || !androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, function1, kotlinx.coroutines.channels.a.f51159f)) {
            return;
        }
        function1.invoke(i10.f51174e);
    }

    @Override // kotlinx.coroutines.channels.r
    @NotNull
    public final Object l(E e2) {
        Object y10 = y(e2);
        if (y10 == kotlinx.coroutines.channels.a.f51155b) {
            return ChannelResult.Companion.c(kotlin.p.f51048a);
        }
        if (y10 == kotlinx.coroutines.channels.a.f51156c) {
            i<?> i10 = i();
            return i10 == null ? ChannelResult.Companion.b() : ChannelResult.Companion.a(s(i10));
        }
        if (y10 instanceof i) {
            return ChannelResult.Companion.a(s((i) y10));
        }
        throw new IllegalStateException(("trySend returned " + y10).toString());
    }

    public final String m() {
        String str;
        LockFreeLinkedListNode F = this.f51162c.F();
        if (F == this.f51162c) {
            return "EmptyQueue";
        }
        if (F instanceof i) {
            str = F.toString();
        } else if (F instanceof n) {
            str = "ReceiveQueued";
        } else if (F instanceof q) {
            str = "SendQueued";
        } else {
            str = "UNEXPECTED:" + ((Object) F);
        }
        LockFreeLinkedListNode G = this.f51162c.G();
        if (G == F) {
            return str;
        }
        String str2 = str + ",queueSize=" + e();
        if (!(G instanceof i)) {
            return str2;
        }
        return str2 + ",closedForSend=" + ((Object) G);
    }

    @Override // kotlinx.coroutines.channels.r
    public final boolean q() {
        return i() != null;
    }

    public final void r(i<?> iVar) {
        Object b4 = kotlinx.coroutines.internal.m.b(null, 1, null);
        while (true) {
            LockFreeLinkedListNode G = iVar.G();
            n nVar = G instanceof n ? (n) G : null;
            if (nVar == null) {
                break;
            } else if (!nVar.K()) {
                nVar.H();
            } else {
                b4 = kotlinx.coroutines.internal.m.c(b4, nVar);
            }
        }
        if (b4 != null) {
            if (!(b4 instanceof ArrayList)) {
                ((n) b4).R(iVar);
            } else {
                ArrayList arrayList = (ArrayList) b4;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    ((n) arrayList.get(size)).R(iVar);
                }
            }
        }
        z(iVar);
    }

    public final Throwable s(i<?> iVar) {
        r(iVar);
        return iVar.X();
    }

    public final void t(Continuation<?> continuation, E e2, i<?> iVar) {
        UndeliveredElementException d10;
        r(iVar);
        Throwable X = iVar.X();
        Function1<E, kotlin.p> function1 = this.f51161b;
        if (function1 != null && (d10 = OnUndeliveredElementKt.d(function1, e2, null, 2, null)) != null) {
            kotlin.a.a(d10, X);
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m3565constructorimpl(kotlin.e.a(d10)));
        } else {
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m3565constructorimpl(kotlin.e.a(X)));
        }
    }

    @NotNull
    public String toString() {
        return j0.a(this) + '@' + j0.b(this) + '{' + m() + '}' + g();
    }

    public final void u(Throwable th) {
        f0 f0Var;
        Object obj = this.onCloseHandler;
        if (obj == null || obj == (f0Var = kotlinx.coroutines.channels.a.f51159f) || !androidx.concurrent.futures.a.a(f51160d, this, obj, f0Var)) {
            return;
        }
        ((Function1) z.e(obj, 1)).invoke(th);
    }

    public abstract boolean v();

    public abstract boolean w();

    public final boolean x() {
        return !(this.f51162c.F() instanceof o) && w();
    }

    @NotNull
    public Object y(E e2) {
        o<E> F;
        do {
            F = F();
            if (F == null) {
                return kotlinx.coroutines.channels.a.f51156c;
            }
        } while (F.i(e2, null) == null);
        F.e(e2);
        return F.a();
    }

    public void z(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
    }
}
