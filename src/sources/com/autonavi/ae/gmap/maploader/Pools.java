package com.autonavi.ae.gmap.maploader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class Pools {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface Pool<T> {
        T acquire();

        void destory();

        boolean release(T t2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int i10) {
            if (i10 > 0) {
                this.mPool = new Object[i10];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean isInPool(T t2) {
            for (int i10 = 0; i10 < this.mPoolSize; i10++) {
                if (this.mPool[i10] == t2) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.autonavi.ae.gmap.maploader.Pools.Pool
        public T acquire() {
            int i10 = this.mPoolSize;
            if (i10 <= 0) {
                return null;
            }
            int i11 = i10 - 1;
            Object[] objArr = this.mPool;
            T t2 = (T) objArr[i11];
            objArr[i11] = null;
            this.mPoolSize = i10 - 1;
            return t2;
        }

        @Override // com.autonavi.ae.gmap.maploader.Pools.Pool
        public void destory() {
            int i10 = 0;
            while (true) {
                Object[] objArr = this.mPool;
                if (i10 >= objArr.length) {
                    return;
                }
                objArr[i10] = null;
                i10++;
            }
        }

        @Override // com.autonavi.ae.gmap.maploader.Pools.Pool
        public boolean release(T t2) {
            if (!isInPool(t2)) {
                int i10 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i10 >= objArr.length) {
                    return false;
                }
                objArr[i10] = t2;
                this.mPoolSize = i10 + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object mLock;

        public SynchronizedPool(int i10) {
            super(i10);
            this.mLock = new Object();
        }

        @Override // com.autonavi.ae.gmap.maploader.Pools.SimplePool, com.autonavi.ae.gmap.maploader.Pools.Pool
        public T acquire() {
            T t2;
            synchronized (this.mLock) {
                t2 = (T) super.acquire();
            }
            return t2;
        }

        @Override // com.autonavi.ae.gmap.maploader.Pools.SimplePool, com.autonavi.ae.gmap.maploader.Pools.Pool
        public boolean release(T t2) {
            boolean release;
            synchronized (this.mLock) {
                release = super.release(t2);
            }
            return release;
        }
    }

    private Pools() {
    }
}
