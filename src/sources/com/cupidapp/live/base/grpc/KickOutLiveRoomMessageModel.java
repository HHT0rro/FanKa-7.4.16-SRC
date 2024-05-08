package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class KickOutLiveRoomMessageModel {

    @NotNull
    private final KickOutLiveRoomModel entity;

    public KickOutLiveRoomMessageModel(@NotNull KickOutLiveRoomModel entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ KickOutLiveRoomMessageModel copy$default(KickOutLiveRoomMessageModel kickOutLiveRoomMessageModel, KickOutLiveRoomModel kickOutLiveRoomModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            kickOutLiveRoomModel = kickOutLiveRoomMessageModel.entity;
        }
        return kickOutLiveRoomMessageModel.copy(kickOutLiveRoomModel);
    }

    @NotNull
    public final KickOutLiveRoomModel component1() {
        return this.entity;
    }

    @NotNull
    public final KickOutLiveRoomMessageModel copy(@NotNull KickOutLiveRoomModel entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        return new KickOutLiveRoomMessageModel(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof KickOutLiveRoomMessageModel) && kotlin.jvm.internal.s.d(this.entity, ((KickOutLiveRoomMessageModel) obj).entity);
    }

    @NotNull
    public final KickOutLiveRoomModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "KickOutLiveRoomMessageModel(entity=" + ((Object) this.entity) + ")";
    }
}
