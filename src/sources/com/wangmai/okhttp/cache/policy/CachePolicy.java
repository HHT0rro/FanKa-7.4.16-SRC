package com.wangmai.okhttp.cache.policy;

import com.wangmai.okhttp.cache.CacheEntity;
import com.wangmai.okhttp.callback.Callback;
import okhttp3.Call;
import okhttp3.Response;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface CachePolicy<T> {
    void cancel();

    boolean isCanceled();

    boolean isExecuted();

    boolean onAnalysisResponse(Call call, Response response);

    void onError(com.wangmai.okhttp.model.Response<T> response);

    void onSuccess(com.wangmai.okhttp.model.Response<T> response);

    CacheEntity<T> prepareCache();

    Call prepareRawCall() throws Throwable;

    void requestAsync(CacheEntity<T> cacheEntity, Callback<T> callback);

    com.wangmai.okhttp.model.Response<T> requestSync(CacheEntity<T> cacheEntity);
}
