package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.LiveShowModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveConnectAcceptConnectorMessage {

    @NotNull
    private final LiveShowModel entity;

    @NotNull
    private final String liveShowId;

    public LiveConnectAcceptConnectorMessage(@NotNull LiveShowModel entity, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(entity, "entity");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        this.entity = entity;
        this.liveShowId = liveShowId;
    }

    public static /* synthetic */ LiveConnectAcceptConnectorMessage copy$default(LiveConnectAcceptConnectorMessage liveConnectAcceptConnectorMessage, LiveShowModel liveShowModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            liveShowModel = liveConnectAcceptConnectorMessage.entity;
        }
        if ((i10 & 2) != 0) {
            str = liveConnectAcceptConnectorMessage.liveShowId;
        }
        return liveConnectAcceptConnectorMessage.copy(liveShowModel, str);
    }

    @NotNull
    public final LiveShowModel component1() {
        return this.entity;
    }

    @NotNull
    public final String component2() {
        return this.liveShowId;
    }

    @NotNull
    public final LiveConnectAcceptConnectorMessage copy(@NotNull LiveShowModel entity, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(entity, "entity");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        return new LiveConnectAcceptConnectorMessage(entity, liveShowId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveConnectAcceptConnectorMessage)) {
            return false;
        }
        LiveConnectAcceptConnectorMessage liveConnectAcceptConnectorMessage = (LiveConnectAcceptConnectorMessage) obj;
        return kotlin.jvm.internal.s.d(this.entity, liveConnectAcceptConnectorMessage.entity) && kotlin.jvm.internal.s.d(this.liveShowId, liveConnectAcceptConnectorMessage.liveShowId);
    }

    @NotNull
    public final LiveShowModel getEntity() {
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
        LiveShowModel liveShowModel = this.entity;
        return "LiveConnectAcceptConnectorMessage(entity=" + ((Object) liveShowModel) + ", liveShowId=" + this.liveShowId + ")";
    }
}
