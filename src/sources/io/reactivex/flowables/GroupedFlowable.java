package io.reactivex.flowables;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class GroupedFlowable<K, T> extends Flowable<T> {
    public final K key;

    public GroupedFlowable(@Nullable K k10) {
        this.key = k10;
    }

    @Nullable
    public K getKey() {
        return this.key;
    }
}
