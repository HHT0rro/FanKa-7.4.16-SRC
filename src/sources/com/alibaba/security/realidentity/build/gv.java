package com.alibaba.security.realidentity.build;

import com.alibaba.security.common.http.ok.MediaType;
import com.alibaba.security.common.http.ok.ResponseBody;
import com.alibaba.security.common.http.okio.Buffer;
import com.alibaba.security.common.http.okio.BufferedSource;
import com.alibaba.security.common.http.okio.ForwardingSource;
import com.alibaba.security.common.http.okio.RPOkio;
import com.alibaba.security.common.http.okio.Source;
import com.alibaba.security.realidentity.oss.model.OSSRequest;
import java.io.IOException;

/* compiled from: ProgressTouchableResponseBody.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class gv<T extends OSSRequest> extends ResponseBody {

    /* renamed from: a, reason: collision with root package name */
    private final ResponseBody f3777a;

    /* renamed from: b, reason: collision with root package name */
    private by f3778b;

    /* renamed from: c, reason: collision with root package name */
    private BufferedSource f3779c;

    /* renamed from: d, reason: collision with root package name */
    private T f3780d;

    /* compiled from: ProgressTouchableResponseBody.java */
    /* renamed from: com.alibaba.security.realidentity.build.gv$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class AnonymousClass1 extends ForwardingSource {

        /* renamed from: b, reason: collision with root package name */
        private long f3782b;

        public AnonymousClass1(Source source) {
            super(source);
            this.f3782b = 0L;
        }

        @Override // com.alibaba.security.common.http.okio.ForwardingSource, com.alibaba.security.common.http.okio.Source
        public final long read(Buffer buffer, long j10) throws IOException {
            long read = super.read(buffer, j10);
            this.f3782b += read != -1 ? read : 0L;
            if (gv.this.f3778b != null && read != -1 && this.f3782b != 0) {
                by byVar = gv.this.f3778b;
                OSSRequest unused = gv.this.f3780d;
                byVar.a(this.f3782b, gv.this.f3777a.contentLength());
            }
            return read;
        }
    }

    public gv(ResponseBody responseBody, gr grVar) {
        this.f3777a = responseBody;
        this.f3778b = grVar.f3761f;
        this.f3780d = (T) grVar.f3756a;
    }

    @Override // com.alibaba.security.common.http.ok.ResponseBody
    public final long contentLength() {
        return this.f3777a.contentLength();
    }

    @Override // com.alibaba.security.common.http.ok.ResponseBody
    public final MediaType contentType() {
        return this.f3777a.contentType();
    }

    @Override // com.alibaba.security.common.http.ok.ResponseBody
    public final BufferedSource source() {
        if (this.f3779c == null) {
            this.f3779c = RPOkio.buffer(new AnonymousClass1(this.f3777a.source()));
        }
        return this.f3779c;
    }

    private Source a(Source source) {
        return new AnonymousClass1(source);
    }
}
