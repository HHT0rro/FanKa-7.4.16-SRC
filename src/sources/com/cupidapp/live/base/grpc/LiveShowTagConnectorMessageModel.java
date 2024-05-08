package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowTagConnectorMessageModel {

    @NotNull
    private final LiveShowTagMessageModel entity;

    public LiveShowTagConnectorMessageModel(@NotNull LiveShowTagMessageModel entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ LiveShowTagConnectorMessageModel copy$default(LiveShowTagConnectorMessageModel liveShowTagConnectorMessageModel, LiveShowTagMessageModel liveShowTagMessageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            liveShowTagMessageModel = liveShowTagConnectorMessageModel.entity;
        }
        return liveShowTagConnectorMessageModel.copy(liveShowTagMessageModel);
    }

    @NotNull
    public final LiveShowTagMessageModel component1() {
        return this.entity;
    }

    @NotNull
    public final LiveShowTagConnectorMessageModel copy(@NotNull LiveShowTagMessageModel entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        return new LiveShowTagConnectorMessageModel(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveShowTagConnectorMessageModel) && kotlin.jvm.internal.s.d(this.entity, ((LiveShowTagConnectorMessageModel) obj).entity);
    }

    @NotNull
    public final LiveShowTagMessageModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveShowTagConnectorMessageModel(entity=" + ((Object) this.entity) + ")";
    }
}
