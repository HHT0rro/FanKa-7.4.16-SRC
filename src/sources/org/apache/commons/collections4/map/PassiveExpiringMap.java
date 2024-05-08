package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class PassiveExpiringMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 1;
    private final Map<Object, Long> expirationMap;
    private final ExpirationPolicy<K, V> expiringPolicy;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ConstantTimeToLiveExpirationPolicy<K, V> implements ExpirationPolicy<K, V> {
        private static final long serialVersionUID = 1;
        private final long timeToLiveMillis;

        public ConstantTimeToLiveExpirationPolicy() {
            this(-1L);
        }

        @Override // org.apache.commons.collections4.map.PassiveExpiringMap.ExpirationPolicy
        public long expirationTime(K k10, V v2) {
            if (this.timeToLiveMillis < 0) {
                return -1L;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j10 = this.timeToLiveMillis;
            if (currentTimeMillis > Long.MAX_VALUE - j10) {
                return -1L;
            }
            return currentTimeMillis + j10;
        }

        public ConstantTimeToLiveExpirationPolicy(long j10) {
            this.timeToLiveMillis = j10;
        }

        public ConstantTimeToLiveExpirationPolicy(long j10, TimeUnit timeUnit) {
            this(PassiveExpiringMap.validateAndConvertToMillis(j10, timeUnit));
        }
    }

    @FunctionalInterface
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface ExpirationPolicy<K, V> extends Serializable {
        long expirationTime(K k10, V v2);
    }

    public PassiveExpiringMap() {
        this(-1L);
    }

    private boolean isExpired(long j10, Long l10) {
        if (l10 == null) {
            return false;
        }
        long longValue = l10.longValue();
        return longValue >= 0 && j10 >= longValue;
    }

    private long now() {
        return System.currentTimeMillis();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void removeAllExpired(long j10) {
        Iterator<Map.Entry<Object, Long>> iterator2 = this.expirationMap.entrySet().iterator2();
        while (iterator2.hasNext()) {
            Map.Entry<Object, Long> next = iterator2.next();
            if (isExpired(j10, next.getValue())) {
                super.remove(next.getKey());
                iterator2.remove();
            }
        }
    }

    private void removeIfExpired(Object obj, long j10) {
        if (isExpired(j10, this.expirationMap.get(obj))) {
            remove(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long validateAndConvertToMillis(long j10, TimeUnit timeUnit) {
        Objects.requireNonNull(timeUnit, "Time unit must not be null");
        return TimeUnit.MILLISECONDS.convert(j10, timeUnit);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void clear() {
        super.clear();
        this.expirationMap.clear();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public boolean containsKey(Object obj) {
        removeIfExpired(obj, now());
        return super.containsKey(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public boolean containsValue(Object obj) {
        removeAllExpired(now());
        return super.containsValue(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        removeAllExpired(now());
        return super.entrySet();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V get(Object obj) {
        removeIfExpired(obj, now());
        return (V) super.get(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public boolean isEmpty() {
        removeAllExpired(now());
        return super.isEmpty();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    /* renamed from: keySet */
    public Set<K> h() {
        removeAllExpired(now());
        return super.h();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V put(K k10, V v2) {
        removeIfExpired(k10, now());
        this.expirationMap.put(k10, Long.valueOf(this.expiringPolicy.expirationTime(k10, v2)));
        return (V) super.put(k10, v2);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public V remove(Object obj) {
        this.expirationMap.remove(obj);
        return (V) super.remove(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public int size() {
        removeAllExpired(now());
        return super.size();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Collection<V> values() {
        removeAllExpired(now());
        return super.values();
    }

    public PassiveExpiringMap(ExpirationPolicy<K, V> expirationPolicy) {
        this(expirationPolicy, new HashMap());
    }

    public PassiveExpiringMap(ExpirationPolicy<K, V> expirationPolicy, Map<K, V> map) {
        super(map);
        this.expirationMap = new HashMap();
        Objects.requireNonNull(expirationPolicy, "Policy must not be null.");
        this.expiringPolicy = expirationPolicy;
    }

    public PassiveExpiringMap(long j10) {
        this(new ConstantTimeToLiveExpirationPolicy(j10), new HashMap());
    }

    public PassiveExpiringMap(long j10, Map<K, V> map) {
        this(new ConstantTimeToLiveExpirationPolicy(j10), map);
    }

    public PassiveExpiringMap(long j10, TimeUnit timeUnit) {
        this(validateAndConvertToMillis(j10, timeUnit));
    }

    public PassiveExpiringMap(long j10, TimeUnit timeUnit, Map<K, V> map) {
        this(validateAndConvertToMillis(j10, timeUnit), map);
    }

    public PassiveExpiringMap(Map<K, V> map) {
        this(-1L, map);
    }
}
