package java.lang;

import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import jdk.internal.misc.TerminatingThreadLocal;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ThreadLocal<T> {
    private static final int HASH_INCREMENT = 1640531527;
    private static AtomicInteger nextHashCode = new AtomicInteger();
    private final int threadLocalHashCode = nextHashCode();

    private static int nextHashCode() {
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }

    protected T initialValue() {
        return null;
    }

    public static <S> ThreadLocal<S> withInitial(Supplier<? extends S> supplier) {
        return new SuppliedThreadLocal(supplier);
    }

    public T get() {
        ThreadLocalMap.Entry entry;
        ThreadLocalMap map = getMap(Thread.currentThread());
        if (map != null && (entry = map.getEntry(this)) != null) {
            return (T) entry.value;
        }
        return setInitialValue();
    }

    boolean isPresent() {
        Thread t2 = Thread.currentThread();
        ThreadLocalMap map = getMap(t2);
        return (map == null || map.getEntry(this) == null) ? false : true;
    }

    private T setInitialValue() {
        T value = initialValue();
        Thread t2 = Thread.currentThread();
        ThreadLocalMap map = getMap(t2);
        if (map != null) {
            map.set(this, value);
        } else {
            createMap(t2, value);
        }
        if (this instanceof TerminatingThreadLocal) {
            TerminatingThreadLocal.register((TerminatingThreadLocal) this);
        }
        return value;
    }

    public void set(T value) {
        Thread t2 = Thread.currentThread();
        ThreadLocalMap map = getMap(t2);
        if (map != null) {
            map.set(this, value);
        } else {
            createMap(t2, value);
        }
    }

    public void remove() {
        ThreadLocalMap m10 = getMap(Thread.currentThread());
        if (m10 != null) {
            m10.remove(this);
        }
    }

    ThreadLocalMap getMap(Thread t2) {
        return t2.threadLocals;
    }

    void createMap(Thread t2, T firstValue) {
        t2.threadLocals = new ThreadLocalMap((ThreadLocal<?>) this, (Object) firstValue);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadLocalMap createInheritedMap(ThreadLocalMap parentMap) {
        return new ThreadLocalMap(parentMap);
    }

    T childValue(T parentValue) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class SuppliedThreadLocal<T> extends ThreadLocal<T> {
        private final Supplier<? extends T> supplier;

        SuppliedThreadLocal(Supplier<? extends T> supplier) {
            this.supplier = (Supplier) Objects.requireNonNull(supplier);
        }

        @Override // java.lang.ThreadLocal
        protected T initialValue() {
            return this.supplier.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ThreadLocalMap {
        private static final int INITIAL_CAPACITY = 16;
        private int size;
        private Entry[] table;
        private int threshold;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static class Entry extends WeakReference<ThreadLocal<?>> {
            Object value;

            Entry(ThreadLocal<?> k10, Object v2) {
                super(k10);
                this.value = v2;
            }
        }

        private void setThreshold(int len) {
            this.threshold = (len * 2) / 3;
        }

        private static int nextIndex(int i10, int len) {
            if (i10 + 1 < len) {
                return i10 + 1;
            }
            return 0;
        }

        private static int prevIndex(int i10, int len) {
            return i10 + (-1) >= 0 ? i10 - 1 : len - 1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ThreadLocalMap(ThreadLocal<?> firstKey, Object firstValue) {
            this.size = 0;
            this.table = new Entry[16];
            int i10 = ((ThreadLocal) firstKey).threadLocalHashCode & 15;
            this.table[i10] = new Entry(firstKey, firstValue);
            this.size = 1;
            setThreshold(16);
        }

        private ThreadLocalMap(ThreadLocalMap parentMap) {
            ThreadLocal<Object> key;
            Entry[] entryArr;
            this.size = 0;
            Entry[] parentTable = parentMap.table;
            int len = parentTable.length;
            setThreshold(len);
            this.table = new Entry[len];
            for (Entry e2 : parentTable) {
                if (e2 != null && (key = e2.get()) != null) {
                    Object value = key.childValue(e2.value);
                    Entry c4 = new Entry(key, value);
                    int h10 = ((ThreadLocal) key).threadLocalHashCode & (len - 1);
                    while (true) {
                        entryArr = this.table;
                        if (entryArr[h10] == null) {
                            break;
                        } else {
                            h10 = nextIndex(h10, len);
                        }
                    }
                    entryArr[h10] = c4;
                    this.size++;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Entry getEntry(ThreadLocal<?> key) {
            int i10 = ((ThreadLocal) key).threadLocalHashCode;
            int i11 = i10 & (r1.length - 1);
            Entry e2 = this.table[i11];
            if (e2 != null && e2.refersTo(key)) {
                return e2;
            }
            return getEntryAfterMiss(key, i11, e2);
        }

        private Entry getEntryAfterMiss(ThreadLocal<?> key, int i10, Entry e2) {
            Entry[] tab = this.table;
            int len = tab.length;
            while (e2 != null) {
                if (e2.refersTo(key)) {
                    return e2;
                }
                if (e2.refersTo(null)) {
                    expungeStaleEntry(i10);
                } else {
                    i10 = nextIndex(i10, len);
                }
                e2 = tab[i10];
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void set(ThreadLocal<?> key, Object value) {
            Entry[] tab = this.table;
            int len = tab.length;
            int i10 = ((ThreadLocal) key).threadLocalHashCode & (len - 1);
            Entry e2 = tab[i10];
            while (e2 != null) {
                if (e2.refersTo(key)) {
                    e2.value = value;
                    return;
                } else if (!e2.refersTo(null)) {
                    int nextIndex = nextIndex(i10, len);
                    i10 = nextIndex;
                    e2 = tab[nextIndex];
                } else {
                    replaceStaleEntry(key, value, i10);
                    return;
                }
            }
            tab[i10] = new Entry(key, value);
            int sz = this.size + 1;
            this.size = sz;
            if (!cleanSomeSlots(i10, sz) && sz >= this.threshold) {
                rehash();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void remove(ThreadLocal<?> key) {
            Entry[] tab = this.table;
            int len = tab.length;
            int i10 = ((ThreadLocal) key).threadLocalHashCode & (len - 1);
            Entry e2 = tab[i10];
            while (e2 != null) {
                if (!e2.refersTo(key)) {
                    int nextIndex = nextIndex(i10, len);
                    i10 = nextIndex;
                    e2 = tab[nextIndex];
                } else {
                    e2.clear();
                    expungeStaleEntry(i10);
                    return;
                }
            }
        }

        private void replaceStaleEntry(ThreadLocal<?> key, Object value, int staleSlot) {
            Entry[] tab = this.table;
            int len = tab.length;
            int slotToExpunge = staleSlot;
            int i10 = prevIndex(staleSlot, len);
            while (true) {
                Entry e2 = tab[i10];
                if (e2 == null) {
                    break;
                }
                if (e2.refersTo(null)) {
                    slotToExpunge = i10;
                }
                i10 = prevIndex(i10, len);
            }
            int i11 = nextIndex(staleSlot, len);
            while (true) {
                Entry e10 = tab[i11];
                if (e10 != null) {
                    if (e10.refersTo(key)) {
                        e10.value = value;
                        tab[i11] = tab[staleSlot];
                        tab[staleSlot] = e10;
                        if (slotToExpunge == staleSlot) {
                            slotToExpunge = i11;
                        }
                        cleanSomeSlots(expungeStaleEntry(slotToExpunge), len);
                        return;
                    }
                    if (e10.refersTo(null) && slotToExpunge == staleSlot) {
                        slotToExpunge = i11;
                    }
                    i11 = nextIndex(i11, len);
                } else {
                    tab[staleSlot].value = null;
                    tab[staleSlot] = new Entry(key, value);
                    if (slotToExpunge != staleSlot) {
                        cleanSomeSlots(expungeStaleEntry(slotToExpunge), len);
                        return;
                    }
                    return;
                }
            }
        }

        private int expungeStaleEntry(int staleSlot) {
            Entry[] tab = this.table;
            int len = tab.length;
            tab[staleSlot].value = null;
            tab[staleSlot] = null;
            this.size--;
            int i10 = nextIndex(staleSlot, len);
            while (true) {
                Entry e2 = tab[i10];
                if (e2 != null) {
                    ThreadLocal<?> k10 = e2.get();
                    if (k10 == null) {
                        e2.value = null;
                        tab[i10] = null;
                        this.size--;
                    } else {
                        int h10 = ((ThreadLocal) k10).threadLocalHashCode & (len - 1);
                        if (h10 != i10) {
                            tab[i10] = null;
                            while (tab[h10] != null) {
                                h10 = nextIndex(h10, len);
                            }
                            tab[h10] = e2;
                        }
                    }
                    i10 = nextIndex(i10, len);
                } else {
                    return i10;
                }
            }
        }

        private boolean cleanSomeSlots(int i10, int n10) {
            int i11;
            boolean removed = false;
            Entry[] tab = this.table;
            int len = tab.length;
            do {
                i10 = nextIndex(i10, len);
                Entry e2 = tab[i10];
                if (e2 != null && e2.refersTo(null)) {
                    n10 = len;
                    removed = true;
                    i10 = expungeStaleEntry(i10);
                }
                i11 = n10 >>> 1;
                n10 = i11;
            } while (i11 != 0);
            return removed;
        }

        private void rehash() {
            expungeStaleEntries();
            int i10 = this.size;
            int i11 = this.threshold;
            if (i10 >= i11 - (i11 / 4)) {
                resize();
            }
        }

        private void resize() {
            Entry[] oldTab = this.table;
            int oldLen = oldTab.length;
            int newLen = oldLen * 2;
            Entry[] newTab = new Entry[newLen];
            int count = 0;
            for (Entry e2 : oldTab) {
                if (e2 != null) {
                    ThreadLocal<?> k10 = e2.get();
                    if (k10 == null) {
                        e2.value = null;
                    } else {
                        int h10 = ((ThreadLocal) k10).threadLocalHashCode & (newLen - 1);
                        while (newTab[h10] != null) {
                            h10 = nextIndex(h10, newLen);
                        }
                        newTab[h10] = e2;
                        count++;
                    }
                }
            }
            setThreshold(newLen);
            this.size = count;
            this.table = newTab;
        }

        private void expungeStaleEntries() {
            Entry[] tab = this.table;
            int len = tab.length;
            for (int j10 = 0; j10 < len; j10++) {
                Entry e2 = tab[j10];
                if (e2 != null && e2.refersTo(null)) {
                    expungeStaleEntry(j10);
                }
            }
        }
    }
}
