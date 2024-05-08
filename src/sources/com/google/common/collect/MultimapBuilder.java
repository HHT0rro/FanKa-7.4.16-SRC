package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class MultimapBuilder<K0, V0> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class ArrayListSupplier<V> implements com.google.common.base.t<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        public ArrayListSupplier(int i10) {
            this.expectedValuesPerKey = m.b(i10, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.t
        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class EnumSetSupplier<V extends Enum<V>> implements com.google.common.base.t<Set<V>>, Serializable {
        private final Class<V> clazz;

        public EnumSetSupplier(Class<V> cls) {
            this.clazz = (Class) com.google.common.base.o.r(cls);
        }

        @Override // com.google.common.base.t
        public Set<V> get() {
            return EnumSet.noneOf(this.clazz);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class HashSetSupplier<V> implements com.google.common.base.t<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        public HashSetSupplier(int i10) {
            this.expectedValuesPerKey = m.b(i10, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.t
        public Set<V> get() {
            return q0.d(this.expectedValuesPerKey);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class LinkedHashSetSupplier<V> implements com.google.common.base.t<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        public LinkedHashSetSupplier(int i10) {
            this.expectedValuesPerKey = m.b(i10, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.t
        public Set<V> get() {
            return q0.f(this.expectedValuesPerKey);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum LinkedListSupplier implements com.google.common.base.t<List<?>> {
        INSTANCE;

        public static <V> com.google.common.base.t<List<V>> instance() {
            return INSTANCE;
        }

        @Override // com.google.common.base.t
        public List<?> get() {
            return new LinkedList();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class TreeSetSupplier<V> implements com.google.common.base.t<SortedSet<V>>, Serializable {
        private final Comparator<? super V> comparator;

        public TreeSetSupplier(Comparator<? super V> comparator) {
            this.comparator = (Comparator) com.google.common.base.o.r(comparator);
        }

        @Override // com.google.common.base.t
        public SortedSet<V> get() {
            return new TreeSet(this.comparator);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends d<Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f26437a;

        public a(int i10) {
            this.f26437a = i10;
        }

        @Override // com.google.common.collect.MultimapBuilder.d
        public <K, V> Map<K, Collection<V>> c() {
            return q0.c(this.f26437a);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends d<K0> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f26438a;

        public b(Comparator comparator) {
            this.f26438a = comparator;
        }

        @Override // com.google.common.collect.MultimapBuilder.d
        public <K extends K0, V> Map<K, Collection<V>> c() {
            return new TreeMap(this.f26438a);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class c<K0, V0> extends MultimapBuilder<K0, V0> {
        public c() {
            super(null);
        }

        public abstract <K extends K0, V extends V0> i0<K, V> e();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class d<K0> {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends c<K0, Object> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f26439a;

            public a(int i10) {
                this.f26439a = i10;
            }

            @Override // com.google.common.collect.MultimapBuilder.c
            public <K extends K0, V> i0<K, V> e() {
                return Multimaps.d(d.this.c(), new ArrayListSupplier(this.f26439a));
            }
        }

        public c<K0, Object> a() {
            return b(2);
        }

        public c<K0, Object> b(int i10) {
            m.b(i10, "expectedValuesPerKey");
            return new a(i10);
        }

        public abstract <K extends K0, V> Map<K, Collection<V>> c();
    }

    public /* synthetic */ MultimapBuilder(a aVar) {
        this();
    }

    public static d<Object> a() {
        return b(8);
    }

    public static d<Object> b(int i10) {
        m.b(i10, "expectedKeys");
        return new a(i10);
    }

    public static d<Comparable> c() {
        return d(Ordering.natural());
    }

    public static <K0> d<K0> d(Comparator<K0> comparator) {
        com.google.common.base.o.r(comparator);
        return new b(comparator);
    }

    public MultimapBuilder() {
    }
}
