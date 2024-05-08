package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveBroadcastModel {

    @NotNull
    private final String decoration;

    @NotNull
    private final String message;

    public LiveBroadcastModel(@NotNull String message, @NotNull String decoration) {
        kotlin.jvm.internal.s.i(message, "message");
        kotlin.jvm.internal.s.i(decoration, "decoration");
        this.message = message;
        this.decoration = decoration;
    }

    public static /* synthetic */ LiveBroadcastModel copy$default(LiveBroadcastModel liveBroadcastModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveBroadcastModel.message;
        }
        if ((i10 & 2) != 0) {
            str2 = liveBroadcastModel.decoration;
        }
        return liveBroadcastModel.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.message;
    }

    @NotNull
    public final String component2() {
        return this.decoration;
    }

    @NotNull
    public final LiveBroadcastModel copy(@NotNull String message, @NotNull String decoration) {
        kotlin.jvm.internal.s.i(message, "message");
        kotlin.jvm.internal.s.i(decoration, "decoration");
        return new LiveBroadcastModel(message, decoration);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveBroadcastModel)) {
            return false;
        }
        LiveBroadcastModel liveBroadcastModel = (LiveBroadcastModel) obj;
        return kotlin.jvm.internal.s.d(this.message, liveBroadcastModel.message) && kotlin.jvm.internal.s.d(this.decoration, liveBroadcastModel.decoration);
    }

    @NotNull
    public final String getDecoration() {
        return this.decoration;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return (this.message.hashCode() * 31) + this.decoration.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveBroadcastModel(message=" + this.message + ", decoration=" + this.decoration + ")";
    }
}
