package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveCriticalHitConnectorMessage {

    @NotNull
    private final LiveCriticalHitMessage entity;

    public LiveCriticalHitConnectorMessage(@NotNull LiveCriticalHitMessage entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ LiveCriticalHitConnectorMessage copy$default(LiveCriticalHitConnectorMessage liveCriticalHitConnectorMessage, LiveCriticalHitMessage liveCriticalHitMessage, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            liveCriticalHitMessage = liveCriticalHitConnectorMessage.entity;
        }
        return liveCriticalHitConnectorMessage.copy(liveCriticalHitMessage);
    }

    @NotNull
    public final LiveCriticalHitMessage component1() {
        return this.entity;
    }

    @NotNull
    public final LiveCriticalHitConnectorMessage copy(@NotNull LiveCriticalHitMessage entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        return new LiveCriticalHitConnectorMessage(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveCriticalHitConnectorMessage) && kotlin.jvm.internal.s.d(this.entity, ((LiveCriticalHitConnectorMessage) obj).entity);
    }

    @NotNull
    public final LiveCriticalHitMessage getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveCriticalHitConnectorMessage(entity=" + ((Object) this.entity) + ")";
    }
}
