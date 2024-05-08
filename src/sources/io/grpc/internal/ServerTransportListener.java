package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.Metadata;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ServerTransportListener {
    void streamCreated(ServerStream serverStream, String str, Metadata metadata);

    Attributes transportReady(Attributes attributes);

    void transportTerminated();
}
