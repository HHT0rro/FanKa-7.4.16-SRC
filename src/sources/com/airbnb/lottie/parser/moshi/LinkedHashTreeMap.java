package com.airbnb.lottie.parser.moshi;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new a();
    public Comparator<? super K> comparator;
    private LinkedHashTreeMap<K, V>.d entrySet;
    public final g<K, V> header;
    private LinkedHashTreeMap<K, V>.e keySet;
    public int modCount;
    public int size;
    public g<K, V>[] table;
    public int threshold;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class b<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public g<K, V> f2082a;

        /* renamed from: b, reason: collision with root package name */
        public int f2083b;

        /* renamed from: c, reason: collision with root package name */
        public int f2084c;

        /* renamed from: d, reason: collision with root package name */
        public int f2085d;

        public void a(g<K, V> gVar) {
            gVar.f2097d = null;
            gVar.f2095b = null;
            gVar.f2096c = null;
            gVar.f2103j = 1;
            int i10 = this.f2083b;
            if (i10 > 0) {
                int i11 = this.f2085d;
                if ((i11 & 1) == 0) {
                    this.f2085d = i11 + 1;
                    this.f2083b = i10 - 1;
                    this.f2084c++;
                }
            }
            gVar.f2095b = this.f2082a;
            this.f2082a = gVar;
            int i12 = this.f2085d + 1;
            this.f2085d = i12;
            int i13 = this.f2083b;
            if (i13 > 0 && (i12 & 1) == 0) {
                this.f2085d = i12 + 1;
                this.f2083b = i13 - 1;
                this.f2084c++;
            }
            int i14 = 4;
            while (true) {
                int i15 = i14 - 1;
                if ((this.f2085d & i15) != i15) {
                    return;
                }
                int i16 = this.f2084c;
                if (i16 == 0) {
                    g<K, V> gVar2 = this.f2082a;
                    g<K, V> gVar3 = gVar2.f2095b;
                    g<K, V> gVar4 = gVar3.f2095b;
                    gVar3.f2095b = gVar4.f2095b;
                    this.f2082a = gVar3;
                    gVar3.f2096c = gVar4;
                    gVar3.f2097d = gVar2;
                    gVar3.f2103j = gVar2.f2103j + 1;
                    gVar4.f2095b = gVar3;
                    gVar2.f2095b = gVar3;
                } else if (i16 == 1) {
                    g<K, V> gVar5 = this.f2082a;
                    g<K, V> gVar6 = gVar5.f2095b;
                    this.f2082a = gVar6;
                    gVar6.f2097d = gVar5;
                    gVar6.f2103j = gVar5.f2103j + 1;
                    gVar5.f2095b = gVar6;
                    this.f2084c = 0;
                } else if (i16 == 2) {
                    this.f2084c = 0;
                }
                i14 *= 2;
            }
        }

        public void b(int i10) {
            this.f2083b = ((Integer.highestOneBit(i10) * 2) - 1) - i10;
            this.f2085d = 0;
            this.f2084c = 0;
            this.f2082a = null;
        }

        public g<K, V> c() {
            g<K, V> gVar = this.f2082a;
            if (gVar.f2095b == null) {
                return gVar;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class c<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public g<K, V> f2086a;

        public g<K, V> a() {
            g<K, V> gVar = this.f2086a;
            if (gVar == null) {
                return null;
            }
            g<K, V> gVar2 = gVar.f2095b;
            gVar.f2095b = null;
            g<K, V> gVar3 = gVar.f2097d;
            while (true) {
                g<K, V> gVar4 = gVar2;
                gVar2 = gVar3;
                if (gVar2 != null) {
                    gVar2.f2095b = gVar4;
                    gVar3 = gVar2.f2096c;
                } else {
                    this.f2086a = gVar4;
                    return gVar;
                }
            }
        }

        public void b(g<K, V> gVar) {
            g<K, V> gVar2 = null;
            while (gVar != null) {
                gVar.f2095b = gVar2;
                gVar2 = gVar;
                gVar = gVar.f2096c;
            }
            this.f2086a = gVar2;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class d extends AbstractSet<Map.Entry<K, V>> {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public class a extends LinkedHashTreeMap<K, V>.f<Map.Entry<K, V>> {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedHashTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            g<K, V> findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = LinkedHashTreeMap.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedHashTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class e extends AbstractSet<K> {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
        public class a extends LinkedHashTreeMap<K, V>.f<K> {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f2100g;
            }
        }

        public e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedHashTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedHashTreeMap.this.size;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public abstract class f<T> implements Iterator<T> {

        /* renamed from: b, reason: collision with root package name */
        public g<K, V> f2091b;

        /* renamed from: c, reason: collision with root package name */
        public g<K, V> f2092c = null;

        /* renamed from: d, reason: collision with root package name */
        public int f2093d;

        public f() {
            this.f2091b = LinkedHashTreeMap.this.header.f2098e;
            this.f2093d = LinkedHashTreeMap.this.modCount;
        }

        public final g<K, V> a() {
            g<K, V> gVar = this.f2091b;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            if (gVar != linkedHashTreeMap.header) {
                if (linkedHashTreeMap.modCount == this.f2093d) {
                    this.f2091b = gVar.f2098e;
                    this.f2092c = gVar;
                    return gVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f2091b != LinkedHashTreeMap.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            g<K, V> gVar = this.f2092c;
            if (gVar != null) {
                LinkedHashTreeMap.this.removeInternal(gVar, true);
                this.f2092c = null;
                this.f2093d = LinkedHashTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedHashTreeMap() {
        this(null);
    }

    private void doubleCapacity() {
        g<K, V>[] doubleCapacity = doubleCapacity(this.table);
        this.table = doubleCapacity;
        this.threshold = (doubleCapacity.length / 2) + (doubleCapacity.length / 4);
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(g<K, V> gVar, boolean z10) {
        while (gVar != null) {
            g<K, V> gVar2 = gVar.f2096c;
            g<K, V> gVar3 = gVar.f2097d;
            int i10 = gVar2 != null ? gVar2.f2103j : 0;
            int i11 = gVar3 != null ? gVar3.f2103j : 0;
            int i12 = i10 - i11;
            if (i12 == -2) {
                g<K, V> gVar4 = gVar3.f2096c;
                g<K, V> gVar5 = gVar3.f2097d;
                int i13 = (gVar4 != null ? gVar4.f2103j : 0) - (gVar5 != null ? gVar5.f2103j : 0);
                if (i13 != -1 && (i13 != 0 || z10)) {
                    rotateRight(gVar3);
                    rotateLeft(gVar);
                } else {
                    rotateLeft(gVar);
                }
                if (z10) {
                    return;
                }
            } else if (i12 == 2) {
                g<K, V> gVar6 = gVar2.f2096c;
                g<K, V> gVar7 = gVar2.f2097d;
                int i14 = (gVar6 != null ? gVar6.f2103j : 0) - (gVar7 != null ? gVar7.f2103j : 0);
                if (i14 != 1 && (i14 != 0 || z10)) {
                    rotateLeft(gVar2);
                    rotateRight(gVar);
                } else {
                    rotateRight(gVar);
                }
                if (z10) {
                    return;
                }
            } else if (i12 == 0) {
                gVar.f2103j = i10 + 1;
                if (z10) {
                    return;
                }
            } else {
                gVar.f2103j = Math.max(i10, i11) + 1;
                if (!z10) {
                    return;
                }
            }
            gVar = gVar.f2095b;
        }
    }

    private void replaceInParent(g<K, V> gVar, g<K, V> gVar2) {
        g<K, V> gVar3 = gVar.f2095b;
        gVar.f2095b = null;
        if (gVar2 != null) {
            gVar2.f2095b = gVar3;
        }
        if (gVar3 != null) {
            if (gVar3.f2096c == gVar) {
                gVar3.f2096c = gVar2;
                return;
            } else {
                gVar3.f2097d = gVar2;
                return;
            }
        }
        int i10 = gVar.f2101h;
        this.table[i10 & (r0.length - 1)] = gVar2;
    }

    private void rotateLeft(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f2096c;
        g<K, V> gVar3 = gVar.f2097d;
        g<K, V> gVar4 = gVar3.f2096c;
        g<K, V> gVar5 = gVar3.f2097d;
        gVar.f2097d = gVar4;
        if (gVar4 != null) {
            gVar4.f2095b = gVar;
        }
        replaceInParent(gVar, gVar3);
        gVar3.f2096c = gVar;
        gVar.f2095b = gVar3;
        int max = Math.max(gVar2 != null ? gVar2.f2103j : 0, gVar4 != null ? gVar4.f2103j : 0) + 1;
        gVar.f2103j = max;
        gVar3.f2103j = Math.max(max, gVar5 != null ? gVar5.f2103j : 0) + 1;
    }

    private void rotateRight(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f2096c;
        g<K, V> gVar3 = gVar.f2097d;
        g<K, V> gVar4 = gVar2.f2096c;
        g<K, V> gVar5 = gVar2.f2097d;
        gVar.f2096c = gVar5;
        if (gVar5 != null) {
            gVar5.f2095b = gVar;
        }
        replaceInParent(gVar, gVar2);
        gVar2.f2097d = gVar;
        gVar.f2095b = gVar2;
        int max = Math.max(gVar3 != null ? gVar3.f2103j : 0, gVar5 != null ? gVar5.f2103j : 0) + 1;
        gVar.f2103j = max;
        gVar2.f2103j = Math.max(max, gVar4 != null ? gVar4.f2103j : 0) + 1;
    }

    private static int secondaryHash(int i10) {
        int i11 = i10 ^ ((i10 >>> 20) ^ (i10 >>> 12));
        return (i11 >>> 4) ^ ((i11 >>> 7) ^ i11);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.table, (Object) null);
        this.size = 0;
        this.modCount++;
        g<K, V> gVar = this.header;
        g<K, V> gVar2 = gVar.f2098e;
        while (gVar2 != gVar) {
            g<K, V> gVar3 = gVar2.f2098e;
            gVar2.f2099f = null;
            gVar2.f2098e = null;
            gVar2 = gVar3;
        }
        gVar.f2099f = gVar;
        gVar.f2098e = gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashTreeMap<K, V>.d dVar = this.entrySet;
        if (dVar != null) {
            return dVar;
        }
        LinkedHashTreeMap<K, V>.d dVar2 = new d();
        this.entrySet = dVar2;
        return dVar2;
    }

    public g<K, V> find(K k10, boolean z10) {
        g<K, V> gVar;
        int i10;
        g<K, V> gVar2;
        int compare;
        Comparator<? super K> comparator = this.comparator;
        g<K, V>[] gVarArr = this.table;
        int secondaryHash = secondaryHash(k10.hashCode());
        int length = (gVarArr.length - 1) & secondaryHash;
        g<K, V> gVar3 = gVarArr[length];
        if (gVar3 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k10 : null;
            while (true) {
                if (comparable != null) {
                    compare = comparable.compareTo(gVar3.f2100g);
                } else {
                    compare = comparator.compare(k10, gVar3.f2100g);
                }
                if (compare == 0) {
                    return gVar3;
                }
                g<K, V> gVar4 = compare < 0 ? gVar3.f2096c : gVar3.f2097d;
                if (gVar4 == null) {
                    gVar = gVar3;
                    i10 = compare;
                    break;
                }
                gVar3 = gVar4;
            }
        } else {
            gVar = gVar3;
            i10 = 0;
        }
        if (!z10) {
            return null;
        }
        g<K, V> gVar5 = this.header;
        if (gVar == null) {
            if (comparator == NATURAL_ORDER && !(k10 instanceof Comparable)) {
                throw new ClassCastException(k10.getClass().getName() + " is not Comparable");
            }
            gVar2 = new g<>(gVar, k10, secondaryHash, gVar5, gVar5.f2099f);
            gVarArr[length] = gVar2;
        } else {
            gVar2 = new g<>(gVar, k10, secondaryHash, gVar5, gVar5.f2099f);
            if (i10 < 0) {
                gVar.f2096c = gVar2;
            } else {
                gVar.f2097d = gVar2;
            }
            rebalance(gVar, true);
        }
        int i11 = this.size;
        this.size = i11 + 1;
        if (i11 > this.threshold) {
            doubleCapacity();
        }
        this.modCount++;
        return gVar2;
    }

    public g<K, V> findByEntry(Map.Entry<?, ?> entry) {
        g<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.f2102i, entry.getValue())) {
            return findByObject;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g<K, V> findByObject(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        g<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.f2102i;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        LinkedHashTreeMap<K, V>.e eVar = this.keySet;
        if (eVar != null) {
            return eVar;
        }
        LinkedHashTreeMap<K, V>.e eVar2 = new e();
        this.keySet = eVar2;
        return eVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v2) {
        Objects.requireNonNull(k10, "key == null");
        g<K, V> find = find(k10, true);
        V v10 = find.f2102i;
        find.f2102i = v2;
        return v10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        g<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.f2102i;
        }
        return null;
    }

    public void removeInternal(g<K, V> gVar, boolean z10) {
        int i10;
        if (z10) {
            g<K, V> gVar2 = gVar.f2099f;
            gVar2.f2098e = gVar.f2098e;
            gVar.f2098e.f2099f = gVar2;
            gVar.f2099f = null;
            gVar.f2098e = null;
        }
        g<K, V> gVar3 = gVar.f2096c;
        g<K, V> gVar4 = gVar.f2097d;
        g<K, V> gVar5 = gVar.f2095b;
        int i11 = 0;
        if (gVar3 != null && gVar4 != null) {
            g<K, V> b4 = gVar3.f2103j > gVar4.f2103j ? gVar3.b() : gVar4.a();
            removeInternal(b4, false);
            g<K, V> gVar6 = gVar.f2096c;
            if (gVar6 != null) {
                i10 = gVar6.f2103j;
                b4.f2096c = gVar6;
                gVar6.f2095b = b4;
                gVar.f2096c = null;
            } else {
                i10 = 0;
            }
            g<K, V> gVar7 = gVar.f2097d;
            if (gVar7 != null) {
                i11 = gVar7.f2103j;
                b4.f2097d = gVar7;
                gVar7.f2095b = b4;
                gVar.f2097d = null;
            }
            b4.f2103j = Math.max(i10, i11) + 1;
            replaceInParent(gVar, b4);
            return;
        }
        if (gVar3 != null) {
            replaceInParent(gVar, gVar3);
            gVar.f2096c = null;
        } else if (gVar4 != null) {
            replaceInParent(gVar, gVar4);
            gVar.f2097d = null;
        } else {
            replaceInParent(gVar, null);
        }
        rebalance(gVar5, false);
        this.size--;
        this.modCount++;
    }

    public g<K, V> removeInternalByKey(Object obj) {
        g<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
        this.header = new g<>();
        g<K, V>[] gVarArr = new g[16];
        this.table = gVarArr;
        this.threshold = (gVarArr.length / 2) + (gVarArr.length / 4);
    }

    public static <K, V> g<K, V>[] doubleCapacity(g<K, V>[] gVarArr) {
        int length = gVarArr.length;
        g<K, V>[] gVarArr2 = new g[length * 2];
        c cVar = new c();
        b bVar = new b();
        b bVar2 = new b();
        for (int i10 = 0; i10 < length; i10++) {
            g<K, V> gVar = gVarArr[i10];
            if (gVar != null) {
                cVar.b(gVar);
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    g<K, V> a10 = cVar.a();
                    if (a10 == null) {
                        break;
                    }
                    if ((a10.f2101h & length) == 0) {
                        i11++;
                    } else {
                        i12++;
                    }
                }
                bVar.b(i11);
                bVar2.b(i12);
                cVar.b(gVar);
                while (true) {
                    g<K, V> a11 = cVar.a();
                    if (a11 == null) {
                        break;
                    }
                    if ((a11.f2101h & length) == 0) {
                        bVar.a(a11);
                    } else {
                        bVar2.a(a11);
                    }
                }
                gVarArr2[i10] = i11 > 0 ? bVar.c() : null;
                gVarArr2[i10 + length] = i12 > 0 ? bVar2.c() : null;
            }
        }
        return gVarArr2;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class g<K, V> implements Map.Entry<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public g<K, V> f2095b;

        /* renamed from: c, reason: collision with root package name */
        public g<K, V> f2096c;

        /* renamed from: d, reason: collision with root package name */
        public g<K, V> f2097d;

        /* renamed from: e, reason: collision with root package name */
        public g<K, V> f2098e;

        /* renamed from: f, reason: collision with root package name */
        public g<K, V> f2099f;

        /* renamed from: g, reason: collision with root package name */
        public final K f2100g;

        /* renamed from: h, reason: collision with root package name */
        public final int f2101h;

        /* renamed from: i, reason: collision with root package name */
        public V f2102i;

        /* renamed from: j, reason: collision with root package name */
        public int f2103j;

        public g() {
            this.f2100g = null;
            this.f2101h = -1;
            this.f2099f = this;
            this.f2098e = this;
        }

        public g<K, V> a() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f2096c; gVar2 != null; gVar2 = gVar2.f2096c) {
                gVar = gVar2;
            }
            return gVar;
        }

        public g<K, V> b() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f2097d; gVar2 != null; gVar2 = gVar2.f2097d) {
                gVar = gVar2;
            }
            return gVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k10 = this.f2100g;
            if (k10 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k10.equals(entry.getKey())) {
                return false;
            }
            V v2 = this.f2102i;
            if (v2 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v2.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f2100g;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f2102i;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.f2100g;
            int hashCode = k10 == null ? 0 : k10.hashCode();
            V v2 = this.f2102i;
            return hashCode ^ (v2 != null ? v2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v2) {
            V v10 = this.f2102i;
            this.f2102i = v2;
            return v10;
        }

        public String toString() {
            return ((Object) this.f2100g) + "=" + ((Object) this.f2102i);
        }

        public g(g<K, V> gVar, K k10, int i10, g<K, V> gVar2, g<K, V> gVar3) {
            this.f2095b = gVar;
            this.f2100g = k10;
            this.f2101h = i10;
            this.f2103j = 1;
            this.f2098e = gVar2;
            this.f2099f = gVar3;
            gVar3.f2098e = this;
            gVar2.f2099f = this;
        }
    }
}
