package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkFirstBloodMessage {

    @NotNull
    private final String liveShowId;

    @NotNull
    private final String userId;

    public LivePkFirstBloodMessage(@NotNull String liveShowId, @NotNull String userId) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        kotlin.jvm.internal.s.i(userId, "userId");
        this.liveShowId = liveShowId;
        this.userId = userId;
    }

    public static /* synthetic */ LivePkFirstBloodMessage copy$default(LivePkFirstBloodMessage livePkFirstBloodMessage, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = livePkFirstBloodMessage.liveShowId;
        }
        if ((i10 & 2) != 0) {
            str2 = livePkFirstBloodMessage.userId;
        }
        return livePkFirstBloodMessage.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.liveShowId;
    }

    @NotNull
    public final String component2() {
        return this.userId;
    }

    @NotNull
    public final LivePkFirstBloodMessage copy(@NotNull String liveShowId, @NotNull String userId) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        kotlin.jvm.internal.s.i(userId, "userId");
        return new LivePkFirstBloodMessage(liveShowId, userId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePkFirstBloodMessage)) {
            return false;
        }
        LivePkFirstBloodMessage livePkFirstBloodMessage = (LivePkFirstBloodMessage) obj;
        return kotlin.jvm.internal.s.d(this.liveShowId, livePkFirstBloodMessage.liveShowId) && kotlin.jvm.internal.s.d(this.userId, livePkFirstBloodMessage.userId);
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        return (this.liveShowId.hashCode() * 31) + this.userId.hashCode();
    }

    @NotNull
    public String toString() {
        return "LivePkFirstBloodMessage(liveShowId=" + this.liveShowId + ", userId=" + this.userId + ")";
    }
}
