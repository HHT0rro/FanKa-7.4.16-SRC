package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.LiveShowShakeMessageModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowShakeConnectorMessage {

    @NotNull
    private final LiveShowShakeMessageModel entity;

    @NotNull
    private final String liveShowId;

    public LiveShowShakeConnectorMessage(@NotNull String liveShowId, @NotNull LiveShowShakeMessageModel entity) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        kotlin.jvm.internal.s.i(entity, "entity");
        this.liveShowId = liveShowId;
        this.entity = entity;
    }

    public static /* synthetic */ LiveShowShakeConnectorMessage copy$default(LiveShowShakeConnectorMessage liveShowShakeConnectorMessage, String str, LiveShowShakeMessageModel liveShowShakeMessageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveShowShakeConnectorMessage.liveShowId;
        }
        if ((i10 & 2) != 0) {
            liveShowShakeMessageModel = liveShowShakeConnectorMessage.entity;
        }
        return liveShowShakeConnectorMessage.copy(str, liveShowShakeMessageModel);
    }

    @NotNull
    public final String component1() {
        return this.liveShowId;
    }

    @NotNull
    public final LiveShowShakeMessageModel component2() {
        return this.entity;
    }

    @NotNull
    public final LiveShowShakeConnectorMessage copy(@NotNull String liveShowId, @NotNull LiveShowShakeMessageModel entity) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        kotlin.jvm.internal.s.i(entity, "entity");
        return new LiveShowShakeConnectorMessage(liveShowId, entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveShowShakeConnectorMessage)) {
            return false;
        }
        LiveShowShakeConnectorMessage liveShowShakeConnectorMessage = (LiveShowShakeConnectorMessage) obj;
        return kotlin.jvm.internal.s.d(this.liveShowId, liveShowShakeConnectorMessage.liveShowId) && kotlin.jvm.internal.s.d(this.entity, liveShowShakeConnectorMessage.entity);
    }

    @NotNull
    public final LiveShowShakeMessageModel getEntity() {
        return this.entity;
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    public int hashCode() {
        return (this.liveShowId.hashCode() * 31) + this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveShowShakeConnectorMessage(liveShowId=" + this.liveShowId + ", entity=" + ((Object) this.entity) + ")";
    }
}
