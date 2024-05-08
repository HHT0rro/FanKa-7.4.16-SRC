package com.wangmai.okhttp.cache.policy;

import com.wangmai.okhttp.cache.CacheEntity;
import com.wangmai.okhttp.callback.Callback;
import com.wangmai.okhttp.exception.CacheException;
import com.wangmai.okhttp.request.base.Request;
import com.wangmai.okhttp.utils.ThreadUtils;
import okhttp3.Call;
import okhttp3.Response;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DefaultCachePolicy<T> extends BaseCachePolicy<T> {
    public static final String TAG = "WM_DefaultCachePolicy";

    public DefaultCachePolicy(Request<T, ? extends Request> request) {
        super(request);
    }

    @Override // com.wangmai.okhttp.cache.policy.BaseCachePolicy, com.wangmai.okhttp.cache.policy.CachePolicy
    public boolean onAnalysisResponse(Call call, Response response) {
        if (response.code() != 304) {
            return false;
        }
        CacheEntity<T> cacheEntity = this.cacheEntity;
        if (cacheEntity == null) {
            final com.wangmai.okhttp.model.Response error = com.wangmai.okhttp.model.Response.error(true, call, response, CacheException.NON_AND_304(this.request.getCacheKey()));
            runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.DefaultCachePolicy.3
                @Override // java.lang.Runnable
                public void run() {
                    DefaultCachePolicy.this.mCallback.onError(error);
                    DefaultCachePolicy.this.mCallback.onFinish();
                }
            });
        } else {
            final com.wangmai.okhttp.model.Response success = com.wangmai.okhttp.model.Response.success(true, cacheEntity.getData(), call, response);
            runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.DefaultCachePolicy.4
                @Override // java.lang.Runnable
                public void run() {
                    DefaultCachePolicy.this.mCallback.onCacheSuccess(success);
                    DefaultCachePolicy.this.mCallback.onFinish();
                }
            });
        }
        return true;
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public void onError(final com.wangmai.okhttp.model.Response<T> response) {
        runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.DefaultCachePolicy.2
            @Override // java.lang.Runnable
            public void run() {
                DefaultCachePolicy.this.mCallback.onError(response);
                DefaultCachePolicy.this.mCallback.onFinish();
            }
        });
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public void onSuccess(final com.wangmai.okhttp.model.Response<T> response) {
        runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.DefaultCachePolicy.1
            @Override // java.lang.Runnable
            public void run() {
                DefaultCachePolicy.this.mCallback.onSuccess(response);
                DefaultCachePolicy.this.mCallback.onFinish();
            }
        });
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public void requestAsync(CacheEntity<T> cacheEntity, Callback<T> callback) {
        this.mCallback = callback;
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.DefaultCachePolicy.5
            @Override // java.lang.Runnable
            public void run() {
                DefaultCachePolicy.this.runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.DefaultCachePolicy.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DefaultCachePolicy defaultCachePolicy = DefaultCachePolicy.this;
                        defaultCachePolicy.mCallback.onStart(defaultCachePolicy.request);
                    }
                });
                try {
                    DefaultCachePolicy.this.prepareRawCall();
                    DefaultCachePolicy.this.requestNetworkAsync();
                } catch (Throwable th) {
                    final com.wangmai.okhttp.model.Response error = com.wangmai.okhttp.model.Response.error(false, DefaultCachePolicy.this.rawCall, null, th);
                    DefaultCachePolicy.this.runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.DefaultCachePolicy.5.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DefaultCachePolicy.this.mCallback.onError(error);
                        }
                    });
                }
            }
        });
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public com.wangmai.okhttp.model.Response<T> requestSync(CacheEntity<T> cacheEntity) {
        try {
            prepareRawCall();
            com.wangmai.okhttp.model.Response<T> requestNetworkSync = requestNetworkSync();
            if (!requestNetworkSync.isSuccessful() || requestNetworkSync.code() != 304) {
                return requestNetworkSync;
            }
            if (cacheEntity == null) {
                return com.wangmai.okhttp.model.Response.error(true, this.rawCall, requestNetworkSync.getRawResponse(), CacheException.NON_AND_304(this.request.getCacheKey()));
            }
            return com.wangmai.okhttp.model.Response.success(true, cacheEntity.getData(), this.rawCall, requestNetworkSync.getRawResponse());
        } catch (Throwable th) {
            return com.wangmai.okhttp.model.Response.error(false, this.rawCall, null, th);
        }
    }
}
