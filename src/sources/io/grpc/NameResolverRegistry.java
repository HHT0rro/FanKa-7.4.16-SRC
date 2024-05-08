package io.grpc;

import com.google.common.base.o;
import com.google.common.collect.ImmutableMap;
import io.grpc.NameResolver;
import io.grpc.ServiceProviders;
import io.grpc.internal.DnsNameResolverProvider;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4159")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class NameResolverRegistry {
    private static final String UNKNOWN_SCHEME = "unknown";
    private static NameResolverRegistry instance;
    private static final Logger logger = Logger.getLogger(NameResolverRegistry.class.getName());
    private final NameResolver.Factory factory = new NameResolverFactory();
    private String defaultScheme = "unknown";
    private final LinkedHashSet<NameResolverProvider> allProviders = new LinkedHashSet<>();
    private ImmutableMap<String, NameResolverProvider> effectiveProviders = ImmutableMap.of();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class NameResolverFactory extends NameResolver.Factory {
        private NameResolverFactory() {
        }

        @Override // io.grpc.NameResolver.Factory
        public String getDefaultScheme() {
            String str;
            synchronized (NameResolverRegistry.this) {
                str = NameResolverRegistry.this.defaultScheme;
            }
            return str;
        }

        @Override // io.grpc.NameResolver.Factory
        public NameResolver newNameResolver(URI uri, NameResolver.Args args) {
            NameResolverProvider nameResolverProvider;
            String scheme = uri.getScheme();
            if (scheme == null || (nameResolverProvider = NameResolverRegistry.this.providers().get(scheme.toLowerCase(Locale.US))) == null) {
                return null;
            }
            return nameResolverProvider.newNameResolver(uri, args);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class NameResolverPriorityAccessor implements ServiceProviders.PriorityAccessor<NameResolverProvider> {
        private NameResolverPriorityAccessor() {
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public int getPriority(NameResolverProvider nameResolverProvider) {
            return nameResolverProvider.priority();
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public boolean isAvailable(NameResolverProvider nameResolverProvider) {
            return nameResolverProvider.isAvailable();
        }
    }

    private synchronized void addProvider(NameResolverProvider nameResolverProvider) {
        o.e(nameResolverProvider.isAvailable(), "isAvailable() returned false");
        this.allProviders.add(nameResolverProvider);
    }

    public static synchronized NameResolverRegistry getDefaultRegistry() {
        NameResolverRegistry nameResolverRegistry;
        synchronized (NameResolverRegistry.class) {
            if (instance == null) {
                List<NameResolverProvider> loadAll = ServiceProviders.loadAll(NameResolverProvider.class, getHardCodedClasses(), NameResolverProvider.class.getClassLoader(), new NameResolverPriorityAccessor());
                if (loadAll.isEmpty()) {
                    logger.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
                }
                instance = new NameResolverRegistry();
                for (NameResolverProvider nameResolverProvider : loadAll) {
                    logger.fine("Service loader found " + ((Object) nameResolverProvider));
                    instance.addProvider(nameResolverProvider);
                }
                instance.refreshProviders();
            }
            nameResolverRegistry = instance;
        }
        return nameResolverRegistry;
    }

    public static List<Class<?>> getHardCodedClasses() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(DnsNameResolverProvider.class);
        } catch (ClassNotFoundException e2) {
            logger.log(Level.FINE, "Unable to find DNS NameResolver", (Throwable) e2);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private synchronized void refreshProviders() {
        HashMap hashMap = new HashMap();
        int i10 = Integer.MIN_VALUE;
        String str = "unknown";
        Iterator<NameResolverProvider> it = this.allProviders.iterator2();
        while (it.hasNext()) {
            NameResolverProvider next = it.next();
            String scheme = next.getScheme();
            NameResolverProvider nameResolverProvider = (NameResolverProvider) hashMap.get(scheme);
            if (nameResolverProvider == null || nameResolverProvider.priority() < next.priority()) {
                hashMap.put(scheme, next);
            }
            if (i10 < next.priority()) {
                i10 = next.priority();
                str = next.getScheme();
            }
        }
        this.effectiveProviders = ImmutableMap.copyOf((Map) hashMap);
        this.defaultScheme = str;
    }

    public NameResolver.Factory asFactory() {
        return this.factory;
    }

    public synchronized void deregister(NameResolverProvider nameResolverProvider) {
        this.allProviders.remove(nameResolverProvider);
        refreshProviders();
    }

    public synchronized Map<String, NameResolverProvider> providers() {
        return this.effectiveProviders;
    }

    public synchronized void register(NameResolverProvider nameResolverProvider) {
        addProvider(nameResolverProvider);
        refreshProviders();
    }
}
