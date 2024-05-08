package com.google.common.collect;

import android.view.View;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    public static final double HASH_FLOODING_FPP = 0.001d;
    private static final int MAX_HASH_BUCKET_LENGTH = 9;
    public transient Object[] elements;
    private transient int[] entries;
    private transient int metadata;
    private transient int size;
    private transient Object table;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements Iterator<E> {

        /* renamed from: b, reason: collision with root package name */
        public int f26218b;

        /* renamed from: c, reason: collision with root package name */
        public int f26219c;

        /* renamed from: d, reason: collision with root package name */
        public int f26220d = -1;

        public a() {
            this.f26218b = CompactHashSet.this.metadata;
            this.f26219c = CompactHashSet.this.firstEntryIndex();
        }

        public final void a() {
            if (CompactHashSet.this.metadata != this.f26218b) {
                throw new ConcurrentModificationException();
            }
        }

        public void b() {
            this.f26218b += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f26219c >= 0;
        }

        @Override // java.util.Iterator
        public E next() {
            a();
            if (hasNext()) {
                int i10 = this.f26219c;
                this.f26220d = i10;
                E e2 = (E) CompactHashSet.this.element(i10);
                this.f26219c = CompactHashSet.this.getSuccessor(this.f26219c);
                return e2;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            m.e(this.f26220d >= 0);
            b();
            CompactHashSet compactHashSet = CompactHashSet.this;
            compactHashSet.remove(compactHashSet.element(this.f26220d));
            this.f26219c = CompactHashSet.this.adjustAfterRemove(this.f26219c, this.f26220d);
            this.f26220d = -1;
        }
    }

    public CompactHashSet() {
        init(3);
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
    }

    private Set<E> createHashFloodingResistantDelegate(int i10) {
        return new LinkedHashSet(i10, 1.0f);
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int i10) {
        return new CompactHashSet<>(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public E element(int i10) {
        return (E) requireElements()[i10];
    }

    private int entry(int i10) {
        return requireEntries()[i10];
    }

    private int hashTableMask() {
        return (1 << (this.metadata & 31)) - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            init(readInt);
            for (int i10 = 0; i10 < readInt; i10++) {
                add(objectInputStream.readObject());
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder(25);
        sb2.append("Invalid size: ");
        sb2.append(readInt);
        throw new InvalidObjectException(sb2.toString());
    }

    private Object[] requireElements() {
        Object[] objArr = this.elements;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private int[] requireEntries() {
        int[] iArr = this.entries;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private Object requireTable() {
        Object obj = this.table;
        Objects.requireNonNull(obj);
        return obj;
    }

    private void resizeMeMaybe(int i10) {
        int min;
        int length = requireEntries().length;
        if (i10 <= length || (min = Math.min(View.LAST_APP_AUTOFILL_ID, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        resizeEntries(min);
    }

    private int resizeTable(int i10, int i11, int i12, int i13) {
        Object a10 = o.a(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            o.i(a10, i12 & i14, i13 + 1);
        }
        Object requireTable = requireTable();
        int[] requireEntries = requireEntries();
        for (int i15 = 0; i15 <= i10; i15++) {
            int h10 = o.h(requireTable, i15);
            while (h10 != 0) {
                int i16 = h10 - 1;
                int i17 = requireEntries[i16];
                int b4 = o.b(i17, i10) | i15;
                int i18 = b4 & i14;
                int h11 = o.h(a10, i18);
                o.i(a10, i18, h10);
                requireEntries[i16] = o.d(b4, h11, i14);
                h10 = o.c(i17, i10);
            }
        }
        this.table = a10;
        setHashTableMask(i14);
        return i14;
    }

    private void setElement(int i10, E e2) {
        requireElements()[i10] = e2;
    }

    private void setEntry(int i10, int i11) {
        requireEntries()[i10] = i11;
    }

    private void setHashTableMask(int i10) {
        this.metadata = o.d(this.metadata, 32 - Integer.numberOfLeadingZeros(i10), 31);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<E> iterator2 = iterator2();
        while (iterator2.hasNext()) {
            objectOutputStream.writeObject(iterator2.next());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        if (needsAllocArrays()) {
            allocArrays();
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.add(e2);
        }
        int[] requireEntries = requireEntries();
        Object[] requireElements = requireElements();
        int i10 = this.size;
        int i11 = i10 + 1;
        int d10 = f0.d(e2);
        int hashTableMask = hashTableMask();
        int i12 = d10 & hashTableMask;
        int h10 = o.h(requireTable(), i12);
        if (h10 != 0) {
            int b4 = o.b(d10, hashTableMask);
            int i13 = 0;
            while (true) {
                int i14 = h10 - 1;
                int i15 = requireEntries[i14];
                if (o.b(i15, hashTableMask) == b4 && com.google.common.base.l.a(e2, requireElements[i14])) {
                    return false;
                }
                int c4 = o.c(i15, hashTableMask);
                i13++;
                if (c4 != 0) {
                    h10 = c4;
                } else {
                    if (i13 >= 9) {
                        return convertToHashFloodingResistantImplementation().add(e2);
                    }
                    if (i11 > hashTableMask) {
                        hashTableMask = resizeTable(hashTableMask, o.e(hashTableMask), d10, i10);
                    } else {
                        requireEntries[i14] = o.d(i15, i11, hashTableMask);
                    }
                }
            }
        } else if (i11 > hashTableMask) {
            hashTableMask = resizeTable(hashTableMask, o.e(hashTableMask), d10, i10);
        } else {
            o.i(requireTable(), i12, i11);
        }
        resizeMeMaybe(i11);
        insertEntry(i10, e2, d10, hashTableMask);
        this.size = i11;
        incrementModCount();
        return true;
    }

    public int adjustAfterRemove(int i10, int i11) {
        return i10 - 1;
    }

    public int allocArrays() {
        com.google.common.base.o.y(needsAllocArrays(), "Arrays already allocated");
        int i10 = this.metadata;
        int j10 = o.j(i10);
        this.table = o.a(j10);
        setHashTableMask(j10 - 1);
        this.entries = new int[i10];
        this.elements = new Object[i10];
        return i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        incrementModCount();
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            this.metadata = Ints.e(size(), 3, View.LAST_APP_AUTOFILL_ID);
            delegateOrNull.clear();
            this.table = null;
            this.size = 0;
            return;
        }
        Arrays.fill(requireElements(), 0, this.size, (Object) null);
        o.g(requireTable());
        Arrays.fill(requireEntries(), 0, this.size, 0);
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.contains(obj);
        }
        int d10 = f0.d(obj);
        int hashTableMask = hashTableMask();
        int h10 = o.h(requireTable(), d10 & hashTableMask);
        if (h10 == 0) {
            return false;
        }
        int b4 = o.b(d10, hashTableMask);
        do {
            int i10 = h10 - 1;
            int entry = entry(i10);
            if (o.b(entry, hashTableMask) == b4 && com.google.common.base.l.a(obj, element(i10))) {
                return true;
            }
            h10 = o.c(entry, hashTableMask);
        } while (h10 != 0);
        return false;
    }

    public Set<E> convertToHashFloodingResistantImplementation() {
        Set<E> createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(hashTableMask() + 1);
        int firstEntryIndex = firstEntryIndex();
        while (firstEntryIndex >= 0) {
            createHashFloodingResistantDelegate.add(element(firstEntryIndex));
            firstEntryIndex = getSuccessor(firstEntryIndex);
        }
        this.table = createHashFloodingResistantDelegate;
        this.entries = null;
        this.elements = null;
        incrementModCount();
        return createHashFloodingResistantDelegate;
    }

    public Set<E> delegateOrNull() {
        Object obj = this.table;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    public int getSuccessor(int i10) {
        int i11 = i10 + 1;
        if (i11 < this.size) {
            return i11;
        }
        return -1;
    }

    public void incrementModCount() {
        this.metadata += 32;
    }

    public void init(int i10) {
        com.google.common.base.o.e(i10 >= 0, "Expected size must be >= 0");
        this.metadata = Ints.e(i10, 1, View.LAST_APP_AUTOFILL_ID);
    }

    public void insertEntry(int i10, E e2, int i11, int i12) {
        setEntry(i10, o.d(i11, 0, i12));
        setElement(i10, e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isUsingHashFloodingResistance() {
        return delegateOrNull() != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.iterator2();
        }
        return new a();
    }

    public void moveLastEntry(int i10, int i11) {
        Object requireTable = requireTable();
        int[] requireEntries = requireEntries();
        Object[] requireElements = requireElements();
        int size = size() - 1;
        if (i10 < size) {
            Object obj = requireElements[size];
            requireElements[i10] = obj;
            requireElements[size] = null;
            requireEntries[i10] = requireEntries[size];
            requireEntries[size] = 0;
            int d10 = f0.d(obj) & i11;
            int h10 = o.h(requireTable, d10);
            int i12 = size + 1;
            if (h10 == i12) {
                o.i(requireTable, d10, i10 + 1);
                return;
            }
            while (true) {
                int i13 = h10 - 1;
                int i14 = requireEntries[i13];
                int c4 = o.c(i14, i11);
                if (c4 == i12) {
                    requireEntries[i13] = o.d(i14, i10 + 1, i11);
                    return;
                }
                h10 = c4;
            }
        } else {
            requireElements[i10] = null;
            requireEntries[i10] = 0;
        }
    }

    public boolean needsAllocArrays() {
        return this.table == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (needsAllocArrays()) {
            return false;
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return delegateOrNull.remove(obj);
        }
        int hashTableMask = hashTableMask();
        int f10 = o.f(obj, null, hashTableMask, requireTable(), requireEntries(), requireElements(), null);
        if (f10 == -1) {
            return false;
        }
        moveLastEntry(f10, hashTableMask);
        this.size--;
        incrementModCount();
        return true;
    }

    public void resizeEntries(int i10) {
        this.entries = Arrays.copyOf(requireEntries(), i10);
        this.elements = Arrays.copyOf(requireElements(), i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        Set<E> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.size() : this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (needsAllocArrays()) {
            return new Object[0];
        }
        Set<E> delegateOrNull = delegateOrNull();
        return delegateOrNull != null ? delegateOrNull.toArray() : Arrays.copyOf(requireElements(), this.size);
    }

    public void trimToSize() {
        if (needsAllocArrays()) {
            return;
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            Set<E> createHashFloodingResistantDelegate = createHashFloodingResistantDelegate(size());
            createHashFloodingResistantDelegate.addAll(delegateOrNull);
            this.table = createHashFloodingResistantDelegate;
            return;
        }
        int i10 = this.size;
        if (i10 < requireEntries().length) {
            resizeEntries(i10);
        }
        int j10 = o.j(i10);
        int hashTableMask = hashTableMask();
        if (j10 < hashTableMask) {
            resizeTable(hashTableMask, j10, 0, 0);
        }
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    public CompactHashSet(int i10) {
        init(i10);
    }

    @SafeVarargs
    public static <E> CompactHashSet<E> create(E... eArr) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (needsAllocArrays()) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        Set<E> delegateOrNull = delegateOrNull();
        if (delegateOrNull != null) {
            return (T[]) delegateOrNull.toArray(tArr);
        }
        return (T[]) m0.h(requireElements(), 0, this.size, tArr);
    }
}
