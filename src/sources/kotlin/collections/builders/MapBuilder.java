package kotlin.collections.builders;

import ce.n;
import com.alipay.sdk.util.i;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.e0;
import kotlin.collections.l;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MapBuilder.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, zd.e {

    @NotNull
    private static final a Companion = new a(null);
    private static final int INITIAL_CAPACITY = 8;
    private static final int INITIAL_MAX_PROBE_DISTANCE = 2;
    private static final int MAGIC = -1640531527;
    private static final int TOMBSTONE = -1;

    @Nullable
    private kotlin.collections.builders.c<K, V> entriesView;

    @NotNull
    private int[] hashArray;
    private int hashShift;
    private boolean isReadOnly;

    @NotNull
    private K[] keysArray;

    @Nullable
    private kotlin.collections.builders.d<K> keysView;
    private int length;
    private int maxProbeDistance;

    @NotNull
    private int[] presenceArray;
    private int size;

    @Nullable
    private V[] valuesArray;

    @Nullable
    private kotlin.collections.builders.e<V> valuesView;

    /* compiled from: MapBuilder.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int c(int i10) {
            return Integer.highestOneBit(n.b(i10, 1) * 3);
        }

        public final int d(int i10) {
            return Integer.numberOfLeadingZeros(i10) + 1;
        }
    }

    /* compiled from: MapBuilder.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class b<K, V> extends d<K, V> implements Iterator<Map.Entry<K, V>>, zd.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull MapBuilder<K, V> map) {
            super(map);
            s.i(map, "map");
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public c<K, V> next() {
            if (a() < ((MapBuilder) c()).length) {
                int a10 = a();
                e(a10 + 1);
                f(a10);
                c<K, V> cVar = new c<>(c(), b());
                d();
                return cVar;
            }
            throw new NoSuchElementException();
        }

        public final void h(@NotNull StringBuilder sb2) {
            s.i(sb2, "sb");
            if (a() < ((MapBuilder) c()).length) {
                int a10 = a();
                e(a10 + 1);
                f(a10);
                Object obj = ((MapBuilder) c()).keysArray[b()];
                if (s.d(obj, c())) {
                    sb2.append("(this Map)");
                } else {
                    sb2.append(obj);
                }
                sb2.append('=');
                Object[] objArr = ((MapBuilder) c()).valuesArray;
                s.f(objArr);
                Object obj2 = objArr[b()];
                if (s.d(obj2, c())) {
                    sb2.append("(this Map)");
                } else {
                    sb2.append(obj2);
                }
                d();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int i() {
            if (a() < ((MapBuilder) c()).length) {
                int a10 = a();
                e(a10 + 1);
                f(a10);
                Object obj = ((MapBuilder) c()).keysArray[b()];
                int hashCode = obj != null ? obj.hashCode() : 0;
                Object[] objArr = ((MapBuilder) c()).valuesArray;
                s.f(objArr);
                Object obj2 = objArr[b()];
                int hashCode2 = hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
                d();
                return hashCode2;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: MapBuilder.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class c<K, V> implements Map.Entry<K, V>, zd.a {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final MapBuilder<K, V> f50915b;

        /* renamed from: c, reason: collision with root package name */
        public final int f50916c;

        public c(@NotNull MapBuilder<K, V> map, int i10) {
            s.i(map, "map");
            this.f50915b = map;
            this.f50916c = i10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (s.d(entry.getKey(), getKey()) && s.d(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((MapBuilder) this.f50915b).keysArray[this.f50916c];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = ((MapBuilder) this.f50915b).valuesArray;
            s.f(objArr);
            return (V) objArr[this.f50916c];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int hashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return hashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v2) {
            this.f50915b.checkIsMutable$kotlin_stdlib();
            Object[] allocateValuesArray = this.f50915b.allocateValuesArray();
            int i10 = this.f50916c;
            V v10 = (V) allocateValuesArray[i10];
            allocateValuesArray[i10] = v2;
            return v10;
        }

        @NotNull
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append((Object) getKey());
            sb2.append('=');
            sb2.append((Object) getValue());
            return sb2.toString();
        }
    }

    /* compiled from: MapBuilder.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class d<K, V> {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final MapBuilder<K, V> f50917b;

        /* renamed from: c, reason: collision with root package name */
        public int f50918c;

        /* renamed from: d, reason: collision with root package name */
        public int f50919d;

        public d(@NotNull MapBuilder<K, V> map) {
            s.i(map, "map");
            this.f50917b = map;
            this.f50919d = -1;
            d();
        }

        public final int a() {
            return this.f50918c;
        }

        public final int b() {
            return this.f50919d;
        }

        @NotNull
        public final MapBuilder<K, V> c() {
            return this.f50917b;
        }

        public final void d() {
            while (this.f50918c < ((MapBuilder) this.f50917b).length) {
                int[] iArr = ((MapBuilder) this.f50917b).presenceArray;
                int i10 = this.f50918c;
                if (iArr[i10] >= 0) {
                    return;
                } else {
                    this.f50918c = i10 + 1;
                }
            }
        }

        public final void e(int i10) {
            this.f50918c = i10;
        }

        public final void f(int i10) {
            this.f50919d = i10;
        }

        public final boolean hasNext() {
            return this.f50918c < ((MapBuilder) this.f50917b).length;
        }

        public final void remove() {
            if (this.f50919d != -1) {
                this.f50917b.checkIsMutable$kotlin_stdlib();
                this.f50917b.removeKeyAt(this.f50919d);
                this.f50919d = -1;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }
    }

    /* compiled from: MapBuilder.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class e<K, V> extends d<K, V> implements Iterator<K>, zd.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull MapBuilder<K, V> map) {
            super(map);
            s.i(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (a() < ((MapBuilder) c()).length) {
                int a10 = a();
                e(a10 + 1);
                f(a10);
                K k10 = (K) ((MapBuilder) c()).keysArray[b()];
                d();
                return k10;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: MapBuilder.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class f<K, V> extends d<K, V> implements Iterator<V>, zd.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@NotNull MapBuilder<K, V> map) {
            super(map);
            s.i(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (a() < ((MapBuilder) c()).length) {
                int a10 = a();
                e(a10 + 1);
                f(a10);
                Object[] objArr = ((MapBuilder) c()).valuesArray;
                s.f(objArr);
                V v2 = (V) objArr[b()];
                d();
                return v2;
            }
            throw new NoSuchElementException();
        }
    }

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i10, int i11) {
        this.keysArray = kArr;
        this.valuesArray = vArr;
        this.presenceArray = iArr;
        this.hashArray = iArr2;
        this.maxProbeDistance = i10;
        this.length = i11;
        this.hashShift = Companion.d(getHashSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] allocateValuesArray() {
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) kotlin.collections.builders.b.d(getCapacity$kotlin_stdlib());
        this.valuesArray = vArr2;
        return vArr2;
    }

    private final void compact() {
        int i10;
        V[] vArr = this.valuesArray;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i10 = this.length;
            if (i11 >= i10) {
                break;
            }
            if (this.presenceArray[i11] >= 0) {
                K[] kArr = this.keysArray;
                kArr[i12] = kArr[i11];
                if (vArr != null) {
                    vArr[i12] = vArr[i11];
                }
                i12++;
            }
            i11++;
        }
        kotlin.collections.builders.b.g(this.keysArray, i12, i10);
        if (vArr != null) {
            kotlin.collections.builders.b.g(vArr, i12, this.length);
        }
        this.length = i12;
    }

    private final boolean contentEquals(Map<?, ?> map) {
        return size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet());
    }

    private final void ensureCapacity(int i10) {
        if (i10 >= 0) {
            if (i10 > getCapacity$kotlin_stdlib()) {
                int capacity$kotlin_stdlib = (getCapacity$kotlin_stdlib() * 3) / 2;
                if (i10 <= capacity$kotlin_stdlib) {
                    i10 = capacity$kotlin_stdlib;
                }
                this.keysArray = (K[]) kotlin.collections.builders.b.e(this.keysArray, i10);
                V[] vArr = this.valuesArray;
                this.valuesArray = vArr != null ? (V[]) kotlin.collections.builders.b.e(vArr, i10) : null;
                int[] copyOf = Arrays.copyOf(this.presenceArray, i10);
                s.h(copyOf, "copyOf(this, newSize)");
                this.presenceArray = copyOf;
                int c4 = Companion.c(i10);
                if (c4 > getHashSize()) {
                    rehash(c4);
                    return;
                }
                return;
            }
            return;
        }
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int i10) {
        if (shouldCompact(i10)) {
            rehash(getHashSize());
        } else {
            ensureCapacity(this.length + i10);
        }
    }

    private final int findKey(K k10) {
        int hash = hash(k10);
        int i10 = this.maxProbeDistance;
        while (true) {
            int i11 = this.hashArray[hash];
            if (i11 == 0) {
                return -1;
            }
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (s.d(this.keysArray[i12], k10)) {
                    return i12;
                }
            }
            i10--;
            if (i10 < 0) {
                return -1;
            }
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
        }
    }

    private final int findValue(V v2) {
        int i10 = this.length;
        while (true) {
            i10--;
            if (i10 < 0) {
                return -1;
            }
            if (this.presenceArray[i10] >= 0) {
                V[] vArr = this.valuesArray;
                s.f(vArr);
                if (s.d(vArr[i10], v2)) {
                    return i10;
                }
            }
        }
    }

    private final int getHashSize() {
        return this.hashArray.length;
    }

    private final int hash(K k10) {
        return ((k10 != null ? k10.hashCode() : 0) * MAGIC) >>> this.hashShift;
    }

    private final boolean putAllEntries(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z10 = false;
        if (collection.isEmpty()) {
            return false;
        }
        ensureExtraCapacity(collection.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            if (putEntry(iterator2.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    private final boolean putEntry(Map.Entry<? extends K, ? extends V> entry) {
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib >= 0) {
            allocateValuesArray[addKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i10 = (-addKey$kotlin_stdlib) - 1;
        if (s.d(entry.getValue(), allocateValuesArray[i10])) {
            return false;
        }
        allocateValuesArray[i10] = entry.getValue();
        return true;
    }

    private final boolean putRehash(int i10) {
        int hash = hash(this.keysArray[i10]);
        int i11 = this.maxProbeDistance;
        while (true) {
            int[] iArr = this.hashArray;
            if (iArr[hash] == 0) {
                iArr[hash] = i10 + 1;
                this.presenceArray[i10] = hash;
                return true;
            }
            i11--;
            if (i11 < 0) {
                return false;
            }
            hash = hash == 0 ? getHashSize() - 1 : hash - 1;
        }
    }

    private final void rehash(int i10) {
        if (this.length > size()) {
            compact();
        }
        int i11 = 0;
        if (i10 != getHashSize()) {
            this.hashArray = new int[i10];
            this.hashShift = Companion.d(i10);
        } else {
            l.k(this.hashArray, 0, 0, getHashSize());
        }
        while (i11 < this.length) {
            int i12 = i11 + 1;
            if (!putRehash(i11)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i11 = i12;
        }
    }

    private final void removeHashAt(int i10) {
        int d10 = n.d(this.maxProbeDistance * 2, getHashSize() / 2);
        int i11 = 0;
        int i12 = i10;
        do {
            i10 = i10 == 0 ? getHashSize() - 1 : i10 - 1;
            i11++;
            if (i11 > this.maxProbeDistance) {
                this.hashArray[i12] = 0;
                return;
            }
            int[] iArr = this.hashArray;
            int i13 = iArr[i10];
            if (i13 == 0) {
                iArr[i12] = 0;
                return;
            }
            if (i13 < 0) {
                iArr[i12] = -1;
            } else {
                int i14 = i13 - 1;
                if (((hash(this.keysArray[i14]) - i10) & (getHashSize() - 1)) >= i11) {
                    this.hashArray[i12] = i13;
                    this.presenceArray[i14] = i12;
                }
                d10--;
            }
            i12 = i10;
            i11 = 0;
            d10--;
        } while (d10 >= 0);
        this.hashArray[i12] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeKeyAt(int i10) {
        kotlin.collections.builders.b.f(this.keysArray, i10);
        removeHashAt(this.presenceArray[i10]);
        this.presenceArray[i10] = -1;
        this.size = size() - 1;
    }

    private final boolean shouldCompact(int i10) {
        int capacity$kotlin_stdlib = getCapacity$kotlin_stdlib();
        int i11 = this.length;
        int i12 = capacity$kotlin_stdlib - i11;
        int size = i11 - size();
        return i12 < i10 && i12 + size >= i10 && size >= getCapacity$kotlin_stdlib() / 4;
    }

    private final Object writeReplace() {
        if (this.isReadOnly) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    public final int addKey$kotlin_stdlib(K k10) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int hash = hash(k10);
            int d10 = n.d(this.maxProbeDistance * 2, getHashSize() / 2);
            int i10 = 0;
            while (true) {
                int i11 = this.hashArray[hash];
                if (i11 <= 0) {
                    if (this.length >= getCapacity$kotlin_stdlib()) {
                        ensureExtraCapacity(1);
                    } else {
                        int i12 = this.length;
                        int i13 = i12 + 1;
                        this.length = i13;
                        this.keysArray[i12] = k10;
                        this.presenceArray[i12] = hash;
                        this.hashArray[hash] = i13;
                        this.size = size() + 1;
                        if (i10 > this.maxProbeDistance) {
                            this.maxProbeDistance = i10;
                        }
                        return i12;
                    }
                } else {
                    if (s.d(this.keysArray[i11 - 1], k10)) {
                        return -i11;
                    }
                    i10++;
                    if (i10 > d10) {
                        rehash(getHashSize() * 2);
                        break;
                    }
                    hash = hash == 0 ? getHashSize() - 1 : hash - 1;
                }
            }
        }
    }

    @NotNull
    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        return this;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        e0 iterator2 = new IntRange(0, this.length - 1).iterator2();
        while (iterator2.hasNext()) {
            int nextInt = iterator2.nextInt();
            int[] iArr = this.presenceArray;
            int i10 = iArr[nextInt];
            if (i10 >= 0) {
                this.hashArray[i10] = 0;
                iArr[nextInt] = -1;
            }
        }
        kotlin.collections.builders.b.g(this.keysArray, 0, this.length);
        V[] vArr = this.valuesArray;
        if (vArr != null) {
            kotlin.collections.builders.b.g(vArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
    }

    public final boolean containsAllEntries$kotlin_stdlib(@NotNull Collection<?> m10) {
        s.i(m10, "m");
        for (Object obj : m10) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        s.i(entry, "entry");
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        s.f(vArr);
        return s.d(vArr[findKey], entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return findKey(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return findValue(obj) >= 0;
    }

    @NotNull
    public final b<K, V> entriesIterator$kotlin_stdlib() {
        return new b<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object obj) {
        return obj == this || ((obj instanceof Map) && contentEquals((Map) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        int findKey = findKey(obj);
        if (findKey < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        s.f(vArr);
        return vArr[findKey];
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.keysArray.length;
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        kotlin.collections.builders.c<K, V> cVar = this.entriesView;
        if (cVar != null) {
            return cVar;
        }
        kotlin.collections.builders.c<K, V> cVar2 = new kotlin.collections.builders.c<>(this);
        this.entriesView = cVar2;
        return cVar2;
    }

    @NotNull
    public Set<K> getKeys() {
        kotlin.collections.builders.d<K> dVar = this.keysView;
        if (dVar != null) {
            return dVar;
        }
        kotlin.collections.builders.d<K> dVar2 = new kotlin.collections.builders.d<>(this);
        this.keysView = dVar2;
        return dVar2;
    }

    public int getSize() {
        return this.size;
    }

    @NotNull
    public Collection<V> getValues() {
        kotlin.collections.builders.e<V> eVar = this.valuesView;
        if (eVar != null) {
            return eVar;
        }
        kotlin.collections.builders.e<V> eVar2 = new kotlin.collections.builders.e<>(this);
        this.valuesView = eVar2;
        return eVar2;
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i10 = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            i10 += entriesIterator$kotlin_stdlib.i();
        }
        return i10;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isReadOnly$kotlin_stdlib() {
        return this.isReadOnly;
    }

    @Override // java.util.Map
    /* renamed from: keySet */
    public final /* bridge */ Set<K> h() {
        return getKeys();
    }

    @NotNull
    public final e<K, V> keysIterator$kotlin_stdlib() {
        return new e<>(this);
    }

    @Override // java.util.Map
    @Nullable
    public V put(K k10, V v2) {
        checkIsMutable$kotlin_stdlib();
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(k10);
        V[] allocateValuesArray = allocateValuesArray();
        if (addKey$kotlin_stdlib < 0) {
            int i10 = (-addKey$kotlin_stdlib) - 1;
            V v10 = allocateValuesArray[i10];
            allocateValuesArray[i10] = v2;
            return v10;
        }
        allocateValuesArray[addKey$kotlin_stdlib] = v2;
        return null;
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends V> from) {
        s.i(from, "from");
        checkIsMutable$kotlin_stdlib();
        putAllEntries(from.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V remove(Object obj) {
        int removeKey$kotlin_stdlib = removeKey$kotlin_stdlib(obj);
        if (removeKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.valuesArray;
        s.f(vArr);
        V v2 = vArr[removeKey$kotlin_stdlib];
        kotlin.collections.builders.b.f(vArr, removeKey$kotlin_stdlib);
        return v2;
    }

    public final boolean removeEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        s.i(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        V[] vArr = this.valuesArray;
        s.f(vArr);
        if (!s.d(vArr[findKey], entry.getValue())) {
            return false;
        }
        removeKeyAt(findKey);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K k10) {
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(k10);
        if (findKey < 0) {
            return -1;
        }
        removeKeyAt(findKey);
        return findKey;
    }

    public final boolean removeValue$kotlin_stdlib(V v2) {
        checkIsMutable$kotlin_stdlib();
        int findValue = findValue(v2);
        if (findValue < 0) {
            return false;
        }
        removeKeyAt(findValue);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder((size() * 3) + 2);
        sb2.append("{");
        b<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i10 = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            entriesIterator$kotlin_stdlib.h(sb2);
            i10++;
        }
        sb2.append(i.f4738d);
        String sb3 = sb2.toString();
        s.h(sb3, "sb.toString()");
        return sb3;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    @NotNull
    public final f<K, V> valuesIterator$kotlin_stdlib() {
        return new f<>(this);
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i10) {
        this(kotlin.collections.builders.b.d(i10), null, new int[i10], new int[Companion.c(i10)], 2, 0);
    }
}
