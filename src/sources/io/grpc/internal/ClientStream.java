package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Status;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ClientStream extends Stream {
    void appendTimeoutInsight(InsightBuilder insightBuilder);

    void cancel(Status status);

    Attributes getAttributes();

    void halfClose();

    void setAuthority(String str);

    void setDeadline(Deadline deadline);

    void setDecompressorRegistry(DecompressorRegistry decompressorRegistry);

    void setFullStreamDecompression(boolean z10);

    void setMaxInboundMessageSize(int i10);

    void setMaxOutboundMessageSize(int i10);

    void start(ClientStreamListener clientStreamListener);
}
