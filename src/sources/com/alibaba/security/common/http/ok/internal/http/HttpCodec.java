package com.alibaba.security.common.http.ok.internal.http;

import com.alibaba.security.common.http.ok.RPRequest;
import com.alibaba.security.common.http.ok.Response;
import com.alibaba.security.common.http.ok.ResponseBody;
import com.alibaba.security.common.http.okio.Sink;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface HttpCodec {
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    void cancel();

    Sink createRequestBody(RPRequest rPRequest, long j10);

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    ResponseBody openResponseBody(Response response) throws IOException;

    Response.Builder readResponseHeaders(boolean z10) throws IOException;

    void writeRequestHeaders(RPRequest rPRequest) throws IOException;
}
