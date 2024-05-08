package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.LivePkCloseAudioModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkCloseAudioConnectorMessage {

    @NotNull
    private final LivePkCloseAudioModel entity;

    public LivePkCloseAudioConnectorMessage(@NotNull LivePkCloseAudioModel entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ LivePkCloseAudioConnectorMessage copy$default(LivePkCloseAudioConnectorMessage livePkCloseAudioConnectorMessage, LivePkCloseAudioModel livePkCloseAudioModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            livePkCloseAudioModel = livePkCloseAudioConnectorMessage.entity;
        }
        return livePkCloseAudioConnectorMessage.copy(livePkCloseAudioModel);
    }

    @NotNull
    public final LivePkCloseAudioModel component1() {
        return this.entity;
    }

    @NotNull
    public final LivePkCloseAudioConnectorMessage copy(@NotNull LivePkCloseAudioModel entity) {
        kotlin.jvm.internal.s.i(entity, "entity");
        return new LivePkCloseAudioConnectorMessage(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LivePkCloseAudioConnectorMessage) && kotlin.jvm.internal.s.d(this.entity, ((LivePkCloseAudioConnectorMessage) obj).entity);
    }

    @NotNull
    public final LivePkCloseAudioModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "LivePkCloseAudioConnectorMessage(entity=" + ((Object) this.entity) + ")";
    }
}
