package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.base.Suppliers;
import com.google.common.base.j;
import com.google.common.base.o;
import com.google.common.base.t;
import com.google.common.base.v;
import com.google.common.cache.LocalCache;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class CacheBuilder<K, V> {

    /* renamed from: q, reason: collision with root package name */
    public static final t<? extends com.google.common.cache.b> f26000q = Suppliers.a(new a());

    /* renamed from: r, reason: collision with root package name */
    public static final d f26001r = new d(0, 0, 0, 0, 0, 0);

    /* renamed from: s, reason: collision with root package name */
    public static final t<com.google.common.cache.b> f26002s = new b();

    /* renamed from: t, reason: collision with root package name */
    public static final v f26003t = new c();

    /* renamed from: u, reason: collision with root package name */
    public static final Logger f26004u = Logger.getLogger(CacheBuilder.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public j<? super K, ? super V> f26010f;

    /* renamed from: g, reason: collision with root package name */
    public LocalCache.Strength f26011g;

    /* renamed from: h, reason: collision with root package name */
    public LocalCache.Strength f26012h;

    /* renamed from: l, reason: collision with root package name */
    public Equivalence<Object> f26016l;

    /* renamed from: m, reason: collision with root package name */
    public Equivalence<Object> f26017m;

    /* renamed from: n, reason: collision with root package name */
    public i<? super K, ? super V> f26018n;

    /* renamed from: o, reason: collision with root package name */
    public v f26019o;

    /* renamed from: a, reason: collision with root package name */
    public boolean f26005a = true;

    /* renamed from: b, reason: collision with root package name */
    public int f26006b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f26007c = -1;

    /* renamed from: d, reason: collision with root package name */
    public long f26008d = -1;

    /* renamed from: e, reason: collision with root package name */
    public long f26009e = -1;

    /* renamed from: i, reason: collision with root package name */
    public long f26013i = -1;

    /* renamed from: j, reason: collision with root package name */
    public long f26014j = -1;

    /* renamed from: k, reason: collision with root package name */
    public long f26015k = -1;

    /* renamed from: p, reason: collision with root package name */
    public t<? extends com.google.common.cache.b> f26020p = f26000q;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum NullListener implements i<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.i
        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum OneWeigher implements j<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.j
        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements com.google.common.cache.b {
        @Override // com.google.common.cache.b
        public void a(int i10) {
        }

        @Override // com.google.common.cache.b
        public void b() {
        }

        @Override // com.google.common.cache.b
        public void c(long j10) {
        }

        @Override // com.google.common.cache.b
        public void d(int i10) {
        }

        @Override // com.google.common.cache.b
        public void e(long j10) {
        }

        @Override // com.google.common.cache.b
        public d f() {
            return CacheBuilder.f26001r;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b implements t<com.google.common.cache.b> {
        @Override // com.google.common.base.t
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.common.cache.b get() {
            return new com.google.common.cache.a();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c extends v {
        @Override // com.google.common.base.v
        public long a() {
            return 0L;
        }
    }

    public static CacheBuilder<Object, Object> y() {
        return new CacheBuilder<>();
    }

    public CacheBuilder<K, V> A(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.f26011g;
        o.B(strength2 == null, "Key strength was already set to %s", strength2);
        this.f26011g = (LocalCache.Strength) o.r(strength);
        return this;
    }

    public CacheBuilder<K, V> B(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.f26012h;
        o.B(strength2 == null, "Value strength was already set to %s", strength2);
        this.f26012h = (LocalCache.Strength) o.r(strength);
        return this;
    }

    public CacheBuilder<K, V> C(v vVar) {
        o.x(this.f26019o == null);
        this.f26019o = (v) o.r(vVar);
        return this;
    }

    public CacheBuilder<K, V> D(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f26017m;
        o.B(equivalence2 == null, "value equivalence was already set to %s", equivalence2);
        this.f26017m = (Equivalence) o.r(equivalence);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> E(j<? super K1, ? super V1> jVar) {
        o.x(this.f26010f == null);
        if (this.f26005a) {
            long j10 = this.f26008d;
            o.A(j10 == -1, "weigher can not be combined with maximum size", j10);
        }
        this.f26010f = (j) o.r(jVar);
        return this;
    }

    public <K1 extends K, V1 extends V> com.google.common.cache.c<K1, V1> a() {
        d();
        c();
        return new LocalCache.LocalManualCache(this);
    }

    public <K1 extends K, V1 extends V> f<K1, V1> b(CacheLoader<? super K1, V1> cacheLoader) {
        d();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    public final void c() {
        o.y(this.f26015k == -1, "refreshAfterWrite requires a LoadingCache");
    }

    public final void d() {
        if (this.f26010f == null) {
            o.y(this.f26009e == -1, "maximumWeight requires weigher");
        } else if (this.f26005a) {
            o.y(this.f26009e != -1, "weigher requires maximumWeight");
        } else if (this.f26009e == -1) {
            f26004u.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    public CacheBuilder<K, V> e(int i10) {
        int i11 = this.f26007c;
        o.z(i11 == -1, "concurrency level was already set to %s", i11);
        o.d(i10 > 0);
        this.f26007c = i10;
        return this;
    }

    public CacheBuilder<K, V> f(long j10, TimeUnit timeUnit) {
        long j11 = this.f26014j;
        o.A(j11 == -1, "expireAfterAccess was already set to %s ns", j11);
        o.l(j10 >= 0, "duration cannot be negative: %s %s", j10, timeUnit);
        this.f26014j = timeUnit.toNanos(j10);
        return this;
    }

    public CacheBuilder<K, V> g(long j10, TimeUnit timeUnit) {
        long j11 = this.f26013i;
        o.A(j11 == -1, "expireAfterWrite was already set to %s ns", j11);
        o.l(j10 >= 0, "duration cannot be negative: %s %s", j10, timeUnit);
        this.f26013i = timeUnit.toNanos(j10);
        return this;
    }

    public int h() {
        int i10 = this.f26007c;
        if (i10 == -1) {
            return 4;
        }
        return i10;
    }

    public long i() {
        long j10 = this.f26014j;
        if (j10 == -1) {
            return 0L;
        }
        return j10;
    }

    public long j() {
        long j10 = this.f26013i;
        if (j10 == -1) {
            return 0L;
        }
        return j10;
    }

    public int k() {
        int i10 = this.f26006b;
        if (i10 == -1) {
            return 16;
        }
        return i10;
    }

    public Equivalence<Object> l() {
        return (Equivalence) com.google.common.base.j.a(this.f26016l, m().defaultEquivalence());
    }

    public LocalCache.Strength m() {
        return (LocalCache.Strength) com.google.common.base.j.a(this.f26011g, LocalCache.Strength.STRONG);
    }

    public long n() {
        if (this.f26013i == 0 || this.f26014j == 0) {
            return 0L;
        }
        return this.f26010f == null ? this.f26008d : this.f26009e;
    }

    public long o() {
        long j10 = this.f26015k;
        if (j10 == -1) {
            return 0L;
        }
        return j10;
    }

    public <K1 extends K, V1 extends V> i<K1, V1> p() {
        return (i) com.google.common.base.j.a(this.f26018n, NullListener.INSTANCE);
    }

    public t<? extends com.google.common.cache.b> q() {
        return this.f26020p;
    }

    public v r(boolean z10) {
        v vVar = this.f26019o;
        return vVar != null ? vVar : z10 ? v.b() : f26003t;
    }

    public Equivalence<Object> s() {
        return (Equivalence) com.google.common.base.j.a(this.f26017m, t().defaultEquivalence());
    }

    public LocalCache.Strength t() {
        return (LocalCache.Strength) com.google.common.base.j.a(this.f26012h, LocalCache.Strength.STRONG);
    }

    public String toString() {
        j.b c4 = com.google.common.base.j.c(this);
        int i10 = this.f26006b;
        if (i10 != -1) {
            c4.b("initialCapacity", i10);
        }
        int i11 = this.f26007c;
        if (i11 != -1) {
            c4.b("concurrencyLevel", i11);
        }
        long j10 = this.f26008d;
        if (j10 != -1) {
            c4.c("maximumSize", j10);
        }
        long j11 = this.f26009e;
        if (j11 != -1) {
            c4.c("maximumWeight", j11);
        }
        long j12 = this.f26013i;
        if (j12 != -1) {
            StringBuilder sb2 = new StringBuilder(22);
            sb2.append(j12);
            sb2.append("ns");
            c4.d("expireAfterWrite", sb2.toString());
        }
        long j13 = this.f26014j;
        if (j13 != -1) {
            StringBuilder sb3 = new StringBuilder(22);
            sb3.append(j13);
            sb3.append("ns");
            c4.d("expireAfterAccess", sb3.toString());
        }
        LocalCache.Strength strength = this.f26011g;
        if (strength != null) {
            c4.d("keyStrength", com.google.common.base.a.e(strength.toString()));
        }
        LocalCache.Strength strength2 = this.f26012h;
        if (strength2 != null) {
            c4.d("valueStrength", com.google.common.base.a.e(strength2.toString()));
        }
        if (this.f26016l != null) {
            c4.k("keyEquivalence");
        }
        if (this.f26017m != null) {
            c4.k("valueEquivalence");
        }
        if (this.f26018n != null) {
            c4.k("removalListener");
        }
        return c4.toString();
    }

    public <K1 extends K, V1 extends V> j<K1, V1> u() {
        return (j) com.google.common.base.j.a(this.f26010f, OneWeigher.INSTANCE);
    }

    public CacheBuilder<K, V> v(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f26016l;
        o.B(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.f26016l = (Equivalence) o.r(equivalence);
        return this;
    }

    public CacheBuilder<K, V> w(long j10) {
        long j11 = this.f26008d;
        o.A(j11 == -1, "maximum size was already set to %s", j11);
        long j12 = this.f26009e;
        o.A(j12 == -1, "maximum weight was already set to %s", j12);
        o.y(this.f26010f == null, "maximum size can not be combined with weigher");
        o.e(j10 >= 0, "maximum size must not be negative");
        this.f26008d = j10;
        return this;
    }

    public CacheBuilder<K, V> x(long j10) {
        long j11 = this.f26009e;
        o.A(j11 == -1, "maximum weight was already set to %s", j11);
        long j12 = this.f26008d;
        o.A(j12 == -1, "maximum size was already set to %s", j12);
        o.e(j10 >= 0, "maximum weight must not be negative");
        this.f26009e = j10;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> z(i<? super K1, ? super V1> iVar) {
        o.x(this.f26018n == null);
        this.f26018n = (i) o.r(iVar);
        return this;
    }
}
