package com.wangmai.okhttp.model;

import okhttp3.Call;
import okhttp3.Headers;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Response<T> {
    public T body;
    public boolean isFromCache;
    public Call rawCall;
    public okhttp3.Response rawResponse;
    public Throwable throwable;

    public static <T> Response<T> error(boolean z10, Call call, okhttp3.Response response, Throwable th) {
        Response<T> response2 = new Response<>();
        response2.setFromCache(z10);
        response2.setRawCall(call);
        response2.setRawResponse(response);
        response2.setException(th);
        return response2;
    }

    public static <T> Response<T> success(boolean z10, T t2, Call call, okhttp3.Response response) {
        Response<T> response2 = new Response<>();
        response2.setFromCache(z10);
        response2.setBody(t2);
        response2.setRawCall(call);
        response2.setRawResponse(response);
        return response2;
    }

    public T body() {
        return this.body;
    }

    public int code() {
        okhttp3.Response response = this.rawResponse;
        if (response == null) {
            return -1;
        }
        return response.code();
    }

    public Throwable getException() {
        return this.throwable;
    }

    public Call getRawCall() {
        return this.rawCall;
    }

    public okhttp3.Response getRawResponse() {
        return this.rawResponse;
    }

    public Headers headers() {
        okhttp3.Response response = this.rawResponse;
        if (response == null) {
            return null;
        }
        return response.headers();
    }

    public boolean isFromCache() {
        return this.isFromCache;
    }

    public boolean isSuccessful() {
        return this.throwable == null;
    }

    public String message() {
        okhttp3.Response response = this.rawResponse;
        if (response == null) {
            return null;
        }
        return response.message();
    }

    public void setBody(T t2) {
        this.body = t2;
    }

    public void setException(Throwable th) {
        this.throwable = th;
    }

    public void setFromCache(boolean z10) {
        this.isFromCache = z10;
    }

    public void setRawCall(Call call) {
        this.rawCall = call;
    }

    public void setRawResponse(okhttp3.Response response) {
        this.rawResponse = response;
    }
}
