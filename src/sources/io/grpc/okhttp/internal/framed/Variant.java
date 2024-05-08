package io.grpc.okhttp.internal.framed;

import io.grpc.okhttp.internal.Protocol;
import okio.BufferedSink;
import okio.BufferedSource;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface Variant {
    Protocol getProtocol();

    FrameReader newReader(BufferedSource bufferedSource, boolean z10);

    FrameWriter newWriter(BufferedSink bufferedSink, boolean z10);
}
