package com.alibaba.security.realidentity.build;

import com.alibaba.security.realidentity.business.bucket.HttpBucketParams;
import com.alibaba.security.realidentity.http.base.RetrofitHttpCallback;
import com.alibaba.security.realidentity.http.model.HttpResponse;

/* compiled from: BusinessHttpCallback.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class w extends RetrofitHttpCallback {

    /* renamed from: a, reason: collision with root package name */
    private HttpBucketParams f3989a;

    public w(HttpBucketParams httpBucketParams) {
        this.f3989a = httpBucketParams;
    }

    public abstract void a(HttpBucketParams httpBucketParams);

    public abstract void b(HttpBucketParams httpBucketParams);

    @Override // com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
    public void onFailure(HttpResponse httpResponse) {
        HttpBucketParams httpBucketParams = this.f3989a;
        if (httpBucketParams != null) {
            httpBucketParams.transform(httpResponse);
        }
        b(this.f3989a);
    }

    @Override // com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
    public abstract void onNetError(Exception exc);

    @Override // com.alibaba.security.realidentity.http.base.RetrofitHttpCallback
    public void onSuccess(HttpResponse httpResponse) {
        HttpBucketParams httpBucketParams = this.f3989a;
        if (httpBucketParams != null) {
            httpBucketParams.transform(httpResponse);
        }
        a(this.f3989a);
    }
}
