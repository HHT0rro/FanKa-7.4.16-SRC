package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.p;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.y;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n;
import kotlinx.coroutines.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Mutex.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MutexImpl implements kotlinx.coroutines.sync.c, kotlinx.coroutines.selects.e<Object, kotlinx.coroutines.sync.c> {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51503a = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");

    @NotNull
    public volatile /* synthetic */ Object _state;

    /* compiled from: Mutex.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class LockCont extends a {

        /* renamed from: h, reason: collision with root package name */
        @NotNull
        public final l<p> f51504h;

        /* JADX WARN: Multi-variable type inference failed */
        public LockCont(@Nullable Object obj, @NotNull l<? super p> lVar) {
            super(obj);
            this.f51504h = lVar;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        public void P() {
            this.f51504h.s(n.f51447a);
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        public boolean R() {
            if (!Q()) {
                return false;
            }
            l<p> lVar = this.f51504h;
            p pVar = p.f51048a;
            final MutexImpl mutexImpl = MutexImpl.this;
            return lVar.B(pVar, null, new Function1<Throwable, p>() { // from class: kotlinx.coroutines.sync.MutexImpl$LockCont$tryResumeLockWaiter$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                    invoke2(th);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Throwable th) {
                    MutexImpl.this.b(this.f51510e);
                }
            }) != null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "LockCont[" + this.f51510e + ", " + ((Object) this.f51504h) + "] for " + ((Object) MutexImpl.this);
        }
    }

    /* compiled from: Mutex.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class LockSelect<R> extends a {

        /* renamed from: h, reason: collision with root package name */
        @NotNull
        public final kotlinx.coroutines.selects.f<R> f51506h;

        /* renamed from: i, reason: collision with root package name */
        @NotNull
        public final Function2<kotlinx.coroutines.sync.c, Continuation<? super R>, Object> f51507i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ MutexImpl f51508j;

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        public void P() {
            Function2<kotlinx.coroutines.sync.c, Continuation<? super R>, Object> function2 = this.f51507i;
            MutexImpl mutexImpl = this.f51508j;
            Continuation<R> m10 = this.f51506h.m();
            final MutexImpl mutexImpl2 = this.f51508j;
            ee.a.d(function2, mutexImpl, m10, new Function1<Throwable, p>() { // from class: kotlinx.coroutines.sync.MutexImpl$LockSelect$completeResumeLockWaiter$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                    invoke2(th);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Throwable th) {
                    MutexImpl.this.b(this.f51510e);
                }
            });
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.a
        public boolean R() {
            return Q() && this.f51506h.l();
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "LockSelect[" + this.f51510e + ", " + ((Object) this.f51506h) + "] for " + ((Object) this.f51508j);
        }
    }

    /* compiled from: Mutex.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public abstract class a extends LockFreeLinkedListNode implements t0 {

        /* renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f51509g = AtomicIntegerFieldUpdater.newUpdater(a.class, "isTaken");

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public final Object f51510e;

        @NotNull
        private volatile /* synthetic */ int isTaken = 0;

        public a(@Nullable Object obj) {
            this.f51510e = obj;
        }

        public abstract void P();

        public final boolean Q() {
            return f51509g.compareAndSet(this, 0, 1);
        }

        public abstract boolean R();

        @Override // kotlinx.coroutines.t0
        public final void dispose() {
            K();
        }
    }

    /* compiled from: Mutex.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class b extends kotlinx.coroutines.internal.p {

        @NotNull
        public volatile Object owner;

        public b(@NotNull Object obj) {
            this.owner = obj;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        @NotNull
        public String toString() {
            return "LockedQueue[" + this.owner + ']';
        }
    }

    /* compiled from: Mutex.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class c extends kotlinx.coroutines.internal.d<MutexImpl> {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final b f51512b;

        public c(@NotNull b bVar) {
            this.f51512b = bVar;
        }

        @Override // kotlinx.coroutines.internal.d
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void d(@NotNull MutexImpl mutexImpl, @Nullable Object obj) {
            androidx.concurrent.futures.a.a(MutexImpl.f51503a, mutexImpl, this, obj == null ? MutexKt.f51518f : this.f51512b);
        }

        @Override // kotlinx.coroutines.internal.d
        @Nullable
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Object i(@NotNull MutexImpl mutexImpl) {
            f0 f0Var;
            if (this.f51512b.P()) {
                return null;
            }
            f0Var = MutexKt.f51514b;
            return f0Var;
        }
    }

    public MutexImpl(boolean z10) {
        this._state = z10 ? MutexKt.f51517e : MutexKt.f51518f;
    }

    @Override // kotlinx.coroutines.sync.c
    @Nullable
    public Object a(@Nullable Object obj, @NotNull Continuation<? super p> continuation) {
        Object c4;
        return (!d(obj) && (c4 = c(obj, continuation)) == sd.a.d()) ? c4 : p.f51048a;
    }

    @Override // kotlinx.coroutines.sync.c
    public void b(@Nullable Object obj) {
        kotlinx.coroutines.sync.b bVar;
        f0 f0Var;
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof kotlinx.coroutines.sync.b) {
                if (obj == null) {
                    Object obj3 = ((kotlinx.coroutines.sync.b) obj2).f51527a;
                    f0Var = MutexKt.f51516d;
                    if (!(obj3 != f0Var)) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    kotlinx.coroutines.sync.b bVar2 = (kotlinx.coroutines.sync.b) obj2;
                    if (!(bVar2.f51527a == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + bVar2.f51527a + " but expected " + obj).toString());
                    }
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51503a;
                bVar = MutexKt.f51518f;
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj2, bVar)) {
                    return;
                }
            } else if (obj2 instanceof y) {
                ((y) obj2).c(this);
            } else if (obj2 instanceof b) {
                if (obj != null) {
                    b bVar3 = (b) obj2;
                    if (!(bVar3.owner == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + bVar3.owner + " but expected " + obj).toString());
                    }
                }
                b bVar4 = (b) obj2;
                LockFreeLinkedListNode L = bVar4.L();
                if (L == null) {
                    c cVar = new c(bVar4);
                    if (androidx.concurrent.futures.a.a(f51503a, this, obj2, cVar) && cVar.c(this) == null) {
                        return;
                    }
                } else {
                    a aVar = (a) L;
                    if (aVar.R()) {
                        Object obj4 = aVar.f51510e;
                        if (obj4 == null) {
                            obj4 = MutexKt.f51515c;
                        }
                        bVar4.owner = obj4;
                        aVar.P();
                        return;
                    }
                }
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
    
        kotlinx.coroutines.o.c(r0, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(final java.lang.Object r7, kotlin.coroutines.Continuation<? super kotlin.p> r8) {
        /*
            r6 = this;
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.c(r8)
            kotlinx.coroutines.m r0 = kotlinx.coroutines.o.b(r0)
            kotlinx.coroutines.sync.MutexImpl$LockCont r1 = new kotlinx.coroutines.sync.MutexImpl$LockCont
            r1.<init>(r7, r0)
        Ld:
            java.lang.Object r2 = r6._state
            boolean r3 = r2 instanceof kotlinx.coroutines.sync.b
            if (r3 == 0) goto L4a
            r3 = r2
            kotlinx.coroutines.sync.b r3 = (kotlinx.coroutines.sync.b) r3
            java.lang.Object r4 = r3.f51527a
            kotlinx.coroutines.internal.f0 r5 = kotlinx.coroutines.sync.MutexKt.f()
            if (r4 == r5) goto L2b
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.sync.MutexImpl.f51503a
            kotlinx.coroutines.sync.MutexImpl$b r5 = new kotlinx.coroutines.sync.MutexImpl$b
            java.lang.Object r3 = r3.f51527a
            r5.<init>(r3)
            androidx.concurrent.futures.a.a(r4, r6, r2, r5)
            goto Ld
        L2b:
            if (r7 != 0) goto L32
            kotlinx.coroutines.sync.b r3 = kotlinx.coroutines.sync.MutexKt.c()
            goto L37
        L32:
            kotlinx.coroutines.sync.b r3 = new kotlinx.coroutines.sync.b
            r3.<init>(r7)
        L37:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.sync.MutexImpl.f51503a
            boolean r2 = androidx.concurrent.futures.a.a(r4, r6, r2, r3)
            if (r2 == 0) goto Ld
            kotlin.p r1 = kotlin.p.f51048a
            kotlinx.coroutines.sync.MutexImpl$lockSuspend$2$1$1 r2 = new kotlinx.coroutines.sync.MutexImpl$lockSuspend$2$1$1
            r2.<init>()
            r0.h(r1, r2)
            goto L71
        L4a:
            boolean r3 = r2 instanceof kotlinx.coroutines.sync.MutexImpl.b
            if (r3 == 0) goto La3
            r3 = r2
            kotlinx.coroutines.sync.MutexImpl$b r3 = (kotlinx.coroutines.sync.MutexImpl.b) r3
            java.lang.Object r4 = r3.owner
            if (r4 == r7) goto L57
            r4 = 1
            goto L58
        L57:
            r4 = 0
        L58:
            if (r4 == 0) goto L88
            r3.u(r1)
            java.lang.Object r3 = r6._state
            if (r3 == r2) goto L6e
            boolean r2 = r1.Q()
            if (r2 != 0) goto L68
            goto L6e
        L68:
            kotlinx.coroutines.sync.MutexImpl$LockCont r1 = new kotlinx.coroutines.sync.MutexImpl$LockCont
            r1.<init>(r7, r0)
            goto Ld
        L6e:
            kotlinx.coroutines.o.c(r0, r1)
        L71:
            java.lang.Object r7 = r0.r()
            java.lang.Object r0 = sd.a.d()
            if (r7 != r0) goto L7e
            td.f.c(r8)
        L7e:
            java.lang.Object r8 = sd.a.d()
            if (r7 != r8) goto L85
            return r7
        L85:
            kotlin.p r7 = kotlin.p.f51048a
            return r7
        L88:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Already locked by "
            r8.append(r0)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        La3:
            boolean r3 = r2 instanceof kotlinx.coroutines.internal.y
            if (r3 == 0) goto Lae
            kotlinx.coroutines.internal.y r2 = (kotlinx.coroutines.internal.y) r2
            r2.c(r6)
            goto Ld
        Lae:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Illegal state "
            r8.append(r0)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexImpl.c(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean d(@Nullable Object obj) {
        f0 f0Var;
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof kotlinx.coroutines.sync.b) {
                Object obj3 = ((kotlinx.coroutines.sync.b) obj2).f51527a;
                f0Var = MutexKt.f51516d;
                if (obj3 != f0Var) {
                    return false;
                }
                if (androidx.concurrent.futures.a.a(f51503a, this, obj2, obj == null ? MutexKt.f51517e : new kotlinx.coroutines.sync.b(obj))) {
                    return true;
                }
            } else {
                if (obj2 instanceof b) {
                    if (((b) obj2).owner != obj) {
                        return false;
                    }
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
                if (!(obj2 instanceof y)) {
                    throw new IllegalStateException(("Illegal state " + obj2).toString());
                }
                ((y) obj2).c(this);
            }
        }
    }

    @NotNull
    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof kotlinx.coroutines.sync.b) {
                return "Mutex[" + ((kotlinx.coroutines.sync.b) obj).f51527a + ']';
            }
            if (!(obj instanceof y)) {
                if (!(obj instanceof b)) {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
                return "Mutex[" + ((b) obj).owner + ']';
            }
            ((y) obj).c(this);
        }
    }
}
