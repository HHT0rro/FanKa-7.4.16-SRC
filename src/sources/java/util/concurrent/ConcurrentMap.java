package java.util.concurrent;

import XI.CA.XI.K0;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface ConcurrentMap<K, V> extends Map<K, V> {
    V putIfAbsent(K k10, V v2);

    boolean remove(Object obj, Object obj2);

    V replace(K k10, V v2);

    boolean replace(K k10, V v2, V v10);

    @Override // java.util.Map
    default V getOrDefault(Object key, V defaultValue) {
        V v2 = get(key);
        return v2 != null ? v2 : defaultValue;
    }

    @Override // java.util.Map
    default void forEach(BiConsumer<? super K, ? super V> action) {
        Objects.requireNonNull(action);
        for (Map.Entry<K, V> entry : entrySet()) {
            try {
                K k10 = entry.getKey();
                V v2 = entry.getValue();
                action.accept(k10, v2);
            } catch (IllegalStateException e2) {
            }
        }
    }

    @Override // java.util.Map
    default void replaceAll(final BiFunction<? super K, ? super V, ? extends V> function) {
        Objects.requireNonNull(function);
        forEach(new BiConsumer() { // from class: java.util.concurrent.ConcurrentMap$$ExternalSyntheticLambda0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ConcurrentMap.this.lambda$replaceAll$0(function, obj, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default void lambda$replaceAll$0(BiFunction function, Object k10, Object v2) {
        while (!replace(k10, v2, function.apply(k10, v2))) {
            Object obj = get(k10);
            v2 = obj;
            if (obj == null) {
                return;
            }
        }
    }

    @Override // java.util.Map
    default V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        V newValue;
        Objects.requireNonNull(mappingFunction);
        V v2 = get(key);
        V oldValue = v2;
        if (v2 == null && (newValue = mappingFunction.apply(key)) != null) {
            V putIfAbsent = putIfAbsent(key, newValue);
            oldValue = putIfAbsent;
            if (putIfAbsent == null) {
                return newValue;
            }
        }
        return oldValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    default V computeIfPresent(K k10, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        V apply;
        Objects.requireNonNull(biFunction);
        while (true) {
            K0 k02 = (Object) get(k10);
            if (k02 != 0) {
                apply = biFunction.apply(k10, k02);
                if (apply == null) {
                    if (remove(k10, k02)) {
                        break;
                    }
                } else if (replace(k10, k02, apply)) {
                    break;
                }
            } else {
                return null;
            }
        }
        return apply;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    default V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        V newValue;
        Object putIfAbsent;
        while (true) {
            Object obj = get(key);
            do {
                newValue = remappingFunction.apply(key, obj);
                if (newValue != null) {
                    if (obj != null) {
                        if (replace(key, obj, newValue)) {
                            return newValue;
                        }
                    } else {
                        putIfAbsent = putIfAbsent(key, newValue);
                        obj = putIfAbsent;
                    }
                } else if (obj == null || remove(key, obj)) {
                    return null;
                }
            } while (putIfAbsent != null);
            return newValue;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    default V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        Objects.requireNonNull(value);
        while (true) {
            Object obj = get(key);
            while (obj == null) {
                Object putIfAbsent = putIfAbsent(key, value);
                obj = putIfAbsent;
                if (putIfAbsent == null) {
                    return value;
                }
            }
            V newValue = remappingFunction.apply(obj, value);
            if (newValue != null) {
                if (replace(key, obj, newValue)) {
                    return newValue;
                }
            } else if (remove(key, obj)) {
                return null;
            }
        }
    }
}
