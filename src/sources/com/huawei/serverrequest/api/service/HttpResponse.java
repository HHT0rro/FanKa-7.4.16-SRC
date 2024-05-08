package com.huawei.serverrequest.api.service;

import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface HttpResponse {
    void cancel();

    long contentLength();

    Map<String, String> headers();

    InputStream inputStream();

    int statusCode();

    String statusMessage();

    String string() throws HttpException;

    @NonNull
    String url();
}
