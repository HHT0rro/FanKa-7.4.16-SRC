package java.util;

import java.io.Serializable;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class AbstractMap<K, V> implements Map<K, V> {
    transient Set<K> keySet;
    transient Collection<V> values;

    @Override // java.util.Map
    public abstract Set<Map.Entry<K, V>> entrySet();

    @Override // java.util.Map
    public int size() {
        return entrySet().size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
    
        if (r0.hasNext() == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r2 = r0.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        if (r5.equals(r2.getValue()) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0009, code lost:
    
        if (r5 == null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000f, code lost:
    
        if (r0.hasNext() == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
    
        r2 = r0.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r2.getValue() != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        return true;
     */
    @Override // java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean containsValue(java.lang.Object r5) {
        /*
            r4 = this;
            java.util.Set r0 = r4.entrySet()
            java.util.Iterator r0 = r0.iterator2()
            r1 = 1
            if (r5 != 0) goto L1f
        Lb:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L37
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            if (r3 != 0) goto L1e
            return r1
        L1e:
            goto Lb
        L1f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L37
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L36
            return r1
        L36:
            goto L1f
        L37:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.AbstractMap.containsValue(java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0037, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
    
        if (r0.hasNext() == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r2 = r0.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        if (r5.equals(r2.getKey()) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0009, code lost:
    
        if (r5 == null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000f, code lost:
    
        if (r0.hasNext() == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
    
        r2 = r0.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r2.getKey() != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        return true;
     */
    @Override // java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean containsKey(java.lang.Object r5) {
        /*
            r4 = this;
            java.util.Set r0 = r4.entrySet()
            java.util.Iterator r0 = r0.iterator2()
            r1 = 1
            if (r5 != 0) goto L1f
        Lb:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L37
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            if (r3 != 0) goto L1e
            return r1
        L1e:
            goto Lb
        L1f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L37
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L36
            return r1
        L36:
            goto L1f
        L37:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.AbstractMap.containsKey(java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
    
        if (r0.hasNext() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0028, code lost:
    
        r1 = r0.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        if (r4.equals(r1.getKey()) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        return r1.getValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0008, code lost:
    
        if (r4 == null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r0.hasNext() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        r1 = r0.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
    
        if (r1.getKey() != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        return r1.getValue();
     */
    @Override // java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V get(java.lang.Object r4) {
        /*
            r3 = this;
            java.util.Set r0 = r3.entrySet()
            java.util.Iterator r0 = r0.iterator2()
            if (r4 != 0) goto L22
        La:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L3e
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            if (r2 != 0) goto L21
            java.lang.Object r2 = r1.getValue()
            return r2
        L21:
            goto La
        L22:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L3e
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L3d
            java.lang.Object r2 = r1.getValue()
            return r2
        L3d:
            goto L22
        L3e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.AbstractMap.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.Map
    public V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public V remove(Object key) {
        Iterator<Map.Entry<K, V>> i10 = entrySet().iterator2();
        Map.Entry<K, V> correctEntry = null;
        if (key == null) {
            while (correctEntry == null && i10.hasNext()) {
                Map.Entry<K, V> e2 = i10.next();
                if (e2.getKey() == null) {
                    correctEntry = e2;
                }
            }
        } else {
            while (correctEntry == null && i10.hasNext()) {
                Map.Entry<K, V> e10 = i10.next();
                if (key.equals(e10.getKey())) {
                    correctEntry = e10;
                }
            }
        }
        if (correctEntry == null) {
            return null;
        }
        V oldValue = correctEntry.getValue();
        i10.remove();
        return oldValue;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> m10) {
        for (Map.Entry<? extends K, ? extends V> e2 : m10.entrySet()) {
            put(e2.getKey(), e2.getValue());
        }
    }

    @Override // java.util.Map
    public void clear() {
        entrySet().clear();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        Set<K> ks = this.keySet;
        if (ks == null) {
            Set<K> ks2 = new AbstractSet<K>() { // from class: java.util.AbstractMap.1
                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                /* renamed from: iterator */
                public Iterator<K> iterator2() {
                    return new Iterator<K>() { // from class: java.util.AbstractMap.1.1

                        /* renamed from: i, reason: collision with root package name */
                        private Iterator<Map.Entry<K, V>> f50423i;

                        {
                            this.f50423i = AbstractMap.this.entrySet().iterator2();
                        }

                        @Override // java.util.Iterator
                        public boolean hasNext() {
                            return this.f50423i.hasNext();
                        }

                        @Override // java.util.Iterator
                        public K next() {
                            return this.f50423i.next().getKey();
                        }

                        @Override // java.util.Iterator
                        public void remove() {
                            this.f50423i.remove();
                        }
                    };
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return AbstractMap.this.size();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean isEmpty() {
                    return AbstractMap.this.isEmpty();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    AbstractMap.this.clear();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object k10) {
                    return AbstractMap.this.containsKey(k10);
                }
            };
            this.keySet = ks2;
            return ks2;
        }
        return ks;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        Collection<V> vals = this.values;
        if (vals == null) {
            Collection<V> vals2 = new AbstractCollection<V>() { // from class: java.util.AbstractMap.2
                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                /* renamed from: iterator */
                public Iterator<V> iterator2() {
                    return new Iterator<V>() { // from class: java.util.AbstractMap.2.1

                        /* renamed from: i, reason: collision with root package name */
                        private Iterator<Map.Entry<K, V>> f50424i;

                        {
                            this.f50424i = AbstractMap.this.entrySet().iterator2();
                        }

                        @Override // java.util.Iterator
                        public boolean hasNext() {
                            return this.f50424i.hasNext();
                        }

                        @Override // java.util.Iterator
                        public V next() {
                            return this.f50424i.next().getValue();
                        }

                        @Override // java.util.Iterator
                        public void remove() {
                            this.f50424i.remove();
                        }
                    };
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return AbstractMap.this.size();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean isEmpty() {
                    return AbstractMap.this.isEmpty();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    AbstractMap.this.clear();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object v2) {
                    return AbstractMap.this.containsValue(v2);
                }
            };
            this.values = vals2;
            return vals2;
        }
        return vals;
    }

    @Override // java.util.Map
    public boolean equals(Object o10) {
        if (o10 == this) {
            return true;
        }
        if (!(o10 instanceof Map)) {
            return false;
        }
        Map<?, ?> m10 = (Map) o10;
        if (m10.size() != size()) {
            return false;
        }
        try {
            for (Map.Entry<K, V> e2 : entrySet()) {
                K key = e2.getKey();
                V value = e2.getValue();
                if (value == null) {
                    if (m10.get(key) != null || !m10.containsKey(key)) {
                        return false;
                    }
                } else if (!value.equals(m10.get(key))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException e10) {
            return false;
        } catch (NullPointerException e11) {
            return false;
        }
    }

    @Override // java.util.Map
    public int hashCode() {
        int h10 = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            h10 += entry.hashCode();
        }
        return h10;
    }

    public String toString() {
        Iterator<Map.Entry<K, V>> i10 = entrySet().iterator2();
        if (!i10.hasNext()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('{');
        while (true) {
            Map.Entry<K, V> e2 = i10.next();
            K key = e2.getKey();
            V value = e2.getValue();
            sb2.append(key == this ? "(this Map)" : key);
            sb2.append('=');
            sb2.append(value != this ? value : "(this Map)");
            if (!i10.hasNext()) {
                return sb2.append('}').toString();
            }
            sb2.append(',').append(' ');
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        AbstractMap<?, ?> result = (AbstractMap) super.clone();
        result.keySet = null;
        result.values = null;
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean eq(Object o12, Object o22) {
        return o12 == null ? o22 == null : o12.equals(o22);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SimpleEntry<K, V> implements Map.Entry<K, V>, Serializable {
        private static final long serialVersionUID = -8499721149061103585L;
        private final K key;
        private V value;

        public SimpleEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public SimpleEntry(Map.Entry<? extends K, ? extends V> entry) {
            this.key = entry.getKey();
            this.value = entry.getValue();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object o10) {
            if (o10 instanceof Map.Entry) {
                Map.Entry<?, ?> e2 = (Map.Entry) o10;
                if (AbstractMap.eq(this.key, e2.getKey()) && AbstractMap.eq(this.value, e2.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.key;
            int hashCode = k10 == null ? 0 : k10.hashCode();
            V v2 = this.value;
            return hashCode ^ (v2 != null ? v2.hashCode() : 0);
        }

        public String toString() {
            return ((Object) this.key) + "=" + ((Object) this.value);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SimpleImmutableEntry<K, V> implements Map.Entry<K, V>, Serializable {
        private static final long serialVersionUID = 7138329143949025153L;
        private final K key;
        private final V value;

        public SimpleImmutableEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public SimpleImmutableEntry(Map.Entry<? extends K, ? extends V> entry) {
            this.key = entry.getKey();
            this.value = entry.getValue();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V value) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object o10) {
            if (o10 instanceof Map.Entry) {
                Map.Entry<?, ?> e2 = (Map.Entry) o10;
                if (AbstractMap.eq(this.key, e2.getKey()) && AbstractMap.eq(this.value, e2.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.key;
            int hashCode = k10 == null ? 0 : k10.hashCode();
            V v2 = this.value;
            return hashCode ^ (v2 != null ? v2.hashCode() : 0);
        }

        public String toString() {
            return ((Object) this.key) + "=" + ((Object) this.value);
        }
    }
}
