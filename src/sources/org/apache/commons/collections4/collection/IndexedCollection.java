package org.apache.commons.collections4.collection;

import androidx.core.util.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Predicate;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.MultiValueMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class IndexedCollection<K, C> extends AbstractCollectionDecorator<C> {
    private static final long serialVersionUID = -5512610452568370038L;
    private final MultiMap<K, C> index;
    private final Transformer<C, K> keyTransformer;
    private final boolean uniqueIndex;

    public IndexedCollection(Collection<C> collection, Transformer<C, K> transformer, MultiMap<K, C> multiMap, boolean z10) {
        super(collection);
        this.keyTransformer = transformer;
        this.index = multiMap;
        this.uniqueIndex = z10;
        reindex();
    }

    private void addToIndex(C c4) {
        K transform = this.keyTransformer.transform(c4);
        if (this.uniqueIndex && this.index.containsKey(transform)) {
            throw new IllegalArgumentException("Duplicate key in uniquely indexed collection.");
        }
        this.index.put(transform, c4);
    }

    public static <K, C> IndexedCollection<K, C> nonUniqueIndexedCollection(Collection<C> collection, Transformer<C, K> transformer) {
        return new IndexedCollection<>(collection, transformer, MultiValueMap.multiValueMap(new HashMap()), false);
    }

    private void removeFromIndex(C c4) {
        this.index.remove(this.keyTransformer.transform(c4));
    }

    public static <K, C> IndexedCollection<K, C> uniqueIndexedCollection(Collection<C> collection, Transformer<C, K> transformer) {
        return new IndexedCollection<>(collection, transformer, MultiValueMap.multiValueMap(new HashMap()), true);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean add(C c4) {
        boolean add = super.add(c4);
        if (add) {
            addToIndex(c4);
        }
        return add;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends C> collection) {
        Iterator<? extends C> iterator2 = collection.iterator2();
        boolean z10 = false;
        while (iterator2.hasNext()) {
            z10 |= add(iterator2.next());
        }
        return z10;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public void clear() {
        super.clear();
        this.index.clear();
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.index.containsKey(this.keyTransformer.transform(obj));
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            if (!contains(iterator2.next())) {
                return false;
            }
        }
        return true;
    }

    public C get(K k10) {
        Collection collection = (Collection) this.index.get(k10);
        if (collection == null) {
            return null;
        }
        return (C) collection.iterator2().next();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void reindex() {
        this.index.clear();
        Iterator iterator2 = decorated().iterator2();
        while (iterator2.hasNext()) {
            addToIndex(iterator2.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        boolean remove = super.remove(obj);
        if (remove) {
            removeFromIndex(obj);
        }
        return remove;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> iterator2 = collection.iterator2();
        boolean z10 = false;
        while (iterator2.hasNext()) {
            z10 |= remove(iterator2.next());
        }
        return z10;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean removeIf(Predicate<? super C> predicate) {
        boolean z10 = false;
        if (a.a(predicate)) {
            return false;
        }
        Iterator<C> iterator2 = iterator2();
        while (iterator2.hasNext()) {
            if (predicate.test(iterator2.next())) {
                iterator2.remove();
                z10 = true;
            }
        }
        if (z10) {
            reindex();
        }
        return z10;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll = super.retainAll(collection);
        if (retainAll) {
            reindex();
        }
        return retainAll;
    }

    public Collection<C> values(K k10) {
        return (Collection) this.index.get(k10);
    }
}
