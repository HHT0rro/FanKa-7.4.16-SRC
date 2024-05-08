package com.google.common.cache;

import com.google.common.base.o;
import java.util.AbstractMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    private RemovalNotification(K k10, V v2, RemovalCause removalCause) {
        super(k10, v2);
        this.cause = (RemovalCause) o.r(removalCause);
    }

    public static <K, V> RemovalNotification<K, V> create(K k10, V v2, RemovalCause removalCause) {
        return new RemovalNotification<>(k10, v2, removalCause);
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}
