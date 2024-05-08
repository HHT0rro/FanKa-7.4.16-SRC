package java.nio.channels;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public interface GatheringByteChannel extends WritableByteChannel {
    long write(ByteBuffer[] byteBufferArr) throws IOException;

    long write(ByteBuffer[] byteBufferArr, int i10, int i11) throws IOException;
}
