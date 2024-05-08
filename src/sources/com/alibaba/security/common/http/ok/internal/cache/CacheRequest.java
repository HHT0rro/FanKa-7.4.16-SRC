package com.alibaba.security.common.http.ok.internal.cache;

import com.alibaba.security.common.http.okio.Sink;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface CacheRequest {
    void abort();

    Sink body() throws IOException;
}
