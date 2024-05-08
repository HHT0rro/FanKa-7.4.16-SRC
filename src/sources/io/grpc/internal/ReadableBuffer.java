package io.grpc.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ReadableBuffer extends Closeable {
    byte[] array();

    int arrayOffset();

    boolean byteBufferSupported();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    ByteBuffer getByteBuffer();

    boolean hasArray();

    void mark();

    boolean markSupported();

    ReadableBuffer readBytes(int i10);

    void readBytes(OutputStream outputStream, int i10) throws IOException;

    void readBytes(ByteBuffer byteBuffer);

    void readBytes(byte[] bArr, int i10, int i11);

    int readInt();

    int readUnsignedByte();

    int readableBytes();

    void reset();

    void skipBytes(int i10);
}
