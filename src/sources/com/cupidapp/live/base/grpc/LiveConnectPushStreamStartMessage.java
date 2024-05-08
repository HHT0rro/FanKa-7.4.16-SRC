package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.LiveShowModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveConnectPushStreamStartMessage {

    @NotNull
    private final LiveShowModel entity;

    public LiveConnectPushStreamStartMessage(@NotNull LiveShowModel entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ LiveConnectPushStreamStartMessage copy$default(LiveConnectPushStreamStartMessage liveConnectPushStreamStartMessage, LiveShowModel liveShowModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            liveShowModel = liveConnectPushStreamStartMessage.entity;
        }
        return liveConnectPushStreamStartMessage.copy(liveShowModel);
    }

    @NotNull
    public final LiveShowModel component1() {
        return this.entity;
    }

    @NotNull
    public final LiveConnectPushStreamStartMessage copy(@NotNull LiveShowModel entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        return new LiveConnectPushStreamStartMessage(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveConnectPushStreamStartMessage) && kotlin.jvm.internal.s.d(this.entity, ((LiveConnectPushStreamStartMessage) obj).entity);
    }

    @NotNull
    public final LiveShowModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveConnectPushStreamStartMessage(entity=" + ((Object) this.entity) + ")";
    }
}
