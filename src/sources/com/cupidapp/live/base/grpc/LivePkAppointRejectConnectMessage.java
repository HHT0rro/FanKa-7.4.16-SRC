package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.LivePkAppointRejectModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkAppointRejectConnectMessage {

    @NotNull
    private final LivePkAppointRejectModel entity;

    @NotNull
    private final String liveShowId;

    public LivePkAppointRejectConnectMessage(@NotNull LivePkAppointRejectModel entity, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(entity, "entity");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        this.entity = entity;
        this.liveShowId = liveShowId;
    }

    public static /* synthetic */ LivePkAppointRejectConnectMessage copy$default(LivePkAppointRejectConnectMessage livePkAppointRejectConnectMessage, LivePkAppointRejectModel livePkAppointRejectModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            livePkAppointRejectModel = livePkAppointRejectConnectMessage.entity;
        }
        if ((i10 & 2) != 0) {
            str = livePkAppointRejectConnectMessage.liveShowId;
        }
        return livePkAppointRejectConnectMessage.copy(livePkAppointRejectModel, str);
    }

    @NotNull
    public final LivePkAppointRejectModel component1() {
        return this.entity;
    }

    @NotNull
    public final String component2() {
        return this.liveShowId;
    }

    @NotNull
    public final LivePkAppointRejectConnectMessage copy(@NotNull LivePkAppointRejectModel entity, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(entity, "entity");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        return new LivePkAppointRejectConnectMessage(entity, liveShowId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePkAppointRejectConnectMessage)) {
            return false;
        }
        LivePkAppointRejectConnectMessage livePkAppointRejectConnectMessage = (LivePkAppointRejectConnectMessage) obj;
        return kotlin.jvm.internal.s.d(this.entity, livePkAppointRejectConnectMessage.entity) && kotlin.jvm.internal.s.d(this.liveShowId, livePkAppointRejectConnectMessage.liveShowId);
    }

    @NotNull
    public final LivePkAppointRejectModel getEntity() {
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
        LivePkAppointRejectModel livePkAppointRejectModel = this.entity;
        return "LivePkAppointRejectConnectMessage(entity=" + ((Object) livePkAppointRejectModel) + ", liveShowId=" + this.liveShowId + ")";
    }
}
