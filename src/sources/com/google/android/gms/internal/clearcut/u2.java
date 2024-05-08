package com.google.android.gms.internal.clearcut;

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

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class u2<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: b */
    public final int f24054b;

    /* renamed from: c */
    public List<b3> f24055c;

    /* renamed from: d */
    public Map<K, V> f24056d;

    /* renamed from: e */
    public boolean f24057e;

    /* renamed from: f */
    public volatile d3 f24058f;

    /* renamed from: g */
    public Map<K, V> f24059g;

    /* renamed from: h */
    public volatile x2 f24060h;

    public u2(int i10) {
        this.f24054b = i10;
        this.f24055c = Collections.emptyList();
        this.f24056d = Collections.emptyMap();
        this.f24059g = Collections.emptyMap();
    }

    public /* synthetic */ u2(int i10, v2 v2Var) {
        this(i10);
    }

    public static /* synthetic */ Object c(u2 u2Var, int i10) {
        return u2Var.h(i10);
    }

    public static /* synthetic */ void e(u2 u2Var) {
        u2Var.o();
    }

    public static <FieldDescriptorType extends t0<FieldDescriptorType>> u2<FieldDescriptorType, Object> f(int i10) {
        return new v2(i10);
    }

    public static /* synthetic */ List i(u2 u2Var) {
        return u2Var.f24055c;
    }

    public static /* synthetic */ Map j(u2 u2Var) {
        return u2Var.f24056d;
    }

    public final boolean a() {
        return this.f24057e;
    }

    public final int b(K k10) {
        int size = this.f24055c.size() - 1;
        if (size >= 0) {
            int compareTo = k10.compareTo((Comparable) this.f24055c.get(size).getKey());
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
            int compareTo2 = k10.compareTo((Comparable) this.f24055c.get(i11).getKey());
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
        o();
        if (!this.f24055c.isEmpty()) {
            this.f24055c.clear();
        }
        if (this.f24056d.isEmpty()) {
            return;
        }
        this.f24056d.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return b(comparable) >= 0 || this.f24056d.containsKey(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: d */
    public final V put(K k10, V v2) {
        o();
        int b4 = b(k10);
        if (b4 >= 0) {
            return (V) this.f24055c.get(b4).setValue(v2);
        }
        o();
        if (this.f24055c.isEmpty() && !(this.f24055c instanceof ArrayList)) {
            this.f24055c = new ArrayList(this.f24054b);
        }
        int i10 = -(b4 + 1);
        if (i10 >= this.f24054b) {
            return p().put(k10, v2);
        }
        int size = this.f24055c.size();
        int i11 = this.f24054b;
        if (size == i11) {
            b3 remove = this.f24055c.remove(i11 - 1);
            p().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f24055c.add(i10, new b3(this, k10, v2));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f24058f == null) {
            this.f24058f = new d3(this, null);
        }
        return this.f24058f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u2)) {
            return super.equals(obj);
        }
        u2 u2Var = (u2) obj;
        int size = size();
        if (size != u2Var.size()) {
            return false;
        }
        int l10 = l();
        if (l10 != u2Var.l()) {
            return entrySet().equals(u2Var.entrySet());
        }
        for (int i10 = 0; i10 < l10; i10++) {
            if (!g(i10).equals(u2Var.g(i10))) {
                return false;
            }
        }
        if (l10 != size) {
            return this.f24056d.equals(u2Var.f24056d);
        }
        return true;
    }

    public final Map.Entry<K, V> g(int i10) {
        return this.f24055c.get(i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int b4 = b(comparable);
        return b4 >= 0 ? (V) this.f24055c.get(b4).getValue() : this.f24056d.get(comparable);
    }

    public final V h(int i10) {
        o();
        V v2 = (V) this.f24055c.remove(i10).getValue();
        if (!this.f24056d.isEmpty()) {
            Iterator<Map.Entry<K, V>> iterator2 = p().entrySet().iterator2();
            this.f24055c.add(new b3(this, iterator2.next()));
            iterator2.remove();
        }
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int l10 = l();
        int i10 = 0;
        for (int i11 = 0; i11 < l10; i11++) {
            i10 += this.f24055c.get(i11).hashCode();
        }
        return this.f24056d.size() > 0 ? i10 + this.f24056d.hashCode() : i10;
    }

    public final int l() {
        return this.f24055c.size();
    }

    public final Iterable<Map.Entry<K, V>> m() {
        return this.f24056d.isEmpty() ? y2.a() : this.f24056d.entrySet();
    }

    public final Set<Map.Entry<K, V>> n() {
        if (this.f24060h == null) {
            this.f24060h = new x2(this, null);
        }
        return this.f24060h;
    }

    public final void o() {
        if (this.f24057e) {
            throw new UnsupportedOperationException();
        }
    }

    public final SortedMap<K, V> p() {
        o();
        if (this.f24056d.isEmpty() && !(this.f24056d instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f24056d = treeMap;
            this.f24059g = treeMap.descendingMap();
        }
        return (SortedMap) this.f24056d;
    }

    public void q() {
        if (this.f24057e) {
            return;
        }
        this.f24056d = this.f24056d.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f24056d);
        this.f24059g = this.f24059g.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f24059g);
        this.f24057e = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        o();
        Comparable comparable = (Comparable) obj;
        int b4 = b(comparable);
        if (b4 >= 0) {
            return (V) h(b4);
        }
        if (this.f24056d.isEmpty()) {
            return null;
        }
        return this.f24056d.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f24055c.size() + this.f24056d.size();
    }
}
