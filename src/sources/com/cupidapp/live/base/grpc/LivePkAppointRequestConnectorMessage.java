package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.LivePkAppointRequestModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkAppointRequestConnectorMessage {

    @NotNull
    private final LivePkAppointRequestModel entity;

    @NotNull
    private final String liveShowId;

    public LivePkAppointRequestConnectorMessage(@NotNull LivePkAppointRequestModel entity, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(entity, "entity");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        this.entity = entity;
        this.liveShowId = liveShowId;
    }

    public static /* synthetic */ LivePkAppointRequestConnectorMessage copy$default(LivePkAppointRequestConnectorMessage livePkAppointRequestConnectorMessage, LivePkAppointRequestModel livePkAppointRequestModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            livePkAppointRequestModel = livePkAppointRequestConnectorMessage.entity;
        }
        if ((i10 & 2) != 0) {
            str = livePkAppointRequestConnectorMessage.liveShowId;
        }
        return livePkAppointRequestConnectorMessage.copy(livePkAppointRequestModel, str);
    }

    @NotNull
    public final LivePkAppointRequestModel component1() {
        return this.entity;
    }

    @NotNull
    public final String component2() {
        return this.liveShowId;
    }

    @NotNull
    public final LivePkAppointRequestConnectorMessage copy(@NotNull LivePkAppointRequestModel entity, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(entity, "entity");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        return new LivePkAppointRequestConnectorMessage(entity, liveShowId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePkAppointRequestConnectorMessage)) {
            return false;
        }
        LivePkAppointRequestConnectorMessage livePkAppointRequestConnectorMessage = (LivePkAppointRequestConnectorMessage) obj;
        return kotlin.jvm.internal.s.d(this.entity, livePkAppointRequestConnectorMessage.entity) && kotlin.jvm.internal.s.d(this.liveShowId, livePkAppointRequestConnectorMessage.liveShowId);
    }

    @NotNull
    public final LivePkAppointRequestModel getEntity() {
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
        LivePkAppointRequestModel livePkAppointRequestModel = this.entity;
        return "LivePkAppointRequestConnectorMessage(entity=" + ((Object) livePkAppointRequestModel) + ", liveShowId=" + this.liveShowId + ")";
    }
}
