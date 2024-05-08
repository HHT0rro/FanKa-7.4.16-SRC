package com.wangmai.okhttp.adapter;

import com.wangmai.okhttp.callback.Callback;
import com.wangmai.okhttp.model.Response;
import com.wangmai.okhttp.request.base.Request;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface Call<T> {
    void cancel();

    Call<T> clone();

    Response<T> execute() throws Exception;

    void execute(Callback<T> callback);

    Request getRequest();

    boolean isCanceled();

    boolean isExecuted();
}
