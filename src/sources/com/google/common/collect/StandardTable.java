package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.d1;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class StandardTable<R, C, V> extends com.google.common.collect.i<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    public final Map<R, Map<C, V>> backingMap;
    private transient Set<C> columnKeySet;
    private transient StandardTable<R, C, V>.f columnMap;
    public final com.google.common.base.t<? extends Map<C, V>> factory;
    private transient Map<R, Map<C, V>> rowMap;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b implements Iterator<d1.a<R, C, V>> {

        /* renamed from: b, reason: collision with root package name */
        public final Iterator<Map.Entry<R, Map<C, V>>> f26473b;

        /* renamed from: c, reason: collision with root package name */
        public Map.Entry<R, Map<C, V>> f26474c;

        /* renamed from: d, reason: collision with root package name */
        public Iterator<Map.Entry<C, V>> f26475d;

        public b() {
            this.f26473b = StandardTable.this.backingMap.entrySet().iterator2();
            this.f26475d = Iterators.j();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d1.a<R, C, V> next() {
            if (!this.f26475d.hasNext()) {
                Map.Entry<R, Map<C, V>> next = this.f26473b.next();
                this.f26474c = next;
                this.f26475d = next.getValue().entrySet().iterator2();
            }
            Objects.requireNonNull(this.f26474c);
            Map.Entry<C, V> next2 = this.f26475d.next();
            return Tables.c(this.f26474c.getKey(), next2.getKey(), next2.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f26473b.hasNext() || this.f26475d.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f26475d.remove();
            Map.Entry<R, Map<C, V>> entry = this.f26474c;
            Objects.requireNonNull(entry);
            if (entry.getValue().isEmpty()) {
                this.f26473b.remove();
                this.f26474c = null;
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c extends Maps.u<R, V> {

        /* renamed from: e, reason: collision with root package name */
        public final C f26477e;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends Sets.b<Map.Entry<R, V>> {
            public a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                c.this.d(Predicates.b());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return StandardTable.this.containsMapping(entry.getKey(), c.this.f26477e, entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                c cVar = c.this;
                return !StandardTable.this.containsColumn(cVar.f26477e);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<Map.Entry<R, V>> iterator2() {
                return new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return StandardTable.this.removeMapping(entry.getKey(), c.this.f26477e, entry.getValue());
            }

            @Override // com.google.common.collect.Sets.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(Predicates.g(Predicates.e(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                Iterator<Map<C, V>> iterator2 = StandardTable.this.backingMap.values().iterator2();
                int i10 = 0;
                while (iterator2.hasNext()) {
                    if (iterator2.next().containsKey(c.this.f26477e)) {
                        i10++;
                    }
                }
                return i10;
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class b extends AbstractIterator<Map.Entry<R, V>> {

            /* renamed from: d, reason: collision with root package name */
            public final Iterator<Map.Entry<R, Map<C, V>>> f26480d;

            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
            public class a extends com.google.common.collect.b<R, V> {

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ Map.Entry f26482b;

                public a(Map.Entry entry) {
                    this.f26482b = entry;
                }

                @Override // com.google.common.collect.b, java.util.Map.Entry
                public R getKey() {
                    return (R) this.f26482b.getKey();
                }

                @Override // com.google.common.collect.b, java.util.Map.Entry
                public V getValue() {
                    return (V) ((Map) this.f26482b.getValue()).get(c.this.f26477e);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.b, java.util.Map.Entry
                public V setValue(V v2) {
                    return (V) l0.a(((Map) this.f26482b.getValue()).put(c.this.f26477e, com.google.common.base.o.r(v2)));
                }
            }

            public b() {
                this.f26480d = StandardTable.this.backingMap.entrySet().iterator2();
            }

            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<R, V> a() {
                while (this.f26480d.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = this.f26480d.next();
                    if (next.getValue().containsKey(c.this.f26477e)) {
                        return new a(next);
                    }
                }
                return b();
            }
        }

        /* renamed from: com.google.common.collect.StandardTable$c$c, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class C0233c extends Maps.m<R, V> {
            public C0233c() {
                super(c.this);
            }

            @Override // com.google.common.collect.Maps.m, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                c cVar = c.this;
                return StandardTable.this.contains(obj, cVar.f26477e);
            }

            @Override // com.google.common.collect.Maps.m, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                c cVar = c.this;
                return StandardTable.this.remove(obj, cVar.f26477e) != null;
            }

            @Override // com.google.common.collect.Sets.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(Maps.o(Predicates.g(Predicates.e(collection))));
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class d extends Maps.t<R, V> {
            public d() {
                super(c.this);
            }

            @Override // com.google.common.collect.Maps.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                return obj != null && c.this.d(Maps.N(Predicates.d(obj)));
            }

            @Override // com.google.common.collect.Maps.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return c.this.d(Maps.N(Predicates.e(collection)));
            }

            @Override // com.google.common.collect.Maps.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(Maps.N(Predicates.g(Predicates.e(collection))));
            }
        }

        public c(C c4) {
            this.f26477e = (C) com.google.common.base.o.r(c4);
        }

        @Override // com.google.common.collect.Maps.u
        public Set<Map.Entry<R, V>> a() {
            return new a();
        }

        @Override // com.google.common.collect.Maps.u
        /* renamed from: b */
        public Set<R> g() {
            return new C0233c();
        }

        @Override // com.google.common.collect.Maps.u
        public Collection<V> c() {
            return new d();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.contains(obj, this.f26477e);
        }

        public boolean d(com.google.common.base.p<? super Map.Entry<R, V>> pVar) {
            Iterator<Map.Entry<R, Map<C, V>>> iterator2 = StandardTable.this.backingMap.entrySet().iterator2();
            boolean z10 = false;
            while (iterator2.hasNext()) {
                Map.Entry<R, Map<C, V>> next = iterator2.next();
                Map<C, V> value = next.getValue();
                V v2 = value.get(this.f26477e);
                if (v2 != null && pVar.apply(Maps.j(next.getKey(), v2))) {
                    value.remove(this.f26477e);
                    z10 = true;
                    if (value.isEmpty()) {
                        iterator2.remove();
                    }
                }
            }
            return z10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            return (V) StandardTable.this.get(obj, this.f26477e);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(R r10, V v2) {
            return (V) StandardTable.this.put(r10, this.f26477e, v2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            return (V) StandardTable.this.remove(obj, this.f26477e);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class d extends AbstractIterator<C> {

        /* renamed from: d, reason: collision with root package name */
        public final Map<C, V> f26486d;

        /* renamed from: e, reason: collision with root package name */
        public final Iterator<Map<C, V>> f26487e;

        /* renamed from: f, reason: collision with root package name */
        public Iterator<Map.Entry<C, V>> f26488f;

        public d() {
            this.f26486d = StandardTable.this.factory.get();
            this.f26487e = StandardTable.this.backingMap.values().iterator2();
            this.f26488f = Iterators.h();
        }

        @Override // com.google.common.collect.AbstractIterator
        public C a() {
            while (true) {
                if (this.f26488f.hasNext()) {
                    Map.Entry<C, V> next = this.f26488f.next();
                    if (!this.f26486d.containsKey(next.getKey())) {
                        this.f26486d.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else if (this.f26487e.hasNext()) {
                    this.f26488f = this.f26487e.next().entrySet().iterator2();
                } else {
                    return b();
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class e extends StandardTable<R, C, V>.i<C> {
        public e() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<C> iterator2() {
            return StandardTable.this.createColumnKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean z10 = false;
            if (obj == null) {
                return false;
            }
            Iterator<Map<C, V>> iterator2 = StandardTable.this.backingMap.values().iterator2();
            while (iterator2.hasNext()) {
                Map<C, V> next = iterator2.next();
                if (next.h().remove(obj)) {
                    z10 = true;
                    if (next.isEmpty()) {
                        iterator2.remove();
                    }
                }
            }
            return z10;
        }

        @Override // com.google.common.collect.Sets.b, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            com.google.common.base.o.r(collection);
            Iterator<Map<C, V>> iterator2 = StandardTable.this.backingMap.values().iterator2();
            boolean z10 = false;
            while (iterator2.hasNext()) {
                Map<C, V> next = iterator2.next();
                if (Iterators.s(next.h().iterator2(), collection)) {
                    z10 = true;
                    if (next.isEmpty()) {
                        iterator2.remove();
                    }
                }
            }
            return z10;
        }

        @Override // com.google.common.collect.Sets.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            com.google.common.base.o.r(collection);
            Iterator<Map<C, V>> iterator2 = StandardTable.this.backingMap.values().iterator2();
            boolean z10 = false;
            while (iterator2.hasNext()) {
                Map<C, V> next = iterator2.next();
                if (next.h().retainAll(collection)) {
                    z10 = true;
                    if (next.isEmpty()) {
                        iterator2.remove();
                    }
                }
            }
            return z10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Iterators.v(iterator2());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class f extends Maps.u<C, Map<R, V>> {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends StandardTable<R, C, V>.i<Map.Entry<C, Map<R, V>>> {

            /* renamed from: com.google.common.collect.StandardTable$f$a$a, reason: collision with other inner class name */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
            public class C0234a implements com.google.common.base.g<C, Map<R, V>> {
                public C0234a() {
                }

                @Override // com.google.common.base.g
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map<R, V> apply(C c4) {
                    return StandardTable.this.column(c4);
                }
            }

            public a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!StandardTable.this.containsColumn(entry.getKey())) {
                    return false;
                }
                Map<R, V> map = f.this.get(entry.getKey());
                Objects.requireNonNull(map);
                return map.equals(entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<Map.Entry<C, Map<R, V>>> iterator2() {
                return Maps.d(StandardTable.this.columnKeySet(), new C0234a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj) || !(obj instanceof Map.Entry)) {
                    return false;
                }
                StandardTable.this.removeColumn(((Map.Entry) obj).getKey());
                return true;
            }

            @Override // com.google.common.collect.Sets.b, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                com.google.common.base.o.r(collection);
                return Sets.i(this, collection.iterator2());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Sets.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                com.google.common.base.o.r(collection);
                Iterator iterator2 = Lists.l(StandardTable.this.columnKeySet().iterator2()).iterator2();
                boolean z10 = false;
                while (iterator2.hasNext()) {
                    Object next = iterator2.next();
                    if (!collection.contains(Maps.j(next, StandardTable.this.column(next)))) {
                        StandardTable.this.removeColumn(next);
                        z10 = true;
                    }
                }
                return z10;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.columnKeySet().size();
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class b extends Maps.t<C, Map<R, V>> {
            public b() {
                super(f.this);
            }

            @Override // com.google.common.collect.Maps.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                for (Map.Entry<C, Map<R, V>> entry : f.this.entrySet()) {
                    if (entry.getValue().equals(obj)) {
                        StandardTable.this.removeColumn(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                com.google.common.base.o.r(collection);
                Iterator iterator2 = Lists.l(StandardTable.this.columnKeySet().iterator2()).iterator2();
                boolean z10 = false;
                while (iterator2.hasNext()) {
                    Object next = iterator2.next();
                    if (collection.contains(StandardTable.this.column(next))) {
                        StandardTable.this.removeColumn(next);
                        z10 = true;
                    }
                }
                return z10;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.t, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                com.google.common.base.o.r(collection);
                Iterator iterator2 = Lists.l(StandardTable.this.columnKeySet().iterator2()).iterator2();
                boolean z10 = false;
                while (iterator2.hasNext()) {
                    Object next = iterator2.next();
                    if (!collection.contains(StandardTable.this.column(next))) {
                        StandardTable.this.removeColumn(next);
                        z10 = true;
                    }
                }
                return z10;
            }
        }

        public f() {
        }

        @Override // com.google.common.collect.Maps.u
        public Set<Map.Entry<C, Map<R, V>>> a() {
            return new a();
        }

        @Override // com.google.common.collect.Maps.u
        public Collection<Map<R, V>> c() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map<R, V> get(Object obj) {
            if (!StandardTable.this.containsColumn(obj)) {
                return null;
            }
            StandardTable standardTable = StandardTable.this;
            Objects.requireNonNull(obj);
            return standardTable.column(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map<R, V> remove(Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                return StandardTable.this.removeColumn(obj);
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.u, java.util.AbstractMap, java.util.Map
        /* renamed from: keySet */
        public Set<C> h() {
            return StandardTable.this.columnKeySet();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class g extends Maps.l<C, V> {

        /* renamed from: b, reason: collision with root package name */
        public final R f26495b;

        /* renamed from: c, reason: collision with root package name */
        public Map<C, V> f26496c;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a implements Iterator<Map.Entry<C, V>> {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Iterator f26498b;

            public a(Iterator it) {
                this.f26498b = it;
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<C, V> next() {
                return g.this.e((Map.Entry) this.f26498b.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f26498b.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f26498b.remove();
                g.this.c();
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class b extends w<C, V> {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Map.Entry f26500b;

            public b(g gVar, Map.Entry entry) {
                this.f26500b = entry;
            }

            @Override // com.google.common.collect.w, java.util.Map.Entry
            public boolean equals(Object obj) {
                return standardEquals(obj);
            }

            @Override // com.google.common.collect.z
            /* renamed from: o, reason: merged with bridge method [inline-methods] */
            public Map.Entry<C, V> delegate() {
                return this.f26500b;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.w, java.util.Map.Entry
            public V setValue(V v2) {
                return (V) super.setValue(com.google.common.base.o.r(v2));
            }
        }

        public g(R r10) {
            this.f26495b = (R) com.google.common.base.o.r(r10);
        }

        @Override // com.google.common.collect.Maps.l
        public Iterator<Map.Entry<C, V>> a() {
            d();
            Map<C, V> map = this.f26496c;
            if (map == null) {
                return Iterators.j();
            }
            return new a(map.entrySet().iterator2());
        }

        public Map<C, V> b() {
            return StandardTable.this.backingMap.get(this.f26495b);
        }

        public void c() {
            d();
            Map<C, V> map = this.f26496c;
            if (map == null || !map.isEmpty()) {
                return;
            }
            StandardTable.this.backingMap.remove(this.f26495b);
            this.f26496c = null;
        }

        @Override // com.google.common.collect.Maps.l, java.util.AbstractMap, java.util.Map
        public void clear() {
            d();
            Map<C, V> map = this.f26496c;
            if (map != null) {
                map.clear();
            }
            c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            Map<C, V> map;
            d();
            return (obj == null || (map = this.f26496c) == null || !Maps.w(map, obj)) ? false : true;
        }

        public final void d() {
            Map<C, V> map = this.f26496c;
            if (map == null || (map.isEmpty() && StandardTable.this.backingMap.containsKey(this.f26495b))) {
                this.f26496c = b();
            }
        }

        public Map.Entry<C, V> e(Map.Entry<C, V> entry) {
            return new b(this, entry);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Map<C, V> map;
            d();
            if (obj == null || (map = this.f26496c) == null) {
                return null;
            }
            return (V) Maps.x(map, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(C c4, V v2) {
            com.google.common.base.o.r(c4);
            com.google.common.base.o.r(v2);
            Map<C, V> map = this.f26496c;
            if (map != null && !map.isEmpty()) {
                return this.f26496c.put(c4, v2);
            }
            return (V) StandardTable.this.put(this.f26495b, c4, v2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            d();
            Map<C, V> map = this.f26496c;
            if (map == null) {
                return null;
            }
            V v2 = (V) Maps.y(map, obj);
            c();
            return v2;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            d();
            Map<C, V> map = this.f26496c;
            if (map == null) {
                return 0;
            }
            return map.size();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class h extends Maps.u<R, Map<C, V>> {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends StandardTable<R, C, V>.i<Map.Entry<R, Map<C, V>>> {

            /* renamed from: com.google.common.collect.StandardTable$h$a$a, reason: collision with other inner class name */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
            public class C0235a implements com.google.common.base.g<R, Map<C, V>> {
                public C0235a() {
                }

                @Override // com.google.common.base.g
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map<C, V> apply(R r10) {
                    return StandardTable.this.row(r10);
                }
            }

            public a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && n.c(StandardTable.this.backingMap.entrySet(), entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<Map.Entry<R, Map<C, V>>> iterator2() {
                return Maps.d(StandardTable.this.backingMap.h(), new C0235a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return entry.getKey() != null && (entry.getValue() instanceof Map) && StandardTable.this.backingMap.entrySet().remove(entry);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.backingMap.size();
            }
        }

        public h() {
        }

        @Override // com.google.common.collect.Maps.u
        public Set<Map.Entry<R, Map<C, V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.containsRow(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map<C, V> get(Object obj) {
            if (!StandardTable.this.containsRow(obj)) {
                return null;
            }
            StandardTable standardTable = StandardTable.this;
            Objects.requireNonNull(obj);
            return standardTable.row(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map<C, V> remove(Object obj) {
            if (obj == null) {
                return null;
            }
            return StandardTable.this.backingMap.remove(obj);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public abstract class i<T> extends Sets.b<T> {
        public i() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StandardTable.this.backingMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return StandardTable.this.backingMap.isEmpty();
        }
    }

    public StandardTable(Map<R, Map<C, V>> map, com.google.common.base.t<? extends Map<C, V>> tVar) {
        this.backingMap = map;
        this.factory = tVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean containsMapping(Object obj, Object obj2, Object obj3) {
        return obj3 != null && obj3.equals(get(obj, obj2));
    }

    private Map<C, V> getOrCreate(R r10) {
        Map<C, V> map = this.backingMap.get(r10);
        if (map != null) {
            return map;
        }
        Map<C, V> map2 = this.factory.get();
        this.backingMap.put(r10, map2);
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<R, V> removeColumn(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> iterator2 = this.backingMap.entrySet().iterator2();
        while (iterator2.hasNext()) {
            Map.Entry<R, Map<C, V>> next = iterator2.next();
            V remove = next.getValue().remove(obj);
            if (remove != null) {
                linkedHashMap.put(next.getKey(), remove);
                if (next.getValue().isEmpty()) {
                    iterator2.remove();
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeMapping(Object obj, Object obj2, Object obj3) {
        if (!containsMapping(obj, obj2, obj3)) {
            return false;
        }
        remove(obj, obj2);
        return true;
    }

    @Override // com.google.common.collect.i
    public Iterator<d1.a<R, C, V>> cellIterator() {
        return new b();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public Set<d1.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public void clear() {
        this.backingMap.clear();
    }

    @Override // com.google.common.collect.d1
    public Map<R, V> column(C c4) {
        return new c(c4);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public Set<C> columnKeySet() {
        Set<C> set = this.columnKeySet;
        if (set != null) {
            return set;
        }
        e eVar = new e();
        this.columnKeySet = eVar;
        return eVar;
    }

    @Override // com.google.common.collect.d1
    public Map<C, Map<R, V>> columnMap() {
        StandardTable<R, C, V>.f fVar = this.columnMap;
        if (fVar != null) {
            return fVar;
        }
        StandardTable<R, C, V>.f fVar2 = new f();
        this.columnMap = fVar2;
        return fVar2;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public boolean contains(Object obj, Object obj2) {
        return (obj == null || obj2 == null || !super.contains(obj, obj2)) ? false : true;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public boolean containsColumn(Object obj) {
        if (obj == null) {
            return false;
        }
        Iterator<Map<C, V>> iterator2 = this.backingMap.values().iterator2();
        while (iterator2.hasNext()) {
            if (Maps.w(iterator2.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public boolean containsRow(Object obj) {
        return obj != null && Maps.w(this.backingMap, obj);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    public Iterator<C> createColumnKeyIterator() {
        return new d();
    }

    public Map<R, Map<C, V>> createRowMap() {
        return new h();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public V get(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return (V) super.get(obj, obj2);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public V put(R r10, C c4, V v2) {
        com.google.common.base.o.r(r10);
        com.google.common.base.o.r(c4);
        com.google.common.base.o.r(v2);
        return getOrCreate(r10).put(c4, v2);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public V remove(Object obj, Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) Maps.x(this.backingMap, obj)) == null) {
            return null;
        }
        V v2 = (V) map.remove(obj2);
        if (map.isEmpty()) {
            this.backingMap.remove(obj);
        }
        return v2;
    }

    @Override // com.google.common.collect.d1
    public Map<C, V> row(R r10) {
        return new g(r10);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public Set<R> rowKeySet() {
        return rowMap().h();
    }

    @Override // com.google.common.collect.d1
    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> map = this.rowMap;
        if (map != null) {
            return map;
        }
        Map<R, Map<C, V>> createRowMap = createRowMap();
        this.rowMap = createRowMap;
        return createRowMap;
    }

    @Override // com.google.common.collect.d1
    public int size() {
        Iterator<Map<C, V>> iterator2 = this.backingMap.values().iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            i10 += iterator2.next().size();
        }
        return i10;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.d1
    public Collection<V> values() {
        return super.values();
    }
}
