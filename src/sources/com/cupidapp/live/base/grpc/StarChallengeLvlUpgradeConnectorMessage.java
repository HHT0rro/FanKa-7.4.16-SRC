package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.StarChallengeLvlUpgradeModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class StarChallengeLvlUpgradeConnectorMessage {

    @Nullable
    private final StarChallengeLvlUpgradeModel entity;

    public StarChallengeLvlUpgradeConnectorMessage(@Nullable StarChallengeLvlUpgradeModel starChallengeLvlUpgradeModel) {
        this.entity = starChallengeLvlUpgradeModel;
    }

    public static /* synthetic */ StarChallengeLvlUpgradeConnectorMessage copy$default(StarChallengeLvlUpgradeConnectorMessage starChallengeLvlUpgradeConnectorMessage, StarChallengeLvlUpgradeModel starChallengeLvlUpgradeModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            starChallengeLvlUpgradeModel = starChallengeLvlUpgradeConnectorMessage.entity;
        }
        return starChallengeLvlUpgradeConnectorMessage.copy(starChallengeLvlUpgradeModel);
    }

    @Nullable
    public final StarChallengeLvlUpgradeModel component1() {
        return this.entity;
    }

    @NotNull
    public final StarChallengeLvlUpgradeConnectorMessage copy(@Nullable StarChallengeLvlUpgradeModel starChallengeLvlUpgradeModel) {
        return new StarChallengeLvlUpgradeConnectorMessage(starChallengeLvlUpgradeModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StarChallengeLvlUpgradeConnectorMessage) && kotlin.jvm.internal.s.d(this.entity, ((StarChallengeLvlUpgradeConnectorMessage) obj).entity);
    }

    @Nullable
    public final StarChallengeLvlUpgradeModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        StarChallengeLvlUpgradeModel starChallengeLvlUpgradeModel = this.entity;
        if (starChallengeLvlUpgradeModel == null) {
            return 0;
        }
        return starChallengeLvlUpgradeModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "StarChallengeLvlUpgradeConnectorMessage(entity=" + ((Object) this.entity) + ")";
    }
}
