package io.grpc;

import com.google.common.base.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ServerServiceDefinition {
    private final Map<String, ServerMethodDefinition<?, ?>> methods;
    private final ServiceDescriptor serviceDescriptor;

    public static Builder builder(String str) {
        return new Builder(str);
    }

    @Internal
    public ServerMethodDefinition<?, ?> getMethod(String str) {
        return this.methods.get(str);
    }

    public Collection<ServerMethodDefinition<?, ?>> getMethods() {
        return this.methods.values();
    }

    public ServiceDescriptor getServiceDescriptor() {
        return this.serviceDescriptor;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Builder {
        private final Map<String, ServerMethodDefinition<?, ?>> methods;
        private final ServiceDescriptor serviceDescriptor;
        private final String serviceName;

        public <ReqT, RespT> Builder addMethod(MethodDescriptor<ReqT, RespT> methodDescriptor, ServerCallHandler<ReqT, RespT> serverCallHandler) {
            return addMethod(ServerMethodDefinition.create((MethodDescriptor) o.s(methodDescriptor, "method must not be null"), (ServerCallHandler) o.s(serverCallHandler, "handler must not be null")));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ServerServiceDefinition build() {
            ServiceDescriptor serviceDescriptor = this.serviceDescriptor;
            if (serviceDescriptor == null) {
                ArrayList arrayList = new ArrayList(this.methods.size());
                Iterator<ServerMethodDefinition<?, ?>> iterator2 = this.methods.values().iterator2();
                while (iterator2.hasNext()) {
                    arrayList.add(iterator2.next().getMethodDescriptor());
                }
                serviceDescriptor = new ServiceDescriptor(this.serviceName, arrayList);
            }
            HashMap hashMap = new HashMap(this.methods);
            for (MethodDescriptor<?, ?> methodDescriptor : serviceDescriptor.getMethods()) {
                ServerMethodDefinition serverMethodDefinition = (ServerMethodDefinition) hashMap.remove(methodDescriptor.getFullMethodName());
                if (serverMethodDefinition != null) {
                    if (serverMethodDefinition.getMethodDescriptor() != methodDescriptor) {
                        throw new IllegalStateException("Bound method for " + methodDescriptor.getFullMethodName() + " not same instance as method in service descriptor");
                    }
                } else {
                    throw new IllegalStateException("No method bound for descriptor entry " + methodDescriptor.getFullMethodName());
                }
            }
            if (hashMap.size() <= 0) {
                return new ServerServiceDefinition(serviceDescriptor, this.methods);
            }
            throw new IllegalStateException("No entry in descriptor matching bound method " + ((ServerMethodDefinition) hashMap.values().iterator2().next()).getMethodDescriptor().getFullMethodName());
        }

        private Builder(String str) {
            this.methods = new HashMap();
            this.serviceName = (String) o.s(str, "serviceName");
            this.serviceDescriptor = null;
        }

        public <ReqT, RespT> Builder addMethod(ServerMethodDefinition<ReqT, RespT> serverMethodDefinition) {
            MethodDescriptor<ReqT, RespT> methodDescriptor = serverMethodDefinition.getMethodDescriptor();
            o.n(this.serviceName.equals(methodDescriptor.getServiceName()), "Method name should be prefixed with service name and separated with '/'. Expected service name: '%s'. Actual fully qualifed method name: '%s'.", this.serviceName, methodDescriptor.getFullMethodName());
            String fullMethodName = methodDescriptor.getFullMethodName();
            o.B(!this.methods.containsKey(fullMethodName), "Method by same name already registered: %s", fullMethodName);
            this.methods.put(fullMethodName, serverMethodDefinition);
            return this;
        }

        private Builder(ServiceDescriptor serviceDescriptor) {
            this.methods = new HashMap();
            this.serviceDescriptor = (ServiceDescriptor) o.s(serviceDescriptor, "serviceDescriptor");
            this.serviceName = serviceDescriptor.getName();
        }
    }

    private ServerServiceDefinition(ServiceDescriptor serviceDescriptor, Map<String, ServerMethodDefinition<?, ?>> map) {
        this.serviceDescriptor = (ServiceDescriptor) o.s(serviceDescriptor, "serviceDescriptor");
        this.methods = Collections.unmodifiableMap(new HashMap(map));
    }

    public static Builder builder(ServiceDescriptor serviceDescriptor) {
        return new Builder(serviceDescriptor);
    }
}
