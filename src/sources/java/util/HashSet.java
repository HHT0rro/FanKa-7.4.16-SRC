package java.util;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import jdk.internal.misc.SharedSecrets;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable {
    private static final Object PRESENT = new Object();
    static final long serialVersionUID = -5024744406713321676L;
    private transient HashMap<E, Object> map;

    public HashSet() {
        this.map = new HashMap<>();
    }

    public HashSet(Collection<? extends E> c4) {
        this.map = new HashMap<>(Math.max(((int) (c4.size() / 0.75f)) + 1, 16));
        addAll(c4);
    }

    public HashSet(int initialCapacity, float loadFactor) {
        this.map = new HashMap<>(initialCapacity, loadFactor);
    }

    public HashSet(int initialCapacity) {
        this.map = new HashMap<>(initialCapacity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashSet(int initialCapacity, float loadFactor, boolean dummy) {
        this.map = new LinkedHashMap(initialCapacity, loadFactor);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<E> iterator2() {
        return this.map.h().iterator2();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.map.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object o10) {
        return this.map.containsKey(o10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        return this.map.put(e2, PRESENT) == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o10) {
        return this.map.remove(o10) == PRESENT;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.map.clear();
    }

    public Object clone() {
        try {
            HashSet<E> newSet = (HashSet) super.clone();
            newSet.map = (HashMap) this.map.clone();
            return newSet;
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2);
        }
    }

    private void writeObject(ObjectOutputStream s2) throws IOException {
        s2.defaultWriteObject();
        s2.writeInt(this.map.capacity());
        s2.writeFloat(this.map.loadFactor());
        s2.writeInt(this.map.size());
        for (E e2 : this.map.h()) {
            s2.writeObject(e2);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        HashMap<E, Object> hashMap;
        objectInputStream.readFields();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException("Illegal capacity: " + readInt);
        }
        float readFloat = objectInputStream.readFloat();
        if (readFloat <= 0.0f || Float.isNaN(readFloat)) {
            throw new InvalidObjectException("Illegal load factor: " + readFloat);
        }
        float min = Math.min(Math.max(0.25f, readFloat), 4.0f);
        int readInt2 = objectInputStream.readInt();
        if (readInt2 < 0) {
            throw new InvalidObjectException("Illegal size: " + readInt2);
        }
        int min2 = (int) Math.min(readInt2 * Math.min(1.0f / min, 4.0f), 1.07374182E9f);
        SharedSecrets.getJavaObjectInputStreamAccess().checkArray(objectInputStream, Map.Entry[].class, HashMap.tableSizeFor(min2));
        if (this instanceof LinkedHashSet) {
            hashMap = new LinkedHashMap<>(min2, min);
        } else {
            hashMap = new HashMap<>(min2, min);
        }
        this.map = hashMap;
        for (int i10 = 0; i10 < readInt2; i10++) {
            this.map.put(objectInputStream.readObject(), PRESENT);
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return new HashMap.KeySpliterator(this.map, 0, -1, 0, 0);
    }
}
