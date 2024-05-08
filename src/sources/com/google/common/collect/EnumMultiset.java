package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.k0;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class EnumMultiset<E extends Enum<E>> extends d<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private transient int[] counts;
    private transient int distinctElements;
    private transient E[] enumConstants;
    private transient long size;
    private transient Class<E> type;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends EnumMultiset<E>.c<E> {
        public a() {
            super();
        }

        @Override // com.google.common.collect.EnumMultiset.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public E a(int i10) {
            return (E) EnumMultiset.this.enumConstants[i10];
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends EnumMultiset<E>.c<k0.a<E>> {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends Multisets.b<E> {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f26236b;

            public a(int i10) {
                this.f26236b = i10;
            }

            @Override // com.google.common.collect.k0.a
            public int getCount() {
                return EnumMultiset.this.counts[this.f26236b];
            }

            @Override // com.google.common.collect.k0.a
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public E getElement() {
                return (E) EnumMultiset.this.enumConstants[this.f26236b];
            }
        }

        public b() {
            super();
        }

        @Override // com.google.common.collect.EnumMultiset.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public k0.a<E> a(int i10) {
            return new a(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public abstract class c<T> implements Iterator<T> {

        /* renamed from: b, reason: collision with root package name */
        public int f26238b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f26239c = -1;

        public c() {
        }

        public abstract T a(int i10);

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (this.f26238b < EnumMultiset.this.enumConstants.length) {
                int[] iArr = EnumMultiset.this.counts;
                int i10 = this.f26238b;
                if (iArr[i10] > 0) {
                    return true;
                }
                this.f26238b = i10 + 1;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T a10 = a(this.f26238b);
                int i10 = this.f26238b;
                this.f26239c = i10;
                this.f26238b = i10 + 1;
                return a10;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            m.e(this.f26239c >= 0);
            if (EnumMultiset.this.counts[this.f26239c] > 0) {
                EnumMultiset.access$210(EnumMultiset.this);
                EnumMultiset.access$322(EnumMultiset.this, r0.counts[this.f26239c]);
                EnumMultiset.this.counts[this.f26239c] = 0;
            }
            this.f26239c = -1;
        }
    }

    private EnumMultiset(Class<E> cls) {
        this.type = cls;
        com.google.common.base.o.d(cls.isEnum());
        E[] enumConstants = cls.getEnumConstants();
        this.enumConstants = enumConstants;
        this.counts = new int[enumConstants.length];
    }

    public static /* synthetic */ int access$210(EnumMultiset enumMultiset) {
        int i10 = enumMultiset.distinctElements;
        enumMultiset.distinctElements = i10 - 1;
        return i10;
    }

    public static /* synthetic */ long access$322(EnumMultiset enumMultiset, long j10) {
        long j11 = enumMultiset.size - j10;
        enumMultiset.size = j11;
        return j11;
    }

    private void checkIsE(Object obj) {
        com.google.common.base.o.r(obj);
        if (isActuallyE(obj)) {
            return;
        }
        String valueOf = String.valueOf(this.type);
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 21 + valueOf2.length());
        sb2.append("Expected an ");
        sb2.append(valueOf);
        sb2.append(" but got ");
        sb2.append(valueOf2);
        throw new ClassCastException(sb2.toString());
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> cls) {
        return new EnumMultiset<>(cls);
    }

    private boolean isActuallyE(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r52 = (Enum) obj;
        int ordinal = r52.ordinal();
        E[] eArr = this.enumConstants;
        return ordinal < eArr.length && eArr[ordinal] == r52;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Class<E> cls = (Class) objectInputStream.readObject();
        this.type = cls;
        E[] enumConstants = cls.getEnumConstants();
        this.enumConstants = enumConstants;
        this.counts = new int[enumConstants.length];
        v0.f(this, objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.type);
        v0.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        Arrays.fill(this.counts, 0);
        this.size = 0L;
        this.distinctElements = 0;
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.k0
    public int count(Object obj) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        return this.counts[((Enum) obj).ordinal()];
    }

    @Override // com.google.common.collect.d
    public int distinctElements() {
        return this.distinctElements;
    }

    @Override // com.google.common.collect.d
    public Iterator<E> elementIterator() {
        return new a();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.d
    public Iterator<k0.a<E>> entryIterator() {
        return new b();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return Multisets.i(this);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public int remove(Object obj, int i10) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        Enum r12 = (Enum) obj;
        m.b(i10, "occurrences");
        if (i10 == 0) {
            return count(obj);
        }
        int ordinal = r12.ordinal();
        int[] iArr = this.counts;
        int i11 = iArr[ordinal];
        if (i11 == 0) {
            return 0;
        }
        if (i11 <= i10) {
            iArr[ordinal] = 0;
            this.distinctElements--;
            this.size -= i11;
        } else {
            iArr[ordinal] = i11 - i10;
            this.size -= i10;
        }
        return i11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return Ints.l(this.size);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable) {
        Iterator<E> iterator2 = iterable.iterator2();
        com.google.common.base.o.e(iterator2.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> enumMultiset = new EnumMultiset<>(iterator2.next().getDeclaringClass());
        g0.a(enumMultiset, iterable);
        return enumMultiset;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public int add(E e2, int i10) {
        checkIsE(e2);
        m.b(i10, "occurrences");
        if (i10 == 0) {
            return count(e2);
        }
        int ordinal = e2.ordinal();
        int i11 = this.counts[ordinal];
        long j10 = i10;
        long j11 = i11 + j10;
        com.google.common.base.o.j(j11 <= ZipUtils.UPPER_UNIXTIME_BOUND, "too many occurrences: %s", j11);
        this.counts[ordinal] = (int) j11;
        if (i11 == 0) {
            this.distinctElements++;
        }
        this.size += j10;
        return i11;
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public /* bridge */ /* synthetic */ boolean setCount(Object obj, int i10, int i11) {
        return super.setCount(obj, i10, i11);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.k0
    public int setCount(E e2, int i10) {
        checkIsE(e2);
        m.b(i10, "count");
        int ordinal = e2.ordinal();
        int[] iArr = this.counts;
        int i11 = iArr[ordinal];
        iArr[ordinal] = i10;
        this.size += i10 - i11;
        if (i11 == 0 && i10 > 0) {
            this.distinctElements++;
        } else if (i11 > 0 && i10 == 0) {
            this.distinctElements--;
        }
        return i11;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable, Class<E> cls) {
        EnumMultiset<E> create = create(cls);
        g0.a(create, iterable);
        return create;
    }
}
