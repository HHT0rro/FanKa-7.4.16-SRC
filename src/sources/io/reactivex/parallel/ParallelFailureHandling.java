package io.reactivex.parallel;

import io.reactivex.functions.BiFunction;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public enum ParallelFailureHandling implements BiFunction<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    @Override // io.reactivex.functions.BiFunction
    public ParallelFailureHandling apply(Long l10, Throwable th) {
        return this;
    }
}
