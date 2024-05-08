package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.LivePkEndModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkEndConnectorMessage {

    @NotNull
    private final LivePkEndModel entity;

    @NotNull
    private final String liveShowId;

    public LivePkEndConnectorMessage(@NotNull LivePkEndModel entity, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(entity, "entity");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        this.entity = entity;
        this.liveShowId = liveShowId;
    }

    public static /* synthetic */ LivePkEndConnectorMessage copy$default(LivePkEndConnectorMessage livePkEndConnectorMessage, LivePkEndModel livePkEndModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            livePkEndModel = livePkEndConnectorMessage.entity;
        }
        if ((i10 & 2) != 0) {
            str = livePkEndConnectorMessage.liveShowId;
        }
        return livePkEndConnectorMessage.copy(livePkEndModel, str);
    }

    @NotNull
    public final LivePkEndModel component1() {
        return this.entity;
    }

    @NotNull
    public final String component2() {
        return this.liveShowId;
    }

    @NotNull
    public final LivePkEndConnectorMessage copy(@NotNull LivePkEndModel entity, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(entity, "entity");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        return new LivePkEndConnectorMessage(entity, liveShowId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePkEndConnectorMessage)) {
            return false;
        }
        LivePkEndConnectorMessage livePkEndConnectorMessage = (LivePkEndConnectorMessage) obj;
        return kotlin.jvm.internal.s.d(this.entity, livePkEndConnectorMessage.entity) && kotlin.jvm.internal.s.d(this.liveShowId, livePkEndConnectorMessage.liveShowId);
    }

    @NotNull
    public final LivePkEndModel getEntity() {
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
        LivePkEndModel livePkEndModel = this.entity;
        return "LivePkEndConnectorMessage(entity=" + ((Object) livePkEndModel) + ", liveShowId=" + this.liveShowId + ")";
    }
}
