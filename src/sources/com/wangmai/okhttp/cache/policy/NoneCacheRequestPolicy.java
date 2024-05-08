package com.wangmai.okhttp.cache.policy;

import com.wangmai.okhttp.cache.CacheEntity;
import com.wangmai.okhttp.callback.Callback;
import com.wangmai.okhttp.model.Response;
import com.wangmai.okhttp.request.base.Request;
import com.wangmai.okhttp.utils.ThreadUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NoneCacheRequestPolicy<T> extends BaseCachePolicy<T> {
    public static final String TAG = "WM_NoneCacheRequest";

    public NoneCacheRequestPolicy(Request<T, ? extends Request> request) {
        super(request);
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public void onError(final Response<T> response) {
        runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.NoneCacheRequestPolicy.2
            @Override // java.lang.Runnable
            public void run() {
                NoneCacheRequestPolicy.this.mCallback.onError(response);
                NoneCacheRequestPolicy.this.mCallback.onFinish();
            }
        });
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public void onSuccess(final Response<T> response) {
        runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.NoneCacheRequestPolicy.1
            @Override // java.lang.Runnable
            public void run() {
                NoneCacheRequestPolicy.this.mCallback.onSuccess(response);
                NoneCacheRequestPolicy.this.mCallback.onFinish();
            }
        });
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public void requestAsync(final CacheEntity<T> cacheEntity, Callback<T> callback) {
        this.mCallback = callback;
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.NoneCacheRequestPolicy.3
            @Override // java.lang.Runnable
            public void run() {
                NoneCacheRequestPolicy.this.runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.NoneCacheRequestPolicy.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NoneCacheRequestPolicy noneCacheRequestPolicy = NoneCacheRequestPolicy.this;
                        noneCacheRequestPolicy.mCallback.onStart(noneCacheRequestPolicy.request);
                    }
                });
                try {
                    NoneCacheRequestPolicy.this.prepareRawCall();
                    CacheEntity cacheEntity2 = cacheEntity;
                    if (cacheEntity2 != null) {
                        final Response success = Response.success(true, cacheEntity2.getData(), NoneCacheRequestPolicy.this.rawCall, null);
                        NoneCacheRequestPolicy.this.runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.NoneCacheRequestPolicy.3.3
                            @Override // java.lang.Runnable
                            public void run() {
                                NoneCacheRequestPolicy.this.mCallback.onCacheSuccess(success);
                                NoneCacheRequestPolicy.this.mCallback.onFinish();
                            }
                        });
                    } else {
                        NoneCacheRequestPolicy.this.requestNetworkAsync();
                    }
                } catch (Throwable th) {
                    final Response error = Response.error(false, NoneCacheRequestPolicy.this.rawCall, null, th);
                    NoneCacheRequestPolicy.this.runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.NoneCacheRequestPolicy.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            NoneCacheRequestPolicy.this.mCallback.onError(error);
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
            Response<T> success = cacheEntity != null ? Response.success(true, cacheEntity.getData(), this.rawCall, null) : null;
            return success == null ? requestNetworkSync() : success;
        } catch (Throwable th) {
            return Response.error(false, this.rawCall, null, th);
        }
    }
}
