package com.wangmai.okhttp.cache.policy;

import android.graphics.Bitmap;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.cache.CacheEntity;
import com.wangmai.okhttp.cache.CacheMode;
import com.wangmai.okhttp.callback.Callback;
import com.wangmai.okhttp.db.CacheManager;
import com.wangmai.okhttp.exception.HttpException;
import com.wangmai.okhttp.request.base.Request;
import com.wangmai.okhttp.utils.HeaderParser;
import com.wangmai.okhttp.utils.HttpUtils;
import java.io.IOException;
import java.net.SocketTimeoutException;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.Response;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class BaseCachePolicy<T> implements CachePolicy<T> {
    public static final String TAG = "WM_BaseCachePolicy";
    public CacheEntity<T> cacheEntity;
    public volatile boolean canceled;
    public volatile int currentRetryCount = 0;
    public boolean executed;
    public Callback<T> mCallback;
    public Call rawCall;
    public Request<T, ? extends Request> request;

    public BaseCachePolicy(Request<T, ? extends Request> request) {
        this.request = request;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveCache(Headers headers, T t2) {
        if (this.request.getCacheMode() == CacheMode.NO_CACHE || (t2 instanceof Bitmap)) {
            return;
        }
        CacheEntity<T> createCacheEntity = HeaderParser.createCacheEntity(headers, t2, this.request.getCacheMode(), this.request.getCacheKey());
        if (createCacheEntity == null) {
            CacheManager.getInstance().remove(this.request.getCacheKey());
        } else {
            CacheManager.getInstance().replace(this.request.getCacheKey(), createCacheEntity);
        }
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public void cancel() {
        this.canceled = true;
        Call call = this.rawCall;
        if (call != null) {
            call.cancel();
        }
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public boolean isCanceled() {
        boolean z10 = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            Call call = this.rawCall;
            if (call == null || !call.isCanceled()) {
                z10 = false;
            }
        }
        return z10;
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public boolean isExecuted() {
        return this.executed;
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public boolean onAnalysisResponse(Call call, Response response) {
        return false;
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public CacheEntity<T> prepareCache() {
        if (this.request.getCacheKey() == null) {
            Request<T, ? extends Request> request = this.request;
            request.cacheKey(HttpUtils.createUrlFromParams(request.getBaseUrl(), this.request.getParams().urlParamsMap));
        }
        if (this.request.getCacheMode() == null) {
            this.request.cacheMode(CacheMode.NO_CACHE);
        }
        CacheMode cacheMode = this.request.getCacheMode();
        if (cacheMode != CacheMode.NO_CACHE) {
            CacheEntity<T> cacheEntity = (CacheEntity<T>) CacheManager.getInstance().get(this.request.getCacheKey());
            this.cacheEntity = cacheEntity;
            HeaderParser.addCacheHeaders(this.request, cacheEntity, cacheMode);
            CacheEntity<T> cacheEntity2 = this.cacheEntity;
            if (cacheEntity2 != null && cacheEntity2.checkExpire(cacheMode, this.request.getCacheTime(), System.currentTimeMillis())) {
                this.cacheEntity.setExpire(true);
            }
        }
        CacheEntity<T> cacheEntity3 = this.cacheEntity;
        if (cacheEntity3 == null || cacheEntity3.isExpire() || this.cacheEntity.getData() == null || this.cacheEntity.getResponseHeaders() == null) {
            this.cacheEntity = null;
        }
        return this.cacheEntity;
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public synchronized Call prepareRawCall() throws Throwable {
        if (!this.executed) {
            this.executed = true;
            this.rawCall = this.request.getRawCall();
            if (this.canceled) {
                this.rawCall.cancel();
            }
        } else {
            throw HttpException.COMMON("Already executed!");
        }
        return this.rawCall;
    }

    public void requestNetworkAsync() {
        requestNetworkAsync(true);
    }

    public com.wangmai.okhttp.model.Response<T> requestNetworkSync() {
        try {
            Response execute = this.rawCall.execute();
            int code = execute.code();
            if (code != 404 && code < 500) {
                T convertResponse = this.request.getConverter().convertResponse(execute);
                saveCache(execute.headers(), convertResponse);
                return com.wangmai.okhttp.model.Response.success(false, convertResponse, this.rawCall, execute);
            }
            return com.wangmai.okhttp.model.Response.error(false, this.rawCall, execute, HttpException.NET_ERROR());
        } catch (Throwable th) {
            if ((th instanceof SocketTimeoutException) && this.currentRetryCount < this.request.getRetryCount()) {
                this.currentRetryCount++;
                this.rawCall = this.request.getRawCall();
                if (this.canceled) {
                    this.rawCall.cancel();
                } else {
                    requestNetworkSync();
                }
            }
            return com.wangmai.okhttp.model.Response.error(false, this.rawCall, null, th);
        }
    }

    public void runOnUiThread(Runnable runnable) {
        OkHttp.getInstance().getDelivery().post(runnable);
    }

    public void requestNetworkAsync(final boolean z10) {
        this.rawCall.enqueue(new okhttp3.Callback() { // from class: com.wangmai.okhttp.cache.policy.BaseCachePolicy.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if ((iOException instanceof SocketTimeoutException) && BaseCachePolicy.this.currentRetryCount < BaseCachePolicy.this.request.getRetryCount()) {
                    BaseCachePolicy.this.currentRetryCount++;
                    BaseCachePolicy baseCachePolicy = BaseCachePolicy.this;
                    baseCachePolicy.rawCall = baseCachePolicy.request.getRawCall();
                    if (BaseCachePolicy.this.canceled) {
                        BaseCachePolicy.this.rawCall.cancel();
                        return;
                    } else {
                        BaseCachePolicy.this.rawCall.enqueue(this);
                        return;
                    }
                }
                if (call.isCanceled()) {
                    return;
                }
                BaseCachePolicy.this.onError(com.wangmai.okhttp.model.Response.error(false, call, null, iOException));
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                int code = response.code();
                if (code != 404 && code < 500) {
                    if (BaseCachePolicy.this.onAnalysisResponse(call, response)) {
                        return;
                    }
                    try {
                        T convertResponse = BaseCachePolicy.this.request.getConverter().convertResponse(response);
                        BaseCachePolicy.this.saveCache(response.headers(), convertResponse);
                        com.wangmai.okhttp.model.Response<T> success = com.wangmai.okhttp.model.Response.success(false, convertResponse, call, response);
                        if (z10) {
                            BaseCachePolicy.this.onSuccess(success);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        BaseCachePolicy.this.onError(com.wangmai.okhttp.model.Response.error(false, call, response, th));
                        return;
                    }
                }
                BaseCachePolicy.this.onError(com.wangmai.okhttp.model.Response.error(false, call, response, HttpException.NET_ERROR()));
            }
        });
    }
}
