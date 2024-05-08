package com.wangmai.okhttp.callback;

import com.wangmai.okhttp.model.Progress;
import com.wangmai.okhttp.model.Response;
import com.wangmai.okhttp.request.base.Request;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class AbsCallback<T> implements Callback<T> {
    @Override // com.wangmai.okhttp.callback.Callback
    public void downloadProgress(Progress progress) {
    }

    @Override // com.wangmai.okhttp.callback.Callback
    public void onCacheSuccess(Response<T> response) {
    }

    @Override // com.wangmai.okhttp.callback.Callback
    public void onError(Response<T> response) {
    }

    @Override // com.wangmai.okhttp.callback.Callback
    public void onFinish() {
    }

    @Override // com.wangmai.okhttp.callback.Callback
    public void onStart(Request<T, ? extends Request> request) {
    }

    @Override // com.wangmai.okhttp.callback.Callback
    public void uploadProgress(Progress progress) {
    }
}
