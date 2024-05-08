package com.huawei.hmf.taskstream;

import java.util.concurrent.Executor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface TaskStream<TResult> {
    Disposable subscribe(Consumer<TResult> consumer);

    Disposable subscribe(Consumer<TResult> consumer, Consumer<? super Exception> consumer2);

    void subscribe(Observer<TResult> observer);

    void subscribe(Executor executor, Observer<TResult> observer);
}
