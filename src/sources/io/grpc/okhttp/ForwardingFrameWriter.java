package io.grpc.okhttp;

import com.google.common.base.o;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.FrameWriter;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.Settings;
import java.io.IOException;
import java.util.List;
import okio.Buffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
abstract class ForwardingFrameWriter implements FrameWriter {
    private final FrameWriter delegate;

    public ForwardingFrameWriter(FrameWriter frameWriter) {
        this.delegate = (FrameWriter) o.s(frameWriter, "delegate");
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void ackSettings(Settings settings) throws IOException {
        this.delegate.ackSettings(settings);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void connectionPreface() throws IOException {
        this.delegate.connectionPreface();
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void data(boolean z10, int i10, Buffer buffer, int i11) throws IOException {
        this.delegate.data(z10, i10, buffer, i11);
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void goAway(int i10, ErrorCode errorCode, byte[] bArr) throws IOException {
        this.delegate.goAway(i10, errorCode, bArr);
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void headers(int i10, List<Header> list) throws IOException {
        this.delegate.headers(i10, list);
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public int maxDataLength() {
        return this.delegate.maxDataLength();
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void ping(boolean z10, int i10, int i11) throws IOException {
        this.delegate.ping(z10, i10, i11);
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void pushPromise(int i10, int i11, List<Header> list) throws IOException {
        this.delegate.pushPromise(i10, i11, list);
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void rstStream(int i10, ErrorCode errorCode) throws IOException {
        this.delegate.rstStream(i10, errorCode);
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void settings(Settings settings) throws IOException {
        this.delegate.settings(settings);
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void synReply(boolean z10, int i10, List<Header> list) throws IOException {
        this.delegate.synReply(z10, i10, list);
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void synStream(boolean z10, boolean z11, int i10, int i11, List<Header> list) throws IOException {
        this.delegate.synStream(z10, z11, i10, i11, list);
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void windowUpdate(int i10, long j10) throws IOException {
        this.delegate.windowUpdate(i10, j10);
    }
}
