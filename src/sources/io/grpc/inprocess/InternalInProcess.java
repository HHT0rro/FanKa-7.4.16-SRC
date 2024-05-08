package io.grpc.inprocess;

import io.grpc.Attributes;
import io.grpc.Internal;
import io.grpc.ServerStreamTracer;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerListener;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class InternalInProcess {
    private InternalInProcess() {
    }

    @Internal
    public static ConnectionClientTransport createInProcessTransport(String str, int i10, String str2, String str3, Attributes attributes, ObjectPool<ScheduledExecutorService> objectPool, List<ServerStreamTracer.Factory> list, ServerListener serverListener, boolean z10) {
        return new InProcessTransport(str, i10, str2, str3, attributes, objectPool, list, serverListener, z10);
    }
}
