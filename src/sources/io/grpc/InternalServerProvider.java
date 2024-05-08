package io.grpc;

import io.grpc.ServerProvider;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class InternalServerProvider {
    private InternalServerProvider() {
    }

    public static ServerBuilder<?> builderForPort(ServerProvider serverProvider, int i10) {
        return serverProvider.builderForPort(i10);
    }

    public static ServerProvider.NewServerBuilderResult newServerBuilderForPort(ServerProvider serverProvider, int i10, ServerCredentials serverCredentials) {
        return serverProvider.newServerBuilderForPort(i10, serverCredentials);
    }
}
