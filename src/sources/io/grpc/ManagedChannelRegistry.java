package io.grpc;

import com.google.common.base.o;
import io.grpc.ManagedChannelProvider;
import io.grpc.ServiceProviders;
import io.grpc.okhttp.OkHttpChannelProvider;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ManagedChannelRegistry {
    private static ManagedChannelRegistry instance;
    private static final Logger logger = Logger.getLogger(ManagedChannelRegistry.class.getName());
    private final LinkedHashSet<ManagedChannelProvider> allProviders = new LinkedHashSet<>();
    private List<ManagedChannelProvider> effectiveProviders = Collections.emptyList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ManagedChannelPriorityAccessor implements ServiceProviders.PriorityAccessor<ManagedChannelProvider> {
        private ManagedChannelPriorityAccessor() {
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public int getPriority(ManagedChannelProvider managedChannelProvider) {
            return managedChannelProvider.priority();
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public boolean isAvailable(ManagedChannelProvider managedChannelProvider) {
            return managedChannelProvider.isAvailable();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ProviderNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public ProviderNotFoundException(String str) {
            super(str);
        }
    }

    private synchronized void addProvider(ManagedChannelProvider managedChannelProvider) {
        o.e(managedChannelProvider.isAvailable(), "isAvailable() returned false");
        this.allProviders.add(managedChannelProvider);
    }

    public static synchronized ManagedChannelRegistry getDefaultRegistry() {
        ManagedChannelRegistry managedChannelRegistry;
        synchronized (ManagedChannelRegistry.class) {
            if (instance == null) {
                List<ManagedChannelProvider> loadAll = ServiceProviders.loadAll(ManagedChannelProvider.class, getHardCodedClasses(), ManagedChannelProvider.class.getClassLoader(), new ManagedChannelPriorityAccessor());
                instance = new ManagedChannelRegistry();
                for (ManagedChannelProvider managedChannelProvider : loadAll) {
                    logger.fine("Service loader found " + ((Object) managedChannelProvider));
                    instance.addProvider(managedChannelProvider);
                }
                instance.refreshProviders();
            }
            managedChannelRegistry = instance;
        }
        return managedChannelRegistry;
    }

    public static List<Class<?>> getHardCodedClasses() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(OkHttpChannelProvider.class);
        } catch (ClassNotFoundException e2) {
            logger.log(Level.FINE, "Unable to find OkHttpChannelProvider", (Throwable) e2);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
        } catch (ClassNotFoundException e10) {
            logger.log(Level.FINE, "Unable to find NettyChannelProvider", (Throwable) e10);
        }
        try {
            arrayList.add(Class.forName("io.grpc.netty.UdsNettyChannelProvider"));
        } catch (ClassNotFoundException e11) {
            logger.log(Level.FINE, "Unable to find UdsNettyChannelProvider", (Throwable) e11);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private synchronized void refreshProviders() {
        ArrayList arrayList = new ArrayList(this.allProviders);
        Collections.sort(arrayList, Collections.reverseOrder(new Comparator<ManagedChannelProvider>() { // from class: io.grpc.ManagedChannelRegistry.1
            @Override // java.util.Comparator
            public int compare(ManagedChannelProvider managedChannelProvider, ManagedChannelProvider managedChannelProvider2) {
                return managedChannelProvider.priority() - managedChannelProvider2.priority();
            }
        }));
        this.effectiveProviders = Collections.unmodifiableList(arrayList);
    }

    public synchronized void deregister(ManagedChannelProvider managedChannelProvider) {
        this.allProviders.remove(managedChannelProvider);
        refreshProviders();
    }

    public ManagedChannelBuilder<?> newChannelBuilder(String str, ChannelCredentials channelCredentials) {
        return newChannelBuilder(NameResolverRegistry.getDefaultRegistry(), str, channelCredentials);
    }

    public ManagedChannelProvider provider() {
        List<ManagedChannelProvider> providers = providers();
        if (providers.isEmpty()) {
            return null;
        }
        return providers.get(0);
    }

    public synchronized List<ManagedChannelProvider> providers() {
        return this.effectiveProviders;
    }

    public synchronized void register(ManagedChannelProvider managedChannelProvider) {
        addProvider(managedChannelProvider);
        refreshProviders();
    }

    public ManagedChannelBuilder<?> newChannelBuilder(NameResolverRegistry nameResolverRegistry, String str, ChannelCredentials channelCredentials) {
        NameResolverProvider nameResolverProvider;
        Collection<Class<? extends SocketAddress>> emptySet;
        try {
            nameResolverProvider = nameResolverRegistry.providers().get(new URI(str).getScheme());
        } catch (URISyntaxException unused) {
            nameResolverProvider = null;
        }
        if (nameResolverProvider == null) {
            nameResolverProvider = nameResolverRegistry.providers().get(nameResolverRegistry.asFactory().getDefaultScheme());
        }
        if (nameResolverProvider != null) {
            emptySet = nameResolverProvider.getProducedSocketAddressTypes();
        } else {
            emptySet = Collections.emptySet();
        }
        if (!providers().isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            for (ManagedChannelProvider managedChannelProvider : providers()) {
                if (!managedChannelProvider.getSupportedSocketAddressTypes().containsAll(emptySet)) {
                    sb2.append("; ");
                    sb2.append(managedChannelProvider.getClass().getName());
                    sb2.append(": does not support 1 or more of ");
                    sb2.append(Arrays.toString(emptySet.toArray()));
                } else {
                    ManagedChannelProvider.NewChannelBuilderResult newChannelBuilder = managedChannelProvider.newChannelBuilder(str, channelCredentials);
                    if (newChannelBuilder.getChannelBuilder() != null) {
                        return newChannelBuilder.getChannelBuilder();
                    }
                    sb2.append("; ");
                    sb2.append(managedChannelProvider.getClass().getName());
                    sb2.append(": ");
                    sb2.append(newChannelBuilder.getError());
                }
            }
            throw new ProviderNotFoundException(sb2.substring(2));
        }
        throw new ProviderNotFoundException("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
    }
}
