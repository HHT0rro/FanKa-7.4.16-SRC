package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements k<K, V>, Serializable {
    private static final int ABSENT = -1;
    private static final int ENDPOINT = -2;
    private transient Set<Map.Entry<K, V>> entrySet;
    private transient int firstInInsertionOrder;
    private transient int[] hashTableKToV;
    private transient int[] hashTableVToK;
    private transient k<V, K> inverse;
    private transient Set<K> keySet;
    public transient K[] keys;
    private transient int lastInInsertionOrder;
    public transient int modCount;
    private transient int[] nextInBucketKToV;
    private transient int[] nextInBucketVToK;
    private transient int[] nextInInsertionOrder;
    private transient int[] prevInInsertionOrder;
    public transient int size;
    private transient Set<V> valueSet;
    public transient V[] values;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Inverse<K, V> extends AbstractMap<V, K> implements k<V, K>, Serializable {
        private final HashBiMap<K, V> forward;
        private transient Set<Map.Entry<V, K>> inverseEntrySet;

        public Inverse(HashBiMap<K, V> hashBiMap) {
            this.forward = hashBiMap;
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            ((HashBiMap) this.forward).inverse = this;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            this.forward.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.forward.containsValue(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            return this.forward.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.inverseEntrySet;
            if (set != null) {
                return set;
            }
            d dVar = new d(this.forward);
            this.inverseEntrySet = dVar;
            return dVar;
        }

        @Override // com.google.common.collect.k
        public K forcePut(V v2, K k10) {
            return this.forward.putInverse(v2, k10, true);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K get(Object obj) {
            return this.forward.getInverse(obj);
        }

        @Override // com.google.common.collect.k
        public k<K, V> inverse() {
            return this.forward;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: keySet */
        public Set<V> h() {
            return this.forward.values();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K put(V v2, K k10) {
            return this.forward.putInverse(v2, k10, false);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public K remove(Object obj) {
            return this.forward.removeInverse(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.forward.size;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> values() {
            return this.forward.h();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class a extends com.google.common.collect.b<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final K f26241b;

        /* renamed from: c, reason: collision with root package name */
        public int f26242c;

        public a(int i10) {
            this.f26241b = (K) l0.a(HashBiMap.this.keys[i10]);
            this.f26242c = i10;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return this.f26241b;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getValue() {
            j();
            int i10 = this.f26242c;
            return i10 == -1 ? (V) l0.b() : (V) l0.a(HashBiMap.this.values[i10]);
        }

        public void j() {
            int i10 = this.f26242c;
            if (i10 != -1) {
                HashBiMap hashBiMap = HashBiMap.this;
                if (i10 <= hashBiMap.size && com.google.common.base.l.a(hashBiMap.keys[i10], this.f26241b)) {
                    return;
                }
            }
            this.f26242c = HashBiMap.this.findEntryByKey(this.f26241b);
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V setValue(V v2) {
            j();
            int i10 = this.f26242c;
            if (i10 == -1) {
                HashBiMap.this.put(this.f26241b, v2);
                return (V) l0.b();
            }
            V v10 = (V) l0.a(HashBiMap.this.values[i10]);
            if (com.google.common.base.l.a(v10, v2)) {
                return v2;
            }
            HashBiMap.this.replaceValueInEntry(this.f26242c, v2, false);
            return v10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class b<K, V> extends com.google.common.collect.b<V, K> {

        /* renamed from: b, reason: collision with root package name */
        public final HashBiMap<K, V> f26244b;

        /* renamed from: c, reason: collision with root package name */
        public final V f26245c;

        /* renamed from: d, reason: collision with root package name */
        public int f26246d;

        public b(HashBiMap<K, V> hashBiMap, int i10) {
            this.f26244b = hashBiMap;
            this.f26245c = (V) l0.a(hashBiMap.values[i10]);
            this.f26246d = i10;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getKey() {
            return this.f26245c;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getValue() {
            j();
            int i10 = this.f26246d;
            return i10 == -1 ? (K) l0.b() : (K) l0.a(this.f26244b.keys[i10]);
        }

        public final void j() {
            int i10 = this.f26246d;
            if (i10 != -1) {
                HashBiMap<K, V> hashBiMap = this.f26244b;
                if (i10 <= hashBiMap.size && com.google.common.base.l.a(this.f26245c, hashBiMap.values[i10])) {
                    return;
                }
            }
            this.f26246d = this.f26244b.findEntryByValue(this.f26245c);
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K setValue(K k10) {
            j();
            int i10 = this.f26246d;
            if (i10 == -1) {
                this.f26244b.putInverse(this.f26245c, k10, false);
                return (K) l0.b();
            }
            K k11 = (K) l0.a(this.f26244b.keys[i10]);
            if (com.google.common.base.l.a(k11, k10)) {
                return k10;
            }
            this.f26244b.replaceKeyInEntry(this.f26246d, k10, false);
            return k11;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class c extends g<K, V, Map.Entry<K, V>> {
        public c() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.g
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> b(int i10) {
            return new a(i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int findEntryByKey = HashBiMap.this.findEntryByKey(key);
            return findEntryByKey != -1 && com.google.common.base.l.a(value, HashBiMap.this.values[findEntryByKey]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int d10 = f0.d(key);
            int findEntryByKey = HashBiMap.this.findEntryByKey(key, d10);
            if (findEntryByKey == -1 || !com.google.common.base.l.a(value, HashBiMap.this.values[findEntryByKey])) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, d10);
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class d<K, V> extends g<K, V, Map.Entry<V, K>> {
        public d(HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
        }

        @Override // com.google.common.collect.HashBiMap.g
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry<V, K> b(int i10) {
            return new b(this.f26250b, i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int findEntryByValue = this.f26250b.findEntryByValue(key);
            return findEntryByValue != -1 && com.google.common.base.l.a(this.f26250b.keys[findEntryByValue], value);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int d10 = f0.d(key);
            int findEntryByValue = this.f26250b.findEntryByValue(key, d10);
            if (findEntryByValue == -1 || !com.google.common.base.l.a(this.f26250b.keys[findEntryByValue], value)) {
                return false;
            }
            this.f26250b.removeEntryValueHashKnown(findEntryByValue, d10);
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class e extends g<K, V, K> {
        public e() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.g
        public K b(int i10) {
            return (K) l0.a(HashBiMap.this.keys[i10]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int d10 = f0.d(obj);
            int findEntryByKey = HashBiMap.this.findEntryByKey(obj, d10);
            if (findEntryByKey == -1) {
                return false;
            }
            HashBiMap.this.removeEntryKeyHashKnown(findEntryByKey, d10);
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class f extends g<K, V, V> {
        public f() {
            super(HashBiMap.this);
        }

        @Override // com.google.common.collect.HashBiMap.g
        public V b(int i10) {
            return (V) l0.a(HashBiMap.this.values[i10]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int d10 = f0.d(obj);
            int findEntryByValue = HashBiMap.this.findEntryByValue(obj, d10);
            if (findEntryByValue == -1) {
                return false;
            }
            HashBiMap.this.removeEntryValueHashKnown(findEntryByValue, d10);
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class g<K, V, T> extends AbstractSet<T> {

        /* renamed from: b, reason: collision with root package name */
        public final HashBiMap<K, V> f26250b;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a implements Iterator<T> {

            /* renamed from: b, reason: collision with root package name */
            public int f26251b;

            /* renamed from: c, reason: collision with root package name */
            public int f26252c = -1;

            /* renamed from: d, reason: collision with root package name */
            public int f26253d;

            /* renamed from: e, reason: collision with root package name */
            public int f26254e;

            public a() {
                this.f26251b = ((HashBiMap) g.this.f26250b).firstInInsertionOrder;
                HashBiMap<K, V> hashBiMap = g.this.f26250b;
                this.f26253d = hashBiMap.modCount;
                this.f26254e = hashBiMap.size;
            }

            public final void a() {
                if (g.this.f26250b.modCount != this.f26253d) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f26251b != -2 && this.f26254e > 0;
            }

            @Override // java.util.Iterator
            public T next() {
                if (hasNext()) {
                    T t2 = (T) g.this.b(this.f26251b);
                    this.f26252c = this.f26251b;
                    this.f26251b = ((HashBiMap) g.this.f26250b).nextInInsertionOrder[this.f26251b];
                    this.f26254e--;
                    return t2;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                m.e(this.f26252c != -1);
                g.this.f26250b.removeEntry(this.f26252c);
                int i10 = this.f26251b;
                HashBiMap<K, V> hashBiMap = g.this.f26250b;
                if (i10 == hashBiMap.size) {
                    this.f26251b = this.f26252c;
                }
                this.f26252c = -1;
                this.f26253d = hashBiMap.modCount;
            }
        }

        public g(HashBiMap<K, V> hashBiMap) {
            this.f26250b = hashBiMap;
        }

        public abstract T b(int i10);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f26250b.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<T> iterator2() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f26250b.size;
        }
    }

    private HashBiMap(int i10) {
        init(i10);
    }

    private int bucket(int i10) {
        return i10 & (this.hashTableKToV.length - 1);
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    private static int[] createFilledWithAbsent(int i10) {
        int[] iArr = new int[i10];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void deleteFromTableKToV(int i10, int i11) {
        com.google.common.base.o.d(i10 != -1);
        int bucket = bucket(i11);
        int[] iArr = this.hashTableKToV;
        if (iArr[bucket] == i10) {
            int[] iArr2 = this.nextInBucketKToV;
            iArr[bucket] = iArr2[i10];
            iArr2[i10] = -1;
            return;
        }
        int i12 = iArr[bucket];
        int i13 = this.nextInBucketKToV[i12];
        while (true) {
            int i14 = i13;
            int i15 = i12;
            i12 = i14;
            if (i12 == -1) {
                String valueOf = String.valueOf(this.keys[i10]);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 32);
                sb2.append("Expected to find entry with key ");
                sb2.append(valueOf);
                throw new AssertionError((Object) sb2.toString());
            }
            if (i12 == i10) {
                int[] iArr3 = this.nextInBucketKToV;
                iArr3[i15] = iArr3[i10];
                iArr3[i10] = -1;
                return;
            }
            i13 = this.nextInBucketKToV[i12];
        }
    }

    private void deleteFromTableVToK(int i10, int i11) {
        com.google.common.base.o.d(i10 != -1);
        int bucket = bucket(i11);
        int[] iArr = this.hashTableVToK;
        if (iArr[bucket] == i10) {
            int[] iArr2 = this.nextInBucketVToK;
            iArr[bucket] = iArr2[i10];
            iArr2[i10] = -1;
            return;
        }
        int i12 = iArr[bucket];
        int i13 = this.nextInBucketVToK[i12];
        while (true) {
            int i14 = i13;
            int i15 = i12;
            i12 = i14;
            if (i12 == -1) {
                String valueOf = String.valueOf(this.values[i10]);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 34);
                sb2.append("Expected to find entry with value ");
                sb2.append(valueOf);
                throw new AssertionError((Object) sb2.toString());
            }
            if (i12 == i10) {
                int[] iArr3 = this.nextInBucketVToK;
                iArr3[i15] = iArr3[i10];
                iArr3[i10] = -1;
                return;
            }
            i13 = this.nextInBucketVToK[i12];
        }
    }

    private void ensureCapacity(int i10) {
        int[] iArr = this.nextInBucketKToV;
        if (iArr.length < i10) {
            int e2 = ImmutableCollection.b.e(iArr.length, i10);
            this.keys = (K[]) Arrays.copyOf(this.keys, e2);
            this.values = (V[]) Arrays.copyOf(this.values, e2);
            this.nextInBucketKToV = expandAndFillWithAbsent(this.nextInBucketKToV, e2);
            this.nextInBucketVToK = expandAndFillWithAbsent(this.nextInBucketVToK, e2);
            this.prevInInsertionOrder = expandAndFillWithAbsent(this.prevInInsertionOrder, e2);
            this.nextInInsertionOrder = expandAndFillWithAbsent(this.nextInInsertionOrder, e2);
        }
        if (this.hashTableKToV.length < i10) {
            int a10 = f0.a(i10, 1.0d);
            this.hashTableKToV = createFilledWithAbsent(a10);
            this.hashTableVToK = createFilledWithAbsent(a10);
            for (int i11 = 0; i11 < this.size; i11++) {
                int bucket = bucket(f0.d(this.keys[i11]));
                int[] iArr2 = this.nextInBucketKToV;
                int[] iArr3 = this.hashTableKToV;
                iArr2[i11] = iArr3[bucket];
                iArr3[bucket] = i11;
                int bucket2 = bucket(f0.d(this.values[i11]));
                int[] iArr4 = this.nextInBucketVToK;
                int[] iArr5 = this.hashTableVToK;
                iArr4[i11] = iArr5[bucket2];
                iArr5[bucket2] = i11;
            }
        }
    }

    private static int[] expandAndFillWithAbsent(int[] iArr, int i10) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i10);
        Arrays.fill(copyOf, length, i10, -1);
        return copyOf;
    }

    private void insertIntoTableKToV(int i10, int i11) {
        com.google.common.base.o.d(i10 != -1);
        int bucket = bucket(i11);
        int[] iArr = this.nextInBucketKToV;
        int[] iArr2 = this.hashTableKToV;
        iArr[i10] = iArr2[bucket];
        iArr2[bucket] = i10;
    }

    private void insertIntoTableVToK(int i10, int i11) {
        com.google.common.base.o.d(i10 != -1);
        int bucket = bucket(i11);
        int[] iArr = this.nextInBucketVToK;
        int[] iArr2 = this.hashTableVToK;
        iArr[i10] = iArr2[bucket];
        iArr2[bucket] = i10;
    }

    private void moveEntryToIndex(int i10, int i11) {
        int i12;
        int i13;
        if (i10 == i11) {
            return;
        }
        int i14 = this.prevInInsertionOrder[i10];
        int i15 = this.nextInInsertionOrder[i10];
        setSucceeds(i14, i11);
        setSucceeds(i11, i15);
        K[] kArr = this.keys;
        K k10 = kArr[i10];
        V[] vArr = this.values;
        V v2 = vArr[i10];
        kArr[i11] = k10;
        vArr[i11] = v2;
        int bucket = bucket(f0.d(k10));
        int[] iArr = this.hashTableKToV;
        if (iArr[bucket] == i10) {
            iArr[bucket] = i11;
        } else {
            int i16 = iArr[bucket];
            int i17 = this.nextInBucketKToV[i16];
            while (true) {
                int i18 = i17;
                i12 = i16;
                i16 = i18;
                if (i16 == i10) {
                    break;
                } else {
                    i17 = this.nextInBucketKToV[i16];
                }
            }
            this.nextInBucketKToV[i12] = i11;
        }
        int[] iArr2 = this.nextInBucketKToV;
        iArr2[i11] = iArr2[i10];
        iArr2[i10] = -1;
        int bucket2 = bucket(f0.d(v2));
        int[] iArr3 = this.hashTableVToK;
        if (iArr3[bucket2] == i10) {
            iArr3[bucket2] = i11;
        } else {
            int i19 = iArr3[bucket2];
            int i20 = this.nextInBucketVToK[i19];
            while (true) {
                int i21 = i20;
                i13 = i19;
                i19 = i21;
                if (i19 == i10) {
                    break;
                } else {
                    i20 = this.nextInBucketVToK[i19];
                }
            }
            this.nextInBucketVToK[i13] = i11;
        }
        int[] iArr4 = this.nextInBucketVToK;
        iArr4[i11] = iArr4[i10];
        iArr4[i10] = -1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int h10 = v0.h(objectInputStream);
        init(16);
        v0.c(this, objectInputStream, h10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceKeyInEntry(int i10, K k10, boolean z10) {
        com.google.common.base.o.d(i10 != -1);
        int d10 = f0.d(k10);
        int findEntryByKey = findEntryByKey(k10, d10);
        int i11 = this.lastInInsertionOrder;
        int i12 = -2;
        if (findEntryByKey != -1) {
            if (z10) {
                i11 = this.prevInInsertionOrder[findEntryByKey];
                i12 = this.nextInInsertionOrder[findEntryByKey];
                removeEntryKeyHashKnown(findEntryByKey, d10);
                if (i10 == this.size) {
                    i10 = findEntryByKey;
                }
            } else {
                String valueOf = String.valueOf(k10);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 28);
                sb2.append("Key already present in map: ");
                sb2.append(valueOf);
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        if (i11 == i10) {
            i11 = this.prevInInsertionOrder[i10];
        } else if (i11 == this.size) {
            i11 = findEntryByKey;
        }
        if (i12 == i10) {
            findEntryByKey = this.nextInInsertionOrder[i10];
        } else if (i12 != this.size) {
            findEntryByKey = i12;
        }
        setSucceeds(this.prevInInsertionOrder[i10], this.nextInInsertionOrder[i10]);
        deleteFromTableKToV(i10, f0.d(this.keys[i10]));
        this.keys[i10] = k10;
        insertIntoTableKToV(i10, f0.d(k10));
        setSucceeds(i11, i10);
        setSucceeds(i10, findEntryByKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void replaceValueInEntry(int i10, V v2, boolean z10) {
        com.google.common.base.o.d(i10 != -1);
        int d10 = f0.d(v2);
        int findEntryByValue = findEntryByValue(v2, d10);
        if (findEntryByValue != -1) {
            if (z10) {
                removeEntryValueHashKnown(findEntryByValue, d10);
                if (i10 == this.size) {
                    i10 = findEntryByValue;
                }
            } else {
                String valueOf = String.valueOf(v2);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 30);
                sb2.append("Value already present in map: ");
                sb2.append(valueOf);
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        deleteFromTableVToK(i10, f0.d(this.values[i10]));
        this.values[i10] = v2;
        insertIntoTableVToK(i10, d10);
    }

    private void setSucceeds(int i10, int i11) {
        if (i10 == -2) {
            this.firstInInsertionOrder = i11;
        } else {
            this.nextInInsertionOrder[i10] = i11;
        }
        if (i11 == -2) {
            this.lastInInsertionOrder = i10;
        } else {
            this.prevInInsertionOrder[i11] = i10;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        v0.i(this, objectOutputStream);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, (Object) null);
        Arrays.fill(this.hashTableKToV, -1);
        Arrays.fill(this.hashTableVToK, -1);
        Arrays.fill(this.nextInBucketKToV, 0, this.size, -1);
        Arrays.fill(this.nextInBucketVToK, 0, this.size, -1);
        Arrays.fill(this.prevInInsertionOrder, 0, this.size, -1);
        Arrays.fill(this.nextInInsertionOrder, 0, this.size, -1);
        this.size = 0;
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.modCount++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findEntryByKey(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return findEntryByValue(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        c cVar = new c();
        this.entrySet = cVar;
        return cVar;
    }

    public int findEntry(Object obj, int i10, int[] iArr, int[] iArr2, Object[] objArr) {
        int i11 = iArr[bucket(i10)];
        while (i11 != -1) {
            if (com.google.common.base.l.a(objArr[i11], obj)) {
                return i11;
            }
            i11 = iArr2[i11];
        }
        return -1;
    }

    public int findEntryByKey(Object obj) {
        return findEntryByKey(obj, f0.d(obj));
    }

    public int findEntryByValue(Object obj) {
        return findEntryByValue(obj, f0.d(obj));
    }

    @Override // com.google.common.collect.k
    public V forcePut(K k10, V v2) {
        return put(k10, v2, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        int findEntryByKey = findEntryByKey(obj);
        if (findEntryByKey == -1) {
            return null;
        }
        return this.values[findEntryByKey];
    }

    public K getInverse(Object obj) {
        int findEntryByValue = findEntryByValue(obj);
        if (findEntryByValue == -1) {
            return null;
        }
        return this.keys[findEntryByValue];
    }

    public void init(int i10) {
        m.b(i10, "expectedSize");
        int a10 = f0.a(i10, 1.0d);
        this.size = 0;
        this.keys = (K[]) new Object[i10];
        this.values = (V[]) new Object[i10];
        this.hashTableKToV = createFilledWithAbsent(a10);
        this.hashTableVToK = createFilledWithAbsent(a10);
        this.nextInBucketKToV = createFilledWithAbsent(i10);
        this.nextInBucketVToK = createFilledWithAbsent(i10);
        this.firstInInsertionOrder = -2;
        this.lastInInsertionOrder = -2;
        this.prevInInsertionOrder = createFilledWithAbsent(i10);
        this.nextInInsertionOrder = createFilledWithAbsent(i10);
    }

    @Override // com.google.common.collect.k
    public k<V, K> inverse() {
        k<V, K> kVar = this.inverse;
        if (kVar != null) {
            return kVar;
        }
        Inverse inverse = new Inverse(this);
        this.inverse = inverse;
        return inverse;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.keySet = eVar;
        return eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v2) {
        return put(k10, v2, false);
    }

    public K putInverse(V v2, K k10, boolean z10) {
        int d10 = f0.d(v2);
        int findEntryByValue = findEntryByValue(v2, d10);
        if (findEntryByValue != -1) {
            K k11 = this.keys[findEntryByValue];
            if (com.google.common.base.l.a(k11, k10)) {
                return k10;
            }
            replaceKeyInEntry(findEntryByValue, k10, z10);
            return k11;
        }
        int i10 = this.lastInInsertionOrder;
        int d11 = f0.d(k10);
        int findEntryByKey = findEntryByKey(k10, d11);
        if (!z10) {
            com.google.common.base.o.m(findEntryByKey == -1, "Key already present: %s", k10);
        } else if (findEntryByKey != -1) {
            i10 = this.prevInInsertionOrder[findEntryByKey];
            removeEntryKeyHashKnown(findEntryByKey, d11);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i11 = this.size;
        kArr[i11] = k10;
        this.values[i11] = v2;
        insertIntoTableKToV(i11, d11);
        insertIntoTableVToK(this.size, d10);
        int i12 = i10 == -2 ? this.firstInInsertionOrder : this.nextInInsertionOrder[i10];
        setSucceeds(i10, this.size);
        setSucceeds(this.size, i12);
        this.size++;
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        int d10 = f0.d(obj);
        int findEntryByKey = findEntryByKey(obj, d10);
        if (findEntryByKey == -1) {
            return null;
        }
        V v2 = this.values[findEntryByKey];
        removeEntryKeyHashKnown(findEntryByKey, d10);
        return v2;
    }

    public void removeEntry(int i10) {
        removeEntryKeyHashKnown(i10, f0.d(this.keys[i10]));
    }

    public void removeEntryKeyHashKnown(int i10, int i11) {
        removeEntry(i10, i11, f0.d(this.values[i10]));
    }

    public void removeEntryValueHashKnown(int i10, int i11) {
        removeEntry(i10, f0.d(this.keys[i10]), i11);
    }

    public K removeInverse(Object obj) {
        int d10 = f0.d(obj);
        int findEntryByValue = findEntryByValue(obj, d10);
        if (findEntryByValue == -1) {
            return null;
        }
        K k10 = this.keys[findEntryByValue];
        removeEntryValueHashKnown(findEntryByValue, d10);
        return k10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public static <K, V> HashBiMap<K, V> create(int i10) {
        return new HashBiMap<>(i10);
    }

    private void removeEntry(int i10, int i11, int i12) {
        com.google.common.base.o.d(i10 != -1);
        deleteFromTableKToV(i10, i11);
        deleteFromTableVToK(i10, i12);
        setSucceeds(this.prevInInsertionOrder[i10], this.nextInInsertionOrder[i10]);
        moveEntryToIndex(this.size - 1, i10);
        K[] kArr = this.keys;
        int i13 = this.size;
        kArr[i13 - 1] = null;
        this.values[i13 - 1] = null;
        this.size = i13 - 1;
        this.modCount++;
    }

    public int findEntryByKey(Object obj, int i10) {
        return findEntry(obj, i10, this.hashTableKToV, this.nextInBucketKToV, this.keys);
    }

    public int findEntryByValue(Object obj, int i10) {
        return findEntry(obj, i10, this.hashTableVToK, this.nextInBucketVToK, this.values);
    }

    public V put(K k10, V v2, boolean z10) {
        int d10 = f0.d(k10);
        int findEntryByKey = findEntryByKey(k10, d10);
        if (findEntryByKey != -1) {
            V v10 = this.values[findEntryByKey];
            if (com.google.common.base.l.a(v10, v2)) {
                return v2;
            }
            replaceValueInEntry(findEntryByKey, v2, z10);
            return v10;
        }
        int d11 = f0.d(v2);
        int findEntryByValue = findEntryByValue(v2, d11);
        if (!z10) {
            com.google.common.base.o.m(findEntryByValue == -1, "Value already present: %s", v2);
        } else if (findEntryByValue != -1) {
            removeEntryValueHashKnown(findEntryByValue, d11);
        }
        ensureCapacity(this.size + 1);
        K[] kArr = this.keys;
        int i10 = this.size;
        kArr[i10] = k10;
        this.values[i10] = v2;
        insertIntoTableKToV(i10, d10);
        insertIntoTableVToK(this.size, d11);
        setSucceeds(this.lastInInsertionOrder, this.size);
        setSucceeds(this.size, -2);
        this.size++;
        this.modCount++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        f fVar = new f();
        this.valueSet = fVar;
        return fVar;
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }
}
