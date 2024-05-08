package z7;

import com.google.firebase.components.MissingDependencyException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class k extends a {

    /* renamed from: e, reason: collision with root package name */
    public static final e8.a<Set<Object>> f54997e = j.a();

    /* renamed from: a, reason: collision with root package name */
    public final Map<c<?>, p<?>> f54998a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, p<?>> f54999b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Map<Class<?>, p<Set<?>>> f55000c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final o f55001d;

    public k(Executor executor, Iterable<g> iterable, c<?>... cVarArr) {
        o oVar = new o(executor);
        this.f55001d = oVar;
        ArrayList<c<?>> arrayList = new ArrayList();
        arrayList.add(c.l(oVar, o.class, d8.c.class, d8.b.class));
        Iterator<g> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            arrayList.addAll(iterator2.next().a());
        }
        for (c<?> cVar : cVarArr) {
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        l.a(arrayList);
        for (c<?> cVar2 : arrayList) {
            this.f54998a.put(cVar2, new p<>(h.a(this, cVar2)));
        }
        g();
        h();
    }

    public static /* synthetic */ Set f(Set set) {
        HashSet hashSet = new HashSet();
        Iterator iterator2 = set.iterator2();
        while (iterator2.hasNext()) {
            hashSet.add(((p) iterator2.next()).get());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // z7.d
    public <T> e8.a<Set<T>> a(Class<T> cls) {
        p<Set<?>> pVar = this.f55000c.get(cls);
        return pVar != null ? pVar : (e8.a<Set<T>>) f54997e;
    }

    @Override // z7.a, z7.d
    public /* bridge */ /* synthetic */ Set b(Class cls) {
        return super.b(cls);
    }

    @Override // z7.d
    public <T> e8.a<T> c(Class<T> cls) {
        q.c(cls, "Null interface requested.");
        return this.f54999b.get(cls);
    }

    public void d(boolean z10) {
        for (Map.Entry<c<?>, p<?>> entry : this.f54998a.entrySet()) {
            c<?> key = entry.getKey();
            p<?> value = entry.getValue();
            if (key.h() || (key.i() && z10)) {
                value.get();
            }
        }
        this.f55001d.a();
    }

    public final void g() {
        for (Map.Entry<c<?>, p<?>> entry : this.f54998a.entrySet()) {
            c<?> key = entry.getKey();
            if (key.j()) {
                p<?> value = entry.getValue();
                Iterator<Class<? super Object>> iterator2 = key.e().iterator2();
                while (iterator2.hasNext()) {
                    this.f54999b.put(iterator2.next(), value);
                }
            }
        }
        i();
    }

    @Override // z7.a, z7.d
    public /* bridge */ /* synthetic */ Object get(Class cls) {
        return super.get(cls);
    }

    public final void h() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<c<?>, p<?>> entry : this.f54998a.entrySet()) {
            c<?> key = entry.getKey();
            if (!key.j()) {
                p<?> value = entry.getValue();
                for (Class<? super Object> cls : key.e()) {
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, new HashSet());
                    }
                    ((Set) hashMap.get(cls)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            this.f55000c.put((Class) entry2.getKey(), new p<>(i.a((Set) entry2.getValue())));
        }
    }

    public final void i() {
        for (c<?> cVar : this.f54998a.h()) {
            for (m mVar : cVar.c()) {
                if (mVar.c() && !this.f54999b.containsKey(mVar.a())) {
                    throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", cVar, mVar.a()));
                }
            }
        }
    }
}
