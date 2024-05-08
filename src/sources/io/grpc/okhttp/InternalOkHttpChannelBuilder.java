package io.grpc.okhttp;

import io.grpc.Internal;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class InternalOkHttpChannelBuilder {
    private InternalOkHttpChannelBuilder() {
    }

    public static void disableCheckAuthority(OkHttpChannelBuilder okHttpChannelBuilder) {
        okHttpChannelBuilder.disableCheckAuthority();
    }

    public static void enableCheckAuthority(OkHttpChannelBuilder okHttpChannelBuilder) {
        okHttpChannelBuilder.enableCheckAuthority();
    }

    public static void setStatsEnabled(OkHttpChannelBuilder okHttpChannelBuilder, boolean z10) {
        okHttpChannelBuilder.setStatsEnabled(z10);
    }
}
