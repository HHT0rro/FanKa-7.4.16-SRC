package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.LivePkStartModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkStartConnectorMessage {

    @NotNull
    private final LivePkStartModel entity;

    @NotNull
    private final String liveShowId;

    public LivePkStartConnectorMessage(@NotNull LivePkStartModel entity, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(entity, "entity");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        this.entity = entity;
        this.liveShowId = liveShowId;
    }

    public static /* synthetic */ LivePkStartConnectorMessage copy$default(LivePkStartConnectorMessage livePkStartConnectorMessage, LivePkStartModel livePkStartModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            livePkStartModel = livePkStartConnectorMessage.entity;
        }
        if ((i10 & 2) != 0) {
            str = livePkStartConnectorMessage.liveShowId;
        }
        return livePkStartConnectorMessage.copy(livePkStartModel, str);
    }

    @NotNull
    public final LivePkStartModel component1() {
        return this.entity;
    }

    @NotNull
    public final String component2() {
        return this.liveShowId;
    }

    @NotNull
    public final LivePkStartConnectorMessage copy(@NotNull LivePkStartModel entity, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(entity, "entity");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        return new LivePkStartConnectorMessage(entity, liveShowId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePkStartConnectorMessage)) {
            return false;
        }
        LivePkStartConnectorMessage livePkStartConnectorMessage = (LivePkStartConnectorMessage) obj;
        return kotlin.jvm.internal.s.d(this.entity, livePkStartConnectorMessage.entity) && kotlin.jvm.internal.s.d(this.liveShowId, livePkStartConnectorMessage.liveShowId);
    }

    @NotNull
    public final LivePkStartModel getEntity() {
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
        LivePkStartModel livePkStartModel = this.entity;
        return "LivePkStartConnectorMessage(entity=" + ((Object) livePkStartModel) + ", liveShowId=" + this.liveShowId + ")";
    }
}
