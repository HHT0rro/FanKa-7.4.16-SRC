package io.grpc.internal;

import io.grpc.Status;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ManagedClientTransport extends ClientTransport {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Listener {
        void transportInUse(boolean z10);

        void transportReady();

        void transportShutdown(Status status);

        void transportTerminated();
    }

    void shutdown(Status status);

    void shutdownNow(Status status);

    Runnable start(Listener listener);
}
