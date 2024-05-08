package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* compiled from: ListenableFuture.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface n<V> extends Future<V> {
    void addListener(Runnable runnable, Executor executor);
}
