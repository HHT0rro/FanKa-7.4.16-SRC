package org.apache.commons.collections4.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections4.SortedBag;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class CollectionSortedBag<E> extends AbstractSortedBagDecorator<E> {
    private static final long serialVersionUID = -2560033712679053143L;

    public CollectionSortedBag(SortedBag<E> sortedBag) {
        super(sortedBag);
    }

    public static <E> SortedBag<E> collectionSortedBag(SortedBag<E> sortedBag) {
        return new CollectionSortedBag(sortedBag);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        setCollection((Collection) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(decorated());
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        return add(e2, 1);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        boolean z10;
        Iterator<? extends E> iterator2 = collection.iterator2();
        while (true) {
            while (iterator2.hasNext()) {
                z10 = z10 || add(iterator2.next(), 1);
            }
            return z10;
        }
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

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return remove(obj, 1);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        boolean z10;
        if (collection != null) {
            while (true) {
                for (Object obj : collection) {
                    z10 = z10 || remove(obj, getCount(obj));
                }
                return z10;
            }
        }
        return decorated().removeAll(null);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        if (collection != null) {
            boolean z10 = false;
            Iterator<E> iterator2 = iterator2();
            while (iterator2.hasNext()) {
                if (!collection.contains(iterator2.next())) {
                    iterator2.remove();
                    z10 = true;
                }
            }
            return z10;
        }
        return decorated().retainAll(null);
    }

    @Override // org.apache.commons.collections4.bag.AbstractBagDecorator, org.apache.commons.collections4.Bag
    public boolean add(E e2, int i10) {
        decorated().add(e2, i10);
        return true;
    }
}
