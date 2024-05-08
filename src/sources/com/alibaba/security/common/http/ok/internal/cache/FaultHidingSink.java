package com.alibaba.security.common.http.ok.internal.cache;

import com.alibaba.security.common.http.okio.Buffer;
import com.alibaba.security.common.http.okio.ForwardingSink;
import com.alibaba.security.common.http.okio.Sink;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class FaultHidingSink extends ForwardingSink {
    private boolean hasErrors;

    public FaultHidingSink(Sink sink) {
        super(sink);
    }

    @Override // com.alibaba.security.common.http.okio.ForwardingSink, com.alibaba.security.common.http.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e2) {
            this.hasErrors = true;
            onException(e2);
        }
    }

    @Override // com.alibaba.security.common.http.okio.ForwardingSink, com.alibaba.security.common.http.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e2) {
            this.hasErrors = true;
            onException(e2);
        }
    }

    public void onException(IOException iOException) {
    }

    @Override // com.alibaba.security.common.http.okio.ForwardingSink, com.alibaba.security.common.http.okio.Sink
    public void write(Buffer buffer, long j10) throws IOException {
        if (this.hasErrors) {
            buffer.skip(j10);
            return;
        }
        try {
            super.write(buffer, j10);
        } catch (IOException e2) {
            this.hasErrors = true;
            onException(e2);
        }
    }
}
