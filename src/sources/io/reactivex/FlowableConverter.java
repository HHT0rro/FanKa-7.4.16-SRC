package io.reactivex;

import io.reactivex.annotations.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface FlowableConverter<T, R> {
    @NonNull
    R apply(@NonNull Flowable<T> flowable);
}
