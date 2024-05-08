package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
    private final HashMap<K, SafeIterableMap.Entry<K, V>> mHashMap = new HashMap<>();

    @Nullable
    public Map.Entry<K, V> ceil(K k10) {
        if (contains(k10)) {
            return this.mHashMap.get(k10).mPrevious;
        }
        return null;
    }

    public boolean contains(K k10) {
        return this.mHashMap.containsKey(k10);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    @Nullable
    public SafeIterableMap.Entry<K, V> get(K k10) {
        return this.mHashMap.get(k10);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V putIfAbsent(@NonNull K k10, @NonNull V v2) {
        SafeIterableMap.Entry<K, V> entry = get(k10);
        if (entry != null) {
            return entry.mValue;
        }
        this.mHashMap.put(k10, put(k10, v2));
        return null;
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V remove(@NonNull K k10) {
        V v2 = (V) super.remove(k10);
        this.mHashMap.remove(k10);
        return v2;
    }
}
