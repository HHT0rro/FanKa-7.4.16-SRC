package io.grpc;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class InsecureChannelCredentials extends ChannelCredentials {
    private InsecureChannelCredentials() {
    }

    public static ChannelCredentials create() {
        return new InsecureChannelCredentials();
    }

    @Override // io.grpc.ChannelCredentials
    public ChannelCredentials withoutBearerTokens() {
        return this;
    }
}
