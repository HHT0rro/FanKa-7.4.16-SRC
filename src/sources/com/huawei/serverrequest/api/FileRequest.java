package com.huawei.serverrequest.api;

import androidx.annotation.NonNull;
import com.huawei.serverrequest.api.ServerRequest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class FileRequest implements ServerRequest {
    @Override // com.huawei.serverrequest.api.ServerRequest
    public long getCacheExpireTime() {
        return 0L;
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    public String getCacheId() {
        return "non";
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    public String getId() {
        return "non";
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    public ServerRequest.RequestType getRequestType() {
        return ServerRequest.RequestType.REQUEST_SERVER;
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    @NonNull
    public String method() {
        return "GET";
    }
}
