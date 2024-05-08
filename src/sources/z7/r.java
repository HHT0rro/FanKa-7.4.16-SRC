package z7;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class r extends z7.a {

    /* renamed from: a, reason: collision with root package name */
    public final Set<Class<?>> f55018a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<Class<?>> f55019b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<Class<?>> f55020c;

    /* renamed from: d, reason: collision with root package name */
    public final Set<Class<?>> f55021d;

    /* renamed from: e, reason: collision with root package name */
    public final Set<Class<?>> f55022e;

    /* renamed from: f, reason: collision with root package name */
    public final d f55023f;

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a implements d8.b {

        /* renamed from: a, reason: collision with root package name */
        public final Set<Class<?>> f55024a;

        /* renamed from: b, reason: collision with root package name */
        public final d8.b f55025b;

        public a(Set<Class<?>> set, d8.b bVar) {
            this.f55024a = set;
            this.f55025b = bVar;
        }
    }

    public r(c<?> cVar, d dVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (m mVar : cVar.c()) {
            if (mVar.b()) {
                if (mVar.d()) {
                    hashSet3.add(mVar.a());
                } else {
                    hashSet.add(mVar.a());
                }
            } else if (mVar.d()) {
                hashSet4.add(mVar.a());
            } else {
                hashSet2.add(mVar.a());
            }
        }
        if (!cVar.f().isEmpty()) {
            hashSet.add(d8.b.class);
        }
        this.f55018a = Collections.unmodifiableSet(hashSet);
        this.f55019b = Collections.unmodifiableSet(hashSet2);
        this.f55020c = Collections.unmodifiableSet(hashSet3);
        this.f55021d = Collections.unmodifiableSet(hashSet4);
        this.f55022e = cVar.f();
        this.f55023f = dVar;
    }

    @Override // z7.d
    public <T> e8.a<Set<T>> a(Class<T> cls) {
        if (this.f55021d.contains(cls)) {
            return this.f55023f.a(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }

    @Override // z7.a, z7.d
    public <T> Set<T> b(Class<T> cls) {
        if (this.f55020c.contains(cls)) {
            return this.f55023f.b(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }

    @Override // z7.d
    public <T> e8.a<T> c(Class<T> cls) {
        if (this.f55019b.contains(cls)) {
            return this.f55023f.c(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }

    @Override // z7.a, z7.d
    public <T> T get(Class<T> cls) {
        if (this.f55018a.contains(cls)) {
            T t2 = (T) this.f55023f.get(cls);
            return !cls.equals(d8.b.class) ? t2 : (T) new a(this.f55022e, (d8.b) t2);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", cls));
    }
}
