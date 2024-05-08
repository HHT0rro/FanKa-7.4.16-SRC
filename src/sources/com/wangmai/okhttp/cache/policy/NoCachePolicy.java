package com.wangmai.okhttp.cache.policy;

import com.wangmai.okhttp.cache.CacheEntity;
import com.wangmai.okhttp.callback.Callback;
import com.wangmai.okhttp.model.Response;
import com.wangmai.okhttp.request.base.Request;
import com.wangmai.okhttp.utils.ThreadUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NoCachePolicy<T> extends BaseCachePolicy<T> {
    public static final String TAG = "WM_NoCachePolicy";

    public NoCachePolicy(Request<T, ? extends Request> request) {
        super(request);
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public void onError(final Response<T> response) {
        runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.NoCachePolicy.2
            @Override // java.lang.Runnable
            public void run() {
                NoCachePolicy.this.mCallback.onError(response);
                NoCachePolicy.this.mCallback.onFinish();
            }
        });
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public void onSuccess(final Response<T> response) {
        runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.NoCachePolicy.1
            @Override // java.lang.Runnable
            public void run() {
                NoCachePolicy.this.mCallback.onSuccess(response);
                NoCachePolicy.this.mCallback.onFinish();
            }
        });
    }

    @Override // com.wangmai.okhttp.cache.policy.CachePolicy
    public void requestAsync(CacheEntity<T> cacheEntity, Callback<T> callback) {
        this.mCallback = callback;
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.NoCachePolicy.3
            @Override // java.lang.Runnable
            public void run() {
                NoCachePolicy.this.runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.NoCachePolicy.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NoCachePolicy noCachePolicy = NoCachePolicy.this;
                        noCachePolicy.mCallback.onStart(noCachePolicy.request);
                    }
                });
                try {
                    NoCachePolicy.this.prepareRawCall();
                    NoCachePolicy.this.requestNetworkAsync();
                } catch (Throwable th) {
                    final Response error = Response.error(false, NoCachePolicy.this.rawCall, null, th);
                    NoCachePolicy.this.runOnUiThread(new Runnable() { // from class: com.wangmai.okhttp.cache.policy.NoCachePolicy.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            NoCachePolicy.this.mCallback.onError(error);
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
            return requestNetworkSync();
        } catch (Throwable th) {
            return Response.error(false, this.rawCall, null, th);
        }
    }
}
