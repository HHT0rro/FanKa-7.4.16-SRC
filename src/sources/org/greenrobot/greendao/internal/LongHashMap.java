package org.greenrobot.greendao.internal;

import java.util.Arrays;
import org.greenrobot.greendao.DaoLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class LongHashMap<T> {
    private int capacity;
    private int size;
    private Entry<T>[] table;
    private int threshold;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Entry<T> {
        public final long key;
        public Entry<T> next;
        public T value;

        public Entry(long j10, T t2, Entry<T> entry) {
            this.key = j10;
            this.value = t2;
            this.next = entry;
        }
    }

    public LongHashMap() {
        this(16);
    }

    public void clear() {
        this.size = 0;
        Arrays.fill(this.table, (Object) null);
    }

    public boolean containsKey(long j10) {
        for (Entry<T> entry = this.table[((((int) j10) ^ ((int) (j10 >>> 32))) & Integer.MAX_VALUE) % this.capacity]; entry != null; entry = entry.next) {
            if (entry.key == j10) {
                return true;
            }
        }
        return false;
    }

    public T get(long j10) {
        for (Entry<T> entry = this.table[((((int) j10) ^ ((int) (j10 >>> 32))) & Integer.MAX_VALUE) % this.capacity]; entry != null; entry = entry.next) {
            if (entry.key == j10) {
                return entry.value;
            }
        }
        return null;
    }

    public void logStats() {
        int i10 = 0;
        for (Entry<T> entry : this.table) {
            while (entry != null) {
                entry = entry.next;
                if (entry != null) {
                    i10++;
                }
            }
        }
        DaoLog.d("load: " + (this.size / this.capacity) + ", size: " + this.size + ", capa: " + this.capacity + ", collisions: " + i10 + ", collision ratio: " + (i10 / this.size));
    }

    public T put(long j10, T t2) {
        int i10 = ((((int) j10) ^ ((int) (j10 >>> 32))) & Integer.MAX_VALUE) % this.capacity;
        Entry<T> entry = this.table[i10];
        for (Entry<T> entry2 = entry; entry2 != null; entry2 = entry2.next) {
            if (entry2.key == j10) {
                T t10 = entry2.value;
                entry2.value = t2;
                return t10;
            }
        }
        this.table[i10] = new Entry<>(j10, t2, entry);
        int i11 = this.size + 1;
        this.size = i11;
        if (i11 <= this.threshold) {
            return null;
        }
        setCapacity(this.capacity * 2);
        return null;
    }

    public T remove(long j10) {
        int i10 = ((((int) j10) ^ ((int) (j10 >>> 32))) & Integer.MAX_VALUE) % this.capacity;
        Entry<T> entry = this.table[i10];
        Entry<T> entry2 = null;
        while (entry != null) {
            Entry<T> entry3 = entry.next;
            if (entry.key == j10) {
                if (entry2 == null) {
                    this.table[i10] = entry3;
                } else {
                    entry2.next = entry3;
                }
                this.size--;
                return entry.value;
            }
            entry2 = entry;
            entry = entry3;
        }
        return null;
    }

    public void reserveRoom(int i10) {
        setCapacity((i10 * 5) / 3);
    }

    public void setCapacity(int i10) {
        Entry<T>[] entryArr = new Entry[i10];
        int length = this.table.length;
        for (int i11 = 0; i11 < length; i11++) {
            Entry<T> entry = this.table[i11];
            while (entry != null) {
                long j10 = entry.key;
                int i12 = ((((int) (j10 >>> 32)) ^ ((int) j10)) & Integer.MAX_VALUE) % i10;
                Entry<T> entry2 = entry.next;
                entry.next = entryArr[i12];
                entryArr[i12] = entry;
                entry = entry2;
            }
        }
        this.table = entryArr;
        this.capacity = i10;
        this.threshold = (i10 * 4) / 3;
    }

    public int size() {
        return this.size;
    }

    public LongHashMap(int i10) {
        this.capacity = i10;
        this.threshold = (i10 * 4) / 3;
        this.table = new Entry[i10];
    }
}
