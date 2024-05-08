package io.grpc.util;

import io.grpc.BindableService;
import io.grpc.ExperimentalApi;
import io.grpc.HandlerRegistry;
import io.grpc.MethodDescriptor;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/933")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class MutableHandlerRegistry extends HandlerRegistry {
    private final ConcurrentMap<String, ServerServiceDefinition> services = new ConcurrentHashMap();

    public ServerServiceDefinition addService(ServerServiceDefinition serverServiceDefinition) {
        return this.services.put(serverServiceDefinition.getServiceDescriptor().getName(), serverServiceDefinition);
    }

    @Override // io.grpc.HandlerRegistry
    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    public List<ServerServiceDefinition> getServices() {
        return Collections.unmodifiableList(new ArrayList(this.services.values()));
    }

    @Override // io.grpc.HandlerRegistry
    public ServerMethodDefinition<?, ?> lookupMethod(String str, String str2) {
        ServerServiceDefinition serverServiceDefinition;
        String extractFullServiceName = MethodDescriptor.extractFullServiceName(str);
        if (extractFullServiceName == null || (serverServiceDefinition = this.services.get(extractFullServiceName)) == null) {
            return null;
        }
        return serverServiceDefinition.getMethod(str);
    }

    public boolean removeService(ServerServiceDefinition serverServiceDefinition) {
        return this.services.remove(serverServiceDefinition.getServiceDescriptor().getName(), serverServiceDefinition);
    }

    public ServerServiceDefinition addService(BindableService bindableService) {
        return addService(bindableService.bindService());
    }
}
