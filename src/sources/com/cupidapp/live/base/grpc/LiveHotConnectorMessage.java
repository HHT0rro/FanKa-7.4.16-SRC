package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.HeatValuesModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveHotConnectorMessage {

    @NotNull
    private final HeatValuesModel entity;

    public LiveHotConnectorMessage(@NotNull HeatValuesModel entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ LiveHotConnectorMessage copy$default(LiveHotConnectorMessage liveHotConnectorMessage, HeatValuesModel heatValuesModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            heatValuesModel = liveHotConnectorMessage.entity;
        }
        return liveHotConnectorMessage.copy(heatValuesModel);
    }

    @NotNull
    public final HeatValuesModel component1() {
        return this.entity;
    }

    @NotNull
    public final LiveHotConnectorMessage copy(@NotNull HeatValuesModel entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        return new LiveHotConnectorMessage(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveHotConnectorMessage) && kotlin.jvm.internal.s.d(this.entity, ((LiveHotConnectorMessage) obj).entity);
    }

    @NotNull
    public final HeatValuesModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveHotConnectorMessage(entity=" + ((Object) this.entity) + ")";
    }
}
