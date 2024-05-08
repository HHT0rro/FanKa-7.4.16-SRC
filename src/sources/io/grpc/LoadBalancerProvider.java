package io.grpc;

import com.google.common.base.j;
import io.grpc.LoadBalancer;
import io.grpc.NameResolver;
import java.util.Map;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class LoadBalancerProvider extends LoadBalancer.Factory {
    private static final NameResolver.ConfigOrError UNKNOWN_CONFIG = NameResolver.ConfigOrError.fromConfig(new UnknownConfig());

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class UnknownConfig {
        public String toString() {
            return "service config is unused";
        }
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public abstract String getPolicyName();

    public abstract int getPriority();

    public final int hashCode() {
        return super.hashCode();
    }

    public abstract boolean isAvailable();

    public NameResolver.ConfigOrError parseLoadBalancingPolicyConfig(Map<String, ?> map) {
        return UNKNOWN_CONFIG;
    }

    public final String toString() {
        return j.c(this).d("policy", getPolicyName()).b("priority", getPriority()).e("available", isAvailable()).toString();
    }
}
