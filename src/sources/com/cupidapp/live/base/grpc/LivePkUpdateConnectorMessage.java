package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.LivePkUpdateModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkUpdateConnectorMessage {

    @NotNull
    private final LivePkUpdateModel entity;

    @NotNull
    private final String liveShowId;

    public LivePkUpdateConnectorMessage(@NotNull LivePkUpdateModel entity, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(entity, "entity");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        this.entity = entity;
        this.liveShowId = liveShowId;
    }

    public static /* synthetic */ LivePkUpdateConnectorMessage copy$default(LivePkUpdateConnectorMessage livePkUpdateConnectorMessage, LivePkUpdateModel livePkUpdateModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            livePkUpdateModel = livePkUpdateConnectorMessage.entity;
        }
        if ((i10 & 2) != 0) {
            str = livePkUpdateConnectorMessage.liveShowId;
        }
        return livePkUpdateConnectorMessage.copy(livePkUpdateModel, str);
    }

    @NotNull
    public final LivePkUpdateModel component1() {
        return this.entity;
    }

    @NotNull
    public final String component2() {
        return this.liveShowId;
    }

    @NotNull
    public final LivePkUpdateConnectorMessage copy(@NotNull LivePkUpdateModel entity, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(entity, "entity");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        return new LivePkUpdateConnectorMessage(entity, liveShowId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePkUpdateConnectorMessage)) {
            return false;
        }
        LivePkUpdateConnectorMessage livePkUpdateConnectorMessage = (LivePkUpdateConnectorMessage) obj;
        return kotlin.jvm.internal.s.d(this.entity, livePkUpdateConnectorMessage.entity) && kotlin.jvm.internal.s.d(this.liveShowId, livePkUpdateConnectorMessage.liveShowId);
    }

    @NotNull
    public final LivePkUpdateModel getEntity() {
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
        LivePkUpdateModel livePkUpdateModel = this.entity;
        return "LivePkUpdateConnectorMessage(entity=" + ((Object) livePkUpdateModel) + ", liveShowId=" + this.liveShowId + ")";
    }
}
