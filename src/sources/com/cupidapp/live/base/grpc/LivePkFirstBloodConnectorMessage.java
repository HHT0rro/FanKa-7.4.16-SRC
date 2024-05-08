package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkFirstBloodConnectorMessage {

    @NotNull
    private final LivePkFirstBloodMessage entity;

    public LivePkFirstBloodConnectorMessage(@NotNull LivePkFirstBloodMessage entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ LivePkFirstBloodConnectorMessage copy$default(LivePkFirstBloodConnectorMessage livePkFirstBloodConnectorMessage, LivePkFirstBloodMessage livePkFirstBloodMessage, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            livePkFirstBloodMessage = livePkFirstBloodConnectorMessage.entity;
        }
        return livePkFirstBloodConnectorMessage.copy(livePkFirstBloodMessage);
    }

    @NotNull
    public final LivePkFirstBloodMessage component1() {
        return this.entity;
    }

    @NotNull
    public final LivePkFirstBloodConnectorMessage copy(@NotNull LivePkFirstBloodMessage entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        return new LivePkFirstBloodConnectorMessage(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LivePkFirstBloodConnectorMessage) && kotlin.jvm.internal.s.d(this.entity, ((LivePkFirstBloodConnectorMessage) obj).entity);
    }

    @NotNull
    public final LivePkFirstBloodMessage getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "LivePkFirstBloodConnectorMessage(entity=" + ((Object) this.entity) + ")";
    }
}
