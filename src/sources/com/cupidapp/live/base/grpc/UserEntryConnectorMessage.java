package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.BadgeModel;
import com.cupidapp.live.liveshow.model.LiveSeatResult;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class UserEntryConnectorMessage {

    @NotNull
    private final LiveUserEntryModel entity;

    @Nullable
    private final List<BadgeModel> liveAdBadge;

    @Nullable
    private final List<LiveSeatResult> viewersSeat;

    public UserEntryConnectorMessage(@NotNull LiveUserEntryModel entity, @Nullable List<LiveSeatResult> list, @Nullable List<BadgeModel> list2) {
        kotlin.jvm.internal.s.i(entity, "entity");
        this.entity = entity;
        this.viewersSeat = list;
        this.liveAdBadge = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserEntryConnectorMessage copy$default(UserEntryConnectorMessage userEntryConnectorMessage, LiveUserEntryModel liveUserEntryModel, List list, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            liveUserEntryModel = userEntryConnectorMessage.entity;
        }
        if ((i10 & 2) != 0) {
            list = userEntryConnectorMessage.viewersSeat;
        }
        if ((i10 & 4) != 0) {
            list2 = userEntryConnectorMessage.liveAdBadge;
        }
        return userEntryConnectorMessage.copy(liveUserEntryModel, list, list2);
    }

    @NotNull
    public final LiveUserEntryModel component1() {
        return this.entity;
    }

    @Nullable
    public final List<LiveSeatResult> component2() {
        return this.viewersSeat;
    }

    @Nullable
    public final List<BadgeModel> component3() {
        return this.liveAdBadge;
    }

    @NotNull
    public final UserEntryConnectorMessage copy(@NotNull LiveUserEntryModel entity, @Nullable List<LiveSeatResult> list, @Nullable List<BadgeModel> list2) {
        kotlin.jvm.internal.s.i(entity, "entity");
        return new UserEntryConnectorMessage(entity, list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserEntryConnectorMessage)) {
            return false;
        }
        UserEntryConnectorMessage userEntryConnectorMessage = (UserEntryConnectorMessage) obj;
        return kotlin.jvm.internal.s.d(this.entity, userEntryConnectorMessage.entity) && kotlin.jvm.internal.s.d(this.viewersSeat, userEntryConnectorMessage.viewersSeat) && kotlin.jvm.internal.s.d(this.liveAdBadge, userEntryConnectorMessage.liveAdBadge);
    }

    @NotNull
    public final LiveUserEntryModel getEntity() {
        return this.entity;
    }

    @Nullable
    public final List<BadgeModel> getLiveAdBadge() {
        return this.liveAdBadge;
    }

    @Nullable
    public final List<LiveSeatResult> getViewersSeat() {
        return this.viewersSeat;
    }

    public int hashCode() {
        int hashCode = this.entity.hashCode() * 31;
        List<LiveSeatResult> list = this.viewersSeat;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<BadgeModel> list2 = this.liveAdBadge;
        return hashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "UserEntryConnectorMessage(entity=" + ((Object) this.entity) + ", viewersSeat=" + ((Object) this.viewersSeat) + ", liveAdBadge=" + ((Object) this.liveAdBadge) + ")";
    }
}
