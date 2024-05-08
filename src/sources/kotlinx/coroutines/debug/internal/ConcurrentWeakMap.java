package kotlinx.coroutines.debug.internal;

import ce.n;
import com.alibaba.security.common.track.model.TrackConstants;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConcurrentWeakMap.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ConcurrentWeakMap<K, V> extends kotlin.collections.f<K, V> {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f51184c = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");

    @NotNull
    private volatile /* synthetic */ int _size;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final ReferenceQueue<K> f51185b;

    @NotNull
    public volatile /* synthetic */ Object core;

    /* compiled from: ConcurrentWeakMap.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class a {

        /* renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f51186g = AtomicIntegerFieldUpdater.newUpdater(a.class, TrackConstants.Method.LOAD);

        /* renamed from: a, reason: collision with root package name */
        public final int f51187a;

        /* renamed from: b, reason: collision with root package name */
        public final int f51188b;

        /* renamed from: c, reason: collision with root package name */
        public final int f51189c;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public /* synthetic */ AtomicReferenceArray f51190d;

        /* renamed from: e, reason: collision with root package name */
        @NotNull
        public /* synthetic */ AtomicReferenceArray f51191e;

        @NotNull
        private volatile /* synthetic */ int load = 0;

        /* compiled from: ConcurrentWeakMap.kt */
        @kotlin.d
        /* renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class C0779a<E> implements Iterator<E>, zd.a {

            /* renamed from: b, reason: collision with root package name */
            @NotNull
            public final Function2<K, V, E> f51193b;

            /* renamed from: c, reason: collision with root package name */
            public int f51194c = -1;

            /* renamed from: d, reason: collision with root package name */
            public K f51195d;

            /* renamed from: e, reason: collision with root package name */
            public V f51196e;

            /* JADX WARN: Multi-variable type inference failed */
            public C0779a(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
                this.f51193b = function2;
                a();
            }

            public final void a() {
                K k10;
                while (true) {
                    int i10 = this.f51194c + 1;
                    this.f51194c = i10;
                    if (i10 >= a.this.f51187a) {
                        return;
                    }
                    f fVar = (f) a.this.f51190d.get(this.f51194c);
                    if (fVar != null && (k10 = (K) fVar.get()) != null) {
                        this.f51195d = k10;
                        Object obj = (V) a.this.f51191e.get(this.f51194c);
                        if (obj instanceof g) {
                            obj = (V) ((g) obj).f51229a;
                        }
                        if (obj != null) {
                            this.f51196e = (V) obj;
                            return;
                        }
                    }
                }
            }

            @Override // java.util.Iterator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Void remove() {
                kotlinx.coroutines.debug.internal.a.c();
                throw new KotlinNothingValueException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f51194c < a.this.f51187a;
            }

            @Override // java.util.Iterator
            public E next() {
                if (this.f51194c < a.this.f51187a) {
                    Function2<K, V, E> function2 = this.f51193b;
                    K k10 = this.f51195d;
                    if (k10 == false) {
                        s.A("key");
                        k10 = (K) p.f51048a;
                    }
                    V v2 = this.f51196e;
                    if (v2 == false) {
                        s.A("value");
                        v2 = (V) p.f51048a;
                    }
                    E e2 = (E) function2.mo1743invoke(k10, v2);
                    a();
                    return e2;
                }
                throw new NoSuchElementException();
            }
        }

        public a(int i10) {
            this.f51187a = i10;
            this.f51188b = Integer.numberOfLeadingZeros(i10) + 1;
            this.f51189c = (i10 * 2) / 3;
            this.f51190d = new AtomicReferenceArray(i10);
            this.f51191e = new AtomicReferenceArray(i10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object g(a aVar, Object obj, Object obj2, f fVar, int i10, Object obj3) {
            if ((i10 & 4) != 0) {
                fVar = null;
            }
            return aVar.f(obj, obj2, fVar);
        }

        public final void b(@NotNull f<?> fVar) {
            int d10 = d(fVar.f51228a);
            while (true) {
                f<?> fVar2 = (f) this.f51190d.get(d10);
                if (fVar2 == null) {
                    return;
                }
                if (fVar2 == fVar) {
                    i(d10);
                    return;
                } else {
                    if (d10 == 0) {
                        d10 = this.f51187a;
                    }
                    d10--;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        public final V c(@NotNull K k10) {
            int d10 = d(k10.hashCode());
            while (true) {
                f fVar = (f) this.f51190d.get(d10);
                if (fVar == null) {
                    return null;
                }
                T t2 = fVar.get();
                if (s.d(k10, t2)) {
                    V v2 = (V) this.f51191e.get(d10);
                    return v2 instanceof g ? (V) ((g) v2).f51229a : v2;
                }
                if (t2 == 0) {
                    i(d10);
                }
                if (d10 == 0) {
                    d10 = this.f51187a;
                }
                d10--;
            }
        }

        public final int d(int i10) {
            return (i10 * (-1640531527)) >>> this.f51188b;
        }

        @NotNull
        public final <E> Iterator<E> e(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
            return new C0779a(function2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
        
            r6 = r5.f51191e.get(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
        
            if ((r6 instanceof kotlinx.coroutines.debug.internal.g) == false) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
        
            if (r5.f51191e.compareAndSet(r0, r6, r7) == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x006e, code lost:
        
            return r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
        
            return kotlinx.coroutines.debug.internal.a.a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0017, code lost:
        
            if (r1 == false) goto L9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0019, code lost:
        
            r1 = r5.load;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x001d, code lost:
        
            if (r1 < r5.f51189c) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x002c, code lost:
        
            if (kotlinx.coroutines.debug.internal.ConcurrentWeakMap.a.f51186g.compareAndSet(r5, r1, r1 + 1) != false) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x002f, code lost:
        
            r1 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0023, code lost:
        
            return kotlinx.coroutines.debug.internal.a.a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0030, code lost:
        
            if (r8 != null) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0032, code lost:
        
            r8 = new kotlinx.coroutines.debug.internal.f<>(r6, r5.f51192f.f51185b);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0043, code lost:
        
            if (r5.f51190d.compareAndSet(r0, null, r8) != false) goto L38;
         */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object f(@org.jetbrains.annotations.NotNull K r6, @org.jetbrains.annotations.Nullable V r7, @org.jetbrains.annotations.Nullable kotlinx.coroutines.debug.internal.f<K> r8) {
            /*
                r5 = this;
                int r0 = r6.hashCode()
                int r0 = r5.d(r0)
                r1 = 0
            L9:
                java.util.concurrent.atomic.AtomicReferenceArray r2 = r5.f51190d
                java.lang.Object r2 = r2.get(r0)
                kotlinx.coroutines.debug.internal.f r2 = (kotlinx.coroutines.debug.internal.f) r2
                if (r2 != 0) goto L46
                r2 = 0
                if (r7 != 0) goto L17
                return r2
            L17:
                if (r1 != 0) goto L30
            L19:
                int r1 = r5.load
                int r3 = r5.f51189c
                if (r1 < r3) goto L24
                kotlinx.coroutines.internal.f0 r6 = kotlinx.coroutines.debug.internal.a.a()
                return r6
            L24:
                int r3 = r1 + 1
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r4 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.a.f51186g
                boolean r1 = r4.compareAndSet(r5, r1, r3)
                if (r1 != 0) goto L2f
                goto L19
            L2f:
                r1 = 1
            L30:
                if (r8 != 0) goto L3d
                kotlinx.coroutines.debug.internal.f r8 = new kotlinx.coroutines.debug.internal.f
                kotlinx.coroutines.debug.internal.ConcurrentWeakMap<K, V> r3 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.this
                java.lang.ref.ReferenceQueue r3 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.f(r3)
                r8.<init>(r6, r3)
            L3d:
                java.util.concurrent.atomic.AtomicReferenceArray r3 = r5.f51190d
                boolean r2 = r3.compareAndSet(r0, r2, r8)
                if (r2 != 0) goto L57
                goto L9
            L46:
                java.lang.Object r2 = r2.get()
                boolean r3 = kotlin.jvm.internal.s.d(r6, r2)
                if (r3 == 0) goto L6f
                if (r1 == 0) goto L57
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r6 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.a.f51186g
                r6.decrementAndGet(r5)
            L57:
                java.util.concurrent.atomic.AtomicReferenceArray r6 = r5.f51191e
                java.lang.Object r6 = r6.get(r0)
                boolean r8 = r6 instanceof kotlinx.coroutines.debug.internal.g
                if (r8 == 0) goto L66
                kotlinx.coroutines.internal.f0 r6 = kotlinx.coroutines.debug.internal.a.a()
                return r6
            L66:
                java.util.concurrent.atomic.AtomicReferenceArray r8 = r5.f51191e
                boolean r8 = r8.compareAndSet(r0, r6, r7)
                if (r8 == 0) goto L57
                return r6
            L6f:
                if (r2 != 0) goto L74
                r5.i(r0)
            L74:
                if (r0 != 0) goto L78
                int r0 = r5.f51187a
            L78:
                int r0 = r0 + (-1)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.ConcurrentWeakMap.a.f(java.lang.Object, java.lang.Object, kotlinx.coroutines.debug.internal.f):java.lang.Object");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final ConcurrentWeakMap<K, V>.a h() {
            int i10;
            Object obj;
            while (true) {
                ConcurrentWeakMap<K, V>.a aVar = (ConcurrentWeakMap<K, V>.a) new a(Integer.highestOneBit(n.b(ConcurrentWeakMap.this.size(), 4)) * 4);
                int i11 = this.f51187a;
                while (i10 < i11) {
                    f fVar = (f) this.f51190d.get(i10);
                    Object obj2 = fVar != null ? fVar.get() : null;
                    if (fVar != null && obj2 == null) {
                        i(i10);
                    }
                    while (true) {
                        obj = this.f51191e.get(i10);
                        if (obj instanceof g) {
                            obj = ((g) obj).f51229a;
                            break;
                        }
                        if (this.f51191e.compareAndSet(i10, obj, kotlinx.coroutines.debug.internal.a.b(obj))) {
                            break;
                        }
                    }
                    i10 = (obj2 == null || obj == null || aVar.f(obj2, obj, fVar) != kotlinx.coroutines.debug.internal.a.a()) ? i10 + 1 : 0;
                }
                return aVar;
            }
        }

        public final void i(int i10) {
            Object obj;
            do {
                obj = this.f51191e.get(i10);
                if (obj == null || (obj instanceof g)) {
                    return;
                }
            } while (!this.f51191e.compareAndSet(i10, obj, null));
            ConcurrentWeakMap.this.h();
        }
    }

    /* compiled from: ConcurrentWeakMap.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class b<K, V> implements Map.Entry<K, V>, zd.a {

        /* renamed from: b, reason: collision with root package name */
        public final K f51198b;

        /* renamed from: c, reason: collision with root package name */
        public final V f51199c;

        public b(K k10, V v2) {
            this.f51198b = k10;
            this.f51199c = v2;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f51198b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f51199c;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v2) {
            kotlinx.coroutines.debug.internal.a.c();
            throw new KotlinNothingValueException();
        }
    }

    /* compiled from: ConcurrentWeakMap.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class c<E> extends kotlin.collections.g<E> {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final Function2<K, V, E> f51200b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull Function2<? super K, ? super V, ? extends E> function2) {
            this.f51200b = function2;
        }

        @Override // kotlin.collections.g, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(E e2) {
            kotlinx.coroutines.debug.internal.a.c();
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.collections.g
        public int getSize() {
            return ConcurrentWeakMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        @NotNull
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return ((a) ConcurrentWeakMap.this.core).e(this.f51200b);
        }
    }

    public ConcurrentWeakMap() {
        this(false, 1, null);
    }

    public /* synthetic */ ConcurrentWeakMap(boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? false : z10);
    }

    @Override // kotlin.collections.f
    @NotNull
    public Set<Map.Entry<K, V>> a() {
        return new c(new Function2<K, V, Map.Entry<K, V>>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$entries$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo1743invoke(Object obj, Object obj2) {
                return mo1743invoke((ConcurrentWeakMap$entries$1<K, V>) obj, obj2);
            }

            @Override // kotlin.jvm.functions.Function2
            @NotNull
            /* renamed from: invoke */
            public final Map.Entry<K, V> mo1743invoke(@NotNull K k10, @NotNull V v2) {
                return new ConcurrentWeakMap.b(k10, v2);
            }
        });
    }

    @Override // kotlin.collections.f
    @NotNull
    public Set<K> b() {
        return new c(new Function2<K, V, K>() { // from class: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$keys$1
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            /* renamed from: invoke */
            public final K mo1743invoke(@NotNull K k10, @NotNull V v2) {
                return k10;
            }
        });
    }

    @Override // kotlin.collections.f
    public int c() {
        return this._size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator<K> iterator2 = h().iterator2();
        while (iterator2.hasNext()) {
            remove(iterator2.next());
        }
    }

    public final void g(f<?> fVar) {
        ((a) this.core).b(fVar);
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V get(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        return (V) ((a) this.core).c(obj);
    }

    public final void h() {
        f51184c.decrementAndGet(this);
    }

    public final synchronized V i(K k10, V v2) {
        V v10;
        a aVar = (a) this.core;
        while (true) {
            v10 = (V) a.g(aVar, k10, v2, null, 4, null);
            if (v10 == kotlinx.coroutines.debug.internal.a.a()) {
                aVar = aVar.h();
                this.core = aVar;
            }
        }
        return v10;
    }

    public final void j() {
        if (!(this.f51185b != null)) {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
        while (true) {
            try {
                Reference<? extends K> remove = this.f51185b.remove();
                if (remove == null) {
                    break;
                } else {
                    g((f) remove);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V put(@NotNull K k10, @NotNull V v2) {
        V v10 = (V) a.g((a) this.core, k10, v2, null, 4, null);
        if (v10 == kotlinx.coroutines.debug.internal.a.a()) {
            v10 = i(k10, v2);
        }
        if (v10 == null) {
            f51184c.incrementAndGet(this);
        }
        return v10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V remove(@Nullable Object obj) {
        if (obj == 0) {
            return null;
        }
        V v2 = (V) a.g((a) this.core, obj, null, null, 4, null);
        if (v2 == kotlinx.coroutines.debug.internal.a.a()) {
            v2 = i(obj, null);
        }
        if (v2 != null) {
            f51184c.decrementAndGet(this);
        }
        return v2;
    }

    public ConcurrentWeakMap(boolean z10) {
        this._size = 0;
        this.core = new a(16);
        this.f51185b = z10 ? new ReferenceQueue<>() : null;
    }
}
