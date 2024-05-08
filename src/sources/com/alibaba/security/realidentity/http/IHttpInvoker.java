package com.alibaba.security.realidentity.http;

import com.alibaba.security.realidentity.http.base.BusinessHttpWrapper;
import com.alibaba.security.realidentity.http.base.RetrofitHttpCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IHttpInvoker {
    void dynamic(BusinessHttpWrapper businessHttpWrapper, RetrofitHttpCallback retrofitHttpCallback);

    void normal(BusinessHttpWrapper businessHttpWrapper, RetrofitHttpCallback retrofitHttpCallback);

    void start(BusinessHttpWrapper businessHttpWrapper, RetrofitHttpCallback retrofitHttpCallback);

    void submit(BusinessHttpWrapper businessHttpWrapper, RetrofitHttpCallback retrofitHttpCallback);

    void upload(BusinessHttpWrapper businessHttpWrapper, RetrofitHttpCallback retrofitHttpCallback);
}
