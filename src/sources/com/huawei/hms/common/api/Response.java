package com.huawei.hms.common.api;

import com.huawei.hms.support.api.client.Result;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Response<T extends Result> {
    public T result;

    public Response() {
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T t2) {
        this.result = t2;
    }

    public Response(T t2) {
        this.result = t2;
    }
}
