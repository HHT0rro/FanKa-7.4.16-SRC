package com.google.android.exoplayer2.util;

import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: CopyOnWriteMultiset.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f<E> implements Iterable<E> {

    /* renamed from: b, reason: collision with root package name */
    public final Object f22976b = new Object();

    /* renamed from: c, reason: collision with root package name */
    @GuardedBy("lock")
    public final Map<E, Integer> f22977c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    @GuardedBy("lock")
    public Set<E> f22978d = Collections.emptySet();

    /* renamed from: e, reason: collision with root package name */
    @GuardedBy("lock")
    public List<E> f22979e = Collections.emptyList();

    public void b(E e2) {
        synchronized (this.f22976b) {
            ArrayList arrayList = new ArrayList(this.f22979e);
            arrayList.add(e2);
            this.f22979e = Collections.unmodifiableList(arrayList);
            Integer num = this.f22977c.get(e2);
            if (num == null) {
                HashSet hashSet = new HashSet(this.f22978d);
                hashSet.add(e2);
                this.f22978d = Collections.unmodifiableSet(hashSet);
            }
            this.f22977c.put(e2, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
        }
    }

    public void c(E e2) {
        synchronized (this.f22976b) {
            Integer num = this.f22977c.get(e2);
            if (num == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.f22979e);
            arrayList.remove(e2);
            this.f22979e = Collections.unmodifiableList(arrayList);
            if (num.intValue() == 1) {
                this.f22977c.remove(e2);
                HashSet hashSet = new HashSet(this.f22978d);
                hashSet.remove(e2);
                this.f22978d = Collections.unmodifiableSet(hashSet);
            } else {
                this.f22977c.put(e2, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    public int count(E e2) {
        int intValue;
        synchronized (this.f22976b) {
            intValue = this.f22977c.containsKey(e2) ? this.f22977c.get(e2).intValue() : 0;
        }
        return intValue;
    }

    public Set<E> elementSet() {
        Set<E> set;
        synchronized (this.f22976b) {
            set = this.f22978d;
        }
        return set;
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        Iterator<E> iterator2;
        synchronized (this.f22976b) {
            iterator2 = this.f22979e.iterator2();
        }
        return iterator2;
    }
}
