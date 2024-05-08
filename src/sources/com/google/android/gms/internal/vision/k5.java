package com.google.android.gms.internal.vision;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class k5<K> implements Map.Entry<K, Object> {

    /* renamed from: b, reason: collision with root package name */
    public Map.Entry<K, i5> f25525b;

    public k5(Map.Entry<K, i5> entry) {
        this.f25525b = entry;
    }

    public final i5 a() {
        return this.f25525b.getValue();
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f25525b.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f25525b.getValue() == null) {
            return null;
        }
        return i5.e();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof c6) {
            return this.f25525b.getValue().a((c6) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
