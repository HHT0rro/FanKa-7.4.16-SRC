package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.StarChallengeChestModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class StarChallengeChestConnectorMessage {

    @Nullable
    private final StarChallengeChestModel entity;

    public StarChallengeChestConnectorMessage(@Nullable StarChallengeChestModel starChallengeChestModel) {
        this.entity = starChallengeChestModel;
    }

    public static /* synthetic */ StarChallengeChestConnectorMessage copy$default(StarChallengeChestConnectorMessage starChallengeChestConnectorMessage, StarChallengeChestModel starChallengeChestModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            starChallengeChestModel = starChallengeChestConnectorMessage.entity;
        }
        return starChallengeChestConnectorMessage.copy(starChallengeChestModel);
    }

    @Nullable
    public final StarChallengeChestModel component1() {
        return this.entity;
    }

    @NotNull
    public final StarChallengeChestConnectorMessage copy(@Nullable StarChallengeChestModel starChallengeChestModel) {
        return new StarChallengeChestConnectorMessage(starChallengeChestModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StarChallengeChestConnectorMessage) && kotlin.jvm.internal.s.d(this.entity, ((StarChallengeChestConnectorMessage) obj).entity);
    }

    @Nullable
    public final StarChallengeChestModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        StarChallengeChestModel starChallengeChestModel = this.entity;
        if (starChallengeChestModel == null) {
            return 0;
        }
        return starChallengeChestModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "StarChallengeChestConnectorMessage(entity=" + ((Object) this.entity) + ")";
    }
}
