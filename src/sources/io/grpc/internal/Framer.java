package io.grpc.internal;

import io.grpc.Compressor;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface Framer {
    void close();

    void dispose();

    void flush();

    boolean isClosed();

    Framer setCompressor(Compressor compressor);

    void setMaxOutboundMessageSize(int i10);

    Framer setMessageCompression(boolean z10);

    void writePayload(InputStream inputStream);
}
