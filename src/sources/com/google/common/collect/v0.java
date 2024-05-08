package com.google.common.collect;

import com.google.common.collect.k0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Serialization.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class v0 {

    /* compiled from: Serialization.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class b<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Field f26621a;

        public void a(T t2, int i10) {
            try {
                this.f26621a.set(t2, Integer.valueOf(i10));
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public void b(T t2, Object obj) {
            try {
                this.f26621a.set(t2, obj);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        public b(Field field) {
            this.f26621a = field;
            field.setAccessible(true);
        }
    }

    public static <T> b<T> a(Class<T> cls, String str) {
        try {
            return new b<>(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e2) {
            throw new AssertionError(e2);
        }
    }

    public static <K, V> void b(Map<K, V> map, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        c(map, objectInputStream, objectInputStream.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void c(Map<K, V> map, ObjectInputStream objectInputStream, int i10) throws IOException, ClassNotFoundException {
        for (int i11 = 0; i11 < i10; i11++) {
            map.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    public static <K, V> void d(j0<K, V> j0Var, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        e(j0Var, objectInputStream, objectInputStream.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void e(j0<K, V> j0Var, ObjectInputStream objectInputStream, int i10) throws IOException, ClassNotFoundException {
        for (int i11 = 0; i11 < i10; i11++) {
            Collection collection = j0Var.get(objectInputStream.readObject());
            int readInt = objectInputStream.readInt();
            for (int i12 = 0; i12 < readInt; i12++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    public static <E> void f(k0<E> k0Var, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        g(k0Var, objectInputStream, objectInputStream.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> void g(k0<E> k0Var, ObjectInputStream objectInputStream, int i10) throws IOException, ClassNotFoundException {
        for (int i11 = 0; i11 < i10; i11++) {
            k0Var.add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    public static int h(ObjectInputStream objectInputStream) throws IOException {
        return objectInputStream.readInt();
    }

    public static <K, V> void i(Map<K, V> map, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    public static <K, V> void j(j0<K, V> j0Var, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(j0Var.asMap().size());
        for (Map.Entry<K, Collection<V>> entry : j0Var.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            Iterator<V> iterator2 = entry.getValue().iterator2();
            while (iterator2.hasNext()) {
                objectOutputStream.writeObject(iterator2.next());
            }
        }
    }

    public static <E> void k(k0<E> k0Var, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(k0Var.entrySet().size());
        for (k0.a<E> aVar : k0Var.entrySet()) {
            objectOutputStream.writeObject(aVar.getElement());
            objectOutputStream.writeInt(aVar.getCount());
        }
    }
}
