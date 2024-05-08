package sun.security.util;

import java.util.Arrays;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Cache<K, V> {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface CacheVisitor<K, V> {
        void visit(Map<K, V> map);
    }

    public abstract void accept(CacheVisitor<K, V> cacheVisitor);

    public abstract void clear();

    public abstract V get(Object obj);

    public abstract V pull(Object obj);

    public abstract void put(K k10, V v2);

    public abstract void remove(Object obj);

    public abstract void setCapacity(int i10);

    public abstract void setTimeout(int i10);

    public abstract int size();

    public static <K, V> Cache<K, V> newSoftMemoryCache(int size) {
        return new MemoryCache(true, size);
    }

    public static <K, V> Cache<K, V> newSoftMemoryCache(int size, int timeout) {
        return new MemoryCache(true, size, timeout);
    }

    public static <K, V> Cache<K, V> newHardMemoryCache(int size) {
        return new MemoryCache(false, size);
    }

    public static <K, V> Cache<K, V> newNullCache() {
        return (Cache<K, V>) NullCache.INSTANCE;
    }

    public static <K, V> Cache<K, V> newHardMemoryCache(int size, int timeout) {
        return new MemoryCache(false, size, timeout);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class EqualByteArray {

        /* renamed from: b, reason: collision with root package name */
        private final byte[] f53742b;
        private int hash;

        public EqualByteArray(byte[] b4) {
            this.f53742b = b4;
        }

        public int hashCode() {
            int h10 = this.hash;
            if (h10 != 0) {
                return h10;
            }
            byte[] bArr = this.f53742b;
            if (bArr.length > 0) {
                int h11 = Arrays.hashCode(bArr);
                this.hash = h11;
                return h11;
            }
            return h10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EqualByteArray)) {
                return false;
            }
            EqualByteArray other = (EqualByteArray) obj;
            return Arrays.equals(this.f53742b, other.f53742b);
        }
    }
}
