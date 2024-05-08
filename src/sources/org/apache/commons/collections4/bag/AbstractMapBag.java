package org.apache.commons.collections4.bag;

import com.android.internal.accessibility.common.ShortcutConstants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.set.UnmodifiableSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractMapBag<E> implements Bag<E> {
    private transient Map<E, MutableInteger> map;
    private transient int modCount;
    private int size;
    private transient Set<E> uniqueSet;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class BagIterator<E> implements Iterator<E> {
        private final Iterator<Map.Entry<E, MutableInteger>> entryIterator;
        private int itemCount;
        private final int mods;
        private final AbstractMapBag<E> parent;
        private Map.Entry<E, MutableInteger> current = null;
        private boolean canRemove = false;

        public BagIterator(AbstractMapBag<E> abstractMapBag) {
            this.parent = abstractMapBag;
            this.entryIterator = ((AbstractMapBag) abstractMapBag).map.entrySet().iterator2();
            this.mods = ((AbstractMapBag) abstractMapBag).modCount;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.itemCount > 0 || this.entryIterator.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (((AbstractMapBag) this.parent).modCount == this.mods) {
                if (this.itemCount == 0) {
                    Map.Entry<E, MutableInteger> next = this.entryIterator.next();
                    this.current = next;
                    this.itemCount = next.getValue().value;
                }
                this.canRemove = true;
                this.itemCount--;
                return this.current.getKey();
            }
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (((AbstractMapBag) this.parent).modCount == this.mods) {
                if (this.canRemove) {
                    MutableInteger value = this.current.getValue();
                    int i10 = value.value;
                    if (i10 > 1) {
                        value.value = i10 - 1;
                    } else {
                        this.entryIterator.remove();
                    }
                    AbstractMapBag.access$210(this.parent);
                    this.canRemove = false;
                    return;
                }
                throw new IllegalStateException();
            }
            throw new ConcurrentModificationException();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class MutableInteger {
        public int value;

        public MutableInteger(int i10) {
            this.value = i10;
        }

        public boolean equals(Object obj) {
            return (obj instanceof MutableInteger) && ((MutableInteger) obj).value == this.value;
        }

        public int hashCode() {
            return this.value;
        }
    }

    public AbstractMapBag() {
    }

    public static /* synthetic */ int access$210(AbstractMapBag abstractMapBag) {
        int i10 = abstractMapBag.size;
        abstractMapBag.size = i10 - 1;
        return i10;
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        return add(e2, 1);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        boolean z10;
        Iterator<? extends E> iterator2 = collection.iterator2();
        while (true) {
            while (iterator2.hasNext()) {
                z10 = z10 || add(iterator2.next());
            }
            return z10;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        this.modCount++;
        this.map.clear();
        this.size = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof Bag) {
            return containsAll((Bag<?>) collection);
        }
        return containsAll((Bag<?>) new HashBag(collection));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void doReadObject(Map<E, MutableInteger> map, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.map = map;
        int readInt = objectInputStream.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            Object readObject = objectInputStream.readObject();
            int readInt2 = objectInputStream.readInt();
            map.put(readObject, new MutableInteger(readInt2));
            this.size += readInt2;
        }
    }

    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.map.size());
        for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().value);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Bag)) {
            return false;
        }
        Bag bag = (Bag) obj;
        if (bag.size() != size()) {
            return false;
        }
        for (E e2 : this.map.h()) {
            if (bag.getCount(e2) != getCount(e2)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.commons.collections4.Bag
    public int getCount(Object obj) {
        MutableInteger mutableInteger = this.map.get(obj);
        if (mutableInteger != null) {
            return mutableInteger.value;
        }
        return 0;
    }

    public Map<E, MutableInteger> getMap() {
        return this.map;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int i10 = 0;
        for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
            E key = entry.getKey();
            i10 += entry.getValue().value ^ (key == null ? 0 : key.hashCode());
        }
        return i10;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new BagIterator(this);
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        MutableInteger mutableInteger = this.map.get(obj);
        if (mutableInteger == null) {
            return false;
        }
        this.modCount++;
        this.map.remove(obj);
        this.size -= mutableInteger.value;
        return true;
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        boolean z10;
        if (collection == null) {
            return false;
        }
        Iterator<?> iterator2 = collection.iterator2();
        while (true) {
            while (iterator2.hasNext()) {
                z10 = z10 || remove(iterator2.next(), 1);
            }
            return z10;
        }
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        if (collection instanceof Bag) {
            return retainAll((Bag<?>) collection);
        }
        return retainAll((Bag<?>) new HashBag(collection));
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        int i10 = 0;
        for (E e2 : this.map.h()) {
            int count = getCount(e2);
            while (count > 0) {
                objArr[i10] = e2;
                count--;
                i10++;
            }
        }
        return objArr;
    }

    public String toString() {
        if (size() == 0) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        Iterator<E> iterator2 = uniqueSet().iterator2();
        while (iterator2.hasNext()) {
            E next = iterator2.next();
            sb2.append(getCount(next));
            sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
            sb2.append((Object) next);
            if (iterator2.hasNext()) {
                sb2.append(',');
            }
        }
        sb2.append(']');
        return sb2.toString();
    }

    @Override // org.apache.commons.collections4.Bag
    public Set<E> uniqueSet() {
        if (this.uniqueSet == null) {
            this.uniqueSet = UnmodifiableSet.unmodifiableSet(this.map.h());
        }
        return this.uniqueSet;
    }

    public AbstractMapBag(Map<E, MutableInteger> map) {
        this.map = map;
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean add(E e2, int i10) {
        this.modCount++;
        if (i10 > 0) {
            MutableInteger mutableInteger = this.map.get(e2);
            this.size += i10;
            if (mutableInteger == null) {
                this.map.put(e2, new MutableInteger(i10));
                return true;
            }
            mutableInteger.value += i10;
        }
        return false;
    }

    public boolean containsAll(Bag<?> bag) {
        for (Object obj : bag.uniqueSet()) {
            if (getCount(obj) < bag.getCount(obj)) {
                return false;
            }
        }
        return true;
    }

    public boolean retainAll(Bag<?> bag) {
        HashBag hashBag = new HashBag();
        for (E e2 : uniqueSet()) {
            int count = getCount(e2);
            int count2 = bag.getCount(e2);
            if (1 <= count2 && count2 <= count) {
                hashBag.add(e2, count - count2);
            } else {
                hashBag.add(e2, count);
            }
        }
        if (hashBag.isEmpty()) {
            return false;
        }
        return removeAll(hashBag);
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean remove(Object obj, int i10) {
        MutableInteger mutableInteger = this.map.get(obj);
        if (mutableInteger == null || i10 <= 0) {
            return false;
        }
        this.modCount++;
        int i11 = mutableInteger.value;
        if (i10 < i11) {
            mutableInteger.value = i11 - i10;
            this.size -= i10;
        } else {
            this.map.remove(obj);
            this.size -= mutableInteger.value;
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        }
        int i10 = 0;
        for (E e2 : this.map.h()) {
            int count = getCount(e2);
            while (count > 0) {
                tArr[i10] = e2;
                count--;
                i10++;
            }
        }
        while (i10 < tArr.length) {
            tArr[i10] = null;
            i10++;
        }
        return tArr;
    }
}
