package com.alibaba.security.realidentity.build;

import com.alibaba.security.common.http.ok.MediaType;
import com.alibaba.security.common.http.ok.RequestBody;
import com.alibaba.security.common.http.okio.BufferedSink;
import com.alibaba.security.common.http.okio.RPOkio;
import com.alibaba.security.common.http.okio.Source;
import com.alibaba.security.realidentity.oss.model.OSSRequest;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProgressTouchableRequestBody.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gu<T extends OSSRequest> extends RequestBody {

    /* renamed from: a, reason: collision with root package name */
    private static final int f3771a = 2048;

    /* renamed from: b, reason: collision with root package name */
    private InputStream f3772b;

    /* renamed from: c, reason: collision with root package name */
    private String f3773c;

    /* renamed from: d, reason: collision with root package name */
    private long f3774d;

    /* renamed from: e, reason: collision with root package name */
    private by f3775e;

    /* renamed from: f, reason: collision with root package name */
    private T f3776f;

    public gu(InputStream inputStream, long j10, String str, gr grVar) {
        this.f3772b = inputStream;
        this.f3773c = str;
        this.f3774d = j10;
        this.f3775e = grVar.f3761f;
        this.f3776f = (T) grVar.f3756a;
    }

    @Override // com.alibaba.security.common.http.ok.RequestBody
    public final long contentLength() throws IOException {
        return this.f3774d;
    }

    @Override // com.alibaba.security.common.http.ok.RequestBody
    public final MediaType contentType() {
        return MediaType.parse(this.f3773c);
    }

    @Override // com.alibaba.security.common.http.ok.RequestBody
    public final void writeTo(BufferedSink bufferedSink) throws IOException {
        Source source = RPOkio.source(this.f3772b);
        long j10 = 0;
        while (true) {
            long j11 = this.f3774d;
            if (j10 >= j11) {
                break;
            }
            long read = source.read(bufferedSink.buffer(), Math.min(j11 - j10, 2048L));
            if (read == -1) {
                break;
            }
            j10 += read;
            bufferedSink.flush();
            by byVar = this.f3775e;
            if (byVar != null && j10 != 0) {
                byVar.a(j10, this.f3774d);
            }
        }
        if (source != null) {
            source.close();
        }
    }
}
