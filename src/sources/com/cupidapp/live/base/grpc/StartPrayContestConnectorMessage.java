package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class StartPrayContestConnectorMessage {

    @NotNull
    private final PrayContestMessage entity;

    public StartPrayContestConnectorMessage(@NotNull PrayContestMessage entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ StartPrayContestConnectorMessage copy$default(StartPrayContestConnectorMessage startPrayContestConnectorMessage, PrayContestMessage prayContestMessage, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            prayContestMessage = startPrayContestConnectorMessage.entity;
        }
        return startPrayContestConnectorMessage.copy(prayContestMessage);
    }

    @NotNull
    public final PrayContestMessage component1() {
        return this.entity;
    }

    @NotNull
    public final StartPrayContestConnectorMessage copy(@NotNull PrayContestMessage entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        return new StartPrayContestConnectorMessage(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StartPrayContestConnectorMessage) && kotlin.jvm.internal.s.d(this.entity, ((StartPrayContestConnectorMessage) obj).entity);
    }

    @NotNull
    public final PrayContestMessage getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "StartPrayContestConnectorMessage(entity=" + ((Object) this.entity) + ")";
    }
}
