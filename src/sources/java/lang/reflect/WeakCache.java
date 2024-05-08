package java.lang.reflect;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class WeakCache<K, P, V> {
    private final BiFunction<K, P, ?> subKeyFactory;
    private final BiFunction<K, P, V> valueFactory;
    private final ReferenceQueue<K> refQueue = new ReferenceQueue<>();
    private final ConcurrentMap<Object, ConcurrentMap<Object, Supplier<V>>> map = new ConcurrentHashMap();
    private final ConcurrentMap<Supplier<V>, Boolean> reverseMap = new ConcurrentHashMap();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private interface Value<V> extends Supplier<V> {
    }

    public WeakCache(BiFunction<K, P, ?> subKeyFactory, BiFunction<K, P, V> valueFactory) {
        this.subKeyFactory = (BiFunction) Objects.requireNonNull(subKeyFactory);
        this.valueFactory = (BiFunction) Objects.requireNonNull(valueFactory);
    }

    public V get(K key, P parameter) {
        Objects.requireNonNull(parameter);
        expungeStaleEntries();
        Object cacheKey = CacheKey.valueOf(key, this.refQueue);
        ConcurrentMap<Object, Supplier<V>> valuesMap = this.map.get(cacheKey);
        if (valuesMap == null) {
            ConcurrentMap<Object, ConcurrentMap<Object, Supplier<V>>> concurrentMap = this.map;
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            valuesMap = concurrentHashMap;
            ConcurrentMap<Object, Supplier<V>> oldValuesMap = concurrentMap.putIfAbsent(cacheKey, concurrentHashMap);
            if (oldValuesMap != null) {
                valuesMap = oldValuesMap;
            }
        }
        Object subKey = Objects.requireNonNull(this.subKeyFactory.apply(key, parameter));
        Supplier<V> supplier = valuesMap.get(subKey);
        Supplier<V> supplier2 = supplier;
        WeakCache<K, P, V>.Factory factory = null;
        while (true) {
            if (supplier2 != null) {
                V value = supplier2.get();
                if (value != null) {
                    return value;
                }
            }
            if (factory == null) {
                factory = new Factory(key, parameter, subKey, valuesMap);
            }
            if (supplier2 == null) {
                Supplier<V> supplier3 = valuesMap.putIfAbsent(subKey, factory);
                supplier2 = supplier3;
                if (supplier2 == null) {
                    supplier2 = factory;
                }
            } else if (valuesMap.replace(subKey, supplier2, factory)) {
                supplier2 = factory;
            } else {
                Supplier<V> supplier4 = valuesMap.get(subKey);
                supplier2 = supplier4;
            }
        }
    }

    public boolean containsValue(V value) {
        Objects.requireNonNull(value);
        expungeStaleEntries();
        return this.reverseMap.containsKey(new LookupValue(value));
    }

    public int size() {
        expungeStaleEntries();
        return this.reverseMap.size();
    }

    private void expungeStaleEntries() {
        while (true) {
            CacheKey<K> cacheKey = (CacheKey) this.refQueue.poll();
            if (cacheKey != null) {
                cacheKey.expungeFrom(this.map, this.reverseMap);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public final class Factory implements Supplier<V> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final K key;
        private final P parameter;
        private final Object subKey;
        private final ConcurrentMap<Object, Supplier<V>> valuesMap;

        Factory(K key, P parameter, Object subKey, ConcurrentMap<Object, Supplier<V>> valuesMap) {
            this.key = key;
            this.parameter = parameter;
            this.subKey = subKey;
            this.valuesMap = valuesMap;
        }

        @Override // java.util.function.Supplier
        public synchronized V get() {
            if (this.valuesMap.get(this.subKey) != this) {
                return null;
            }
            V v2 = null;
            try {
                V v10 = (V) Objects.requireNonNull(WeakCache.this.valueFactory.apply(this.key, this.parameter));
                CacheValue cacheValue = new CacheValue(v10);
                if (this.valuesMap.replace(this.subKey, this, cacheValue)) {
                    WeakCache.this.reverseMap.put(cacheValue, Boolean.TRUE);
                    return v10;
                }
                throw new AssertionError((Object) "Should not reach here");
            } finally {
                if (v2 == null) {
                    this.valuesMap.remove(this.subKey, this);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class LookupValue<V> implements Value<V> {
        private final V value;

        LookupValue(V value) {
            this.value = value;
        }

        @Override // java.util.function.Supplier
        public V get() {
            return this.value;
        }

        public int hashCode() {
            return System.identityHashCode(this.value);
        }

        public boolean equals(Object obj) {
            return obj == this || ((obj instanceof Value) && this.value == ((Value) obj).get());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class CacheValue<V> extends WeakReference<V> implements Value<V> {
        private final int hash;

        CacheValue(V value) {
            super(value);
            this.hash = System.identityHashCode(value);
        }

        public int hashCode() {
            return this.hash;
        }

        public boolean equals(Object obj) {
            V value;
            return obj == this || ((obj instanceof Value) && (value = get()) != null && value == ((Value) obj).get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class CacheKey<K> extends WeakReference<K> {
        private static final Object NULL_KEY = new Object();
        private final int hash;

        static <K> Object valueOf(K key, ReferenceQueue<K> refQueue) {
            if (key == null) {
                return NULL_KEY;
            }
            return new CacheKey(key, refQueue);
        }

        private CacheKey(K key, ReferenceQueue<K> refQueue) {
            super(key, refQueue);
            this.hash = System.identityHashCode(key);
        }

        public int hashCode() {
            return this.hash;
        }

        public boolean equals(Object obj) {
            K key;
            return obj == this || (obj != null && obj.getClass() == getClass() && (key = get()) != null && key == ((CacheKey) obj).get());
        }

        void expungeFrom(ConcurrentMap<?, ? extends ConcurrentMap<?, ?>> map, ConcurrentMap<?, Boolean> reverseMap) {
            ConcurrentMap<?, ?> valuesMap = map.remove(this);
            if (valuesMap != null) {
                for (Object cacheValue : valuesMap.values()) {
                    reverseMap.remove(cacheValue);
                }
            }
        }
    }
}
