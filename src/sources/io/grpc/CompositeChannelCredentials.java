package io.grpc;

import com.google.common.base.o;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class CompositeChannelCredentials extends ChannelCredentials {
    private final CallCredentials callCredentials;
    private final ChannelCredentials channelCredentials;

    private CompositeChannelCredentials(ChannelCredentials channelCredentials, CallCredentials callCredentials) {
        this.channelCredentials = (ChannelCredentials) o.s(channelCredentials, "channelCreds");
        this.callCredentials = (CallCredentials) o.s(callCredentials, "callCreds");
    }

    public static ChannelCredentials create(ChannelCredentials channelCredentials, CallCredentials callCredentials) {
        return new CompositeChannelCredentials(channelCredentials, callCredentials);
    }

    public CallCredentials getCallCredentials() {
        return this.callCredentials;
    }

    public ChannelCredentials getChannelCredentials() {
        return this.channelCredentials;
    }

    @Override // io.grpc.ChannelCredentials
    public ChannelCredentials withoutBearerTokens() {
        return this.channelCredentials.withoutBearerTokens();
    }
}
