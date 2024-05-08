package com.huawei.serverrequest.api;

import androidx.annotation.NonNull;
import com.huawei.serverrequest.api.service.HttpResponse;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface ServerResponse {

    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface ResponseBody extends HttpResponse {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum ResponseType {
        FROM_CACHE,
        FROM_SERVER
    }

    @NonNull
    ResponseBody getResponse();

    @NonNull
    ResponseType getResponseType();
}
