package com.wangmai.okhttp.callback;

import com.wangmai.okhttp.convert.Converter;
import com.wangmai.okhttp.model.Progress;
import com.wangmai.okhttp.model.Response;
import com.wangmai.okhttp.request.base.Request;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface Callback<T> extends Converter<T> {
    void downloadProgress(Progress progress);

    void onCacheSuccess(Response<T> response);

    void onError(Response<T> response);

    void onFinish();

    void onStart(Request<T, ? extends Request> request);

    void onSuccess(Response<T> response);

    void uploadProgress(Progress progress);
}
