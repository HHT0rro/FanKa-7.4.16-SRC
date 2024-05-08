package com.alibaba.security.common.http.ok.internal.http;

import com.alibaba.security.common.http.ok.MediaType;
import com.alibaba.security.common.http.ok.ResponseBody;
import com.alibaba.security.common.http.okio.BufferedSource;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final BufferedSource source;

    public RealResponseBody(String str, long j10, BufferedSource bufferedSource) {
        this.contentTypeString = str;
        this.contentLength = j10;
        this.source = bufferedSource;
    }

    @Override // com.alibaba.security.common.http.ok.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // com.alibaba.security.common.http.ok.ResponseBody
    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    @Override // com.alibaba.security.common.http.ok.ResponseBody
    public BufferedSource source() {
        return this.source;
    }
}
