package com.huawei.serverrequest.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface ServerRequest {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public @interface METHOD {
        public static final String GET = "GET";
        public static final String POST = "POST";
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public enum RequestType {
        REQUEST_SERVER,
        REQUEST_CACHE,
        REQUEST_CACHE_OTHERWISE_SERVER
    }

    @NonNull
    String getBody() throws Exception;

    long getCacheExpireTime();

    String getCacheId();

    @Nullable
    String getContentType();

    @NonNull
    Map<String, String> getHeaders();

    String getId();

    RequestType getRequestType();

    @NonNull
    String getUrl();

    @NonNull
    @METHOD
    String method();
}
