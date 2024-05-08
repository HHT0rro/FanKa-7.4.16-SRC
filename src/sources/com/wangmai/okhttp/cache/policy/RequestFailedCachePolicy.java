package com.wangmai.okhttp.cache.policy;

import com.wangmai.okhttp.cache.CacheEntity;
import com.wangmai.okhttp.callback.Callback;
import com.wangmai.okhttp.model.Response;
import com.wangmai.okhttp.request.base.Request;
import com.wangmai.okhttp.utils.ThreadUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class RequestFailedCachePolicy<T> extends BaseCachePolicy<T> {
    public static final String TAG = "WM_RequestFailedCache";

    public RequestFailedCachePolicy(Request<T, ? extends Request> request) {
        super(request);
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public void onError(final Response<T> response) {
        CacheEntity<T> cacheEntity = this.cacheEntity;
        if (cacheEntity != null) {
            final Response success = Response.success(true, cacheEntity.getData(), response.getRawCall(), response.getRawResponse());
            runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.RequestFailedCachePolicy.2
                @Override // java.lang.Runnable
                public void run() {
                    RequestFailedCachePolicy.this.mCallback.onCacheSuccess(success);
                    RequestFailedCachePolicy.this.mCallback.onFinish();
                }
            });
        } else {
            runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.RequestFailedCachePolicy.3
                @Override // java.lang.Runnable
                public void run() {
                    RequestFailedCachePolicy.this.mCallback.onError(response);
                    RequestFailedCachePolicy.this.mCallback.onFinish();
                }
            });
        }
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public void onSuccess(final Response<T> response) {
        runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.RequestFailedCachePolicy.1
            @Override // java.lang.Runnable
            public void run() {
                RequestFailedCachePolicy.this.mCallback.onSuccess(response);
                RequestFailedCachePolicy.this.mCallback.onFinish();
            }
        });
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public void requestAsync(CacheEntity<T> cacheEntity, Callback<T> callback) {
        this.mCallback = callback;
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.RequestFailedCachePolicy.4
            @Override // java.lang.Runnable
            public void run() {
                RequestFailedCachePolicy.this.runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.RequestFailedCachePolicy.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RequestFailedCachePolicy requestFailedCachePolicy = RequestFailedCachePolicy.this;
                        requestFailedCachePolicy.mCallback.onStart(requestFailedCachePolicy.request);
                    }
                });
                try {
                    RequestFailedCachePolicy.this.prepareRawCall();
                    RequestFailedCachePolicy.this.requestNetworkAsync();
                } catch (Throwable th) {
                    final Response error = Response.error(false, RequestFailedCachePolicy.this.rawCall, null, th);
                    RequestFailedCachePolicy.this.runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.RequestFailedCachePolicy.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            RequestFailedCachePolicy.this.mCallback.onError(error);
                        }
                    });
                }
            }
        });
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public Response<T> requestSync(CacheEntity<T> cacheEntity) {
        try {
            prepareRawCall();
            Response<T> requestNetworkSync = requestNetworkSync();
            return (requestNetworkSync.isSuccessful() || cacheEntity == null) ? requestNetworkSync : Response.success(true, cacheEntity.getData(), this.rawCall, requestNetworkSync.getRawResponse());
        } catch (Throwable th) {
            return Response.error(false, this.rawCall, null, th);
        }
    }
}
