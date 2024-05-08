package org.greenrobot.greendao.query;

import android.database.Cursor;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.InternalQueryDaoAccess;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class LazyList<E> implements List<E>, Closeable {
    private final Cursor cursor;
    private final InternalQueryDaoAccess<E> daoAccess;
    private final List<E> entities;
    private volatile int loadedCount;
    private final ReentrantLock lock;
    private final int size;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class LazyIterator implements CloseableListIterator<E> {
        private final boolean closeWhenDone;
        private int index;

        public LazyIterator(int i10, boolean z10) {
            this.index = i10;
            this.closeWhenDone = z10;
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            LazyList.this.close();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.index < LazyList.this.size;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.index < LazyList.this.size) {
                E e2 = (E) LazyList.this.get(this.index);
                int i10 = this.index + 1;
                this.index = i10;
                if (i10 == LazyList.this.size && this.closeWhenDone) {
                    close();
                }
                return e2;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i10 = this.index;
            if (i10 > 0) {
                int i11 = i10 - 1;
                this.index = i11;
                return (E) LazyList.this.get(i11);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.index - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            throw new UnsupportedOperationException();
        }
    }

    public LazyList(InternalQueryDaoAccess<E> internalQueryDaoAccess, Cursor cursor, boolean z10) {
        this.cursor = cursor;
        this.daoAccess = internalQueryDaoAccess;
        int count = cursor.getCount();
        this.size = count;
        if (z10) {
            this.entities = new ArrayList(count);
            for (int i10 = 0; i10 < this.size; i10++) {
                this.entities.add(null);
            }
        } else {
            this.entities = null;
        }
        if (this.size == 0) {
            cursor.close();
        }
        this.lock = new ReentrantLock();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public void checkCached() {
        if (this.entities == null) {
            throw new DaoException("This operation only works with cached lazy lists");
        }
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.cursor.close();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        loadRemaining();
        return this.entities.contains(obj);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        loadRemaining();
        return this.entities.containsAll(collection);
    }

    @Override // java.util.List
    public E get(int i10) {
        List<E> list = this.entities;
        if (list != null) {
            E e2 = list.get(i10);
            if (e2 == null) {
                this.lock.lock();
                try {
                    e2 = this.entities.get(i10);
                    if (e2 == null) {
                        e2 = loadEntity(i10);
                        this.entities.set(i10, e2);
                        this.loadedCount++;
                        if (this.loadedCount == this.size) {
                            this.cursor.close();
                        }
                    }
                } finally {
                }
            }
            return e2;
        }
        this.lock.lock();
        try {
            return loadEntity(i10);
        } finally {
        }
    }

    public int getLoadedCount() {
        return this.loadedCount;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        loadRemaining();
        return this.entities.indexOf(obj);
    }

    public boolean isClosed() {
        return this.cursor.isClosed();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isLoadedCompletely() {
        return this.loadedCount == this.size;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return new LazyIterator(0, false);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        loadRemaining();
        return this.entities.lastIndexOf(obj);
    }

    public CloseableListIterator<E> listIteratorAutoClose() {
        return new LazyIterator(0, true);
    }

    public E loadEntity(int i10) {
        if (this.cursor.moveToPosition(i10)) {
            E loadCurrent = this.daoAccess.loadCurrent(this.cursor, 0, true);
            if (loadCurrent != null) {
                return loadCurrent;
            }
            throw new DaoException("Loading of entity failed (null) at position " + i10);
        }
        throw new DaoException("Could not move to cursor location " + i10);
    }

    public void loadRemaining() {
        checkCached();
        int size = this.entities.size();
        for (int i10 = 0; i10 < size; i10++) {
            get(i10);
        }
    }

    public E peek(int i10) {
        List<E> list = this.entities;
        if (list != null) {
            return list.get(i10);
        }
        return null;
    }

    @Override // java.util.List
    public E remove(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public E set(int i10, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public int size() {
        return this.size;
    }

    @Override // java.util.List
    public List<E> subList(int i10, int i11) {
        checkCached();
        for (int i12 = i10; i12 < i11; i12++) {
            get(i12);
        }
        return this.entities.subList(i10, i11);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public Object[] toArray() {
        loadRemaining();
        return this.entities.toArray();
    }

    @Override // java.util.List
    public void add(int i10, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public CloseableListIterator<E> listIterator() {
        return new LazyIterator(0, false);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i10) {
        return new LazyIterator(i10, false);
    }

    @Override // java.util.List, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        loadRemaining();
        return (T[]) this.entities.toArray(tArr);
    }
}
