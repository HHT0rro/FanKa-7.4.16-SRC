package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: Uninterruptibles.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class w {
    public static <V> V a(Future<V> future) throws ExecutionException {
        V v2;
        boolean z10 = false;
        while (true) {
            try {
                v2 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v2;
    }
}
