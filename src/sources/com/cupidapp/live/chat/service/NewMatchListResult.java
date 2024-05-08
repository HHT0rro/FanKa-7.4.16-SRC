package com.cupidapp.live.chat.service;

import com.cupidapp.live.feed.model.PromotionNearByGuideModel;
import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ContactService.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NewMatchListResult {

    @Nullable
    private final ChatStateEntranceModel chatStatusEntrance;

    @Nullable
    private final ClubEntranceModel groupInfo;

    @Nullable
    private final PromotionNearByGuideModel guide;

    @Nullable
    private final List<User> list;

    @Nullable
    private final SuperBoostEntranceModel superBoostEntrance;

    public NewMatchListResult(@Nullable List<User> list, @Nullable ChatStateEntranceModel chatStateEntranceModel, @Nullable PromotionNearByGuideModel promotionNearByGuideModel, @Nullable ClubEntranceModel clubEntranceModel, @Nullable SuperBoostEntranceModel superBoostEntranceModel) {
        this.list = list;
        this.chatStatusEntrance = chatStateEntranceModel;
        this.guide = promotionNearByGuideModel;
        this.groupInfo = clubEntranceModel;
        this.superBoostEntrance = superBoostEntranceModel;
    }

    public static /* synthetic */ NewMatchListResult copy$default(NewMatchListResult newMatchListResult, List list, ChatStateEntranceModel chatStateEntranceModel, PromotionNearByGuideModel promotionNearByGuideModel, ClubEntranceModel clubEntranceModel, SuperBoostEntranceModel superBoostEntranceModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = newMatchListResult.list;
        }
        if ((i10 & 2) != 0) {
            chatStateEntranceModel = newMatchListResult.chatStatusEntrance;
        }
        ChatStateEntranceModel chatStateEntranceModel2 = chatStateEntranceModel;
        if ((i10 & 4) != 0) {
            promotionNearByGuideModel = newMatchListResult.guide;
        }
        PromotionNearByGuideModel promotionNearByGuideModel2 = promotionNearByGuideModel;
        if ((i10 & 8) != 0) {
            clubEntranceModel = newMatchListResult.groupInfo;
        }
        ClubEntranceModel clubEntranceModel2 = clubEntranceModel;
        if ((i10 & 16) != 0) {
            superBoostEntranceModel = newMatchListResult.superBoostEntrance;
        }
        return newMatchListResult.copy(list, chatStateEntranceModel2, promotionNearByGuideModel2, clubEntranceModel2, superBoostEntranceModel);
    }

    @Nullable
    public final List<User> component1() {
        return this.list;
    }

    @Nullable
    public final ChatStateEntranceModel component2() {
        return this.chatStatusEntrance;
    }

    @Nullable
    public final PromotionNearByGuideModel component3() {
        return this.guide;
    }

    @Nullable
    public final ClubEntranceModel component4() {
        return this.groupInfo;
    }

    @Nullable
    public final SuperBoostEntranceModel component5() {
        return this.superBoostEntrance;
    }

    @NotNull
    public final NewMatchListResult copy(@Nullable List<User> list, @Nullable ChatStateEntranceModel chatStateEntranceModel, @Nullable PromotionNearByGuideModel promotionNearByGuideModel, @Nullable ClubEntranceModel clubEntranceModel, @Nullable SuperBoostEntranceModel superBoostEntranceModel) {
        return new NewMatchListResult(list, chatStateEntranceModel, promotionNearByGuideModel, clubEntranceModel, superBoostEntranceModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NewMatchListResult)) {
            return false;
        }
        NewMatchListResult newMatchListResult = (NewMatchListResult) obj;
        return s.d(this.list, newMatchListResult.list) && s.d(this.chatStatusEntrance, newMatchListResult.chatStatusEntrance) && s.d(this.guide, newMatchListResult.guide) && s.d(this.groupInfo, newMatchListResult.groupInfo) && s.d(this.superBoostEntrance, newMatchListResult.superBoostEntrance);
    }

    @Nullable
    public final ChatStateEntranceModel getChatStatusEntrance() {
        return this.chatStatusEntrance;
    }

    @Nullable
    public final ClubEntranceModel getGroupInfo() {
        return this.groupInfo;
    }

    @Nullable
    public final PromotionNearByGuideModel getGuide() {
        return this.guide;
    }

    @Nullable
    public final List<User> getList() {
        return this.list;
    }

    @Nullable
    public final SuperBoostEntranceModel getSuperBoostEntrance() {
        return this.superBoostEntrance;
    }

    public int hashCode() {
        List<User> list = this.list;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        ChatStateEntranceModel chatStateEntranceModel = this.chatStatusEntrance;
        int hashCode2 = (hashCode + (chatStateEntranceModel == null ? 0 : chatStateEntranceModel.hashCode())) * 31;
        PromotionNearByGuideModel promotionNearByGuideModel = this.guide;
        int hashCode3 = (hashCode2 + (promotionNearByGuideModel == null ? 0 : promotionNearByGuideModel.hashCode())) * 31;
        ClubEntranceModel clubEntranceModel = this.groupInfo;
        int hashCode4 = (hashCode3 + (clubEntranceModel == null ? 0 : clubEntranceModel.hashCode())) * 31;
        SuperBoostEntranceModel superBoostEntranceModel = this.superBoostEntrance;
        return hashCode4 + (superBoostEntranceModel != null ? superBoostEntranceModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "NewMatchListResult(list=" + ((Object) this.list) + ", chatStatusEntrance=" + ((Object) this.chatStatusEntrance) + ", guide=" + ((Object) this.guide) + ", groupInfo=" + ((Object) this.groupInfo) + ", superBoostEntrance=" + ((Object) this.superBoostEntrance) + ")";
    }

    public /* synthetic */ NewMatchListResult(List list, ChatStateEntranceModel chatStateEntranceModel, PromotionNearByGuideModel promotionNearByGuideModel, ClubEntranceModel clubEntranceModel, SuperBoostEntranceModel superBoostEntranceModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i10 & 2) != 0 ? null : chatStateEntranceModel, (i10 & 4) != 0 ? null : promotionNearByGuideModel, clubEntranceModel, (i10 & 16) != 0 ? null : superBoostEntranceModel);
    }
}
