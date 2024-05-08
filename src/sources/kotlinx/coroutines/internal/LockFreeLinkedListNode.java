package kotlinx.coroutines.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.PropertyReference0Impl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LockFreeLinkedList.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class LockFreeLinkedListNode {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51353b = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51354c = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51355d = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");

    @NotNull
    public volatile /* synthetic */ Object _next = this;

    @NotNull
    public volatile /* synthetic */ Object _prev = this;

    @NotNull
    private volatile /* synthetic */ Object _removedRef = null;

    /* compiled from: LockFreeLinkedList.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class a extends kotlinx.coroutines.internal.b {
        @Override // kotlinx.coroutines.internal.b
        public final void a(@NotNull kotlinx.coroutines.internal.d<?> dVar, @Nullable Object obj) {
            LockFreeLinkedListNode i10;
            boolean z10 = obj == null;
            LockFreeLinkedListNode h10 = h();
            if (h10 == null || (i10 = i()) == null) {
                return;
            }
            if (androidx.concurrent.futures.a.a(LockFreeLinkedListNode.f51353b, h10, dVar, z10 ? n(h10, i10) : i10) && z10) {
                f(h10, i10);
            }
        }

        @Override // kotlinx.coroutines.internal.b
        @Nullable
        public final Object c(@NotNull kotlinx.coroutines.internal.d<?> dVar) {
            while (true) {
                LockFreeLinkedListNode m10 = m(dVar);
                if (m10 == null) {
                    return kotlinx.coroutines.internal.c.f51374b;
                }
                Object obj = m10._next;
                if (obj == dVar || dVar.h()) {
                    return null;
                }
                if (obj instanceof y) {
                    y yVar = (y) obj;
                    if (dVar.b(yVar)) {
                        return kotlinx.coroutines.internal.c.f51374b;
                    }
                    yVar.c(m10);
                } else {
                    Object e2 = e(m10);
                    if (e2 != null) {
                        return e2;
                    }
                    if (l(m10, obj)) {
                        continue;
                    } else {
                        c cVar = new c(m10, (LockFreeLinkedListNode) obj, this);
                        if (androidx.concurrent.futures.a.a(LockFreeLinkedListNode.f51353b, m10, obj, cVar)) {
                            try {
                                if (cVar.c(m10) != r.f51408a) {
                                    return null;
                                }
                            } catch (Throwable th) {
                                androidx.concurrent.futures.a.a(LockFreeLinkedListNode.f51353b, m10, cVar, obj);
                                throw th;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }

        @Nullable
        public abstract Object e(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode);

        public abstract void f(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2);

        public abstract void g(@NotNull c cVar);

        @Nullable
        public abstract LockFreeLinkedListNode h();

        @Nullable
        public abstract LockFreeLinkedListNode i();

        @Nullable
        public Object j(@NotNull c cVar) {
            g(cVar);
            return null;
        }

        public void k(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        }

        public abstract boolean l(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj);

        @Nullable
        public abstract LockFreeLinkedListNode m(@NotNull y yVar);

        @NotNull
        public abstract Object n(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2);
    }

    /* compiled from: LockFreeLinkedList.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class b extends kotlinx.coroutines.internal.d<LockFreeLinkedListNode> {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final LockFreeLinkedListNode f51356b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public LockFreeLinkedListNode f51357c;

        public b(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.f51356b = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.d
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void d(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @Nullable Object obj) {
            boolean z10 = obj == null;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = z10 ? this.f51356b : this.f51357c;
            if (lockFreeLinkedListNode2 != null && androidx.concurrent.futures.a.a(LockFreeLinkedListNode.f51353b, lockFreeLinkedListNode, this, lockFreeLinkedListNode2) && z10) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.f51356b;
                LockFreeLinkedListNode lockFreeLinkedListNode4 = this.f51357c;
                kotlin.jvm.internal.s.f(lockFreeLinkedListNode4);
                lockFreeLinkedListNode3.D(lockFreeLinkedListNode4);
            }
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class c extends y {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public final LockFreeLinkedListNode f51358a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final LockFreeLinkedListNode f51359b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public final a f51360c;

        public c(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2, @NotNull a aVar) {
            this.f51358a = lockFreeLinkedListNode;
            this.f51359b = lockFreeLinkedListNode2;
            this.f51360c = aVar;
        }

        @Override // kotlinx.coroutines.internal.y
        @NotNull
        public kotlinx.coroutines.internal.d<?> a() {
            return this.f51360c.b();
        }

        @Override // kotlinx.coroutines.internal.y
        @Nullable
        public Object c(@Nullable Object obj) {
            Object f10;
            Object obj2;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
            Object j10 = this.f51360c.j(this);
            Object obj3 = r.f51408a;
            if (j10 == obj3) {
                LockFreeLinkedListNode lockFreeLinkedListNode2 = this.f51359b;
                if (androidx.concurrent.futures.a.a(LockFreeLinkedListNode.f51353b, lockFreeLinkedListNode, this, lockFreeLinkedListNode2.N())) {
                    this.f51360c.k(lockFreeLinkedListNode);
                    lockFreeLinkedListNode2.z(null);
                }
                return obj3;
            }
            if (j10 != null) {
                f10 = a().e(j10);
            } else {
                f10 = a().f();
            }
            if (f10 == kotlinx.coroutines.internal.c.f51373a) {
                obj2 = a();
            } else if (f10 == null) {
                obj2 = this.f51360c.n(lockFreeLinkedListNode, this.f51359b);
            } else {
                obj2 = this.f51359b;
            }
            androidx.concurrent.futures.a.a(LockFreeLinkedListNode.f51353b, lockFreeLinkedListNode, this, obj2);
            return null;
        }

        public final void d() {
            this.f51360c.g(this);
        }

        @Override // kotlinx.coroutines.internal.y
        @NotNull
        public String toString() {
            return "PrepareOp(op=" + ((Object) a()) + ')';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class d<T> extends a {

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f51361c = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_affectedNode");

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ AtomicReferenceFieldUpdater f51362d = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_originalNext");

        @NotNull
        private volatile /* synthetic */ Object _affectedNode = null;

        @NotNull
        private volatile /* synthetic */ Object _originalNext = null;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final LockFreeLinkedListNode f51363b;

        public d(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.f51363b = lockFreeLinkedListNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        @Nullable
        public Object e(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (lockFreeLinkedListNode == this.f51363b) {
                return q.b();
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        public final void f(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            lockFreeLinkedListNode2.z(null);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        public void g(@NotNull c cVar) {
            androidx.concurrent.futures.a.a(f51361c, this, null, cVar.f51358a);
            androidx.concurrent.futures.a.a(f51362d, this, null, cVar.f51359b);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        @Nullable
        public final LockFreeLinkedListNode h() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        @Nullable
        public final LockFreeLinkedListNode i() {
            return (LockFreeLinkedListNode) this._originalNext;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        public final boolean l(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
            if (!(obj instanceof z)) {
                return false;
            }
            ((z) obj).f51425a.I();
            return true;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        @Nullable
        public final LockFreeLinkedListNode m(@NotNull y yVar) {
            LockFreeLinkedListNode lockFreeLinkedListNode = this.f51363b;
            while (true) {
                Object obj = lockFreeLinkedListNode._next;
                if (obj instanceof y) {
                    y yVar2 = (y) obj;
                    if (yVar.b(yVar2)) {
                        return null;
                    }
                    yVar2.c(this.f51363b);
                } else {
                    return (LockFreeLinkedListNode) obj;
                }
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.a
        @NotNull
        public final Object n(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            return lockFreeLinkedListNode2.N();
        }

        public final T o() {
            T t2 = (T) h();
            kotlin.jvm.internal.s.f(t2);
            return t2;
        }
    }

    public final LockFreeLinkedListNode A(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.J()) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListNode._prev;
        }
        return lockFreeLinkedListNode;
    }

    public final void D(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        do {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) lockFreeLinkedListNode._prev;
            if (E() != lockFreeLinkedListNode) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(f51354c, lockFreeLinkedListNode, lockFreeLinkedListNode2, this));
        if (J()) {
            lockFreeLinkedListNode.z(null);
        }
    }

    @NotNull
    public final Object E() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof y)) {
                return obj;
            }
            ((y) obj).c(this);
        }
    }

    @NotNull
    public final LockFreeLinkedListNode F() {
        return q.c(E());
    }

    @NotNull
    public final LockFreeLinkedListNode G() {
        LockFreeLinkedListNode z10 = z(null);
        return z10 == null ? A((LockFreeLinkedListNode) this._prev) : z10;
    }

    public final void H() {
        ((z) E()).f51425a.I();
    }

    public final void I() {
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        while (true) {
            Object E = lockFreeLinkedListNode.E();
            if (E instanceof z) {
                lockFreeLinkedListNode = ((z) E).f51425a;
            } else {
                lockFreeLinkedListNode.z(null);
                return;
            }
        }
    }

    public boolean J() {
        return E() instanceof z;
    }

    public boolean K() {
        return M() == null;
    }

    @Nullable
    public final LockFreeLinkedListNode L() {
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) E();
            if (lockFreeLinkedListNode == this) {
                return null;
            }
            if (lockFreeLinkedListNode.K()) {
                return lockFreeLinkedListNode;
            }
            lockFreeLinkedListNode.H();
        }
    }

    @Nullable
    public final LockFreeLinkedListNode M() {
        Object E;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            E = E();
            if (E instanceof z) {
                return ((z) E).f51425a;
            }
            if (E == this) {
                return (LockFreeLinkedListNode) E;
            }
            lockFreeLinkedListNode = (LockFreeLinkedListNode) E;
        } while (!androidx.concurrent.futures.a.a(f51353b, this, E, lockFreeLinkedListNode.N()));
        lockFreeLinkedListNode.z(null);
        return null;
    }

    public final z N() {
        z zVar = (z) this._removedRef;
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = new z(this);
        f51355d.lazySet(this, zVar2);
        return zVar2;
    }

    public final int O(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2, @NotNull b bVar) {
        f51354c.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51353b;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        bVar.f51357c = lockFreeLinkedListNode2;
        if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, lockFreeLinkedListNode2, bVar)) {
            return bVar.c(this) == null ? 1 : 2;
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return ((Object) new PropertyReference0Impl(this) { // from class: kotlinx.coroutines.internal.LockFreeLinkedListNode$toString$1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.jvm.internal.PropertyReference0
            @Nullable
            public Object get() {
                return kotlinx.coroutines.j0.a(this.receiver);
            }
        }) + '@' + kotlinx.coroutines.j0.b(this);
    }

    public final void u(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        do {
        } while (!G().w(lockFreeLinkedListNode, this));
    }

    public final boolean w(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
        f51354c.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51353b;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        if (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, lockFreeLinkedListNode2, lockFreeLinkedListNode)) {
            return false;
        }
        lockFreeLinkedListNode.D(lockFreeLinkedListNode2);
        return true;
    }

    public final boolean y(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        f51354c.lazySet(lockFreeLinkedListNode, this);
        f51353b.lazySet(lockFreeLinkedListNode, this);
        while (E() == this) {
            if (androidx.concurrent.futures.a.a(f51353b, this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.D(this);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        if (androidx.concurrent.futures.a.a(kotlinx.coroutines.internal.LockFreeLinkedListNode.f51353b, r3, r2, ((kotlinx.coroutines.internal.z) r4).f51425a) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode z(kotlinx.coroutines.internal.y r8) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r7) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f51354c
            boolean r0 = androidx.concurrent.futures.a.a(r1, r7, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r7.J()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r8) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.y
            if (r5 == 0) goto L38
            if (r8 == 0) goto L32
            r0 = r4
            kotlinx.coroutines.internal.y r0 = (kotlinx.coroutines.internal.y) r0
            boolean r0 = r8.b(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            kotlinx.coroutines.internal.y r4 = (kotlinx.coroutines.internal.y) r4
            r4.c(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.z
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f51353b
            kotlinx.coroutines.internal.z r4 = (kotlinx.coroutines.internal.z) r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = r4.f51425a
            boolean r2 = androidx.concurrent.futures.a.a(r5, r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r2
            goto L7
        L52:
            r3 = r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.z(kotlinx.coroutines.internal.y):kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }
}
