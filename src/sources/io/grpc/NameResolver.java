package io.grpc;

import com.google.common.base.j;
import com.google.common.base.l;
import com.google.common.base.o;
import com.huawei.flexiblelayout.card.FLPNode;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class NameResolver {

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Args {
        private final ChannelLogger channelLogger;
        private final int defaultPort;
        private final Executor executor;
        private final String overrideAuthority;
        private final ProxyDetector proxyDetector;
        private final ScheduledExecutorService scheduledExecutorService;
        private final ServiceConfigParser serviceConfigParser;
        private final SynchronizationContext syncContext;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Builder {
            private ChannelLogger channelLogger;
            private Integer defaultPort;
            private Executor executor;
            private String overrideAuthority;
            private ProxyDetector proxyDetector;
            private ScheduledExecutorService scheduledExecutorService;
            private ServiceConfigParser serviceConfigParser;
            private SynchronizationContext syncContext;

            public Args build() {
                return new Args(this.defaultPort, this.proxyDetector, this.syncContext, this.serviceConfigParser, this.scheduledExecutorService, this.channelLogger, this.executor, this.overrideAuthority);
            }

            @ExperimentalApi("https://github.com/grpc/grpc-java/issues/6438")
            public Builder setChannelLogger(ChannelLogger channelLogger) {
                this.channelLogger = (ChannelLogger) o.r(channelLogger);
                return this;
            }

            public Builder setDefaultPort(int i10) {
                this.defaultPort = Integer.valueOf(i10);
                return this;
            }

            public Builder setOffloadExecutor(Executor executor) {
                this.executor = executor;
                return this;
            }

            @ExperimentalApi("https://github.com/grpc/grpc-java/issues/9406")
            public Builder setOverrideAuthority(String str) {
                this.overrideAuthority = str;
                return this;
            }

            public Builder setProxyDetector(ProxyDetector proxyDetector) {
                this.proxyDetector = (ProxyDetector) o.r(proxyDetector);
                return this;
            }

            @ExperimentalApi("https://github.com/grpc/grpc-java/issues/6454")
            public Builder setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
                this.scheduledExecutorService = (ScheduledExecutorService) o.r(scheduledExecutorService);
                return this;
            }

            public Builder setServiceConfigParser(ServiceConfigParser serviceConfigParser) {
                this.serviceConfigParser = (ServiceConfigParser) o.r(serviceConfigParser);
                return this;
            }

            public Builder setSynchronizationContext(SynchronizationContext synchronizationContext) {
                this.syncContext = (SynchronizationContext) o.r(synchronizationContext);
                return this;
            }
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/6438")
        public ChannelLogger getChannelLogger() {
            ChannelLogger channelLogger = this.channelLogger;
            if (channelLogger != null) {
                return channelLogger;
            }
            throw new IllegalStateException("ChannelLogger is not set in Builder");
        }

        public int getDefaultPort() {
            return this.defaultPort;
        }

        public Executor getOffloadExecutor() {
            return this.executor;
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/9406")
        public String getOverrideAuthority() {
            return this.overrideAuthority;
        }

        public ProxyDetector getProxyDetector() {
            return this.proxyDetector;
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/6454")
        public ScheduledExecutorService getScheduledExecutorService() {
            ScheduledExecutorService scheduledExecutorService = this.scheduledExecutorService;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService;
            }
            throw new IllegalStateException("ScheduledExecutorService not set in Builder");
        }

        public ServiceConfigParser getServiceConfigParser() {
            return this.serviceConfigParser;
        }

        public SynchronizationContext getSynchronizationContext() {
            return this.syncContext;
        }

        public Builder toBuilder() {
            Builder builder = new Builder();
            builder.setDefaultPort(this.defaultPort);
            builder.setProxyDetector(this.proxyDetector);
            builder.setSynchronizationContext(this.syncContext);
            builder.setServiceConfigParser(this.serviceConfigParser);
            builder.setScheduledExecutorService(this.scheduledExecutorService);
            builder.setChannelLogger(this.channelLogger);
            builder.setOffloadExecutor(this.executor);
            builder.setOverrideAuthority(this.overrideAuthority);
            return builder;
        }

        public String toString() {
            return j.c(this).b("defaultPort", this.defaultPort).d("proxyDetector", this.proxyDetector).d("syncContext", this.syncContext).d("serviceConfigParser", this.serviceConfigParser).d("scheduledExecutorService", this.scheduledExecutorService).d("channelLogger", this.channelLogger).d("executor", this.executor).d("overrideAuthority", this.overrideAuthority).toString();
        }

        private Args(Integer num, ProxyDetector proxyDetector, SynchronizationContext synchronizationContext, ServiceConfigParser serviceConfigParser, ScheduledExecutorService scheduledExecutorService, ChannelLogger channelLogger, Executor executor, String str) {
            this.defaultPort = ((Integer) o.s(num, "defaultPort not set")).intValue();
            this.proxyDetector = (ProxyDetector) o.s(proxyDetector, "proxyDetector not set");
            this.syncContext = (SynchronizationContext) o.s(synchronizationContext, "syncContext not set");
            this.serviceConfigParser = (ServiceConfigParser) o.s(serviceConfigParser, "serviceConfigParser not set");
            this.scheduledExecutorService = scheduledExecutorService;
            this.channelLogger = channelLogger;
            this.executor = executor;
            this.overrideAuthority = str;
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class Factory {
        public abstract String getDefaultScheme();

        public abstract NameResolver newNameResolver(URI uri, Args args);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Listener {
        void onAddresses(List<EquivalentAddressGroup> list, Attributes attributes);

        void onError(Status status);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class Listener2 implements Listener {
        @Override // io.grpc.NameResolver.Listener
        @Deprecated
        public final void onAddresses(List<EquivalentAddressGroup> list, Attributes attributes) {
            onResult(ResolutionResult.newBuilder().setAddresses(list).setAttributes(attributes).build());
        }

        @Override // io.grpc.NameResolver.Listener
        public abstract void onError(Status status);

        public abstract void onResult(ResolutionResult resolutionResult);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ResolutionResult {
        private final List<EquivalentAddressGroup> addresses;
        private final Attributes attributes;
        private final ConfigOrError serviceConfig;

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static final class Builder {
            private List<EquivalentAddressGroup> addresses = Collections.emptyList();
            private Attributes attributes = Attributes.EMPTY;
            private ConfigOrError serviceConfig;

            public ResolutionResult build() {
                return new ResolutionResult(this.addresses, this.attributes, this.serviceConfig);
            }

            public Builder setAddresses(List<EquivalentAddressGroup> list) {
                this.addresses = list;
                return this;
            }

            public Builder setAttributes(Attributes attributes) {
                this.attributes = attributes;
                return this;
            }

            public Builder setServiceConfig(ConfigOrError configOrError) {
                this.serviceConfig = configOrError;
                return this;
            }
        }

        public ResolutionResult(List<EquivalentAddressGroup> list, Attributes attributes, ConfigOrError configOrError) {
            this.addresses = Collections.unmodifiableList(new ArrayList(list));
            this.attributes = (Attributes) o.s(attributes, "attributes");
            this.serviceConfig = configOrError;
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ResolutionResult)) {
                return false;
            }
            ResolutionResult resolutionResult = (ResolutionResult) obj;
            return l.a(this.addresses, resolutionResult.addresses) && l.a(this.attributes, resolutionResult.attributes) && l.a(this.serviceConfig, resolutionResult.serviceConfig);
        }

        public List<EquivalentAddressGroup> getAddresses() {
            return this.addresses;
        }

        public Attributes getAttributes() {
            return this.attributes;
        }

        public ConfigOrError getServiceConfig() {
            return this.serviceConfig;
        }

        public int hashCode() {
            return l.b(this.addresses, this.attributes, this.serviceConfig);
        }

        public Builder toBuilder() {
            return newBuilder().setAddresses(this.addresses).setAttributes(this.attributes).setServiceConfig(this.serviceConfig);
        }

        public String toString() {
            return j.c(this).d("addresses", this.addresses).d("attributes", this.attributes).d("serviceConfig", this.serviceConfig).toString();
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4972")
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public @interface ResolutionResultAttr {
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static abstract class ServiceConfigParser {
        public abstract ConfigOrError parseServiceConfig(Map<String, ?> map);
    }

    public abstract String getServiceAuthority();

    public void refresh() {
    }

    public abstract void shutdown();

    public void start(final Listener listener) {
        if (listener instanceof Listener2) {
            start((Listener2) listener);
        } else {
            start(new Listener2() { // from class: io.grpc.NameResolver.1
                @Override // io.grpc.NameResolver.Listener2, io.grpc.NameResolver.Listener
                public void onError(Status status) {
                    listener.onError(status);
                }

                @Override // io.grpc.NameResolver.Listener2
                public void onResult(ResolutionResult resolutionResult) {
                    listener.onAddresses(resolutionResult.getAddresses(), resolutionResult.getAttributes());
                }
            });
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1770")
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ConfigOrError {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Object config;
        private final Status status;

        private ConfigOrError(Object obj) {
            this.config = o.s(obj, FLPNode.KEY_CONFIG);
            this.status = null;
        }

        public static ConfigOrError fromConfig(Object obj) {
            return new ConfigOrError(obj);
        }

        public static ConfigOrError fromError(Status status) {
            return new ConfigOrError(status);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ConfigOrError.class != obj.getClass()) {
                return false;
            }
            ConfigOrError configOrError = (ConfigOrError) obj;
            return l.a(this.status, configOrError.status) && l.a(this.config, configOrError.config);
        }

        public Object getConfig() {
            return this.config;
        }

        public Status getError() {
            return this.status;
        }

        public int hashCode() {
            return l.b(this.status, this.config);
        }

        public String toString() {
            if (this.config != null) {
                return j.c(this).d(FLPNode.KEY_CONFIG, this.config).toString();
            }
            return j.c(this).d("error", this.status).toString();
        }

        private ConfigOrError(Status status) {
            this.config = null;
            this.status = (Status) o.s(status, "status");
            o.m(!status.isOk(), "cannot use OK status: %s", status);
        }
    }

    public void start(Listener2 listener2) {
        start((Listener) listener2);
    }
}
