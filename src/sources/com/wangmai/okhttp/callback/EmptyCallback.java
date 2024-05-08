package com.wangmai.okhttp.callback;

import okhttp3.Response;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class EmptyCallback extends AbsCallback<Object> {
    @Override // com.wangmai.okhttp.convert.Converter
    public Object convertResponse(Response response) throws Throwable {
        return null;
    }

    @Override // com.wangmai.okhttp.callback.Callback
    public void onSuccess(com.wangmai.okhttp.model.Response<Object> response) {
    }
}
