package com.google.android.gms.internal.clearcut;

import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f1<K> implements Map.Entry<K, Object> {

    /* renamed from: b, reason: collision with root package name */
    public Map.Entry<K, d1> f23892b;

    public f1(Map.Entry<K, d1> entry) {
        this.f23892b = entry;
    }

    public final d1 a() {
        return this.f23892b.getValue();
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f23892b.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f23892b.getValue() == null) {
            return null;
        }
        return d1.e();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof a2) {
            return this.f23892b.getValue().c((a2) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
