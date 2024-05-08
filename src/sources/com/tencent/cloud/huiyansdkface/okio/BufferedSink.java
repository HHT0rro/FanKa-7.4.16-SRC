package com.tencent.cloud.huiyansdkface.okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    Buffer buffer();

    BufferedSink emit() throws IOException;

    BufferedSink emitCompleteSegments() throws IOException;

    @Override // com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Flushable
    void flush() throws IOException;

    OutputStream outputStream();

    BufferedSink write(ByteString byteString) throws IOException;

    BufferedSink write(Source source, long j10) throws IOException;

    BufferedSink write(byte[] bArr) throws IOException;

    BufferedSink write(byte[] bArr, int i10, int i11) throws IOException;

    long writeAll(Source source) throws IOException;

    BufferedSink writeByte(int i10) throws IOException;

    BufferedSink writeDecimalLong(long j10) throws IOException;

    BufferedSink writeHexadecimalUnsignedLong(long j10) throws IOException;

    BufferedSink writeInt(int i10) throws IOException;

    BufferedSink writeIntLe(int i10) throws IOException;

    BufferedSink writeLong(long j10) throws IOException;

    BufferedSink writeLongLe(long j10) throws IOException;

    BufferedSink writeShort(int i10) throws IOException;

    BufferedSink writeShortLe(int i10) throws IOException;

    BufferedSink writeString(String str, int i10, int i11, Charset charset) throws IOException;

    BufferedSink writeString(String str, Charset charset) throws IOException;

    BufferedSink writeUtf8(String str) throws IOException;

    BufferedSink writeUtf8(String str, int i10, int i11) throws IOException;

    BufferedSink writeUtf8CodePoint(int i10) throws IOException;
}
