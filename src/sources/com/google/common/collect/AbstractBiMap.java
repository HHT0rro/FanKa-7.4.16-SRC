package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class AbstractBiMap<K, V> extends v<K, V> implements k<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    private transient Map<K, V> delegate;
    private transient Set<Map.Entry<K, V>> entrySet;
    public transient AbstractBiMap<V, K> inverse;
    private transient Set<K> keySet;
    private transient Set<V> valueSet;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Inverse<K, V> extends AbstractBiMap<K, V> {
        private static final long serialVersionUID = 0;

        public Inverse(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap, null);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            setInverse((AbstractBiMap) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(inverse());
        }

        @Override // com.google.common.collect.AbstractBiMap
        public K checkKey(K k10) {
            return this.inverse.checkValue(k10);
        }

        @Override // com.google.common.collect.AbstractBiMap
        public V checkValue(V v2) {
            return this.inverse.checkKey(v2);
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.v, com.google.common.collect.z
        public /* bridge */ /* synthetic */ Object delegate() {
            return super.delegate();
        }

        public Object readResolve() {
            return inverse().inverse();
        }

        @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.v, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements Iterator<Map.Entry<K, V>> {

        /* renamed from: b, reason: collision with root package name */
        public Map.Entry<K, V> f26137b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Iterator f26138c;

        public a(Iterator it) {
            this.f26138c = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            Map.Entry<K, V> entry = (Map.Entry) this.f26138c.next();
            this.f26137b = entry;
            return new b(entry);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f26138c.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            Map.Entry<K, V> entry = this.f26137b;
            if (entry != null) {
                V value = entry.getValue();
                this.f26138c.remove();
                AbstractBiMap.this.removeFromInverseMap(value);
                this.f26137b = null;
                return;
            }
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends w<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final Map.Entry<K, V> f26140b;

        public b(Map.Entry<K, V> entry) {
            this.f26140b = entry;
        }

        @Override // com.google.common.collect.z
        /* renamed from: o */
        public Map.Entry<K, V> delegate() {
            return this.f26140b;
        }

        @Override // com.google.common.collect.w, java.util.Map.Entry
        public V setValue(V v2) {
            AbstractBiMap.this.checkValue(v2);
            com.google.common.base.o.y(AbstractBiMap.this.entrySet().contains(this), "entry no longer in map");
            if (com.google.common.base.l.a(v2, getValue())) {
                return v2;
            }
            com.google.common.base.o.m(!AbstractBiMap.this.containsValue(v2), "value already present: %s", v2);
            V value = this.f26140b.setValue(v2);
            com.google.common.base.o.y(com.google.common.base.l.a(v2, AbstractBiMap.this.get(getKey())), "entry no longer in map");
            AbstractBiMap.this.updateInverseMap(getKey(), true, value, v2);
            return value;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c extends b0<Map.Entry<K, V>> {

        /* renamed from: b, reason: collision with root package name */
        public final Set<Map.Entry<K, V>> f26142b;

        public c() {
            this.f26142b = AbstractBiMap.this.delegate.entrySet();
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return Maps.f(delegate(), obj);
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            return AbstractBiMap.this.entrySetIterator();
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!this.f26142b.contains(obj) || !(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            ((AbstractBiMap) AbstractBiMap.this.inverse).delegate.remove(entry.getValue());
            this.f26142b.remove(entry);
            return true;
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        public /* synthetic */ c(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        @Override // com.google.common.collect.b0, com.google.common.collect.s, com.google.common.collect.z
        public Set<Map.Entry<K, V>> delegate() {
            return this.f26142b;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class d extends b0<K> {
        public d() {
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public void clear() {
            AbstractBiMap.this.clear();
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            return Maps.m(AbstractBiMap.this.entrySet().iterator2());
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            AbstractBiMap.this.removeFromBothMaps(obj);
            return true;
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        public /* synthetic */ d(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        @Override // com.google.common.collect.b0, com.google.common.collect.s, com.google.common.collect.z
        public Set<K> delegate() {
            return AbstractBiMap.this.delegate.h();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class e extends b0<V> {

        /* renamed from: b, reason: collision with root package name */
        public final Set<V> f26145b;

        public e() {
            this.f26145b = AbstractBiMap.this.inverse.h();
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<V> iterator2() {
            return Maps.L(AbstractBiMap.this.entrySet().iterator2());
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.z
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        public /* synthetic */ e(AbstractBiMap abstractBiMap, a aVar) {
            this();
        }

        @Override // com.google.common.collect.b0, com.google.common.collect.s, com.google.common.collect.z
        public Set<V> delegate() {
            return this.f26145b;
        }
    }

    public /* synthetic */ AbstractBiMap(Map map, AbstractBiMap abstractBiMap, a aVar) {
        this(map, abstractBiMap);
    }

    private V putInBothMaps(K k10, V v2, boolean z10) {
        checkKey(k10);
        checkValue(v2);
        boolean containsKey = containsKey(k10);
        if (containsKey && com.google.common.base.l.a(v2, get(k10))) {
            return v2;
        }
        if (z10) {
            inverse().remove(v2);
        } else {
            com.google.common.base.o.m(!containsValue(v2), "value already present: %s", v2);
        }
        V put = this.delegate.put(k10, v2);
        updateInverseMap(k10, containsKey, put, v2);
        return put;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V removeFromBothMaps(Object obj) {
        V v2 = (V) l0.a(this.delegate.remove(obj));
        removeFromInverseMap(v2);
        return v2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFromInverseMap(V v2) {
        this.inverse.delegate.remove(v2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void updateInverseMap(K k10, boolean z10, V v2, V v10) {
        if (z10) {
            removeFromInverseMap(l0.a(v2));
        }
        this.inverse.delegate.put(v10, k10);
    }

    public K checkKey(K k10) {
        return k10;
    }

    public V checkValue(V v2) {
        return v2;
    }

    @Override // com.google.common.collect.v, java.util.Map
    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    @Override // com.google.common.collect.v, java.util.Map
    public boolean containsValue(Object obj) {
        return this.inverse.containsKey(obj);
    }

    @Override // com.google.common.collect.v, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        c cVar = new c(this, null);
        this.entrySet = cVar;
        return cVar;
    }

    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        return new a(this.delegate.entrySet().iterator2());
    }

    @Override // com.google.common.collect.k
    public V forcePut(K k10, V v2) {
        return putInBothMaps(k10, v2, true);
    }

    @Override // com.google.common.collect.k
    public k<V, K> inverse() {
        return this.inverse;
    }

    @Override // com.google.common.collect.v, java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        d dVar = new d(this, null);
        this.keySet = dVar;
        return dVar;
    }

    public AbstractBiMap<V, K> makeInverse(Map<V, K> map) {
        return new Inverse(map, this);
    }

    @Override // com.google.common.collect.v, java.util.Map
    public V put(K k10, V v2) {
        return putInBothMaps(k10, v2, false);
    }

    @Override // com.google.common.collect.v, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.collect.v, java.util.Map
    public V remove(Object obj) {
        if (containsKey(obj)) {
            return removeFromBothMaps(obj);
        }
        return null;
    }

    public void setDelegates(Map<K, V> map, Map<V, K> map2) {
        com.google.common.base.o.x(this.delegate == null);
        com.google.common.base.o.x(this.inverse == null);
        com.google.common.base.o.d(map.isEmpty());
        com.google.common.base.o.d(map2.isEmpty());
        com.google.common.base.o.d(map != map2);
        this.delegate = map;
        this.inverse = makeInverse(map2);
    }

    public void setInverse(AbstractBiMap<V, K> abstractBiMap) {
        this.inverse = abstractBiMap;
    }

    public AbstractBiMap(Map<K, V> map, Map<V, K> map2) {
        setDelegates(map, map2);
    }

    @Override // com.google.common.collect.v, com.google.common.collect.z
    public Map<K, V> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.collect.v, java.util.Map
    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        e eVar = new e(this, null);
        this.valueSet = eVar;
        return eVar;
    }

    private AbstractBiMap(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
        this.delegate = map;
        this.inverse = abstractBiMap;
    }
}
