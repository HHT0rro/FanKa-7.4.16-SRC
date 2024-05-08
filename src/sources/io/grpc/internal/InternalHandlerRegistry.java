package io.grpc.internal;

import io.grpc.HandlerRegistry;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class InternalHandlerRegistry extends HandlerRegistry {
    private final Map<String, ServerMethodDefinition<?, ?>> methods;
    private final List<ServerServiceDefinition> services;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Builder {
        private final HashMap<String, ServerServiceDefinition> services = new LinkedHashMap();

        public Builder addService(ServerServiceDefinition serverServiceDefinition) {
            this.services.put(serverServiceDefinition.getServiceDescriptor().getName(), serverServiceDefinition);
            return this;
        }

        public InternalHandlerRegistry build() {
            HashMap hashMap = new HashMap();
            Iterator<ServerServiceDefinition> iterator2 = this.services.values().iterator2();
            while (iterator2.hasNext()) {
                for (ServerMethodDefinition<?, ?> serverMethodDefinition : iterator2.next().getMethods()) {
                    hashMap.put(serverMethodDefinition.getMethodDescriptor().getFullMethodName(), serverMethodDefinition);
                }
            }
            return new InternalHandlerRegistry(Collections.unmodifiableList(new ArrayList(this.services.values())), Collections.unmodifiableMap(hashMap));
        }
    }

    @Override // io.grpc.HandlerRegistry
    public List<ServerServiceDefinition> getServices() {
        return this.services;
    }

    @Override // io.grpc.HandlerRegistry
    public ServerMethodDefinition<?, ?> lookupMethod(String str, String str2) {
        return this.methods.get(str);
    }

    private InternalHandlerRegistry(List<ServerServiceDefinition> list, Map<String, ServerMethodDefinition<?, ?>> map) {
        this.services = list;
        this.methods = map;
    }
}
