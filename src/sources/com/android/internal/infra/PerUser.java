package com.android.internal.infra;

import android.util.SparseArray;
import com.android.internal.util.Preconditions;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class PerUser<T> extends SparseArray<T> {
    protected abstract T create(int i10);

    public T forUser(int userId) {
        return get(userId);
    }

    @Override // android.util.SparseArray
    public T get(int i10) {
        T t2 = (T) super.get(i10);
        if (t2 != null) {
            return t2;
        }
        T t10 = (T) Preconditions.checkNotNull(create(i10));
        put(i10, t10);
        return t10;
    }
}
