package com.wangmai.okhttp.adapter;

import com.wangmai.okhttp.cache.CacheMode;
import com.wangmai.okhttp.cache.policy.CachePolicy;
import com.wangmai.okhttp.cache.policy.DefaultCachePolicy;
import com.wangmai.okhttp.cache.policy.FirstCacheRequestPolicy;
import com.wangmai.okhttp.cache.policy.NoCachePolicy;
import com.wangmai.okhttp.cache.policy.NoneCacheRequestPolicy;
import com.wangmai.okhttp.cache.policy.RequestFailedCachePolicy;
import com.wangmai.okhttp.callback.Callback;
import com.wangmai.okhttp.model.Response;
import com.wangmai.okhttp.request.base.Request;
import com.wangmai.okhttp.utils.HttpUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CacheCall<T> implements Call<T> {
    public CachePolicy<T> policy;
    public Request<T, ? extends Request> request;

    /* renamed from: com.wangmai.okhttp.adapter.CacheCall$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$wangmai$okhttp$cache$CacheMode;

        static {
            int[] iArr = new int[CacheMode.values().length];
            $SwitchMap$com$wangmai$okhttp$cache$CacheMode = iArr;
            try {
                iArr[CacheMode.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$wangmai$okhttp$cache$CacheMode[CacheMode.IF_NONE_CACHE_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$wangmai$okhttp$cache$CacheMode[CacheMode.FIRST_CACHE_THEN_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$wangmai$okhttp$cache$CacheMode[CacheMode.REQUEST_FAILED_READ_CACHE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$wangmai$okhttp$cache$CacheMode[CacheMode.NO_CACHE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public CacheCall(Request<T, ? extends Request> request) {
        this.policy = null;
        this.request = request;
        this.policy = preparePolicy();
    }

    private CachePolicy<T> preparePolicy() {
        if (this.request.getCacheMode() == null) {
            this.request.cacheMode(CacheMode.NO_CACHE);
        }
        int i10 = AnonymousClass1.$SwitchMap$com$wangmai$okhttp$cache$CacheMode[this.request.getCacheMode().ordinal()];
        if (i10 == 1) {
            this.policy = new DefaultCachePolicy(this.request);
        } else if (i10 == 2) {
            this.policy = new NoneCacheRequestPolicy(this.request);
        } else if (i10 == 3) {
            this.policy = new FirstCacheRequestPolicy(this.request);
        } else if (i10 != 4) {
            this.policy = new NoCachePolicy(this.request);
        } else {
            this.policy = new RequestFailedCachePolicy(this.request);
        }
        if (this.request.getCachePolicy() != null) {
            this.policy = this.request.getCachePolicy();
        }
        HttpUtils.checkNotNull(this.policy, "policy == null");
        return this.policy;
    }

    @Override // com.wangmai.okhttp.adapter.Call
    public void cancel() {
        this.policy.cancel();
    }

    @Override // com.wangmai.okhttp.adapter.Call
    public Response<T> execute() {
        return this.policy.requestSync(this.policy.prepareCache());
    }

    @Override // com.wangmai.okhttp.adapter.Call
    public Request getRequest() {
        return this.request;
    }

    @Override // com.wangmai.okhttp.adapter.Call
    public boolean isCanceled() {
        return this.policy.isCanceled();
    }

    @Override // com.wangmai.okhttp.adapter.Call
    public boolean isExecuted() {
        return this.policy.isExecuted();
    }

    @Override // com.wangmai.okhttp.adapter.Call
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Call<T> m2930clone() {
        return new CacheCall(this.request);
    }

    @Override // com.wangmai.okhttp.adapter.Call
    public void execute(Callback<T> callback) {
        HttpUtils.checkNotNull(callback, "callback == null");
        this.policy.requestAsync(this.policy.prepareCache(), callback);
    }
}
