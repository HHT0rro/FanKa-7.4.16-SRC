package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NotifyConnectorMessage {

    @NotNull
    private final NotifyMessageModel entity;

    public NotifyConnectorMessage(@NotNull NotifyMessageModel entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ NotifyConnectorMessage copy$default(NotifyConnectorMessage notifyConnectorMessage, NotifyMessageModel notifyMessageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            notifyMessageModel = notifyConnectorMessage.entity;
        }
        return notifyConnectorMessage.copy(notifyMessageModel);
    }

    @NotNull
    public final NotifyMessageModel component1() {
        return this.entity;
    }

    @NotNull
    public final NotifyConnectorMessage copy(@NotNull NotifyMessageModel entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        return new NotifyConnectorMessage(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NotifyConnectorMessage) && kotlin.jvm.internal.s.d(this.entity, ((NotifyConnectorMessage) obj).entity);
    }

    @NotNull
    public final NotifyMessageModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "NotifyConnectorMessage(entity=" + ((Object) this.entity) + ")";
    }
}
