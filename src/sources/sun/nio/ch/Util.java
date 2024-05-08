package sun.nio.ch;

import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import sun.misc.Cleaner;
import sun.misc.Unsafe;
import sun.misc.VM;
import sun.security.action.GetPropertyAction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Util {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int TEMP_BUF_POOL_SIZE = IOUtil.IOV_MAX;
    private static final long MAX_CACHED_BUFFER_SIZE = getMaxCachedBufferSize();
    private static ThreadLocal<BufferCache> bufferCache = new ThreadLocal<BufferCache>() { // from class: sun.nio.ch.Util.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public BufferCache initialValue() {
            return new BufferCache();
        }
    };
    private static Unsafe unsafe = Unsafe.getUnsafe();
    private static volatile String bugLevel = null;

    private static long getMaxCachedBufferSize() {
        String s2 = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: sun.nio.ch.Util.2
            @Override // java.security.PrivilegedAction
            public String run() {
                return System.getProperty("jdk.nio.maxCachedBufferSize");
            }
        });
        if (s2 != null) {
            try {
                long m10 = Long.parseLong(s2);
                if (m10 >= 0) {
                    return m10;
                }
                return Long.MAX_VALUE;
            } catch (NumberFormatException e2) {
                return Long.MAX_VALUE;
            }
        }
        return Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isBufferTooLarge(int size) {
        return ((long) size) > MAX_CACHED_BUFFER_SIZE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isBufferTooLarge(ByteBuffer buf) {
        return isBufferTooLarge(buf.capacity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class BufferCache {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private ByteBuffer[] buffers = new ByteBuffer[Util.TEMP_BUF_POOL_SIZE];
        private int count;
        private int start;

        private int next(int i10) {
            return (i10 + 1) % Util.TEMP_BUF_POOL_SIZE;
        }

        BufferCache() {
        }

        ByteBuffer get(int size) {
            ByteBuffer bb2;
            if (this.count == 0) {
                return null;
            }
            ByteBuffer[] buffers = this.buffers;
            ByteBuffer buf = buffers[this.start];
            if (buf.capacity() < size) {
                buf = null;
                int i10 = this.start;
                while (true) {
                    int next = next(i10);
                    i10 = next;
                    if (next == this.start || (bb2 = buffers[i10]) == null) {
                        break;
                    }
                    if (bb2.capacity() >= size) {
                        buf = bb2;
                        break;
                    }
                }
                if (buf == null) {
                    return null;
                }
                buffers[i10] = buffers[this.start];
            }
            int i11 = this.start;
            buffers[i11] = null;
            this.start = next(i11);
            this.count--;
            buf.rewind();
            buf.limit(size);
            return buf;
        }

        boolean offerFirst(ByteBuffer buf) {
            if (this.count >= Util.TEMP_BUF_POOL_SIZE) {
                return false;
            }
            int i10 = ((this.start + Util.TEMP_BUF_POOL_SIZE) - 1) % Util.TEMP_BUF_POOL_SIZE;
            this.start = i10;
            this.buffers[i10] = buf;
            this.count++;
            return true;
        }

        boolean offerLast(ByteBuffer buf) {
            if (this.count >= Util.TEMP_BUF_POOL_SIZE) {
                return false;
            }
            int next = (this.start + this.count) % Util.TEMP_BUF_POOL_SIZE;
            this.buffers[next] = buf;
            this.count++;
            return true;
        }

        boolean isEmpty() {
            return this.count == 0;
        }

        ByteBuffer removeFirst() {
            ByteBuffer[] byteBufferArr = this.buffers;
            int i10 = this.start;
            ByteBuffer buf = byteBufferArr[i10];
            byteBufferArr[i10] = null;
            this.start = next(i10);
            this.count--;
            return buf;
        }
    }

    public static ByteBuffer getTemporaryDirectBuffer(int size) {
        if (isBufferTooLarge(size)) {
            return ByteBuffer.allocateDirect(size);
        }
        BufferCache cache = bufferCache.get();
        ByteBuffer buf = cache.get(size);
        if (buf != null) {
            return buf;
        }
        if (!cache.isEmpty()) {
            free(cache.removeFirst());
        }
        return ByteBuffer.allocateDirect(size);
    }

    public static void releaseTemporaryDirectBuffer(ByteBuffer buf) {
        offerFirstTemporaryDirectBuffer(buf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void offerFirstTemporaryDirectBuffer(ByteBuffer buf) {
        if (isBufferTooLarge(buf)) {
            free(buf);
            return;
        }
        BufferCache cache = bufferCache.get();
        if (!cache.offerFirst(buf)) {
            free(buf);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void offerLastTemporaryDirectBuffer(ByteBuffer buf) {
        if (isBufferTooLarge(buf)) {
            free(buf);
            return;
        }
        BufferCache cache = bufferCache.get();
        if (!cache.offerLast(buf)) {
            free(buf);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void free(ByteBuffer byteBuffer) {
        Cleaner cleaner = ((DirectBuffer) byteBuffer).cleaner();
        if (cleaner != null) {
            cleaner.clean();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer[] subsequence(ByteBuffer[] bs, int offset, int length) {
        if (offset == 0 && length == bs.length) {
            return bs;
        }
        ByteBuffer[] bs2 = new ByteBuffer[length];
        for (int i10 = 0; i10 < length; i10++) {
            bs2[i10] = bs[offset + i10];
        }
        return bs2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Set<E> ungrowableSet(final Set<E> s2) {
        return new Set<E>() { // from class: sun.nio.ch.Util.3
            @Override // java.util.Set
            public int size() {
                return Set.this.size();
            }

            @Override // java.util.Set
            public boolean isEmpty() {
                return Set.this.isEmpty();
            }

            @Override // java.util.Set
            public boolean contains(Object o10) {
                return Set.this.contains(o10);
            }

            @Override // java.util.Set
            public Object[] toArray() {
                return Set.this.toArray();
            }

            @Override // java.util.Set
            public <T> T[] toArray(T[] tArr) {
                return (T[]) Set.this.toArray(tArr);
            }

            public String toString() {
                return Set.this.toString();
            }

            @Override // java.util.Set, java.util.Collection, java.lang.Iterable
            /* renamed from: iterator */
            public Iterator<E> iterator2() {
                return Set.this.iterator2();
            }

            @Override // java.util.Set
            public boolean equals(Object o10) {
                return Set.this.equals(o10);
            }

            @Override // java.util.Set
            public int hashCode() {
                return Set.this.hashCode();
            }

            @Override // java.util.Set
            public void clear() {
                Set.this.clear();
            }

            @Override // java.util.Set
            public boolean remove(Object o10) {
                return Set.this.remove(o10);
            }

            @Override // java.util.Set
            public boolean containsAll(Collection<?> coll) {
                return Set.this.containsAll(coll);
            }

            @Override // java.util.Set
            public boolean removeAll(Collection<?> coll) {
                return Set.this.removeAll(coll);
            }

            @Override // java.util.Set
            public boolean retainAll(Collection<?> coll) {
                return Set.this.retainAll(coll);
            }

            @Override // java.util.Set
            public boolean add(E o10) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Set
            public boolean addAll(Collection<? extends E> coll) {
                throw new UnsupportedOperationException();
            }
        };
    }

    private static byte _get(long a10) {
        return unsafe.getByte(a10);
    }

    private static void _put(long a10, byte b4) {
        unsafe.putByte(a10, b4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static void erase(ByteBuffer byteBuffer) {
        unsafe.setMemory(((DirectBuffer) byteBuffer).address(), byteBuffer.capacity(), (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe unsafe() {
        return unsafe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean atBugLevel(String bl) {
        if (bugLevel == null) {
            if (!VM.isBooted()) {
                return false;
            }
            String value = (String) AccessController.doPrivileged(new GetPropertyAction("sun.nio.ch.bugLevel"));
            bugLevel = value != null ? value : "";
        }
        return bugLevel.equals(bl);
    }
}
