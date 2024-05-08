package com.google.common.collect;

import android.view.View;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    public static final double HASH_FLOODING_FPP = 0.001d;
    private static final int MAX_HASH_BUCKET_LENGTH = 9;
    private static final Object NOT_FOUND = new Object();
    public transient int[] entries;
    private transient Set<Map.Entry<K, V>> entrySetView;
    private transient Set<K> keySetView;
    public transient Object[] keys;
    private transient int metadata;
    private transient int size;
    private transient Object table;
    public transient Object[] values;
    private transient Collection<V> valuesView;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends CompactHashMap<K, V>.e<K> {
        public a() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        public K b(int i10) {
            return (K) CompactHashMap.this.key(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends CompactHashMap<K, V>.e<Map.Entry<K, V>> {
        public b() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> b(int i10) {
            return new g(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c extends CompactHashMap<K, V>.e<V> {
        public c() {
            super(CompactHashMap.this, null);
        }

        @Override // com.google.common.collect.CompactHashMap.e
        public V b(int i10) {
            return (V) CompactHashMap.this.value(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class d extends AbstractSet<Map.Entry<K, V>> {
        public d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int indexOf = CompactHashMap.this.indexOf(entry.getKey());
            return indexOf != -1 && com.google.common.base.l.a(CompactHashMap.this.value(indexOf), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            return CompactHashMap.this.entrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (CompactHashMap.this.needsAllocArrays()) {
                return false;
            }
            int hashTableMask = CompactHashMap.this.hashTableMask();
            int f10 = o.f(entry.getKey(), entry.getValue(), hashTableMask, CompactHashMap.this.requireTable(), CompactHashMap.this.requireEntries(), CompactHashMap.this.requireKeys(), CompactHashMap.this.requireValues());
            if (f10 == -1) {
                return false;
            }
            CompactHashMap.this.moveLastEntry(f10, hashTableMask);
            CompactHashMap.access$1210(CompactHashMap.this);
            CompactHashMap.this.incrementModCount();
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class f extends AbstractSet<K> {
        public f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            return CompactHashMap.this.keySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return delegateOrNull.h().remove(obj);
            }
            return CompactHashMap.this.removeHelper(obj) != CompactHashMap.NOT_FOUND;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public final class g extends com.google.common.collect.b<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final K f26214b;

        /* renamed from: c, reason: collision with root package name */
        public int f26215c;

        public g(int i10) {
            this.f26214b = (K) CompactHashMap.this.key(i10);
            this.f26215c = i10;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return this.f26214b;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getValue() {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return (V) l0.a(delegateOrNull.get(this.f26214b));
            }
            j();
            int i10 = this.f26215c;
            return i10 == -1 ? (V) l0.b() : (V) CompactHashMap.this.value(i10);
        }

        public final void j() {
            int i10 = this.f26215c;
            if (i10 == -1 || i10 >= CompactHashMap.this.size() || !com.google.common.base.l.a(this.f26214b, CompactHashMap.this.key(this.f26215c))) {
                this.f26215c = CompactHashMap.this.indexOf(this.f26214b);
            }
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V setValue(V v2) {
            Map<K, V> delegateOrNull = CompactHashMap.this.delegateOrNull();
            if (delegateOrNull != null) {
                return (V) l0.a(delegateOrNull.put(this.f26214b, v2));
            }
            j();
            int i10 = this.f26215c;
            if (i10 == -1) {
                CompactHashMap.this.put(this.f26214b, v2);
                return (V) l0.b();
            }
            V v10 = (V) CompactHashMap.this.value(i10);
            CompactHashMap.this.setValue(this.f26215c, v2);
            return v10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class h extends AbstractCollection<V> {
        public h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            CompactHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<V> iterator2() {
            return CompactHashMap.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return CompactHashMap.this.size();
        }
    }

    public CompactHashMap() {
        init(3);
    }

    public static /* synthetic */ int access$1210(CompactHashMap compactHashMap) {
        int i10 = compactHashMap.size;
        compactHashMap.size = i10 - 1;
        return i10;
    }

    public static <K, V> CompactHashMap<K, V> create() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> createWithExpectedSize(int i10) {
        return new CompactHashMap<>(i10);
    }

    private int entry(int i10) {
        return requireEntries()[i10];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hashTableMask() {
        return (1 << (this.metadata & 31)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int indexOf(Object obj) {
        if (needsAllocArrays()) {
            return -1;
        }
        int d10 = f0.d(obj);
        int hashTableMask = hashTableMask();
        int h10 = o.h(requireTable(), d10 & hashTableMask);
        if (h10 == 0) {
            return -1;
        }
        int b4 = o.b(d10, hashTableMask);
        do {
            int i10 = h10 - 1;
            int entry = entry(i10);
            if (o.b(entry, hashTableMask) == b4 && com.google.common.base.l.a(obj, key(i10))) {
                return i10;
            }
            h10 = o.c(entry, hashTableMask);
        } while (h10 != 0);
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public K key(int i10) {
        return (K) requireKeys()[i10];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            init(readInt);
            for (int i10 = 0; i10 < readInt; i10++) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder(25);
        sb2.append("Invalid size: ");
        sb2.append(readInt);
        throw new InvalidObjectException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object removeHelper(Object obj) {
        if (needsAllocArrays()) {
            return NOT_FOUND;
        }
        int hashTableMask = hashTableMask();
        int f10 = o.f(obj, null, hashTableMask, requireTable(), requireEntries(), requireKeys(), null);
        if (f10 == -1) {
            return NOT_FOUND;
        }
        V value = value(f10);
        moveLastEntry(f10, hashTableMask);
        this.size--;
        incrementModCount();
        return value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] requireEntries() {
        int[] iArr = this.entries;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] requireKeys() {
        Object[] objArr = this.keys;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object requireTable() {
        Object obj = this.table;
        Objects.requireNonNull(obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] requireValues() {
        Object[] objArr = this.values;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private void resizeMeMaybe(int i10) {
        int min;
        int length = requireEntries().length;
        if (i10 <= length || (min = Math.min(View.LAST_APP_AUTOFILL_ID, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        resizeEntries(min);
    }

    private int resizeTable(int i10, int i11, int i12, int i13) {
        Object a10 = o.a(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            o.i(a10, i12 & i14, i13 + 1);
        }
        Object requireTable = requireTable();
        int[] requireEntries = requireEntries();
        for (int i15 = 0; i15 <= i10; i15++) {
            int h10 = o.h(requireTable, i15);
            while (h10 != 0) {
                int i16 = h10 - 1;
                int i17 = requireEntries[i16];
                int b4 = o.b(i17, i10) | i15;
                int i18 = b4 & i14;
                int h11 = o.h(a10, i18);
                o.i(a10, i18, h10);
                requireEntries[i16] = o.d(b4, h11, i14);
                h10 = o.c(i17, i10);
            }
        }
        this.table = a10;
        setHashTableMask(i14);
        return i14;
    }

    private void setEntry(int i10, int i11) {
        requireEntries()[i10] = i11;
    }

    private void setHashTableMask(int i10) {
        this.metadata = o.d(this.metadata, 32 - Integer.numberOfLeadingZeros(i10), 31);
    }

    private void setKey(int i10, K k10) {
        requireKeys()[i10] = k10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(int i10, V v2) {
        requireValues()[i10] = v2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V value(int i10) {
        return (V) requireValues()[i10];
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<Map.Entry<K, V>> entrySetIterator = entrySetIterator();
        while (entrySetIterator.hasNext()) {
            Map.Entry<K, V> next = entrySetIterator.next();
            objectOutputStream.writeObject(next.getKey());
            objectOutputStream.writeObject(next.getValue());
        }
    }

    public void accessEntry(int i10) {
    }

    public int adjustAfterRemove(int i10, int i11) {
        return i10 - 1;
    }

    public int allocArrays() {
        com.google.common.base.o.y(needsAllocArrays(), "Arrays already allocated");
        int i10 = this.metadata;
        int j10 = o.j(i10);
        this.table = o.a(j10);
        setHashTableMask(j10 - 1);
        this.entries = new int[i10];
        this.keys = new Object[i10];
        this.values = new Object[i10];
        return i10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        incrementModCount();
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            this.metadata = Ints.e(size(), 3, View.LAST_APP_AUTOFILL_ID);
            delegateOrNull.clear();
            this.table = null;
            this.size = 0;
            return;
        }
        Arrays.fill(requireKeys(), 0, this.size, (Object) null);
        Arrays.fill(requireValues(), 0, this.size, (Object) null);
        o.g(requireTable());
        Arrays.fill(requireEntries(), 0, this.size, 0);
        this.size = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.containsKey(obj);
        }
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.containsValue(obj);
        }
        for (int i10 = 0; i10 < this.size; i10++) {
            if (com.google.common.base.l.a(obj, value(i10))) {
                return true;
            }
        }
        return false;
    }

    public Map<K, V> convertToHashFloodingResistantImplementation() {
        Map<K, V> createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(hashTableMask() + 1);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            createHashFloodingResistantDelegate.put(key(firstEntryIndex), value(firstEntryIndex));
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
        this.table = createHashFloodingResistantDelegate;
        this.entries = null;
        this.keys = null;
        this.values = null;
        incrementModCount();
        return createHashFloodingResistantDelegate;
    }

    public Set<Map.Entry<K, V>> createEntrySet() {
        return new d();
    }

    public Map<K, V> createHashFloodingResistantDelegate(int i10) {
        return new LinkedHashMap(i10, 1.0f);
    }

    public Set<K> createKeySet() {
        return new f();
    }

    public Collection<V> createValues() {
        return new h();
    }

    public Map<K, V> delegateOrNull() {
        Object obj = this.table;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySetView;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
        this.entrySetView = createEntrySet;
        return createEntrySet;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.entrySet().iterator2();
        }
        return new b();
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.get(obj);
        }
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        accessEntry(indexOf);
        return value(indexOf);
    }

    public int getSuccessor(int i10) {
        int i11 = i10 + 1;
        if (i11 < this.size) {
            return i11;
        }
        return -1;
    }

    public void incrementModCount() {
        this.metadata += 32;
    }

    public void init(int i10) {
        com.google.common.base.o.e(i10 >= 0, "Expected size must be >= 0");
        this.metadata = Ints.e(i10, 1, View.LAST_APP_AUTOFILL_ID);
    }

    public void insertEntry(int i10, K k10, V v2, int i11, int i12) {
        setEntry(i10, o.d(i11, 0, i12));
        setKey(i10, k10);
        setValue(i10, v2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        Set<K> set = this.keySetView;
        if (set != null) {
            return set;
        }
        Set<K> createKeySet = createKeySet();
        this.keySetView = createKeySet;
        return createKeySet;
    }

    public Iterator<K> keySetIterator() {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.h().iterator2();
        }
        return new a();
    }

    public void moveLastEntry(int i10, int i11) {
        Object requireTable = requireTable();
        int[] requireEntries = requireEntries();
        Object[] requireKeys = requireKeys();
        Object[] requireValues = requireValues();
        int size = size() - 1;
        if (i10 < size) {
            Object obj = requireKeys[size];
            requireKeys[i10] = obj;
            requireValues[i10] = requireValues[size];
            requireKeys[size] = null;
            requireValues[size] = null;
            requireEntries[i10] = requireEntries[size];
            requireEntries[size] = 0;
            int d10 = f0.d(obj) & i11;
            int h10 = o.h(requireTable, d10);
            int i12 = size + 1;
            if (h10 == i12) {
                o.i(requireTable, d10, i10 + 1);
                return;
            }
            while (true) {
                int i13 = h10 - 1;
                int i14 = requireEntries[i13];
                int c4 = o.c(i14, i11);
                if (c4 == i12) {
                    requireEntries[i13] = o.d(i14, i10 + 1, i11);
                    return;
                }
                h10 = c4;
            }
        } else {
            requireKeys[i10] = null;
            requireValues[i10] = null;
            requireEntries[i10] = 0;
        }
    }

    public boolean needsAllocArrays() {
        return this.table == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v2) {
        int resizeTable;
        int i10;
        if (needsAllocArrays()) {
            allocArrays();
        }
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.put(k10, v2);
        }
        int[] requireEntries = requireEntries();
        Object[] requireKeys = requireKeys();
        Object[] requireValues = requireValues();
        int i11 = this.size;
        int i12 = i11 + 1;
        int d10 = f0.d(k10);
        int hashTableMask = hashTableMask();
        int i13 = d10 & hashTableMask;
        int h10 = o.h(requireTable(), i13);
        if (h10 != 0) {
            int b4 = o.b(d10, hashTableMask);
            int i14 = 0;
            while (true) {
                int i15 = h10 - 1;
                int i16 = requireEntries[i15];
                if (o.b(i16, hashTableMask) == b4 && com.google.common.base.l.a(k10, requireKeys[i15])) {
                    V v10 = (V) requireValues[i15];
                    requireValues[i15] = v2;
                    accessEntry(i15);
                    return v10;
                }
                int c4 = o.c(i16, hashTableMask);
                i14++;
                if (c4 != 0) {
                    h10 = c4;
                } else {
                    if (i14 >= 9) {
                        return convertToHashFloodingResistantImplementation().put(k10, v2);
                    }
                    if (i12 > hashTableMask) {
                        resizeTable = resizeTable(hashTableMask, o.e(hashTableMask), d10, i11);
                    } else {
                        requireEntries[i15] = o.d(i16, i12, hashTableMask);
                    }
                }
            }
        } else if (i12 > hashTableMask) {
            resizeTable = resizeTable(hashTableMask, o.e(hashTableMask), d10, i11);
            i10 = resizeTable;
        } else {
            o.i(requireTable(), i13, i12);
            i10 = hashTableMask;
        }
        resizeMeMaybe(i12);
        insertEntry(i11, k10, v2, d10, i10);
        this.size = i12;
        incrementModCount();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.remove(obj);
        }
        V v2 = (V) removeHelper(obj);
        if (v2 == NOT_FOUND) {
            return null;
        }
        return v2;
    }

    public void resizeEntries(int i10) {
        this.entries = Arrays.copyOf(requireEntries(), i10);
        this.keys = Arrays.copyOf(requireKeys(), i10);
        this.values = Arrays.copyOf(requireValues(), i10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map<K, V> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.size() : this.size;
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            Map<K, V> createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(size());
            createHashFloodingResistantDelegate.putAll(delegateOrNull);
            this.table = createHashFloodingResistantDelegate;
            return;
        }
        int i10 = this.size;
        if (i10 < requireEntries().length) {
            resizeEntries(i10);
        }
        int j10 = o.j(i10);
        int hashTableMask = hashTableMask();
        if (j10 < hashTableMask) {
            resizeTable(hashTableMask, j10, 0, 0);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Collection<V> createValues = createValues();
        this.valuesView = createValues;
        return createValues;
    }

    public Iterator<V> valuesIterator() {
        Map<K, V> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.values().iterator2();
        }
        return new c();
    }

    public CompactHashMap(int i10) {
        init(i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public abstract class e<T> implements Iterator<T> {

        /* renamed from: b, reason: collision with root package name */
        public int f26209b;

        /* renamed from: c, reason: collision with root package name */
        public int f26210c;

        /* renamed from: d, reason: collision with root package name */
        public int f26211d;

        public e() {
            this.f26209b = CompactHashMap.this.metadata;
            this.f26210c = CompactHashMap.this.firstEntryIndex();
            this.f26211d = -1;
        }

        public final void a() {
            if (CompactHashMap.this.metadata != this.f26209b) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract T b(int i10);

        public void c() {
            this.f26209b += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f26210c >= 0;
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (hasNext()) {
                int i10 = this.f26210c;
                this.f26211d = i10;
                T b4 = b(i10);
                this.f26210c = CompactHashMap.this.getSuccessor(this.f26210c);
                return b4;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            m.e(this.f26211d >= 0);
            c();
            CompactHashMap compactHashMap = CompactHashMap.this;
            compactHashMap.remove(compactHashMap.key(this.f26211d));
            this.f26210c = CompactHashMap.this.adjustAfterRemove(this.f26210c, this.f26211d);
            this.f26211d = -1;
        }

        public /* synthetic */ e(CompactHashMap compactHashMap, a aVar) {
            this();
        }
    }
}
