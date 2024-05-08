package io.grpc;

import com.google.common.base.o;
import io.grpc.ServiceProviders;
import io.grpc.internal.PickFirstLoadBalancerProvider;
import io.grpc.util.SecretRoundRobinLoadBalancerProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class LoadBalancerRegistry {
    private static LoadBalancerRegistry instance;
    private final LinkedHashSet<LoadBalancerProvider> allProviders = new LinkedHashSet<>();
    private final LinkedHashMap<String, LoadBalancerProvider> effectiveProviders = new LinkedHashMap<>();
    private static final Logger logger = Logger.getLogger(LoadBalancerRegistry.class.getName());
    private static final Iterable<Class<?>> HARDCODED_CLASSES = getHardCodedClasses();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class LoadBalancerPriorityAccessor implements ServiceProviders.PriorityAccessor<LoadBalancerProvider> {
        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public int getPriority(LoadBalancerProvider loadBalancerProvider) {
            return loadBalancerProvider.getPriority();
        }

        @Override // io.grpc.ServiceProviders.PriorityAccessor
        public boolean isAvailable(LoadBalancerProvider loadBalancerProvider) {
            return loadBalancerProvider.isAvailable();
        }
    }

    private synchronized void addProvider(LoadBalancerProvider loadBalancerProvider) {
        o.e(loadBalancerProvider.isAvailable(), "isAvailable() returned false");
        this.allProviders.add(loadBalancerProvider);
    }

    public static synchronized LoadBalancerRegistry getDefaultRegistry() {
        LoadBalancerRegistry loadBalancerRegistry;
        synchronized (LoadBalancerRegistry.class) {
            if (instance == null) {
                List<LoadBalancerProvider> loadAll = ServiceProviders.loadAll(LoadBalancerProvider.class, HARDCODED_CLASSES, LoadBalancerProvider.class.getClassLoader(), new LoadBalancerPriorityAccessor());
                instance = new LoadBalancerRegistry();
                for (LoadBalancerProvider loadBalancerProvider : loadAll) {
                    logger.fine("Service loader found " + ((Object) loadBalancerProvider));
                    instance.addProvider(loadBalancerProvider);
                }
                instance.refreshProviderMap();
            }
            loadBalancerRegistry = instance;
        }
        return loadBalancerRegistry;
    }

    public static List<Class<?>> getHardCodedClasses() {
        ArrayList arrayList = new ArrayList();
        try {
            int i10 = PickFirstLoadBalancerProvider.f50072a;
            arrayList.add(PickFirstLoadBalancerProvider.class);
        } catch (ClassNotFoundException e2) {
            logger.log(Level.WARNING, "Unable to find pick-first LoadBalancer", (Throwable) e2);
        }
        try {
            int i11 = SecretRoundRobinLoadBalancerProvider.Provider.f50091a;
            arrayList.add(SecretRoundRobinLoadBalancerProvider.Provider.class);
        } catch (ClassNotFoundException e10) {
            logger.log(Level.FINE, "Unable to find round-robin LoadBalancer", (Throwable) e10);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private synchronized void refreshProviderMap() {
        this.effectiveProviders.clear();
        Iterator<LoadBalancerProvider> it = this.allProviders.iterator2();
        while (it.hasNext()) {
            LoadBalancerProvider next = it.next();
            String policyName = next.getPolicyName();
            LoadBalancerProvider loadBalancerProvider = this.effectiveProviders.get(policyName);
            if (loadBalancerProvider == null || loadBalancerProvider.getPriority() < next.getPriority()) {
                this.effectiveProviders.put(policyName, next);
            }
        }
    }

    public synchronized void deregister(LoadBalancerProvider loadBalancerProvider) {
        this.allProviders.remove(loadBalancerProvider);
        refreshProviderMap();
    }

    public synchronized LoadBalancerProvider getProvider(String str) {
        return this.effectiveProviders.get(o.s(str, "policy"));
    }

    public synchronized Map<String, LoadBalancerProvider> providers() {
        return new LinkedHashMap(this.effectiveProviders);
    }

    public synchronized void register(LoadBalancerProvider loadBalancerProvider) {
        addProvider(loadBalancerProvider);
        refreshProviderMap();
    }
}
