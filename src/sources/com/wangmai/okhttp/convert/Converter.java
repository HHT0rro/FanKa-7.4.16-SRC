package com.wangmai.okhttp.convert;

import okhttp3.Response;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface Converter<T> {
    T convertResponse(Response response) throws Throwable;
}
