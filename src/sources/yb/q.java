package yb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* compiled from: DatabaseWorkerPool.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class q implements o {

    /* renamed from: a, reason: collision with root package name */
    public final String f54776a;

    /* renamed from: b, reason: collision with root package name */
    public final int f54777b;

    /* renamed from: c, reason: collision with root package name */
    public final int f54778c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedList<k> f54779d = new LinkedList<>();

    /* renamed from: e, reason: collision with root package name */
    public final Set<m> f54780e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public final Set<m> f54781f = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    public final Map<Integer, m> f54782g = new HashMap();

    public q(String str, int i10, int i11) {
        this.f54776a = str;
        this.f54777b = i10;
        this.f54778c = i11;
    }

    @Override // yb.o
    public synchronized void a(k kVar) {
        this.f54779d.add(kVar);
        Iterator<E> iterator2 = new HashSet(this.f54780e).iterator2();
        while (iterator2.hasNext()) {
            i((m) iterator2.next());
        }
    }

    @Override // yb.o
    public synchronized void b() {
        Iterator<m> iterator2 = this.f54780e.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().f();
        }
        Iterator<m> iterator22 = this.f54781f.iterator2();
        while (iterator22.hasNext()) {
            iterator22.next().f();
        }
    }

    @Override // yb.o
    public /* synthetic */ void c(i iVar, Runnable runnable) {
        n.a(this, iVar, runnable);
    }

    public m e(String str, int i10) {
        return new m(str, i10);
    }

    public final synchronized k f(m mVar) {
        k next;
        m mVar2;
        ListIterator<k> listIterator = this.f54779d.listIterator();
        do {
            if (!listIterator.hasNext()) {
                return null;
            }
            next = listIterator.next();
            mVar2 = next.a() != null ? this.f54782g.get(next.a()) : null;
            if (mVar2 == null) {
                break;
            }
        } while (mVar2 != mVar);
        listIterator.remove();
        return next;
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final synchronized void g(m mVar) {
        HashSet hashSet = new HashSet(this.f54780e);
        this.f54781f.remove(mVar);
        this.f54780e.add(mVar);
        if (!mVar.b() && mVar.d() != null) {
            this.f54782g.remove(mVar.d());
        }
        i(mVar);
        Iterator<E> iterator2 = hashSet.iterator2();
        while (iterator2.hasNext()) {
            i((m) iterator2.next());
        }
    }

    public final synchronized void i(m mVar) {
        k f10 = f(mVar);
        if (f10 != null) {
            this.f54781f.add(mVar);
            this.f54780e.remove(mVar);
            if (f10.a() != null) {
                this.f54782g.put(f10.a(), mVar);
            }
            mVar.e(f10);
        }
    }

    @Override // yb.o
    public synchronized void start() {
        for (int i10 = 0; i10 < this.f54777b; i10++) {
            final m e2 = e(this.f54776a + i10, this.f54778c);
            e2.g(new Runnable() { // from class: yb.p
                @Override // java.lang.Runnable
                public final void run() {
                    q.this.g(e2);
                }
            });
            this.f54780e.add(e2);
        }
    }
}
