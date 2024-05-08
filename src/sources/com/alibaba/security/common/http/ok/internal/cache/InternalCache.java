package com.alibaba.security.common.http.ok.internal.cache;

import com.alibaba.security.common.http.ok.RPRequest;
import com.alibaba.security.common.http.ok.Response;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface InternalCache {
    Response get(RPRequest rPRequest) throws IOException;

    CacheRequest put(Response response) throws IOException;

    void remove(RPRequest rPRequest) throws IOException;

    void trackConditionalCacheHit();

    void trackResponse(CacheStrategy cacheStrategy);

    void update(Response response, Response response2);
}
