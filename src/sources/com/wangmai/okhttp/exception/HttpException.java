package com.wangmai.okhttp.exception;

import com.wangmai.okhttp.model.Response;
import com.wangmai.okhttp.utils.HttpUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HttpException extends RuntimeException {
    public static final long serialVersionUID = 8773734741709178425L;
    public int code;
    public String message;
    public transient Response<?> response;

    public HttpException(String str) {
        super(str);
    }

    public static HttpException COMMON(String str) {
        return new HttpException(str);
    }

    public static HttpException NET_ERROR() {
        return new HttpException("network error! http response code is 404 or 5xx!");
    }

    public static String getMessage(Response<?> response) {
        HttpUtils.checkNotNull(response, "response == null");
        return "HTTP " + response.code() + " " + response.message();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public Response<?> response() {
        return this.response;
    }

    public HttpException(Response<?> response) {
        super(getMessage(response));
        this.code = response.code();
        this.message = response.message();
        this.response = response;
    }
}
