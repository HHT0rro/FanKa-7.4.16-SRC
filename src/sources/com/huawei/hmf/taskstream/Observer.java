package com.huawei.hmf.taskstream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface Observer<TResult> {
    void onComplete();

    void onFailure(Exception exc);

    void onNext(TResult tresult);

    void onSubscribe(Disposable disposable);
}
