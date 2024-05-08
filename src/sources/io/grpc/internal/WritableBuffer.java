package io.grpc.internal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface WritableBuffer {
    int readableBytes();

    void release();

    int writableBytes();

    void write(byte b4);

    void write(byte[] bArr, int i10, int i11);
}
