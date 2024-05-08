package io.grpc.internal;

import com.google.common.base.j;
import com.google.common.base.o;
import io.grpc.ChannelLogger;
import io.grpc.ConnectivityState;
import io.grpc.ConnectivityStateInfo;
import io.grpc.LoadBalancer;
import io.grpc.LoadBalancerProvider;
import io.grpc.LoadBalancerRegistry;
import io.grpc.NameResolver;
import io.grpc.Status;
import io.grpc.internal.ServiceConfigUtil;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class AutoConfiguredLoadBalancerFactory {
    private final String defaultPolicy;
    private final LoadBalancerRegistry registry;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class AutoConfiguredLoadBalancer {
        private LoadBalancer delegate;
        private LoadBalancerProvider delegateProvider;
        private final LoadBalancer.Helper helper;

        public AutoConfiguredLoadBalancer(LoadBalancer.Helper helper) {
            this.helper = helper;
            LoadBalancerProvider provider = AutoConfiguredLoadBalancerFactory.this.registry.getProvider(AutoConfiguredLoadBalancerFactory.this.defaultPolicy);
            this.delegateProvider = provider;
            if (provider != null) {
                this.delegate = provider.newLoadBalancer(helper);
                return;
            }
            throw new IllegalStateException("Could not find policy '" + AutoConfiguredLoadBalancerFactory.this.defaultPolicy + "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
        }

        public LoadBalancer getDelegate() {
            return this.delegate;
        }

        public LoadBalancerProvider getDelegateProvider() {
            return this.delegateProvider;
        }

        public void handleNameResolutionError(Status status) {
            getDelegate().handleNameResolutionError(status);
        }

        @Deprecated
        public void handleSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo) {
            getDelegate().handleSubchannelState(subchannel, connectivityStateInfo);
        }

        public void requestConnection() {
            getDelegate().requestConnection();
        }

        public void setDelegate(LoadBalancer loadBalancer) {
            this.delegate = loadBalancer;
        }

        public void shutdown() {
            this.delegate.shutdown();
            this.delegate = null;
        }

        public boolean tryAcceptResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
            ServiceConfigUtil.PolicySelection policySelection = (ServiceConfigUtil.PolicySelection) resolvedAddresses.getLoadBalancingPolicyConfig();
            if (policySelection == null) {
                try {
                    AutoConfiguredLoadBalancerFactory autoConfiguredLoadBalancerFactory = AutoConfiguredLoadBalancerFactory.this;
                    policySelection = new ServiceConfigUtil.PolicySelection(autoConfiguredLoadBalancerFactory.getProviderOrThrow(autoConfiguredLoadBalancerFactory.defaultPolicy, "using default policy"), null);
                } catch (PolicyException e2) {
                    this.helper.updateBalancingState(ConnectivityState.TRANSIENT_FAILURE, new FailingPicker(Status.INTERNAL.withDescription(e2.getMessage())));
                    this.delegate.shutdown();
                    this.delegateProvider = null;
                    this.delegate = new NoopLoadBalancer();
                    return true;
                }
            }
            if (this.delegateProvider == null || !policySelection.provider.getPolicyName().equals(this.delegateProvider.getPolicyName())) {
                this.helper.updateBalancingState(ConnectivityState.CONNECTING, new EmptyPicker());
                this.delegate.shutdown();
                LoadBalancerProvider loadBalancerProvider = policySelection.provider;
                this.delegateProvider = loadBalancerProvider;
                LoadBalancer loadBalancer = this.delegate;
                this.delegate = loadBalancerProvider.newLoadBalancer(this.helper);
                this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.INFO, "Load balancer changed from {0} to {1}", loadBalancer.getClass().getSimpleName(), this.delegate.getClass().getSimpleName());
            }
            Object obj = policySelection.config;
            if (obj != null) {
                this.helper.getChannelLogger().log(ChannelLogger.ChannelLogLevel.DEBUG, "Load-balancing config: {0}", policySelection.config);
            }
            return getDelegate().acceptResolvedAddresses(LoadBalancer.ResolvedAddresses.newBuilder().setAddresses(resolvedAddresses.getAddresses()).setAttributes(resolvedAddresses.getAttributes()).setLoadBalancingPolicyConfig(obj).build());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class EmptyPicker extends LoadBalancer.SubchannelPicker {
        private EmptyPicker() {
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return LoadBalancer.PickResult.withNoResult();
        }

        public String toString() {
            return j.b(EmptyPicker.class).toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class FailingPicker extends LoadBalancer.SubchannelPicker {
        private final Status failure;

        public FailingPicker(Status status) {
            this.failure = status;
        }

        @Override // io.grpc.LoadBalancer.SubchannelPicker
        public LoadBalancer.PickResult pickSubchannel(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return LoadBalancer.PickResult.withError(this.failure);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class NoopLoadBalancer extends LoadBalancer {
        private NoopLoadBalancer() {
        }

        @Override // io.grpc.LoadBalancer
        public boolean acceptResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
            return true;
        }

        @Override // io.grpc.LoadBalancer
        public void handleNameResolutionError(Status status) {
        }

        @Override // io.grpc.LoadBalancer
        @Deprecated
        public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        }

        @Override // io.grpc.LoadBalancer
        public void shutdown() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class PolicyException extends Exception {
        private static final long serialVersionUID = 1;

        private PolicyException(String str) {
            super(str);
        }
    }

    public AutoConfiguredLoadBalancerFactory(String str) {
        this(LoadBalancerRegistry.getDefaultRegistry(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LoadBalancerProvider getProviderOrThrow(String str, String str2) throws PolicyException {
        LoadBalancerProvider provider = this.registry.getProvider(str);
        if (provider != null) {
            return provider;
        }
        throw new PolicyException("Trying to load '" + str + "' because " + str2 + ", but it's unavailable");
    }

    public AutoConfiguredLoadBalancer newLoadBalancer(LoadBalancer.Helper helper) {
        return new AutoConfiguredLoadBalancer(helper);
    }

    public NameResolver.ConfigOrError parseLoadBalancerPolicy(Map<String, ?> map) {
        List<ServiceConfigUtil.LbConfig> unwrapLoadBalancingConfigList;
        if (map != null) {
            try {
                unwrapLoadBalancingConfigList = ServiceConfigUtil.unwrapLoadBalancingConfigList(ServiceConfigUtil.getLoadBalancingConfigsFromServiceConfig(map));
            } catch (RuntimeException e2) {
                return NameResolver.ConfigOrError.fromError(Status.UNKNOWN.withDescription("can't parse load balancer configuration").withCause(e2));
            }
        } else {
            unwrapLoadBalancingConfigList = null;
        }
        if (unwrapLoadBalancingConfigList == null || unwrapLoadBalancingConfigList.isEmpty()) {
            return null;
        }
        return ServiceConfigUtil.selectLbPolicyFromList(unwrapLoadBalancingConfigList, this.registry);
    }

    public AutoConfiguredLoadBalancerFactory(LoadBalancerRegistry loadBalancerRegistry, String str) {
        this.registry = (LoadBalancerRegistry) o.s(loadBalancerRegistry, "registry");
        this.defaultPolicy = (String) o.s(str, "defaultPolicy");
    }
}
