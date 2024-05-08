package com.google.android.gms.internal.vision;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class x6<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: b */
    public final int f25696b;

    /* renamed from: c */
    public List<c7> f25697c;

    /* renamed from: d */
    public Map<K, V> f25698d;

    /* renamed from: e */
    public boolean f25699e;

    /* renamed from: f */
    public volatile e7 f25700f;

    /* renamed from: g */
    public Map<K, V> f25701g;

    /* renamed from: h */
    public volatile y6 f25702h;

    public x6(int i10) {
        this.f25696b = i10;
        this.f25697c = Collections.emptyList();
        this.f25698d = Collections.emptyMap();
        this.f25701g = Collections.emptyMap();
    }

    public static <FieldDescriptorType extends s4<FieldDescriptorType>> x6<FieldDescriptorType, Object> b(int i10) {
        return new w6(i10);
    }

    public static /* synthetic */ Object c(x6 x6Var, int i10) {
        return x6Var.k(i10);
    }

    public static /* synthetic */ void f(x6 x6Var) {
        x6Var.p();
    }

    public static /* synthetic */ List g(x6 x6Var) {
        return x6Var.f25697c;
    }

    public static /* synthetic */ Map l(x6 x6Var) {
        return x6Var.f25698d;
    }

    public final int a(K k10) {
        int size = this.f25697c.size() - 1;
        if (size >= 0) {
            int compareTo = k10.compareTo((Comparable) this.f25697c.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i10 = 0;
        while (i10 <= size) {
            int i11 = (i10 + size) / 2;
            int compareTo2 = k10.compareTo((Comparable) this.f25697c.get(i11).getKey());
            if (compareTo2 < 0) {
                size = i11 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i11;
                }
                i10 = i11 + 1;
            }
        }
        return -(i10 + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        p();
        if (!this.f25697c.isEmpty()) {
            this.f25697c.clear();
        }
        if (this.f25698d.isEmpty()) {
            return;
        }
        this.f25698d.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f25698d.containsKey(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: d */
    public final V put(K k10, V v2) {
        p();
        int a10 = a(k10);
        if (a10 >= 0) {
            return (V) this.f25697c.get(a10).setValue(v2);
        }
        p();
        if (this.f25697c.isEmpty() && !(this.f25697c instanceof ArrayList)) {
            this.f25697c = new ArrayList(this.f25696b);
        }
        int i10 = -(a10 + 1);
        if (i10 >= this.f25696b) {
            return q().put(k10, v2);
        }
        int size = this.f25697c.size();
        int i11 = this.f25696b;
        if (size == i11) {
            c7 remove = this.f25697c.remove(i11 - 1);
            q().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f25697c.add(i10, new c7(this, k10, v2));
        return null;
    }

    public void e() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (this.f25699e) {
            return;
        }
        if (this.f25698d.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.f25698d);
        }
        this.f25698d = unmodifiableMap;
        if (this.f25701g.isEmpty()) {
            unmodifiableMap2 = Collections.emptyMap();
        } else {
            unmodifiableMap2 = Collections.unmodifiableMap(this.f25701g);
        }
        this.f25701g = unmodifiableMap2;
        this.f25699e = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f25700f == null) {
            this.f25700f = new e7(this, null);
        }
        return this.f25700f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x6)) {
            return super.equals(obj);
        }
        x6 x6Var = (x6) obj;
        int size = size();
        if (size != x6Var.size()) {
            return false;
        }
        int j10 = j();
        if (j10 != x6Var.j()) {
            return entrySet().equals(x6Var.entrySet());
        }
        for (int i10 = 0; i10 < j10; i10++) {
            if (!h(i10).equals(x6Var.h(i10))) {
                return false;
            }
        }
        if (j10 != size) {
            return this.f25698d.equals(x6Var.f25698d);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a10 = a(comparable);
        if (a10 >= 0) {
            return (V) this.f25697c.get(a10).getValue();
        }
        return this.f25698d.get(comparable);
    }

    public final Map.Entry<K, V> h(int i10) {
        return this.f25697c.get(i10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int j10 = j();
        int i10 = 0;
        for (int i11 = 0; i11 < j10; i11++) {
            i10 += this.f25697c.get(i11).hashCode();
        }
        return this.f25698d.size() > 0 ? i10 + this.f25698d.hashCode() : i10;
    }

    public final boolean i() {
        return this.f25699e;
    }

    public final int j() {
        return this.f25697c.size();
    }

    public final V k(int i10) {
        p();
        V v2 = (V) this.f25697c.remove(i10).getValue();
        if (!this.f25698d.isEmpty()) {
            Iterator<Map.Entry<K, V>> iterator2 = q().entrySet().iterator2();
            this.f25697c.add(new c7(this, iterator2.next()));
            iterator2.remove();
        }
        return v2;
    }

    public final Iterable<Map.Entry<K, V>> m() {
        if (this.f25698d.isEmpty()) {
            return b7.a();
        }
        return this.f25698d.entrySet();
    }

    public final Set<Map.Entry<K, V>> o() {
        if (this.f25702h == null) {
            this.f25702h = new y6(this, null);
        }
        return this.f25702h;
    }

    public final void p() {
        if (this.f25699e) {
            throw new UnsupportedOperationException();
        }
    }

    public final SortedMap<K, V> q() {
        p();
        if (this.f25698d.isEmpty() && !(this.f25698d instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f25698d = treeMap;
            this.f25701g = treeMap.descendingMap();
        }
        return (SortedMap) this.f25698d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        p();
        Comparable comparable = (Comparable) obj;
        int a10 = a(comparable);
        if (a10 >= 0) {
            return (V) k(a10);
        }
        if (this.f25698d.isEmpty()) {
            return null;
        }
        return this.f25698d.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f25697c.size() + this.f25698d.size();
    }

    public /* synthetic */ x6(int i10, w6 w6Var) {
        this(i10);
    }
}
