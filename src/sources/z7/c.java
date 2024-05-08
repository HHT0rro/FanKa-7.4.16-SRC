package z7;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Set<Class<? super T>> f54978a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<m> f54979b;

    /* renamed from: c, reason: collision with root package name */
    public final int f54980c;

    /* renamed from: d, reason: collision with root package name */
    public final int f54981d;

    /* renamed from: e, reason: collision with root package name */
    public final f<T> f54982e;

    /* renamed from: f, reason: collision with root package name */
    public final Set<Class<?>> f54983f;

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Set<Class<? super T>> f54984a;

        /* renamed from: b, reason: collision with root package name */
        public final Set<m> f54985b;

        /* renamed from: c, reason: collision with root package name */
        public int f54986c;

        /* renamed from: d, reason: collision with root package name */
        public int f54987d;

        /* renamed from: e, reason: collision with root package name */
        public f<T> f54988e;

        /* renamed from: f, reason: collision with root package name */
        public Set<Class<?>> f54989f;

        public b<T> b(m mVar) {
            q.c(mVar, "Null dependency");
            f(mVar.a());
            this.f54985b.add(mVar);
            return this;
        }

        public c<T> c() {
            q.d(this.f54988e != null, "Missing required property: factory.");
            return new c<>(new HashSet(this.f54984a), new HashSet(this.f54985b), this.f54986c, this.f54987d, this.f54988e, this.f54989f);
        }

        public b<T> d(f<T> fVar) {
            this.f54988e = (f) q.c(fVar, "Null factory");
            return this;
        }

        public final b<T> e() {
            this.f54987d = 1;
            return this;
        }

        public final void f(Class<?> cls) {
            q.a(!this.f54984a.contains(cls), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        @SafeVarargs
        public b(Class<T> cls, Class<? super T>... clsArr) {
            HashSet hashSet = new HashSet();
            this.f54984a = hashSet;
            this.f54985b = new HashSet();
            this.f54986c = 0;
            this.f54987d = 0;
            this.f54989f = new HashSet();
            q.c(cls, "Null interface");
            hashSet.add(cls);
            for (Class<? super T> cls2 : clsArr) {
                q.c(cls2, "Null interface");
            }
            Collections.addAll(this.f54984a, clsArr);
        }
    }

    public static <T> b<T> a(Class<T> cls) {
        return new b<>(cls, new Class[0]);
    }

    @SafeVarargs
    public static <T> b<T> b(Class<T> cls, Class<? super T>... clsArr) {
        return new b<>(cls, clsArr);
    }

    public static <T> b<T> g(Class<T> cls) {
        return a(cls).e();
    }

    public static /* synthetic */ Object k(Object obj, d dVar) {
        return obj;
    }

    @SafeVarargs
    public static <T> c<T> l(T t2, Class<T> cls, Class<? super T>... clsArr) {
        return b(cls, clsArr).d(z7.b.b(t2)).c();
    }

    public Set<m> c() {
        return this.f54979b;
    }

    public f<T> d() {
        return this.f54982e;
    }

    public Set<Class<? super T>> e() {
        return this.f54978a;
    }

    public Set<Class<?>> f() {
        return this.f54983f;
    }

    public boolean h() {
        return this.f54980c == 1;
    }

    public boolean i() {
        return this.f54980c == 2;
    }

    public boolean j() {
        return this.f54981d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f54978a.toArray()) + ">{" + this.f54980c + ", type=" + this.f54981d + ", deps=" + Arrays.toString(this.f54979b.toArray()) + com.alipay.sdk.util.i.f4738d;
    }

    public c(Set<Class<? super T>> set, Set<m> set2, int i10, int i11, f<T> fVar, Set<Class<?>> set3) {
        this.f54978a = Collections.unmodifiableSet(set);
        this.f54979b = Collections.unmodifiableSet(set2);
        this.f54980c = i10;
        this.f54981d = i11;
        this.f54982e = fVar;
        this.f54983f = Collections.unmodifiableSet(set3);
    }
}
