package io.grpc.internal;

import androidx.core.app.NotificationCompat;
import com.google.common.base.VerifyException;
import com.google.common.base.j;
import com.google.common.base.l;
import com.google.common.base.o;
import com.google.common.base.r;
import com.google.common.base.u;
import com.google.common.base.w;
import com.huawei.openalliance.ad.constant.bg;
import com.nirvana.tools.crash.CrashSdk;
import io.grpc.Attributes;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;
import io.grpc.ProxiedSocketAddress;
import io.grpc.ProxyDetector;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.SharedResourceHolder;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class DnsNameResolver extends NameResolver {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final long DEFAULT_NETWORK_CACHE_TTL_SECONDS = 30;
    private static final String JNDI_LOCALHOST_PROPERTY;
    private static final String JNDI_PROPERTY;
    private static final String JNDI_TXT_PROPERTY;
    public static final String NETWORKADDRESS_CACHE_TTL_PROPERTY = "networkaddress.cache.ttl";
    private static final String SERVICE_CONFIG_NAME_PREFIX = "_grpc_config.";
    public static final String SERVICE_CONFIG_PREFIX = "grpc_config=";
    public static boolean enableJndi;
    public static boolean enableJndiLocalhost;
    public static boolean enableTxt;
    private static String localHostname;
    private static final ResourceResolverFactory resourceResolverFactory;
    private final String authority;
    private final long cacheTtlNanos;
    private Executor executor;
    private final SharedResourceHolder.Resource<Executor> executorResource;
    private final String host;
    private NameResolver.Listener2 listener;
    private final int port;
    public final ProxyDetector proxyDetector;
    public boolean resolved;
    private boolean resolving;
    private final NameResolver.ServiceConfigParser serviceConfigParser;
    private boolean shutdown;
    private final r stopwatch;
    private final SynchronizationContext syncContext;
    private final boolean usingExecutorResource;
    private static final Logger logger = Logger.getLogger(DnsNameResolver.class.getName());
    private static final String SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY = "clientLanguage";
    private static final String SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY = "percentage";
    private static final String SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY = "clientHostname";
    private static final String SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY = "serviceConfig";
    private static final Set<String> SERVICE_CONFIG_CHOICE_KEYS = Collections.unmodifiableSet(new HashSet(Arrays.asList(SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY, SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY, SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY, SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY)));
    private final Random random = new Random();
    public volatile AddressResolver addressResolver = JdkAddressResolver.INSTANCE;
    private final AtomicReference<ResourceResolver> resourceResolver = new AtomicReference<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface AddressResolver {
        List<InetAddress> resolveAddress(String str) throws Exception;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class InternalResolutionResult {
        private List<EquivalentAddressGroup> addresses;
        public Attributes attributes;
        private NameResolver.ConfigOrError config;
        private Status error;

        private InternalResolutionResult() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum JdkAddressResolver implements AddressResolver {
        INSTANCE;

        @Override // io.grpc.internal.DnsNameResolver.AddressResolver
        public List<InetAddress> resolveAddress(String str) throws UnknownHostException {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class Resolve implements Runnable {
        private final NameResolver.Listener2 savedListener;

        public Resolve(NameResolver.Listener2 listener2) {
            this.savedListener = (NameResolver.Listener2) o.s(listener2, "savedListener");
        }

        @Override // java.lang.Runnable
        public void run() {
            SynchronizationContext synchronizationContext;
            Runnable runnable;
            Logger logger = DnsNameResolver.logger;
            Level level = Level.FINER;
            if (logger.isLoggable(level)) {
                DnsNameResolver.logger.finer("Attempting DNS resolution of " + DnsNameResolver.this.host);
            }
            InternalResolutionResult internalResolutionResult = null;
            try {
                try {
                    EquivalentAddressGroup detectProxy = DnsNameResolver.this.detectProxy();
                    NameResolver.ResolutionResult.Builder newBuilder = NameResolver.ResolutionResult.newBuilder();
                    if (detectProxy != null) {
                        if (DnsNameResolver.logger.isLoggable(level)) {
                            DnsNameResolver.logger.finer("Using proxy address " + ((Object) detectProxy));
                        }
                        newBuilder.setAddresses(Collections.singletonList(detectProxy));
                    } else {
                        internalResolutionResult = DnsNameResolver.this.doResolve(false);
                        if (internalResolutionResult.error != null) {
                            this.savedListener.onError(internalResolutionResult.error);
                            return;
                        }
                        if (internalResolutionResult.addresses != null) {
                            newBuilder.setAddresses(internalResolutionResult.addresses);
                        }
                        if (internalResolutionResult.config != null) {
                            newBuilder.setServiceConfig(internalResolutionResult.config);
                        }
                        Attributes attributes = internalResolutionResult.attributes;
                        if (attributes != null) {
                            newBuilder.setAttributes(attributes);
                        }
                    }
                    this.savedListener.onResult(newBuilder.build());
                    r2 = internalResolutionResult != null && internalResolutionResult.error == null;
                    synchronizationContext = DnsNameResolver.this.syncContext;
                    runnable = new Runnable() { // from class: io.grpc.internal.DnsNameResolver.Resolve.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (r2) {
                                DnsNameResolver dnsNameResolver = DnsNameResolver.this;
                                dnsNameResolver.resolved = true;
                                if (dnsNameResolver.cacheTtlNanos > 0) {
                                    DnsNameResolver.this.stopwatch.g().h();
                                }
                            }
                            DnsNameResolver.this.resolving = false;
                        }
                    };
                } catch (IOException e2) {
                    this.savedListener.onError(Status.UNAVAILABLE.withDescription("Unable to resolve host " + DnsNameResolver.this.host).withCause(e2));
                    r2 = 0 != 0 && null.error == null;
                    synchronizationContext = DnsNameResolver.this.syncContext;
                    runnable = new Runnable() { // from class: io.grpc.internal.DnsNameResolver.Resolve.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (r2) {
                                DnsNameResolver dnsNameResolver = DnsNameResolver.this;
                                dnsNameResolver.resolved = true;
                                if (dnsNameResolver.cacheTtlNanos > 0) {
                                    DnsNameResolver.this.stopwatch.g().h();
                                }
                            }
                            DnsNameResolver.this.resolving = false;
                        }
                    };
                }
                synchronizationContext.execute(runnable);
            } finally {
                r2 = 0 != 0 && null.error == null;
                DnsNameResolver.this.syncContext.execute(new Runnable() { // from class: io.grpc.internal.DnsNameResolver.Resolve.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (r2) {
                            DnsNameResolver dnsNameResolver = DnsNameResolver.this;
                            dnsNameResolver.resolved = true;
                            if (dnsNameResolver.cacheTtlNanos > 0) {
                                DnsNameResolver.this.stopwatch.g().h();
                            }
                        }
                        DnsNameResolver.this.resolving = false;
                    }
                });
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface ResourceResolver {
        List<SrvRecord> resolveSrv(String str) throws Exception;

        List<String> resolveTxt(String str) throws Exception;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface ResourceResolverFactory {
        ResourceResolver newResourceResolver();

        Throwable unavailabilityCause();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class SrvRecord {
        public final String host;
        public final int port;

        public SrvRecord(String str, int i10) {
            this.host = str;
            this.port = i10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || SrvRecord.class != obj.getClass()) {
                return false;
            }
            SrvRecord srvRecord = (SrvRecord) obj;
            return this.port == srvRecord.port && this.host.equals(srvRecord.host);
        }

        public int hashCode() {
            return l.b(this.host, Integer.valueOf(this.port));
        }

        public String toString() {
            return j.c(this).d("host", this.host).b("port", this.port).toString();
        }
    }

    static {
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
        JNDI_PROPERTY = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
        JNDI_LOCALHOST_PROPERTY = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
        JNDI_TXT_PROPERTY = property3;
        enableJndi = Boolean.parseBoolean(property);
        enableJndiLocalhost = Boolean.parseBoolean(property2);
        enableTxt = Boolean.parseBoolean(property3);
        resourceResolverFactory = getResourceResolverFactory(DnsNameResolver.class.getClassLoader());
    }

    public DnsNameResolver(String str, String str2, NameResolver.Args args, SharedResourceHolder.Resource<Executor> resource, r rVar, boolean z10) {
        o.s(args, "args");
        this.executorResource = resource;
        URI create = URI.create("//" + ((String) o.s(str2, "name")));
        o.m(create.getHost() != null, "Invalid DNS name: %s", str2);
        this.authority = (String) o.t(create.getAuthority(), "nameUri (%s) doesn't have an authority", create);
        this.host = create.getHost();
        if (create.getPort() == -1) {
            this.port = args.getDefaultPort();
        } else {
            this.port = create.getPort();
        }
        this.proxyDetector = (ProxyDetector) o.s(args.getProxyDetector(), "proxyDetector");
        this.cacheTtlNanos = getNetworkAddressCacheTtlNanos(z10);
        this.stopwatch = (r) o.s(rVar, NotificationCompat.CATEGORY_STOPWATCH);
        this.syncContext = (SynchronizationContext) o.s(args.getSynchronizationContext(), "syncContext");
        Executor offloadExecutor = args.getOffloadExecutor();
        this.executor = offloadExecutor;
        this.usingExecutorResource = offloadExecutor == null;
        this.serviceConfigParser = (NameResolver.ServiceConfigParser) o.s(args.getServiceConfigParser(), "serviceConfigParser");
    }

    private boolean cacheRefreshRequired() {
        if (this.resolved) {
            long j10 = this.cacheTtlNanos;
            if (j10 != 0 && (j10 <= 0 || this.stopwatch.e(TimeUnit.NANOSECONDS) <= this.cacheTtlNanos)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EquivalentAddressGroup detectProxy() throws IOException {
        ProxiedSocketAddress proxyFor = this.proxyDetector.proxyFor(InetSocketAddress.createUnresolved(this.host, this.port));
        if (proxyFor != null) {
            return new EquivalentAddressGroup(proxyFor);
        }
        return null;
    }

    private static final List<String> getClientLanguagesFromChoice(Map<String, ?> map) {
        return JsonUtil.getListOfStrings(map, SERVICE_CONFIG_CHOICE_CLIENT_LANGUAGE_KEY);
    }

    private static final List<String> getHostnamesFromChoice(Map<String, ?> map) {
        return JsonUtil.getListOfStrings(map, SERVICE_CONFIG_CHOICE_CLIENT_HOSTNAME_KEY);
    }

    private static String getLocalHostname() {
        if (localHostname == null) {
            try {
                localHostname = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e2) {
                throw new RuntimeException(e2);
            }
        }
        return localHostname;
    }

    private static long getNetworkAddressCacheTtlNanos(boolean z10) {
        if (z10) {
            return 0L;
        }
        String property = System.getProperty(NETWORKADDRESS_CACHE_TTL_PROPERTY);
        long j10 = 30;
        if (property != null) {
            try {
                j10 = Long.parseLong(property);
            } catch (NumberFormatException unused) {
                logger.log(Level.WARNING, "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{NETWORKADDRESS_CACHE_TTL_PROPERTY, property, 30L});
            }
        }
        return j10 > 0 ? TimeUnit.SECONDS.toNanos(j10) : j10;
    }

    private static final Double getPercentageFromChoice(Map<String, ?> map) {
        return JsonUtil.getNumberAsDouble(map, SERVICE_CONFIG_CHOICE_PERCENTAGE_KEY);
    }

    public static ResourceResolverFactory getResourceResolverFactory(ClassLoader classLoader) {
        try {
            try {
                try {
                    ResourceResolverFactory resourceResolverFactory2 = (ResourceResolverFactory) Class.forName("io.grpc.internal.JndiResourceResolverFactory", true, classLoader).asSubclass(ResourceResolverFactory.class).getConstructor(new Class[0]).newInstance(new Object[0]);
                    if (resourceResolverFactory2.unavailabilityCause() == null) {
                        return resourceResolverFactory2;
                    }
                    logger.log(Level.FINE, "JndiResourceResolverFactory not available, skipping.", resourceResolverFactory2.unavailabilityCause());
                    return null;
                } catch (Exception e2) {
                    logger.log(Level.FINE, "Can't construct JndiResourceResolverFactory, skipping.", (Throwable) e2);
                    return null;
                }
            } catch (Exception e10) {
                logger.log(Level.FINE, "Can't find JndiResourceResolverFactory ctor, skipping.", (Throwable) e10);
                return null;
            }
        } catch (ClassCastException e11) {
            logger.log(Level.FINE, "Unable to cast JndiResourceResolverFactory, skipping.", (Throwable) e11);
            return null;
        } catch (ClassNotFoundException e12) {
            logger.log(Level.FINE, "Unable to find JndiResourceResolverFactory, skipping.", (Throwable) e12);
            return null;
        }
    }

    public static Map<String, ?> maybeChooseServiceConfig(Map<String, ?> map, Random random, String str) {
        boolean z10;
        boolean z11;
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            w.a(SERVICE_CONFIG_CHOICE_KEYS.contains(entry.getKey()), "Bad key: %s", entry);
        }
        List<String> clientLanguagesFromChoice = getClientLanguagesFromChoice(map);
        if (clientLanguagesFromChoice != null && !clientLanguagesFromChoice.isEmpty()) {
            Iterator<String> iterator2 = clientLanguagesFromChoice.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    z11 = false;
                    break;
                }
                if (CrashSdk.CRASH_TYPE_JAVA.equalsIgnoreCase(iterator2.next())) {
                    z11 = true;
                    break;
                }
            }
            if (!z11) {
                return null;
            }
        }
        Double percentageFromChoice = getPercentageFromChoice(map);
        if (percentageFromChoice != null) {
            int intValue = percentageFromChoice.intValue();
            w.a(intValue >= 0 && intValue <= 100, "Bad percentage: %s", percentageFromChoice);
            if (random.nextInt(100) >= intValue) {
                return null;
            }
        }
        List<String> hostnamesFromChoice = getHostnamesFromChoice(map);
        if (hostnamesFromChoice != null && !hostnamesFromChoice.isEmpty()) {
            Iterator<String> iterator22 = hostnamesFromChoice.iterator2();
            while (true) {
                if (!iterator22.hasNext()) {
                    z10 = false;
                    break;
                }
                if (iterator22.next().equals(str)) {
                    z10 = true;
                    break;
                }
            }
            if (!z10) {
                return null;
            }
        }
        Map<String, ?> object = JsonUtil.getObject(map, SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY);
        if (object != null) {
            return object;
        }
        throw new VerifyException(String.format("key '%s' missing in '%s'", map, SERVICE_CONFIG_CHOICE_SERVICE_CONFIG_KEY));
    }

    public static NameResolver.ConfigOrError parseServiceConfig(List<String> list, Random random, String str) {
        try {
            Iterator<Map<String, ?>> iterator2 = parseTxtResults(list).iterator2();
            Map<String, ?> map = null;
            while (iterator2.hasNext()) {
                try {
                    map = maybeChooseServiceConfig(iterator2.next(), random, str);
                    if (map != null) {
                        break;
                    }
                } catch (RuntimeException e2) {
                    return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("failed to pick service config choice").withCause(e2));
                }
            }
            if (map == null) {
                return null;
            }
            return NameResolver.ConfigOrError.fromConfig(map);
        } catch (IOException | RuntimeException e10) {
            return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("failed to parse TXT records").withCause(e10));
        }
    }

    public static List<Map<String, ?>> parseTxtResults(List<String> list) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!str.startsWith(SERVICE_CONFIG_PREFIX)) {
                logger.log(Level.FINE, "Ignoring non service config {0}", new Object[]{str});
            } else {
                Object parse = JsonParser.parse(str.substring(12));
                if (parse instanceof List) {
                    arrayList.addAll(JsonUtil.checkObjectList((List) parse));
                } else {
                    throw new ClassCastException("wrong type " + parse);
                }
            }
        }
        return arrayList;
    }

    private void resolve() {
        if (this.resolving || this.shutdown || !cacheRefreshRequired()) {
            return;
        }
        this.resolving = true;
        this.executor.execute(new Resolve(this.listener));
    }

    private List<EquivalentAddressGroup> resolveAddresses() {
        Exception e2 = null;
        try {
            try {
                List<InetAddress> resolveAddress = this.addressResolver.resolveAddress(this.host);
                ArrayList arrayList = new ArrayList(resolveAddress.size());
                Iterator<InetAddress> iterator2 = resolveAddress.iterator2();
                while (iterator2.hasNext()) {
                    arrayList.add(new EquivalentAddressGroup(new InetSocketAddress(iterator2.next(), this.port)));
                }
                return Collections.unmodifiableList(arrayList);
            } catch (Exception e10) {
                e2 = e10;
                u.f(e2);
                throw new RuntimeException(e2);
            }
        } catch (Throwable th) {
            if (e2 != null) {
                logger.log(Level.FINE, "Address resolution failure", (Throwable) e2);
            }
            throw th;
        }
    }

    private NameResolver.ConfigOrError resolveServiceConfig() {
        List<String> emptyList = Collections.emptyList();
        ResourceResolver resourceResolver = getResourceResolver();
        if (resourceResolver != null) {
            try {
                emptyList = resourceResolver.resolveTxt(SERVICE_CONFIG_NAME_PREFIX + this.host);
            } catch (Exception e2) {
                logger.log(Level.FINE, "ServiceConfig resolution failure", (Throwable) e2);
            }
        }
        if (!emptyList.isEmpty()) {
            NameResolver.ConfigOrError parseServiceConfig = parseServiceConfig(emptyList, this.random, getLocalHostname());
            if (parseServiceConfig == null) {
                return null;
            }
            if (parseServiceConfig.getError() != null) {
                return NameResolver.ConfigOrError.fromError(parseServiceConfig.getError());
            }
            return this.serviceConfigParser.parseServiceConfig((Map) parseServiceConfig.getConfig());
        }
        logger.log(Level.FINE, "No TXT records found for {0}", new Object[]{this.host});
        return null;
    }

    public static boolean shouldUseJndi(boolean z10, boolean z11, String str) {
        if (!z10) {
            return false;
        }
        if ("localhost".equalsIgnoreCase(str)) {
            return z11;
        }
        if (str.contains(com.huawei.openalliance.ad.constant.u.bD)) {
            return false;
        }
        boolean z12 = true;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt != '.') {
                z12 &= charAt >= '0' && charAt <= '9';
            }
        }
        return true ^ z12;
    }

    public InternalResolutionResult doResolve(boolean z10) {
        InternalResolutionResult internalResolutionResult = new InternalResolutionResult();
        try {
            internalResolutionResult.addresses = resolveAddresses();
        } catch (Exception e2) {
            if (!z10) {
                internalResolutionResult.error = Status.UNAVAILABLE.withDescription("Unable to resolve host " + this.host).withCause(e2);
                return internalResolutionResult;
            }
        }
        if (enableTxt) {
            internalResolutionResult.config = resolveServiceConfig();
        }
        return internalResolutionResult;
    }

    public String getHost() {
        return this.host;
    }

    public final int getPort() {
        return this.port;
    }

    public ResourceResolver getResourceResolver() {
        ResourceResolverFactory resourceResolverFactory2;
        if (!shouldUseJndi(enableJndi, enableJndiLocalhost, this.host)) {
            return null;
        }
        ResourceResolver resourceResolver = this.resourceResolver.get();
        return (resourceResolver != null || (resourceResolverFactory2 = resourceResolverFactory) == null) ? resourceResolver : resourceResolverFactory2.newResourceResolver();
    }

    @Override // io.grpc.NameResolver
    public String getServiceAuthority() {
        return this.authority;
    }

    @Override // io.grpc.NameResolver
    public void refresh() {
        o.y(this.listener != null, "not started");
        resolve();
    }

    public void setAddressResolver(AddressResolver addressResolver) {
        this.addressResolver = addressResolver;
    }

    public void setResourceResolver(ResourceResolver resourceResolver) {
        this.resourceResolver.set(resourceResolver);
    }

    @Override // io.grpc.NameResolver
    public void shutdown() {
        if (this.shutdown) {
            return;
        }
        this.shutdown = true;
        Executor executor = this.executor;
        if (executor == null || !this.usingExecutorResource) {
            return;
        }
        this.executor = (Executor) SharedResourceHolder.release(this.executorResource, executor);
    }

    @Override // io.grpc.NameResolver
    public void start(NameResolver.Listener2 listener2) {
        o.y(this.listener == null, "already started");
        if (this.usingExecutorResource) {
            this.executor = (Executor) SharedResourceHolder.get(this.executorResource);
        }
        this.listener = (NameResolver.Listener2) o.s(listener2, bg.e.f32299p);
        resolve();
    }
}
