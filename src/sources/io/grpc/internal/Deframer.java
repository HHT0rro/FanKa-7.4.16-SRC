package io.grpc.internal;

import io.grpc.Decompressor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface Deframer {
    void close();

    void closeWhenComplete();

    void deframe(ReadableBuffer readableBuffer);

    void request(int i10);

    void setDecompressor(Decompressor decompressor);

    void setFullStreamDecompressor(GzipInflatingBuffer gzipInflatingBuffer);

    void setMaxInboundMessageSize(int i10);
}
