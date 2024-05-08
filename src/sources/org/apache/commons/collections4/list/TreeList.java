package org.apache.commons.collections4.list;

import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.OrderedIterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class TreeList<E> extends AbstractList<E> {
    private AVLNode<E> root;
    private int size;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class TreeListIterator<E> implements ListIterator<E>, OrderedIterator<E> {
        private AVLNode<E> current;
        private int currentIndex;
        private int expectedModCount;
        private AVLNode<E> next;
        private int nextIndex;
        private final TreeList<E> parent;

        public TreeListIterator(TreeList<E> treeList, int i10) throws IndexOutOfBoundsException {
            this.parent = treeList;
            this.expectedModCount = ((AbstractList) treeList).modCount;
            this.next = ((TreeList) treeList).root == null ? null : ((TreeList) treeList).root.get(i10);
            this.nextIndex = i10;
            this.currentIndex = -1;
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            checkModCount();
            this.parent.add(this.nextIndex, e2);
            this.current = null;
            this.currentIndex = -1;
            this.nextIndex++;
            this.expectedModCount++;
        }

        public void checkModCount() {
            if (((AbstractList) this.parent).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.nextIndex < this.parent.size();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.nextIndex > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            checkModCount();
            if (hasNext()) {
                if (this.next == null) {
                    this.next = ((TreeList) this.parent).root.get(this.nextIndex);
                }
                E value = this.next.getValue();
                AVLNode<E> aVLNode = this.next;
                this.current = aVLNode;
                int i10 = this.nextIndex;
                this.nextIndex = i10 + 1;
                this.currentIndex = i10;
                this.next = aVLNode.next();
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
                AVLNode<E> aVLNode = this.next;
                if (aVLNode == null) {
                    this.next = ((TreeList) this.parent).root.get(this.nextIndex - 1);
                } else {
                    this.next = aVLNode.previous();
                }
                E value = this.next.getValue();
                this.current = this.next;
                int i10 = this.nextIndex - 1;
                this.nextIndex = i10;
                this.currentIndex = i10;
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
            int i10 = this.currentIndex;
            if (i10 != -1) {
                this.parent.remove(i10);
                int i11 = this.nextIndex;
                if (i11 != this.currentIndex) {
                    this.nextIndex = i11 - 1;
                }
                this.next = null;
                this.current = null;
                this.currentIndex = -1;
                this.expectedModCount++;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            checkModCount();
            AVLNode<E> aVLNode = this.current;
            if (aVLNode != null) {
                aVLNode.setValue(e2);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public TreeList() {
    }

    private void checkInterval(int i10, int i11, int i12) {
        if (i10 < i11 || i10 > i12) {
            throw new IndexOutOfBoundsException("Invalid index:" + i10 + ", size=" + size());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, E e2) {
        this.modCount++;
        checkInterval(i10, 0, size());
        AVLNode<E> aVLNode = this.root;
        if (aVLNode == null) {
            this.root = new AVLNode<>(i10, e2, null, null);
        } else {
            this.root = aVLNode.insert(i10, e2);
        }
        this.size++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        this.modCount += collection.size();
        AVLNode<E> aVLNode = new AVLNode<>(collection);
        AVLNode<E> aVLNode2 = this.root;
        if (aVLNode2 != null) {
            aVLNode = aVLNode2.addAll(aVLNode, this.size);
        }
        this.root = aVLNode;
        this.size += collection.size();
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.modCount++;
        this.root = null;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i10) {
        checkInterval(i10, 0, size() - 1);
        return this.root.get(i10).getValue();
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        AVLNode<E> aVLNode = this.root;
        if (aVLNode == null) {
            return -1;
        }
        return aVLNode.indexOf(obj, ((AVLNode) aVLNode).relativePosition);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i10) {
        this.modCount++;
        checkInterval(i10, 0, size() - 1);
        E e2 = get(i10);
        this.root = this.root.remove(i10);
        this.size--;
        return e2;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i10, E e2) {
        checkInterval(i10, 0, size() - 1);
        AVLNode<E> aVLNode = this.root.get(i10);
        E e10 = (E) ((AVLNode) aVLNode).value;
        aVLNode.setValue(e2);
        return e10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        AVLNode<E> aVLNode = this.root;
        if (aVLNode != null) {
            aVLNode.toArray(objArr, ((AVLNode) aVLNode).relativePosition);
        }
        return objArr;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class AVLNode<E> {
        private int height;
        private AVLNode<E> left;
        private boolean leftIsPrevious;
        private int relativePosition;
        private AVLNode<E> right;
        private boolean rightIsNext;
        private E value;

        /* JADX INFO: Access modifiers changed from: private */
        public AVLNode<E> addAll(AVLNode<E> aVLNode, int i10) {
            AVLNode<E> max = max();
            AVLNode<E> min = aVLNode.min();
            if (aVLNode.height > this.height) {
                AVLNode<E> removeMax = removeMax();
                ArrayDeque arrayDeque = new ArrayDeque();
                AVLNode<E> aVLNode2 = aVLNode;
                int i11 = aVLNode.relativePosition + i10;
                int i12 = 0;
                while (aVLNode2 != null && aVLNode2.height > getHeight(removeMax)) {
                    arrayDeque.push(aVLNode2);
                    aVLNode2 = aVLNode2.left;
                    if (aVLNode2 != null) {
                        i12 = i11;
                        i11 = aVLNode2.relativePosition + i11;
                    } else {
                        i12 = i11;
                    }
                }
                max.setLeft(removeMax, null);
                max.setRight(aVLNode2, min);
                if (removeMax != null) {
                    removeMax.max().setRight(null, max);
                    removeMax.relativePosition -= i10 - 1;
                }
                if (aVLNode2 != null) {
                    aVLNode2.min().setLeft(null, max);
                    aVLNode2.relativePosition = (i11 - i10) + 1;
                }
                max.relativePosition = (i10 - 1) - i12;
                aVLNode.relativePosition += i10;
                while (!arrayDeque.isEmpty()) {
                    AVLNode aVLNode3 = (AVLNode) arrayDeque.pop();
                    aVLNode3.setLeft(max, null);
                    max = aVLNode3.balance();
                }
                return max;
            }
            AVLNode<E> removeMin = aVLNode.removeMin();
            ArrayDeque arrayDeque2 = new ArrayDeque();
            AVLNode<E> aVLNode4 = this;
            int i13 = this.relativePosition;
            int i14 = 0;
            while (aVLNode4 != null && aVLNode4.height > getHeight(removeMin)) {
                arrayDeque2.push(aVLNode4);
                aVLNode4 = aVLNode4.right;
                if (aVLNode4 != null) {
                    int i15 = i13;
                    i13 = aVLNode4.relativePosition + i13;
                    i14 = i15;
                } else {
                    i14 = i13;
                }
            }
            min.setRight(removeMin, null);
            min.setLeft(aVLNode4, max);
            if (removeMin != null) {
                removeMin.min().setLeft(null, min);
                removeMin.relativePosition++;
            }
            if (aVLNode4 != null) {
                aVLNode4.max().setRight(null, min);
                aVLNode4.relativePosition = i13 - i10;
            }
            min.relativePosition = i10 - i14;
            while (!arrayDeque2.isEmpty()) {
                AVLNode aVLNode5 = (AVLNode) arrayDeque2.pop();
                aVLNode5.setRight(min, null);
                min = aVLNode5.balance();
            }
            return min;
        }

        private AVLNode<E> balance() {
            int heightRightMinusLeft = heightRightMinusLeft();
            if (heightRightMinusLeft == -2) {
                if (this.left.heightRightMinusLeft() > 0) {
                    setLeft(this.left.rotateLeft(), null);
                }
                return rotateRight();
            }
            if (heightRightMinusLeft == -1 || heightRightMinusLeft == 0 || heightRightMinusLeft == 1) {
                return this;
            }
            if (heightRightMinusLeft == 2) {
                if (this.right.heightRightMinusLeft() < 0) {
                    setRight(this.right.rotateRight(), null);
                }
                return rotateLeft();
            }
            throw new RuntimeException("tree inconsistent!");
        }

        private int getHeight(AVLNode<E> aVLNode) {
            if (aVLNode == null) {
                return -1;
            }
            return aVLNode.height;
        }

        private AVLNode<E> getLeftSubTree() {
            if (this.leftIsPrevious) {
                return null;
            }
            return this.left;
        }

        private int getOffset(AVLNode<E> aVLNode) {
            if (aVLNode == null) {
                return 0;
            }
            return aVLNode.relativePosition;
        }

        private AVLNode<E> getRightSubTree() {
            if (this.rightIsNext) {
                return null;
            }
            return this.right;
        }

        private int heightRightMinusLeft() {
            return getHeight(getRightSubTree()) - getHeight(getLeftSubTree());
        }

        private AVLNode<E> insertOnLeft(int i10, E e2) {
            if (getLeftSubTree() == null) {
                setLeft(new AVLNode<>(-1, e2, this, this.left), null);
            } else {
                setLeft(this.left.insert(i10, e2), null);
            }
            int i11 = this.relativePosition;
            if (i11 >= 0) {
                this.relativePosition = i11 + 1;
            }
            AVLNode<E> balance = balance();
            recalcHeight();
            return balance;
        }

        private AVLNode<E> insertOnRight(int i10, E e2) {
            if (getRightSubTree() == null) {
                setRight(new AVLNode<>(1, e2, this.right, this), null);
            } else {
                setRight(this.right.insert(i10, e2), null);
            }
            int i11 = this.relativePosition;
            if (i11 < 0) {
                this.relativePosition = i11 - 1;
            }
            AVLNode<E> balance = balance();
            recalcHeight();
            return balance;
        }

        private AVLNode<E> max() {
            return getRightSubTree() == null ? this : this.right.max();
        }

        private AVLNode<E> min() {
            return getLeftSubTree() == null ? this : this.left.min();
        }

        private void recalcHeight() {
            this.height = Math.max(getLeftSubTree() == null ? -1 : getLeftSubTree().height, getRightSubTree() != null ? getRightSubTree().height : -1) + 1;
        }

        private AVLNode<E> removeMax() {
            if (getRightSubTree() == null) {
                return removeSelf();
            }
            setRight(this.right.removeMax(), this.right.right);
            int i10 = this.relativePosition;
            if (i10 < 0) {
                this.relativePosition = i10 + 1;
            }
            recalcHeight();
            return balance();
        }

        private AVLNode<E> removeMin() {
            if (getLeftSubTree() == null) {
                return removeSelf();
            }
            setLeft(this.left.removeMin(), this.left.left);
            int i10 = this.relativePosition;
            if (i10 > 0) {
                this.relativePosition = i10 - 1;
            }
            recalcHeight();
            return balance();
        }

        private AVLNode<E> removeSelf() {
            if (getRightSubTree() == null && getLeftSubTree() == null) {
                return null;
            }
            if (getRightSubTree() == null) {
                int i10 = this.relativePosition;
                if (i10 > 0) {
                    this.left.relativePosition += i10;
                }
                this.left.max().setRight(null, this.right);
                return this.left;
            }
            if (getLeftSubTree() == null) {
                AVLNode<E> aVLNode = this.right;
                int i11 = aVLNode.relativePosition;
                int i12 = this.relativePosition;
                aVLNode.relativePosition = i11 + (i12 - (i12 < 0 ? 0 : 1));
                aVLNode.min().setLeft(null, this.left);
                return this.right;
            }
            if (heightRightMinusLeft() > 0) {
                AVLNode<E> min = this.right.min();
                this.value = min.value;
                if (this.leftIsPrevious) {
                    this.left = min.left;
                }
                this.right = this.right.removeMin();
                int i13 = this.relativePosition;
                if (i13 < 0) {
                    this.relativePosition = i13 + 1;
                }
            } else {
                AVLNode<E> max = this.left.max();
                this.value = max.value;
                if (this.rightIsNext) {
                    this.right = max.right;
                }
                AVLNode<E> aVLNode2 = this.left;
                AVLNode<E> aVLNode3 = aVLNode2.left;
                AVLNode<E> removeMax = aVLNode2.removeMax();
                this.left = removeMax;
                if (removeMax == null) {
                    this.left = aVLNode3;
                    this.leftIsPrevious = true;
                }
                int i14 = this.relativePosition;
                if (i14 > 0) {
                    this.relativePosition = i14 - 1;
                }
            }
            recalcHeight();
            return this;
        }

        private AVLNode<E> rotateLeft() {
            AVLNode<E> aVLNode = this.right;
            AVLNode<E> leftSubTree = getRightSubTree().getLeftSubTree();
            int offset = this.relativePosition + getOffset(aVLNode);
            int i10 = -aVLNode.relativePosition;
            int offset2 = getOffset(aVLNode) + getOffset(leftSubTree);
            setRight(leftSubTree, aVLNode);
            aVLNode.setLeft(this, null);
            setOffset(aVLNode, offset);
            setOffset(this, i10);
            setOffset(leftSubTree, offset2);
            return aVLNode;
        }

        private AVLNode<E> rotateRight() {
            AVLNode<E> aVLNode = this.left;
            AVLNode<E> rightSubTree = getLeftSubTree().getRightSubTree();
            int offset = this.relativePosition + getOffset(aVLNode);
            int i10 = -aVLNode.relativePosition;
            int offset2 = getOffset(aVLNode) + getOffset(rightSubTree);
            setLeft(rightSubTree, aVLNode);
            aVLNode.setRight(this, null);
            setOffset(aVLNode, offset);
            setOffset(this, i10);
            setOffset(rightSubTree, offset2);
            return aVLNode;
        }

        private void setLeft(AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            boolean z10 = aVLNode == null;
            this.leftIsPrevious = z10;
            if (z10) {
                aVLNode = aVLNode2;
            }
            this.left = aVLNode;
            recalcHeight();
        }

        private int setOffset(AVLNode<E> aVLNode, int i10) {
            if (aVLNode == null) {
                return 0;
            }
            int offset = getOffset(aVLNode);
            aVLNode.relativePosition = i10;
            return offset;
        }

        private void setRight(AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            boolean z10 = aVLNode == null;
            this.rightIsNext = z10;
            if (z10) {
                aVLNode = aVLNode2;
            }
            this.right = aVLNode;
            recalcHeight();
        }

        public AVLNode<E> get(int i10) {
            int i11 = i10 - this.relativePosition;
            if (i11 == 0) {
                return this;
            }
            AVLNode<E> leftSubTree = i11 < 0 ? getLeftSubTree() : getRightSubTree();
            if (leftSubTree == null) {
                return null;
            }
            return leftSubTree.get(i11);
        }

        public E getValue() {
            return this.value;
        }

        public int indexOf(Object obj, int i10) {
            if (getLeftSubTree() != null) {
                AVLNode<E> aVLNode = this.left;
                int indexOf = aVLNode.indexOf(obj, aVLNode.relativePosition + i10);
                if (indexOf != -1) {
                    return indexOf;
                }
            }
            E e2 = this.value;
            if (e2 != null ? e2.equals(obj) : e2 == obj) {
                return i10;
            }
            if (getRightSubTree() == null) {
                return -1;
            }
            AVLNode<E> aVLNode2 = this.right;
            return aVLNode2.indexOf(obj, i10 + aVLNode2.relativePosition);
        }

        public AVLNode<E> insert(int i10, E e2) {
            int i11 = i10 - this.relativePosition;
            if (i11 <= 0) {
                return insertOnLeft(i11, e2);
            }
            return insertOnRight(i11, e2);
        }

        public AVLNode<E> next() {
            AVLNode<E> aVLNode;
            if (!this.rightIsNext && (aVLNode = this.right) != null) {
                return aVLNode.min();
            }
            return this.right;
        }

        public AVLNode<E> previous() {
            AVLNode<E> aVLNode;
            if (!this.leftIsPrevious && (aVLNode = this.left) != null) {
                return aVLNode.max();
            }
            return this.left;
        }

        public AVLNode<E> remove(int i10) {
            int i11 = i10 - this.relativePosition;
            if (i11 == 0) {
                return removeSelf();
            }
            if (i11 > 0) {
                setRight(this.right.remove(i11), this.right.right);
                int i12 = this.relativePosition;
                if (i12 < 0) {
                    this.relativePosition = i12 + 1;
                }
            } else {
                setLeft(this.left.remove(i11), this.left.left);
                int i13 = this.relativePosition;
                if (i13 > 0) {
                    this.relativePosition = i13 - 1;
                }
            }
            recalcHeight();
            return balance();
        }

        public void setValue(E e2) {
            this.value = e2;
        }

        public void toArray(Object[] objArr, int i10) {
            objArr[i10] = this.value;
            if (getLeftSubTree() != null) {
                AVLNode<E> aVLNode = this.left;
                aVLNode.toArray(objArr, aVLNode.relativePosition + i10);
            }
            if (getRightSubTree() != null) {
                AVLNode<E> aVLNode2 = this.right;
                aVLNode2.toArray(objArr, i10 + aVLNode2.relativePosition);
            }
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AVLNode(");
            sb2.append(this.relativePosition);
            sb2.append(',');
            sb2.append(this.left != null);
            sb2.append(',');
            sb2.append((Object) this.value);
            sb2.append(',');
            sb2.append(getRightSubTree() != null);
            sb2.append(", faedelung ");
            sb2.append(this.rightIsNext);
            sb2.append(" )");
            return sb2.toString();
        }

        private AVLNode(int i10, E e2, AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            this.relativePosition = i10;
            this.value = e2;
            this.rightIsNext = true;
            this.leftIsPrevious = true;
            this.right = aVLNode;
            this.left = aVLNode2;
        }

        private AVLNode(Collection<? extends E> collection) {
            this(collection.iterator2(), 0, collection.size() - 1, 0, null, null);
        }

        private AVLNode(Iterator<? extends E> it, int i10, int i11, int i12, AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            int i13 = i10 + ((i11 - i10) / 2);
            if (i10 < i13) {
                this.left = new AVLNode<>(it, i10, i13 - 1, i13, aVLNode, this);
            } else {
                this.leftIsPrevious = true;
                this.left = aVLNode;
            }
            this.value = it.next();
            this.relativePosition = i13 - i12;
            if (i13 < i11) {
                this.right = new AVLNode<>(it, i13 + 1, i11, i13, this, aVLNode2);
            } else {
                this.rightIsNext = true;
                this.right = aVLNode2;
            }
            recalcHeight();
        }
    }

    public TreeList(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return;
        }
        this.root = new AVLNode<>(collection);
        this.size = collection.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i10) {
        checkInterval(i10, 0, size());
        return new TreeListIterator(this, i10);
    }
}
