package io.grpc.internal;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.common.base.j;
import com.google.common.base.l;
import com.google.common.base.o;
import com.google.common.base.s;
import io.grpc.CallOptions;
import io.grpc.InternalConfigSelector;
import io.grpc.LoadBalancer;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.RetriableStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ManagedChannelServiceConfig {
    private final MethodInfo defaultMethodConfig;
    private final Map<String, ?> healthCheckingConfig;
    private final Object loadBalancingConfig;
    private final RetriableStream.Throttle retryThrottling;
    private final Map<String, MethodInfo> serviceMap;
    private final Map<String, MethodInfo> serviceMethodMap;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class MethodInfo {
        public static final CallOptions.Key<MethodInfo> KEY = CallOptions.Key.create("io.grpc.internal.ManagedChannelServiceConfig.MethodInfo");
        public final HedgingPolicy hedgingPolicy;
        public final Integer maxInboundMessageSize;
        public final Integer maxOutboundMessageSize;
        public final RetryPolicy retryPolicy;
        public final Long timeoutNanos;
        public final Boolean waitForReady;

        public MethodInfo(Map<String, ?> map, boolean z10, int i10, int i11) {
            this.timeoutNanos = ServiceConfigUtil.getTimeoutFromMethodConfig(map);
            this.waitForReady = ServiceConfigUtil.getWaitForReadyFromMethodConfig(map);
            Integer maxResponseMessageBytesFromMethodConfig = ServiceConfigUtil.getMaxResponseMessageBytesFromMethodConfig(map);
            this.maxInboundMessageSize = maxResponseMessageBytesFromMethodConfig;
            if (maxResponseMessageBytesFromMethodConfig != null) {
                o.m(maxResponseMessageBytesFromMethodConfig.intValue() >= 0, "maxInboundMessageSize %s exceeds bounds", maxResponseMessageBytesFromMethodConfig);
            }
            Integer maxRequestMessageBytesFromMethodConfig = ServiceConfigUtil.getMaxRequestMessageBytesFromMethodConfig(map);
            this.maxOutboundMessageSize = maxRequestMessageBytesFromMethodConfig;
            if (maxRequestMessageBytesFromMethodConfig != null) {
                o.m(maxRequestMessageBytesFromMethodConfig.intValue() >= 0, "maxOutboundMessageSize %s exceeds bounds", maxRequestMessageBytesFromMethodConfig);
            }
            Map<String, ?> retryPolicyFromMethodConfig = z10 ? ServiceConfigUtil.getRetryPolicyFromMethodConfig(map) : null;
            this.retryPolicy = retryPolicyFromMethodConfig == null ? null : retryPolicy(retryPolicyFromMethodConfig, i10);
            Map<String, ?> hedgingPolicyFromMethodConfig = z10 ? ServiceConfigUtil.getHedgingPolicyFromMethodConfig(map) : null;
            this.hedgingPolicy = hedgingPolicyFromMethodConfig != null ? hedgingPolicy(hedgingPolicyFromMethodConfig, i11) : null;
        }

        private static HedgingPolicy hedgingPolicy(Map<String, ?> map, int i10) {
            int intValue = ((Integer) o.s(ServiceConfigUtil.getMaxAttemptsFromHedgingPolicy(map), "maxAttempts cannot be empty")).intValue();
            o.h(intValue >= 2, "maxAttempts must be greater than 1: %s", intValue);
            int min = Math.min(intValue, i10);
            long longValue = ((Long) o.s(ServiceConfigUtil.getHedgingDelayNanosFromHedgingPolicy(map), "hedgingDelay cannot be empty")).longValue();
            o.j(longValue >= 0, "hedgingDelay must not be negative: %s", longValue);
            return new HedgingPolicy(min, longValue, ServiceConfigUtil.getNonFatalStatusCodesFromHedgingPolicy(map));
        }

        private static RetryPolicy retryPolicy(Map<String, ?> map, int i10) {
            int intValue = ((Integer) o.s(ServiceConfigUtil.getMaxAttemptsFromRetryPolicy(map), "maxAttempts cannot be empty")).intValue();
            boolean z10 = true;
            o.h(intValue >= 2, "maxAttempts must be greater than 1: %s", intValue);
            int min = Math.min(intValue, i10);
            long longValue = ((Long) o.s(ServiceConfigUtil.getInitialBackoffNanosFromRetryPolicy(map), "initialBackoff cannot be empty")).longValue();
            o.j(longValue > 0, "initialBackoffNanos must be greater than 0: %s", longValue);
            long longValue2 = ((Long) o.s(ServiceConfigUtil.getMaxBackoffNanosFromRetryPolicy(map), "maxBackoff cannot be empty")).longValue();
            o.j(longValue2 > 0, "maxBackoff must be greater than 0: %s", longValue2);
            double doubleValue = ((Double) o.s(ServiceConfigUtil.getBackoffMultiplierFromRetryPolicy(map), "backoffMultiplier cannot be empty")).doubleValue();
            o.m(doubleValue > ShadowDrawableWrapper.COS_45, "backoffMultiplier must be greater than 0: %s", Double.valueOf(doubleValue));
            Long perAttemptRecvTimeoutNanosFromRetryPolicy = ServiceConfigUtil.getPerAttemptRecvTimeoutNanosFromRetryPolicy(map);
            o.m(perAttemptRecvTimeoutNanosFromRetryPolicy == null || perAttemptRecvTimeoutNanosFromRetryPolicy.longValue() >= 0, "perAttemptRecvTimeout cannot be negative: %s", perAttemptRecvTimeoutNanosFromRetryPolicy);
            Set<Status.Code> retryableStatusCodesFromRetryPolicy = ServiceConfigUtil.getRetryableStatusCodesFromRetryPolicy(map);
            if (perAttemptRecvTimeoutNanosFromRetryPolicy == null && retryableStatusCodesFromRetryPolicy.isEmpty()) {
                z10 = false;
            }
            o.e(z10, "retryableStatusCodes cannot be empty without perAttemptRecvTimeout");
            return new RetryPolicy(min, longValue, longValue2, doubleValue, perAttemptRecvTimeoutNanosFromRetryPolicy, retryableStatusCodesFromRetryPolicy);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof MethodInfo)) {
                return false;
            }
            MethodInfo methodInfo = (MethodInfo) obj;
            return l.a(this.timeoutNanos, methodInfo.timeoutNanos) && l.a(this.waitForReady, methodInfo.waitForReady) && l.a(this.maxInboundMessageSize, methodInfo.maxInboundMessageSize) && l.a(this.maxOutboundMessageSize, methodInfo.maxOutboundMessageSize) && l.a(this.retryPolicy, methodInfo.retryPolicy) && l.a(this.hedgingPolicy, methodInfo.hedgingPolicy);
        }

        public int hashCode() {
            return l.b(this.timeoutNanos, this.waitForReady, this.maxInboundMessageSize, this.maxOutboundMessageSize, this.retryPolicy, this.hedgingPolicy);
        }

        public String toString() {
            return j.c(this).d("timeoutNanos", this.timeoutNanos).d("waitForReady", this.waitForReady).d("maxInboundMessageSize", this.maxInboundMessageSize).d("maxOutboundMessageSize", this.maxOutboundMessageSize).d("retryPolicy", this.retryPolicy).d("hedgingPolicy", this.hedgingPolicy).toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ServiceConfigConvertedSelector extends InternalConfigSelector {
        public final ManagedChannelServiceConfig config;

        @Override // io.grpc.InternalConfigSelector
        public InternalConfigSelector.Result selectConfig(LoadBalancer.PickSubchannelArgs pickSubchannelArgs) {
            return InternalConfigSelector.Result.newBuilder().setConfig(this.config).build();
        }

        private ServiceConfigConvertedSelector(ManagedChannelServiceConfig managedChannelServiceConfig) {
            this.config = managedChannelServiceConfig;
        }
    }

    public ManagedChannelServiceConfig(MethodInfo methodInfo, Map<String, MethodInfo> map, Map<String, MethodInfo> map2, RetriableStream.Throttle throttle, Object obj, Map<String, ?> map3) {
        this.defaultMethodConfig = methodInfo;
        this.serviceMethodMap = Collections.unmodifiableMap(new HashMap(map));
        this.serviceMap = Collections.unmodifiableMap(new HashMap(map2));
        this.retryThrottling = throttle;
        this.loadBalancingConfig = obj;
        this.healthCheckingConfig = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
    }

    public static ManagedChannelServiceConfig empty() {
        return new ManagedChannelServiceConfig(null, new HashMap(), new HashMap(), null, null, null);
    }

    public static ManagedChannelServiceConfig fromServiceConfig(Map<String, ?> map, boolean z10, int i10, int i11, Object obj) {
        RetriableStream.Throttle throttlePolicy = z10 ? ServiceConfigUtil.getThrottlePolicy(map) : null;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Map<String, ?> healthCheckedService = ServiceConfigUtil.getHealthCheckedService(map);
        List<Map<String, ?>> methodConfigFromServiceConfig = ServiceConfigUtil.getMethodConfigFromServiceConfig(map);
        if (methodConfigFromServiceConfig == null) {
            return new ManagedChannelServiceConfig(null, hashMap, hashMap2, throttlePolicy, obj, healthCheckedService);
        }
        MethodInfo methodInfo = null;
        for (Map<String, ?> map2 : methodConfigFromServiceConfig) {
            MethodInfo methodInfo2 = new MethodInfo(map2, z10, i10, i11);
            List<Map<String, ?>> nameListFromMethodConfig = ServiceConfigUtil.getNameListFromMethodConfig(map2);
            if (nameListFromMethodConfig != null && !nameListFromMethodConfig.isEmpty()) {
                for (Map<String, ?> map3 : nameListFromMethodConfig) {
                    String serviceFromName = ServiceConfigUtil.getServiceFromName(map3);
                    String methodFromName = ServiceConfigUtil.getMethodFromName(map3);
                    if (s.b(serviceFromName)) {
                        o.m(s.b(methodFromName), "missing service name for method %s", methodFromName);
                        o.m(methodInfo == null, "Duplicate default method config in service config %s", map);
                        methodInfo = methodInfo2;
                    } else if (s.b(methodFromName)) {
                        o.m(!hashMap2.containsKey(serviceFromName), "Duplicate service %s", serviceFromName);
                        hashMap2.put(serviceFromName, methodInfo2);
                    } else {
                        String generateFullMethodName = MethodDescriptor.generateFullMethodName(serviceFromName, methodFromName);
                        o.m(!hashMap.containsKey(generateFullMethodName), "Duplicate method name %s", generateFullMethodName);
                        hashMap.put(generateFullMethodName, methodInfo2);
                    }
                }
            }
        }
        return new ManagedChannelServiceConfig(methodInfo, hashMap, hashMap2, throttlePolicy, obj, healthCheckedService);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ManagedChannelServiceConfig.class != obj.getClass()) {
            return false;
        }
        ManagedChannelServiceConfig managedChannelServiceConfig = (ManagedChannelServiceConfig) obj;
        return l.a(this.defaultMethodConfig, managedChannelServiceConfig.defaultMethodConfig) && l.a(this.serviceMethodMap, managedChannelServiceConfig.serviceMethodMap) && l.a(this.serviceMap, managedChannelServiceConfig.serviceMap) && l.a(this.retryThrottling, managedChannelServiceConfig.retryThrottling) && l.a(this.loadBalancingConfig, managedChannelServiceConfig.loadBalancingConfig);
    }

    public InternalConfigSelector getDefaultConfigSelector() {
        if (this.serviceMap.isEmpty() && this.serviceMethodMap.isEmpty() && this.defaultMethodConfig == null) {
            return null;
        }
        return new ServiceConfigConvertedSelector();
    }

    public Map<String, ?> getHealthCheckingConfig() {
        return this.healthCheckingConfig;
    }

    public Object getLoadBalancingConfig() {
        return this.loadBalancingConfig;
    }

    public MethodInfo getMethodConfig(MethodDescriptor<?, ?> methodDescriptor) {
        MethodInfo methodInfo = this.serviceMethodMap.get(methodDescriptor.getFullMethodName());
        if (methodInfo == null) {
            methodInfo = this.serviceMap.get(methodDescriptor.getServiceName());
        }
        return methodInfo == null ? this.defaultMethodConfig : methodInfo;
    }

    public RetriableStream.Throttle getRetryThrottling() {
        return this.retryThrottling;
    }

    public int hashCode() {
        return l.b(this.defaultMethodConfig, this.serviceMethodMap, this.serviceMap, this.retryThrottling, this.loadBalancingConfig);
    }

    public String toString() {
        return j.c(this).d("defaultMethodConfig", this.defaultMethodConfig).d("serviceMethodMap", this.serviceMethodMap).d("serviceMap", this.serviceMap).d("retryThrottling", this.retryThrottling).d("loadBalancingConfig", this.loadBalancingConfig).toString();
    }
}
