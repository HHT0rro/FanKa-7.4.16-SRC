package io.grpc.stub;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface StreamObserver<V> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(V v2);
}
