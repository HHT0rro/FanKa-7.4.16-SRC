package com.huawei.hmf.services.ui.internal;

import android.util.LongSparseArray;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class ObjectPool {
    private final LongSparseArray<Object> pool = new LongSparseArray<>();
    private static final ObjectPool instance = new ObjectPool();
    private static final AtomicLong UNIQUE_ID = new AtomicLong(0);

    private ObjectPool() {
    }

    public static ObjectPool getInstance() {
        return instance;
    }

    public Long add(Object obj) {
        if (obj != null) {
            Long valueOf = Long.valueOf(UNIQUE_ID.getAndIncrement());
            this.pool.put(valueOf.longValue(), obj);
            return valueOf;
        }
        throw new IllegalArgumentException("value cannot be null.");
    }

    public Object get(Long l10) {
        return this.pool.get(l10.longValue());
    }

    public void remove(Long l10) {
        this.pool.remove(l10.longValue());
    }
}
