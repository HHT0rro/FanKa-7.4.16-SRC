package org.apache.commons.collections4.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.OrderedIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class AbstractLinkedList<E> implements List<E> {
    public transient Node<E> header;
    public transient int modCount;
    public transient int size;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class LinkedListIterator<E> implements ListIterator<E>, OrderedIterator<E> {
        public Node<E> current;
        public int expectedModCount;
        public Node<E> next;
        public int nextIndex;
        public final AbstractLinkedList<E> parent;

        public LinkedListIterator(AbstractLinkedList<E> abstractLinkedList, int i10) throws IndexOutOfBoundsException {
            this.parent = abstractLinkedList;
            this.expectedModCount = abstractLinkedList.modCount;
            this.next = abstractLinkedList.getNode(i10, true);
            this.nextIndex = i10;
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            checkModCount();
            this.parent.addNodeBefore(this.next, e2);
            this.current = null;
            this.nextIndex++;
            this.expectedModCount++;
        }

        public void checkModCount() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public Node<E> getLastNodeReturned() throws IllegalStateException {
            Node<E> node = this.current;
            if (node != null) {
                return node;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.next != this.parent.header;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.next.previous != this.parent.header;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            checkModCount();
            if (hasNext()) {
                E value = this.next.getValue();
                Node<E> node = this.next;
                this.current = node;
                this.next = node.next;
                this.nextIndex++;
                return value;
            }
            throw new NoSuchElementException("No element at index " + this.nextIndex + ".");
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.nextIndex;
        }

        @Override // java.util.ListIterator
        public E previous() {
            checkModCount();
            if (hasPrevious()) {
                Node<E> node = this.next.previous;
                this.next = node;
                E value = node.getValue();
                this.current = this.next;
                this.nextIndex--;
                return value;
            }
            throw new NoSuchElementException("Already at start of list.");
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return nextIndex() - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkModCount();
            Node<E> node = this.current;
            Node<E> node2 = this.next;
            if (node == node2) {
                this.next = node2.next;
                this.parent.removeNode(getLastNodeReturned());
            } else {
                this.parent.removeNode(getLastNodeReturned());
                this.nextIndex--;
            }
            this.current = null;
            this.expectedModCount++;
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            checkModCount();
            getLastNodeReturned().setValue(e2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class LinkedSubList<E> extends AbstractList<E> {
        public int expectedModCount;
        public int offset;
        public AbstractLinkedList<E> parent;
        public int size;

        public LinkedSubList(AbstractLinkedList<E> abstractLinkedList, int i10, int i11) {
            if (i10 >= 0) {
                if (i11 > abstractLinkedList.size()) {
                    throw new IndexOutOfBoundsException("toIndex = " + i11);
                }
                if (i10 <= i11) {
                    this.parent = abstractLinkedList;
                    this.offset = i10;
                    this.size = i11 - i10;
                    this.expectedModCount = abstractLinkedList.modCount;
                    return;
                }
                throw new IllegalArgumentException("fromIndex(" + i10 + ") > toIndex(" + i11 + ")");
            }
            throw new IndexOutOfBoundsException("fromIndex = " + i10);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i10, E e2) {
            rangeCheck(i10, this.size + 1);
            checkModCount();
            this.parent.add(i10 + this.offset, e2);
            this.expectedModCount = this.parent.modCount;
            this.size++;
            this.modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends E> collection) {
            return addAll(this.size, collection);
        }

        public void checkModCount() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            checkModCount();
            Iterator<E> iterator2 = iterator2();
            while (iterator2.hasNext()) {
                iterator2.next();
                iterator2.remove();
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i10) {
            rangeCheck(i10, this.size);
            checkModCount();
            return this.parent.get(i10 + this.offset);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            checkModCount();
            return this.parent.createSubListIterator(this);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int i10) {
            rangeCheck(i10, this.size + 1);
            checkModCount();
            return this.parent.createSubListListIterator(this, i10);
        }

        public void rangeCheck(int i10, int i11) {
            if (i10 < 0 || i10 >= i11) {
                throw new IndexOutOfBoundsException("Index '" + i10 + "' out of bounds for size '" + this.size + "'");
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public E remove(int i10) {
            rangeCheck(i10, this.size);
            checkModCount();
            E remove = this.parent.remove(i10 + this.offset);
            this.expectedModCount = this.parent.modCount;
            this.size--;
            this.modCount++;
            return remove;
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int i10, E e2) {
            rangeCheck(i10, this.size);
            checkModCount();
            return this.parent.set(i10 + this.offset, e2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            checkModCount();
            return this.size;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<E> subList(int i10, int i11) {
            AbstractLinkedList<E> abstractLinkedList = this.parent;
            int i12 = this.offset;
            return new LinkedSubList(abstractLinkedList, i10 + i12, i11 + i12);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i10, Collection<? extends E> collection) {
            rangeCheck(i10, this.size + 1);
            int size = collection.size();
            if (size == 0) {
                return false;
            }
            checkModCount();
            this.parent.addAll(this.offset + i10, collection);
            this.expectedModCount = this.parent.modCount;
            this.size += size;
            this.modCount++;
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class LinkedSubListIterator<E> extends LinkedListIterator<E> {
        public final LinkedSubList<E> sub;

        public LinkedSubListIterator(LinkedSubList<E> linkedSubList, int i10) {
            super(linkedSubList.parent, i10 + linkedSubList.offset);
            this.sub = linkedSubList;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public void add(E e2) {
            super.add(e2);
            LinkedSubList<E> linkedSubList = this.sub;
            linkedSubList.expectedModCount = this.parent.modCount;
            linkedSubList.size++;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return nextIndex() < this.sub.size;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public boolean hasPrevious() {
            return previousIndex() >= 0;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public int nextIndex() {
            return super.nextIndex() - this.sub.offset;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            super.remove();
            this.sub.expectedModCount = this.parent.modCount;
            r0.size--;
        }
    }

    public AbstractLinkedList() {
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        addLast(e2);
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        return addAll(this.size, collection);
    }

    public boolean addFirst(E e2) {
        addNodeAfter(this.header, e2);
        return true;
    }

    public boolean addLast(E e2) {
        addNodeBefore(this.header, e2);
        return true;
    }

    public void addNode(Node<E> node, Node<E> node2) {
        node.next = node2;
        node.previous = node2.previous;
        node2.previous.next = node;
        node2.previous = node;
        this.size++;
        this.modCount++;
    }

    public void addNodeAfter(Node<E> node, E e2) {
        addNode(createNode(e2), node.next);
    }

    public void addNodeBefore(Node<E> node, E e2) {
        addNode(createNode(e2), node);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public void clear() {
        removeAllNodes();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            if (!contains(iterator2.next())) {
                return false;
            }
        }
        return true;
    }

    public Node<E> createHeaderNode() {
        return new Node<>();
    }

    public Node<E> createNode(E e2) {
        return new Node<>(e2);
    }

    public Iterator<E> createSubListIterator(LinkedSubList<E> linkedSubList) {
        return createSubListListIterator(linkedSubList, 0);
    }

    public ListIterator<E> createSubListListIterator(LinkedSubList<E> linkedSubList, int i10) {
        return new LinkedSubListIterator(linkedSubList, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        init();
        int readInt = objectInputStream.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            add(objectInputStream.readObject());
        }
    }

    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(size());
        Iterator<E> iterator2 = iterator2();
        while (iterator2.hasNext()) {
            objectOutputStream.writeObject(iterator2.next());
        }
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        if (list.size() != size()) {
            return false;
        }
        ListIterator<E> listIterator = listIterator();
        ListIterator<E> listIterator2 = list.listIterator();
        while (listIterator.hasNext() && listIterator2.hasNext()) {
            E next = listIterator.next();
            E next2 = listIterator2.next();
            if (next == null) {
                if (next2 != null) {
                    return false;
                }
            } else if (!next.equals(next2)) {
                return false;
            }
        }
        return (listIterator.hasNext() || listIterator2.hasNext()) ? false : true;
    }

    @Override // java.util.List
    public E get(int i10) {
        return getNode(i10, false).getValue();
    }

    public E getFirst() {
        Node<E> node = this.header;
        Node<E> node2 = node.next;
        if (node2 != node) {
            return node2.getValue();
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        Node<E> node = this.header;
        Node<E> node2 = node.previous;
        if (node2 != node) {
            return node2.getValue();
        }
        throw new NoSuchElementException();
    }

    public Node<E> getNode(int i10, boolean z10) throws IndexOutOfBoundsException {
        if (i10 >= 0) {
            if (!z10 && i10 == this.size) {
                throw new IndexOutOfBoundsException("Couldn't get the node: index (" + i10 + ") is the size of the list.");
            }
            int i11 = this.size;
            if (i10 <= i11) {
                if (i10 < i11 / 2) {
                    Node<E> node = this.header.next;
                    for (int i12 = 0; i12 < i10; i12++) {
                        node = node.next;
                    }
                    return node;
                }
                Node<E> node2 = this.header;
                while (i11 > i10) {
                    node2 = node2.previous;
                    i11--;
                }
                return node2;
            }
            throw new IndexOutOfBoundsException("Couldn't get the node: index (" + i10 + ") greater than the size of the list (" + this.size + ").");
        }
        throw new IndexOutOfBoundsException("Couldn't get the node: index (" + i10 + ") less than zero.");
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public int hashCode() {
        Iterator<E> iterator2 = iterator2();
        int i10 = 1;
        while (iterator2.hasNext()) {
            E next = iterator2.next();
            i10 = (i10 * 31) + (next == null ? 0 : next.hashCode());
        }
        return i10;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        int i10 = 0;
        for (Node<E> node = this.header.next; node != this.header; node = node.next) {
            if (isEqualValue(node.getValue(), obj)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public void init() {
        this.header = createHeaderNode();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isEqualValue(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        int i10 = this.size - 1;
        Node<E> node = this.header;
        while (true) {
            node = node.previous;
            if (node == this.header) {
                return -1;
            }
            if (isEqualValue(node.getValue(), obj)) {
                return i10;
            }
            i10--;
        }
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new LinkedListIterator(this, 0);
    }

    @Override // java.util.List
    public E remove(int i10) {
        Node<E> node = getNode(i10, false);
        E value = node.getValue();
        removeNode(node);
        return value;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<E> iterator2 = iterator2();
        boolean z10 = false;
        while (iterator2.hasNext()) {
            if (collection.contains(iterator2.next())) {
                iterator2.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public void removeAllNodes() {
        Node<E> node = this.header;
        node.next = node;
        node.previous = node;
        this.size = 0;
        this.modCount++;
    }

    public E removeFirst() {
        Node<E> node = this.header;
        Node<E> node2 = node.next;
        if (node2 != node) {
            E value = node2.getValue();
            removeNode(node2);
            return value;
        }
        throw new NoSuchElementException();
    }

    public E removeLast() {
        Node<E> node = this.header;
        Node<E> node2 = node.previous;
        if (node2 != node) {
            E value = node2.getValue();
            removeNode(node2);
            return value;
        }
        throw new NoSuchElementException();
    }

    public void removeNode(Node<E> node) {
        Node<E> node2 = node.previous;
        node2.next = node.next;
        node.next.previous = node2;
        this.size--;
        this.modCount++;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        Iterator<E> iterator2 = iterator2();
        boolean z10 = false;
        while (iterator2.hasNext()) {
            if (!collection.contains(iterator2.next())) {
                iterator2.remove();
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.List
    public E set(int i10, E e2) {
        Node<E> node = getNode(i10, false);
        E value = node.getValue();
        updateNode(node, e2);
        return value;
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.List
    public List<E> subList(int i10, int i11) {
        return new LinkedSubList(this, i10, i11);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return toArray(new Object[this.size]);
    }

    public String toString() {
        if (size() == 0) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder(size() * 16);
        sb2.append('[');
        Iterator<E> iterator2 = iterator2();
        boolean hasNext = iterator2.hasNext();
        while (hasNext) {
            Object next = iterator2.next();
            if (next == this) {
                next = "(this Collection)";
            }
            sb2.append(next);
            hasNext = iterator2.hasNext();
            if (hasNext) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
        return sb2.toString();
    }

    public void updateNode(Node<E> node, E e2) {
        node.setValue(e2);
    }

    public AbstractLinkedList(Collection<? extends E> collection) {
        init();
        addAll(collection);
    }

    @Override // java.util.List
    public void add(int i10, E e2) {
        addNodeBefore(getNode(i10, true), e2);
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends E> collection) {
        Node<E> node = getNode(i10, true);
        Iterator<? extends E> iterator2 = collection.iterator2();
        while (iterator2.hasNext()) {
            addNodeBefore(node, iterator2.next());
        }
        return true;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i10) {
        return new LinkedListIterator(this, i10);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.size));
        }
        int i10 = 0;
        Node<E> node = this.header.next;
        while (node != this.header) {
            tArr[i10] = node.getValue();
            node = node.next;
            i10++;
        }
        int length = tArr.length;
        int i11 = this.size;
        if (length > i11) {
            tArr[i11] = null;
        }
        return tArr;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Node<E> {
        public Node<E> next;
        public Node<E> previous;
        public E value;

        public Node() {
            this.previous = this;
            this.next = this;
        }

        public Node<E> getNextNode() {
            return this.next;
        }

        public Node<E> getPreviousNode() {
            return this.previous;
        }

        public E getValue() {
            return this.value;
        }

        public void setNextNode(Node<E> node) {
            this.next = node;
        }

        public void setPreviousNode(Node<E> node) {
            this.previous = node;
        }

        public void setValue(E e2) {
            this.value = e2;
        }

        public Node(E e2) {
            this.value = e2;
        }

        public Node(Node<E> node, Node<E> node2, E e2) {
            this.previous = node;
            this.next = node2;
            this.value = e2;
        }
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        Node<E> node = this.header;
        do {
            node = node.next;
            if (node == this.header) {
                return false;
            }
        } while (!isEqualValue(node.getValue(), obj));
        removeNode(node);
        return true;
    }
}
