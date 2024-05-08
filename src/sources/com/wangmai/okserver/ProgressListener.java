package com.wangmai.okserver;

import com.wangmai.okhttp.model.Progress;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface ProgressListener<T> {
    void onError(Progress progress);

    void onFinish(T t2, Progress progress);

    void onProgress(Progress progress);

    void onRemove(Progress progress);

    void onStart(Progress progress);
}
