package androidx.constraintlayout.solver;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class Pools {
    private static final boolean DEBUG = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface Pool<T> {
        T acquire();

        boolean release(T t2);

        void releaseAll(T[] tArr, int i10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
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

        @Override // androidx.constraintlayout.solver.Pools.Pool
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

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public boolean release(T t2) {
            int i10 = this.mPoolSize;
            Object[] objArr = this.mPool;
            if (i10 >= objArr.length) {
                return false;
            }
            objArr[i10] = t2;
            this.mPoolSize = i10 + 1;
            return true;
        }

        @Override // androidx.constraintlayout.solver.Pools.Pool
        public void releaseAll(T[] tArr, int i10) {
            if (i10 > tArr.length) {
                i10 = tArr.length;
            }
            for (int i11 = 0; i11 < i10; i11++) {
                T t2 = tArr[i11];
                int i12 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i12 < objArr.length) {
                    objArr[i12] = t2;
                    this.mPoolSize = i12 + 1;
                }
            }
        }
    }

    private Pools() {
    }
}
