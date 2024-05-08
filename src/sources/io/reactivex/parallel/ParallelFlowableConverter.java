package io.reactivex.parallel;

import io.reactivex.annotations.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ParallelFlowableConverter<T, R> {
    @NonNull
    R apply(@NonNull ParallelFlowable<T> parallelFlowable);
}
