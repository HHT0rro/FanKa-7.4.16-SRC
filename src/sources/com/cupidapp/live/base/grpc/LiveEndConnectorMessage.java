package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveEndConnectorMessage {

    @NotNull
    private final EndMessage entity;

    public LiveEndConnectorMessage(@NotNull EndMessage entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ LiveEndConnectorMessage copy$default(LiveEndConnectorMessage liveEndConnectorMessage, EndMessage endMessage, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            endMessage = liveEndConnectorMessage.entity;
        }
        return liveEndConnectorMessage.copy(endMessage);
    }

    @NotNull
    public final EndMessage component1() {
        return this.entity;
    }

    @NotNull
    public final LiveEndConnectorMessage copy(@NotNull EndMessage entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        return new LiveEndConnectorMessage(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveEndConnectorMessage) && kotlin.jvm.internal.s.d(this.entity, ((LiveEndConnectorMessage) obj).entity);
    }

    @NotNull
    public final EndMessage getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveEndConnectorMessage(entity=" + ((Object) this.entity) + ")";
    }
}
