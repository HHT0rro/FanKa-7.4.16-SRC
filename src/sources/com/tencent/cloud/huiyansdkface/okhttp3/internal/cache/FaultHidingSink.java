package com.tencent.cloud.huiyansdkface.okhttp3.internal.cache;

import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.ForwardingSink;
import com.tencent.cloud.huiyansdkface.okio.Sink;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
class FaultHidingSink extends ForwardingSink {

    /* renamed from: a, reason: collision with root package name */
    private boolean f41688a;

    public FaultHidingSink(Sink sink) {
        super(sink);
    }

    public void a(IOException iOException) {
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ForwardingSink, com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f41688a) {
            return;
        }
        try {
            super.close();
        } catch (IOException e2) {
            this.f41688a = true;
            a(e2);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ForwardingSink, com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.f41688a) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e2) {
            this.f41688a = true;
            a(e2);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okio.ForwardingSink, com.tencent.cloud.huiyansdkface.okio.Sink
    public void write(Buffer buffer, long j10) throws IOException {
        if (this.f41688a) {
            buffer.skip(j10);
            return;
        }
        try {
            super.write(buffer, j10);
        } catch (IOException e2) {
            this.f41688a = true;
            a(e2);
        }
    }
}
