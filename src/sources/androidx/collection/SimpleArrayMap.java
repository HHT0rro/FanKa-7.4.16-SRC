package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SimpleArrayMap<K, V> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";

    @Nullable
    public static Object[] mBaseCache;
    public static int mBaseCacheSize;

    @Nullable
    public static Object[] mTwiceBaseCache;
    public static int mTwiceBaseCacheSize;
    public Object[] mArray;
    public int[] mHashes;
    public int mSize;

    public SimpleArrayMap() {
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    private void allocArrays(int i10) {
        if (i10 == 8) {
            synchronized (SimpleArrayMap.class) {
                Object[] objArr = mTwiceBaseCache;
                if (objArr != null) {
                    this.mArray = objArr;
                    mTwiceBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    mTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (i10 == 4) {
            synchronized (SimpleArrayMap.class) {
                Object[] objArr2 = mBaseCache;
                if (objArr2 != null) {
                    this.mArray = objArr2;
                    mBaseCache = (Object[]) objArr2[0];
                    this.mHashes = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    mBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[i10];
        this.mArray = new Object[i10 << 1];
    }

    private static int binarySearchHashes(int[] iArr, int i10, int i11) {
        try {
            return ContainerHelpers.binarySearch(iArr, i10, i11);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (SimpleArrayMap.class) {
                if (mTwiceBaseCacheSize < 10) {
                    objArr[0] = mTwiceBaseCache;
                    objArr[1] = iArr;
                    for (int i11 = (i10 << 1) - 1; i11 >= 2; i11--) {
                        objArr[i11] = null;
                    }
                    mTwiceBaseCache = objArr;
                    mTwiceBaseCacheSize++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (SimpleArrayMap.class) {
                if (mBaseCacheSize < 10) {
                    objArr[0] = mBaseCache;
                    objArr[1] = iArr;
                    for (int i12 = (i10 << 1) - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    mBaseCache = objArr;
                    mBaseCacheSize++;
                }
            }
        }
    }

    public void clear() {
        int i10 = this.mSize;
        if (i10 > 0) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
            freeArrays(iArr, objArr, i10);
        }
        if (this.mSize > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(@Nullable Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public void ensureCapacity(int i10) {
        int i11 = this.mSize;
        int[] iArr = this.mHashes;
        if (iArr.length < i10) {
            Object[] objArr = this.mArray;
            allocArrays(i10);
            if (this.mSize > 0) {
                System.arraycopy((Object) iArr, 0, (Object) this.mHashes, 0, i11);
                System.arraycopy(objArr, 0, this.mArray, 0, i11 << 1);
            }
            freeArrays(iArr, objArr, i11);
        }
        if (this.mSize != i11) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            for (int i10 = 0; i10 < this.mSize; i10++) {
                try {
                    K keyAt = keyAt(i10);
                    V valueAt = valueAt(i10);
                    Object obj2 = simpleArrayMap.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i11 = 0; i11 < this.mSize; i11++) {
                try {
                    K keyAt2 = keyAt(i11);
                    V valueAt2 = valueAt(i11);
                    Object obj3 = map.get(keyAt2);
                    if (valueAt2 == null) {
                        if (obj3 != null || !map.containsKey(keyAt2)) {
                            return false;
                        }
                    } else if (!valueAt2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    @Nullable
    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v2) {
        int indexOfKey = indexOfKey(obj);
        return indexOfKey >= 0 ? (V) this.mArray[(indexOfKey << 1) + 1] : v2;
    }

    public int hashCode() {
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int i10 = this.mSize;
        int i11 = 1;
        int i12 = 0;
        int i13 = 0;
        while (i12 < i10) {
            Object obj = objArr[i11];
            i13 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i12];
            i12++;
            i11 += 2;
        }
        return i13;
    }

    public int indexOf(Object obj, int i10) {
        int i11 = this.mSize;
        if (i11 == 0) {
            return -1;
        }
        int binarySearchHashes = binarySearchHashes(this.mHashes, i11, i10);
        if (binarySearchHashes < 0 || obj.equals(this.mArray[binarySearchHashes << 1])) {
            return binarySearchHashes;
        }
        int i12 = binarySearchHashes + 1;
        while (i12 < i11 && this.mHashes[i12] == i10) {
            if (obj.equals(this.mArray[i12 << 1])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = binarySearchHashes - 1; i13 >= 0 && this.mHashes[i13] == i10; i13--) {
            if (obj.equals(this.mArray[i13 << 1])) {
                return i13;
            }
        }
        return ~i12;
    }

    public int indexOfKey(@Nullable Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    public int indexOfNull() {
        int i10 = this.mSize;
        if (i10 == 0) {
            return -1;
        }
        int binarySearchHashes = binarySearchHashes(this.mHashes, i10, 0);
        if (binarySearchHashes < 0 || this.mArray[binarySearchHashes << 1] == null) {
            return binarySearchHashes;
        }
        int i11 = binarySearchHashes + 1;
        while (i11 < i10 && this.mHashes[i11] == 0) {
            if (this.mArray[i11 << 1] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = binarySearchHashes - 1; i12 >= 0 && this.mHashes[i12] == 0; i12--) {
            if (this.mArray[i12 << 1] == null) {
                return i12;
            }
        }
        return ~i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int indexOfValue(Object obj) {
        int i10 = this.mSize * 2;
        Object[] objArr = this.mArray;
        if (obj == null) {
            for (int i11 = 1; i11 < i10; i11 += 2) {
                if (objArr[i11] == null) {
                    return i11 >> 1;
                }
            }
            return -1;
        }
        for (int i12 = 1; i12 < i10; i12 += 2) {
            if (obj.equals(objArr[i12])) {
                return i12 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public K keyAt(int i10) {
        return (K) this.mArray[i10 << 1];
    }

    @Nullable
    public V put(K k10, V v2) {
        int i10;
        int indexOf;
        int i11 = this.mSize;
        if (k10 == null) {
            indexOf = indexOfNull();
            i10 = 0;
        } else {
            int hashCode = k10.hashCode();
            i10 = hashCode;
            indexOf = indexOf(k10, hashCode);
        }
        if (indexOf >= 0) {
            int i12 = (indexOf << 1) + 1;
            Object[] objArr = this.mArray;
            V v10 = (V) objArr[i12];
            objArr[i12] = v2;
            return v10;
        }
        int i13 = ~indexOf;
        int[] iArr = this.mHashes;
        if (i11 >= iArr.length) {
            int i14 = 4;
            if (i11 >= 8) {
                i14 = (i11 >> 1) + i11;
            } else if (i11 >= 4) {
                i14 = 8;
            }
            Object[] objArr2 = this.mArray;
            allocArrays(i14);
            if (i11 == this.mSize) {
                int[] iArr2 = this.mHashes;
                if (iArr2.length > 0) {
                    System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.mArray, 0, objArr2.length);
                }
                freeArrays(iArr, objArr2, i11);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i13 < i11) {
            int[] iArr3 = this.mHashes;
            int i15 = i13 + 1;
            System.arraycopy((Object) iArr3, i13, (Object) iArr3, i15, i11 - i13);
            Object[] objArr3 = this.mArray;
            System.arraycopy(objArr3, i13 << 1, objArr3, i15 << 1, (this.mSize - i13) << 1);
        }
        int i16 = this.mSize;
        if (i11 == i16) {
            int[] iArr4 = this.mHashes;
            if (i13 < iArr4.length) {
                iArr4[i13] = i10;
                Object[] objArr4 = this.mArray;
                int i17 = i13 << 1;
                objArr4[i17] = k10;
                objArr4[i17 + 1] = v2;
                this.mSize = i16 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(@NonNull SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i10 = simpleArrayMap.mSize;
        ensureCapacity(this.mSize + i10);
        if (this.mSize != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                put(simpleArrayMap.keyAt(i11), simpleArrayMap.valueAt(i11));
            }
        } else if (i10 > 0) {
            System.arraycopy((Object) simpleArrayMap.mHashes, 0, (Object) this.mHashes, 0, i10);
            System.arraycopy(simpleArrayMap.mArray, 0, this.mArray, 0, i10 << 1);
            this.mSize = i10;
        }
    }

    @Nullable
    public V putIfAbsent(K k10, V v2) {
        V v10 = get(k10);
        return v10 == null ? put(k10, v2) : v10;
    }

    @Nullable
    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V removeAt(int i10) {
        Object[] objArr = this.mArray;
        int i11 = i10 << 1;
        V v2 = (V) objArr[i11 + 1];
        int i12 = this.mSize;
        int i13 = 0;
        if (i12 <= 1) {
            freeArrays(this.mHashes, objArr, i12);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int i14 = i12 - 1;
            int[] iArr = this.mHashes;
            if (iArr.length > 8 && i12 < iArr.length / 3) {
                allocArrays(i12 > 8 ? i12 + (i12 >> 1) : 8);
                if (i12 != this.mSize) {
                    throw new ConcurrentModificationException();
                }
                if (i10 > 0) {
                    System.arraycopy((Object) iArr, 0, (Object) this.mHashes, 0, i10);
                    System.arraycopy(objArr, 0, this.mArray, 0, i11);
                }
                if (i10 < i14) {
                    int i15 = i10 + 1;
                    int i16 = i14 - i10;
                    System.arraycopy((Object) iArr, i15, (Object) this.mHashes, i10, i16);
                    System.arraycopy(objArr, i15 << 1, this.mArray, i11, i16 << 1);
                }
            } else {
                if (i10 < i14) {
                    int i17 = i10 + 1;
                    int i18 = i14 - i10;
                    System.arraycopy((Object) iArr, i17, (Object) iArr, i10, i18);
                    Object[] objArr2 = this.mArray;
                    System.arraycopy(objArr2, i17 << 1, objArr2, i11, i18 << 1);
                }
                Object[] objArr3 = this.mArray;
                int i19 = i14 << 1;
                objArr3[i19] = null;
                objArr3[i19 + 1] = null;
            }
            i13 = i14;
        }
        if (i12 == this.mSize) {
            this.mSize = i13;
            return v2;
        }
        throw new ConcurrentModificationException();
    }

    @Nullable
    public V replace(K k10, V v2) {
        int indexOfKey = indexOfKey(k10);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, v2);
        }
        return null;
    }

    public V setValueAt(int i10, V v2) {
        int i11 = (i10 << 1) + 1;
        Object[] objArr = this.mArray;
        V v10 = (V) objArr[i11];
        objArr[i11] = v2;
        return v10;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.mSize * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.mSize; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            K keyAt = keyAt(i10);
            if (keyAt != this) {
                sb2.append((Object) keyAt);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            V valueAt = valueAt(i10);
            if (valueAt != this) {
                sb2.append((Object) valueAt);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public V valueAt(int i10) {
        return (V) this.mArray[(i10 << 1) + 1];
    }

    public boolean remove(Object obj, Object obj2) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey < 0) {
            return false;
        }
        V valueAt = valueAt(indexOfKey);
        if (obj2 != valueAt && (obj2 == null || !obj2.equals(valueAt))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public boolean replace(K k10, V v2, V v10) {
        int indexOfKey = indexOfKey(k10);
        if (indexOfKey < 0) {
            return false;
        }
        V valueAt = valueAt(indexOfKey);
        if (valueAt != v2 && (v2 == null || !v2.equals(valueAt))) {
            return false;
        }
        setValueAt(indexOfKey, v10);
        return true;
    }

    public SimpleArrayMap(int i10) {
        if (i10 == 0) {
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            allocArrays(i10);
        }
        this.mSize = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != 0) {
            putAll(simpleArrayMap);
        }
    }
}
