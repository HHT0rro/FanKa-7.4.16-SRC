package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveAnchorLvlUpgradeAnimationConnectorMessage {

    @NotNull
    private final String animationUrl;

    @NotNull
    private final String liveShowId;

    public LiveAnchorLvlUpgradeAnimationConnectorMessage(@NotNull String animationUrl, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(animationUrl, "animationUrl");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        this.animationUrl = animationUrl;
        this.liveShowId = liveShowId;
    }

    public static /* synthetic */ LiveAnchorLvlUpgradeAnimationConnectorMessage copy$default(LiveAnchorLvlUpgradeAnimationConnectorMessage liveAnchorLvlUpgradeAnimationConnectorMessage, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveAnchorLvlUpgradeAnimationConnectorMessage.animationUrl;
        }
        if ((i10 & 2) != 0) {
            str2 = liveAnchorLvlUpgradeAnimationConnectorMessage.liveShowId;
        }
        return liveAnchorLvlUpgradeAnimationConnectorMessage.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.animationUrl;
    }

    @NotNull
    public final String component2() {
        return this.liveShowId;
    }

    @NotNull
    public final LiveAnchorLvlUpgradeAnimationConnectorMessage copy(@NotNull String animationUrl, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(animationUrl, "animationUrl");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        return new LiveAnchorLvlUpgradeAnimationConnectorMessage(animationUrl, liveShowId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveAnchorLvlUpgradeAnimationConnectorMessage)) {
            return false;
        }
        LiveAnchorLvlUpgradeAnimationConnectorMessage liveAnchorLvlUpgradeAnimationConnectorMessage = (LiveAnchorLvlUpgradeAnimationConnectorMessage) obj;
        return kotlin.jvm.internal.s.d(this.animationUrl, liveAnchorLvlUpgradeAnimationConnectorMessage.animationUrl) && kotlin.jvm.internal.s.d(this.liveShowId, liveAnchorLvlUpgradeAnimationConnectorMessage.liveShowId);
    }

    @NotNull
    public final String getAnimationUrl() {
        return this.animationUrl;
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    public int hashCode() {
        return (this.animationUrl.hashCode() * 31) + this.liveShowId.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveAnchorLvlUpgradeAnimationConnectorMessage(animationUrl=" + this.animationUrl + ", liveShowId=" + this.liveShowId + ")";
    }
}
