package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.BoundedMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.apache.commons.collections4.map.AbstractLinkedMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class LRUMap<K, V> extends AbstractLinkedMap<K, V> implements BoundedMap<K, V>, Serializable, Cloneable {
    public static final int DEFAULT_MAX_SIZE = 100;
    private static final long serialVersionUID = -612114643488955218L;
    private transient int maxSize;
    private boolean scanUntilRemovable;

    public LRUMap() {
        this(100, 0.75f, false);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void addMapping(int i10, int i11, K k10, V v2) {
        if (isFull()) {
            AbstractLinkedMap.LinkEntry<K, V> linkEntry = this.header.after;
            boolean z10 = false;
            if (this.scanUntilRemovable) {
                while (true) {
                    if (linkEntry == this.header || linkEntry == null) {
                        break;
                    }
                    if (removeLRU(linkEntry)) {
                        z10 = true;
                        break;
                    }
                    linkEntry = linkEntry.after;
                }
                if (linkEntry == null) {
                    throw new IllegalStateException("Entry.after=null, header.after=" + ((Object) this.header.after) + " header.before=" + ((Object) this.header.before) + " key=" + ((Object) k10) + " value=" + ((Object) v2) + " size=" + this.size + " maxSize=" + this.maxSize + " This should not occur if your keys are immutable, and you have used synchronization properly.");
                }
            } else {
                z10 = removeLRU(linkEntry);
            }
            AbstractLinkedMap.LinkEntry<K, V> linkEntry2 = linkEntry;
            if (!z10) {
                super.addMapping(i10, i11, k10, v2);
                return;
            }
            if (linkEntry2 != null) {
                reuseMapping(linkEntry2, i10, i11, k10, v2);
                return;
            }
            throw new IllegalStateException("reuse=null, header.after=" + ((Object) this.header.after) + " header.before=" + ((Object) this.header.before) + " key=" + ((Object) k10) + " value=" + ((Object) v2) + " size=" + this.size + " maxSize=" + this.maxSize + " This should not occur if your keys are immutable, and you have used synchronization properly.");
        }
        super.addMapping(i10, i11, k10, v2);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.maxSize = objectInputStream.readInt();
        super.doReadObject(objectInputStream);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.maxSize);
        super.doWriteObject(objectOutputStream);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        return get(obj, true);
    }

    @Override // org.apache.commons.collections4.BoundedMap
    public boolean isFull() {
        return this.size >= this.maxSize;
    }

    public boolean isScanUntilRemovable() {
        return this.scanUntilRemovable;
    }

    @Override // org.apache.commons.collections4.BoundedMap
    public int maxSize() {
        return this.maxSize;
    }

    public void moveToMRU(AbstractLinkedMap.LinkEntry<K, V> linkEntry) {
        AbstractLinkedMap.LinkEntry<K, V> linkEntry2 = linkEntry.after;
        AbstractLinkedMap.LinkEntry<K, V> linkEntry3 = this.header;
        if (linkEntry2 == linkEntry3) {
            if (linkEntry == linkEntry3) {
                throw new IllegalStateException("Can't move header to MRU This should not occur if your keys are immutable, and you have used synchronization properly.");
            }
            return;
        }
        this.modCount++;
        AbstractLinkedMap.LinkEntry<K, V> linkEntry4 = linkEntry.before;
        if (linkEntry4 != null) {
            linkEntry4.after = linkEntry2;
            linkEntry.after.before = linkEntry4;
            linkEntry.after = linkEntry3;
            linkEntry.before = linkEntry3.before;
            linkEntry3.before.after = linkEntry;
            linkEntry3.before = linkEntry;
            return;
        }
        throw new IllegalStateException("Entry.before is null. This should not occur if your keys are immutable, and you have used synchronization properly.");
    }

    public boolean removeLRU(AbstractLinkedMap.LinkEntry<K, V> linkEntry) {
        return true;
    }

    public void reuseMapping(AbstractLinkedMap.LinkEntry<K, V> linkEntry, int i10, int i11, K k10, V v2) {
        try {
            int hashIndex = hashIndex(linkEntry.hashCode, this.data.length);
            AbstractHashedMap.HashEntry<K, V> hashEntry = this.data[hashIndex];
            AbstractHashedMap.HashEntry<K, V> hashEntry2 = null;
            while (hashEntry != linkEntry && hashEntry != null) {
                hashEntry2 = hashEntry;
                hashEntry = hashEntry.next;
            }
            if (hashEntry != null) {
                this.modCount++;
                removeEntry(linkEntry, hashIndex, hashEntry2);
                reuseEntry(linkEntry, i10, i11, k10, v2);
                addEntry(linkEntry, i10);
                return;
            }
            throw new IllegalStateException("Entry.next=null, data[removeIndex]=" + ((Object) this.data[hashIndex]) + " previous=" + ((Object) hashEntry2) + " key=" + ((Object) k10) + " value=" + ((Object) v2) + " size=" + this.size + " maxSize=" + this.maxSize + " This should not occur if your keys are immutable, and you have used synchronization properly.");
        } catch (NullPointerException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NPE, entry=");
            sb2.append((Object) linkEntry);
            sb2.append(" entryIsHeader=");
            sb2.append(linkEntry == this.header);
            sb2.append(" key=");
            sb2.append((Object) k10);
            sb2.append(" value=");
            sb2.append((Object) v2);
            sb2.append(" size=");
            sb2.append(this.size);
            sb2.append(" maxSize=");
            sb2.append(this.maxSize);
            sb2.append(" This should not occur if your keys are immutable, and you have used synchronization properly.");
            throw new IllegalStateException(sb2.toString());
        }
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void updateEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, V v2) {
        moveToMRU((AbstractLinkedMap.LinkEntry) hashEntry);
        hashEntry.setValue(v2);
    }

    public LRUMap(int i10) {
        this(i10, 0.75f);
    }

    public V get(Object obj, boolean z10) {
        AbstractLinkedMap.LinkEntry<K, V> entry = getEntry(obj);
        if (entry == null) {
            return null;
        }
        if (z10) {
            moveToMRU(entry);
        }
        return entry.getValue();
    }

    public LRUMap(int i10, int i11) {
        this(i10, i11, 0.75f);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap
    public LRUMap<K, V> clone() {
        return (LRUMap) super.clone();
    }

    public LRUMap(int i10, boolean z10) {
        this(i10, 0.75f, z10);
    }

    public LRUMap(int i10, float f10) {
        this(i10, f10, false);
    }

    public LRUMap(int i10, int i11, float f10) {
        this(i10, i11, f10, false);
    }

    public LRUMap(int i10, float f10, boolean z10) {
        this(i10, i10, f10, z10);
    }

    public LRUMap(int i10, int i11, float f10, boolean z10) {
        super(i11, f10);
        if (i10 < 1) {
            throw new IllegalArgumentException("LRUMap max size must be greater than 0");
        }
        if (i11 <= i10) {
            this.maxSize = i10;
            this.scanUntilRemovable = z10;
            return;
        }
        throw new IllegalArgumentException("LRUMap initial size must not be greather than max size");
    }

    public LRUMap(Map<? extends K, ? extends V> map) {
        this((Map) map, false);
    }

    public LRUMap(Map<? extends K, ? extends V> map, boolean z10) {
        this(map.size(), 0.75f, z10);
        putAll(map);
    }
}
