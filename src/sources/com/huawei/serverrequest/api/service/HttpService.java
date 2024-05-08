package com.huawei.serverrequest.api.service;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface HttpService {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface BuildHttpClientDelegate {
        void onBuildHttpClient(@NonNull ClientParams clientParams);
    }

    @NonNull
    HttpResponse execute(@NonNull HttpRequest httpRequest) throws HttpException;

    void setDelegate(@Nullable BuildHttpClientDelegate buildHttpClientDelegate);
}
