package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    public static final int MAX_TABLE_SIZE = 1073741824;
    private transient ImmutableList<E> asList;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        public final Object[] elements;

        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class a<E> extends ImmutableCollection.a<E> {

        /* renamed from: d, reason: collision with root package name */
        public Object[] f26300d;

        /* renamed from: e, reason: collision with root package name */
        public int f26301e;

        public a() {
            super(4);
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public a<E> a(E e2) {
            com.google.common.base.o.r(e2);
            if (this.f26300d != null && ImmutableSet.chooseTableSize(this.f26258b) <= this.f26300d.length) {
                l(e2);
                return this;
            }
            this.f26300d = null;
            super.f(e2);
            return this;
        }

        public a<E> j(E... eArr) {
            if (this.f26300d != null) {
                for (E e2 : eArr) {
                    a(e2);
                }
            } else {
                super.b(eArr);
            }
            return this;
        }

        public a<E> k(Iterator<? extends E> it) {
            com.google.common.base.o.r(it);
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public final void l(E e2) {
            Objects.requireNonNull(this.f26300d);
            int length = this.f26300d.length - 1;
            int hashCode = e2.hashCode();
            int c4 = f0.c(hashCode);
            while (true) {
                int i10 = c4 & length;
                Object[] objArr = this.f26300d;
                Object obj = objArr[i10];
                if (obj == null) {
                    objArr[i10] = e2;
                    this.f26301e += hashCode;
                    super.f(e2);
                    return;
                } else if (obj.equals(e2)) {
                    return;
                } else {
                    c4 = i10 + 1;
                }
            }
        }

        public ImmutableSet<E> m() {
            ImmutableSet<E> construct;
            int i10 = this.f26258b;
            if (i10 == 0) {
                return ImmutableSet.of();
            }
            if (i10 != 1) {
                if (this.f26300d != null && ImmutableSet.chooseTableSize(i10) == this.f26300d.length) {
                    Object[] copyOf = ImmutableSet.shouldTrim(this.f26258b, this.f26257a.length) ? Arrays.copyOf(this.f26257a, this.f26258b) : this.f26257a;
                    construct = new RegularImmutableSet<>(copyOf, this.f26301e, this.f26300d, r5.length - 1, this.f26258b);
                } else {
                    construct = ImmutableSet.construct(this.f26258b, this.f26257a);
                    this.f26258b = construct.size();
                }
                this.f26259c = true;
                this.f26300d = null;
                return construct;
            }
            Object obj = this.f26257a[0];
            Objects.requireNonNull(obj);
            return ImmutableSet.of(obj);
        }

        public a(int i10) {
            super(i10);
            this.f26300d = new Object[ImmutableSet.chooseTableSize(i10)];
        }
    }

    public static <E> a<E> builder() {
        return new a<>();
    }

    public static <E> a<E> builderWithExpectedSize(int i10) {
        m.b(i10, "expectedSize");
        return new a<>(i10);
    }

    public static int chooseTableSize(int i10) {
        int max = Math.max(i10, 2);
        if (max < CUTOFF) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (highestOneBit * DESIRED_LOAD_FACTOR < max) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        com.google.common.base.o.e(max < 1073741824, "collection too large");
        return 1073741824;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ImmutableSet<E> construct(int i10, Object... objArr) {
        if (i10 == 0) {
            return of();
        }
        if (i10 != 1) {
            int chooseTableSize = chooseTableSize(i10);
            Object[] objArr2 = new Object[chooseTableSize];
            int i11 = chooseTableSize - 1;
            int i12 = 0;
            int i13 = 0;
            for (int i14 = 0; i14 < i10; i14++) {
                Object a10 = m0.a(objArr[i14], i14);
                int hashCode = a10.hashCode();
                int c4 = f0.c(hashCode);
                while (true) {
                    int i15 = c4 & i11;
                    Object obj = objArr2[i15];
                    if (obj == null) {
                        objArr[i13] = a10;
                        objArr2[i15] = a10;
                        i12 += hashCode;
                        i13++;
                        break;
                    }
                    if (obj.equals(a10)) {
                        break;
                    }
                    c4++;
                }
            }
            Arrays.fill(objArr, i13, i10, (Object) null);
            if (i13 == 1) {
                Object obj2 = objArr[0];
                Objects.requireNonNull(obj2);
                return new SingletonImmutableSet(obj2);
            }
            if (chooseTableSize(i13) < chooseTableSize / 2) {
                return construct(i13, objArr);
            }
            if (shouldTrim(i13, objArr.length)) {
                objArr = Arrays.copyOf(objArr, i13);
            }
            return new RegularImmutableSet(objArr, i12, objArr2, i11, i13);
        }
        Object obj3 = objArr[0];
        Objects.requireNonNull(obj3);
        return of(obj3);
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldTrim(int i10, int i11) {
        return i10 < (i11 >> 1) + (i11 >> 2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> createAsList = createAsList();
        this.asList = createAsList;
        return createAsList;
    }

    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.b(this);
    }

    public boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public abstract i1<E> iterator2();

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableSet<E> of(E e2) {
        return new SingletonImmutableSet(e2);
    }

    public static <E> ImmutableSet<E> of(E e2, E e10) {
        return construct(2, e2, e10);
    }

    public static <E> ImmutableSet<E> of(E e2, E e10, E e11) {
        return construct(3, e2, e10, e11);
    }

    public static <E> ImmutableSet<E> of(E e2, E e10, E e11, E e12) {
        return construct(4, e2, e10, e11, e12);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator2());
    }

    public static <E> ImmutableSet<E> of(E e2, E e10, E e11, E e12, E e13) {
        return construct(5, e2, e10, e11, e12, e13);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e2, E e10, E e11, E e12, E e13, E e14, E... eArr) {
        com.google.common.base.o.e(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e2;
        objArr[1] = e10;
        objArr[2] = e11;
        objArr[3] = e12;
        objArr[4] = e13;
        objArr[5] = e14;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return construct(length, objArr);
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new a().a(next).k(it).m();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return construct(eArr.length, (Object[]) eArr.clone());
        }
        return of((Object) eArr[0]);
    }
}
