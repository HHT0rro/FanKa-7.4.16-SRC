package io.grpc;

import java.nio.ByteBuffer;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/7387")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface HasByteBuffer {
    boolean byteBufferSupported();

    ByteBuffer getByteBuffer();
}
