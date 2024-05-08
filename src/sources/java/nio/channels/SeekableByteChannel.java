package java.nio.channels;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface SeekableByteChannel extends ByteChannel {
    long position() throws IOException;

    SeekableByteChannel position(long j10) throws IOException;

    @Override // java.nio.channels.ReadableByteChannel
    int read(ByteBuffer byteBuffer) throws IOException;

    long size() throws IOException;

    SeekableByteChannel truncate(long j10) throws IOException;

    int write(ByteBuffer byteBuffer) throws IOException;
}
