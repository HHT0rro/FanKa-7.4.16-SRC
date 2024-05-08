package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GrpcIMBase.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GrpcConnectEvent {
    private final boolean connect;

    public GrpcConnectEvent(boolean z10) {
        this.connect = z10;
    }

    public static /* synthetic */ GrpcConnectEvent copy$default(GrpcConnectEvent grpcConnectEvent, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = grpcConnectEvent.connect;
        }
        return grpcConnectEvent.copy(z10);
    }

    public final boolean component1() {
        return this.connect;
    }

    @NotNull
    public final GrpcConnectEvent copy(boolean z10) {
        return new GrpcConnectEvent(z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GrpcConnectEvent) && this.connect == ((GrpcConnectEvent) obj).connect;
    }

    public final boolean getConnect() {
        return this.connect;
    }

    public int hashCode() {
        boolean z10 = this.connect;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "GrpcConnectEvent(connect=" + this.connect + ")";
    }
}
