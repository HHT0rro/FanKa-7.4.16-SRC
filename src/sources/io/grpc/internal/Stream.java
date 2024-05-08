package io.grpc.internal;

import io.grpc.Compressor;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface Stream {
    void flush();

    boolean isReady();

    void optimizeForDirectExecutor();

    void request(int i10);

    void setCompressor(Compressor compressor);

    void setMessageCompression(boolean z10);

    void writeMessage(InputStream inputStream);
}
