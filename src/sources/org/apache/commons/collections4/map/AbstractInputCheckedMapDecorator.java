package org.apache.commons.collections4.map;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator;
import org.apache.commons.collections4.set.AbstractSetDecorator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractInputCheckedMapDecorator<K, V> extends AbstractMapDecorator<K, V> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class EntrySetIterator extends AbstractIteratorDecorator<Map.Entry<K, V>> {
        private final AbstractInputCheckedMapDecorator<K, V> parent;

        public EntrySetIterator(Iterator<Map.Entry<K, V>> it, AbstractInputCheckedMapDecorator<K, V> abstractInputCheckedMapDecorator) {
            super(it);
            this.parent = abstractInputCheckedMapDecorator;
        }

        @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
        public Map.Entry<K, V> next() {
            return new MapEntry(getIterator().next(), this.parent);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class MapEntry extends AbstractMapEntryDecorator<K, V> {
        private final AbstractInputCheckedMapDecorator<K, V> parent;

        public MapEntry(Map.Entry<K, V> entry, AbstractInputCheckedMapDecorator<K, V> abstractInputCheckedMapDecorator) {
            super(entry);
            this.parent = abstractInputCheckedMapDecorator;
        }

        @Override // org.apache.commons.collections4.keyvalue.AbstractMapEntryDecorator, java.util.Map.Entry
        public V setValue(V v2) {
            return getMapEntry().setValue(this.parent.checkSetValue(v2));
        }
    }

    public AbstractInputCheckedMapDecorator() {
    }

    public abstract V checkSetValue(V v2);

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (isSetValueChecking()) {
            return new EntrySet(this.map.entrySet(), this);
        }
        return this.map.entrySet();
    }

    public boolean isSetValueChecking() {
        return true;
    }

    public AbstractInputCheckedMapDecorator(Map<K, V> map) {
        super(map);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class EntrySet extends AbstractSetDecorator<Map.Entry<K, V>> {
        private static final long serialVersionUID = 4354731610923110264L;
        private final AbstractInputCheckedMapDecorator<K, V> parent;

        public EntrySet(Set<Map.Entry<K, V>> set, AbstractInputCheckedMapDecorator<K, V> abstractInputCheckedMapDecorator) {
            super(set);
            this.parent = abstractInputCheckedMapDecorator;
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<K, V>> iterator2() {
            return new EntrySetIterator(decorated().iterator2(), this.parent);
        }

        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] array = decorated().toArray();
            for (int i10 = 0; i10 < array.length; i10++) {
                array[i10] = new MapEntry((Map.Entry) array[i10], this.parent);
            }
            return array;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            T[] tArr2 = (T[]) decorated().toArray(tArr.length > 0 ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), 0) : tArr);
            for (int i10 = 0; i10 < tArr2.length; i10++) {
                tArr2[i10] = new MapEntry((Map.Entry) tArr2[i10], this.parent);
            }
            if (tArr2.length > tArr.length) {
                return tArr2;
            }
            System.arraycopy(tArr2, 0, tArr, 0, tArr2.length);
            if (tArr.length > tArr2.length) {
                tArr[tArr2.length] = null;
            }
            return tArr;
        }
    }
}
