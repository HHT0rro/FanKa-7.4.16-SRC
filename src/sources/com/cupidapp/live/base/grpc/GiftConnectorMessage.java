package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.BadgeModel;
import com.cupidapp.live.liveshow.model.LiveActivityModel;
import com.cupidapp.live.liveshow.model.LiveSeatResult;
import com.cupidapp.live.liveshow.model.LiveShowGiftModel;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GiftConnectorMessage {

    @Nullable
    private final List<LiveActivityModel> activities;

    @NotNull
    private final LiveShowGiftModel entity;

    @Nullable
    private final List<BadgeModel> liveAdBadge;

    @Nullable
    private final List<LiveSeatResult> viewersSeat;

    public GiftConnectorMessage(@NotNull LiveShowGiftModel entity, @Nullable List<LiveActivityModel> list, @Nullable List<LiveSeatResult> list2, @Nullable List<BadgeModel> list3) {
        kotlin.jvm.internal.s.i(entity, "entity");
        this.entity = entity;
        this.activities = list;
        this.viewersSeat = list2;
        this.liveAdBadge = list3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GiftConnectorMessage copy$default(GiftConnectorMessage giftConnectorMessage, LiveShowGiftModel liveShowGiftModel, List list, List list2, List list3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            liveShowGiftModel = giftConnectorMessage.entity;
        }
        if ((i10 & 2) != 0) {
            list = giftConnectorMessage.activities;
        }
        if ((i10 & 4) != 0) {
            list2 = giftConnectorMessage.viewersSeat;
        }
        if ((i10 & 8) != 0) {
            list3 = giftConnectorMessage.liveAdBadge;
        }
        return giftConnectorMessage.copy(liveShowGiftModel, list, list2, list3);
    }

    @NotNull
    public final LiveShowGiftModel component1() {
        return this.entity;
    }

    @Nullable
    public final List<LiveActivityModel> component2() {
        return this.activities;
    }

    @Nullable
    public final List<LiveSeatResult> component3() {
        return this.viewersSeat;
    }

    @Nullable
    public final List<BadgeModel> component4() {
        return this.liveAdBadge;
    }

    @NotNull
    public final GiftConnectorMessage copy(@NotNull LiveShowGiftModel entity, @Nullable List<LiveActivityModel> list, @Nullable List<LiveSeatResult> list2, @Nullable List<BadgeModel> list3) {
        kotlin.jvm.internal.s.i(entity, "entity");
        return new GiftConnectorMessage(entity, list, list2, list3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiftConnectorMessage)) {
            return false;
        }
        GiftConnectorMessage giftConnectorMessage = (GiftConnectorMessage) obj;
        return kotlin.jvm.internal.s.d(this.entity, giftConnectorMessage.entity) && kotlin.jvm.internal.s.d(this.activities, giftConnectorMessage.activities) && kotlin.jvm.internal.s.d(this.viewersSeat, giftConnectorMessage.viewersSeat) && kotlin.jvm.internal.s.d(this.liveAdBadge, giftConnectorMessage.liveAdBadge);
    }

    @Nullable
    public final List<LiveActivityModel> getActivities() {
        return this.activities;
    }

    @NotNull
    public final LiveShowGiftModel getEntity() {
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
        List<LiveActivityModel> list = this.activities;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<LiveSeatResult> list2 = this.viewersSeat;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<BadgeModel> list3 = this.liveAdBadge;
        return hashCode3 + (list3 != null ? list3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "GiftConnectorMessage(entity=" + ((Object) this.entity) + ", activities=" + ((Object) this.activities) + ", viewersSeat=" + ((Object) this.viewersSeat) + ", liveAdBadge=" + ((Object) this.liveAdBadge) + ")";
    }
}
