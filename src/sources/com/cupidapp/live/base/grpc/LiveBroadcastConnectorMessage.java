package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveBroadcastConnectorMessage {

    @NotNull
    private final LiveBroadcastModel entity;

    @NotNull
    private final String liveShowId;

    public LiveBroadcastConnectorMessage(@NotNull LiveBroadcastModel entity, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(entity, "entity");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        this.entity = entity;
        this.liveShowId = liveShowId;
    }

    public static /* synthetic */ LiveBroadcastConnectorMessage copy$default(LiveBroadcastConnectorMessage liveBroadcastConnectorMessage, LiveBroadcastModel liveBroadcastModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            liveBroadcastModel = liveBroadcastConnectorMessage.entity;
        }
        if ((i10 & 2) != 0) {
            str = liveBroadcastConnectorMessage.liveShowId;
        }
        return liveBroadcastConnectorMessage.copy(liveBroadcastModel, str);
    }

    @NotNull
    public final LiveBroadcastModel component1() {
        return this.entity;
    }

    @NotNull
    public final String component2() {
        return this.liveShowId;
    }

    @NotNull
    public final LiveBroadcastConnectorMessage copy(@NotNull LiveBroadcastModel entity, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(entity, "entity");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        return new LiveBroadcastConnectorMessage(entity, liveShowId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveBroadcastConnectorMessage)) {
            return false;
        }
        LiveBroadcastConnectorMessage liveBroadcastConnectorMessage = (LiveBroadcastConnectorMessage) obj;
        return kotlin.jvm.internal.s.d(this.entity, liveBroadcastConnectorMessage.entity) && kotlin.jvm.internal.s.d(this.liveShowId, liveBroadcastConnectorMessage.liveShowId);
    }

    @NotNull
    public final LiveBroadcastModel getEntity() {
        return this.entity;
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    public int hashCode() {
        return (this.entity.hashCode() * 31) + this.liveShowId.hashCode();
    }

    @NotNull
    public String toString() {
        LiveBroadcastModel liveBroadcastModel = this.entity;
        return "LiveBroadcastConnectorMessage(entity=" + ((Object) liveBroadcastModel) + ", liveShowId=" + this.liveShowId + ")";
    }
}
