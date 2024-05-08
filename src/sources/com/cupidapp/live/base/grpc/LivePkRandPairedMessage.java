package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.LivePkStartModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkRandPairedMessage {

    @NotNull
    private final LivePkStartModel entity;

    @NotNull
    private final String liveShowId;

    public LivePkRandPairedMessage(@NotNull LivePkStartModel entity, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(entity, "entity");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        this.entity = entity;
        this.liveShowId = liveShowId;
    }

    public static /* synthetic */ LivePkRandPairedMessage copy$default(LivePkRandPairedMessage livePkRandPairedMessage, LivePkStartModel livePkStartModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            livePkStartModel = livePkRandPairedMessage.entity;
        }
        if ((i10 & 2) != 0) {
            str = livePkRandPairedMessage.liveShowId;
        }
        return livePkRandPairedMessage.copy(livePkStartModel, str);
    }

    @NotNull
    public final LivePkStartModel component1() {
        return this.entity;
    }

    @NotNull
    public final String component2() {
        return this.liveShowId;
    }

    @NotNull
    public final LivePkRandPairedMessage copy(@NotNull LivePkStartModel entity, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(entity, "entity");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        return new LivePkRandPairedMessage(entity, liveShowId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePkRandPairedMessage)) {
            return false;
        }
        LivePkRandPairedMessage livePkRandPairedMessage = (LivePkRandPairedMessage) obj;
        return kotlin.jvm.internal.s.d(this.entity, livePkRandPairedMessage.entity) && kotlin.jvm.internal.s.d(this.liveShowId, livePkRandPairedMessage.liveShowId);
    }

    @NotNull
    public final LivePkStartModel getEntity() {
        return this.entity;
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    public int hashCode() {
        return (this.entity.hashCode() * 31) + this.liveShowId.hashCode();
    }

    @NotNull
    public String toString() {
        LivePkStartModel livePkStartModel = this.entity;
        return "LivePkRandPairedMessage(entity=" + ((Object) livePkStartModel) + ", liveShowId=" + this.liveShowId + ")";
    }
}
