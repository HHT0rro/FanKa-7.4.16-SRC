package io.grpc.util;

import com.huawei.quickcard.base.Attributes;
import io.grpc.Internal;
import io.grpc.LoadBalancer;
import io.grpc.LoadBalancerProvider;
import io.grpc.LoadBalancerRegistry;
import io.grpc.NameResolver;
import io.grpc.Status;
import io.grpc.internal.JsonUtil;
import io.grpc.internal.ServiceConfigUtil;
import io.grpc.internal.TimeProvider;
import io.grpc.util.OutlierDetectionLoadBalancer;
import java.util.List;
import java.util.Map;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class OutlierDetectionLoadBalancerProvider extends LoadBalancerProvider {
    @Override // io.grpc.LoadBalancerProvider
    public String getPolicyName() {
        return "outlier_detection_experimental";
    }

    @Override // io.grpc.LoadBalancerProvider
    public int getPriority() {
        return 5;
    }

    @Override // io.grpc.LoadBalancerProvider
    public boolean isAvailable() {
        return true;
    }

    @Override // io.grpc.LoadBalancer.Factory
    public LoadBalancer newLoadBalancer(LoadBalancer.Helper helper) {
        return new OutlierDetectionLoadBalancer(helper, TimeProvider.SYSTEM_TIME_PROVIDER);
    }

    @Override // io.grpc.LoadBalancerProvider
    public NameResolver.ConfigOrError parseLoadBalancingPolicyConfig(Map<String, ?> map) {
        Long stringAsDuration = JsonUtil.getStringAsDuration(map, Attributes.Style.INTERVAL);
        Long stringAsDuration2 = JsonUtil.getStringAsDuration(map, "baseEjectionTime");
        Long stringAsDuration3 = JsonUtil.getStringAsDuration(map, "maxEjectionTime");
        Integer numberAsInteger = JsonUtil.getNumberAsInteger(map, "maxEjectionPercentage");
        OutlierDetectionLoadBalancer.OutlierDetectionLoadBalancerConfig.Builder builder = new OutlierDetectionLoadBalancer.OutlierDetectionLoadBalancerConfig.Builder();
        if (stringAsDuration != null) {
            builder.setIntervalNanos(stringAsDuration);
        }
        if (stringAsDuration2 != null) {
            builder.setBaseEjectionTimeNanos(stringAsDuration2);
        }
        if (stringAsDuration3 != null) {
            builder.setMaxEjectionTimeNanos(stringAsDuration3);
        }
        if (numberAsInteger != null) {
            builder.setMaxEjectionPercent(numberAsInteger);
        }
        Map<String, ?> object = JsonUtil.getObject(map, "successRateEjection");
        if (object != null) {
            OutlierDetectionLoadBalancer.OutlierDetectionLoadBalancerConfig.SuccessRateEjection.Builder builder2 = new OutlierDetectionLoadBalancer.OutlierDetectionLoadBalancerConfig.SuccessRateEjection.Builder();
            Integer numberAsInteger2 = JsonUtil.getNumberAsInteger(object, "stdevFactor");
            Integer numberAsInteger3 = JsonUtil.getNumberAsInteger(object, "enforcementPercentage");
            Integer numberAsInteger4 = JsonUtil.getNumberAsInteger(object, "minimumHosts");
            Integer numberAsInteger5 = JsonUtil.getNumberAsInteger(object, "requestVolume");
            if (numberAsInteger2 != null) {
                builder2.setStdevFactor(numberAsInteger2);
            }
            if (numberAsInteger3 != null) {
                builder2.setEnforcementPercentage(numberAsInteger3);
            }
            if (numberAsInteger4 != null) {
                builder2.setMinimumHosts(numberAsInteger4);
            }
            if (numberAsInteger5 != null) {
                builder2.setRequestVolume(numberAsInteger5);
            }
            builder.setSuccessRateEjection(builder2.build());
        }
        Map<String, ?> object2 = JsonUtil.getObject(map, "failurePercentageEjection");
        if (object2 != null) {
            OutlierDetectionLoadBalancer.OutlierDetectionLoadBalancerConfig.FailurePercentageEjection.Builder builder3 = new OutlierDetectionLoadBalancer.OutlierDetectionLoadBalancerConfig.FailurePercentageEjection.Builder();
            Integer numberAsInteger6 = JsonUtil.getNumberAsInteger(object2, "threshold");
            Integer numberAsInteger7 = JsonUtil.getNumberAsInteger(object2, "enforcementPercentage");
            Integer numberAsInteger8 = JsonUtil.getNumberAsInteger(object2, "minimumHosts");
            Integer numberAsInteger9 = JsonUtil.getNumberAsInteger(object2, "requestVolume");
            if (numberAsInteger6 != null) {
                builder3.setThreshold(numberAsInteger6);
            }
            if (numberAsInteger7 != null) {
                builder3.setEnforcementPercentage(numberAsInteger7);
            }
            if (numberAsInteger8 != null) {
                builder3.setMinimumHosts(numberAsInteger8);
            }
            if (numberAsInteger9 != null) {
                builder3.setRequestVolume(numberAsInteger9);
            }
            builder.setFailurePercentageEjection(builder3.build());
        }
        List<ServiceConfigUtil.LbConfig> unwrapLoadBalancingConfigList = ServiceConfigUtil.unwrapLoadBalancingConfigList(JsonUtil.getListOfObjects(map, "childPolicy"));
        if (unwrapLoadBalancingConfigList != null && !unwrapLoadBalancingConfigList.isEmpty()) {
            NameResolver.ConfigOrError selectLbPolicyFromList = ServiceConfigUtil.selectLbPolicyFromList(unwrapLoadBalancingConfigList, LoadBalancerRegistry.getDefaultRegistry());
            if (selectLbPolicyFromList.getError() != null) {
                return selectLbPolicyFromList;
            }
            builder.setChildPolicy((ServiceConfigUtil.PolicySelection) selectLbPolicyFromList.getConfig());
            return NameResolver.ConfigOrError.fromConfig(builder.build());
        }
        return NameResolver.ConfigOrError.fromError(Status.INTERNAL.withDescription("No child policy in outlier_detection_experimental LB policy: " + ((Object) map)));
    }
}
