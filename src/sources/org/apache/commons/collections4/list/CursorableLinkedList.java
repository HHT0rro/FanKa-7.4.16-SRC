package org.apache.commons.collections4.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.list.AbstractLinkedList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class CursorableLinkedList<E> extends AbstractLinkedList<E> implements Serializable {
    private static final long serialVersionUID = 8836393098519411393L;
    private transient List<WeakReference<Cursor<E>>> cursors;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Cursor<E> extends AbstractLinkedList.LinkedListIterator<E> {
        public boolean currentRemovedByAnother;
        public boolean nextIndexValid;
        public boolean valid;

        public Cursor(CursorableLinkedList<E> cursorableLinkedList, int i10) {
            super(cursorableLinkedList, i10);
            this.nextIndexValid = true;
            this.currentRemovedByAnother = false;
            this.valid = true;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public void add(E e2) {
            super.add(e2);
            this.next = this.next.next;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator
        public void checkModCount() {
            if (!this.valid) {
                throw new ConcurrentModificationException("Cursor closed");
            }
        }

        public void close() {
            if (this.valid) {
                ((CursorableLinkedList) this.parent).unregisterCursor(this);
                this.valid = false;
            }
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ boolean hasNext() {
            return super.hasNext();
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ boolean hasPrevious() {
            return super.hasPrevious();
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return super.next();
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public int nextIndex() {
            if (!this.nextIndexValid) {
                AbstractLinkedList.Node<E> node = this.next;
                AbstractLinkedList<E> abstractLinkedList = this.parent;
                AbstractLinkedList.Node<E> node2 = abstractLinkedList.header;
                if (node == node2) {
                    this.nextIndex = abstractLinkedList.size();
                } else {
                    int i10 = 0;
                    for (AbstractLinkedList.Node<E> node3 = node2.next; node3 != this.next; node3 = node3.next) {
                        i10++;
                    }
                    this.nextIndex = i10;
                }
                this.nextIndexValid = true;
            }
            return this.nextIndex;
        }

        public void nodeChanged(AbstractLinkedList.Node<E> node) {
        }

        public void nodeInserted(AbstractLinkedList.Node<E> node) {
            if (node.previous == this.current) {
                this.next = node;
            } else if (this.next.previous == node) {
                this.next = node;
            } else {
                this.nextIndexValid = false;
            }
        }

        public void nodeRemoved(AbstractLinkedList.Node<E> node) {
            AbstractLinkedList.Node<E> node2 = this.next;
            if (node == node2 && node == this.current) {
                this.next = node.next;
                this.current = null;
                this.currentRemovedByAnother = true;
            } else if (node == node2) {
                this.next = node.next;
                this.currentRemovedByAnother = false;
            } else if (node == this.current) {
                this.current = null;
                this.currentRemovedByAnother = true;
                this.nextIndex--;
            } else {
                this.nextIndexValid = false;
                this.currentRemovedByAnother = false;
            }
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ Object previous() {
            return super.previous();
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ int previousIndex() {
            return super.previousIndex();
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            if (this.current != null || !this.currentRemovedByAnother) {
                checkModCount();
                this.parent.removeNode(getLastNodeReturned());
            }
            this.currentRemovedByAnother = false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            super.set(obj);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class SubCursor<E> extends Cursor<E> {
        public final AbstractLinkedList.LinkedSubList<E> sub;

        public SubCursor(AbstractLinkedList.LinkedSubList<E> linkedSubList, int i10) {
            super((CursorableLinkedList) linkedSubList.parent, i10 + linkedSubList.offset);
            this.sub = linkedSubList;
        }

        @Override // org.apache.commons.collections4.list.CursorableLinkedList.Cursor, org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public void add(E e2) {
            super.add(e2);
            AbstractLinkedList.LinkedSubList<E> linkedSubList = this.sub;
            linkedSubList.expectedModCount = this.parent.modCount;
            linkedSubList.size++;
        }

        @Override // org.apache.commons.collections4.list.CursorableLinkedList.Cursor, org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return nextIndex() < this.sub.size;
        }

        @Override // org.apache.commons.collections4.list.CursorableLinkedList.Cursor, org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public boolean hasPrevious() {
            return previousIndex() >= 0;
        }

        @Override // org.apache.commons.collections4.list.CursorableLinkedList.Cursor, org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public int nextIndex() {
            return super.nextIndex() - this.sub.offset;
        }

        @Override // org.apache.commons.collections4.list.CursorableLinkedList.Cursor, org.apache.commons.collections4.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            super.remove();
            this.sub.expectedModCount = this.parent.modCount;
            r0.size--;
        }
    }

    public CursorableLinkedList() {
        init();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    public void addNode(AbstractLinkedList.Node<E> node, AbstractLinkedList.Node<E> node2) {
        super.addNode(node, node2);
        broadcastNodeInserted(node);
    }

    public void broadcastNodeChanged(AbstractLinkedList.Node<E> node) {
        Iterator<WeakReference<Cursor<E>>> iterator2 = this.cursors.iterator2();
        while (iterator2.hasNext()) {
            Cursor<E> cursor = iterator2.next().get();
            if (cursor == null) {
                iterator2.remove();
            } else {
                cursor.nodeChanged(node);
            }
        }
    }

    public void broadcastNodeInserted(AbstractLinkedList.Node<E> node) {
        Iterator<WeakReference<Cursor<E>>> iterator2 = this.cursors.iterator2();
        while (iterator2.hasNext()) {
            Cursor<E> cursor = iterator2.next().get();
            if (cursor == null) {
                iterator2.remove();
            } else {
                cursor.nodeInserted(node);
            }
        }
    }

    public void broadcastNodeRemoved(AbstractLinkedList.Node<E> node) {
        Iterator<WeakReference<Cursor<E>>> iterator2 = this.cursors.iterator2();
        while (iterator2.hasNext()) {
            Cursor<E> cursor = iterator2.next().get();
            if (cursor == null) {
                iterator2.remove();
            } else {
                cursor.nodeRemoved(node);
            }
        }
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    public ListIterator<E> createSubListListIterator(AbstractLinkedList.LinkedSubList<E> linkedSubList, int i10) {
        SubCursor subCursor = new SubCursor(linkedSubList, i10);
        registerCursor(subCursor);
        return subCursor;
    }

    public Cursor<E> cursor() {
        return cursor(0);
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    public void init() {
        super.init();
        this.cursors = new ArrayList();
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList, java.util.List, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return super.listIterator(0);
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList, java.util.List
    public ListIterator<E> listIterator() {
        return cursor(0);
    }

    public void registerCursor(Cursor<E> cursor) {
        Iterator<WeakReference<Cursor<E>>> iterator2 = this.cursors.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().get() == null) {
                iterator2.remove();
            }
        }
        this.cursors.add(new WeakReference<>(cursor));
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    public void removeAllNodes() {
        if (size() > 0) {
            Iterator<E> iterator2 = iterator2();
            while (iterator2.hasNext()) {
                iterator2.next();
                iterator2.remove();
            }
        }
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    public void removeNode(AbstractLinkedList.Node<E> node) {
        super.removeNode(node);
        broadcastNodeRemoved(node);
    }

    public void unregisterCursor(Cursor<E> cursor) {
        Iterator<WeakReference<Cursor<E>>> iterator2 = this.cursors.iterator2();
        while (iterator2.hasNext()) {
            WeakReference<Cursor<E>> next = iterator2.next();
            Cursor<E> cursor2 = next.get();
            if (cursor2 == null) {
                iterator2.remove();
            } else if (cursor2 == cursor) {
                next.clear();
                iterator2.remove();
                return;
            }
        }
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    public void updateNode(AbstractLinkedList.Node<E> node, E e2) {
        super.updateNode(node, e2);
        broadcastNodeChanged(node);
    }

    public Cursor<E> cursor(int i10) {
        Cursor<E> cursor = new Cursor<>(this, i10);
        registerCursor(cursor);
        return cursor;
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList, java.util.List
    public ListIterator<E> listIterator(int i10) {
        return cursor(i10);
    }

    public CursorableLinkedList(Collection<? extends E> collection) {
        super(collection);
    }
}
