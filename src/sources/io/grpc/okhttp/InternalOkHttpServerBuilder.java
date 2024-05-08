package io.grpc.okhttp;

import io.grpc.Internal;
import io.grpc.ServerStreamTracer;
import io.grpc.internal.InternalServer;
import io.grpc.internal.TransportTracer;
import java.util.List;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class InternalOkHttpServerBuilder {
    private InternalOkHttpServerBuilder() {
    }

    public static InternalServer buildTransportServers(OkHttpServerBuilder okHttpServerBuilder, List<? extends ServerStreamTracer.Factory> list) {
        return okHttpServerBuilder.buildTransportServers(list);
    }

    public static void setStatsEnabled(OkHttpServerBuilder okHttpServerBuilder, boolean z10) {
        okHttpServerBuilder.setStatsEnabled(z10);
    }

    public static void setTransportTracerFactory(OkHttpServerBuilder okHttpServerBuilder, TransportTracer.Factory factory) {
        okHttpServerBuilder.setTransportTracerFactory(factory);
    }
}
