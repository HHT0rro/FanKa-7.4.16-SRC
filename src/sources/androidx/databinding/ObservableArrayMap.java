package androidx.databinding;

import androidx.collection.ArrayMap;
import androidx.databinding.ObservableMap;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ObservableArrayMap<K, V> extends ArrayMap<K, V> implements ObservableMap<K, V> {
    private transient MapChangeRegistry mListeners;

    private void notifyChange(Object obj) {
        MapChangeRegistry mapChangeRegistry = this.mListeners;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.notifyCallbacks(this, 0, obj);
        }
    }

    @Override // androidx.databinding.ObservableMap
    public void addOnMapChangedCallback(ObservableMap.OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> onMapChangedCallback) {
        if (this.mListeners == null) {
            this.mListeners = new MapChangeRegistry();
        }
        this.mListeners.add(onMapChangedCallback);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        if (isEmpty()) {
            return;
        }
        super.clear();
        notifyChange(null);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K k10, V v2) {
        super.put(k10, v2);
        notifyChange(k10);
        return v2;
    }

    @Override // androidx.collection.ArrayMap
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> iterator2 = collection.iterator2();
        boolean z10 = false;
        while (iterator2.hasNext()) {
            int indexOfKey = indexOfKey(iterator2.next());
            if (indexOfKey >= 0) {
                z10 = true;
                removeAt(indexOfKey);
            }
        }
        return z10;
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int i10) {
        K keyAt = keyAt(i10);
        V v2 = (V) super.removeAt(i10);
        if (v2 != null) {
            notifyChange(keyAt);
        }
        return v2;
    }

    @Override // androidx.databinding.ObservableMap
    public void removeOnMapChangedCallback(ObservableMap.OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> onMapChangedCallback) {
        MapChangeRegistry mapChangeRegistry = this.mListeners;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.remove(onMapChangedCallback);
        }
    }

    @Override // androidx.collection.ArrayMap
    public boolean retainAll(Collection<?> collection) {
        boolean z10 = false;
        for (int size = size() - 1; size >= 0; size--) {
            if (!collection.contains(keyAt(size))) {
                removeAt(size);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int i10, V v2) {
        K keyAt = keyAt(i10);
        V v10 = (V) super.setValueAt(i10, v2);
        notifyChange(keyAt);
        return v10;
    }
}
