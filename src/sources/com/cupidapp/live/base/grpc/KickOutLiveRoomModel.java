package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class KickOutLiveRoomModel {

    @Nullable
    private final String message;

    public KickOutLiveRoomModel(@Nullable String str) {
        this.message = str;
    }

    public static /* synthetic */ KickOutLiveRoomModel copy$default(KickOutLiveRoomModel kickOutLiveRoomModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = kickOutLiveRoomModel.message;
        }
        return kickOutLiveRoomModel.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.message;
    }

    @NotNull
    public final KickOutLiveRoomModel copy(@Nullable String str) {
        return new KickOutLiveRoomModel(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof KickOutLiveRoomModel) && kotlin.jvm.internal.s.d(this.message, ((KickOutLiveRoomModel) obj).message);
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        String str = this.message;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "KickOutLiveRoomModel(message=" + this.message + ")";
    }
}
