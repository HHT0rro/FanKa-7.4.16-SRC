package io.grpc.internal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ServerListener {
    void serverShutdown();

    ServerTransportListener transportCreated(ServerTransport serverTransport);
}
