package com.google.common.collect;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class MutableClassToInstanceMap<B> extends v<Class<? extends B>, B> implements Serializable {
    private final Map<Class<? extends B>, B> delegate;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class SerializedForm<B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Map<Class<? extends B>, B> backingMap;

        public SerializedForm(Map<Class<? extends B>, B> map) {
            this.backingMap = map;
        }

        public Object readResolve() {
            return MutableClassToInstanceMap.create(this.backingMap);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a extends w<Class<? extends B>, B> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f26456b;

        public a(Map.Entry entry) {
            this.f26456b = entry;
        }

        @Override // com.google.common.collect.z
        /* renamed from: o */
        public Map.Entry<Class<? extends B>, B> delegate() {
            return this.f26456b;
        }

        @Override // com.google.common.collect.w, java.util.Map.Entry
        public B setValue(B b4) {
            return (B) super.setValue(MutableClassToInstanceMap.cast(getKey(), b4));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends b0<Map.Entry<Class<? extends B>, B>> {

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class a extends f1<Map.Entry<Class<? extends B>, B>, Map.Entry<Class<? extends B>, B>> {
            public a(b bVar, Iterator it) {
                super(it);
            }

            @Override // com.google.common.collect.f1
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<Class<? extends B>, B> a(Map.Entry<Class<? extends B>, B> entry) {
                return MutableClassToInstanceMap.checkedEntry(entry);
            }
        }

        public b() {
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<Map.Entry<Class<? extends B>, B>> iterator2() {
            return new a(this, delegate().iterator2());
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.s, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        @Override // com.google.common.collect.b0, com.google.common.collect.s, com.google.common.collect.z
        public Set<Map.Entry<Class<? extends B>, B>> delegate() {
            return MutableClassToInstanceMap.this.delegate().entrySet();
        }
    }

    private MutableClassToInstanceMap(Map<Class<? extends B>, B> map) {
        this.delegate = (Map) com.google.common.base.o.r(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <B, T extends B> T cast(Class<T> cls, B b4) {
        return (T) com.google.common.primitives.d.d(cls).cast(b4);
    }

    public static <B> Map.Entry<Class<? extends B>, B> checkedEntry(Map.Entry<Class<? extends B>, B> entry) {
        return new a(entry);
    }

    public static <B> MutableClassToInstanceMap<B> create() {
        return new MutableClassToInstanceMap<>(new HashMap());
    }

    private Object writeReplace() {
        return new SerializedForm(delegate());
    }

    @Override // com.google.common.collect.v, java.util.Map
    public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
        return new b();
    }

    public <T extends B> T getInstance(Class<T> cls) {
        return (T) cast(cls, get(cls));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.v, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((Class<? extends Class<? extends B>>) obj, (Class<? extends B>) obj2);
    }

    @Override // com.google.common.collect.v, java.util.Map
    public void putAll(Map<? extends Class<? extends B>, ? extends B> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            cast((Class) entry.getKey(), entry.getValue());
        }
        super.putAll(linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends B> T putInstance(Class<T> cls, T t2) {
        return (T) cast(cls, put((Class<? extends Class<T>>) cls, (Class<T>) t2));
    }

    public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> map) {
        return new MutableClassToInstanceMap<>(map);
    }

    @Override // com.google.common.collect.v, com.google.common.collect.z
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    public B put(Class<? extends B> cls, B b4) {
        return (B) super.put((MutableClassToInstanceMap<B>) cls, (Class<? extends B>) cast(cls, b4));
    }
}
