package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowAnimationConnectorMessageModel {

    @NotNull
    private final LiveShowAnimationMessageModel entity;

    public LiveShowAnimationConnectorMessageModel(@NotNull LiveShowAnimationMessageModel entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ LiveShowAnimationConnectorMessageModel copy$default(LiveShowAnimationConnectorMessageModel liveShowAnimationConnectorMessageModel, LiveShowAnimationMessageModel liveShowAnimationMessageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            liveShowAnimationMessageModel = liveShowAnimationConnectorMessageModel.entity;
        }
        return liveShowAnimationConnectorMessageModel.copy(liveShowAnimationMessageModel);
    }

    @NotNull
    public final LiveShowAnimationMessageModel component1() {
        return this.entity;
    }

    @NotNull
    public final LiveShowAnimationConnectorMessageModel copy(@NotNull LiveShowAnimationMessageModel entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        return new LiveShowAnimationConnectorMessageModel(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveShowAnimationConnectorMessageModel) && kotlin.jvm.internal.s.d(this.entity, ((LiveShowAnimationConnectorMessageModel) obj).entity);
    }

    @NotNull
    public final LiveShowAnimationMessageModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveShowAnimationConnectorMessageModel(entity=" + ((Object) this.entity) + ")";
    }
}
