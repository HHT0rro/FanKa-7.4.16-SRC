package z7;

import com.google.firebase.components.DependencyCycleException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class l {

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final z7.c<?> f55002a;

        /* renamed from: b, reason: collision with root package name */
        public final Set<b> f55003b = new HashSet();

        /* renamed from: c, reason: collision with root package name */
        public final Set<b> f55004c = new HashSet();

        public b(z7.c<?> cVar) {
            this.f55002a = cVar;
        }

        public void a(b bVar) {
            this.f55003b.add(bVar);
        }

        public void b(b bVar) {
            this.f55004c.add(bVar);
        }

        public z7.c<?> c() {
            return this.f55002a;
        }

        public Set<b> d() {
            return this.f55003b;
        }

        public boolean e() {
            return this.f55003b.isEmpty();
        }

        public boolean f() {
            return this.f55004c.isEmpty();
        }

        public void g(b bVar) {
            this.f55004c.remove(bVar);
        }
    }

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final Class<?> f55005a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f55006b;

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.f55005a.equals(this.f55005a) && cVar.f55006b == this.f55006b;
        }

        public int hashCode() {
            return ((this.f55005a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f55006b).hashCode();
        }

        public c(Class<?> cls, boolean z10) {
            this.f55005a = cls;
            this.f55006b = z10;
        }
    }

    public static void a(List<z7.c<?>> list) {
        Set<b> c4 = c(list);
        Set<b> b4 = b(c4);
        int i10 = 0;
        while (!b4.isEmpty()) {
            b next = b4.iterator2().next();
            b4.remove(next);
            i10++;
            for (b bVar : next.d()) {
                bVar.g(next);
                if (bVar.f()) {
                    b4.add(bVar);
                }
            }
        }
        if (i10 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar2 : c4) {
            if (!bVar2.f() && !bVar2.e()) {
                arrayList.add(bVar2.c());
            }
        }
        throw new DependencyCycleException(arrayList);
    }

    public static Set<b> b(Set<b> set) {
        HashSet hashSet = new HashSet();
        for (b bVar : set) {
            if (bVar.f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    public static Set<b> c(List<z7.c<?>> list) {
        Set<b> set;
        HashMap hashMap = new HashMap(list.size());
        Iterator<z7.c<?>> iterator2 = list.iterator2();
        while (true) {
            if (iterator2.hasNext()) {
                z7.c<?> next = iterator2.next();
                b bVar = new b(next);
                for (Class<? super Object> cls : next.e()) {
                    c cVar = new c(cls, !next.j());
                    if (!hashMap.containsKey(cVar)) {
                        hashMap.put(cVar, new HashSet());
                    }
                    Set set2 = (Set) hashMap.get(cVar);
                    if (!set2.isEmpty() && !cVar.f55006b) {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                    }
                    set2.add(bVar);
                }
            } else {
                Iterator iterator22 = hashMap.values().iterator2();
                while (iterator22.hasNext()) {
                    for (b bVar2 : (Set) iterator22.next()) {
                        for (m mVar : bVar2.c().c()) {
                            if (mVar.b() && (set = (Set) hashMap.get(new c(mVar.a(), mVar.d()))) != null) {
                                for (b bVar3 : set) {
                                    bVar2.a(bVar3);
                                    bVar3.b(bVar2);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator iterator23 = hashMap.values().iterator2();
                while (iterator23.hasNext()) {
                    hashSet.addAll((Set) iterator23.next());
                }
                return hashSet;
            }
        }
    }
}
