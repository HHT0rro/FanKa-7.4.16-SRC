package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface Observer<T> {
    void onComplete();

    void onError(@NonNull Throwable th);

    void onNext(@NonNull T t2);

    void onSubscribe(@NonNull Disposable disposable);
}
