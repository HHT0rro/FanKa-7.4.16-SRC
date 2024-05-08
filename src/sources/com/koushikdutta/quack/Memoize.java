package com.koushikdutta.quack;

import androidx.annotation.RecentlyNullable;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Memoize<T> {
    public MemoizeMap<T> store;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface MemoizeMap<V> {
        void clear();

        boolean containsKey(Object obj);

        V get(Object obj);

        V put(Integer num, V v2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class MemoizeMapImpl<V> extends HashMap<Integer, V> implements MemoizeMap<V> {
        private static final long serialVersionUID = -4020434697394716201L;

        private MemoizeMapImpl() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.koushikdutta.quack.Memoize.MemoizeMap
        @RecentlyNullable
        public /* bridge */ /* synthetic */ Object put(Integer num, Object obj) {
            return super.put((MemoizeMapImpl<V>) num, (Integer) obj);
        }
    }

    public Memoize(MemoizeMap<T> memoizeMap) {
        this.store = memoizeMap;
    }

    public static int hashCode(Object... objArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < objArr.length; i11++) {
            Object obj = objArr[i11];
            i10 ^= Integer.rotateLeft(obj == null ? 0 : obj.hashCode(), i11);
        }
        return objArr.length ^ i10;
    }

    public void clear() {
        this.store.clear();
    }

    public T memoize(MemoizeFunc<T> memoizeFunc, Object... objArr) {
        return memoize(memoizeFunc, hashCode(objArr));
    }

    public Memoize() {
        this(new MemoizeMapImpl());
    }

    public T memoize(MemoizeFunc<T> memoizeFunc, Object obj, Object[] objArr) {
        return memoize(memoizeFunc, (obj == null ? 0 : obj.hashCode()) ^ hashCode(objArr));
    }

    public T memoize(MemoizeFunc<T> memoizeFunc, Object obj, Object obj2, Object[] objArr) {
        return memoize(memoizeFunc, ((obj == null ? 0 : obj.hashCode()) ^ hashCode(objArr)) ^ (obj2 != null ? obj2.hashCode() : 0));
    }

    public T memoize(MemoizeFunc<T> memoizeFunc, Object obj, Object[] objArr, Object[] objArr2) {
        return memoize(memoizeFunc, (obj == null ? 0 : obj.hashCode()) ^ (hashCode(objArr) ^ hashCode(objArr2)));
    }

    private T memoize(MemoizeFunc<T> memoizeFunc, int i10) {
        if (this.store.containsKey(Integer.valueOf(i10))) {
            return this.store.get(Integer.valueOf(i10));
        }
        T process = memoizeFunc.process();
        this.store.put(Integer.valueOf(i10), process);
        return process;
    }
}
