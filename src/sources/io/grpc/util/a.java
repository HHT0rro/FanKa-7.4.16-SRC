package io.grpc.util;

import com.google.common.collect.ImmutableList;
import io.grpc.ChannelLogger;
import io.grpc.util.OutlierDetectionLoadBalancer;
import java.util.List;

/* compiled from: OutlierDetectionLoadBalancer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final /* synthetic */ class a {
    public static List<OutlierDetectionLoadBalancer.OutlierEjectionAlgorithm> a(OutlierDetectionLoadBalancer.OutlierDetectionLoadBalancerConfig outlierDetectionLoadBalancerConfig, ChannelLogger channelLogger) {
        ImmutableList.a builder = ImmutableList.builder();
        if (outlierDetectionLoadBalancerConfig.successRateEjection != null) {
            builder.a(new OutlierDetectionLoadBalancer.SuccessRateOutlierEjectionAlgorithm(outlierDetectionLoadBalancerConfig, channelLogger));
        }
        if (outlierDetectionLoadBalancerConfig.failurePercentageEjection != null) {
            builder.a(new OutlierDetectionLoadBalancer.FailurePercentageOutlierEjectionAlgorithm(outlierDetectionLoadBalancerConfig, channelLogger));
        }
        return builder.k();
    }
}
