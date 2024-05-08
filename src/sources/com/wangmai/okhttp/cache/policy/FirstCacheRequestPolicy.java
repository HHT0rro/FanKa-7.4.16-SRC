package com.wangmai.okhttp.cache.policy;

import com.wangmai.okhttp.cache.CacheEntity;
import com.wangmai.okhttp.callback.Callback;
import com.wangmai.okhttp.model.Response;
import com.wangmai.okhttp.request.base.Request;
import com.wangmai.okhttp.utils.ThreadUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class FirstCacheRequestPolicy<T> extends BaseCachePolicy<T> {
    public static final String TAG = "WM_FirstCacheRequest";

    public FirstCacheRequestPolicy(Request<T, ? extends Request> request) {
        super(request);
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public void onError(final Response<T> response) {
        runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.FirstCacheRequestPolicy.2
            @Override // java.lang.Runnable
            public void run() {
                FirstCacheRequestPolicy.this.mCallback.onError(response);
                FirstCacheRequestPolicy.this.mCallback.onFinish();
            }
        });
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public void onSuccess(final Response<T> response) {
        runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.FirstCacheRequestPolicy.1
            @Override // java.lang.Runnable
            public void run() {
                FirstCacheRequestPolicy.this.mCallback.onSuccess(response);
                FirstCacheRequestPolicy.this.mCallback.onFinish();
            }
        });
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public void requestAsync(final CacheEntity<T> cacheEntity, Callback<T> callback) {
        this.mCallback = callback;
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.FirstCacheRequestPolicy.3
            @Override // java.lang.Runnable
            public void run() {
                FirstCacheRequestPolicy.this.runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.FirstCacheRequestPolicy.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FirstCacheRequestPolicy firstCacheRequestPolicy = FirstCacheRequestPolicy.this;
                        firstCacheRequestPolicy.mCallback.onStart(firstCacheRequestPolicy.request);
                    }
                });
                try {
                    FirstCacheRequestPolicy.this.prepareRawCall();
                    CacheEntity cacheEntity2 = cacheEntity;
                    if (cacheEntity2 != null) {
                        final Response success = Response.success(true, cacheEntity2.getData(), FirstCacheRequestPolicy.this.rawCall, null);
                        FirstCacheRequestPolicy.this.runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.FirstCacheRequestPolicy.3.3
                            @Override // java.lang.Runnable
                            public void run() {
                                FirstCacheRequestPolicy.this.mCallback.onCacheSuccess(success);
                            }
                        });
                    }
                    FirstCacheRequestPolicy.this.requestNetworkAsync();
                } catch (Throwable th) {
                    final Response error = Response.error(false, FirstCacheRequestPolicy.this.rawCall, null, th);
                    FirstCacheRequestPolicy.this.runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.FirstCacheRequestPolicy.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            FirstCacheRequestPolicy.this.mCallback.onError(error);
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
            if (cacheEntity != null) {
                Response.success(true, cacheEntity.getData(), this.rawCall, null);
            }
            Response<T> requestNetworkSync = requestNetworkSync();
            return (requestNetworkSync.isSuccessful() || cacheEntity == null) ? requestNetworkSync : Response.success(true, cacheEntity.getData(), this.rawCall, requestNetworkSync.getRawResponse());
        } catch (Throwable th) {
            return Response.error(false, this.rawCall, null, th);
        }
    }
}
