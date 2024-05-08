package com.huawei.serverrequest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.serverrequest.api.ServerRequest;
import com.huawei.serverrequest.api.service.HttpException;
import com.huawei.serverrequest.api.service.HttpRequest;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpRequestImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d implements HttpRequest {

    /* renamed from: c, reason: collision with root package name */
    private static final String f34812c = "ServerRequest";

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ServerRequest f34813a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final String f34814b;

    public d(@NonNull ServerRequest serverRequest) throws HttpException {
        this.f34813a = serverRequest;
        try {
            this.f34814b = serverRequest.getBody();
        } catch (Exception e2) {
            String str = "getBody failed, request: " + ((Object) serverRequest) + ", e: " + e2.getMessage();
            Log.e("ServerRequest", str);
            throw new HttpException(4, str);
        }
    }

    @NonNull
    public ServerRequest a() {
        return this.f34813a;
    }

    @Override // com.huawei.serverrequest.api.service.HttpRequest
    @NonNull
    public String body() {
        return this.f34814b;
    }

    @Override // com.huawei.serverrequest.api.service.HttpRequest
    @Nullable
    public String contentType() {
        return this.f34813a.getContentType();
    }

    @Override // com.huawei.serverrequest.api.service.HttpRequest
    @NonNull
    public Map<String, String> headers() {
        return this.f34813a.getHeaders();
    }

    @Override // com.huawei.serverrequest.api.service.HttpRequest
    @NonNull
    public String method() {
        return this.f34813a.method();
    }

    public String toString() {
        return "HttpRequestImpl { request = " + ((Object) this.f34813a.getClass()) + ", id = " + this.f34813a.getId() + " }";
    }

    @Override // com.huawei.serverrequest.api.service.HttpRequest
    @NonNull
    public String url() {
        return this.f34813a.getUrl();
    }
}
