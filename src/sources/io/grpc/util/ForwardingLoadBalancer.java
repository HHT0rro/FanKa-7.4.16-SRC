package io.grpc.util;

import com.google.common.base.j;
import io.grpc.ConnectivityStateInfo;
import io.grpc.ExperimentalApi;
import io.grpc.LoadBalancer;
import io.grpc.Status;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class ForwardingLoadBalancer extends LoadBalancer {
    @Override // io.grpc.LoadBalancer
    public boolean canHandleEmptyAddressListFromNameResolution() {
        return delegate().canHandleEmptyAddressListFromNameResolution();
    }

    public abstract LoadBalancer delegate();

    @Override // io.grpc.LoadBalancer
    public void handleNameResolutionError(Status status) {
        delegate().handleNameResolutionError(status);
    }

    @Override // io.grpc.LoadBalancer
    public void handleResolvedAddresses(LoadBalancer.ResolvedAddresses resolvedAddresses) {
        delegate().handleResolvedAddresses(resolvedAddresses);
    }

    @Override // io.grpc.LoadBalancer
    @Deprecated
    public void handleSubchannelState(LoadBalancer.Subchannel subchannel, ConnectivityStateInfo connectivityStateInfo) {
        delegate().handleSubchannelState(subchannel, connectivityStateInfo);
    }

    @Override // io.grpc.LoadBalancer
    public void requestConnection() {
        delegate().requestConnection();
    }

    @Override // io.grpc.LoadBalancer
    public void shutdown() {
        delegate().shutdown();
    }

    public String toString() {
        return j.c(this).d("delegate", delegate()).toString();
    }
}
