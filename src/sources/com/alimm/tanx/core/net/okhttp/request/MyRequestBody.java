package com.alimm.tanx.core.net.okhttp.request;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class MyRequestBody extends RequestBody {
    public RequestBody tanxc_do;
    public tanxc_do tanxc_for;
    public Listener tanxc_if;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface Listener {
        void onRequestProgress(long j10, long j11);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public final class tanxc_do extends ForwardingSink {
        public long tanxc_if;

        public tanxc_do(Sink sink) {
            super(sink);
            this.tanxc_if = 0L;
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer buffer, long j10) throws IOException {
            super.write(buffer, j10);
            long j11 = this.tanxc_if + j10;
            this.tanxc_if = j11;
            MyRequestBody myRequestBody = MyRequestBody.this;
            myRequestBody.tanxc_if.onRequestProgress(j11, myRequestBody.contentLength());
        }
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        try {
            return this.tanxc_do.contentLength();
        } catch (IOException e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.tanxc_do.contentType();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        tanxc_do tanxc_doVar = new tanxc_do(bufferedSink);
        this.tanxc_for = tanxc_doVar;
        BufferedSink buffer = Okio.buffer(tanxc_doVar);
        this.tanxc_do.writeTo(buffer);
        buffer.flush();
    }
}
