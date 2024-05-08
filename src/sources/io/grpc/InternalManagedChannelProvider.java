package io.grpc;

import io.grpc.ManagedChannelProvider;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class InternalManagedChannelProvider {
    private InternalManagedChannelProvider() {
    }

    public static ManagedChannelBuilder<?> builderForAddress(ManagedChannelProvider managedChannelProvider, String str, int i10) {
        return managedChannelProvider.builderForAddress(str, i10);
    }

    public static ManagedChannelBuilder<?> builderForTarget(ManagedChannelProvider managedChannelProvider, String str) {
        return managedChannelProvider.builderForTarget(str);
    }

    public static boolean isAvailable(ManagedChannelProvider managedChannelProvider) {
        return managedChannelProvider.isAvailable();
    }

    public static ManagedChannelProvider.NewChannelBuilderResult newChannelBuilder(ManagedChannelProvider managedChannelProvider, String str, ChannelCredentials channelCredentials) {
        return managedChannelProvider.newChannelBuilder(str, channelCredentials);
    }
}
