package com.android.framework.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {
    public static final LazyStringList EMPTY;
    private static final LazyStringArrayList EMPTY_LIST;
    private final List<Object> list;

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add((LazyStringArrayList) obj);
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, com.android.framework.protobuf.Internal.ProtobufList
    public /* bridge */ /* synthetic */ boolean isModifiable() {
        return super.isModifiable();
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    static {
        LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
        EMPTY_LIST = lazyStringArrayList;
        lazyStringArrayList.makeImmutable();
        EMPTY = lazyStringArrayList;
    }

    static LazyStringArrayList emptyList() {
        return EMPTY_LIST;
    }

    public LazyStringArrayList() {
        this(10);
    }

    public LazyStringArrayList(int initialCapacity) {
        this((ArrayList<Object>) new ArrayList(initialCapacity));
    }

    public LazyStringArrayList(LazyStringList from) {
        this.list = new ArrayList(from.size());
        addAll(from);
    }

    public LazyStringArrayList(List<String> from) {
        this((ArrayList<Object>) new ArrayList(from));
    }

    private LazyStringArrayList(ArrayList<Object> list) {
        this.list = list;
    }

    @Override // com.android.framework.protobuf.Internal.ProtobufList, com.android.framework.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public LazyStringArrayList mutableCopyWithCapacity2(int capacity) {
        if (capacity < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList<Object> newList = new ArrayList<>(capacity);
        newList.addAll(this.list);
        return new LazyStringArrayList(newList);
    }

    @Override // java.util.AbstractList, java.util.List
    public String get(int index) {
        Object o10 = this.list.get(index);
        if (o10 instanceof String) {
            return (String) o10;
        }
        if (o10 instanceof ByteString) {
            ByteString bs = (ByteString) o10;
            String s2 = bs.toStringUtf8();
            if (bs.isValidUtf8()) {
                this.list.set(index, s2);
            }
            return s2;
        }
        byte[] ba2 = (byte[]) o10;
        String s10 = Internal.toStringUtf8(ba2);
        if (Internal.isValidUtf8(ba2)) {
            this.list.set(index, s10);
        }
        return s10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.list.size();
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public String set(int index, String s2) {
        ensureIsMutable();
        Object o10 = this.list.set(index, s2);
        return asString(o10);
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int index, String element) {
        ensureIsMutable();
        this.list.add(index, element);
        this.modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void add(int index, ByteString element) {
        ensureIsMutable();
        this.list.add(index, element);
        this.modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void add(int index, byte[] element) {
        ensureIsMutable();
        this.list.add(index, element);
        this.modCount++;
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends String> c4) {
        return addAll(size(), c4);
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends String> c4) {
        ensureIsMutable();
        boolean ret = this.list.addAll(index, c4 instanceof LazyStringList ? ((LazyStringList) c4).getUnderlyingElements() : c4);
        this.modCount++;
        return ret;
    }

    @Override // com.android.framework.protobuf.LazyStringList
    public boolean addAllByteString(Collection<? extends ByteString> values) {
        ensureIsMutable();
        boolean ret = this.list.addAll(values);
        this.modCount++;
        return ret;
    }

    @Override // com.android.framework.protobuf.LazyStringList
    public boolean addAllByteArray(Collection<byte[]> c4) {
        ensureIsMutable();
        boolean ret = this.list.addAll(c4);
        this.modCount++;
        return ret;
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public String remove(int index) {
        ensureIsMutable();
        Object o10 = this.list.remove(index);
        this.modCount++;
        return asString(o10);
    }

    @Override // com.android.framework.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        ensureIsMutable();
        this.list.clear();
        this.modCount++;
    }

    @Override // com.android.framework.protobuf.LazyStringList
    public void add(ByteString element) {
        ensureIsMutable();
        this.list.add(element);
        this.modCount++;
    }

    @Override // com.android.framework.protobuf.LazyStringList
    public void add(byte[] element) {
        ensureIsMutable();
        this.list.add(element);
        this.modCount++;
    }

    @Override // com.android.framework.protobuf.LazyStringList
    public Object getRaw(int index) {
        return this.list.get(index);
    }

    @Override // com.android.framework.protobuf.LazyStringList
    public ByteString getByteString(int index) {
        Object o10 = this.list.get(index);
        ByteString b4 = asByteString(o10);
        if (b4 != o10) {
            this.list.set(index, b4);
        }
        return b4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.framework.protobuf.LazyStringList
    public byte[] getByteArray(int index) {
        Object o10 = this.list.get(index);
        byte[] asByteArray = asByteArray(o10);
        if (asByteArray != o10) {
            this.list.set(index, asByteArray);
        }
        return asByteArray;
    }

    @Override // com.android.framework.protobuf.LazyStringList
    public void set(int index, ByteString s2) {
        setAndReturn(index, s2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object setAndReturn(int index, ByteString s2) {
        ensureIsMutable();
        return this.list.set(index, s2);
    }

    @Override // com.android.framework.protobuf.LazyStringList
    public void set(int index, byte[] s2) {
        setAndReturn(index, s2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object setAndReturn(int index, byte[] s2) {
        ensureIsMutable();
        return this.list.set(index, s2);
    }

    private static String asString(Object o10) {
        if (o10 instanceof String) {
            return (String) o10;
        }
        if (o10 instanceof ByteString) {
            return ((ByteString) o10).toStringUtf8();
        }
        return Internal.toStringUtf8((byte[]) o10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteString asByteString(Object o10) {
        if (o10 instanceof ByteString) {
            return (ByteString) o10;
        }
        if (o10 instanceof String) {
            return ByteString.copyFromUtf8((String) o10);
        }
        return ByteString.copyFrom((byte[]) o10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] asByteArray(Object o10) {
        if (o10 instanceof byte[]) {
            return (byte[]) o10;
        }
        if (o10 instanceof String) {
            return Internal.toByteArray((String) o10);
        }
        return ((ByteString) o10).toByteArray();
    }

    @Override // com.android.framework.protobuf.LazyStringList
    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.list);
    }

    @Override // com.android.framework.protobuf.LazyStringList
    public void mergeFrom(LazyStringList other) {
        ensureIsMutable();
        for (Object o10 : other.getUnderlyingElements()) {
            if (o10 instanceof byte[]) {
                byte[] b4 = (byte[]) o10;
                this.list.add(Arrays.copyOf(b4, b4.length));
            } else {
                this.list.add(o10);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {
        private final LazyStringArrayList list;

        ByteArrayListView(LazyStringArrayList list) {
            this.list = list;
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] get(int index) {
            return this.list.getByteArray(index);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.list.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] set(int index, byte[] s2) {
            Object o10 = this.list.setAndReturn(index, s2);
            this.modCount++;
            return LazyStringArrayList.asByteArray(o10);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int index, byte[] s2) {
            this.list.add(index, s2);
            this.modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public byte[] remove(int index) {
            Object o10 = this.list.remove(index);
            this.modCount++;
            return LazyStringArrayList.asByteArray(o10);
        }
    }

    @Override // com.android.framework.protobuf.LazyStringList
    public List<byte[]> asByteArrayList() {
        return new ByteArrayListView(this);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {
        private final LazyStringArrayList list;

        ByteStringListView(LazyStringArrayList list) {
            this.list = list;
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString get(int index) {
            return this.list.getByteString(index);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.list.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString set(int index, ByteString s2) {
            Object o10 = this.list.setAndReturn(index, s2);
            this.modCount++;
            return LazyStringArrayList.asByteString(o10);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int index, ByteString s2) {
            this.list.add(index, s2);
            this.modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        public ByteString remove(int index) {
            Object o10 = this.list.remove(index);
            this.modCount++;
            return LazyStringArrayList.asByteString(o10);
        }
    }

    @Override // com.android.framework.protobuf.ProtocolStringList
    public List<ByteString> asByteStringList() {
        return new ByteStringListView(this);
    }

    @Override // com.android.framework.protobuf.LazyStringList
    public LazyStringList getUnmodifiableView() {
        if (isModifiable()) {
            return new UnmodifiableLazyStringList(this);
        }
        return this;
    }
}
