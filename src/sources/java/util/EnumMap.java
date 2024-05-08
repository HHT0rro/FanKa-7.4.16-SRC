package java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class EnumMap<K extends Enum<K>, V> extends AbstractMap<K, V> implements Serializable, Cloneable {
    private static final Object NULL = new Object() { // from class: java.util.EnumMap.1
        public int hashCode() {
            return 0;
        }

        public String toString() {
            return "java.util.EnumMap.NULL";
        }
    };
    private static final long serialVersionUID = 458661240069192865L;
    private transient Set<Map.Entry<K, V>> entrySet;
    private final Class<K> keyType;
    private transient K[] keyUniverse;
    private transient int size;
    private transient Object[] vals;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((EnumMap<K, V>) obj, (Enum) obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object maskNull(Object value) {
        return value == null ? NULL : value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public V unmaskNull(Object obj) {
        if (obj == NULL) {
            return null;
        }
        return obj;
    }

    public EnumMap(Class<K> cls) {
        this.size = 0;
        this.keyType = cls;
        K[] kArr = (K[]) getKeyUniverse(cls);
        this.keyUniverse = kArr;
        this.vals = new Object[kArr.length];
    }

    public EnumMap(EnumMap<K, ? extends V> m10) {
        this.size = 0;
        this.keyType = m10.keyType;
        this.keyUniverse = m10.keyUniverse;
        this.vals = (Object[]) m10.vals.clone();
        this.size = m10.size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EnumMap(Map<K, ? extends V> map) {
        this.size = 0;
        if (map instanceof EnumMap) {
            EnumMap enumMap = (EnumMap) map;
            this.keyType = enumMap.keyType;
            this.keyUniverse = enumMap.keyUniverse;
            this.vals = (Object[]) enumMap.vals.clone();
            this.size = enumMap.size;
            return;
        }
        if (map.isEmpty()) {
            throw new IllegalArgumentException("Specified map is empty");
        }
        Class<K> declaringClass = ((Enum) map.h().iterator2().next()).getDeclaringClass();
        this.keyType = declaringClass;
        K[] kArr = (K[]) getKeyUniverse(declaringClass);
        this.keyUniverse = kArr;
        this.vals = new Object[kArr.length];
        putAll(map);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object value) {
        Object value2 = maskNull(value);
        for (Object val : this.vals) {
            if (value2.equals(val)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object key) {
        return isValidKey(key) && this.vals[((Enum) key).ordinal()] != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean containsMapping(Object key, Object value) {
        return isValidKey(key) && maskNull(value).equals(this.vals[((Enum) key).ordinal()]);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object key) {
        if (isValidKey(key)) {
            return unmaskNull(this.vals[((Enum) key).ordinal()]);
        }
        return null;
    }

    public V put(K key, V value) {
        typeCheck(key);
        int index = key.ordinal();
        Object[] objArr = this.vals;
        Object oldValue = objArr[index];
        objArr[index] = maskNull(value);
        if (oldValue == null) {
            this.size++;
        }
        return unmaskNull(oldValue);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object key) {
        if (!isValidKey(key)) {
            return null;
        }
        int index = ((Enum) key).ordinal();
        Object[] objArr = this.vals;
        Object oldValue = objArr[index];
        objArr[index] = null;
        if (oldValue != null) {
            this.size--;
        }
        return unmaskNull(oldValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeMapping(Object key, Object value) {
        if (!isValidKey(key)) {
            return false;
        }
        int index = ((Enum) key).ordinal();
        if (!maskNull(value).equals(this.vals[index])) {
            return false;
        }
        this.vals[index] = null;
        this.size--;
        return true;
    }

    private boolean isValidKey(Object key) {
        if (key == null) {
            return false;
        }
        Class<?> keyClass = key.getClass();
        return keyClass == this.keyType || keyClass.getSuperclass() == this.keyType;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> m10) {
        if (m10 instanceof EnumMap) {
            EnumMap<?, ?> em = (EnumMap) m10;
            if (em.keyType != this.keyType) {
                if (em.isEmpty()) {
                    return;
                } else {
                    throw new ClassCastException(((Object) em.keyType) + " != " + ((Object) this.keyType));
                }
            }
            for (int i10 = 0; i10 < this.keyUniverse.length; i10++) {
                Object emValue = em.vals[i10];
                if (emValue != null) {
                    Object[] objArr = this.vals;
                    if (objArr[i10] == null) {
                        this.size++;
                    }
                    objArr[i10] = emValue;
                }
            }
            return;
        }
        super.putAll(m10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.vals, (Object) null);
        this.size = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        Set<K> set = (Set<K>) this.keySet;
        if (set == null) {
            KeySet keySet = new KeySet();
            this.keySet = keySet;
            return keySet;
        }
        return set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class KeySet extends AbstractSet<K> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return EnumMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return EnumMap.this.containsKey(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            int oldSize = EnumMap.this.size;
            EnumMap.this.remove(o10);
            return EnumMap.this.size != oldSize;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            EnumMap.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> vs = this.values;
        if (vs == null) {
            Collection<V> vs2 = new Values();
            this.values = vs2;
            return vs2;
        }
        return vs;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class Values extends AbstractCollection<V> {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<V> iterator2() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return EnumMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return EnumMap.this.containsValue(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            Object o11 = EnumMap.this.maskNull(o10);
            for (int i10 = 0; i10 < EnumMap.this.vals.length; i10++) {
                if (o11.equals(EnumMap.this.vals[i10])) {
                    EnumMap.this.vals[i10] = null;
                    EnumMap.this.size--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            EnumMap.this.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> es = this.entrySet;
        if (es != null) {
            return es;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            if (o10 instanceof Map.Entry) {
                Map.Entry<?, ?> entry = (Map.Entry) o10;
                if (EnumMap.this.containsMapping(entry.getKey(), entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o10) {
            if (o10 instanceof Map.Entry) {
                Map.Entry<?, ?> entry = (Map.Entry) o10;
                if (EnumMap.this.removeMapping(entry.getKey(), entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return EnumMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            EnumMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return fillEntryArray(new Object[EnumMap.this.size]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            int size = size();
            if (tArr.length < size) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
            }
            if (tArr.length > size) {
                tArr[size] = null;
            }
            return (T[]) fillEntryArray(tArr);
        }

        private Object[] fillEntryArray(Object[] a10) {
            int j10 = 0;
            for (int i10 = 0; i10 < EnumMap.this.vals.length; i10++) {
                if (EnumMap.this.vals[i10] != null) {
                    Enum r42 = EnumMap.this.keyUniverse[i10];
                    EnumMap enumMap = EnumMap.this;
                    a10[j10] = new AbstractMap.SimpleEntry(r42, enumMap.unmaskNull(enumMap.vals[i10]));
                    j10++;
                }
            }
            return a10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public abstract class EnumMapIterator<T> implements Iterator<T> {
        int index;
        int lastReturnedIndex;

        private EnumMapIterator() {
            this.index = 0;
            this.lastReturnedIndex = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (this.index < EnumMap.this.vals.length) {
                Object[] objArr = EnumMap.this.vals;
                int i10 = this.index;
                if (objArr[i10] != null) {
                    break;
                }
                this.index = i10 + 1;
            }
            return this.index != EnumMap.this.vals.length;
        }

        @Override // java.util.Iterator
        public void remove() {
            checkLastReturnedIndex();
            if (EnumMap.this.vals[this.lastReturnedIndex] != null) {
                EnumMap.this.vals[this.lastReturnedIndex] = null;
                EnumMap enumMap = EnumMap.this;
                enumMap.size--;
            }
            this.lastReturnedIndex = -1;
        }

        private void checkLastReturnedIndex() {
            if (this.lastReturnedIndex < 0) {
                throw new IllegalStateException();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class KeyIterator extends EnumMap<K, V>.EnumMapIterator<K> {
        private KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i10 = this.index;
            this.index = i10 + 1;
            this.lastReturnedIndex = i10;
            return (K) EnumMap.this.keyUniverse[this.lastReturnedIndex];
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private class ValueIterator extends EnumMap<K, V>.EnumMapIterator<V> {
        private ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i10 = this.index;
            this.index = i10 + 1;
            this.lastReturnedIndex = i10;
            EnumMap enumMap = EnumMap.this;
            return (V) enumMap.unmaskNull(enumMap.vals[this.lastReturnedIndex]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class EntryIterator extends EnumMap<K, V>.EnumMapIterator<Map.Entry<K, V>> {
        private EnumMap<K, V>.EntryIterator.Entry lastReturnedEntry;

        private EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i10 = this.index;
            this.index = i10 + 1;
            EnumMap<K, V>.EntryIterator.Entry entry = new Entry(i10);
            this.lastReturnedEntry = entry;
            return entry;
        }

        @Override // java.util.EnumMap.EnumMapIterator, java.util.Iterator
        public void remove() {
            EnumMap<K, V>.EntryIterator.Entry entry = this.lastReturnedEntry;
            this.lastReturnedIndex = entry == null ? -1 : ((Entry) entry).index;
            super.remove();
            ((Entry) this.lastReturnedEntry).index = this.lastReturnedIndex;
            this.lastReturnedEntry = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public class Entry implements Map.Entry<K, V> {
            private int index;

            private Entry(int index) {
                this.index = index;
            }

            @Override // java.util.Map.Entry
            public K getKey() {
                checkIndexForEntryUse();
                return (K) EnumMap.this.keyUniverse[this.index];
            }

            @Override // java.util.Map.Entry
            public V getValue() {
                checkIndexForEntryUse();
                return (V) EnumMap.this.unmaskNull(EnumMap.this.vals[this.index]);
            }

            @Override // java.util.Map.Entry
            public V setValue(V v2) {
                checkIndexForEntryUse();
                V v10 = (V) EnumMap.this.unmaskNull(EnumMap.this.vals[this.index]);
                EnumMap.this.vals[this.index] = EnumMap.this.maskNull(v2);
                return v10;
            }

            @Override // java.util.Map.Entry
            public boolean equals(Object o10) {
                if (this.index < 0) {
                    return o10 == this;
                }
                if (!(o10 instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry<?, ?> e2 = (Map.Entry) o10;
                Object unmaskNull = EnumMap.this.unmaskNull(EnumMap.this.vals[this.index]);
                Object hisValue = e2.getValue();
                if (e2.getKey() == EnumMap.this.keyUniverse[this.index]) {
                    if (unmaskNull == hisValue) {
                        return true;
                    }
                    if (unmaskNull != null && unmaskNull.equals(hisValue)) {
                        return true;
                    }
                }
                return false;
            }

            @Override // java.util.Map.Entry
            public int hashCode() {
                if (this.index < 0) {
                    return super.hashCode();
                }
                return EnumMap.this.entryHashCode(this.index);
            }

            public String toString() {
                if (this.index < 0) {
                    return super.toString();
                }
                return ((Object) EnumMap.this.keyUniverse[this.index]) + "=" + EnumMap.this.unmaskNull(EnumMap.this.vals[this.index]);
            }

            private void checkIndexForEntryUse() {
                if (this.index < 0) {
                    throw new IllegalStateException("Entry was removed");
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 instanceof EnumMap) {
            return equals((EnumMap<?, ?>) o10);
        }
        if (!(o10 instanceof Map)) {
            return false;
        }
        Map<?, ?> m10 = (Map) o10;
        if (this.size != m10.size()) {
            return false;
        }
        int i10 = 0;
        while (true) {
            K[] kArr = this.keyUniverse;
            if (i10 >= kArr.length) {
                return true;
            }
            Object obj = this.vals[i10];
            if (obj != null) {
                K key = kArr[i10];
                V value = unmaskNull(obj);
                if (value == null) {
                    if (m10.get(key) != null || !m10.containsKey(key)) {
                        break;
                    }
                } else if (!value.equals(m10.get(key))) {
                    return false;
                }
            }
            i10++;
        }
        return false;
    }

    private boolean equals(EnumMap<?, ?> em) {
        int i10 = em.size;
        int i11 = this.size;
        if (i10 != i11) {
            return false;
        }
        if (em.keyType != this.keyType) {
            return i11 == 0;
        }
        for (int i12 = 0; i12 < this.keyUniverse.length; i12++) {
            Object ourValue = this.vals[i12];
            Object hisValue = em.vals[i12];
            if (hisValue != ourValue && (hisValue == null || !hisValue.equals(ourValue))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int h10 = 0;
        for (int i10 = 0; i10 < this.keyUniverse.length; i10++) {
            if (this.vals[i10] != null) {
                h10 += entryHashCode(i10);
            }
        }
        return h10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int entryHashCode(int index) {
        return this.keyUniverse[index].hashCode() ^ this.vals[index].hashCode();
    }

    @Override // java.util.AbstractMap
    public EnumMap<K, V> clone() {
        try {
            EnumMap<K, V> result = (EnumMap) super.clone();
            result.vals = (Object[]) result.vals.clone();
            result.entrySet = null;
            return result;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError();
        }
    }

    private void typeCheck(K key) {
        Class<?> keyClass = key.getClass();
        if (keyClass != this.keyType && keyClass.getSuperclass() != this.keyType) {
            throw new ClassCastException(((Object) keyClass) + " != " + ((Object) this.keyType));
        }
    }

    private static <K extends Enum<K>> K[] getKeyUniverse(Class<K> keyType) {
        return keyType.getEnumConstantsShared();
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        s2.defaultWriteObject();
        s2.writeInt(this.size);
        int entriesToBeWritten = this.size;
        int i10 = 0;
        while (entriesToBeWritten > 0) {
            if (this.vals[i10] != null) {
                s2.writeObject(this.keyUniverse[i10]);
                s2.writeObject(unmaskNull(this.vals[i10]));
                entriesToBeWritten--;
            }
            i10++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        K[] kArr = (K[]) getKeyUniverse(this.keyType);
        this.keyUniverse = kArr;
        this.vals = new Object[kArr.length];
        int readInt = objectInputStream.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            put((EnumMap<K, V>) objectInputStream.readObject(), (Enum) objectInputStream.readObject());
        }
    }
}
