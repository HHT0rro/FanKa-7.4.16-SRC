package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.AnchorGradeInfoModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveAnchorLvlExpChangeConnectorMessage {

    @NotNull
    private final AnchorGradeInfoModel entity;

    @NotNull
    private final String liveShowId;

    public LiveAnchorLvlExpChangeConnectorMessage(@NotNull AnchorGradeInfoModel entity, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(entity, "entity");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        this.entity = entity;
        this.liveShowId = liveShowId;
    }

    public static /* synthetic */ LiveAnchorLvlExpChangeConnectorMessage copy$default(LiveAnchorLvlExpChangeConnectorMessage liveAnchorLvlExpChangeConnectorMessage, AnchorGradeInfoModel anchorGradeInfoModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            anchorGradeInfoModel = liveAnchorLvlExpChangeConnectorMessage.entity;
        }
        if ((i10 & 2) != 0) {
            str = liveAnchorLvlExpChangeConnectorMessage.liveShowId;
        }
        return liveAnchorLvlExpChangeConnectorMessage.copy(anchorGradeInfoModel, str);
    }

    @NotNull
    public final AnchorGradeInfoModel component1() {
        return this.entity;
    }

    @NotNull
    public final String component2() {
        return this.liveShowId;
    }

    @NotNull
    public final LiveAnchorLvlExpChangeConnectorMessage copy(@NotNull AnchorGradeInfoModel entity, @NotNull String liveShowId) {
        kotlin.jvm.internal.s.i(entity, "entity");
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        return new LiveAnchorLvlExpChangeConnectorMessage(entity, liveShowId);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveAnchorLvlExpChangeConnectorMessage)) {
            return false;
        }
        LiveAnchorLvlExpChangeConnectorMessage liveAnchorLvlExpChangeConnectorMessage = (LiveAnchorLvlExpChangeConnectorMessage) obj;
        return kotlin.jvm.internal.s.d(this.entity, liveAnchorLvlExpChangeConnectorMessage.entity) && kotlin.jvm.internal.s.d(this.liveShowId, liveAnchorLvlExpChangeConnectorMessage.liveShowId);
    }

    @NotNull
    public final AnchorGradeInfoModel getEntity() {
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
        AnchorGradeInfoModel anchorGradeInfoModel = this.entity;
        return "LiveAnchorLvlExpChangeConnectorMessage(entity=" + ((Object) anchorGradeInfoModel) + ", liveShowId=" + this.liveShowId + ")";
    }
}
