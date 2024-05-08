package com.google.common.collect;

import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class LinkedListMultimap<K, V> extends com.google.common.collect.c<K, V> implements i0<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    private transient g<K, V> head;
    private transient Map<K, f<K, V>> keyToKeyList;
    private transient int modCount;
    private transient int size;
    private transient g<K, V> tail;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends AbstractSequentialList<V> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f26347b;

        public a(Object obj) {
            this.f26347b = obj;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i10) {
            return new i(this.f26347b, i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(this.f26347b);
            if (fVar == null) {
                return 0;
            }
            return fVar.f26360c;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends AbstractSequentialList<Map.Entry<K, V>> {
        public b() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<Map.Entry<K, V>> listIterator(int i10) {
            return new h(i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c extends Sets.b<K> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedListMultimap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<K> iterator2() {
            return new e(LinkedListMultimap.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return !LinkedListMultimap.this.removeAll(obj).isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedListMultimap.this.keyToKeyList.size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class d extends AbstractSequentialList<V> {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends g1<Map.Entry<K, V>, V> {

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ h f26352c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, ListIterator listIterator, h hVar) {
                super(listIterator);
                this.f26352c = hVar;
            }

            @Override // com.google.common.collect.f1
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public V a(Map.Entry<K, V> entry) {
                return entry.getValue();
            }

            @Override // com.google.common.collect.g1, java.util.ListIterator
            public void set(V v2) {
                this.f26352c.f(v2);
            }
        }

        public d() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i10) {
            h hVar = new h(i10);
            return new a(this, hVar, hVar);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class f<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public g<K, V> f26358a;

        /* renamed from: b, reason: collision with root package name */
        public g<K, V> f26359b;

        /* renamed from: c, reason: collision with root package name */
        public int f26360c;

        public f(g<K, V> gVar) {
            this.f26358a = gVar;
            this.f26359b = gVar;
            gVar.f26366g = null;
            gVar.f26365f = null;
            this.f26360c = 1;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class g<K, V> extends com.google.common.collect.b<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final K f26361b;

        /* renamed from: c, reason: collision with root package name */
        public V f26362c;

        /* renamed from: d, reason: collision with root package name */
        public g<K, V> f26363d;

        /* renamed from: e, reason: collision with root package name */
        public g<K, V> f26364e;

        /* renamed from: f, reason: collision with root package name */
        public g<K, V> f26365f;

        /* renamed from: g, reason: collision with root package name */
        public g<K, V> f26366g;

        public g(K k10, V v2) {
            this.f26361b = k10;
            this.f26362c = v2;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public K getKey() {
            return this.f26361b;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V getValue() {
            return this.f26362c;
        }

        @Override // com.google.common.collect.b, java.util.Map.Entry
        public V setValue(V v2) {
            V v10 = this.f26362c;
            this.f26362c = v2;
            return v10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class h implements ListIterator<Map.Entry<K, V>> {

        /* renamed from: b, reason: collision with root package name */
        public int f26367b;

        /* renamed from: c, reason: collision with root package name */
        public g<K, V> f26368c;

        /* renamed from: d, reason: collision with root package name */
        public g<K, V> f26369d;

        /* renamed from: e, reason: collision with root package name */
        public g<K, V> f26370e;

        /* renamed from: f, reason: collision with root package name */
        public int f26371f;

        public h(int i10) {
            this.f26371f = LinkedListMultimap.this.modCount;
            int size = LinkedListMultimap.this.size();
            com.google.common.base.o.u(i10, size);
            if (i10 >= size / 2) {
                this.f26370e = LinkedListMultimap.this.tail;
                this.f26367b = size;
                while (true) {
                    int i11 = i10 + 1;
                    if (i10 >= size) {
                        break;
                    }
                    previous();
                    i10 = i11;
                }
            } else {
                this.f26368c = LinkedListMultimap.this.head;
                while (true) {
                    int i12 = i10 - 1;
                    if (i10 <= 0) {
                        break;
                    }
                    next();
                    i10 = i12;
                }
            }
            this.f26369d = null;
        }

        @Override // java.util.ListIterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public final void b() {
            if (LinkedListMultimap.this.modCount != this.f26371f) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public g<K, V> next() {
            b();
            g<K, V> gVar = this.f26368c;
            if (gVar != null) {
                this.f26369d = gVar;
                this.f26370e = gVar;
                this.f26368c = gVar.f26363d;
                this.f26367b++;
                return gVar;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public g<K, V> previous() {
            b();
            g<K, V> gVar = this.f26370e;
            if (gVar != null) {
                this.f26369d = gVar;
                this.f26368c = gVar;
                this.f26370e = gVar.f26364e;
                this.f26367b--;
                return gVar;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void set(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public void f(V v2) {
            com.google.common.base.o.x(this.f26369d != null);
            this.f26369d.f26362c = v2;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            b();
            return this.f26368c != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            b();
            return this.f26370e != null;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f26367b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f26367b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            b();
            com.google.common.base.o.y(this.f26369d != null, "no calls to next() since the last call to remove()");
            g<K, V> gVar = this.f26369d;
            if (gVar != this.f26368c) {
                this.f26370e = gVar.f26364e;
                this.f26367b--;
            } else {
                this.f26368c = gVar.f26363d;
            }
            LinkedListMultimap.this.removeNode(gVar);
            this.f26369d = null;
            this.f26371f = LinkedListMultimap.this.modCount;
        }
    }

    public LinkedListMultimap() {
        this(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g<K, V> addNode(K k10, V v2, g<K, V> gVar) {
        g<K, V> gVar2 = new g<>(k10, v2);
        if (this.head == null) {
            this.tail = gVar2;
            this.head = gVar2;
            this.keyToKeyList.put(k10, new f<>(gVar2));
            this.modCount++;
        } else if (gVar == null) {
            g<K, V> gVar3 = this.tail;
            Objects.requireNonNull(gVar3);
            gVar3.f26363d = gVar2;
            gVar2.f26364e = this.tail;
            this.tail = gVar2;
            f<K, V> fVar = this.keyToKeyList.get(k10);
            if (fVar == null) {
                this.keyToKeyList.put(k10, new f<>(gVar2));
                this.modCount++;
            } else {
                fVar.f26360c++;
                g<K, V> gVar4 = fVar.f26359b;
                gVar4.f26365f = gVar2;
                gVar2.f26366g = gVar4;
                fVar.f26359b = gVar2;
            }
        } else {
            f<K, V> fVar2 = this.keyToKeyList.get(k10);
            Objects.requireNonNull(fVar2);
            fVar2.f26360c++;
            gVar2.f26364e = gVar.f26364e;
            gVar2.f26366g = gVar.f26366g;
            gVar2.f26363d = gVar;
            gVar2.f26365f = gVar;
            g<K, V> gVar5 = gVar.f26366g;
            if (gVar5 == null) {
                fVar2.f26358a = gVar2;
            } else {
                gVar5.f26365f = gVar2;
            }
            g<K, V> gVar6 = gVar.f26364e;
            if (gVar6 == null) {
                this.head = gVar2;
            } else {
                gVar6.f26363d = gVar2;
            }
            gVar.f26364e = gVar2;
            gVar.f26366g = gVar2;
        }
        this.size++;
        return gVar2;
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    private List<V> getCopy(K k10) {
        return Collections.unmodifiableList(Lists.l(new i(k10)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyToKeyList = CompactLinkedHashMap.create();
        int readInt = objectInputStream.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllNodes(K k10) {
        Iterators.d(new i(k10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeNode(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f26364e;
        if (gVar2 != null) {
            gVar2.f26363d = gVar.f26363d;
        } else {
            this.head = gVar.f26363d;
        }
        g<K, V> gVar3 = gVar.f26363d;
        if (gVar3 != null) {
            gVar3.f26364e = gVar2;
        } else {
            this.tail = gVar2;
        }
        if (gVar.f26366g == null && gVar.f26365f == null) {
            f<K, V> remove = this.keyToKeyList.remove(gVar.f26361b);
            Objects.requireNonNull(remove);
            remove.f26360c = 0;
            this.modCount++;
        } else {
            f<K, V> fVar = this.keyToKeyList.get(gVar.f26361b);
            Objects.requireNonNull(fVar);
            fVar.f26360c--;
            g<K, V> gVar4 = gVar.f26366g;
            if (gVar4 == null) {
                g<K, V> gVar5 = gVar.f26365f;
                Objects.requireNonNull(gVar5);
                fVar.f26358a = gVar5;
            } else {
                gVar4.f26365f = gVar.f26365f;
            }
            g<K, V> gVar6 = gVar.f26365f;
            if (gVar6 == null) {
                g<K, V> gVar7 = gVar.f26366g;
                Objects.requireNonNull(gVar7);
                fVar.f26359b = gVar7;
            } else {
                gVar6.f26366g = gVar.f26366g;
            }
        }
        this.size--;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.j0
    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.j0
    public boolean containsKey(Object obj) {
        return this.keyToKeyList.containsKey(obj);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.c
    public Map<K, Collection<V>> createAsMap() {
        return new Multimaps.a(this);
    }

    @Override // com.google.common.collect.c
    public Set<K> createKeySet() {
        return new c();
    }

    @Override // com.google.common.collect.c
    public k0<K> createKeys() {
        return new Multimaps.c(this);
    }

    @Override // com.google.common.collect.c
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError((Object) "should never be called");
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.j0
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((LinkedListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public /* bridge */ /* synthetic */ k0 keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public boolean put(K k10, V v2) {
        addNode(k10, v2, null);
        return true;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public /* bridge */ /* synthetic */ boolean putAll(j0 j0Var) {
        return super.putAll(j0Var);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((LinkedListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.j0
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    private LinkedListMultimap(int i10) {
        this.keyToKeyList = q0.c(i10);
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i10) {
        return new LinkedListMultimap<>(i10);
    }

    @Override // com.google.common.collect.c
    public List<Map.Entry<K, V>> createEntries() {
        return new b();
    }

    @Override // com.google.common.collect.c
    public List<V> createValues() {
        return new d();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    @Override // com.google.common.collect.j0
    public List<V> get(K k10) {
        return new a(k10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.j0
    public List<V> removeAll(Object obj) {
        List<V> copy = getCopy(obj);
        removeAllNodes(obj);
        return copy;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public List<V> replaceValues(K k10, Iterable<? extends V> iterable) {
        List<V> copy = getCopy(k10);
        i iVar = new i(k10);
        Iterator<? extends V> iterator2 = iterable.iterator2();
        while (iVar.hasNext() && iterator2.hasNext()) {
            iVar.next();
            iVar.set(iterator2.next());
        }
        while (iVar.hasNext()) {
            iVar.next();
            iVar.remove();
        }
        while (iterator2.hasNext()) {
            iVar.add(iterator2.next());
        }
        return copy;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.j0
    public List<V> values() {
        return (List) super.values();
    }

    public static <K, V> LinkedListMultimap<K, V> create(j0<? extends K, ? extends V> j0Var) {
        return new LinkedListMultimap<>(j0Var);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class e implements Iterator<K> {

        /* renamed from: b, reason: collision with root package name */
        public final Set<K> f26353b;

        /* renamed from: c, reason: collision with root package name */
        public g<K, V> f26354c;

        /* renamed from: d, reason: collision with root package name */
        public g<K, V> f26355d;

        /* renamed from: e, reason: collision with root package name */
        public int f26356e;

        public e() {
            this.f26353b = Sets.e(LinkedListMultimap.this.keySet().size());
            this.f26354c = LinkedListMultimap.this.head;
            this.f26356e = LinkedListMultimap.this.modCount;
        }

        public final void a() {
            if (LinkedListMultimap.this.modCount != this.f26356e) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f26354c != null;
        }

        @Override // java.util.Iterator
        public K next() {
            g<K, V> gVar;
            a();
            g<K, V> gVar2 = this.f26354c;
            if (gVar2 != null) {
                this.f26355d = gVar2;
                this.f26353b.add(gVar2.f26361b);
                do {
                    gVar = this.f26354c.f26363d;
                    this.f26354c = gVar;
                    if (gVar == null) {
                        break;
                    }
                } while (!this.f26353b.add(gVar.f26361b));
                return this.f26355d.f26361b;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            com.google.common.base.o.y(this.f26355d != null, "no calls to next() since the last call to remove()");
            LinkedListMultimap.this.removeAllNodes(this.f26355d.f26361b);
            this.f26355d = null;
            this.f26356e = LinkedListMultimap.this.modCount;
        }

        public /* synthetic */ e(LinkedListMultimap linkedListMultimap, a aVar) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class i implements ListIterator<V> {

        /* renamed from: b, reason: collision with root package name */
        public final K f26373b;

        /* renamed from: c, reason: collision with root package name */
        public int f26374c;

        /* renamed from: d, reason: collision with root package name */
        public g<K, V> f26375d;

        /* renamed from: e, reason: collision with root package name */
        public g<K, V> f26376e;

        /* renamed from: f, reason: collision with root package name */
        public g<K, V> f26377f;

        public i(K k10) {
            this.f26373b = k10;
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(k10);
            this.f26375d = fVar == null ? null : fVar.f26358a;
        }

        @Override // java.util.ListIterator
        public void add(V v2) {
            this.f26377f = LinkedListMultimap.this.addNode(this.f26373b, v2, this.f26375d);
            this.f26374c++;
            this.f26376e = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f26375d != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f26377f != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public V next() {
            g<K, V> gVar = this.f26375d;
            if (gVar != null) {
                this.f26376e = gVar;
                this.f26377f = gVar;
                this.f26375d = gVar.f26365f;
                this.f26374c++;
                return gVar.f26362c;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f26374c;
        }

        @Override // java.util.ListIterator
        public V previous() {
            g<K, V> gVar = this.f26377f;
            if (gVar != null) {
                this.f26376e = gVar;
                this.f26375d = gVar;
                this.f26377f = gVar.f26366g;
                this.f26374c--;
                return gVar.f26362c;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f26374c - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            com.google.common.base.o.y(this.f26376e != null, "no calls to next() since the last call to remove()");
            g<K, V> gVar = this.f26376e;
            if (gVar != this.f26375d) {
                this.f26377f = gVar.f26366g;
                this.f26374c--;
            } else {
                this.f26375d = gVar.f26365f;
            }
            LinkedListMultimap.this.removeNode(gVar);
            this.f26376e = null;
        }

        @Override // java.util.ListIterator
        public void set(V v2) {
            com.google.common.base.o.x(this.f26376e != null);
            this.f26376e.f26362c = v2;
        }

        public i(K k10, int i10) {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(k10);
            int i11 = fVar == null ? 0 : fVar.f26360c;
            com.google.common.base.o.u(i10, i11);
            if (i10 >= i11 / 2) {
                this.f26377f = fVar == null ? null : fVar.f26359b;
                this.f26374c = i11;
                while (true) {
                    int i12 = i10 + 1;
                    if (i10 >= i11) {
                        break;
                    }
                    previous();
                    i10 = i12;
                }
            } else {
                this.f26375d = fVar == null ? null : fVar.f26358a;
                while (true) {
                    int i13 = i10 - 1;
                    if (i10 <= 0) {
                        break;
                    }
                    next();
                    i10 = i13;
                }
            }
            this.f26373b = k10;
            this.f26376e = null;
        }
    }

    private LinkedListMultimap(j0<? extends K, ? extends V> j0Var) {
        this(j0Var.keySet().size());
        putAll(j0Var);
    }
}
