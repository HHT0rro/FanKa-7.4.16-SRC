package org.reactivestreams;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface Subscriber<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t2);

    void onSubscribe(Subscription subscription);
}
