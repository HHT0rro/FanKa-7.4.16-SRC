package io.grpc;

import com.google.common.base.o;
import io.grpc.ServerProvider;
import io.grpc.ServiceProviders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Logger;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ServerRegistry {
    private static ServerRegistry instance;
    private static final Logger logger = Logger.getLogger(ServerRegistry.class.getName());
    private final LinkedHashSet<ServerProvider> allProviders = new LinkedHashSet<>();
    private List<ServerProvider> effectiveProviders = Collections.emptyList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ProviderNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public ProviderNotFoundException(String str) {
            super(str);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ServerPriorityAccessor implements ServiceProviders.PriorityAccessor<ServerProvider> {
        private ServerPriorityAccessor() {
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public int getPriority(ServerProvider serverProvider) {
            return serverProvider.priority();
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public boolean isAvailable(ServerProvider serverProvider) {
            return serverProvider.isAvailable();
        }
    }

    private synchronized void addProvider(ServerProvider serverProvider) {
        o.e(serverProvider.isAvailable(), "isAvailable() returned false");
        this.allProviders.add(serverProvider);
    }

    public static synchronized ServerRegistry getDefaultRegistry() {
        ServerRegistry serverRegistry;
        synchronized (ServerRegistry.class) {
            if (instance == null) {
                List<ServerProvider> loadAll = ServiceProviders.loadAll(ServerProvider.class, Collections.emptyList(), ServerProvider.class.getClassLoader(), new ServerPriorityAccessor());
                instance = new ServerRegistry();
                for (ServerProvider serverProvider : loadAll) {
                    logger.fine("Service loader found " + ((Object) serverProvider));
                    instance.addProvider(serverProvider);
                }
                instance.refreshProviders();
            }
            serverRegistry = instance;
        }
        return serverRegistry;
    }

    private synchronized void refreshProviders() {
        ArrayList arrayList = new ArrayList(this.allProviders);
        Collections.sort(arrayList, Collections.reverseOrder(new Comparator<ServerProvider>() { // from class: io.grpc.ServerRegistry.1
            @Override // java.util.Comparator
            public int compare(ServerProvider serverProvider, ServerProvider serverProvider2) {
                return serverProvider.priority() - serverProvider2.priority();
            }
        }));
        this.effectiveProviders = Collections.unmodifiableList(arrayList);
    }

    public synchronized void deregister(ServerProvider serverProvider) {
        this.allProviders.remove(serverProvider);
        refreshProviders();
    }

    public ServerBuilder<?> newServerBuilderForPort(int i10, ServerCredentials serverCredentials) {
        if (!providers().isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            for (ServerProvider serverProvider : providers()) {
                ServerProvider.NewServerBuilderResult newServerBuilderForPort = serverProvider.newServerBuilderForPort(i10, serverCredentials);
                if (newServerBuilderForPort.getServerBuilder() != null) {
                    return newServerBuilderForPort.getServerBuilder();
                }
                sb2.append("; ");
                sb2.append(serverProvider.getClass().getName());
                sb2.append(": ");
                sb2.append(newServerBuilderForPort.getError());
            }
            throw new ProviderNotFoundException(sb2.substring(2));
        }
        throw new ProviderNotFoundException("No functional server found. Try adding a dependency on the grpc-netty or grpc-netty-shaded artifact");
    }

    public ServerProvider provider() {
        List<ServerProvider> providers = providers();
        if (providers.isEmpty()) {
            return null;
        }
        return providers.get(0);
    }

    public synchronized List<ServerProvider> providers() {
        return this.effectiveProviders;
    }

    public synchronized void register(ServerProvider serverProvider) {
        addProvider(serverProvider);
        refreshProviders();
    }
}
