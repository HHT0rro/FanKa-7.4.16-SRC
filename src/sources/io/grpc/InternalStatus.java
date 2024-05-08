package io.grpc;

import io.grpc.Metadata;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class InternalStatus {

    @Internal
    public static final Metadata.Key<String> MESSAGE_KEY = Status.MESSAGE_KEY;

    @Internal
    public static final Metadata.Key<Status> CODE_KEY = Status.CODE_KEY;

    private InternalStatus() {
    }

    @Internal
    public static final StatusRuntimeException asRuntimeException(Status status, Metadata metadata, boolean z10) {
        return new StatusRuntimeException(status, metadata, z10);
    }
}
